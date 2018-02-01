import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class20 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -749901625
   )
   @Export("sampleRate")
   public static int sampleRate;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "2029709435"
   )
   static int method166(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class80.intStack[++class80.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         if(var0 == 3301) {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            class80.intStack[++class80.intStackSize - 1] = BoundingBox.method61(var3, var4);
            return 1;
         } else {
            int[] var5;
            int var6;
            int var7;
            ItemContainer var8;
            if(var0 == 3302) {
               class80.intStackSize -= 2;
               var3 = class80.intStack[class80.intStackSize];
               var4 = class80.intStack[class80.intStackSize + 1];
               var5 = class80.intStack;
               var6 = ++class80.intStackSize - 1;
               var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                  var7 = var8.stackSizes[var4];
               } else {
                  var7 = 0;
               }

               var5[var6] = var7;
               return 1;
            } else if(var0 == 3303) {
               class80.intStackSize -= 2;
               var3 = class80.intStack[class80.intStackSize];
               var4 = class80.intStack[class80.intStackSize + 1];
               class80.intStack[++class80.intStackSize - 1] = MouseInput.method991(var3, var4);
               return 1;
            } else {
               int var10;
               if(var0 == 3304) {
                  var3 = class80.intStack[--class80.intStackSize];
                  int[] var9 = class80.intStack;
                  var10 = ++class80.intStackSize - 1;
                  InvType var11 = (InvType)InvType.inventoryCache.get((long)var3);
                  InvType var12;
                  if(var11 != null) {
                     var12 = var11;
                  } else {
                     byte[] var13 = InvType.field3344.getConfigData(5, var3);
                     var11 = new InvType();
                     if(var13 != null) {
                        var11.decode(new Buffer(var13));
                     }

                     InvType.inventoryCache.put(var11, (long)var3);
                     var12 = var11;
                  }

                  var9[var10] = var12.size;
                  return 1;
               } else if(var0 == 3305) {
                  var3 = class80.intStack[--class80.intStackSize];
                  class80.intStack[++class80.intStackSize - 1] = Client.boostedSkillLevels[var3];
                  return 1;
               } else if(var0 == 3306) {
                  var3 = class80.intStack[--class80.intStackSize];
                  class80.intStack[++class80.intStackSize - 1] = Client.realSkillLevels[var3];
                  return 1;
               } else if(var0 == 3307) {
                  var3 = class80.intStack[--class80.intStackSize];
                  class80.intStack[++class80.intStackSize - 1] = Client.skillExperiences[var3];
                  return 1;
               } else if(var0 == 3308) {
                  var3 = MessageNode.plane;
                  var4 = (class36.localPlayer.x >> 7) + WorldMapType1.baseX;
                  var10 = (class36.localPlayer.y >> 7) + class85.baseY;
                  class80.intStack[++class80.intStackSize - 1] = (var4 << 14) + var10 + (var3 << 28);
                  return 1;
               } else if(var0 == 3309) {
                  var3 = class80.intStack[--class80.intStackSize];
                  class80.intStack[++class80.intStackSize - 1] = var3 >> 14 & 16383;
                  return 1;
               } else if(var0 == 3310) {
                  var3 = class80.intStack[--class80.intStackSize];
                  class80.intStack[++class80.intStackSize - 1] = var3 >> 28;
                  return 1;
               } else if(var0 == 3311) {
                  var3 = class80.intStack[--class80.intStackSize];
                  class80.intStack[++class80.intStackSize - 1] = var3 & 16383;
                  return 1;
               } else if(var0 == 3312) {
                  class80.intStack[++class80.intStackSize - 1] = Client.isMembers?1:0;
                  return 1;
               } else if(var0 == 3313) {
                  class80.intStackSize -= 2;
                  var3 = class80.intStack[class80.intStackSize] + 32768;
                  var4 = class80.intStack[class80.intStackSize + 1];
                  class80.intStack[++class80.intStackSize - 1] = BoundingBox.method61(var3, var4);
                  return 1;
               } else if(var0 != 3314) {
                  if(var0 == 3315) {
                     class80.intStackSize -= 2;
                     var3 = class80.intStack[class80.intStackSize] + 32768;
                     var4 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = MouseInput.method991(var3, var4);
                     return 1;
                  } else if(var0 == 3316) {
                     if(Client.rights >= 2) {
                        class80.intStack[++class80.intStackSize - 1] = Client.rights;
                     } else {
                        class80.intStack[++class80.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3317) {
                     class80.intStack[++class80.intStackSize - 1] = Client.field904;
                     return 1;
                  } else if(var0 == 3318) {
                     class80.intStack[++class80.intStackSize - 1] = Client.world;
                     return 1;
                  } else if(var0 == 3321) {
                     class80.intStack[++class80.intStackSize - 1] = Client.energy;
                     return 1;
                  } else if(var0 == 3322) {
                     class80.intStack[++class80.intStackSize - 1] = Client.weight;
                     return 1;
                  } else if(var0 == 3323) {
                     if(Client.field976) {
                        class80.intStack[++class80.intStackSize - 1] = 1;
                     } else {
                        class80.intStack[++class80.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3324) {
                     class80.intStack[++class80.intStackSize - 1] = Client.flags;
                     return 1;
                  } else if(var0 == 3325) {
                     class80.intStackSize -= 4;
                     var3 = class80.intStack[class80.intStackSize];
                     var4 = class80.intStack[class80.intStackSize + 1];
                     var10 = class80.intStack[class80.intStackSize + 2];
                     var6 = class80.intStack[class80.intStackSize + 3];
                     var3 += var4 << 14;
                     var3 += var10 << 28;
                     var3 += var6;
                     class80.intStack[++class80.intStackSize - 1] = var3;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  class80.intStackSize -= 2;
                  var3 = class80.intStack[class80.intStackSize] + 32768;
                  var4 = class80.intStack[class80.intStackSize + 1];
                  var5 = class80.intStack;
                  var6 = ++class80.intStackSize - 1;
                  var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
                  if(var8 == null) {
                     var7 = 0;
                  } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                     var7 = var8.stackSizes[var4];
                  } else {
                     var7 = 0;
                  }

                  var5[var6] = var7;
                  return 1;
               }
            }
         }
      }
   }
}
