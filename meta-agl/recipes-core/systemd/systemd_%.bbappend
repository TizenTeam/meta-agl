FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
           file://wired.network \
"

do_install_append() {
	# Enable dhcp requests on eth0 wired interface
	install -m 0644 ${WORKDIR}/wired.network ${D}${sysconfdir}/systemd/network/
}

# activate networkd support in systemd recipe
PACKAGECONFIG_append_pn-systemd = " networkd"

