import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 595441043
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("ct")
   void vmethod1830(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1830(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-12"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-1409539870"
   )
   static void method1833(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      DecorativeObject.method1877(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         DecorativeObject.method1877(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2299((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class2.method25(var6)) {
            DecorativeObject.method1877(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "1387842449"
   )
   static final void method1837(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod702()) {
         if(var0 instanceof NPC) {
            NPCComposition var75 = ((NPC)var0).composition;
            if(var75.field3023 != null) {
               var75 = var75.method3643();
            }

            if(null == var75) {
               return;
            }
         }

         int var6 = class45.field900;
         int[] var7 = class45.field902;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method2314()) {
            class206.method3733(var0, var0.field634 + 15);

            for(CombatInfoListHolder var74 = (CombatInfoListHolder)var0.combatInfoList.method2311(); null != var74; var74 = (CombatInfoListHolder)var0.combatInfoList.method2309()) {
               CombatInfo1 var10 = var74.method679(Client.gameCycle);
               if(null == var10) {
                  if(var74.method680()) {
                     var74.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var74.combatInfo2;
                  SpritePixels var12 = var11.method3434();
                  SpritePixels var13 = var11.method3438();
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
                  int var77 = Client.gameCycle - var10.field667;
                  int var19 = var14 * var10.field673 / var11.healthScale;
                  int var20;
                  int var86;
                  if(var10.field668 > var77) {
                     var20 = var11.field2835 == 0?0:var77 / var11.field2835 * var11.field2835;
                     var21 = var10.healthRatio * var14 / var11.healthScale;
                     var86 = var21 + (var19 - var21) * var20 / var10.field668;
                  } else {
                     var86 = var19;
                     var20 = var10.field668 + var11.field2833 - var77;
                     if(var11.field2837 >= 0) {
                        var16 = (var20 << 8) / (var11.field2833 - var11.field2837);
                     }
                  }

                  if(var10.field673 > 0 && var86 < 1) {
                     var86 = 1;
                  }

                  var20 = var2 + Client.field392 - (var14 >> 1);
                  var21 = var3 + Client.field393 - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var14 == var86) {
                        var86 += var15 * 2;
                     } else {
                        var86 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method4054(var20, var21, var16);
                        class219.method3894(var20, var21, var20 + var86, var21 + var22);
                        var13.method4054(var20, var21, var16);
                     } else {
                        var12.method4048(var20, var21);
                        class219.method3894(var20, var21, var86 + var20, var21 + var22);
                        var13.method4048(var20, var21);
                     }

                     class219.method3893(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.field392 > -1) {
                        class219.method3899(var20, var21, var86, 5, '\uff00');
                        class219.method3899(var86 + var20, var21, var14 - var86, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var6) {
            Player var88 = (Player)var0;
            if(var88.field268) {
               return;
            }

            if(var88.skullIcon != -1 || var88.overheadIcon != -1) {
               class206.method3733(var0, 15 + var0.field634);
               if(Client.field392 > -1) {
                  if(var88.skullIcon != -1) {
                     class32.field740[var88.skullIcon].method4048(var2 + Client.field392 - 12, var3 + Client.field393 - var8);
                     var8 += 25;
                  }

                  if(var88.overheadIcon != -1) {
                     class150.field2061[var88.overheadIcon].method4048(Client.field392 + var2 - 12, var3 + Client.field393 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field306 == 10 && var7[var1] == Client.field357) {
               class206.method3733(var0, 15 + var0.field634);
               if(Client.field392 > -1) {
                  class143.field2019[1].method4048(var2 + Client.field392 - 12, Client.field393 + var3 - var8);
               }
            }
         } else {
            NPCComposition var89 = ((NPC)var0).composition;
            if(null != var89.field3023) {
               var89 = var89.method3643();
            }

            if(var89.field3032 >= 0 && var89.field3032 < class150.field2061.length) {
               class206.method3733(var0, 15 + var0.field634);
               if(Client.field392 > -1) {
                  class150.field2061[var89.field3032].method4048(var2 + Client.field392 - 12, Client.field393 + var3 - 30);
               }
            }

            if(Client.field306 == 1 && Client.field327[var1 - var6] == Client.field307 && Client.gameCycle % 20 < 10) {
               class206.method3733(var0, 15 + var0.field634);
               if(Client.field392 > -1) {
                  class143.field2019[0].method4048(var2 + Client.field392 - 12, var3 + Client.field393 - 28);
               }
            }
         }

         if(null != var0.overhead && (var1 >= var6 || !var0.inSequence && (Client.field352 == 4 || !var0.field617 && (Client.field352 == 0 || Client.field352 == 3 || Client.field352 == 1 && class155.method2934(((Player)var0).name, false))))) {
            class206.method3733(var0, var0.field634);
            if(Client.field392 > -1 && Client.field292 < Client.field381) {
               Client.field530[Client.field292] = Ignore.field218.method3774(var0.overhead) / 2;
               Client.field458[Client.field292] = Ignore.field218.field3102;
               Client.field286[Client.field292] = Client.field392;
               Client.field304[Client.field292] = Client.field393;
               Client.field386[Client.field292] = var0.field608;
               Client.field355[Client.field292] = var0.field621;
               Client.field414[Client.field292] = var0.field619;
               Client.field389[Client.field292] = var0.overhead;
               ++Client.field292;
            }
         }

         for(int var9 = 0; var9 < 4; ++var9) {
            int var81 = var0.field609[var9];
            int var82 = var0.field638[var9];
            class196 var85 = null;
            int var83 = 0;
            if(var82 >= 0) {
               if(var81 <= Client.gameCycle) {
                  continue;
               }

               var85 = class164.method3054(var0.field638[var9]);
               var83 = var85.field2875;
               if(null != var85 && null != var85.field2877) {
                  var85 = var85.method3491();
                  if(null == var85) {
                     var0.field609[var9] = -1;
                     continue;
                  }
               }
            } else if(var81 < 0) {
               continue;
            }

            var14 = var0.field627[var9];
            class196 var78 = null;
            if(var14 >= 0) {
               var78 = class164.method3054(var14);
               if(null != var78 && var78.field2877 != null) {
                  var78 = var78.method3491();
               }
            }

            if(var81 - var83 <= Client.gameCycle) {
               if(null == var85) {
                  var0.field609[var9] = -1;
               } else {
                  class206.method3733(var0, var0.field634 / 2);
                  if(Client.field392 > -1) {
                     if(var9 == 1) {
                        Client.field393 -= 20;
                     }

                     if(var9 == 2) {
                        Client.field392 -= 15;
                        Client.field393 -= 10;
                     }

                     if(var9 == 3) {
                        Client.field392 += 15;
                        Client.field393 -= 10;
                     }

                     SpritePixels var84 = null;
                     SpritePixels var18 = null;
                     SpritePixels var80 = null;
                     SpritePixels var79 = null;
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
                     var84 = var85.method3479();
                     int var76;
                     if(null != var84) {
                        var21 = var84.width;
                        var76 = var84.height;
                        if(var76 > var41) {
                           var41 = var76;
                        }

                        var25 = var84.field3203;
                     }

                     var18 = var85.method3501();
                     if(var18 != null) {
                        var22 = var18.width;
                        var76 = var18.height;
                        if(var76 > var41) {
                           var41 = var76;
                        }

                        var26 = var18.field3203;
                     }

                     var80 = var85.method3481();
                     if(var80 != null) {
                        var23 = var80.width;
                        var76 = var80.height;
                        if(var76 > var41) {
                           var41 = var76;
                        }

                        var27 = var80.field3203;
                     }

                     var79 = var85.method3482();
                     if(var79 != null) {
                        var24 = var79.width;
                        var76 = var79.height;
                        if(var76 > var41) {
                           var41 = var76;
                        }

                        var28 = var79.field3203;
                     }

                     if(null != var78) {
                        var29 = var78.method3479();
                        if(null != var29) {
                           var33 = var29.width;
                           var76 = var29.height;
                           if(var76 > var41) {
                              var41 = var76;
                           }

                           var37 = var29.field3203;
                        }

                        var30 = var78.method3501();
                        if(var30 != null) {
                           var34 = var30.width;
                           var76 = var30.height;
                           if(var76 > var41) {
                              var41 = var76;
                           }

                           var38 = var30.field3203;
                        }

                        var31 = var78.method3481();
                        if(null != var31) {
                           var35 = var31.width;
                           var76 = var31.height;
                           if(var76 > var41) {
                              var41 = var76;
                           }

                           var39 = var31.field3203;
                        }

                        var32 = var78.method3482();
                        if(var32 != null) {
                           var36 = var32.width;
                           var76 = var32.height;
                           if(var76 > var41) {
                              var41 = var76;
                           }

                           var40 = var32.field3203;
                        }
                     }

                     class208 var42 = var85.method3506();
                     if(var42 == null) {
                        var42 = class5.field40;
                     }

                     class208 var43;
                     if(var78 != null) {
                        var43 = var78.method3506();
                        if(var43 == null) {
                           var43 = class5.field40;
                        }
                     } else {
                        var43 = class5.field40;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var85.method3478(var0.field625[var9]);
                     int var87 = var42.method3774(var44);
                     if(var78 != null) {
                        var45 = var78.method3478(var0.field628[var9]);
                        var47 = var43.method3774(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var80 == null && var79 == null) {
                           var48 = 1;
                        } else {
                           var48 = 1 + var87 / var22;
                        }
                     }

                     if(null != var78 && var34 > 0) {
                        if(var31 == null && null == var32) {
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

                     var61 = var0.field609[var9] - Client.gameCycle;
                     int var62 = var85.field2880 - var85.field2880 * var61 / var85.field2875;
                     int var63 = -var85.field2882 + var85.field2882 * var61 / var85.field2875;
                     int var64 = var2 + Client.field392 - (var50 >> 1) + var62;
                     int var65 = var63 + (var3 + Client.field393 - 12);
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var65 + 15 + var85.field2867;
                     int var69 = var68 - var42.field3105;
                     int var70 = var42.field3104 + var68;
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
                        var71 = 15 + var65 + var78.field2867;
                        var72 = var71 - var43.field3105;
                        var73 = var71 + var43.field3104;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var85.field2885 >= 0) {
                        var72 = (var61 << 8) / (var85.field2875 - var85.field2885);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(null != var84) {
                           var84.method4054(var64 + var51 - var25, var65, var72);
                        }

                        if(var80 != null) {
                           var80.method4054(var52 + var64 - var27, var65, var72);
                        }

                        if(var18 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method4054(var73 * var22 + (var53 + var64 - var26), var65, var72);
                           }
                        }

                        if(null != var79) {
                           var79.method4054(var55 + var64 - var28, var65, var72);
                        }

                        var42.method3780(var44, var64 + var54, var68, var85.field2874, 0, var72);
                        if(var78 != null) {
                           if(var29 != null) {
                              var29.method4054(var64 + var56 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method4054(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4054(var58 + var64 - var38 + var34 * var73, var65, var72);
                              }
                           }

                           if(null != var32) {
                              var32.method4054(var59 + var64 - var40, var65, var72);
                           }

                           var43.method3780(var45, var64 + var60, var71, var78.field2874, 0, var72);
                        }
                     } else {
                        if(null != var84) {
                           var84.method4048(var64 + var51 - var25, var65);
                        }

                        if(null != var80) {
                           var80.method4048(var64 + var52 - var27, var65);
                        }

                        if(null != var18) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method4048(var22 * var73 + (var53 + var64 - var26), var65);
                           }
                        }

                        if(null != var79) {
                           var79.method4048(var64 + var55 - var28, var65);
                        }

                        var42.method3784(var44, var64 + var54, var68, var85.field2874 | -16777216, 0);
                        if(var78 != null) {
                           if(var29 != null) {
                              var29.method4048(var56 + var64 - var37, var65);
                           }

                           if(null != var31) {
                              var31.method4048(var64 + var57 - var39, var65);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4048(var73 * var34 + (var58 + var64 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method4048(var59 + var64 - var40, var65);
                           }

                           var43.method3784(var45, var60 + var64, var71, var78.field2874 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
