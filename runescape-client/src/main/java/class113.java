import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class113 {
   @ObfuscatedName("i")
   byte[] field1967;
   @ObfuscatedName("t")
   int[] field1970;
   @ObfuscatedName("g")
   int[] field1972;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "0"
   )
   public int method2396(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1970[var8];
         byte var10 = this.field1967[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var10 + var12 - 1 >> 3) + var11;
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (7 + var7 >> 3) - var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "0"
   )
   public int method2397(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field1972[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1972[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return 1 + var7 - var2;
      }
   }

   public class113(byte[] var1) {
      int var2 = var1.length;
      this.field1970 = new int[var2];
      this.field1967 = var1;
      int[] var3 = new int[33];
      this.field1972 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1970[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if(var3[var10] == var8) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field1972[var10] == 0) {
                     this.field1972[var10] = var4;
                  }

                  var10 = this.field1972[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1972.length) {
                  int[] var13 = new int[2 * this.field1972.length];

                  for(int var14 = 0; var14 < this.field1972.length; ++var14) {
                     var13[var14] = this.field1972[var14];
                  }

                  this.field1972 = var13;
               }

               var12 >>>= 1;
            }

            this.field1972[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-102"
   )
   static void method2401() {
      int var0;
      if(client.field311 == 0) {
         class214.field3161 = new class86(4, 104, 104, class5.field100);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field344[var0] = new class108(104, 104);
         }

         class101.field1767 = new class78(512, 512);
         class31.field735 = "Starting game engine...";
         class31.field715 = 5;
         client.field311 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(client.field311 == 20) {
            int[] var29 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 128 + 32 * var1 + 15;
               var3 = 600 + 3 * var2;
               var4 = class91.field1602[var2];
               var29[var1] = var3 * var4 >> 16;
            }

            class86.method1905(var29, 500, 800, 512, 334);
            class31.field735 = "Prepared visibility map";
            class31.field715 = 10;
            client.field311 = 30;
         } else if(client.field311 == 30) {
            class15.field223 = class2.method32(0, false, true, true);
            class33.field765 = class2.method32(1, false, true, true);
            class144.field2241 = class2.method32(2, true, false, true);
            class21.field576 = class2.method32(3, false, true, true);
            class42.field1000 = class2.method32(4, false, true, true);
            class19.field272 = class2.method32(5, true, true, true);
            class103.field1783 = class2.method32(6, true, true, false);
            class122.field2028 = class2.method32(7, false, true, true);
            class13.field203 = class2.method32(8, false, true, true);
            class186.field3024 = class2.method32(9, false, true, true);
            class138.field2161 = class2.method32(10, false, true, true);
            class106.field1878 = class2.method32(11, false, true, true);
            class129.field2067 = class2.method32(12, false, true, true);
            class74.field1371 = class2.method32(13, true, false, true);
            class3.field67 = class2.method32(14, false, true, false);
            class4.field76 = class2.method32(15, false, true, true);
            class31.field735 = "Connecting to update server";
            class31.field715 = 20;
            client.field311 = 40;
         } else if(client.field311 == 40) {
            byte var26 = 0;
            var0 = var26 + class15.field223.method3325() * 4 / 100;
            var0 += class33.field765.method3325() * 4 / 100;
            var0 += class144.field2241.method3325() * 2 / 100;
            var0 += class21.field576.method3325() * 2 / 100;
            var0 += class42.field1000.method3325() * 6 / 100;
            var0 += class19.field272.method3325() * 4 / 100;
            var0 += class103.field1783.method3325() * 2 / 100;
            var0 += class122.field2028.method3325() * 60 / 100;
            var0 += class13.field203.method3325() * 2 / 100;
            var0 += class186.field3024.method3325() * 2 / 100;
            var0 += class138.field2161.method3325() * 2 / 100;
            var0 += class106.field1878.method3325() * 2 / 100;
            var0 += class129.field2067.method3325() * 2 / 100;
            var0 += class74.field1371.method3325() * 2 / 100;
            var0 += class3.field67.method3325() * 2 / 100;
            var0 += class4.field76.method3325() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class31.field735 = "Checking for updates - " + var0 + "%";
               }

               class31.field715 = 30;
            } else {
               class31.field735 = "Loaded update list";
               class31.field715 = 30;
               client.field311 = 45;
            }
         } else {
            class168 var19;
            class168 var20;
            if(client.field311 == 45) {
               boolean var25 = !client.field287;
               class56.field1194 = 22050;
               class21.field575 = var25;
               class56.field1184 = 2;
               class184 var31 = new class184();
               var31.method3639(9, 128);
               class17.field247 = class74.method1564(class77.field1400, class59.field1221, 0, 22050);
               class17.field247.method1134(var31);
               var19 = class4.field76;
               var20 = class3.field67;
               class168 var21 = class42.field1000;
               class183.field2978 = var19;
               class90.field1572 = var20;
               class183.field2975 = var21;
               class183.field2976 = var31;
               client.field331 = class74.method1564(class77.field1400, class59.field1221, 1, 2048);
               class129.field2065 = new class55();
               client.field331.method1134(class129.field2065);
               class51.field1164 = new class74(22050, class56.field1194);
               class31.field735 = "Prepared sound engine";
               class31.field715 = 35;
               client.field311 = 50;
            } else {
               int var5;
               if(client.field311 == 50) {
                  var0 = 0;
                  class224 var30;
                  if(class1.field26 == null) {
                     var19 = class13.field203;
                     var20 = class74.field1371;
                     var4 = var19.method3236("p11_full");
                     var5 = var19.method3237(var4, "");
                     var30 = class8.method90(var19, var20, var4, var5);
                     class1.field26 = var30;
                  } else {
                     ++var0;
                  }

                  if(null == class82.field1440) {
                     var19 = class13.field203;
                     var20 = class74.field1371;
                     var4 = var19.method3236("p12_full");
                     var5 = var19.method3237(var4, "");
                     var30 = class8.method90(var19, var20, var4, var5);
                     class82.field1440 = var30;
                  } else {
                     ++var0;
                  }

                  if(null == class4.field79) {
                     var19 = class13.field203;
                     var20 = class74.field1371;
                     var4 = var19.method3236("b12_full");
                     var5 = var19.method3237(var4, "");
                     var30 = class8.method90(var19, var20, var4, var5);
                     class4.field79 = var30;
                  } else {
                     ++var0;
                  }

                  if(var0 < 3) {
                     class31.field735 = "Loading fonts - " + var0 * 100 / 3 + "%";
                     class31.field715 = 40;
                  } else {
                     class2.field62 = new class160(true);
                     class31.field735 = "Loaded fonts";
                     class31.field715 = 40;
                     client.field311 = 60;
                  }
               } else {
                  class168 var18;
                  if(client.field311 == 60) {
                     var18 = class138.field2161;
                     var19 = class13.field203;
                     var3 = 0;
                     if(var18.method3227("title.jpg", "")) {
                        ++var3;
                     }

                     if(var19.method3227("logo", "")) {
                        ++var3;
                     }

                     if(var19.method3227("logo_deadman_mode", "")) {
                        ++var3;
                     }

                     if(var19.method3227("titlebox", "")) {
                        ++var3;
                     }

                     if(var19.method3227("titlebutton", "")) {
                        ++var3;
                     }

                     if(var19.method3227("runes", "")) {
                        ++var3;
                     }

                     if(var19.method3227("title_mute", "")) {
                        ++var3;
                     }

                     if(var19.method3281("options_radio_buttons,0")) {
                        ++var3;
                     }

                     if(var19.method3281("options_radio_buttons,2")) {
                        ++var3;
                     }

                     var19.method3227("sl_back", "");
                     var19.method3227("sl_flags", "");
                     var19.method3227("sl_arrows", "");
                     var19.method3227("sl_stars", "");
                     var19.method3227("sl_button", "");
                     byte var24 = 9;
                     if(var3 < var24) {
                        class31.field735 = "Loading title screen - " + 100 * var3 / var24 + "%";
                        class31.field715 = 50;
                     } else {
                        class31.field735 = "Loaded title screen";
                        class31.field715 = 50;
                        class2.method14(5);
                        client.field311 = 70;
                     }
                  } else if(client.field311 == 70) {
                     if(!class144.field2241.method3225()) {
                        class31.field735 = "Loading config - " + class144.field2241.method3313() + "%";
                        class31.field715 = 60;
                     } else {
                        class40.method821(class144.field2241);
                        class41.method840(class144.field2241);
                        class168 var28 = class144.field2241;
                        var18 = class122.field2028;
                        class178.field2936 = var28;
                        class218.field3170 = var18;
                        class44.field1030 = class178.field2936.method3231(3);
                        class137.method2896(class144.field2241, class122.field2028, client.field287);
                        class158.method3143(class144.field2241, class122.field2028);
                        var19 = class144.field2241;
                        var20 = class122.field2028;
                        boolean var23 = client.field286;
                        class224 var22 = class1.field26;
                        class51.field1163 = var19;
                        class227.field3218 = var20;
                        class51.field1160 = var23;
                        class51.field1125 = class51.field1163.method3231(10);
                        class51.field1132 = var22;
                        class168 var6 = class144.field2241;
                        class168 var7 = class15.field223;
                        class168 var8 = class33.field765;
                        class42.field993 = var6;
                        class42.field996 = var7;
                        class42.field998 = var8;
                        class124.method2751(class144.field2241, class122.field2028);
                        class48.method967(class144.field2241);
                        class168 var9 = class144.field2241;
                        class52.field1172 = var9;
                        class52.field1168 = class52.field1172.method3231(16);
                        class168 var10 = class21.field576;
                        class168 var11 = class122.field2028;
                        class168 var12 = class13.field203;
                        class168 var13 = class74.field1371;
                        class173.field2853 = var10;
                        class173.field2836 = var11;
                        class33.field761 = var12;
                        class163.field2681 = var13;
                        class216.field3168 = new class173[class173.field2853.method3232()][];
                        class173.field2800 = new boolean[class173.field2853.method3232()];
                        class168 var14 = class144.field2241;
                        class50.field1109 = var14;
                        class168 var15 = class144.field2241;
                        class142.field2206 = var15;
                        class168 var16 = class144.field2241;
                        class45.field1046 = var16;
                        class28.method638(class144.field2241);
                        class106.field1879 = new class19();
                        class31.field735 = "Loaded config";
                        class31.field715 = 60;
                        client.field311 = 80;
                     }
                  } else if(client.field311 != 80) {
                     if(client.field311 == 90) {
                        if(!class186.field3024.method3225()) {
                           class31.field735 = "Loading textures - " + class186.field3024.method3313() + "%";
                           class31.field715 = 90;
                        } else {
                           class95 var27 = new class95(class186.field3024, class13.field203, 20, 0.8D, client.field287?64:128);
                           class91.method2054(var27);
                           class91.method2055(0.8D);
                           class31.field735 = "Loaded textures";
                           class31.field715 = 90;
                           client.field311 = 110;
                        }
                     } else if(client.field311 == 110) {
                        class47.field1082 = new class13();
                        class77.field1400.method2868(class47.field1082, 10);
                        class31.field735 = "Loaded input handler";
                        class31.field715 = 94;
                        client.field311 = 120;
                     } else if(client.field311 == 120) {
                        if(!class138.field2161.method3227("huffman", "")) {
                           class31.field735 = "Loading wordpack - " + 0 + "%";
                           class31.field715 = 96;
                        } else {
                           class113 var17 = new class113(class138.field2161.method3279("huffman", ""));
                           class222.field3185 = var17;
                           class31.field735 = "Loaded wordpack";
                           class31.field715 = 96;
                           client.field311 = 130;
                        }
                     } else if(client.field311 == 130) {
                        if(!class21.field576.method3225()) {
                           class31.field735 = "Loading interfaces - " + class21.field576.method3313() * 4 / 5 + "%";
                           class31.field715 = 100;
                        } else if(!class129.field2067.method3225()) {
                           class31.field735 = "Loading interfaces - " + (80 + class129.field2067.method3313() / 6) + "%";
                           class31.field715 = 100;
                        } else if(!class74.field1371.method3225()) {
                           class31.field735 = "Loading interfaces - " + (96 + class74.field1371.method3313() / 20) + "%";
                           class31.field715 = 100;
                        } else {
                           class31.field735 = "Loaded interfaces";
                           class31.field715 = 100;
                           client.field311 = 140;
                        }
                     } else if(client.field311 == 140) {
                        class2.method14(10);
                     }
                  } else {
                     var0 = 0;
                     if(class165.field2695 == null) {
                        class165.field2695 = class74.method1559(class13.field203, "compass", "");
                     } else {
                        ++var0;
                     }

                     if(class44.field1035 == null) {
                        class44.field1035 = class74.method1559(class13.field203, "mapedge", "");
                     } else {
                        ++var0;
                     }

                     if(class35.field781 == null) {
                        class35.field781 = class214.method3893(class13.field203, "mapscene", "");
                     } else {
                        ++var0;
                     }

                     if(class75.field1379 == null) {
                        class75.field1379 = class49.method973(class13.field203, "mapfunction", "");
                     } else {
                        ++var0;
                     }

                     if(class24.field618 == null) {
                        class24.field618 = class49.method973(class13.field203, "hitmarks", "");
                     } else {
                        ++var0;
                     }

                     if(null == class14.field214) {
                        class14.field214 = class49.method973(class13.field203, "headicons_pk", "");
                     } else {
                        ++var0;
                     }

                     if(null == class10.field171) {
                        class10.field171 = class49.method973(class13.field203, "headicons_prayer", "");
                     } else {
                        ++var0;
                     }

                     if(null == class149.field2266) {
                        class149.field2266 = class49.method973(class13.field203, "headicons_hint", "");
                     } else {
                        ++var0;
                     }

                     if(null == class48.field1094) {
                        class48.field1094 = class49.method973(class13.field203, "mapmarker", "");
                     } else {
                        ++var0;
                     }

                     if(class151.field2285 == null) {
                        class151.field2285 = class49.method973(class13.field203, "cross", "");
                     } else {
                        ++var0;
                     }

                     if(class108.field1908 == null) {
                        class108.field1908 = class49.method973(class13.field203, "mapdots", "");
                     } else {
                        ++var0;
                     }

                     if(class144.field2243 == null) {
                        class144.field2243 = class214.method3893(class13.field203, "scrollbar", "");
                     } else {
                        ++var0;
                     }

                     if(null == class17.field248) {
                        class17.field248 = class214.method3893(class13.field203, "mod_icons", "");
                     } else {
                        ++var0;
                     }

                     if(var0 < 13) {
                        class31.field735 = "Loading sprites - " + 100 * var0 / 13 + "%";
                        class31.field715 = 70;
                     } else {
                        class223.field3195 = class17.field248;
                        class44.field1035.method1697();
                        var1 = (int)(Math.random() * 21.0D) - 10;
                        var2 = (int)(Math.random() * 21.0D) - 10;
                        var3 = (int)(Math.random() * 21.0D) - 10;
                        var4 = (int)(Math.random() * 41.0D) - 20;

                        for(var5 = 0; var5 < class75.field1379.length; ++var5) {
                           class75.field1379[var5].method1666(var1 + var4, var2 + var4, var4 + var3);
                        }

                        class35.field781[0].method1821(var1 + var4, var4 + var2, var4 + var3);
                        class31.field735 = "Loaded sprites";
                        class31.field715 = 70;
                        client.field311 = 90;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "64"
   )
   static final void method2403(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class5.field92[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.field100[0][var5][var4] = class5.field100[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class5.field100[0][var5][var4] = class5.field100[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class5.field100[0][var5][var4] = class5.field100[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class5.field100[0][var5][var4] = class5.field100[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)Lclass80;",
      garbageValue = "320226992"
   )
   static class80 method2404(class167 var0, int var1, int var2) {
      return !class21.method551(var0, var1, var2)?null:class16.method165();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1252481702"
   )
   static void method2405() {
      client var0 = client.field280;
      synchronized(client.field280) {
         Container var1 = client.field280.method3051();
         if(var1 != null) {
            class126.field2049 = Math.max(var1.getSize().width, class43.field1016);
            class109.field1915 = Math.max(var1.getSize().height, class29.field690);
            if(class43.field1022 == var1) {
               Insets var2 = class43.field1022.getInsets();
               class126.field2049 -= var2.right + var2.left;
               class109.field1915 -= var2.top + var2.bottom;
            }

            if(class126.field2049 <= 0) {
               class126.field2049 = 1;
            }

            if(class109.field1915 <= 0) {
               class109.field1915 = 1;
            }

            int var5 = client.field496?2:1;
            if(var5 == 1) {
               class10.field162 = client.field565;
               class41.field966 = client.field498 * 503;
            } else {
               class10.field162 = Math.min(class126.field2049, 7680);
               class41.field966 = Math.min(class109.field1915, 2160);
            }

            class144.field2226 = (class126.field2049 - class10.field162) / 2;
            class144.field2242 = 0;
            class59.field1221.setSize(class10.field162, class41.field966);
            class96.field1646 = class12.method138(class10.field162, class41.field966, class59.field1221);
            if(class43.field1022 == var1) {
               Insets var3 = class43.field1022.getInsets();
               class59.field1221.setLocation(var3.left + class144.field2226, var3.top + class144.field2242);
            } else {
               class59.field1221.setLocation(class144.field2226, class144.field2242);
            }

            class4.method36();
            if(client.field442 != -1) {
               class140.method2945(true);
            }

            class94.method2124();
         }
      }
   }
}
