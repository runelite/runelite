import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class175 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 4655255531654283761L
   )
   static long field2371;
   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field2370;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field2368;

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(Lho;IB)I",
      garbageValue = "37"
   )
   static final int method3312(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class239.method4167(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class10.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class211.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class222.field2817[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class211.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class226.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class222.field2813[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class239.method4167(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class10.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class211.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class17.method125(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class226.localPlayer.x >> 7) + class21.baseX;
               }

               if(var6 == 19) {
                  var7 = (class226.localPlayer.y >> 7) + class164.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1597071355"
   )
   public static void method3310() {
      CombatInfo2.field3340.reset();
      CombatInfo2.spriteCache.reset();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;I)Z",
      garbageValue = "934278888"
   )
   public static boolean method3313(IndexDataBase var0, IndexDataBase var1) {
      Area.field3277 = var1;
      if(!var0.method4012()) {
         return false;
      } else {
         class270.field3665 = var0.fileCount(35);
         Area.field3265 = new Area[class270.field3665];

         for(int var2 = 0; var2 < class270.field3665; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               Area.field3265[var2] = new Area(var2);
               Area.field3265[var2].method4186(new Buffer(var3));
               Area.field3265[var2].method4183();
            }
         }

         return true;
      }
   }
}
