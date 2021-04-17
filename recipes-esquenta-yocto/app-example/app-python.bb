inherit systemd

DESCRIPTION = "Simple App Python with Autorun"
SECTION = "GUI"

# If you add any other license, you must add the md5/sha256 of the licence file
LICENSE = "CLOSED"

# Package Release - r0
PR = "r0"

SYSTEMD_SERVICE_${PN} = "app.python.service"

# Runtime dependencies of our package
RDEPENDS_${PN} = " python3-core python3-pyqt5 fontconfig"

# We define where we add our package resource

FILES_${PN} += "\
                /opt/app-python/* \
               "

SCR_URI = "\
           file://app/* \
           file://init/app-python.service \
          "
do_install(){
    install -d ${D}/opt/app-python
    install -d ${D}${systemd_unitdir}/system

    # Copy other files with other permissions
    cp -R --no-dereference --preserve=mode,links -v ${WORKDIR}/app/* ${D}/opt/app-python

    # Install the python application in its directory
    # install -Dm 0755 ${WORKDIR}/app/my-app.py ${D}/opt/app-python

    # Install the service file to its directory
    install -Dm 0644 ${WORKDIR}/init/app-python.service ${D}${systemd_unitdir}/system
}
