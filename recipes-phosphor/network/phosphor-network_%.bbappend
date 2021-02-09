FILESEXTRAPATHS_prepend_gbmc := "${THISDIR}/${PN}:"

# In-Review upstream but not in tree yet
SRC_URI_append_gbmc = " \
  file://0002-ipaddress-Parse-from-netlink.patch \
  file://0003-util-Fix-isValidPrefix-to-allow-up-to-128-for-IPv6.patch \
  file://0004-util-Refactor-addressing-parsing-and-conversion.patch \
  "

# Platforms with gbmc_hoth don't use the U-Boot environment
PACKAGECONFIG_remove_gbmc_hoth = "uboot-env"
