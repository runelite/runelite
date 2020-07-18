# RuneLite Gauntlet Plugin

**Update:** April 17th 2020

This plugin has beeen deprecated. The official RuneLite has stopped supporting the "Projectiles" class, one of the fundamental classes of this project.

I recommend that you switch to OpenOSRS.

**OpenOSRS** -> https://openosrs.com/

**Plugin Fork** -> @xKylee https://github.com/xKylee/plugins-source

---

**Author:** Yuri-chan (Nagi#0001)

**Last Updated:** July 30, 2019

**Disclaimer:** You will need to compile the classes yourself if you want to use the project.

**License:** WTFPL (https://en.wikipedia.org/wiki/WTFPL) - Everyone is permitted to copy and distribute.

## Major Changelog:
```
July 30, 2019 - Version 1.3
+ Instance Map

July 29, 2019 - Version 1.2 "Plugin Overhaul"
+ All configurations have become independant. You can disable one without affecting the other.
+ Prayer audio no longer ignores sound settings
+ Prayer attack visual is now independant to Magic and Range attacks.
+ Magic and Range attacks now have their own visuals.
+ Boss attack style icon can be toggled.
+ Timer is now available.
+ Ability to change icon size

July 27, 2019 - Version 1.1 "Initial Plugin Release"
+ Boss Overlay
+ Boss & Player Counter
+ Resources Overlay
```

## Settings and Features:
![alt text](https://www.kthisiscvpv.com/OFQRV156450711931fMT.png)

# Version 1.3

## Show Map: 
Show a live instance map as you travel around the map.

![alt text](https://www.kthisiscvpv.com/V4gZu1564507042yaJqx.png)

# Version 1.2

## Highlight Resources (Color): 
Resource deposits in each room will be highlighted in yellow.

## Highlight Resources (Icon): 
Resource deposits in each room will have an icon specifying their individual types.

![alt text](https://www.kthisiscvpv.com/AA7z61564447413LG9GI.png)

## Count Boss Attacks: 
Count the amount of attacks left until the boss changes their attack style.

## Count Player Attacks: 
Count the amount of player attacks left until the boss changes their prayer.

![alt text](https://www.kthisiscvpv.com/46dC515644638509q6gV.png)

## Unique Prayer Audio: 
Plays a unique sound whenever the boss is about to shut down your prayer.

``client.playSoundEffect(SoundEffectID.MAGIC_SPLASH_BOING);``

## Unique Prayer Visual: 
Prayer attacks will have a unique overlay visual.

![alt text](https://www.kthisiscvpv.com/64nol15644637343GmeX.png)

## Unique Magic & Range Visuals: 
Magic and Range attacks will have a unique overlay visual.

![alt text](https://www.kthisiscvpv.com/hrphS1564463651qNz2r.png)

## Overlay the Boss (Color): 
Overlay the boss with an color denoting it's current attack style.

## Overlay the Boss (Icon): 
Overlay the boss with an icon denoting it's current attack style.

![alt text](https://www.kthisiscvpv.com/QC2P91564447661A598x.png)

## Show Tornado Decay: 
Display the amount of ticks left until the tornadoes decay.

![alt text](https://www.kthisiscvpv.com/H44wz1564448298tMMS5.png)

## Show Custom Timer (Widget): 
Display a timer widget that tracks your gauntlet progress.

![alt text](https://www.kthisiscvpv.com/hZT4a1564448458EP5y4.png)

## Show Custom Timer (Chat): 
Display a chat message that tracks your gauntlet progress.

```
Triggers:
... when the player dies or leaves the raid during preperation.
... when the player first enters the boss room.
... when the player dies during the boss fight.
```

![alt text](https://www.kthisiscvpv.com/uW8IY1564448575Sn5ze.png)

## Gloabl Icon Size: 
Globally change the size of icons. { Range: 1 to 50 }

![alt text](https://www.kthisiscvpv.com/JQNN71564448951PRMGV.gif)
