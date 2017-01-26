import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class0 implements Comparator {
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = -2054585805
   )
   static int field1;
   @ObfuscatedName("y")
   static int[] field3;

   public int compare(Object var1, Object var2) {
      return this.method13((class2)var1, (class2)var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1673062392"
   )
   static int method4(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method887();
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1374889559"
   )
   int method13(class2 var1, class2 var2) {
      return var1.field24 < var2.field24?-1:(var1.field24 == var2.field24?0:1);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "-85222448"
   )
   static final void method14(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod702()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(null != var6.configs) {
               var6 = var6.method3708();
            }

            if(null == var6) {
               return;
            }
         }

         int var74 = class45.field898;
         int[] var7 = class45.field895;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method2383()) {
            class60.method1121(var0, 15 + var0.field642);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method2381(); null != var9; var9 = (CombatInfoListHolder)var0.combatInfoList.method2389()) {
               CombatInfo1 var10 = var9.method688(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method687()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method3515();
                  SpritePixels var13 = var11.method3511();
                  int var15 = 0;
                  if(null != var12 && var13 != null) {
                     if(var11.field2839 * 2 < var13.width) {
                        var15 = var11.field2839;
                     }

                     var14 = var13.width - 2 * var15;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field661;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var76;
                  int var88;
                  if(var10.field656 > var18) {
                     var76 = var11.field2834 == 0?0:var11.field2834 * (var18 / var11.field2834);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var21 + var76 * (var19 - var21) / var10.field656;
                  } else {
                     var88 = var19;
                     var76 = var11.field2835 + var10.field656 - var18;
                     if(var11.field2833 >= 0) {
                        var16 = (var76 << 8) / (var11.field2835 - var11.field2833);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var76 = var2 + Client.field398 - (var14 >> 1);
                  var21 = var3 + Client.field317 - var8;
                  if(null != var12 && null != var13) {
                     var76 -= var15;
                     if(var88 == var14) {
                        var88 += 2 * var15;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method4223(var76, var21, var16);
                        Rasterizer2D.method3986(var76, var21, var88 + var76, var21 + var22);
                        var13.method4223(var76, var21, var16);
                     } else {
                        var12.method4144(var76, var21);
                        Rasterizer2D.method3986(var76, var21, var76 + var88, var21 + var22);
                        var13.method4144(var76, var21);
                     }

                     Rasterizer2D.method4008(var2, var3, var4 + var2, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.field398 > -1) {
                        Rasterizer2D.method4020(var76, var21, var88, 5, '\uff00');
                        Rasterizer2D.method4020(var76 + var88, var21, var14 - var88, 5, 16711680);
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
            if(var85.field266) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               class60.method1121(var0, 15 + var0.field642);
               if(Client.field398 > -1) {
                  if(var85.skullIcon != -1) {
                     class140.field1978[var85.skullIcon].method4144(var2 + Client.field398 - 12, var3 + Client.field317 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     Client.field389[var85.overheadIcon].method4144(var2 + Client.field398 - 12, Client.field317 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field407 == 10 && var7[var1] == Client.field321) {
               class60.method1121(var0, 15 + var0.field642);
               if(Client.field398 > -1) {
                  World.field678[1].method4144(Client.field398 + var2 - 12, var3 + Client.field317 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.method3708();
            }

            if(var86.field3012 >= 0 && var86.field3012 < Client.field389.length) {
               class60.method1121(var0, var0.field642 + 15);
               if(Client.field398 > -1) {
                  Client.field389[var86.field3012].method4144(var2 + Client.field398 - 12, var3 + Client.field317 - 30);
               }
            }

            if(Client.field407 == 1 && Client.field419[var1 - var74] == Client.field499 && Client.gameCycle % 20 < 10) {
               class60.method1121(var0, 15 + var0.field642);
               if(Client.field398 > -1) {
                  World.field678[0].method4144(Client.field398 + var2 - 12, Client.field317 + var3 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field495 == 4 || !var0.field606 && (Client.field495 == 0 || Client.field495 == 3 || Client.field495 == 1 && GameEngine.method2194(((Player)var0).name, false))))) {
            class60.method1121(var0, var0.field642);
            if(Client.field398 > -1 && Client.field372 < Client.field373) {
               Client.field377[Client.field372] = Tile.field1346.method3870(var0.overhead) / 2;
               Client.field376[Client.field372] = Tile.field1346.field3100;
               Client.field491[Client.field372] = Client.field398;
               Client.field401[Client.field372] = Client.field317;
               Client.field278[Client.field372] = var0.field594;
               Client.field379[Client.field372] = var0.field609;
               Client.field380[Client.field372] = var0.field608;
               Client.field381[Client.field372] = var0.overhead;
               ++Client.field372;
            }
         }

         for(int var80 = 0; var80 < 4; ++var80) {
            int var81 = var0.field612[var80];
            int var82 = var0.field650[var80];
            class196 var87 = null;
            int var77 = 0;
            if(var82 >= 0) {
               if(var81 <= Client.gameCycle) {
                  continue;
               }

               var87 = class108.method2038(var0.field650[var80]);
               var77 = var87.field2869;
               if(null != var87 && var87.field2880 != null) {
                  var87 = var87.method3590();
                  if(null == var87) {
                     var0.field612[var80] = -1;
                     continue;
                  }
               }
            } else if(var81 < 0) {
               continue;
            }

            var14 = var0.field615[var80];
            class196 var78 = null;
            if(var14 >= 0) {
               var78 = class108.method2038(var14);
               if(var78 != null && var78.field2880 != null) {
                  var78 = var78.method3590();
               }
            }

            if(var81 - var77 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.field612[var80] = -1;
               } else {
                  class60.method1121(var0, var0.field642 / 2);
                  if(Client.field398 > -1) {
                     if(var80 == 1) {
                        Client.field317 -= 20;
                     }

                     if(var80 == 2) {
                        Client.field398 -= 15;
                        Client.field317 -= 10;
                     }

                     if(var80 == 3) {
                        Client.field398 += 15;
                        Client.field317 -= 10;
                     }

                     SpritePixels var83 = null;
                     SpritePixels var84 = null;
                     SpritePixels var79 = null;
                     SpritePixels var20 = null;
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
                     var83 = var87.method3551();
                     int var42;
                     if(var83 != null) {
                        var21 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var83.offsetX;
                     }

                     var84 = var87.method3552();
                     if(null != var84) {
                        var22 = var84.width;
                        var42 = var84.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var84.offsetX;
                     }

                     var79 = var87.method3553();
                     if(null != var79) {
                        var23 = var79.width;
                        var42 = var79.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var79.offsetX;
                     }

                     var20 = var87.method3554();
                     if(var20 != null) {
                        var24 = var20.width;
                        var42 = var20.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var20.offsetX;
                     }

                     if(null != var78) {
                        var29 = var78.method3551();
                        if(null != var29) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var78.method3552();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var78.method3553();
                        if(null != var31) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var78.method3554();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var75 = var87.method3555();
                     if(null == var75) {
                        var75 = Ignore.field204;
                     }

                     Font var43;
                     if(null != var78) {
                        var43 = var78.method3555();
                        if(null == var43) {
                           var43 = Ignore.field204;
                        }
                     } else {
                        var43 = Ignore.field204;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method3550(var0.field613[var80]);
                     int var89 = var75.method3870(var44);
                     if(var78 != null) {
                        var45 = var78.method3550(var0.field616[var80]);
                        var47 = var43.method3870(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var79 == null && null == var20) {
                           var48 = 1;
                        } else {
                           var48 = 1 + var89 / var22;
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

                     var61 = var0.field612[var80] - Client.gameCycle;
                     int var62 = var87.field2874 - var87.field2874 * var61 / var87.field2869;
                     int var63 = -var87.field2861 + var87.field2861 * var61 / var87.field2869;
                     int var64 = Client.field398 + var2 - (var50 >> 1) + var62;
                     int var65 = var63 + (var3 + Client.field317 - 12);
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var87.field2882 + 15 + var65;
                     int var69 = var68 - var75.field3101;
                     int var70 = var75.field3106 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var78 != null) {
                        var71 = var78.field2882 + var65 + 15;
                        var72 = var71 - var43.field3101;
                        var73 = var71 + var43.field3106;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field2876 >= 0) {
                        var72 = (var61 << 8) / (var87.field2869 - var87.field2876);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var83 != null) {
                           var83.method4223(var64 + var51 - var25, var65, var72);
                        }

                        if(var79 != null) {
                           var79.method4223(var64 + var52 - var27, var65, var72);
                        }

                        if(null != var84) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var84.method4223(var64 + var53 - var26 + var22 * var73, var65, var72);
                           }
                        }

                        if(var20 != null) {
                           var20.method4223(var64 + var55 - var28, var65, var72);
                        }

                        var75.method3876(var44, var64 + var54, var68, var87.field2879, 0, var72);
                        if(null != var78) {
                           if(null != var29) {
                              var29.method4223(var56 + var64 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method4223(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4223(var58 + var64 - var38 + var73 * var34, var65, var72);
                              }
                           }

                           if(null != var32) {
                              var32.method4223(var59 + var64 - var40, var65, var72);
                           }

                           var43.method3876(var45, var64 + var60, var71, var78.field2879, 0, var72);
                        }
                     } else {
                        if(null != var83) {
                           var83.method4144(var51 + var64 - var25, var65);
                        }

                        if(null != var79) {
                           var79.method4144(var64 + var52 - var27, var65);
                        }

                        if(var84 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var84.method4144(var73 * var22 + (var64 + var53 - var26), var65);
                           }
                        }

                        if(var20 != null) {
                           var20.method4144(var55 + var64 - var28, var65);
                        }

                        var75.method3875(var44, var54 + var64, var68, var87.field2879 | -16777216, 0);
                        if(null != var78) {
                           if(var29 != null) {
                              var29.method4144(var56 + var64 - var37, var65);
                           }

                           if(null != var31) {
                              var31.method4144(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4144(var64 + var58 - var38 + var73 * var34, var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method4144(var64 + var59 - var40, var65);
                           }

                           var43.method3875(var45, var60 + var64, var71, var78.field2879 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
