KERNEL_MODULE_AUTOLOAD += " i2c-dev "
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://fragment.cfg "

deltacfg = "fragment.cfg"
do_configure_prepend() {
    ${S}/scripts/kconfig/merge_config.sh -O ${WORKDIR} -m ${WORKDIR}/defconfig ${WORKDIR}/${deltacfg}
    cp ${WORKDIR}/.config ${WORKDIR}/defconfig
}
