FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

PACKAGECONFIG_CONFARGS = ""

SRC_URI += " \
     file://swupdate.cfg \
     file://swupdate.service \
     file://swupdate-env \
     "

do_install_append() {
    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/swupdate.cfg ${D}${sysconfdir}

    install -d ${D}${bindir}
    install -m 0744 ${WORKDIR}/swupdate-env ${D}${bindir}

}
