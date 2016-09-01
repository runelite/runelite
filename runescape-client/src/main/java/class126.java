import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ds")
public final class class126 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -706066757
   )
   int field2076;
   @ObfuscatedName("i")
   int[] field2077 = new int[256];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2085331739
   )
   int field2078;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1621667217
   )
   int field2079;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1286999565
   )
   int field2080;
   @ObfuscatedName("l")
   int[] field2083 = new int[256];

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   final int method2835() {
      if(--this.field2078 + 1 == 0) {
         this.method2837();
         this.field2078 = 255;
      }

      return this.field2077[this.field2078];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "21"
   )
   final void method2836() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2077[var1];
         var3 += this.field2077[var1 + 1];
         var4 += this.field2077[var1 + 2];
         var5 += this.field2077[3 + var1];
         var6 += this.field2077[var1 + 4];
         var7 += this.field2077[5 + var1];
         var8 += this.field2077[6 + var1];
         var9 += this.field2077[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2083[var1] = var2;
         this.field2083[1 + var1] = var3;
         this.field2083[2 + var1] = var4;
         this.field2083[3 + var1] = var5;
         this.field2083[4 + var1] = var6;
         this.field2083[var1 + 5] = var7;
         this.field2083[var1 + 6] = var8;
         this.field2083[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2083[var1];
         var3 += this.field2083[var1 + 1];
         var4 += this.field2083[var1 + 2];
         var5 += this.field2083[var1 + 3];
         var6 += this.field2083[4 + var1];
         var7 += this.field2083[5 + var1];
         var8 += this.field2083[6 + var1];
         var9 += this.field2083[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2083[var1] = var2;
         this.field2083[var1 + 1] = var3;
         this.field2083[var1 + 2] = var4;
         this.field2083[3 + var1] = var5;
         this.field2083[var1 + 4] = var6;
         this.field2083[var1 + 5] = var7;
         this.field2083[6 + var1] = var8;
         this.field2083[var1 + 7] = var9;
      }

      this.method2837();
      this.field2078 = 256;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "73"
   )
   final void method2837() {
      this.field2079 += ++this.field2080;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2083[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2076 ^= this.field2076 << 13;
            } else {
               this.field2076 ^= this.field2076 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2076 ^= this.field2076 << 2;
         } else {
            this.field2076 ^= this.field2076 >>> 16;
         }

         this.field2076 += this.field2083[var1 + 128 & 255];
         int var3;
         this.field2083[var1] = var3 = this.field2079 + this.field2083[(var2 & 1020) >> 2] + this.field2076;
         this.field2077[var1] = this.field2079 = var2 + this.field2083[(var3 >> 8 & 1020) >> 2];
      }

   }

   class126(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2077[var2] = var1[var2];
      }

      this.method2836();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method2842() {
      int[] var0 = class34.field755;

      int var1;
      for(var1 = 0; var1 < class34.field760; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(null != var2 && var2.field838 > 0) {
            --var2.field838;
            if(var2.field838 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field319; ++var1) {
         int var4 = Client.field320[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(null != var3 && var3.field838 > 0) {
            --var3.field838;
            if(var3.field838 == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1334200434"
   )
   static final void method2844() {
      try {
         if(Client.field522 == 0) {
            if(Item.field694 != null) {
               Item.field694.method3044();
               Item.field694 = null;
            }

            Frames.field1836 = null;
            Client.field348 = false;
            Client.field468 = 0;
            Client.field522 = 1;
         }

         if(Client.field522 == 1) {
            if(Frames.field1836 == null) {
               Frames.field1836 = class127.field2086.method2926(class59.host, Client.field317);
            }

            if(Frames.field1836.field2266 == 2) {
               throw new IOException();
            }

            if(Frames.field1836.field2266 == 1) {
               Item.field694 = new class146((Socket)Frames.field1836.field2270, class127.field2086);
               Frames.field1836 = null;
               Client.field522 = 2;
            }
         }

         if(Client.field522 == 2) {
            Client.field323.offset = 0;
            Client.field323.method2715(14);
            Item.field694.method3043(Client.field323.payload, 0, 1);
            Client.field446.offset = 0;
            Client.field522 = 3;
         }

         int var0;
         if(Client.field522 == 3) {
            if(null != FaceNormal.field1492) {
               FaceNormal.field1492.method1274();
            }

            if(class138.field2135 != null) {
               class138.field2135.method1274();
            }

            var0 = Item.field694.method3040();
            if(FaceNormal.field1492 != null) {
               FaceNormal.field1492.method1274();
            }

            if(null != class138.field2135) {
               class138.field2135.method1274();
            }

            if(var0 != 0) {
               class110.method2438(var0);
               return;
            }

            Client.field446.offset = 0;
            Client.field522 = 5;
         }

         int var1;
         int var2;
         if(Client.field522 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field323.offset = 0;
            Client.field323.method2715(1);
            Client.field323.method2715(class33.field746.vmethod3206());
            Client.field323.method2544(var7[0]);
            Client.field323.method2544(var7[1]);
            Client.field323.method2544(var7[2]);
            Client.field323.method2544(var7[3]);
            switch(class33.field746.field2664) {
            case 0:
            case 3:
               Client.field323.method2742(class159.field2362);
               Client.field323.offset += 5;
               break;
            case 1:
               Client.field323.offset += 8;
               break;
            case 2:
               Client.field323.method2544(((Integer)class161.field2659.field137.get(Integer.valueOf(XClanMember.method580(class33.username)))).intValue());
               Client.field323.offset += 4;
            }

            Client.field323.method2616(class33.field733);
            Client.field323.method2577(class4.field60, class4.field61);
            Client.field324.offset = 0;
            if(Client.gameState == 40) {
               Client.field324.method2715(18);
            } else {
               Client.field324.method2715(16);
            }

            Client.field324.method2542(0);
            var1 = Client.field324.offset;
            Client.field324.method2544(121);
            Client.field324.method2550(Client.field323.payload, 0, Client.field323.offset);
            var2 = Client.field324.offset;
            Client.field324.method2616(class33.username);
            Client.field324.method2715((Client.isResized?1:0) << 1 | (Client.field314?1:0));
            Client.field324.method2542(FaceNormal.field1499);
            Client.field324.method2542(class212.field3175);
            class125 var3 = Client.field324;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class152.field2286.method4159(0L);
               class152.field2286.method4161(var4);

               for(var5 = 0; var5 < 24 && var4[var5] == 0; ++var5) {
                  ;
               }

               if(var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var12) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.method2550(var4, 0, 24);
            Client.field324.method2616(class40.field878);
            Client.field324.method2544(class110.field1938);
            Buffer var17 = new Buffer(class9.field151.method3214());
            class9.field151.method3220(var17);
            Client.field324.method2550(var17.payload, 0, var17.payload.length);
            Client.field324.method2715(class48.field1067);
            Client.field324.method2544(class153.field2300.field2742);
            Client.field324.method2544(WallObject.field1585.field2742);
            Client.field324.method2544(World.field644.field2742);
            Client.field324.method2544(class35.field779.field2742);
            Client.field324.method2544(class51.field1111.field2742);
            Client.field324.method2544(class140.field2165.field2742);
            Client.field324.method2544(class192.field3108.field2742);
            Client.field324.method2544(class114.field2017.field2742);
            Client.field324.method2544(class109.field1922.field2742);
            Client.field324.method2544(class54.field1145.field2742);
            Client.field324.method2544(class33.field753.field2742);
            Client.field324.method2544(class129.field2094.field2742);
            Client.field324.method2544(class188.field3049.field2742);
            Client.field324.method2544(Client.field311.field2742);
            Client.field324.method2544(Friend.field255.field2742);
            Client.field324.method2544(class22.field584.field2742);
            Client.field324.method2559(var7, var2, Client.field324.offset);
            Client.field324.method2552(Client.field324.offset - var1);
            Item.field694.method3043(Client.field324.payload, 0, Client.field324.offset);
            Client.field323.method2817(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            Client.field446.method2817(var7);
            Client.field522 = 6;
         }

         if(Client.field522 == 6 && Item.field694.method3041() > 0) {
            var0 = Item.field694.method3040();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field522 = 7;
            } else if(var0 == 2) {
               Client.field522 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field326 = -1;
               Client.field522 = 13;
            } else if(var0 == 23 && Client.field401 < 1) {
               ++Client.field401;
               Client.field522 = 0;
            } else {
               if(var0 != 29) {
                  class110.method2438(var0);
                  return;
               }

               Client.field522 = 11;
            }
         }

         if(Client.field522 == 7 && Item.field694.method3041() > 0) {
            Client.field316 = (Item.field694.method3040() + 3) * 60;
            Client.field522 = 8;
         }

         if(Client.field522 == 8) {
            Client.field468 = 0;
            class20.method546("You have only just left another world.", "Your profile will be transferred in:", Client.field316 / 60 + " seconds.");
            if(--Client.field316 <= 0) {
               Client.field522 = 0;
            }

         } else {
            if(Client.field522 == 9 && Item.field694.method3041() >= 13) {
               boolean var14 = Item.field694.method3040() == 1;
               Item.field694.method3042(Client.field446.payload, 0, 4);
               Client.field446.offset = 0;
               boolean var15 = false;
               if(var14) {
                  var1 = Client.field446.method2819() << 24;
                  var1 |= Client.field446.method2819() << 16;
                  var1 |= Client.field446.method2819() << 8;
                  var1 |= Client.field446.method2819();
                  var2 = XClanMember.method580(class33.username);
                  if(class161.field2659.field137.size() >= 10 && !class161.field2659.field137.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = class161.field2659.field137.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  class161.field2659.field137.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class5.method80();
               }

               Client.field312 = Item.field694.method3040();
               Client.field448 = Item.field694.method3040() == 1;
               Client.localInteractingIndex = Item.field694.method3040();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += Item.field694.method3040();
               Client.field563 = Item.field694.method3040();
               Item.field694.method3042(Client.field446.payload, 0, 1);
               Client.field446.offset = 0;
               Client.packetOpcode = Client.field446.method2819();
               Item.field694.method3042(Client.field446.payload, 0, 2);
               Client.field446.offset = 0;
               Client.field326 = Client.field446.method2551();

               try {
                  Client var9 = Client.field377;
                  JSObject.getWindow(var9).call("zap", (Object[])null);
               } catch (Throwable var11) {
                  ;
               }

               Client.field522 = 10;
            }

            if(Client.field522 == 10) {
               if(Item.field694.method3041() >= Client.field326) {
                  Client.field446.offset = 0;
                  Item.field694.method3042(Client.field446.payload, 0, Client.field326);
                  Client.field291 = -1L;
                  Client.field294 = -1;
                  class85.field1475.field200 = 0;
                  class184.field2991 = true;
                  Client.field295 = true;
                  Client.field505 = -1L;
                  class214.field3187 = new class205();
                  Client.field323.offset = 0;
                  Client.field446.offset = 0;
                  Client.packetOpcode = -1;
                  Client.field330 = 1;
                  Client.field396 = -1;
                  Client.field332 = -1;
                  Client.field328 = 0;
                  Client.field297 = 0;
                  Client.field440 = 0;
                  Client.field525 = 0;
                  Client.menuOptionCount = 0;
                  Client.isMenuOpen = false;
                  class130.method2876(0);
                  class1.method12();
                  Client.field432 = 0;
                  Client.field404 = false;
                  Client.field521 = 0;
                  Client.field344 = (int)(Math.random() * 100.0D) - 50;
                  Client.field346 = (int)(Math.random() * 110.0D) - 55;
                  Client.field490 = (int)(Math.random() * 80.0D) - 40;
                  Client.mapScale = (int)(Math.random() * 120.0D) - 60;
                  Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field515 = 0;
                  Client.field435 = -1;
                  Client.flagX = 0;
                  Client.flagY = 0;
                  Client.field415 = class21.field577;
                  Client.field307 = class21.field577;
                  Client.field319 = 0;
                  class34.field760 = 0;

                  for(var0 = 0; var0 < 2048; ++var0) {
                     class34.field759[var0] = null;
                     class34.field758[var0] = 1;
                  }

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.cachedPlayers[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     Client.cachedNPCs[var0] = null;
                  }

                  Client.field411 = -1;
                  Client.projectiles.method3855();
                  Client.field357.method3855();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItemDeque[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.field413 = new Deque();
                  Client.field502 = 0;
                  Client.friendCount = 0;
                  Client.ignoreCount = 0;

                  for(var0 = 0; var0 < class22.field583; ++var0) {
                     class56 var22 = class35.method714(var0);
                     if(var22 != null) {
                        class179.settings[var0] = 0;
                        class179.widgetSettings[var0] = 0;
                     }
                  }

                  class8.chatMessages.method205();
                  Client.field447 = -1;
                  if(Client.widgetRoot != -1) {
                     class160.method3204(Client.widgetRoot);
                  }

                  for(WidgetNode var19 = (WidgetNode)Client.componentTable.method3821(); var19 != null; var19 = (WidgetNode)Client.componentTable.method3822()) {
                     class62.method1313(var19, true);
                  }

                  Client.widgetRoot = -1;
                  Client.componentTable = new XHashTable(8);
                  Client.field443 = null;
                  Client.isMenuOpen = false;
                  Client.menuOptionCount = 0;
                  Client.field553.method3514((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.field408[var0] = null;
                     Client.field409[var0] = false;
                  }

                  XItemContainer.itemContainers = new XHashTable(32);
                  Client.field289 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field484[var0] = true;
                  }

                  class221.method4001();
                  Client.field541 = null;
                  class1.field25 = 0;
                  class13.clanMembers = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
                  }

                  WidgetNode.field55 = null;
                  VertexNormal.method2251(Client.field446);
                  Tile.field1789 = -1;
                  class13.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field522 == 11 && Item.field694.method3041() >= 2) {
                  Client.field446.offset = 0;
                  Item.field694.method3042(Client.field446.payload, 0, 2);
                  Client.field446.offset = 0;
                  Tile.field1815 = Client.field446.method2551();
                  Client.field522 = 12;
               }

               if(Client.field522 == 12 && Item.field694.method3041() >= Tile.field1815) {
                  Client.field446.offset = 0;
                  Item.field694.method3042(Client.field446.payload, 0, Tile.field1815);
                  Client.field446.offset = 0;
                  String var18 = Client.field446.method2774();
                  String var10 = Client.field446.method2774();
                  String var20 = Client.field446.method2774();
                  class20.method546(var18, var10, var20);
                  class130.setGameState(10);
               }

               if(Client.field522 != 13) {
                  ++Client.field468;
                  if(Client.field468 > 2000) {
                     if(Client.field401 < 1) {
                        if(Client.field317 == NPCComposition.field920) {
                           Client.field317 = class14.field207;
                        } else {
                           Client.field317 = NPCComposition.field920;
                        }

                        ++Client.field401;
                        Client.field522 = 0;
                     } else {
                        class110.method2438(-3);
                     }
                  }
               } else {
                  if(Client.field326 == -1) {
                     if(Item.field694.method3041() < 2) {
                        return;
                     }

                     Item.field694.method3042(Client.field446.payload, 0, 2);
                     Client.field446.offset = 0;
                     Client.field326 = Client.field446.method2551();
                  }

                  if(Item.field694.method3041() >= Client.field326) {
                     Item.field694.method3042(Client.field446.payload, 0, Client.field326);
                     Client.field446.offset = 0;
                     var0 = Client.field326;
                     Client.field323.offset = 0;
                     Client.field446.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field330 = 1;
                     Client.field396 = -1;
                     Client.field332 = -1;
                     Client.field326 = 0;
                     Client.field328 = 0;
                     Client.field297 = 0;
                     Client.menuOptionCount = 0;
                     Client.isMenuOpen = false;
                     Client.field515 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     class48.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var21 = Client.cachedNPCs[var1];
                        if(var21 != null) {
                           var21.interacting = -1;
                           var21.field844 = false;
                        }
                     }

                     XItemContainer.itemContainers = new XHashTable(32);
                     class130.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field484[var1] = true;
                     }

                     class221.method4001();
                     VertexNormal.method2251(Client.field446);
                     if(var0 != Client.field446.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var13) {
         if(Client.field401 < 1) {
            if(NPCComposition.field920 == Client.field317) {
               Client.field317 = class14.field207;
            } else {
               Client.field317 = NPCComposition.field920;
            }

            ++Client.field401;
            Client.field522 = 0;
         } else {
            class110.method2438(-2);
         }
      }
   }
}
