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

         int var75 = class96.field1487;
         int[] var7 = class96.field1491;
         int var8 = 3;
         int var9;
         int var10;
         int var11;
         int var22;
         int var23;
         if(!var0.combatInfoList.method3449()) {
            class205.method3706(var0, var0.field1258 + 15);

            for(CombatInfoListHolder var12 = (CombatInfoListHolder)var0.combatInfoList.method3457(); var12 != null; var12 = (CombatInfoListHolder)var0.combatInfoList.method3448()) {
               CombatInfo1 var13 = var12.method1569(Client.gameCycle);
               if(var13 == null) {
                  if(var12.method1570()) {
                     var12.unlink();
                  }
               } else {
                  CombatInfo2 var14 = var12.combatInfo2;
                  SpritePixels var15 = var14.method4278();
                  SpritePixels var16 = var14.method4280();
                  int var17 = 0;
                  if(var15 != null && var16 != null) {
                     if(var14.field3383 * 2 < var16.width) {
                        var17 = var14.field3383;
                     }

                     var9 = var16.width - var17 * 2;
                  } else {
                     var9 = var14.healthScale;
                  }

                  int var18 = 255;
                  boolean var19 = true;
                  int var20 = Client.gameCycle - var13.field1276;
                  int var21 = var13.health * var9 / var14.healthScale;
                  if(var13.field1271 > var20) {
                     var22 = var14.field3381 == 0?0:var14.field3381 * (var20 / var14.field3381);
                     var10 = var9 * var13.healthRatio / var14.healthScale;
                     var23 = var10 + (var21 - var10) * var22 / var13.field1271;
                  } else {
                     var23 = var21;
                     var22 = var14.field3379 + var13.field1271 - var20;
                     if(var14.field3384 >= 0) {
                        var18 = (var22 << 8) / (var14.field3379 - var14.field3384);
                     }
                  }

                  if(var13.health > 0 && var23 < 1) {
                     var23 = 1;
                  }

                  var22 = var2 + Client.field1011 - (var9 >> 1);
                  var10 = Client.field1049 + var3 - var8;
                  if(var15 != null && var16 != null) {
                     var22 -= var17;
                     if(var23 == var9) {
                        var23 += var17 * 2;
                     } else {
                        var23 += var17;
                     }

                     var11 = var15.height;
                     var8 += var11;
                     if(var18 >= 0 && var18 < 255) {
                        var15.method4955(var22, var10, var18);
                        Rasterizer2D.method4862(var22, var10, var23 + var22, var11 + var10);
                        var16.method4955(var22, var10, var18);
                     } else {
                        var15.method4950(var22, var10);
                        Rasterizer2D.method4862(var22, var10, var22 + var23, var11 + var10);
                        var16.method4950(var22, var10);
                     }

                     Rasterizer2D.method4833(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field1011 > -1) {
                        Rasterizer2D.method4826(var22, var10, var23, 5, '\uff00');
                        Rasterizer2D.method4826(var23 + var22, var10, var9 - var23, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var75) {
            Player var78 = (Player)var0;
            if(var78.hidden) {
               return;
            }

            if(var78.skullIcon != -1 || var78.overheadIcon != -1) {
               class205.method3706(var0, var0.field1258 + 15);
               if(Client.field1011 > -1) {
                  if(var78.skullIcon != -1) {
                     class226.field3144[var78.skullIcon].method4950(var2 + Client.field1011 - 12, Client.field1049 + var3 - var8);
                     var8 += 25;
                  }

                  if(var78.overheadIcon != -1) {
                     class266.field3661[var78.overheadIcon].method4950(var2 + Client.field1011 - 12, Client.field1049 + var3 - var8);
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
            NPCComposition var76 = ((NPC)var0).composition;
            if(var76.configs != null) {
               var76 = var76.method4525();
            }

            if(var76.field3581 >= 0 && var76.field3581 < class266.field3661.length) {
               class205.method3706(var0, var0.field1258 + 15);
               if(Client.field1011 > -1) {
                  class266.field3661[var76.field3581].method4950(Client.field1011 + var2 - 12, var3 + Client.field1049 - 30);
               }
            }

            if(Client.field920 == 1 && Client.npcIndices[var1 - var75] == Client.field1133 && Client.gameCycle % 20 < 10) {
               class205.method3706(var0, var0.field1258 + 15);
               if(Client.field1011 > -1) {
                  class18.field332[0].method4950(Client.field1011 + var2 - 12, var3 + Client.field1049 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var75 || !var0.inSequence && (Client.field954 == 4 || !var0.field1222 && (Client.field954 == 0 || Client.field954 == 3 || Client.field954 == 1 && class162.method2946(((Player)var0).name, false))))) {
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

         for(int var79 = 0; var79 < 4; ++var79) {
            int var77 = var0.hitsplatCycles[var79];
            int var80 = var0.field1228[var79];
            class254 var81 = null;
            int var82 = 0;
            if(var80 >= 0) {
               if(var77 <= Client.gameCycle) {
                  continue;
               }

               var81 = class24.method200(var0.field1228[var79]);
               var82 = var81.field3418;
               if(var81 != null && var81.field3436 != null) {
                  var81 = var81.method4351();
                  if(var81 == null) {
                     var0.hitsplatCycles[var79] = -1;
                     continue;
                  }
               }
            } else if(var77 < 0) {
               continue;
            }

            var9 = var0.field1241[var79];
            class254 var83 = null;
            if(var9 >= 0) {
               var83 = class24.method200(var9);
               if(var83 != null && var83.field3436 != null) {
                  var83 = var83.method4351();
               }
            }

            if(var77 - var82 <= Client.gameCycle) {
               if(var81 == null) {
                  var0.hitsplatCycles[var79] = -1;
               } else {
                  class205.method3706(var0, var0.field1258 / 2);
                  if(Client.field1011 > -1) {
                     if(var79 == 1) {
                        Client.field1049 -= 20;
                     }

                     if(var79 == 2) {
                        Client.field1011 -= 15;
                        Client.field1049 -= 10;
                     }

                     if(var79 == 3) {
                        Client.field1011 += 15;
                        Client.field1049 -= 10;
                     }

                     SpritePixels var84 = null;
                     SpritePixels var85 = null;
                     SpritePixels var86 = null;
                     SpritePixels var87 = null;
                     var10 = 0;
                     var11 = 0;
                     var22 = 0;
                     var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     SpritePixels var28 = null;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     int var32 = 0;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     var84 = var81.method4378();
                     int var41;
                     if(var84 != null) {
                        var10 = var84.width;
                        var41 = var84.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var24 = var84.offsetX;
                     }

                     var85 = var81.method4354();
                     if(var85 != null) {
                        var11 = var85.width;
                        var41 = var85.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var25 = var85.offsetX;
                     }

                     var86 = var81.method4376();
                     if(var86 != null) {
                        var22 = var86.width;
                        var41 = var86.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var26 = var86.offsetX;
                     }

                     var87 = var81.method4386();
                     if(var87 != null) {
                        var23 = var87.width;
                        var41 = var87.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var27 = var87.offsetX;
                     }

                     if(var83 != null) {
                        var28 = var83.method4378();
                        if(var28 != null) {
                           var32 = var28.width;
                           var41 = var28.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var36 = var28.offsetX;
                        }

                        var29 = var83.method4354();
                        if(var29 != null) {
                           var33 = var29.width;
                           var41 = var29.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var83.method4376();
                        if(var30 != null) {
                           var34 = var30.width;
                           var41 = var30.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var83.method4386();
                        if(var31 != null) {
                           var35 = var31.width;
                           var41 = var31.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var39 = var31.offsetX;
                        }
                     }

                     Font var42 = var81.method4353();
                     if(var42 == null) {
                        var42 = class5.field39;
                     }

                     Font var43;
                     if(var83 != null) {
                        var43 = var83.method4353();
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
                     var44 = var81.method4352(var0.field1229[var79]);
                     int var48 = var42.method4696(var44);
                     if(var83 != null) {
                        var45 = var83.method4352(var0.field1232[var79]);
                        var47 = var43.method4696(var45);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if(var11 > 0) {
                        if(var86 == null && var87 == null) {
                           var49 = 1;
                        } else {
                           var49 = var48 / var11 + 1;
                        }
                     }

                     if(var83 != null && var33 > 0) {
                        if(var30 == null && var31 == null) {
                           var50 = 1;
                        } else {
                           var50 = var47 / var33 + 1;
                        }
                     }

                     int var51 = 0;
                     int var52 = var51;
                     if(var10 > 0) {
                        var51 += var10;
                     }

                     var51 += 2;
                     int var53 = var51;
                     if(var22 > 0) {
                        var51 += var22;
                     }

                     int var54 = var51;
                     int var55 = var51;
                     int var56;
                     if(var11 > 0) {
                        var56 = var49 * var11;
                        var51 += var56;
                        var55 += (var56 - var48) / 2;
                     } else {
                        var51 += var48;
                     }

                     var56 = var51;
                     if(var23 > 0) {
                        var51 += var23;
                     }

                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62;
                     if(var83 != null) {
                        var51 += 2;
                        var57 = var51;
                        if(var32 > 0) {
                           var51 += var32;
                        }

                        var51 += 2;
                        var58 = var51;
                        if(var34 > 0) {
                           var51 += var34;
                        }

                        var59 = var51;
                        var61 = var51;
                        if(var33 > 0) {
                           var62 = var50 * var33;
                           var51 += var62;
                           var61 += (var62 - var47) / 2;
                        } else {
                           var51 += var47;
                        }

                        var60 = var51;
                        if(var35 > 0) {
                           var51 += var35;
                        }
                     }

                     var62 = var0.hitsplatCycles[var79] - Client.gameCycle;
                     int var63 = var81.field3416 - var81.field3416 * var62 / var81.field3418;
                     int var64 = -var81.field3432 + var62 * var81.field3432 / var81.field3418;
                     int var65 = Client.field1011 + var2 - (var51 >> 1) + var63;
                     int var66 = var64 + (Client.field1049 + var3 - 12);
                     int var67 = var66;
                     int var68 = var40 + var66;
                     int var69 = var81.field3426 + var66 + 15;
                     int var70 = var69 - var42.field3651;
                     int var71 = var69 + var42.field3645;
                     if(var70 < var66) {
                        var67 = var70;
                     }

                     if(var71 > var68) {
                        var68 = var71;
                     }

                     int var72 = 0;
                     int var73;
                     int var74;
                     if(var83 != null) {
                        var72 = var66 + 15 + var83.field3426;
                        var73 = var72 - var43.field3651;
                        var74 = var43.field3645 + var72;
                        if(var73 < var67) {
                           ;
                        }

                        if(var74 > var68) {
                           ;
                        }
                     }

                     var73 = 255;
                     if(var81.field3422 >= 0) {
                        var73 = (var62 << 8) / (var81.field3418 - var81.field3422);
                     }

                     if(var73 >= 0 && var73 < 255) {
                        if(var84 != null) {
                           var84.method4955(var65 + var52 - var24, var66, var73);
                        }

                        if(var86 != null) {
                           var86.method4955(var53 + var65 - var26, var66, var73);
                        }

                        if(var85 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var85.method4955(var74 * var11 + (var65 + var54 - var25), var66, var73);
                           }
                        }

                        if(var87 != null) {
                           var87.method4955(var56 + var65 - var27, var66, var73);
                        }

                        var42.method4633(var44, var65 + var55, var69, var81.field3433, 0, var73);
                        if(var83 != null) {
                           if(var28 != null) {
                              var28.method4955(var65 + var57 - var36, var66, var73);
                           }

                           if(var30 != null) {
                              var30.method4955(var58 + var65 - var38, var66, var73);
                           }

                           if(var29 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var29.method4955(var65 + var59 - var37 + var33 * var74, var66, var73);
                              }
                           }

                           if(var31 != null) {
                              var31.method4955(var60 + var65 - var39, var66, var73);
                           }

                           var43.method4633(var45, var61 + var65, var72, var83.field3433, 0, var73);
                        }
                     } else {
                        if(var84 != null) {
                           var84.method4950(var65 + var52 - var24, var66);
                        }

                        if(var86 != null) {
                           var86.method4950(var65 + var53 - var26, var66);
                        }

                        if(var85 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var85.method4950(var65 + var54 - var25 + var11 * var74, var66);
                           }
                        }

                        if(var87 != null) {
                           var87.method4950(var56 + var65 - var27, var66);
                        }

                        var42.method4647(var44, var65 + var55, var69, var81.field3433 | -16777216, 0);
                        if(var83 != null) {
                           if(var28 != null) {
                              var28.method4950(var65 + var57 - var36, var66);
                           }

                           if(var30 != null) {
                              var30.method4950(var65 + var58 - var38, var66);
                           }

                           if(var29 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var29.method4950(var74 * var33 + (var65 + var59 - var37), var66);
                              }
                           }

                           if(var31 != null) {
                              var31.method4950(var65 + var60 - var39, var66);
                           }

                           var43.method4647(var45, var61 + var65, var72, var83.field3433 | -16777216, 0);
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
