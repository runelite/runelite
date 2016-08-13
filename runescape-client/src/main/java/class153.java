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
      if(Client.field323 == 0) {
         class136.region = new Region(4, 104, 104, class5.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class23.field619 = new SpritePixels(512, 512);
         class33.field758 = "Starting game engine...";
         class33.field757 = 5;
         Client.field323 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field323 == 20) {
            int[] var5 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 128 + 32 * var1 + 15;
               var3 = 600 + var2 * 3;
               var4 = class94.field1661[var2];
               var5[var1] = var4 * var3 >> 16;
            }

            Region.method2037(var5, 500, 800, 512, 334);
            class33.field758 = "Prepared visibility map";
            class33.field757 = 10;
            Client.field323 = 30;
         } else if(Client.field323 == 30) {
            class16.field240 = class48.method1033(0, false, true, true);
            class56.field1236 = class48.method1033(1, false, true, true);
            SecondaryBufferProvider.field1448 = class48.method1033(2, true, false, true);
            class164.field2699 = class48.method1033(3, false, true, true);
            class119.field2039 = class48.method1033(4, false, true, true);
            BufferProvider.field1476 = class48.method1033(5, true, true, true);
            class188.field3051 = class48.method1033(6, true, true, false);
            Ignore.field137 = class48.method1033(7, false, true, true);
            Client.field451 = class48.method1033(8, false, true, true);
            ObjectComposition.field964 = class48.method1033(9, false, true, true);
            XClanMember.field644 = class48.method1033(10, false, true, true);
            class0.field12 = class48.method1033(11, false, true, true);
            class20.field581 = class48.method1033(12, false, true, true);
            Tile.field1811 = class48.method1033(13, true, false, true);
            class10.field172 = class48.method1033(14, false, true, false);
            class138.field2139 = class48.method1033(15, false, true, true);
            class33.field758 = "Connecting to update server";
            class33.field757 = 20;
            Client.field323 = 40;
         } else if(Client.field323 == 40) {
            byte var21 = 0;
            var0 = var21 + class16.field240.method3494() * 4 / 100;
            var0 += class56.field1236.method3494() * 4 / 100;
            var0 += SecondaryBufferProvider.field1448.method3494() * 2 / 100;
            var0 += class164.field2699.method3494() * 2 / 100;
            var0 += class119.field2039.method3494() * 6 / 100;
            var0 += BufferProvider.field1476.method3494() * 4 / 100;
            var0 += class188.field3051.method3494() * 2 / 100;
            var0 += Ignore.field137.method3494() * 60 / 100;
            var0 += Client.field451.method3494() * 2 / 100;
            var0 += ObjectComposition.field964.method3494() * 2 / 100;
            var0 += XClanMember.field644.method3494() * 2 / 100;
            var0 += class0.field12.method3494() * 2 / 100;
            var0 += class20.field581.method3494() * 2 / 100;
            var0 += Tile.field1811.method3494() * 2 / 100;
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
               Client.field323 = 45;
            }
         } else {
            class171 var6;
            class171 var7;
            class171 var22;
            if(Client.field323 == 45) {
               boolean var8 = !Client.field301;
               class59.field1254 = 22050;
               class59.field1264 = var8;
               class59.field1245 = 2;
               class187 var9 = new class187();
               var9.method3757(9, 128);
               Projectile.field127 = class10.method141(class125.field2070, class107.canvas, 0, 22050);
               Projectile.field127.method1317(var9);
               var6 = class138.field2139;
               var7 = class10.field172;
               var22 = class119.field2039;
               class145.field2235 = var6;
               class186.field3012 = var7;
               class159.field2369 = var22;
               class59.field1266 = var9;
               class125.field2069 = class10.method141(class125.field2070, class107.canvas, 1, 2048);
               class20.field585 = new class58();
               class125.field2069.method1317(class20.field585);
               class79.field1463 = new class77(22050, class59.field1254);
               class33.field758 = "Prepared sound engine";
               class33.field757 = 35;
               Client.field323 = 50;
            } else if(Client.field323 == 50) {
               var0 = 0;
               if(null == Ignore.field133) {
                  Ignore.field133 = class23.method596(Client.field451, Tile.field1811, "p11_full", "");
               } else {
                  ++var0;
               }

               if(class8.field144 == null) {
                  class8.field144 = class23.method596(Client.field451, Tile.field1811, "p12_full", "");
               } else {
                  ++var0;
               }

               if(null == class59.field1268) {
                  class59.field1268 = class23.method596(Client.field451, Tile.field1811, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class33.field758 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class33.field757 = 40;
               } else {
                  WidgetNode.field69 = new class163(true);
                  class33.field758 = "Loaded fonts";
                  class33.field757 = 40;
                  Client.field323 = 60;
               }
            } else if(Client.field323 == 60) {
               var0 = class221.method4133(XClanMember.field644, Client.field451);
               var1 = class77.method1708();
               if(var0 < var1) {
                  class33.field758 = "Loading title screen - " + var0 * 100 / var1 + "%";
                  class33.field757 = 50;
               } else {
                  class33.field758 = "Loaded title screen";
                  class33.field757 = 50;
                  class138.setGameState(5);
                  Client.field323 = 70;
               }
            } else if(Client.field323 == 70) {
               if(!SecondaryBufferProvider.field1448.method3430()) {
                  class33.field758 = "Loading config - " + SecondaryBufferProvider.field1448.method3492() + "%";
                  class33.field757 = 60;
               } else {
                  class171 var23 = SecondaryBufferProvider.field1448;
                  class48.field1086 = var23;
                  class171 var26 = SecondaryBufferProvider.field1448;
                  class43.field1007 = var26;
                  var6 = SecondaryBufferProvider.field1448;
                  var7 = Ignore.field137;
                  KitDefinition.field1055 = var6;
                  RSCanvas.field2197 = var7;
                  KitDefinition.field1054 = KitDefinition.field1055.method3405(3);
                  var22 = SecondaryBufferProvider.field1448;
                  class171 var10 = Ignore.field137;
                  boolean var11 = Client.field301;
                  ObjectComposition.field945 = var22;
                  ObjectComposition.field995 = var10;
                  ObjectComposition.field958 = var11;
                  class171 var12 = SecondaryBufferProvider.field1448;
                  class171 var13 = Ignore.field137;
                  NPCComposition.field921 = var12;
                  NPCComposition.field908 = var13;
                  class8.method123(SecondaryBufferProvider.field1448, Ignore.field137, Client.isMembers, Ignore.field133);
                  class171 var14 = SecondaryBufferProvider.field1448;
                  class171 var15 = class16.field240;
                  class171 var16 = class56.field1236;
                  Sequence.field1013 = var14;
                  Sequence.field1012 = var15;
                  Sequence.field1019 = var16;
                  Actor.method801(SecondaryBufferProvider.field1448, Ignore.field137);
                  ObjectComposition.method876(SecondaryBufferProvider.field1448);
                  Friend.method207(SecondaryBufferProvider.field1448);
                  class92.method2160(class164.field2699, Ignore.field137, Client.field451, Tile.field1811);
                  class40.method810(SecondaryBufferProvider.field1448);
                  class137.method3017(SecondaryBufferProvider.field1448);
                  class171 var17 = SecondaryBufferProvider.field1448;
                  class47.field1076 = var17;
                  Sequence.method918(SecondaryBufferProvider.field1448);
                  Actor.chatMessages = new ChatMessages();
                  class171 var18 = SecondaryBufferProvider.field1448;
                  class171 var19 = Client.field451;
                  class171 var20 = Tile.field1811;
                  class51.field1134 = var18;
                  class51.field1127 = var19;
                  class225.field3226 = var20;
                  class20.method570(SecondaryBufferProvider.field1448, Client.field451);
                  class33.field758 = "Loaded config";
                  class33.field757 = 60;
                  Client.field323 = 80;
               }
            } else if(Client.field323 != 80) {
               if(Client.field323 == 90) {
                  if(!ObjectComposition.field964.method3430()) {
                     class33.field758 = "Loading textures - " + ObjectComposition.field964.method3492() + "%";
                     class33.field757 = 90;
                  } else {
                     TextureProvider var24 = new TextureProvider(ObjectComposition.field964, Client.field451, 20, 0.8D, Client.field301?64:128);
                     class94.method2221(var24);
                     class94.method2225(0.8D);
                     class33.field758 = "Loaded textures";
                     class33.field757 = 90;
                     Client.field323 = 110;
                  }
               } else if(Client.field323 == 110) {
                  WidgetNode.field68 = new class13();
                  class125.field2070.method3029(WidgetNode.field68, 10);
                  class33.field758 = "Loaded input handler";
                  class33.field757 = 94;
                  Client.field323 = 120;
               } else if(Client.field323 == 120) {
                  if(!XClanMember.field644.method3413("huffman", "")) {
                     class33.field758 = "Loading wordpack - 0%";
                     class33.field757 = 96;
                  } else {
                     class116 var25 = new class116(XClanMember.field644.method3412("huffman", ""));
                     class225.field3227 = var25;
                     class33.field758 = "Loaded wordpack";
                     class33.field757 = 96;
                     Client.field323 = 130;
                  }
               } else if(Client.field323 == 130) {
                  if(!class164.field2699.method3430()) {
                     class33.field758 = "Loading interfaces - " + class164.field2699.method3492() * 4 / 5 + "%";
                     class33.field757 = 100;
                  } else if(!class20.field581.method3430()) {
                     class33.field758 = "Loading interfaces - " + (80 + class20.field581.method3492() / 6) + "%";
                     class33.field757 = 100;
                  } else if(!Tile.field1811.method3430()) {
                     class33.field758 = "Loading interfaces - " + (96 + Tile.field1811.method3492() / 20) + "%";
                     class33.field757 = 100;
                  } else {
                     class33.field758 = "Loaded interfaces";
                     class33.field757 = 100;
                     Client.field323 = 140;
                  }
               } else if(Client.field323 == 140) {
                  class138.setGameState(10);
               }
            } else {
               var0 = 0;
               if(class171.field2754 == null) {
                  class171.field2754 = class4.method47(Client.field451, "compass", "");
               } else {
                  ++var0;
               }

               if(class32.field735 == null) {
                  class32.field735 = class4.method47(Client.field451, "mapedge", "");
               } else {
                  ++var0;
               }

               if(null == WallObject.field1611) {
                  WallObject.field1611 = NPC.method773(Client.field451, "mapscene", "");
               } else {
                  ++var0;
               }

               if(null == class50.field1121) {
                  class50.field1121 = class54.method1167(Client.field451, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(null == Player.field57) {
                  Player.field57 = class54.method1167(Client.field451, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(null == class125.field2066) {
                  class125.field2066 = class54.method1167(Client.field451, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class158.field2353 == null) {
                  class158.field2353 = class54.method1167(Client.field451, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(Client.field463 == null) {
                  Client.field463 = class54.method1167(Client.field451, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(null == class130.field2101) {
                  class130.field2101 = class54.method1167(Client.field451, "cross", "");
               } else {
                  ++var0;
               }

               if(null == ChatMessages.field283) {
                  ChatMessages.field283 = class54.method1167(Client.field451, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class110.field1947 == null) {
                  class110.field1947 = NPC.method773(Client.field451, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(null == Client.field372) {
                  Client.field372 = NPC.method773(Client.field451, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class33.field758 = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class33.field757 = 70;
               } else {
                  class226.modIcons = Client.field372;
                  class32.field735.method1798();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var27 = 0; var27 < class50.field1121.length; ++var27) {
                     class50.field1121[var27].method1838(var4 + var1, var4 + var2, var3 + var4);
                  }

                  WallObject.field1611[0].method1960(var1 + var4, var2 + var4, var4 + var3);
                  class33.field758 = "Loaded sprites";
                  class33.field757 = 70;
                  Client.field323 = 90;
               }
            }
         }
      }

   }
}
