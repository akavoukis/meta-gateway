DESCRIPTION = "swupdate image"
SECTION = ""

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS += "rpi-zigbee-image"
PR = "r6"

SRC_URI = " \
            file://sw-description \
            file://emmcsetup.lua \
            "

# SRC_URI[md5sum] = "17e6a3996de2942629dce65db1a701c5"

# images to build before building swupdate image
IMAGE_DEPENDS = "rpi-zigbee-image"

# images and files that will be included in the .swu image
SWUPDATE_IMAGES = " \
        rpi-zigbee-image \
	"

SWUPDATE_IMAGES_FSTYPES[rpi-zigbee-image] = ".ext4.gz"

#SWUPDATE_SIGNING = "1"

inherit swupdate

COMPATIBLE = "rpi-zigbee-image"
