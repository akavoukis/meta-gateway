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
                         copy-personal-files \
                         swupdate \
			 swupdate-www \
			 swupdate-tools \
                         u-boot-fw-utils \
                         lua \
                         parted \
                         linux-firmware-bcm43455 \
                         bluetooth-config \
"

IMAGE_INSTALL_remove = "linux-firmware"

TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc"
IMAGE_FSTYPES += " ext4.gz"
