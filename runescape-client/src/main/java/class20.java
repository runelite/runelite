import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class20 implements Runnable {
   @ObfuscatedName("y")
   int[] field212 = new int[500];
   @ObfuscatedName("n")
   Object field213 = new Object();
   @ObfuscatedName("x")
   boolean field214 = true;
   @ObfuscatedName("v")
   int[] field215 = new int[500];
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1711533933
   )
   static int field217;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1662023401
   )
   int field221 = 0;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)I",
      garbageValue = "-386185109"
   )
   static int method208(class159 var0) {
      int var1 = var0.method3147(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3147(5);
      } else if(var1 == 2) {
         var2 = var0.method3147(8);
      } else {
         var2 = var0.method3147(11);
      }

      return var2;
   }

   public void run() {
      for(; this.field214; class47.method970(50L)) {
         Object var1 = this.field213;
         synchronized(this.field213) {
            if(this.field221 < 500) {
               this.field215[this.field221] = class115.field1805;
               this.field212[this.field221] = class115.field1806;
               ++this.field221;
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "2089551456"
   )
   static final boolean method211(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2006222799"
   )
   static void method212() {
      int var0;
      if(Client.field315 == 0) {
         Friend.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class26.field595 = new SpritePixels(512, 512);
         class41.field855 = "Starting game engine...";
         class41.field853 = 5;
         Client.field315 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field315 == 20) {
            int[] var24 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 15 + 128 + var1 * 32;
               var3 = var2 * 3 + 600;
               var4 = class84.field1460[var2];
               var24[var1] = var3 * var4 >> 16;
            }

            Region.method1824(var24, 500, 800, 512, 334);
            class41.field855 = "Prepared visibility map";
            class41.field853 = 10;
            Client.field315 = 30;
         } else if(Client.field315 == 30) {
            class5.field38 = class10.method148(0, false, true, true);
            class0.field0 = class10.method148(1, false, true, true);
            Client.field499 = class10.method148(2, true, false, true);
            class40.field818 = class10.method148(3, false, true, true);
            class150.field2041 = class10.method148(4, false, true, true);
            class154.field2094 = class10.method148(5, true, true, true);
            Client.field306 = class10.method148(6, true, true, false);
            class9.field74 = class10.method148(7, false, true, true);
            class39.field808 = class10.method148(8, false, true, true);
            class8.field68 = class10.method148(9, false, true, true);
            Friend.field146 = class10.method148(10, false, true, true);
            WidgetNode.field175 = class10.method148(11, false, true, true);
            Tile.field1358 = class10.method148(12, false, true, true);
            GroundObject.field1308 = class10.method148(13, true, false, true);
            WidgetNode.field180 = class10.method148(14, false, true, false);
            class184.field2743 = class10.method148(15, false, true, true);
            class41.field855 = "Connecting to update server";
            class41.field853 = 20;
            Client.field315 = 40;
         } else if(Client.field315 == 40) {
            byte var21 = 0;
            var0 = var21 + class5.field38.method3461() * 4 / 100;
            var0 += class0.field0.method3461() * 4 / 100;
            var0 += Client.field499.method3461() * 2 / 100;
            var0 += class40.field818.method3461() * 2 / 100;
            var0 += class150.field2041.method3461() * 6 / 100;
            var0 += class154.field2094.method3461() * 4 / 100;
            var0 += Client.field306.method3461() * 2 / 100;
            var0 += class9.field74.method3461() * 60 / 100;
            var0 += class39.field808.method3461() * 2 / 100;
            var0 += class8.field68.method3461() * 2 / 100;
            var0 += Friend.field146.method3461() * 2 / 100;
            var0 += WidgetNode.field175.method3461() * 2 / 100;
            var0 += Tile.field1358.method3461() * 2 / 100;
            var0 += GroundObject.field1308.method3461() * 2 / 100;
            var0 += WidgetNode.field180.method3461() * 2 / 100;
            var0 += class184.field2743.method3461() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field855 = "Checking for updates - " + var0 + "%";
               }

               class41.field853 = 30;
            } else {
               class41.field855 = "Loaded update list";
               class41.field853 = 30;
               Client.field315 = 45;
            }
         } else if(Client.field315 == 45) {
            boolean var20 = !Client.field290;
            class57.field1053 = 22050;
            class57.field1059 = var20;
            class57.field1052 = 2;
            class139 var26 = new class139();
            var26.method2583(9, 128);
            class36.field772 = class7.method102(class114.field1793, class110.canvas, 0, 22050);
            class36.field772.method1122(var26);
            CombatInfo1.method647(class184.field2743, WidgetNode.field180, class150.field2041, var26);
            FaceNormal.field1570 = class7.method102(class114.field1793, class110.canvas, 1, 2048);
            Client.field572 = new class51();
            FaceNormal.field1570.method1122(Client.field572);
            DecorativeObject.field1602 = new class65(22050, class57.field1053);
            class41.field855 = "Prepared sound engine";
            class41.field853 = 35;
            Client.field315 = 50;
         } else if(Client.field315 == 50) {
            var0 = 0;
            if(null == Friend.field151) {
               Friend.field151 = Frames.method1991(class39.field808, GroundObject.field1308, "p11_full", "");
            } else {
               ++var0;
            }

            if(null == class15.field162) {
               class15.field162 = Frames.method1991(class39.field808, GroundObject.field1308, "p12_full", "");
            } else {
               ++var0;
            }

            if(class217.field3188 == null) {
               class217.field3188 = Frames.method1991(class39.field808, GroundObject.field1308, "b12_full", "");
            } else {
               ++var0;
            }

            if(var0 < 3) {
               class41.field855 = "Loading fonts - " + var0 * 100 / 3 + "%";
               class41.field853 = 40;
            } else {
               class88.field1545 = new class230(true);
               class41.field855 = "Loaded fonts";
               class41.field853 = 40;
               Client.field315 = 60;
            }
         } else if(Client.field315 == 60) {
            var0 = class159.method3166(Friend.field146, class39.field808);
            byte var18 = 9;
            if(var0 < var18) {
               class41.field855 = "Loading title screen - " + var0 * 100 / var18 + "%";
               class41.field853 = 50;
            } else {
               class41.field855 = "Loaded title screen";
               class41.field853 = 50;
               World.setGameState(5);
               Client.field315 = 70;
            }
         } else {
            class184 var16;
            if(Client.field315 == 70) {
               if(!Client.field499.method3365()) {
                  class41.field855 = "Loading config - " + Client.field499.method3451() + "%";
                  class41.field853 = 60;
               } else {
                  CombatInfo2.method3606(Client.field499);
                  class184 var23 = Client.field499;
                  FloorUnderlayDefinition.field2812 = var23;
                  class6.method90(Client.field499, class9.field74);
                  class103.method2075(Client.field499, class9.field74, Client.field290);
                  class104.method2089(Client.field499, class9.field74);
                  class184 var25 = Client.field499;
                  var16 = class9.field74;
                  boolean var19 = Client.isMembers;
                  Font var17 = Friend.field151;
                  ItemComposition.field2978 = var25;
                  ItemComposition.field2955 = var16;
                  Item.isMembersWorld = var19;
                  SecondaryBufferProvider.field3217 = ItemComposition.field2978.method3352(10);
                  class22.field235 = var17;
                  class184 var5 = Client.field499;
                  class184 var6 = class5.field38;
                  class184 var7 = class0.field0;
                  Sequence.field3072 = var5;
                  class203.field3085 = var6;
                  Sequence.field3059 = var7;
                  class184 var8 = Client.field499;
                  class184 var9 = class9.field74;
                  Spotanim.field2798 = var8;
                  class202.field3081 = var9;
                  class184 var10 = Client.field499;
                  Varbit.field2854 = var10;
                  class1.method20(Client.field499);
                  Player.method258(class40.field818, class9.field74, class39.field808, GroundObject.field1308);
                  class184 var11 = Client.field499;
                  class186.field2770 = var11;
                  class184 var12 = Client.field499;
                  class195.field2860 = var12;
                  class116.method2341(Client.field499);
                  class0.method13(Client.field499);
                  class22.chatMessages = new ChatMessages();
                  GroundObject.method1626(Client.field499, class39.field808, GroundObject.field1308);
                  Actor.method640(Client.field499, class39.field808);
                  class41.field855 = "Loaded config";
                  class41.field853 = 60;
                  Client.field315 = 80;
               }
            } else if(Client.field315 != 80) {
               if(Client.field315 == 90) {
                  if(!class8.field68.method3365()) {
                     class41.field855 = "Loading textures - " + class8.field68.method3451() + "%";
                     class41.field853 = 90;
                  } else {
                     TextureProvider var22 = new TextureProvider(class8.field68, class39.field808, 20, 0.8D, Client.field290?64:128);
                     class84.method1739(var22);
                     class84.method1728(0.8D);
                     class41.field855 = "Loaded textures";
                     class41.field853 = 90;
                     Client.field315 = 110;
                  }
               } else if(Client.field315 == 110) {
                  Client.field286 = new class20();
                  class114.field1793.method2067(Client.field286, 10);
                  class41.field855 = "Loaded input handler";
                  class41.field853 = 94;
                  Client.field315 = 120;
               } else if(Client.field315 == 120) {
                  if(!Friend.field146.method3372("huffman", "")) {
                     class41.field855 = "Loading wordpack - " + 0 + "%";
                     class41.field853 = 96;
                  } else {
                     class145 var13 = new class145(Friend.field146.method3371("huffman", ""));
                     class187.method3505(var13);
                     class41.field855 = "Loaded wordpack";
                     class41.field853 = 96;
                     Client.field315 = 130;
                  }
               } else if(Client.field315 == 130) {
                  if(!class40.field818.method3365()) {
                     class41.field855 = "Loading interfaces - " + class40.field818.method3451() * 4 / 5 + "%";
                     class41.field853 = 100;
                  } else if(!Tile.field1358.method3365()) {
                     class41.field855 = "Loading interfaces - " + (80 + Tile.field1358.method3451() / 6) + "%";
                     class41.field853 = 100;
                  } else if(!GroundObject.field1308.method3365()) {
                     class41.field855 = "Loading interfaces - " + (96 + GroundObject.field1308.method3451() / 20) + "%";
                     class41.field853 = 100;
                  } else {
                     class41.field855 = "Loaded interfaces";
                     class41.field853 = 100;
                     Client.field315 = 140;
                  }
               } else if(Client.field315 == 140) {
                  World.setGameState(10);
               }
            } else {
               var0 = 0;
               SpritePixels var14;
               if(null == Projectile.field884) {
                  var16 = class39.field808;
                  var3 = var16.method3426("compass");
                  var4 = var16.method3370(var3, "");
                  var14 = GameEngine.method2296(var16, var3, var4);
                  Projectile.field884 = var14;
               } else {
                  ++var0;
               }

               if(null == class38.field797) {
                  var16 = class39.field808;
                  var3 = var16.method3426("mapedge");
                  var4 = var16.method3370(var3, "");
                  var14 = GameEngine.method2296(var16, var3, var4);
                  class38.field797 = var14;
               } else {
                  ++var0;
               }

               if(null == class143.field2002) {
                  class143.field2002 = XItemContainer.method169(class39.field808, "mapscene", "");
               } else {
                  ++var0;
               }

               if(null == class207.field3102) {
                  class207.field3102 = class149.method2849(class39.field808, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(class162.field2150 == null) {
                  class162.field2150 = class149.method2849(class39.field808, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(Projectile.field869 == null) {
                  Projectile.field869 = class149.method2849(class39.field808, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(CombatInfoListHolder.field758 == null) {
                  CombatInfoListHolder.field758 = class149.method2849(class39.field808, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(null == class16.field170) {
                  class16.field170 = class149.method2849(class39.field808, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(null == class7.field57) {
                  class7.field57 = class149.method2849(class39.field808, "cross", "");
               } else {
                  ++var0;
               }

               if(null == class44.field902) {
                  class44.field902 = class149.method2849(class39.field808, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class9.field73 == null) {
                  class9.field73 = XItemContainer.method169(class39.field808, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(CollisionData.field1838 == null) {
                  CollisionData.field1838 = XItemContainer.method169(class39.field808, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class41.field855 = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class41.field853 = 70;
               } else {
                  FontTypeFace.modIcons = CollisionData.field1838;
                  class38.field797.method4166();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var15 = 0; var15 < class207.field3102.length; ++var15) {
                     class207.field3102[var15].method4165(var4 + var1, var2 + var4, var4 + var3);
                  }

                  class143.field2002[0].method4114(var4 + var1, var2 + var4, var3 + var4);
                  class41.field855 = "Loaded sprites";
                  class41.field853 = 70;
                  Client.field315 = 90;
               }
            }
         }
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2050483412"
   )
   static final void method213() {
      Client.field334.method3165();
      int var0 = Client.field334.method3147(8);
      int var1;
      if(var0 < Client.field328) {
         for(var1 = var0; var1 < Client.field328; ++var1) {
            Client.field318[++Client.field557 - 1] = Client.field285[var1];
         }
      }

      if(var0 > Client.field328) {
         throw new RuntimeException("");
      } else {
         Client.field328 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.field285[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.field334.method3147(1);
            if(var4 == 0) {
               Client.field285[++Client.field328 - 1] = var2;
               var3.field622 = Client.gameCycle;
            } else {
               int var5 = Client.field334.method3147(2);
               if(var5 == 0) {
                  Client.field285[++Client.field328 - 1] = var2;
                  var3.field622 = Client.gameCycle;
                  Client.field331[++Client.field513 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.field285[++Client.field328 - 1] = var2;
                     var3.field622 = Client.gameCycle;
                     var6 = Client.field334.method3147(3);
                     var3.method795(var6, (byte)1);
                     var7 = Client.field334.method3147(1);
                     if(var7 == 1) {
                        Client.field331[++Client.field513 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.field285[++Client.field328 - 1] = var2;
                     var3.field622 = Client.gameCycle;
                     var6 = Client.field334.method3147(3);
                     var3.method795(var6, (byte)2);
                     var7 = Client.field334.method3147(3);
                     var3.method795(var7, (byte)2);
                     int var8 = Client.field334.method3147(1);
                     if(var8 == 1) {
                        Client.field331[++Client.field513 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field318[++Client.field557 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZS)Z",
      garbageValue = "1536"
   )
   static boolean method215(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class60.method1229(var0, class149.field2037);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class60.method1229(Client.friends[var3].name, class149.field2037)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class60.method1229(WidgetNode.localPlayer.name, class149.field2037))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
