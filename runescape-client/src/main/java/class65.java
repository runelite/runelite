import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class65 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 301622695
   )
   int field1110;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 1426143271
   )
   static int field1111;
   @ObfuscatedName("j")
   int[][] field1112;
   @ObfuscatedName("dl")
   @Export("region")
   static Region region;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 858666971
   )
   int field1114;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1809856333"
   )
   int method1181(int var1) {
      if(null != this.field1112) {
         var1 = (int)((long)var1 * (long)this.field1114 / (long)this.field1110);
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1386383395"
   )
   int method1182(int var1) {
      if(this.field1112 != null) {
         var1 = 6 + (int)((long)var1 * (long)this.field1114 / (long)this.field1110);
      }

      return var1;
   }

   public class65(int var1, int var2) {
      if(var1 != var2) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1110 = var1;
         this.field1114 = var2;
         this.field1112 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1112[var7];
            double var9 = 6.0D + (double)var7 / (double)var1;
            int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(7.0D + var9);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = 3.141592653589793D * ((double)var11 - var9);
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(65536.0D * var17 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-539487858"
   )
   byte[] method1185(byte[] var1) {
      if(null != this.field1112) {
         int var2 = 14 + (int)((long)this.field1114 * (long)var1.length / (long)this.field1110);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1112[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1114;
            var9 = var5 / this.field1110;
            var4 += var9;
            var5 -= this.field1110 * var9;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "247141482"
   )
   static final WidgetNode method1186(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field178 = var2;
      Client.componentTable.method2333(var3, (long)var0);
      class2.method23(var1);
      Widget var4 = class37.method759(var0);
      class2.method28(var4);
      if(Client.field309 != null) {
         class2.method28(Client.field309);
         Client.field309 = null;
      }

      class9.method124();
      class22.method233(Widget.widgets[var0 >> 16], var4, false);
      class119.method2280(var1);
      if(Client.widgetRoot != -1) {
         class148.method2769(Client.widgetRoot, 1);
      }

      return var3;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "-1891688968"
   )
   static final void method1187(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod736()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.method3729();
            }

            if(null == var6) {
               return;
            }
         }

         int var74 = class45.field901;
         int[] var7 = class45.field902;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method2368()) {
            class156.method2898(var0, 15 + var0.field592);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method2351(); null != var9; var9 = (CombatInfoListHolder)var0.combatInfoList.method2353()) {
               CombatInfo1 var10 = var9.method727(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method726()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method3515();
                  SpritePixels var13 = var11.method3526();
                  int var15 = 0;
                  if(null != var12 && var13 != null) {
                     if(var11.field2824 * 2 < var13.width) {
                        var15 = var11.field2824;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field654;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field657 > var18) {
                     var20 = var11.field2823 == 0?0:var18 / var11.field2823 * var11.field2823;
                     var21 = var10.healthRatio * var14 / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.field657 + var21;
                  } else {
                     var88 = var19;
                     var20 = var10.field657 + var11.field2816 - var18;
                     if(var11.field2822 >= 0) {
                        var16 = (var20 << 8) / (var11.field2816 - var11.field2822);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.field383 - (var14 >> 1);
                  var21 = Client.field384 + var3 - var8;
                  if(null != var12 && null != var13) {
                     var20 -= var15;
                     if(var88 == var14) {
                        var88 += 2 * var15;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method4120(var20, var21, var16);
                        Rasterizer2D.method3974(var20, var21, var20 + var88, var21 + var22);
                        var13.method4120(var20, var21, var16);
                     } else {
                        var12.method4121(var20, var21);
                        Rasterizer2D.method3974(var20, var21, var20 + var88, var22 + var21);
                        var13.method4121(var20, var21);
                     }

                     Rasterizer2D.method3973(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field383 > -1) {
                        Rasterizer2D.method4004(var20, var21, var88, 5, '\uff00');
                        Rasterizer2D.method4004(var20 + var88, var21, var14 - var88, 5, 16711680);
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
            if(var85.field262) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               class156.method2898(var0, 15 + var0.field592);
               if(Client.field383 > -1) {
                  if(var85.skullIcon != -1) {
                     class101.field1666[var85.skullIcon].method4121(var2 + Client.field383 - 12, var3 + Client.field384 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class94.field1591[var85.overheadIcon].method4121(var2 + Client.field383 - 12, Client.field384 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field296 == 10 && Client.field298 == var7[var1]) {
               class156.method2898(var0, var0.field592 + 15);
               if(Client.field383 > -1) {
                  class49.field963[1].method4121(Client.field383 + var2 - 12, Client.field384 + var3 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(null != var86.configs) {
               var86 = var86.method3729();
            }

            if(var86.field2985 >= 0 && var86.field2985 < class94.field1591.length) {
               class156.method2898(var0, var0.field592 + 15);
               if(Client.field383 > -1) {
                  class94.field1591[var86.field2985].method4121(Client.field383 + var2 - 12, Client.field384 + var3 - 30);
               }
            }

            if(Client.field296 == 1 && Client.field297 == Client.field554[var1 - var74] && Client.gameCycle % 20 < 10) {
               class156.method2898(var0, 15 + var0.field592);
               if(Client.field383 > -1) {
                  class49.field963[0].method4121(Client.field383 + var2 - 12, Client.field384 + var3 - 28);
               }
            }
         }

         if(null != var0.overhead && (var1 >= var74 || !var0.inSequence && (Client.field495 == 4 || !var0.field604 && (Client.field495 == 0 || Client.field495 == 3 || Client.field495 == 1 && class63.method1170(((Player)var0).name, false))))) {
            class156.method2898(var0, var0.field592);
            if(Client.field383 > -1 && Client.field371 < Client.field372) {
               Client.field376[Client.field371] = class16.field176.method3884(var0.overhead) / 2;
               Client.field519[Client.field371] = class16.field176.field3086;
               Client.field373[Client.field371] = Client.field383;
               Client.field374[Client.field371] = Client.field384;
               Client.field377[Client.field371] = var0.field607;
               Client.field378[Client.field371] = var0.field648;
               Client.field379[Client.field371] = var0.field606;
               Client.field380[Client.field371] = var0.overhead;
               ++Client.field371;
            }
         }

         for(int var81 = 0; var81 < 4; ++var81) {
            int var82 = var0.field612[var81];
            int var84 = var0.field610[var81];
            class196 var87 = null;
            int var83 = 0;
            if(var84 >= 0) {
               if(var82 <= Client.gameCycle) {
                  continue;
               }

               var87 = class151.method2847(var0.field610[var81]);
               var83 = var87.field2858;
               if(var87 != null && null != var87.field2870) {
                  var87 = var87.method3564();
                  if(var87 == null) {
                     var0.field612[var81] = -1;
                     continue;
                  }
               }
            } else if(var82 < 0) {
               continue;
            }

            var14 = var0.field613[var81];
            class196 var80 = null;
            if(var14 >= 0) {
               var80 = class151.method2847(var14);
               if(null != var80 && null != var80.field2870) {
                  var80 = var80.method3564();
               }
            }

            if(var82 - var83 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.field612[var81] = -1;
               } else {
                  class156.method2898(var0, var0.field592 / 2);
                  if(Client.field383 > -1) {
                     if(var81 == 1) {
                        Client.field384 -= 20;
                     }

                     if(var81 == 2) {
                        Client.field383 -= 15;
                        Client.field384 -= 10;
                     }

                     if(var81 == 3) {
                        Client.field383 += 15;
                        Client.field384 -= 10;
                     }

                     SpritePixels var78 = null;
                     SpritePixels var77 = null;
                     SpritePixels var79 = null;
                     SpritePixels var76 = null;
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
                     var78 = var87.method3585();
                     int var42;
                     if(null != var78) {
                        var21 = var78.width;
                        var42 = var78.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var78.offsetX;
                     }

                     var77 = var87.method3567();
                     if(null != var77) {
                        var22 = var77.width;
                        var42 = var77.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var77.offsetX;
                     }

                     var79 = var87.method3568();
                     if(var79 != null) {
                        var23 = var79.width;
                        var42 = var79.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var79.offsetX;
                     }

                     var76 = var87.method3569();
                     if(var76 != null) {
                        var24 = var76.width;
                        var42 = var76.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var76.offsetX;
                     }

                     if(var80 != null) {
                        var29 = var80.method3585();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var80.method3567();
                        if(null != var30) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var80.method3568();
                        if(null != var31) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var80.method3569();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var75 = var87.method3586();
                     if(null == var75) {
                        var75 = class41.field855;
                     }

                     Font var43;
                     if(var80 != null) {
                        var43 = var80.method3586();
                        if(var43 == null) {
                           var43 = class41.field855;
                        }
                     } else {
                        var43 = class41.field855;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method3565(var0.field611[var81]);
                     int var89 = var75.method3884(var44);
                     if(null != var80) {
                        var45 = var80.method3565(var0.field614[var81]);
                        var47 = var43.method3884(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var79 == null && var76 == null) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(var80 != null && var34 > 0) {
                        if(null == var31 && var32 == null) {
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
                     if(null != var80) {
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

                     var61 = var0.field612[var81] - Client.gameCycle;
                     int var62 = var87.field2863 - var87.field2863 * var61 / var87.field2858;
                     int var63 = var61 * var87.field2861 / var87.field2858 + -var87.field2861;
                     int var64 = Client.field383 + var2 - (var50 >> 1) + var62;
                     int var65 = var3 + Client.field384 - 12 + var63;
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var87.field2868 + 15 + var65;
                     int var69 = var68 - var75.field3093;
                     int var70 = var75.field3094 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(null != var80) {
                        var71 = 15 + var65 + var80.field2868;
                        var72 = var71 - var43.field3093;
                        var73 = var71 + var43.field3094;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field2865 >= 0) {
                        var72 = (var61 << 8) / (var87.field2858 - var87.field2865);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var78 != null) {
                           var78.method4120(var51 + var64 - var25, var65, var72);
                        }

                        if(var79 != null) {
                           var79.method4120(var52 + var64 - var27, var65, var72);
                        }

                        if(var77 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var77.method4120(var73 * var22 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(var76 != null) {
                           var76.method4120(var64 + var55 - var28, var65, var72);
                        }

                        var75.method3883(var44, var54 + var64, var68, var87.field2872, 0, var72);
                        if(var80 != null) {
                           if(null != var29) {
                              var29.method4120(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method4120(var57 + var64 - var39, var65, var72);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4120(var73 * var34 + (var64 + var58 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method4120(var59 + var64 - var40, var65, var72);
                           }

                           var43.method3883(var45, var64 + var60, var71, var80.field2872, 0, var72);
                        }
                     } else {
                        if(null != var78) {
                           var78.method4121(var64 + var51 - var25, var65);
                        }

                        if(var79 != null) {
                           var79.method4121(var52 + var64 - var27, var65);
                        }

                        if(var77 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var77.method4121(var53 + var64 - var26 + var73 * var22, var65);
                           }
                        }

                        if(var76 != null) {
                           var76.method4121(var55 + var64 - var28, var65);
                        }

                        var75.method3919(var44, var64 + var54, var68, var87.field2872 | -16777216, 0);
                        if(var80 != null) {
                           if(var29 != null) {
                              var29.method4121(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method4121(var57 + var64 - var39, var65);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4121(var58 + var64 - var38 + var34 * var73, var65);
                              }
                           }

                           if(null != var32) {
                              var32.method4121(var59 + var64 - var40, var65);
                           }

                           var43.method3919(var45, var60 + var64, var71, var80.field2872 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
