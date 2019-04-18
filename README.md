![](https://i.imgur.com/sBLouZ7.png)

[![Discord](https://img.shields.io/discord/373382904769675265.svg)](https://discord.gg/HN5gf3m) [![Travis](https://travis-ci.com/zeruth/runelit.svg?branch=master)](https://travis-ci.com/zeruth/runelit)  
RuneLit is a fork of [RuneLite](https://github.com/runelite/runelite) that provides more functionality and less restrictions while staying open source. This is meant to directly compete with 3rd party RL clients that are trying to sell their code. 
  
# Notable Features:

### Auto patch-time Bytecode patcher  
What a mouthful right? it's great though.  
The heart of the auto patching system is ByteCodePatcher. Adding a new patch would go as follows.  
     
1. Find unique identifier for class so it can be found after rev update, Add check<rsClass> to ByteCodePatcher.  
2. Create Transformer for rsClass and call it when class is identified.  
  
A fully functional example is included at ActorTransform:  
transformGetAnimation removes filtering  
transformAnimationChanged removes filtering  