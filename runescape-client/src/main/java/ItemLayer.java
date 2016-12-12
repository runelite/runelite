import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2082296675
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -769451707
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 811623377
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1117874361
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @Export("top")
   Renderable top;
   @ObfuscatedName("g")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1810346735
   )
   @Export("height")
   int height;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 58297741
   )
   public static int field1220;
   @ObfuscatedName("h")
   public static boolean field1221;
   @ObfuscatedName("c")
   static int[] field1222;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 263810413
   )
   public static int field1223;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "7"
   )
   static int method1447() {
      return ++class47.field939 - 1;
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)I",
      garbageValue = "-41"
   )
   static final int method1448(Widget var0, int var1) {
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
                  var10 = class191.method3433(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class7.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(1 + var11 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class165.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class172.field2357[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class165.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class39.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class172.field2356[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class191.method3433(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class7.getItemDefinition(var11).isMembers || Client.isMembers)) {
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
                  var9 = class165.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class97.method1898(var9);
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
                  var7 = class15.baseX + (class39.localPlayer.x >> 7);
               }

               if(var6 == 19) {
                  var7 = class20.baseY + (class39.localPlayer.y >> 7);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-662671593"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2894.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class207.field3089.method3211(6, var0);
         var1 = new ObjectComposition();
         var1.field2923 = var0;
         if(var2 != null) {
            var1.method3540(new Buffer(var2));
         }

         var1.method3539();
         if(var1.field2931) {
            var1.field2909 = 0;
            var1.field2910 = false;
         }

         ObjectComposition.field2894.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1504157154"
   )
   public static int method1450(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class162.method3009(var0.charAt(var3));
      }

      return var2;
   }
}
