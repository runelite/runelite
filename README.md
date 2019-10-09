![](https://i.imgur.com/0D5106S.png)



# OpenOSRS 
[![Build Status](https://github.com/open-osrs/runelite/workflows/OpenOSRS%20-%20CI/badge.svg)](https://github.com/open-osrs/runelite/actions)
[![HitCount](http://hits.dwyl.io/open-osrs/runelite.svg)](http://hits.dwyl.io/open-osrs/runelite)  
[OpenOSRS](https://openosrs.com)  is an extended version of [RuneLite](https://github.com/runelite/runelite) that provides more functionality and less restrictions while staying more open-source. We are not affiliated with RuneLite.

## Discord
[![Discord](https://img.shields.io/discord/373382904769675265.svg)](https://discord.gg/HN5gf3m)

## Project Layout

- [cache](cache/src/main/java/net/runelite/cache) - Libraries used for reading/writing cache files, as well as the data in it
- [deobfuscator](deobfuscator/src/main/java/net/runelite/deob) - Can decompile and cleanup gamepacks as well as map updates to newer revs
- [http-api](http-api/src/main/java/net/runelite/http/api) - API for runelite and OpenOSRS
- [http-service](http-service/src/main/java/net/runelite/http/service) - Service for https://api.runelite.net
- [http-service-plus](http-service-plus/src/main/java/net/runelite/http/service) - Service for https://api.openosrs.com
- [injector-plugin](injector-plugin/src/main/java/net/runelite/injector) - Tool for implementing our modifications to the gamepack
- [runelite-api](runelite-api/src/main/java/net/runelite/api) - RuneLite API, interfaces for accessing the client
- [runelite-mixins](runelite-mixins/src/main/java/net/runelite) - Classes containing the Objects to be injected using the injector-plugin
- [runescape-api](runescape-api/src/main/java/net/runelite) - Mappings correspond to these interfaces, runelite-api is a subset of this
- [runelite-client](runelite-client/src/main/java/net/runelite/client) - Game client with plugins

## Building
We have migrated the project to Gradle. Information on how to setup and build the project can be found at https://github.com/open-osrs/runelite/wiki/Building-with-IntelliJ-IDEA

## Private Servers
Currently we support RSMod which can be found at: https://github.com/Tomm0017/rsmod but should work with any server that follows osrs protocol.
```
Gradle  
enter  
run --args='--rs=RSPS'  
into the tasks box

Jar
Use -rs=RSPS arg.

Exe
Use --clientargs="--rs=RSPS" arg.

-----

Codebase is set to 127.0.0.1 by default and can be changed in the Private Server plugin (requires restart) 
Update modulus in Private Server plugin. 
    
Disable Default World plugin if you have it enabled, this causes issues with codebase.
```  
## License

OpenOSRS is licensed under the BSD 2-clause license. See the license header in the respective file to be sure.

## Contribute and Develop

We've set up a separate document for our [contribution guidelines](https://github.com/open-osrs/runelite/blob/master/.github/CONTRIBUTING.md).
