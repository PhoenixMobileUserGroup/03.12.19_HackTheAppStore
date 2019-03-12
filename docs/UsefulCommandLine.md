Back to [Main](README.md)

# Useful Bash and Other Commands #

## Zip Align and Sign ##
The following script can be used to zip align and sign an unsigned APK.  Make sure to replace the variables before running:

```
#set these values
name=unpinned

# Android signing from command line
originalApk=$name.apk
signedApk=$name.signed.apk

mv $originalApk $unsignedApk

$ANDROID_HOME/build-tools/26.0.2/zipalign -f -v 4 $unsignedApk $signedApk
$ANDROID_HOME/build-tools/26.0.2/apksigner sign --ks Distribution/ug_shared $signedApk
>NQM7i2m}q8.

```
