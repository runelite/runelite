import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class178 {
   @ObfuscatedName("f")
   static final class178 field2680 = new class178("RC", 1);
   @ObfuscatedName("s")
   static final class178 field2681 = new class178("LIVE", 0);
   @ObfuscatedName("h")
   static final class178 field2682 = new class178("WIP", 2);
   @ObfuscatedName("c")
   static final class178 field2683 = new class178("BUILDLIVE", 3);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 220561587
   )
   final int field2684;
   @ObfuscatedName("a")
   public final String field2685;
   @ObfuscatedName("bg")
   @Export("host")
   static String host;

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2136069825"
   )
   static final void method3165() {
      class212.method3826(false);
      Client.field348 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class137.field1918.length; ++var1) {
         if(class112.field1769[var1] != -1 && class137.field1918[var1] == null) {
            class137.field1918[var1] = class1.field16.method3182(class112.field1769[var1], 0);
            if(null == class137.field1918[var1]) {
               var0 = false;
               ++Client.field348;
            }
         }

         if(RSCanvas.field1759[var1] != -1 && null == FileOnDisk.field1194[var1]) {
            FileOnDisk.field1194[var1] = class1.field16.method3183(RSCanvas.field1759[var1], 0, class49.xteaKeys[var1]);
            if(null == FileOnDisk.field1194[var1]) {
               var0 = false;
               ++Client.field348;
            }
         }
      }

      if(!var0) {
         Client.field528 = 1;
      } else {
         Client.field350 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class137.field1918.length; ++var1) {
            byte[] var23 = FileOnDisk.field1194[var1];
            if(var23 != null) {
               var3 = 64 * (class143.mapRegions[var1] >> 8) - class22.baseX;
               var4 = 64 * (class143.mapRegions[var1] & 255) - class103.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class38.method720(var23, var3, var4);
            }
         }

         if(!var0) {
            Client.field528 = 2;
         } else {
            if(Client.field528 != 0) {
               class36.method714("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            ChatMessages.method830();
            class156.method2929();
            ChatMessages.method830();
            class0.region.method1658();
            ChatMessages.method830();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2179();
            }

            int var2;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var2 = 0; var2 < 104; ++var2) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class10.tileSettings[var1][var2][var3] = 0;
                  }
               }
            }

            ChatMessages.method830();
            XGrandExchangeOffer.method60();
            var1 = class137.field1918.length;
            class9.method96();
            class212.method3826(true);
            int var5;
            int var6;
            int var7;
            int var10;
            int var11;
            int var12;
            int var24;
            if(!Client.isDynamicRegion) {
               byte[] var26;
               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = 64 * (class143.mapRegions[var2] >> 8) - class22.baseX;
                  var4 = 64 * (class143.mapRegions[var2] & 255) - class103.baseY;
                  var26 = class137.field1918[var2];
                  if(null != var26) {
                     ChatMessages.method830();
                     var6 = GroundObject.field1301 * 8 - 48;
                     var7 = WidgetNode.field200 * 8 - 48;
                     CollisionData[] var25 = Client.collisionMaps;

                     for(var24 = 0; var24 < 4; ++var24) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var3 + var10 > 0 && var3 + var10 < 103 && var11 + var4 > 0 && var4 + var11 < 103) {
                                 var25[var24].flags[var3 + var10][var4 + var11] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var9 = new Buffer(var26);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var12 = 0; var12 < 64; ++var12) {
                              class137.method2398(var9, var10, var3 + var11, var12 + var4, var6, var7, 0);
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = (class143.mapRegions[var2] >> 8) * 64 - class22.baseX;
                  var4 = (class143.mapRegions[var2] & 255) * 64 - class103.baseY;
                  var26 = class137.field1918[var2];
                  if(var26 == null && WidgetNode.field200 < 800) {
                     ChatMessages.method830();
                     class45.method792(var3, var4, 64, 64);
                  }
               }

               class212.method3826(true);

               for(var2 = 0; var2 < var1; ++var2) {
                  byte[] var27 = FileOnDisk.field1194[var2];
                  if(var27 != null) {
                     var4 = (class143.mapRegions[var2] >> 8) * 64 - class22.baseX;
                     var5 = 64 * (class143.mapRegions[var2] & 255) - class103.baseY;
                     ChatMessages.method830();
                     Region var28 = class0.region;
                     CollisionData[] var29 = Client.collisionMaps;
                     Buffer var31 = new Buffer(var27);
                     var24 = -1;

                     while(true) {
                        var10 = var31.method2735();
                        if(var10 == 0) {
                           break;
                        }

                        var24 += var10;
                        var11 = 0;

                        while(true) {
                           var12 = var31.method2735();
                           if(var12 == 0) {
                              break;
                           }

                           var11 += var12 - 1;
                           int var13 = var11 & 63;
                           int var14 = var11 >> 6 & 63;
                           int var15 = var11 >> 12;
                           int var16 = var31.readUnsignedByte();
                           int var17 = var16 >> 2;
                           int var18 = var16 & 3;
                           int var19 = var14 + var4;
                           int var20 = var13 + var5;
                           if(var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
                              int var21 = var15;
                              if((class10.tileSettings[1][var19][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var22 = null;
                              if(var21 >= 0) {
                                 var22 = var29[var21];
                              }

                              class63.method1105(var15, var19, var20, var24, var18, var17, var28, var22);
                           }
                        }
                     }
                  }
               }
            }

            int var8;
            if(Client.isDynamicRegion) {
               for(var2 = 0; var2 < 4; ++var2) {
                  ChatMessages.method830();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var30 = false;
                        var6 = Client.field548[var2][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var24 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var24 / 8 << 8);

                           for(var12 = 0; var12 < class143.mapRegions.length; ++var12) {
                              if(class143.mapRegions[var12] == var11 && class137.field1918[var12] != null) {
                                 class159.method2981(class137.field1918[var12], var2, var3 * 8, 8 * var4, var7, (var24 & 7) * 8, (var10 & 7) * 8, var8, Client.collisionMaps);
                                 var30 = true;
                                 break;
                              }
                           }
                        }

                        if(!var30) {
                           var7 = var2;
                           var8 = 8 * var3;
                           var24 = 8 * var4;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class10.tileHeights[var7][var10 + var8][var11 + var24] = 0;
                              }
                           }

                           if(var8 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class10.tileHeights[var7][var8][var24 + var10] = class10.tileHeights[var7][var8 - 1][var24 + var10];
                              }
                           }

                           if(var24 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class10.tileHeights[var7][var10 + var8][var24] = class10.tileHeights[var7][var10 + var8][var24 - 1];
                              }
                           }

                           if(var8 > 0 && class10.tileHeights[var7][var8 - 1][var24] != 0) {
                              class10.tileHeights[var7][var8][var24] = class10.tileHeights[var7][var8 - 1][var24];
                           } else if(var24 > 0 && class10.tileHeights[var7][var8][var24 - 1] != 0) {
                              class10.tileHeights[var7][var8][var24] = class10.tileHeights[var7][var8][var24 - 1];
                           } else if(var8 > 0 && var24 > 0 && class10.tileHeights[var7][var8 - 1][var24 - 1] != 0) {
                              class10.tileHeights[var7][var8][var24] = class10.tileHeights[var7][var8 - 1][var24 - 1];
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < 13; ++var2) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field548[0][var2][var3];
                     if(var4 == -1) {
                        class45.method792(8 * var2, var3 * 8, 8, 8);
                     }
                  }
               }

               class212.method3826(true);

               for(var2 = 0; var2 < 4; ++var2) {
                  ChatMessages.method830();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field548[var2][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var7 = var5 >> 1 & 3;
                           var8 = var5 >> 14 & 1023;
                           var24 = var5 >> 3 & 2047;
                           var10 = (var8 / 8 << 8) + var24 / 8;

                           for(var11 = 0; var11 < class143.mapRegions.length; ++var11) {
                              if(class143.mapRegions[var11] == var10 && FileOnDisk.field1194[var11] != null) {
                                 GameEngine.method2128(FileOnDisk.field1194[var11], var2, var3 * 8, var4 * 8, var6, 8 * (var8 & 7), 8 * (var24 & 7), var7, class0.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            class212.method3826(true);
            class156.method2929();
            ChatMessages.method830();
            class138.method2412(class0.region, Client.collisionMaps);
            class212.method3826(true);
            var2 = class10.field91;
            if(var2 > class118.plane) {
               var2 = class118.plane;
            }

            if(var2 < class118.plane - 1) {
               var2 = class118.plane - 1;
            }

            if(Client.field299) {
               class0.region.method1659(class10.field91);
            } else {
               class0.region.method1659(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  ItemComposition.groundItemSpawned(var3, var4);
               }
            }

            ChatMessages.method830();
            class1.method10();
            ObjectComposition.field2902.reset();
            if(class118.field1855 != null) {
               Client.field336.method2963(56);
               Client.field336.method2711(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var3 = (GroundObject.field1301 - 6) / 8;
               var4 = (GroundObject.field1301 + 6) / 8;
               var5 = (WidgetNode.field200 - 6) / 8;
               var6 = (6 + WidgetNode.field200) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var8 = var5 - 1; var8 <= 1 + var6; ++var8) {
                     if(var7 < var3 || var7 > var4 || var8 < var5 || var8 > var6) {
                        class1.field16.method3179("m" + var7 + "_" + var8);
                        class1.field16.method3179("l" + var7 + "_" + var8);
                     }
                  }
               }
            }

            class103.setGameState(30);
            ChatMessages.method830();
            ChatLineBuffer.underlayIds = null;
            class10.overlayIds = null;
            class20.overlayPaths = null;
            class10.overlayRotations = null;
            class161.field2152 = null;
            class162.field2157 = null;
            class10.field93 = null;
            class16.field184 = null;
            class11.field116 = null;
            class37.field784 = null;
            class10.field97 = null;
            class170.field2349 = null;
            Client.field336.method2963(179);
            class101.field1654.vmethod1992();

            for(var3 = 0; var3 < 32; ++var3) {
               GameEngine.field1778[var3] = 0L;
            }

            for(var3 = 0; var3 < 32; ++var3) {
               GameEngine.field1779[var3] = 0L;
            }

            class45.field895 = 0;
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class178(String var1, int var2) {
      this.field2685 = var1;
      this.field2684 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "46"
   )
   static final String method3169(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}
