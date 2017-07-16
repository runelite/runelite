import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("fz")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;
   @ObfuscatedName("a")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1686798431"
   )
   public static void method797() {
      while(true) {
         Deque var1 = class236.field3235;
         FileSystem var0;
         synchronized(class236.field3235) {
            var0 = (FileSystem)class236.field3230.popFront();
         }

         if(var0 == null) {
            return;
         }

         var0.data.method4179(var0.index, (int)var0.hash, var0.field3202, false);
      }
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(III)Lfs;",
      garbageValue = "1197080112"
   )
   static class163 method796(int var0, int var1) {
      Client.field1184.field2308 = var0;
      Client.field1184.field2311 = var1;
      Client.field1184.field2307 = 1;
      Client.field1184.field2306 = 1;
      return Client.field1184;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(Lca;IIIIII)V",
      garbageValue = "-371986604"
   )
   static final void method791(Actor var0, int var1, int var2, int var3, int var4, int var5) {
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

         int var74 = class96.field1499;
         int[] var7 = class96.field1492;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method3575()) {
            class47.characterToScreen(var0, var0.field1235 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3558(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3560()) {
               CombatInfo1 var10 = var9.method1651(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1660()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4351();
                  SpritePixels var13 = var11.method4342();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3376 * 2 < var13.width) {
                        var15 = var11.field3376;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field1282;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field1275 > var18) {
                     var20 = var11.field3363 == 0?0:var11.field3363 * (var18 / var11.field3363);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = (var19 - var21) * var20 / var10.field1275 + var21;
                  } else {
                     var88 = var19;
                     var20 = var10.field1275 + var11.field3372 - var18;
                     if(var11.field3365 >= 0) {
                        var16 = (var20 << 8) / (var11.field3372 - var11.field3365);
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
                        var12.method4989(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var21 + var22);
                        var13.method4989(var20, var21, var16);
                     } else {
                        var12.method5032(var20, var21);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var21 + var22);
                        var13.method5032(var20, var21);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenY > -1) {
                        Rasterizer2D.method4921(var20, var21, var88, 5, '\uff00');
                        Rasterizer2D.method4921(var20 + var88, var21, var14 - var88, 5, 16711680);
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
               class47.characterToScreen(var0, var0.field1235 + 15);
               if(Client.screenY > -1) {
                  if(var85.skullIcon != -1) {
                     class43.mapfunctions[var85.skullIcon].method5032(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     XItemContainer.hitmarks[var85.overheadIcon].method5032(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field1120 == 10 && var7[var1] == Client.field927) {
               class47.characterToScreen(var0, var0.field1235 + 15);
               if(Client.screenY > -1) {
                  class23.pkIcons[1].method5032(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3579 >= 0 && var86.field3579 < XItemContainer.hitmarks.length) {
               class47.characterToScreen(var0, var0.field1235 + 15);
               if(Client.screenY > -1) {
                  XItemContainer.hitmarks[var86.field3579].method5032(var2 + Client.screenY - 12, var3 + Client.screenX - 30);
               }
            }

            if(Client.field1120 == 1 && Client.npcIndices[var1 - var74] == Client.field924 && Client.gameCycle % 20 < 10) {
               class47.characterToScreen(var0, var0.field1235 + 15);
               if(Client.screenY > -1) {
                  class23.pkIcons[0].method5032(var2 + Client.screenY - 12, var3 + Client.screenX - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field1060 == 4 || !var0.field1228 && (Client.field1060 == 0 || Client.field1060 == 3 || Client.field1060 == 1 && WorldMapType3.isFriended(((Player)var0).name, false))))) {
            class47.characterToScreen(var0, var0.field1235);
            if(Client.screenY > -1 && Client.field999 < Client.field1188) {
               Client.field1004[Client.field999] = class21.field338.method4721(var0.overhead) / 2;
               Client.field1003[Client.field999] = class21.field338.verticalSpace;
               Client.field1186[Client.field999] = Client.screenY;
               Client.field1002[Client.field999] = Client.screenX;
               Client.field1005[Client.field999] = var0.field1231;
               Client.field1163[Client.field999] = var0.field1241;
               Client.field1167[Client.field999] = var0.field1230;
               Client.field1008[Client.field999] = var0.overhead;
               ++Client.field999;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1234[var75];
            class254 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = class21.method154(var0.field1234[var75]);
               var78 = var87.field3418;
               if(var87 != null && var87.field3429 != null) {
                  var87 = var87.method4431();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1237[var75];
            class254 var79 = null;
            if(var14 >= 0) {
               var79 = class21.method154(var14);
               if(var79 != null && var79.field3429 != null) {
                  var79 = var79.method4431();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  class47.characterToScreen(var0, var0.field1235 / 2);
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
                     var80 = var87.method4457();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4432();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4461();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4436();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4457();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4432();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4461();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4436();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4434();
                     if(var84 == null) {
                        var84 = class223.field2847;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4434();
                        if(var43 == null) {
                           var43 = class223.field2847;
                        }
                     } else {
                        var43 = class223.field2847;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4460(var0.hitsplatTypes[var75]);
                     int var89 = var84.method4721(var44);
                     if(var79 != null) {
                        var45 = var79.method4460(var0.field1238[var75]);
                        var47 = var43.method4721(var45);
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
                     int var62 = var87.field3417 - var61 * var87.field3417 / var87.field3418;
                     int var63 = var87.field3424 * var61 / var87.field3418 + -var87.field3424;
                     int var64 = Client.screenY + var2 - (var50 >> 1) + var62;
                     int var65 = var63 + (var3 + Client.screenX - 12);
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = 15 + var65 + var87.field3432;
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
                        var71 = var65 + 15 + var79.field3432;
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
                     if(var87.field3425 >= 0) {
                        var72 = (var61 << 8) / (var87.field3418 - var87.field3425);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.method4989(var64 + var51 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.method4989(var64 + var52 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method4989(var22 * var73 + (var53 + var64 - var26), var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.method4989(var64 + var55 - var28, var65, var72);
                        }

                        var84.method4678(var44, var54 + var64, var68, var87.field3419, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method4989(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method4989(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4989(var73 * var34 + (var58 + var64 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method4989(var59 + var64 - var40, var65, var72);
                           }

                           var43.method4678(var45, var64 + var60, var71, var79.field3419, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.method5032(var64 + var51 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.method5032(var64 + var52 - var27, var65);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5032(var22 * var73 + (var64 + var53 - var26), var65);
                           }
                        }

                        if(var83 != null) {
                           var83.method5032(var55 + var64 - var28, var65);
                        }

                        var84.method4725(var44, var54 + var64, var68, var87.field3419 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5032(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method5032(var57 + var64 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5032(var34 * var73 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method5032(var64 + var59 - var40, var65);
                           }

                           var43.method4725(var45, var64 + var60, var71, var79.field3419 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
