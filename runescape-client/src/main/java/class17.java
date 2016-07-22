import java.awt.Image;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2014432063
   )
   @Export("world")
   int field223;
   @ObfuscatedName("w")
   @Export("previousName")
   String field224;
   @ObfuscatedName("k")
   public static short[][] field225;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -439169039
   )
   @Export("rank")
   int field226;
   @ObfuscatedName("g")
   boolean field227;
   @ObfuscatedName("l")
   boolean field228;
   @ObfuscatedName("m")
   @Export("name")
   String field229;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1961163965
   )
   static int field232;
   @ObfuscatedName("qh")
   protected static Image field233;
   @ObfuscatedName("aw")
   static boolean field235;
   @ObfuscatedName("mk")
   @Export("clanMembers")
   static class25[] field236;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1818341901"
   )
   static void method184() {
      int var0;
      if(client.field509 == 0) {
         class5.field91 = new class89(4, 104, 104, class5.field77);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field331[var0] = new class111(104, 104);
         }

         class20.field561 = new class81(512, 512);
         class33.field746 = "Starting game engine...";
         class33.field747 = 5;
         client.field509 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(client.field509 == 20) {
            int[] var28 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 128 + var1 * 32 + 15;
               var3 = 3 * var2 + 600;
               var4 = class94.field1660[var2];
               var28[var1] = var3 * var4 >> 16;
            }

            class89.method2033(var28, 500, 800, 512, 334);
            class33.field746 = "Prepared visibility map";
            class33.field747 = 10;
            client.field509 = 30;
         } else if(client.field509 == 30) {
            class22.field584 = class15.method177(0, false, true, true);
            class217.field3199 = class15.method177(1, false, true, true);
            class56.field1231 = class15.method177(2, true, false, true);
            class50.field1115 = class15.method177(3, false, true, true);
            class127.field2083 = class15.method177(4, false, true, true);
            class129.field2097 = class15.method177(5, true, true, true);
            class38.field814 = class15.method177(6, true, true, false);
            class184.field2985 = class15.method177(7, false, true, true);
            class42.field993 = class15.method177(8, false, true, true);
            class157.field2345 = class15.method177(9, false, true, true);
            class40.field895 = class15.method177(10, false, true, true);
            class139.field2155 = class15.method177(11, false, true, true);
            class182.field2967 = class15.method177(12, false, true, true);
            class87.field1531 = class15.method177(13, true, false, true);
            class40.field899 = class15.method177(14, false, true, false);
            class20.field559 = class15.method177(15, false, true, true);
            class33.field746 = "Connecting to update server";
            class33.field747 = 20;
            client.field509 = 40;
         } else if(client.field509 == 40) {
            byte var25 = 0;
            var0 = var25 + class22.field584.method3383() * 4 / 100;
            var0 += class217.field3199.method3383() * 4 / 100;
            var0 += class56.field1231.method3383() * 2 / 100;
            var0 += class50.field1115.method3383() * 2 / 100;
            var0 += class127.field2083.method3383() * 6 / 100;
            var0 += class129.field2097.method3383() * 4 / 100;
            var0 += class38.field814.method3383() * 2 / 100;
            var0 += class184.field2985.method3383() * 60 / 100;
            var0 += class42.field993.method3383() * 2 / 100;
            var0 += class157.field2345.method3383() * 2 / 100;
            var0 += class40.field895.method3383() * 2 / 100;
            var0 += class139.field2155.method3383() * 2 / 100;
            var0 += class182.field2967.method3383() * 2 / 100;
            var0 += class87.field1531.method3383() * 2 / 100;
            var0 += class40.field899.method3383() * 2 / 100;
            var0 += class20.field559.method3383() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class33.field746 = "Checking for updates - " + var0 + "%";
               }

               class33.field747 = 30;
            } else {
               class33.field746 = "Loaded update list";
               class33.field747 = 30;
               client.field509 = 45;
            }
         } else {
            class171 var19;
            class171 var21;
            class171 var22;
            if(client.field509 == 45) {
               boolean var24 = !client.field277;
               class59.field1268 = 22050;
               class59.field1247 = var24;
               class59.field1262 = 2;
               class187 var29 = new class187();
               var29.method3766(9, 128);
               class36.field799 = class25.method598(class40.field900, class112.field1965, 0, 22050);
               class36.field799.method1249(var29);
               var19 = class20.field559;
               var21 = class40.field899;
               var22 = class127.field2083;
               class186.field3011 = var19;
               class186.field3005 = var21;
               class186.field3006 = var22;
               class186.field3007 = var29;
               class158.field2354 = class25.method598(class40.field900, class112.field1965, 1, 2048);
               class18.field254 = new class58();
               class158.field2354.method1249(class18.field254);
               class31.field718 = new class77(22050, class59.field1268);
               class33.field746 = "Prepared sound engine";
               class33.field747 = 35;
               client.field509 = 50;
            } else if(client.field509 == 50) {
               var0 = 0;
               if(class12.field171 == null) {
                  class12.field171 = class8.method115(class42.field993, class87.field1531, "p11_full", "");
               } else {
                  ++var0;
               }

               if(null == class15.field201) {
                  class15.field201 = class8.method115(class42.field993, class87.field1531, "p12_full", "");
               } else {
                  ++var0;
               }

               if(class1.field25 == null) {
                  class1.field25 = class8.method115(class42.field993, class87.field1531, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class33.field746 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class33.field747 = 40;
               } else {
                  class21.field577 = new class163(true);
                  class33.field746 = "Loaded fonts";
                  class33.field747 = 40;
                  client.field509 = 60;
               }
            } else {
               class171 var20;
               if(client.field509 == 60) {
                  var20 = class40.field895;
                  var19 = class42.field993;
                  var3 = 0;
                  if(var20.method3322("title.jpg", "")) {
                     ++var3;
                  }

                  if(var19.method3322("logo", "")) {
                     ++var3;
                  }

                  if(var19.method3322("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var19.method3322("titlebox", "")) {
                     ++var3;
                  }

                  if(var19.method3322("titlebutton", "")) {
                     ++var3;
                  }

                  if(var19.method3322("runes", "")) {
                     ++var3;
                  }

                  if(var19.method3322("title_mute", "")) {
                     ++var3;
                  }

                  if(var19.method3345("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var19.method3345("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var19.method3322("sl_back", "");
                  var19.method3322("sl_flags", "");
                  var19.method3322("sl_arrows", "");
                  var19.method3322("sl_stars", "");
                  var19.method3322("sl_button", "");
                  var4 = class38.method768();
                  if(var3 < var4) {
                     class33.field746 = "Loading title screen - " + var3 * 100 / var4 + "%";
                     class33.field747 = 50;
                  } else {
                     class33.field746 = "Loaded title screen";
                     class33.field747 = 50;
                     class171.method3414(5);
                     client.field509 = 70;
                  }
               } else if(client.field509 == 70) {
                  if(!class56.field1231.method3308()) {
                     class33.field746 = "Loading config - " + class56.field1231.method3390() + "%";
                     class33.field747 = 60;
                  } else {
                     class39.method787(class56.field1231);
                     class48.method1017(class56.field1231);
                     class171 var27 = class56.field1231;
                     var20 = class184.field2985;
                     class46.field1049 = var27;
                     class169.field2722 = var20;
                     class46.field1058 = class46.field1049.method3317(3);
                     class88.method1997(class56.field1231, class184.field2985, client.field277);
                     var19 = class56.field1231;
                     var21 = class184.field2985;
                     class41.field928 = var19;
                     class41.field904 = var21;
                     var22 = class56.field1231;
                     class171 var5 = class184.field2985;
                     boolean var6 = client.field276;
                     class227 var7 = class12.field171;
                     class55.field1230 = var22;
                     class134.field2118 = var5;
                     class55.field1175 = var6;
                     class229.field3261 = class55.field1230.method3317(10);
                     class80.field1473 = var7;
                     class55.method1191(class56.field1231, class22.field584, class217.field3199);
                     class138.method2933(class56.field1231, class184.field2985);
                     class171 var8 = class56.field1231;
                     class50.field1108 = var8;
                     class38.method762(class56.field1231);
                     class171 var9 = class50.field1115;
                     class171 var10 = class184.field2985;
                     class171 var11 = class42.field993;
                     class171 var12 = class87.field1531;
                     class176.field2889 = var9;
                     class176.field2788 = var10;
                     class159.field2367 = var11;
                     class25.field628 = var12;
                     class176.field2814 = new class176[class176.field2889.method3306()][];
                     class219.field3209 = new boolean[class176.field2889.method3306()];
                     class171 var13 = class56.field1231;
                     class54.field1170 = var13;
                     class33.method709(class56.field1231);
                     class171 var14 = class56.field1231;
                     class47.field1068 = var14;
                     class51.method1091(class56.field1231);
                     class33.field764 = new class19();
                     class171 var15 = class56.field1231;
                     class171 var16 = class42.field993;
                     class171 var17 = class87.field1531;
                     class51.field1137 = var15;
                     class51.field1125 = var16;
                     class51.field1120 = var17;
                     class13.method157(class56.field1231, class42.field993);
                     class33.field746 = "Loaded config";
                     class33.field747 = 60;
                     client.field509 = 80;
                  }
               } else if(client.field509 != 80) {
                  if(client.field509 == 90) {
                     if(!class157.field2345.method3308()) {
                        class33.field746 = "Loading textures - " + class157.field2345.method3390() + "%";
                        class33.field747 = 90;
                     } else {
                        class98 var26 = new class98(class157.field2345, class42.field993, 20, 0.8D, client.field277?64:128);
                        class94.method2202(var26);
                        class94.method2167(0.8D);
                        class33.field746 = "Loaded textures";
                        class33.field747 = 90;
                        client.field509 = 110;
                     }
                  } else if(client.field509 == 110) {
                     class62.field1289 = new class13();
                     class40.field900.method2937(class62.field1289, 10);
                     class33.field746 = "Loaded input handler";
                     class33.field747 = 94;
                     client.field509 = 120;
                  } else if(client.field509 == 120) {
                     if(!class40.field895.method3322("huffman", "")) {
                        class33.field746 = "Loading wordpack - " + 0 + "%";
                        class33.field747 = 96;
                     } else {
                        class116 var18 = new class116(class40.field895.method3334("huffman", ""));
                        class154.method3193(var18);
                        class33.field746 = "Loaded wordpack";
                        class33.field747 = 96;
                        client.field509 = 130;
                     }
                  } else if(client.field509 == 130) {
                     if(!class50.field1115.method3308()) {
                        class33.field746 = "Loading interfaces - " + class50.field1115.method3390() * 4 / 5 + "%";
                        class33.field747 = 100;
                     } else if(!class182.field2967.method3308()) {
                        class33.field746 = "Loading interfaces - " + (80 + class182.field2967.method3390() / 6) + "%";
                        class33.field747 = 100;
                     } else if(!class87.field1531.method3308()) {
                        class33.field746 = "Loading interfaces - " + (96 + class87.field1531.method3390() / 20) + "%";
                        class33.field747 = 100;
                     } else {
                        class33.field746 = "Loaded interfaces";
                        class33.field747 = 100;
                        client.field509 = 140;
                     }
                  } else if(client.field509 == 140) {
                     class171.method3414(10);
                  }
               } else {
                  var0 = 0;
                  if(null == class222.field3215) {
                     class222.field3215 = class28.method647(class42.field993, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(null == class75.field1428) {
                     class75.field1428 = class28.method647(class42.field993, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(class153.field2310 == null) {
                     class153.field2310 = class9.method121(class42.field993, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(null == class24.field608) {
                     class24.field608 = class62.method1336(class42.field993, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(null == class14.field187) {
                     class14.field187 = class62.method1336(class42.field993, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(null == client.field348) {
                     client.field348 = class62.method1336(class42.field993, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(null == class54.field1165) {
                     class54.field1165 = class62.method1336(class42.field993, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class8.field131 == null) {
                     class8.field131 = class62.method1336(class42.field993, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(null == class11.field161) {
                     class11.field161 = class62.method1336(class42.field993, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(class22.field589 == null) {
                     class22.field589 = class62.method1336(class42.field993, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class177.field2934 == null) {
                     class177.field2934 = class9.method121(class42.field993, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(client.field379 == null) {
                     client.field379 = class9.method121(class42.field993, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 12) {
                     class33.field746 = "Loading sprites - " + 100 * var0 / 12 + "%";
                     class33.field747 = 70;
                  } else {
                     class226.field3236 = client.field379;
                     class75.field1428.method1792();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(int var23 = 0; var23 < class24.field608.length; ++var23) {
                        class24.field608[var23].method1862(var4 + var1, var4 + var2, var3 + var4);
                     }

                     class153.field2310[0].method1945(var4 + var1, var2 + var4, var3 + var4);
                     class33.field746 = "Loaded sprites";
                     class33.field747 = 70;
                     client.field509 = 90;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "2012116055"
   )
   public static class51 method185(int var0) {
      class51 var1 = (class51)class51.field1141.method3817((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class51.field1137.method3304(32, var0);
         var1 = new class51();
         if(null != var2) {
            var1.method1062(new class122(var2));
         }

         class51.field1141.method3823(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "2"
   )
   @Export("loadWorlds")
   static boolean method186() {
      try {
         if(null == class224.field3228) {
            class224.field3228 = new class18(class40.field900, new URL(client.field473));
         } else {
            byte[] var0 = class224.field3228.method189();
            if(null != var0) {
               class122 var1 = new class122(var0);
               class27.field646 = var1.method2706();
               class219.field3210 = new class27[class27.field646];

               class27 var3;
               for(int var2 = 0; var2 < class27.field646; var3.field656 = var2++) {
                  var3 = class219.field3210[var2] = new class27();
                  var3.field650 = var1.method2706();
                  var3.field651 = var1.method2577();
                  var3.field654 = var1.method2580();
                  var3.field645 = var1.method2580();
                  var3.field655 = var1.method2556();
                  var3.field652 = var1.method2575();
               }

               class102.method2282(class219.field3210, 0, class219.field3210.length - 1, class27.field649, class27.field648);
               class224.field3228 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class224.field3228 = null;
      }

      return false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1048951381"
   )
   public static void method187() {
      class176.field2850.method3814();
      class176.field2790.method3814();
      class176.field2791.method3814();
      class176.field2823.method3814();
   }
}
