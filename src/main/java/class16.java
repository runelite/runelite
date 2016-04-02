import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public final class class16 extends class208 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 62068989
   )
   int field224;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -804402563
   )
   int field225;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1565777025
   )
   int field226;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -206946931
   )
   int field227;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 823905589
   )
   int field228;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = 1014014861
   )
   static int field229;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1552121233
   )
   int field230;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1295203921
   )
   int field232;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -308292155
   )
   int field233;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 491380063
   )
   int field234 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -536705607
   )
   int field235 = -1;
   @ObfuscatedName("pd")
   static Clipboard field236;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 141251641
   )
   int field238;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1435532205
   )
   int field239;

   @ObfuscatedName("g")
   public static class80 method178(class167 var0, String var1, String var2) {
      int var3 = var0.method3255(var1);
      int var4 = var0.method3271(var3, var2);
      return class6.method101(var0, var3, var4);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-116"
   )
   static void method179() {
      int var0;
      if(0 == client.field450) {
         class151.field2250 = new class86(4, 104, 104, class5.field90);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field338[var0] = new class108(104, 104);
         }

         class141.field2160 = new class78(512, 512);
         class31.field722 = "Starting game engine...";
         class31.field707 = 5;
         client.field450 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(client.field450 == 20) {
            int[] var21 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 32 * var1 + 128 + 15;
               var3 = 600 + 3 * var2;
               var4 = class91.field1568[var2];
               var21[var1] = var3 * var4 >> 16;
            }

            class86.method1962(var21, 500, 800, 512, 334);
            class31.field722 = "Prepared visibility map";
            class31.field707 = 10;
            client.field450 = 30;
         } else if(client.field450 == 30) {
            class99.field1651 = class159.method3175(0, false, true, true);
            class216.field3157 = class159.method3175(1, false, true, true);
            class104.field1772 = class159.method3175(2, true, false, true);
            class27.field659 = class159.method3175(3, false, true, true);
            class143.field2175 = class159.method3175(4, false, true, true);
            class32.field743 = class159.method3175(5, true, true, true);
            class24.field611 = class159.method3175(6, true, true, false);
            class19.field272 = class159.method3175(7, false, true, true);
            class17.field246 = class159.method3175(8, false, true, true);
            class124.field2023 = class159.method3175(9, false, true, true);
            class108.field1880 = class159.method3175(10, false, true, true);
            class82.field1406 = class159.method3175(11, false, true, true);
            class59.field1189 = class159.method3175(12, false, true, true);
            class72.field1319 = class159.method3175(13, true, false, true);
            class133.field2057 = class159.method3175(14, false, true, false);
            class115.field1956 = class159.method3175(15, false, true, true);
            class31.field722 = "Connecting to update server";
            class31.field707 = 20;
            client.field450 = 40;
         } else if(client.field450 == 40) {
            byte var20 = 0;
            var0 = var20 + class99.field1651.method3323() * 4 / 100;
            var0 += class216.field3157.method3323() * 4 / 100;
            var0 += class104.field1772.method3323() * 2 / 100;
            var0 += class27.field659.method3323() * 2 / 100;
            var0 += class143.field2175.method3323() * 6 / 100;
            var0 += class32.field743.method3323() * 4 / 100;
            var0 += class24.field611.method3323() * 2 / 100;
            var0 += class19.field272.method3323() * 60 / 100;
            var0 += class17.field246.method3323() * 2 / 100;
            var0 += class124.field2023.method3323() * 2 / 100;
            var0 += class108.field1880.method3323() * 2 / 100;
            var0 += class82.field1406.method3323() * 2 / 100;
            var0 += class59.field1189.method3323() * 2 / 100;
            var0 += class72.field1319.method3323() * 2 / 100;
            var0 += class133.field2057.method3323() * 2 / 100;
            var0 += class115.field1956.method3323() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class31.field722 = "Checking for updates - " + var0 + "%";
               }

               class31.field707 = 30;
            } else {
               class31.field722 = "Loaded update list";
               class31.field707 = 30;
               client.field450 = 45;
            }
         } else {
            class168 var10;
            class168 var12;
            class168 var13;
            if(45 == client.field450) {
               class45.method949(22050, !client.field285, 2);
               class184 var19 = new class184();
               var19.method3596(9, 128);
               class221.field3179 = class99.method2213(class125.field2028, 0, 22050);
               class221.field3179.method1174(var19);
               var10 = class115.field1956;
               var12 = class133.field2057;
               var13 = class143.field2175;
               class183.field2961 = var10;
               class183.field2960 = var12;
               class183.field2956 = var13;
               class183.field2957 = var19;
               class5.field94 = class99.method2213(class125.field2028, 1, 2048);
               class135.field2074 = new class55();
               class5.field94.method1174(class135.field2074);
               class49.field1066 = new class74(22050, class56.field1153);
               class31.field722 = "Prepared sound engine";
               class31.field707 = 35;
               client.field450 = 50;
            } else {
               int var5;
               if(client.field450 == 50) {
                  var0 = 0;
                  class224 var11;
                  if(class34.field753 == null) {
                     var12 = class17.field246;
                     var13 = class72.field1319;
                     var4 = var12.method3255("p11_full");
                     var5 = var12.method3271(var4, "");
                     var11 = class77.method1695(var12, var13, var4, var5);
                     class34.field753 = var11;
                  } else {
                     ++var0;
                  }

                  if(null == class25.field628) {
                     var12 = class17.field246;
                     var13 = class72.field1319;
                     var4 = var12.method3255("p12_full");
                     var5 = var12.method3271(var4, "");
                     var11 = class77.method1695(var12, var13, var4, var5);
                     class25.field628 = var11;
                  } else {
                     ++var0;
                  }

                  if(class124.field2022 == null) {
                     var12 = class17.field246;
                     var13 = class72.field1319;
                     var4 = var12.method3255("b12_full");
                     var5 = var12.method3271(var4, "");
                     var11 = class77.method1695(var12, var13, var4, var5);
                     class124.field2022 = var11;
                  } else {
                     ++var0;
                  }

                  if(var0 < 3) {
                     class31.field722 = "Loading fonts - " + var0 * 100 / 3 + "%";
                     class31.field707 = 40;
                  } else {
                     class36.field784 = new class160(true);
                     class31.field722 = "Loaded fonts";
                     class31.field707 = 40;
                     client.field450 = 60;
                  }
               } else if(60 == client.field450) {
                  var10 = class108.field1880;
                  var12 = class17.field246;
                  var3 = 0;
                  if(var10.method3273("title.jpg", "")) {
                     ++var3;
                  }

                  if(var12.method3273("logo", "")) {
                     ++var3;
                  }

                  if(var12.method3273("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var12.method3273("titlebox", "")) {
                     ++var3;
                  }

                  if(var12.method3273("titlebutton", "")) {
                     ++var3;
                  }

                  if(var12.method3273("runes", "")) {
                     ++var3;
                  }

                  if(var12.method3273("title_mute", "")) {
                     ++var3;
                  }

                  if(var12.method3299("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var12.method3299("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var12.method3273("sl_back", "");
                  var12.method3273("sl_flags", "");
                  var12.method3273("sl_arrows", "");
                  var12.method3273("sl_stars", "");
                  var12.method3273("sl_button", "");
                  var4 = class104.method2320();
                  if(var3 < var4) {
                     class31.field722 = "Loading title screen - " + var3 * 100 / var4 + "%";
                     class31.field707 = 50;
                  } else {
                     class31.field722 = "Loaded title screen";
                     class31.field707 = 50;
                     class141.method2971(5);
                     client.field450 = 70;
                  }
               } else if(client.field450 == 70) {
                  if(!class104.field1772.method3259()) {
                     class31.field722 = "Loading config - " + class104.field1772.method3344() + "%";
                     class31.field707 = 60;
                  } else {
                     class168 var18 = class104.field1772;
                     class46.field1028 = var18;
                     var10 = class104.field1772;
                     class41.field959 = var10;
                     var12 = class104.field1772;
                     var13 = class19.field272;
                     class44.field1005 = var12;
                     class44.field1007 = var13;
                     class44.field1002 = class44.field1005.method3307(3);
                     class9.method129(class104.field1772, class19.field272, client.field285);
                     class45.method957(class104.field1772, class19.field272);
                     class18.method190(class104.field1772, class19.field272, client.field284, class34.field753);
                     class31.method699(class104.field1772, class99.field1651, class216.field3157);
                     class168 var14 = class104.field1772;
                     class168 var15 = class19.field272;
                     class216.field3159 = var14;
                     class43.field992 = var15;
                     class168 var6 = class104.field1772;
                     class47.field1045 = var6;
                     class9.method124(class104.field1772);
                     class140.method2966(class27.field659, class19.field272, class17.field246, class72.field1319);
                     class168 var7 = class104.field1772;
                     class213.field3144 = var7;
                     class168 var8 = class104.field1772;
                     class48.field1053 = var8;
                     class34.method726(class104.field1772);
                     class168 var9 = class104.field1772;
                     class218.field3163 = var9;
                     class125.field2027 = new class19();
                     class31.field722 = "Loaded config";
                     class31.field707 = 60;
                     client.field450 = 80;
                  }
               } else if(80 != client.field450) {
                  if(90 == client.field450) {
                     if(!class124.field2023.method3259()) {
                        class31.field722 = "Loading textures - " + class124.field2023.method3344() + "%";
                        class31.field707 = 90;
                     } else {
                        class95 var17 = new class95(class124.field2023, class17.field246, 20, 0.8D, client.field285?64:128);
                        class91.method2159(var17);
                        class91.method2109(0.8D);
                        class31.field722 = "Loaded textures";
                        class31.field707 = 90;
                        client.field450 = 110;
                     }
                  } else if(110 == client.field450) {
                     class32.field728 = new class13();
                     class125.field2028.method2888(class32.field728, 10);
                     class31.field722 = "Loaded input handler";
                     class31.field707 = 94;
                     client.field450 = 120;
                  } else if(client.field450 == 120) {
                     if(!class108.field1880.method3273("huffman", "")) {
                        class31.field722 = "Loading wordpack - " + 0 + "%";
                        class31.field707 = 96;
                     } else {
                        class113 var16 = new class113(class108.field1880.method3305("huffman", ""));
                        class4.method48(var16);
                        class31.field722 = "Loaded wordpack";
                        class31.field707 = 96;
                        client.field450 = 130;
                     }
                  } else if(130 == client.field450) {
                     if(!class27.field659.method3259()) {
                        class31.field722 = "Loading interfaces - " + class27.field659.method3344() * 4 / 5 + "%";
                        class31.field707 = 100;
                     } else if(!class59.field1189.method3259()) {
                        class31.field722 = "Loading interfaces - " + (80 + class59.field1189.method3344() / 6) + "%";
                        class31.field707 = 100;
                     } else if(!class72.field1319.method3259()) {
                        class31.field722 = "Loading interfaces - " + (96 + class72.field1319.method3344() / 20) + "%";
                        class31.field707 = 100;
                     } else {
                        class31.field722 = "Loaded interfaces";
                        class31.field707 = 100;
                        client.field450 = 140;
                     }
                  } else if(client.field450 == 140) {
                     class141.method2971(10);
                  }
               } else {
                  var0 = 0;
                  if(class138.field2127 == null) {
                     class138.field2127 = class174.method3425(class17.field246, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(class158.field2596 == null) {
                     class158.field2596 = class174.method3425(class17.field246, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(class12.field190 == null) {
                     class12.field190 = class133.method2848(class17.field246, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class169.field2704 == null) {
                     class169.field2704 = class122.method2774(class17.field246, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(class121.field1997 == null) {
                     class121.field1997 = class122.method2774(class17.field246, "hitmarks", "");
                  } else {
                     ++var0;
                  }

                  if(null == class74.field1340) {
                     class74.field1340 = class122.method2774(class17.field246, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(null == class26.field630) {
                     class26.field630 = class122.method2774(class17.field246, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(null == class123.field2014) {
                     class123.field2014 = class122.method2774(class17.field246, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class30.field688 == null) {
                     class30.field688 = class122.method2774(class17.field246, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(class90.field1544 == null) {
                     class90.field1544 = class122.method2774(class17.field246, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(null == client.field512) {
                     client.field512 = class122.method2774(class17.field246, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class217.field3162 == null) {
                     class217.field3162 = class133.method2848(class17.field246, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class149.field2236 == null) {
                     class149.field2236 = class133.method2848(class17.field246, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 13) {
                     class31.field722 = "Loading sprites - " + 100 * var0 / 13 + "%";
                     class31.field707 = 70;
                  } else {
                     class223.field3194 = class149.field2236;
                     class158.field2596.method1704();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(var5 = 0; var5 < class169.field2704.length; ++var5) {
                        class169.field2704[var5].method1792(var4 + var1, var2 + var4, var4 + var3);
                     }

                     class12.field190[0].method1871(var4 + var1, var4 + var2, var4 + var3);
                     class31.field722 = "Loaded sprites";
                     class31.field707 = 70;
                     client.field450 = 90;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1202209519"
   )
   static final void method180() {
      class14.method167(false);
      client.field333 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class42.field980.length; ++var1) {
         if(-1 != class9.field163[var1] && class42.field980[var1] == null) {
            class42.field980[var1] = class32.field743.method3280(class9.field163[var1], 0);
            if(null == class42.field980[var1]) {
               var0 = false;
               ++client.field333;
            }
         }

         if(class185.field3001[var1] != -1 && class37.field813[var1] == null) {
            class37.field813[var1] = class32.field743.method3270(class185.field3001[var1], 0, class14.field213[var1]);
            if(null == class37.field813[var1]) {
               var0 = false;
               ++client.field333;
            }
         }
      }

      if(!var0) {
         client.field337 = 1;
      } else {
         client.field335 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class42.field980.length; ++var1) {
            byte[] var2 = class37.field813[var1];
            if(var2 != null) {
               var3 = (class45.field1016[var1] >> 8) * 64 - class85.field1439;
               var4 = (class45.field1016[var1] & 255) * 64 - class6.field128;
               if(client.field339) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class24.method594(var2, var3, var4);
            }
         }

         if(!var0) {
            client.field337 = 2;
         } else {
            if(client.field337 != 0) {
               class123.method2787("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class11.method155();
            class5.method90();
            class11.method155();
            class151.field2250.method1926();
            class11.method155();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               client.field338[var1].method2407();
            }

            int var30;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var30 = 0; var30 < 104; ++var30) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class5.field80[var1][var30][var3] = 0;
                  }
               }
            }

            class11.method155();
            class48.method995();
            var1 = class42.field980.length;

            for(class23 var31 = (class23)class23.field601.method3825(); var31 != null; var31 = (class23)class23.field601.method3827()) {
               if(var31.field591 != null) {
                  class135.field2074.method1146(var31.field591);
                  var31.field591 = null;
               }

               if(null != var31.field596) {
                  class135.field2074.method1146(var31.field596);
                  var31.field596 = null;
               }
            }

            class23.field601.method3819();
            class14.method167(true);
            int var6;
            int var7;
            int var9;
            int var10;
            int var11;
            int var12;
            int var33;
            if(!client.field339) {
               byte[] var5;
               for(var30 = 0; var30 < var1; ++var30) {
                  var3 = (class45.field1016[var30] >> 8) * 64 - class85.field1439;
                  var4 = (class45.field1016[var30] & 255) * 64 - class6.field128;
                  var5 = class42.field980[var30];
                  if(var5 != null) {
                     class11.method155();
                     var6 = class5.field100 * 8 - 48;
                     var7 = class126.field2033 * 8 - 48;
                     class108[] var8 = client.field338;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var3 + var10 > 0 && var10 + var3 < 103 && var11 + var4 > 0 && var4 + var11 < 103) {
                                 var8[var9].field1885[var3 + var10][var4 + var11] &= -16777217;
                              }
                           }
                        }
                     }

                     class119 var37 = new class119(var5);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var12 = 0; var12 < 64; ++var12) {
                              class176.method3432(var37, var10, var3 + var11, var12 + var4, var6, var7, 0);
                           }
                        }
                     }
                  }
               }

               for(var30 = 0; var30 < var1; ++var30) {
                  var3 = 64 * (class45.field1016[var30] >> 8) - class85.field1439;
                  var4 = 64 * (class45.field1016[var30] & 255) - class6.field128;
                  var5 = class42.field980[var30];
                  if(null == var5 && class126.field2033 < 800) {
                     class11.method155();
                     class51.method1063(var3, var4, 64, 64);
                  }
               }

               class14.method167(true);

               for(var30 = 0; var30 < var1; ++var30) {
                  byte[] var32 = class37.field813[var30];
                  if(null != var32) {
                     var4 = (class45.field1016[var30] >> 8) * 64 - class85.field1439;
                     var33 = (class45.field1016[var30] & 255) * 64 - class6.field128;
                     class11.method155();
                     class116.method2469(var32, var4, var33, class151.field2250, client.field338);
                  }
               }
            }

            int var36;
            if(client.field339) {
               for(var30 = 0; var30 < 4; ++var30) {
                  class11.method155();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var34 = false;
                        var6 = client.field498[var30][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var36 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var12 = 0; var12 < class45.field1016.length; ++var12) {
                              if(class45.field1016[var12] == var11 && class42.field980[var12] != null) {
                                 byte[] var13 = class42.field980[var12];
                                 int var14 = 8 * var3;
                                 int var15 = 8 * var4;
                                 int var16 = (var9 & 7) * 8;
                                 int var17 = (var10 & 7) * 8;
                                 class108[] var18 = client.field338;

                                 int var20;
                                 for(int var19 = 0; var19 < 8; ++var19) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var19 + var14 > 0 && var19 + var14 < 103 && var20 + var15 > 0 && var20 + var15 < 103) {
                                          var18[var30].field1885[var19 + var14][var20 + var15] &= -16777217;
                                       }
                                    }
                                 }

                                 class119 var38 = new class119(var13);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(int var21 = 0; var21 < 64; ++var21) {
                                       for(int var22 = 0; var22 < 64; ++var22) {
                                          if(var20 == var7 && var21 >= var16 && var21 < 8 + var16 && var22 >= var17 && var22 < var17 + 8) {
                                             int var27 = var21 & 7;
                                             int var28 = var22 & 7;
                                             int var29 = var36 & 3;
                                             int var26;
                                             if(0 == var29) {
                                                var26 = var27;
                                             } else if(var29 == 1) {
                                                var26 = var28;
                                             } else if(2 == var29) {
                                                var26 = 7 - var27;
                                             } else {
                                                var26 = 7 - var28;
                                             }

                                             class176.method3432(var38, var30, var14 + var26, var15 + class126.method2811(var21 & 7, var22 & 7, var36), 0, 0, var36);
                                          } else {
                                             class176.method3432(var38, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var34 = true;
                                 break;
                              }
                           }
                        }

                        if(!var34) {
                           class0.method0(var30, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var30 = 0; var30 < 13; ++var30) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = client.field498[0][var30][var3];
                     if(var4 == -1) {
                        class51.method1063(var30 * 8, 8 * var3, 8, 8);
                     }
                  }
               }

               class14.method167(true);

               for(var30 = 0; var30 < 4; ++var30) {
                  class11.method155();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var33 = client.field498[var30][var3][var4];
                        if(var33 != -1) {
                           var6 = var33 >> 24 & 3;
                           var7 = var33 >> 1 & 3;
                           var36 = var33 >> 14 & 1023;
                           var9 = var33 >> 3 & 2047;
                           var10 = var9 / 8 + (var36 / 8 << 8);

                           for(var11 = 0; var11 < class45.field1016.length; ++var11) {
                              if(var10 == class45.field1016[var11] && null != class37.field813[var11]) {
                                 class33.method710(class37.field813[var11], var30, 8 * var3, 8 * var4, var6, (var36 & 7) * 8, (var9 & 7) * 8, var7, class151.field2250, client.field338);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            class14.method167(true);
            class5.method90();
            class11.method155();
            class1.method10(class151.field2250, client.field338);
            class14.method167(true);
            var30 = class5.field81;
            if(var30 > class48.field1063) {
               var30 = class48.field1063;
            }

            if(var30 < class48.field1063 - 1) {
               var30 = class48.field1063 - 1;
            }

            if(client.field285) {
               class151.field2250.method1927(class5.field81);
            } else {
               class151.field2250.method1927(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class31.method680(var3, var4);
               }
            }

            class11.method155();

            for(class16 var35 = (class16)client.field411.method3825(); null != var35; var35 = (class16)client.field411.method3827()) {
               if(var35.field235 == -1) {
                  var35.field234 = 0;
                  class90.method2101(var35);
               } else {
                  var35.method3913();
               }
            }

            class40.field902.method3760();
            if(null != class2.field61) {
               client.field321.method2762(74);
               client.field321.method2617(1057001181);
            }

            if(!client.field339) {
               var3 = (class5.field100 - 6) / 8;
               var4 = (6 + class5.field100) / 8;
               var33 = (class126.field2033 - 6) / 8;
               var6 = (class126.field2033 + 6) / 8;

               for(var7 = var3 - 1; var7 <= 1 + var4; ++var7) {
                  for(var36 = var33 - 1; var36 <= 1 + var6; ++var36) {
                     if(var7 < var3 || var7 > var4 || var36 < var33 || var36 > var6) {
                        class32.field743.method3275("m" + var7 + "_" + var36);
                        class32.field743.method3275("l" + var7 + "_" + var36);
                     }
                  }
               }
            }

            class141.method2971(30);
            class11.method155();
            class84.field1431 = (byte[][][])null;
            class124.field2024 = (byte[][][])null;
            class107.field1856 = (byte[][][])null;
            class5.field82 = (byte[][][])null;
            class4.field74 = (int[][][])null;
            class5.field98 = (byte[][][])null;
            class95.field1602 = (int[][])null;
            class191.field3076 = null;
            class87.field1504 = null;
            class89.field1529 = null;
            class31.field723 = null;
            class5.field84 = null;
            client.field321.method2762(146);
            class4.field75.vmethod3115();

            for(var3 = 0; var3 < 32; ++var3) {
               class144.field2196[var3] = 0L;
            }

            for(var3 = 0; var3 < 32; ++var3) {
               class144.field2197[var3] = 0L;
            }

            class143.field2185 = 0;
         }
      }
   }

   @ObfuscatedName("a")
   public static int method181(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
