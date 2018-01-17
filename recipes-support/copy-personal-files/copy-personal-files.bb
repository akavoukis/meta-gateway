DESCRIPTION = "Get personal files to /root directory"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r1"
SRC_URI = "file://*"

S = "${WORKDIR}"

do_install() {
        install -d ${D}/home/root
	install ${S}/my_files/* ${D}/home/root/
}

FILES_${PN} += "/home"
