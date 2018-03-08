import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("av")
   static int[] field1943;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      longValue = 5307190258623719771L
   )
   static long field1946;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 76279069
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1325803731
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1152421859
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1713351591
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1920560605
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("b")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -345504085
   )
   @Export("rgb")
   int rgb;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILfn;Lju;I)V",
      garbageValue = "-1803903662"
   )
   static void method2863(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         for(FileSystem var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var5 != null; var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
            if(var5.hash == (long)var0 && var1 == var5.index && var5.type == 0) {
               var3 = var5.field3367;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.load(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.read(var0);
         var2.load(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(Lga;B)V",
      garbageValue = "-17"
   )
   static final void method2862(class183 var0) {
      PacketBuffer var1 = Client.field1072.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(class183.field2459 == var0) {
         var2 = var1.method3567();
         var3 = var2 >> 2;
         var4 = var2 & 3;
         var5 = Client.field909[var3];
         var6 = var1.method3566();
         var7 = (var6 >> 4 & 7) + class64.field742;
         var8 = (var6 & 7) + FaceNormal.field2034;
         if(var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
            class37.method539(Ignore.plane, var7, var8, var5, -1, var3, var4, 0, -1);
         }

      } else {
         int var9;
         if(class183.field2463 == var0) {
            var2 = var1.readUnsignedByte();
            var3 = (var2 >> 4 & 7) + class64.field742;
            var4 = (var2 & 7) + FaceNormal.field2034;
            var5 = var1.method3574();
            var6 = var1.method3566();
            var7 = var6 >> 2;
            var8 = var6 & 3;
            var9 = Client.field909[var7];
            if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
               class37.method539(Ignore.plane, var3, var4, var9, var5, var7, var8, 0, -1);
            }

         } else if(class183.field2456 == var0) {
            var2 = var1.method3566();
            var3 = (var2 >> 4 & 7) + class64.field742;
            var4 = (var2 & 7) + FaceNormal.field2034;
            var5 = var1.method3576();
            var6 = var1.method3576();
            var7 = var1.method3566();
            if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
               var3 = var3 * 128 + 64;
               var4 = var4 * 128 + 64;
               GraphicsObject var42 = new GraphicsObject(var6, Ignore.plane, var3, var4, class149.getTileHeight(var3, var4, Ignore.plane) - var7, var5, Client.gameCycle);
               Client.graphicsObjectDeque.addFront(var42);
            }

         } else {
            int var10;
            if(class183.field2464 == var0) {
               var2 = var1.method3567();
               var3 = (var2 >> 4 & 7) + class64.field742;
               var4 = (var2 & 7) + FaceNormal.field2034;
               var5 = var1.method3567();
               var6 = var5 >> 4 & 15;
               var7 = var5 & 7;
               var8 = var1.method3567();
               var9 = var1.method3574();
               if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  var10 = var6 + 1;
                  if(WorldMapData.localPlayer.pathX[0] >= var3 - var10 && WorldMapData.localPlayer.pathX[0] <= var3 + var10 && WorldMapData.localPlayer.pathY[0] >= var4 - var10 && WorldMapData.localPlayer.pathY[0] <= var10 + var4 && Client.field1083 != 0 && var7 > 0 && Client.queuedSoundEffectCount < 50) {
                     Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var9;
                     Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var7;
                     Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var8;
                     Client.audioEffects[Client.queuedSoundEffectCount] = null;
                     Client.soundLocations[Client.queuedSoundEffectCount] = var6 + (var4 << 8) + (var3 << 16);
                     ++Client.queuedSoundEffectCount;
                  }
               }
            }

            Item var32;
            if(class183.field2458 == var0) {
               var2 = var1.method3565();
               var3 = (var2 >> 4 & 7) + class64.field742;
               var4 = (var2 & 7) + FaceNormal.field2034;
               var5 = var1.method3576();
               var6 = var1.method3576();
               if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  var32 = new Item();
                  var32.id = var6;
                  var32.quantity = var5;
                  if(Client.groundItemDeque[Ignore.plane][var3][var4] == null) {
                     Client.groundItemDeque[Ignore.plane][var3][var4] = new Deque();
                  }

                  Client.groundItemDeque[Ignore.plane][var3][var4].addFront(var32);
                  GameCanvas.groundItemSpawned(var3, var4);
               }

            } else {
               int var11;
               int var12;
               int var13;
               int var14;
               if(class183.field2461 == var0) {
                  var2 = var1.method3576();
                  byte var38 = var1.readByte();
                  var4 = var1.method3576();
                  byte var39 = var1.readByte();
                  var6 = var1.method3565();
                  var7 = (var6 >> 4 & 7) + class64.field742;
                  var8 = (var6 & 7) + FaceNormal.field2034;
                  byte var40 = var1.method3535();
                  var10 = var1.method3574();
                  var11 = var1.method3566();
                  var12 = var11 >> 2;
                  var13 = var11 & 3;
                  var14 = Client.field909[var12];
                  int var15 = var1.readUnsignedShort();
                  byte var16 = var1.method3535();
                  Player var17;
                  if(var15 == Client.localInteractingIndex) {
                     var17 = WorldMapData.localPlayer;
                  } else {
                     var17 = Client.cachedPlayers[var15];
                  }

                  if(var17 != null) {
                     ObjectComposition var18 = Spotanim.getObjectDefinition(var10);
                     int var19;
                     int var20;
                     if(var13 != 1 && var13 != 3) {
                        var19 = var18.width;
                        var20 = var18.length;
                     } else {
                        var19 = var18.length;
                        var20 = var18.width;
                     }

                     int var21 = var7 + (var19 >> 1);
                     int var22 = var7 + (var19 + 1 >> 1);
                     int var23 = var8 + (var20 >> 1);
                     int var24 = var8 + (var20 + 1 >> 1);
                     int[][] var25 = class62.tileHeights[Ignore.plane];
                     int var26 = var25[var22][var24] + var25[var21][var24] + var25[var22][var23] + var25[var21][var23] >> 2;
                     int var27 = (var7 << 7) + (var19 << 6);
                     int var28 = (var8 << 7) + (var20 << 6);
                     Model var29 = var18.method5024(var12, var13, var25, var27, var26, var28);
                     if(var29 != null) {
                        class37.method539(Ignore.plane, var7, var8, var14, -1, 0, 0, var4 + 1, var2 + 1);
                        var17.animationCycleStart = var4 + Client.gameCycle;
                        var17.animationCycleEnd = var2 + Client.gameCycle;
                        var17.model = var29;
                        var17.field825 = var7 * 128 + var19 * 64;
                        var17.field840 = var8 * 128 + var20 * 64;
                        var17.field826 = var26;
                        byte var30;
                        if(var38 > var39) {
                           var30 = var38;
                           var38 = var39;
                           var39 = var30;
                        }

                        if(var40 > var16) {
                           var30 = var40;
                           var40 = var16;
                           var16 = var30;
                        }

                        var17.field815 = var7 + var38;
                        var17.field829 = var7 + var39;
                        var17.field814 = var8 + var40;
                        var17.field841 = var16 + var8;
                     }
                  }
               }

               if(class183.field2460 == var0) {
                  var2 = var1.readUnsignedShort();
                  var3 = var1.method3565();
                  var4 = (var3 >> 4 & 7) + class64.field742;
                  var5 = (var3 & 7) + FaceNormal.field2034;
                  var6 = var1.readUnsignedByte();
                  var7 = var6 >> 2;
                  var8 = var6 & 3;
                  var9 = Client.field909[var7];
                  if(var4 >= 0 && var5 >= 0 && var4 < 103 && var5 < 103) {
                     if(var9 == 0) {
                        WallObject var33 = class38.region.method2888(Ignore.plane, var4, var5);
                        if(var33 != null) {
                           var11 = var33.hash >> 14 & 32767;
                           if(var7 == 2) {
                              var33.renderable1 = new DynamicObject(var11, 2, var8 + 4, Ignore.plane, var4, var5, var2, false, var33.renderable1);
                              var33.renderable2 = new DynamicObject(var11, 2, var8 + 1 & 3, Ignore.plane, var4, var5, var2, false, var33.renderable2);
                           } else {
                              var33.renderable1 = new DynamicObject(var11, var7, var8, Ignore.plane, var4, var5, var2, false, var33.renderable1);
                           }
                        }
                     }

                     if(var9 == 1) {
                        DecorativeObject var43 = class38.region.method2889(Ignore.plane, var4, var5);
                        if(var43 != null) {
                           var11 = var43.hash >> 14 & 32767;
                           if(var7 != 4 && var7 != 5) {
                              if(var7 == 6) {
                                 var43.renderable1 = new DynamicObject(var11, 4, var8 + 4, Ignore.plane, var4, var5, var2, false, var43.renderable1);
                              } else if(var7 == 7) {
                                 var43.renderable1 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, Ignore.plane, var4, var5, var2, false, var43.renderable1);
                              } else if(var7 == 8) {
                                 var43.renderable1 = new DynamicObject(var11, 4, var8 + 4, Ignore.plane, var4, var5, var2, false, var43.renderable1);
                                 var43.renderable2 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, Ignore.plane, var4, var5, var2, false, var43.renderable2);
                              }
                           } else {
                              var43.renderable1 = new DynamicObject(var11, 4, var8, Ignore.plane, var4, var5, var2, false, var43.renderable1);
                           }
                        }
                     }

                     if(var9 == 2) {
                        GameObject var44 = class38.region.method2890(Ignore.plane, var4, var5);
                        if(var7 == 11) {
                           var7 = 10;
                        }

                        if(var44 != null) {
                           var44.renderable = new DynamicObject(var44.hash >> 14 & 32767, var7, var8, Ignore.plane, var4, var5, var2, false, var44.renderable);
                        }
                     }

                     if(var9 == 3) {
                        GroundObject var45 = class38.region.getFloorDecoration(Ignore.plane, var4, var5);
                        if(var45 != null) {
                           var45.renderable = new DynamicObject(var45.hash >> 14 & 32767, 22, var8, Ignore.plane, var4, var5, var2, false, var45.renderable);
                        }
                     }
                  }

               } else if(class183.field2462 == var0) {
                  var2 = var1.method3566();
                  var3 = (var2 >> 4 & 7) + class64.field742;
                  var4 = (var2 & 7) + FaceNormal.field2034;
                  var5 = var1.method3574();
                  var6 = var1.method3576();
                  var7 = var1.readUnsignedShort();
                  if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                     Deque var31 = Client.groundItemDeque[Ignore.plane][var3][var4];
                     if(var31 != null) {
                        for(Item var34 = (Item)var31.getFront(); var34 != null; var34 = (Item)var31.getNext()) {
                           if((var6 & 32767) == var34.id && var5 == var34.quantity) {
                              var34.quantity = var7;
                              break;
                           }
                        }

                        GameCanvas.groundItemSpawned(var3, var4);
                     }
                  }

               } else if(class183.field2455 != var0) {
                  if(class183.field2457 == var0) {
                     byte var37 = var1.method3535();
                     var3 = var1.method3566();
                     var4 = var1.method3574();
                     var5 = var1.method3571();
                     var6 = var1.method3566();
                     var7 = (var6 >> 4 & 7) + class64.field742;
                     var8 = (var6 & 7) + FaceNormal.field2034;
                     var9 = var1.method3574();
                     var10 = var1.method3565() * 4;
                     byte var41 = var1.method3613();
                     var12 = var1.method3576();
                     var13 = var1.method3566();
                     var14 = var1.method3566() * 4;
                     var11 = var41 + var7;
                     var2 = var37 + var8;
                     if(var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var11 >= 0 && var2 >= 0 && var11 < 104 && var2 < 104 && var12 != 65535) {
                        var7 = var7 * 128 + 64;
                        var8 = var8 * 128 + 64;
                        var11 = var11 * 128 + 64;
                        var2 = var2 * 128 + 64;
                        Projectile var36 = new Projectile(var12, Ignore.plane, var7, var8, class149.getTileHeight(var7, var8, Ignore.plane) - var10, var4 + Client.gameCycle, var9 + Client.gameCycle, var3, var13, var5, var14);
                        var36.moveProjectile(var11, var2, class149.getTileHeight(var11, var2, Ignore.plane) - var14, var4 + Client.gameCycle);
                        Client.projectiles.addFront(var36);
                     }

                  }
               } else {
                  var2 = var1.method3566();
                  var3 = (var2 >> 4 & 7) + class64.field742;
                  var4 = (var2 & 7) + FaceNormal.field2034;
                  var5 = var1.method3574();
                  if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                     Deque var35 = Client.groundItemDeque[Ignore.plane][var3][var4];
                     if(var35 != null) {
                        for(var32 = (Item)var35.getFront(); var32 != null; var32 = (Item)var35.getNext()) {
                           if((var5 & 32767) == var32.id) {
                              var32.unlink();
                              break;
                           }
                        }

                        if(var35.getFront() == null) {
                           Client.groundItemDeque[Ignore.plane][var3][var4] = null;
                        }

                        GameCanvas.groundItemSpawned(var3, var4);
                     }
                  }

               }
            }
         }
      }
   }
}
