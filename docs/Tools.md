Back to [Main](README.md)

Here's a checklist of things you'll need to get started (checked boxes are critical; unchecked will be handy at some point)...

**Android Environment:**
- [x] At least one of these (both recommended):
  - [Genymotion Emulator with Play Support](#genymotion-emulator)
  - Rooted Android Device
- [x] [ADB Tools](#adb-tools)

**Reversing Tools:**
- [x] [Dex to Java Decompiler (jadx recommended)](#jadx)
- [ ] [Unity Reversing tools (DevX Studio)](#other-reversing-tools)
- [ ] [ARM assembly reversing tools](#other-reversing-tools)
- [ ] [ILSpy for Xamarin](#ilspy)

**Other**
- [x] [Network Traffic Sniffer](#network-traffic-sniffers)
- [x] A text editor of choice (if this wasn't a given, please pipe yourself to [/dev/null](devnull.md) to avoid future confusion)
- [ ] Android Studio

# Genymotion Emulator #
Useful Android emulator.  Can easily be setup with GooglePlay support and ARM translation (Marshmallow).

[ref: [https://www.genymotion.com](https://www.genymotion.com)]

## Open GApps ##
Add GooglePlay and more to your emulator or rooted device

[ref: [opengapps.org](https://opengapps.org)]


## Setup Instructions ##
See the [Genymotion Setup Article](GenymotionSetup.md) for information about setting up.


# ADB Tools #
ADB tools will be absolutely critical so you can access the Emulator or physical Android device's file system.  Also enables installing of patched or modified APK's.

Instructions are not provided here for installing, but Android Studio will come with ADB tools and is a straight forward install.


# JADX #
JADX is a valuable Dex to Java decompiler.  It also comes with a handy GUI that can be used to browse sorces and generate an Android Studio project. 

## Setup ##
Instuctions for JADX found on GitHub under [skylot/jadx](https://github.com/skylot/jadx)

For OSX, homebrew can be used:
```
$ brew search jadx
==> Formulae
jadx ✔

$ brew install jadx
/* Output removed for brevity */
```


# ILSPy #
For those familiar with .NET reflector, ILSpy provides nearly the same functionality and is free.  

## Setup ##
Install on Windows is very easy: [icsharpcode/ILSpy](https://github.com/icsharpcode/ILSpy#ilspy-------)

For OSX, I've found the following GitHub repo valuable: [aerror2/ILSpy-For-MacOSX](https://github.com/aerror2/ILSpy-For-MacOSX)


# Other Reversing Tools #
These tools are more 300-level tools and are very expensive.  For the sake of white hat exploration, these tools will probably not be required and are recommended only for people interested in mobile security consulting.

## Unity Reversing ##
A tool called [UnityUnpacker](http://devxdevelopment.com/UnityUnpacker) packs a $50 - $500 punch to your wallet, but also unpacks Unity applications.

This tool can be used to reverse apps built using Unity to get access to the underlying game assets (e.g., scripts, scenes)

## Assembly Debugger (e.g., ARM assembly) ##
[Hex-Rays](https://www.hex-rays.com/) offers a suite of tools that can be used to debug ARM-level assembly code.  In most cases, ARM debuggers are required to debug .so files and such that are compiled down to the ARM level vs. Android intermediate languages (i.e., smali).

If you need this tool, you're probably beyond the point of exploring the security of your own application in the AppStore (you know who you are).  Therefore, prepare yourself by navigating to their pricing page and do some ROI analysis.  You may also want to analyze your risk/reward ratio.  Reversing applications can be prosecuted by law through fines or jail time.

[see: [South Korean Overwatch hackers arrested and fined $10 grand](https://www.altchar.com/games-news/566980/south-korean-overwatch-hackers-arrested-and-fined)]


# Network Traffic Sniffers #
These tools can be used to read TCP, HTTP, and HTTPs traffic

## Charles Proxy ##
> Charles is an HTTP proxy / HTTP monitor / Reverse Proxy that enables a developer to view all of the HTTP and SSL / HTTPS traffic between their machine and the Internet. This includes requests, responses and the HTTP headers (which contain the cookies and caching information).

Charles Proxy offers an app in GooglePlay and Apple App Store that can be installed directly to your phone for HTTP and HTTPs traffic analysis.

Charles is not a free tool, but 30-day demos are available with limitted feature sets.

[ref: [charlesproxy.com](https://www.charlesproxy.com)]


## Burp Suite ##
Alternative HTTP proxy debugger.  Community edition (free) should provide the general functionality needed to monitor HTTP and HTTPs traffic from your device.

[ref: [portswigger.net/burp](https://portswigger.net/burp)]


## Honorable Mentions ##
These tools are worth mentioning, but were left off the list above due to either complexity or X-Platform support (i.e., Linix / OSX versions don't exit)
- WireShark
- Fiddler Proxy