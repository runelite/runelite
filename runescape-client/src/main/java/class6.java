import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class6 implements Comparator {
   @ObfuscatedName("dr")
   static int[] field52;
   @ObfuscatedName("k")
   static ModIcon[] field53;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "0"
   )
   int method87(class2 var1, class2 var2) {
      return var1.method22().compareTo(var2.method22());
   }

   public int compare(Object var1, Object var2) {
      return this.method87((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-683099435"
   )
   static void method91() {
      int var0;
      if(Client.field366 == 0) {
         Varbit.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class148.field2025 = new SpritePixels(512, 512);
         class41.field834 = "Starting game engine...";
         class41.field829 = 5;
         Client.field366 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field366 == 20) {
            int[] var18 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 15 + var1 * 32 + 128;
               var3 = 600 + 3 * var2;
               var4 = class84.field1435[var2];
               var18[var1] = var3 * var4 >> 16;
            }

            Region.method1879(var18, 500, 800, 512, 334);
            class41.field834 = "Prepared visibility map";
            class41.field829 = 10;
            Client.field366 = 30;
         } else if(Client.field366 == 30) {
            class22.field238 = XGrandExchangeOffer.method70(0, false, true, true);
            ChatMessages.field911 = XGrandExchangeOffer.method70(1, false, true, true);
            Client.field313 = XGrandExchangeOffer.method70(2, true, false, true);
            Client.field314 = XGrandExchangeOffer.method70(3, false, true, true);
            class1.field13 = XGrandExchangeOffer.method70(4, false, true, true);
            class26.field588 = XGrandExchangeOffer.method70(5, true, true, true);
            XItemContainer.field122 = XGrandExchangeOffer.method70(6, true, true, false);
            XClanMember.field266 = XGrandExchangeOffer.method70(7, false, true, true);
            class114.field1790 = XGrandExchangeOffer.method70(8, false, true, true);
            class40.field814 = XGrandExchangeOffer.method70(9, false, true, true);
            WallObject.field1545 = XGrandExchangeOffer.method70(10, false, true, true);
            class114.field1789 = XGrandExchangeOffer.method70(11, false, true, true);
            class143.field2004 = XGrandExchangeOffer.method70(12, false, true, true);
            Client.field533 = XGrandExchangeOffer.method70(13, true, false, true);
            class195.field2871 = XGrandExchangeOffer.method70(14, false, true, false);
            FrameMap.field1458 = XGrandExchangeOffer.method70(15, false, true, true);
            class41.field834 = "Connecting to update server";
            class41.field829 = 20;
            Client.field366 = 40;
         } else if(Client.field366 == 40) {
            byte var20 = 0;
            var0 = var20 + class22.field238.method3432() * 4 / 100;
            var0 += ChatMessages.field911.method3432() * 4 / 100;
            var0 += Client.field313.method3432() * 2 / 100;
            var0 += Client.field314.method3432() * 2 / 100;
            var0 += class1.field13.method3432() * 6 / 100;
            var0 += class26.field588.method3432() * 4 / 100;
            var0 += XItemContainer.field122.method3432() * 2 / 100;
            var0 += XClanMember.field266.method3432() * 60 / 100;
            var0 += class114.field1790.method3432() * 2 / 100;
            var0 += class40.field814.method3432() * 2 / 100;
            var0 += WallObject.field1545.method3432() * 2 / 100;
            var0 += class114.field1789.method3432() * 2 / 100;
            var0 += class143.field2004.method3432() * 2 / 100;
            var0 += Client.field533.method3432() * 2 / 100;
            var0 += class195.field2871.method3432() * 2 / 100;
            var0 += FrameMap.field1458.method3432() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field834 = "Checking for updates - " + var0 + "%";
               }

               class41.field829 = 30;
            } else {
               class41.field834 = "Loaded update list";
               class41.field829 = 30;
               Client.field366 = 45;
            }
         } else if(Client.field366 == 45) {
            class164.method3214(22050, !Client.field404, 2);
            class139 var17 = new class139();
            var17.method2566(9, 128);
            class3.field30 = Projectile.method862(class25.field579, class0.canvas, 0, 22050);
            class3.field30.method1111(var17);
            GameObject.method1980(FrameMap.field1458, class195.field2871, class1.field13, var17);
            Client.field568 = Projectile.method862(class25.field579, class0.canvas, 1, 2048);
            class16.field168 = new class51();
            Client.field568.method1111(class16.field168);
            class119.field1853 = new class65(22050, class202.field3079);
            class41.field834 = "Prepared sound engine";
            class41.field829 = 35;
            Client.field366 = 50;
         } else {
            int var5;
            class184 var8;
            class184 var10;
            if(Client.field366 == 50) {
               var0 = 0;
               Font var14;
               if(null == Client.field567) {
                  var10 = class114.field1790;
                  var8 = Client.field533;
                  var4 = var10.method3363("p11_full");
                  var5 = var10.method3407(var4, "");
                  if(!class185.method3467(var10, var4, var5)) {
                     var14 = null;
                  } else {
                     var14 = FileOnDisk.method1488(var8.getConfigData(var4, var5));
                  }

                  Client.field567 = var14;
               } else {
                  ++var0;
               }

               if(XItemContainer.field119 == null) {
                  var10 = class114.field1790;
                  var8 = Client.field533;
                  var4 = var10.method3363("p12_full");
                  var5 = var10.method3407(var4, "");
                  if(!class185.method3467(var10, var4, var5)) {
                     var14 = null;
                  } else {
                     var14 = FileOnDisk.method1488(var8.getConfigData(var4, var5));
                  }

                  XItemContainer.field119 = var14;
               } else {
                  ++var0;
               }

               if(class16.field170 == null) {
                  var10 = class114.field1790;
                  var8 = Client.field533;
                  var4 = var10.method3363("b12_full");
                  var5 = var10.method3407(var4, "");
                  if(!class185.method3467(var10, var4, var5)) {
                     var14 = null;
                  } else {
                     var14 = FileOnDisk.method1488(var8.getConfigData(var4, var5));
                  }

                  class16.field170 = var14;
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class41.field834 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class41.field829 = 40;
               } else {
                  class88.field1524 = new class230(true);
                  class41.field834 = "Loaded fonts";
                  class41.field829 = 40;
                  Client.field366 = 60;
               }
            } else {
               class184 var19;
               if(Client.field366 == 60) {
                  var19 = WallObject.field1545;
                  var10 = class114.field1790;
                  var3 = 0;
                  if(var19.method3366("title.jpg", "")) {
                     ++var3;
                  }

                  if(var10.method3366("logo", "")) {
                     ++var3;
                  }

                  if(var10.method3366("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var10.method3366("titlebox", "")) {
                     ++var3;
                  }

                  if(var10.method3366("titlebutton", "")) {
                     ++var3;
                  }

                  if(var10.method3366("runes", "")) {
                     ++var3;
                  }

                  if(var10.method3366("title_mute", "")) {
                     ++var3;
                  }

                  if(var10.method3367("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var10.method3367("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var10.method3366("sl_back", "");
                  var10.method3366("sl_flags", "");
                  var10.method3366("sl_arrows", "");
                  var10.method3366("sl_stars", "");
                  var10.method3366("sl_button", "");
                  byte var13 = 9;
                  if(var3 < var13) {
                     class41.field834 = "Loading title screen - " + var3 * 100 / var13 + "%";
                     class41.field829 = 50;
                  } else {
                     class41.field834 = "Loaded title screen";
                     class41.field829 = 50;
                     GameObject.setGameState(5);
                     Client.field366 = 70;
                  }
               } else if(Client.field366 == 70) {
                  if(!Client.field313.method3352()) {
                     class41.field834 = "Loading config - " + Client.field313.method3451() + "%";
                     class41.field829 = 60;
                  } else {
                     class184 var16 = Client.field313;
                     Overlay.field3051 = var16;
                     class187.method3501(Client.field313);
                     var19 = Client.field313;
                     var10 = XClanMember.field266;
                     KitDefinition.field2828 = var19;
                     KitDefinition.field2819 = var10;
                     KitDefinition.field2820 = KitDefinition.field2828.method3398(3);
                     class139.method2677(Client.field313, XClanMember.field266, Client.field404);
                     class112.method2160(Client.field313, XClanMember.field266);
                     class195.method3631(Client.field313, XClanMember.field266, Client.isMembers, Client.field567);
                     XClanMember.method260(Client.field313, class22.field238, ChatMessages.field911);
                     var8 = Client.field313;
                     class184 var11 = XClanMember.field266;
                     Spotanim.field2794 = var8;
                     Spotanim.field2792 = var11;
                     class196.method3678(Client.field313);
                     class164.method3215(Client.field313);
                     class39.method813(Client.field314, XClanMember.field266, class114.field1790, Client.field533);
                     class162.method3175(Client.field313);
                     Script.method960(Client.field313);
                     class184 var12 = Client.field313;
                     class170.field2332 = var12;
                     class184 var6 = Client.field313;
                     class189.field2787 = var6;
                     class9.chatMessages = new ChatMessages();
                     class36.method800(Client.field313, class114.field1790, Client.field533);
                     FrameMap.method1753(Client.field313, class114.field1790);
                     class41.field834 = "Loaded config";
                     class41.field829 = 60;
                     Client.field366 = 80;
                  }
               } else if(Client.field366 != 80) {
                  if(Client.field366 == 90) {
                     if(!class40.field814.method3352()) {
                        class41.field834 = "Loading textures - " + class40.field814.method3451() + "%";
                        class41.field829 = 90;
                     } else {
                        TextureProvider var15 = new TextureProvider(class40.field814, class114.field1790, 20, 0.8D, Client.field404?64:128);
                        class84.method1709(var15);
                        class84.method1700(0.8D);
                        class41.field834 = "Loaded textures";
                        class41.field829 = 90;
                        Client.field366 = 110;
                     }
                  } else if(Client.field366 == 110) {
                     GameObject.field1621 = new class20();
                     class25.field579.method2031(GameObject.field1621, 10);
                     class41.field834 = "Loaded input handler";
                     class41.field829 = 94;
                     Client.field366 = 120;
                  } else if(Client.field366 == 120) {
                     if(!WallObject.field1545.method3366("huffman", "")) {
                        class41.field834 = "Loading wordpack - " + 0 + "%";
                        class41.field829 = 96;
                     } else {
                        class145 var7 = new class145(WallObject.field1545.method3365("huffman", ""));
                        class210.field3120 = var7;
                        class41.field834 = "Loaded wordpack";
                        class41.field829 = 96;
                        Client.field366 = 130;
                     }
                  } else if(Client.field366 == 130) {
                     if(!Client.field314.method3352()) {
                        class41.field834 = "Loading interfaces - " + Client.field314.method3451() * 4 / 5 + "%";
                        class41.field829 = 100;
                     } else if(!class143.field2004.method3352()) {
                        class41.field834 = "Loading interfaces - " + (80 + class143.field2004.method3451() / 6) + "%";
                        class41.field829 = 100;
                     } else if(!Client.field533.method3352()) {
                        class41.field834 = "Loading interfaces - " + (96 + Client.field533.method3451() / 20) + "%";
                        class41.field829 = 100;
                     } else {
                        class41.field834 = "Loaded interfaces";
                        class41.field829 = 100;
                        Client.field366 = 140;
                     }
                  } else if(Client.field366 == 140) {
                     GameObject.setGameState(10);
                  }
               } else {
                  var0 = 0;
                  SpritePixels var9;
                  if(null == class94.field1588) {
                     var10 = class114.field1790;
                     var3 = var10.method3363("compass");
                     var4 = var10.method3407(var3, "");
                     var9 = NPCComposition.method3812(var10, var3, var4);
                     class94.field1588 = var9;
                  } else {
                     ++var0;
                  }

                  if(class16.field171 == null) {
                     var10 = class114.field1790;
                     var3 = var10.method3363("mapedge");
                     var4 = var10.method3407(var3, "");
                     var9 = NPCComposition.method3812(var10, var3, var4);
                     class16.field171 = var9;
                  } else {
                     ++var0;
                  }

                  if(class32.field732 == null) {
                     class32.field732 = class164.method3217(class114.field1790, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class16.field177 == null) {
                     class16.field177 = class149.method2823(class114.field1790, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(Client.field440 == null) {
                     Client.field440 = class149.method2823(class114.field1790, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class159.field2121 == null) {
                     class159.field2121 = class149.method2823(class114.field1790, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class164.field2152 == null) {
                     class164.field2152 = class149.method2823(class114.field1790, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class72.field1171 == null) {
                     class72.field1171 = class149.method2823(class114.field1790, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(ScriptState.field115 == null) {
                     ScriptState.field115 = class149.method2823(class114.field1790, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(GroundObject.field1283 == null) {
                     GroundObject.field1283 = class149.method2823(class114.field1790, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class5.field47 == null) {
                     class5.field47 = class164.method3217(class114.field1790, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(null == class2.field22) {
                     class2.field22 = class164.method3217(class114.field1790, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 12) {
                     class41.field834 = "Loading sprites - " + 100 * var0 / 12 + "%";
                     class41.field829 = 70;
                  } else {
                     FontTypeFace.modIcons = class2.field22;
                     class16.field171.method4283();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(var5 = 0; var5 < class16.field177.length; ++var5) {
                        class16.field177[var5].method4245(var1 + var4, var2 + var4, var4 + var3);
                     }

                     class32.field732[0].method4188(var4 + var1, var4 + var2, var3 + var4);
                     class41.field834 = "Loaded sprites";
                     class41.field829 = 70;
                     Client.field366 = 90;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BS)V",
      garbageValue = "-15342"
   )
   static void method95(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3226 = var1.readUnsignedShort();
      class225.field3229 = new int[class225.field3226];
      class155.field2105 = new int[class225.field3226];
      class172.field2351 = new int[class225.field3226];
      class225.field3230 = new int[class225.field3226];
      class225.field3232 = new byte[class225.field3226][];
      var1.offset = var0.length - 7 - class225.field3226 * 8;
      class225.field3228 = var1.readUnsignedShort();
      class225.field3227 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3226; ++var3) {
         class225.field3229[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3226; ++var3) {
         class155.field2105[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3226; ++var3) {
         class172.field2351[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3226; ++var3) {
         class225.field3230[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3226 * 8 - (var2 - 1) * 3;
      class225.field3231 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class225.field3231[var3] = var1.read24BitInt();
         if(class225.field3231[var3] == 0) {
            class225.field3231[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3226; ++var3) {
         int var4 = class172.field2351[var3];
         int var5 = class225.field3230[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class225.field3232[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var4 * var10 + var9] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)V",
      garbageValue = "1682881854"
   )
   static void method96(class159 var0, int var1) {
      boolean var2 = var0.method3119(1) == 1;
      if(var2) {
         class45.field894[++class45.field906 - 1] = var1;
      }

      int var3 = var0.method3119(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field242 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class45.field903[var1] = (var4.pathX[0] + MessageNode.baseX >> 13 << 14) + (var4.field260 << 28) + (var4.pathY[0] + class2.baseY >> 13);
            if(var4.field610 != -1) {
               class45.field904[var1] = var4.field610;
            } else {
               class45.field904[var1] = var4.field652;
            }

            class45.field905[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3119(1) != 0) {
               CombatInfo2.method3616(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3119(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method230(var6, var7);
               var4.field242 = false;
            } else if(var2) {
               var4.field242 = true;
               var4.field244 = var6;
               var4.field264 = var7;
            } else {
               var4.field242 = false;
               var4.method253(var6, var7, class45.field897[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method3119(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field242 = true;
                  var4.field244 = var6;
                  var4.field264 = var7;
               } else {
                  var4.field242 = false;
                  var4.method253(var6, var7, class45.field897[var1]);
               }
            } else {
               var4.method230(var6, var7);
               var4.field242 = false;
            }

         } else {
            var5 = var0.method3119(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3119(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field242 = true;
                     var4.field244 = var10;
                     var4.field264 = var11;
                  } else {
                     var4.field242 = false;
                     var4.method253(var10, var11, class45.field897[var1]);
                  }
               } else {
                  var4.method230(var10, var11);
                  var4.field242 = false;
               }

               var4.field260 = (byte)(var4.field260 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  class156.plane = var4.field260;
               }

            } else {
               var6 = var0.method3119(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var4.pathX[0] + MessageNode.baseX + var8 & 16383) - MessageNode.baseX;
               var11 = (var9 + var4.pathY[0] + class2.baseY & 16383) - class2.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method230(var10, var11);
                  var4.field242 = false;
               } else if(var2) {
                  var4.field242 = true;
                  var4.field244 = var10;
                  var4.field264 = var11;
               } else {
                  var4.field242 = false;
                  var4.method253(var10, var11, class45.field897[var1]);
               }

               var4.field260 = (byte)(var4.field260 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  class156.plane = var4.field260;
               }

            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "-1593485819"
   )
   static void method97(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class31 var5 = new class31();
      var5.field697 = var0;
      var5.field710 = var1 * 128;
      var5.field699 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field704 = (var1 + var6) * 128;
      var5.field701 = (var2 + var7) * 128;
      var5.field703 = var3.ambientSoundId;
      var5.field702 = var3.field2939 * 128;
      var5.field705 = var3.field2947;
      var5.field706 = var3.field2944;
      var5.field698 = var3.field2933;
      if(null != var3.impostorIds) {
         var5.field714 = var3;
         var5.method704();
      }

      class31.field700.method2468(var5);
      if(var5.field698 != null) {
         var5.field708 = var5.field705 + (int)(Math.random() * (double)(var5.field706 - var5.field705));
      }

   }
}
