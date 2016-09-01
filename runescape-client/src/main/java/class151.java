import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class151 extends RuntimeException {
   @ObfuscatedName("r")
   public static String field2277;
   @ObfuscatedName("z")
   String field2278;
   @ObfuscatedName("i")
   Throwable field2279;
   @ObfuscatedName("x")
   static Applet field2280;

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1557113299"
   )
   static final void method3177(boolean var0) {
      for(int var1 = 0; var1 < Client.field319; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field320[var1]];
         int var3 = 536870912 + (Client.field320[var1] << 14);
         if(var2 != null && var2.vmethod750() && var0 == var2.composition.isVisible && var2.composition.method780()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field821 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field386 == Client.field385[var4][var5]) {
                     continue;
                  }

                  Client.field385[var4][var5] = Client.field386;
               }

               if(!var2.composition.field917) {
                  var3 -= Integer.MIN_VALUE;
               }

               Projectile.region.method2110(FrameMap.plane, var2.x, var2.y, KitDefinition.method936(var2.field821 * 64 - 64 + var2.x, var2.field821 * 64 - 64 + var2.y, FrameMap.plane), 60 + (var2.field821 * 64 - 64), var2, var2.angle, var3, var2.field820);
            }
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "-1396709915"
   )
   static final void method3180(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod750()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.field914 != null) {
               var6 = var6.method779();
            }

            if(var6 == null) {
               return;
            }
         }

         int var81 = class34.field760;
         int[] var7 = class34.field755;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.field818.method3889()) {
            ItemComposition.method1163(var0, 15 + var0.field867);

            for(class26 var75 = (class26)var0.field818.method3897(); var75 != null; var75 = (class26)var0.field818.method3882()) {
               class20 var10 = var75.method587(Client.gameCycle);
               if(var10 == null) {
                  if(var75.method583()) {
                     var75.unlink();
                  }
               } else {
                  class49 var11 = var75.field634;
                  SpritePixels var12 = var11.method995();
                  SpritePixels var13 = var11.method1010();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field1084 * 2 < var13.width) {
                        var15 = var11.field1084;
                     }

                     var14 = var13.width - 2 * var15;
                  } else {
                     var14 = var11.field1083;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field573;
                  int var19 = var14 * var10.field565 / var11.field1083;
                  int var20;
                  int var86;
                  if(var10.field568 > var18) {
                     var20 = var11.field1079 == 0?0:var18 / var11.field1079 * var11.field1079;
                     var21 = var10.field570 * var14 / var11.field1083;
                     var86 = (var19 - var21) * var20 / var10.field568 + var21;
                  } else {
                     var86 = var19;
                     var20 = var10.field568 + var11.field1080 - var18;
                     if(var11.field1073 >= 0) {
                        var16 = (var20 << 8) / (var11.field1080 - var11.field1073);
                     }
                  }

                  if(var10.field565 > 0 && var86 < 1) {
                     var86 = 1;
                  }

                  var20 = var2 + Client.field387 - (var14 >> 1);
                  var21 = var3 + Client.field388 - var8;
                  if(null != var12 && var13 != null) {
                     var20 -= var15;
                     if(var86 == var14) {
                        var86 += 2 * var15;
                     } else {
                        var86 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method1730(var20, var21, var16);
                        class82.method1826(var20, var21, var20 + var86, var22 + var21);
                        var13.method1730(var20, var21, var16);
                     } else {
                        var12.method1740(var20, var21);
                        class82.method1826(var20, var21, var86 + var20, var21 + var22);
                        var13.method1740(var20, var21);
                     }

                     class82.method1825(var2, var3, var4 + var2, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.field387 > -1) {
                        class82.method1831(var20, var21, var86, 5, '\uff00');
                        class82.method1831(var86 + var20, var21, var14 - var86, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var81) {
            Player var88 = (Player)var0;
            if(var88.field29) {
               return;
            }

            if(var88.field28 != -1 || var88.field41 != -1) {
               ItemComposition.method1163(var0, 15 + var0.field867);
               if(Client.field387 > -1) {
                  if(var88.field28 != -1) {
                     class8.field135[var88.field28].method1740(Client.field387 + var2 - 12, var3 + Client.field388 - var8);
                     var8 += 25;
                  }

                  if(var88.field41 != -1) {
                     ChatLineBuffer.field686[var88.field41].method1740(var2 + Client.field387 - 12, var3 + Client.field388 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field525 == 10 && Client.field300 == var7[var1]) {
               ItemComposition.method1163(var0, var0.field867 + 15);
               if(Client.field387 > -1) {
                  class145.field2232[1].method1740(var2 + Client.field387 - 12, var3 + Client.field388 - var8);
               }
            }
         } else {
            NPCComposition var89 = ((NPC)var0).composition;
            if(null != var89.field914) {
               var89 = var89.method779();
            }

            if(var89.field895 >= 0 && var89.field895 < ChatLineBuffer.field686.length) {
               ItemComposition.method1163(var0, var0.field867 + 15);
               if(Client.field387 > -1) {
                  ChatLineBuffer.field686[var89.field895].method1740(var2 + Client.field387 - 12, Client.field388 + var3 - 30);
               }
            }

            if(Client.field525 == 1 && Client.field299 == Client.field320[var1 - var81] && Client.gameCycle % 20 < 10) {
               ItemComposition.method1163(var0, 15 + var0.field867);
               if(Client.field387 > -1) {
                  class145.field2232[0].method1740(Client.field387 + var2 - 12, var3 + Client.field388 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var81 || !var0.inSequence && (Client.field442 == 4 || !var0.field828 && (Client.field442 == 0 || Client.field442 == 3 || Client.field442 == 1 && class109.method2436(((Player)var0).name, false))))) {
            ItemComposition.method1163(var0, var0.field867);
            if(Client.field387 > -1 && Client.field375 < Client.field362) {
               Client.field356[Client.field375] = VertexNormal.field1680.method4099(var0.overhead) / 2;
               Client.field379[Client.field375] = VertexNormal.field1680.field3240;
               Client.field475[Client.field375] = Client.field387;
               Client.field378[Client.field375] = Client.field388;
               Client.field559[Client.field375] = var0.field834;
               Client.field382[Client.field375] = var0.field862;
               Client.field383[Client.field375] = var0.field838;
               Client.field384[Client.field375] = var0.overhead;
               ++Client.field375;
            }
         }

         for(int var9 = 0; var9 < 4; ++var9) {
            int var79 = var0.field876[var9];
            int var82 = var0.field837[var9];
            class51 var85 = null;
            int var83 = 0;
            if(var82 >= 0) {
               if(var79 <= Client.gameCycle) {
                  continue;
               }

               var85 = class47.method952(var0.field837[var9]);
               var83 = var85.field1106;
            } else if(var79 < 0) {
               continue;
            }

            var14 = var0.field840[var9];
            class51 var76 = null;
            if(var14 >= 0) {
               var76 = class47.method952(var14);
            }

            if(var79 - var83 <= Client.gameCycle) {
               if(null == var85) {
                  var0.field876[var9] = -1;
               } else {
                  ItemComposition.method1163(var0, var0.field867 / 2);
                  if(Client.field387 > -1) {
                     if(var9 == 1) {
                        Client.field388 -= 20;
                     }

                     if(var9 == 2) {
                        Client.field387 -= 15;
                        Client.field388 -= 10;
                     }

                     if(var9 == 3) {
                        Client.field387 += 15;
                        Client.field388 -= 10;
                     }

                     SpritePixels var77 = null;
                     SpritePixels var84 = null;
                     SpritePixels var80 = null;
                     SpritePixels var78 = null;
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
                     var77 = var85.method1035();
                     int var74;
                     if(null != var77) {
                        var21 = var77.width;
                        var74 = var77.height;
                        if(var74 > var41) {
                           var41 = var74;
                        }

                        var25 = var77.field1439;
                     }

                     var84 = var85.method1028();
                     if(var84 != null) {
                        var22 = var84.width;
                        var74 = var84.height;
                        if(var74 > var41) {
                           var41 = var74;
                        }

                        var26 = var84.field1439;
                     }

                     var80 = var85.method1033();
                     if(null != var80) {
                        var23 = var80.width;
                        var74 = var80.height;
                        if(var74 > var41) {
                           var41 = var74;
                        }

                        var27 = var80.field1439;
                     }

                     var78 = var85.method1045();
                     if(null != var78) {
                        var24 = var78.width;
                        var74 = var78.height;
                        if(var74 > var41) {
                           var41 = var74;
                        }

                        var28 = var78.field1439;
                     }

                     if(null != var76) {
                        var29 = var76.method1035();
                        if(null != var29) {
                           var33 = var29.width;
                           var74 = var29.height;
                           if(var74 > var41) {
                              var41 = var74;
                           }

                           var37 = var29.field1439;
                        }

                        var30 = var76.method1028();
                        if(null != var30) {
                           var34 = var30.width;
                           var74 = var30.height;
                           if(var74 > var41) {
                              var41 = var74;
                           }

                           var38 = var30.field1439;
                        }

                        var31 = var76.method1033();
                        if(null != var31) {
                           var35 = var31.width;
                           var74 = var31.height;
                           if(var74 > var41) {
                              var41 = var74;
                           }

                           var39 = var31.field1439;
                        }

                        var32 = var76.method1045();
                        if(null != var32) {
                           var36 = var32.width;
                           var74 = var32.height;
                           if(var74 > var41) {
                              var41 = var74;
                           }

                           var40 = var32.field1439;
                        }
                     }

                     class227 var42 = var85.method1050();
                     if(var42 == null) {
                        var42 = XItemContainer.field225;
                     }

                     class227 var43;
                     if(null != var76) {
                        var43 = var76.method1050();
                        if(null == var43) {
                           var43 = XItemContainer.field225;
                        }
                     } else {
                        var43 = XItemContainer.field225;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var85.method1051(var0.field833[var9]);
                     int var87 = var42.method4099(var44);
                     if(var76 != null) {
                        var45 = var76.method1051(var0.field841[var9]);
                        var47 = var43.method4099(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(null == var80 && null == var78) {
                           var48 = 1;
                        } else {
                           var48 = var87 / var22 + 1;
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

                     var61 = var0.field876[var9] - Client.gameCycle;
                     int var62 = var85.field1105 - var61 * var85.field1105 / var85.field1106;
                     int var63 = var85.field1116 * var61 / var85.field1106 + -var85.field1116;
                     int var64 = Client.field387 + var2 - (var50 >> 1) + var62;
                     int var65 = var3 + Client.field388 - 12 + var63;
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var85.field1115 + 15 + var65;
                     int var69 = var68 - var42.field3234;
                     int var70 = var68 + var42.field3242;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(null != var76) {
                        var71 = var76.field1115 + var65 + 15;
                        var72 = var71 - var43.field3234;
                        var73 = var71 + var43.field3242;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var85.field1112 >= 0) {
                        var72 = (var61 << 8) / (var85.field1106 - var85.field1112);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(null != var77) {
                           var77.method1730(var64 + var51 - var25, var65, var72);
                        }

                        if(var80 != null) {
                           var80.method1730(var64 + var52 - var27, var65, var72);
                        }

                        if(null != var84) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var84.method1730(var64 + var53 - var26 + var22 * var73, var65, var72);
                           }
                        }

                        if(var78 != null) {
                           var78.method1730(var55 + var64 - var28, var65, var72);
                        }

                        var42.method4044(var44, var54 + var64, var68, var85.field1095, 0, var72);
                        if(null != var76) {
                           if(var29 != null) {
                              var29.method1730(var56 + var64 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method1730(var64 + var57 - var39, var65, var72);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1730(var64 + var58 - var38 + var34 * var73, var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method1730(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4044(var45, var64 + var60, var71, var76.field1095, 0, var72);
                        }
                     } else {
                        if(var77 != null) {
                           var77.method1740(var51 + var64 - var25, var65);
                        }

                        if(null != var80) {
                           var80.method1740(var64 + var52 - var27, var65);
                        }

                        if(var84 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var84.method1740(var73 * var22 + (var53 + var64 - var26), var65);
                           }
                        }

                        if(null != var78) {
                           var78.method1740(var64 + var55 - var28, var65);
                        }

                        var42.method4079(var44, var54 + var64, var68, var85.field1095 | -16777216, 0);
                        if(null != var76) {
                           if(null != var29) {
                              var29.method1740(var64 + var56 - var37, var65);
                           }

                           if(null != var31) {
                              var31.method1740(var57 + var64 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1740(var34 * var73 + (var58 + var64 - var38), var65);
                              }
                           }

                           if(null != var32) {
                              var32.method1740(var59 + var64 - var40, var65);
                           }

                           var43.method4079(var45, var60 + var64, var71, var76.field1095 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
