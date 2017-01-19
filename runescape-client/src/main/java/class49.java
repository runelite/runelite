import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class49 extends Renderable {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -754135683
   )
   int field945;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -775492941
   )
   int field946;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -720152631
   )
   int field947;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1456985779
   )
   int field948;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1741813131
   )
   int field949;
   @ObfuscatedName("k")
   Sequence field950;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1489751161
   )
   int field951;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 844207267
   )
   int field952;
   @ObfuscatedName("dw")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("rb")
   protected static boolean field956;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 504190037
   )
   int field958;

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field958 = var1;
      this.field946 = var2;
      this.field947 = var3;
      this.field948 = var4;
      this.field949 = var5;
      this.field951 = var6;
      if(var7 != -1) {
         this.field950 = class110.getAnimation(var7);
         this.field952 = 0;
         this.field945 = Client.gameCycle - 1;
         if(this.field950.replyMode == 0 && var9 != null && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(this.field950 == var10.field950) {
               this.field952 = var10.field952;
               this.field945 = var10.field945;
               return;
            }
         }

         if(var8 && this.field950.frameStep != -1) {
            this.field952 = (int)(Math.random() * (double)this.field950.frameIDs.length);
            this.field945 -= (int)(Math.random() * (double)this.field950.frameLenghts[this.field952]);
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2062912069"
   )
   protected final Model getModel() {
      if(null != this.field950) {
         int var12 = Client.gameCycle - this.field945;
         if(var12 > 100 && this.field950.frameStep > 0) {
            var12 = 100;
         }

         label67: {
            do {
               do {
                  if(var12 <= this.field950.frameLenghts[this.field952]) {
                     break label67;
                  }

                  var12 -= this.field950.frameLenghts[this.field952];
                  ++this.field952;
               } while(this.field952 < this.field950.frameIDs.length);

               this.field952 -= this.field950.frameStep;
            } while(this.field952 >= 0 && this.field952 < this.field950.frameIDs.length);

            this.field950 = null;
         }

         this.field945 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = class143.getObjectDefinition(this.field958);
      if(var1.impostorIds != null) {
         var1 = var1.getImpostor();
      }

      if(null == var1) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field947 != 1 && this.field947 != 3) {
            var2 = var1.sizeX;
            var3 = var1.sizeY;
         } else {
            var2 = var1.sizeY;
            var3 = var1.sizeX;
         }

         int var4 = this.field949 + (var2 >> 1);
         int var5 = (1 + var2 >> 1) + this.field949;
         int var6 = this.field951 + (var3 >> 1);
         int var7 = (1 + var3 >> 1) + this.field951;
         int[][] var8 = class10.tileHeights[this.field948];
         int var9 = var8[var4][var7] + var8[var5][var6] + var8[var4][var6] + var8[var5][var7] >> 2;
         int var10 = (var2 << 6) + (this.field949 << 7);
         int var11 = (var3 << 6) + (this.field951 << 7);
         return var1.method3489(this.field946, this.field947, var8, var10, var9, var11, this.field950, this.field952);
      }
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1222466987"
   )
   static boolean method854(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class137.method2397(var0, class1.field15);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class137.method2397(Client.friends[var3].name, class1.field15)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class137.method2397(XItemContainer.localPlayer.name, class1.field15))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIIB)V",
      garbageValue = "-111"
   )
   static final void method855(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod699()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.method3576();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class45.field894;
         int[] var7 = class45.field896;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method2298()) {
            class210.method3821(var0, 15 + var0.field654);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method2295(); null != var9; var9 = (CombatInfoListHolder)var0.combatInfoList.method2291()) {
               CombatInfo1 var10 = var9.method680(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method678()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method3411();
                  SpritePixels var13 = var11.method3410();
                  int var15 = 0;
                  if(var12 != null && null != var13) {
                     if(var11.field2848 * 2 < var13.width) {
                        var15 = var11.field2848;
                     }

                     var14 = var13.width - 2 * var15;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field670;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field669 > var18) {
                     var20 = var11.field2846 == 0?0:var11.field2846 * (var18 / var11.field2846);
                     var21 = var10.healthRatio * var14 / var11.healthScale;
                     var88 = var21 + var20 * (var19 - var21) / var10.field669;
                  } else {
                     var88 = var19;
                     var20 = var11.field2849 + var10.field669 - var18;
                     if(var11.field2842 >= 0) {
                        var16 = (var20 << 8) / (var11.field2849 - var11.field2842);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.field398 - (var14 >> 1);
                  var21 = Client.field399 + var3 - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var14 == var88) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method3977(var20, var21, var16);
                        Rasterizer2D.method3845(var20, var21, var88 + var20, var21 + var22);
                        var13.method3977(var20, var21, var16);
                     } else {
                        var12.method3971(var20, var21);
                        Rasterizer2D.method3845(var20, var21, var88 + var20, var22 + var21);
                        var13.method3971(var20, var21);
                     }

                     Rasterizer2D.method3844(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field398 > -1) {
                        Rasterizer2D.method3876(var20, var21, var88, 5, '\uff00');
                        Rasterizer2D.method3876(var20 + var88, var21, var14 - var88, 5, 16711680);
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
            if(var85.field257) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               class210.method3821(var0, var0.field654 + 15);
               if(Client.field398 > -1) {
                  if(var85.skullIcon != -1) {
                     class41.field848[var85.skullIcon].method3971(Client.field398 + var2 - 12, var3 + Client.field399 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class150.field2053[var85.overheadIcon].method3971(var2 + Client.field398 - 12, var3 + Client.field399 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field311 == 10 && Client.field313 == var7[var1]) {
               class210.method3821(var0, var0.field654 + 15);
               if(Client.field398 > -1) {
                  class101.field1658[1].method3971(Client.field398 + var2 - 12, var3 + Client.field399 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.method3576();
            }

            if(var86.field3021 >= 0 && var86.field3021 < class150.field2053.length) {
               class210.method3821(var0, 15 + var0.field654);
               if(Client.field398 > -1) {
                  class150.field2053[var86.field3021].method3971(Client.field398 + var2 - 12, Client.field399 + var3 - 30);
               }
            }

            if(Client.field311 == 1 && Client.field333[var1 - var74] == Client.field312 && Client.gameCycle % 20 < 10) {
               class210.method3821(var0, 15 + var0.field654);
               if(Client.field398 > -1) {
                  class101.field1658[0].method3971(Client.field398 + var2 - 12, var3 + Client.field399 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field510 == 4 || !var0.field625 && (Client.field510 == 0 || Client.field510 == 3 || Client.field510 == 1 && method854(((Player)var0).name, false))))) {
            class210.method3821(var0, var0.field654);
            if(Client.field398 > -1 && Client.field386 < Client.field387) {
               Client.field391[Client.field386] = class16.field187.method3722(var0.overhead) / 2;
               Client.field341[Client.field386] = class16.field187.field3102;
               Client.field338[Client.field386] = Client.field398;
               Client.field389[Client.field386] = Client.field399;
               Client.field392[Client.field386] = var0.field621;
               Client.field393[Client.field386] = var0.field622;
               Client.field394[Client.field386] = var0.field649;
               Client.field395[Client.field386] = var0.overhead;
               ++Client.field386;
            }
         }

         for(int var77 = 0; var77 < 4; ++var77) {
            int var83 = var0.field626[var77];
            int var81 = var0.field641[var77];
            class196 var87 = null;
            int var79 = 0;
            if(var81 >= 0) {
               if(var83 <= Client.gameCycle) {
                  continue;
               }

               var87 = class97.method1871(var0.field641[var77]);
               var79 = var87.field2882;
               if(var87 != null && null != var87.field2893) {
                  var87 = var87.method3455();
                  if(var87 == null) {
                     var0.field626[var77] = -1;
                     continue;
                  }
               }
            } else if(var83 < 0) {
               continue;
            }

            var14 = var0.field627[var77];
            class196 var76 = null;
            if(var14 >= 0) {
               var76 = class97.method1871(var14);
               if(null != var76 && var76.field2893 != null) {
                  var76 = var76.method3455();
               }
            }

            if(var83 - var79 <= Client.gameCycle) {
               if(null == var87) {
                  var0.field626[var77] = -1;
               } else {
                  class210.method3821(var0, var0.field654 / 2);
                  if(Client.field398 > -1) {
                     if(var77 == 1) {
                        Client.field399 -= 20;
                     }

                     if(var77 == 2) {
                        Client.field398 -= 15;
                        Client.field399 -= 10;
                     }

                     if(var77 == 3) {
                        Client.field398 += 15;
                        Client.field399 -= 10;
                     }

                     SpritePixels var80 = null;
                     SpritePixels var82 = null;
                     SpritePixels var84 = null;
                     SpritePixels var75 = null;
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
                     var80 = var87.method3456();
                     int var78;
                     if(null != var80) {
                        var21 = var80.width;
                        var78 = var80.height;
                        if(var78 > var41) {
                           var41 = var78;
                        }

                        var25 = var80.offsetX;
                     }

                     var82 = var87.method3457();
                     if(null != var82) {
                        var22 = var82.width;
                        var78 = var82.height;
                        if(var78 > var41) {
                           var41 = var78;
                        }

                        var26 = var82.offsetX;
                     }

                     var84 = var87.method3458();
                     if(null != var84) {
                        var23 = var84.width;
                        var78 = var84.height;
                        if(var78 > var41) {
                           var41 = var78;
                        }

                        var27 = var84.offsetX;
                     }

                     var75 = var87.method3459();
                     if(var75 != null) {
                        var24 = var75.width;
                        var78 = var75.height;
                        if(var78 > var41) {
                           var41 = var78;
                        }

                        var28 = var75.offsetX;
                     }

                     if(null != var76) {
                        var29 = var76.method3456();
                        if(var29 != null) {
                           var33 = var29.width;
                           var78 = var29.height;
                           if(var78 > var41) {
                              var41 = var78;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var76.method3457();
                        if(null != var30) {
                           var34 = var30.width;
                           var78 = var30.height;
                           if(var78 > var41) {
                              var41 = var78;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var76.method3458();
                        if(null != var31) {
                           var35 = var31.width;
                           var78 = var31.height;
                           if(var78 > var41) {
                              var41 = var78;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var76.method3459();
                        if(null != var32) {
                           var36 = var32.width;
                           var78 = var32.height;
                           if(var78 > var41) {
                              var41 = var78;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var42 = var87.method3473();
                     if(null == var42) {
                        var42 = class137.field1909;
                     }

                     Font var43;
                     if(null != var76) {
                        var43 = var76.method3473();
                        if(null == var43) {
                           var43 = class137.field1909;
                        }
                     } else {
                        var43 = class137.field1909;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method3461(var0.field618[var77]);
                     int var89 = var42.method3722(var44);
                     if(null != var76) {
                        var45 = var76.method3461(var0.field628[var77]);
                        var47 = var43.method3722(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var84 == null && null == var75) {
                           var48 = 1;
                        } else {
                           var48 = 1 + var89 / var22;
                        }
                     }

                     if(var76 != null && var34 > 0) {
                        if(null == var31 && null == var32) {
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
                     if(var76 != null) {
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

                     var61 = var0.field626[var77] - Client.gameCycle;
                     int var62 = var87.field2895 - var61 * var87.field2895 / var87.field2882;
                     int var63 = -var87.field2888 + var61 * var87.field2888 / var87.field2882;
                     int var64 = var62 + (var2 + Client.field398 - (var50 >> 1));
                     int var65 = var63 + (var3 + Client.field399 - 12);
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var87.field2887 + 15 + var65;
                     int var69 = var68 - var42.field3107;
                     int var70 = var68 + var42.field3108;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var76 != null) {
                        var71 = var76.field2887 + var65 + 15;
                        var72 = var71 - var43.field3107;
                        var73 = var43.field3108 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field2889 >= 0) {
                        var72 = (var61 << 8) / (var87.field2882 - var87.field2889);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(null != var80) {
                           var80.method3977(var64 + var51 - var25, var65, var72);
                        }

                        if(null != var84) {
                           var84.method3977(var52 + var64 - var27, var65, var72);
                        }

                        if(null != var82) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var82.method3977(var73 * var22 + (var53 + var64 - var26), var65, var72);
                           }
                        }

                        if(var75 != null) {
                           var75.method3977(var64 + var55 - var28, var65, var72);
                        }

                        var42.method3728(var44, var54 + var64, var68, var87.field2881, 0, var72);
                        if(null != var76) {
                           if(null != var29) {
                              var29.method3977(var64 + var56 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method3977(var57 + var64 - var39, var65, var72);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method3977(var64 + var58 - var38 + var34 * var73, var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method3977(var59 + var64 - var40, var65, var72);
                           }

                           var43.method3728(var45, var60 + var64, var71, var76.field2881, 0, var72);
                        }
                     } else {
                        if(null != var80) {
                           var80.method3971(var64 + var51 - var25, var65);
                        }

                        if(null != var84) {
                           var84.method3971(var52 + var64 - var27, var65);
                        }

                        if(null != var82) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var82.method3971(var53 + var64 - var26 + var22 * var73, var65);
                           }
                        }

                        if(var75 != null) {
                           var75.method3971(var55 + var64 - var28, var65);
                        }

                        var42.method3727(var44, var64 + var54, var68, var87.field2881 | -16777216, 0);
                        if(null != var76) {
                           if(null != var29) {
                              var29.method3971(var56 + var64 - var37, var65);
                           }

                           if(null != var31) {
                              var31.method3971(var57 + var64 - var39, var65);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method3971(var34 * var73 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(null != var32) {
                              var32.method3971(var59 + var64 - var40, var65);
                           }

                           var43.method3727(var45, var64 + var60, var71, var76.field2881 | -16777216, 0);
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
      signature = "([BI)[B",
      garbageValue = "626236105"
   )
   static final byte[] method856(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.method2727();
      if(var3 >= 0 && (class182.field2728 == 0 || var3 <= class182.field2728)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2824(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2727();
            if(var4 >= 0 && (class182.field2728 == 0 || var4 <= class182.field2728)) {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class147.method2662(var5, var4, var0, var3, 9);
               } else {
                  class182.field2723.method2656(var1, var5);
               }

               return var5;
            } else {
               throw new RuntimeException();
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
