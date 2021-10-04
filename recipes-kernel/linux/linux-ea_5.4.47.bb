# Copyright (C) 2017 Embedded Artists AB
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided by Embedded Artists but based on NXP's kernel"
DESCRIPTION = "Linux Kernel for Embedded Artists i.MX based COM boards. \
The kernel is based on the kernel provided by NXP."

require recipes-kernel/linux/linux-imx.inc
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/edstarkers/linux-imx.git;protocol=git;branch=${SRCBRANCH}"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

LOCALVERSION = "-2.2.0"
SRCBRANCH = "ea_5.4.47"
SRCREV = "6afae5e43b820189037e551b08b5ecfdb84e3c97"
DEPENDS += "lzop-native bc-native"

DEFAULT_PREFERENCE = "1"

DO_CONFIG_EA_IMX_COPY = "no"
DO_CONFIG_EA_IMX_COPY_mx6 = "yes"
DO_CONFIG_EA_IMX_COPY_mx7 = "yes"
DO_CONFIG_EA_IMX_COPY_mx8 = "no"

addtask copy_defconfig after do_unpack before do_preconfigure
do_copy_defconfig () {
    install -d ${B}


    if [ ${DO_CONFIG_EA_IMX_COPY} = "yes" ]; then
        # copy latest ea_imx_defconfig to use
        mkdir -p ${B}
        cp ${S}/arch/arm/configs/ea_imx_defconfig ${B}/.config
        cp ${S}/arch/arm/configs/ea_imx_defconfig ${B}/../defconfig
    else
        # copy latest defconfig to use for mx8
        mkdir -p ${B}
        cp ${S}/arch/arm64/configs/ea_imx8_defconfig ${B}/.config
        cp ${S}/arch/arm64/configs/ea_imx8_defconfig ${B}/../defconfig
    fi
    
    if [ -f ${S}/arch/arm64/configs/${MACHINE}_defconfig ]; then
     	mkdir -p ${B}
     	cp ${S}/arch/arm64/configs/${MACHINE}_defconfig ${B}/.config
     	cp ${S}/arch/arm64/configs/${MACHINE}_defconfig ${B}/../defconfig
    fi

}

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

EXTRA_OEMAKE_append_mx6 = " ARCH=arm"
EXTRA_OEMAKE_append_mx7 = " ARCH=arm"
EXTRA_OEMAKE_append_mx8 = " ARCH=arm64"

