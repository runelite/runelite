import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public final class class153 {
   @ObfuscatedName("v")
   static int[] field2310;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1073787572"
   )
   static void method3285() {
      int var0;
      if(client.field323 == 0) {
         class136.field2126 = new class89(4, 104, 104, class5.field85);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field354[var0] = new class111(104, 104);
         }

         class23.field619 = new class81(512, 512);
         class33.field758 = "Starting game engine...";
         class33.field757 = 5;
         client.field323 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(client.field323 == 20) {
            int[] var26 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 128 + 32 * var1 + 15;
               var3 = 600 + var2 * 3;
               var4 = class94.field1661[var2];
               var26[var1] = var4 * var3 >> 16;
            }

            class89.method2037(var26, 500, 800, 512, 334);
            class33.field758 = "Prepared visibility map";
            class33.field757 = 10;
            client.field323 = 30;
         } else if(client.field323 == 30) {
            class16.field240 = class48.method1033(0, false, true, true);
            class56.field1236 = class48.method1033(1, false, true, true);
            class78.field1448 = class48.method1033(2, true, false, true);
            class164.field2699 = class48.method1033(3, false, true, true);
            class119.field2039 = class48.method1033(4, false, true, true);
            class80.field1476 = class48.method1033(5, true, true, true);
            class188.field3051 = class48.method1033(6, true, true, false);
            class7.field137 = class48.method1033(7, false, true, true);
            client.field451 = class48.method1033(8, false, true, true);
            class42.field964 = class48.method1033(9, false, true, true);
            class25.field644 = class48.method1033(10, false, true, true);
            class0.field12 = class48.method1033(11, false, true, true);
            class20.field581 = class48.method1033(12, false, true, true);
            class104.field1811 = class48.method1033(13, true, false, true);
            class10.field172 = class48.method1033(14, false, true, false);
            class138.field2139 = class48.method1033(15, false, true, true);
            class33.field758 = "Connecting to update server";
            class33.field757 = 20;
            client.field323 = 40;
         } else if(client.field323 == 40) {
            byte var23 = 0;
            var0 = var23 + class16.field240.method3494() * 4 / 100;
            var0 += class56.field1236.method3494() * 4 / 100;
            var0 += class78.field1448.method3494() * 2 / 100;
            var0 += class164.field2699.method3494() * 2 / 100;
            var0 += class119.field2039.method3494() * 6 / 100;
            var0 += class80.field1476.method3494() * 4 / 100;
            var0 += class188.field3051.method3494() * 2 / 100;
            var0 += class7.field137.method3494() * 60 / 100;
            var0 += client.field451.method3494() * 2 / 100;
            var0 += class42.field964.method3494() * 2 / 100;
            var0 += class25.field644.method3494() * 2 / 100;
            var0 += class0.field12.method3494() * 2 / 100;
            var0 += class20.field581.method3494() * 2 / 100;
            var0 += class104.field1811.method3494() * 2 / 100;
            var0 += class10.field172.method3494() * 2 / 100;
            var0 += class138.field2139.method3494() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class33.field758 = "Checking for updates - " + var0 + "%";
               }

               class33.field757 = 30;
            } else {
               class33.field758 = "Loaded update list";
               class33.field757 = 30;
               client.field323 = 45;
            }
         } else {
            class171 var17;
            class171 var19;
            class171 var20;
            if(client.field323 == 45) {
               boolean var22 = !client.field301;
               class59.field1254 = 22050;
               class59.field1264 = var22;
               class59.field1245 = 2;
               class187 var27 = new class187();
               var27.method3757(9, 128);
               class6.field127 = class10.method141(class125.field2070, class107.field1867, 0, 22050);
               class6.field127.method1317(var27);
               var19 = class138.field2139;
               var20 = class10.field172;
               var17 = class119.field2039;
               class145.field2235 = var19;
               class186.field3012 = var20;
               class159.field2369 = var17;
               class59.field1266 = var27;
               class125.field2069 = class10.method141(class125.field2070, class107.field1867, 1, 2048);
               class20.field585 = new class58();
               class125.field2069.method1317(class20.field585);
               class79.field1463 = new class77(22050, class59.field1254);
               class33.field758 = "Prepared sound engine";
               class33.field757 = 35;
               client.field323 = 50;
            } else if(client.field323 == 50) {
               var0 = 0;
               if(null == class7.field133) {
                  class7.field133 = class23.method596(client.field451, class104.field1811, "p11_full", "");
               } else {
                  ++var0;
               }

               if(class8.field144 == null) {
                  class8.field144 = class23.method596(client.field451, class104.field1811, "p12_full", "");
               } else {
                  ++var0;
               }

               if(null == class59.field1268) {
                  class59.field1268 = class23.method596(client.field451, class104.field1811, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class33.field758 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class33.field757 = 40;
               } else {
                  class3.field69 = new class163(true);
                  class33.field758 = "Loaded fonts";
                  class33.field757 = 40;
                  client.field323 = 60;
               }
            } else if(client.field323 == 60) {
               var0 = class221.method4133(class25.field644, client.field451);
               var1 = class77.method1708();
               if(var0 < var1) {
                  class33.field758 = "Loading title screen - " + var0 * 100 / var1 + "%";
                  class33.field757 = 50;
               } else {
                  class33.field758 = "Loaded title screen";
                  class33.field757 = 50;
                  class138.method3024(5);
                  client.field323 = 70;
               }
            } else if(client.field323 == 70) {
               if(!class78.field1448.method3430()) {
                  class33.field758 = "Loading config - " + class78.field1448.method3492() + "%";
                  class33.field757 = 60;
               } else {
                  class171 var25 = class78.field1448;
                  class48.field1086 = var25;
                  class171 var18 = class78.field1448;
                  class43.field1007 = var18;
                  var19 = class78.field1448;
                  var20 = class7.field137;
                  class46.field1055 = var19;
                  class142.field2197 = var20;
                  class46.field1054 = class46.field1055.method3405(3);
                  var17 = class78.field1448;
                  class171 var21 = class7.field137;
                  boolean var6 = client.field301;
                  class42.field945 = var17;
                  class42.field995 = var21;
                  class42.field958 = var6;
                  class171 var7 = class78.field1448;
                  class171 var8 = class7.field137;
                  class41.field921 = var7;
                  class41.field908 = var8;
                  class8.method123(class78.field1448, class7.field137, client.field520, class7.field133);
                  class171 var9 = class78.field1448;
                  class171 var10 = class16.field240;
                  class171 var11 = class56.field1236;
                  class44.field1013 = var9;
                  class44.field1012 = var10;
                  class44.field1019 = var11;
                  class39.method801(class78.field1448, class7.field137);
                  class42.method876(class78.field1448);
                  class17.method207(class78.field1448);
                  class92.method2160(class164.field2699, class7.field137, client.field451, class104.field1811);
                  class40.method810(class78.field1448);
                  class137.method3017(class78.field1448);
                  class171 var12 = class78.field1448;
                  class47.field1076 = var12;
                  class44.method918(class78.field1448);
                  class39.field869 = new class19();
                  class171 var13 = class78.field1448;
                  class171 var14 = client.field451;
                  class171 var15 = class104.field1811;
                  class51.field1134 = var13;
                  class51.field1127 = var14;
                  class225.field3226 = var15;
                  class20.method570(class78.field1448, client.field451);
                  class33.field758 = "Loaded config";
                  class33.field757 = 60;
                  client.field323 = 80;
               }
            } else if(client.field323 != 80) {
               if(client.field323 == 90) {
                  if(!class42.field964.method3430()) {
                     class33.field758 = "Loading textures - " + class42.field964.method3492() + "%";
                     class33.field757 = 90;
                  } else {
                     class98 var24 = new class98(class42.field964, client.field451, 20, 0.8D, client.field301?64:128);
                     class94.method2221(var24);
                     class94.method2225(0.8D);
                     class33.field758 = "Loaded textures";
                     class33.field757 = 90;
                     client.field323 = 110;
                  }
               } else if(client.field323 == 110) {
                  class3.field68 = new class13();
                  class125.field2070.method3029(class3.field68, 10);
                  class33.field758 = "Loaded input handler";
                  class33.field757 = 94;
                  client.field323 = 120;
               } else if(client.field323 == 120) {
                  if(!class25.field644.method3413("huffman", "")) {
                     class33.field758 = "Loading wordpack - " + 0 + "%";
                     class33.field757 = 96;
                  } else {
                     class116 var16 = new class116(class25.field644.method3412("huffman", ""));
                     class225.field3227 = var16;
                     class33.field758 = "Loaded wordpack";
                     class33.field757 = 96;
                     client.field323 = 130;
                  }
               } else if(client.field323 == 130) {
                  if(!class164.field2699.method3430()) {
                     class33.field758 = "Loading interfaces - " + class164.field2699.method3492() * 4 / 5 + "%";
                     class33.field757 = 100;
                  } else if(!class20.field581.method3430()) {
                     class33.field758 = "Loading interfaces - " + (80 + class20.field581.method3492() / 6) + "%";
                     class33.field757 = 100;
                  } else if(!class104.field1811.method3430()) {
                     class33.field758 = "Loading interfaces - " + (96 + class104.field1811.method3492() / 20) + "%";
                     class33.field757 = 100;
                  } else {
                     class33.field758 = "Loaded interfaces";
                     class33.field757 = 100;
                     client.field323 = 140;
                  }
               } else if(client.field323 == 140) {
                  class138.method3024(10);
               }
            } else {
               var0 = 0;
               if(class171.field2754 == null) {
                  class171.field2754 = class4.method47(client.field451, "compass", "");
               } else {
                  ++var0;
               }

               if(class32.field735 == null) {
                  class32.field735 = class4.method47(client.field451, "mapedge", "");
               } else {
                  ++var0;
               }

               if(null == class90.field1611) {
                  class90.field1611 = class36.method773(client.field451, "mapscene", "");
               } else {
                  ++var0;
               }

               if(null == class50.field1121) {
                  class50.field1121 = class54.method1167(client.field451, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(null == class2.field57) {
                  class2.field57 = class54.method1167(client.field451, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(null == class125.field2066) {
                  class125.field2066 = class54.method1167(client.field451, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class158.field2353 == null) {
                  class158.field2353 = class54.method1167(client.field451, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(client.field463 == null) {
                  client.field463 = class54.method1167(client.field451, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(null == class130.field2101) {
                  class130.field2101 = class54.method1167(client.field451, "cross", "");
               } else {
                  ++var0;
               }

               if(null == class19.field283) {
                  class19.field283 = class54.method1167(client.field451, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class110.field1947 == null) {
                  class110.field1947 = class36.method773(client.field451, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(null == client.field372) {
                  client.field372 = class36.method773(client.field451, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class33.field758 = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class33.field757 = 70;
               } else {
                  class226.field3239 = client.field372;
                  class32.field735.method1798();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var5 = 0; var5 < class50.field1121.length; ++var5) {
                     class50.field1121[var5].method1838(var4 + var1, var4 + var2, var3 + var4);
                  }

                  class90.field1611[0].method1960(var1 + var4, var2 + var4, var4 + var3);
                  class33.field758 = "Loaded sprites";
                  class33.field757 = 70;
                  client.field323 = 90;
               }
            }
         }
      }
   }
}
