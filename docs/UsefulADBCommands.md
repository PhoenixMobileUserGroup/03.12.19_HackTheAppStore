# Useful ADB Commands #

## List packages ##
`adb shell pm list packages`

Lists all installed packages

Example:

```
$ adb shell pm list packages
package:com.example.android.livecubes
package:com.android.providers.telephony
package:com.android.providers.calendar

```

## Grep ##
`grep`

The grep utility searches any given input files, selecting lines that match one or more patterns

Example:

```
$ adb shell pm list packages | grep facebook
package:com.facebook.katana
```


## List Package Path ##

`adb shell pm path <package_name>`

Displays the path in the Android filesytem for the package

Example:
```
$ adb shell pm path com.facebook.katana
package:/data/app/com.facebook.katana-1/base.apk
```