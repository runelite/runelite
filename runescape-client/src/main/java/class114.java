import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class114 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   static void method2434() {
      int var0;
      if(client.field432 == 0) {
         class35.field771 = new class86(4, 104, 104, class5.field91);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field482[var0] = new class108(104, 104);
         }

         class25.field621 = new class78(512, 512);
         class31.field711 = "Starting game engine...";
         class31.field730 = 5;
         client.field432 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(20 == client.field432) {
            int[] var37 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 32 * var1 + 128 + 15;
               var3 = 3 * var2 + 600;
               var4 = class91.field1571[var2];
               var37[var1] = var4 * var3 >> 16;
            }

            class86.method1975(var37, 500, 800, 512, 334);
            class31.field711 = "Prepared visibility map";
            class31.field730 = 10;
            client.field432 = 30;
         } else if(30 == client.field432) {
            class101.field1738 = class4.method36(0, false, true, true);
            class26.field646 = class4.method36(1, false, true, true);
            class0.field13 = class4.method36(2, true, false, true);
            class28.field659 = class4.method36(3, false, true, true);
            class101.field1741 = class4.method36(4, false, true, true);
            class158.field2578 = class4.method36(5, true, true, true);
            class135.field2069 = class4.method36(6, true, true, false);
            class26.field628 = class4.method36(7, false, true, true);
            class178.field2917 = class4.method36(8, false, true, true);
            class22.field582 = class4.method36(9, false, true, true);
            client.field306 = class4.method36(10, false, true, true);
            class136.field2080 = class4.method36(11, false, true, true);
            class104.field1776 = class4.method36(12, false, true, true);
            class123.field1997 = class4.method36(13, true, false, true);
            class9.field156 = class4.method36(14, false, true, false);
            class18.field247 = class4.method36(15, false, true, true);
            class31.field711 = "Connecting to update server";
            class31.field730 = 20;
            client.field432 = 40;
         } else if(40 == client.field432) {
            byte var36 = 0;
            var0 = var36 + class101.field1738.method3311() * 4 / 100;
            var0 += class26.field646.method3311() * 4 / 100;
            var0 += class0.field13.method3311() * 2 / 100;
            var0 += class28.field659.method3311() * 2 / 100;
            var0 += class101.field1741.method3311() * 6 / 100;
            var0 += class158.field2578.method3311() * 4 / 100;
            var0 += class135.field2069.method3311() * 2 / 100;
            var0 += class26.field628.method3311() * 60 / 100;
            var0 += class178.field2917.method3311() * 2 / 100;
            var0 += class22.field582.method3311() * 2 / 100;
            var0 += client.field306.method3311() * 2 / 100;
            var0 += class136.field2080.method3311() * 2 / 100;
            var0 += class104.field1776.method3311() * 2 / 100;
            var0 += class123.field1997.method3311() * 2 / 100;
            var0 += class9.field156.method3311() * 2 / 100;
            var0 += class18.field247.method3311() * 2 / 100;
            if(var0 != 100) {
               if(0 != var0) {
                  class31.field711 = "Checking for updates - " + var0 + "%";
               }

               class31.field730 = 30;
            } else {
               class31.field711 = "Loaded update list";
               class31.field730 = 30;
               client.field432 = 45;
            }
         } else {
            class168 var26;
            class168 var28;
            class168 var29;
            if(45 == client.field432) {
               class36.method740(22050, !client.field303, 2);
               class184 var35 = new class184();
               var35.method3597(9, 128);
               class17.field244 = class40.method785(class142.field2153, class3.field66, 0, 22050);
               class17.field244.method1189(var35);
               var26 = class18.field247;
               var28 = class9.field156;
               var29 = class101.field1741;
               class183.field2965 = var26;
               class183.field2956 = var28;
               class183.field2962 = var29;
               class183.field2958 = var35;
               class14.field203 = class40.method785(class142.field2153, class3.field66, 1, 2048);
               class135.field2066 = new class55();
               class14.field203.method1189(class135.field2066);
               class108.field1886 = new class74(22050, class56.field1181);
               class31.field711 = "Prepared sound engine";
               class31.field730 = 35;
               client.field432 = 50;
            } else {
               int var5;
               if(client.field432 == 50) {
                  var0 = 0;
                  class224 var27;
                  if(class188.field3044 == null) {
                     var28 = class178.field2917;
                     var29 = class123.field1997;
                     var4 = var28.method3232("p11_full");
                     var5 = var28.method3233(var4, "");
                     var27 = class59.method1261(var28, var29, var4, var5);
                     class188.field3044 = var27;
                  } else {
                     ++var0;
                  }

                  if(null == class37.field797) {
                     var28 = class178.field2917;
                     var29 = class123.field1997;
                     var4 = var28.method3232("p12_full");
                     var5 = var28.method3233(var4, "");
                     var27 = class59.method1261(var28, var29, var4, var5);
                     class37.field797 = var27;
                  } else {
                     ++var0;
                  }

                  if(null == class95.field1606) {
                     var28 = class178.field2917;
                     var29 = class123.field1997;
                     var4 = var28.method3232("b12_full");
                     var5 = var28.method3233(var4, "");
                     var27 = class59.method1261(var28, var29, var4, var5);
                     class95.field1606 = var27;
                  } else {
                     ++var0;
                  }

                  if(var0 < 3) {
                     class31.field711 = "Loading fonts - " + 100 * var0 / 3 + "%";
                     class31.field730 = 40;
                  } else {
                     class3.field70 = new class160(true);
                     class31.field711 = "Loaded fonts";
                     class31.field730 = 40;
                     client.field432 = 60;
                  }
               } else if(client.field432 == 60) {
                  var26 = client.field306;
                  var28 = class178.field2917;
                  var3 = 0;
                  if(var26.method3247("title.jpg", "")) {
                     ++var3;
                  }

                  if(var28.method3247("logo", "")) {
                     ++var3;
                  }

                  if(var28.method3247("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var28.method3247("titlebox", "")) {
                     ++var3;
                  }

                  if(var28.method3247("titlebutton", "")) {
                     ++var3;
                  }

                  if(var28.method3247("runes", "")) {
                     ++var3;
                  }

                  if(var28.method3247("title_mute", "")) {
                     ++var3;
                  }

                  if(var28.method3236("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var28.method3236("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var28.method3247("sl_back", "");
                  var28.method3247("sl_flags", "");
                  var28.method3247("sl_arrows", "");
                  var28.method3247("sl_stars", "");
                  var28.method3247("sl_button", "");
                  var4 = class96.method2191();
                  if(var3 < var4) {
                     class31.field711 = "Loading title screen - " + var3 * 100 / var4 + "%";
                     class31.field730 = 50;
                  } else {
                     class31.field711 = "Loaded title screen";
                     class31.field730 = 50;
                     class13.method162(5);
                     client.field432 = 70;
                  }
               } else if(70 == client.field432) {
                  if(!class0.field13.method3254()) {
                     class31.field711 = "Loading config - " + class0.field13.method3304() + "%";
                     class31.field730 = 60;
                  } else {
                     class168 var34 = class0.field13;
                     class46.field1043 = var34;
                     class28.method646(class0.field13);
                     var26 = class0.field13;
                     var28 = class26.field628;
                     class44.field1010 = var26;
                     class44.field1014 = var28;
                     class229.field3232 = class44.field1010.method3227(3);
                     var29 = class0.field13;
                     class168 var30 = class26.field628;
                     boolean var31 = client.field303;
                     class40.field905 = var29;
                     class40.field906 = var30;
                     class40.field911 = var31;
                     class168 var6 = class0.field13;
                     class168 var7 = class26.field628;
                     class39.field895 = var6;
                     class177.field2912 = var7;
                     class168 var8 = class0.field13;
                     class168 var9 = class26.field628;
                     boolean var10 = client.field279;
                     class224 var11 = class188.field3044;
                     class51.field1087 = var8;
                     class51.field1135 = var9;
                     class72.field1334 = var10;
                     class51.field1126 = class51.field1087.method3227(10);
                     class209.field3128 = var11;
                     class168 var12 = class0.field13;
                     class168 var13 = class101.field1738;
                     class168 var14 = class26.field646;
                     class42.field980 = var12;
                     class42.field968 = var13;
                     class42.field969 = var14;
                     class168 var15 = class0.field13;
                     class168 var16 = class26.field628;
                     class219.field3172 = var15;
                     class43.field1004 = var16;
                     class168 var17 = class0.field13;
                     class47.field1056 = var17;
                     class168 var18 = class0.field13;
                     class52.field1149 = var18;
                     class52.field1142 = class52.field1149.method3227(16);
                     class168 var19 = class28.field659;
                     class168 var20 = class26.field628;
                     class168 var21 = class178.field2917;
                     class168 var22 = class123.field1997;
                     class173.field2736 = var19;
                     class222.field3185 = var20;
                     class213.field3155 = var21;
                     class173.field2737 = var22;
                     class173.field2735 = new class173[class173.field2736.method3250()][];
                     class173.field2792 = new boolean[class173.field2736.method3250()];
                     class168 var23 = class0.field13;
                     class50.field1082 = var23;
                     class17.method192(class0.field13);
                     class168 var24 = class0.field13;
                     class45.field1028 = var24;
                     class168 var25 = class0.field13;
                     class49.field1072 = var25;
                     class27.field651 = new class19();
                     class31.field711 = "Loaded config";
                     class31.field730 = 60;
                     client.field432 = 80;
                  }
               } else if(80 != client.field432) {
                  if(client.field432 == 90) {
                     if(!class22.field582.method3254()) {
                        class31.field711 = "Loading textures - " + class22.field582.method3304() + "%";
                        class31.field730 = 90;
                     } else {
                        class95 var33 = new class95(class22.field582, class178.field2917, 20, 0.8D, client.field303?64:128);
                        class91.method2091(var33);
                        class91.method2097(0.8D);
                        class31.field711 = "Loaded textures";
                        class31.field730 = 90;
                        client.field432 = 110;
                     }
                  } else if(client.field432 == 110) {
                     class226.field3215 = new class13();
                     class142.field2153.method2851(class226.field3215, 10);
                     class31.field711 = "Loaded input handler";
                     class31.field730 = 94;
                     client.field432 = 120;
                  } else if(client.field432 == 120) {
                     if(!client.field306.method3247("huffman", "")) {
                        class31.field711 = "Loading wordpack - " + 0 + "%";
                        class31.field730 = 96;
                     } else {
                        class113 var32 = new class113(client.field306.method3234("huffman", ""));
                        class163.field2644 = var32;
                        class31.field711 = "Loaded wordpack";
                        class31.field730 = 96;
                        client.field432 = 130;
                     }
                  } else if(130 == client.field432) {
                     if(!class28.field659.method3254()) {
                        class31.field711 = "Loading interfaces - " + class28.field659.method3304() * 4 / 5 + "%";
                        class31.field730 = 100;
                     } else if(!class104.field1776.method3254()) {
                        class31.field711 = "Loading interfaces - " + (80 + class104.field1776.method3304() / 6) + "%";
                        class31.field730 = 100;
                     } else if(!class123.field1997.method3254()) {
                        class31.field711 = "Loading interfaces - " + (96 + class123.field1997.method3304() / 20) + "%";
                        class31.field730 = 100;
                     } else {
                        class31.field711 = "Loaded interfaces";
                        class31.field730 = 100;
                        client.field432 = 140;
                     }
                  } else if(client.field432 == 140) {
                     class13.method162(10);
                  }
               } else {
                  var0 = 0;
                  if(class14.field202 == null) {
                     class14.field202 = class167.method3295(class178.field2917, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(class151.field2239 == null) {
                     class151.field2239 = class167.method3295(class178.field2917, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(null == class9.field158) {
                     class9.field158 = class34.method722(class178.field2917, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class101.field1726 == null) {
                     class101.field1726 = class95.method2186(class178.field2917, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(null == class15.field219) {
                     class15.field219 = class95.method2186(class178.field2917, "hitmarks", "");
                  } else {
                     ++var0;
                  }

                  if(null == class15.field220) {
                     class15.field220 = class95.method2186(class178.field2917, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(null == class210.field3137) {
                     class210.field3137 = class95.method2186(class178.field2917, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(null == class129.field2029) {
                     class129.field2029 = class95.method2186(class178.field2917, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(null == class108.field1881) {
                     class108.field1881 = class95.method2186(class178.field2917, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(null == client.field555) {
                     client.field555 = class95.method2186(class178.field2917, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(client.field352 == null) {
                     client.field352 = class95.method2186(class178.field2917, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class209.field3126 == null) {
                     class209.field3126 = class34.method722(class178.field2917, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(null == class50.field1081) {
                     class50.field1081 = class34.method722(class178.field2917, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 13) {
                     class31.field711 = "Loading sprites - " + var0 * 100 / 13 + "%";
                     class31.field730 = 70;
                  } else {
                     class223.field3199 = class50.field1081;
                     class151.field2239.method1692();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(var5 = 0; var5 < class101.field1726.length; ++var5) {
                        class101.field1726[var5].method1691(var1 + var4, var4 + var2, var4 + var3);
                     }

                     class9.field158[0].method1856(var1 + var4, var2 + var4, var3 + var4);
                     class31.field711 = "Loaded sprites";
                     class31.field730 = 70;
                     client.field432 = 90;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   public static void method2435() {
      if(class140.field2124 != null) {
         class140 var0 = class140.field2124;
         synchronized(class140.field2124) {
            class140.field2124 = null;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-118576995"
   )
   static void method2436(String var0, String var1, String var2) {
      class31.field714 = var0;
      class31.field729 = var1;
      class31.field716 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIB)[Lclass80;",
      garbageValue = "28"
   )
   static class80[] method2437(class167 var0, int var1, int var2) {
      if(!class31.method691(var0, var1, var2)) {
         return null;
      } else {
         class80[] var4 = new class80[class76.field1368];

         for(int var5 = 0; var5 < class76.field1368; ++var5) {
            class80 var6 = var4[var5] = new class80();
            var6.field1407 = class76.field1364;
            var6.field1408 = class129.field2027;
            var6.field1406 = class76.field1366[var5];
            var6.field1404 = class76.field1367[var5];
            var6.field1403 = class52.field1145[var5];
            var6.field1401 = class76.field1371[var5];
            var6.field1405 = class227.field3220;
            var6.field1402 = client.field557[var5];
         }

         class157.method3133();
         return var4;
      }
   }
}
