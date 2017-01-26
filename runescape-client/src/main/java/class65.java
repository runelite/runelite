import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class65 {
   @ObfuscatedName("k")
   int[][] field1106;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1269014299
   )
   int field1108;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1854146231
   )
   int field1109;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 1531794391
   )
   static int field1112;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "97"
   )
   int method1140(int var1) {
      if(this.field1106 != null) {
         var1 = (int)((long)this.field1109 * (long)var1 / (long)this.field1108);
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "0"
   )
   byte[] method1141(byte[] var1) {
      if(null != this.field1106) {
         int var2 = 14 + (int)((long)var1.length * (long)this.field1109 / (long)this.field1108);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1106[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1109;
            var9 = var5 / this.field1108;
            var4 += var9;
            var5 -= this.field1108 * var9;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = '耀' + var3[var6] >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1070239373"
   )
   public static final boolean method1142() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1701 == class105.field1718) {
            return false;
         } else {
            class109.field1744 = class105.field1713[class105.field1701];
            VertexNormal.field1424 = class105.field1706[class105.field1701];
            class105.field1701 = class105.field1701 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1759377212"
   )
   int method1145(int var1) {
      if(null != this.field1106) {
         var1 = (int)((long)var1 * (long)this.field1109 / (long)this.field1108) + 6;
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1833872022"
   )
   public static void method1151(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   public class65(int var1, int var2) {
      if(var1 != var2) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1108 = var1;
         this.field1109 = var2;
         this.field1106 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1106[var7];
            double var9 = 6.0D + (double)var7 / (double)var1;
            int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(var9 + 7.0D);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = ((double)var11 - var9) * 3.141592653589793D;
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(0.5D + var17 * 65536.0D);
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-608879927"
   )
   public static void method1152(class182 var0) {
      Overlay.field3037 = var0;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "51430560"
   )
   static final int method1153(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class10.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class10.tileHeights[var5][var3 + 1][var4] + class10.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = (128 - var6) * class10.tileHeights[var5][var3][1 + var4] + class10.tileHeights[var5][1 + var3][var4 + 1] * var6 >> 7;
         return var9 * var7 + (128 - var7) * var8 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-66"
   )
   static final void method1154() {
      int var0;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(class103.method1973(var0)) {
            class161.method3079(Widget.widgets[var0], -1);
         }
      }

      for(var0 = 0; var0 < Client.field480; ++var0) {
         if(Client.field482[var0]) {
            Client.field483[var0] = true;
         }

         Client.field484[var0] = Client.field482[var0];
         Client.field482[var0] = false;
      }

      Client.field481 = Client.gameCycle;
      Client.field425 = -1;
      Client.field426 = -1;
      class39.field802 = null;
      int var1;
      int var2;
      int var3;
      if(Client.widgetRoot != -1) {
         Client.field480 = 0;
         var0 = Client.widgetRoot;
         var1 = class26.field577;
         var2 = class187.field2776;
         if(!class103.method1973(var0)) {
            for(var3 = 0; var3 < 100; ++var3) {
               Client.field482[var3] = true;
            }
         } else {
            class99.field1648 = null;
            class36.gameDraw(Widget.widgets[var0], -1, 0, 0, var1, var2, 0, 0, -1);
            if(null != class99.field1648) {
               class36.gameDraw(class99.field1648, -1412584499, 0, 0, var1, var2, class26.field588, class37.field785, -1);
               class99.field1648 = null;
            }
         }
      }

      Rasterizer2D.method4037();
      if(!Client.isMenuOpen) {
         if(Client.field425 != -1) {
            var0 = Client.field425;
            var1 = Client.field426;
            if(Client.menuOptionCount >= 2 || Client.field429 != 0 || Client.field432) {
               String var11;
               if(Client.field429 == 1 && Client.menuOptionCount < 2) {
                  var11 = "Use" + " " + Client.field431 + " " + "->";
               } else if(Client.field432 && Client.menuOptionCount < 2) {
                  var11 = Client.field406 + " " + Client.field436 + " " + "->";
               } else {
                  var11 = Client.method569(Client.menuOptionCount - 1);
               }

               if(Client.menuOptionCount > 2) {
                  var11 = var11 + Client.method568(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
               }

               Tile.field1346.method3952(var11, var0 + 4, 15 + var1, 16777215, 0, Client.gameCycle / 1000);
            }
         }
      } else {
         class99.method1939();
      }

      if(Client.field489 == 3) {
         for(var0 = 0; var0 < Client.field480; ++var0) {
            if(Client.field484[var0]) {
               Rasterizer2D.method3990(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field483[var0]) {
               Rasterizer2D.method3990(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      var0 = WallObject.plane;
      var1 = class16.localPlayer.x;
      var2 = class16.localPlayer.y;
      var3 = Client.field354;

      for(class31 var4 = (class31)class31.field711.method2412(); var4 != null; var4 = (class31)class31.field711.method2426()) {
         if(var4.field704 != -1 || null != var4.field700) {
            int var5 = 0;
            if(var1 > var4.field698) {
               var5 += var1 - var4.field698;
            } else if(var1 < var4.field696) {
               var5 += var4.field696 - var1;
            }

            if(var2 > var4.field699) {
               var5 += var2 - var4.field699;
            } else if(var2 < var4.field697) {
               var5 += var4.field697 - var2;
            }

            if(var5 - 64 <= var4.field709 && Client.field518 != 0 && var0 == var4.field707) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = Client.field518 * (var4.field709 - var5) / var4.field709;
               Object var10000;
               if(null == var4.field702) {
                  if(var4.field704 >= 0) {
                     var10000 = null;
                     class53 var12 = class53.method957(class150.field2044, var4.field704, 0);
                     if(null != var12) {
                        class55 var8 = var12.method955().method995(class187.field2769);
                        class66 var9 = class66.method1214(var8, 100, var6);
                        var9.method1162(-1);
                        CombatInfoListHolder.field753.method898(var9);
                        var4.field702 = var9;
                     }
                  }
               } else {
                  var4.field702.method1163(var6);
               }

               if(var4.field706 == null) {
                  if(var4.field700 != null && (var4.field701 -= var3) <= 0) {
                     int var7 = (int)(Math.random() * (double)var4.field700.length);
                     var10000 = null;
                     class53 var13 = class53.method957(class150.field2044, var4.field700[var7], 0);
                     if(null != var13) {
                        class55 var14 = var13.method955().method995(class187.field2769);
                        class66 var10 = class66.method1214(var14, 100, var6);
                        var10.method1162(0);
                        CombatInfoListHolder.field753.method898(var10);
                        var4.field706 = var10;
                        var4.field701 = var4.field703 + (int)(Math.random() * (double)(var4.field695 - var4.field703));
                     }
                  }
               } else {
                  var4.field706.method1163(var6);
                  if(!var4.field706.linked()) {
                     var4.field706 = null;
                  }
               }
            } else {
               if(var4.field702 != null) {
                  CombatInfoListHolder.field753.method899(var4.field702);
                  var4.field702 = null;
               }

               if(var4.field706 != null) {
                  CombatInfoListHolder.field753.method899(var4.field706);
                  var4.field706 = null;
               }
            }
         }
      }

      Client.field354 = 0;
   }
}
