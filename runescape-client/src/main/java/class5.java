import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
final class class5 implements class0 {
   @ObfuscatedName("dw")
   static class153 field38;
   @ObfuscatedName("ef")
   static Font field39;
   @ObfuscatedName("m")
   static File field40;
   @ObfuscatedName("re")
   @ObfuscatedGetter(
      intValue = 1548499233
   )
   static int field44;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "100"
   )
   static int method14(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class83.intStack[++class83.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         int[] var5;
         int var6;
         int var7;
         XItemContainer var8;
         if(var0 == 3301) {
            class83.intStackSize -= 2;
            var3 = class83.intStack[class83.intStackSize];
            var4 = class83.intStack[class83.intStackSize + 1];
            var5 = class83.intStack;
            var6 = ++class83.intStackSize - 1;
            var8 = (XItemContainer)XItemContainer.itemContainers.method3425((long)var3);
            if(var8 == null) {
               var7 = -1;
            } else if(var4 >= 0 && var4 < var8.itemIds.length) {
               var7 = var8.itemIds[var4];
            } else {
               var7 = -1;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 == 3302) {
            class83.intStackSize -= 2;
            var3 = class83.intStack[class83.intStackSize];
            var4 = class83.intStack[class83.intStackSize + 1];
            var5 = class83.intStack;
            var6 = ++class83.intStackSize - 1;
            var8 = (XItemContainer)XItemContainer.itemContainers.method3425((long)var3);
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
            class83.intStackSize -= 2;
            var3 = class83.intStack[class83.intStackSize];
            var4 = class83.intStack[class83.intStackSize + 1];
            class83.intStack[++class83.intStackSize - 1] = class43.method596(var3, var4);
            return 1;
         } else {
            int var9;
            if(var0 == 3304) {
               var3 = class83.intStack[--class83.intStackSize];
               int[] var10 = class83.intStack;
               var9 = ++class83.intStackSize - 1;
               class240 var11 = (class240)class240.field3286.get((long)var3);
               class240 var12;
               if(var11 != null) {
                  var12 = var11;
               } else {
                  byte[] var13 = class240.field3288.getConfigData(5, var3);
                  var11 = new class240();
                  if(var13 != null) {
                     var11.method4152(new Buffer(var13));
                  }

                  class240.field3286.put(var11, (long)var3);
                  var12 = var11;
               }

               var10[var9] = var12.field3287;
               return 1;
            } else if(var0 == 3305) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = Client.boostedSkillLevels[var3];
               return 1;
            } else if(var0 == 3306) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = Client.realSkillLevels[var3];
               return 1;
            } else if(var0 == 3307) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = Client.skillExperiences[var3];
               return 1;
            } else if(var0 == 3308) {
               var3 = Player.plane;
               var4 = (class20.localPlayer.x >> 7) + class19.baseX;
               var9 = (class20.localPlayer.y >> 7) + class21.baseY;
               class83.intStack[++class83.intStackSize - 1] = (var3 << 28) + (var4 << 14) + var9;
               return 1;
            } else if(var0 == 3309) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               class83.intStack[++class83.intStackSize - 1] = Client.isMembers?1:0;
               return 1;
            } else if(var0 == 3313) {
               class83.intStackSize -= 2;
               var3 = class83.intStack[class83.intStackSize] + '耀';
               var4 = class83.intStack[class83.intStackSize + 1];
               var5 = class83.intStack;
               var6 = ++class83.intStackSize - 1;
               var8 = (XItemContainer)XItemContainer.itemContainers.method3425((long)var3);
               if(var8 == null) {
                  var7 = -1;
               } else if(var4 >= 0 && var4 < var8.itemIds.length) {
                  var7 = var8.itemIds[var4];
               } else {
                  var7 = -1;
               }

               var5[var6] = var7;
               return 1;
            } else if(var0 != 3314) {
               if(var0 == 3315) {
                  class83.intStackSize -= 2;
                  var3 = class83.intStack[class83.intStackSize] + '耀';
                  var4 = class83.intStack[class83.intStackSize + 1];
                  class83.intStack[++class83.intStackSize - 1] = class43.method596(var3, var4);
                  return 1;
               } else if(var0 == 3316) {
                  if(Client.rights >= 2) {
                     class83.intStack[++class83.intStackSize - 1] = Client.rights;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3317) {
                  class83.intStack[++class83.intStackSize - 1] = Client.field919;
                  return 1;
               } else if(var0 == 3318) {
                  class83.intStack[++class83.intStackSize - 1] = Client.world;
                  return 1;
               } else if(var0 == 3321) {
                  class83.intStack[++class83.intStackSize - 1] = Client.energy;
                  return 1;
               } else if(var0 == 3322) {
                  class83.intStack[++class83.intStackSize - 1] = Client.weight;
                  return 1;
               } else if(var0 == 3323) {
                  if(Client.field1075) {
                     class83.intStack[++class83.intStackSize - 1] = 1;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3324) {
                  class83.intStack[++class83.intStackSize - 1] = Client.flags;
                  return 1;
               } else if(var0 == 3325) {
                  class83.intStackSize -= 4;
                  var3 = class83.intStack[class83.intStackSize];
                  var4 = class83.intStack[class83.intStackSize + 1];
                  var9 = class83.intStack[class83.intStackSize + 2];
                  var6 = class83.intStack[class83.intStackSize + 3];
                  var3 += var4 << 14;
                  var3 += var9 << 28;
                  var3 += var6;
                  class83.intStack[++class83.intStackSize - 1] = var3;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               class83.intStackSize -= 2;
               var3 = class83.intStack[class83.intStackSize] + '耀';
               var4 = class83.intStack[class83.intStackSize + 1];
               var5 = class83.intStack;
               var6 = ++class83.intStackSize - 1;
               var8 = (XItemContainer)XItemContainer.itemContainers.method3425((long)var3);
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

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "337463417"
   )
   static final void method15(boolean var0) {
      for(int var1 = 0; var1 < Client.field930; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.vmethod1593() && var0 == var2.composition.isVisible && var2.composition.method4517()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1212 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1009[var4][var5] == Client.field1010) {
                     continue;
                  }

                  Client.field1009[var4][var5] = Client.field1010;
               }

               if(!var2.composition.field3586) {
                  var3 -= Integer.MIN_VALUE;
               }

               class17.region.method2610(Player.plane, var2.x, var2.y, class77.method1438(var2.x + (var2.field1212 * 64 - 64), var2.y + (var2.field1212 * 64 - 64), Player.plane), var2.field1212 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1211);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1878684480"
   )
   static void method16() {
      FileOnDisk var0 = null;

      try {
         var0 = TextureProvider.getPreferencesFile("", Client.field1169.field3200, true);
         Buffer var1 = Item.field1481.method1503();
         var0.method2264(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method2274();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;B)V",
      garbageValue = "-113"
   )
   public static void method17(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3372 = var0;
      class280.field3751 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class15.addChatMessage(var0, var1, var2, (String)null);
   }
}
