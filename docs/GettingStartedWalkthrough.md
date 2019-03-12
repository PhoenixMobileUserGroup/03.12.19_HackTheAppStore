Back to [Main](README.md)

# Overview #
Follow the steps in this guide to setup your environment to run the demos presented in the user group meetup.

# Steps #
- [x] Setup genymotion ([link](GenymotionSetup.md))
- [x] Install tools ([link](Tools.md))
- [x] Get familiar with adb commands
- [ ] Install the sample app

# Install the Sample Apps #
Run through these steps to install the sample app

## Download Sample Apps ##
First, download the sample apps to a local directory using this release:
[https://github.com/jixer/03.12.19_HackTheAppStore/releases/tag/sample-apps-v3](https://github.com/jixer/03.12.19_HackTheAppStore/releases/tag/sample-apps-v3)

Extract the zip file to the directory.

## Test Genymotion Connectivity ##
Ensure that Genymotion device is running.  Ensure adb can connect to the device by running the following commands:
```bash
adb devices
adb shell ls mnt
```

Output should be similar to the following:
```bash
$ adb devices
List of devices attached
192.168.58.101:5555	device

$ adb shell ls mnt
asec
expand
media_rw
obb
runtime
sdcard
secure
shared
user
```

## ADB Install ##
You can run the `adb install` command for each of the sample apps.  

Alternatively, ensure that the apk files are in a directory by themselves.  From terminal, navigate to that directory and run the following:
```bash
for i in `ls`; do adb install $i; done
```

You shoud see 5 success messages.

# Conclusion #
With those steps complete, you should be all ready to start reversing the sample apps, testing traffic sniffing tools, and patching the TrustKit app.
