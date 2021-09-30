SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_FEATURE_remove = "psplash"

LICENSE = "MIT"

IMAGE_INSTALL = "\
   ${CORE_IMAGE_BASE_INSTALL} \
   i2c-tools-misc \
   i2c-tools \
   iproute2 \
   alsa-utils \
   wget \
   python-subprocess \
   python-pyserial \
   python-argparse \
   python-pip \
   nano \
   kernel-modules-pcie8997 \
   linux-firmware-pcie8997 \
   kernel-modules-sdio8997 \
   glibc-gconv-utf-16 \
   glibc-utils \
   iperf3 \
   mmc-utils \
   memtester \
   picocom \
   htop \
   ea-files \
   ea-resizefs \
   u-boot-fw-utils \
   u-boot-script-ea \
   libgpiod \
"

inherit core-image

# User/Group modifications"
# - Adding user 'tester' without password"
# - Setting password for user 'root' to 'pass'"
# - For more options see extrausers.bbclass"
inherit extrausers
EXTRA_USERS_PARAMS = " \
  #useradd -p '' nixer; \
  #usermod -s /bin/sh nixer; \
  #usermod -P 'm1ndth3g4p' nixer;  \
  usermod -P 'n01c4t4rr0' root \
"
