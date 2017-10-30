SUMMARY = "z-stack gateway package"
LICENSE = "commercial"
LIC_FILES_CHKSUM = "file://zigbee-gateway/EULA.txt;md5=7c2d5ea0952f712724a4e7e8e546d101"
SRC_URI = "file://Z-Stack_Linux_Gateway-1_0_1-src-linux-installer.run \
	file://makefile2.patch \
	file://zstack.service \
"
TARGET_CC_ARCH += "${LDFLAGS}"
INSANE_SKIP_${PN} = "ldflags" 
INSANE_SKIP_${PN}-dev = "ldflags" 

DEPENDS = "protobuf-c \
           protobuf \
"
RDEPENDS_${PN} += "bash"

S = "${WORKDIR}"
TCLIB = "${WORKDIR}/TCLIB"

addtask extract after do_unpack before do_patch

do_extract() {
        ${S}/Z-Stack_Linux_Gateway-1_0_1-src-linux-installer.run --mode unattended \
                --prefix ${S}/${PN}
}

do_compile() {
        export TCLIB="${TCLIB}"
	mkdir -p "${TCLIB}"
        cd ${S}/${PN}/Source
	bash ${S}/${PN}/Source/build_all
}

ZSTACK = "${D}/opt/zstack/"
OUT = "${S}/${PN}/Source/out/Precompiled_arm"
FILES_${PN} += "/opt/zstack"

inherit systemd
SYSTEMD_SERVICE_${PN} = " zstack.service"

do_install() {
        install -d ${ZSTACK}
        cp -r ${OUT}/. ${ZSTACK}
	install -d ${D}${libdir}
	install -m 0644 ${OUT}/protobuf/libprotobuf-c.so.0 ${D}${libdir}

	unitdir="${D}${systemd_unitdir}/system"
	install -d -m 0755 ${unitdir}
        install -m 0644 ${WORKDIR}/zstack.service ${unitdir}
}
 
