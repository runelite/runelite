import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public final class class5 {
   @ObfuscatedName("ka")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("h")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1619278201
   )
   static int field86 = 99;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -802875025
   )
   static int field87 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("n")
   static byte[][][] field88;
   @ObfuscatedName("u")
   static byte[][][] field89;
   @ObfuscatedName("d")
   static byte[][][] field90;
   @ObfuscatedName("m")
   static int[][] field91;
   @ObfuscatedName("j")
   static int[] field92;
   @ObfuscatedName("s")
   static int[] field93;
   @ObfuscatedName("p")
   static int[] field94;
   @ObfuscatedName("i")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -808200803
   )
   static int field96;
   @ObfuscatedName("z")
   static final int[] field97 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("q")
   static final int[] field98 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("o")
   static final int[] field99 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("f")
   static final int[] field100 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("b")
   static final int[] field101 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("g")
   static byte[][][] field102;
   @ObfuscatedName("bq")
   static class171 field104;
   @ObfuscatedName("k")
   static final int[] field105 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2102715107
   )
   static int field106 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("r")
   static int[][][] field107;

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "792652805"
   )
   static final void method70() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var29;
      if(Client.packetOpcode == 180) {
         var0 = Client.field347.method2544();
         var1 = (var0 >> 4 & 7) + ItemComposition.field1214;
         var2 = Tile.field1797 + (var0 & 7);
         var3 = var1 + Client.field347.method2545();
         var4 = var2 + Client.field347.method2545();
         var29 = Client.field347.method2547();
         var6 = Client.field347.method2546();
         var7 = Client.field347.method2544() * 4;
         var8 = Client.field347.method2544() * 4;
         var9 = Client.field347.method2546();
         var10 = Client.field347.method2546();
         var11 = Client.field347.method2544();
         var12 = Client.field347.method2544();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
            var1 = 64 + var1 * 128;
            var2 = 64 + var2 * 128;
            var3 = var3 * 128 + 64;
            var4 = 128 * var4 + 64;
            Projectile var13 = new Projectile(var6, class173.plane, var1, var2, class16.method191(var1, var2, class173.plane) - var7, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var29, var8);
            var13.method97(var3, var4, class16.method191(var3, var4, class173.plane) - var8, Client.gameCycle + var9);
            Client.projectiles.method3865(var13);
         }

      } else if(Client.packetOpcode == 252) {
         var0 = Client.field347.method2544();
         var1 = ItemComposition.field1214 + (var0 >> 4 & 7);
         var2 = (var0 & 7) + Tile.field1797;
         var3 = Client.field347.method2546();
         var4 = Client.field347.method2544();
         var29 = Client.field347.method2546();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            var1 = var1 * 128 + 64;
            var2 = 64 + 128 * var2;
            class31 var40 = new class31(var3, class173.plane, var1, var2, class16.method191(var1, var2, class173.plane) - var4, var29, Client.gameCycle);
            Client.field436.method3865(var40);
         }

      } else if(Client.packetOpcode == 243) {
         var0 = Client.field347.method2571();
         var1 = var0 >> 2;
         var2 = var0 & 3;
         var3 = Client.field365[var1];
         var4 = Client.field347.method2620();
         var29 = (var4 >> 4 & 7) + ItemComposition.field1214;
         var6 = Tile.field1797 + (var4 & 7);
         if(var29 >= 0 && var6 >= 0 && var29 < 104 && var6 < 104) {
            class4.method53(class173.plane, var29, var6, var3, -1, var1, var2, 0, -1);
         }

      } else {
         Item var5;
         if(Client.packetOpcode == 122) {
            var0 = Client.field347.method2571();
            var1 = ItemComposition.field1214 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + Tile.field1797;
            var3 = Client.field347.method2572();
            var4 = Client.field347.method2528();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var5 = new Item();
               var5.id = var4;
               var5.quantity = var3;
               if(null == Client.groundItemDeque[class173.plane][var1][var2]) {
                  Client.groundItemDeque[class173.plane][var1][var2] = new Deque();
               }

               Client.groundItemDeque[class173.plane][var1][var2].method3865(var5);
               class174.groundItemSpawned(var1, var2);
            }

         } else {
            if(Client.packetOpcode == 223) {
               var0 = Client.field347.method2544();
               var1 = (var0 >> 4 & 7) + ItemComposition.field1214;
               var2 = Tile.field1797 + (var0 & 7);
               var3 = Client.field347.method2546();
               var4 = Client.field347.method2544();
               var29 = var4 >> 4 & 15;
               var6 = var4 & 7;
               var7 = Client.field347.method2544();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var8 = var29 + 1;
                  if(class138.localPlayer.pathX[0] >= var1 - var8 && class138.localPlayer.pathX[0] <= var8 + var1 && class138.localPlayer.pathY[0] >= var2 - var8 && class138.localPlayer.pathY[0] <= var8 + var2 && Client.field408 != 0 && var6 > 0 && Client.field542 < 50) {
                     Client.field543[Client.field542] = var3;
                     Client.field544[Client.field542] = var6;
                     Client.field545[Client.field542] = var7;
                     Client.field554[Client.field542] = null;
                     Client.field546[Client.field542] = (var1 << 16) + (var2 << 8) + var29;
                     ++Client.field542;
                  }
               }
            }

            if(Client.packetOpcode == 40) {
               var0 = Client.field347.method2544();
               var1 = (var0 >> 4 & 7) + ItemComposition.field1214;
               var2 = (var0 & 7) + Tile.field1797;
               var3 = Client.field347.method2546();
               var4 = Client.field347.method2546();
               var29 = Client.field347.method2546();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  Deque var32 = Client.groundItemDeque[class173.plane][var1][var2];
                  if(null != var32) {
                     for(Item var33 = (Item)var32.method3845(); null != var33; var33 = (Item)var32.method3847()) {
                        if(var33.id == (var3 & 32767) && var4 == var33.quantity) {
                           var33.quantity = var29;
                           break;
                        }
                     }

                     class174.groundItemSpawned(var1, var2);
                  }
               }

            } else if(Client.packetOpcode == 61) {
               var0 = Client.field347.method2725();
               var1 = Client.field347.method2620();
               var2 = var1 >> 2;
               var3 = var1 & 3;
               var4 = Client.field365[var2];
               var29 = Client.field347.method2544();
               var6 = ItemComposition.field1214 + (var29 >> 4 & 7);
               var7 = (var29 & 7) + Tile.field1797;
               if(var6 >= 0 && var7 >= 0 && var6 < 103 && var7 < 103) {
                  if(var4 == 0) {
                     WallObject var31 = class128.region.method2066(class173.plane, var6, var7);
                     if(null != var31) {
                        var9 = var31.hash >> 14 & 32767;
                        if(var2 == 2) {
                           var31.renderable1 = new class12(var9, 2, 4 + var3, class173.plane, var6, var7, var0, false, var31.renderable1);
                           var31.renderable2 = new class12(var9, 2, 1 + var3 & 3, class173.plane, var6, var7, var0, false, var31.renderable2);
                        } else {
                           var31.renderable1 = new class12(var9, var2, var3, class173.plane, var6, var7, var0, false, var31.renderable1);
                        }
                     }
                  }

                  if(var4 == 1) {
                     DecorativeObject var37 = class128.region.method2018(class173.plane, var6, var7);
                     if(null != var37) {
                        var9 = var37.hash >> 14 & 32767;
                        if(var2 != 4 && var2 != 5) {
                           if(var2 == 6) {
                              var37.renderable1 = new class12(var9, 4, 4 + var3, class173.plane, var6, var7, var0, false, var37.renderable1);
                           } else if(var2 == 7) {
                              var37.renderable1 = new class12(var9, 4, (2 + var3 & 3) + 4, class173.plane, var6, var7, var0, false, var37.renderable1);
                           } else if(var2 == 8) {
                              var37.renderable1 = new class12(var9, 4, var3 + 4, class173.plane, var6, var7, var0, false, var37.renderable1);
                              var37.renderable2 = new class12(var9, 4, (2 + var3 & 3) + 4, class173.plane, var6, var7, var0, false, var37.renderable2);
                           }
                        } else {
                           var37.renderable1 = new class12(var9, 4, var3, class173.plane, var6, var7, var0, false, var37.renderable1);
                        }
                     }
                  }

                  if(var4 == 2) {
                     GameObject var38 = class128.region.method1976(class173.plane, var6, var7);
                     if(var2 == 11) {
                        var2 = 10;
                     }

                     if(null != var38) {
                        var38.renderable = new class12(var38.hash >> 14 & 32767, var2, var3, class173.plane, var6, var7, var0, false, var38.renderable);
                     }
                  }

                  if(var4 == 3) {
                     GroundObject var39 = class128.region.method2071(class173.plane, var6, var7);
                     if(var39 != null) {
                        var39.renderable = new class12(var39.hash >> 14 & 32767, 22, var3, class173.plane, var6, var7, var0, false, var39.renderable);
                     }
                  }
               }

            } else if(Client.packetOpcode == 28) {
               var0 = Client.field347.method2620();
               var1 = (var0 >> 4 & 7) + ItemComposition.field1214;
               var2 = Tile.field1797 + (var0 & 7);
               var3 = Client.field347.method2546();
               var4 = Client.field347.method2620();
               var29 = var4 >> 2;
               var6 = var4 & 3;
               var7 = Client.field365[var29];
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class4.method53(class173.plane, var1, var2, var7, var3, var29, var6, 0, -1);
               }

            } else {
               if(Client.packetOpcode == 217) {
                  byte var35 = Client.field347.method2739();
                  byte var36 = Client.field347.method2574();
                  var2 = Client.field347.method2572();
                  var3 = Client.field347.method2620();
                  var4 = (var3 >> 4 & 7) + ItemComposition.field1214;
                  var29 = Tile.field1797 + (var3 & 7);
                  var6 = Client.field347.method2653();
                  var7 = var6 >> 2;
                  var8 = var6 & 3;
                  var9 = Client.field365[var7];
                  var10 = Client.field347.method2546();
                  var11 = Client.field347.method2725();
                  var12 = Client.field347.method2528();
                  byte var30 = Client.field347.method2739();
                  byte var14 = Client.field347.method2739();
                  Player var15;
                  if(Client.localInteractingIndex == var12) {
                     var15 = class138.localPlayer;
                  } else {
                     var15 = Client.cachedPlayers[var12];
                  }

                  if(var15 != null) {
                     ObjectComposition var16 = class9.getObjectDefinition(var2);
                     int var17;
                     int var18;
                     if(var8 != 1 && var8 != 3) {
                        var17 = var16.field959;
                        var18 = var16.field960;
                     } else {
                        var17 = var16.field960;
                        var18 = var16.field959;
                     }

                     int var19 = var4 + (var17 >> 1);
                     int var20 = (1 + var17 >> 1) + var4;
                     int var21 = var29 + (var18 >> 1);
                     int var22 = var29 + (var18 + 1 >> 1);
                     int[][] var23 = tileHeights[class173.plane];
                     int var24 = var23[var19][var22] + var23[var19][var21] + var23[var20][var21] + var23[var20][var22] >> 2;
                     int var25 = (var4 << 7) + (var17 << 6);
                     int var26 = (var18 << 6) + (var29 << 7);
                     Model var27 = var16.method845(var7, var8, var23, var25, var24, var26);
                     if(null != var27) {
                        class4.method53(class173.plane, var4, var29, var9, -1, 0, 0, 1 + var10, 1 + var11);
                        var15.totalLevel = var10 + Client.gameCycle;
                        var15.field41 = var11 + Client.gameCycle;
                        var15.model = var27;
                        var15.field59 = var4 * 128 + 64 * var17;
                        var15.field51 = var18 * 64 + 128 * var29;
                        var15.field44 = var24;
                        byte var28;
                        if(var36 > var30) {
                           var28 = var36;
                           var36 = var30;
                           var30 = var28;
                        }

                        if(var14 > var35) {
                           var28 = var14;
                           var14 = var35;
                           var35 = var28;
                        }

                        var15.field46 = var36 + var4;
                        var15.field57 = var30 + var4;
                        var15.field47 = var29 + var14;
                        var15.field49 = var29 + var35;
                     }
                  }
               }

               if(Client.packetOpcode == 12) {
                  var0 = Client.field347.method2653();
                  var1 = ItemComposition.field1214 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + Tile.field1797;
                  var3 = Client.field347.method2725();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var34 = Client.groundItemDeque[class173.plane][var1][var2];
                     if(null != var34) {
                        for(var5 = (Item)var34.method3845(); var5 != null; var5 = (Item)var34.method3847()) {
                           if(var5.id == (var3 & 32767)) {
                              var5.unlink();
                              break;
                           }
                        }

                        if(var34.method3845() == null) {
                           Client.groundItemDeque[class173.plane][var1][var2] = null;
                        }

                        class174.groundItemSpawned(var1, var2);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-666585563"
   )
   static final void method86() {
      boolean var0 = false;

      int var1;
      int var4;
      while(!var0) {
         var0 = true;

         for(var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[1 + var1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[1 + var1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[1 + var1];
               Client.menuTypes[1 + var1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[1 + var1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[1 + var1] = var4;
               var0 = false;
            }
         }
      }

      if(FrameMap.field1821 == null) {
         if(Client.field473 == null) {
            int var12 = class143.field2210;
            int var10;
            int var11;
            if(Client.isMenuOpen) {
               if(var12 != 1 && (class4.field81 || var12 != 4)) {
                  var1 = class143.field2204;
                  var11 = class143.field2206;
                  if(var1 < class146.menuX - 10 || var1 > ChatLineBuffer.menuWidth + class146.menuX + 10 || var11 < class130.menuY - 10 || var11 > class130.menuY + class194.menuHeight + 10) {
                     Client.isMenuOpen = false;
                     class144.method3021(class146.menuX, class130.menuY, ChatLineBuffer.menuWidth, class194.menuHeight);
                  }
               }

               if(var12 == 1 || !class4.field81 && var12 == 4) {
                  var1 = class146.menuX;
                  var11 = class130.menuY;
                  var10 = ChatLineBuffer.menuWidth;
                  var4 = class143.field2211;
                  int var5 = class143.field2212;
                  int var6 = -1;

                  for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
                     int var8 = var11 + 31 + 15 * (Client.menuOptionCount - 1 - var7);
                     if(var4 > var1 && var4 < var1 + var10 && var5 > var8 - 13 && var5 < var8 + 3) {
                        var6 = var7;
                     }
                  }

                  if(var6 != -1) {
                     class85.method1925(var6);
                  }

                  Client.isMenuOpen = false;
                  class144.method3021(class146.menuX, class130.menuY, ChatLineBuffer.menuWidth, class194.menuHeight);
               }
            } else {
               if((var12 == 1 || !class4.field81 && var12 == 4) && Client.menuOptionCount > 0) {
                  var1 = Client.menuTypes[Client.menuOptionCount - 1];
                  if(var1 == 39 || var1 == 40 || var1 == 41 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || var1 == 35 || var1 == 36 || var1 == 37 || var1 == 38 || var1 == 1005) {
                     var11 = Client.menuActionParams0[Client.menuOptionCount - 1];
                     var10 = Client.menuActionParams1[Client.menuOptionCount - 1];
                     Widget var9 = class173.method3412(var10);
                     if(class136.method2884(Projectile.method96(var9)) || class132.method2857(Projectile.method96(var9))) {
                        if(FrameMap.field1821 != null && !Client.field556 && Client.field440 != 1 && !TextureProvider.method2237(Client.menuOptionCount - 1) && Client.menuOptionCount > 0) {
                           Frames.method2327(Client.field417, Client.field392);
                        }

                        Client.field556 = false;
                        Client.field423 = 0;
                        if(FrameMap.field1821 != null) {
                           class32.method673(FrameMap.field1821);
                        }

                        FrameMap.field1821 = class173.method3412(var10);
                        Client.field416 = var11;
                        Client.field417 = class143.field2211;
                        Client.field392 = class143.field2212;
                        if(Client.menuOptionCount > 0) {
                           class28.method633(Client.menuOptionCount - 1);
                        }

                        class32.method673(FrameMap.field1821);
                        return;
                     }
                  }
               }

               if((var12 == 1 || !class4.field81 && var12 == 4) && (Client.field440 == 1 && Client.menuOptionCount > 2 || TextureProvider.method2237(Client.menuOptionCount - 1))) {
                  var12 = 2;
               }

               if((var12 == 1 || !class4.field81 && var12 == 4) && Client.menuOptionCount > 0) {
                  class85.method1925(Client.menuOptionCount - 1);
               }

               if(var12 == 2 && Client.menuOptionCount > 0) {
                  ChatMessages.method235(class143.field2211, class143.field2212);
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-504644240"
   )
   static void method87() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   static void method88(String var0, String var1, String var2) {
      class33.loginMessage1 = var0;
      class33.loginMessage2 = var1;
      class33.loginMessage3 = var2;
   }
}
