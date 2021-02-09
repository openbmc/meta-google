PR = "r1"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

inherit systemd

RDEPENDS_${PN} += "iperf3"

SRC_URI_gbmc += "file://iperf3.service"

SYSTEMD_SERVICE_${PN} += "iperf3.service"

do_install() {
    # Install service definitions
    install -d -m 0755 ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/iperf3.service ${D}${systemd_system_unitdir}
}
