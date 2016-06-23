import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("u")
   @Export("previousName")
   String field248;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 221357945
   )
   @Export("world")
   int field249;
   @ObfuscatedName("l")
   boolean field251;
   @ObfuscatedName("d")
   boolean field252;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 1767647453
   )
   static int field253;
   @ObfuscatedName("f")
   @Export("name")
   String field254;
   @ObfuscatedName("be")
   static class168 field255;
   @ObfuscatedName("q")
   public static class228[] field257;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -451194237
   )
   @Export("rank")
   int field260;
   @ObfuscatedName("bq")
   static class168 field261;

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "-1332639041"
   )
   static final boolean method199(class173 var0) {
      if(var0.field2867 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2867.length; ++var1) {
            int var2 = class101.method2344(var0, var1);
            int var3 = var0.field2868[var1];
            if(var0.field2867[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2867[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2867[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass37;B)V",
      garbageValue = "35"
   )
   static final void method200(class37 var0) {
      var0.field849 = var0.field826;
      if(var0.field874 == 0) {
         var0.field865 = 0;
      } else {
         if(var0.field822 != -1 && var0.field855 == 0) {
            class42 var1 = class34.method768(var0.field822);
            if(var0.field879 > 0 && var1.field1008 == 0) {
               ++var0.field865;
               return;
            }

            if(var0.field879 <= 0 && var1.field997 == 0) {
               ++var0.field865;
               return;
            }
         }

         int var10 = var0.field837;
         int var2 = var0.field880;
         int var3 = var0.field825 * 64 + var0.field875[var0.field874 - 1] * 128;
         int var4 = var0.field825 * 64 + var0.field876[var0.field874 - 1] * 128;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field871 = 1280;
            } else if(var2 > var4) {
               var0.field871 = 1792;
            } else {
               var0.field871 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field871 = 768;
            } else if(var2 > var4) {
               var0.field871 = 256;
            } else {
               var0.field871 = 512;
            }
         } else if(var2 < var4) {
            var0.field871 = 1024;
         } else if(var2 > var4) {
            var0.field871 = 0;
         }

         byte var5 = var0.field828[var0.field874 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field871 - var0.field883 & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field830;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field829;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field832;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field831;
            }

            if(var7 == -1) {
               var7 = var0.field829;
            }

            var0.field849 = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof class34) {
               var9 = ((class34)var0).field782.field933;
            }

            if(var9) {
               if(var0.field883 != var0.field871 && var0.field846 == -1 && var0.field873 != 0) {
                  var8 = 2;
               }

               if(var0.field874 > 2) {
                  var8 = 6;
               }

               if(var0.field874 > 3) {
                  var8 = 8;
               }

               if(var0.field865 > 0 && var0.field874 > 1) {
                  var8 = 8;
                  --var0.field865;
               }
            } else {
               if(var0.field874 > 1) {
                  var8 = 6;
               }

               if(var0.field874 > 2) {
                  var8 = 8;
               }

               if(var0.field865 > 0 && var0.field874 > 1) {
                  var8 = 8;
                  --var0.field865;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field849 == var0.field829 && var0.field833 != -1) {
               var0.field849 = var0.field833;
            }

            if(var3 != var10 || var2 != var4) {
               if(var10 < var3) {
                  var0.field837 += var8;
                  if(var0.field837 > var3) {
                     var0.field837 = var3;
                  }
               } else if(var10 > var3) {
                  var0.field837 -= var8;
                  if(var0.field837 < var3) {
                     var0.field837 = var3;
                  }
               }

               if(var2 < var4) {
                  var0.field880 += var8;
                  if(var0.field880 > var4) {
                     var0.field880 = var4;
                  }
               } else if(var2 > var4) {
                  var0.field880 -= var8;
                  if(var0.field880 < var4) {
                     var0.field880 = var4;
                  }
               }
            }

            if(var0.field837 == var3 && var4 == var0.field880) {
               --var0.field874;
               if(var0.field879 > 0) {
                  --var0.field879;
               }
            }

         } else {
            var0.field837 = var3;
            var0.field880 = var4;
            --var0.field874;
            if(var0.field879 > 0) {
               --var0.field879;
            }

         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1881304630"
   )
   static void method201() {
      int var0;
      if(client.field320 == 0) {
         class129.field2056 = new class86(4, 104, 104, class5.field99);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field350[var0] = new class108(104, 104);
         }

         class178.field2911 = new class78(512, 512);
         class31.field740 = "Starting game engine...";
         class31.field728 = 5;
         client.field320 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(client.field320 == 20) {
            int[] var17 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 32 * var1 + 128 + 15;
               var3 = 600 + var2 * 3;
               var4 = class91.field1597[var2];
               var17[var1] = var4 * var3 >> 16;
            }

            class86.method1984(var17, 500, 800, 512, 334);
            class31.field740 = "Prepared visibility map";
            class31.field728 = 10;
            client.field320 = 30;
         } else if(client.field320 == 30) {
            class131.field2068 = class75.method1700(0, false, true, true);
            class130.field2062 = class75.method1700(1, false, true, true);
            class11.field177 = class75.method1700(2, true, false, true);
            class8.field143 = class75.method1700(3, false, true, true);
            class136.field2101 = class75.method1700(4, false, true, true);
            class89.field1563 = class75.method1700(5, true, true, true);
            field261 = class75.method1700(6, true, true, false);
            class113.field1971 = class75.method1700(7, false, true, true);
            class108.field1909 = class75.method1700(8, false, true, true);
            class38.field889 = class75.method1700(9, false, true, true);
            class29.field702 = class75.method1700(10, false, true, true);
            class152.field2257 = class75.method1700(11, false, true, true);
            field255 = class75.method1700(12, false, true, true);
            class186.field3004 = class75.method1700(13, true, false, true);
            class144.field2208 = class75.method1700(14, false, true, false);
            class31.field746 = class75.method1700(15, false, true, true);
            class31.field740 = "Connecting to update server";
            class31.field728 = 20;
            client.field320 = 40;
         } else if(client.field320 == 40) {
            byte var19 = 0;
            var0 = var19 + class131.field2068.method3362() * 4 / 100;
            var0 += class130.field2062.method3362() * 4 / 100;
            var0 += class11.field177.method3362() * 2 / 100;
            var0 += class8.field143.method3362() * 2 / 100;
            var0 += class136.field2101.method3362() * 6 / 100;
            var0 += class89.field1563.method3362() * 4 / 100;
            var0 += field261.method3362() * 2 / 100;
            var0 += class113.field1971.method3362() * 60 / 100;
            var0 += class108.field1909.method3362() * 2 / 100;
            var0 += class38.field889.method3362() * 2 / 100;
            var0 += class29.field702.method3362() * 2 / 100;
            var0 += class152.field2257.method3362() * 2 / 100;
            var0 += field255.method3362() * 2 / 100;
            var0 += class186.field3004.method3362() * 2 / 100;
            var0 += class144.field2208.method3362() * 2 / 100;
            var0 += class31.field746.method3362() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class31.field740 = "Checking for updates - " + var0 + "%";
               }

               class31.field728 = 30;
            } else {
               class31.field740 = "Loaded update list";
               class31.field728 = 30;
               client.field320 = 45;
            }
         } else if(client.field320 == 45) {
            class48.method1041(22050, !client.field296, 2);
            class184 var16 = new class184();
            var16.method3747(9, 128);
            class39.field923 = class1.method11(class7.field136, class89.field1567, 0, 22050);
            class39.field923.method1238(var16);
            class16.method196(class31.field746, class144.field2208, class136.field2101, var16);
            class6.field128 = class1.method11(class7.field136, class89.field1567, 1, 2048);
            class121.field2014 = new class55();
            class6.field128.method1238(class121.field2014);
            class12.field194 = new class74(22050, class56.field1196);
            class31.field740 = "Prepared sound engine";
            class31.field728 = 35;
            client.field320 = 50;
         } else if(client.field320 == 50) {
            var0 = 0;
            if(class31.field737 == null) {
               class31.field737 = class52.method1138(class108.field1909, class186.field3004, "p11_full", "");
            } else {
               ++var0;
            }

            if(null == class36.field814) {
               class36.field814 = class52.method1138(class108.field1909, class186.field3004, "p12_full", "");
            } else {
               ++var0;
            }

            if(class32.field758 == null) {
               class32.field758 = class52.method1138(class108.field1909, class186.field3004, "b12_full", "");
            } else {
               ++var0;
            }

            if(var0 < 3) {
               class31.field740 = "Loading fonts - " + var0 * 100 / 3 + "%";
               class31.field728 = 40;
            } else {
               class46.field1074 = new class160(true);
               class31.field740 = "Loaded fonts";
               class31.field728 = 40;
               client.field320 = 60;
            }
         } else {
            class168 var10;
            class168 var18;
            if(client.field320 == 60) {
               var18 = class29.field702;
               var10 = class108.field1909;
               var3 = 0;
               if(var18.method3348("title.jpg", "")) {
                  ++var3;
               }

               if(var10.method3348("logo", "")) {
                  ++var3;
               }

               if(var10.method3348("logo_deadman_mode", "")) {
                  ++var3;
               }

               if(var10.method3348("titlebox", "")) {
                  ++var3;
               }

               if(var10.method3348("titlebutton", "")) {
                  ++var3;
               }

               if(var10.method3348("runes", "")) {
                  ++var3;
               }

               if(var10.method3348("title_mute", "")) {
                  ++var3;
               }

               if(var10.method3324("options_radio_buttons,0")) {
                  ++var3;
               }

               if(var10.method3324("options_radio_buttons,2")) {
                  ++var3;
               }

               var10.method3348("sl_back", "");
               var10.method3348("sl_flags", "");
               var10.method3348("sl_arrows", "");
               var10.method3348("sl_stars", "");
               var10.method3348("sl_button", "");
               byte var13 = 9;
               if(var3 < var13) {
                  class31.field740 = "Loading title screen - " + var3 * 100 / var13 + "%";
                  class31.field728 = 50;
               } else {
                  class31.field740 = "Loaded title screen";
                  class31.field728 = 50;
                  class11.method156(5);
                  client.field320 = 70;
               }
            } else if(client.field320 == 70) {
               if(!class11.field177.method3290()) {
                  class31.field740 = "Loading config - " + class11.field177.method3370() + "%";
                  class31.field728 = 60;
               } else {
                  class12.method166(class11.field177);
                  class168 var15 = class11.field177;
                  class41.field993 = var15;
                  class98.method2266(class11.field177, class113.field1971);
                  class111.method2475(class11.field177, class113.field1971, client.field296);
                  class106.method2420(class11.field177, class113.field1971);
                  class18.method208(class11.field177, class113.field1971, client.field410, class31.field737);
                  var18 = class11.field177;
                  var10 = class131.field2068;
                  class168 var8 = class130.field2062;
                  class42.field1011 = var18;
                  class42.field998 = var10;
                  class42.field1000 = var8;
                  class168 var11 = class11.field177;
                  class168 var12 = class113.field1971;
                  class43.field1038 = var11;
                  class43.field1021 = var12;
                  class16.method195(class11.field177);
                  class75.method1697(class11.field177);
                  class46.method1007(class8.field143, class113.field1971, class108.field1909, class186.field3004);
                  class59.method1330(class11.field177);
                  class168 var6 = class11.field177;
                  class48.field1092 = var6;
                  class37.method802(class11.field177);
                  class7.method111(class11.field177);
                  class3.field65 = new class19();
                  class31.field740 = "Loaded config";
                  class31.field728 = 60;
                  client.field320 = 80;
               }
            } else if(client.field320 != 80) {
               if(client.field320 == 90) {
                  if(!class38.field889.method3290()) {
                     class31.field740 = "Loading textures - " + class38.field889.method3370() + "%";
                     class31.field728 = 90;
                  } else {
                     class95 var14 = new class95(class38.field889, class108.field1909, 20, 0.8D, client.field296?64:128);
                     class91.method2207(var14);
                     class91.method2182(0.8D);
                     class31.field740 = "Loaded textures";
                     class31.field728 = 90;
                     client.field320 = 110;
                  }
               } else if(client.field320 == 110) {
                  client.field473 = new class13();
                  class7.field136.method2903(client.field473, 10);
                  class31.field740 = "Loaded input handler";
                  class31.field728 = 94;
                  client.field320 = 120;
               } else if(client.field320 == 120) {
                  if(!class29.field702.method3348("huffman", "")) {
                     class31.field740 = "Loading wordpack - " + 0 + "%";
                     class31.field728 = 96;
                  } else {
                     class113 var7 = new class113(class29.field702.method3302("huffman", ""));
                     class222.field3181 = var7;
                     class31.field740 = "Loaded wordpack";
                     class31.field728 = 96;
                     client.field320 = 130;
                  }
               } else if(client.field320 == 130) {
                  if(!class8.field143.method3290()) {
                     class31.field740 = "Loading interfaces - " + class8.field143.method3370() * 4 / 5 + "%";
                     class31.field728 = 100;
                  } else if(!field255.method3290()) {
                     class31.field740 = "Loading interfaces - " + (80 + field255.method3370() / 6) + "%";
                     class31.field728 = 100;
                  } else if(!class186.field3004.method3290()) {
                     class31.field740 = "Loading interfaces - " + (96 + class186.field3004.method3370() / 20) + "%";
                     class31.field728 = 100;
                  } else {
                     class31.field740 = "Loaded interfaces";
                     class31.field728 = 100;
                     client.field320 = 140;
                  }
               } else if(client.field320 == 140) {
                  class11.method156(10);
               }
            } else {
               var0 = 0;
               class78 var9;
               if(null == class9.field165) {
                  var10 = class108.field1909;
                  var3 = var10.method3300("compass");
                  var4 = var10.method3301(var3, "");
                  var9 = class46.method1018(var10, var3, var4);
                  class9.field165 = var9;
               } else {
                  ++var0;
               }

               if(null == class189.field3051) {
                  var10 = class108.field1909;
                  var3 = var10.method3300("mapedge");
                  var4 = var10.method3301(var3, "");
                  var9 = class46.method1018(var10, var3, var4);
                  class189.field3051 = var9;
               } else {
                  ++var0;
               }

               if(class14.field211 == null) {
                  class14.field211 = client.method595(class108.field1909, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class8.field144 == null) {
                  class8.field144 = class8.method128(class108.field1909, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(class138.field2139 == null) {
                  class138.field2139 = class8.method128(class108.field1909, "hitmarks", "");
               } else {
                  ++var0;
               }

               if(null == class156.field2305) {
                  class156.field2305 = class8.method128(class108.field1909, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(null == class87.field1541) {
                  class87.field1541 = class8.method128(class108.field1909, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(null == class9.field164) {
                  class9.field164 = class8.method128(class108.field1909, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(class5.field104 == null) {
                  class5.field104 = class8.method128(class108.field1909, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(null == class30.field711) {
                  class30.field711 = class8.method128(class108.field1909, "cross", "");
               } else {
                  ++var0;
               }

               if(null == class111.field1959) {
                  class111.field1959 = class8.method128(class108.field1909, "mapdots", "");
               } else {
                  ++var0;
               }

               if(null == class159.field2597) {
                  class159.field2597 = client.method595(class108.field1909, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class111.field1962 == null) {
                  class111.field1962 = client.method595(class108.field1909, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 13) {
                  class31.field740 = "Loading sprites - " + 100 * var0 / 13 + "%";
                  class31.field728 = 70;
               } else {
                  class223.field3191 = class111.field1962;
                  class189.field3051.method1808();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var5 = 0; var5 < class8.field144.length; ++var5) {
                     class8.field144[var5].method1828(var1 + var4, var4 + var2, var3 + var4);
                  }

                  class14.field211[0].method1913(var4 + var1, var2 + var4, var3 + var4);
                  class31.field740 = "Loaded sprites";
                  class31.field728 = 70;
                  client.field320 = 90;
               }
            }
         }
      }
   }
}
