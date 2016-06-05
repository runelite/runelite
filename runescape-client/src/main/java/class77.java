import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("BufferProvider")
public abstract class class77 {
   @ObfuscatedName("r")
   @Export("image")
   public Image field1395;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1648504875
   )
   @Export("height")
   int field1396;
   @ObfuscatedName("pm")
   public static class136 field1400;
   @ObfuscatedName("g")
   @Export("pixels")
   public int[] field1401;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -220742809
   )
   @Export("width")
   public int field1402;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "0"
   )
   public abstract void vmethod1829(Graphics var1, int var2, int var3);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1610060208"
   )
   public abstract void vmethod1830(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-789686150"
   )
   abstract void vmethod1838(int var1, int var2, Component var3);

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "286107883"
   )
   static final boolean method1653(class173 var0) {
      if(var0.field2889 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2889.length; ++var1) {
            int var2 = method1659(var0, var1);
            int var3 = var0.field2890[var1];
            if(var0.field2889[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2889[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2889[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "190"
   )
   static final void method1656() {
      class24.method572(false);
      client.field338 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class115.field1980.length; ++var1) {
         if(class98.field1684[var1] != -1 && null == class115.field1980[var1]) {
            class115.field1980[var1] = class19.field272.method3221(class98.field1684[var1], 0);
            if(null == class115.field1980[var1]) {
               var0 = false;
               ++client.field338;
            }
         }

         if(client.field343[var1] != -1 && null == class22.field587[var1]) {
            class22.field587[var1] = class19.field272.method3222(client.field343[var1], 0, class32.field746[var1]);
            if(class22.field587[var1] == null) {
               var0 = false;
               ++client.field338;
            }
         }
      }

      if(!var0) {
         client.field403 = 1;
      } else {
         client.field340 = 0;
         var0 = true;

         int var3;
         int var4;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         class119 var49;
         for(var1 = 0; var1 < class115.field1980.length; ++var1) {
            byte[] var2 = class22.field587[var1];
            if(var2 != null) {
               var3 = (class165.field2691[var1] >> 8) * 64 - class89.field1565;
               var4 = (class165.field2691[var1] & 255) * 64 - client.field358;
               if(client.field345) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               var49 = new class119(var2);
               var9 = -1;

               label1604:
               while(true) {
                  var10 = var49.method2481();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var49.method2481();
                        if(var13 == 0) {
                           continue label1604;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var49.method2494() >> 2;
                        var17 = var3 + var15;
                        var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           class40 var51 = class49.method980(var9);
                           if(var16 != 22 || !client.field287 || var51.field924 != 0 || var51.field931 == 1 || var51.field952) {
                              if(!var51.method793()) {
                                 ++client.field340;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var49.method2481();
                     if(var13 == 0) {
                        break;
                     }

                     var49.method2494();
                  }
               }
            }
         }

         if(!var0) {
            client.field403 = 2;
         } else {
            if(client.field403 != 0) {
               class76.method1632("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class135.method2845();
            class18.method174();
            class135.method2845();
            class214.field3161.method1870();
            class135.method2845();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               client.field344[var1].method2352();
            }

            int var50;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var50 = 0; var50 < 104; ++var50) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class5.field83[var1][var50][var3] = 0;
                  }
               }
            }

            class135.method2845();
            class5.field84 = 99;
            class161.field2672 = new byte[4][104][104];
            class5.field87 = new byte[4][104][104];
            class5.field86 = new byte[4][104][104];
            class47.field1081 = new byte[4][104][104];
            class102.field1774 = new int[4][105][105];
            class5.field92 = new byte[4][105][105];
            class5.field88 = new int[105][105];
            class47.field1075 = new int[104];
            class76.field1391 = new int[104];
            class114.field1974 = new int[104];
            class18.field250 = new int[104];
            class5.field89 = new int[104];
            var1 = class115.field1980.length;
            class24.method577();
            class24.method572(true);
            int var5;
            int var19;
            int var20;
            int var21;
            int var70;
            if(!client.field345) {
               byte[] var56;
               for(var50 = 0; var50 < var1; ++var50) {
                  var3 = 64 * (class165.field2691[var50] >> 8) - class89.field1565;
                  var4 = 64 * (class165.field2691[var50] & 255) - client.field358;
                  var56 = class115.field1980[var50];
                  if(var56 != null) {
                     class135.method2845();
                     class17.method171(var56, var3, var4, class40.field964 * 8 - 48, class31.field732 * 8 - 48, client.field344);
                  }
               }

               for(var50 = 0; var50 < var1; ++var50) {
                  var3 = 64 * (class165.field2691[var50] >> 8) - class89.field1565;
                  var4 = (class165.field2691[var50] & 255) * 64 - client.field358;
                  var56 = class115.field1980[var50];
                  if(null == var56 && class31.field732 < 800) {
                     class135.method2845();
                     class113.method2403(var3, var4, 64, 64);
                  }
               }

               class24.method572(true);

               for(var50 = 0; var50 < var1; ++var50) {
                  byte[] var57 = class22.field587[var50];
                  if(var57 != null) {
                     var4 = (class165.field2691[var50] >> 8) * 64 - class89.field1565;
                     var5 = (class165.field2691[var50] & 255) * 64 - client.field358;
                     class135.method2845();
                     class86 var58 = class214.field3161;
                     class108[] var59 = client.field344;
                     var49 = new class119(var57);
                     var9 = -1;

                     while(true) {
                        var10 = var49.method2481();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var70 = var49.method2481();
                           if(var70 == 0) {
                              break;
                           }

                           var11 += var70 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var49.method2494();
                           var17 = var16 >> 2;
                           var18 = var16 & 3;
                           var19 = var4 + var14;
                           var20 = var5 + var13;
                           if(var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
                              var21 = var15;
                              if((class5.field83[1][var19][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              class108 var60 = null;
                              if(var21 >= 0) {
                                 var60 = var59[var21];
                              }

                              class125.method2764(var15, var19, var20, var9, var18, var17, var58, var60);
                           }
                        }
                     }
                  }
               }
            }

            int var6;
            int var8;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var38;
            int var40;
            int var41;
            int var42;
            int var43;
            int var44;
            int var45;
            int var69;
            if(client.field345) {
               class108[] var54;
               class119 var74;
               for(var50 = 0; var50 < 4; ++var50) {
                  class135.method2845();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var68 = false;
                        var6 = client.field346[var50][var3][var4];
                        if(var6 != -1) {
                           var69 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var70 = 0; var70 < class165.field2691.length; ++var70) {
                              if(var11 == class165.field2691[var70] && null != class115.field1980[var70]) {
                                 byte[] var61 = class115.field1980[var70];
                                 var14 = 8 * var3;
                                 var15 = 8 * var4;
                                 var16 = (var9 & 7) * 8;
                                 var17 = (var10 & 7) * 8;
                                 var54 = client.field344;

                                 for(var19 = 0; var19 < 8; ++var19) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var19 + var14 > 0 && var19 + var14 < 103 && var20 + var15 > 0 && var20 + var15 < 103) {
                                          var54[var50].field1906[var19 + var14][var15 + var20] &= -16777217;
                                       }
                                    }
                                 }

                                 var74 = new class119(var61);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(var22 = 0; var22 < 64; ++var22) {
                                          if(var69 == var20 && var21 >= var16 && var21 < 8 + var16 && var22 >= var17 && var22 < 8 + var17) {
                                             class102.method2238(var74, var50, var14 + class133.method2830(var21 & 7, var22 & 7, var8), var15 + class174.method3412(var21 & 7, var22 & 7, var8), 0, 0, var8);
                                          } else {
                                             class102.method2238(var74, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var68 = true;
                                 break;
                              }
                           }
                        }

                        if(!var68) {
                           var69 = var50;
                           var8 = 8 * var3;
                           var9 = 8 * var4;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class5.field100[var69][var10 + var8][var9 + var11] = 0;
                              }
                           }

                           if(var8 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class5.field100[var69][var8][var10 + var9] = class5.field100[var69][var8 - 1][var9 + var10];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class5.field100[var69][var8 + var10][var9] = class5.field100[var69][var8 + var10][var9 - 1];
                              }
                           }

                           if(var8 > 0 && class5.field100[var69][var8 - 1][var9] != 0) {
                              class5.field100[var69][var8][var9] = class5.field100[var69][var8 - 1][var9];
                           } else if(var9 > 0 && class5.field100[var69][var8][var9 - 1] != 0) {
                              class5.field100[var69][var8][var9] = class5.field100[var69][var8][var9 - 1];
                           } else if(var8 > 0 && var9 > 0 && class5.field100[var69][var8 - 1][var9 - 1] != 0) {
                              class5.field100[var69][var8][var9] = class5.field100[var69][var8 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var50 = 0; var50 < 13; ++var50) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = client.field346[0][var50][var3];
                     if(var4 == -1) {
                        class113.method2403(8 * var50, var3 * 8, 8, 8);
                     }
                  }
               }

               class24.method572(true);

               for(var50 = 0; var50 < 4; ++var50) {
                  class135.method2845();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1398:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = client.field346[var50][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var69 = var5 >> 1 & 3;
                           var8 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = var9 / 8 + (var8 / 8 << 8);

                           for(var11 = 0; var11 < class165.field2691.length; ++var11) {
                              if(var10 == class165.field2691[var11] && null != class22.field587[var11]) {
                                 byte[] var52 = class22.field587[var11];
                                 var13 = var3 * 8;
                                 var14 = 8 * var4;
                                 var15 = (var8 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 class86 var63 = class214.field3161;
                                 var54 = client.field344;
                                 var74 = new class119(var52);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var74.method2481();
                                    if(var21 == 0) {
                                       continue label1398;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       var23 = var74.method2481();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       var24 = var22 & 63;
                                       var25 = var22 >> 6 & 63;
                                       var26 = var22 >> 12;
                                       var27 = var74.method2494();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var26 == var6 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < 8 + var16) {
                                          class40 var65 = class49.method980(var20);
                                          var33 = var25 & 7;
                                          var34 = var24 & 7;
                                          var36 = var65.field954;
                                          int var66 = var65.field923;
                                          if((var29 & 1) == 1) {
                                             var38 = var36;
                                             var36 = var66;
                                             var66 = var38;
                                          }

                                          var35 = var69 & 3;
                                          if(var35 == 0) {
                                             var32 = var33;
                                          } else if(var35 == 1) {
                                             var32 = var34;
                                          } else if(var35 == 2) {
                                             var32 = 7 - var33 - (var36 - 1);
                                          } else {
                                             var32 = 7 - var34 - (var66 - 1);
                                          }

                                          var38 = var32 + var13;
                                          var41 = var25 & 7;
                                          var42 = var24 & 7;
                                          var44 = var65.field954;
                                          var45 = var65.field923;
                                          int var46;
                                          if((var29 & 1) == 1) {
                                             var46 = var44;
                                             var44 = var45;
                                             var45 = var46;
                                          }

                                          var43 = var69 & 3;
                                          if(var43 == 0) {
                                             var40 = var42;
                                          } else if(var43 == 1) {
                                             var40 = 7 - var41 - (var44 - 1);
                                          } else if(var43 == 2) {
                                             var40 = 7 - var42 - (var45 - 1);
                                          } else {
                                             var40 = var41;
                                          }

                                          var46 = var40 + var14;
                                          if(var38 > 0 && var46 > 0 && var38 < 103 && var46 < 103) {
                                             int var47 = var50;
                                             if((class5.field83[1][var38][var46] & 2) == 2) {
                                                var47 = var50 - 1;
                                             }

                                             class108 var48 = null;
                                             if(var47 >= 0) {
                                                var48 = var54[var47];
                                             }

                                             class125.method2764(var50, var38, var46, var20, var69 + var29 & 3, var28, var63, var48);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class24.method572(true);
            class18.method174();
            class135.method2845();
            class86 var67 = class214.field3161;
            class108[] var77 = client.field344;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class5.field83[var4][var5][var6] & 1) == 1) {
                        var69 = var4;
                        if((class5.field83[1][var5][var6] & 2) == 2) {
                           var69 = var4 - 1;
                        }

                        if(var69 >= 0) {
                           var77[var69].method2357(var5, var6);
                        }
                     }
                  }
               }
            }

            class5.field96 += (int)(Math.random() * 5.0D) - 2;
            if(class5.field96 < -8) {
               class5.field96 = -8;
            }

            if(class5.field96 > 8) {
               class5.field96 = 8;
            }

            class5.field97 += (int)(Math.random() * 5.0D) - 2;
            if(class5.field97 < -16) {
               class5.field97 = -16;
            }

            if(class5.field97 > 16) {
               class5.field97 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var76 = class5.field92[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var70 = var11 * 768 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class5.field100[var4][var14 + 1][var13] - class5.field100[var4][var14 - 1][var13];
                     var16 = class5.field100[var4][var14][var13 + 1] - class5.field100[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(var15 * var15 + 65536 + var16 * var16));
                     var18 = (var15 << 8) / var17;
                     var19 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = 96 + (-50 * var18 + var19 * -10 + var20 * -50) / var70;
                     var22 = (var76[var14][var13 - 1] >> 2) + (var76[var14 - 1][var13] >> 2) + (var76[var14 + 1][var13] >> 3) + (var76[var14][1 + var13] >> 3) + (var76[var14][var13] >> 1);
                     class5.field88[var14][var13] = var21 - var22;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  class47.field1075[var13] = 0;
                  class76.field1391[var13] = 0;
                  class114.field1974[var13] = 0;
                  class18.field250[var13] = 0;
                  class5.field89[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var13 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class161.field2672[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           class41 var78 = class32.method685(var16 - 1);
                           class47.field1075[var14] += var78.field968;
                           class76.field1391[var14] += var78.field974;
                           class114.field1974[var14] += var78.field970;
                           class18.field250[var14] += var78.field973;
                           ++class5.field89[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class161.field2672[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           class41 var75 = class32.method685(var17 - 1);
                           class47.field1075[var14] -= var75.field968;
                           class76.field1391[var14] -= var75.field974;
                           class114.field1974[var14] -= var75.field970;
                           class18.field250[var14] -= var75.field973;
                           --class5.field89[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var18 = 0;

                     for(var19 = -5; var19 < 109; ++var19) {
                        var20 = var19 + 5;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += class47.field1075[var20];
                           var15 += class76.field1391[var20];
                           var16 += class114.field1974[var20];
                           var17 += class18.field250[var20];
                           var18 += class5.field89[var20];
                        }

                        var21 = var19 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= class47.field1075[var21];
                           var15 -= class76.field1391[var21];
                           var16 -= class114.field1974[var21];
                           var17 -= class18.field250[var21];
                           var18 -= class5.field89[var21];
                        }

                        if(var19 >= 1 && var19 < 103 && (!client.field287 || (class5.field83[0][var13][var19] & 2) != 0 || (class5.field83[var4][var13][var19] & 16) == 0)) {
                           if(var4 < class5.field84) {
                              class5.field84 = var4;
                           }

                           var22 = class161.field2672[var4][var13][var19] & 255;
                           var23 = class5.field87[var4][var13][var19] & 255;
                           if(var22 > 0 || var23 > 0) {
                              var24 = class5.field100[var4][var13][var19];
                              var25 = class5.field100[var4][var13 + 1][var19];
                              var26 = class5.field100[var4][1 + var13][1 + var19];
                              var27 = class5.field100[var4][var13][var19 + 1];
                              var28 = class5.field88[var13][var19];
                              var29 = class5.field88[var13 + 1][var19];
                              int var30 = class5.field88[1 + var13][1 + var19];
                              int var31 = class5.field88[var13][var19 + 1];
                              var32 = -1;
                              var33 = -1;
                              if(var22 > 0) {
                                 var34 = var14 * 256 / var17;
                                 var35 = var15 / var18;
                                 var36 = var16 / var18;
                                 var32 = class22.method561(var34, var35, var36);
                                 var34 = var34 + class5.field96 & 255;
                                 var36 += class5.field97;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = class22.method561(var34, var35, var36);
                              }

                              class46 var37;
                              if(var4 > 0) {
                                 boolean var72 = true;
                                 if(var22 == 0 && class5.field86[var4][var13][var19] != 0) {
                                    var72 = false;
                                 }

                                 if(var23 > 0) {
                                    var36 = var23 - 1;
                                    var37 = (class46)class46.field1052.method3716((long)var36);
                                    class46 var62;
                                    if(var37 != null) {
                                       var62 = var37;
                                    } else {
                                       byte[] var64 = class46.field1053.method3221(4, var36);
                                       var37 = new class46();
                                       if(var64 != null) {
                                          var37.method932(new class119(var64), var36);
                                       }

                                       var37.method931();
                                       class46.field1052.method3724(var37, (long)var36);
                                       var62 = var37;
                                    }

                                    if(!var62.field1055) {
                                       var72 = false;
                                    }
                                 }

                                 if(var72 && var25 == var24 && var24 == var26 && var27 == var24) {
                                    class102.field1774[var4][var13][var19] |= 2340;
                                 }
                              }

                              var34 = 0;
                              if(var33 != -1) {
                                 var34 = class91.field1579[class38.method743(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var67.method1929(var4, var13, var19, 0, 0, -1, var24, var25, var26, var27, class38.method743(var32, var28), class38.method743(var32, var29), class38.method743(var32, var30), class38.method743(var32, var31), 0, 0, 0, 0, var34, 0);
                              } else {
                                 var35 = class5.field86[var4][var13][var19] + 1;
                                 byte var73 = class47.field1081[var4][var13][var19];
                                 var38 = var23 - 1;
                                 class46 var55 = (class46)class46.field1052.method3716((long)var38);
                                 if(null != var55) {
                                    var37 = var55;
                                 } else {
                                    byte[] var53 = class46.field1053.method3221(4, var38);
                                    var55 = new class46();
                                    if(null != var53) {
                                       var55.method932(new class119(var53), var38);
                                    }

                                    var55.method931();
                                    class46.field1052.method3724(var55, (long)var38);
                                    var37 = var55;
                                 }

                                 var40 = var37.field1067;
                                 if(var40 >= 0) {
                                    var42 = class91.field1599.vmethod2128(var40);
                                    var41 = -1;
                                 } else if(var37.field1066 == 16711935) {
                                    var41 = -2;
                                    var40 = -1;
                                    var42 = -2;
                                 } else {
                                    var41 = class22.method561(var37.field1057, var37.field1058, var37.field1059);
                                    var43 = var37.field1057 + class5.field96 & 255;
                                    var44 = class5.field97 + var37.field1059;
                                    if(var44 < 0) {
                                       var44 = 0;
                                    } else if(var44 > 255) {
                                       var44 = 255;
                                    }

                                    var42 = class22.method561(var43, var37.field1058, var44);
                                 }

                                 var43 = 0;
                                 if(var42 != -2) {
                                    var43 = class91.field1579[class115.method2408(var42, 96)];
                                 }

                                 if(var37.field1051 != -1) {
                                    var44 = class5.field96 + var37.field1060 & 255;
                                    var45 = class5.field97 + var37.field1062;
                                    if(var45 < 0) {
                                       var45 = 0;
                                    } else if(var45 > 255) {
                                       var45 = 255;
                                    }

                                    var42 = class22.method561(var44, var37.field1065, var45);
                                    var43 = class91.field1579[class115.method2408(var42, 96)];
                                 }

                                 var67.method1929(var4, var13, var19, var35, var73, var40, var24, var25, var26, var27, class38.method743(var32, var28), class38.method743(var32, var29), class38.method743(var32, var30), class38.method743(var32, var31), class115.method2408(var41, var28), class115.method2408(var41, var29), class115.method2408(var41, var30), class115.method2408(var41, var31), var34, var43);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var67.method1874(var4, var14, var13, class85.method1868(var4, var14, var13));
                  }
               }

               class161.field2672[var4] = (byte[][])null;
               class5.field87[var4] = (byte[][])null;
               class5.field86[var4] = (byte[][])null;
               class47.field1081[var4] = (byte[][])null;
               class5.field92[var4] = (byte[][])null;
            }

            var67.method1901(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class5.field83[1][var4][var5] & 2) == 2) {
                     var67.method1872(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var69 = 0; var69 < 4; ++var69) {
               if(var69 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var8 = 0; var8 <= var69; ++var8) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var71;
                        if((class102.field1774[var8][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var70 = var9;
                           var13 = var8;

                           for(var14 = var8; var11 > 0 && (class102.field1774[var8][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var70 < 104 && (class102.field1774[var8][var10][1 + var70] & var4) != 0) {
                              ++var70;
                           }

                           label1133:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var70; ++var15) {
                                 if((class102.field1774[var13 - 1][var10][var15] & var4) == 0) {
                                    break label1133;
                                 }
                              }

                              --var13;
                           }

                           label1122:
                           while(var14 < var69) {
                              for(var15 = var11; var15 <= var70; ++var15) {
                                 if((class102.field1774[1 + var14][var10][var15] & var4) == 0) {
                                    break label1122;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (1 + (var70 - var11)) * (1 + var14 - var13);
                           if(var15 >= 8) {
                              var71 = 240;
                              var17 = class5.field100[var14][var10][var11] - var71;
                              var18 = class5.field100[var13][var10][var11];
                              class86.method1873(var69, 1, var10 * 128, 128 * var10, var11 * 128, var70 * 128 + 128, var17, var18);

                              for(var19 = var13; var19 <= var14; ++var19) {
                                 for(var20 = var11; var20 <= var70; ++var20) {
                                    class102.field1774[var19][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class102.field1774[var8][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var70 = var10;
                           var13 = var8;

                           for(var14 = var8; var11 > 0 && (class102.field1774[var8][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var70 < 104 && (class102.field1774[var8][1 + var70][var9] & var5) != 0) {
                              ++var70;
                           }

                           label1186:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var70; ++var15) {
                                 if((class102.field1774[var13 - 1][var15][var9] & var5) == 0) {
                                    break label1186;
                                 }
                              }

                              --var13;
                           }

                           label1175:
                           while(var14 < var69) {
                              for(var15 = var11; var15 <= var70; ++var15) {
                                 if((class102.field1774[1 + var14][var15][var9] & var5) == 0) {
                                    break label1175;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var70 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var71 = 240;
                              var17 = class5.field100[var14][var11][var9] - var71;
                              var18 = class5.field100[var13][var11][var9];
                              class86.method1873(var69, 2, var11 * 128, 128 + var70 * 128, 128 * var9, 128 * var9, var17, var18);

                              for(var19 = var13; var19 <= var14; ++var19) {
                                 for(var20 = var11; var20 <= var70; ++var20) {
                                    class102.field1774[var19][var20][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((class102.field1774[var8][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var70 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (class102.field1774[var8][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (class102.field1774[var8][var10][1 + var14] & var6) != 0) {
                              ++var14;
                           }

                           label1239:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class102.field1774[var8][var11 - 1][var15] & var6) == 0) {
                                    break label1239;
                                 }
                              }

                              --var11;
                           }

                           label1228:
                           while(var70 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class102.field1774[var8][1 + var70][var15] & var6) == 0) {
                                    break label1228;
                                 }
                              }

                              ++var70;
                           }

                           if((var70 - var11 + 1) * (var14 - var13 + 1) >= 4) {
                              var15 = class5.field100[var8][var11][var13];
                              class86.method1873(var69, 4, 128 * var11, 128 + 128 * var70, 128 * var13, 128 * var14 + 128, var15, var15);

                              for(var16 = var11; var16 <= var70; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    class102.field1774[var8][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class24.method572(true);
            var4 = class5.field84;
            if(var4 > class32.field754) {
               var4 = class32.field754;
            }

            if(var4 < class32.field754 - 1) {
               var4 = class32.field754 - 1;
            }

            if(client.field287) {
               class214.field3161.method1871(class5.field84);
            } else {
               class214.field3161.method1871(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class3.method35(var5, var6);
               }
            }

            class135.method2845();
            class7.method85();
            class40.field917.method3717();
            if(class43.field1022 != null) {
               client.field325.method2733(119);
               client.field325.method2456(1057001181);
            }

            if(!client.field345) {
               var5 = (class40.field964 - 6) / 8;
               var6 = (class40.field964 + 6) / 8;
               var69 = (class31.field732 - 6) / 8;
               var8 = (class31.field732 + 6) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var69 - 1; var10 <= 1 + var8; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var69 || var10 > var8) {
                        class19.field272.method3241("m" + var9 + "_" + var10);
                        class19.field272.method3241("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class2.method14(30);
            class135.method2845();
            class161.field2672 = (byte[][][])null;
            class5.field87 = (byte[][][])null;
            class5.field86 = (byte[][][])null;
            class47.field1081 = (byte[][][])null;
            class102.field1774 = (int[][][])null;
            class5.field92 = (byte[][][])null;
            class5.field88 = (int[][])null;
            class47.field1075 = null;
            class76.field1391 = null;
            class114.field1974 = null;
            class18.field250 = null;
            class5.field89 = null;
            client.field325.method2733(23);
            class216.method3903();
         }
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1028900235"
   )
   static final void method1657() {
      for(class6 var0 = (class6)client.field417.method3797(); var0 != null; var0 = (class6)client.field417.method3779()) {
         if(var0.field117 == class32.field754 && client.field332 <= var0.field123) {
            if(client.field332 >= var0.field107) {
               if(var0.field120 > 0) {
                  class34 var1 = client.field320[var0.field120 - 1];
                  if(null != var1 && var1.field809 >= 0 && var1.field809 < 13312 && var1.field804 >= 0 && var1.field804 < 13312) {
                     var0.method69(var1.field809, var1.field804, class14.method147(var1.field809, var1.field804, var0.field117) - var0.field108, client.field332);
                  }
               }

               if(var0.field120 < 0) {
                  int var2 = -var0.field120 - 1;
                  class2 var3;
                  if(client.field460 == var2) {
                     var3 = class152.field2301;
                  } else {
                     var3 = client.field405[var2];
                  }

                  if(var3 != null && var3.field809 >= 0 && var3.field809 < 13312 && var3.field804 >= 0 && var3.field804 < 13312) {
                     var0.method69(var3.field809, var3.field804, class14.method147(var3.field809, var3.field804, var0.field117) - var0.field108, client.field332);
                  }
               }

               var0.method74(client.field330);
               class214.field3161.method1903(class32.field754, (int)var0.field113, (int)var0.field114, (int)var0.field115, 60, var0, var0.field121, -1, false);
            }
         } else {
            var0.method3870();
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1655173143"
   )
   public final void method1658() {
      class79.method1751(this.field1401, this.field1402, this.field1396);
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(Lclass173;II)I",
      garbageValue = "642791754"
   )
   static final int method1659(class173 var0, int var1) {
      if(var0.field2888 != null && var1 < var0.field2888.length) {
         try {
            int[] var2 = var0.field2888[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.field303[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field420[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = client.field421[var2[var4++]];
               }

               int var9;
               class173 var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class170.method3344(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class123.method2743(var11).field1134 || client.field286)) {
                     for(var12 = 0; var12 < var10.field2849.length; ++var12) {
                        if(var10.field2849[var12] == var11 + 1) {
                           var7 += var10.field2868[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class176.field2923[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class155.field2324[client.field420[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class176.field2923[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class152.field2301.field41;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class155.field2323[var9]) {
                        var7 += client.field420[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class170.method3344(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class123.method2743(var11).field1134 || client.field286)) {
                     for(var12 = 0; var12 < var10.field2849.length; ++var12) {
                        if(var10.field2849[var12] == var11 + 1) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = client.field531;
               }

               if(var6 == 12) {
                  var7 = client.field448;
               }

               if(var6 == 13) {
                  var9 = class176.field2923[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class13.method144(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class152.field2301.field809 >> 7) + class89.field1565;
               }

               if(var6 == 19) {
                  var7 = (class152.field2301.field804 >> 7) + client.field358;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)I",
      garbageValue = "-191"
   )
   public static int method1660(CharSequence var0) {
      return class110.method2387(var0, 10, true);
   }
}
