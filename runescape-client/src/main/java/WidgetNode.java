import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("kf")
   static class112 field176;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -177544571
   )
   @Export("id")
   int id;
   @ObfuscatedName("f")
   boolean field178 = false;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 828222755
   )
   int field180;
   @ObfuscatedName("d")
   static int[] field181;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = -1626777301
   )
   @Export("cameraX")
   static int cameraX;

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "850761223"
   )
   static final void method183(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod679()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(null != var6.field3028) {
               var6 = var6.method3635();
            }

            if(null == var6) {
               return;
            }
         }

         int var74 = class45.field908;
         int[] var7 = class45.field903;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method2328()) {
            class11.method151(var0, 15 + var0.field601);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method2326(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method2327()) {
               CombatInfo1 var10 = var9.method672(Client.gameCycle);
               if(null == var10) {
                  if(var9.method667()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method3471();
                  SpritePixels var13 = var11.method3470();
                  int var15 = 0;
                  if(null != var12 && var13 != null) {
                     if(var11.field2845 * 2 < var13.width) {
                        var15 = var11.field2845;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field661;
                  int var19 = var14 * var10.field666 / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field664 > var18) {
                     var20 = var11.field2830 == 0?0:var18 / var11.field2830 * var11.field2830;
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.field664 + var21;
                  } else {
                     var88 = var19;
                     var20 = var11.field2841 + var10.field664 - var18;
                     if(var11.field2838 >= 0) {
                        var16 = (var20 << 8) / (var11.field2841 - var11.field2838);
                     }
                  }

                  if(var10.field666 > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = Client.field387 + var2 - (var14 >> 1);
                  var21 = var3 + Client.field536 - var8;
                  if(null != var12 && null != var13) {
                     var20 -= var15;
                     if(var14 == var88) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method4038(var20, var21, var16);
                        class219.method3890(var20, var21, var20 + var88, var21 + var22);
                        var13.method4038(var20, var21, var16);
                     } else {
                        var12.method4032(var20, var21);
                        class219.method3890(var20, var21, var20 + var88, var22 + var21);
                        var13.method4032(var20, var21);
                     }

                     class219.method3889(var2, var3, var4 + var2, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field387 > -1) {
                        class219.method3910(var20, var21, var88, 5, '\uff00');
                        class219.method3910(var88 + var20, var21, var14 - var88, 5, 16711680);
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
            if(var85.field245) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               class11.method151(var0, 15 + var0.field601);
               if(Client.field387 > -1) {
                  if(var85.skullIcon != -1) {
                     Frames.field1563[var85.skullIcon].method4032(var2 + Client.field387 - 12, var3 + Client.field536 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     XClanMember.field273[var85.overheadIcon].method4032(Client.field387 + var2 - 12, Client.field536 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field489 == 10 && Client.field303 == var7[var1]) {
               class11.method151(var0, var0.field601 + 15);
               if(Client.field387 > -1) {
                  class9.field85[1].method4032(var2 + Client.field387 - 12, var3 + Client.field536 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.field3028 != null) {
               var86 = var86.method3635();
            }

            if(var86.field3027 >= 0 && var86.field3027 < XClanMember.field273.length) {
               class11.method151(var0, 15 + var0.field601);
               if(Client.field387 > -1) {
                  XClanMember.field273[var86.field3027].method4032(var2 + Client.field387 - 12, var3 + Client.field536 - 30);
               }
            }

            if(Client.field489 == 1 && Client.field302 == Client.field323[var1 - var74] && Client.gameCycle % 20 < 10) {
               class11.method151(var0, var0.field601 + 15);
               if(Client.field387 > -1) {
                  class9.field85[0].method4032(Client.field387 + var2 - 12, Client.field536 + var3 - 28);
               }
            }
         }

         if(null != var0.overhead && (var1 >= var74 || !var0.inSequence && (Client.field504 == 4 || !var0.field612 && (Client.field504 == 0 || Client.field504 == 3 || Client.field504 == 1 && class119.method2252(((Player)var0).name, false))))) {
            class11.method151(var0, var0.field601);
            if(Client.field387 > -1 && Client.field381 < Client.field452) {
               Client.field330[Client.field381] = class11.field119.method3774(var0.overhead) / 2;
               Client.field385[Client.field381] = class11.field119.field3097;
               Client.field383[Client.field381] = Client.field387;
               Client.field384[Client.field381] = Client.field536;
               Client.field334[Client.field381] = var0.field615;
               Client.field530[Client.field381] = var0.field616;
               Client.field299[Client.field381] = var0.field614;
               Client.field390[Client.field381] = var0.overhead;
               ++Client.field381;
            }
         }

         for(int var77 = 0; var77 < 4; ++var77) {
            int var80 = var0.field620[var77];
            int var81 = var0.field618[var77];
            class196 var87 = null;
            int var82 = 0;
            if(var81 >= 0) {
               if(var80 <= Client.gameCycle) {
                  continue;
               }

               var87 = class119.method2256(var0.field618[var77]);
               var82 = var87.field2875;
               if(null != var87 && var87.field2886 != null) {
                  var87 = var87.method3513();
                  if(var87 == null) {
                     var0.field620[var77] = -1;
                     continue;
                  }
               }
            } else if(var80 < 0) {
               continue;
            }

            var14 = var0.field621[var77];
            class196 var79 = null;
            if(var14 >= 0) {
               var79 = class119.method2256(var14);
               if(var79 != null && var79.field2886 != null) {
                  var79 = var79.method3513();
               }
            }

            if(var80 - var82 <= Client.gameCycle) {
               if(null == var87) {
                  var0.field620[var77] = -1;
               } else {
                  class11.method151(var0, var0.field601 / 2);
                  if(Client.field387 > -1) {
                     if(var77 == 1) {
                        Client.field536 -= 20;
                     }

                     if(var77 == 2) {
                        Client.field387 -= 15;
                        Client.field536 -= 10;
                     }

                     if(var77 == 3) {
                        Client.field387 += 15;
                        Client.field536 -= 10;
                     }

                     SpritePixels var84 = null;
                     SpritePixels var78 = null;
                     SpritePixels var75 = null;
                     SpritePixels var83 = null;
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
                     var84 = var87.method3534();
                     int var76;
                     if(null != var84) {
                        var21 = var84.width;
                        var76 = var84.height;
                        if(var76 > var41) {
                           var41 = var76;
                        }

                        var25 = var84.field3207;
                     }

                     var78 = var87.method3514();
                     if(null != var78) {
                        var22 = var78.width;
                        var76 = var78.height;
                        if(var76 > var41) {
                           var41 = var76;
                        }

                        var26 = var78.field3207;
                     }

                     var75 = var87.method3515();
                     if(var75 != null) {
                        var23 = var75.width;
                        var76 = var75.height;
                        if(var76 > var41) {
                           var41 = var76;
                        }

                        var27 = var75.field3207;
                     }

                     var83 = var87.method3533();
                     if(var83 != null) {
                        var24 = var83.width;
                        var76 = var83.height;
                        if(var76 > var41) {
                           var41 = var76;
                        }

                        var28 = var83.field3207;
                     }

                     if(null != var79) {
                        var29 = var79.method3534();
                        if(var29 != null) {
                           var33 = var29.width;
                           var76 = var29.height;
                           if(var76 > var41) {
                              var41 = var76;
                           }

                           var37 = var29.field3207;
                        }

                        var30 = var79.method3514();
                        if(var30 != null) {
                           var34 = var30.width;
                           var76 = var30.height;
                           if(var76 > var41) {
                              var41 = var76;
                           }

                           var38 = var30.field3207;
                        }

                        var31 = var79.method3515();
                        if(null != var31) {
                           var35 = var31.width;
                           var76 = var31.height;
                           if(var76 > var41) {
                              var41 = var76;
                           }

                           var39 = var31.field3207;
                        }

                        var32 = var79.method3533();
                        if(var32 != null) {
                           var36 = var32.width;
                           var76 = var32.height;
                           if(var76 > var41) {
                              var41 = var76;
                           }

                           var40 = var32.field3207;
                        }
                     }

                     class208 var42 = var87.method3517();
                     if(var42 == null) {
                        var42 = RSCanvas.field1753;
                     }

                     class208 var43;
                     if(var79 != null) {
                        var43 = var79.method3517();
                        if(null == var43) {
                           var43 = RSCanvas.field1753;
                        }
                     } else {
                        var43 = RSCanvas.field1753;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method3512(var0.field619[var77]);
                     int var89 = var42.method3774(var44);
                     if(var79 != null) {
                        var45 = var79.method3512(var0.field644[var77]);
                        var47 = var43.method3774(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(null == var75 && null == var83) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(var79 != null && var34 > 0) {
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
                     if(var79 != null) {
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

                     var61 = var0.field620[var77] - Client.gameCycle;
                     int var62 = var87.field2880 - var61 * var87.field2880 / var87.field2875;
                     int var63 = -var87.field2881 + var61 * var87.field2881 / var87.field2875;
                     int var64 = var62 + (Client.field387 + var2 - (var50 >> 1));
                     int var65 = var63 + (var3 + Client.field536 - 12);
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var87.field2885 + 15 + var65;
                     int var69 = var68 - var42.field3098;
                     int var70 = var42.field3099 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(null != var79) {
                        var71 = var79.field2885 + 15 + var65;
                        var72 = var71 - var43.field3098;
                        var73 = var43.field3099 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field2871 >= 0) {
                        var72 = (var61 << 8) / (var87.field2875 - var87.field2871);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(null != var84) {
                           var84.method4038(var51 + var64 - var25, var65, var72);
                        }

                        if(var75 != null) {
                           var75.method4038(var64 + var52 - var27, var65, var72);
                        }

                        if(var78 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var78.method4038(var53 + var64 - var26 + var22 * var73, var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.method4038(var64 + var55 - var28, var65, var72);
                        }

                        var42.method3838(var44, var64 + var54, var68, var87.field2884, 0, var72);
                        if(null != var79) {
                           if(var29 != null) {
                              var29.method4038(var64 + var56 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method4038(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4038(var58 + var64 - var38 + var73 * var34, var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method4038(var59 + var64 - var40, var65, var72);
                           }

                           var43.method3838(var45, var64 + var60, var71, var79.field2884, 0, var72);
                        }
                     } else {
                        if(var84 != null) {
                           var84.method4032(var51 + var64 - var25, var65);
                        }

                        if(var75 != null) {
                           var75.method4032(var64 + var52 - var27, var65);
                        }

                        if(var78 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var78.method4032(var53 + var64 - var26 + var22 * var73, var65);
                           }
                        }

                        if(null != var83) {
                           var83.method4032(var55 + var64 - var28, var65);
                        }

                        var42.method3779(var44, var64 + var54, var68, var87.field2884 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method4032(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method4032(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4032(var58 + var64 - var38 + var34 * var73, var65);
                              }
                           }

                           if(null != var32) {
                              var32.method4032(var64 + var59 - var40, var65);
                           }

                           var43.method3779(var45, var60 + var64, var71, var79.field2884 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIIS)V",
      garbageValue = "12805"
   )
   static final void method184(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -class170.method3172(var4 + var2 + 932731, var3 + 556238 + var5) * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = 8 * -var8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class11.field117[var1][var2][var3] = var0.readByte();
               class10.field91[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class65.field1110[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               NPC.field763[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-84538494"
   )
   static final int method185(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2932(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2748(var3.nextInt());
      }

      var4.method2748(var6[0]);
      var4.method2748(var6[1]);
      var4.method2919(var0);
      var4.method2919(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2748(var3.nextInt());
      }

      var4.method2780(class36.field769, class36.field765);
      var5.method2932(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2748(var3.nextInt());
      }

      var5.method2919(var3.nextLong());
      var5.method2749(var3.nextLong());
      class3.method33(var5);
      var5.method2919(var3.nextLong());
      var5.method2780(class36.field769, class36.field765);
      var7 = class57.method1067(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.method2757(var2);
      var8.offset = var7;
      var8.method2822(var6);
      Buffer var9 = new Buffer(var4.offset + 5 + var5.offset + var8.offset);
      var9.method2932(2);
      var9.method2932(var4.offset);
      var9.method2753(var4.payload, 0, var4.offset);
      var9.method2932(var5.offset);
      var9.method2753(var5.payload, 0, var5.offset);
      var9.method2746(var8.offset);
      var9.method2753(var8.payload, 0, var8.offset);
      byte[] var11 = var9.payload;
      int var13 = var11.length;
      StringBuilder var14 = new StringBuilder();

      int var17;
      for(int var15 = 0; var15 < var13 + 0; var15 += 3) {
         int var16 = var11[var15] & 255;
         var14.append(class206.field3084[var16 >>> 2]);
         if(var15 < var13 - 1) {
            var17 = var11[1 + var15] & 255;
            var14.append(class206.field3084[(var16 & 3) << 4 | var17 >>> 4]);
            if(var15 < var13 - 2) {
               int var18 = var11[2 + var15] & 255;
               var14.append(class206.field3084[(var17 & 15) << 2 | var18 >>> 6]).append(class206.field3084[var18 & 63]);
            } else {
               var14.append(class206.field3084[(var17 & 15) << 2]).append("=");
            }
         } else {
            var14.append(class206.field3084[(var16 & 3) << 4]).append("==");
         }
      }

      String var12 = var14.toString();
      var12 = var12;

      try {
         URL var19 = new URL(class6.method85("services", false) + "m=accountappeal/login.ws");
         URLConnection var26 = var19.openConnection();
         var26.setDoInput(true);
         var26.setDoOutput(true);
         var26.setConnectTimeout(5000);
         OutputStreamWriter var20 = new OutputStreamWriter(var26.getOutputStream());
         var20.write("data2=" + class225.method4146(var12) + "&dest=" + class225.method4146("passwordchoice.ws"));
         var20.flush();
         InputStream var21 = var26.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            var17 = var21.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var17 == -1) {
               var20.close();
               var21.close();
               String var22 = new String(var9.payload);
               if(var22.startsWith("OFFLINE")) {
                  return 4;
               } else if(var22.startsWith("WRONG")) {
                  return 7;
               } else if(var22.startsWith("RELOAD")) {
                  return 3;
               } else if(var22.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.method2837(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var22 = new String(var9.payload, 0, var9.offset);
                  if(!class20.method194(var22)) {
                     return 5;
                  } else {
                     if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                        try {
                           Desktop.getDesktop().browse(new URI(var22));
                           return 2;
                        } catch (Exception var24) {
                           ;
                        }
                     }

                     if(class114.field1784.startsWith("win")) {
                        GroundObject.method1528(var22, 0);
                     } else if(class114.field1784.startsWith("mac")) {
                        NPC.method689(var22, 1, "openjs");
                     } else {
                        GroundObject.method1528(var22, 2);
                     }

                     return 2;
                  }
               }
            }

            var9.offset += var17;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var25) {
         var25.printStackTrace();
         return 5;
      }
   }
}
