import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("ax")
public enum class27 implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   field412(3, (byte)0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   field402(2, (byte)1),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   field403(1, (byte)2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   field404(0, (byte)3);

   @ObfuscatedName("l")
   static int[] field401;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 670823241
   )
   final int field405;
   @ObfuscatedName("n")
   final byte field406;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -500924549
   )
   static int field407;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -800670385
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static IndexedSprite field409;

   class27(int var3, byte var4) {
      this.field405 = var3;
      this.field406 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field406;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)[Lax;",
      garbageValue = "33"
   )
   static class27[] method241() {
      return new class27[]{field404, field412, field403, field402};
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1555795774"
   )
   static final void method249(boolean var0) {
      for(int var1 = 0; var1 < Client.field946; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4623()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1233 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1034[var4][var5] == Client.field1035) {
                     continue;
                  }

                  Client.field1034[var4][var5] = Client.field1035;
               }

               if(!var2.composition.field3579) {
                  var3 -= Integer.MIN_VALUE;
               }

               ScriptState.region.method2877(plane, var2.x, var2.y, class227.getTileHeight(var2.field1233 * 64 - 64 + var2.x, var2.field1233 * 64 - 64 + var2.y, plane), var2.field1233 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1284);
            }
         }
      }

   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-1870380642"
   )
   static final void method248(String var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_6);
      Client.secretPacketBuffer1.putByte(ClanMember.getLength(var0) + 1);
      Client.secretPacketBuffer1.putString(var0);
      Client.secretPacketBuffer1.putByte(var1);
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(Lbg;IIIIII)V",
      garbageValue = "521562375"
   )
   static final void method240(Actor var0, int var1, int var2, int var3, int var4, int var5) {
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

         int var74 = class95.field1507;
         int[] var7 = class95.field1511;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method3645()) {
            DState.characterToScreen(var0, var0.field1279 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3642(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3644()) {
               CombatInfo1 var10 = var9.method1690(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1691()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4398();
                  SpritePixels var13 = var11.method4400();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3377 * 2 < var13.width) {
                        var15 = var11.field3377;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field1295;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field1294 > var18) {
                     var20 = var11.field3372 == 0?0:var11.field3372 * (var18 / var11.field3372);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.field1294 + var21;
                  } else {
                     var88 = var19;
                     var20 = var10.field1294 + var11.field3373 - var18;
                     if(var11.field3371 >= 0) {
                        var16 = (var20 << 8) / (var11.field3373 - var11.field3371);
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
                        var12.method5015(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.method5015(var20, var21, var16);
                     } else {
                        var12.method5019(var20, var21);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var21 + var22);
                        var13.method5019(var20, var21);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenY > -1) {
                        Rasterizer2D.method4890(var20, var21, var88, 5, '\uff00');
                        Rasterizer2D.method4890(var88 + var20, var21, var14 - var88, 5, 16711680);
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
               DState.characterToScreen(var0, var0.field1279 + 15);
               if(Client.screenY > -1) {
                  if(var85.skullIcon != -1) {
                     class94.mapfunctions[var85.skullIcon].method5019(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class12.hitmarks[var85.overheadIcon].method5019(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field958 == 10 && var7[var1] == Client.field960) {
               DState.characterToScreen(var0, var0.field1279 + 15);
               if(Client.screenY > -1) {
                  class10.pkIcons[1].method5019(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3548 >= 0 && var86.field3548 < class12.hitmarks.length) {
               DState.characterToScreen(var0, var0.field1279 + 15);
               if(Client.screenY > -1) {
                  class12.hitmarks[var86.field3548].method5019(var2 + Client.screenY - 12, var3 + Client.screenX - 30);
               }
            }

            if(Client.field958 == 1 && Client.npcIndices[var1 - var74] == Client.field959 && Client.gameCycle % 20 < 10) {
               DState.characterToScreen(var0, var0.field1279 + 15);
               if(Client.screenY > -1) {
                  class10.pkIcons[0].method5019(var2 + Client.screenY - 12, var3 + Client.screenX - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field1148 == 4 || !var0.field1243 && (Client.field1148 == 0 || Client.field1148 == 3 || Client.field1148 == 1 && Actor.isFriended(((Player)var0).name, false))))) {
            DState.characterToScreen(var0, var0.field1279);
            if(Client.screenY > -1 && Client.field1024 < Client.field1025) {
               Client.field1029[Client.field1024] = class73.field897.method4775(var0.overhead) / 2;
               Client.field1118[Client.field1024] = class73.field897.verticalSpace;
               Client.field1026[Client.field1024] = Client.screenY;
               Client.field1201[Client.field1024] = Client.screenX;
               Client.field1030[Client.field1024] = var0.field1246;
               Client.field1031[Client.field1024] = var0.field1237;
               Client.field1032[Client.field1024] = var0.field1245;
               Client.field993[Client.field1024] = var0.overhead;
               ++Client.field1024;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1236[var75];
            class255 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = class61.method1090(var0.field1236[var75]);
               var78 = var87.field3420;
               if(var87 != null && var87.field3431 != null) {
                  var87 = var87.method4486();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1252[var75];
            class255 var79 = null;
            if(var14 >= 0) {
               var79 = class61.method1090(var14);
               if(var79 != null && var79.field3431 != null) {
                  var79 = var79.method4486();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  DState.characterToScreen(var0, var0.field1279 / 2);
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
                     var80 = var87.method4488();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4496();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4490();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4491();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4488();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4496();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4490();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4491();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4492();
                     if(var84 == null) {
                        var84 = class31.field447;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4492();
                        if(var43 == null) {
                           var43 = class31.field447;
                        }
                     } else {
                        var43 = class31.field447;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4487(var0.hitsplatTypes[var75]);
                     int var89 = var84.method4775(var44);
                     if(var79 != null) {
                        var45 = var79.method4487(var0.field1278[var75]);
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
                     int var62 = var87.field3414 - var61 * var87.field3414 / var87.field3420;
                     int var63 = var61 * var87.field3426 / var87.field3420 + -var87.field3426;
                     int var64 = var62 + (var2 + Client.screenY - (var50 >> 1));
                     int var65 = var63 + (var3 + Client.screenX - 12);
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var65 + var87.field3412 + 15;
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
                        var71 = var65 + var79.field3412 + 15;
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
                     if(var87.field3411 >= 0) {
                        var72 = (var61 << 8) / (var87.field3420 - var87.field3411);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.method5015(var51 + var64 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.method5015(var52 + var64 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5015(var64 + var53 - var26 + var73 * var22, var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.method5015(var55 + var64 - var28, var65, var72);
                        }

                        var84.method4771(var44, var64 + var54, var68, var87.field3415, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5015(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method5015(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5015(var73 * var34 + (var64 + var58 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method5015(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4771(var45, var60 + var64, var71, var79.field3415, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.method5019(var64 + var51 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.method5019(var64 + var52 - var27, var65);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5019(var64 + var53 - var26 + var22 * var73, var65);
                           }
                        }

                        if(var83 != null) {
                           var83.method5019(var55 + var64 - var28, var65);
                        }

                        var84.method4773(var44, var64 + var54, var68, var87.field3415 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5019(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method5019(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5019(var58 + var64 - var38 + var73 * var34, var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method5019(var59 + var64 - var40, var65);
                           }

                           var43.method4773(var45, var60 + var64, var71, var79.field3415 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
