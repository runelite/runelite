import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("t")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("s")
   @Export("progress")
   byte progress;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1897858645
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 4145137
   )
   @Export("price")
   public int price;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1522987083
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -935902449
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -439013195
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgy;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2016812903"
   )
   @Export("status")
   public int status() {
      return this.progress & 7;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "46"
   )
   @Export("type")
   public int type() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "8218"
   )
   void method106(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-851914908"
   )
   void method102(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "979483326"
   )
   public static void method105() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3324 != 0) {
            IndexStoreActionHandler.field3324 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lec;[Lfb;I)V",
      garbageValue = "1902971006"
   )
   static final void method119(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class62.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class62.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method3376(var3, var4);
                  }
               }
            }
         }
      }

      class62.field735 += (int)(Math.random() * 5.0D) - 2;
      if(class62.field735 < -8) {
         class62.field735 = -8;
      }

      if(class62.field735 > 8) {
         class62.field735 = 8;
      }

      class62.field723 += (int)(Math.random() * 5.0D) - 2;
      if(class62.field723 < -16) {
         class62.field723 = -16;
      }

      if(class62.field723 > 16) {
         class62.field723 = 16;
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
         byte[][] var42 = class160.field2156[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class62.tileHeights[var2][var12 + 1][var11] - class62.tileHeights[var2][var12 - 1][var11];
               var14 = class62.tileHeights[var2][var12][var11 + 1] - class62.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + var14 * var14 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var18 * -50 + var16 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12][var11 + 1] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11] >> 1);
               class62.field726[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            BoundingBox2D.field229[var11] = 0;
            TotalQuantityComparator.field292[var11] = 0;
            class62.field727[var11] = 0;
            class94.field1417[var11] = 0;
            BoundingBox3D.field247[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class62.field724[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = OwnWorldComparator.getUnderlayDefinition(var14 - 1);
                     BoundingBox2D.field229[var12] += var43.hue;
                     TotalQuantityComparator.field292[var12] += var43.saturation;
                     class62.field727[var12] += var43.lightness;
                     class94.field1417[var12] += var43.hueMultiplier;
                     ++BoundingBox3D.field247[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class62.field724[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = OwnWorldComparator.getUnderlayDefinition(var15 - 1);
                     BoundingBox2D.field229[var12] -= var44.hue;
                     TotalQuantityComparator.field292[var12] -= var44.saturation;
                     class62.field727[var12] -= var44.lightness;
                     class94.field1417[var12] -= var44.hueMultiplier;
                     --BoundingBox3D.field247[var12];
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
                     var12 += BoundingBox2D.field229[var18];
                     var13 += TotalQuantityComparator.field292[var18];
                     var14 += class62.field727[var18];
                     var15 += class94.field1417[var18];
                     var16 += BoundingBox3D.field247[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= BoundingBox2D.field229[var19];
                     var13 -= TotalQuantityComparator.field292[var19];
                     var14 -= class62.field727[var19];
                     var15 -= class94.field1417[var19];
                     var16 -= BoundingBox3D.field247[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class62.tileSettings[0][var11][var17] & 2) != 0 || (class62.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class62.field736) {
                        class62.field736 = var2;
                     }

                     var20 = class62.field724[var2][var11][var17] & 255;
                     int var21 = class29.field403[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class62.tileHeights[var2][var11][var17];
                        int var23 = class62.tileHeights[var2][var11 + 1][var17];
                        int var24 = class62.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class62.tileHeights[var2][var11][var17 + 1];
                        int var26 = class62.field726[var11][var17];
                        int var27 = class62.field726[var11 + 1][var17];
                        int var28 = class62.field726[var11 + 1][var17 + 1];
                        int var29 = class62.field726[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = FontName.method5350(var32, var33, var34);
                           var32 = var32 + class62.field735 & 255;
                           var34 += class62.field723;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = FontName.method5350(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && TotalQuantityComparator.field288[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !class153.getOverlayDefinition(var21 - 1).isHidden) {
                              var47 = false;
                           }

                           if(var47 && var22 == var23 && var22 == var24 && var25 == var22) {
                              class21.field331[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[class60.method982(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class60.method982(var30, var26), class60.method982(var30, var27), class60.method982(var30, var28), class60.method982(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = TotalQuantityComparator.field288[var2][var11][var17] + 1;
                           byte var48 = class62.field725[var2][var11][var17];
                           Overlay var35 = class153.getOverlayDefinition(var21 - 1);
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
                              var37 = FontName.method5350(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class62.field735 & 255;
                              var40 = var35.lightness + class62.field723;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = FontName.method5350(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[class263.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class62.field735 & 255;
                              int var41 = var35.otherLightness + class62.field723;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = FontName.method5350(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[class263.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, class60.method982(var30, var26), class60.method982(var30, var27), class60.method982(var30, var28), class60.method982(var30, var29), class263.adjustHSLListness0(var37, var26), class263.adjustHSLListness0(var37, var27), class263.adjustHSLListness0(var37, var28), class263.adjustHSLListness0(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class62.tileSettings[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class62.tileSettings[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.setPhysicalLevel(var2, var12, var11, var17);
            }
         }

         class62.field724[var2] = null;
         class29.field403[var2] = null;
         TotalQuantityComparator.field288[var2] = null;
         class62.field725[var2] = null;
         class160.field2156[var2] = null;
      }

      var0.applyLighting(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class62.tileSettings[1][var2][var3] & 2) == 2) {
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
                  short var46;
                  if((class21.field331[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class21.field331[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class21.field331[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label463:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class21.field331[var11 - 1][var8][var13] & var2) == 0) {
                              break label463;
                           }
                        }

                        --var11;
                     }

                     label452:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class21.field331[var12 + 1][var8][var13] & var2) == 0) {
                              break label452;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class62.tileHeights[var12][var8][var9] - var46;
                        var16 = class62.tileHeights[var11][var8][var9];
                        Region.addOcclude(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class21.field331[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class21.field331[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class21.field331[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class21.field331[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label516:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class21.field331[var11 - 1][var13][var7] & var3) == 0) {
                              break label516;
                           }
                        }

                        --var11;
                     }

                     label505:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class21.field331[var12 + 1][var13][var7] & var3) == 0) {
                              break label505;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class62.tileHeights[var12][var9][var7] - var46;
                        var16 = class62.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class21.field331[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class21.field331[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class21.field331[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class21.field331[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label569:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class21.field331[var6][var9 - 1][var13] & var4) == 0) {
                              break label569;
                           }
                        }

                        --var9;
                     }

                     label558:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class21.field331[var6][var10 + 1][var13] & var4) == 0) {
                              break label558;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class62.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class21.field331[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(Lij;Ljava/lang/String;I)V",
      garbageValue = "-1321309284"
   )
   static void method120(IndexData var0, String var1) {
      class63 var2 = new class63(var0, var1);
      Client.field1092.add(var2);
   }
}
