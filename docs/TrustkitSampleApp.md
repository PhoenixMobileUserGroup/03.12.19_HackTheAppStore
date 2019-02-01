Back to [Main](README.md)

# Overview #
> TrustKit is an open source framework that makes it easy to deploy SSL public key pinning and reporting in any iOS 10+, macOS 10.10+, tvOS 10+ or watchOS 3+ App; it supports both Swift and Objective-C Apps.

[see: [datatheorem/TrustKit](https://github.com/datatheorem/TrustKit)]

# SSL Pinning #
Pinning provides developers a means of man-in-the-middle prevention, but forcing the client to validate the expected identity of the certificate being used to e

## OWASP Introduction ##
> Secure channels are a cornerstone to users and employees working remotely and on the go. Users and developers expect end-to-end security when sending and receiving data - especially sensitive data on channels protected by VPN, SSL, or TLS. While organizations which control DNS and CA have likely reduced risk to trivial levels under most threat models, users and developers subjugated to other's DNS and a public CA hierarchy are exposed to non-trivial amounts of risk. In fact, history has shown those relying on outside services have suffered chronic breaches in their secure channels.
The pandemic abuse of trust has resulted in users, developers and applications making security related decisions on untrusted input. The situation is somewhat of a paradox: entities such as DNS and CAs are trusted and supposed to supply trusted input; yet their input cannot be trusted. Relying on untrusted input for security related decisions is not only bad karma, it violates a number of secure coding principals (see, for example, OWASP's Injection Theory and Data Validation).
> 
> Pinning effectively removes the "conference of trust". An application which pins a certificate or public key no longer needs to depend on others - such as DNS or CAs - when making security decisions relating to a peer's identity. For those familiar with SSH, you should realize that public key pinning is nearly identical to SSH's StrictHostKeyChecking option. SSH had it right the entire time, and the rest of the world is beginning to realize the virtues of directly identifying a host or service by its public key.
Others who actively engage in pinning include Google and its browser Chrome. Chrome was successful in detecting the DigiNotar compromise which uncovered suspected interception by the Iranian government on its citizens. The initial report of the compromise can be found at Is This MITM Attack to Gmail's SSL?; and Google Security's immediate response at An update on attempted man-in-the-middle attacks.

[ref: [owasp.org](https://www.owasp.org/index.php/Certificate_and_Public_Key_Pinning)]

# Miscellaneous Info #
## TrustKit Pin Digest from Cert ##
Here is a useful command for obtaining the Base64 SHA-256 pin digest required by TrustKit:

`openssl x509 -inform der -in <file>.cer -pubkey -noout | openssl pkey -pubin -outform der | openssl dgst -sha256 -binary | openssl enc -base64`

*NOTE: You may have to modify the `-inform` value based upon the certificate file format (der vs pem)*

**Example:**
```
$ openssl x509 -inform der -in *.github.com.cer -pubkey -noout | openssl pkey -pubin -outform der | openssl dgst -sha256 -binary | openssl enc -base64
y2HhTRXXLdmAF1esYBb/muQUl3BIBdmEB8jUvMrGc28=
```
