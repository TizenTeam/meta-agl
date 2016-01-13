FILESEXTRAPATHS_prepend := "${THISDIR}/linux-yocto:"

# Extra configuration options for the QEMU kernel
SRC_URI += "file://cirrus.cfg \
            file://uinput.cfg \
            "
