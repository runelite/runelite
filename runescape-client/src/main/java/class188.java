import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class188 extends CacheableNode {
   @ObfuscatedName("c")
   static NodeCache field2775;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1151228391
   )
   public int field2776;
   @ObfuscatedName("z")
   static Game field2778;
   @ObfuscatedName("d")
   public static IndexDataBase field2781;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-860826209"
   )
   void method3424(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3425(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-189845601"
   )
   void method3425(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2776 = var1.readUnsignedShort();
      }

   }

   static {
      field2775 = new NodeCache(64);
   }

   class188() {
      this.field2776 = 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1344276693"
   )
   static void method3430() {
      int var0;
      if(Client.field308 == 0) {
         class172.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         ISAACCipher.field2000 = new SpritePixels(512, 512);
         class41.field829 = "Starting game engine...";
         class41.field817 = 5;
         Client.field308 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field308 == 20) {
            int[] var24 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 128 + 15;
               var3 = var2 * 3 + 600;
               var4 = class84.field1433[var2];
               var24[var1] = var4 * var3 >> 16;
            }

            Region.method1756(var24, 500, 800, 512, 334);
            class41.field829 = "Prepared visibility map";
            class41.field817 = 10;
            Client.field308 = 30;
         } else if(Client.field308 == 30) {
            class122.indexInterfaces = class13.method177(0, false, true, true);
            class33.indexSoundEffects = class13.method177(1, false, true, true);
            class213.field3150 = class13.method177(2, true, false, true);
            class8.field78 = class13.method177(3, false, true, true);
            class199.field2882 = class13.method177(4, false, true, true);
            FileOnDisk.indexMaps = class13.method177(5, true, true, true);
            class18.indexTrack1 = class13.method177(6, true, true, false);
            class45.indexModels = class13.method177(7, false, true, true);
            WallObject.indexSprites = class13.method177(8, false, true, true);
            class214.indexTextures = class13.method177(9, false, true, true);
            Client.field312 = class13.method177(10, false, true, true);
            KitDefinition.indexTrack2 = class13.method177(11, false, true, true);
            class107.indexScripts = class13.method177(12, false, true, true);
            DecorativeObject.field1584 = class13.method177(13, true, false, true);
            class9.field84 = class13.method177(14, false, true, false);
            class16.field177 = class13.method177(15, false, true, true);
            class41.field829 = "Connecting to update server";
            class41.field817 = 20;
            Client.field308 = 40;
         } else if(Client.field308 == 40) {
            byte var21 = 0;
            var0 = var21 + class122.indexInterfaces.method3407() * 4 / 100;
            var0 += class33.indexSoundEffects.method3407() * 4 / 100;
            var0 += class213.field3150.method3407() * 2 / 100;
            var0 += class8.field78.method3407() * 2 / 100;
            var0 += class199.field2882.method3407() * 6 / 100;
            var0 += FileOnDisk.indexMaps.method3407() * 4 / 100;
            var0 += class18.indexTrack1.method3407() * 2 / 100;
            var0 += class45.indexModels.method3407() * 60 / 100;
            var0 += WallObject.indexSprites.method3407() * 2 / 100;
            var0 += class214.indexTextures.method3407() * 2 / 100;
            var0 += Client.field312.method3407() * 2 / 100;
            var0 += KitDefinition.indexTrack2.method3407() * 2 / 100;
            var0 += class107.indexScripts.method3407() * 2 / 100;
            var0 += DecorativeObject.field1584.method3407() * 2 / 100;
            var0 += class9.field84.method3407() * 2 / 100;
            var0 += class16.field177.method3407() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field829 = "Checking for updates - " + var0 + "%";
               }

               class41.field817 = 30;
            } else {
               class41.field829 = "Loaded update list";
               class41.field817 = 30;
               Client.field308 = 45;
            }
         } else {
            IndexData var16;
            IndexData var17;
            IndexData var18;
            if(Client.field308 == 45) {
               boolean var20 = !Client.field285;
               class57.field1032 = 22050;
               class57.field1047 = var20;
               class196.field2862 = 2;
               class160 var27 = new class160();
               var27.method2914(9, 128);
               class8.field70 = class33.method717(class45.field896, class65.canvas, 0, 22050);
               class8.field70.method1065(var27);
               var16 = class16.field177;
               var17 = class9.field84;
               var18 = class199.field2882;
               class159.field2068 = var16;
               class159.field2064 = var17;
               class159.field2070 = var18;
               class159.field2066 = var27;
               class6.field56 = class33.method717(class45.field896, class65.canvas, 1, 2048);
               class114.field1791 = new class51();
               class6.field56.method1065(class114.field1791);
               class118.field1848 = new class65(22050, class57.field1032);
               class41.field829 = "Prepared sound engine";
               class41.field817 = 35;
               Client.field308 = 50;
            } else {
               int var5;
               if(Client.field308 == 50) {
                  var0 = 0;
                  Font var26;
                  if(class36.field766 == null) {
                     var16 = WallObject.indexSprites;
                     var17 = DecorativeObject.field1584;
                     var4 = var16.method3296("p11_full");
                     var5 = var16.method3310(var4, "");
                     var26 = Tile.method1568(var16, var17, var4, var5);
                     class36.field766 = var26;
                  } else {
                     ++var0;
                  }

                  if(WallObject.field1542 == null) {
                     var16 = WallObject.indexSprites;
                     var17 = DecorativeObject.field1584;
                     var4 = var16.method3296("p12_full");
                     var5 = var16.method3310(var4, "");
                     var26 = Tile.method1568(var16, var17, var4, var5);
                     WallObject.field1542 = var26;
                  } else {
                     ++var0;
                  }

                  if(TextureProvider.field1192 == null) {
                     var16 = WallObject.indexSprites;
                     var17 = DecorativeObject.field1584;
                     var4 = var16.method3296("b12_full");
                     var5 = var16.method3310(var4, "");
                     var26 = Tile.method1568(var16, var17, var4, var5);
                     TextureProvider.field1192 = var26;
                  } else {
                     ++var0;
                  }

                  if(var0 < 3) {
                     class41.field829 = "Loading fonts - " + var0 * 100 / 3 + "%";
                     class41.field817 = 40;
                  } else {
                     class5.field49 = new class234(true);
                     class41.field829 = "Loaded fonts";
                     class41.field817 = 40;
                     Client.field308 = 60;
                  }
               } else {
                  IndexData var25;
                  if(Client.field308 == 60) {
                     var25 = Client.field312;
                     var16 = WallObject.indexSprites;
                     var3 = 0;
                     if(var25.method3312("title.jpg", "")) {
                        ++var3;
                     }

                     if(var16.method3312("logo", "")) {
                        ++var3;
                     }

                     if(var16.method3312("logo_deadman_mode", "")) {
                        ++var3;
                     }

                     if(var16.method3312("titlebox", "")) {
                        ++var3;
                     }

                     if(var16.method3312("titlebutton", "")) {
                        ++var3;
                     }

                     if(var16.method3312("runes", "")) {
                        ++var3;
                     }

                     if(var16.method3312("title_mute", "")) {
                        ++var3;
                     }

                     if(var16.method3352("options_radio_buttons,0")) {
                        ++var3;
                     }

                     if(var16.method3352("options_radio_buttons,2")) {
                        ++var3;
                     }

                     var16.method3312("sl_back", "");
                     var16.method3312("sl_flags", "");
                     var16.method3312("sl_arrows", "");
                     var16.method3312("sl_stars", "");
                     var16.method3312("sl_button", "");
                     var4 = MessageNode.method220();
                     if(var3 < var4) {
                        class41.field829 = "Loading title screen - " + var3 * 100 / var4 + "%";
                        class41.field817 = 50;
                     } else {
                        class41.field829 = "Loaded title screen";
                        class41.field817 = 50;
                        class9.setGameState(5);
                        Client.field308 = 70;
                     }
                  } else if(Client.field308 == 70) {
                     if(!class213.field3150.method3299()) {
                        class41.field829 = "Loading config - " + class213.field3150.method3399() + "%";
                        class41.field817 = 60;
                     } else {
                        ObjectComposition.method3733(class213.field3150);
                        IndexData var23 = class213.field3150;
                        FloorUnderlayDefinition.field2820 = var23;
                        class120.method2299(class213.field3150, class45.indexModels);
                        class16.method192(class213.field3150, class45.indexModels, Client.field285);
                        var25 = class213.field3150;
                        var16 = class45.indexModels;
                        NPCComposition.field3038 = var25;
                        NPCComposition.field3034 = var16;
                        var17 = class213.field3150;
                        class199.field2883 = var17;
                        var18 = class213.field3150;
                        IndexData var19 = class45.indexModels;
                        boolean var6 = Client.isMembers;
                        Font var7 = class36.field766;
                        ItemComposition.field2979 = var18;
                        class189.field2787 = var19;
                        ItemComposition.isMembersWorld = var6;
                        ItemComposition.field2981 = ItemComposition.field2979.method3305(10);
                        ItemComposition.field3005 = var7;
                        GameEngine.method2203(class213.field3150, class122.indexInterfaces, class33.indexSoundEffects);
                        class97.method1934(class213.field3150, class45.indexModels);
                        class38.method770(class213.field3150);
                        class18.method201(class213.field3150);
                        CombatInfo2.method3559(class8.field78, class45.indexModels, WallObject.indexSprites, DecorativeObject.field1584);
                        IndexData var8 = class213.field3150;
                        field2781 = var8;
                        class179.method3272(class213.field3150);
                        IndexData var9 = class213.field3150;
                        class190.field2789 = var9;
                        WallObject.method1905(class213.field3150);
                        IndexData var10 = class213.field3150;
                        class198.field2872 = var10;
                        XClanMember.chatMessages = new ChatMessages();
                        IndexData var11 = class213.field3150;
                        IndexData var12 = WallObject.indexSprites;
                        IndexData var13 = DecorativeObject.field1584;
                        class201.field2920 = var11;
                        class201.field2918 = var12;
                        class201.field2897 = var13;
                        class160.method3021(class213.field3150, WallObject.indexSprites);
                        class41.field829 = "Loaded config";
                        class41.field817 = 60;
                        Client.field308 = 80;
                     }
                  } else if(Client.field308 != 80) {
                     if(Client.field308 == 90) {
                        if(!class214.indexTextures.method3299()) {
                           class41.field829 = "Loading textures - " + class214.indexTextures.method3399() + "%";
                           class41.field817 = 90;
                        } else {
                           TextureProvider var22 = new TextureProvider(class214.indexTextures, WallObject.indexSprites, 20, 0.8D, Client.field285?64:128);
                           class84.method1710(var22);
                           class84.method1651(0.8D);
                           class41.field829 = "Loaded textures";
                           class41.field817 = 90;
                           Client.field308 = 110;
                        }
                     } else if(Client.field308 == 110) {
                        class180.field2678 = new class20();
                        class45.field896.method1968(class180.field2678, 10);
                        class41.field829 = "Loaded input handler";
                        class41.field817 = 94;
                        Client.field308 = 120;
                     } else if(Client.field308 == 120) {
                        if(!Client.field312.method3312("huffman", "")) {
                           class41.field829 = "Loading wordpack - " + 0 + "%";
                           class41.field817 = 96;
                        } else {
                           class121 var14 = new class121(Client.field312.method3311("huffman", ""));
                           Varbit.method3582(var14);
                           class41.field829 = "Loaded wordpack";
                           class41.field817 = 96;
                           Client.field308 = 130;
                        }
                     } else if(Client.field308 == 130) {
                        if(!class8.field78.method3299()) {
                           class41.field829 = "Loading interfaces - " + class8.field78.method3399() * 4 / 5 + "%";
                           class41.field817 = 100;
                        } else if(!class107.indexScripts.method3299()) {
                           class41.field829 = "Loading interfaces - " + (class107.indexScripts.method3399() / 6 + 80) + "%";
                           class41.field817 = 100;
                        } else if(!DecorativeObject.field1584.method3299()) {
                           class41.field829 = "Loading interfaces - " + (DecorativeObject.field1584.method3399() / 20 + 96) + "%";
                           class41.field817 = 100;
                        } else {
                           class41.field829 = "Loaded interfaces";
                           class41.field817 = 100;
                           Client.field308 = 140;
                        }
                     } else if(Client.field308 == 140) {
                        class9.setGameState(10);
                     }
                  } else {
                     var0 = 0;
                     SpritePixels var15;
                     if(ItemLayer.field1204 == null) {
                        var16 = WallObject.indexSprites;
                        var3 = var16.method3296("compass");
                        var4 = var16.method3310(var3, "");
                        var15 = Ignore.method203(var16, var3, var4);
                        ItemLayer.field1204 = var15;
                     } else {
                        ++var0;
                     }

                     if(Client.field359 == null) {
                        var16 = WallObject.indexSprites;
                        var3 = var16.method3296("mapedge");
                        var4 = var16.method3310(var3, "");
                        var15 = Ignore.method203(var16, var3, var4);
                        Client.field359 = var15;
                     } else {
                        ++var0;
                     }

                     if(GroundObject.field1284 == null) {
                        GroundObject.field1284 = class210.method4011(WallObject.indexSprites, "mapscene", "");
                     } else {
                        ++var0;
                     }

                     if(class107.field1719 == null) {
                        class107.field1719 = ObjectComposition.method3734(WallObject.indexSprites, "mapfunction", "");
                     } else {
                        ++var0;
                     }

                     if(Script.field938 == null) {
                        Script.field938 = ObjectComposition.method3734(WallObject.indexSprites, "headicons_pk", "");
                     } else {
                        ++var0;
                     }

                     if(VertexNormal.field1414 == null) {
                        VertexNormal.field1414 = ObjectComposition.method3734(WallObject.indexSprites, "headicons_prayer", "");
                     } else {
                        ++var0;
                     }

                     if(class108.field1726 == null) {
                        class108.field1726 = ObjectComposition.method3734(WallObject.indexSprites, "headicons_hint", "");
                     } else {
                        ++var0;
                     }

                     if(class5.field50 == null) {
                        class5.field50 = ObjectComposition.method3734(WallObject.indexSprites, "mapmarker", "");
                     } else {
                        ++var0;
                     }

                     if(PlayerComposition.field2181 == null) {
                        PlayerComposition.field2181 = ObjectComposition.method3734(WallObject.indexSprites, "cross", "");
                     } else {
                        ++var0;
                     }

                     if(class49.field956 == null) {
                        class49.field956 = ObjectComposition.method3734(WallObject.indexSprites, "mapdots", "");
                     } else {
                        ++var0;
                     }

                     if(class128.field1952 == null) {
                        class128.field1952 = class210.method4011(WallObject.indexSprites, "scrollbar", "");
                     } else {
                        ++var0;
                     }

                     if(class40.field804 == null) {
                        class40.field804 = class210.method4011(WallObject.indexSprites, "mod_icons", "");
                     } else {
                        ++var0;
                     }

                     if(var0 < 12) {
                        class41.field829 = "Loading sprites - " + var0 * 100 / 12 + "%";
                        class41.field817 = 70;
                     } else {
                        FontTypeFace.modIcons = class40.field804;
                        Client.field359.method4240();
                        var1 = (int)(Math.random() * 21.0D) - 10;
                        var2 = (int)(Math.random() * 21.0D) - 10;
                        var3 = (int)(Math.random() * 21.0D) - 10;
                        var4 = (int)(Math.random() * 41.0D) - 20;

                        for(var5 = 0; var5 < class107.field1719.length; ++var5) {
                           class107.field1719[var5].method4221(var4 + var1, var4 + var2, var4 + var3);
                        }

                        GroundObject.field1284[0].method4169(var1 + var4, var4 + var2, var4 + var3);
                        class41.field829 = "Loaded sprites";
                        class41.field817 = 70;
                        Client.field308 = 90;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-505579308"
   )
   static final void method3431(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class99.menuAction(var1, var2, var3, var4, var5, var6, class115.field1802, class115.field1813);
      }
   }
}
