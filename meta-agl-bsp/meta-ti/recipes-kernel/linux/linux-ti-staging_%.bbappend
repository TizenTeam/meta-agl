FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://ramblock_nbd.cfg"
KERNEL_CONFIG_FRAGMENTS_append = " ${WORKDIR}/ramblock_nbd.cfg"

# Enable support for TP-Link TL-W722N USB Wifi adapter
SRC_URI_append = " file://ath9k_htc.cfg"
KERNEL_CONFIG_FRAGMENTS_append = " ${WORKDIR}/ath9k_htc.cfg"

# Enable support for RTLSDR
SRC_URI_append = " file://rtl_sdr.cfg"
KERNEL_CONFIG_FRAGMENTS_append = " ${WORKDIR}/rtl_sdr.cfg"

# Enable support for Bluetooth HCI USB devices
SRC_URI_append = " file://btusb.cfg"
KERNEL_CONFIG_FRAGMENTS_append = " ${WORKDIR}/btusb.cfg"

#-------------------------------------------------------------------------
# smack patches for handling bluetooth

SRC_URI_append_smack = "\
       file://0001-Smack-File-receive-for-sockets.patch \
       file://0002-smack-fix-cache-of-access-labels.patch \
       file://0003-Smack-ignore-null-signal-in-smack_task_kill.patch \
       file://0004-Smack-Assign-smack_known_web-label-for-kernel-thread.patch \
"
