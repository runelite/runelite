import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class180 extends Node {
   @ObfuscatedName("p")
   class184 field2695;
   @ObfuscatedName("d")
   byte[] field2696;
   @ObfuscatedName("h")
   class116 field2697;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 793446085
   )
   static int field2698;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 803826155
   )
   int field2701;

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "654106667"
   )
   static final void method3297(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod803()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(null != var6.configs) {
               var6 = var6.method3735();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class45.field921;
         int[] var7 = class45.field931;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method2421()) {
            MessageNode.method215(var0, 15 + var0.field629);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method2420(); null != var9; var9 = (CombatInfoListHolder)var0.combatInfoList.method2415()) {
               CombatInfo1 var10 = var9.method790(Client.gameCycle);
               if(null == var10) {
                  if(var9.method791()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method3530();
                  SpritePixels var13 = var11.method3544();
                  int var76 = 0;
                  if(var12 != null && null != var13) {
                     if(var11.field2845 * 2 < var13.width) {
                        var76 = var11.field2845;
                     }

                     var14 = var13.width - 2 * var76;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field687;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field688 > var18) {
                     var20 = var11.field2840 == 0?0:var11.field2840 * (var18 / var11.field2840);
                     var21 = var10.healthRatio * var14 / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.field688 + var21;
                  } else {
                     var88 = var19;
                     var20 = var11.field2838 + var10.field688 - var18;
                     if(var11.field2839 >= 0) {
                        var16 = (var20 << 8) / (var11.field2838 - var11.field2839);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = Client.field410 + var2 - (var14 >> 1);
                  var21 = Client.field411 + var3 - var8;
                  if(var12 != null && null != var13) {
                     var20 -= var76;
                     if(var88 == var14) {
                        var88 += var76 * 2;
                     } else {
                        var88 += var76;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method4241(var20, var21, var16);
                        Rasterizer2D.method4006(var20, var21, var88 + var20, var22 + var21);
                        var13.method4241(var20, var21, var16);
                     } else {
                        var12.method4173(var20, var21);
                        Rasterizer2D.method4006(var20, var21, var88 + var20, var21 + var22);
                        var13.method4173(var20, var21);
                     }

                     Rasterizer2D.method4031(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.field410 > -1) {
                        Rasterizer2D.method4011(var20, var21, var88, 5, '\uff00');
                        Rasterizer2D.method4011(var88 + var20, var21, var14 - var88, 5, 16711680);
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
            if(var85.field276) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               MessageNode.method215(var0, 15 + var0.field629);
               if(Client.field410 > -1) {
                  if(var85.skullIcon != -1) {
                     class31.field726[var85.skullIcon].method4173(Client.field410 + var2 - 12, var3 + Client.field411 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     ScriptState.field125[var85.overheadIcon].method4173(var2 + Client.field410 - 12, Client.field411 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field551 == 10 && var7[var1] == Client.field325) {
               MessageNode.method215(var0, 15 + var0.field629);
               if(Client.field410 > -1) {
                  class177.field2672[1].method4173(var2 + Client.field410 - 12, var3 + Client.field411 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(null != var86.configs) {
               var86 = var86.method3735();
            }

            if(var86.field3007 >= 0 && var86.field3007 < ScriptState.field125.length) {
               MessageNode.method215(var0, var0.field629 + 15);
               if(Client.field410 > -1) {
                  ScriptState.field125[var86.field3007].method4173(var2 + Client.field410 - 12, Client.field411 + var3 - 30);
               }
            }

            if(Client.field551 == 1 && Client.field324 == Client.field345[var1 - var74] && Client.gameCycle % 20 < 10) {
               MessageNode.method215(var0, var0.field629 + 15);
               if(Client.field410 > -1) {
                  class177.field2672[0].method4173(var2 + Client.field410 - 12, var3 + Client.field411 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field588 == 4 || !var0.field626 && (Client.field588 == 0 || Client.field588 == 3 || Client.field588 == 1 && class15.method183(((Player)var0).name, false))))) {
            MessageNode.method215(var0, var0.field629);
            if(Client.field410 > -1 && Client.field398 < Client.field465) {
               Client.field403[Client.field398] = NPC.field786.method3921(var0.overhead) / 2;
               Client.field317[Client.field398] = NPC.field786.field3105;
               Client.field400[Client.field398] = Client.field410;
               Client.field375[Client.field398] = Client.field411;
               Client.field382[Client.field398] = var0.field640;
               Client.field405[Client.field398] = var0.field641;
               Client.field552[Client.field398] = var0.field638;
               Client.field407[Client.field398] = var0.overhead;
               ++Client.field398;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var81 = var0.field645[var75];
            int var82 = var0.field643[var75];
            class196 var87 = null;
            int var83 = 0;
            if(var82 >= 0) {
               if(var81 <= Client.gameCycle) {
                  continue;
               }

               var87 = Script.method970(var0.field643[var75]);
               var83 = var87.field2876;
               if(var87 != null && var87.field2887 != null) {
                  var87 = var87.method3612();
                  if(var87 == null) {
                     var0.field645[var75] = -1;
                     continue;
                  }
               }
            } else if(var81 < 0) {
               continue;
            }

            var14 = var0.field646[var75];
            class196 var15 = null;
            if(var14 >= 0) {
               var15 = Script.method970(var14);
               if(null != var15 && var15.field2887 != null) {
                  var15 = var15.method3612();
               }
            }

            if(var81 - var83 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.field645[var75] = -1;
               } else {
                  MessageNode.method215(var0, var0.field629 / 2);
                  if(Client.field410 > -1) {
                     if(var75 == 1) {
                        Client.field411 -= 20;
                     }

                     if(var75 == 2) {
                        Client.field410 -= 15;
                        Client.field411 -= 10;
                     }

                     if(var75 == 3) {
                        Client.field410 += 15;
                        Client.field411 -= 10;
                     }

                     SpritePixels var77 = null;
                     SpritePixels var78 = null;
                     SpritePixels var80 = null;
                     SpritePixels var84 = null;
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
                     var77 = var87.method3578();
                     int var42;
                     if(null != var77) {
                        var21 = var77.width;
                        var42 = var77.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var77.offsetX;
                     }

                     var78 = var87.method3579();
                     if(null != var78) {
                        var22 = var78.width;
                        var42 = var78.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var78.offsetX;
                     }

                     var80 = var87.method3586();
                     if(null != var80) {
                        var23 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var80.offsetX;
                     }

                     var84 = var87.method3581();
                     if(null != var84) {
                        var24 = var84.width;
                        var42 = var84.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var84.offsetX;
                     }

                     if(var15 != null) {
                        var29 = var15.method3578();
                        if(null != var29) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var15.method3579();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var15.method3586();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var15.method3581();
                        if(null != var32) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var79 = var87.method3609();
                     if(var79 == null) {
                        var79 = class13.field154;
                     }

                     Font var43;
                     if(var15 != null) {
                        var43 = var15.method3609();
                        if(null == var43) {
                           var43 = class13.field154;
                        }
                     } else {
                        var43 = class13.field154;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method3577(var0.field644[var75]);
                     int var89 = var79.method3921(var44);
                     if(var15 != null) {
                        var45 = var15.method3577(var0.field647[var75]);
                        var47 = var43.method3921(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var80 == null && null == var84) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(var15 != null && var34 > 0) {
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
                     if(var15 != null) {
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

                     var61 = var0.field645[var75] - Client.gameCycle;
                     int var62 = var87.field2881 - var87.field2881 * var61 / var87.field2876;
                     int var63 = -var87.field2882 + var87.field2882 * var61 / var87.field2876;
                     int var64 = Client.field410 + var2 - (var50 >> 1) + var62;
                     int var65 = var63 + (var3 + Client.field411 - 12);
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var87.field2888 + var65 + 15;
                     int var69 = var68 - var79.field3112;
                     int var70 = var68 + var79.field3117;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(null != var15) {
                        var71 = var15.field2888 + var65 + 15;
                        var72 = var71 - var43.field3112;
                        var73 = var71 + var43.field3117;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field2883 >= 0) {
                        var72 = (var61 << 8) / (var87.field2876 - var87.field2883);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(null != var77) {
                           var77.method4241(var64 + var51 - var25, var65, var72);
                        }

                        if(null != var80) {
                           var80.method4241(var64 + var52 - var27, var65, var72);
                        }

                        if(null != var78) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var78.method4241(var53 + var64 - var26 + var73 * var22, var65, var72);
                           }
                        }

                        if(null != var84) {
                           var84.method4241(var64 + var55 - var28, var65, var72);
                        }

                        var79.method3899(var44, var54 + var64, var68, var87.field2877, 0, var72);
                        if(var15 != null) {
                           if(var29 != null) {
                              var29.method4241(var56 + var64 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method4241(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4241(var73 * var34 + (var58 + var64 - var38), var65, var72);
                              }
                           }

                           if(null != var32) {
                              var32.method4241(var59 + var64 - var40, var65, var72);
                           }

                           var43.method3899(var45, var60 + var64, var71, var15.field2877, 0, var72);
                        }
                     } else {
                        if(null != var77) {
                           var77.method4173(var51 + var64 - var25, var65);
                        }

                        if(null != var80) {
                           var80.method4173(var52 + var64 - var27, var65);
                        }

                        if(null != var78) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var78.method4173(var53 + var64 - var26 + var73 * var22, var65);
                           }
                        }

                        if(var84 != null) {
                           var84.method4173(var55 + var64 - var28, var65);
                        }

                        var79.method3898(var44, var54 + var64, var68, var87.field2877 | -16777216, 0);
                        if(null != var15) {
                           if(null != var29) {
                              var29.method4173(var56 + var64 - var37, var65);
                           }

                           if(null != var31) {
                              var31.method4173(var64 + var57 - var39, var65);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4173(var64 + var58 - var38 + var34 * var73, var65);
                              }
                           }

                           if(null != var32) {
                              var32.method4173(var64 + var59 - var40, var65);
                           }

                           var43.method3898(var45, var60 + var64, var71, var15.field2877 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "-1753868423"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var1 << 16) + (long)var0 + ((long)var2 << 38) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class103.getItemDefinition(var0);
      if(var1 > 1 && null != var9.countObj) {
         int var10 = -1;

         for(int var19 = 0; var19 < 10; ++var19) {
            if(var1 >= var9.countCo[var19] && var9.countCo[var19] != 0) {
               var10 = var9.countObj[var19];
            }
         }

         if(var10 != -1) {
            var9 = class103.getItemDefinition(var10);
         }
      }

      Model var20 = var9.getModel(1);
      if(var20 == null) {
         return null;
      } else {
         SpritePixels var11 = null;
         if(var9.notedTemplate != -1) {
            var11 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var11) {
               return null;
            }
         } else if(var9.field2969 != -1) {
            var11 = createSprite(var9.field2998, var1, var2, var3, 0, false);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field2976 != -1) {
            var11 = createSprite(var9.field3000, var1, 0, 0, 0, false);
            if(var11 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method4037(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method4044();
         class84.method1686();
         class84.method1712(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field2976 != -1) {
            var11.method4173(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = class84.field1468[var9.xan2d] * var16 >> 16;
         int var18 = var16 * class84.field1462[var9.xan2d] >> 16;
         var20.method1647();
         var20.method1629(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var20.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.field2969 != -1) {
            var11.method4173(0, 0);
         }

         if(var2 >= 1) {
            var8.method4169(1);
         }

         if(var2 >= 2) {
            var8.method4169(16777215);
         }

         if(var3 != 0) {
            var8.method4191(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var11.method4173(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class185.field2768.method3898(class185.method3429(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method4008(var15);
         class84.method1686();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
