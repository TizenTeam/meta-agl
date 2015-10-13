FILESEXTRAPATHS_append := ":${THISDIR}/${PN}"

SRC_URI_append = "\
    file://weston.service \
    file://weston.ini \
    "

inherit systemd
DEPENDS_append = " systemd"

EXTRA_OECONF_remove = "--disable-rdp-compositor"
PACKAGECONFIG_append = " freerdp"
PACKAGECONFIG[freerdp] = "--enable-rdp-compositor,--disable-rdp-compositor,freerdp"

do_install_append() {
    mkdir -p ${D}${systemd_unitdir}/system/
    cp ${WORKDIR}/weston.service ${D}${systemd_unitdir}/system/
    mkdir -p ${D}${systemd_unitdir}/system/multi-user.target.wants/
    ln -sf /lib/systemd/system/weston.service ${D}/${systemd_unitdir}/system/multi-user.target.wants/weston.service

    WESTON_INI_CONFIG=${sysconfdir}/xdg/weston
    install -d ${D}${WESTON_INI_CONFIG}
    install -m 0644 ${WORKDIR}/weston.ini ${D}${WESTON_INI_CONFIG}/weston.ini
}

FILES_${PN} += " \
    ${systemd_unitdir}/system/* \
    ${sysconfdir}/xdg/weston/weston.ini \
    "
