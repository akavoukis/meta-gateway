DESCRIPTION = "Configure bluetooth to connect"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


SRC_URI = " file://10-hci-up.rules"

S = "${WORKDIR}"

do_install () {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/10-hci-up.rules ${D}${sysconfdir}/udev/rules.d/
}
FILES_${PN} = "${base_libdir}/udev/rules.d"

