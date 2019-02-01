
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
