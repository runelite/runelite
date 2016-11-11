import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class40 extends class210 {
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 1791176353
   )
   static int field896;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -265161187
   )
   int field897 = (int)(class34.method738() / 1000L);
   @ObfuscatedName("pq")
   public static class139 field898;
   @ObfuscatedName("h")
   String field901;
   @ObfuscatedName("e")
   short field903;

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)I",
      garbageValue = "111"
   )
   static final int method801(Widget var0, int var1) {
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
                  var10 = class173.method3412(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class92.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == 1 + var11) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class179.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class158.field2345[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class179.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class138.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class158.field2344[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class173.method3412(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class92.getItemDefinition(var11).isMembers || Client.isMembers)) {
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
                  var9 = class179.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class9.method127(var9);
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
                  var7 = (class138.localPlayer.x >> 7) + class193.baseX;
               }

               if(var6 == 19) {
                  var7 = (class138.localPlayer.y >> 7) + DecorativeObject.baseY;
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

   class40(String var1, int var2) {
      this.field901 = var1;
      this.field903 = (short)var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass146;ZI)V",
      garbageValue = "464963141"
   )
   public static void method802(class146 var0, boolean var1) {
      if(null != class174.field2768) {
         try {
            class174.field2768.method3029();
         } catch (Exception var6) {
            ;
         }

         class174.field2768 = null;
      }

      class174.field2768 = var0;
      class20.method533(var1);
      class174.field2778.offset = 0;
      class189.field3062 = null;
      class16.field255 = null;
      class174.field2766 = 0;

      while(true) {
         class175 var2 = (class175)class174.field2764.method3815();
         if(null == var2) {
            while(true) {
               var2 = (class175)class174.field2769.method3815();
               if(null == var2) {
                  if(class174.field2776 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.method2529(4);
                        var7.method2529(class174.field2776);
                        var7.method2701(0);
                        class174.field2768.method3028(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class174.field2768.method3029();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class174.field2772;
                        class174.field2768 = null;
                     }
                  }

                  class174.field2761 = 0;
                  class168.field2707 = class34.method738();
                  return;
               }

               class174.field2765.method3904(var2);
               class174.field2767.method3813(var2, var2.hash);
               ++class174.field2777;
               --class174.field2770;
            }
         }

         class174.field2762.method3813(var2, var2.hash);
         ++class174.field2763;
         --class174.field2760;
      }
   }
}
