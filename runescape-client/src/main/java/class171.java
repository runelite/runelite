import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class171 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 394420955
   )
   public static int field2347;

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIIB)V",
      garbageValue = "-115"
   )
   static final void method3330(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod794()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.method3779();
            }

            if(var6 == null) {
               return;
            }
         }

         int var79 = class45.field916;
         int[] var7 = class45.field913;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method2460()) {
            ScriptState.method163(var0, var0.field653 + 15);

            for(CombatInfoListHolder var74 = (CombatInfoListHolder)var0.combatInfoList.method2453(); var74 != null; var74 = (CombatInfoListHolder)var0.combatInfoList.method2468()) {
               CombatInfo1 var10 = var74.method785(Client.gameCycle);
               if(var10 == null) {
                  if(var74.method779()) {
                     var74.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var74.combatInfo2;
                  SpritePixels var12 = var11.method3591();
                  SpritePixels var13 = var11.method3587();
                  int var15 = 0;
                  if(null != var12 && var13 != null) {
                     if(var11.field2843 * 2 < var13.width) {
                        var15 = var11.field2843;
                     }

                     var14 = var13.width - 2 * var15;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var77 = Client.gameCycle - var10.field669;
                  int var76 = var10.health * var14 / var11.healthScale;
                  int var20;
                  int var86;
                  if(var10.field668 > var77) {
                     var20 = var11.field2842 == 0?0:var77 / var11.field2842 * var11.field2842;
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var86 = (var76 - var21) * var20 / var10.field668 + var21;
                  } else {
                     var86 = var76;
                     var20 = var11.field2848 + var10.field668 - var77;
                     if(var11.field2834 >= 0) {
                        var16 = (var20 << 8) / (var11.field2848 - var11.field2834);
                     }
                  }

                  if(var10.health > 0 && var86 < 1) {
                     var86 = 1;
                  }

                  var20 = Client.field447 + var2 - (var14 >> 1);
                  var21 = Client.field469 + var3 - var8;
                  if(null != var12 && null != var13) {
                     var20 -= var15;
                     if(var86 == var14) {
                        var86 += 2 * var15;
                     } else {
                        var86 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method4180(var20, var21, var16);
                        Rasterizer2D.method4014(var20, var21, var20 + var86, var22 + var21);
                        var13.method4180(var20, var21, var16);
                     } else {
                        var12.method4174(var20, var21);
                        Rasterizer2D.method4014(var20, var21, var86 + var20, var21 + var22);
                        var13.method4174(var20, var21);
                     }

                     Rasterizer2D.method4091(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field447 > -1) {
                        Rasterizer2D.method4056(var20, var21, var86, 5, '\uff00');
                        Rasterizer2D.method4056(var20 + var86, var21, var14 - var86, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var79) {
            Player var88 = (Player)var0;
            if(var88.field260) {
               return;
            }

            if(var88.skullIcon != -1 || var88.overheadIcon != -1) {
               ScriptState.method163(var0, 15 + var0.field653);
               if(Client.field447 > -1) {
                  if(var88.skullIcon != -1) {
                     class162.field2150[var88.skullIcon].method4174(Client.field447 + var2 - 12, Client.field469 + var3 - var8);
                     var8 += 25;
                  }

                  if(var88.overheadIcon != -1) {
                     Projectile.field869[var88.overheadIcon].method4174(var2 + Client.field447 - 12, var3 + Client.field469 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field304 == 10 && Client.field562 == var7[var1]) {
               ScriptState.method163(var0, 15 + var0.field653);
               if(Client.field447 > -1) {
                  CombatInfoListHolder.field758[1].method4174(var2 + Client.field447 - 12, var3 + Client.field469 - var8);
               }
            }
         } else {
            NPCComposition var89 = ((NPC)var0).composition;
            if(var89.configs != null) {
               var89 = var89.method3779();
            }

            if(var89.field3034 >= 0 && var89.field3034 < Projectile.field869.length) {
               ScriptState.method163(var0, 15 + var0.field653);
               if(Client.field447 > -1) {
                  Projectile.field869[var89.field3034].method4174(var2 + Client.field447 - 12, var3 + Client.field469 - 30);
               }
            }

            if(Client.field304 == 1 && Client.field305 == Client.field285[var1 - var79] && Client.gameCycle % 20 < 10) {
               ScriptState.method163(var0, var0.field653 + 15);
               if(Client.field447 > -1) {
                  CombatInfoListHolder.field758[0].method4174(Client.field447 + var2 - 12, Client.field469 + var3 - 28);
               }
            }
         }

         if(null != var0.overhead && (var1 >= var79 || !var0.inSequence && (Client.field507 == 4 || !var0.field613 && (Client.field507 == 0 || Client.field507 == 3 || Client.field507 == 1 && class20.method215(((Player)var0).name, false))))) {
            ScriptState.method163(var0, var0.field653);
            if(Client.field447 > -1 && Client.field484 < Client.field383) {
               Client.field434[Client.field484] = class217.field3188.method3904(var0.overhead) / 2;
               Client.field386[Client.field484] = class217.field3188.field3112;
               Client.field384[Client.field484] = Client.field447;
               Client.field385[Client.field484] = Client.field469;
               Client.field388[Client.field484] = var0.field620;
               Client.field500[Client.field484] = var0.field641;
               Client.field390[Client.field484] = var0.field637;
               Client.field391[Client.field484] = var0.overhead;
               ++Client.field484;
            }
         }

         for(int var9 = 0; var9 < 4; ++var9) {
            int var81 = var0.field625[var9];
            int var82 = var0.field623[var9];
            class196 var85 = null;
            int var83 = 0;
            if(var82 >= 0) {
               if(var81 <= Client.gameCycle) {
                  continue;
               }

               var85 = Script.method971(var0.field623[var9]);
               var83 = var85.field2882;
               if(null != var85 && null != var85.field2893) {
                  var85 = var85.method3642();
                  if(null == var85) {
                     var0.field625[var9] = -1;
                     continue;
                  }
               }
            } else if(var81 < 0) {
               continue;
            }

            var14 = var0.field611[var9];
            class196 var75 = null;
            if(var14 >= 0) {
               var75 = Script.method971(var14);
               if(null != var75 && null != var75.field2893) {
                  var75 = var75.method3642();
               }
            }

            if(var81 - var83 <= Client.gameCycle) {
               if(var85 == null) {
                  var0.field625[var9] = -1;
               } else {
                  ScriptState.method163(var0, var0.field653 / 2);
                  if(Client.field447 > -1) {
                     if(var9 == 1) {
                        Client.field469 -= 20;
                     }

                     if(var9 == 2) {
                        Client.field447 -= 15;
                        Client.field469 -= 10;
                     }

                     if(var9 == 3) {
                        Client.field447 += 15;
                        Client.field469 -= 10;
                     }

                     SpritePixels var78 = null;
                     SpritePixels var18 = null;
                     SpritePixels var19 = null;
                     SpritePixels var80 = null;
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
                     var78 = var85.method3627();
                     int var84;
                     if(var78 != null) {
                        var21 = var78.width;
                        var84 = var78.height;
                        if(var84 > var41) {
                           var41 = var84;
                        }

                        var25 = var78.offsetX;
                     }

                     var18 = var85.method3628();
                     if(null != var18) {
                        var22 = var18.width;
                        var84 = var18.height;
                        if(var84 > var41) {
                           var41 = var84;
                        }

                        var26 = var18.offsetX;
                     }

                     var19 = var85.method3629();
                     if(null != var19) {
                        var23 = var19.width;
                        var84 = var19.height;
                        if(var84 > var41) {
                           var41 = var84;
                        }

                        var27 = var19.offsetX;
                     }

                     var80 = var85.method3630();
                     if(null != var80) {
                        var24 = var80.width;
                        var84 = var80.height;
                        if(var84 > var41) {
                           var41 = var84;
                        }

                        var28 = var80.offsetX;
                     }

                     if(var75 != null) {
                        var29 = var75.method3627();
                        if(var29 != null) {
                           var33 = var29.width;
                           var84 = var29.height;
                           if(var84 > var41) {
                              var41 = var84;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var75.method3628();
                        if(var30 != null) {
                           var34 = var30.width;
                           var84 = var30.height;
                           if(var84 > var41) {
                              var41 = var84;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var75.method3629();
                        if(null != var31) {
                           var35 = var31.width;
                           var84 = var31.height;
                           if(var84 > var41) {
                              var41 = var84;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var75.method3630();
                        if(null != var32) {
                           var36 = var32.width;
                           var84 = var32.height;
                           if(var84 > var41) {
                              var41 = var84;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var42 = var85.method3659();
                     if(null == var42) {
                        var42 = Friend.field151;
                     }

                     Font var43;
                     if(null != var75) {
                        var43 = var75.method3659();
                        if(var43 == null) {
                           var43 = Friend.field151;
                        }
                     } else {
                        var43 = Friend.field151;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var85.method3648(var0.field624[var9]);
                     int var87 = var42.method3904(var44);
                     if(var75 != null) {
                        var45 = var75.method3648(var0.field627[var9]);
                        var47 = var43.method3904(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var19 == null && null == var80) {
                           var48 = 1;
                        } else {
                           var48 = var87 / var22 + 1;
                        }
                     }

                     if(null != var75 && var34 > 0) {
                        if(null == var31 && null == var32) {
                           var49 = 1;
                        } else {
                           var49 = 1 + var47 / var34;
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
                        var54 += (var55 - var87) / 2;
                     } else {
                        var50 += var87;
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
                     if(null != var75) {
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

                     var61 = var0.field625[var9] - Client.gameCycle;
                     int var62 = var85.field2871 - var61 * var85.field2871 / var85.field2882;
                     int var63 = -var85.field2880 + var61 * var85.field2880 / var85.field2882;
                     int var64 = var2 + Client.field447 - (var50 >> 1) + var62;
                     int var65 = var3 + Client.field469 - 12 + var63;
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var65 + 15 + var85.field2892;
                     int var69 = var68 - var42.field3113;
                     int var70 = var42.field3114 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(null != var75) {
                        var71 = var75.field2892 + var65 + 15;
                        var72 = var71 - var43.field3113;
                        var73 = var43.field3114 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var85.field2889 >= 0) {
                        var72 = (var61 << 8) / (var85.field2882 - var85.field2889);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var78 != null) {
                           var78.method4180(var51 + var64 - var25, var65, var72);
                        }

                        if(null != var19) {
                           var19.method4180(var64 + var52 - var27, var65, var72);
                        }

                        if(var18 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method4180(var73 * var22 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(null != var80) {
                           var80.method4180(var55 + var64 - var28, var65, var72);
                        }

                        var42.method3910(var44, var64 + var54, var68, var85.field2881, 0, var72);
                        if(null != var75) {
                           if(null != var29) {
                              var29.method4180(var64 + var56 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method4180(var57 + var64 - var39, var65, var72);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4180(var73 * var34 + (var58 + var64 - var38), var65, var72);
                              }
                           }

                           if(null != var32) {
                              var32.method4180(var59 + var64 - var40, var65, var72);
                           }

                           var43.method3910(var45, var60 + var64, var71, var75.field2881, 0, var72);
                        }
                     } else {
                        if(null != var78) {
                           var78.method4174(var64 + var51 - var25, var65);
                        }

                        if(null != var19) {
                           var19.method4174(var64 + var52 - var27, var65);
                        }

                        if(null != var18) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method4174(var22 * var73 + (var53 + var64 - var26), var65);
                           }
                        }

                        if(var80 != null) {
                           var80.method4174(var64 + var55 - var28, var65);
                        }

                        var42.method3973(var44, var64 + var54, var68, var85.field2881 | -16777216, 0);
                        if(null != var75) {
                           if(var29 != null) {
                              var29.method4174(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method4174(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4174(var34 * var73 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(null != var32) {
                              var32.method4174(var59 + var64 - var40, var65);
                           }

                           var43.method3973(var45, var64 + var60, var71, var75.field2881 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   class171() throws Throwable {
      throw new Error();
   }
}
