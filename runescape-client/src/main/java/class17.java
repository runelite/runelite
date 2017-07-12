import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class17 implements Comparator {
   @ObfuscatedName("k")
   @Export("blendedHue")
   static int[] blendedHue;
   @ObfuscatedName("i")
   static boolean field317;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "1763840078"
   )
   int method123(class14 var1, class14 var2) {
      return var1.field285.price < var2.field285.price?-1:(var2.field285.price == var1.field285.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method123((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1496050479"
   )
   static final void method114() {
      WorldMapData.flush(false);
      Client.field1083 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < ISAACCipher.field2429.length; ++var1) {
         if(WorldMapType3.field394[var1] != -1 && ISAACCipher.field2429[var1] == null) {
            ISAACCipher.field2429[var1] = Frames.indexMaps.getConfigData(WorldMapType3.field394[var1], 0);
            if(ISAACCipher.field2429[var1] == null) {
               var0 = false;
               ++Client.field1083;
            }
         }

         if(class45.landRegionFielIds[var1] != -1 && class14.field290[var1] == null) {
            class14.field290[var1] = Frames.indexMaps.getConfigData(class45.landRegionFielIds[var1], 0, class28.xteaKeys[var1]);
            if(class14.field290[var1] == null) {
               var0 = false;
               ++Client.field1083;
            }
         }
      }

      if(!var0) {
         Client.field1104 = 1;
      } else {
         Client.field983 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < ISAACCipher.field2429.length; ++var1) {
            byte[] var2 = class14.field290[var1];
            if(var2 != null) {
               var3 = (RSCanvas.mapRegions[var1] >> 8) * 64 - KeyFocusListener.baseX;
               var4 = (RSCanvas.mapRegions[var1] & 255) * 64 - class266.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class261.method4733(var2, var3, var4);
            }
         }

         if(!var0) {
            Client.field1104 = 2;
         } else {
            if(Client.field1104 != 0) {
               class2.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class14.method67();
            class28.method231();
            class14.method67();
            class2.region.reset();
            class14.method67();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].reset();
            }

            int var23;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var23 = 0; var23 < 104; ++var23) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class61.tileSettings[var1][var23][var3] = 0;
                  }
               }
            }

            class14.method67();
            class34.method506();
            var1 = ISAACCipher.field2429.length;
            class168.method3108();
            WorldMapData.flush(true);
            int var6;
            int var7;
            int var9;
            int var10;
            int var11;
            int var12;
            int var25;
            if(!Client.isDynamicRegion) {
               byte[] var5;
               for(var23 = 0; var23 < var1; ++var23) {
                  var3 = (RSCanvas.mapRegions[var23] >> 8) * 64 - KeyFocusListener.baseX;
                  var4 = (RSCanvas.mapRegions[var23] & 255) * 64 - class266.baseY;
                  var5 = ISAACCipher.field2429[var23];
                  if(var5 != null) {
                     class14.method67();
                     var6 = World.field1321 * 8 - 48;
                     var7 = FileOnDisk.field1777 * 8 - 48;
                     CollisionData[] var8 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var3 + var10 > 0 && var3 + var10 < 103 && var4 + var11 > 0 && var11 + var4 < 103) {
                                 var8[var9].flags[var3 + var10][var11 + var4] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var24 = new Buffer(var5);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var12 = 0; var12 < 64; ++var12) {
                              GraphicsObject.loadTerrain(var24, var10, var11 + var3, var4 + var12, var6, var7, 0);
                           }
                        }
                     }
                  }
               }

               for(var23 = 0; var23 < var1; ++var23) {
                  var3 = (RSCanvas.mapRegions[var23] >> 8) * 64 - KeyFocusListener.baseX;
                  var4 = (RSCanvas.mapRegions[var23] & 255) * 64 - class266.baseY;
                  var5 = ISAACCipher.field2429[var23];
                  if(var5 == null && FileOnDisk.field1777 < 800) {
                     class14.method67();
                     WorldMapType3.method201(var3, var4, 64, 64);
                  }
               }

               WorldMapData.flush(true);

               for(var23 = 0; var23 < var1; ++var23) {
                  byte[] var27 = class14.field290[var23];
                  if(var27 != null) {
                     var4 = (RSCanvas.mapRegions[var23] >> 8) * 64 - KeyFocusListener.baseX;
                     var25 = (RSCanvas.mapRegions[var23] & 255) * 64 - class266.baseY;
                     class14.method67();
                     Region var28 = class2.region;
                     CollisionData[] var29 = Client.collisionMaps;
                     Buffer var30 = new Buffer(var27);
                     var9 = -1;

                     while(true) {
                        var10 = var30.getUSmart();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var12 = var30.getUSmart();
                           if(var12 == 0) {
                              break;
                           }

                           var11 += var12 - 1;
                           int var13 = var11 & 63;
                           int var14 = var11 >> 6 & 63;
                           int var15 = var11 >> 12;
                           int var16 = var30.readUnsignedByte();
                           int var17 = var16 >> 2;
                           int var18 = var16 & 3;
                           int var19 = var14 + var4;
                           int var20 = var13 + var25;
                           if(var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
                              int var21 = var15;
                              if((class61.tileSettings[1][var19][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var22 = null;
                              if(var21 >= 0) {
                                 var22 = var29[var21];
                              }

                              class211.addObject(var15, var19, var20, var9, var18, var17, var28, var22);
                           }
                        }
                     }
                  }
               }
            }

            int var26;
            if(Client.isDynamicRegion) {
               for(var23 = 0; var23 < 4; ++var23) {
                  class14.method67();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var31 = false;
                        var6 = Client.field988[var23][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var26 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var12 = 0; var12 < RSCanvas.mapRegions.length; ++var12) {
                              if(RSCanvas.mapRegions[var12] == var11 && ISAACCipher.field2429[var12] != null) {
                                 class33.method347(ISAACCipher.field2429[var12], var23, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var26, Client.collisionMaps);
                                 var31 = true;
                                 break;
                              }
                           }
                        }

                        if(!var31) {
                           var7 = var23;
                           var26 = var3 * 8;
                           var9 = var4 * 8;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class61.tileHeights[var7][var26 + var10][var9 + var11] = 0;
                              }
                           }

                           if(var26 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class61.tileHeights[var7][var26][var9 + var10] = class61.tileHeights[var7][var26 - 1][var9 + var10];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class61.tileHeights[var7][var10 + var26][var9] = class61.tileHeights[var7][var26 + var10][var9 - 1];
                              }
                           }

                           if(var26 > 0 && class61.tileHeights[var7][var26 - 1][var9] != 0) {
                              class61.tileHeights[var7][var26][var9] = class61.tileHeights[var7][var26 - 1][var9];
                           } else if(var9 > 0 && class61.tileHeights[var7][var26][var9 - 1] != 0) {
                              class61.tileHeights[var7][var26][var9] = class61.tileHeights[var7][var26][var9 - 1];
                           } else if(var26 > 0 && var9 > 0 && class61.tileHeights[var7][var26 - 1][var9 - 1] != 0) {
                              class61.tileHeights[var7][var26][var9] = class61.tileHeights[var7][var26 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var23 = 0; var23 < 13; ++var23) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field988[0][var23][var3];
                     if(var4 == -1) {
                        WorldMapType3.method201(var23 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               WorldMapData.flush(true);

               for(var23 = 0; var23 < 4; ++var23) {
                  class14.method67();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var25 = Client.field988[var23][var3][var4];
                        if(var25 != -1) {
                           var6 = var25 >> 24 & 3;
                           var7 = var25 >> 1 & 3;
                           var26 = var25 >> 14 & 1023;
                           var9 = var25 >> 3 & 2047;
                           var10 = (var26 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < RSCanvas.mapRegions.length; ++var11) {
                              if(RSCanvas.mapRegions[var11] == var10 && class14.field290[var11] != null) {
                                 class3.method11(class14.field290[var11], var23, var3 * 8, var4 * 8, var6, (var26 & 7) * 8, (var9 & 7) * 8, var7, class2.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            WorldMapData.flush(true);
            class28.method231();
            class14.method67();
            Client.method1527(class2.region, Client.collisionMaps);
            WorldMapData.flush(true);
            var23 = class61.field770;
            if(var23 > WallObject.plane) {
               var23 = WallObject.plane;
            }

            if(var23 < WallObject.plane - 1) {
               var23 = WallObject.plane - 1;
            }

            if(Client.lowMemory) {
               class2.region.setup(class61.field770);
            } else {
               class2.region.setup(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  Occluder.groundItemSpawned(var3, var4);
               }
            }

            class14.method67();

            for(PendingSpawn var32 = (PendingSpawn)Client.pendingSpawns.getFront(); var32 != null; var32 = (PendingSpawn)Client.pendingSpawns.getNext()) {
               if(var32.hitpoints == -1) {
                  var32.delay = 0;
                  class3.method10(var32);
               } else {
                  var32.unlink();
               }
            }

            ObjectComposition.field3487.reset();
            if(class261.clientInstance.method967()) {
               Client.secretPacketBuffer1.putOpcode(219);
               Client.secretPacketBuffer1.putInt(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var3 = (World.field1321 - 6) / 8;
               var4 = (World.field1321 + 6) / 8;
               var25 = (FileOnDisk.field1777 - 6) / 8;
               var6 = (FileOnDisk.field1777 + 6) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var26 = var25 - 1; var26 <= var6 + 1; ++var26) {
                     if(var7 < var3 || var7 > var4 || var26 < var25 || var26 > var6) {
                        Frames.indexMaps.method4143("m" + var7 + "_" + var26);
                        Frames.indexMaps.method4143("l" + var7 + "_" + var26);
                     }
                  }
               }
            }

            TextureProvider.setGameState(30);
            class14.method67();
            class51.resetMapInfo();
            Client.secretPacketBuffer1.putOpcode(111);
            class95.method1782();
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)V",
      garbageValue = "-1751909066"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = XItemContainer.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field914 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - KeyFocusListener.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - class266.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      WallObject.plane = var2.field911 = var4;
      if(class96.field1520[var1] != null) {
         var2.decodeApperance(class96.field1520[var1]);
      }

      class96.field1521 = 0;
      class96.field1531[++class96.field1521 - 1] = var1;
      class96.field1516[var1] = 0;
      class96.field1523 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class96.field1522[var7] = (var10 << 14) + (var9 << 28) + var11;
            class96.field1526[var7] = 0;
            class96.field1527[var7] = -1;
            class96.field1524[++class96.field1523 - 1] = var7;
            class96.field1516[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1870101392"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = Timer.method2972(var0 - 1, var1 - 1) + Timer.method2972(var0 + 1, var1 - 1) + Timer.method2972(var0 - 1, var1 + 1) + Timer.method2972(var0 + 1, var1 + 1);
      int var3 = Timer.method2972(var0 - 1, var1) + Timer.method2972(var0 + 1, var1) + Timer.method2972(var0, var1 - 1) + Timer.method2972(var0, var1 + 1);
      int var4 = Timer.method2972(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Lclass252;",
      garbageValue = "-38"
   )
   public static class252 method115(int var0) {
      class252 var1 = (class252)class252.field3402.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class252.field3406.getConfigData(34, var0);
         var1 = new class252();
         if(var2 != null) {
            var1.method4459(new Buffer(var2));
         }

         var1.method4458();
         class252.field3402.put(var1, (long)var0);
         return var1;
      }
   }
}
