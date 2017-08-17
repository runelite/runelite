import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class21 {
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      longValue = 7266085426959268199L
   )
   static long field345;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 51863041
   )
   static int field344;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lfc;I)V",
      garbageValue = "466578220"
   )
   static final void method169(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
               var8[var1].flags[var9 + var2][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var13 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  class41.loadTerrain(var13, var1, var2 + Occluder.method2918(var11 & 7, var12 & 7, var7), var3 + CombatInfo1.method1551(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class41.loadTerrain(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   static final void method167() {
      for(int var0 = 0; var0 < Client.field958; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class268.method4890(var2, var2.composition.field3543);
         }
      }

   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(Lcr;IIIIII)V",
      garbageValue = "2118801866"
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

         int var74 = class97.field1510;
         int[] var7 = class97.field1511;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method3567()) {
            class31.characterToScreen(var0, var0.field1231 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3572(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3589()) {
               CombatInfo1 var10 = var9.method1680(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1677()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4423();
                  SpritePixels var13 = var11.method4427();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3361 * 2 < var13.width) {
                        var15 = var11.field3361;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field1283;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field1279 > var18) {
                     var20 = var11.field3360 == 0?0:var11.field3360 * (var18 / var11.field3360);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.field1279 + var21;
                  } else {
                     var88 = var19;
                     var20 = var11.field3357 + var10.field1279 - var18;
                     if(var11.field3355 >= 0) {
                        var16 = (var20 << 8) / (var11.field3357 - var11.field3355);
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
                        var12.method5097(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.method5097(var20, var21, var16);
                     } else {
                        var12.method5172(var20, var21);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.method5172(var20, var21);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenY > -1) {
                        Rasterizer2D.method4968(var20, var21, var88, 5, '\uff00');
                        Rasterizer2D.method4968(var88 + var20, var21, var14 - var88, 5, 16711680);
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
               class31.characterToScreen(var0, var0.field1231 + 15);
               if(Client.screenY > -1) {
                  if(var85.skullIcon != -1) {
                     RSCanvas.mapfunctions[var85.skullIcon].method5172(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class27.hitmarks[var85.overheadIcon].method5172(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field951 == 10 && var7[var1] == Client.field953) {
               class31.characterToScreen(var0, var0.field1231 + 15);
               if(Client.screenY > -1) {
                  class13.pkIcons[1].method5172(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3540 >= 0 && var86.field3540 < class27.hitmarks.length) {
               class31.characterToScreen(var0, var0.field1231 + 15);
               if(Client.screenY > -1) {
                  class27.hitmarks[var86.field3540].method5172(var2 + Client.screenY - 12, var3 + Client.screenX - 30);
               }
            }

            if(Client.field951 == 1 && Client.npcIndices[var1 - var74] == Client.field952 && Client.gameCycle % 20 < 10) {
               class31.characterToScreen(var0, var0.field1231 + 15);
               if(Client.screenY > -1) {
                  class13.pkIcons[0].method5172(var2 + Client.screenY - 12, var3 + Client.screenX - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field1097 == 4 || !var0.field1273 && (Client.field1097 == 0 || Client.field1097 == 3 || Client.field1097 == 1 && WorldMapType2.isFriended(((Player)var0).name, false))))) {
            class31.characterToScreen(var0, var0.field1231);
            if(Client.screenY > -1 && Client.field936 < Client.field1053) {
               Client.field1165[Client.field936] = class61.field765.method4775(var0.overhead) / 2;
               Client.field1022[Client.field936] = class61.field765.verticalSpace;
               Client.field1019[Client.field936] = Client.screenY;
               Client.field1021[Client.field936] = Client.screenX;
               Client.field1130[Client.field936] = var0.field1235;
               Client.field1025[Client.field936] = var0.field1236;
               Client.field1026[Client.field936] = var0.field1274;
               Client.field1190[Client.field936] = var0.overhead;
               ++Client.field936;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1238[var75];
            class255 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = BuildType.method4099(var0.field1238[var75]);
               var78 = var87.field3410;
               if(var87 != null && var87.field3421 != null) {
                  var87 = var87.method4513();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1272[var75];
            class255 var79 = null;
            if(var14 >= 0) {
               var79 = BuildType.method4099(var14);
               if(var79 != null && var79.field3421 != null) {
                  var79 = var79.method4513();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  class31.characterToScreen(var0, var0.field1231 / 2);
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
                     var80 = var87.method4515();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4510();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4517();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4518();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4515();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4510();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4517();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4518();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4521();
                     if(var84 == null) {
                        var84 = VertexNormal.field2006;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4521();
                        if(var43 == null) {
                           var43 = VertexNormal.field2006;
                        }
                     } else {
                        var43 = VertexNormal.field2006;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4514(var0.hitsplatTypes[var75]);
                     int var89 = var84.method4775(var44);
                     if(var79 != null) {
                        var45 = var79.method4514(var0.field1252[var75]);
                        var47 = var43.method4775(var45);
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
                        var55 = var48 * var22;
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
                           var61 = var34 * var49;
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
                     int var62 = var87.field3420 - var61 * var87.field3420 / var87.field3410;
                     int var63 = var61 * var87.field3416 / var87.field3410 + -var87.field3416;
                     int var64 = var62 + (var2 + Client.screenY - (var50 >> 1));
                     int var65 = var3 + Client.screenX - 12 + var63;
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var65 + var87.field3423 + 15;
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
                        var71 = var65 + var79.field3423 + 15;
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
                     if(var87.field3417 >= 0) {
                        var72 = (var61 << 8) / (var87.field3410 - var87.field3417);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.method5097(var64 + var51 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.method5097(var64 + var52 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5097(var53 + var64 - var26 + var73 * var22, var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.method5097(var64 + var55 - var28, var65, var72);
                        }

                        var84.method4781(var44, var54 + var64, var68, var87.field3409, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5097(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method5097(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5097(var34 * var73 + (var64 + var58 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method5097(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4781(var45, var64 + var60, var71, var79.field3409, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.method5172(var64 + var51 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.method5172(var64 + var52 - var27, var65);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5172(var53 + var64 - var26 + var73 * var22, var65);
                           }
                        }

                        if(var83 != null) {
                           var83.method5172(var55 + var64 - var28, var65);
                        }

                        var84.method4780(var44, var54 + var64, var68, var87.field3409 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5172(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method5172(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5172(var34 * var73 + (var58 + var64 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method5172(var59 + var64 - var40, var65);
                           }

                           var43.method4780(var45, var64 + var60, var71, var79.field3409 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
