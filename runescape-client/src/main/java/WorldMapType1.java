import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1453150507
   )
   int field439;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1825301879
   )
   int field442;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2052848119
   )
   int field437;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2020942099
   )
   int field430;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1971207809
   )
   int field436;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2058407109
   )
   int field431;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1774990039
   )
   int field438;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 36466259
   )
   int field433;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -982990201
   )
   int field432;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -490698607
   )
   int field429;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-39567884"
   )
   public boolean vmethod705(int var1, int var2) {
      return var1 >> 6 >= this.field439 && var1 >> 6 <= this.field437 && var2 >> 6 >= this.field436 && var2 >> 6 <= this.field438;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2062801574"
   )
   public boolean vmethod704(int var1, int var2, int var3) {
      return var1 >= this.field442 && var1 < this.field442 + this.field430?var2 >> 6 >= this.field431 && var2 >> 6 <= this.field433 && var3 >> 6 >= this.field432 && var3 >> 6 <= this.field429:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "-3"
   )
   public void vmethod703(WorldMapData var1) {
      if(var1.field457 > this.field439) {
         var1.field457 = this.field439;
      }

      if(var1.field460 < this.field437) {
         var1.field460 = this.field437;
      }

      if(var1.field453 > this.field436) {
         var1.field453 = this.field436;
      }

      if(var1.field462 < this.field438) {
         var1.field462 = this.field438;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Lhq;",
      garbageValue = "578346769"
   )
   public Coordinates vmethod728(int var1, int var2) {
      if(!this.vmethod705(var1, var2)) {
         return null;
      } else {
         int var3 = this.field431 * 64 - this.field439 * 64 + var1;
         int var4 = var2 + (this.field432 * 64 - this.field436 * 64);
         return new Coordinates(this.field442, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-670381390"
   )
   public int[] vmethod706(int var1, int var2, int var3) {
      if(!this.vmethod704(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field439 * 64 - this.field431 * 64), var3 + (this.field436 * 64 - this.field432 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfh;B)V",
      garbageValue = "0"
   )
   public void vmethod716(Buffer var1) {
      this.field442 = var1.readUnsignedByte();
      this.field430 = var1.readUnsignedByte();
      this.field431 = var1.readUnsignedShort();
      this.field432 = var1.readUnsignedShort();
      this.field433 = var1.readUnsignedShort();
      this.field429 = var1.readUnsignedShort();
      this.field439 = var1.readUnsignedShort();
      this.field436 = var1.readUnsignedShort();
      this.field437 = var1.readUnsignedShort();
      this.field438 = var1.readUnsignedShort();
      this.method257();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "265100991"
   )
   void method257() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Lia;",
      garbageValue = "-44"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class271.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3433 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "390313310"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class5.clientInstance.method867();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field947 = 0;
            Client.field948 = 0;
         }

         if(var0 != 20 && var0 != 40 && class22.field341 != null) {
            class22.field341.close();
            class22.field341 = null;
         }

         if(Client.gameState == 25) {
            Client.field973 = 0;
            Client.field1123 = 0;
            Client.field929 = 1;
            Client.field971 = 0;
            Client.field972 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class91.method1738(Ignore.field855, indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class91.method1738(Ignore.field855, indexSprites, false, 4);
            } else {
               FaceNormal.method2910();
            }
         } else {
            class91.method1738(Ignore.field855, indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-384806625"
   )
   public static final boolean method279() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field630 == KeyFocusListener.field618) {
            return false;
         } else {
            Coordinates.field2589 = KeyFocusListener.field633[KeyFocusListener.field630];
            World.field1292 = KeyFocusListener.field635[KeyFocusListener.field630];
            KeyFocusListener.field630 = KeyFocusListener.field630 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lit;IIIZI)V",
      garbageValue = "-2007060515"
   )
   public static void method276(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class204.field2487 = 1;
      class204.field2488 = var0;
      class12.field273 = var1;
      class204.field2489 = var2;
      class204.field2490 = var3;
      class33.field472 = var4;
      class204.field2491 = 10000;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lej;[Lfo;B)V",
      garbageValue = "16"
   )
   static final void method260(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class61.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class61.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method3060(var3, var4);
                  }
               }
            }
         }
      }

      class61.field757 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field757 < -8) {
         class61.field757 = -8;
      }

      if(class61.field757 > 8) {
         class61.field757 = 8;
      }

      class61.field743 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field743 < -16) {
         class61.field743 = -16;
      }

      if(class61.field743 > 16) {
         class61.field743 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = ChatLineBuffer.field1546[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class61.tileHeights[var2][var12 + 1][var11] - class61.tileHeights[var2][var12 - 1][var11];
               var14 = class61.tileHeights[var2][var12][var11 + 1] - class61.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + var14 * var14 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var16 * -50 + var17 * -10 + var18 * -50) / var10 + 96;
               var20 = (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11] >> 1);
               class61.field756[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class20.blendedHue[var11] = 0;
            GroundObject.blendedSaturation[var11] = 0;
            class33.field473[var11] = 0;
            class61.field746[var11] = 0;
            class61.field742[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class91.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class34.method493(var14 - 1);
                     class20.blendedHue[var12] += var43.hue;
                     GroundObject.blendedSaturation[var12] += var43.saturation;
                     class33.field473[var12] += var43.lightness;
                     class61.field746[var12] += var43.hueMultiplier;
                     ++class61.field742[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class91.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class34.method493(var15 - 1);
                     class20.blendedHue[var12] -= var44.hue;
                     GroundObject.blendedSaturation[var12] -= var44.saturation;
                     class33.field473[var12] -= var44.lightness;
                     class61.field746[var12] -= var44.hueMultiplier;
                     --class61.field742[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class20.blendedHue[var18];
                     var13 += GroundObject.blendedSaturation[var18];
                     var14 += class33.field473[var18];
                     var15 += class61.field746[var18];
                     var16 += class61.field742[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class20.blendedHue[var19];
                     var13 -= GroundObject.blendedSaturation[var19];
                     var14 -= class33.field473[var19];
                     var15 -= class61.field746[var19];
                     var16 -= class61.field742[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field753) {
                        class61.field753 = var2;
                     }

                     var20 = class91.underlayIds[var2][var11][var17] & 255;
                     int var21 = class61.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = class61.field756[var11][var17];
                        int var27 = class61.field756[var11 + 1][var17];
                        int var28 = class61.field756[var11 + 1][var17 + 1];
                        int var29 = class61.field756[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class74.method1142(var32, var33, var34);
                           var32 = var32 + class61.field757 & 255;
                           var34 += class61.field743;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class74.method1142(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var46 = true;
                           if(var20 == 0 && class92.overlayPaths[var2][var11][var17] != 0) {
                              var46 = false;
                           }

                           if(var21 > 0 && !class226.method4083(var21 - 1).isHidden) {
                              var46 = false;
                           }

                           if(var46 && var23 == var22 && var22 == var24 && var25 == var22) {
                              class61.field748[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[class48.method729(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class48.method729(var30, var26), class48.method729(var30, var27), class48.method729(var30, var28), class48.method729(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class92.overlayPaths[var2][var11][var17] + 1;
                           byte var47 = class35.overlayRotations[var2][var11][var17];
                           Overlay var35 = class226.method4083(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = Graphics3D.textureLoader.getAverageTextureRGB(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class74.method1142(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field757 & 255;
                              var40 = var35.lightness + class61.field743;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class74.method1142(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[class262.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class61.field757 & 255;
                              int var41 = var35.otherLightness + class61.field743;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class74.method1142(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[class262.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var47, var36, var22, var23, var24, var25, class48.method729(var30, var26), class48.method729(var30, var27), class48.method729(var30, var28), class48.method729(var30, var29), class262.adjustHSLListness0(var37, var26), class262.adjustHSLListness0(var37, var27), class262.adjustHSLListness0(var37, var28), class262.adjustHSLListness0(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.setPhysicalLevel(var2, var12, var11, Huffman.method3115(var2, var12, var11));
            }
         }

         class91.underlayIds[var2] = null;
         class61.overlayIds[var2] = null;
         class92.overlayPaths[var2] = null;
         class35.overlayRotations[var2] = null;
         ChatLineBuffer.field1546[var2] = null;
      }

      var0.applyLighting(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class61.tileSettings[1][var2][var3] & 2) == 2) {
               var0.setBridge(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var45;
                  if((class61.field748[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class61.field748[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class61.field748[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label468:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class61.field748[var11 - 1][var8][var13] & var2) == 0) {
                              break label468;
                           }
                        }

                        --var11;
                     }

                     label457:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class61.field748[var12 + 1][var8][var13] & var2) == 0) {
                              break label457;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var45;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.addOcclude(var5, 1, var8 * 128, var8 * 128, var9 * 128, 128 + var10 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class61.field748[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class61.field748[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class61.field748[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class61.field748[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label521:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class61.field748[var11 - 1][var13][var7] & var3) == 0) {
                              break label521;
                           }
                        }

                        --var11;
                     }

                     label510:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class61.field748[var12 + 1][var13][var7] & var3) == 0) {
                              break label510;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var45;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class61.field748[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class61.field748[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class61.field748[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class61.field748[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label574:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class61.field748[var6][var9 - 1][var13] & var4) == 0) {
                              break label574;
                           }
                        }

                        --var9;
                     }

                     label563:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if(0 == (class61.field748[var6][var10 + 1][var13] & var4)) {
                              break label563;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, 128 + var12 * 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class61.field748[var6][var14][var15] &= ~var4;
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
