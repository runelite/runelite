import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class2 implements class0 {
   @ObfuscatedName("o")
   @Export("cacheLocations")
   public static String[] cacheLocations;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("varplayer_ref")
   static IndexDataBase varplayer_ref;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1292101382"
   )
   static void method6(String var0, String var1, String var2) {
      class92.loginMessage1 = var0;
      class92.loginMessage2 = var1;
      class92.loginMessage3 = var2;
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(Lhy;II)I",
      garbageValue = "-139753544"
   )
   static final int method4(Widget var0, int var1) {
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
                  var10 = class61.method1038(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class83.getItemDefinition(var11).isMembers || Client.isMembers)) {
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
                  var7 = class222.field2839[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class211.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = Script.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class222.field2841[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class61.method1038(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class83.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(1 + var11 == var10.itemIds[var12]) {
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
                  var7 = class1.method3(var9);
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
                  var7 = (Script.localPlayer.x >> 7) + class163.baseX;
               }

               if(var6 == 19) {
                  var7 = (Script.localPlayer.y >> 7) + class10.baseY;
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

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   static final void method5() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         if(var0.hitpoints == 0) {
            if(var0.field1193 < 0 || class91.method1698(var0.field1193, var0.field1195)) {
               DecorativeObject.method2890(var0.level, var0.type, var0.x, var0.y, var0.field1193, var0.field1201, var0.field1195);
               var0.unlink();
            }
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102 && (var0.id < 0 || class91.method1698(var0.id, var0.field1198))) {
               DecorativeObject.method2890(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1198);
               var0.delay = -1;
               if(var0.id == var0.field1193 && var0.field1193 == -1) {
                  var0.unlink();
               } else if(var0.id == var0.field1193 && var0.field1201 == var0.orientation && var0.field1198 == var0.field1195) {
                  var0.unlink();
               }
            }
         }
      }

   }
}
