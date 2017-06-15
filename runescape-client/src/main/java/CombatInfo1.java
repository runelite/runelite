import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -361987895
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -582531069
   )
   int field1271;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2086385281
   )
   @Export("health")
   int health;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2146180103
   )
   static int field1274;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1369364715
   )
   int field1276;

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIIB)V",
      garbageValue = "3"
   )
   static final void method1456(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod1593()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.method4525();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class96.field1487;
         int[] var7 = class96.field1491;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method3449()) {
            class205.method3706(var0, var0.field1258 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3457(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3448()) {
               CombatInfo1 var10 = var9.method1569(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1570()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4278();
                  SpritePixels var13 = var11.method4280();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3383 * 2 < var13.width) {
                        var15 = var11.field3383;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field1276;
                  int var19 = var10.health * var14 / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field1271 > var18) {
                     var20 = var11.field3381 == 0?0:var11.field3381 * (var18 / var11.field3381);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var21 + (var19 - var21) * var20 / var10.field1271;
                  } else {
                     var88 = var19;
                     var20 = var11.field3379 + var10.field1271 - var18;
                     if(var11.field3384 >= 0) {
                        var16 = (var20 << 8) / (var11.field3379 - var11.field3384);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.field1011 - (var14 >> 1);
                  var21 = Client.field1049 + var3 - var8;
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
                        var12.method4955(var20, var21, var16);
                        Rasterizer2D.method4862(var20, var21, var88 + var20, var22 + var21);
                        var13.method4955(var20, var21, var16);
                     } else {
                        var12.method4950(var20, var21);
                        Rasterizer2D.method4862(var20, var21, var20 + var88, var22 + var21);
                        var13.method4950(var20, var21);
                     }

                     Rasterizer2D.method4833(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field1011 > -1) {
                        Rasterizer2D.method4826(var20, var21, var88, 5, '\uff00');
                        Rasterizer2D.method4826(var88 + var20, var21, var14 - var88, 5, 16711680);
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
               class205.method3706(var0, var0.field1258 + 15);
               if(Client.field1011 > -1) {
                  if(var85.skullIcon != -1) {
                     class226.field3144[var85.skullIcon].method4950(var2 + Client.field1011 - 12, Client.field1049 + var3 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class266.field3661[var85.overheadIcon].method4950(var2 + Client.field1011 - 12, Client.field1049 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field920 == 10 && Client.field922 == var7[var1]) {
               class205.method3706(var0, var0.field1258 + 15);
               if(Client.field1011 > -1) {
                  class18.field332[1].method4950(Client.field1011 + var2 - 12, Client.field1049 + var3 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.method4525();
            }

            if(var86.field3581 >= 0 && var86.field3581 < class266.field3661.length) {
               class205.method3706(var0, var0.field1258 + 15);
               if(Client.field1011 > -1) {
                  class266.field3661[var86.field3581].method4950(Client.field1011 + var2 - 12, var3 + Client.field1049 - 30);
               }
            }

            if(Client.field920 == 1 && Client.npcIndices[var1 - var74] == Client.field1133 && Client.gameCycle % 20 < 10) {
               class205.method3706(var0, var0.field1258 + 15);
               if(Client.field1011 > -1) {
                  class18.field332[0].method4950(Client.field1011 + var2 - 12, var3 + Client.field1049 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field954 == 4 || !var0.field1222 && (Client.field954 == 0 || Client.field954 == 3 || Client.field954 == 1 && class162.method2946(((Player)var0).name, false))))) {
            class205.method3706(var0, var0.field1258);
            if(Client.field1011 > -1 && Client.field1074 < Client.field1000) {
               Client.field1004[Client.field1074] = class64.field788.method4696(var0.overhead) / 2;
               Client.field1003[Client.field1074] = class64.field788.field3643;
               Client.field962[Client.field1074] = Client.field1011;
               Client.field1002[Client.field1074] = Client.field1049;
               Client.field1005[Client.field1074] = var0.field1225;
               Client.field1006[Client.field1074] = var0.field1262;
               Client.field1007[Client.field1074] = var0.field1234;
               Client.field903[Client.field1074] = var0.overhead;
               ++Client.field1074;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1228[var75];
            class254 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = class24.method200(var0.field1228[var75]);
               var78 = var87.field3418;
               if(var87 != null && var87.field3436 != null) {
                  var87 = var87.method4351();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1241[var75];
            class254 var79 = null;
            if(var14 >= 0) {
               var79 = class24.method200(var14);
               if(var79 != null && var79.field3436 != null) {
                  var79 = var79.method4351();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  class205.method3706(var0, var0.field1258 / 2);
                  if(Client.field1011 > -1) {
                     if(var75 == 1) {
                        Client.field1049 -= 20;
                     }

                     if(var75 == 2) {
                        Client.field1011 -= 15;
                        Client.field1049 -= 10;
                     }

                     if(var75 == 3) {
                        Client.field1011 += 15;
                        Client.field1049 -= 10;
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
                     var80 = var87.method4378();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4354();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4376();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4386();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4378();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4354();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4376();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4386();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4353();
                     if(var84 == null) {
                        var84 = class5.field39;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4353();
                        if(var43 == null) {
                           var43 = class5.field39;
                        }
                     } else {
                        var43 = class5.field39;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4352(var0.field1229[var75]);
                     int var89 = var84.method4696(var44);
                     if(var79 != null) {
                        var45 = var79.method4352(var0.field1232[var75]);
                        var47 = var43.method4696(var45);
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
                     int var62 = var87.field3416 - var87.field3416 * var61 / var87.field3418;
                     int var63 = -var87.field3432 + var61 * var87.field3432 / var87.field3418;
                     int var64 = Client.field1011 + var2 - (var50 >> 1) + var62;
                     int var65 = var63 + (Client.field1049 + var3 - 12);
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var87.field3426 + var65 + 15;
                     int var69 = var68 - var84.field3651;
                     int var70 = var68 + var84.field3645;
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
                        var71 = var65 + 15 + var79.field3426;
                        var72 = var71 - var43.field3651;
                        var73 = var43.field3645 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field3422 >= 0) {
                        var72 = (var61 << 8) / (var87.field3418 - var87.field3422);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.method4955(var64 + var51 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.method4955(var52 + var64 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method4955(var73 * var22 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.method4955(var55 + var64 - var28, var65, var72);
                        }

                        var84.method4633(var44, var64 + var54, var68, var87.field3433, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method4955(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method4955(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4955(var64 + var58 - var38 + var34 * var73, var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method4955(var59 + var64 - var40, var65, var72);
                           }

                           var43.method4633(var45, var60 + var64, var71, var79.field3433, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.method4950(var64 + var51 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.method4950(var64 + var52 - var27, var65);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method4950(var64 + var53 - var26 + var22 * var73, var65);
                           }
                        }

                        if(var83 != null) {
                           var83.method4950(var55 + var64 - var28, var65);
                        }

                        var84.method4647(var44, var64 + var54, var68, var87.field3433 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method4950(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method4950(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4950(var73 * var34 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method4950(var64 + var59 - var40, var65);
                           }

                           var43.method4647(var45, var60 + var64, var71, var79.field3433 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1562561442"
   )
   void method1457(int var1, int var2, int var3, int var4) {
      this.field1276 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1271 = var4;
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1276 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1271 = var4;
   }
}
