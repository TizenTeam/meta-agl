SUMMARY = "HTML5 template for controlling multimedia through AFB"
DESCRIPTION = "afb-radio is a sample AngularJS/HTML5 application using \
Application Framework Binder to interface with an AM/FM Radio dongle, \
including controls such as : turn on/off, switch AM/FM, change station, \
change volume, mute, etc. It uses 2 AFB APIs : Audio, Radio."
HOMEPAGE = "http://www.iot.bzh"

LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6cb04bdb88e11107e3af4d8e3f301be5"

#DEPENDS = "nodejs-native"
RDEPENDS_${PN} = "afb-daemon afb-daemon-plugin-audio afb-daemon-plugin-radio afb-daemon-plugin-token qtquickcontrols-qmlplugins qtwebengine-qmlplugins"

SRC_URI = "git://github.com/iotbzh/afb-radio;protocol=https;branch=master \
           file://afb-radio \
           file://afb-radio.qml \
          "
SRCREV = "bc8464b9b632671751348a904ab21bd2db39da20"
S = "${WORKDIR}/git"

do_install () {
  mkdir -p ${D}/${datadir}/agl/afb-radio
  cp -ra ${S}/dist.prod/* ${D}/${datadir}/agl/afb-radio/
  install -m 0644 ${WORKDIR}/afb-radio.qml ${D}/${datadir}/agl

  mkdir -p ${D}/${bindir}
  install -m 0755 ${WORKDIR}/afb-radio ${D}/${bindir}/afb-radio
}

FILES_${PN} += "${datadir}"
