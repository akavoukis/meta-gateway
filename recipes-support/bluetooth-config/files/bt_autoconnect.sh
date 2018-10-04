#! /bin/sh

timeout 30s /usr/lib/bluez/test/test-discovery
timeout 30s /usr/lib/bluez/test/simple-agent hci0 30:14:10:17:02:90
rfcomm connect hci0 30:14:10:17:02:90 1
