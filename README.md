![](https://i.imgur.com/OVRdQBz.png)



# RuneLitePlus 
[![Build Status](https://travis-ci.org/runelite-extended/runelite.svg?branch=master)](https://travis-ci.org/runelite-extended/runelite)
[![HitCount](http://hits.dwyl.io/runelite-extended/runelite.svg)](http://hits.dwyl.io/runelite-extended/runelite)  
[RuneLitePlus](https://runelitepl.us)  is an extended version of [RuneLite](https://github.com/runelite/runelite) that provides more functionality and less restrictions while staying more open-source. We are not affiliated with RuneLite.

## Discord
[![Discord](https://img.shields.io/discord/373382904769675265.svg)](https://discord.gg/HN5gf3m)

## Project Layout

- [cache](cache/src/main/java/net/runelite/cache) - Libraries used for reading/writing cache files, as well as the data in it
- [deobfuscator](deobfuscator/src/main/java/net/runelite/deob) - Can decompile and cleanup gamepacks as well as map updates to newer revs
- [http-api](http-api/src/main/java/net/runelite/http/api) - API for runelite and runeliteplus
- [http-service](http-service/src/main/java/net/runelite/http/service) - Service for https://api.runelitepl.us
- [injector-plugin](injector-plugin/src/main/java/net/runelite/injector) - Tool for implementing our modifications to the gamepack
- [runelite-api](runelite-api/src/main/java/net/runelite/api) - RuneLite API, interfaces for accessing the client
- [runelite-mixins](runelite-mixins/src/main/java/net/runelite) - Classes containing the Objects to be injected using the injector-plugin
- [runescape-api](runescape-api/src/main/java/net/runelite) - Mappings correspond to these interfaces, runelite-api is a subset of this
- [runelite-client](runelite-client/src/main/java/net/runelite/client) - Game client with plugins

## Private Servers
Currently we support RSMod which can be found at: https://github.com/Tomm0017/rsmod but should work with any server that follows osrs protocol.
```
Jar/IntelliJ
Use -private-server arg.

Exe
Use --clientargs="--private-server" arg.

Using modified mixins is possible using -local-injected arg, but it looks in a very specific location. 
(./injected-client/target/injected-client-X.X.XX-SNAPSHOT.jar) (X.X.XX must match current API version)

-----

Set codebase in ./codebase or in Private Server plugin and restart.  
Update modulus in Private Server plugin. 
    
Disable Default World plugin if you have it enabled, this causes issues with codebase.
```  
## License

RuneLitePlus is licensed under the BSD 2-clause license. See the license header in the respective file to be sure.

## Contribute and Develop

We've set up a separate document for our [contribution guidelines](https://github.com/runelite-extended/runelite/blob/master/.github/CONTRIBUTING.md).
