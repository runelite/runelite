import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class13 implements Runnable {
   @ObfuscatedName("d")
   Object field187 = new Object();
   @ObfuscatedName("pd")
   static class137 field188;
   @ObfuscatedName("r")
   int[] field189 = new int[500];
   @ObfuscatedName("z")
   int[] field190 = new int[500];
   @ObfuscatedName("ni")
   static class59 field192;
   @ObfuscatedName("ec")
   static ModIcon[] field194;
   @ObfuscatedName("eq")
   static SpritePixels[] field195;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -668646775
   )
   int field196 = 0;
   @ObfuscatedName("a")
   boolean field197 = true;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 598387897
   )
   static int field199;

   public void run() {
      for(; this.field197; Item.method681(50L)) {
         Object var1 = this.field187;
         synchronized(this.field187) {
            if(this.field196 < 500) {
               this.field189[this.field196] = class143.field2225;
               this.field190[this.field196] = class143.field2222;
               ++this.field196;
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IS)Z",
      garbageValue = "5200"
   )
   static boolean method164(String var0, int var1) {
      return class20.method558(var0, var1, "openjs");
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-1600174995"
   )
   static final String[] method165(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)I",
      garbageValue = "-1"
   )
   static final int method166(Widget var0, int var1) {
      if(null != var0.dynamicValues && var1 < var0.dynamicValues.length) {
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
                  var10 = class24.method600(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!MessageNode.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(1 + var11 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class179.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class158.field2361[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class179.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = WidgetNode.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class158.field2364[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class24.method600(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!MessageNode.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == 1 + var11) {
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
                  var7 = class153.method3184(var9);
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
                  var7 = class9.baseX + (WidgetNode.localPlayer.x >> 7);
               }

               if(var6 == 19) {
                  var7 = KitDefinition.baseY + (WidgetNode.localPlayer.y >> 7);
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

   @ObfuscatedName("d")
   public static String method168(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class165.field2712[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "53706370"
   )
   public static void method169(class170 var0, class170 var1) {
      class49.field1098 = var0;
      class49.field1090 = var1;
   }
}
