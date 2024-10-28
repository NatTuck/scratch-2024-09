
# Licensing and Deps

## Semantic Versioning (SemVer)

Version numbers (at least for libraries) have three parts (aa.bb.cc)

 - The major version - Changing this means a backwards-incompatible API change.
   - E.g 2.3.7 -> 3.0.0 - Our app may break, due to API changes.
 - The minor version - Changing this means that new features were added, but nothing should break.
   - E.g 2.3.7 -> 2.4.0 - App keeps working, hopefully.
 - The patch number - Changing this means only backwards-compatible bugfixes.
   - E.g 2.3.7 -> 2.3.11 - App keeps working, or we should get mad at the library dev.

Version numbers in package.json:

 - "2.3.7" exact version
 - "~2.3.7" means new patch versions allowed
 - "^2.3.7" means new patch or minor versions allowed


## Open Source Licenses

 - If it's open source / free software, we are allowed to use, share, modify, and share modified versions. 
 
Two kinds of open source license:

 - Permissive licenses: We can do mostly whatever we want, including using this code in our programs
   which are not open source (e.g. the MIT license).
 - Copyleft licenses: You can use it, but any software you write using it must be shared under the same
   license. (e.g. GNU GPL)
   - Network-aware copyleft licenses (GNU Affero GPL)

## Proprietary Licenses

I recommend avoiding proprietary licenses for your library dependencies.

Fusion charts licnsing terms as of 2023:

 - For only $1899/year
 - Your team of up to five developers can use this
 - As long as you don't charge a subscription fee to end users

## Even worse are platform dependencies.

If you build an application for Microsoft Sharepoint or Amazon AWS or Apple iPhone,
that's the only place that app will ever exist.


## License Auditing
