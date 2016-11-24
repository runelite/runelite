import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class5 implements Comparator {
   @ObfuscatedName("p")
   static byte[][][] field51;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -2054720793
   )
   static int field55;

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1806936906"
   )
   static final void method72() {
      Client.field330.method3234(130);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2414(); null != var0; var0 = (WidgetNode)Client.componentTable.method2409()) {
         if(var0.field174 == 0 || var0.field174 == 3) {
            XGrandExchangeOffer.method68(var0, true);
         }
      }

      if(Client.field449 != null) {
         Tile.method1577(Client.field449);
         Client.field449 = null;
      }

   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1310967364"
   )
   int method73(class2 var1, class2 var2) {
      return var1.field23.price < var2.field23.price?-1:(var2.field23.price == var1.field23.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method73((class2)var1, (class2)var2);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "2123647221"
   )
   static final void method78(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod746()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(null != var6.field3022) {
               var6 = var6.method3770();
            }

            if(null == var6) {
               return;
            }
         }

         int var79 = class45.field897;
         int[] var7 = class45.field902;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.field611.method2427()) {
            class3.method34(var0, 15 + var0.field621);

            for(class34 var9 = (class34)var0.field611.method2428(); var9 != null; var9 = (class34)var0.field611.method2420()) {
               class28 var10 = var9.method718(Client.gameCycle);
               if(null == var10) {
                  if(var9.method719()) {
                     var9.unlink();
                  }
               } else {
                  class193 var11 = var9.field744;
                  SpritePixels var12 = var11.method3587();
                  SpritePixels var13 = var11.method3572();
                  int var15 = 0;
                  if(null != var12 && null != var13) {
                     if(var11.field2845 * 2 < var13.width) {
                        var15 = var11.field2845;
                     }

                     var14 = var13.width - 2 * var15;
                  } else {
                     var14 = var11.field2844;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field660;
                  int var19 = var10.field658 * var14 / var11.field2844;
                  int var75;
                  int var88;
                  if(var10.field661 > var18) {
                     var75 = var11.field2839 == 0?0:var18 / var11.field2839 * var11.field2839;
                     var21 = var10.field662 * var14 / var11.field2844;
                     var88 = var75 * (var19 - var21) / var10.field661 + var21;
                  } else {
                     var88 = var19;
                     var75 = var11.field2841 + var10.field661 - var18;
                     if(var11.field2837 >= 0) {
                        var16 = (var75 << 8) / (var11.field2841 - var11.field2837);
                     }
                  }

                  if(var10.field658 > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var75 = Client.field347 + var2 - (var14 >> 1);
                  var21 = var3 + Client.field394 - var8;
                  if(var12 != null && var13 != null) {
                     var75 -= var15;
                     if(var88 == var14) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method4198(var75, var21, var16);
                        class219.method4068(var75, var21, var88 + var75, var21 + var22);
                        var13.method4198(var75, var21, var16);
                     } else {
                        var12.method4192(var75, var21);
                        class219.method4068(var75, var21, var75 + var88, var21 + var22);
                        var13.method4192(var75, var21);
                     }

                     class219.method4041(var2, var3, var4 + var2, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.field347 > -1) {
                        class219.method4071(var75, var21, var88, 5, '\uff00');
                        class219.method4071(var88 + var75, var21, var14 - var88, 5, 16711680);
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
            Player var85 = (Player)var0;
            if(var85.field263) {
               return;
            }

            if(var85.field259 != -1 || var85.field246 != -1) {
               class3.method34(var0, 15 + var0.field621);
               if(Client.field347 > -1) {
                  if(var85.field259 != -1) {
                     class28.field657[var85.field259].method4192(var2 + Client.field347 - 12, var3 + Client.field394 - var8);
                     var8 += 25;
                  }

                  if(var85.field246 != -1) {
                     class16.field167[var85.field246].method4192(var2 + Client.field347 - 12, var3 + Client.field394 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field302 == 10 && Client.field304 == var7[var1]) {
               class3.method34(var0, var0.field621 + 15);
               if(Client.field347 > -1) {
                  class3.field37[1].method4192(var2 + Client.field347 - 12, var3 + Client.field394 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.field3022 != null) {
               var86 = var86.method3770();
            }

            if(var86.field3020 >= 0 && var86.field3020 < class16.field167.length) {
               class3.method34(var0, var0.field621 + 15);
               if(Client.field347 > -1) {
                  class16.field167[var86.field3020].method4192(var2 + Client.field347 - 12, Client.field394 + var3 - 30);
               }
            }

            if(Client.field302 == 1 && Client.field303 == Client.field559[var1 - var79] && Client.gameCycle % 20 < 10) {
               class3.method34(var0, var0.field621 + 15);
               if(Client.field347 > -1) {
                  class3.field37[0].method4192(var2 + Client.field347 - 12, var3 + Client.field394 - 28);
               }
            }
         }

         if(null != var0.overhead && (var1 >= var79 || !var0.inSequence && (Client.field364 == 4 || !var0.field609 && (Client.field364 == 0 || Client.field364 == 3 || Client.field364 == 1 && class22.method221(((Player)var0).name, false))))) {
            class3.method34(var0, var0.field621);
            if(Client.field347 > -1 && Client.field381 < Client.field382) {
               Client.field386[Client.field381] = class156.field2236.method3912(var0.overhead) / 2;
               Client.field385[Client.field381] = class156.field2236.field3091;
               Client.field530[Client.field381] = Client.field347;
               Client.field384[Client.field381] = Client.field394;
               Client.field387[Client.field381] = var0.field612;
               Client.field293[Client.field381] = var0.field613;
               Client.field389[Client.field381] = var0.field607;
               Client.field307[Client.field381] = var0.overhead;
               ++Client.field381;
            }
         }

         for(int var80 = 0; var80 < 4; ++var80) {
            int var81 = var0.field617[var80];
            int var84 = var0.field615[var80];
            class196 var87 = null;
            int var83 = 0;
            if(var84 >= 0) {
               if(var81 <= Client.gameCycle) {
                  continue;
               }

               var87 = class6.method92(var0.field615[var80]);
               var83 = var87.field2867;
               if(null != var87 && null != var87.field2885) {
                  var87 = var87.method3619();
                  if(null == var87) {
                     var0.field617[var80] = -1;
                     continue;
                  }
               }
            } else if(var81 < 0) {
               continue;
            }

            var14 = var0.field618[var80];
            class196 var77 = null;
            if(var14 >= 0) {
               var77 = class6.method92(var14);
               if(null != var77 && null != var77.field2885) {
                  var77 = var77.method3619();
               }
            }

            if(var81 - var83 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.field617[var80] = -1;
               } else {
                  class3.method34(var0, var0.field621 / 2);
                  if(Client.field347 > -1) {
                     if(var80 == 1) {
                        Client.field394 -= 20;
                     }

                     if(var80 == 2) {
                        Client.field347 -= 15;
                        Client.field394 -= 10;
                     }

                     if(var80 == 3) {
                        Client.field347 += 15;
                        Client.field394 -= 10;
                     }

                     SpritePixels var82 = null;
                     SpritePixels var76 = null;
                     SpritePixels var78 = null;
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
                     var82 = var87.method3621();
                     int var42;
                     if(var82 != null) {
                        var21 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var82.field3201;
                     }

                     var76 = var87.method3622();
                     if(var76 != null) {
                        var22 = var76.width;
                        var42 = var76.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var76.field3201;
                     }

                     var78 = var87.method3623();
                     if(null != var78) {
                        var23 = var78.width;
                        var42 = var78.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var78.field3201;
                     }

                     var20 = var87.method3634();
                     if(var20 != null) {
                        var24 = var20.width;
                        var42 = var20.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var20.field3201;
                     }

                     if(null != var77) {
                        var29 = var77.method3621();
                        if(null != var29) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.field3201;
                        }

                        var30 = var77.method3622();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.field3201;
                        }

                        var31 = var77.method3623();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.field3201;
                        }

                        var32 = var77.method3634();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.field3201;
                        }
                     }

                     class208 var74 = var87.method3632();
                     if(var74 == null) {
                        var74 = GroundObject.field1293;
                     }

                     class208 var43;
                     if(null != var77) {
                        var43 = var77.method3632();
                        if(var43 == null) {
                           var43 = GroundObject.field1293;
                        }
                     } else {
                        var43 = GroundObject.field1293;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method3618(var0.field619[var80]);
                     int var89 = var74.method3912(var44);
                     if(var77 != null) {
                        var45 = var77.method3618(var0.field655[var80]);
                        var47 = var43.method3912(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(null == var78 && var20 == null) {
                           var48 = 1;
                        } else {
                           var48 = 1 + var89 / var22;
                        }
                     }

                     if(null != var77 && var34 > 0) {
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
                     if(null != var77) {
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

                     var61 = var0.field617[var80] - Client.gameCycle;
                     int var62 = var87.field2879 - var61 * var87.field2879 / var87.field2867;
                     int var63 = -var87.field2880 + var61 * var87.field2880 / var87.field2867;
                     int var64 = Client.field347 + var2 - (var50 >> 1) + var62;
                     int var65 = var63 + (var3 + Client.field394 - 12);
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var87.field2865 + var65 + 15;
                     int var69 = var68 - var74.field3092;
                     int var70 = var74.field3096 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(null != var77) {
                        var71 = var65 + 15 + var77.field2865;
                        var72 = var71 - var43.field3092;
                        var73 = var71 + var43.field3096;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field2874 >= 0) {
                        var72 = (var61 << 8) / (var87.field2867 - var87.field2874);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var82 != null) {
                           var82.method4198(var64 + var51 - var25, var65, var72);
                        }

                        if(var78 != null) {
                           var78.method4198(var52 + var64 - var27, var65, var72);
                        }

                        if(var76 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var76.method4198(var64 + var53 - var26 + var22 * var73, var65, var72);
                           }
                        }

                        if(var20 != null) {
                           var20.method4198(var55 + var64 - var28, var65, var72);
                        }

                        var74.method3972(var44, var64 + var54, var68, var87.field2883, 0, var72);
                        if(var77 != null) {
                           if(var29 != null) {
                              var29.method4198(var56 + var64 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method4198(var64 + var57 - var39, var65, var72);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4198(var64 + var58 - var38 + var34 * var73, var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method4198(var59 + var64 - var40, var65, var72);
                           }

                           var43.method3972(var45, var60 + var64, var71, var77.field2883, 0, var72);
                        }
                     } else {
                        if(var82 != null) {
                           var82.method4192(var51 + var64 - var25, var65);
                        }

                        if(null != var78) {
                           var78.method4192(var52 + var64 - var27, var65);
                        }

                        if(null != var76) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var76.method4192(var64 + var53 - var26 + var22 * var73, var65);
                           }
                        }

                        if(var20 != null) {
                           var20.method4192(var64 + var55 - var28, var65);
                        }

                        var74.method3920(var44, var54 + var64, var68, var87.field2883 | -16777216, 0);
                        if(var77 != null) {
                           if(var29 != null) {
                              var29.method4192(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method4192(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4192(var64 + var58 - var38 + var34 * var73, var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method4192(var64 + var59 - var40, var65);
                           }

                           var43.method3920(var45, var60 + var64, var71, var77.field2883 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-733636260"
   )
   public static Widget method79(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || null == Widget.widgets[var1][var2]) {
         boolean var3 = class60.method1127(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)LSpritePixels;",
      garbageValue = "-70"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(null != var8) {
            return var8;
         }
      }

      ItemComposition var9 = class18.getItemDefinition(var0);
      if(var1 > 1 && var9.field2966 != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field2978[var11] && var9.field2978[var11] != 0) {
               var10 = var9.field2966[var11];
            }
         }

         if(var10 != -1) {
            var9 = class18.getItemDefinition(var10);
         }
      }

      Model var20 = var9.getModel(1);
      if(null == var20) {
         return null;
      } else {
         SpritePixels var19 = null;
         if(var9.field2980 != -1) {
            var19 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var19 == null) {
               return null;
            }
         } else if(var9.field2972 != -1) {
            var19 = createSprite(var9.field2957, var1, var2, var3, 0, false);
            if(null == var19) {
               return null;
            }
         } else if(var9.field2991 != -1) {
            var19 = createSprite(var9.field2958, var1, 0, 0, 0, false);
            if(var19 == null) {
               return null;
            }
         }

         int[] var12 = class219.graphicsPixels;
         int var13 = class219.graphicsPixelsWidth;
         int var14 = class219.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class219.method4043(var15);
         var8 = new SpritePixels(36, 32);
         class219.setRasterBuffer(var8.image, 36, 32);
         class219.method4061();
         class84.method1666();
         class84.method1669(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field2991 != -1) {
            var19.method4192(0, 0);
         }

         int var16 = var9.field2952;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = class84.field1444[var9.field2955] * var16 >> 16;
         int var18 = var16 * class84.field1445[var9.field2955] >> 16;
         var20.method1584();
         var20.method1596(0, var9.field2982, var9.field2977, var9.field2955, var9.field2940, var17 + var20.modelHeight / 2 + var9.field2959, var9.field2959 + var18);
         if(var9.field2972 != -1) {
            var19.method4192(0, 0);
         }

         if(var2 >= 1) {
            var8.method4276(1);
         }

         if(var2 >= 2) {
            var8.method4276(16777215);
         }

         if(var3 != 0) {
            var8.method4189(var3);
         }

         class219.setRasterBuffer(var8.image, 36, 32);
         if(var9.field2980 != -1) {
            var19.method4192(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class183.field2733.method3920(ItemLayer.method1488(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class219.setRasterBuffer(var12, var13, var14);
         class219.method4044(var15);
         class84.method1666();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
