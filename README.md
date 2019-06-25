![](https://i.imgur.com/OVRdQBz.png)



# RuneLitePlus-PS rev180 [![Build Status](https://travis-ci.org/zeruth/runeliteplus-ps.svg?branch=master)](https://travis-ci.org/zeruth/runeliteplus-ps) [![Discord](https://img.shields.io/discord/373382904769675265.svg)](https://discord.gg/HN5gf3m)

[RuneLitePlus-PS](https://runelitepl.us)  is a fork of [RuneLite](https://github.com/runelite/runelite) that provides more functionality and less restrictions while staying open source. This is a specific version meant for rs-mod which can be found here:
https://www.rune-server.ee/runescape-development/rs2-server/downloads/684206-180-rs-mod-release.html

## Usage

By default, this connects to our sandbox server, which is for client testing.

To setup your rsa keys, navigate to runelite-mixins and go to RSBufferMixin and set modulus and exponent
To setup your codebase, navigate to runelite-client/rs and go to RSAppletStub and set codebase = new URL("http://IP_OR_URL_HERE/");

After that it's ran much like RuneLite or RuneLitePlus, install then run RuneLite.main()

To release the built jar publicly, you'd have to host your injected client remotely and make some small modifications to rs.ClientLoader

## License

RuneLitePlus-PS is licensed under the BSD 2-clause license. See the license header in the respective file to be sure.

## Contribute and Develop

We've set up a separate document for our [contribution guidelines](https://github.com/runelite-extended/runelite/blob/master/.github/CONTRIBUTING.md).
