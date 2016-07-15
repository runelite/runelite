import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("Item")
public final class class30 extends class88 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -82821079
   )
   @Export("quantity")
   int field715;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -754048363
   )
   @Export("id")
   int field717;
   @ObfuscatedName("ec")
   static class81 field719;
   @ObfuscatedName("a")
   @Export("isMembersWorld")
   public static boolean field721;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1520690947
   )
   public static int field722;
   @ObfuscatedName("i")
   static class176 field725;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2097848935
   )
   public static int field726;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "1416493334"
   )
   public static void method660(class170 var0, class170 var1) {
      class46.field1063 = var0;
      class46.field1060 = var1;
      class46.field1061 = class46.field1063.method3352(3);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-2017557153"
   )
   protected final class108 vmethod1999() {
      return class9.method108(this.field717).method1160(this.field715);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "66"
   )
   public static void method665() {
      if(null != class174.field2760) {
         class174.field2760.method3088();
      }

   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIII)V",
      garbageValue = "-1392661729"
   )
   static final void method666(class176 var0, int var1, int var2, int var3) {
      class110.method2469();
      class178 var4 = var0.method3493(false);
      if(var4 != null) {
         class82.method1934(var1, var2, var1 + var4.field2940, var2 + var4.field2938);
         if(client.field531 != 2 && client.field531 != 5) {
            int var5 = client.field365 + client.field514 & 2047;
            int var6 = class118.field2035.field896 / 32 + 48;
            int var7 = 464 - class118.field2035.field879 / 32;
            class33.field793.method1812(var1, var2, var4.field2940, var4.field2938, var6, var7, var5, 256 + client.field327, var4.field2937, var4.field2939);

            int var8;
            int var10;
            int var18;
            for(var8 = 0; var8 < client.field525; ++var8) {
               var18 = 4 * client.field526[var8] + 2 - class118.field2035.field896 / 32;
               var10 = client.field527[var8] * 4 + 2 - class118.field2035.field879 / 32;
               class51.method1121(var1, var2, var18, var10, client.field528[var8], var4);
            }

            int var12;
            int var19;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var18 = 0; var18 < 104; ++var18) {
                  class202 var17 = client.field426[class50.field1119][var8][var18];
                  if(null != var17) {
                     var19 = 2 + var8 * 4 - class118.field2035.field896 / 32;
                     var12 = 4 * var18 + 2 - class118.field2035.field879 / 32;
                     class51.method1121(var1, var2, var19, var12, client.field390[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < client.field332; ++var8) {
               class36 var9 = client.field331[client.field333[var8]];
               if(null != var9 && var9.vmethod787()) {
                  class41 var22 = var9.field825;
                  if(null != var22 && var22.field948 != null) {
                     var22 = var22.method824();
                  }

                  if(null != var22 && var22.field939 && var22.field947) {
                     var19 = var9.field896 / 32 - class118.field2035.field896 / 32;
                     var12 = var9.field879 / 32 - class118.field2035.field879 / 32;
                     class51.method1121(var1, var2, var19, var12, client.field390[1], var4);
                  }
               }
            }

            var8 = class34.field804;
            int[] var20 = class34.field807;

            for(var10 = 0; var10 < var8; ++var10) {
               class2 var11 = client.field467[var20[var10]];
               if(null != var11 && var11.vmethod787() && !var11.field51 && class118.field2035 != var11) {
                  var12 = var11.field896 / 32 - class118.field2035.field896 / 32;
                  int var13 = var11.field879 / 32 - class118.field2035.field879 / 32;
                  boolean var14 = false;
                  if(class75.method1669(var11.field52, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class21.field596; ++var16) {
                     if(var11.field52.equals(class22.field603[var16].field646)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var21 = false;
                  if(class118.field2035.field49 != 0 && var11.field49 != 0 && class118.field2035.field49 == var11.field49) {
                     var21 = true;
                  }

                  if(var14) {
                     class51.method1121(var1, var2, var12, var13, client.field390[3], var4);
                  } else if(var21) {
                     class51.method1121(var1, var2, var12, var13, client.field390[4], var4);
                  } else if(var15) {
                     class51.method1121(var1, var2, var12, var13, client.field390[5], var4);
                  } else {
                     class51.method1121(var1, var2, var12, var13, client.field390[2], var4);
                  }
               }
            }

            if(client.field294 != 0 && client.field567 % 20 < 10) {
               if(client.field294 == 1 && client.field312 >= 0 && client.field312 < client.field331.length) {
                  class36 var23 = client.field331[client.field312];
                  if(null != var23) {
                     var19 = var23.field896 / 32 - class118.field2035.field896 / 32;
                     var12 = var23.field879 / 32 - class118.field2035.field879 / 32;
                     class19.method211(var1, var2, var19, var12, class136.field2122[1], var4);
                  }
               }

               if(client.field294 == 2) {
                  var10 = client.field314 * 4 - class19.field286 * 4 + 2 - class118.field2035.field896 / 32;
                  var19 = 2 + (client.field341 * 4 - class6.field128 * 4) - class118.field2035.field879 / 32;
                  class19.method211(var1, var2, var10, var19, class136.field2122[1], var4);
               }

               if(client.field294 == 10 && client.field313 >= 0 && client.field313 < client.field467.length) {
                  class2 var24 = client.field467[client.field313];
                  if(null != var24) {
                     var19 = var24.field896 / 32 - class118.field2035.field896 / 32;
                     var12 = var24.field879 / 32 - class118.field2035.field879 / 32;
                     class19.method211(var1, var2, var19, var12, class136.field2122[1], var4);
                  }
               }
            }

            if(client.field529 != 0) {
               var10 = client.field529 * 4 + 2 - class118.field2035.field896 / 32;
               var19 = 2 + client.field530 * 4 - class118.field2035.field879 / 32;
               class51.method1121(var1, var2, var10, var19, class136.field2122[0], var4);
            }

            if(!class118.field2035.field51) {
               class82.method1911(var4.field2940 / 2 + var1 - 1, var4.field2938 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            class82.method1886(var1, var2, 0, var4.field2937, var4.field2939);
         }

         client.field501[var3] = true;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILclass110;Lclass111;I)Z",
      garbageValue = "1919716726"
   )
   public static final boolean method668(int var0, int var1, class110 var2, class111 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class109.field1942[var6][var7] = 99;
      class109.field1943[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class109.field1944[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class109.field1945[var10001] = var1;
      int[][] var12 = var3.field1969;

      while(var18 != var11) {
         var4 = class109.field1944[var11];
         var5 = class109.field1945[var11];
         var11 = 1 + var11 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1965;
         int var14 = var5 - var3.field1966;
         if(var2.vmethod2464(2, var4, var5, var3)) {
            field722 = var4;
            class127.field2088 = var5;
            return true;
         }

         int var15 = 1 + class109.field1943[var16][var17];
         if(var16 > 0 && class109.field1942[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][1 + var14] & 19136824) == 0) {
            class109.field1944[var18] = var4 - 1;
            class109.field1945[var18] = var5;
            var18 = 1 + var18 & 4095;
            class109.field1942[var16 - 1][var17] = 2;
            class109.field1943[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class109.field1942[var16 + 1][var17] == 0 && (var12[2 + var13][var14] & 19136899) == 0 && (var12[2 + var13][1 + var14] & 19136992) == 0) {
            class109.field1944[var18] = var4 + 1;
            class109.field1945[var18] = var5;
            var18 = 1 + var18 & 4095;
            class109.field1942[var16 + 1][var17] = 8;
            class109.field1943[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class109.field1942[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class109.field1944[var18] = var4;
            class109.field1945[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1942[var16][var17 - 1] = 1;
            class109.field1943[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class109.field1942[var16][1 + var17] == 0 && (var12[var13][2 + var14] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class109.field1944[var18] = var4;
            class109.field1945[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class109.field1942[var16][var17 + 1] = 4;
            class109.field1943[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class109.field1942[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class109.field1944[var18] = var4 - 1;
            class109.field1945[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1942[var16 - 1][var17 - 1] = 3;
            class109.field1943[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class109.field1942[1 + var16][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[2 + var13][var14 - 1] & 19136899) == 0 && (var12[2 + var13][var14] & 19136995) == 0) {
            class109.field1944[var18] = 1 + var4;
            class109.field1945[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1942[1 + var16][var17 - 1] = 9;
            class109.field1943[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class109.field1942[var16 - 1][1 + var17] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][2 + var14] & 19137016) == 0) {
            class109.field1944[var18] = var4 - 1;
            class109.field1945[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class109.field1942[var16 - 1][var17 + 1] = 6;
            class109.field1943[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class109.field1942[1 + var16][var17 + 1] == 0 && (var12[1 + var13][var14 + 2] & 19137016) == 0 && (var12[2 + var13][var14 + 2] & 19136992) == 0 && (var12[2 + var13][1 + var14] & 19136995) == 0) {
            class109.field1944[var18] = var4 + 1;
            class109.field1945[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class109.field1942[1 + var16][var17 + 1] = 12;
            class109.field1943[var16 + 1][var17 + 1] = var15;
         }
      }

      field722 = var4;
      class127.field2088 = var5;
      return false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;B)V",
      garbageValue = "12"
   )
   static void method669(class227 var0, class227 var1) {
      if(class29.field708 == null) {
         class29.field708 = class85.method1983(class230.field3263, "sl_back", "");
      }

      if(null == class8.field154) {
         class8.field154 = class178.method3539(class230.field3263, "sl_flags", "");
      }

      if(class188.field3041 == null) {
         class188.field3041 = class178.method3539(class230.field3263, "sl_arrows", "");
      }

      if(class77.field1436 == null) {
         class77.field1436 = class178.method3539(class230.field3263, "sl_stars", "");
      }

      class82.method1911(class33.field758, 23, 765, 480, 0);
      class82.method1894(class33.field758, 0, 125, 23, 12425273, 9135624);
      class82.method1894(class33.field758 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4119("Select a world", class33.field758 + 62, 15, 0, -1);
      if(class77.field1436 != null) {
         class77.field1436[1].method1952(140 + class33.field758, 1);
         var1.method4177("Members only world", 152 + class33.field758, 10, 16777215, -1);
         class77.field1436[0].method1952(class33.field758 + 140, 12);
         var1.method4177("Free world", class33.field758 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(null != class188.field3041) {
         int var2 = class33.field758 + 280;
         if(class27.field681[0] == 0 && class27.field675[0] == 0) {
            class188.field3041[2].method1952(var2, 4);
         } else {
            class188.field3041[0].method1952(var2, 4);
         }

         if(class27.field681[0] == 0 && class27.field675[0] == 1) {
            class188.field3041[3].method1952(var2 + 15, 4);
         } else {
            class188.field3041[1].method1952(var2 + 15, 4);
         }

         var0.method4177("World", var2 + 32, 17, 16777215, -1);
         int var3 = 390 + class33.field758;
         if(class27.field681[0] == 1 && class27.field675[0] == 0) {
            class188.field3041[2].method1952(var3, 4);
         } else {
            class188.field3041[0].method1952(var3, 4);
         }

         if(class27.field681[0] == 1 && class27.field675[0] == 1) {
            class188.field3041[3].method1952(var3 + 15, 4);
         } else {
            class188.field3041[1].method1952(var3 + 15, 4);
         }

         var0.method4177("Players", 32 + var3, 17, 16777215, -1);
         var4 = class33.field758 + 500;
         if(class27.field681[0] == 2 && class27.field675[0] == 0) {
            class188.field3041[2].method1952(var4, 4);
         } else {
            class188.field3041[0].method1952(var4, 4);
         }

         if(class27.field681[0] == 2 && class27.field675[0] == 1) {
            class188.field3041[3].method1952(var4 + 15, 4);
         } else {
            class188.field3041[1].method1952(var4 + 15, 4);
         }

         var0.method4177("Location", var4 + 32, 17, 16777215, -1);
         var5 = class33.field758 + 610;
         if(class27.field681[0] == 3 && class27.field675[0] == 0) {
            class188.field3041[2].method1952(var5, 4);
         } else {
            class188.field3041[0].method1952(var5, 4);
         }

         if(class27.field681[0] == 3 && class27.field675[0] == 1) {
            class188.field3041[3].method1952(15 + var5, 4);
         } else {
            class188.field3041[1].method1952(15 + var5, 4);
         }

         var0.method4177("Type", var5 + 32, 17, 16777215, -1);
      }

      class82.method1911(class33.field758 + 708, 4, 50, 16, 0);
      var1.method4119("Cancel", 25 + 708 + class33.field758, 16, 16777215, -1);
      class33.field792 = -1;
      if(class29.field708 != null) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (var23 + 1);
         var5 = 480 / (1 + var24);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= class27.field673) {
               --var4;
            }

            if(var4 * (var5 - 1) >= class27.field673) {
               --var5;
            }

            if(var4 * (var5 - 1) >= class27.field673) {
               --var5;
            }
         } while(var5 != var6 || var4 != var7);

         var6 = (765 - var4 * var23) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var24 * var5) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var24 * var5 - var7 * (var5 - 1)) / 2;
         int var10 = 23 + var9;
         int var11 = class33.field758 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < class27.field673; ++var14) {
            class27 var15 = class118.field2032[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.field677);
            if(var15.field677 == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.field677 > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method609()) {
               if(var15.method604()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method608()) {
               var19 = 16711680;
               if(var15.method604()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method606()) {
               if(var15.method604()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method604()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class143.field2198 >= var11 && class143.field2201 >= var10 && class143.field2198 < var11 + var23 && class143.field2201 < var24 + var10 && var16) {
               class33.field792 = var14;
               class29.field708[var18].method1832(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class29.field708[var18].method1800(var11, var10);
            }

            if(class8.field154 != null) {
               class8.field154[(var15.method604()?8:0) + var15.field683].method1952(29 + var11, var10);
            }

            var0.method4119(Integer.toString(var15.field674), var11 + 15, 5 + var24 / 2 + var10, var19, -1);
            var1.method4119(var17, var11 + 60, var24 / 2 + var10 + 5, 268435455, -1);
            var10 += var24 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var23 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4179(class118.field2032[class33.field792].field682) + 6;
            int var20 = 8 + var1.field3242;
            class82.method1911(class143.field2198 - var14 / 2, 5 + class143.field2201 + 20, var14, var20, 16777120);
            class82.method1925(class143.field2198 - var14 / 2, 5 + class143.field2201 + 20, var14, var20, 0);
            var1.method4119(class118.field2032[class33.field792].field682, class143.field2198, 4 + 5 + class143.field2201 + 20 + var1.field3242, 0, -1);
         }
      }

      try {
         Graphics var21 = class158.field2346.getGraphics();
         class44.field1039.vmethod1975(var21, 0, 0);
      } catch (Exception var22) {
         class158.field2346.repaint();
      }

   }
}
