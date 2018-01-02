SUMMARY = "Set of utilities to flash eeproms for raspberrypi hats"
DESCRIPTION = "Set of utilities to flash eeproms for raspberrypi hats"
HOMEPAGE = "https://github.com/raspberrypi/hats"
SECTION = "console/utils"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENCE;md5=1b1cf9e2e4cebd4befcd53878f5594fc"

DEPENDS = ""
PR = "r1"
RDEPENDS_${PN} = "userland dtc"

SRCREV = "9a8ff3ba8c3c19976e6b54e9c9257d7267beb02e"
SRC_URI = "git://github.com/raspberrypi/hats.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"
eeprom_dir = "${S}/eepromutils"

do_compile() {
    cd ${eeprom_dir}
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0744 ${eeprom_dir}/eepdump ${D}${bindir}
    install -m 0744 ${eeprom_dir}/eepmake ${D}${bindir}
    install -m 0744 ${eeprom_dir}/eepflash.sh ${D}${bindir}
    install -d ${D}/var/lib/eepromutils
    install -m 0644 ${eeprom_dir}/eeprom_settings.txt ${D}/var/lib/eepromutils
}
