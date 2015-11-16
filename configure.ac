#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.61])
AC_INIT([libsqlite4java], [version-unused], [unknown@nowhere.com])
AM_INIT_AUTOMAKE
AC_CONFIG_MACRO_DIR([m4])
AC_CONFIG_SRCDIR([native/sqlite3_wrap_manual.c])
AC_CONFIG_HEADERS([config.h])

# Checks for programs.
AC_PROG_CC
AC_CHECK_PROG([swig_var], [swig], [yes], [no],, [])
if test "x${swig_var}" != xyes; then
   AC_MSG_ERROR([You need SWIG installed on your build machine!])
fi

# Checks for libraries.

# Checks for header files.
AC_HEADER_DIRENT
AC_HEADER_STDC
AC_CHECK_HEADERS([stdlib.h string.h unistd.h math.h])

# Checks for typedefs, structures, and compiler characteristics.
AC_C_CONST
AC_HEADER_STDBOOL
AC_C_INLINE
AC_TYPE_SIZE_T
AC_HEADER_TIME

# Checks for library functions.
AC_FUNC_CLOSEDIR_VOID
AC_FUNC_MEMCMP
AC_FUNC_SELECT_ARGTYPES
AC_TYPE_SIGNAL
AC_FUNC_STAT
AC_PROG_LIBTOOL
# AC_CHECK_FUNCS([inet_ntoa memset socket])

AM_INIT_AUTOMAKE([subdir-objects -Wall])

AC_ARG_VAR([JDK_HOME], [root directory of Java Development Kit])
if test -z "$JDK_HOME"; then
   # default for Debian/Wheezy
   JDK_HOME="/usr/lib/jvm/java-7-openjdk"
fi
AC_MSG_NOTICE([JDK_HOME=${JDK_HOME}])


AC_ARG_ENABLE([jamvm-openjdk8],
[  --jamvm-openjdk8	enable compiling for JamVM on OpenJDK 8 (no implicit JNI API)],
[enable_jamvm_openjdk8=${enableval}], [enable_jamvm_openjdk8=no])

if test "x${enable_jamvm_openjdk8}" = xyes; then
   AC_DEFINE([JAMVM_OPENJDK8], 1, [explicit JNI method generation for JamVM/OpenJDK8])
   AC_MSG_NOTICE([explicit JNI method generation for JamVM/OpenJDK8 enabled])
else
   AC_MSG_NOTICE([explicit JNI method generation for JamVM/OpenJDK8 disabled])
fi


AC_CONFIG_FILES([Makefile native/libsqlite4java.pc])

AC_OUTPUT
