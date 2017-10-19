import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public abstract class class9 extends Node {
   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "[Ljo;"
   )
   static IndexedSprite[] field263;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2004882891"
   )
   public abstract void vmethod57();

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ldm;B)V",
      garbageValue = "81"
   )
   static final void method53(class117 var0) {
      var0.field1704 = false;
      if(var0.field1705 != null) {
         var0.field1705.field1737 = 0;
      }

      for(class117 var1 = var0.vmethod3966(); var1 != null; var1 = var0.vmethod3967()) {
         method53(var1);
      }

   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Lhj;II)I",
      garbageValue = "-1122492669"
   )
   static final int method52(Widget var0, int var1) {
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
                  var10 = ItemLayer.method2454(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!FaceNormal.getItemDefinition(var11).isMembers || Client.isMembers)) {
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
                  var7 = class222.field2826[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class211.widgetSettings[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = class66.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class222.field2827[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = ItemLayer.method2454(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!FaceNormal.getItemDefinition(var11).isMembers || Client.isMembers)) {
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
                  var7 = class89.method1732(var9);
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
                  var7 = (class66.localPlayer.x >> 7) + class22.baseX * 411265;
               }

               if(var6 == 19) {
                  var7 = (class66.localPlayer.y >> 7) + class273.baseY;
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

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(IIIILky;Lhh;B)V",
      garbageValue = "16"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5234(var10 + var5.field2589 / 2 - var4.maxWidth / 2, var5.field2592 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2589, var5.field2592, var5.field2594, var5.field2591);
            } else {
               var4.drawAt(var0 + var10 + var5.field2589 / 2 - var4.maxWidth / 2, var5.field2592 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1920647440"
   )
   public static int method55(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
