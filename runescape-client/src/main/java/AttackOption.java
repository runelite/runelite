import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "[Lkl;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 579794535
   )
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1940611593"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Lia;",
      garbageValue = "0"
   )
   public static InvType method1777(int var0) {
      InvType var1 = (InvType)InvType.inventoryCache.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvType.field3355.getConfigData(5, var0);
         var1 = new InvType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvType.inventoryCache.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-78"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = MouseInput.getSmoothNoise2D(var3, var5);
      int var8 = MouseInput.getSmoothNoise2D(var3 + 1, var5);
      int var9 = MouseInput.getSmoothNoise2D(var3, var5 + 1);
      int var10 = MouseInput.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
      return var15;
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1116414632"
   )
   static final void method1773() {
      Client.flush(false);
      Client.field921 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class29.field400.length; ++var1) {
         if(class230.landMapFileIds[var1] != -1 && class29.field400[var1] == null) {
            class29.field400[var1] = PlayerComposition.indexMaps.getConfigData(class230.landMapFileIds[var1], 0);
            if(class29.field400[var1] == null) {
               var0 = false;
               ++Client.field921;
            }
         }

         if(GrandExchangeOffer.landRegionFileIds[var1] != -1 && class250.field3386[var1] == null) {
            class250.field3386[var1] = PlayerComposition.indexMaps.getConfigData(GrandExchangeOffer.landRegionFileIds[var1], 0, ScriptEvent.xteaKeys[var1]);
            if(class250.field3386[var1] == null) {
               var0 = false;
               ++Client.field921;
            }
         }
      }

      if(!var0) {
         Client.field955 = 1;
      } else {
         Client.field923 = 0;
         var0 = true;

         int var3;
         int var4;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         int var49;
         int var50;
         for(var1 = 0; var1 < class29.field400.length; ++var1) {
            byte[] var2 = class250.field3386[var1];
            if(var2 != null) {
               var3 = (VertexNormal.mapRegions[var1] >> 8) * 64 - IndexDataBase.baseX;
               var4 = (VertexNormal.mapRegions[var1] & 255) * 64 - Occluder.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               Buffer var8 = new Buffer(var2);
               var9 = -1;

               label1351:
               while(true) {
                  var10 = var8.getUSmart();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.getUSmart();
                        if(var13 == 0) {
                           continue label1351;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var49 = var15 + var3;
                        var50 = var4 + var14;
                        if(var49 > 0 && var50 > 0 && var49 < 103 && var50 < 103) {
                           ObjectComposition var19 = class3.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.lowMemory || var19.int1 != 0 || var19.interactType == 1 || var19.boolean2) {
                              if(!var19.method4729()) {
                                 ++Client.field923;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.getUSmart();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field955 = 2;
         } else {
            if(Client.field955 != 0) {
               UrlRequester.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class25.method190();
            class235.method4236();
            class25.method190();
            GrandExchangeEvent.region.reset();
            class25.method190();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].reset();
            }

            int var44;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var44 = 0; var44 < 104; ++var44) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class61.tileSettings[var1][var44][var3] = 0;
                  }
               }
            }

            class25.method190();
            class34.method500();
            var1 = class29.field400.length;
            FriendLoginUpdate.method1113();
            Client.flush(true);
            int var5;
            if(!Client.isDynamicRegion) {
               byte[] var45;
               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (VertexNormal.mapRegions[var44] >> 8) * 64 - IndexDataBase.baseX;
                  var4 = (VertexNormal.mapRegions[var44] & 255) * 64 - Occluder.baseY;
                  var45 = class29.field400[var44];
                  if(var45 != null) {
                     class25.method190();
                     PendingSpawn.method1572(var45, var3, var4, class44.field554 * 8 - 48, class156.field2159 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (VertexNormal.mapRegions[var44] >> 8) * 64 - IndexDataBase.baseX;
                  var4 = (VertexNormal.mapRegions[var44] & 255) * 64 - Occluder.baseY;
                  var45 = class29.field400[var44];
                  if(var45 == null && class156.field2159 < 800) {
                     class25.method190();
                     ScriptVarType.method27(var3, var4, 64, 64);
                  }
               }

               Client.flush(true);

               for(var44 = 0; var44 < var1; ++var44) {
                  byte[] var47 = class250.field3386[var44];
                  if(var47 != null) {
                     var4 = (VertexNormal.mapRegions[var44] >> 8) * 64 - IndexDataBase.baseX;
                     var5 = (VertexNormal.mapRegions[var44] & 255) * 64 - Occluder.baseY;
                     class25.method190();
                     GameEngine.method1006(var47, var4, var5, GrandExchangeEvent.region, Client.collisionMaps);
                  }
               }
            }

            int var6;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var38;
            int var39;
            int var40;
            int var46;
            int var57;
            int var58;
            if(Client.isDynamicRegion) {
               for(var44 = 0; var44 < 4; ++var44) {
                  class25.method190();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var56 = false;
                        var6 = Client.field928[var44][var3][var4];
                        if(var6 != -1) {
                           var57 = var6 >> 24 & 3;
                           var46 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var58 = 0; var58 < VertexNormal.mapRegions.length; ++var58) {
                              if(VertexNormal.mapRegions[var58] == var11 && class29.field400[var58] != null) {
                                 class221.method4154(class29.field400[var58], var44, var3 * 8, var4 * 8, var57, (var9 & 7) * 8, (var10 & 7) * 8, var46, Client.collisionMaps);
                                 var56 = true;
                                 break;
                              }
                           }
                        }

                        if(!var56) {
                           class250.method4474(var44, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var44 = 0; var44 < 13; ++var44) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field928[0][var44][var3];
                     if(var4 == -1) {
                        ScriptVarType.method27(var44 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               Client.flush(true);

               for(var44 = 0; var44 < 4; ++var44) {
                  class25.method190();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1226:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field928[var44][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var57 = var5 >> 1 & 3;
                           var46 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var46 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < VertexNormal.mapRegions.length; ++var11) {
                              if(VertexNormal.mapRegions[var11] == var10 && class250.field3386[var11] != null) {
                                 byte[] var48 = class250.field3386[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = (var46 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Region var17 = GrandExchangeEvent.region;
                                 CollisionData[] var18 = Client.collisionMaps;
                                 Buffer var61 = new Buffer(var48);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var61.getUSmart();
                                    if(var21 == 0) {
                                       continue label1226;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       var23 = var61.getUSmart();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       var24 = var22 & 63;
                                       var25 = var22 >> 6 & 63;
                                       var26 = var22 >> 12;
                                       var27 = var61.readUnsignedByte();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var30 = class3.getObjectDefinition(var20);
                                          var33 = var25 & 7;
                                          var34 = var24 & 7;
                                          var36 = var30.sizeX;
                                          int var37 = var30.sizeY;
                                          if((var29 & 1) == 1) {
                                             var38 = var36;
                                             var36 = var37;
                                             var37 = var38;
                                          }

                                          var35 = var57 & 3;
                                          if(var35 == 0) {
                                             var32 = var33;
                                          } else if(var35 == 1) {
                                             var32 = var34;
                                          } else if(var35 == 2) {
                                             var32 = 7 - var33 - (var36 - 1);
                                          } else {
                                             var32 = 7 - var34 - (var37 - 1);
                                          }

                                          var38 = var32 + var13;
                                          var39 = var14 + class111.method2195(var25 & 7, var24 & 7, var57, var30.sizeX, var30.sizeY, var29);
                                          if(var38 > 0 && var39 > 0 && var38 < 103 && var39 < 103) {
                                             var40 = var44;
                                             if((class61.tileSettings[1][var38][var39] & 2) == 2) {
                                                var40 = var44 - 1;
                                             }

                                             CollisionData var41 = null;
                                             if(var40 >= 0) {
                                                var41 = var18[var40];
                                             }

                                             FriendLoginUpdate.addObject(var44, var38, var39, var20, var29 + var57 & 3, var28, var17, var41);
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
            }

            Client.flush(true);
            class235.method4236();
            class25.method190();
            Region var55 = GrandExchangeEvent.region;
            CollisionData[] var68 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class61.tileSettings[var4][var5][var6] & 1) == 1) {
                        var57 = var4;
                        if((class61.tileSettings[1][var5][var6] & 2) == 2) {
                           var57 = var4 - 1;
                        }

                        if(var57 >= 0) {
                           var68[var57].method3158(var5, var6);
                        }
                     }
                  }
               }
            }

            class61.field734 += (int)(Math.random() * 5.0D) - 2;
            if(class61.field734 < -8) {
               class61.field734 = -8;
            }

            if(class61.field734 > 8) {
               class61.field734 = 8;
            }

            class61.field725 += (int)(Math.random() * 5.0D) - 2;
            if(class61.field725 < -16) {
               class61.field725 = -16;
            }

            if(class61.field725 > 16) {
               class61.field725 = 16;
            }

            int var51;
            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var65 = ScriptState.field745[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var58 = var11 * 768 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class61.tileHeights[var4][var14 + 1][var13] - class61.tileHeights[var4][var14 - 1][var13];
                     var16 = class61.tileHeights[var4][var14][var13 + 1] - class61.tileHeights[var4][var14][var13 - 1];
                     var49 = (int)Math.sqrt((double)(var15 * var15 + var16 * var16 + 65536));
                     var50 = (var15 << 8) / var49;
                     var51 = 65536 / var49;
                     var20 = (var16 << 8) / var49;
                     var21 = (var50 * -50 + var20 * -50 + var51 * -10) / var58 + 96;
                     var22 = (var65[var14 - 1][var13] >> 2) + (var65[var14][var13 - 1] >> 2) + (var65[var14 + 1][var13] >> 3) + (var65[var14][var13 + 1] >> 3) + (var65[var14][var13] >> 1);
                     class61.field727[var14][var13] = var21 - var22;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  TotalQuantityComparator.field287[var13] = 0;
                  class43.field545[var13] = 0;
                  GrandExchangeOffer.field300[var13] = 0;
                  Permission.field3260[var13] = 0;
                  Frames.field2044[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var13 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class61.field724[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           FloorUnderlayDefinition var59 = ScriptState.getUnderlayDefinition(var16 - 1);
                           TotalQuantityComparator.field287[var14] += var59.hue;
                           class43.field545[var14] += var59.saturation;
                           GrandExchangeOffer.field300[var14] += var59.lightness;
                           Permission.field3260[var14] += var59.hueMultiplier;
                           ++Frames.field2044[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var49 = class61.field724[var4][var16][var14] & 255;
                        if(var49 > 0) {
                           FloorUnderlayDefinition var60 = ScriptState.getUnderlayDefinition(var49 - 1);
                           TotalQuantityComparator.field287[var14] -= var60.hue;
                           class43.field545[var14] -= var60.saturation;
                           GrandExchangeOffer.field300[var14] -= var60.lightness;
                           Permission.field3260[var14] -= var60.hueMultiplier;
                           --Frames.field2044[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var49 = 0;
                     var50 = 0;

                     for(var51 = -5; var51 < 109; ++var51) {
                        var20 = var51 + 5;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += TotalQuantityComparator.field287[var20];
                           var15 += class43.field545[var20];
                           var16 += GrandExchangeOffer.field300[var20];
                           var49 += Permission.field3260[var20];
                           var50 += Frames.field2044[var20];
                        }

                        var21 = var51 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= TotalQuantityComparator.field287[var21];
                           var15 -= class43.field545[var21];
                           var16 -= GrandExchangeOffer.field300[var21];
                           var49 -= Permission.field3260[var21];
                           var50 -= Frames.field2044[var21];
                        }

                        if(var51 >= 1 && var51 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var13][var51] & 2) != 0 || (class61.tileSettings[var4][var13][var51] & 16) == 0)) {
                           if(var4 < class61.field735) {
                              class61.field735 = var4;
                           }

                           var22 = class61.field724[var4][var13][var51] & 255;
                           var23 = class61.field736[var4][var13][var51] & 255;
                           if(var22 > 0 || var23 > 0) {
                              var24 = class61.tileHeights[var4][var13][var51];
                              var25 = class61.tileHeights[var4][var13 + 1][var51];
                              var26 = class61.tileHeights[var4][var13 + 1][var51 + 1];
                              var27 = class61.tileHeights[var4][var13][var51 + 1];
                              var28 = class61.field727[var13][var51];
                              var29 = class61.field727[var13 + 1][var51];
                              int var52 = class61.field727[var13 + 1][var51 + 1];
                              int var31 = class61.field727[var13][var51 + 1];
                              var32 = -1;
                              var33 = -1;
                              if(var22 > 0) {
                                 var34 = var14 * 256 / var49;
                                 var35 = var15 / var50;
                                 var36 = var16 / var50;
                                 var32 = ChatLineBuffer.method1923(var34, var35, var36);
                                 var34 = var34 + class61.field734 & 255;
                                 var36 += class61.field725;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = ChatLineBuffer.method1923(var34, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var63 = true;
                                 if(var22 == 0 && class36.field481[var4][var13][var51] != 0) {
                                    var63 = false;
                                 }

                                 if(var23 > 0 && !class41.getOverlayDefinition(var23 - 1).isHidden) {
                                    var63 = false;
                                 }

                                 if(var63 && var25 == var24 && var24 == var26 && var24 == var27) {
                                    BoundingBox3D.field242[var4][var13][var51] |= 2340;
                                 }
                              }

                              var34 = 0;
                              if(var33 != -1) {
                                 var34 = Graphics3D.colorPalette[CombatInfo1.method1592(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var55.addTile(var4, var13, var51, 0, 0, -1, var24, var25, var26, var27, CombatInfo1.method1592(var32, var28), CombatInfo1.method1592(var32, var29), CombatInfo1.method1592(var32, var52), CombatInfo1.method1592(var32, var31), 0, 0, 0, 0, var34, 0);
                              } else {
                                 var35 = class36.field481[var4][var13][var51] + 1;
                                 byte var64 = class61.field726[var4][var13][var51];
                                 Overlay var53 = class41.getOverlayDefinition(var23 - 1);
                                 var38 = var53.texture;
                                 int var42;
                                 int var54;
                                 if(var38 >= 0) {
                                    var40 = Graphics3D.textureLoader.getAverageTextureRGB(var38);
                                    var39 = -1;
                                 } else if(var53.color == 16711935) {
                                    var39 = -2;
                                    var38 = -1;
                                    var40 = -2;
                                 } else {
                                    var39 = ChatLineBuffer.method1923(var53.hue, var53.saturation, var53.lightness);
                                    var54 = var53.hue + class61.field734 & 255;
                                    var42 = var53.lightness + class61.field725;
                                    if(var42 < 0) {
                                       var42 = 0;
                                    } else if(var42 > 255) {
                                       var42 = 255;
                                    }

                                    var40 = ChatLineBuffer.method1923(var54, var53.saturation, var42);
                                 }

                                 var54 = 0;
                                 if(var40 != -2) {
                                    var54 = Graphics3D.colorPalette[class82.adjustHSLListness0(var40, 96)];
                                 }

                                 if(var53.otherRgbColor != -1) {
                                    var42 = var53.otherHue + class61.field734 & 255;
                                    int var43 = var53.otherLightness + class61.field725;
                                    if(var43 < 0) {
                                       var43 = 0;
                                    } else if(var43 > 255) {
                                       var43 = 255;
                                    }

                                    var40 = ChatLineBuffer.method1923(var42, var53.otherSaturation, var43);
                                    var54 = Graphics3D.colorPalette[class82.adjustHSLListness0(var40, 96)];
                                 }

                                 var55.addTile(var4, var13, var51, var35, var64, var38, var24, var25, var26, var27, CombatInfo1.method1592(var32, var28), CombatInfo1.method1592(var32, var29), CombatInfo1.method1592(var32, var52), CombatInfo1.method1592(var32, var31), class82.adjustHSLListness0(var39, var28), class82.adjustHSLListness0(var39, var29), class82.adjustHSLListness0(var39, var52), class82.adjustHSLListness0(var39, var31), var34, var54);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var55.setPhysicalLevel(var4, var14, var13, BoundingBox3D.method60(var4, var14, var13));
                  }
               }

               class61.field724[var4] = null;
               class61.field736[var4] = null;
               class36.field481[var4] = null;
               class61.field726[var4] = null;
               ScriptState.field745[var4] = null;
            }

            var55.applyLighting(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class61.tileSettings[1][var4][var5] & 2) == 2) {
                     var55.setBridge(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var57 = 0; var57 < 4; ++var57) {
               if(var57 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var46 = 0; var46 <= var57; ++var46) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var62;
                        if((BoundingBox3D.field242[var46][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var58 = var9;
                           var13 = var46;

                           for(var14 = var46; var11 > 0 && (BoundingBox3D.field242[var46][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var58 < 104 && (BoundingBox3D.field242[var46][var10][var58 + 1] & var4) != 0) {
                              ++var58;
                           }

                           label961:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var58; ++var15) {
                                 if((BoundingBox3D.field242[var13 - 1][var10][var15] & var4) == 0) {
                                    break label961;
                                 }
                              }

                              --var13;
                           }

                           label950:
                           while(var14 < var57) {
                              for(var15 = var11; var15 <= var58; ++var15) {
                                 if((BoundingBox3D.field242[var14 + 1][var10][var15] & var4) == 0) {
                                    break label950;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var14 + 1 - var13) * (var58 - var11 + 1);
                           if(var15 >= 8) {
                              var62 = 240;
                              var49 = class61.tileHeights[var14][var10][var11] - var62;
                              var50 = class61.tileHeights[var13][var10][var11];
                              Region.addOcclude(var57, 1, var10 * 128, var10 * 128, var11 * 128, var58 * 128 + 128, var49, var50);

                              for(var51 = var13; var51 <= var14; ++var51) {
                                 for(var20 = var11; var20 <= var58; ++var20) {
                                    BoundingBox3D.field242[var51][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((BoundingBox3D.field242[var46][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var58 = var10;
                           var13 = var46;

                           for(var14 = var46; var11 > 0 && (BoundingBox3D.field242[var46][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var58 < 104 && (BoundingBox3D.field242[var46][var58 + 1][var9] & var5) != 0) {
                              ++var58;
                           }

                           label1014:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var58; ++var15) {
                                 if((BoundingBox3D.field242[var13 - 1][var15][var9] & var5) == 0) {
                                    break label1014;
                                 }
                              }

                              --var13;
                           }

                           label1003:
                           while(var14 < var57) {
                              for(var15 = var11; var15 <= var58; ++var15) {
                                 if((BoundingBox3D.field242[var14 + 1][var15][var9] & var5) == 0) {
                                    break label1003;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var58 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var62 = 240;
                              var49 = class61.tileHeights[var14][var11][var9] - var62;
                              var50 = class61.tileHeights[var13][var11][var9];
                              Region.addOcclude(var57, 2, var11 * 128, var58 * 128 + 128, var9 * 128, var9 * 128, var49, var50);

                              for(var51 = var13; var51 <= var14; ++var51) {
                                 for(var20 = var11; var20 <= var58; ++var20) {
                                    BoundingBox3D.field242[var51][var20][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((BoundingBox3D.field242[var46][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var58 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (BoundingBox3D.field242[var46][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (BoundingBox3D.field242[var46][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label1067:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((BoundingBox3D.field242[var46][var11 - 1][var15] & var6) == 0) {
                                    break label1067;
                                 }
                              }

                              --var11;
                           }

                           label1056:
                           while(var58 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((BoundingBox3D.field242[var46][var58 + 1][var15] & var6) == 0) {
                                    break label1056;
                                 }
                              }

                              ++var58;
                           }

                           if((var58 - var11 + 1) * (var14 - var13 + 1) >= 4) {
                              var15 = class61.tileHeights[var46][var11][var13];
                              Region.addOcclude(var57, 4, var11 * 128, var58 * 128 + 128, var13 * 128, var14 * 128 + 128, var15, var15);

                              for(var16 = var11; var16 <= var58; ++var16) {
                                 for(var49 = var13; var49 <= var14; ++var49) {
                                    BoundingBox3D.field242[var46][var16][var49] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            Client.flush(true);
            var4 = class61.field735;
            if(var4 > class233.plane) {
               var4 = class233.plane;
            }

            if(var4 < class233.plane - 1) {
               var4 = class233.plane - 1;
            }

            if(Client.lowMemory) {
               GrandExchangeEvent.region.setup(class61.field735);
            } else {
               GrandExchangeEvent.region.setup(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class139.groundItemSpawned(var5, var6);
               }
            }

            class25.method190();

            for(PendingSpawn var66 = (PendingSpawn)Client.pendingSpawns.getFront(); var66 != null; var66 = (PendingSpawn)Client.pendingSpawns.getNext()) {
               if(var66.hitpoints == -1) {
                  var66.delay = 0;
                  BaseVarType.method18(var66);
               } else {
                  var66.unlink();
               }
            }

            ObjectComposition.field3502.reset();
            PacketNode var67;
            if(Bounds.clientInstance.method884()) {
               var67 = class218.method4105(ClientPacket.field2384, Client.field916.field1470);
               var67.packetBuffer.putInt(1057001181);
               Client.field916.method1925(var67);
            }

            if(!Client.isDynamicRegion) {
               var5 = (class44.field554 - 6) / 8;
               var6 = (class44.field554 + 6) / 8;
               var57 = (class156.field2159 - 6) / 8;
               var46 = (class156.field2159 + 6) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var57 - 1; var10 <= var46 + 1; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var57 || var10 > var46) {
                        PlayerComposition.indexMaps.method4287("m" + var9 + "_" + var10);
                        PlayerComposition.indexMaps.method4287("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            WorldComparator.setGameState(30);
            class25.method190();
            KeyFocusListener.method765();
            var67 = class218.method4105(ClientPacket.field2318, Client.field916.field1470);
            Client.field916.method1925(var67);
            CombatInfoListHolder.timer.vmethod3107();

            for(var6 = 0; var6 < 32; ++var6) {
               GameEngine.field667[var6] = 0L;
            }

            for(var6 = 0; var6 < 32; ++var6) {
               GameEngine.field668[var6] = 0L;
            }

            GameEngine.field681 = 0;
         }
      }
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Lhx;III)V",
      garbageValue = "136297121"
   )
   static final void method1767(Widget var0, int var1, int var2) {
      if(Client.field1027 == null && !Client.isMenuOpen) {
         if(var0 != null && SoundTaskDataProvider.method781(var0) != null) {
            Client.field1027 = var0;
            Client.field1028 = SoundTaskDataProvider.method781(var0);
            Client.field1029 = var1;
            Client.field953 = var2;
            class37.field488 = 0;
            Client.field1014 = false;
            int var3 = Client.menuOptionCount - 1;
            if(var3 != -1) {
               FontName.topContextMenuRow = new ContextMenuRow();
               FontName.topContextMenuRow.param0 = Client.menuActionParams0[var3];
               FontName.topContextMenuRow.param1 = Client.menuActionParams1[var3];
               FontName.topContextMenuRow.type = Client.menuTypes[var3];
               FontName.topContextMenuRow.identifier = Client.menuIdentifiers[var3];
               FontName.topContextMenuRow.option = Client.menuOptions[var3];
            }

         }
      }
   }

   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "(Lfr;S)V",
      garbageValue = "671"
   )
   static void method1776(Buffer var0) {
      if(Client.field1083 != null) {
         var0.putBytes(Client.field1083, 0, Client.field1083.length);
      } else {
         byte[] var1 = ClanMember.method1189();
         var0.putBytes(var1, 0, var1.length);
      }
   }
}
