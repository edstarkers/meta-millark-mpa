SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_FEATURE_remove = "psplash"

LICENSE = "MIT"

IMAGE_INSTALL = "\
   ${CORE_IMAGE_BASE_INSTALL} \
   i2c-tools-misc \
   i2c-tools \
   pciutils \
   iproute2 \
   alsa-utils \
   wget \
   nano \
   picocom \
   htop \
   python-subprocess \
   python-pyserial \
   python-argparse \
   python-pip \
   kernel-modules-pcie8997 \
   linux-firmware-pcie8997 \
   kernel-modules-sdio8997 \
   glibc-gconv-utf-16 \
   glibc-utils \
   iperf3 \
   ea-files \
   mmc-utils \
   memtester \
   screen \
   ea-resizefs \
   u-boot-fw-utils \
   u-boot-script-ea \
   ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-init', '', d)} \
   ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-examples', '', d)} \
   libgpiod \
"

#IMAGE_INSTALL_append_imx8mnea-ucom = "\
#   ea-resizefs \
#"

inherit core-image

# User/Group modifications"
# - Adding user 'tester' without password"
# - Setting password for user 'root' to 'pass'"
# - For more options see extrausers.bbclass"
inherit extrausers
EXTRA_USERS_PARAMS = " \
  #useradd -p '' millark; \
  #usermod -s /bin/sh nixer; \
  #usermod -P 'm1ndth3g4p' nixer;  \
  usermod -P 'n01c4t4rr0' root \
"
