import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class1 {
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = -2051334239
   )
   static int field19;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = 538415837
   )
   static int field23;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "-1224986780"
   )
   static final void method5(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod767()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(null != var6.field897) {
               var6 = var6.method790();
            }

            if(null == var6) {
               return;
            }
         }

         int var75 = class34.field743;
         int[] var7 = class34.field739;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.field831.method3866()) {
            FrameMap.method2258(var0, var0.field851 + 15);

            for(class26 var9 = (class26)var0.field831.method3850(); null != var9; var9 = (class26)var0.field831.method3852()) {
               class20 var10 = var9.method594(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method595()) {
                     var9.unlink();
                  }
               } else {
                  class49 var11 = var9.field622;
                  SpritePixels var12 = var11.method971();
                  SpritePixels var13 = var11.method981();
                  int var15 = 0;
                  if(null != var12 && null != var13) {
                     if(var11.field1050 * 2 < var13.width) {
                        var15 = var11.field1050;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.field1059;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var76 = Client.gameCycle - var10.field556;
                  int var19 = var14 * var10.field555 / var11.field1059;
                  int var20;
                  int var88;
                  if(var10.field553 > var76) {
                     var20 = var11.field1055 == 0?0:var76 / var11.field1055 * var11.field1055;
                     var21 = var10.field554 * var14 / var11.field1059;
                     var88 = var21 + (var19 - var21) * var20 / var10.field553;
                  } else {
                     var88 = var19;
                     var20 = var11.field1056 + var10.field553 - var76;
                     if(var11.field1058 >= 0) {
                        var16 = (var20 << 8) / (var11.field1056 - var11.field1058);
                     }
                  }

                  if(var10.field555 > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.field375 - (var14 >> 1);
                  var21 = var3 + Client.field376 - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var14 == var88) {
                        var88 += 2 * var15;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method1705(var20, var21, var16);
                        class82.method1796(var20, var21, var88 + var20, var21 + var22);
                        var13.method1705(var20, var21, var16);
                     } else {
                        var12.method1712(var20, var21);
                        class82.method1796(var20, var21, var20 + var88, var22 + var21);
                        var13.method1712(var20, var21);
                     }

                     class82.method1795(var2, var3, var4 + var2, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.field375 > -1) {
                        class82.method1801(var20, var21, var88, 5, '\uff00');
                        class82.method1801(var88 + var20, var21, var14 - var88, 5, 16711680);
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
            Player var85 = (Player)var0;
            if(var85.field50) {
               return;
            }

            if(var85.field27 != -1 || var85.field28 != -1) {
               FrameMap.method2258(var0, var0.field851 + 15);
               if(Client.field375 > -1) {
                  if(var85.field27 != -1) {
                     class128.field2076[var85.field27].method1712(var2 + Client.field375 - 12, var3 + Client.field376 - var8);
                     var8 += 25;
                  }

                  if(var85.field28 != -1) {
                     ObjectComposition.field957[var85.field28].method1712(var2 + Client.field375 - 12, var3 + Client.field376 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field310 == 10 && var7[var1] == Client.field417) {
               FrameMap.method2258(var0, var0.field851 + 15);
               if(Client.field375 > -1) {
                  ChatMessages.field260[1].method1712(var2 + Client.field375 - 12, var3 + Client.field376 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(null != var86.field897) {
               var86 = var86.method790();
            }

            if(var86.field895 >= 0 && var86.field895 < ObjectComposition.field957.length) {
               FrameMap.method2258(var0, 15 + var0.field851);
               if(Client.field375 > -1) {
                  ObjectComposition.field957[var86.field895].method1712(var2 + Client.field375 - 12, var3 + Client.field376 - 30);
               }
            }

            if(Client.field310 == 1 && Client.field285 == Client.field307[var1 - var75] && Client.gameCycle % 20 < 10) {
               FrameMap.method2258(var0, var0.field851 + 15);
               if(Client.field375 > -1) {
                  ChatMessages.field260[0].method1712(Client.field375 + var2 - 12, Client.field376 + var3 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var75 || !var0.inSequence && (Client.field537 == 4 || !var0.field815 && (Client.field537 == 0 || Client.field537 == 3 || Client.field537 == 1 && ChatMessages.method222(((Player)var0).name, false))))) {
            FrameMap.method2258(var0, var0.field851);
            if(Client.field375 > -1 && Client.field363 < Client.field364) {
               Client.field368[Client.field363] = class117.field2001.method4027(var0.overhead) / 2;
               Client.field367[Client.field363] = class117.field2001.field3238;
               Client.field365[Client.field363] = Client.field375;
               Client.field366[Client.field363] = Client.field376;
               Client.field413[Client.field363] = var0.field818;
               Client.field370[Client.field363] = var0.field819;
               Client.field371[Client.field363] = var0.field817;
               Client.field351[Client.field363] = var0.overhead;
               ++Client.field363;
            }
         }

         for(int var79 = 0; var79 < 4; ++var79) {
            int var81 = var0.field823[var79];
            int var82 = var0.field838[var79];
            class51 var87 = null;
            int var80 = 0;
            if(var82 >= 0) {
               if(var81 <= Client.gameCycle) {
                  continue;
               }

               var87 = class9.method119(var0.field838[var79]);
               var80 = var87.field1084;
               if(var87 != null && var87.field1095 != null) {
                  var87 = var87.method1005();
                  if(null == var87) {
                     var0.field823[var79] = -1;
                     continue;
                  }
               }
            } else if(var81 < 0) {
               continue;
            }

            var14 = var0.field824[var79];
            class51 var78 = null;
            if(var14 >= 0) {
               var78 = class9.method119(var14);
               if(var78 != null && var78.field1095 != null) {
                  var78 = var78.method1005();
               }
            }

            if(var81 - var80 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.field823[var79] = -1;
               } else {
                  FrameMap.method2258(var0, var0.field851 / 2);
                  if(Client.field375 > -1) {
                     if(var79 == 1) {
                        Client.field376 -= 20;
                     }

                     if(var79 == 2) {
                        Client.field375 -= 15;
                        Client.field376 -= 10;
                     }

                     if(var79 == 3) {
                        Client.field375 += 15;
                        Client.field376 -= 10;
                     }

                     SpritePixels var84 = null;
                     SpritePixels var18 = null;
                     SpritePixels var83 = null;
                     SpritePixels var77 = null;
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
                     var84 = var87.method1007();
                     int var74;
                     if(null != var84) {
                        var21 = var84.width;
                        var74 = var84.height;
                        if(var74 > var41) {
                           var41 = var74;
                        }

                        var25 = var84.field1442;
                     }

                     var18 = var87.method1002();
                     if(var18 != null) {
                        var22 = var18.width;
                        var74 = var18.height;
                        if(var74 > var41) {
                           var41 = var74;
                        }

                        var26 = var18.field1442;
                     }

                     var83 = var87.method1009();
                     if(var83 != null) {
                        var23 = var83.width;
                        var74 = var83.height;
                        if(var74 > var41) {
                           var41 = var74;
                        }

                        var27 = var83.field1442;
                     }

                     var77 = var87.method1010();
                     if(null != var77) {
                        var24 = var77.width;
                        var74 = var77.height;
                        if(var74 > var41) {
                           var41 = var74;
                        }

                        var28 = var77.field1442;
                     }

                     if(var78 != null) {
                        var29 = var78.method1007();
                        if(null != var29) {
                           var33 = var29.width;
                           var74 = var29.height;
                           if(var74 > var41) {
                              var41 = var74;
                           }

                           var37 = var29.field1442;
                        }

                        var30 = var78.method1002();
                        if(null != var30) {
                           var34 = var30.width;
                           var74 = var30.height;
                           if(var74 > var41) {
                              var41 = var74;
                           }

                           var38 = var30.field1442;
                        }

                        var31 = var78.method1009();
                        if(null != var31) {
                           var35 = var31.width;
                           var74 = var31.height;
                           if(var74 > var41) {
                              var41 = var74;
                           }

                           var39 = var31.field1442;
                        }

                        var32 = var78.method1010();
                        if(var32 != null) {
                           var36 = var32.width;
                           var74 = var32.height;
                           if(var74 > var41) {
                              var41 = var74;
                           }

                           var40 = var32.field1442;
                        }
                     }

                     class227 var42 = var87.method1030();
                     if(var42 == null) {
                        var42 = class92.field1590;
                     }

                     class227 var43;
                     if(null != var78) {
                        var43 = var78.method1030();
                        if(var43 == null) {
                           var43 = class92.field1590;
                        }
                     } else {
                        var43 = class92.field1590;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method1006(var0.field833[var79]);
                     int var89 = var42.method4027(var44);
                     if(null != var78) {
                        var45 = var78.method1006(var0.field825[var79]);
                        var47 = var43.method4027(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(null == var83 && var77 == null) {
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
                     if(null != var78) {
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

                     var61 = var0.field823[var79] - Client.gameCycle;
                     int var62 = var87.field1089 - var87.field1089 * var61 / var87.field1084;
                     int var63 = var61 * var87.field1090 / var87.field1084 + -var87.field1090;
                     int var64 = var62 + (var2 + Client.field375 - (var50 >> 1));
                     int var65 = var63 + (var3 + Client.field376 - 12);
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var87.field1094 + 15 + var65;
                     int var69 = var68 - var42.field3248;
                     int var70 = var42.field3240 + var68;
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
                        var71 = 15 + var65 + var78.field1094;
                        var72 = var71 - var43.field3248;
                        var73 = var43.field3240 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field1082 >= 0) {
                        var72 = (var61 << 8) / (var87.field1084 - var87.field1082);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var84 != null) {
                           var84.method1705(var51 + var64 - var25, var65, var72);
                        }

                        if(null != var83) {
                           var83.method1705(var64 + var52 - var27, var65, var72);
                        }

                        if(var18 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method1705(var73 * var22 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(null != var77) {
                           var77.method1705(var55 + var64 - var28, var65, var72);
                        }

                        var42.method4085(var44, var64 + var54, var68, var87.field1077, 0, var72);
                        if(null != var78) {
                           if(null != var29) {
                              var29.method1705(var64 + var56 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method1705(var57 + var64 - var39, var65, var72);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1705(var34 * var73 + (var64 + var58 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method1705(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4085(var45, var60 + var64, var71, var78.field1077, 0, var72);
                        }
                     } else {
                        if(var84 != null) {
                           var84.method1712(var64 + var51 - var25, var65);
                        }

                        if(null != var83) {
                           var83.method1712(var52 + var64 - var27, var65);
                        }

                        if(var18 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method1712(var64 + var53 - var26 + var73 * var22, var65);
                           }
                        }

                        if(var77 != null) {
                           var77.method1712(var64 + var55 - var28, var65);
                        }

                        var42.method4032(var44, var64 + var54, var68, var87.field1077 | -16777216, 0);
                        if(null != var78) {
                           if(null != var29) {
                              var29.method1712(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method1712(var64 + var57 - var39, var65);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1712(var73 * var34 + (var58 + var64 - var38), var65);
                              }
                           }

                           if(null != var32) {
                              var32.method1712(var59 + var64 - var40, var65);
                           }

                           var43.method4032(var45, var64 + var60, var71, var78.field1077 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "1546057842"
   )
   static void method6(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2907 == 0) {
         var0.width = var0.field2805;
      } else if(var0.field2907 == 1) {
         var0.width = var1 - var0.field2805;
      } else if(var0.field2907 == 2) {
         var0.width = var1 * var0.field2805 >> 14;
      }

      if(var0.field2809 == 0) {
         var0.height = var0.field2791;
      } else if(var0.field2809 == 1) {
         var0.height = var2 - var0.field2791;
      } else if(var0.field2809 == 2) {
         var0.height = var2 * var0.field2791 >> 14;
      }

      if(var0.field2907 == 4) {
         var0.width = var0.height * var0.field2802 / var0.field2816;
      }

      if(var0.field2809 == 4) {
         var0.height = var0.field2816 * var0.width / var0.field2802;
      }

      if(Client.field438 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field440 = var0;
      }

      if(var3 && null != var0.field2918 && (var0.width != var4 || var5 != var0.height)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field5 = var0.field2918;
         Client.field467.method3801(var6);
      }

   }
}
