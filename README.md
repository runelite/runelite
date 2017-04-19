![](https://puu.sh/vpxc1/5fe318e5b1.png)
# runelite

runelite is a RuneScape 2 client and reverse engineering project

If you have any questions please join our IRC channel on [irc.rizon.net #runelite](http://qchat.rizon.net/?channels=runelite&uio=d4) or alternatively our [Discord](https://discord.gg/mePCs8U) server.

## Project Layout

- cache - libraries used for reading/writing cache files, as well as the data in it
- deobfuscator - contains bytecode deobfuscator, mapper for handling updates, and the injector
- http-api - API for api.runelite.net
- http-service - Service for api.runelite.net
- model-viewer - RS Model, NPC/Object, and terrain viewer
- runelite-api - runelite api, use this for plugin development
- runescape-api - mappings correspond to these interfaces, runelite-api wraps this
- runescape-client-injector - builds the injection from the vanilla client and the mappings
- runescape-client - decompiled RuneScape client, contains mappings

## Usage

Open the project in your IDE as a Maven project, build the root module and then run the RuneLite class in runelite-client.  
For more information visit the [RuneLite Wiki](https://github.com/runelite/runelite/wiki).

### License

Most of Runelite is licensed under the BSD 2-clause license. See the license header in the respective file to be sure.
Some of the code, like everything in runescape-client, is automatically generated, and is not licensed.
