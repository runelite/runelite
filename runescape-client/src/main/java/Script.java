import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 1658723895
   )
   static int field1412;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field1406;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("q")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("o")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("p")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1197460281
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2091636655
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1712413665
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1637077519
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Lgv;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1406 = new NodeCache(128);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)[Lgv;",
      garbageValue = "-937982235"
   )
   IterableHashTable[] method1999(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILca;ZB)I",
      garbageValue = "24"
   )
   static int method2008(int var0, Script var1, boolean var2) {
      if(var0 == 3200) {
         class80.intStackSize -= 3;
         int var3 = class80.intStack[class80.intStackSize];
         int var4 = class80.intStack[class80.intStackSize + 1];
         int var5 = class80.intStack[class80.intStackSize + 2];
         if(Client.field1040 != 0 && var4 != 0 && Client.queuedSoundEffectCount < 50) {
            Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var3;
            Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var4;
            Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var5;
            Client.audioEffects[Client.queuedSoundEffectCount] = null;
            Client.soundLocations[Client.queuedSoundEffectCount] = 0;
            ++Client.queuedSoundEffectCount;
         }

         return 1;
      } else if(var0 == 3201) {
         class20.method168(class80.intStack[--class80.intStackSize]);
         return 1;
      } else if(var0 == 3202) {
         class80.intStackSize -= 2;
         class5.method12(class80.intStack[class80.intStackSize], class80.intStack[class80.intStackSize + 1]);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "861022745"
   )
   static final int method2007() {
      if(Client.preferences.hideRoofs) {
         return class230.plane;
      } else {
         int var0 = 3;
         if(DecorativeObject.cameraPitch < 310) {
            int var1 = MapIcon.cameraX >> 7;
            int var2 = CombatInfo1.cameraY >> 7;
            int var3 = OwnWorldComparator.localPlayer.x >> 7;
            int var4 = OwnWorldComparator.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class230.plane;
            }

            if((class61.tileSettings[class230.plane][var1][var2] & 4) != 0) {
               var0 = class230.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = 32768;

               while(var3 != var1) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class61.tileSettings[class230.plane][var1][var2] & 4) != 0) {
                     var0 = class230.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class61.tileSettings[class230.plane][var1][var2] & 4) != 0) {
                        var0 = class230.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = 32768;

               while(var2 != var4) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class61.tileSettings[class230.plane][var1][var2] & 4) != 0) {
                     var0 = class230.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class61.tileSettings[class230.plane][var1][var2] & 4) != 0) {
                        var0 = class230.plane;
                     }
                  }
               }
            }
         }

         if(OwnWorldComparator.localPlayer.x >= 0 && OwnWorldComparator.localPlayer.y >= 0 && OwnWorldComparator.localPlayer.x < 13312 && OwnWorldComparator.localPlayer.y < 13312) {
            if((class61.tileSettings[class230.plane][OwnWorldComparator.localPlayer.x >> 7][OwnWorldComparator.localPlayer.y >> 7] & 4) != 0) {
               var0 = class230.plane;
            }

            return var0;
         } else {
            return class230.plane;
         }
      }
   }
}
