![](https://i.imgur.com/OVRdQBz.png)



# RuneLitePlus 
[![forthebadge](https://forthebadge.com/images/badges/built-by-developers.svg)](https://forthebadge.com)

[![Build Status](https://travis-ci.org/runelite-extended/runelite.svg?branch=master)](https://travis-ci.org/runelite-extended/runelite) [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com) [![HitCount](http://hits.dwyl.io/runelite-extended/runelite.svg)](http://hits.dwyl.io/runelite-extended/runelite) [![saythanks](https://img.shields.io/badge/say-thanks-32cd32.svg)](https://www.patreon.com/RuneLitePlus)

[RuneLitePlus](https://runelitepl.us)  is an extended version of [RuneLite](https://github.com/runelite/runelite) that provides more functionality and less restrictions while staying more open-source. We are not affiliated with RuneLite.



## Discord
![[Discord]](https://discordapp.com/api/guilds/373382904769675265/widget.png?style=banner2)

## Project Layout

- [cache](cache/src/main/java/net/runelite/cache) - Libraries used for reading/writing cache files, as well as the data in it
- [deobfuscator]{deobfuscator/src/main/java/net/runelite/deob) - Can decompile and cleanup gamepacks as well as map updates to newer revs
- [http-api](http-api/src/main/java/net/runelite/http/api) - API for runelite and runeliteplus
- [http-service](http-service/src/main/java/net/runelite/http/service) - Service for https://api.runelitepl.us
- [injector-plugin](injector-plugin/src/main/java/net/runelite/injector) - Tool for implementing our modifications to the gamepack
- [runelite-api](runelite-api/src/main/java/net/runelite/api) - RuneLite API, interfaces for accessing the client
- [runelite-mixins](runelite-mixins/src/main/java/net/runelite) - Classes containing the Objects to be injected using the injector-plugin
- [runescape-api](runescape-api/src/main/java/net/runelite) - Mappings correspond to these interfaces, runelite-api is a subset of this
- [runelite-client](runelite-client/src/main/java/net/runelite/client) - Game client with plugins

## Private Servers

Use -local-injected and -private-server args.  
Replace modulus in RSBufferMixin.  
Set codebase in PrivateRSAppletStub.  
  
Disable Default World plugin if you have it enabled, this causes issues with codebase.

## License

RuneLitePlus is licensed under the BSD 2-clause license. See the license header in the respective file to be sure.

## Contribute and Develop

We've set up a separate document for our [contribution guidelines](https://github.com/runelite-extended/runelite/blob/master/.github/CONTRIBUTING.md).
