KERNEL_MODULE_AUTOLOAD += " i2c-dev "
KERNEL_DEVICETREE += " ../../../../../i2c-gpio.dtbo "

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://fragment.cfg \
            file://i2c-gpio.dtbo \
            file://pir_driver.patch \
            file://pir_driver_dt.patch \
"

deltacfg = "fragment.cfg"
do_configure_prepend() {
    ${S}/scripts/kconfig/merge_config.sh -O ${WORKDIR} -m ${WORKDIR}/defconfig ${WORKDIR}/${deltacfg}
    cp ${WORKDIR}/.config ${WORKDIR}/defconfig
}
