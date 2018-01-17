#! /bin/sh
set -e
if [ ! -d "/boot/overlays" ]; then
  mount /dev/mmcblk0p1 /boot
fi
dd if=/dev/zero ibs=1k count=4 of=blank.eep
eepflash.sh -w -f=blank.eep -t=24c32
dtc -I dts -O dtb -@ -o myhat.dtb myhat.dts
eepmake eeprom_settings.txt myhat-with-dt.eep myhat.dtb
eepflash.sh -w -f=myhat-with-dt.eep -t=24c32

