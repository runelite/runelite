import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class11 {
   @ObfuscatedName("h")
   static final class198 field171 = new class198(1024);
   @ObfuscatedName("m")
   static final class200 field172 = new class200();
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1342156881
   )
   static int field173 = 0;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -900512167
   )
   static int field174;
   @ObfuscatedName("w")
   public static String field176;
   @ObfuscatedName("j")
   static final Map field178 = new HashMap();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1371297365"
   )
   static final void method152() {
      class137.method2897();
      class19.method230();
      class19.method240();
      class40.field932.method3707();
      class40.field908.method3707();
      class40.field909.method3707();
      class40.field910.method3707();
      class34.method715();
      class0.method2();
      class175.method3413();
      class8.method120();
      class47.field1047.method3707();
      class52.field1141.method3707();
      class28.method649();
      class173.field2791.method3707();
      class173.field2739.method3707();
      class173.field2740.method3707();
      class173.field2849.method3707();
      ((class95)class91.field1566).method2179();
      class22.field572.method3707();
      class101.field1738.method3238();
      class26.field646.method3238();
      class28.field659.method3238();
      class101.field1741.method3238();
      class158.field2578.method3238();
      class135.field2069.method3238();
      class26.field628.method3238();
      class178.field2917.method3238();
      class22.field582.method3238();
      client.field306.method3238();
      class136.field2080.method3238();
      class104.field1776.method3238();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;I)V",
      garbageValue = "336124421"
   )
   static void method153(class224 var0, class224 var1) {
      if(class31.field718 == null) {
         class31.field718 = class95.method2186(class178.field2917, "sl_back", "");
      }

      if(class3.field68 == null) {
         class3.field68 = class34.method722(class178.field2917, "sl_flags", "");
      }

      if(null == class75.field1359) {
         class75.field1359 = class34.method722(class178.field2917, "sl_arrows", "");
      }

      if(class26.field642 == null) {
         class26.field642 = class34.method722(class178.field2917, "sl_stars", "");
      }

      class79.method1783(class31.field696, 23, 765, 480, 0);
      class79.method1788(class31.field696, 0, 125, 23, 12425273, 9135624);
      class79.method1788(class31.field696 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4007("Select a world", 62 + class31.field696, 15, 0, -1);
      if(class26.field642 != null) {
         class26.field642[1].method1867(class31.field696 + 140, 1);
         var1.method4006("Members only world", class31.field696 + 152, 10, 16777215, -1);
         class26.field642[0].method1867(140 + class31.field696, 12);
         var1.method4006("Free world", 152 + class31.field696, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class75.field1359 != null) {
         int var2 = class31.field696 + 280;
         if(class25.field617[0] == 0 && class25.field622[0] == 0) {
            class75.field1359[2].method1867(var2, 4);
         } else {
            class75.field1359[0].method1867(var2, 4);
         }

         if(class25.field617[0] == 0 && class25.field622[0] == 1) {
            class75.field1359[3].method1867(var2 + 15, 4);
         } else {
            class75.field1359[1].method1867(15 + var2, 4);
         }

         var0.method4006("World", var2 + 32, 17, 16777215, -1);
         int var3 = 390 + class31.field696;
         if(1 == class25.field617[0] && class25.field622[0] == 0) {
            class75.field1359[2].method1867(var3, 4);
         } else {
            class75.field1359[0].method1867(var3, 4);
         }

         if(class25.field617[0] == 1 && class25.field622[0] == 1) {
            class75.field1359[3].method1867(var3 + 15, 4);
         } else {
            class75.field1359[1].method1867(15 + var3, 4);
         }

         var0.method4006("Players", 32 + var3, 17, 16777215, -1);
         var4 = 500 + class31.field696;
         if(2 == class25.field617[0] && class25.field622[0] == 0) {
            class75.field1359[2].method1867(var4, 4);
         } else {
            class75.field1359[0].method1867(var4, 4);
         }

         if(class25.field617[0] == 2 && class25.field622[0] == 1) {
            class75.field1359[3].method1867(var4 + 15, 4);
         } else {
            class75.field1359[1].method1867(15 + var4, 4);
         }

         var0.method4006("Location", 32 + var4, 17, 16777215, -1);
         var5 = 610 + class31.field696;
         if(class25.field617[0] == 3 && class25.field622[0] == 0) {
            class75.field1359[2].method1867(var5, 4);
         } else {
            class75.field1359[0].method1867(var5, 4);
         }

         if(3 == class25.field617[0] && 1 == class25.field622[0]) {
            class75.field1359[3].method1867(var5 + 15, 4);
         } else {
            class75.field1359[1].method1867(var5 + 15, 4);
         }

         var0.method4006("Type", 32 + var5, 17, 16777215, -1);
      }

      class79.method1783(708 + class31.field696, 4, 50, 16, 0);
      var1.method4007("Cancel", 708 + class31.field696 + 25, 16, 16777215, -1);
      class31.field717 = -1;
      if(class31.field718 != null) {
         byte var21 = 88;
         byte var23 = 19;
         var4 = 765 / (var21 + 1);
         var5 = 480 / (1 + var23);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= class25.field614) {
               --var4;
            }

            if((var5 - 1) * var4 >= class25.field614) {
               --var5;
            }

            if(var4 * (var5 - 1) >= class25.field614) {
               --var5;
            }
         } while(var5 != var6 || var7 != var4);

         var6 = (765 - var21 * var4) / (1 + var4);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var23) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var21 * var4 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var5 * var23 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class31.field696;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < class25.field614; ++var14) {
            class25 var15 = class25.field616[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.field625);
            if(var15.field625 == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.field625 > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method604()) {
               if(var15.method599()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method620()) {
               var19 = 16711680;
               if(var15.method599()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method605()) {
               if(var15.method599()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method599()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class140.field2128 >= var11 && class140.field2126 >= var10 && class140.field2128 < var11 + var21 && class140.field2126 < var23 + var10 && var16) {
               class31.field717 = var14;
               class31.field718[var18].method1704(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class31.field718[var18].method1698(var11, var10);
            }

            if(null != class3.field68) {
               class3.field68[(var15.method599()?8:0) + var15.field623].method1867(var11 + 29, var10);
            }

            var0.method4007(Integer.toString(var15.field618), 15 + var11, 5 + var23 / 2 + var10, var19, -1);
            var1.method4007(var17, 60 + var11, 5 + var23 / 2 + var10, 268435455, -1);
            var10 += var23 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var21 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4002(class25.field616[class31.field717].field620) + 6;
            int var24 = 8 + var1.field3192;
            class79.method1783(class140.field2128 - var14 / 2, 20 + class140.field2126 + 5, var14, var24, 16777120);
            class79.method1801(class140.field2128 - var14 / 2, 5 + 20 + class140.field2126, var14, var24, 0);
            var1.method4007(class25.field616[class31.field717].field620, class140.field2128, 4 + var1.field3192 + 5 + 20 + class140.field2126, 0, -1);
         }
      }

      try {
         Graphics var22 = class3.field66.getGraphics();
         class75.field1363.vmethod1873(var22, 0, 0);
      } catch (Exception var20) {
         class3.field66.repaint();
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static final void method154(int var0) {
      int[] var1 = class25.field621.field1392;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if(0 == (class5.field84[var0][var5][var3] & 24)) {
               class35.field771.method1939(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && 0 != (class5.field84[var0 + 1][var5][var3] & 8)) {
               class35.field771.method1939(var1, var4, 512, 1 + var0, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class25.field621.method1705();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class5.field84[var0][var6][var5] & 24) == 0) {
               class113.method2432(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class5.field84[var0 + 1][var6][var5] & 8) != 0) {
               class113.method2432(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      client.field503 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class35.field771.method1934(class28.field655, var5, var6);
            if(0 != var7) {
               var7 = var7 >> 14 & 32767;
               int var8 = class85.method1903(var7).field933;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && 29 != var8 && 34 != var8 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = client.field482[class28.field655].field1879;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(1 == var15 && var9 < 103 && var9 < 3 + var5 && (var13[var9 + 1][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(3 == var15 && var10 < 103 && var10 < 3 + var6 && (var13[var9][var10 + 1] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  client.field506[client.field503] = class101.field1726[var8];
                  client.field474[client.field503] = var9;
                  client.field450[client.field503] = var10;
                  ++client.field503;
               }
            }
         }
      }

      class75.field1363.method1678();
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "-1876577038"
   )
   static final boolean method155(class173 var0) {
      int var1 = var0.field2748;
      if(var1 == 205) {
         client.field305 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field546.method3456(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field546.method3440(var2, var3 == 1);
         }

         if(324 == var1) {
            client.field546.method3439(false);
         }

         if(var1 == 325) {
            client.field546.method3439(true);
         }

         if(326 == var1) {
            client.field318.method2735(222);
            client.field546.method3442(client.field318);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "218817058"
   )
   static final void method156(int var0, int var1) {
      class199 var2 = client.field364[class28.field655][var0][var1];
      if(var2 == null) {
         class35.field771.method1926(class28.field655, var0, var1);
      } else {
         long var3 = -99999999L;
         class28 var5 = null;

         class28 var6;
         for(var6 = (class28)var2.method3784(); var6 != null; var6 = (class28)var2.method3777()) {
            class51 var7 = class89.method2081(var6.field662);
            long var8 = (long)var7.field1107;
            if(var7.field1106 == 1) {
               var8 *= (long)(1 + var6.field658);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class35.field771.method1926(class28.field655, var0, var1);
         } else {
            var2.method3780(var5);
            class28 var10 = null;
            class28 var11 = null;

            for(var6 = (class28)var2.method3784(); null != var6; var6 = (class28)var2.method3777()) {
               if(var6.field662 != var5.field662) {
                  if(null == var10) {
                     var10 = var6;
                  }

                  if(var10.field662 != var6.field662 && var11 == null) {
                     var11 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class35.field771.method1912(class28.field655, var0, var1, class148.method3106(128 * var0 + 64, 64 + 128 * var1, class28.field655), var5, var9, var10, var11);
         }
      }
   }
}
