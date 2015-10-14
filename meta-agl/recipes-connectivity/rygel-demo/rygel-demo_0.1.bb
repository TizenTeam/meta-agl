SUMMARY = "AGL Demonstration for Rygel and free media files"

LICENSE = "CC-BY-3.0"
LIC_FILES_CHKSUM="file://COPYING;md5=887db7f87bd792c4e0eadec138d5391b"

inherit systemd
DEPENDS = " rygel systemd"
RDEPENDS_${PN} = " rygel systemd"

FILESEXTRAPATHS_prepend := ":${THISDIR}/rygel-demo:"

SRC_URI = "file://rygel.service \
           file://udhcpc.service \
           file://Big_Buck_Bunny_first_23_seconds_1080p.ogg \
           file://1vs0_-_JuniorGroove.ogg \
           file://All_the_Living_and_the_Dead_-_Untrue.ogg \
           file://COPYING \
          "
SRC_URI[md5sum] = "16c1b1de28d0d591a66fb70d06fe417c"
SRC_URI[md256sum] = "e82907dd45f77b01eacb319da794023cddb15691fec398b6f0200cb450b3b8ae"

do_configure() {
       cp ${WORKDIR}/COPYING ${S}
       cp ${WORKDIR}/*.ogg ${S}
       cp ${WORKDIR}/*.service ${S}
}

do_install() {
       mkdir -p ${D}/${systemd_unitdir}/system
       install -m 0644 rygel.service ${D}/${systemd_unitdir}/system
       install -m 0644 udhcpc.service ${D}/${systemd_unitdir}/system
       install -d ${D}/${systemd_unitdir}/system/multi-user.target.wants
       ln -sf /lib/systemd/system/rygel.service ${D}/${systemd_unitdir}/system/multi-user.target.wants/rygel.service
       ln -sf /lib/systemd/system/udhcpc.service ${D}/${systemd_unitdir}/system/multi-user.target.wants/udhcpc.service
       mkdir -p ${D}/${datadir}/media
       install -m 0644 Big_Buck_Bunny_first_23_seconds_1080p.ogg ${D}/${datadir}/media
       install -m 0644 1vs0_-_JuniorGroove.ogg ${D}/${datadir}/media
       install -m 0644 All_the_Living_and_the_Dead_-_Untrue.ogg ${D}/${datadir}/media
}

FILES_${PN} = "${systemd_unitdir} ${datadir}"
