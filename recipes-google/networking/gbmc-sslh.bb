PR = "r1"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

inherit systemd

RDEPENDS_${PN} += "sslh"

SRC_URI_gbmc += "file://sslh.service"
SRC_URI_gbmc += "file://sslh.socket"

SYSTEMD_SERVICE_${PN} += "sslh.service"
SYSTEMD_SERVICE_${PN} += "sslh.socket"

do_install() {
    # Install service definitions
    install -d -m 0755 ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/sslh.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/sslh.socket ${D}${systemd_system_unitdir}
}
