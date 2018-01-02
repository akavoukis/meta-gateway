# Base this image on rpi including the zigbee gateway
include recipes-core/images/rpi-basic-image.bb
include rpi-extra.inc

SPLASH = "psplash-raspberrypi"
IMAGE_FEATURES += "ssh-server-dropbear splash"
IMAGE_INSTALL_append = " zigbee-gateway \
			 mono \
			 mono-dev \
			 homegenie \
                         eepromutils \
"
KERNEL_DEVICETREE += " i2c-gpio.dtbo"
