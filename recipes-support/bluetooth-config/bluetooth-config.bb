SUMMARY = "Automatic configures bluetooth \ 
This recipe will automatic configure the bluetooth by \
Automatic pair using the pincode 1234 to the ARDUINO's bluetooth module \
The connect to the serial port though bluetoth \
"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


SRC_URI = "file://10-hci-up.rules \
           file://bt_autoconnect.sh \
           file://bluetooth-autobind@hci0.service \
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
        install -m 0644 ${WORKDIR}/bluetooth-autobind@hci0.service ${D}${systemd_unitdir}/system
}

inherit systemd

SYSTEMD_SERVICE_${PN} = "bluetooth-autobind@hci0.service"

FILES_${PN} = "${sysconfdir}/udev/rules.d \
               ${bindir}/* \
"

