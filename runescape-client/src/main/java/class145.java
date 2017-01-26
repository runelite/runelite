import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class145 {
   @ObfuscatedName("g")
   byte[] field2015;
   @ObfuscatedName("p")
   int[] field2017;
   @ObfuscatedName("f")
   static int[] field2018;
   @ObfuscatedName("x")
   int[] field2021;

   public class145(byte[] var1) {
      int var2 = var1.length;
      this.field2017 = new int[var2];
      this.field2015 = var1;
      int[] var3 = new int[33];
      this.field2021 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2017[var5] = var8;
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
                  if(var8 != var11) {
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

            for(var10 = 1 + var6; var10 <= 32; ++var10) {
               if(var3[var10] == var8) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field2021[var10] == 0) {
                     this.field2021[var10] = var4;
                  }

                  var10 = this.field2021[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2021.length) {
                  int[] var13 = new int[this.field2021.length * 2];

                  for(int var14 = 0; var14 < this.field2021.length; ++var14) {
                     var13[var14] = this.field2021[var14];
                  }

                  this.field2021 = var13;
               }

               var12 >>>= 1;
            }

            this.field2021[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "-1487861600"
   )
   public int method2741(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2017[var8];
         byte var10 = this.field2015[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var12 + var10 - 1 >> 3) + var11;
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-1377593401"
   )
   public int method2745(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1987658684"
   )
   static void method2746() {
      int var0;
      if(Client.field306 == 0) {
         Renderable.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         WidgetNode.field174 = new SpritePixels(512, 512);
         class41.field837 = "Starting game engine...";
         class41.field836 = 5;
         Client.field306 = 20;
      } else {
         int var1;
         int var4;
         int var22;
         int var23;
         if(Client.field306 == 20) {
            int[] var32 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var22 = 128 + var1 * 32 + 15;
               var23 = 600 + 3 * var22;
               var4 = class84.field1438[var22];
               var32[var1] = var4 * var23 >> 16;
            }

            Region.method1756(var32, 500, 800, 512, 334);
            class41.field837 = "Prepared visibility map";
            class41.field836 = 10;
            Client.field306 = 30;
         } else if(Client.field306 == 30) {
            XItemContainer.field118 = class107.method2035(0, false, true, true);
            class1.field12 = class107.method2035(1, false, true, true);
            class7.field65 = class107.method2035(2, true, false, true);
            class150.field2043 = class107.method2035(3, false, true, true);
            class150.field2044 = class107.method2035(4, false, true, true);
            Client.field309 = class107.method2035(5, true, true, true);
            class227.field3228 = class107.method2035(6, true, true, false);
            FileOnDisk.field1189 = class107.method2035(7, false, true, true);
            class184.field2739 = class107.method2035(8, false, true, true);
            class108.field1738 = class107.method2035(9, false, true, true);
            class94.field1595 = class107.method2035(10, false, true, true);
            class49.field962 = class107.method2035(11, false, true, true);
            class8.field74 = class107.method2035(12, false, true, true);
            class99.field1649 = class107.method2035(13, true, false, true);
            class138.field1925 = class107.method2035(14, false, true, false);
            class157.field2121 = class107.method2035(15, false, true, true);
            class41.field837 = "Connecting to update server";
            class41.field836 = 20;
            Client.field306 = 40;
         } else if(Client.field306 == 40) {
            byte var28 = 0;
            var0 = var28 + XItemContainer.field118.method3361() * 4 / 100;
            var0 += class1.field12.method3361() * 4 / 100;
            var0 += class7.field65.method3361() * 2 / 100;
            var0 += class150.field2043.method3361() * 2 / 100;
            var0 += class150.field2044.method3361() * 6 / 100;
            var0 += Client.field309.method3361() * 4 / 100;
            var0 += class227.field3228.method3361() * 2 / 100;
            var0 += FileOnDisk.field1189.method3361() * 60 / 100;
            var0 += class184.field2739.method3361() * 2 / 100;
            var0 += class108.field1738.method3361() * 2 / 100;
            var0 += class94.field1595.method3361() * 2 / 100;
            var0 += class49.field962.method3361() * 2 / 100;
            var0 += class8.field74.method3361() * 2 / 100;
            var0 += class99.field1649.method3361() * 2 / 100;
            var0 += class138.field1925.method3361() * 2 / 100;
            var0 += class157.field2121.method3361() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field837 = "Checking for updates - " + var0 + "%";
               }

               class41.field836 = 30;
            } else {
               class41.field837 = "Loaded update list";
               class41.field836 = 30;
               Client.field306 = 45;
            }
         } else if(Client.field306 == 45) {
            class3.method36(22050, !Client.field283, 2);
            class139 var31 = new class139();
            var31.method2515(9, 128);
            class186.field2763 = Friend.method179(class45.field899, class157.canvas, 0, 22050);
            class186.field2763.method1028(var31);
            class103.method1971(class157.field2121, class138.field1925, class150.field2044, var31);
            class47.field935 = Friend.method179(class45.field899, class157.canvas, 1, 2048);
            CombatInfoListHolder.field753 = new class51();
            class47.field935.method1028(CombatInfoListHolder.field753);
            class187.field2769 = new class65(22050, class57.field1047);
            class41.field837 = "Prepared sound engine";
            class41.field836 = 35;
            Client.field306 = 50;
         } else {
            class184 var2;
            class184 var3;
            int var5;
            if(Client.field306 == 50) {
               var0 = 0;
               Font var34;
               if(null == Ignore.field204) {
                  var2 = class184.field2739;
                  var3 = class99.field1649;
                  var4 = var2.method3276("p11_full");
                  var5 = var2.method3287(var4, "");
                  var34 = Friend.method182(var2, var3, var4, var5);
                  Ignore.field204 = var34;
               } else {
                  ++var0;
               }

               if(class178.field2670 == null) {
                  var2 = class184.field2739;
                  var3 = class99.field1649;
                  var4 = var2.method3276("p12_full");
                  var5 = var2.method3287(var4, "");
                  var34 = Friend.method182(var2, var3, var4, var5);
                  class178.field2670 = var34;
               } else {
                  ++var0;
               }

               if(Tile.field1346 == null) {
                  var2 = class184.field2739;
                  var3 = class99.field1649;
                  var4 = var2.method3276("b12_full");
                  var5 = var2.method3287(var4, "");
                  var34 = Friend.method182(var2, var3, var4, var5);
                  Tile.field1346 = var34;
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class41.field837 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class41.field836 = 40;
               } else {
                  class11.field108 = new class230(true);
                  class41.field837 = "Loaded fonts";
                  class41.field836 = 40;
                  Client.field306 = 60;
               }
            } else {
               class184 var24;
               if(Client.field306 == 60) {
                  var24 = class94.field1595;
                  var2 = class184.field2739;
                  var23 = 0;
                  if(var24.method3289("title.jpg", "")) {
                     ++var23;
                  }

                  if(var2.method3289("logo", "")) {
                     ++var23;
                  }

                  if(var2.method3289("logo_deadman_mode", "")) {
                     ++var23;
                  }

                  if(var2.method3289("titlebox", "")) {
                     ++var23;
                  }

                  if(var2.method3289("titlebutton", "")) {
                     ++var23;
                  }

                  if(var2.method3289("runes", "")) {
                     ++var23;
                  }

                  if(var2.method3289("title_mute", "")) {
                     ++var23;
                  }

                  if(var2.method3290("options_radio_buttons,0")) {
                     ++var23;
                  }

                  if(var2.method3290("options_radio_buttons,2")) {
                     ++var23;
                  }

                  var2.method3289("sl_back", "");
                  var2.method3289("sl_flags", "");
                  var2.method3289("sl_arrows", "");
                  var2.method3289("sl_stars", "");
                  var2.method3289("sl_button", "");
                  byte var26 = 9;
                  if(var23 < var26) {
                     class41.field837 = "Loading title screen - " + 100 * var23 / var26 + "%";
                     class41.field836 = 50;
                  } else {
                     class41.field837 = "Loaded title screen";
                     class41.field836 = 50;
                     class212.setGameState(5);
                     Client.field306 = 70;
                  }
               } else if(Client.field306 == 70) {
                  if(!class7.field65.method3275()) {
                     class41.field837 = "Loading config - " + class7.field65.method3370() + "%";
                     class41.field836 = 60;
                  } else {
                     class65.method1152(class7.field65);
                     class116.method2241(class7.field65);
                     class16.method186(class7.field65, FileOnDisk.field1189);
                     class184 var30 = class7.field65;
                     var24 = FileOnDisk.field1189;
                     boolean var33 = Client.field283;
                     ObjectComposition.field2889 = var30;
                     ObjectComposition.field2904 = var24;
                     ObjectComposition.field2890 = var33;
                     CombatInfoListHolder.method695(class7.field65, FileOnDisk.field1189);
                     var3 = class7.field65;
                     class184 var25 = FileOnDisk.field1189;
                     boolean var27 = Client.isMembers;
                     Font var6 = Ignore.field204;
                     ItemComposition.field2941 = var3;
                     class8.field77 = var25;
                     ItemComposition.isMembersWorld = var27;
                     ItemComposition.field2943 = ItemComposition.field2941.method3309(10);
                     class181.field2698 = var6;
                     class184 var7 = class7.field65;
                     class184 var8 = XItemContainer.field118;
                     class184 var9 = class1.field12;
                     Sequence.field3046 = var7;
                     Sequence.field3045 = var8;
                     Sequence.field3044 = var9;
                     class184 var10 = class7.field65;
                     class184 var11 = FileOnDisk.field1189;
                     class3.field38 = var10;
                     Spotanim.field2800 = var11;
                     class184 var12 = class7.field65;
                     class44.field892 = var12;
                     class184 var13 = class7.field65;
                     class187.field2775 = var13;
                     class187.field2770 = class187.field2775.method3309(16);
                     class184 var14 = class150.field2043;
                     class184 var15 = FileOnDisk.field1189;
                     class184 var16 = class184.field2739;
                     class184 var17 = class99.field1649;
                     Widget.field2281 = var14;
                     Widget.field2188 = var15;
                     class9.field83 = var16;
                     Widget.field2189 = var17;
                     Widget.widgets = new Widget[Widget.field2281.method3282()][];
                     Widget.validInterfaces = new boolean[Widget.field2281.method3282()];
                     class184 var18 = class7.field65;
                     class186.field2767 = var18;
                     class184 var19 = class7.field65;
                     class195.field2857 = var19;
                     CollisionData.method2286(class7.field65);
                     class184 var20 = class7.field65;
                     class189.field2786 = var20;
                     Tile.chatMessages = new ChatMessages();
                     class115.method2239(class7.field65, class184.field2739, class99.field1649);
                     class175.method3241(class7.field65, class184.field2739);
                     class41.field837 = "Loaded config";
                     class41.field836 = 60;
                     Client.field306 = 80;
                  }
               } else if(Client.field306 != 80) {
                  if(Client.field306 == 90) {
                     if(!class108.field1738.method3275()) {
                        class41.field837 = "Loading textures - " + class108.field1738.method3370() + "%";
                        class41.field836 = 90;
                     } else {
                        TextureProvider var29 = new TextureProvider(class108.field1738, class184.field2739, 20, 0.8D, Client.field283?64:128);
                        class84.method1633(var29);
                        class84.method1684(0.8D);
                        class41.field837 = "Loaded textures";
                        class41.field836 = 90;
                        Client.field306 = 110;
                     }
                  } else if(Client.field306 == 110) {
                     class45.field901 = new class20();
                     class45.field899.method1968(class45.field901, 10);
                     class41.field837 = "Loaded input handler";
                     class41.field836 = 94;
                     Client.field306 = 120;
                  } else if(Client.field306 == 120) {
                     if(!class94.field1595.method3289("huffman", "")) {
                        class41.field837 = "Loading wordpack - " + 0 + "%";
                        class41.field836 = 96;
                     } else {
                        class145 var21 = new class145(class94.field1595.method3288("huffman", ""));
                        class156.method3023(var21);
                        class41.field837 = "Loaded wordpack";
                        class41.field836 = 96;
                        Client.field306 = 130;
                     }
                  } else if(Client.field306 == 130) {
                     if(!class150.field2043.method3275()) {
                        class41.field837 = "Loading interfaces - " + class150.field2043.method3370() * 4 / 5 + "%";
                        class41.field836 = 100;
                     } else if(!class8.field74.method3275()) {
                        class41.field837 = "Loading interfaces - " + (80 + class8.field74.method3370() / 6) + "%";
                        class41.field836 = 100;
                     } else if(!class99.field1649.method3275()) {
                        class41.field837 = "Loading interfaces - " + (96 + class99.field1649.method3370() / 20) + "%";
                        class41.field836 = 100;
                     } else {
                        class41.field837 = "Loaded interfaces";
                        class41.field836 = 100;
                        Client.field306 = 140;
                     }
                  } else if(Client.field306 == 140) {
                     class212.setGameState(10);
                  }
               } else {
                  var0 = 0;
                  if(null == class2.field21) {
                     class2.field21 = class36.method725(class184.field2739, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(class101.field1657 == null) {
                     class101.field1657 = class36.method725(class184.field2739, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(class3.field37 == null) {
                     class3.field37 = class8.method116(class184.field2739, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class16.field171 == null) {
                     class16.field171 = class41.method771(class184.field2739, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(class140.field1978 == null) {
                     class140.field1978 = class41.method771(class184.field2739, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(null == Client.field389) {
                     Client.field389 = class41.method771(class184.field2739, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(null == World.field678) {
                     World.field678 = class41.method771(class184.field2739, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class175.field2644 == null) {
                     class175.field2644 = class41.method771(class184.field2739, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(Player.field253 == null) {
                     Player.field253 = class41.method771(class184.field2739, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(class152.field2087 == null) {
                     class152.field2087 = class41.method771(class184.field2739, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class26.field583 == null) {
                     class26.field583 = class8.method116(class184.field2739, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(Renderable.field1540 == null) {
                     Renderable.field1540 = class8.method116(class184.field2739, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 12) {
                     class41.field837 = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class41.field836 = 70;
                  } else {
                     FontTypeFace.modIcons = Renderable.field1540;
                     class101.field1657.method4136();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var22 = (int)(Math.random() * 21.0D) - 10;
                     var23 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(var5 = 0; var5 < class16.field171.length; ++var5) {
                        class16.field171[var5].method4149(var1 + var4, var22 + var4, var4 + var23);
                     }

                     class3.field37[0].method4082(var4 + var1, var4 + var22, var4 + var23);
                     class41.field837 = "Loaded sprites";
                     class41.field836 = 70;
                     Client.field306 = 90;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-169520653"
   )
   public static void method2747() {
      class187.field2772.reset();
   }
}
