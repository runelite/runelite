import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class252 extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static NodeCache field3379;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   public static IndexDataBase field3375;
   @ObfuscatedName("f")
   char field3376;
   @ObfuscatedName("g")
   boolean field3378;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1677591887
   )
   public int field3377;
   @ObfuscatedName("x")
   public String field3374;

   static {
      field3379 = new NodeCache(64);
   }

   class252() {
      this.field3378 = true;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;IB)V",
      garbageValue = "122"
   )
   void method4466(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class267.field3650[var5 - 128];
            if(var6 == 0) {
               var6 = 63;
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field3376 = var3;
      } else if(var2 == 2) {
         this.field3377 = var1.readInt();
      } else if(var2 == 4) {
         this.field3378 = false;
      } else if(var2 == 5) {
         this.field3374 = var1.readString();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1454947691"
   )
   void method4455() {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-619234905"
   )
   void method4456(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4466(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1196995111"
   )
   public boolean method4458() {
      return this.field3376 == 115;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lia;III)Lkp;",
      garbageValue = "1430442763"
   )
   public static SpritePixels method4470(IndexDataBase var0, int var1, int var2) {
      if(!FileOnDisk.method2386(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class287.field3779;
         var4.maxHeight = ISAACCipher.field2435;
         var4.offsetX = class287.field3781[0];
         var4.offsetY = class211.offsetsY[0];
         var4.width = class266.field3647[0];
         var4.height = class287.field3782[0];
         int var5 = var4.width * var4.height;
         byte[] var6 = class274.spritePixels[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class287.field3783[var6[var7] & 255];
         }

         class287.field3781 = null;
         class211.offsetsY = null;
         class266.field3647 = null;
         class287.field3782 = null;
         class287.field3783 = null;
         class274.spritePixels = null;
         return var4;
      }
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method4469() {
      WorldMapType2.flush(false);
      Client.field991 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class15.field298.length; ++var1) {
         if(Ignore.field872[var1] != -1 && class15.field298[var1] == null) {
            class15.field298[var1] = class14.indexMaps.getConfigData(Ignore.field872[var1], 0);
            if(class15.field298[var1] == null) {
               var0 = false;
               ++Client.field991;
            }
         }

         if(class15.landRegionFielIds[var1] != -1 && class29.field431[var1] == null) {
            class29.field431[var1] = class14.indexMaps.getConfigData(class15.landRegionFielIds[var1], 0, Player.xteaKeys[var1]);
            if(class29.field431[var1] == null) {
               var0 = false;
               ++Client.field991;
            }
         }
      }

      if(!var0) {
         Client.field995 = 1;
      } else {
         Client.field981 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class15.field298.length; ++var1) {
            byte[] var2 = class29.field431[var1];
            if(var2 != null) {
               var3 = (class141.mapRegions[var1] >> 8) * 64 - class47.baseX;
               var4 = (class141.mapRegions[var1] & 255) * 64 - class44.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class27.method229(var2, var3, var4);
            }
         }

         if(!var0) {
            Client.field995 = 2;
         } else {
            if(Client.field995 != 0) {
               class88.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class182.method3458();
            class276.method4935();
            class182.method3458();
            class36.region.reset();
            class182.method3458();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].reset();
            }

            int var13;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var13 = 0; var13 < 104; ++var13) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class61.tileSettings[var1][var13][var3] = 0;
                  }
               }
            }

            class182.method3458();
            class61.field761 = 99;
            class61.underlayIds = new byte[4][104][104];
            class61.overlayIds = new byte[4][104][104];
            class61.overlayPaths = new byte[4][104][104];
            class61.overlayRotations = new byte[4][104][104];
            class240.field3259 = new int[4][105][105];
            class61.field784 = new byte[4][105][105];
            WorldMapType2.field530 = new int[105][105];
            class61.blendedHue = new int[104];
            WorldMapType1.blendedSaturation = new int[104];
            class31.field456 = new int[104];
            Huffman.field2325 = new int[104];
            class51.field661 = new int[104];
            var1 = class15.field298.length;
            class56.method869();
            WorldMapType2.flush(true);
            int var14;
            if(!Client.isDynamicRegion) {
               byte[] var5;
               for(var13 = 0; var13 < var1; ++var13) {
                  var3 = (class141.mapRegions[var13] >> 8) * 64 - class47.baseX;
                  var4 = (class141.mapRegions[var13] & 255) * 64 - class44.baseY;
                  var5 = class15.field298[var13];
                  if(var5 != null) {
                     class182.method3458();
                     class7.method32(var5, var3, var4, class13.field278 * 8 - 48, GroundObject.field1873 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var13 = 0; var13 < var1; ++var13) {
                  var3 = (class141.mapRegions[var13] >> 8) * 64 - class47.baseX;
                  var4 = (class141.mapRegions[var13] & 255) * 64 - class44.baseY;
                  var5 = class15.field298[var13];
                  if(var5 == null && GroundObject.field1873 < 800) {
                     class182.method3458();
                     class11.method54(var3, var4, 64, 64);
                  }
               }

               WorldMapType2.flush(true);

               for(var13 = 0; var13 < var1; ++var13) {
                  byte[] var15 = class29.field431[var13];
                  if(var15 != null) {
                     var4 = (class141.mapRegions[var13] >> 8) * 64 - class47.baseX;
                     var14 = (class141.mapRegions[var13] & 255) * 64 - class44.baseY;
                     class182.method3458();
                     Tile.method2521(var15, var4, var14, class36.region, Client.collisionMaps);
                  }
               }
            }

            int var6;
            int var7;
            int var8;
            if(Client.isDynamicRegion) {
               int var9;
               int var10;
               int var11;
               for(var13 = 0; var13 < 4; ++var13) {
                  class182.method3458();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var16 = false;
                        var6 = Client.field998[var13][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(int var12 = 0; var12 < class141.mapRegions.length; ++var12) {
                              if(class141.mapRegions[var12] == var11 && class15.field298[var12] != null) {
                                 class21.method169(class15.field298[var12], var13, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, Client.collisionMaps);
                                 var16 = true;
                                 break;
                              }
                           }
                        }

                        if(!var16) {
                           class83.method1624(var13, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var13 = 0; var13 < 13; ++var13) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field998[0][var13][var3];
                     if(var4 == -1) {
                        class11.method54(var13 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               WorldMapType2.flush(true);

               for(var13 = 0; var13 < 4; ++var13) {
                  class182.method3458();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var14 = Client.field998[var13][var3][var4];
                        if(var14 != -1) {
                           var6 = var14 >> 24 & 3;
                           var7 = var14 >> 1 & 3;
                           var8 = var14 >> 14 & 1023;
                           var9 = var14 >> 3 & 2047;
                           var10 = (var8 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class141.mapRegions.length; ++var11) {
                              if(class141.mapRegions[var11] == var10 && class29.field431[var11] != null) {
                                 class2.method3(class29.field431[var11], var13, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, class36.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            WorldMapType2.flush(true);
            class276.method4935();
            class182.method3458();
            PendingSpawn.method1523(class36.region, Client.collisionMaps);
            WorldMapType2.flush(true);
            var13 = class61.field761;
            if(var13 > class35.plane) {
               var13 = class35.plane;
            }

            if(var13 < class35.plane - 1) {
               var13 = class35.plane - 1;
            }

            if(Client.lowMemory) {
               class36.region.setup(class61.field761);
            } else {
               class36.region.setup(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class209.groundItemSpawned(var3, var4);
               }
            }

            class182.method3458();
            class39.method562();
            ObjectComposition.field3476.reset();
            if(class27.clientInstance.method993()) {
               Client.secretPacketBuffer1.putOpcode(86);
               Client.secretPacketBuffer1.putInt(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var3 = (class13.field278 - 6) / 8;
               var4 = (class13.field278 + 6) / 8;
               var14 = (GroundObject.field1873 - 6) / 8;
               var6 = (GroundObject.field1873 + 6) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var8 = var14 - 1; var8 <= var6 + 1; ++var8) {
                     if(var7 < var3 || var7 > var4 || var8 < var14 || var8 > var6) {
                        class14.indexMaps.method4135("m" + var7 + "_" + var8);
                        class14.indexMaps.method4135("l" + var7 + "_" + var8);
                     }
                  }
               }
            }

            MouseInput.setGameState(30);
            class182.method3458();
            class90.method1722();
            Client.secretPacketBuffer1.putOpcode(11);
            GameEngine.timer.vmethod3010();

            for(var3 = 0; var3 < 32; ++var3) {
               GameEngine.field700[var3] = 0L;
            }

            for(var3 = 0; var3 < 32; ++var3) {
               GameEngine.field701[var3] = 0L;
            }

            GameEngine.field695 = 0;
         }
      }
   }
}
