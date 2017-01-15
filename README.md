# runelite

runelite is a RuneScape 2 client and reverse engineering project

## project layout

- cache - libraries used for reading/writing cache files, as well as the data in it
- deobfuscator - contains bytecode deobfuscator, mapper for handling updates, and the injector
- runelite-api - runelite api, use this for plugin development
- runescape-api - mappings correspond to these interfaces. runelite-api wraps this.
- runescape-client-injector - builds the injection from the vanilla client and the mappings
- runescape-client - decompiled RuneScape client, contains mappings

## Usage

Open the project in your IDE as a Maven project and run the RuneLite class in runelite-client.

### License

Most of Runelite is licensed under the BSD 2-clause license. See the license header in the respective file to be sure.
Some of the code, like evreything in runescape-client, is automatically generated, and is not licensed.
