import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class9 {
   @ObfuscatedName("e")
   static final BigInteger field168 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("bm")
   static class168 field169;
   @ObfuscatedName("y")
   static final BigInteger field170 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("cw")
   static class143 field173;
   @ObfuscatedName("ge")
   static class173 field175;

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "-297379225"
   )
   static final void method114(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(null != var3) {
            if(0 == var3.field2814) {
               if(null != var3.field2891) {
                  method114(var3.field2891, var1);
               }

               class3 var4 = (class3)client.field455.method3806((long)var3.field2838);
               if(var4 != null) {
                  class39.method797(var4.field74, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && var3.field2874 != null) {
               var5 = new class0();
               var5.field2 = var3;
               var5.field7 = var3.field2874;
               class3.method48(var5);
            }

            if(1 == var1 && var3.field2875 != null) {
               if(var3.field2802 >= 0) {
                  class173 var6 = class52.method1115(var3.field2838);
                  if(var6 == null || var6.field2891 == null || var3.field2802 >= var6.field2891.length || var3 != var6.field2891[var3.field2802]) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field2 = var3;
               var5.field7 = var3.field2875;
               class3.method48(var5);
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1453694552"
   )
   static void method118() {
      int var0;
      if(client.field323 == 0) {
         class3.field75 = new class86(4, 104, 104, class5.field96);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field372[var0] = new class108(104, 104);
         }

         class7.field143 = new class78(512, 512);
         class31.field728 = "Starting game engine...";
         class31.field727 = 5;
         client.field323 = 20;
      } else {
         int var3;
         int var4;
         int var15;
         int var18;
         if(client.field323 == 20) {
            int[] var28 = new int[9];

            for(var15 = 0; var15 < 9; ++var15) {
               var18 = 32 * var15 + 128 + 15;
               var3 = var18 * 3 + 600;
               var4 = class91.field1573[var18];
               var28[var15] = var4 * var3 >> 16;
            }

            class86.method1951(var28, 500, 800, 512, 334);
            class31.field728 = "Prepared visibility map";
            class31.field727 = 10;
            client.field323 = 30;
         } else if(30 == client.field323) {
            class148.field2246 = class168.method3392(0, false, true, true);
            class114.field1988 = class168.method3392(1, false, true, true);
            class46.field1076 = class168.method3392(2, true, false, true);
            class22.field608 = class168.method3392(3, false, true, true);
            class47.field1086 = class168.method3392(4, false, true, true);
            class18.field271 = class168.method3392(5, true, true, true);
            class19.field289 = class168.method3392(6, true, true, false);
            class8.field152 = class168.method3392(7, false, true, true);
            class35.field795 = class168.method3392(8, false, true, true);
            class8.field151 = class168.method3392(9, false, true, true);
            class4.field82 = class168.method3392(10, false, true, true);
            class39.field917 = class168.method3392(11, false, true, true);
            field169 = class168.method3392(12, false, true, true);
            class96.field1649 = class168.method3392(13, true, false, true);
            class108.field1913 = class168.method3392(14, false, true, false);
            class82.field1440 = class168.method3392(15, false, true, true);
            class31.field728 = "Connecting to update server";
            class31.field727 = 20;
            client.field323 = 40;
         } else if(40 == client.field323) {
            byte var27 = 0;
            var0 = var27 + class148.field2246.method3361() * 4 / 100;
            var0 += class114.field1988.method3361() * 4 / 100;
            var0 += class46.field1076.method3361() * 2 / 100;
            var0 += class22.field608.method3361() * 2 / 100;
            var0 += class47.field1086.method3361() * 6 / 100;
            var0 += class18.field271.method3361() * 4 / 100;
            var0 += class19.field289.method3361() * 2 / 100;
            var0 += class8.field152.method3361() * 60 / 100;
            var0 += class35.field795.method3361() * 2 / 100;
            var0 += class8.field151.method3361() * 2 / 100;
            var0 += class4.field82.method3361() * 2 / 100;
            var0 += class39.field917.method3361() * 2 / 100;
            var0 += field169.method3361() * 2 / 100;
            var0 += class96.field1649.method3361() * 2 / 100;
            var0 += class108.field1913.method3361() * 2 / 100;
            var0 += class82.field1440.method3361() * 2 / 100;
            if(100 != var0) {
               if(var0 != 0) {
                  class31.field728 = "Checking for updates - " + var0 + "%";
               }

               class31.field727 = 30;
            } else {
               class31.field728 = "Loaded update list";
               class31.field727 = 30;
               client.field323 = 45;
            }
         } else if(client.field323 == 45) {
            boolean var26 = !client.field413;
            class129.field2058 = 22050;
            class56.field1194 = var26;
            class50.field1111 = 2;
            class184 var17 = new class184();
            var17.method3658(9, 128);
            class17.field253 = class141.method2993(class123.field2036, 0, 22050);
            class17.field253.method1203(var17);
            class124.method2791(class82.field1440, class108.field1913, class47.field1086, var17);
            class153.field2299 = class141.method2993(class123.field2036, 1, 2048);
            class72.field1353 = new class55();
            class153.field2299.method1203(class72.field1353);
            class3.field73 = new class74(22050, class129.field2058);
            class31.field728 = "Prepared sound engine";
            class31.field727 = 35;
            client.field323 = 50;
         } else if(client.field323 == 50) {
            var0 = 0;
            if(class104.field1807 == null) {
               class104.field1807 = class106.method2386(class35.field795, class96.field1649, "p11_full", "");
            } else {
               ++var0;
            }

            if(null == class3.field76) {
               class3.field76 = class106.method2386(class35.field795, class96.field1649, "p12_full", "");
            } else {
               ++var0;
            }

            if(class89.field1561 == null) {
               class89.field1561 = class106.method2386(class35.field795, class96.field1649, "b12_full", "");
            } else {
               ++var0;
            }

            if(var0 < 3) {
               class31.field728 = "Loading fonts - " + var0 * 100 / 3 + "%";
               class31.field727 = 40;
            } else {
               class14.field224 = new class160(true);
               class31.field728 = "Loaded fonts";
               class31.field727 = 40;
               client.field323 = 60;
            }
         } else if(client.field323 == 60) {
            var0 = class1.method7(class4.field82, class35.field795);
            var15 = class164.method3270();
            if(var0 < var15) {
               class31.field728 = "Loading title screen - " + var0 * 100 / var15 + "%";
               class31.field727 = 50;
            } else {
               class31.field728 = "Loaded title screen";
               class31.field727 = 50;
               class138.method2937(5);
               client.field323 = 70;
            }
         } else if(client.field323 == 70) {
            if(!class46.field1076.method3346()) {
               class31.field728 = "Loading config - " + class46.field1076.method3369() + "%";
               class31.field727 = 60;
            } else {
               class101.method2280(class46.field1076);
               client.method357(class46.field1076);
               class122.method2779(class46.field1076, class8.field152);
               class168 var25 = class46.field1076;
               class168 var16 = class8.field152;
               boolean var19 = client.field413;
               class40.field926 = var25;
               class40.field927 = var16;
               class40.field964 = var19;
               class168 var20 = class46.field1076;
               class168 var21 = class8.field152;
               class39.field905 = var20;
               class39.field907 = var21;
               class168 var22 = class46.field1076;
               class168 var6 = class8.field152;
               boolean var7 = client.field300;
               class224 var8 = class104.field1807;
               class26.field672 = var22;
               class51.field1114 = var6;
               class51.field1115 = var7;
               class51.field1116 = class26.field672.method3330(10);
               class96.field1642 = var8;
               class95.method2183(class46.field1076, class148.field2246, class114.field1988);
               class168 var9 = class46.field1076;
               class168 var10 = class8.field152;
               class43.field1020 = var9;
               class43.field1013 = var10;
               class168 var11 = class46.field1076;
               class47.field1083 = var11;
               class14.method169(class46.field1076);
               class116.method2455(class22.field608, class8.field152, class35.field795, class96.field1649);
               class168 var12 = class46.field1076;
               class50.field1110 = var12;
               class168 var13 = class46.field1076;
               class48.field1087 = var13;
               class11.method137(class46.field1076);
               class168 var14 = class46.field1076;
               class49.field1104 = var14;
               class74.field1375 = new class19();
               class31.field728 = "Loaded config";
               class31.field727 = 60;
               client.field323 = 80;
            }
         } else if(80 != client.field323) {
            if(90 == client.field323) {
               if(!class8.field151.method3346()) {
                  class31.field728 = "Loading textures - " + class8.field151.method3369() + "%";
                  class31.field727 = 90;
               } else {
                  class95 var24 = new class95(class8.field151, class35.field795, 20, 0.8D, client.field413?64:128);
                  class91.method2105(var24);
                  class91.method2087(0.8D);
                  class31.field728 = "Loaded textures";
                  class31.field727 = 90;
                  client.field323 = 110;
               }
            } else if(client.field323 == 110) {
               class150.field2275 = new class13();
               class123.field2036.method2889(class150.field2275, 10);
               class31.field728 = "Loaded input handler";
               class31.field727 = 94;
               client.field323 = 120;
            } else if(120 == client.field323) {
               if(!class4.field82.method3312("huffman", "")) {
                  class31.field728 = "Loading wordpack - " + 0 + "%";
                  class31.field727 = 96;
               } else {
                  class113 var23 = new class113(class4.field82.method3352("huffman", ""));
                  class40.method858(var23);
                  class31.field728 = "Loaded wordpack";
                  class31.field727 = 96;
                  client.field323 = 130;
               }
            } else if(130 == client.field323) {
               if(!class22.field608.method3346()) {
                  class31.field728 = "Loading interfaces - " + class22.field608.method3369() * 4 / 5 + "%";
                  class31.field727 = 100;
               } else if(!field169.method3346()) {
                  class31.field728 = "Loading interfaces - " + (80 + field169.method3369() / 6) + "%";
                  class31.field727 = 100;
               } else if(!class96.field1649.method3346()) {
                  class31.field728 = "Loading interfaces - " + (96 + class96.field1649.method3369() / 20) + "%";
                  class31.field727 = 100;
               } else {
                  class31.field728 = "Loaded interfaces";
                  class31.field727 = 100;
                  client.field323 = 140;
               }
            } else if(client.field323 == 140) {
               class138.method2937(10);
            }
         } else {
            var0 = 0;
            class78 var1;
            class168 var2;
            if(null == class32.field746) {
               var2 = class35.field795;
               var3 = var2.method3303("compass");
               var4 = var2.method3289(var3, "");
               var1 = class16.method184(var2, var3, var4);
               class32.field746 = var1;
            } else {
               ++var0;
            }

            if(null == class143.field2203) {
               var2 = class35.field795;
               var3 = var2.method3303("mapedge");
               var4 = var2.method3289(var3, "");
               var1 = class16.method184(var2, var3, var4);
               class143.field2203 = var1;
            } else {
               ++var0;
            }

            if(class93.field1610 == null) {
               class93.field1610 = class56.method1236(class35.field795, "mapscene", "");
            } else {
               ++var0;
            }

            if(null == class4.field88) {
               class4.field88 = class23.method598(class35.field795, "mapfunction", "");
            } else {
               ++var0;
            }

            if(null == class84.field1462) {
               class84.field1462 = class23.method598(class35.field795, "hitmarks", "");
            } else {
               ++var0;
            }

            if(null == class44.field1044) {
               class44.field1044 = class23.method598(class35.field795, "headicons_pk", "");
            } else {
               ++var0;
            }

            if(null == class2.field40) {
               class2.field40 = class23.method598(class35.field795, "headicons_prayer", "");
            } else {
               ++var0;
            }

            if(class165.field2682 == null) {
               class165.field2682 = class23.method598(class35.field795, "headicons_hint", "");
            } else {
               ++var0;
            }

            if(null == class7.field144) {
               class7.field144 = class23.method598(class35.field795, "mapmarker", "");
            } else {
               ++var0;
            }

            if(null == class227.field3220) {
               class227.field3220 = class23.method598(class35.field795, "cross", "");
            } else {
               ++var0;
            }

            if(class7.field142 == null) {
               class7.field142 = class23.method598(class35.field795, "mapdots", "");
            } else {
               ++var0;
            }

            if(client.field371 == null) {
               client.field371 = class56.method1236(class35.field795, "scrollbar", "");
            } else {
               ++var0;
            }

            if(null == class141.field2187) {
               class141.field2187 = class56.method1236(class35.field795, "mod_icons", "");
            } else {
               ++var0;
            }

            if(var0 < 13) {
               class31.field728 = "Loading sprites - " + var0 * 100 / 13 + "%";
               class31.field727 = 70;
            } else {
               class223.field3191 = class141.field2187;
               class143.field2203.method1763();
               var15 = (int)(Math.random() * 21.0D) - 10;
               var18 = (int)(Math.random() * 21.0D) - 10;
               var3 = (int)(Math.random() * 21.0D) - 10;
               var4 = (int)(Math.random() * 41.0D) - 20;

               for(int var5 = 0; var5 < class4.field88.length; ++var5) {
                  class4.field88[var5].method1690(var15 + var4, var4 + var18, var4 + var3);
               }

               class93.field1610[0].method1853(var4 + var15, var4 + var18, var3 + var4);
               class31.field728 = "Loaded sprites";
               class31.field727 = 70;
               client.field323 = 90;
            }
         }
      }
   }

   @ObfuscatedName("bu")
   static final void method119(int var0, int var1) {
      if(client.field435 >= 2 || 0 != client.field381 || client.field573) {
         String var2;
         if(1 == client.field381 && client.field435 < 2) {
            var2 = "Use" + " " + client.field366 + " " + "->";
         } else if(client.field573 && client.field435 < 2) {
            var2 = client.field315 + " " + client.field453 + " " + "->";
         } else {
            var2 = class82.method1885(client.field435 - 1);
         }

         if(client.field435 > 2) {
            var2 = var2 + class72.method1574(16777215) + " " + '/' + " " + (client.field435 - 2) + " more options";
         }

         class89.field1561.method4044(var2, var0 + 4, 15 + var1, 16777215, 0, client.field305 / 1000);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-75"
   )
   public static void method121() {
      class137 var0 = class137.field2131;
      synchronized(class137.field2131) {
         ++class137.field2141;
         class137.field2138 = class137.field2140;
         class137.field2137 = 0;
         int var1;
         if(class137.field2133 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class137.field2135[var1] = false;
            }

            class137.field2133 = class137.field2125;
         } else {
            while(class137.field2133 != class137.field2125) {
               var1 = class137.field2121[class137.field2125];
               class137.field2125 = class137.field2125 + 1 & 127;
               if(var1 < 0) {
                  class137.field2135[~var1] = false;
               } else {
                  if(!class137.field2135[var1] && class137.field2137 < class137.field2130.length - 1) {
                     class137.field2130[++class137.field2137 - 1] = var1;
                  }

                  class137.field2135[var1] = true;
               }
            }
         }

         class137.field2140 = class137.field2116;
      }
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "97"
   )
   static final void method122() {
      boolean var0 = false;

      int var1;
      int var4;
      while(!var0) {
         var0 = true;

         for(var1 = 0; var1 < client.field435 - 1; ++var1) {
            if(client.field448[var1] < 1000 && client.field448[1 + var1] > 1000) {
               String var2 = client.field441[var1];
               client.field441[var1] = client.field441[var1 + 1];
               client.field441[var1 + 1] = var2;
               String var3 = client.field440[var1];
               client.field440[var1] = client.field440[1 + var1];
               client.field440[var1 + 1] = var3;
               var4 = client.field448[var1];
               client.field448[var1] = client.field448[var1 + 1];
               client.field448[var1 + 1] = var4;
               var4 = client.field436[var1];
               client.field436[var1] = client.field436[var1 + 1];
               client.field436[var1 + 1] = var4;
               var4 = client.field437[var1];
               client.field437[var1] = client.field437[var1 + 1];
               client.field437[var1 + 1] = var4;
               var4 = client.field439[var1];
               client.field439[var1] = client.field439[1 + var1];
               client.field439[1 + var1] = var4;
               var0 = false;
            }
         }
      }

      if(field175 == null) {
         if(null == client.field353) {
            int var13 = class140.field2177;
            int var6;
            int var8;
            int var14;
            int var15;
            String var10000;
            int var17;
            if(client.field433) {
               if(var13 != 1 && (class39.field922 || var13 != 4)) {
                  var1 = class140.field2168;
                  var14 = class140.field2182;
                  if(var1 < client.field404 - 10 || var1 > 10 + client.field404 + class14.field219 || var14 < class18.field278 - 10 || var14 > class18.field278 + class0.field14 + 10) {
                     client.field433 = false;
                     class29.method664(client.field404, class18.field278, class14.field219, class0.field14);
                  }
               }

               if(var13 == 1 || !class39.field922 && 4 == var13) {
                  var1 = client.field404;
                  var14 = class18.field278;
                  var15 = class14.field219;
                  var4 = class140.field2176;
                  var17 = class140.field2167;
                  var6 = -1;

                  int var19;
                  for(var19 = 0; var19 < client.field435; ++var19) {
                     var8 = (client.field435 - 1 - var19) * 15 + var14 + 31;
                     if(var4 > var1 && var4 < var1 + var15 && var17 > var8 - 13 && var17 < var8 + 3) {
                        var6 = var19;
                     }
                  }

                  if(var6 != -1 && var6 >= 0) {
                     var19 = client.field436[var6];
                     var8 = client.field437[var6];
                     int var9 = client.field448[var6];
                     int var10 = client.field439[var6];
                     var10000 = client.field440[var6];
                     String var12 = client.field441[var6];
                     class163.method3263(var19, var8, var9, var10, var12, class140.field2176, class140.field2167);
                  }

                  client.field433 = false;
                  class29.method664(client.field404, class18.field278, class14.field219, class0.field14);
               }
            } else {
               if((1 == var13 || !class39.field922 && 4 == var13) && client.field435 > 0) {
                  var1 = client.field448[client.field435 - 1];
                  if(39 == var1 || 40 == var1 || var1 == 41 || var1 == 42 || 43 == var1 || var1 == 33 || 34 == var1 || var1 == 35 || 36 == var1 || 37 == var1 || 38 == var1 || 1005 == var1) {
                     label333: {
                        var14 = client.field436[client.field435 - 1];
                        var15 = client.field437[client.field435 - 1];
                        class173 var16 = class52.method1115(var15);
                        var6 = class169.method3395(var16);
                        boolean var5 = (var6 >> 28 & 1) != 0;
                        if(!var5) {
                           var8 = class169.method3395(var16);
                           boolean var7 = 0 != (var8 >> 29 & 1);
                           if(!var7) {
                              break label333;
                           }
                        }

                        if(null != field175 && !client.field412 && client.field432 != 1 && !class170.method3396(client.field435 - 1) && client.field435 > 0) {
                           class17.method187(client.field467, client.field308);
                        }

                        client.field412 = false;
                        client.field550 = 0;
                        if(field175 != null) {
                           class134.method2877(field175);
                        }

                        field175 = class52.method1115(var15);
                        client.field408 = var14;
                        client.field467 = class140.field2176;
                        client.field308 = class140.field2167;
                        if(client.field435 > 0) {
                           class113.method2444(client.field435 - 1);
                        }

                        class134.method2877(field175);
                        return;
                     }
                  }
               }

               if((1 == var13 || !class39.field922 && 4 == var13) && (1 == client.field432 && client.field435 > 2 || class170.method3396(client.field435 - 1))) {
                  var13 = 2;
               }

               if((1 == var13 || !class39.field922 && var13 == 4) && client.field435 > 0) {
                  var1 = client.field435 - 1;
                  if(var1 >= 0) {
                     var14 = client.field436[var1];
                     var15 = client.field437[var1];
                     var4 = client.field448[var1];
                     var17 = client.field439[var1];
                     var10000 = client.field440[var1];
                     String var18 = client.field441[var1];
                     class163.method3263(var14, var15, var4, var17, var18, class140.field2176, class140.field2167);
                  }
               }

               if(2 == var13 && client.field435 > 0) {
                  class116.method2456(class140.field2176, class140.field2167);
               }
            }

         }
      }
   }
}
