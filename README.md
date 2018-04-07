![](https://runelite.net/img/logo.png)
# runelite [![Travis](https://img.shields.io/travis/runelite/runelite.svg)](https://travis-ci.org/runelite/runelite) [![Discord](https://img.shields.io/discord/301497432909414422.svg)](https://discord.gg/mePCs8U)

runelite is a RuneScape 2 client and reverse engineering project

If you have any questions, please join our IRC channel on [irc.rizon.net #runelite](http://qchat.rizon.net/?channels=runelite&uio=d4) or alternatively our [Discord](https://discord.gg/mePCs8U) server.

## Project Layout

- cache - Libraries used for reading/writing cache files, as well as the data in it
- deobfuscator - Contains bytecode deobfuscator, mapper for handling updates, and the injector
- http-api - API for api.runelite.net
- http-service - Service for api.runelite.net
- model-viewer - RS Model, NPC/Object, and terrain viewer
- runelite-api - RuneLite API, interfaces for accessing the client
- runelite-mixins - Mixins which are injected into the injected client's classes
- runescape-api - Mappings correspond to these interfaces, runelite-api is a subset of this
- runelite-client - Game client with plugins
- runescape-client-injector - Builds the injected client from the vanilla client and the mappings
- runescape-client - Decompiled RuneScape client, contains mappings

## Usage

Open the project in your IDE as a Maven project, build the root module and then run the RuneLite class in runelite-client.  
For more information visit the [RuneLite Wiki](https://github.com/runelite/runelite/wiki).

### License

Most of RuneLite is licensed under the BSD 2-clause license. See the license header in the respective file to be sure.
Some of the code, like everything in runescape-client, is automatically generated and is not licensed.

## Contribute and Develop

We've set up a separate document for our [contribution guidelines](https://github.com/runelite/runelite/blob/master/CONTRIBUTING.md).
