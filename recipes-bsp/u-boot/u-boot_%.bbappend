FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

SRC_URI_append_rpi = " \
    file://0003-rpi-fdt-always-rewrite-var.patch \
"
