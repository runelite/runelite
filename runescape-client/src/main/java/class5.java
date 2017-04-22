import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
final class class5 implements Comparator {
   @ObfuscatedName("eh")
   static ModIcon[] field47;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -1213060431
   )
   static int field54;
   @ObfuscatedName("u")
   static IndexDataBase field55;
   @ObfuscatedName("bq")
   static IndexData field56;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1459568810"
   )
   static boolean method58(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method67((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "792098875"
   )
   static final void method61(int var0, int var1) {
      if(Friend.field161 != var0 || class148.field2056 != var1) {
         Friend.field161 = var0;
         class148.field2056 = var1;
         GameObject.setGameState(25);
         GameEngine.method2242("Loading - please wait.", true);
         int var2 = class119.baseX;
         int var3 = class187.baseY;
         class119.baseX = (var0 - 6) * 8;
         class187.baseY = (var1 - 6) * 8;
         int var4 = class119.baseX - var2;
         int var5 = class187.baseY - var3;
         var2 = class119.baseX;
         var3 = class187.baseY;

         int var6;
         int var7;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var8 = Client.cachedNPCs[var6];
            if(var8 != null) {
               for(var7 = 0; var7 < 10; ++var7) {
                  var8.pathX[var7] -= var4;
                  var8.pathY[var7] -= var5;
               }

               var8.x -= var4 * 128;
               var8.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var19 = Client.cachedPlayers[var6];
            if(var19 != null) {
               for(var7 = 0; var7 < 10; ++var7) {
                  var19.pathX[var7] -= var4;
                  var19.pathY[var7] -= var5;
               }

               var19.x -= var4 * 128;
               var19.y -= var5 * 128;
            }
         }

         byte var20 = 0;
         byte var9 = 104;
         byte var10 = 1;
         if(var4 < 0) {
            var20 = 103;
            var9 = -1;
            var10 = -1;
         }

         byte var11 = 0;
         byte var12 = 104;
         byte var13 = 1;
         if(var5 < 0) {
            var11 = 103;
            var12 = -1;
            var13 = -1;
         }

         int var14;
         for(int var15 = var20; var9 != var15; var15 += var10) {
            for(var14 = var11; var12 != var14; var14 += var13) {
               int var16 = var15 + var4;
               int var17 = var5 + var14;

               for(int var18 = 0; var18 < 4; ++var18) {
                  if(var16 >= 0 && var17 >= 0 && var16 < 104 && var17 < 104) {
                     Client.groundItemDeque[var18][var15][var14] = Client.groundItemDeque[var18][var16][var17];
                  } else {
                     Client.groundItemDeque[var18][var15][var14] = null;
                  }
               }
            }
         }

         for(class25 var21 = (class25)Client.field461.method2464(); var21 != null; var21 = (class25)Client.field461.method2472()) {
            var21.field599 -= var4;
            var21.field597 -= var5;
            if(var21.field599 < 0 || var21.field597 < 0 || var21.field599 >= 104 || var21.field597 >= 104) {
               var21.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field545 = 0;
         Client.field446 = false;
         Client.field459 = -1;
         Client.field391.method2458();
         Client.projectiles.method2458();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].method2346();
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-302579386"
   )
   static void method65() {
      int var0;
      if(Client.field330 == 0) {
         CombatInfo1.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         CombatInfo1.field686 = new SpritePixels(512, 512);
         class41.field852 = "Starting game engine...";
         class41.field851 = 5;
         Client.field330 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field330 == 20) {
            int[] var5 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 143;
               var3 = var2 * 3 + 600;
               var4 = class84.field1475[var2];
               var5[var1] = var4 * var3 >> 16;
            }

            Region.method1810(var5, 500, 800, 512, 334);
            class41.field852 = "Prepared visibility map";
            class41.field851 = 10;
            Client.field330 = 30;
         } else if(Client.field330 == 30) {
            class157.field2137 = class9.method98(0, false, true, true);
            ChatLineBuffer.indexConfigs = class9.method98(1, false, true, true);
            ChatLineBuffer.field990 = class9.method98(2, true, false, true);
            class37.indexInterfaces = class9.method98(3, false, true, true);
            IndexFile.indexSoundEffects = class9.method98(4, false, true, true);
            class205.indexMaps = class9.method98(5, true, true, true);
            Client.indexTrack1 = class9.method98(6, true, true, false);
            CollisionData.indexModels = class9.method98(7, false, true, true);
            FileOnDisk.indexSprites = class9.method98(8, false, true, true);
            class171.indexTextures = class9.method98(9, false, true, true);
            WallObject.field1581 = class9.method98(10, false, true, true);
            Friend.indexTrack2 = class9.method98(11, false, true, true);
            Projectile.indexScripts = class9.method98(12, false, true, true);
            field56 = class9.method98(13, true, false, true);
            class57.field1083 = class9.method98(14, false, true, false);
            Ignore.field215 = class9.method98(15, false, true, true);
            class41.field852 = "Connecting to update server";
            class41.field851 = 20;
            Client.field330 = 40;
         } else if(Client.field330 == 40) {
            byte var28 = 0;
            var0 = var28 + class157.field2137.method3425() * 4 / 100;
            var0 += ChatLineBuffer.indexConfigs.method3425() * 4 / 100;
            var0 += ChatLineBuffer.field990.method3425() * 2 / 100;
            var0 += class37.indexInterfaces.method3425() * 2 / 100;
            var0 += IndexFile.indexSoundEffects.method3425() * 6 / 100;
            var0 += class205.indexMaps.method3425() * 4 / 100;
            var0 += Client.indexTrack1.method3425() * 2 / 100;
            var0 += CollisionData.indexModels.method3425() * 60 / 100;
            var0 += FileOnDisk.indexSprites.method3425() * 2 / 100;
            var0 += class171.indexTextures.method3425() * 2 / 100;
            var0 += WallObject.field1581.method3425() * 2 / 100;
            var0 += Friend.indexTrack2.method3425() * 2 / 100;
            var0 += Projectile.indexScripts.method3425() * 2 / 100;
            var0 += field56.method3425() * 2 / 100;
            var0 += class57.field1083.method3425() * 2 / 100;
            var0 += Ignore.field215.method3425() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field852 = "Checking for updates - " + var0 + "%";
               }

               class41.field851 = 30;
            } else {
               class41.field852 = "Loaded update list";
               class41.field851 = 30;
               Client.field330 = 45;
            }
         } else {
            IndexData var6;
            IndexData var29;
            if(Client.field330 == 45) {
               boolean var7 = !Client.field306;
               class57.field1077 = 22050;
               class57.field1078 = var7;
               class217.field3186 = 2;
               class139 var8 = new class139();
               var8.method2577(9, 128);
               class2.field23 = RSSocket.method2120(class108.field1755, Projectile.canvas, 0, 22050);
               class2.field23.method1081(var8);
               var6 = Ignore.field215;
               IndexData var9 = class57.field1083;
               var29 = IndexFile.indexSoundEffects;
               class138.field1945 = var6;
               class146.field2037 = var9;
               class138.field1942 = var29;
               class138.field1939 = var8;
               class137.field1927 = RSSocket.method2120(class108.field1755, Projectile.canvas, 1, 2048);
               Ignore.field224 = new class51();
               class137.field1927.method1081(Ignore.field224);
               class118.field1868 = new class65(22050, class57.field1077);
               class41.field852 = "Prepared sound engine";
               class41.field851 = 35;
               Client.field330 = 50;
            } else if(Client.field330 == 50) {
               var0 = 0;
               if(class180.field2717 == null) {
                  class180.field2717 = class185.method3473(FileOnDisk.indexSprites, field56, "p11_full", "");
               } else {
                  ++var0;
               }

               if(Player.field282 == null) {
                  Player.field282 = class185.method3473(FileOnDisk.indexSprites, field56, "p12_full", "");
               } else {
                  ++var0;
               }

               if(class63.field1119 == null) {
                  class63.field1119 = class185.method3473(FileOnDisk.indexSprites, field56, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class41.field852 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class41.field851 = 40;
               } else {
                  WallObject.field1573 = new class230(true);
                  class41.field852 = "Loaded fonts";
                  class41.field851 = 40;
                  Client.field330 = 60;
               }
            } else if(Client.field330 == 60) {
               var0 = FileOnDisk.method1445(WallObject.field1581, FileOnDisk.indexSprites);
               var1 = Preferences.method652();
               if(var0 < var1) {
                  class41.field852 = "Loading title screen - " + var0 * 100 / var1 + "%";
                  class41.field851 = 50;
               } else {
                  class41.field852 = "Loaded title screen";
                  class41.field851 = 50;
                  GameObject.setGameState(5);
                  Client.field330 = 70;
               }
            } else if(Client.field330 == 70) {
               if(!ChatLineBuffer.field990.method3358()) {
                  class41.field852 = "Loading config - " + ChatLineBuffer.field990.method3424() + "%";
                  class41.field851 = 60;
               } else {
                  IndexData var30 = ChatLineBuffer.field990;
                  Overlay.field3047 = var30;
                  GameObject.method1959(ChatLineBuffer.field990);
                  class101.method1999(ChatLineBuffer.field990, CollisionData.indexModels);
                  IndexData var33 = ChatLineBuffer.field990;
                  var6 = CollisionData.indexModels;
                  boolean var36 = Client.field306;
                  ObjectComposition.field2897 = var33;
                  ObjectComposition.field2898 = var6;
                  ObjectComposition.field2935 = var36;
                  var29 = ChatLineBuffer.field990;
                  IndexData var10 = CollisionData.indexModels;
                  NPCComposition.field3022 = var29;
                  NPCComposition.field3036 = var10;
                  IndexData var11 = ChatLineBuffer.field990;
                  IndexData var12 = CollisionData.indexModels;
                  boolean var13 = Client.isMembers;
                  Font var14 = class180.field2717;
                  Frames.field1592 = var11;
                  class47.field956 = var12;
                  class109.isMembersWorld = var13;
                  ItemComposition.field3000 = Frames.field1592.method3346(10);
                  ItemComposition.field2993 = var14;
                  class107.method2084(ChatLineBuffer.field990, class157.field2137, ChatLineBuffer.indexConfigs);
                  class211.method3982(ChatLineBuffer.field990, CollisionData.indexModels);
                  IndexData var15 = ChatLineBuffer.field990;
                  Varbit.field2857 = var15;
                  IndexData var16 = ChatLineBuffer.field990;
                  class187.field2788 = var16;
                  class187.field2789 = class187.field2788.method3346(16);
                  IndexData var17 = class37.indexInterfaces;
                  IndexData var18 = CollisionData.indexModels;
                  IndexData var19 = FileOnDisk.indexSprites;
                  IndexData var20 = field56;
                  Widget.field2301 = var17;
                  Widget.field2211 = var18;
                  Widget.field2317 = var19;
                  class20.field235 = var20;
                  Widget.widgets = new Widget[Widget.field2301.method3357()][];
                  class6.validInterfaces = new boolean[Widget.field2301.method3357()];
                  Preferences.method644(ChatLineBuffer.field990);
                  IndexData var21 = ChatLineBuffer.field990;
                  class195.field2867 = var21;
                  IndexData var22 = ChatLineBuffer.field990;
                  class188.field2797 = var22;
                  Client.method557(ChatLineBuffer.field990);
                  class9.chatMessages = new ChatMessages();
                  IndexData var23 = ChatLineBuffer.field990;
                  IndexData var24 = FileOnDisk.indexSprites;
                  IndexData var25 = field56;
                  class196.field2885 = var23;
                  class196.field2883 = var24;
                  class0.field5 = var25;
                  IndexData var26 = ChatLineBuffer.field990;
                  IndexData var27 = FileOnDisk.indexSprites;
                  CombatInfo2.field2852 = var26;
                  CombatInfo2.field2842 = var27;
                  class41.field852 = "Loaded config";
                  class41.field851 = 60;
                  Client.field330 = 80;
               }
            } else if(Client.field330 != 80) {
               if(Client.field330 == 90) {
                  if(!class171.indexTextures.method3358()) {
                     class41.field852 = "Loading textures - " + class171.indexTextures.method3424() + "%";
                     class41.field851 = 90;
                  } else {
                     TextureProvider var31 = new TextureProvider(class171.indexTextures, FileOnDisk.indexSprites, 20, 0.8D, Client.field306?64:128);
                     class84.method1675(var31);
                     class84.method1680(0.8D);
                     class41.field852 = "Loaded textures";
                     class41.field851 = 90;
                     Client.field330 = 110;
                  }
               } else if(Client.field330 == 110) {
                  Client.field400 = new class20();
                  class108.field1755.method2004(Client.field400, 10);
                  class41.field852 = "Loaded input handler";
                  class41.field851 = 94;
                  Client.field330 = 120;
               } else if(Client.field330 == 120) {
                  if(!WallObject.field1581.method3354("huffman", "")) {
                     class41.field852 = "Loading wordpack - 0%";
                     class41.field851 = 96;
                  } else {
                     class145 var32 = new class145(WallObject.field1581.method3353("huffman", ""));
                     class210.field3133 = var32;
                     class41.field852 = "Loaded wordpack";
                     class41.field851 = 96;
                     Client.field330 = 130;
                  }
               } else if(Client.field330 == 130) {
                  if(!class37.indexInterfaces.method3358()) {
                     class41.field852 = "Loading interfaces - " + class37.indexInterfaces.method3424() * 4 / 5 + "%";
                     class41.field851 = 100;
                  } else if(!Projectile.indexScripts.method3358()) {
                     class41.field852 = "Loading interfaces - " + (Projectile.indexScripts.method3424() / 6 + 80) + "%";
                     class41.field851 = 100;
                  } else if(!field56.method3358()) {
                     class41.field852 = "Loading interfaces - " + (field56.method3424() / 20 + 96) + "%";
                     class41.field851 = 100;
                  } else {
                     class41.field852 = "Loaded interfaces";
                     class41.field851 = 100;
                     Client.field330 = 140;
                  }
               } else if(Client.field330 == 140) {
                  GameObject.setGameState(10);
               }
            } else {
               var0 = 0;
               SpritePixels var34;
               if(XGrandExchangeOffer.field39 == null) {
                  var6 = FileOnDisk.indexSprites;
                  var3 = var6.method3351("compass");
                  var4 = var6.method3352(var3, "");
                  var34 = class26.method564(var6, var3, var4);
                  XGrandExchangeOffer.field39 = var34;
               } else {
                  ++var0;
               }

               if(class180.field2718 == null) {
                  var6 = FileOnDisk.indexSprites;
                  var3 = var6.method3351("mapedge");
                  var4 = var6.method3352(var3, "");
                  var34 = class26.method564(var6, var3, var4);
                  class180.field2718 = var34;
               } else {
                  ++var0;
               }

               if(field47 == null) {
                  field47 = ItemComposition.method3719(FileOnDisk.indexSprites, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class15.field171 == null) {
                  class15.field171 = class99.method1981(FileOnDisk.indexSprites, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(class57.field1082 == null) {
                  class57.field1082 = class99.method1981(FileOnDisk.indexSprites, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(ScriptState.field108 == null) {
                  ScriptState.field108 = class99.method1981(FileOnDisk.indexSprites, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class15.field170 == null) {
                  class15.field170 = class99.method1981(FileOnDisk.indexSprites, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(PlayerComposition.field2194 == null) {
                  PlayerComposition.field2194 = class99.method1981(FileOnDisk.indexSprites, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(class33.field771 == null) {
                  class33.field771 = class99.method1981(FileOnDisk.indexSprites, "cross", "");
               } else {
                  ++var0;
               }

               if(MessageNode.field251 == null) {
                  MessageNode.field251 = class99.method1981(FileOnDisk.indexSprites, "mapdots", "");
               } else {
                  ++var0;
               }

               if(Tile.field1372 == null) {
                  Tile.field1372 = ItemComposition.method3719(FileOnDisk.indexSprites, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(Tile.field1373 == null) {
                  Tile.field1373 = ItemComposition.method3719(FileOnDisk.indexSprites, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class41.field852 = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class41.field851 = 70;
               } else {
                  FontTypeFace.modIcons = Tile.field1373;
                  class180.field2718.method4174();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var35 = 0; var35 < class15.field171.length; ++var35) {
                     class15.field171[var35].method4171(var1 + var4, var2 + var4, var4 + var3);
                  }

                  field47[0].method4090(var1 + var4, var4 + var2, var4 + var3);
                  class41.field852 = "Loaded sprites";
                  class41.field851 = 70;
                  Client.field330 = 90;
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-966557639"
   )
   int method67(class2 var1, class2 var2) {
      return var1.field19.price < var2.field19.price?-1:(var1.field19.price == var2.field19.price?0:1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIZS)LSpritePixels;",
      garbageValue = "468"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var1 << 16) + (long)var0 + ((long)var2 << 38);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class196.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class196.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(var21 == null) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.notedTemplate != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field2951 != -1) {
            var22 = createSprite(var9.field2963, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field3001 != -1) {
            var22 = createSprite(var9.field2958, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method4003(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method4057();
         class84.method1671();
         class84.method1674(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field3001 != -1) {
            var22.method4143(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = class84.field1475[var9.xan2d] * var16 >> 16;
         int var18 = var16 * class84.field1469[var9.xan2d] >> 16;
         var21.method1643();
         var21.method1599(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var9.offsetY2d + var21.modelHeight / 2 + var17, var18 + var9.offsetY2d);
         if(var9.field2951 != -1) {
            var22.method4143(0, 0);
         }

         if(var2 >= 1) {
            var8.method4222(1);
         }

         if(var2 >= 2) {
            var8.method4222(16777215);
         }

         if(var3 != 0) {
            var8.method4140(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.method4143(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = ItemComposition.field2993;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M</col>";
            }

            var19.method3930(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method4018(var15);
         class84.method1671();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)LBufferProvider;",
      garbageValue = "-1910989961"
   )
   public static BufferProvider method69(int var0, int var1, Component var2) {
      try {
         MainBufferProvider var3 = new MainBufferProvider();
         var3.init(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         SecondaryBufferProvider var4 = new SecondaryBufferProvider();
         var4.init(var0, var1, var2);
         return var4;
      }
   }
}
