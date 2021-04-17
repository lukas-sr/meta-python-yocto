FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://logo_linux_clut224.ppm \
            file://defconfig \
            "
KBUILD_DEFCONFIG_${MACHINE} ?= ""
KERNEL_DEFCONFIG_colibri-imx6 ?= "${WORKDIR}/defconfig"

do_configure_prepend() {
    install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm ${S}/drivers/video/logo/logo_linux_clut224.ppm
}
