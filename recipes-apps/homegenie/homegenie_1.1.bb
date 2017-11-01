DESCRIPTION = "Installs Homegenie application"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENCE.TXT;md5=8742ca673f11373aa5b26f966c03ef49"

SRC_URI = "https://github.com/genielabs/HomeGenie/releases/download/v1.1-beta.526/homegenie_1_1_beta_r526.tgz"
SRC_URI[md5sum] = "127e416239d431b34f2fbe1cb46ba5b4"

#TODO compile for arm
INSANE_SKIP_${PN} = "arch"

S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}/opt/${PN}
	cp -r ${S} ${D}/opt/${PN}
}

# Do NOT try to compile the contents in the bz2 file.
do_compile() {
}

FILES_${PN} += "/opt/${PN}"

