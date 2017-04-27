import java.awt.Graphics;
import java.awt.datatransfer.Clipboard;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
final class class3 implements Comparator {
   @ObfuscatedName("qb")
   protected static java.awt.Frame field26;
   @ObfuscatedName("pb")
   static Clipboard field28;
   @ObfuscatedName("r")
   public static class61 field32;
   @ObfuscatedName("b")
   public static String field34;
   @ObfuscatedName("x")
   public static Buffer field35;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 596924759
   )
   static int field36;

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)I",
      garbageValue = "-100"
   )
   static final int method28(Widget var0, int var1) {
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
                  var10 = class128.method2364(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class47.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class167.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class174.field2355[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class167.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class22.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class174.field2354[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class128.method2364(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class47.getItemDefinition(var11).isMembers || Client.isMembers)) {
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
                  var9 = class167.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class59.method1140(var9);
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
                  var7 = (class22.localPlayer.x >> 7) + class108.baseX;
               }

               if(var6 == 19) {
                  var7 = GameEngine.baseY + (class22.localPlayer.y >> 7);
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
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "106977904"
   )
   int method29(class2 var1, class2 var2) {
      return var1.field21.totalQuantity < var2.field21.totalQuantity?-1:(var1.field21.totalQuantity == var2.field21.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;I)V",
      garbageValue = "629945973"
   )
   static void method40(Font var0, Font var1) {
      if(Client.field569 == null) {
         Client.field569 = ObjectComposition.method3734(WallObject.indexSprites, "sl_back", "");
      }

      if(class33.field744 == null) {
         class33.field744 = class210.method4011(WallObject.indexSprites, "sl_flags", "");
      }

      if(class109.field1735 == null) {
         class109.field1735 = class210.method4011(WallObject.indexSprites, "sl_arrows", "");
      }

      if(class118.field1840 == null) {
         class118.field1840 = class210.method4011(WallObject.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.method4089(class41.field821, 23, 765, 480, 0);
      Rasterizer2D.method4094(class41.field821, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method4094(class41.field821 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method3944("Select a world", class41.field821 + 62, 15, 0, -1);
      if(class118.field1840 != null) {
         class118.field1840[1].method4170(class41.field821 + 140, 1);
         var1.method3914("Members only world", class41.field821 + 152, 10, 16777215, -1);
         class118.field1840[0].method4170(class41.field821 + 140, 12);
         var1.method3914("Free world", class41.field821 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class109.field1735 != null) {
         int var2 = class41.field821 + 280;
         if(World.field676[0] == 0 && World.field675[0] == 0) {
            class109.field1735[2].method4170(var2, 4);
         } else {
            class109.field1735[0].method4170(var2, 4);
         }

         if(World.field676[0] == 0 && World.field675[0] == 1) {
            class109.field1735[3].method4170(var2 + 15, 4);
         } else {
            class109.field1735[1].method4170(var2 + 15, 4);
         }

         var0.method3914("World", var2 + 32, 17, 16777215, -1);
         int var3 = class41.field821 + 390;
         if(World.field676[0] == 1 && World.field675[0] == 0) {
            class109.field1735[2].method4170(var3, 4);
         } else {
            class109.field1735[0].method4170(var3, 4);
         }

         if(World.field676[0] == 1 && World.field675[0] == 1) {
            class109.field1735[3].method4170(var3 + 15, 4);
         } else {
            class109.field1735[1].method4170(var3 + 15, 4);
         }

         var0.method3914("Players", var3 + 32, 17, 16777215, -1);
         var4 = class41.field821 + 500;
         if(World.field676[0] == 2 && World.field675[0] == 0) {
            class109.field1735[2].method4170(var4, 4);
         } else {
            class109.field1735[0].method4170(var4, 4);
         }

         if(World.field676[0] == 2 && World.field675[0] == 1) {
            class109.field1735[3].method4170(var4 + 15, 4);
         } else {
            class109.field1735[1].method4170(var4 + 15, 4);
         }

         var0.method3914("Location", var4 + 32, 17, 16777215, -1);
         var5 = class41.field821 + 610;
         if(World.field676[0] == 3 && World.field675[0] == 0) {
            class109.field1735[2].method4170(var5, 4);
         } else {
            class109.field1735[0].method4170(var5, 4);
         }

         if(World.field676[0] == 3 && World.field675[0] == 1) {
            class109.field1735[3].method4170(var5 + 15, 4);
         } else {
            class109.field1735[1].method4170(var5 + 15, 4);
         }

         var0.method3914("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method4089(class41.field821 + 708, 4, 50, 16, 0);
      var1.method3944("Cancel", class41.field821 + 708 + 25, 16, 16777215, -1);
      class41.field812 = -1;
      if(Client.field569 != null) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (var23 + 1);
         var5 = 480 / (var24 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= World.field669) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.field669) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.field669) {
               --var5;
            }
         } while(var6 != var5 || var4 != var7);

         var6 = (765 - var23 * var4) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var24 * var5) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var24 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = class41.field821 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field669; ++var14) {
            World var15 = World.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method608()) {
               if(var15.method603()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method618()) {
               var19 = 16711680;
               if(var15.method603()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method605()) {
               if(var15.method603()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method603()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class115.field1805 >= var11 && class115.field1806 >= var10 && class115.field1805 < var23 + var11 && class115.field1806 < var24 + var10 && var16) {
               class41.field812 = var14;
               Client.field569[var18].method4234(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               Client.field569[var18].method4295(var11, var10);
            }

            if(class33.field744 != null) {
               class33.field744[(var15.method603()?8:0) + var15.location].method4170(var11 + 29, var10);
            }

            var0.method3944(Integer.toString(var15.id), var11 + 15, var24 / 2 + var10 + 5, var19, -1);
            var1.method3944(var17, var11 + 60, var10 + var24 / 2 + 5, 268435455, -1);
            var10 += var24 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 += var6 + var23;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method3904(World.worldList[class41.field812].activity) + 6;
            int var20 = var1.field3111 + 8;
            Rasterizer2D.method4089(class115.field1805 - var14 / 2, class115.field1806 + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.method4095(class115.field1805 - var14 / 2, class115.field1806 + 20 + 5, var14, var20, 0);
            var1.method3944(World.worldList[class41.field812].activity, class115.field1805, var1.field3111 + class115.field1806 + 20 + 5 + 4, 0, -1);
         }
      }

      try {
         Graphics var21 = class65.canvas.getGraphics();
         class88.bufferProvider.draw(var21, 0, 0);
      } catch (Exception var22) {
         class65.canvas.repaint();
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method29((class2)var1, (class2)var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-285280576"
   )
   public static int method41(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field1956[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
