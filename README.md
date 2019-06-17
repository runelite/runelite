![](https://i.imgur.com/OVRdQBz.png)



# RuneLitePlus-PS rev180 [![Build Status](https://travis-ci.org/runelite-extended/runelite.svg?branch=master)](https://travis-ci.org/runelite-extended/runelite) [![Discord](https://img.shields.io/discord/373382904769675265.svg)](https://discord.gg/HN5gf3m)

[RuneLitePlus-PS](https://runelitepl.us)  is a fork of [RuneLite](https://github.com/runelite/runelite) that provides more functionality and less restrictions while staying open source. This is specific version meant for rs-mod which can be found here:  
https://www.rune-server.ee/runescape-development/rs2-server/downloads/684206-180-rs-mod-release.html

## Usage

To setup your rsa keys, navigate to runelite-mixins and go to RSBufferMixin and set modulus and exponent

After that it's ran much like RuneLite or RuneLitePlus, install then run RuneLite.main()

Be sure to add either -rs=CUSTOM or -local-injected while working on it in intelliJ  (Both args achieve the same goal)   
[](https://media.discordapp.net/attachments/557733761589051452/590312770772271131/unknown.png)  
  
To release the built jar publicly, you'd have to host your injected client remotely and redirect it to your source in rs.ClientLoader

## License

RuneLitePlus-PS is licensed under the BSD 2-clause license. See the license header in the respective file to be sure.

## Contribute and Develop

We've set up a separate document for our [contribution guidelines](https://github.com/runelite-extended/runelite/blob/master/.github/CONTRIBUTING.md).
