import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("SceneComposition")
public class SceneComposition extends AbstractScene {
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgh;Lgh;I)V",
      garbageValue = "-77669356"
   )
   @Export("decode")
   void decode(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field476.field472) {
         throw new IllegalStateException("");
      } else {
         super.field377 = var2.readUnsignedByte();
         super.field378 = var2.readUnsignedByte();
         super.field383 = var2.readUnsignedShort();
         super.field374 = var2.readUnsignedShort();
         super.field380 = var2.readUnsignedShort();
         super.field376 = var2.readUnsignedShort();
         super.field378 = Math.min(super.field378, 4);
         super.field379 = new short[1][64][64];
         super.field375 = new short[super.field378][64][64];
         super.field381 = new byte[super.field378][64][64];
         super.field382 = new byte[super.field378][64][64];
         super.field384 = new SceneMapObj[super.field378][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field462.field463) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field380 && var5 == super.field376) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method241(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof SceneComposition)) {
         return false;
      } else {
         SceneComposition var2 = (SceneComposition)var1;
         return super.field380 == var2.field380 && super.field376 == var2.field376;
      }
   }

   public int hashCode() {
      return super.field380 | super.field376 << 8;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;B)I",
      garbageValue = "0"
   )
   static int method170(PacketBuffer var0) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "1024436922"
   )
   @Export("encodeStringCp1252")
   public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(Lbr;IIIIII)V",
      garbageValue = "-1640365653"
   )
   static final void method168(Actor var0, int var1, int var2, int var3, int var4, int var5) {
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

         int var74 = class94.playerIndexesCount;
         int[] var7 = class94.playerIndices;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.isEmpty()) {
            Ignore.characterToScreen(var0, var0.field1136 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.last(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.previous()) {
               CombatInfo1 var10 = var9.method1621(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1622()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4549();
                  SpritePixels var13 = var11.method4536();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3445 * 2 < var13.width) {
                        var15 = var11.field3445;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.cycle;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.int2 > var18) {
                     var20 = var11.field3450 == 0?0:var11.field3450 * (var18 / var11.field3450);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.int2 + var21;
                  } else {
                     var88 = var19;
                     var20 = var10.int2 + var11.field3451 - var18;
                     if(var11.field3449 >= 0) {
                        var16 = (var20 << 8) / (var11.field3451 - var11.field3449);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.screenY - (var14 >> 1);
                  var21 = var3 + Client.screenX - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var88 == var14) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method5211(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var88 + var20, var21 + var22);
                        var13.method5211(var20, var21, var16);
                     } else {
                        var12.drawAt(var20, var21);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.drawAt(var20, var21);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenY > -1) {
                        Rasterizer2D.Rasterizer2D_fillRectangle(var20, var21, var88, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var88 + var20, var21, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            Player var85 = (Player)var0;
            if(var85.hidden) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               Ignore.characterToScreen(var0, var0.field1136 + 15);
               if(Client.screenY > -1) {
                  if(var85.skullIcon != -1) {
                     GEItemNameComparator.headIconsPk[var85.skullIcon].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     UnitPriceComparator.headIconsPrayer[var85.overheadIcon].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
               Ignore.characterToScreen(var0, var0.field1136 + 15);
               if(Client.screenY > -1) {
                  RenderOverview.headIconsHint[1].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3647 >= 0 && var86.field3647 < UnitPriceComparator.headIconsPrayer.length) {
               Ignore.characterToScreen(var0, var0.field1136 + 15);
               if(Client.screenY > -1) {
                  UnitPriceComparator.headIconsPrayer[var86.field3647].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - 30);
               }
            }

            if(Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var74] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               Ignore.characterToScreen(var0, var0.field1136 + 15);
               if(Client.screenY > -1) {
                  RenderOverview.headIconsHint[0].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.publicChatMode == 4 || !var0.field1122 && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && class48.isFriended(((Player)var0).name, false))))) {
            Ignore.characterToScreen(var0, var0.field1136);
            if(Client.screenY > -1 && Client.field921 < Client.field1100) {
               Client.field926[Client.field921] = Friend.fontBold12.method4886(var0.overhead) / 2;
               Client.field925[Client.field921] = Friend.fontBold12.verticalSpace;
               Client.field923[Client.field921] = Client.screenY;
               Client.field924[Client.field921] = Client.screenX;
               Client.field927[Client.field921] = var0.field1179;
               Client.field900[Client.field921] = var0.field1140;
               Client.field929[Client.field921] = var0.overheadTextCyclesRemaining;
               Client.field997[Client.field921] = var0.overhead;
               ++Client.field921;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1158[var75];
            class265 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = IndexData.method4378(var0.field1158[var75]);
               var78 = var87.field3500;
               if(var87 != null && var87.field3505 != null) {
                  var87 = var87.method4625();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1161[var75];
            class265 var79 = null;
            if(var14 >= 0) {
               var79 = IndexData.method4378(var14);
               if(var79 != null && var79.field3505 != null) {
                  var79 = var79.method4625();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  Ignore.characterToScreen(var0, var0.field1136 / 2);
                  if(Client.screenY > -1) {
                     if(var75 == 1) {
                        Client.screenX -= 20;
                     }

                     if(var75 == 2) {
                        Client.screenY -= 15;
                        Client.screenX -= 10;
                     }

                     if(var75 == 3) {
                        Client.screenY += 15;
                        Client.screenX -= 10;
                     }

                     SpritePixels var80 = null;
                     SpritePixels var81 = null;
                     SpritePixels var82 = null;
                     SpritePixels var83 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var80 = var87.method4627();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4628();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4644();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4629();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4627();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4628();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4644();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4629();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4631();
                     if(var84 == null) {
                        var84 = class56.fontPlain11;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4631();
                        if(var43 == null) {
                           var43 = class56.fontPlain11;
                        }
                     } else {
                        var43 = class56.fontPlain11;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4626(var0.hitsplatTypes[var75]);
                     int var89 = var84.method4886(var44);
                     if(var79 != null) {
                        var45 = var79.method4626(var0.field1146[var75]);
                        var47 = var43.method4886(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var82 == null && var83 == null) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(var79 != null && var34 > 0) {
                        if(var31 == null && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = var47 / var34 + 1;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var22 * var48;
                        var50 += var55;
                        var54 += (var55 - var89) / 2;
                     } else {
                        var50 += var89;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var79 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var49 * var34;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.hitsplatCycles[var75] - Client.gameCycle;
                     int var62 = var87.field3486 - var61 * var87.field3486 / var87.field3500;
                     int var63 = var61 * var87.field3496 / var87.field3500 + -var87.field3496;
                     int var64 = var62 + (var2 + Client.screenY - (var50 >> 1));
                     int var65 = var3 + Client.screenX - 12 + var63;
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var65 + var87.field3494 + 15;
                     int var69 = var68 - var84.minSpacing;
                     int var70 = var68 + var84.maxSpacing;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var79 != null) {
                        var71 = var65 + var79.field3494 + 15;
                        var72 = var71 - var43.minSpacing;
                        var73 = var71 + var43.maxSpacing;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field3501 >= 0) {
                        var72 = (var61 << 8) / (var87.field3500 - var87.field3501);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.method5211(var64 + var51 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.method5211(var52 + var64 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5211(var73 * var22 + (var53 + var64 - var26), var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.method5211(var55 + var64 - var28, var65, var72);
                        }

                        var84.method4892(var44, var64 + var54, var68, var87.field3492, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5211(var56 + var64 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method5211(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5211(var34 * var73 + (var58 + var64 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method5211(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4892(var45, var60 + var64, var71, var79.field3492, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.drawAt(var51 + var64 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.drawAt(var52 + var64 - var27, var65);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.drawAt(var22 * var73 + (var53 + var64 - var26), var65);
                           }
                        }

                        if(var83 != null) {
                           var83.drawAt(var64 + var55 - var28, var65);
                        }

                        var84.method4891(var44, var54 + var64, var68, var87.field3492 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.drawAt(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.drawAt(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.drawAt(var73 * var34 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.drawAt(var59 + var64 - var40, var65);
                           }

                           var43.method4891(var45, var60 + var64, var71, var79.field3492 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "([Lhz;IB)V",
      garbageValue = "8"
   )
   static final void method165(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method165(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(GraphicsObject.loadWidget(var5)) {
                     method165(Widget.widgets[var5], var1);
                  }
               }
            }

            ScriptEvent var6;
            if(var1 == 0 && var3.field2799 != null) {
               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.objs = var3.field2799;
               CacheFile.method2350(var6);
            }

            if(var1 == 1 && var3.field2856 != null) {
               if(var3.index >= 0) {
                  Widget var7 = VertexNormal.getWidget(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
                     continue;
                  }
               }

               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.objs = var3.field2856;
               CacheFile.method2350(var6);
            }
         }
      }

   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-1807723657"
   )
   static String method167(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(MilliTimer.sessionToken != null) {
         var3 = "/p=" + MilliTimer.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + BaseVarType.field31 + var3 + "/";
   }
}
