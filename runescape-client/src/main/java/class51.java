import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class51 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -16564157
   )
   public int field1095 = 16777215;
   @ObfuscatedName("r")
   public static class170 field1096;
   @ObfuscatedName("z")
   public static NodeCache field1097 = new NodeCache(64);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -746295089
   )
   int field1098 = -1;
   @ObfuscatedName("i")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("b")
   public static NodeCache field1100 = new NodeCache(20);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1736594899
   )
   int field1103 = -1;
   @ObfuscatedName("j")
   public static class170 field1104;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1513015763
   )
   public int field1105 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -231224237
   )
   public int field1106 = 70;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 685930055
   )
   public int field1107 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1307279581
   )
   int field1108 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1187672937
   )
   int field1109 = -1;
   @ObfuscatedName("x")
   public static class170 field1110;
   @ObfuscatedName("bh")
   static class171 field1111;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 907688749
   )
   public int field1112 = -1;
   @ObfuscatedName("n")
   String field1113 = "";
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1861951499
   )
   int field1114 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 172952849
   )
   public int field1115 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1812246125
   )
   public int field1116 = 0;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "812875065"
   )
   public SpritePixels method1028() {
      if(this.field1108 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1108);
         if(null != var1) {
            return var1;
         } else {
            var1 = class43.method856(field1096, this.field1108, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1108);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "23"
   )
   void method1029(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1036(var1, var2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)LSpritePixels;",
      garbageValue = "-24470"
   )
   public SpritePixels method1033() {
      if(this.field1098 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1098);
         if(null != var1) {
            return var1;
         } else {
            var1 = class43.method856(field1096, this.field1098, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1098);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "14"
   )
   public SpritePixels method1035() {
      if(this.field1114 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1114);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class43.method856(field1096, this.field1114, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1114);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-79"
   )
   void method1036(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1103 = var1.method2571();
      } else if(var2 == 2) {
         this.field1095 = var1.method2560();
      } else if(var2 == 3) {
         this.field1114 = var1.method2571();
      } else if(var2 == 4) {
         this.field1098 = var1.method2571();
      } else if(var2 == 5) {
         this.field1108 = var1.method2571();
      } else if(var2 == 6) {
         this.field1109 = var1.method2571();
      } else if(var2 == 7) {
         this.field1105 = var1.method2759();
      } else if(var2 == 8) {
         this.field1113 = var1.method2635();
      } else if(var2 == 9) {
         this.field1106 = var1.method2551();
      } else if(var2 == 10) {
         this.field1116 = var1.method2759();
      } else if(var2 == 11) {
         this.field1112 = 0;
      } else if(var2 == 12) {
         this.field1107 = var1.method2556();
      } else if(var2 == 13) {
         this.field1115 = var1.method2759();
      } else if(var2 == 14) {
         this.field1112 = var1.method2551();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-950067413"
   )
   public SpritePixels method1045() {
      if(this.field1109 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1109);
         if(null != var1) {
            return var1;
         } else {
            var1 = class43.method856(field1096, this.field1109, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1109);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lclass227;",
      garbageValue = "-1231872554"
   )
   public class227 method1050() {
      if(this.field1103 == -1) {
         return null;
      } else {
         class227 var1 = (class227)field1100.get((long)this.field1103);
         if(null != var1) {
            return var1;
         } else {
            class170 var3 = field1096;
            class170 var4 = field1104;
            int var5 = this.field1103;
            class227 var2;
            if(!NPCComposition.method775(var3, var5, 0)) {
               var2 = null;
            } else {
               var2 = FrameMap.method2347(var4.method3290(var5, 0));
            }

            Object var10000 = null;
            return var2;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "72"
   )
   public String method1051(int var1) {
      String var2 = this.field1113;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class12.method147(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(III)Lclass110;",
      garbageValue = "1035456860"
   )
   static class110 method1054(int var0, int var1) {
      Client.field280.field1943 = var0;
      Client.field280.field1940 = var1;
      Client.field280.field1939 = 1;
      Client.field280.field1945 = 1;
      return Client.field280;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "49"
   )
   static void method1055() {
      int var0;
      if(Client.field308 == 0) {
         Projectile.region = new Region(4, 104, 104, class5.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class143.field2205 = new SpritePixels(512, 512);
         class33.field738 = "Starting game engine...";
         class33.field737 = 5;
         Client.field308 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var15;
         if(Client.field308 == 20) {
            int[] var25 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 32 * var1 + 128 + 15;
               var3 = 600 + var2 * 3;
               var15 = class94.field1639[var2];
               var25[var1] = var15 * var3 >> 16;
            }

            Region.method1983(var25, 500, 800, 512, 334);
            class33.field738 = "Prepared visibility map";
            class33.field737 = 10;
            Client.field308 = 30;
         } else if(Client.field308 == 30) {
            class153.field2300 = class47.method969(0, false, true, true);
            WallObject.field1585 = class47.method969(1, false, true, true);
            World.field644 = class47.method969(2, true, false, true);
            class35.field779 = class47.method969(3, false, true, true);
            field1111 = class47.method969(4, false, true, true);
            class140.field2165 = class47.method969(5, true, true, true);
            class192.field3108 = class47.method969(6, true, true, false);
            class114.field2017 = class47.method969(7, false, true, true);
            class109.field1922 = class47.method969(8, false, true, true);
            class54.field1145 = class47.method969(9, false, true, true);
            class33.field753 = class47.method969(10, false, true, true);
            class129.field2094 = class47.method969(11, false, true, true);
            class188.field3049 = class47.method969(12, false, true, true);
            Client.field311 = class47.method969(13, true, false, true);
            Friend.field255 = class47.method969(14, false, true, false);
            class22.field584 = class47.method969(15, false, true, true);
            class33.field738 = "Connecting to update server";
            class33.field737 = 20;
            Client.field308 = 40;
         } else if(Client.field308 == 40) {
            byte var21 = 0;
            var0 = var21 + class153.field2300.method3363() * 4 / 100;
            var0 += WallObject.field1585.method3363() * 4 / 100;
            var0 += World.field644.method3363() * 2 / 100;
            var0 += class35.field779.method3363() * 2 / 100;
            var0 += field1111.method3363() * 6 / 100;
            var0 += class140.field2165.method3363() * 4 / 100;
            var0 += class192.field3108.method3363() * 2 / 100;
            var0 += class114.field2017.method3363() * 60 / 100;
            var0 += class109.field1922.method3363() * 2 / 100;
            var0 += class54.field1145.method3363() * 2 / 100;
            var0 += class33.field753.method3363() * 2 / 100;
            var0 += class129.field2094.method3363() * 2 / 100;
            var0 += class188.field3049.method3363() * 2 / 100;
            var0 += Client.field311.method3363() * 2 / 100;
            var0 += Friend.field255.method3363() * 2 / 100;
            var0 += class22.field584.method3363() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class33.field738 = "Checking for updates - " + var0 + "%";
               }

               class33.field737 = 30;
            } else {
               class33.field738 = "Loaded update list";
               class33.field737 = 30;
               Client.field308 = 45;
            }
         } else if(Client.field308 == 45) {
            class24.method579(22050, !Client.field314, 2);
            class187 var24 = new class187();
            var24.method3625(9, 128);
            FaceNormal.field1492 = class32.method668(class127.field2086, class129.canvas, 0, 22050);
            FaceNormal.field1492.method1214(var24);
            Widget.method3467(class22.field584, Friend.field255, field1111, var24);
            class138.field2135 = class32.method668(class127.field2086, class129.canvas, 1, 2048);
            class14.field205 = new class58();
            class138.field2135.method1214(class14.field205);
            class143.field2215 = new class77(22050, class59.field1228);
            class33.field738 = "Prepared sound engine";
            class33.field737 = 35;
            Client.field308 = 50;
         } else {
            int var5;
            class227 var6;
            class171 var16;
            class171 var18;
            if(Client.field308 == 50) {
               var0 = 0;
               if(XItemContainer.field225 == null) {
                  var16 = class109.field1922;
                  var18 = Client.field311;
                  var15 = var16.method3359("p11_full");
                  var5 = var16.method3305(var15, "");
                  if(!NPCComposition.method775(var16, var15, var5)) {
                     var6 = null;
                  } else {
                     var6 = FrameMap.method2347(var18.method3290(var15, var5));
                  }

                  XItemContainer.field225 = var6;
               } else {
                  ++var0;
               }

               if(null == class158.field2347) {
                  var16 = class109.field1922;
                  var18 = Client.field311;
                  var15 = var16.method3359("p12_full");
                  var5 = var16.method3305(var15, "");
                  if(!NPCComposition.method775(var16, var15, var5)) {
                     var6 = null;
                  } else {
                     var6 = FrameMap.method2347(var18.method3290(var15, var5));
                  }

                  class158.field2347 = var6;
               } else {
                  ++var0;
               }

               if(null == VertexNormal.field1680) {
                  var16 = class109.field1922;
                  var18 = Client.field311;
                  var15 = var16.method3359("b12_full");
                  var5 = var16.method3305(var15, "");
                  if(!NPCComposition.method775(var16, var15, var5)) {
                     var6 = null;
                  } else {
                     var6 = FrameMap.method2347(var18.method3290(var15, var5));
                  }

                  VertexNormal.field1680 = var6;
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class33.field738 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class33.field737 = 40;
               } else {
                  class9.field151 = new class163(true);
                  class33.field738 = "Loaded fonts";
                  class33.field737 = 40;
                  Client.field308 = 60;
               }
            } else if(Client.field308 == 60) {
               var0 = class14.method164(class33.field753, class109.field1922);
               byte var19 = 9;
               if(var0 < var19) {
                  class33.field738 = "Loading title screen - " + var0 * 100 / var19 + "%";
                  class33.field737 = 50;
               } else {
                  class33.field738 = "Loaded title screen";
                  class33.field737 = 50;
                  class130.setGameState(5);
                  Client.field308 = 70;
               }
            } else if(Client.field308 == 70) {
               if(!World.field644.method3308()) {
                  class33.field738 = "Loading config - " + World.field644.method3371() + "%";
                  class33.field737 = 60;
               } else {
                  class43.method859(World.field644);
                  class171 var23 = World.field644;
                  class43.field982 = var23;
                  class18.method199(World.field644, class114.field2017);
                  class53.method1073(World.field644, class114.field2017, Client.field314);
                  class171 var17 = World.field644;
                  var16 = class114.field2017;
                  NPCComposition.field894 = var17;
                  NPCComposition.field885 = var16;
                  var18 = World.field644;
                  class171 var4 = class114.field2017;
                  boolean var20 = Client.isMembers;
                  var6 = XItemContainer.field225;
                  ItemComposition.field1198 = var18;
                  class11.field169 = var4;
                  ItemComposition.isMembersWorld = var20;
                  class54.field1142 = ItemComposition.field1198.method3299(10);
                  class28.field676 = var6;
                  class171 var7 = World.field644;
                  class171 var8 = class153.field2300;
                  class171 var9 = WallObject.field1585;
                  class181.field2967 = var7;
                  Sequence.field1003 = var8;
                  Sequence.field1008 = var9;
                  class75.method1605(World.field644, class114.field2017);
                  class125.method2831(World.field644);
                  class50.method1015(World.field644);
                  class136.method2910(class35.field779, class114.field2017, class109.field1922, Client.field311);
                  class171 var10 = World.field644;
                  class54.field1150 = var10;
                  class22.method557(World.field644);
                  class119.method2508(World.field644);
                  Tile.method2344(World.field644);
                  class8.chatMessages = new ChatMessages();
                  class171 var11 = World.field644;
                  class171 var12 = class109.field1922;
                  class171 var13 = Client.field311;
                  field1110 = var11;
                  field1096 = var12;
                  field1104 = var13;
                  MessageNode.method737(World.field644, class109.field1922);
                  class33.field738 = "Loaded config";
                  class33.field737 = 60;
                  Client.field308 = 80;
               }
            } else if(Client.field308 != 80) {
               if(Client.field308 == 90) {
                  if(!class54.field1145.method3308()) {
                     class33.field738 = "Loading textures - " + class54.field1145.method3371() + "%";
                     class33.field737 = 90;
                  } else {
                     TextureProvider var22 = new TextureProvider(class54.field1145, class109.field1922, 20, 0.8D, Client.field314?64:128);
                     class94.method2135(var22);
                     class94.method2136(0.8D);
                     class33.field738 = "Loaded textures";
                     class33.field737 = 90;
                     Client.field308 = 110;
                  }
               } else if(Client.field308 == 110) {
                  class85.field1475 = new class13();
                  class127.field2086.method2927(class85.field1475, 10);
                  class33.field738 = "Loaded input handler";
                  class33.field737 = 94;
                  Client.field308 = 120;
               } else if(Client.field308 == 120) {
                  if(!class33.field753.method3294("huffman", "")) {
                     class33.field738 = "Loading wordpack - " + 0 + "%";
                     class33.field737 = 96;
                  } else {
                     class116 var14 = new class116(class33.field753.method3296("huffman", ""));
                     class225.field3232 = var14;
                     class33.field738 = "Loaded wordpack";
                     class33.field737 = 96;
                     Client.field308 = 130;
                  }
               } else if(Client.field308 == 130) {
                  if(!class35.field779.method3308()) {
                     class33.field738 = "Loading interfaces - " + class35.field779.method3371() * 4 / 5 + "%";
                     class33.field737 = 100;
                  } else if(!class188.field3049.method3308()) {
                     class33.field738 = "Loading interfaces - " + (80 + class188.field3049.method3371() / 6) + "%";
                     class33.field737 = 100;
                  } else if(!Client.field311.method3308()) {
                     class33.field738 = "Loading interfaces - " + (96 + Client.field311.method3371() / 20) + "%";
                     class33.field737 = 100;
                  } else {
                     class33.field738 = "Loaded interfaces";
                     class33.field737 = 100;
                     Client.field308 = 140;
                  }
               } else if(Client.field308 == 140) {
                  class130.setGameState(10);
               }
            } else {
               var0 = 0;
               if(class8.field143 == null) {
                  class8.field143 = class24.method574(class109.field1922, "compass", "");
               } else {
                  ++var0;
               }

               if(null == class77.field1412) {
                  class77.field1412 = class24.method574(class109.field1922, "mapedge", "");
               } else {
                  ++var0;
               }

               if(null == ChatLineBuffer.field689) {
                  ChatLineBuffer.field689 = Sequence.method898(class109.field1922, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class8.field140 == null) {
                  class8.field140 = class10.method128(class109.field1922, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(class8.field135 == null) {
                  class8.field135 = class10.method128(class109.field1922, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(ChatLineBuffer.field686 == null) {
                  ChatLineBuffer.field686 = class10.method128(class109.field1922, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(null == class145.field2232) {
                  class145.field2232 = class10.method128(class109.field1922, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(null == ObjectComposition.field942) {
                  ObjectComposition.field942 = class10.method128(class109.field1922, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(null == XClanMember.field631) {
                  XClanMember.field631 = class10.method128(class109.field1922, "cross", "");
               } else {
                  ++var0;
               }

               if(Client.field450 == null) {
                  Client.field450 = class10.method128(class109.field1922, "mapdots", "");
               } else {
                  ++var0;
               }

               if(null == class152.field2292) {
                  class152.field2292 = Sequence.method898(class109.field1922, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(Client.field358 == null) {
                  Client.field358 = Sequence.method898(class109.field1922, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class33.field738 = "Loading sprites - " + 100 * var0 / 12 + "%";
                  class33.field737 = 70;
               } else {
                  class226.modIcons = Client.field358;
                  class77.field1412.method1796();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var15 = (int)(Math.random() * 41.0D) - 20;

                  for(var5 = 0; var5 < class8.field140.length; ++var5) {
                     class8.field140[var5].method1731(var1 + var15, var15 + var2, var15 + var3);
                  }

                  ChatLineBuffer.field689[0].method1900(var1 + var15, var2 + var15, var3 + var15);
                  class33.field738 = "Loaded sprites";
                  class33.field737 = 70;
                  Client.field308 = 90;
               }
            }
         }
      }
   }
}
