import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("c")
   static byte[][][] field2156;
   @ObfuscatedName("g")
   long[] field2155;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1757199541
   )
   int field2154;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 25297311
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -1257444173690565585L
   )
   long field2148;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1982076785
   )
   int field2151;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 861733193
   )
   int field2153;

   public MilliTimer() {
      this.field2155 = new long[10];
      this.field2154 = 256;
      this.sleepTime = 1;
      this.field2151 = 0;
      this.field2148 = class289.method5267();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2155[var1] = this.field2148;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1727690798"
   )
   public void vmethod3396() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2155[var1] = 0L;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2016091306"
   )
   public int vmethod3398(int var1, int var2) {
      int var3 = this.field2154;
      int var4 = this.sleepTime;
      this.field2154 = 300;
      this.sleepTime = 1;
      this.field2148 = class289.method5267();
      if(this.field2155[this.field2153] == 0L) {
         this.field2154 = var3;
         this.sleepTime = var4;
      } else if(this.field2148 > this.field2155[this.field2153]) {
         this.field2154 = (int)((long)(var1 * 2560) / (this.field2148 - this.field2155[this.field2153]));
      }

      if(this.field2154 < 25) {
         this.field2154 = 25;
      }

      if(this.field2154 > 256) {
         this.field2154 = 256;
         this.sleepTime = (int)((long)var1 - (this.field2148 - this.field2155[this.field2153]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2155[this.field2153] = this.field2148;
      this.field2153 = (this.field2153 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2155[var5]) {
               this.field2155[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      BoundingBox3DDrawMode.method59((long)this.sleepTime);

      for(var5 = 0; this.field2151 < 256; this.field2151 += this.field2154) {
         ++var5;
      }

      this.field2151 &= 255;
      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILfr;Lji;I)V",
      garbageValue = "-2114756551"
   )
   static void method3280(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.type = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var3);
      }

      GameCanvas.method835();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljr;IIIZI)V",
      garbageValue = "-1835099590"
   )
   public static void method3279(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class229.field2694 = 1;
      class132.field1905 = var0;
      class321.field3940 = var1;
      class132.field1897 = var2;
      AttackOption.field1334 = var3;
      Signlink.field2193 = var4;
      class20.field335 = 10000;
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(Lbm;IIIIII)V",
      garbageValue = "-1335995067"
   )
   @Export("draw2DExtras")
   static final void draw2DExtras(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.hasConfig()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.transform();
            }

            if(var6 == null) {
               return;
            }
         }

         int var75 = class93.playerIndexesCount;
         int[] var7 = class93.playerIndices;
         byte var8 = 0;
         if(var1 < var75 && var0.field1144 == Client.gameCycle && MapCacheArchiveNames.method600((Player)var0)) {
            Player var9 = (Player)var0;
            if(var1 < var75) {
               GrandExchangeOffer.characterToScreen(var0, var0.logicalHeight + 15);
               FontTypeFace var10 = (FontTypeFace)Client.fontsMap.get(FontName.FontName_plain12);
               byte var11 = 9;
               var10.drawTextCentered(var9.name.getName(), var2 + Client.screenX, var3 + Client.screenY - var11, 16777215, 0);
               var8 = 18;
            }
         }

         int var76 = -2;
         int var15;
         int var22;
         int var23;
         if(!var0.combatInfoList.isEmpty()) {
            GrandExchangeOffer.characterToScreen(var0, var0.logicalHeight + 15);

            for(CombatInfoListHolder var87 = (CombatInfoListHolder)var0.combatInfoList.last(); var87 != null; var87 = (CombatInfoListHolder)var0.combatInfoList.previous()) {
               CombatInfo1 var77 = var87.method1925(Client.gameCycle);
               if(var77 == null) {
                  if(var87.method1926()) {
                     var87.unlink();
                  }
               } else {
                  CombatInfo2 var12 = var87.combatInfo2;
                  SpritePixels var13 = var12.method4959();
                  SpritePixels var14 = var12.method4958();
                  int var16 = 0;
                  if(var13 != null && var14 != null) {
                     if(var12.field3536 * 2 < var14.width) {
                        var16 = var12.field3536;
                     }

                     var15 = var14.width - var16 * 2;
                  } else {
                     var15 = var12.healthScale;
                  }

                  int var17 = 255;
                  boolean var18 = true;
                  int var19 = Client.gameCycle - var77.cycle;
                  int var20 = var15 * var77.health / var12.healthScale;
                  int var21;
                  int var92;
                  if(var77.int2 > var19) {
                     var21 = var12.field3534 == 0?0:var12.field3534 * (var19 / var12.field3534);
                     var22 = var15 * var77.healthRatio / var12.healthScale;
                     var92 = var21 * (var20 - var22) / var77.int2 + var22;
                  } else {
                     var92 = var20;
                     var21 = var12.field3532 + var77.int2 - var19;
                     if(var12.field3530 >= 0) {
                        var17 = (var21 << 8) / (var12.field3532 - var12.field3530);
                     }
                  }

                  if(var77.health > 0 && var92 < 1) {
                     var92 = 1;
                  }

                  if(var13 != null && var14 != null) {
                     if(var15 == var92) {
                        var92 += var16 * 2;
                     } else {
                        var92 += var16;
                     }

                     var21 = var13.height;
                     var76 += var21;
                     var22 = var2 + Client.screenX - (var15 >> 1);
                     var23 = var3 + Client.screenY - var76;
                     var22 -= var16;
                     if(var17 >= 0 && var17 < 255) {
                        var13.drawAtOpacity(var22, var23, var17);
                        Rasterizer2D.setInnerDrawRegion(var22, var23, var92 + var22, var23 + var21);
                        var14.drawAtOpacity(var22, var23, var17);
                     } else {
                        var13.drawAt(var22, var23);
                        Rasterizer2D.setInnerDrawRegion(var22, var23, var92 + var22, var23 + var21);
                        var14.drawAt(var22, var23);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var76 += 2;
                  } else {
                     var76 += 5;
                     if(Client.screenX > -1) {
                        var21 = var2 + Client.screenX - (var15 >> 1);
                        var22 = var3 + Client.screenY - var76;
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var92, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var92 + var21, var22, var15 - var92, 5, 16711680);
                     }

                     var76 += 2;
                  }
               }
            }
         }

         if(var76 == -2) {
            var76 += 7;
         }

         var76 += var8;
         if(var1 < var75) {
            Player var88 = (Player)var0;
            if(var88.hidden) {
               return;
            }

            if(var88.skullIcon != -1 || var88.overheadIcon != -1) {
               GrandExchangeOffer.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  if(var88.skullIcon != -1) {
                     var76 += 25;
                     class132.headIconsPk[var88.skullIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var76);
                  }

                  if(var88.overheadIcon != -1) {
                     var76 += 25;
                     MouseRecorder.headIconsPrayer[var88.overheadIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var76);
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
               GrandExchangeOffer.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  var76 += DecorativeObject.headIconsHint[1].height;
                  DecorativeObject.headIconsHint[1].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var76);
               }
            }
         } else {
            NPCComposition var89 = ((NPC)var0).composition;
            if(var89.configs != null) {
               var89 = var89.transform();
            }

            if(var89.headIcon >= 0 && var89.headIcon < MouseRecorder.headIconsPrayer.length) {
               GrandExchangeOffer.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  MouseRecorder.headIconsPrayer[var89.headIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 30);
               }
            }

            if(Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               GrandExchangeOffer.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  DecorativeObject.headIconsHint[0].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var75 || !var0.field1155 && (Client.publicChatMode == 4 || !var0.field1191 && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            GrandExchangeOffer.characterToScreen(var0, var0.logicalHeight);
            if(Client.screenX > -1 && Client.overheadTextCount < Client.field939) {
               Client.overheadTextsOffsetX[Client.overheadTextCount] = class22.fontBold12.getTextWidth(var0.overhead) / 2;
               Client.overheadTextsOffsetY[Client.overheadTextCount] = class22.fontBold12.verticalSpace;
               Client.overheadTextsX[Client.overheadTextCount] = Client.screenX;
               Client.overheadTextsY[Client.overheadTextCount] = Client.screenY;
               Client.field944[Client.overheadTextCount] = var0.field1159;
               Client.field945[Client.overheadTextCount] = var0.field1158;
               Client.overheadTextsCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadTexts[Client.overheadTextCount] = var0.overhead;
               ++Client.overheadTextCount;
            }
         }

         for(int var78 = 0; var78 < 4; ++var78) {
            int var90 = var0.hitsplatCycles[var78];
            int var79 = var0.field1160[var78];
            class281 var91 = null;
            int var80 = 0;
            if(var79 >= 0) {
               if(var90 <= Client.gameCycle) {
                  continue;
               }

               var91 = FileRequest.method4638(var0.field1160[var78]);
               var80 = var91.field3580;
               if(var91 != null && var91.field3587 != null) {
                  var91 = var91.method5047();
                  if(var91 == null) {
                     var0.hitsplatCycles[var78] = -1;
                     continue;
                  }
               }
            } else if(var90 < 0) {
               continue;
            }

            var15 = var0.field1163[var78];
            class281 var81 = null;
            if(var15 >= 0) {
               var81 = FileRequest.method4638(var15);
               if(var81 != null && var81.field3587 != null) {
                  var81 = var81.method5047();
               }
            }

            if(var90 - var80 <= Client.gameCycle) {
               if(var91 == null) {
                  var0.hitsplatCycles[var78] = -1;
               } else {
                  GrandExchangeOffer.characterToScreen(var0, var0.logicalHeight / 2);
                  if(Client.screenX > -1) {
                     if(var78 == 1) {
                        Client.screenY -= 20;
                     }

                     if(var78 == 2) {
                        Client.screenX -= 15;
                        Client.screenY -= 10;
                     }

                     if(var78 == 3) {
                        Client.screenX += 15;
                        Client.screenY -= 10;
                     }

                     SpritePixels var82 = null;
                     SpritePixels var83 = null;
                     SpritePixels var84 = null;
                     SpritePixels var85 = null;
                     var22 = 0;
                     var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     int var29 = 0;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     SpritePixels var33 = null;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     int var42 = 0;
                     var82 = var91.method5048();
                     int var43;
                     if(var82 != null) {
                        var22 = var82.width;
                        var43 = var82.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var82.offsetX;
                     }

                     var83 = var91.method5074();
                     if(var83 != null) {
                        var23 = var83.width;
                        var43 = var83.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var83.offsetX;
                     }

                     var84 = var91.method5050();
                     if(var84 != null) {
                        var24 = var84.width;
                        var43 = var84.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var84.offsetX;
                     }

                     var85 = var91.method5051();
                     if(var85 != null) {
                        var25 = var85.width;
                        var43 = var85.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var85.offsetX;
                     }

                     if(var81 != null) {
                        var30 = var81.method5048();
                        if(var30 != null) {
                           var34 = var30.width;
                           var43 = var30.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var81.method5074();
                        if(var31 != null) {
                           var35 = var31.width;
                           var43 = var31.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var81.method5050();
                        if(var32 != null) {
                           var36 = var32.width;
                           var43 = var32.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.offsetX;
                        }

                        var33 = var81.method5051();
                        if(var33 != null) {
                           var37 = var33.width;
                           var43 = var33.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.offsetX;
                        }
                     }

                     Font var86 = var91.method5052();
                     if(var86 == null) {
                        var86 = UnitPriceComparator.fontPlain11;
                     }

                     Font var44;
                     if(var81 != null) {
                        var44 = var81.method5052();
                        if(var44 == null) {
                           var44 = UnitPriceComparator.fontPlain11;
                        }
                     } else {
                        var44 = UnitPriceComparator.fontPlain11;
                     }

                     String var45 = null;
                     String var46 = null;
                     boolean var47 = false;
                     int var48 = 0;
                     var45 = var91.method5043(var0.hitsplatTypes[var78]);
                     int var93 = var86.getTextWidth(var45);
                     if(var81 != null) {
                        var46 = var81.method5043(var0.field1164[var78]);
                        var48 = var44.getTextWidth(var46);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if(var23 > 0) {
                        if(var84 == null && var85 == null) {
                           var49 = 1;
                        } else {
                           var49 = var93 / var23 + 1;
                        }
                     }

                     if(var81 != null && var35 > 0) {
                        if(var32 == null && var33 == null) {
                           var50 = 1;
                        } else {
                           var50 = var48 / var35 + 1;
                        }
                     }

                     int var51 = 0;
                     int var52 = var51;
                     if(var22 > 0) {
                        var51 += var22;
                     }

                     var51 += 2;
                     int var53 = var51;
                     if(var24 > 0) {
                        var51 += var24;
                     }

                     int var54 = var51;
                     int var55 = var51;
                     int var56;
                     if(var23 > 0) {
                        var56 = var49 * var23;
                        var51 += var56;
                        var55 += (var56 - var93) / 2;
                     } else {
                        var51 += var93;
                     }

                     var56 = var51;
                     if(var25 > 0) {
                        var51 += var25;
                     }

                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62;
                     if(var81 != null) {
                        var51 += 2;
                        var57 = var51;
                        if(var34 > 0) {
                           var51 += var34;
                        }

                        var51 += 2;
                        var58 = var51;
                        if(var36 > 0) {
                           var51 += var36;
                        }

                        var59 = var51;
                        var61 = var51;
                        if(var35 > 0) {
                           var62 = var35 * var50;
                           var51 += var62;
                           var61 += (var62 - var48) / 2;
                        } else {
                           var51 += var48;
                        }

                        var60 = var51;
                        if(var37 > 0) {
                           var51 += var37;
                        }
                     }

                     var62 = var0.hitsplatCycles[var78] - Client.gameCycle;
                     int var63 = var91.field3581 - var62 * var91.field3581 / var91.field3580;
                     int var64 = var62 * var91.field3582 / var91.field3580 + -var91.field3582;
                     int var65 = var63 + (var2 + Client.screenX - (var51 >> 1));
                     int var66 = var64 + (var3 + Client.screenY - 12);
                     int var67 = var66;
                     int var68 = var42 + var66;
                     int var69 = var66 + var91.field3586 + 15;
                     int var70 = var69 - var86.minSpacing;
                     int var71 = var69 + var86.maxSpacing;
                     if(var70 < var66) {
                        var67 = var70;
                     }

                     if(var71 > var68) {
                        var68 = var71;
                     }

                     int var72 = 0;
                     int var73;
                     int var74;
                     if(var81 != null) {
                        var72 = var66 + var81.field3586 + 15;
                        var73 = var72 - var44.minSpacing;
                        var74 = var72 + var44.maxSpacing;
                        if(var73 < var67) {
                           ;
                        }

                        if(var74 > var68) {
                           ;
                        }
                     }

                     var73 = 255;
                     if(var91.field3566 >= 0) {
                        var73 = (var62 << 8) / (var91.field3580 - var91.field3566);
                     }

                     if(var73 >= 0 && var73 < 255) {
                        if(var82 != null) {
                           var82.drawAtOpacity(var52 + var65 - var26, var66, var73);
                        }

                        if(var84 != null) {
                           var84.drawAtOpacity(var65 + var53 - var28, var66, var73);
                        }

                        if(var83 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var83.drawAtOpacity(var74 * var23 + (var65 + var54 - var27), var66, var73);
                           }
                        }

                        if(var85 != null) {
                           var85.drawAtOpacity(var56 + var65 - var29, var66, var73);
                        }

                        var86.method5571(var45, var55 + var65, var69, var91.field3575, 0, var73);
                        if(var81 != null) {
                           if(var30 != null) {
                              var30.drawAtOpacity(var57 + var65 - var38, var66, var73);
                           }

                           if(var32 != null) {
                              var32.drawAtOpacity(var58 + var65 - var40, var66, var73);
                           }

                           if(var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawAtOpacity(var35 * var74 + (var59 + var65 - var39), var66, var73);
                              }
                           }

                           if(var33 != null) {
                              var33.drawAtOpacity(var65 + var60 - var41, var66, var73);
                           }

                           var44.method5571(var46, var61 + var65, var72, var81.field3575, 0, var73);
                        }
                     } else {
                        if(var82 != null) {
                           var82.drawAt(var52 + var65 - var26, var66);
                        }

                        if(var84 != null) {
                           var84.drawAt(var53 + var65 - var28, var66);
                        }

                        if(var83 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var83.drawAt(var23 * var74 + (var54 + var65 - var27), var66);
                           }
                        }

                        if(var85 != null) {
                           var85.drawAt(var65 + var56 - var29, var66);
                        }

                        var86.method5630(var45, var55 + var65, var69, var91.field3575 | -16777216, 0);
                        if(var81 != null) {
                           if(var30 != null) {
                              var30.drawAt(var65 + var57 - var38, var66);
                           }

                           if(var32 != null) {
                              var32.drawAt(var58 + var65 - var40, var66);
                           }

                           if(var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawAt(var35 * var74 + (var59 + var65 - var39), var66);
                              }
                           }

                           if(var33 != null) {
                              var33.drawAt(var65 + var60 - var41, var66);
                           }

                           var44.method5630(var46, var65 + var61, var72, var81.field3575 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
