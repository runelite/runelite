import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("GameObject")
public final class class98 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 489966885
   )
   @Export("hash")
   public int field1668 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -27250967
   )
   @Export("height")
   int field1669;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1157615937
   )
   @Export("relativeX")
   int field1670;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -67063189
   )
   @Export("y")
   int field1671;
   @ObfuscatedName("d")
   @Export("renderable")
   public class85 field1672;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 517112331
   )
   @Export("orientation")
   int field1673;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1226711073
   )
   @Export("offsetX")
   int field1674;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 947115613
   )
   @Export("plane")
   int field1675;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 512822133
   )
   @Export("flags")
   int field1676 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 468232911
   )
   @Export("offsetY")
   int field1677;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1920831419
   )
   int field1678;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1611143229
   )
   int field1679;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -389358117
   )
   @Export("x")
   int field1680;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1853777573
   )
   @Export("relativeY")
   int field1681;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -2101067539
   )
   protected static int field1682;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-868561920"
   )
   static void method2176() {
      int var0;
      if(client.field306 == 0) {
         client.field339 = new class86(4, 104, 104, class5.field93);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field340[var0] = new class108(104, 104);
         }

         class74.field1370 = new class78(512, 512);
         class31.field731 = "Starting game engine...";
         class31.field730 = 5;
         client.field306 = 20;
      } else {
         int var1;
         int var3;
         int var4;
         int var21;
         if(20 == client.field306) {
            int[] var35 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var21 = 32 * var1 + 128 + 15;
               var3 = var21 * 3 + 600;
               var4 = class91.field1596[var21];
               var35[var1] = var3 * var4 >> 16;
            }

            class86.method2002(var35, 500, 800, 512, 334);
            class31.field731 = "Prepared visibility map";
            class31.field730 = 10;
            client.field306 = 30;
         } else if(30 == client.field306) {
            class14.field199 = class176.method3436(0, false, true, true);
            class115.field1988 = class176.method3436(1, false, true, true);
            class186.field3023 = class176.method3436(2, true, false, true);
            class174.field2905 = class176.method3436(3, false, true, true);
            class28.field682 = class176.method3436(4, false, true, true);
            class7.field132 = class176.method3436(5, true, true, true);
            class102.field1776 = class176.method3436(6, true, true, false);
            class15.field212 = class176.method3436(7, false, true, true);
            class127.field2058 = class176.method3436(8, false, true, true);
            class96.field1644 = class176.method3436(9, false, true, true);
            class164.field2663 = class176.method3436(10, false, true, true);
            class3.field65 = class176.method3436(11, false, true, true);
            class9.field155 = class176.method3436(12, false, true, true);
            class8.field147 = class176.method3436(13, true, false, true);
            client.field334 = class176.method3436(14, false, true, false);
            class4.field75 = class176.method3436(15, false, true, true);
            class31.field731 = "Connecting to update server";
            class31.field730 = 20;
            client.field306 = 40;
         } else if(client.field306 == 40) {
            byte var34 = 0;
            var0 = var34 + class14.field199.method3323() * 4 / 100;
            var0 += class115.field1988.method3323() * 4 / 100;
            var0 += class186.field3023.method3323() * 2 / 100;
            var0 += class174.field2905.method3323() * 2 / 100;
            var0 += class28.field682.method3323() * 6 / 100;
            var0 += class7.field132.method3323() * 4 / 100;
            var0 += class102.field1776.method3323() * 2 / 100;
            var0 += class15.field212.method3323() * 60 / 100;
            var0 += class127.field2058.method3323() * 2 / 100;
            var0 += class96.field1644.method3323() * 2 / 100;
            var0 += class164.field2663.method3323() * 2 / 100;
            var0 += class3.field65.method3323() * 2 / 100;
            var0 += class9.field155.method3323() * 2 / 100;
            var0 += class8.field147.method3323() * 2 / 100;
            var0 += client.field334.method3323() * 2 / 100;
            var0 += class4.field75.method3323() * 2 / 100;
            if(100 != var0) {
               if(var0 != 0) {
                  class31.field731 = "Checking for updates - " + var0 + "%";
               }

               class31.field730 = 30;
            } else {
               class31.field731 = "Loaded update list";
               class31.field730 = 30;
               client.field306 = 45;
            }
         } else if(45 == client.field306) {
            class110.method2417(22050, !client.field493, 2);
            class184 var33 = new class184();
            var33.method3586(9, 128);
            class3.field63 = class77.method1661(class38.field878, class122.field2024, 0, 22050);
            class3.field63.method1164(var33);
            class76.method1638(class4.field75, client.field334, class28.field682, var33);
            class139.field2154 = class77.method1661(class38.field878, class122.field2024, 1, 2048);
            class114.field1978 = new class55();
            class139.field2154.method1164(class114.field1978);
            class110.field1960 = new class74(22050, class56.field1186);
            class31.field731 = "Prepared sound engine";
            class31.field730 = 35;
            client.field306 = 50;
         } else if(50 == client.field306) {
            var0 = 0;
            if(null == class12.field187) {
               class12.field187 = class154.method3143(class127.field2058, class8.field147, "p11_full", "");
            } else {
               ++var0;
            }

            if(null == class181.field2945) {
               class181.field2945 = class154.method3143(class127.field2058, class8.field147, "p12_full", "");
            } else {
               ++var0;
            }

            if(class164.field2665 == null) {
               class164.field2665 = class154.method3143(class127.field2058, class8.field147, "b12_full", "");
            } else {
               ++var0;
            }

            if(var0 < 3) {
               class31.field731 = "Loading fonts - " + var0 * 100 / 3 + "%";
               class31.field730 = 40;
            } else {
               class179.field2942 = new class160(true);
               class31.field731 = "Loaded fonts";
               class31.field730 = 40;
               client.field306 = 60;
            }
         } else {
            class168 var2;
            class168 var20;
            if(60 == client.field306) {
               var20 = class164.field2663;
               var2 = class127.field2058;
               var3 = 0;
               if(var20.method3293("title.jpg", "")) {
                  ++var3;
               }

               if(var2.method3293("logo", "")) {
                  ++var3;
               }

               if(var2.method3293("logo_deadman_mode", "")) {
                  ++var3;
               }

               if(var2.method3293("titlebox", "")) {
                  ++var3;
               }

               if(var2.method3293("titlebutton", "")) {
                  ++var3;
               }

               if(var2.method3293("runes", "")) {
                  ++var3;
               }

               if(var2.method3293("title_mute", "")) {
                  ++var3;
               }

               if(var2.method3257("options_radio_buttons,0")) {
                  ++var3;
               }

               if(var2.method3257("options_radio_buttons,2")) {
                  ++var3;
               }

               var2.method3293("sl_back", "");
               var2.method3293("sl_flags", "");
               var2.method3293("sl_arrows", "");
               var2.method3293("sl_stars", "");
               var2.method3293("sl_button", "");
               var4 = class3.method35();
               if(var3 < var4) {
                  class31.field731 = "Loading title screen - " + var3 * 100 / var4 + "%";
                  class31.field730 = 50;
               } else {
                  class31.field731 = "Loaded title screen";
                  class31.field730 = 50;
                  class15.method188(5);
                  client.field306 = 70;
               }
            } else if(client.field306 == 70) {
               if(!class186.field3023.method3238()) {
                  class31.field731 = "Loading config - " + class186.field3023.method3334() + "%";
                  class31.field730 = 60;
               } else {
                  class7.method102(class186.field3023);
                  class168 var30 = class186.field3023;
                  class41.field981 = var30;
                  class139.method2923(class186.field3023, class15.field212);
                  var20 = class186.field3023;
                  var2 = class15.field212;
                  boolean var22 = client.field493;
                  class103.field1782 = var20;
                  class21.field574 = var2;
                  class40.field951 = var22;
                  class168 var23 = class186.field3023;
                  class168 var25 = class15.field212;
                  class39.field884 = var23;
                  class39.field912 = var25;
                  class168 var6 = class186.field3023;
                  class168 var26 = class15.field212;
                  boolean var27 = client.field447;
                  class224 var31 = class12.field187;
                  class177.field2924 = var6;
                  class51.field1134 = var26;
                  class49.field1091 = var27;
                  class51.field1110 = class177.field2924.method3249(10);
                  class90.field1567 = var31;
                  class20.method549(class186.field3023, class14.field199, class115.field1988);
                  class168 var32 = class186.field3023;
                  class168 var11 = class15.field212;
                  class43.field1002 = var32;
                  class43.field1003 = var11;
                  class168 var12 = class186.field3023;
                  class47.field1070 = var12;
                  class168 var13 = class186.field3023;
                  class52.field1167 = var13;
                  class126.field2053 = class52.field1167.method3249(16);
                  class168 var14 = class174.field2905;
                  class168 var15 = class15.field212;
                  class168 var16 = class127.field2058;
                  class168 var17 = class8.field147;
                  class173.field2755 = var14;
                  class173.field2756 = var15;
                  class173.field2757 = var16;
                  class173.field2864 = var17;
                  class217.field3171 = new class173[class173.field2755.method3250()][];
                  class173.field2838 = new boolean[class173.field2755.method3250()];
                  class12.method156(class186.field3023);
                  class168 var18 = class186.field3023;
                  class48.field1084 = var18;
                  class155.method3144(class186.field3023);
                  class168 var19 = class186.field3023;
                  class49.field1090 = var19;
                  class34.field784 = new class19();
                  class31.field731 = "Loaded config";
                  class31.field730 = 60;
                  client.field306 = 80;
               }
            } else if(client.field306 != 80) {
               if(client.field306 == 90) {
                  if(!class96.field1644.method3238()) {
                     class31.field731 = "Loading textures - " + class96.field1644.method3334() + "%";
                     class31.field730 = 90;
                  } else {
                     class95 var29 = new class95(class96.field1644, class127.field2058, 20, 0.8D, client.field493?64:128);
                     class91.method2074(var29);
                     class91.method2094(0.8D);
                     class31.field731 = "Loaded textures";
                     class31.field730 = 90;
                     client.field306 = 110;
                  }
               } else if(110 == client.field306) {
                  class44.field1036 = new class13();
                  class38.field878.method2862(class44.field1036, 10);
                  class31.field731 = "Loaded input handler";
                  class31.field730 = 94;
                  client.field306 = 120;
               } else if(120 == client.field306) {
                  if(!class164.field2663.method3293("huffman", "")) {
                     class31.field731 = "Loading wordpack - " + 0 + "%";
                     class31.field730 = 96;
                  } else {
                     class113 var28 = new class113(class164.field2663.method3255("huffman", ""));
                     class74.method1585(var28);
                     class31.field731 = "Loaded wordpack";
                     class31.field730 = 96;
                     client.field306 = 130;
                  }
               } else if(130 == client.field306) {
                  if(!class174.field2905.method3238()) {
                     class31.field731 = "Loading interfaces - " + class174.field2905.method3334() * 4 / 5 + "%";
                     class31.field730 = 100;
                  } else if(!class9.field155.method3238()) {
                     class31.field731 = "Loading interfaces - " + (80 + class9.field155.method3334() / 6) + "%";
                     class31.field730 = 100;
                  } else if(!class8.field147.method3238()) {
                     class31.field731 = "Loading interfaces - " + (96 + class8.field147.method3334() / 20) + "%";
                     class31.field730 = 100;
                  } else {
                     class31.field731 = "Loaded interfaces";
                     class31.field730 = 100;
                     client.field306 = 140;
                  }
               } else if(140 == client.field306) {
                  class15.method188(10);
               }
            } else {
               var0 = 0;
               class78 var5;
               class78 var7;
               int var8;
               byte[] var9;
               int var10;
               if(null == class99.field1691) {
                  var2 = class127.field2058;
                  var3 = var2.method3253("compass");
                  var4 = var2.method3254(var3, "");
                  if(!class35.method714(var2, var3, var4)) {
                     var5 = null;
                  } else {
                     var7 = new class78();
                     var7.field1416 = class226.field3214;
                     var7.field1412 = class76.field1386;
                     var7.field1410 = class76.field1387[0];
                     var7.field1406 = class76.field1390[0];
                     var7.field1407 = class76.field1389[0];
                     var7.field1408 = class9.field159[0];
                     var8 = var7.field1408 * var7.field1407;
                     var9 = class21.field575[0];
                     var7.field1414 = new int[var8];

                     for(var10 = 0; var10 < var8; ++var10) {
                        var7.field1414[var10] = class76.field1396[var9[var10] & 255];
                     }

                     class27.method633();
                     var5 = var7;
                  }

                  class99.field1691 = var5;
               } else {
                  ++var0;
               }

               if(null == class24.field620) {
                  var2 = class127.field2058;
                  var3 = var2.method3253("mapedge");
                  var4 = var2.method3254(var3, "");
                  if(!class35.method714(var2, var3, var4)) {
                     var5 = null;
                  } else {
                     var7 = new class78();
                     var7.field1416 = class226.field3214;
                     var7.field1412 = class76.field1386;
                     var7.field1410 = class76.field1387[0];
                     var7.field1406 = class76.field1390[0];
                     var7.field1407 = class76.field1389[0];
                     var7.field1408 = class9.field159[0];
                     var8 = var7.field1407 * var7.field1408;
                     var9 = class21.field575[0];
                     var7.field1414 = new int[var8];

                     for(var10 = 0; var10 < var8; ++var10) {
                        var7.field1414[var10] = class76.field1396[var9[var10] & 255];
                     }

                     class27.method633();
                     var5 = var7;
                  }

                  class24.field620 = var5;
               } else {
                  ++var0;
               }

               if(class2.field60 == null) {
                  class2.field60 = class13.method170(class127.field2058, "mapscene", "");
               } else {
                  ++var0;
               }

               if(null == class176.field2921) {
                  class176.field2921 = class11.method152(class127.field2058, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(null == class77.field1405) {
                  class77.field1405 = class11.method152(class127.field2058, "hitmarks", "");
               } else {
                  ++var0;
               }

               if(class210.field3141 == null) {
                  class210.field3141 = class11.method152(class127.field2058, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(null == class164.field2668) {
                  class164.field2668 = class11.method152(class127.field2058, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(null == class39.field919) {
                  class39.field919 = class11.method152(class127.field2058, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(null == class90.field1570) {
                  class90.field1570 = class11.method152(class127.field2058, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(class136.field2105 == null) {
                  class136.field2105 = class11.method152(class127.field2058, "cross", "");
               } else {
                  ++var0;
               }

               if(null == class138.field2146) {
                  class138.field2146 = class11.method152(class127.field2058, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class151.field2270 == null) {
                  class151.field2270 = class13.method170(class127.field2058, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class74.field1364 == null) {
                  class74.field1364 = class13.method170(class127.field2058, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 13) {
                  class31.field731 = "Loading sprites - " + var0 * 100 / 13 + "%";
                  class31.field730 = 70;
               } else {
                  class223.field3192 = class74.field1364;
                  class24.field620.method1668();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var21 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var24 = 0; var24 < class176.field2921.length; ++var24) {
                     class176.field2921[var24].method1667(var1 + var4, var21 + var4, var3 + var4);
                  }

                  class2.field60[0].method1840(var1 + var4, var21 + var4, var3 + var4);
                  class31.field731 = "Loaded sprites";
                  class31.field730 = 70;
                  client.field306 = 90;
               }
            }
         }
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "283869156"
   )
   static final void method2177(int var0, int var1, int var2, int var3) {
      if(client.field390 == 1) {
         class136.field2105[client.field389 / 100].method1676(client.field387 - 8, client.field539 - 8);
      }

      if(client.field390 == 2) {
         class136.field2105[client.field389 / 100 + 4].method1676(client.field387 - 8, client.field539 - 8);
      }

      client.field358 = 0;
      int var4 = (class106.field1881.field823 >> 7) + class22.field594;
      int var5 = (class106.field1881.field813 >> 7) + class114.field1981;
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         client.field358 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         client.field358 = 1;
      }

      if(client.field358 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         client.field358 = 0;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;Lclass224;ZB)V",
      garbageValue = "73"
   )
   static void method2178(class224 var0, class224 var1, class224 var2, boolean var3) {
      if(var3) {
         class31.field748 = (class15.field214 - client.field492) / 2;
         class31.field720 = class31.field748 + 202;
      }

      if(class31.field744) {
         class131.method2833(var0, var1);
      } else {
         if(var3) {
            class20.field569.method1674(class31.field748, 0);
            class121.field2016.method1674(class31.field748 + 382, 0);
            class31.field718.method1841(class31.field748 + 382 - class31.field718.field1427 / 2, 18);
         }

         int var5;
         if(client.field286 == 0 || client.field286 == 5) {
            byte var4 = 20;
            var0.method4004("RuneScape is loading - please wait...", 180 + class31.field720, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1779(180 + class31.field720 - 152, var5, 304, 34, 9179409);
            class79.method1779(class31.field720 + 180 - 151, 1 + var5, 302, 32, 0);
            class79.method1808(class31.field720 + 180 - 150, var5 + 2, class31.field730 * 3, 30, 9179409);
            class79.method1808(class31.field730 * 3 + (180 + class31.field720 - 150), 2 + var5, 300 - class31.field730 * 3, 30, 0);
            var0.method4004(class31.field731, class31.field720 + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var15;
         int var16;
         short var17;
         if(client.field286 == 20) {
            class209.field3128.method1841(180 + class31.field720 - class209.field3128.field1427 / 2, 271 - class209.field3128.field1429 / 2);
            var15 = 211;
            var0.method4004(class31.field734, class31.field720 + 180, var15, 16776960, 0);
            var16 = var15 + 15;
            var0.method4004(class31.field725, 180 + class31.field720, var16, 16776960, 0);
            var16 += 15;
            var0.method4004(class31.field738, 180 + class31.field720, var16, 16776960, 0);
            var16 += 15;
            var16 += 10;
            if(4 != class31.field732) {
               var0.method4002("Login: ", 180 + class31.field720 - 110, var16, 16777215, 0);
               var17 = 200;

               for(var6 = class31.field737; var0.method3997(var6) > var17; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4002(class223.method4001(var6), class31.field720 + 180 - 70, var16, 16777215, 0);
               var16 += 15;
               var0.method4002("Password: " + class130.method2811(class31.field740), 180 + class31.field720 - 108, var16, 16777215, 0);
               var16 += 15;
            }
         }

         int var7;
         int var20;
         int var21;
         if(client.field286 == 10 || 11 == client.field286) {
            class209.field3128.method1841(class31.field720, 171);
            short var18;
            if(class31.field732 == 0) {
               var15 = 251;
               var0.method4004("Welcome to RuneScape", 180 + class31.field720, var15, 16776960, 0);
               var16 = var15 + 30;
               var5 = 180 + class31.field720 - 80;
               var18 = 291;
               class31.field717.method1841(var5 - 73, var18 - 20);
               var0.method4005("New User", var5 - 73, var18 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 180 + class31.field720 + 80;
               class31.field717.method1841(var5 - 73, var18 - 20);
               var0.method4005("Existing User", var5 - 73, var18 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class31.field732 == 1) {
               var0.method4004(class31.field733, 180 + class31.field720, 211, 16776960, 0);
               var15 = 236;
               var0.method4004(class31.field734, 180 + class31.field720, var15, 16777215, 0);
               var16 = var15 + 15;
               var0.method4004(class31.field725, 180 + class31.field720, var16, 16777215, 0);
               var16 += 15;
               var0.method4004(class31.field738, 180 + class31.field720, var16, 16777215, 0);
               var16 += 15;
               var5 = class31.field720 + 180 - 80;
               var18 = 321;
               class31.field717.method1841(var5 - 73, var18 - 20);
               var0.method4004("Continue", var5, var18 + 5, 16777215, 0);
               var5 = 80 + 180 + class31.field720;
               class31.field717.method1841(var5 - 73, var18 - 20);
               var0.method4004("Cancel", var5, var18 + 5, 16777215, 0);
            } else {
               short var8;
               if(class31.field732 == 2) {
                  var15 = 211;
                  var0.method4004(class31.field734, 180 + class31.field720, var15, 16776960, 0);
                  var16 = var15 + 15;
                  var0.method4004(class31.field725, 180 + class31.field720, var16, 16776960, 0);
                  var16 += 15;
                  var0.method4004(class31.field738, class31.field720 + 180, var16, 16776960, 0);
                  var16 += 15;
                  var16 += 10;
                  var0.method4002("Login: ", class31.field720 + 180 - 110, var16, 16777215, 0);
                  var17 = 200;

                  for(var6 = class31.field737; var0.method3997(var6) > var17; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4002(class223.method4001(var6) + (0 == class31.field729 & client.field335 % 40 < 20?class12.method163(16776960) + "|":""), class31.field720 + 180 - 70, var16, 16777215, 0);
                  var16 += 15;
                  var0.method4002("Password: " + class130.method2811(class31.field740) + (1 == class31.field729 & client.field335 % 40 < 20?class12.method163(16776960) + "|":""), class31.field720 + 180 - 108, var16, 16777215, 0);
                  var16 += 15;
                  var7 = class31.field720 + 180 - 80;
                  var8 = 321;
                  class31.field717.method1841(var7 - 73, var8 - 20);
                  var0.method4004("Login", var7, var8 + 5, 16777215, 0);
                  var7 = 80 + 180 + class31.field720;
                  class31.field717.method1841(var7 - 73, var8 - 20);
                  var0.method4004("Cancel", var7, var8 + 5, 16777215, 0);
                  var15 = 357;
                  var1.method4004("Forgotten your password? <col=ffffff>Click here.", class31.field720 + 180, var15, 16776960, 0);
               } else if(class31.field732 == 3) {
                  var15 = 201;
                  var0.method4004("Invalid username or password.", class31.field720 + 180, var15, 16776960, 0);
                  var16 = var15 + 20;
                  var1.method4004("For accounts created after 24th November 2010, please use your", 180 + class31.field720, var16, 16776960, 0);
                  var16 += 15;
                  var1.method4004("email address to login. Otherwise please login with your username.", 180 + class31.field720, var16, 16776960, 0);
                  var16 += 15;
                  var5 = class31.field720 + 180;
                  var18 = 276;
                  class31.field717.method1841(var5 - 73, var18 - 20);
                  var2.method4004("Try again", var5, var18 + 5, 16777215, 0);
                  var5 = 180 + class31.field720;
                  var18 = 326;
                  class31.field717.method1841(var5 - 73, var18 - 20);
                  var2.method4004("Forgotten password?", var5, 5 + var18, 16777215, 0);
               } else if(4 == class31.field732) {
                  var0.method4004("Authenticator", class31.field720 + 180, 211, 16776960, 0);
                  var15 = 236;
                  var0.method4004(class31.field734, class31.field720 + 180, var15, 16777215, 0);
                  var16 = var15 + 15;
                  var0.method4004(class31.field725, 180 + class31.field720, var16, 16777215, 0);
                  var16 += 15;
                  var0.method4004(class31.field738, class31.field720 + 180, var16, 16777215, 0);
                  var16 += 15;
                  var0.method4002("PIN: " + class130.method2811(class44.field1035) + (client.field335 % 40 < 20?class12.method163(16776960) + "|":""), class31.field720 + 180 - 108, var16, 16777215, 0);
                  var16 -= 8;
                  var0.method4002("Trust this computer", 180 + class31.field720 - 9, var16, 16776960, 0);
                  var16 += 15;
                  var0.method4002("for 30 days: ", class31.field720 + 180 - 9, var16, 16776960, 0);
                  var5 = class31.field720 + 180 - 9 + var0.method3997("for 30 days: ") + 15;
                  var21 = var16 - var0.field3189;
                  class80 var19;
                  if(class31.field739) {
                     var19 = class30.field708;
                  } else {
                     var19 = class27.field678;
                  }

                  var19.method1841(var5, var21);
                  var16 += 15;
                  var20 = class31.field720 + 180 - 80;
                  short var9 = 321;
                  class31.field717.method1841(var20 - 73, var9 - 20);
                  var0.method4004("Continue", var20, 5 + var9, 16777215, 0);
                  var20 = 80 + class31.field720 + 180;
                  class31.field717.method1841(var20 - 73, var9 - 20);
                  var0.method4004("Cancel", var20, 5 + var9, 16777215, 0);
                  var1.method4004("<u=ff>Can\'t Log In?</u>", 180 + class31.field720, 36 + var9, 255, 0);
               } else if(class31.field732 == 5) {
                  var0.method4004("Forgotten your password?", 180 + class31.field720, 201, 16776960, 0);
                  var15 = 221;
                  var2.method4004(class31.field734, class31.field720 + 180, var15, 16776960, 0);
                  var16 = var15 + 15;
                  var2.method4004(class31.field725, 180 + class31.field720, var16, 16776960, 0);
                  var16 += 15;
                  var2.method4004(class31.field738, 180 + class31.field720, var16, 16776960, 0);
                  var16 += 15;
                  var16 += 14;
                  var0.method4002("Username/email: ", class31.field720 + 180 - 145, var16, 16777215, 0);
                  var17 = 174;

                  for(var6 = class31.field737; var0.method3997(var6) > var17; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4002(class223.method4001(var6) + (client.field335 % 40 < 20?class12.method163(16776960) + "|":""), class31.field720 + 180 - 34, var16, 16777215, 0);
                  var16 += 15;
                  var7 = 180 + class31.field720 - 80;
                  var8 = 321;
                  class31.field717.method1841(var7 - 73, var8 - 20);
                  var0.method4004("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = 80 + class31.field720 + 180;
                  class31.field717.method1841(var7 - 73, var8 - 20);
                  var0.method4004("Back", var7, var8 + 5, 16777215, 0);
               } else if(class31.field732 == 6) {
                  var15 = 211;
                  var0.method4004(class31.field734, 180 + class31.field720, var15, 16776960, 0);
                  var16 = var15 + 15;
                  var0.method4004(class31.field725, class31.field720 + 180, var16, 16776960, 0);
                  var16 += 15;
                  var0.method4004(class31.field738, 180 + class31.field720, var16, 16776960, 0);
                  var16 += 15;
                  var5 = 180 + class31.field720;
                  var18 = 321;
                  class31.field717.method1841(var5 - 73, var18 - 20);
                  var0.method4004("Back", var5, var18 + 5, 16777215, 0);
               }
            }
         }

         if(class31.field728 > 0) {
            var16 = class31.field728;
            var17 = 256;
            class31.field726 += 128 * var16;
            if(class31.field726 > class27.field670.length) {
               class31.field726 -= class27.field670.length;
               var21 = (int)(Math.random() * 12.0D);
               class110.method2416(class28.field681[var21]);
            }

            var21 = 0;
            var7 = 128 * var16;
            var20 = 128 * (var17 - var16);

            int var10;
            int var22;
            for(var22 = 0; var22 < var20; ++var22) {
               var10 = class27.field665[var7 + var21] - var16 * class27.field670[var21 + class31.field726 & class27.field670.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class27.field665[var21++] = var10;
            }

            int var11;
            int var12;
            for(var22 = var17 - var16; var22 < var17; ++var22) {
               var10 = var22 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class27.field665[var10 + var11] = 255;
                  } else {
                     class27.field665[var11 + var10] = 0;
                  }
               }
            }

            if(class31.field724 > 0) {
               class31.field724 -= 4 * var16;
            }

            if(class31.field735 > 0) {
               class31.field735 -= var16 * 4;
            }

            if(0 == class31.field724 && class31.field735 == 0) {
               var22 = (int)(Math.random() * (double)(2000 / var16));
               if(var22 == 0) {
                  class31.field724 = 1024;
               }

               if(1 == var22) {
                  class31.field735 = 1024;
               }
            }

            for(var22 = 0; var22 < var17 - var16; ++var22) {
               class31.field721[var22] = class31.field721[var22 + var16];
            }

            for(var22 = var17 - var16; var22 < var17; ++var22) {
               class31.field721[var22] = (int)(Math.sin((double)class31.field716 / 14.0D) * 16.0D + Math.sin((double)class31.field716 / 15.0D) * 14.0D + Math.sin((double)class31.field716 / 16.0D) * 12.0D);
               ++class31.field716;
            }

            class31.field727 += var16;
            var22 = (var16 + (client.field335 & 1)) / 2;
            if(var22 > 0) {
               for(var10 = 0; var10 < class31.field727 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class27.field665[(var12 << 7) + var11] = 192;
               }

               class31.field727 = 0;
               var10 = 0;

               label277:
               while(true) {
                  int var13;
                  if(var10 >= var17) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label277;
                        }

                        var11 = 0;

                        for(var12 = -var22; var12 < var17; ++var12) {
                           var13 = 128 * var12;
                           if(var12 + var22 < var17) {
                              var11 += class43.field1018[var13 + var10 + 128 * var22];
                           }

                           if(var12 - (var22 + 1) >= 0) {
                              var11 -= class43.field1018[var10 + var13 - (1 + var22) * 128];
                           }

                           if(var12 >= 0) {
                              class27.field665[var13 + var10] = var11 / (var22 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = 128 * var10;

                  for(var13 = -var22; var13 < 128; ++var13) {
                     if(var13 + var22 < 128) {
                        var11 += class27.field665[var12 + var13 + var22];
                     }

                     if(var13 - (1 + var22) >= 0) {
                        var11 -= class27.field665[var12 + var13 - (1 + var22)];
                     }

                     if(var13 >= 0) {
                        class43.field1018[var13 + var12] = var11 / (var22 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class31.field728 = 0;
         }

         class101.method2265();
         class151.field2263[class76.field1388.field143?1:0].method1841(class31.field748 + 765 - 40, 463);
         if(client.field286 > 5 && 0 == client.field285) {
            if(null != class50.field1104) {
               var16 = class31.field748 + 5;
               var17 = 463;
               byte var24 = 100;
               byte var23 = 35;
               class50.field1104.method1841(var16, var17);
               var0.method4004("World" + " " + client.field551, var24 / 2 + var16, var23 / 2 + var17 - 2, 16777215, 0);
               if(class87.field1537 != null) {
                  var1.method4004("Loading...", var24 / 2 + var16, 12 + var23 / 2 + var17, 16777215, 0);
               } else {
                  var1.method4004("Click to switch", var24 / 2 + var16, 12 + var17 + var23 / 2, 16777215, 0);
               }
            } else {
               class50.field1104 = class137.method2910(class127.field2058, "sl_button", "");
            }
         }

         try {
            Graphics var25 = class122.field2024.getGraphics();
            class135.field2094.vmethod1857(var25, 0, 0);
         } catch (Exception var14) {
            class122.field2024.repaint();
         }

      }
   }
}
