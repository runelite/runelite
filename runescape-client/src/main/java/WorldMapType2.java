import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("ae")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1262344403
   )
   int field536;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 778738125
   )
   int field537;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 774198755
   )
   int field543;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1171584329
   )
   int field539;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1380009489
   )
   int field540;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 266401761
   )
   int field538;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lat;I)V",
      garbageValue = "1123585680"
   )
   public void vmethod720(WorldMapData var1) {
      if(var1.field464 > this.field540) {
         var1.field464 = this.field540;
      }

      if(var1.field468 < this.field540) {
         var1.field468 = this.field540;
      }

      if(var1.field469 > this.field538) {
         var1.field469 = this.field538;
      }

      if(var1.field461 < this.field538) {
         var1.field461 = this.field538;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2147483647"
   )
   public boolean vmethod699(int var1, int var2, int var3) {
      return var1 >= this.field536 && var1 < this.field537 + this.field536?var2 >> 6 == this.field543 && var3 >> 6 == this.field539:false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2005574810"
   )
   public boolean vmethod700(int var1, int var2) {
      return var1 >> 6 == this.field540 && var2 >> 6 == this.field538;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "880778915"
   )
   public int[] vmethod709(int var1, int var2, int var3) {
      if(!this.vmethod699(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field540 * 64 - this.field543 * 64 + var2, var3 + (this.field538 * 64 - this.field539 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhg;",
      garbageValue = "-1413226110"
   )
   public Coordinates vmethod702(int var1, int var2) {
      if(!this.vmethod700(var1, var2)) {
         return null;
      } else {
         int var3 = this.field543 * 64 - this.field540 * 64 + var1;
         int var4 = this.field539 * 64 - this.field538 * 64 + var2;
         return new Coordinates(this.field536, var3, var4);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfz;B)V",
      garbageValue = "15"
   )
   public void vmethod703(Buffer var1) {
      this.field536 = var1.readUnsignedByte();
      this.field537 = var1.readUnsignedByte();
      this.field543 = var1.readUnsignedShort();
      this.field539 = var1.readUnsignedShort();
      this.field540 = var1.readUnsignedShort();
      this.field538 = var1.readUnsignedShort();
      this.method501();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-50"
   )
   void method501() {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "13"
   )
   public static String method520(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = 65533;
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = 65533;
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = 65533;
               } else {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else {
            var8 = 65533;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1105349715"
   )
   static final void method521() {
      Overlay.overlays.reset();
      FloorUnderlayDefinition.underlays.reset();
      AbstractByteBuffer.method3472();
      ObjectComposition.objects.reset();
      ObjectComposition.field3438.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3440.reset();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      class208.method3989();
      class223.method4150();
      Item.method1794();
      BaseVarType.method13();
      GameObject.method2924();
      class254.field3413.reset();
      class254.field3414.reset();
      class254.field3412.reset();
      class182.method3533();
      class252.field3394.reset();
      class222.method4146();
      Area.skeletonsIndex.reset();
      PlayerComposition.field2608.reset();
      Widget.field2697.reset();
      Widget.field2726.reset();
      Widget.field2638.reset();
      Widget.field2639.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1522.reset();
      class174.indexInterfaces.reset();
      WorldMapData.indexSoundEffects.reset();
      DecorativeObject.field2162.reset();
      class15.field310.reset();
      class18.indexMaps.reset();
      class37.indexTrack1.reset();
      class14.indexModels.reset();
      class3.indexSprites.reset();
      Client.indexTextures.reset();
      class89.field1409.reset();
      ScriptEvent.indexTrack2.reset();
      WorldMapType1.indexScripts.reset();
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1328599719"
   )
   static final void method518() {
      int var0 = class66.localPlayer.x;
      int var1 = class66.localPlayer.y;
      if(Occluder.field2148 - var0 < -500 || Occluder.field2148 - var0 > 500 || class181.field2432 - var1 < -500 || class181.field2432 - var1 > 500) {
         Occluder.field2148 = var0;
         class181.field2432 = var1;
      }

      if(var0 != Occluder.field2148) {
         Occluder.field2148 += (var0 - Occluder.field2148) / 16;
      }

      if(var1 != class181.field2432) {
         class181.field2432 += (var1 - class181.field2432) / 16;
      }

      int var2;
      int var3;
      if(MouseInput.field750 == 4 && class7.field244) {
         var2 = MouseInput.field741 - Client.field995;
         Client.field1000 = var2 * 2;
         Client.field995 = var2 != -1 && var2 != 1?(Client.field995 + MouseInput.field741) / 2:MouseInput.field741;
         var3 = Client.field1001 - MouseInput.field756;
         Client.field994 = var3 * 2;
         Client.field1001 = var3 != -1 && var3 != 1?(MouseInput.field756 + Client.field1001) / 2:MouseInput.field756;
      } else {
         if(KeyFocusListener.field659[96]) {
            Client.field994 += (-24 - Client.field994) / 2;
         } else if(KeyFocusListener.field659[97]) {
            Client.field994 += (24 - Client.field994) / 2;
         } else {
            Client.field994 /= 2;
         }

         if(KeyFocusListener.field659[98]) {
            Client.field1000 += (12 - Client.field1000) / 2;
         } else if(KeyFocusListener.field659[99]) {
            Client.field1000 += (-12 - Client.field1000) / 2;
         } else {
            Client.field1000 /= 2;
         }

         Client.field995 = MouseInput.field741;
         Client.field1001 = MouseInput.field756;
      }

      Client.mapAngle = Client.field994 / 2 + Client.mapAngle & 2047;
      Client.field997 += Client.field1000 / 2;
      if(Client.field997 < 128) {
         Client.field997 = 128;
      }

      if(Client.field997 > 383) {
         Client.field997 = 383;
      }

      var2 = Occluder.field2148 >> 7;
      var3 = class181.field2432 >> 7;
      int var4 = class41.getTileHeight(Occluder.field2148, class181.field2432, class46.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = class46.plane;
               if(var8 < 3 && (class61.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class61.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < 32768) {
         var6 = 32768;
      }

      if(var6 > Client.field958) {
         Client.field958 += (var6 - Client.field958) / 24;
      } else if(var6 < Client.field958) {
         Client.field958 += (var6 - Client.field958) / 80;
      }

   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "105"
   )
   static final void method515() {
      class56.flush(false);
      Client.field981 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class36.field519.length; ++var1) {
         if(WorldMapType3.field400[var1] != -1 && class36.field519[var1] == null) {
            class36.field519[var1] = class18.indexMaps.getConfigData(WorldMapType3.field400[var1], 0);
            if(class36.field519[var1] == null) {
               var0 = false;
               ++Client.field981;
            }
         }

         if(class2.landRegionFielIds[var1] != -1 && ScriptEvent.field856[var1] == null) {
            ScriptEvent.field856[var1] = class18.indexMaps.getConfigData(class2.landRegionFielIds[var1], 0, class35.xteaKeys[var1]);
            if(ScriptEvent.field856[var1] == null) {
               var0 = false;
               ++Client.field981;
            }
         }
      }

      if(!var0) {
         Client.field985 = 1;
      } else {
         Client.field983 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class36.field519.length; ++var1) {
            byte[] var2 = ScriptEvent.field856[var1];
            if(var2 != null) {
               var3 = (class15.mapRegions[var1] >> 8) * 64 - class22.baseX;
               var4 = (class15.mapRegions[var1] & 255) * 64 - class273.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class22.method173(var2, var3, var4);
            }
         }

         if(!var0) {
            Client.field985 = 2;
         } else {
            if(Client.field985 != 0) {
               class24.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            KeyFocusListener.method756();
            method521();
            KeyFocusListener.method756();
            class3.region.reset();
            KeyFocusListener.method756();
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

            KeyFocusListener.method756();
            class61.field770 = 99;
            class2.underlayIds = new byte[4][104][104];
            class61.overlayIds = new byte[4][104][104];
            Huffman.overlayPaths = new byte[4][104][104];
            class61.overlayRotations = new byte[4][104][104];
            class268.field3673 = new int[4][105][105];
            class7.field248 = new byte[4][105][105];
            GrandExchangeOffer.field315 = new int[105][105];
            CombatInfoListHolder.blendedHue = new int[104];
            class47.blendedSaturation = new int[104];
            class19.field333 = new int[104];
            class61.field777 = new int[104];
            class3.field25 = new int[104];
            var1 = class36.field519.length;
            class27.method218();
            class56.flush(true);
            int var9;
            int var10;
            int var11;
            int var12;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            int var20;
            int var21;
            int var45;
            int var51;
            int var52;
            if(!Client.isDynamicRegion) {
               byte[] var5;
               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (class15.mapRegions[var44] >> 8) * 64 - class22.baseX;
                  var4 = (class15.mapRegions[var44] & 255) * 64 - class273.baseY;
                  var5 = class36.field519[var44];
                  if(var5 != null) {
                     KeyFocusListener.method756();
                     class2.method3(var5, var3, var4, class51.field678 * 8 - 48, class94.field1500 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (class15.mapRegions[var44] >> 8) * 64 - class22.baseX;
                  var4 = (class15.mapRegions[var44] & 255) * 64 - class273.baseY;
                  var5 = class36.field519[var44];
                  if(var5 == null && class94.field1500 < 800) {
                     KeyFocusListener.method756();
                     Actor.method1540(var3, var4, 64, 64);
                  }
               }

               class56.flush(true);

               for(var44 = 0; var44 < var1; ++var44) {
                  byte[] var46 = ScriptEvent.field856[var44];
                  if(var46 != null) {
                     var4 = (class15.mapRegions[var44] >> 8) * 64 - class22.baseX;
                     var45 = (class15.mapRegions[var44] & 255) * 64 - class273.baseY;
                     KeyFocusListener.method756();
                     Region var48 = class3.region;
                     CollisionData[] var49 = Client.collisionMaps;
                     Buffer var50 = new Buffer(var46);
                     var9 = -1;

                     while(true) {
                        var10 = var50.getUSmart();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var12 = var50.getUSmart();
                           if(var12 == 0) {
                              break;
                           }

                           var11 += var12 - 1;
                           var51 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var50.readUnsignedByte();
                           var17 = var16 >> 2;
                           var52 = var16 & 3;
                           var19 = var4 + var14;
                           var20 = var45 + var51;
                           if(var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
                              var21 = var15;
                              if((class61.tileSettings[1][var19][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var58 = null;
                              if(var21 >= 0) {
                                 var58 = var49[var21];
                              }

                              class19.addObject(var15, var19, var20, var9, var52, var17, var48, var58);
                           }
                        }
                     }
                  }
               }
            }

            int var6;
            int var7;
            int var8;
            int var22;
            int var26;
            int var27;
            int var28;
            int var29;
            int var32;
            int var34;
            int var35;
            int var36;
            if(Client.isDynamicRegion) {
               for(var44 = 0; var44 < 4; ++var44) {
                  KeyFocusListener.method756();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var65 = false;
                        var6 = Client.field988[var44][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var12 = 0; var12 < class15.mapRegions.length; ++var12) {
                              if(class15.mapRegions[var12] == var11 && class36.field519[var12] != null) {
                                 byte[] var13 = class36.field519[var12];
                                 var14 = var3 * 8;
                                 var15 = var4 * 8;
                                 var16 = (var9 & 7) * 8;
                                 var17 = (var10 & 7) * 8;
                                 CollisionData[] var18 = Client.collisionMaps;

                                 for(var19 = 0; var19 < 8; ++var19) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var19 + var14 > 0 && var19 + var14 < 103 && var20 + var15 > 0 && var15 + var20 < 103) {
                                          var18[var44].flags[var19 + var14][var15 + var20] &= -16777217;
                                       }
                                    }
                                 }

                                 Buffer var47 = new Buffer(var13);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(var22 = 0; var22 < 64; ++var22) {
                                          if(var7 == var20 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < var17 + 8) {
                                             var27 = var21 & 7;
                                             var28 = var22 & 7;
                                             var29 = var8 & 3;
                                             if(var29 == 0) {
                                                var26 = var27;
                                             } else if(var29 == 1) {
                                                var26 = var28;
                                             } else if(var29 == 2) {
                                                var26 = 7 - var27;
                                             } else {
                                                var26 = 7 - var28;
                                             }

                                             var32 = var26 + var14;
                                             var35 = var21 & 7;
                                             var36 = var22 & 7;
                                             int var37 = var8 & 3;
                                             if(var37 == 0) {
                                                var34 = var36;
                                             } else if(var37 == 1) {
                                                var34 = 7 - var35;
                                             } else if(var37 == 2) {
                                                var34 = 7 - var36;
                                             } else {
                                                var34 = var35;
                                             }

                                             ItemContainer.loadTerrain(var47, var44, var32, var15 + var34, 0, 0, var8);
                                          } else {
                                             ItemContainer.loadTerrain(var47, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var65 = true;
                                 break;
                              }
                           }
                        }

                        if(!var65) {
                           var7 = var44;
                           var8 = var3 * 8;
                           var9 = var4 * 8;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class61.tileHeights[var7][var8 + var10][var11 + var9] = 0;
                              }
                           }

                           if(var8 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class61.tileHeights[var7][var8][var10 + var9] = class61.tileHeights[var7][var8 - 1][var9 + var10];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class61.tileHeights[var7][var8 + var10][var9] = class61.tileHeights[var7][var10 + var8][var9 - 1];
                              }
                           }

                           if(var8 > 0 && class61.tileHeights[var7][var8 - 1][var9] != 0) {
                              class61.tileHeights[var7][var8][var9] = class61.tileHeights[var7][var8 - 1][var9];
                           } else if(var9 > 0 && class61.tileHeights[var7][var8][var9 - 1] != 0) {
                              class61.tileHeights[var7][var8][var9] = class61.tileHeights[var7][var8][var9 - 1];
                           } else if(var8 > 0 && var9 > 0 && class61.tileHeights[var7][var8 - 1][var9 - 1] != 0) {
                              class61.tileHeights[var7][var8][var9] = class61.tileHeights[var7][var8 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var44 = 0; var44 < 13; ++var44) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field988[0][var44][var3];
                     if(var4 == -1) {
                        Actor.method1540(var44 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class56.flush(true);

               for(var44 = 0; var44 < 4; ++var44) {
                  KeyFocusListener.method756();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var45 = Client.field988[var44][var3][var4];
                        if(var45 != -1) {
                           var6 = var45 >> 24 & 3;
                           var7 = var45 >> 1 & 3;
                           var8 = var45 >> 14 & 1023;
                           var9 = var45 >> 3 & 2047;
                           var10 = (var8 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class15.mapRegions.length; ++var11) {
                              if(class15.mapRegions[var11] == var10 && ScriptEvent.field856[var11] != null) {
                                 class25.method187(ScriptEvent.field856[var11], var44, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, class3.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            class56.flush(true);
            method521();
            KeyFocusListener.method756();
            Region var59 = class3.region;
            CollisionData[] var66 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var45 = 0; var45 < 104; ++var45) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class61.tileSettings[var4][var45][var6] & 1) == 1) {
                        var7 = var4;
                        if((class61.tileSettings[1][var45][var6] & 2) == 2) {
                           var7 = var4 - 1;
                        }

                        if(var7 >= 0) {
                           var66[var7].method3075(var45, var6);
                        }
                     }
                  }
               }
            }

            class61.field779 += (int)(Math.random() * 5.0D) - 2;
            if(class61.field779 < -8) {
               class61.field779 = -8;
            }

            if(class61.field779 > 8) {
               class61.field779 = 8;
            }

            class61.field781 += (int)(Math.random() * 5.0D) - 2;
            if(class61.field781 < -16) {
               class61.field781 = -16;
            }

            if(class61.field781 > 16) {
               class61.field781 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var60 = class7.field248[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var12 = var11 * 768 >> 8;

               for(var51 = 1; var51 < 103; ++var51) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class61.tileHeights[var4][var14 + 1][var51] - class61.tileHeights[var4][var14 - 1][var51];
                     var16 = class61.tileHeights[var4][var14][var51 + 1] - class61.tileHeights[var4][var14][var51 - 1];
                     var17 = (int)Math.sqrt((double)(var16 * var16 + var15 * var15 + 65536));
                     var52 = (var15 << 8) / var17;
                     var19 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = (var20 * -50 + var52 * -50 + var19 * -10) / var12 + 96;
                     var22 = (var60[var14][var51 + 1] >> 3) + (var60[var14 - 1][var51] >> 2) + (var60[var14][var51 - 1] >> 2) + (var60[var14 + 1][var51] >> 3) + (var60[var14][var51] >> 1);
                     GrandExchangeOffer.field315[var14][var51] = var21 - var22;
                  }
               }

               for(var51 = 0; var51 < 104; ++var51) {
                  CombatInfoListHolder.blendedHue[var51] = 0;
                  class47.blendedSaturation[var51] = 0;
                  class19.field333[var51] = 0;
                  class61.field777[var51] = 0;
                  class3.field25[var51] = 0;
               }

               for(var51 = -5; var51 < 109; ++var51) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var51 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class2.underlayIds[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           FloorUnderlayDefinition var53 = class229.method4165(var16 - 1);
                           CombatInfoListHolder.blendedHue[var14] += var53.hue;
                           class47.blendedSaturation[var14] += var53.saturation;
                           class19.field333[var14] += var53.lightness;
                           class61.field777[var14] += var53.hueMultiplier;
                           ++class3.field25[var14];
                        }
                     }

                     var16 = var51 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class2.underlayIds[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           FloorUnderlayDefinition var61 = class229.method4165(var17 - 1);
                           CombatInfoListHolder.blendedHue[var14] -= var61.hue;
                           class47.blendedSaturation[var14] -= var61.saturation;
                           class19.field333[var14] -= var61.lightness;
                           class61.field777[var14] -= var61.hueMultiplier;
                           --class3.field25[var14];
                        }
                     }
                  }

                  if(var51 >= 1 && var51 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var52 = 0;

                     for(var19 = -5; var19 < 109; ++var19) {
                        var20 = var19 + 5;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += CombatInfoListHolder.blendedHue[var20];
                           var15 += class47.blendedSaturation[var20];
                           var16 += class19.field333[var20];
                           var17 += class61.field777[var20];
                           var52 += class3.field25[var20];
                        }

                        var21 = var19 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= CombatInfoListHolder.blendedHue[var21];
                           var15 -= class47.blendedSaturation[var21];
                           var16 -= class19.field333[var21];
                           var17 -= class61.field777[var21];
                           var52 -= class3.field25[var21];
                        }

                        if(var19 >= 1 && var19 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var51][var19] & 2) != 0 || (class61.tileSettings[var4][var51][var19] & 16) == 0)) {
                           if(var4 < class61.field770) {
                              class61.field770 = var4;
                           }

                           var22 = class2.underlayIds[var4][var51][var19] & 255;
                           int var54 = class61.overlayIds[var4][var51][var19] & 255;
                           if(var22 > 0 || var54 > 0) {
                              int var24 = class61.tileHeights[var4][var51][var19];
                              int var25 = class61.tileHeights[var4][var51 + 1][var19];
                              var26 = class61.tileHeights[var4][var51 + 1][var19 + 1];
                              var27 = class61.tileHeights[var4][var51][var19 + 1];
                              var28 = GrandExchangeOffer.field315[var51][var19];
                              var29 = GrandExchangeOffer.field315[var51 + 1][var19];
                              int var55 = GrandExchangeOffer.field315[var51 + 1][var19 + 1];
                              int var31 = GrandExchangeOffer.field315[var51][var19 + 1];
                              var32 = -1;
                              int var33 = -1;
                              if(var22 > 0) {
                                 var34 = var14 * 256 / var17;
                                 var35 = var15 / var52;
                                 var36 = var16 / var52;
                                 var32 = class163.method3128(var34, var35, var36);
                                 var34 = var34 + class61.field779 & 255;
                                 var36 += class61.field781;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = class163.method3128(var34, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var63 = true;
                                 if(var22 == 0 && Huffman.overlayPaths[var4][var51][var19] != 0) {
                                    var63 = false;
                                 }

                                 if(var54 > 0 && !class18.method135(var54 - 1).isHidden) {
                                    var63 = false;
                                 }

                                 if(var63 && var25 == var24 && var26 == var24 && var27 == var24) {
                                    class268.field3673[var4][var51][var19] |= 2340;
                                 }
                              }

                              var34 = 0;
                              if(var33 != -1) {
                                 var34 = Graphics3D.colorPalette[class138.method2888(var33, 96)];
                              }

                              if(var54 == 0) {
                                 var59.addTile(var4, var51, var19, 0, 0, -1, var24, var25, var26, var27, class138.method2888(var32, var28), class138.method2888(var32, var29), class138.method2888(var32, var55), class138.method2888(var32, var31), 0, 0, 0, 0, var34, 0);
                              } else {
                                 var35 = Huffman.overlayPaths[var4][var51][var19] + 1;
                                 byte var64 = class61.overlayRotations[var4][var51][var19];
                                 Overlay var56 = class18.method135(var54 - 1);
                                 int var38 = var56.texture;
                                 int var39;
                                 int var40;
                                 int var41;
                                 int var42;
                                 if(var38 >= 0) {
                                    var40 = Graphics3D.textureLoader.getAverageTextureRGB(var38);
                                    var39 = -1;
                                 } else if(var56.color == 16711935) {
                                    var39 = -2;
                                    var38 = -1;
                                    var40 = -2;
                                 } else {
                                    var39 = class163.method3128(var56.hue, var56.saturation, var56.lightness);
                                    var41 = var56.hue + class61.field779 & 255;
                                    var42 = var56.lightness + class61.field781;
                                    if(var42 < 0) {
                                       var42 = 0;
                                    } else if(var42 > 255) {
                                       var42 = 255;
                                    }

                                    var40 = class163.method3128(var41, var56.saturation, var42);
                                 }

                                 var41 = 0;
                                 if(var40 != -2) {
                                    var41 = Graphics3D.colorPalette[class214.adjustHSLListness0(var40, 96)];
                                 }

                                 if(var56.otherRgbColor != -1) {
                                    var42 = var56.otherHue + class61.field779 & 255;
                                    int var43 = var56.otherLightness + class61.field781;
                                    if(var43 < 0) {
                                       var43 = 0;
                                    } else if(var43 > 255) {
                                       var43 = 255;
                                    }

                                    var40 = class163.method3128(var42, var56.otherSaturation, var43);
                                    var41 = Graphics3D.colorPalette[class214.adjustHSLListness0(var40, 96)];
                                 }

                                 var59.addTile(var4, var51, var19, var35, var64, var38, var24, var25, var26, var27, class138.method2888(var32, var28), class138.method2888(var32, var29), class138.method2888(var32, var55), class138.method2888(var32, var31), class214.adjustHSLListness0(var39, var28), class214.adjustHSLListness0(var39, var29), class214.adjustHSLListness0(var39, var55), class214.adjustHSLListness0(var39, var31), var34, var41);
                              }
                           }
                        }
                     }
                  }
               }

               for(var51 = 1; var51 < 103; ++var51) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     if((class61.tileSettings[var4][var14][var51] & 8) != 0) {
                        var19 = 0;
                     } else if(var4 > 0 && (class61.tileSettings[1][var14][var51] & 2) != 0) {
                        var19 = var4 - 1;
                     } else {
                        var19 = var4;
                     }

                     var59.setPhysicalLevel(var4, var14, var51, var19);
                  }
               }

               class2.underlayIds[var4] = null;
               class61.overlayIds[var4] = null;
               Huffman.overlayPaths[var4] = null;
               class61.overlayRotations[var4] = null;
               class7.field248[var4] = null;
            }

            var59.applyLighting(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var45 = 0; var45 < 104; ++var45) {
                  if((class61.tileSettings[1][var4][var45] & 2) == 2) {
                     var59.setBridge(var4, var45);
                  }
               }
            }

            var4 = 1;
            var45 = 2;
            var6 = 4;

            for(var7 = 0; var7 < 4; ++var7) {
               if(var7 > 0) {
                  var4 <<= 3;
                  var45 <<= 3;
                  var6 <<= 3;
               }

               for(var8 = 0; var8 <= var7; ++var8) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var62;
                        if((class268.field3673[var8][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var12 = var9;
                           var51 = var8;

                           for(var14 = var8; var11 > 0 && (class268.field3673[var8][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var12 < 104 && (class268.field3673[var8][var10][var12 + 1] & var4) != 0) {
                              ++var12;
                           }

                           label835:
                           while(var51 > 0) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class268.field3673[var51 - 1][var10][var15] & var4) == 0) {
                                    break label835;
                                 }
                              }

                              --var51;
                           }

                           label824:
                           while(var14 < var7) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class268.field3673[var14 + 1][var10][var15] & var4) == 0) {
                                    break label824;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var12 - var11 + 1) * (var14 + 1 - var51);
                           if(var15 >= 8) {
                              var62 = 240;
                              var17 = class61.tileHeights[var14][var10][var11] - var62;
                              var52 = class61.tileHeights[var51][var10][var11];
                              Region.addOcclude(var7, 1, var10 * 128, var10 * 128, var11 * 128, var12 * 128 + 128, var17, var52);

                              for(var19 = var51; var19 <= var14; ++var19) {
                                 for(var20 = var11; var20 <= var12; ++var20) {
                                    class268.field3673[var19][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class268.field3673[var8][var10][var9] & var45) != 0) {
                           var11 = var10;
                           var12 = var10;
                           var51 = var8;

                           for(var14 = var8; var11 > 0 && (class268.field3673[var8][var11 - 1][var9] & var45) != 0; --var11) {
                              ;
                           }

                           while(var12 < 104 && (class268.field3673[var8][var12 + 1][var9] & var45) != 0) {
                              ++var12;
                           }

                           label888:
                           while(var51 > 0) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class268.field3673[var51 - 1][var15][var9] & var45) == 0) {
                                    break label888;
                                 }
                              }

                              --var51;
                           }

                           label877:
                           while(var14 < var7) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class268.field3673[var14 + 1][var15][var9] & var45) == 0) {
                                    break label877;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var12 - var11 + 1) * (var14 + 1 - var51);
                           if(var15 >= 8) {
                              var62 = 240;
                              var17 = class61.tileHeights[var14][var11][var9] - var62;
                              var52 = class61.tileHeights[var51][var11][var9];
                              Region.addOcclude(var7, 2, var11 * 128, var12 * 128 + 128, var9 * 128, var9 * 128, var17, var52);

                              for(var19 = var51; var19 <= var14; ++var19) {
                                 for(var20 = var11; var20 <= var12; ++var20) {
                                    class268.field3673[var19][var20][var9] &= ~var45;
                                 }
                              }
                           }
                        }

                        if((class268.field3673[var8][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var12 = var10;
                           var51 = var9;

                           for(var14 = var9; var51 > 0 && (class268.field3673[var8][var10][var51 - 1] & var6) != 0; --var51) {
                              ;
                           }

                           while(var14 < 104 && (class268.field3673[var8][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label941:
                           while(var11 > 0) {
                              for(var15 = var51; var15 <= var14; ++var15) {
                                 if((class268.field3673[var8][var11 - 1][var15] & var6) == 0) {
                                    break label941;
                                 }
                              }

                              --var11;
                           }

                           label930:
                           while(var12 < 104) {
                              for(var15 = var51; var15 <= var14; ++var15) {
                                 if((class268.field3673[var8][var12 + 1][var15] & var6) == 0) {
                                    break label930;
                                 }
                              }

                              ++var12;
                           }

                           if((var12 - var11 + 1) * (var14 - var51 + 1) >= 4) {
                              var15 = class61.tileHeights[var8][var11][var51];
                              Region.addOcclude(var7, 4, var11 * 128, var12 * 128 + 128, var51 * 128, var14 * 128 + 128, var15, var15);

                              for(var16 = var11; var16 <= var12; ++var16) {
                                 for(var17 = var51; var17 <= var14; ++var17) {
                                    class268.field3673[var8][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class56.flush(true);
            var4 = class61.field770;
            if(var4 > class46.plane) {
               var4 = class46.plane;
            }

            if(var4 < class46.plane - 1) {
               var4 = class46.plane - 1;
            }

            if(Client.lowMemory) {
               class3.region.setup(class61.field770);
            } else {
               class3.region.setup(0);
            }

            for(var45 = 0; var45 < 104; ++var45) {
               for(var6 = 0; var6 < 104; ++var6) {
                  ContextMenuRow.groundItemSpawned(var45, var6);
               }
            }

            KeyFocusListener.method756();
            class54.method780();
            ObjectComposition.field3438.reset();
            if(class7.clientInstance.method927()) {
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_62);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(1057001181);
               } else {
                  Client.secretPacketBuffer1.putInt(1057001181);
               }
            }

            if(!Client.isDynamicRegion) {
               var45 = (class51.field678 - 6) / 8;
               var6 = (class51.field678 + 6) / 8;
               var7 = (class94.field1500 - 6) / 8;
               var8 = (class94.field1500 + 6) / 8;

               for(var9 = var45 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var7 - 1; var10 <= var8 + 1; ++var10) {
                     if(var9 < var45 || var9 > var6 || var10 < var7 || var10 > var8) {
                        class18.indexMaps.method4212("m" + var9 + "_" + var10);
                        class18.indexMaps.method4212("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class72.setGameState(30);
            KeyFocusListener.method756();
            class2.underlayIds = null;
            class61.overlayIds = null;
            Huffman.overlayPaths = null;
            class61.overlayRotations = null;
            class268.field3673 = null;
            class7.field248 = null;
            GrandExchangeOffer.field315 = null;
            CombatInfoListHolder.blendedHue = null;
            class47.blendedSaturation = null;
            class19.field333 = null;
            class61.field777 = null;
            class3.field25 = null;
            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_REGION_CHANGED);
            AbstractSoundSystem.method2116();
         }
      }
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;B)V",
      garbageValue = "-47"
   )
   static void method517(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class215.method4064(var1, var2);
      if(var5 != null) {
         if(var5.field2742 != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.field851 = var0;
            var6.field853 = var4;
            var6.field849 = var5.field2742;
            class56.method817(var6);
         }

         boolean var10 = true;
         if(var5.contentType > 0) {
            var10 = class18.method140(var5);
         }

         if(var10) {
            int var8 = class25.getWidgetConfig(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               if(var0 == 1) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_61);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     Client.secretPacketBuffer1.runeliteWriteInt(var2);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  } else {
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var2);
                     Client.secretPacketBuffer1.putShort(var3);
                  }
               }

               if(var0 == 2) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_126);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     Client.secretPacketBuffer1.runeliteWriteInt(var2);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  } else {
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var2);
                     Client.secretPacketBuffer1.putShort(var3);
                  }
               }

               if(var0 == 3) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_156);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     Client.secretPacketBuffer1.runeliteWriteInt(var2);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  } else {
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var2);
                     Client.secretPacketBuffer1.putShort(var3);
                  }
               }

               if(var0 == 4) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_232);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     Client.secretPacketBuffer1.runeliteWriteInt(var2);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  } else {
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var2);
                     Client.secretPacketBuffer1.putShort(var3);
                  }
               }

               if(var0 == 5) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_139);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     Client.secretPacketBuffer1.runeliteWriteInt(var2);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  } else {
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var2);
                     Client.secretPacketBuffer1.putShort(var3);
                  }
               }

               if(var0 == 6) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_130);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     Client.secretPacketBuffer1.runeliteWriteInt(var2);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  } else {
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var2);
                     Client.secretPacketBuffer1.putShort(var3);
                  }
               }

               if(var0 == 7) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_72);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     Client.secretPacketBuffer1.runeliteWriteInt(var2);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  } else {
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var2);
                     Client.secretPacketBuffer1.putShort(var3);
                  }
               }

               if(var0 == 8) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_103);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     Client.secretPacketBuffer1.runeliteWriteInt(var2);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  } else {
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var2);
                     Client.secretPacketBuffer1.putShort(var3);
                  }
               }

               if(var0 == 9) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_8);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     Client.secretPacketBuffer1.runeliteWriteInt(var2);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  } else {
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var2);
                     Client.secretPacketBuffer1.putShort(var3);
                  }
               }

               if(var0 == 10) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_83);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     Client.secretPacketBuffer1.runeliteWriteInt(var2);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  } else {
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var2);
                     Client.secretPacketBuffer1.putShort(var3);
                  }
               }

            }
         }
      }
   }
}
