import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field742;
   @ObfuscatedName("a")
   @Export("name")
   String name;
   @ObfuscatedName("w")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -681673857
   )
   @Export("world")
   int world;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1196101617
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("u")
   boolean field748;
   @ObfuscatedName("z")
   boolean field747;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "760952420"
   )
   public static int method1037(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "13366209"
   )
   static int method1034(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class82.intStack[--class82.intStackSize];
         var4 = VertexNormal.getWidget(var3);
      } else {
         var4 = var2?class139.field2008:AttackOption.field1306;
      }

      if(var0 == 1000) {
         class82.intStackSize -= 4;
         var4.originalX = class82.intStack[class82.intStackSize];
         var4.originalY = class82.intStack[class82.intStackSize + 1];
         var4.field2764 = class82.intStack[class82.intStackSize + 2];
         var4.field2838 = class82.intStack[class82.intStackSize + 3];
         class33.method344(var4);
         TotalQuantityComparator.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            GrandExchangeOffer.method102(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class82.intStackSize -= 4;
         var4.originalWidth = class82.intStack[class82.intStackSize];
         var4.field2817 = class82.intStack[class82.intStackSize + 1];
         var4.field2766 = class82.intStack[class82.intStackSize + 2];
         var4.buttonType = class82.intStack[class82.intStackSize + 3];
         class33.method344(var4);
         TotalQuantityComparator.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            GrandExchangeOffer.method102(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class82.intStack[--class82.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class33.method344(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class82.intStack[--class82.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2888 = class82.intStack[--class82.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ILhc;ZB)V",
      garbageValue = "-68"
   )
   static void method1036(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class86.method1655().method5365(var0);
      int var4 = UrlRequest.localPlayer.field821;
      int var5 = (UrlRequest.localPlayer.x >> 7) + class46.baseX;
      int var6 = (UrlRequest.localPlayer.y >> 7) + Client.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class86.method1655().method5355(var3, var7, var1, var2);
   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            TotalQuantityComparator.clientInstance.method836();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field1013 = 0;
            Client.field1004 = 0;
            Client.field892.method5033(var0);
            if(var0 != 20) {
               class150.method2932(false);
            }
         }

         if(var0 != 20 && var0 != 40 && MouseInput.field685 != null) {
            MouseInput.field685.vmethod3081();
            MouseInput.field685 = null;
         }

         if(Client.gameState == 25) {
            Client.field899 = 0;
            Client.field895 = 0;
            Client.field896 = 1;
            Client.field897 = 0;
            Client.field898 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class5.method14(class36.indexCache10, class43.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class5.method14(class36.indexCache10, class43.indexSprites, false, 4);
            } else {
               ChatLineBuffer.method1851();
            }
         } else {
            class5.method14(class36.indexCache10, class43.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(Lfa;I)V",
      garbageValue = "1500368903"
   )
   static final void method1035(class173 var0) {
      PacketBuffer var1 = Client.field888.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(class173.field2430 == var0) {
         var2 = var1.method3297();
         var3 = var1.readUnsignedShortOb1();
         var4 = var1.readUnsignedByteNegate();
         var5 = (var4 >> 4 & 7) + class46.field558;
         var6 = (var4 & 7) + class35.field467;
         var7 = var1.readUnsignedShort();
         if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
            Deque var37 = Client.groundItemDeque[BoundingBox2D.plane][var5][var6];
            if(var37 != null) {
               for(Item var9 = (Item)var37.getFront(); var9 != null; var9 = (Item)var37.getNext()) {
                  if((var3 & 32767) == var9.id && var7 == var9.quantity) {
                     var9.quantity = var2;
                     break;
                  }
               }

               Player.groundItemSpawned(var5, var6);
            }
         }

      } else {
         int var31;
         int var32;
         int var41;
         if(class173.field2421 == var0) {
            var2 = var1.method3297();
            var3 = var1.readUnsignedByte();
            var4 = (var3 >> 4 & 7) + class46.field558;
            var5 = (var3 & 7) + class35.field467;
            var6 = var1.readUnsignedByte();
            var7 = var6 >> 2;
            var31 = var6 & 3;
            var32 = Client.field903[var7];
            if(var4 >= 0 && var5 >= 0 && var4 < 103 && var5 < 103) {
               if(var32 == 0) {
                  WallObject var10 = class48.region.method2712(BoundingBox2D.plane, var4, var5);
                  if(var10 != null) {
                     var41 = var10.hash >> 14 & 32767;
                     if(var7 == 2) {
                        var10.renderable1 = new DynamicObject(var41, 2, var31 + 4, BoundingBox2D.plane, var4, var5, var2, false, var10.renderable1);
                        var10.renderable2 = new DynamicObject(var41, 2, var31 + 1 & 3, BoundingBox2D.plane, var4, var5, var2, false, var10.renderable2);
                     } else {
                        var10.renderable1 = new DynamicObject(var41, var7, var31, BoundingBox2D.plane, var4, var5, var2, false, var10.renderable1);
                     }
                  }
               }

               if(var32 == 1) {
                  DecorativeObject var38 = class48.region.method2771(BoundingBox2D.plane, var4, var5);
                  if(var38 != null) {
                     var41 = var38.hash >> 14 & 32767;
                     if(var7 != 4 && var7 != 5) {
                        if(var7 == 6) {
                           var38.renderable1 = new DynamicObject(var41, 4, var31 + 4, BoundingBox2D.plane, var4, var5, var2, false, var38.renderable1);
                        } else if(var7 == 7) {
                           var38.renderable1 = new DynamicObject(var41, 4, (var31 + 2 & 3) + 4, BoundingBox2D.plane, var4, var5, var2, false, var38.renderable1);
                        } else if(var7 == 8) {
                           var38.renderable1 = new DynamicObject(var41, 4, var31 + 4, BoundingBox2D.plane, var4, var5, var2, false, var38.renderable1);
                           var38.renderable2 = new DynamicObject(var41, 4, (var31 + 2 & 3) + 4, BoundingBox2D.plane, var4, var5, var2, false, var38.renderable2);
                        }
                     } else {
                        var38.renderable1 = new DynamicObject(var41, 4, var31, BoundingBox2D.plane, var4, var5, var2, false, var38.renderable1);
                     }
                  }
               }

               if(var32 == 2) {
                  GameObject var39 = class48.region.method2714(BoundingBox2D.plane, var4, var5);
                  if(var7 == 11) {
                     var7 = 10;
                  }

                  if(var39 != null) {
                     var39.renderable = new DynamicObject(var39.hash >> 14 & 32767, var7, var31, BoundingBox2D.plane, var4, var5, var2, false, var39.renderable);
                  }
               }

               if(var32 == 3) {
                  GroundObject var40 = class48.region.getFloorDecoration(BoundingBox2D.plane, var4, var5);
                  if(var40 != null) {
                     var40.renderable = new DynamicObject(var40.hash >> 14 & 32767, 22, var31, BoundingBox2D.plane, var4, var5, var2, false, var40.renderable);
                  }
               }
            }

         } else {
            Item var34;
            if(class173.field2428 == var0) {
               var2 = var1.readUnsignedByteNegate();
               var3 = (var2 >> 4 & 7) + class46.field558;
               var4 = (var2 & 7) + class35.field467;
               var5 = var1.method3299();
               if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  Deque var33 = Client.groundItemDeque[BoundingBox2D.plane][var3][var4];
                  if(var33 != null) {
                     for(var34 = (Item)var33.getFront(); var34 != null; var34 = (Item)var33.getNext()) {
                        if((var5 & 32767) == var34.id) {
                           var34.unlink();
                           break;
                        }
                     }

                     if(var33.getFront() == null) {
                        Client.groundItemDeque[BoundingBox2D.plane][var3][var4] = null;
                     }

                     Player.groundItemSpawned(var3, var4);
                  }
               }

            } else if(class173.field2427 == var0) {
               var2 = var1.method3299();
               var3 = var1.readUnsignedByte();
               var4 = (var3 >> 4 & 7) + class46.field558;
               var5 = (var3 & 7) + class35.field467;
               var6 = var1.readUnsignedShortOb1();
               if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                  var34 = new Item();
                  var34.id = var2;
                  var34.quantity = var6;
                  if(Client.groundItemDeque[BoundingBox2D.plane][var4][var5] == null) {
                     Client.groundItemDeque[BoundingBox2D.plane][var4][var5] = new Deque();
                  }

                  Client.groundItemDeque[BoundingBox2D.plane][var4][var5].addFront(var34);
                  Player.groundItemSpawned(var4, var5);
               }

            } else if(class173.field2423 == var0) {
               var2 = var1.method3297();
               var3 = var1.readUnsignedShort();
               var4 = var1.readUnsignedByteNegate();
               var5 = var1.readUnsignedByte();
               var6 = (var5 >> 4 & 7) + class46.field558;
               var7 = (var5 & 7) + class35.field467;
               if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                  var6 = var6 * 128 + 64;
                  var7 = var7 * 128 + 64;
                  GraphicsObject var8 = new GraphicsObject(var3, BoundingBox2D.plane, var6, var7, WorldMapType2.getTileHeight(var6, var7, BoundingBox2D.plane) - var4, var2, Client.gameCycle);
                  Client.graphicsObjectDeque.addFront(var8);
               }

            } else if(class173.field2420 == var0) {
               var2 = var1.readUnsignedByte();
               var3 = var2 >> 2;
               var4 = var2 & 3;
               var5 = Client.field903[var3];
               var6 = var1.method3274();
               var7 = (var6 >> 4 & 7) + class46.field558;
               var31 = (var6 & 7) + class35.field467;
               var32 = var1.readUnsignedShort();
               if(var7 >= 0 && var31 >= 0 && var7 < 104 && var31 < 104) {
                  class44.method625(BoundingBox2D.plane, var7, var31, var5, var32, var3, var4, 0, -1);
               }

            } else {
               int var35;
               if(class173.field2424 == var0) {
                  var2 = var1.method3335();
                  var3 = var1.readUnsignedShort();
                  var4 = var1.readUnsignedByte();
                  var5 = var4 >> 4 & 15;
                  var6 = var4 & 7;
                  var7 = var1.readUnsignedByte();
                  var31 = (var7 >> 4 & 7) + class46.field558;
                  var32 = (var7 & 7) + class35.field467;
                  if(var31 >= 0 && var32 >= 0 && var31 < 104 && var32 < 104) {
                     var35 = var5 + 1;
                     if(UrlRequest.localPlayer.pathX[0] >= var31 - var35 && UrlRequest.localPlayer.pathX[0] <= var31 + var35 && UrlRequest.localPlayer.pathY[0] >= var32 - var35 && UrlRequest.localPlayer.pathY[0] <= var35 + var32 && Client.field1067 != 0 && var6 > 0 && Client.field1068 < 50) {
                        Client.field1069[Client.field1068] = var3;
                        Client.field1070[Client.field1068] = var6;
                        Client.field1071[Client.field1068] = var2;
                        Client.audioEffects[Client.field1068] = null;
                        Client.field1072[Client.field1068] = var5 + (var32 << 8) + (var31 << 16);
                        ++Client.field1068;
                     }
                  }
               }

               if(class173.field2425 == var0) {
                  var2 = var1.readUnsignedByteNegate();
                  var3 = var2 >> 2;
                  var4 = var2 & 3;
                  var5 = Client.field903[var3];
                  var6 = var1.method3335();
                  var7 = (var6 >> 4 & 7) + class46.field558;
                  var31 = (var6 & 7) + class35.field467;
                  if(var7 >= 0 && var31 >= 0 && var7 < 104 && var31 < 104) {
                     class44.method625(BoundingBox2D.plane, var7, var31, var5, -1, var3, var4, 0, -1);
                  }

               } else {
                  int var12;
                  int var14;
                  if(class173.field2426 == var0) {
                     var2 = var1.method3299();
                     var3 = var1.method3274();
                     var4 = (var3 >> 4 & 7) + class46.field558;
                     var5 = (var3 & 7) + class35.field467;
                     var6 = var1.method3335() * 4;
                     var7 = var1.readUnsignedByteNegate();
                     byte var44 = var1.method3437();
                     var32 = var1.readUnsignedShortOb1();
                     var35 = var1.readUnsignedShortOb1();
                     var41 = var1.readUnsignedByteNegate() * 4;
                     var12 = var1.readShort();
                     int var42 = var1.readUnsignedByte();
                     byte var43 = var1.method3347();
                     var31 = var44 + var4;
                     var14 = var43 + var5;
                     if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104 && var31 >= 0 && var14 >= 0 && var31 < 104 && var14 < 104 && var35 != 65535) {
                        var4 = var4 * 128 + 64;
                        var5 = var5 * 128 + 64;
                        var31 = var31 * 128 + 64;
                        var14 = var14 * 128 + 64;
                        Projectile var15 = new Projectile(var35, BoundingBox2D.plane, var4, var5, WorldMapType2.getTileHeight(var4, var5, BoundingBox2D.plane) - var6, var32 + Client.gameCycle, var2 + Client.gameCycle, var42, var7, var12, var41);
                        var15.moveProjectile(var31, var14, WorldMapType2.getTileHeight(var31, var14, BoundingBox2D.plane) - var41, var32 + Client.gameCycle);
                        Client.projectiles.addFront(var15);
                     }

                  } else {
                     if(class173.field2422 == var0) {
                        var2 = var1.readUnsignedShortOb1();
                        var3 = var1.readUnsignedShortOb1();
                        var4 = var1.readUnsignedShort();
                        var5 = var1.readUnsignedByte();
                        var6 = var5 >> 2;
                        var7 = var5 & 3;
                        var31 = Client.field903[var6];
                        byte var45 = var1.method3347();
                        byte var46 = var1.method3347();
                        byte var11 = var1.method3328();
                        var12 = var1.method3299();
                        byte var13 = var1.method3437();
                        var14 = var1.readUnsignedByteNegate();
                        int var36 = (var14 >> 4 & 7) + class46.field558;
                        int var16 = (var14 & 7) + class35.field467;
                        Player var17;
                        if(var4 == Client.localInteractingIndex) {
                           var17 = UrlRequest.localPlayer;
                        } else {
                           var17 = Client.cachedPlayers[var4];
                        }

                        if(var17 != null) {
                           ObjectComposition var18 = CacheFile.getObjectDefinition(var12);
                           int var19;
                           int var20;
                           if(var7 != 1 && var7 != 3) {
                              var19 = var18.sizeX;
                              var20 = var18.sizeY;
                           } else {
                              var19 = var18.sizeY;
                              var20 = var18.sizeX;
                           }

                           int var21 = var36 + (var19 >> 1);
                           int var22 = var36 + (var19 + 1 >> 1);
                           int var23 = var16 + (var20 >> 1);
                           int var24 = var16 + (var20 + 1 >> 1);
                           int[][] var25 = class61.tileHeights[BoundingBox2D.plane];
                           int var26 = var25[var22][var24] + var25[var21][var23] + var25[var22][var23] + var25[var21][var24] >> 2;
                           int var27 = (var36 << 7) + (var19 << 6);
                           int var28 = (var16 << 7) + (var20 << 6);
                           Model var29 = var18.method4665(var6, var7, var25, var27, var26, var28);
                           if(var29 != null) {
                              class44.method625(BoundingBox2D.plane, var36, var16, var31, -1, 0, 0, var3 + 1, var2 + 1);
                              var17.animationCycleStart = var3 + Client.gameCycle;
                              var17.animationCycleEnd = var2 + Client.gameCycle;
                              var17.model = var29;
                              var17.field809 = var36 * 128 + var19 * 64;
                              var17.field820 = var16 * 128 + var20 * 64;
                              var17.field830 = var26;
                              byte var30;
                              if(var11 > var45) {
                                 var30 = var11;
                                 var11 = var45;
                                 var45 = var30;
                              }

                              if(var13 > var46) {
                                 var30 = var13;
                                 var13 = var46;
                                 var46 = var30;
                              }

                              var17.field823 = var36 + var11;
                              var17.field825 = var45 + var36;
                              var17.field824 = var13 + var16;
                              var17.field828 = var46 + var16;
                           }
                        }
                     }

                  }
               }
            }
         }
      }
   }
}
