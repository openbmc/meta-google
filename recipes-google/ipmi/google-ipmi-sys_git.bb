HOMEPAGE = "http://github.com/openbmc/google-ipmi-sys"
SUMMARY = "Google Sys OEM commands"
DESCRIPTION = "Google Sys OEM commands"

inherit autotools pkgconfig
inherit systemd
inherit obmc-phosphor-ipmiprovider-symlink

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

DEPENDS += "autoconf-archive-native"
DEPENDS += "sdbusplus"
DEPENDS += "phosphor-logging"
DEPENDS += "phosphor-ipmi-host"

S = "${WORKDIR}/git"
SRC_URI = "git://github.com/openbmc/google-ipmi-sys"
SRCREV = "f9a19b80bea5987292e61b8b2aedcc3baedcaf8f"

FILES_${PN}_append = " ${libdir}/ipmid-providers/lib*${SOLIBS}"
FILES_${PN}_append = " ${libdir}/host-ipmid/lib*${SOLIBS}"
FILES_${PN}_append = " ${libdir}/net-ipmid/lib*${SOLIBS}"
FILES_${PN}-dev_append = " ${libdir}/ipmid-providers/lib*${SOLIBSDEV} ${libdir}/ipmid-providers/*.la"

HOSTIPMI_PROVIDER_LIBRARY += "libsyscmds.so"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "gbmc-psu-hardreset.target"

do_install_append() {
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${S}/gbmc-psu-hardreset.target ${D}${systemd_system_unitdir}
}
