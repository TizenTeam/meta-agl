FILESEXTRAPATHS_prepend := "${THISDIR}/mesa:"

# Detect QEMU GPU adapter
SRC_URI += "file://0001-gbm-detect-Cirrus-Logic-5446-QEMU-video-card.patch"

# provide "libegl-gallium" if it does not exist (poky > 1.7)
RPROVIDES_${PN}_append = "libegl-gallium"

PACKAGECONFIG_append = " gallium gallium-egl gallium-gbm gallium-llvm"
