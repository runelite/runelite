import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class213 {
   class213() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIIB)V",
      garbageValue = "103"
   )
   static final void method4062(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod795()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.method3807();
            }

            if(null == var6) {
               return;
            }
         }

         int var74 = class45.field907;
         int[] var7 = class45.field900;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method2438()) {
            class36.method797(var0, var0.field609 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method2455(); null != var9; var9 = (CombatInfoListHolder)var0.combatInfoList.method2437()) {
               CombatInfo1 var10 = var9.method768(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method773()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method3601();
                  SpritePixels var13 = var11.method3600();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field2833 * 2 < var13.width) {
                        var15 = var11.field2833;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var76 = Client.gameCycle - var10.field668;
                  int var77 = var10.health * var14 / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field666 > var76) {
                     var20 = var11.field2839 == 0?0:var76 / var11.field2839 * var11.field2839;
                     var21 = var10.healthRatio * var14 / var11.healthScale;
                     var88 = var20 * (var77 - var21) / var10.field666 + var21;
                  } else {
                     var88 = var77;
                     var20 = var10.field666 + var11.field2840 - var76;
                     if(var11.field2838 >= 0) {
                        var16 = (var20 << 8) / (var11.field2840 - var11.field2838);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.field390 - (var14 >> 1);
                  var21 = Client.field391 + var3 - var8;
                  if(var12 != null && null != var13) {
                     var20 -= var15;
                     if(var88 == var14) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method4271(var20, var21, var16);
                        Rasterizer2D.method4093(var20, var21, var88 + var20, var21 + var22);
                        var13.method4271(var20, var21, var16);
                     } else {
                        var12.method4284(var20, var21);
                        Rasterizer2D.method4093(var20, var21, var20 + var88, var21 + var22);
                        var13.method4284(var20, var21);
                     }

                     Rasterizer2D.method4124(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field390 > -1) {
                        Rasterizer2D.method4099(var20, var21, var88, 5, '\uff00');
                        Rasterizer2D.method4099(var20 + var88, var21, var14 - var88, 5, 16711680);
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
            if(var85.field259) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               class36.method797(var0, var0.field609 + 15);
               if(Client.field390 > -1) {
                  if(var85.skullIcon != -1) {
                     Client.field440[var85.skullIcon].method4284(var2 + Client.field390 - 12, Client.field391 + var3 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class159.field2121[var85.overheadIcon].method4284(var2 + Client.field390 - 12, Client.field391 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field300 == 10 && Client.field311 == var7[var1]) {
               class36.method797(var0, var0.field609 + 15);
               if(Client.field390 > -1) {
                  class164.field2152[1].method4284(Client.field390 + var2 - 12, var3 + Client.field391 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.method3807();
            }

            if(var86.field3034 >= 0 && var86.field3034 < class159.field2121.length) {
               class36.method797(var0, var0.field609 + 15);
               if(Client.field390 > -1) {
                  class159.field2121[var86.field3034].method4284(Client.field390 + var2 - 12, Client.field391 + var3 - 30);
               }
            }

            if(Client.field300 == 1 && Client.field324[var1 - var74] == Client.field301 && Client.gameCycle % 20 < 10) {
               class36.method797(var0, var0.field609 + 15);
               if(Client.field390 > -1) {
                  class164.field2152[0].method4284(Client.field390 + var2 - 12, var3 + Client.field391 - 28);
               }
            }
         }

         if(null != var0.overhead && (var1 >= var74 || !var0.inSequence && (Client.field452 == 4 || !var0.field615 && (Client.field452 == 0 || Client.field452 == 3 || Client.field452 == 1 && ChatLineBuffer.method983(((Player)var0).name, false))))) {
            class36.method797(var0, var0.field609);
            if(Client.field390 > -1 && Client.field445 < Client.field372) {
               Client.field383[Client.field445] = class16.field170.method3969(var0.overhead) / 2;
               Client.field382[Client.field445] = class16.field170.field3104;
               Client.field380[Client.field445] = Client.field390;
               Client.field291[Client.field445] = Client.field391;
               Client.field384[Client.field445] = var0.field648;
               Client.field417[Client.field445] = var0.field619;
               Client.field545[Client.field445] = var0.field606;
               Client.field488[Client.field445] = var0.overhead;
               ++Client.field445;
            }
         }

         for(int var79 = 0; var79 < 4; ++var79) {
            int var80 = var0.field623[var79];
            int var84 = var0.field621[var79];
            class196 var87 = null;
            int var83 = 0;
            if(var84 >= 0) {
               if(var80 <= Client.gameCycle) {
                  continue;
               }

               var87 = NPCComposition.method3832(var0.field621[var79]);
               var83 = var87.field2882;
               if(var87 != null && null != var87.field2893) {
                  var87 = var87.method3671();
                  if(var87 == null) {
                     var0.field623[var79] = -1;
                     continue;
                  }
               }
            } else if(var80 < 0) {
               continue;
            }

            var14 = var0.field651[var79];
            class196 var78 = null;
            if(var14 >= 0) {
               var78 = NPCComposition.method3832(var14);
               if(var78 != null && null != var78.field2893) {
                  var78 = var78.method3671();
               }
            }

            if(var80 - var83 <= Client.gameCycle) {
               if(null == var87) {
                  var0.field623[var79] = -1;
               } else {
                  class36.method797(var0, var0.field609 / 2);
                  if(Client.field390 > -1) {
                     if(var79 == 1) {
                        Client.field391 -= 20;
                     }

                     if(var79 == 2) {
                        Client.field390 -= 15;
                        Client.field391 -= 10;
                     }

                     if(var79 == 3) {
                        Client.field390 += 15;
                        Client.field391 -= 10;
                     }

                     SpritePixels var82 = null;
                     SpritePixels var18 = null;
                     SpritePixels var19 = null;
                     SpritePixels var81 = null;
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
                     var82 = var87.method3674();
                     int var75;
                     if(null != var82) {
                        var21 = var82.width;
                        var75 = var82.height;
                        if(var75 > var41) {
                           var41 = var75;
                        }

                        var25 = var82.offsetX;
                     }

                     var18 = var87.method3646();
                     if(var18 != null) {
                        var22 = var18.width;
                        var75 = var18.height;
                        if(var75 > var41) {
                           var41 = var75;
                        }

                        var26 = var18.offsetX;
                     }

                     var19 = var87.method3647();
                     if(null != var19) {
                        var23 = var19.width;
                        var75 = var19.height;
                        if(var75 > var41) {
                           var41 = var75;
                        }

                        var27 = var19.offsetX;
                     }

                     var81 = var87.method3648();
                     if(var81 != null) {
                        var24 = var81.width;
                        var75 = var81.height;
                        if(var75 > var41) {
                           var41 = var75;
                        }

                        var28 = var81.offsetX;
                     }

                     if(var78 != null) {
                        var29 = var78.method3674();
                        if(null != var29) {
                           var33 = var29.width;
                           var75 = var29.height;
                           if(var75 > var41) {
                              var41 = var75;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var78.method3646();
                        if(var30 != null) {
                           var34 = var30.width;
                           var75 = var30.height;
                           if(var75 > var41) {
                              var41 = var75;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var78.method3647();
                        if(null != var31) {
                           var35 = var31.width;
                           var75 = var31.height;
                           if(var75 > var41) {
                              var41 = var75;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var78.method3648();
                        if(var32 != null) {
                           var36 = var32.width;
                           var75 = var32.height;
                           if(var75 > var41) {
                              var41 = var75;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var42 = var87.method3649();
                     if(var42 == null) {
                        var42 = Client.field567;
                     }

                     Font var43;
                     if(null != var78) {
                        var43 = var78.method3649();
                        if(null == var43) {
                           var43 = Client.field567;
                        }
                     } else {
                        var43 = Client.field567;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method3679(var0.field622[var79]);
                     int var89 = var42.method3969(var44);
                     if(var78 != null) {
                        var45 = var78.method3679(var0.field625[var79]);
                        var47 = var43.method3969(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var19 == null && null == var81) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(null != var78 && var34 > 0) {
                        if(null == var31 && var32 == null) {
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
                     if(var78 != null) {
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

                     var61 = var0.field623[var79] - Client.gameCycle;
                     int var62 = var87.field2887 - var87.field2887 * var61 / var87.field2882;
                     int var63 = var87.field2896 * var61 / var87.field2882 + -var87.field2896;
                     int var64 = var62 + (var2 + Client.field390 - (var50 >> 1));
                     int var65 = var3 + Client.field391 - 12 + var63;
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var87.field2892 + var65 + 15;
                     int var69 = var68 - var42.field3105;
                     int var70 = var68 + var42.field3116;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(null != var78) {
                        var71 = var78.field2892 + 15 + var65;
                        var72 = var71 - var43.field3105;
                        var73 = var71 + var43.field3116;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field2877 >= 0) {
                        var72 = (var61 << 8) / (var87.field2882 - var87.field2877);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(null != var82) {
                           var82.method4271(var64 + var51 - var25, var65, var72);
                        }

                        if(var19 != null) {
                           var19.method4271(var52 + var64 - var27, var65, var72);
                        }

                        if(var18 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method4271(var73 * var22 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(var81 != null) {
                           var81.method4271(var55 + var64 - var28, var65, var72);
                        }

                        var42.method3975(var44, var54 + var64, var68, var87.field2889, 0, var72);
                        if(var78 != null) {
                           if(var29 != null) {
                              var29.method4271(var56 + var64 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method4271(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4271(var64 + var58 - var38 + var73 * var34, var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method4271(var59 + var64 - var40, var65, var72);
                           }

                           var43.method3975(var45, var60 + var64, var71, var78.field2889, 0, var72);
                        }
                     } else {
                        if(var82 != null) {
                           var82.method4284(var51 + var64 - var25, var65);
                        }

                        if(var19 != null) {
                           var19.method4284(var64 + var52 - var27, var65);
                        }

                        if(var18 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method4284(var53 + var64 - var26 + var73 * var22, var65);
                           }
                        }

                        if(null != var81) {
                           var81.method4284(var55 + var64 - var28, var65);
                        }

                        var42.method3974(var44, var64 + var54, var68, var87.field2889 | -16777216, 0);
                        if(var78 != null) {
                           if(var29 != null) {
                              var29.method4284(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method4284(var57 + var64 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4284(var58 + var64 - var38 + var34 * var73, var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method4284(var64 + var59 - var40, var65);
                           }

                           var43.method3974(var45, var60 + var64, var71, var78.field2889 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
