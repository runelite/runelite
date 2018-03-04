import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("slFlagSprites")
   static IndexedSprite[] slFlagSprites;
   @ObfuscatedName("d")
   @Export("objs")
   Object[] objs;
   @ObfuscatedName("z")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1368160223
   )
   int field791;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1051365509
   )
   int field790;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2080941603
   )
   int field798;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   Widget field792;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -420063761
   )
   int field794;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1712197147
   )
   int field795;
   @ObfuscatedName("x")
   @Export("string")
   String string;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1704378781
   )
   int field797;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   class245 field793;

   public ScriptEvent() {
      this.field793 = class245.field2971;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "-854225589"
   )
   public void method1084(Object[] var1) {
      this.objs = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lir;I)V",
      garbageValue = "-51349288"
   )
   public void method1085(class245 var1) {
      this.field793 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgb;I)I",
      garbageValue = "889426341"
   )
   static int method1090(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-482982652"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3386 != 0 && var3 > IndexDataBase.field3386) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3386 == 0 || var6 <= IndexDataBase.field3386)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class188.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(Lbk;IIIIII)V",
      garbageValue = "-1849337094"
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
         if(var1 < var75 && var0.field1143 == Client.gameCycle && class243.method4614((Player)var0)) {
            Player var9 = (Player)var0;
            if(var1 < var75) {
               class156.characterToScreen(var0, var0.logicalHeight + 15);
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
            class156.characterToScreen(var0, var0.logicalHeight + 15);

            for(CombatInfoListHolder var87 = (CombatInfoListHolder)var0.combatInfoList.last(); var87 != null; var87 = (CombatInfoListHolder)var0.combatInfoList.previous()) {
               CombatInfo1 var77 = var87.method1850(Client.gameCycle);
               if(var77 == null) {
                  if(var87.method1851()) {
                     var87.unlink();
                  }
               } else {
                  CombatInfo2 var12 = var87.combatInfo2;
                  SpritePixels var13 = var12.method4997();
                  SpritePixels var14 = var12.method4996();
                  int var16 = 0;
                  if(var13 != null && var14 != null) {
                     if(var12.field3529 * 2 < var14.width) {
                        var16 = var12.field3529;
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
                     var21 = var12.field3524 == 0?0:var12.field3524 * (var19 / var12.field3524);
                     var22 = var15 * var77.healthRatio / var12.healthScale;
                     var92 = var21 * (var20 - var22) / var77.int2 + var22;
                  } else {
                     var92 = var20;
                     var21 = var77.int2 + var12.field3525 - var19;
                     if(var12.field3523 >= 0) {
                        var17 = (var21 << 8) / (var12.field3525 - var12.field3523);
                     }
                  }

                  if(var77.health > 0 && var92 < 1) {
                     var92 = 1;
                  }

                  if(var13 != null && var14 != null) {
                     if(var92 == var15) {
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
                        Rasterizer2D.setInnerDrawRegion(var22, var23, var22 + var92, var23 + var21);
                        var14.drawAtOpacity(var22, var23, var17);
                     } else {
                        var13.drawAt(var22, var23);
                        Rasterizer2D.setInnerDrawRegion(var22, var23, var92 + var22, var21 + var23);
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
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21 + var92, var22, var15 - var92, 5, 16711680);
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
               class156.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  if(var88.skullIcon != -1) {
                     var76 += 25;
                     class241.headIconsPk[var88.skullIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var76);
                  }

                  if(var88.overheadIcon != -1) {
                     var76 += 25;
                     class276.headIconsPrayer[var88.overheadIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var76);
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
               class156.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  var76 += SceneTilePaint.headIconsHint[1].height;
                  SceneTilePaint.headIconsHint[1].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var76);
               }
            }
         } else {
            NPCComposition var89 = ((NPC)var0).composition;
            if(var89.configs != null) {
               var89 = var89.transform();
            }

            if(var89.field3721 >= 0 && var89.field3721 < class276.headIconsPrayer.length) {
               class156.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  class276.headIconsPrayer[var89.field3721].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 30);
               }
            }

            if(Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               class156.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  SceneTilePaint.headIconsHint[0].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var75 || !var0.field1154 && (Client.publicChatMode == 4 || !var0.field1153 && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            class156.characterToScreen(var0, var0.logicalHeight);
            if(Client.screenX > -1 && Client.overheadTextCount < Client.field938) {
               Client.overheadTextsOffsetX[Client.overheadTextCount] = DecorativeObject.fontBold12.getTextWidth(var0.overhead) / 2;
               Client.overheadTextsOffsetY[Client.overheadTextCount] = DecorativeObject.fontBold12.verticalSpace;
               Client.overheadTextsX[Client.overheadTextCount] = Client.screenX;
               Client.overheadTextsY[Client.overheadTextCount] = Client.screenY;
               Client.field943[Client.overheadTextCount] = var0.field1156;
               Client.field915[Client.overheadTextCount] = var0.field1196;
               Client.overheadTextsCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadTexts[Client.overheadTextCount] = var0.overhead;
               ++Client.overheadTextCount;
            }
         }

         for(int var78 = 0; var78 < 4; ++var78) {
            int var90 = var0.hitsplatCycles[var78];
            int var79 = var0.field1144[var78];
            class281 var91 = null;
            int var80 = 0;
            if(var79 >= 0) {
               if(var90 <= Client.gameCycle) {
                  continue;
               }

               var91 = Permission.method4651(var0.field1144[var78]);
               var80 = var91.field3572;
               if(var91 != null && var91.field3583 != null) {
                  var91 = var91.method5082();
                  if(var91 == null) {
                     var0.hitsplatCycles[var78] = -1;
                     continue;
                  }
               }
            } else if(var90 < 0) {
               continue;
            }

            var15 = var0.field1162[var78];
            class281 var81 = null;
            if(var15 >= 0) {
               var81 = Permission.method4651(var15);
               if(var81 != null && var81.field3583 != null) {
                  var81 = var81.method5082();
               }
            }

            if(var90 - var80 <= Client.gameCycle) {
               if(var91 == null) {
                  var0.hitsplatCycles[var78] = -1;
               } else {
                  class156.characterToScreen(var0, var0.logicalHeight / 2);
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
                     var82 = var91.method5084();
                     int var43;
                     if(var82 != null) {
                        var22 = var82.width;
                        var43 = var82.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var82.offsetX;
                     }

                     var83 = var91.method5085();
                     if(var83 != null) {
                        var23 = var83.width;
                        var43 = var83.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var83.offsetX;
                     }

                     var84 = var91.method5086();
                     if(var84 != null) {
                        var24 = var84.width;
                        var43 = var84.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var84.offsetX;
                     }

                     var85 = var91.method5097();
                     if(var85 != null) {
                        var25 = var85.width;
                        var43 = var85.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var85.offsetX;
                     }

                     if(var81 != null) {
                        var30 = var81.method5084();
                        if(var30 != null) {
                           var34 = var30.width;
                           var43 = var30.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var81.method5085();
                        if(var31 != null) {
                           var35 = var31.width;
                           var43 = var31.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var81.method5086();
                        if(var32 != null) {
                           var36 = var32.width;
                           var43 = var32.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.offsetX;
                        }

                        var33 = var81.method5097();
                        if(var33 != null) {
                           var37 = var33.width;
                           var43 = var33.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.offsetX;
                        }
                     }

                     Font var86 = var91.method5088();
                     if(var86 == null) {
                        var86 = class41.fontPlain11;
                     }

                     Font var44;
                     if(var81 != null) {
                        var44 = var81.method5088();
                        if(var44 == null) {
                           var44 = class41.fontPlain11;
                        }
                     } else {
                        var44 = class41.fontPlain11;
                     }

                     String var45 = null;
                     String var46 = null;
                     boolean var47 = false;
                     int var48 = 0;
                     var45 = var91.method5083(var0.hitsplatTypes[var78]);
                     int var93 = var86.getTextWidth(var45);
                     if(var81 != null) {
                        var46 = var81.method5083(var0.field1165[var78]);
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
                        var56 = var23 * var49;
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
                     int var63 = var91.field3584 - var62 * var91.field3584 / var91.field3572;
                     int var64 = var62 * var91.field3578 / var91.field3572 + -var91.field3578;
                     int var65 = var63 + (var2 + Client.screenX - (var51 >> 1));
                     int var66 = var3 + Client.screenY - 12 + var64;
                     int var67 = var66;
                     int var68 = var66 + var42;
                     int var69 = var66 + var91.field3582 + 15;
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
                        var72 = var66 + var81.field3582 + 15;
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
                     if(var91.field3586 >= 0) {
                        var73 = (var62 << 8) / (var91.field3572 - var91.field3586);
                     }

                     if(var73 >= 0 && var73 < 255) {
                        if(var82 != null) {
                           var82.drawAtOpacity(var52 + var65 - var26, var66, var73);
                        }

                        if(var84 != null) {
                           var84.drawAtOpacity(var53 + var65 - var28, var66, var73);
                        }

                        if(var83 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var83.drawAtOpacity(var74 * var23 + (var54 + var65 - var27), var66, var73);
                           }
                        }

                        if(var85 != null) {
                           var85.drawAtOpacity(var65 + var56 - var29, var66, var73);
                        }

                        var86.method5618(var45, var65 + var55, var69, var91.field3569, 0, var73);
                        if(var81 != null) {
                           if(var30 != null) {
                              var30.drawAtOpacity(var65 + var57 - var38, var66, var73);
                           }

                           if(var32 != null) {
                              var32.drawAtOpacity(var58 + var65 - var40, var66, var73);
                           }

                           if(var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawAtOpacity(var35 * var74 + (var65 + var59 - var39), var66, var73);
                              }
                           }

                           if(var33 != null) {
                              var33.drawAtOpacity(var65 + var60 - var41, var66, var73);
                           }

                           var44.method5618(var46, var65 + var61, var72, var81.field3569, 0, var73);
                        }
                     } else {
                        if(var82 != null) {
                           var82.drawAt(var65 + var52 - var26, var66);
                        }

                        if(var84 != null) {
                           var84.drawAt(var65 + var53 - var28, var66);
                        }

                        if(var83 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var83.drawAt(var74 * var23 + (var65 + var54 - var27), var66);
                           }
                        }

                        if(var85 != null) {
                           var85.drawAt(var56 + var65 - var29, var66);
                        }

                        var86.method5689(var45, var55 + var65, var69, var91.field3569 | -16777216, 0);
                        if(var81 != null) {
                           if(var30 != null) {
                              var30.drawAt(var57 + var65 - var38, var66);
                           }

                           if(var32 != null) {
                              var32.drawAt(var65 + var58 - var40, var66);
                           }

                           if(var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawAt(var74 * var35 + (var65 + var59 - var39), var66);
                              }
                           }

                           if(var33 != null) {
                              var33.drawAt(var65 + var60 - var41, var66);
                           }

                           var44.method5689(var46, var61 + var65, var72, var81.field3569 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1178668234"
   )
   static final void method1092() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            CombatInfoListHolder.method1860(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
