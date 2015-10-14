
SRC_URI_append_smack = " \
	file://0001-cross-compiling-improvement.patch \
	file://0002-syslogd-add-the-buffering-option-to-keep-logs-in-mem.patch \
	file://0003-support-smack-feature-for-install-mv-cp-and-stat.patch \
	file://0004-Fix-minor-items.patch \
	file://smack-config \
"

do_configure_append_smack() {
	cp ${WORKDIR}/smack-config .config
}


