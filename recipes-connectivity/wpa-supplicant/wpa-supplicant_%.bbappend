inherit systemd

SRC_URI += "file://wpa_supplicant_data@.service"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# SYSTEMD_SERVICE_${PN} += " wpa_supplicant_data@wlan0.service"
# SYSTEMD_AUTO_ENABLE_${PN} = "enable"

FILES_${PN} += "${datadir}/dbus-1/system-services/* \
                ${systemd_unitdir}/system/ \
                ${sysconfdir}/systemd/system/*"

do_install_append () {
    install -m 644 ${WORKDIR}/wpa_supplicant_data@.service ${D}/${systemd_unitdir}/system/wpa_supplicant_data@.service

    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
    cd ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
    ln -sf ${systemd_unitdir}/system/wpa_supplicant_data@.service wpa_supplicant_data@wlan0.service
}


