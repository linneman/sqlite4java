ACLOCAL_AMFLAGS = -I m4

# meta library name used by libtool
lib_LTLIBRARIES=libsqlite4java.la

# NO SOURCE GENERATION DUE TO MANUAL CHANGES!
SQLITE_WRAP = swig/sqlite_wrap.c
BUILT_SOURCES = $(SQLITE_WRAP)
# Correctly clean the generated headers
CLEANFILES = $(BUILT_SOURCES)

# installed header files
include_HEADERS= \
	native/jni_setup.h \
	native/sqlite3_wrap_manual.h \
	native/intarray.h \
	sqlite/sqlite3.h \
	sqlite/sqlite3ext.h

# pkg config system
pkgconfigdir = $(libdir)/pkgconfig
pkgconfig_DATA = native/libsqlite4java.pc

# Preprocessor Flags
AM_CPPFLAGS = -Wall \
	-DNDEBUG -DLINUX -D_LARGEFILE64_SOURCE -D_GNU_SOURCE \
	-D_LITTLE_ENDIAN -DSQLITE_ENABLE_FTS3 -DSQLITE_ENABLE_FTS3_PARENTHESIS -DSQLITE_ENABLE_MEMORY_MANAGEMENT \
	-DSQLITE_ENABLE_STAT2 -DHAVE_READLINE=0 -DSQLITE_THREADSAFE=1 -DSQLITE_THREAD_OVERRIDE_LOCK=-1 -DTEMP_STORE=1 \
	-DSQLITE_OMIT_LOAD_EXTENSION=1 -DSQLITE_OMIT_DEPRECATED -DSQLITE_OS_UNIX=1 \
	-I$(top_srcdir)/sqlite \
	-I$(top_srcdir)/native \
	-I${JDK_HOME}/include/ \
	-I${JDK_HOME}/include/linux

AM_CFLAGS = -O2 -fpic -fno-omit-frame-pointer -fno-strict-aliasing -static-libgcc
libsqlite4java_la_LDFLAGS = $(AM_LDFLAGS)
libsqlite4java_la_LDFLAGS += -avoid-version
libsqlite4java_la_LDFLAGS += -Xlinker --version-script=native/mapfile-vers-product

# source generation mainly for later Java build
$(SQLITE_WRAP): swig/sqlite3_swigged.h swig/sqlite.i
	cd swig ; \
	swig -java -package com.almworks.sqlite4java sqlite.i

# the rest of the sources goes into distribution (make dist)
libsqlite4java_la_SOURCES = \
	native/sqlite3_wrap_manual.c \
	native/sqlite_wrap.c \
	native/intarray.c \
	sqlite/sqlite3.c

# libsqlite4java_la_LDFLAGS = -version-info $(libtool_VERSION)
