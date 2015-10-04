# Copyright (C) 2010-2012, O.S. Systems Software Ltda.
# Released under the MIT license

include freerdp.inc

inherit gitpkgv

PV = "1.1.0+gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"

EXTRA_OECMAKE += "-DBUILD_STATIC_LIBS=OFF \
                  -DCMAKE_POSITION_INDEPENDANT_CODE=ON \
                  -DWITH_MANPAGES=OFF \
                 "

SRCREV = "2604ff20bd12e810cfeed735b80dbe90020d781c"
SRC_URI = "git://github.com/FreeRDP/FreeRDP.git;branch=stable-1.1 \
           file://winpr-makecert-Build-with-install-RPATH.patch \
           file://Don-t-include-CMakeDetermineSystem.patch \
           file://0001-wlfreerdp-initial-Wayland-client.patch \
           file://0002-wlfreerdp-validate-the-TLS-certificate-interactively.patch \
           file://0003-Fixed-realloc-return-check.patch \
           file://0004-wlfreerdp-reorganize-source-files-add-input-methods.patch \
           file://0005-wlfreerdp-add-keyboard-and-mouse-wheel-support-fix-b.patch \
          "

S = "${WORKDIR}/git"
