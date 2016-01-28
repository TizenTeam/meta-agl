# Disable everything but the media-export plugin
PACKAGECONFIG = "media-export"

SRC_URI += " file://rygel.service \
           "

inherit systemd

do_install_append() {
       # Install rygel systemd service
       if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
              install -p -D ${WORKDIR}/rygel.service ${D}${systemd_user_unitdir}/rygel.service

              # Execute these manually on behalf of systemctl script (from systemd-systemctl-native.bb)
              # because it does not support systemd's user mode.
              mkdir -p ${D}/etc/systemd/user/default.target.wants/
              ln -sf ${systemd_user_unitdir}/lightmediascanner.service ${D}/etc/systemd/user/dbus-org.gnome.Rygel1.service
              ln -sf ${systemd_user_unitdir}/lightmediascanner.service ${D}/etc/systemd/user/default.target.wants/rygel.service
       fi
}

FILES_${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '${systemd_user_unitdir}/rygel.service', '', d)} \
    "
