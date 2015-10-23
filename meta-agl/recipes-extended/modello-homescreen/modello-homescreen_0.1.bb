SUMMARY = "AGL Demonstration for HTML5 HomeScreen"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=ae6497158920d9524cf208c09cc4c984"

RDEPENDS_${PN} = " qtwebkit-examples-examples weston wayland-ivi-extension"

FILESEXTRAPATHS_prepend := ":${THISDIR}/modello-homescreen:"

SRC_URI = "file://Modello_Homescreen.tar.bz2 \
           file://Modello_Dashboard.tar.bz2 \
           file://app_modello_homescreen.sh \
           file://app_modello_dashboard.sh \
           file://icon_ivi_modello_homescreen.png \
           file://icon_ivi_modello_dashboard.png \
           file://icon_ivi_eglwlmocknavigation.png \
           file://weston.ini \
           file://COPYING \
          "
SRC_URI[md5sum] = "fb62880b5c7e7355539ecdc2879d9be9"
SRC_URI[sha256sum] = "5fa2a1a728bae3236e36b281d9275b242fc304590446bb21ecc7dc5c6d179e08"

do_configure() {
       cp ${WORKDIR}/COPYING ${S}
       cp ${WORKDIR}/weston.ini ${S}
       cp ${WORKDIR}/icon_*.png ${S}
       cp ${WORKDIR}/app_*.sh ${S}
       cp -ra ${WORKDIR}/Modello_* ${S}
}

do_install() {
       mkdir -p ${D}/${datadir}/applications/agl
       cp -ra Modello_* ${D}/${datadir}/applications/agl
       install -m 0755 app_*.sh ${D}/${datadir}/applications/agl
       mkdir -p ${D}/${datadir}/weston
       install -m 0644 icon_*.png ${D}/${datadir}/weston
       mkdir -p ${D}/${sysconfdir}/xdg/weston
       install -m 0644 weston.ini ${D}/${sysconfdir}/xdg/weston
}

FILES_${PN} = "${sysconfdir} ${datadir}"
