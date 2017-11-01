DESCRIPTION = "Firmware for rt2870 based USB wifi adaptors"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE%20ralink-firmware.txt;md5=9fb378018ae605c43e52cd472fa27929"

SRC_URI = "file://2010_0709_RT2870_Linux_STA_v${PV}.tar.bz2"

# defaults to 2010_0709_RT2870_Linux_STA_${PV}" (no 'v')
S = "${WORKDIR}/2010_0709_RT2870_Linux_STA_v${PV}"

do_install() {
	install -d ${D}/${base_libdir}/firmware
	install -m 0644 common/rt2870.bin ${D}${base_libdir}/firmware/
}

# Do NOT try to compile the contents in the bz2 file.
do_compile() {
}

FILES_${PN} += "${base_libdir}/firmware/"
