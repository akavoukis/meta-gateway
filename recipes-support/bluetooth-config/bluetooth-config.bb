SUMMARY = "Automatic configures bluetooth \ 
This recipe will automatic configure the bluetooth by \
Automatic pair using the pincode 1234 to the ARDUINO's bluetooth module \
The connect to the serial port though bluetoth \
"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


SRC_URI = "file://10-hci-up.rules \
           file://bt_autoconnect.sh \
           file://bluetooth-autobind@.service \
"

RDEPENDS_${PN} = "bluez5 \
                  bluez5-testtools \
"

S = "${WORKDIR}"

do_install () {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/10-hci-up.rules ${D}${sysconfdir}/udev/rules.d/

        install -d ${D}${bindir}
        install -m 0744 ${WORKDIR}/bt_autoconnect.sh ${D}${bindir}/

        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/bluetooth-autobind@.service ${D}${systemd_unitdir}/system/

        install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
        cd ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
        ln -sf ${systemd_unitdir}/system/bluetooth-autobind@.service bluetooth-autobind@hci0.service
}

inherit systemd

SYSTEMD_SERVICE_${PN} = "bluetooth-autobind@.service"

FILES_${PN} = "${sysconfdir}/udev/rules.d \
               ${bindir}/* \
               ${sysconfdir}/systemd/system/* \
"

