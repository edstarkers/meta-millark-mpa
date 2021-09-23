# Copyright (C) 2017 Embedded Artists

DESCRIPTION = "U-Boot for Embedded Artists i.MX based boards."

DEPENDS += "flex-native bison-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "ea_v2020.04"
SRC_URI = "git://github.com/edstarkers/uboot-imx.git;branch=${SRCBRANCH} \
"
SRCREV = "374064db9db205dabeaed0dc452bdfa730f6b224"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-2.1.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

