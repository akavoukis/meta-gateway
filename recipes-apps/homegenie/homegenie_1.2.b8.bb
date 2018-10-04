DESCRIPTION = "Installs Homegenie application"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENCE.TXT;md5=8742ca673f11373aa5b26f966c03ef49"

SRC_URI = "https://github.com/genielabs/HomeGenie/releases/download/v1.2-beta.8/homegenie_1.2-beta.8.tgz \
           file://homegenie_backup_config.zip;unpack=0 \
           file://homegenie.service \
"

SRC_URI[md5sum] = "aa13385a2edfe10ee2a8a0043381f7c1"

#TODO compile for arm
INSANE_SKIP_${PN} = "arch"

inherit systemd
SYSTEMD_SERVICE_${PN} = " homegenie.service"

S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}/opt
	cp -r ${S} ${D}/opt

        unzip -o ${WORKDIR}/homegenie_backup_config.zip -d ${D}/opt/homegenie

	unitdir="${D}${systemd_unitdir}/system"
	install -d -m 0755 ${unitdir}
        install -m 0644 ${WORKDIR}/homegenie.service ${unitdir}
}

# Do NOT try to compile the contents in the bz2 file.
do_compile() {
}

FILES_${PN} += "/opt"

