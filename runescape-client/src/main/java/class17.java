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

         int var2;
         int var3;
         for(var1 = 0; var1 < ISAACCipher.field2429.length; ++var1) {
            byte[] var4 = class14.field290[var1];
            if(var4 != null) {
               var2 = (RSCanvas.mapRegions[var1] >> 8) * 64 - KeyFocusListener.baseX;
               var3 = (RSCanvas.mapRegions[var1] & 255) * 64 - class266.baseY;
               if(Client.isDynamicRegion) {
                  var2 = 10;
                  var3 = 10;
               }

               var0 &= class261.method4733(var4, var2, var3);
            }
         }

         if(!var0) {
            Client.field1104 = 2;
         } else {
            if(Client.field1104 != 0) {
               class2.drawStatusBox("Loading - please wait.<br> (100%)", true);
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

            int var27;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var27 = 0; var27 < 104; ++var27) {
                  for(var2 = 0; var2 < 104; ++var2) {
                     class61.tileSettings[var1][var27][var2] = 0;
                  }
               }
            }

            class14.method67();
            class34.method506();
            var1 = ISAACCipher.field2429.length;
            class168.method3108();
            WorldMapData.flush(true);
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            if(!Client.isDynamicRegion) {
               var27 = 0;

               label445:
               while(true) {
                  byte[] var12;
                  if(var27 >= var1) {
                     for(var27 = 0; var27 < var1; ++var27) {
                        var2 = (RSCanvas.mapRegions[var27] >> 8) * 64 - KeyFocusListener.baseX;
                        var3 = (RSCanvas.mapRegions[var27] & 255) * 64 - class266.baseY;
                        var12 = ISAACCipher.field2429[var27];
                        if(var12 == null && FileOnDisk.field1777 < 800) {
                           class14.method67();
                           WorldMapType3.method201(var2, var3, 64, 64);
                        }
                     }

                     WorldMapData.flush(true);
                     var27 = 0;

                     while(true) {
                        if(var27 >= var1) {
                           break label445;
                        }

                        byte[] var29 = class14.field290[var27];
                        if(var29 != null) {
                           var3 = (RSCanvas.mapRegions[var27] >> 8) * 64 - KeyFocusListener.baseX;
                           var11 = (RSCanvas.mapRegions[var27] & 255) * 64 - class266.baseY;
                           class14.method67();
                           Region var31 = class2.region;
                           CollisionData[] var15 = Client.collisionMaps;
                           Buffer var16 = new Buffer(var29);
                           var7 = -1;

                           while(true) {
                              var8 = var16.getUSmart();
                              if(var8 == 0) {
                                 break;
                              }

                              var7 += var8;
                              var9 = 0;

                              while(true) {
                                 var10 = var16.getUSmart();
                                 if(var10 == 0) {
                                    break;
                                 }

                                 var9 += var10 - 1;
                                 int var17 = var9 & 63;
                                 int var18 = var9 >> 6 & 63;
                                 int var19 = var9 >> 12;
                                 int var20 = var16.readUnsignedByte();
                                 int var21 = var20 >> 2;
                                 int var22 = var20 & 3;
                                 int var23 = var3 + var18;
                                 int var24 = var17 + var11;
                                 if(var23 > 0 && var24 > 0 && var23 < 103 && var24 < 103) {
                                    int var25 = var19;
                                    if((class61.tileSettings[1][var23][var24] & 2) == 2) {
                                       var25 = var19 - 1;
                                    }

                                    CollisionData var26 = null;
                                    if(var25 >= 0) {
                                       var26 = var15[var25];
                                    }

                                    class211.addObject(var19, var23, var24, var7, var22, var21, var31, var26);
                                 }
                              }
                           }
                        }

                        ++var27;
                     }
                  }

                  var2 = (RSCanvas.mapRegions[var27] >> 8) * 64 - KeyFocusListener.baseX;
                  var3 = (RSCanvas.mapRegions[var27] & 255) * 64 - class266.baseY;
                  var12 = ISAACCipher.field2429[var27];
                  if(var12 != null) {
                     class14.method67();
                     var5 = World.field1321 * 8 - 48;
                     var6 = FileOnDisk.field1777 * 8 - 48;
                     CollisionData[] var13 = Client.collisionMaps;
                     var7 = 0;

                     label442:
                     while(true) {
                        if(var7 >= 4) {
                           Buffer var14 = new Buffer(var12);
                           var8 = 0;

                           while(true) {
                              if(var8 >= 4) {
                                 break label442;
                              }

                              for(var9 = 0; var9 < 64; ++var9) {
                                 for(var10 = 0; var10 < 64; ++var10) {
                                    GraphicsObject.loadTerrain(var14, var8, var2 + var9, var3 + var10, var5, var6, 0);
                                 }
                              }

                              ++var8;
                           }
                        }

                        for(var8 = 0; var8 < 64; ++var8) {
                           for(var9 = 0; var9 < 64; ++var9) {
                              if(var2 + var8 > 0 && var2 + var8 < 103 && var9 + var3 > 0 && var9 + var3 < 103) {
                                 var13[var7].flags[var2 + var8][var9 + var3] &= -16777217;
                              }
                           }
                        }

                        ++var7;
                     }
                  }

                  ++var27;
               }
            }

            int var28;
            if(Client.isDynamicRegion) {
               var27 = 0;

               label378:
               while(true) {
                  if(var27 >= 4) {
                     for(var27 = 0; var27 < 13; ++var27) {
                        for(var2 = 0; var2 < 13; ++var2) {
                           var3 = Client.field988[0][var27][var2];
                           if(var3 == -1) {
                              WorldMapType3.method201(var27 * 8, var2 * 8, 8, 8);
                           }
                        }
                     }

                     WorldMapData.flush(true);
                     var27 = 0;

                     while(true) {
                        if(var27 >= 4) {
                           break label378;
                        }

                        class14.method67();

                        for(var2 = 0; var2 < 13; ++var2) {
                           for(var3 = 0; var3 < 13; ++var3) {
                              var11 = Client.field988[var27][var2][var3];
                              if(var11 != -1) {
                                 var5 = var11 >> 24 & 3;
                                 var6 = var11 >> 1 & 3;
                                 var28 = var11 >> 14 & 1023;
                                 var7 = var11 >> 3 & 2047;
                                 var8 = var7 / 8 + (var28 / 8 << 8);

                                 for(var9 = 0; var9 < RSCanvas.mapRegions.length; ++var9) {
                                    if(RSCanvas.mapRegions[var9] == var8 && class14.field290[var9] != null) {
                                       class3.method11(class14.field290[var9], var27, var2 * 8, var3 * 8, var5, (var28 & 7) * 8, (var7 & 7) * 8, var6, class2.region, Client.collisionMaps);
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        ++var27;
                     }
                  }

                  class14.method67();

                  for(var2 = 0; var2 < 13; ++var2) {
                     for(var3 = 0; var3 < 13; ++var3) {
                        boolean var30 = false;
                        var5 = Client.field988[var27][var2][var3];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var28 = var5 >> 1 & 3;
                           var7 = var5 >> 14 & 1023;
                           var8 = var5 >> 3 & 2047;
                           var9 = (var7 / 8 << 8) + var8 / 8;

                           for(var10 = 0; var10 < RSCanvas.mapRegions.length; ++var10) {
                              if(var9 == RSCanvas.mapRegions[var10] && ISAACCipher.field2429[var10] != null) {
                                 class33.method347(ISAACCipher.field2429[var10], var27, var2 * 8, var3 * 8, var6, (var7 & 7) * 8, (var8 & 7) * 8, var28, Client.collisionMaps);
                                 var30 = true;
                                 break;
                              }
                           }
                        }

                        if(!var30) {
                           var6 = var27;
                           var28 = var2 * 8;
                           var7 = var3 * 8;

                           for(var8 = 0; var8 < 8; ++var8) {
                              for(var9 = 0; var9 < 8; ++var9) {
                                 class61.tileHeights[var6][var8 + var28][var9 + var7] = 0;
                              }
                           }

                           if(var28 > 0) {
                              for(var8 = 1; var8 < 8; ++var8) {
                                 class61.tileHeights[var6][var28][var8 + var7] = class61.tileHeights[var6][var28 - 1][var8 + var7];
                              }
                           }

                           if(var7 > 0) {
                              for(var8 = 1; var8 < 8; ++var8) {
                                 class61.tileHeights[var6][var8 + var28][var7] = class61.tileHeights[var6][var8 + var28][var7 - 1];
                              }
                           }

                           if(var28 > 0 && class61.tileHeights[var6][var28 - 1][var7] != 0) {
                              class61.tileHeights[var6][var28][var7] = class61.tileHeights[var6][var28 - 1][var7];
                           } else if(var7 > 0 && class61.tileHeights[var6][var28][var7 - 1] != 0) {
                              class61.tileHeights[var6][var28][var7] = class61.tileHeights[var6][var28][var7 - 1];
                           } else if(var28 > 0 && var7 > 0 && class61.tileHeights[var6][var28 - 1][var7 - 1] != 0) {
                              class61.tileHeights[var6][var28][var7] = class61.tileHeights[var6][var28 - 1][var7 - 1];
                           }
                        }
                     }
                  }

                  ++var27;
               }
            }

            WorldMapData.flush(true);
            class28.method231();
            class14.method67();
            Client.method1527(class2.region, Client.collisionMaps);
            WorldMapData.flush(true);
            var27 = class61.field770;
            if(var27 > WallObject.plane) {
               var27 = WallObject.plane;
            }

            if(var27 < WallObject.plane - 1) {
               var27 = WallObject.plane - 1;
            }

            if(Client.lowMemory) {
               class2.region.setup(class61.field770);
            } else {
               class2.region.setup(0);
            }

            for(var2 = 0; var2 < 104; ++var2) {
               for(var3 = 0; var3 < 104; ++var3) {
                  Occluder.groundItemSpawned(var2, var3);
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
               var2 = (World.field1321 - 6) / 8;
               var3 = (World.field1321 + 6) / 8;
               var11 = (FileOnDisk.field1777 - 6) / 8;
               var5 = (FileOnDisk.field1777 + 6) / 8;

               for(var6 = var2 - 1; var6 <= var3 + 1; ++var6) {
                  for(var28 = var11 - 1; var28 <= var5 + 1; ++var28) {
                     if(var6 < var2 || var6 > var3 || var28 < var11 || var28 > var5) {
                        Frames.indexMaps.method4143("m" + var6 + "_" + var28);
                        Frames.indexMaps.method4143("l" + var6 + "_" + var28);
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

   public int compare(Object var1, Object var2) {
      return this.method123((class14)var1, (class14)var2);
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
            class96.field1522[var7] = var11 + (var9 << 28) + (var10 << 14);
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
      return var4 / 4 + var2 / 16 + var3 / 8;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "1763840078"
   )
   int method123(class14 var1, class14 var2) {
      return var1.field285.price < var2.field285.price?-1:(var2.field285.price == var1.field285.price?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
