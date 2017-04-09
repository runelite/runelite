import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class84 extends Rasterizer2D {
   @ObfuscatedName("y")
   static int field1452;
   @ObfuscatedName("v")
   static int field1453;
   @ObfuscatedName("u")
   static boolean field1454 = false;
   @ObfuscatedName("s")
   static int field1455;
   @ObfuscatedName("j")
   static int field1456;
   @ObfuscatedName("h")
   @Export("rasterGouraudLowRes")
   public static boolean rasterGouraudLowRes = true;
   @ObfuscatedName("w")
   public static int field1461 = 512;
   @ObfuscatedName("p")
   static int field1462;
   @ObfuscatedName("i")
   static boolean field1463 = false;
   @ObfuscatedName("f")
   @Export("rasterClipEnable")
   static boolean rasterClipEnable = false;
   @ObfuscatedName("d")
   static int field1465;
   @ObfuscatedName("x")
   @Export("colorPalette")
   public static int[] colorPalette = new int[65536];
   @ObfuscatedName("r")
   @Export("rasterAlpha")
   static int rasterAlpha = 0;
   @ObfuscatedName("a")
   static int field1468;
   @ObfuscatedName("c")
   public static int[] field1469 = new int[2048];
   @ObfuscatedName("z")
   @Export("rasterClipY")
   static int[] rasterClipY = new int[1024];
   @ObfuscatedName("q")
   @Export("rasterClipX")
   static int rasterClipX;
   @ObfuscatedName("g")
   public static class93 field1472;
   @ObfuscatedName("b")
   static int[] field1473 = new int[512];
   @ObfuscatedName("k")
   static int[] field1474 = new int[2048];
   @ObfuscatedName("t")
   public static int[] field1475 = new int[2048];

   @ObfuscatedName("f")
   public static final void method1671() {
      setRasterClipping(Rasterizer2D.field3193, Rasterizer2D.field3191, Rasterizer2D.field3194, Rasterizer2D.field3189);
   }

   @ObfuscatedName("u")
   public static final void method1673() {
      field1456 = rasterClipX / 2;
      field1455 = field1465 / 2;
      field1462 = -field1456;
      field1452 = rasterClipX - field1456;
      field1468 = -field1455;
      field1453 = field1465 - field1455;
   }

   @ObfuscatedName("r")
   public static final void method1674(int var0, int var1) {
      int var2 = rasterClipY[0];
      int var3 = var2 / Rasterizer2D.graphicsPixelsWidth;
      int var4 = var2 - var3 * Rasterizer2D.graphicsPixelsWidth;
      field1456 = var0 - var4;
      field1455 = var1 - var3;
      field1462 = -field1456;
      field1452 = rasterClipX - field1456;
      field1468 = -field1455;
      field1453 = field1465 - field1455;
   }

   @ObfuscatedName("o")
   public static final void method1675(class93 var0) {
      field1472 = var0;
   }

   @ObfuscatedName("n")
   static final void method1677(double var0, int var2, int var3) {
      var0 += Math.random() * 0.03D - 0.015D;
      int var4 = var2 * 128;

      for(int var5 = var2; var5 < var3; ++var5) {
         double var6 = (double)(var5 >> 3) / 64.0D + 0.0078125D;
         double var8 = (double)(var5 & 7) / 8.0D + 0.0625D;

         for(int var10 = 0; var10 < 128; ++var10) {
            double var11 = (double)var10 / 128.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(var8 != 0.0D) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = var11 * (1.0D + var8);
               } else {
                  var19 = var11 + var8 - var11 * var8;
               }

               double var21 = 2.0D * var11 - var19;
               double var23 = var6 + 0.3333333333333333D;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var25 = var6 - 0.3333333333333333D;
               if(var25 < 0.0D) {
                  ++var25;
               }

               if(6.0D * var23 < 1.0D) {
                  var13 = var21 + (var19 - var21) * 6.0D * var23;
               } else if(2.0D * var23 < 1.0D) {
                  var13 = var19;
               } else if(3.0D * var23 < 2.0D) {
                  var13 = var21 + (var19 - var21) * (0.6666666666666666D - var23) * 6.0D;
               } else {
                  var13 = var21;
               }

               if(6.0D * var6 < 1.0D) {
                  var15 = var21 + (var19 - var21) * 6.0D * var6;
               } else if(2.0D * var6 < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var6 < 2.0D) {
                  var15 = var21 + (var19 - var21) * (0.6666666666666666D - var6) * 6.0D;
               } else {
                  var15 = var21;
               }

               if(6.0D * var25 < 1.0D) {
                  var17 = var21 + (var19 - var21) * 6.0D * var25;
               } else if(2.0D * var25 < 1.0D) {
                  var17 = var19;
               } else if(3.0D * var25 < 2.0D) {
                  var17 = var21 + (var19 - var21) * (0.6666666666666666D - var25) * 6.0D;
               } else {
                  var17 = var21;
               }
            }

            int var28 = (int)(var13 * 256.0D);
            int var20 = (int)(var15 * 256.0D);
            int var27 = (int)(var17 * 256.0D);
            int var22 = (var28 << 16) + (var20 << 8) + var27;
            var22 = method1684(var22, var0);
            if(var22 == 0) {
               var22 = 1;
            }

            colorPalette[var4++] = var22;
         }
      }

   }

   @ObfuscatedName("a")
   @Export("rasterTexture")
   static final void rasterTexture(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18) {
      int[] var19 = field1472.load(var18);
      int var20;
      if(var19 == null) {
         var20 = field1472.vmethod1942(var18);
         rasterGouraud(var0, var1, var2, var3, var4, var5, method1698(var20, var6), method1698(var20, var7), method1698(var20, var8));
      } else {
         field1454 = field1472.vmethod1941(var18);
         field1463 = field1472.vmethod1946(var18);
         var20 = var4 - var3;
         int var21 = var1 - var0;
         int var22 = var5 - var3;
         int var23 = var2 - var0;
         int var24 = var7 - var6;
         int var25 = var8 - var6;
         int var26 = 0;
         if(var1 != var0) {
            var26 = (var4 - var3 << 14) / (var1 - var0);
         }

         int var27 = 0;
         if(var2 != var1) {
            var27 = (var5 - var4 << 14) / (var2 - var1);
         }

         int var28 = 0;
         if(var2 != var0) {
            var28 = (var3 - var5 << 14) / (var0 - var2);
         }

         int var29 = var20 * var23 - var22 * var21;
         if(var29 != 0) {
            int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
            int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
            var10 = var9 - var10;
            var13 = var12 - var13;
            var16 = var15 - var16;
            var11 -= var9;
            var14 -= var12;
            var17 -= var15;
            int var32 = var11 * var12 - var14 * var9 << 14;
            int var33 = (int)(((long)(var14 * var15 - var17 * var12) << 14) / (long)field1461);
            int var34 = (int)(((long)(var17 * var9 - var11 * var15) << 14) / (long)field1461);
            int var35 = var10 * var12 - var13 * var9 << 14;
            int var36 = (int)(((long)(var13 * var15 - var16 * var12) << 14) / (long)field1461);
            int var37 = (int)(((long)(var16 * var9 - var10 * var15) << 14) / (long)field1461);
            int var38 = var13 * var11 - var10 * var14 << 14;
            int var39 = (int)(((long)(var16 * var14 - var13 * var17) << 14) / (long)field1461);
            int var40 = (int)(((long)(var10 * var17 - var16 * var11) << 14) / (long)field1461);
            int var41;
            if(var0 <= var1 && var0 <= var2) {
               if(var0 < field1465) {
                  if(var1 > field1465) {
                     var1 = field1465;
                  }

                  if(var2 > field1465) {
                     var2 = field1465;
                  }

                  var6 = (var6 << 9) - var30 * var3 + var30;
                  if(var1 < var2) {
                     var5 = var3 <<= 14;
                     if(var0 < 0) {
                        var5 -= var28 * var0;
                        var3 -= var26 * var0;
                        var6 -= var31 * var0;
                        var0 = 0;
                     }

                     var4 <<= 14;
                     if(var1 < 0) {
                        var4 -= var27 * var1;
                        var1 = 0;
                     }

                     var41 = var0 - field1455;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if(var0 != var1 && var28 < var26 || var0 == var1 && var28 > var27) {
                        var2 -= var1;
                        var1 -= var0;
                        var0 = rasterClipY[var0];

                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              while(true) {
                                 --var2;
                                 if(var2 < 0) {
                                    return;
                                 }

                                 method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                 var5 += var28;
                                 var4 += var27;
                                 var6 += var31;
                                 var0 += Rasterizer2D.graphicsPixelsWidth;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var28;
                           var3 += var26;
                           var6 += var31;
                           var0 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     var2 -= var1;
                     var1 -= var0;
                     var0 = rasterClipY[var0];

                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           while(true) {
                              --var2;
                              if(var2 < 0) {
                                 return;
                              }

                              method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                              var5 += var28;
                              var4 += var27;
                              var6 += var31;
                              var0 += Rasterizer2D.graphicsPixelsWidth;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                        var5 += var28;
                        var3 += var26;
                        var6 += var31;
                        var0 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  var4 = var3 <<= 14;
                  if(var0 < 0) {
                     var4 -= var28 * var0;
                     var3 -= var26 * var0;
                     var6 -= var31 * var0;
                     var0 = 0;
                  }

                  var5 <<= 14;
                  if(var2 < 0) {
                     var5 -= var27 * var2;
                     var2 = 0;
                  }

                  var41 = var0 - field1455;
                  var32 += var34 * var41;
                  var35 += var37 * var41;
                  var38 += var40 * var41;
                  if(var0 != var2 && var28 < var26 || var0 == var2 && var27 > var26) {
                     var1 -= var2;
                     var2 -= var0;
                     var0 = rasterClipY[var0];

                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           while(true) {
                              --var1;
                              if(var1 < 0) {
                                 return;
                              }

                              method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                              var5 += var27;
                              var3 += var26;
                              var6 += var31;
                              var0 += Rasterizer2D.graphicsPixelsWidth;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                        var4 += var28;
                        var3 += var26;
                        var6 += var31;
                        var0 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  var1 -= var2;
                  var2 -= var0;
                  var0 = rasterClipY[var0];

                  while(true) {
                     --var2;
                     if(var2 < 0) {
                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              return;
                           }

                           method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var27;
                           var3 += var26;
                           var6 += var31;
                           var0 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                     var4 += var28;
                     var3 += var26;
                     var6 += var31;
                     var0 += Rasterizer2D.graphicsPixelsWidth;
                     var32 += var34;
                     var35 += var37;
                     var38 += var40;
                  }
               }
            } else if(var1 <= var2) {
               if(var1 < field1465) {
                  if(var2 > field1465) {
                     var2 = field1465;
                  }

                  if(var0 > field1465) {
                     var0 = field1465;
                  }

                  var7 = (var7 << 9) - var30 * var4 + var30;
                  if(var2 < var0) {
                     var3 = var4 <<= 14;
                     if(var1 < 0) {
                        var3 -= var26 * var1;
                        var4 -= var27 * var1;
                        var7 -= var31 * var1;
                        var1 = 0;
                     }

                     var5 <<= 14;
                     if(var2 < 0) {
                        var5 -= var28 * var2;
                        var2 = 0;
                     }

                     var41 = var1 - field1455;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if(var1 != var2 && var26 < var27 || var1 == var2 && var26 > var28) {
                        var0 -= var2;
                        var2 -= var1;
                        var1 = rasterClipY[var1];

                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              while(true) {
                                 --var0;
                                 if(var0 < 0) {
                                    return;
                                 }

                                 method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                 var3 += var26;
                                 var5 += var28;
                                 var7 += var31;
                                 var1 += Rasterizer2D.graphicsPixelsWidth;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var3 += var26;
                           var4 += var27;
                           var7 += var31;
                           var1 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     var0 -= var2;
                     var2 -= var1;
                     var1 = rasterClipY[var1];

                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           while(true) {
                              --var0;
                              if(var0 < 0) {
                                 return;
                              }

                              method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                              var3 += var26;
                              var5 += var28;
                              var7 += var31;
                              var1 += Rasterizer2D.graphicsPixelsWidth;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                        var3 += var26;
                        var4 += var27;
                        var7 += var31;
                        var1 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  var5 = var4 <<= 14;
                  if(var1 < 0) {
                     var5 -= var26 * var1;
                     var4 -= var27 * var1;
                     var7 -= var31 * var1;
                     var1 = 0;
                  }

                  var3 <<= 14;
                  if(var0 < 0) {
                     var3 -= var28 * var0;
                     var0 = 0;
                  }

                  var41 = var1 - field1455;
                  var32 += var34 * var41;
                  var35 += var37 * var41;
                  var38 += var40 * var41;
                  if(var26 < var27) {
                     var2 -= var0;
                     var0 -= var1;
                     var1 = rasterClipY[var1];

                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           while(true) {
                              --var2;
                              if(var2 < 0) {
                                 return;
                              }

                              method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                              var3 += var28;
                              var4 += var27;
                              var7 += var31;
                              var1 += Rasterizer2D.graphicsPixelsWidth;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                        var5 += var26;
                        var4 += var27;
                        var7 += var31;
                        var1 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  var2 -= var0;
                  var0 -= var1;
                  var1 = rasterClipY[var1];

                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              return;
                           }

                           method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var3 += var28;
                           var4 += var27;
                           var7 += var31;
                           var1 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                     var5 += var26;
                     var4 += var27;
                     var7 += var31;
                     var1 += Rasterizer2D.graphicsPixelsWidth;
                     var32 += var34;
                     var35 += var37;
                     var38 += var40;
                  }
               }
            } else if(var2 < field1465) {
               if(var0 > field1465) {
                  var0 = field1465;
               }

               if(var1 > field1465) {
                  var1 = field1465;
               }

               var8 = (var8 << 9) - var30 * var5 + var30;
               if(var0 < var1) {
                  var4 = var5 <<= 14;
                  if(var2 < 0) {
                     var4 -= var27 * var2;
                     var5 -= var28 * var2;
                     var8 -= var31 * var2;
                     var2 = 0;
                  }

                  var3 <<= 14;
                  if(var0 < 0) {
                     var3 -= var26 * var0;
                     var0 = 0;
                  }

                  var41 = var2 - field1455;
                  var32 += var34 * var41;
                  var35 += var37 * var41;
                  var38 += var40 * var41;
                  if(var27 < var28) {
                     var1 -= var0;
                     var0 -= var2;
                     var2 = rasterClipY[var2];

                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           while(true) {
                              --var1;
                              if(var1 < 0) {
                                 return;
                              }

                              method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                              var4 += var27;
                              var3 += var26;
                              var8 += var31;
                              var2 += Rasterizer2D.graphicsPixelsWidth;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var4 += var27;
                        var5 += var28;
                        var8 += var31;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  var1 -= var0;
                  var0 -= var2;
                  var2 = rasterClipY[var2];

                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              return;
                           }

                           method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                           var4 += var27;
                           var3 += var26;
                           var8 += var31;
                           var2 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                     var4 += var27;
                     var5 += var28;
                     var8 += var31;
                     var2 += Rasterizer2D.graphicsPixelsWidth;
                     var32 += var34;
                     var35 += var37;
                     var38 += var40;
                  }
               }

               var3 = var5 <<= 14;
               if(var2 < 0) {
                  var3 -= var27 * var2;
                  var5 -= var28 * var2;
                  var8 -= var31 * var2;
                  var2 = 0;
               }

               var4 <<= 14;
               if(var1 < 0) {
                  var4 -= var26 * var1;
                  var1 = 0;
               }

               var41 = var2 - field1455;
               var32 += var34 * var41;
               var35 += var37 * var41;
               var38 += var40 * var41;
               if(var27 < var28) {
                  var0 -= var1;
                  var1 -= var2;
                  var2 = rasterClipY[var2];

                  while(true) {
                     --var1;
                     if(var1 < 0) {
                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              return;
                           }

                           method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                           var4 += var26;
                           var5 += var28;
                           var8 += var31;
                           var2 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                     var3 += var27;
                     var5 += var28;
                     var8 += var31;
                     var2 += Rasterizer2D.graphicsPixelsWidth;
                     var32 += var34;
                     var35 += var37;
                     var38 += var40;
                  }
               }

               var0 -= var1;
               var1 -= var2;
               var2 = rasterClipY[var2];

               while(true) {
                  --var1;
                  if(var1 < 0) {
                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           return;
                        }

                        method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var4 += var26;
                        var5 += var28;
                        var8 += var31;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  method1687(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                  var3 += var27;
                  var5 += var28;
                  var8 += var31;
                  var2 += Rasterizer2D.graphicsPixelsWidth;
                  var32 += var34;
                  var35 += var37;
                  var38 += var40;
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @Export("setRasterClippingEnabled")
   public static void setRasterClippingEnabled(int var0, int var1, int var2) {
      rasterClipEnable = var0 < 0 || var0 > rasterClipX || var1 < 0 || var1 > rasterClipX || var2 < 0 || var2 > rasterClipX;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.8"
   )
   public static final void method1680(double var0) {
      method1677(var0, 0, 512);
   }

   @ObfuscatedName("d")
   static final void method1681(int[] var0, int var1, int var2, int var3, int var4, int var5) {
      if(rasterClipEnable) {
         if(var5 > rasterClipX) {
            var5 = rasterClipX;
         }

         if(var4 < 0) {
            var4 = 0;
         }
      }

      if(var4 < var5) {
         var1 += var4;
         var3 = var5 - var4 >> 2;
         if(rasterAlpha != 0) {
            if(rasterAlpha == 254) {
               while(true) {
                  --var3;
                  if(var3 < 0) {
                     var3 = var5 - var4 & 3;

                     while(true) {
                        --var3;
                        if(var3 < 0) {
                           return;
                        }

                        var0[var1++] = var0[var1];
                     }
                  }

                  var0[var1++] = var0[var1];
                  var0[var1++] = var0[var1];
                  var0[var1++] = var0[var1];
                  var0[var1++] = var0[var1];
               }
            } else {
               int var6 = rasterAlpha;
               int var7 = 256 - rasterAlpha;
               var2 = ((var2 & 16711935) * var7 >> 8 & 16711935) + ((var2 & '\uff00') * var7 >> 8 & '\uff00');

               while(true) {
                  --var3;
                  int var8;
                  if(var3 < 0) {
                     var3 = var5 - var4 & 3;

                     while(true) {
                        --var3;
                        if(var3 < 0) {
                           return;
                        }

                        var8 = var0[var1];
                        var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & '\uff00') * var6 >> 8 & '\uff00');
                     }
                  }

                  var8 = var0[var1];
                  var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & '\uff00') * var6 >> 8 & '\uff00');
                  var8 = var0[var1];
                  var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & '\uff00') * var6 >> 8 & '\uff00');
                  var8 = var0[var1];
                  var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & '\uff00') * var6 >> 8 & '\uff00');
                  var8 = var0[var1];
                  var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & '\uff00') * var6 >> 8 & '\uff00');
               }
            }
         } else {
            while(true) {
               --var3;
               if(var3 < 0) {
                  var3 = var5 - var4 & 3;

                  while(true) {
                     --var3;
                     if(var3 < 0) {
                        return;
                     }

                     var0[var1++] = var2;
                  }
               }

               var0[var1++] = var2;
               var0[var1++] = var2;
               var0[var1++] = var2;
               var0[var1++] = var2;
            }
         }
      }
   }

   @ObfuscatedName("q")
   @Export("rasterFlat")
   public static final void rasterFlat(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = 0;
      if(var1 != var0) {
         var7 = (var4 - var3 << 14) / (var1 - var0);
      }

      int var8 = 0;
      if(var2 != var1) {
         var8 = (var5 - var4 << 14) / (var2 - var1);
      }

      int var9 = 0;
      if(var2 != var0) {
         var9 = (var3 - var5 << 14) / (var0 - var2);
      }

      if(var0 <= var1 && var0 <= var2) {
         if(var0 < field1465) {
            if(var1 > field1465) {
               var1 = field1465;
            }

            if(var2 > field1465) {
               var2 = field1465;
            }

            if(var1 < var2) {
               var5 = var3 <<= 14;
               if(var0 < 0) {
                  var5 -= var9 * var0;
                  var3 -= var7 * var0;
                  var0 = 0;
               }

               var4 <<= 14;
               if(var1 < 0) {
                  var4 -= var8 * var1;
                  var1 = 0;
               }

               if((var0 == var1 || var9 >= var7) && (var0 != var1 || var9 <= var8)) {
                  var2 -= var1;
                  var1 -= var0;
                  var0 = rasterClipY[var0];

                  while(true) {
                     --var1;
                     if(var1 < 0) {
                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              return;
                           }

                           method1681(Rasterizer2D.graphicsPixels, var0, var6, 0, var4 >> 14, var5 >> 14);
                           var5 += var9;
                           var4 += var8;
                           var0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method1681(Rasterizer2D.graphicsPixels, var0, var6, 0, var3 >> 14, var5 >> 14);
                     var5 += var9;
                     var3 += var7;
                     var0 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               var2 -= var1;
               var1 -= var0;
               var0 = rasterClipY[var0];

               while(true) {
                  --var1;
                  if(var1 < 0) {
                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           return;
                        }

                        method1681(Rasterizer2D.graphicsPixels, var0, var6, 0, var5 >> 14, var4 >> 14);
                        var5 += var9;
                        var4 += var8;
                        var0 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method1681(Rasterizer2D.graphicsPixels, var0, var6, 0, var5 >> 14, var3 >> 14);
                  var5 += var9;
                  var3 += var7;
                  var0 += Rasterizer2D.graphicsPixelsWidth;
               }
            }

            var4 = var3 <<= 14;
            if(var0 < 0) {
               var4 -= var9 * var0;
               var3 -= var7 * var0;
               var0 = 0;
            }

            var5 <<= 14;
            if(var2 < 0) {
               var5 -= var8 * var2;
               var2 = 0;
            }

            if(var0 != var2 && var9 < var7 || var0 == var2 && var8 > var7) {
               var1 -= var2;
               var2 -= var0;
               var0 = rasterClipY[var0];

               while(true) {
                  --var2;
                  if(var2 < 0) {
                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           return;
                        }

                        method1681(Rasterizer2D.graphicsPixels, var0, var6, 0, var5 >> 14, var3 >> 14);
                        var5 += var8;
                        var3 += var7;
                        var0 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method1681(Rasterizer2D.graphicsPixels, var0, var6, 0, var4 >> 14, var3 >> 14);
                  var4 += var9;
                  var3 += var7;
                  var0 += Rasterizer2D.graphicsPixelsWidth;
               }
            }

            var1 -= var2;
            var2 -= var0;
            var0 = rasterClipY[var0];

            while(true) {
               --var2;
               if(var2 < 0) {
                  while(true) {
                     --var1;
                     if(var1 < 0) {
                        return;
                     }

                     method1681(Rasterizer2D.graphicsPixels, var0, var6, 0, var3 >> 14, var5 >> 14);
                     var5 += var8;
                     var3 += var7;
                     var0 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               method1681(Rasterizer2D.graphicsPixels, var0, var6, 0, var3 >> 14, var4 >> 14);
               var4 += var9;
               var3 += var7;
               var0 += Rasterizer2D.graphicsPixelsWidth;
            }
         }
      } else if(var1 <= var2) {
         if(var1 < field1465) {
            if(var2 > field1465) {
               var2 = field1465;
            }

            if(var0 > field1465) {
               var0 = field1465;
            }

            if(var2 < var0) {
               var3 = var4 <<= 14;
               if(var1 < 0) {
                  var3 -= var7 * var1;
                  var4 -= var8 * var1;
                  var1 = 0;
               }

               var5 <<= 14;
               if(var2 < 0) {
                  var5 -= var9 * var2;
                  var2 = 0;
               }

               if((var1 == var2 || var7 >= var8) && (var1 != var2 || var7 <= var9)) {
                  var0 -= var2;
                  var2 -= var1;
                  var1 = rasterClipY[var1];

                  while(true) {
                     --var2;
                     if(var2 < 0) {
                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              return;
                           }

                           method1681(Rasterizer2D.graphicsPixels, var1, var6, 0, var5 >> 14, var3 >> 14);
                           var3 += var7;
                           var5 += var9;
                           var1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method1681(Rasterizer2D.graphicsPixels, var1, var6, 0, var4 >> 14, var3 >> 14);
                     var3 += var7;
                     var4 += var8;
                     var1 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               var0 -= var2;
               var2 -= var1;
               var1 = rasterClipY[var1];

               while(true) {
                  --var2;
                  if(var2 < 0) {
                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           return;
                        }

                        method1681(Rasterizer2D.graphicsPixels, var1, var6, 0, var3 >> 14, var5 >> 14);
                        var3 += var7;
                        var5 += var9;
                        var1 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method1681(Rasterizer2D.graphicsPixels, var1, var6, 0, var3 >> 14, var4 >> 14);
                  var3 += var7;
                  var4 += var8;
                  var1 += Rasterizer2D.graphicsPixelsWidth;
               }
            }

            var5 = var4 <<= 14;
            if(var1 < 0) {
               var5 -= var7 * var1;
               var4 -= var8 * var1;
               var1 = 0;
            }

            var3 <<= 14;
            if(var0 < 0) {
               var3 -= var9 * var0;
               var0 = 0;
            }

            if(var7 < var8) {
               var2 -= var0;
               var0 -= var1;
               var1 = rasterClipY[var1];

               while(true) {
                  --var0;
                  if(var0 < 0) {
                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           return;
                        }

                        method1681(Rasterizer2D.graphicsPixels, var1, var6, 0, var3 >> 14, var4 >> 14);
                        var3 += var9;
                        var4 += var8;
                        var1 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method1681(Rasterizer2D.graphicsPixels, var1, var6, 0, var5 >> 14, var4 >> 14);
                  var5 += var7;
                  var4 += var8;
                  var1 += Rasterizer2D.graphicsPixelsWidth;
               }
            }

            var2 -= var0;
            var0 -= var1;
            var1 = rasterClipY[var1];

            while(true) {
               --var0;
               if(var0 < 0) {
                  while(true) {
                     --var2;
                     if(var2 < 0) {
                        return;
                     }

                     method1681(Rasterizer2D.graphicsPixels, var1, var6, 0, var4 >> 14, var3 >> 14);
                     var3 += var9;
                     var4 += var8;
                     var1 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               method1681(Rasterizer2D.graphicsPixels, var1, var6, 0, var4 >> 14, var5 >> 14);
               var5 += var7;
               var4 += var8;
               var1 += Rasterizer2D.graphicsPixelsWidth;
            }
         }
      } else if(var2 < field1465) {
         if(var0 > field1465) {
            var0 = field1465;
         }

         if(var1 > field1465) {
            var1 = field1465;
         }

         if(var0 < var1) {
            var4 = var5 <<= 14;
            if(var2 < 0) {
               var4 -= var8 * var2;
               var5 -= var9 * var2;
               var2 = 0;
            }

            var3 <<= 14;
            if(var0 < 0) {
               var3 -= var7 * var0;
               var0 = 0;
            }

            if(var8 < var9) {
               var1 -= var0;
               var0 -= var2;
               var2 = rasterClipY[var2];

               while(true) {
                  --var0;
                  if(var0 < 0) {
                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           return;
                        }

                        method1681(Rasterizer2D.graphicsPixels, var2, var6, 0, var4 >> 14, var3 >> 14);
                        var4 += var8;
                        var3 += var7;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method1681(Rasterizer2D.graphicsPixels, var2, var6, 0, var4 >> 14, var5 >> 14);
                  var4 += var8;
                  var5 += var9;
                  var2 += Rasterizer2D.graphicsPixelsWidth;
               }
            }

            var1 -= var0;
            var0 -= var2;
            var2 = rasterClipY[var2];

            while(true) {
               --var0;
               if(var0 < 0) {
                  while(true) {
                     --var1;
                     if(var1 < 0) {
                        return;
                     }

                     method1681(Rasterizer2D.graphicsPixels, var2, var6, 0, var3 >> 14, var4 >> 14);
                     var4 += var8;
                     var3 += var7;
                     var2 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               method1681(Rasterizer2D.graphicsPixels, var2, var6, 0, var5 >> 14, var4 >> 14);
               var4 += var8;
               var5 += var9;
               var2 += Rasterizer2D.graphicsPixelsWidth;
            }
         }

         var3 = var5 <<= 14;
         if(var2 < 0) {
            var3 -= var8 * var2;
            var5 -= var9 * var2;
            var2 = 0;
         }

         var4 <<= 14;
         if(var1 < 0) {
            var4 -= var7 * var1;
            var1 = 0;
         }

         if(var8 < var9) {
            var0 -= var1;
            var1 -= var2;
            var2 = rasterClipY[var2];

            while(true) {
               --var1;
               if(var1 < 0) {
                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        return;
                     }

                     method1681(Rasterizer2D.graphicsPixels, var2, var6, 0, var4 >> 14, var5 >> 14);
                     var4 += var7;
                     var5 += var9;
                     var2 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               method1681(Rasterizer2D.graphicsPixels, var2, var6, 0, var3 >> 14, var5 >> 14);
               var3 += var8;
               var5 += var9;
               var2 += Rasterizer2D.graphicsPixelsWidth;
            }
         }

         var0 -= var1;
         var1 -= var2;
         var2 = rasterClipY[var2];

         while(true) {
            --var1;
            if(var1 < 0) {
               while(true) {
                  --var0;
                  if(var0 < 0) {
                     return;
                  }

                  method1681(Rasterizer2D.graphicsPixels, var2, var6, 0, var5 >> 14, var4 >> 14);
                  var4 += var7;
                  var5 += var9;
                  var2 += Rasterizer2D.graphicsPixelsWidth;
               }
            }

            method1681(Rasterizer2D.graphicsPixels, var2, var6, 0, var5 >> 14, var3 >> 14);
            var3 += var8;
            var5 += var9;
            var2 += Rasterizer2D.graphicsPixelsWidth;
         }
      }

   }

   @ObfuscatedName("m")
   static int method1684(int var0, double var1) {
      double var3 = (double)(var0 >> 16) / 256.0D;
      double var5 = (double)(var0 >> 8 & 255) / 256.0D;
      double var7 = (double)(var0 & 255) / 256.0D;
      var3 = Math.pow(var3, var1);
      var5 = Math.pow(var5, var1);
      var7 = Math.pow(var7, var1);
      int var9 = (int)(var3 * 256.0D);
      int var10 = (int)(var5 * 256.0D);
      int var11 = (int)(var7 * 256.0D);
      return (var9 << 16) + (var10 << 8) + var11;
   }

   @ObfuscatedName("v")
   static final void method1687(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
      if(rasterClipEnable) {
         if(var6 > rasterClipX) {
            var6 = rasterClipX;
         }

         if(var5 < 0) {
            var5 = 0;
         }
      }

      if(var5 < var6) {
         var4 += var5;
         var7 += var8 * var5;
         int var15 = var6 - var5;
         int var16;
         int var17;
         int var18;
         int var19;
         int var20;
         int var21;
         int var22;
         int var23;
         if(field1454) {
            var23 = var5 - field1456;
            var9 += var12 * var23;
            var10 += var13 * var23;
            var11 += var14 * var23;
            var22 = var11 >> 12;
            if(var22 != 0) {
               var18 = var9 / var22;
               var19 = var10 / var22;
            } else {
               var18 = 0;
               var19 = 0;
            }

            var9 += var12 * var15;
            var10 += var13 * var15;
            var11 += var14 * var15;
            var22 = var11 >> 12;
            if(var22 != 0) {
               var20 = var9 / var22;
               var21 = var10 / var22;
            } else {
               var20 = 0;
               var21 = 0;
            }

            var2 = (var18 << 20) + var19;
            var17 = ((var20 - var18) / var15 << 20) + (var21 - var19) / var15;
            var15 >>= 3;
            var8 <<= 3;
            var16 = var7 >> 8;
            if(field1463) {
               if(var15 > 0) {
                  do {
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var7 += var8;
                     var16 = var7 >> 8;
                     --var15;
                  } while(var15 > 0);
               }

               var15 = var6 - var5 & 7;
               if(var15 > 0) {
                  do {
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     --var15;
                  } while(var15 > 0);
               }
            } else {
               if(var15 > 0) {
                  do {
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     var7 += var8;
                     var16 = var7 >> 8;
                     --var15;
                  } while(var15 > 0);
               }

               var15 = var6 - var5 & 7;
               if(var15 > 0) {
                  do {
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     --var15;
                  } while(var15 > 0);
               }
            }
         } else {
            var23 = var5 - field1456;
            var9 += var12 * var23;
            var10 += var13 * var23;
            var11 += var14 * var23;
            var22 = var11 >> 14;
            if(var22 != 0) {
               var18 = var9 / var22;
               var19 = var10 / var22;
            } else {
               var18 = 0;
               var19 = 0;
            }

            var9 += var12 * var15;
            var10 += var13 * var15;
            var11 += var14 * var15;
            var22 = var11 >> 14;
            if(var22 != 0) {
               var20 = var9 / var22;
               var21 = var10 / var22;
            } else {
               var20 = 0;
               var21 = 0;
            }

            var2 = (var18 << 18) + var19;
            var17 = ((var20 - var18) / var15 << 18) + (var21 - var19) / var15;
            var15 >>= 3;
            var8 <<= 3;
            var16 = var7 >> 8;
            if(field1463) {
               if(var15 > 0) {
                  do {
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     var7 += var8;
                     var16 = var7 >> 8;
                     --var15;
                  } while(var15 > 0);
               }

               var15 = var6 - var5 & 7;
               if(var15 > 0) {
                  do {
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var17;
                     --var15;
                  } while(var15 > 0);
               }
            } else {
               if(var15 > 0) {
                  do {
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     var7 += var8;
                     var16 = var7 >> 8;
                     --var15;
                  } while(var15 > 0);
               }

               var15 = var6 - var5 & 7;
               if(var15 > 0) {
                  do {
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var17;
                     --var15;
                  } while(var15 > 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @Export("setRasterClipping")
   static final void setRasterClipping(int var0, int var1, int var2, int var3) {
      rasterClipX = var2 - var0;
      field1465 = var3 - var1;
      method1673();
      if(rasterClipY.length < field1465) {
         rasterClipY = new int[World.method601(field1465)];
      }

      int var4 = var1 * Rasterizer2D.graphicsPixelsWidth + var0;

      for(int var5 = 0; var5 < field1465; ++var5) {
         rasterClipY[var5] = var4;
         var4 += Rasterizer2D.graphicsPixelsWidth;
      }

   }

   @ObfuscatedName("s")
   static final void method1689(int[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(rasterClipEnable) {
         if(var5 > rasterClipX) {
            var5 = rasterClipX;
         }

         if(var4 < 0) {
            var4 = 0;
         }
      }

      if(var4 < var5) {
         var1 += var4;
         var6 += var7 * var4;
         int var8;
         int var9;
         int var10;
         if(rasterGouraudLowRes) {
            var3 = var5 - var4 >> 2;
            var7 <<= 2;
            if(rasterAlpha == 0) {
               if(var3 > 0) {
                  do {
                     var2 = colorPalette[var6 >> 8];
                     var6 += var7;
                     var0[var1++] = var2;
                     var0[var1++] = var2;
                     var0[var1++] = var2;
                     var0[var1++] = var2;
                     --var3;
                  } while(var3 > 0);
               }

               var3 = var5 - var4 & 3;
               if(var3 > 0) {
                  var2 = colorPalette[var6 >> 8];

                  do {
                     var0[var1++] = var2;
                     --var3;
                  } while(var3 > 0);
               }
            } else {
               var8 = rasterAlpha;
               var9 = 256 - rasterAlpha;
               if(var3 > 0) {
                  do {
                     var2 = colorPalette[var6 >> 8];
                     var6 += var7;
                     var2 = ((var2 & 16711935) * var9 >> 8 & 16711935) + ((var2 & '\uff00') * var9 >> 8 & '\uff00');
                     var10 = var0[var1];
                     var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                     var10 = var0[var1];
                     var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                     var10 = var0[var1];
                     var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                     var10 = var0[var1];
                     var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                     --var3;
                  } while(var3 > 0);
               }

               var3 = var5 - var4 & 3;
               if(var3 > 0) {
                  var2 = colorPalette[var6 >> 8];
                  var2 = ((var2 & 16711935) * var9 >> 8 & 16711935) + ((var2 & '\uff00') * var9 >> 8 & '\uff00');

                  do {
                     var10 = var0[var1];
                     var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                     --var3;
                  } while(var3 > 0);
               }
            }
         } else {
            var3 = var5 - var4;
            if(rasterAlpha == 0) {
               do {
                  var0[var1++] = colorPalette[var6 >> 8];
                  var6 += var7;
                  --var3;
               } while(var3 > 0);
            } else {
               var8 = rasterAlpha;
               var9 = 256 - rasterAlpha;

               do {
                  var2 = colorPalette[var6 >> 8];
                  var6 += var7;
                  var2 = ((var2 & 16711935) * var9 >> 8 & 16711935) + ((var2 & '\uff00') * var9 >> 8 & '\uff00');
                  var10 = var0[var1];
                  var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                  --var3;
               } while(var3 > 0);
            }
         }
      }

   }

   class84() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @Export("rasterTextureAffine")
   static final void rasterTextureAffine(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18) {
      int[] var19 = field1472.load(var18);
      int var20;
      if(var19 == null) {
         var20 = field1472.vmethod1942(var18);
         rasterGouraud(var0, var1, var2, var3, var4, var5, method1698(var20, var6), method1698(var20, var7), method1698(var20, var8));
      } else {
         field1454 = field1472.vmethod1941(var18);
         field1463 = field1472.vmethod1946(var18);
         var20 = var4 - var3;
         int var21 = var1 - var0;
         int var22 = var5 - var3;
         int var23 = var2 - var0;
         int var24 = var7 - var6;
         int var25 = var8 - var6;
         int var26 = 0;
         if(var1 != var0) {
            var26 = (var4 - var3 << 14) / (var1 - var0);
         }

         int var27 = 0;
         if(var2 != var1) {
            var27 = (var5 - var4 << 14) / (var2 - var1);
         }

         int var28 = 0;
         if(var2 != var0) {
            var28 = (var3 - var5 << 14) / (var0 - var2);
         }

         int var29 = var20 * var23 - var22 * var21;
         if(var29 != 0) {
            int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
            int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
            var10 = var9 - var10;
            var13 = var12 - var13;
            var16 = var15 - var16;
            var11 -= var9;
            var14 -= var12;
            var17 -= var15;
            int var32 = var11 * var12 - var14 * var9 << 14;
            int var33 = (int)(((long)(var14 * var15 - var17 * var12) << 3 << 14) / (long)field1461);
            int var34 = (int)(((long)(var17 * var9 - var11 * var15) << 14) / (long)field1461);
            int var35 = var10 * var12 - var13 * var9 << 14;
            int var36 = (int)(((long)(var13 * var15 - var16 * var12) << 3 << 14) / (long)field1461);
            int var37 = (int)(((long)(var16 * var9 - var10 * var15) << 14) / (long)field1461);
            int var38 = var13 * var11 - var10 * var14 << 14;
            int var39 = (int)(((long)(var16 * var14 - var13 * var17) << 3 << 14) / (long)field1461);
            int var40 = (int)(((long)(var10 * var17 - var16 * var11) << 14) / (long)field1461);
            int var41;
            if(var0 <= var1 && var0 <= var2) {
               if(var0 < field1465) {
                  if(var1 > field1465) {
                     var1 = field1465;
                  }

                  if(var2 > field1465) {
                     var2 = field1465;
                  }

                  var6 = (var6 << 9) - var30 * var3 + var30;
                  if(var1 < var2) {
                     var5 = var3 <<= 14;
                     if(var0 < 0) {
                        var5 -= var28 * var0;
                        var3 -= var26 * var0;
                        var6 -= var31 * var0;
                        var0 = 0;
                     }

                     var4 <<= 14;
                     if(var1 < 0) {
                        var4 -= var27 * var1;
                        var1 = 0;
                     }

                     var41 = var0 - field1455;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if(var0 != var1 && var28 < var26 || var0 == var1 && var28 > var27) {
                        var2 -= var1;
                        var1 -= var0;
                        var0 = rasterClipY[var0];

                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              while(true) {
                                 --var2;
                                 if(var2 < 0) {
                                    return;
                                 }

                                 method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                 var5 += var28;
                                 var4 += var27;
                                 var6 += var31;
                                 var0 += Rasterizer2D.graphicsPixelsWidth;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var28;
                           var3 += var26;
                           var6 += var31;
                           var0 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     var2 -= var1;
                     var1 -= var0;
                     var0 = rasterClipY[var0];

                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           while(true) {
                              --var2;
                              if(var2 < 0) {
                                 return;
                              }

                              method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                              var5 += var28;
                              var4 += var27;
                              var6 += var31;
                              var0 += Rasterizer2D.graphicsPixelsWidth;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                        var5 += var28;
                        var3 += var26;
                        var6 += var31;
                        var0 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  var4 = var3 <<= 14;
                  if(var0 < 0) {
                     var4 -= var28 * var0;
                     var3 -= var26 * var0;
                     var6 -= var31 * var0;
                     var0 = 0;
                  }

                  var5 <<= 14;
                  if(var2 < 0) {
                     var5 -= var27 * var2;
                     var2 = 0;
                  }

                  var41 = var0 - field1455;
                  var32 += var34 * var41;
                  var35 += var37 * var41;
                  var38 += var40 * var41;
                  if(var0 != var2 && var28 < var26 || var0 == var2 && var27 > var26) {
                     var1 -= var2;
                     var2 -= var0;
                     var0 = rasterClipY[var0];

                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           while(true) {
                              --var1;
                              if(var1 < 0) {
                                 return;
                              }

                              method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                              var5 += var27;
                              var3 += var26;
                              var6 += var31;
                              var0 += Rasterizer2D.graphicsPixelsWidth;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                        var4 += var28;
                        var3 += var26;
                        var6 += var31;
                        var0 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  var1 -= var2;
                  var2 -= var0;
                  var0 = rasterClipY[var0];

                  while(true) {
                     --var2;
                     if(var2 < 0) {
                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              return;
                           }

                           method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var27;
                           var3 += var26;
                           var6 += var31;
                           var0 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                     var4 += var28;
                     var3 += var26;
                     var6 += var31;
                     var0 += Rasterizer2D.graphicsPixelsWidth;
                     var32 += var34;
                     var35 += var37;
                     var38 += var40;
                  }
               }
            } else if(var1 <= var2) {
               if(var1 < field1465) {
                  if(var2 > field1465) {
                     var2 = field1465;
                  }

                  if(var0 > field1465) {
                     var0 = field1465;
                  }

                  var7 = (var7 << 9) - var30 * var4 + var30;
                  if(var2 < var0) {
                     var3 = var4 <<= 14;
                     if(var1 < 0) {
                        var3 -= var26 * var1;
                        var4 -= var27 * var1;
                        var7 -= var31 * var1;
                        var1 = 0;
                     }

                     var5 <<= 14;
                     if(var2 < 0) {
                        var5 -= var28 * var2;
                        var2 = 0;
                     }

                     var41 = var1 - field1455;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if(var1 != var2 && var26 < var27 || var1 == var2 && var26 > var28) {
                        var0 -= var2;
                        var2 -= var1;
                        var1 = rasterClipY[var1];

                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              while(true) {
                                 --var0;
                                 if(var0 < 0) {
                                    return;
                                 }

                                 method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                 var3 += var26;
                                 var5 += var28;
                                 var7 += var31;
                                 var1 += Rasterizer2D.graphicsPixelsWidth;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var3 += var26;
                           var4 += var27;
                           var7 += var31;
                           var1 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     var0 -= var2;
                     var2 -= var1;
                     var1 = rasterClipY[var1];

                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           while(true) {
                              --var0;
                              if(var0 < 0) {
                                 return;
                              }

                              method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                              var3 += var26;
                              var5 += var28;
                              var7 += var31;
                              var1 += Rasterizer2D.graphicsPixelsWidth;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                        var3 += var26;
                        var4 += var27;
                        var7 += var31;
                        var1 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  var5 = var4 <<= 14;
                  if(var1 < 0) {
                     var5 -= var26 * var1;
                     var4 -= var27 * var1;
                     var7 -= var31 * var1;
                     var1 = 0;
                  }

                  var3 <<= 14;
                  if(var0 < 0) {
                     var3 -= var28 * var0;
                     var0 = 0;
                  }

                  var41 = var1 - field1455;
                  var32 += var34 * var41;
                  var35 += var37 * var41;
                  var38 += var40 * var41;
                  if(var26 < var27) {
                     var2 -= var0;
                     var0 -= var1;
                     var1 = rasterClipY[var1];

                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           while(true) {
                              --var2;
                              if(var2 < 0) {
                                 return;
                              }

                              method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                              var3 += var28;
                              var4 += var27;
                              var7 += var31;
                              var1 += Rasterizer2D.graphicsPixelsWidth;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                        var5 += var26;
                        var4 += var27;
                        var7 += var31;
                        var1 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  var2 -= var0;
                  var0 -= var1;
                  var1 = rasterClipY[var1];

                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              return;
                           }

                           method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var3 += var28;
                           var4 += var27;
                           var7 += var31;
                           var1 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                     var5 += var26;
                     var4 += var27;
                     var7 += var31;
                     var1 += Rasterizer2D.graphicsPixelsWidth;
                     var32 += var34;
                     var35 += var37;
                     var38 += var40;
                  }
               }
            } else if(var2 < field1465) {
               if(var0 > field1465) {
                  var0 = field1465;
               }

               if(var1 > field1465) {
                  var1 = field1465;
               }

               var8 = (var8 << 9) - var30 * var5 + var30;
               if(var0 < var1) {
                  var4 = var5 <<= 14;
                  if(var2 < 0) {
                     var4 -= var27 * var2;
                     var5 -= var28 * var2;
                     var8 -= var31 * var2;
                     var2 = 0;
                  }

                  var3 <<= 14;
                  if(var0 < 0) {
                     var3 -= var26 * var0;
                     var0 = 0;
                  }

                  var41 = var2 - field1455;
                  var32 += var34 * var41;
                  var35 += var37 * var41;
                  var38 += var40 * var41;
                  if(var27 < var28) {
                     var1 -= var0;
                     var0 -= var2;
                     var2 = rasterClipY[var2];

                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           while(true) {
                              --var1;
                              if(var1 < 0) {
                                 return;
                              }

                              method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                              var4 += var27;
                              var3 += var26;
                              var8 += var31;
                              var2 += Rasterizer2D.graphicsPixelsWidth;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var4 += var27;
                        var5 += var28;
                        var8 += var31;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  var1 -= var0;
                  var0 -= var2;
                  var2 = rasterClipY[var2];

                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              return;
                           }

                           method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                           var4 += var27;
                           var3 += var26;
                           var8 += var31;
                           var2 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                     var4 += var27;
                     var5 += var28;
                     var8 += var31;
                     var2 += Rasterizer2D.graphicsPixelsWidth;
                     var32 += var34;
                     var35 += var37;
                     var38 += var40;
                  }
               }

               var3 = var5 <<= 14;
               if(var2 < 0) {
                  var3 -= var27 * var2;
                  var5 -= var28 * var2;
                  var8 -= var31 * var2;
                  var2 = 0;
               }

               var4 <<= 14;
               if(var1 < 0) {
                  var4 -= var26 * var1;
                  var1 = 0;
               }

               var41 = var2 - field1455;
               var32 += var34 * var41;
               var35 += var37 * var41;
               var38 += var40 * var41;
               if(var27 < var28) {
                  var0 -= var1;
                  var1 -= var2;
                  var2 = rasterClipY[var2];

                  while(true) {
                     --var1;
                     if(var1 < 0) {
                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              return;
                           }

                           method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                           var4 += var26;
                           var5 += var28;
                           var8 += var31;
                           var2 += Rasterizer2D.graphicsPixelsWidth;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }

                     method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                     var3 += var27;
                     var5 += var28;
                     var8 += var31;
                     var2 += Rasterizer2D.graphicsPixelsWidth;
                     var32 += var34;
                     var35 += var37;
                     var38 += var40;
                  }
               }

               var0 -= var1;
               var1 -= var2;
               var2 = rasterClipY[var2];

               while(true) {
                  --var1;
                  if(var1 < 0) {
                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           return;
                        }

                        method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var4 += var26;
                        var5 += var28;
                        var8 += var31;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }

                  method1703(Rasterizer2D.graphicsPixels, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                  var3 += var27;
                  var5 += var28;
                  var8 += var31;
                  var2 += Rasterizer2D.graphicsPixelsWidth;
                  var32 += var34;
                  var35 += var37;
                  var38 += var40;
               }
            }
         }
      }

   }

   @ObfuscatedName("z")
   static final int method1698(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("y")
   static final void method1703(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
      if(rasterClipEnable) {
         if(var6 > rasterClipX) {
            var6 = rasterClipX;
         }

         if(var5 < 0) {
            var5 = 0;
         }
      }

      if(var5 < var6) {
         var4 += var5;
         var7 += var8 * var5;
         int var15 = var6 - var5;
         int var16;
         int var10000;
         int var18;
         int var19;
         int var20;
         int var21;
         int var22;
         int var23;
         int var24;
         if(field1454) {
            var24 = var5 - field1456;
            var9 += (var12 >> 3) * var24;
            var10 += (var13 >> 3) * var24;
            var11 += (var14 >> 3) * var24;
            var23 = var11 >> 12;
            if(var23 != 0) {
               var19 = var9 / var23;
               var20 = var10 / var23;
               if(var19 < 0) {
                  var19 = 0;
               } else if(var19 > 4032) {
                  var19 = 4032;
               }
            } else {
               var19 = 0;
               var20 = 0;
            }

            var9 += var12;
            var10 += var13;
            var11 += var14;
            var23 = var11 >> 12;
            if(var23 != 0) {
               var21 = var9 / var23;
               var22 = var10 / var23;
               if(var21 < 0) {
                  var21 = 0;
               } else if(var21 > 4032) {
                  var21 = 4032;
               }
            } else {
               var21 = 0;
               var22 = 0;
            }

            var2 = (var19 << 20) + var20;
            var18 = (var21 - var19 >> 3 << 20) + (var22 - var20 >> 3);
            var15 >>= 3;
            var8 <<= 3;
            var16 = var7 >> 8;
            if(field1463) {
               if(var15 > 0) {
                  do {
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var10000 = var2 + var18;
                     var19 = var21;
                     var20 = var22;
                     var9 += var12;
                     var10 += var13;
                     var11 += var14;
                     var23 = var11 >> 12;
                     if(var23 != 0) {
                        var21 = var9 / var23;
                        var22 = var10 / var23;
                        if(var21 < 0) {
                           var21 = 0;
                        } else if(var21 > 4032) {
                           var21 = 4032;
                        }
                     } else {
                        var21 = 0;
                        var22 = 0;
                     }

                     var2 = (var19 << 20) + var20;
                     var18 = (var21 - var19 >> 3 << 20) + (var22 - var20 >> 3);
                     var7 += var8;
                     var16 = var7 >> 8;
                     --var15;
                  } while(var15 > 0);
               }

               var15 = var6 - var5 & 7;
               if(var15 > 0) {
                  do {
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     --var15;
                  } while(var15 > 0);
               }
            } else {
               if(var15 > 0) {
                  do {
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var10000 = var2 + var18;
                     var19 = var21;
                     var20 = var22;
                     var9 += var12;
                     var10 += var13;
                     var11 += var14;
                     var23 = var11 >> 12;
                     if(var23 != 0) {
                        var21 = var9 / var23;
                        var22 = var10 / var23;
                        if(var21 < 0) {
                           var21 = 0;
                        } else if(var21 > 4032) {
                           var21 = 4032;
                        }
                     } else {
                        var21 = 0;
                        var22 = 0;
                     }

                     var2 = (var19 << 20) + var20;
                     var18 = (var21 - var19 >> 3 << 20) + (var22 - var20 >> 3);
                     var7 += var8;
                     var16 = var7 >> 8;
                     --var15;
                  } while(var15 > 0);
               }

               var15 = var6 - var5 & 7;
               if(var15 > 0) {
                  do {
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     --var15;
                  } while(var15 > 0);
               }
            }
         } else {
            var24 = var5 - field1456;
            var9 += (var12 >> 3) * var24;
            var10 += (var13 >> 3) * var24;
            var11 += (var14 >> 3) * var24;
            var23 = var11 >> 14;
            if(var23 != 0) {
               var19 = var9 / var23;
               var20 = var10 / var23;
               if(var19 < 0) {
                  var19 = 0;
               } else if(var19 > 16256) {
                  var19 = 16256;
               }
            } else {
               var19 = 0;
               var20 = 0;
            }

            var9 += var12;
            var10 += var13;
            var11 += var14;
            var23 = var11 >> 14;
            if(var23 != 0) {
               var21 = var9 / var23;
               var22 = var10 / var23;
               if(var21 < 0) {
                  var21 = 0;
               } else if(var21 > 16256) {
                  var21 = 16256;
               }
            } else {
               var21 = 0;
               var22 = 0;
            }

            var2 = (var19 << 18) + var20;
            var18 = (var21 - var19 >> 3 << 18) + (var22 - var20 >> 3);
            var15 >>= 3;
            var8 <<= 3;
            var16 = var7 >> 8;
            if(field1463) {
               if(var15 > 0) {
                  do {
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var10000 = var2 + var18;
                     var19 = var21;
                     var20 = var22;
                     var9 += var12;
                     var10 += var13;
                     var11 += var14;
                     var23 = var11 >> 14;
                     if(var23 != 0) {
                        var21 = var9 / var23;
                        var22 = var10 / var23;
                        if(var21 < 0) {
                           var21 = 0;
                        } else if(var21 > 16256) {
                           var21 = 16256;
                        }
                     } else {
                        var21 = 0;
                        var22 = 0;
                     }

                     var2 = (var19 << 18) + var20;
                     var18 = (var21 - var19 >> 3 << 18) + (var22 - var20 >> 3);
                     var7 += var8;
                     var16 = var7 >> 8;
                     --var15;
                  } while(var15 > 0);
               }

               var15 = var6 - var5 & 7;
               if(var15 > 0) {
                  do {
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     var2 += var18;
                     --var15;
                  } while(var15 > 0);
               }
            } else {
               if(var15 > 0) {
                  do {
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var10000 = var2 + var18;
                     var19 = var21;
                     var20 = var22;
                     var9 += var12;
                     var10 += var13;
                     var11 += var14;
                     var23 = var11 >> 14;
                     if(var23 != 0) {
                        var21 = var9 / var23;
                        var22 = var10 / var23;
                        if(var21 < 0) {
                           var21 = 0;
                        } else if(var21 > 16256) {
                           var21 = 16256;
                        }
                     } else {
                        var21 = 0;
                        var22 = 0;
                     }

                     var2 = (var19 << 18) + var20;
                     var18 = (var21 - var19 >> 3 << 18) + (var22 - var20 >> 3);
                     var7 += var8;
                     var16 = var7 >> 8;
                     --var15;
                  } while(var15 > 0);
               }

               var15 = var6 - var5 & 7;
               if(var15 > 0) {
                  do {
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var16 & -16711936) + ((var3 & '\uff00') * var16 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var18;
                     --var15;
                  } while(var15 > 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @Export("rasterGouraud")
   static final void rasterGouraud(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = var4 - var3;
      int var10 = var1 - var0;
      int var11 = var5 - var3;
      int var12 = var2 - var0;
      int var13 = var7 - var6;
      int var14 = var8 - var6;
      int var15;
      if(var2 != var1) {
         var15 = (var5 - var4 << 14) / (var2 - var1);
      } else {
         var15 = 0;
      }

      int var16;
      if(var1 != var0) {
         var16 = (var9 << 14) / var10;
      } else {
         var16 = 0;
      }

      int var17;
      if(var2 != var0) {
         var17 = (var11 << 14) / var12;
      } else {
         var17 = 0;
      }

      int var18 = var9 * var12 - var11 * var10;
      if(var18 != 0) {
         int var19 = (var13 * var12 - var14 * var10 << 8) / var18;
         int var20 = (var14 * var9 - var13 * var11 << 8) / var18;
         if(var0 <= var1 && var0 <= var2) {
            if(var0 < field1465) {
               if(var1 > field1465) {
                  var1 = field1465;
               }

               if(var2 > field1465) {
                  var2 = field1465;
               }

               var6 = (var6 << 8) - var19 * var3 + var19;
               if(var1 < var2) {
                  var5 = var3 <<= 14;
                  if(var0 < 0) {
                     var5 -= var17 * var0;
                     var3 -= var16 * var0;
                     var6 -= var20 * var0;
                     var0 = 0;
                  }

                  var4 <<= 14;
                  if(var1 < 0) {
                     var4 -= var15 * var1;
                     var1 = 0;
                  }

                  if(var0 != var1 && var17 < var16 || var0 == var1 && var17 > var15) {
                     var2 -= var1;
                     var1 -= var0;
                     var0 = rasterClipY[var0];

                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           while(true) {
                              --var2;
                              if(var2 < 0) {
                                 return;
                              }

                              method1689(Rasterizer2D.graphicsPixels, var0, 0, 0, var5 >> 14, var4 >> 14, var6, var19);
                              var5 += var17;
                              var4 += var15;
                              var6 += var20;
                              var0 += Rasterizer2D.graphicsPixelsWidth;
                           }
                        }

                        method1689(Rasterizer2D.graphicsPixels, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
                        var5 += var17;
                        var3 += var16;
                        var6 += var20;
                        var0 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  var2 -= var1;
                  var1 -= var0;
                  var0 = rasterClipY[var0];

                  while(true) {
                     --var1;
                     if(var1 < 0) {
                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              return;
                           }

                           method1689(Rasterizer2D.graphicsPixels, var0, 0, 0, var4 >> 14, var5 >> 14, var6, var19);
                           var5 += var17;
                           var4 += var15;
                           var6 += var20;
                           var0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method1689(Rasterizer2D.graphicsPixels, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
                     var5 += var17;
                     var3 += var16;
                     var6 += var20;
                     var0 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               var4 = var3 <<= 14;
               if(var0 < 0) {
                  var4 -= var17 * var0;
                  var3 -= var16 * var0;
                  var6 -= var20 * var0;
                  var0 = 0;
               }

               var5 <<= 14;
               if(var2 < 0) {
                  var5 -= var15 * var2;
                  var2 = 0;
               }

               if((var0 == var2 || var17 >= var16) && (var0 != var2 || var15 <= var16)) {
                  var1 -= var2;
                  var2 -= var0;
                  var0 = rasterClipY[var0];

                  while(true) {
                     --var2;
                     if(var2 < 0) {
                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              return;
                           }

                           method1689(Rasterizer2D.graphicsPixels, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
                           var5 += var15;
                           var3 += var16;
                           var6 += var20;
                           var0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method1689(Rasterizer2D.graphicsPixels, var0, 0, 0, var3 >> 14, var4 >> 14, var6, var19);
                     var4 += var17;
                     var3 += var16;
                     var6 += var20;
                     var0 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               var1 -= var2;
               var2 -= var0;
               var0 = rasterClipY[var0];

               while(true) {
                  --var2;
                  if(var2 < 0) {
                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           return;
                        }

                        method1689(Rasterizer2D.graphicsPixels, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
                        var5 += var15;
                        var3 += var16;
                        var6 += var20;
                        var0 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method1689(Rasterizer2D.graphicsPixels, var0, 0, 0, var4 >> 14, var3 >> 14, var6, var19);
                  var4 += var17;
                  var3 += var16;
                  var6 += var20;
                  var0 += Rasterizer2D.graphicsPixelsWidth;
               }
            }
         } else if(var1 <= var2) {
            if(var1 < field1465) {
               if(var2 > field1465) {
                  var2 = field1465;
               }

               if(var0 > field1465) {
                  var0 = field1465;
               }

               var7 = (var7 << 8) - var19 * var4 + var19;
               if(var2 < var0) {
                  var3 = var4 <<= 14;
                  if(var1 < 0) {
                     var3 -= var16 * var1;
                     var4 -= var15 * var1;
                     var7 -= var20 * var1;
                     var1 = 0;
                  }

                  var5 <<= 14;
                  if(var2 < 0) {
                     var5 -= var17 * var2;
                     var2 = 0;
                  }

                  if(var1 != var2 && var16 < var15 || var1 == var2 && var16 > var17) {
                     var0 -= var2;
                     var2 -= var1;
                     var1 = rasterClipY[var1];

                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           while(true) {
                              --var0;
                              if(var0 < 0) {
                                 return;
                              }

                              method1689(Rasterizer2D.graphicsPixels, var1, 0, 0, var3 >> 14, var5 >> 14, var7, var19);
                              var3 += var16;
                              var5 += var17;
                              var7 += var20;
                              var1 += Rasterizer2D.graphicsPixelsWidth;
                           }
                        }

                        method1689(Rasterizer2D.graphicsPixels, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
                        var3 += var16;
                        var4 += var15;
                        var7 += var20;
                        var1 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  var0 -= var2;
                  var2 -= var1;
                  var1 = rasterClipY[var1];

                  while(true) {
                     --var2;
                     if(var2 < 0) {
                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              return;
                           }

                           method1689(Rasterizer2D.graphicsPixels, var1, 0, 0, var5 >> 14, var3 >> 14, var7, var19);
                           var3 += var16;
                           var5 += var17;
                           var7 += var20;
                           var1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method1689(Rasterizer2D.graphicsPixels, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
                     var3 += var16;
                     var4 += var15;
                     var7 += var20;
                     var1 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               var5 = var4 <<= 14;
               if(var1 < 0) {
                  var5 -= var16 * var1;
                  var4 -= var15 * var1;
                  var7 -= var20 * var1;
                  var1 = 0;
               }

               var3 <<= 14;
               if(var0 < 0) {
                  var3 -= var17 * var0;
                  var0 = 0;
               }

               if(var16 < var15) {
                  var2 -= var0;
                  var0 -= var1;
                  var1 = rasterClipY[var1];

                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              return;
                           }

                           method1689(Rasterizer2D.graphicsPixels, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
                           var3 += var17;
                           var4 += var15;
                           var7 += var20;
                           var1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method1689(Rasterizer2D.graphicsPixels, var1, 0, 0, var5 >> 14, var4 >> 14, var7, var19);
                     var5 += var16;
                     var4 += var15;
                     var7 += var20;
                     var1 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               var2 -= var0;
               var0 -= var1;
               var1 = rasterClipY[var1];

               while(true) {
                  --var0;
                  if(var0 < 0) {
                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           return;
                        }

                        method1689(Rasterizer2D.graphicsPixels, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
                        var3 += var17;
                        var4 += var15;
                        var7 += var20;
                        var1 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method1689(Rasterizer2D.graphicsPixels, var1, 0, 0, var4 >> 14, var5 >> 14, var7, var19);
                  var5 += var16;
                  var4 += var15;
                  var7 += var20;
                  var1 += Rasterizer2D.graphicsPixelsWidth;
               }
            }
         } else if(var2 < field1465) {
            if(var0 > field1465) {
               var0 = field1465;
            }

            if(var1 > field1465) {
               var1 = field1465;
            }

            var8 = (var8 << 8) - var19 * var5 + var19;
            if(var0 < var1) {
               var4 = var5 <<= 14;
               if(var2 < 0) {
                  var4 -= var15 * var2;
                  var5 -= var17 * var2;
                  var8 -= var20 * var2;
                  var2 = 0;
               }

               var3 <<= 14;
               if(var0 < 0) {
                  var3 -= var16 * var0;
                  var0 = 0;
               }

               if(var15 < var17) {
                  var1 -= var0;
                  var0 -= var2;
                  var2 = rasterClipY[var2];

                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              return;
                           }

                           method1689(Rasterizer2D.graphicsPixels, var2, 0, 0, var4 >> 14, var3 >> 14, var8, var19);
                           var4 += var15;
                           var3 += var16;
                           var8 += var20;
                           var2 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method1689(Rasterizer2D.graphicsPixels, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
                     var4 += var15;
                     var5 += var17;
                     var8 += var20;
                     var2 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               var1 -= var0;
               var0 -= var2;
               var2 = rasterClipY[var2];

               while(true) {
                  --var0;
                  if(var0 < 0) {
                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           return;
                        }

                        method1689(Rasterizer2D.graphicsPixels, var2, 0, 0, var3 >> 14, var4 >> 14, var8, var19);
                        var4 += var15;
                        var3 += var16;
                        var8 += var20;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method1689(Rasterizer2D.graphicsPixels, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
                  var4 += var15;
                  var5 += var17;
                  var8 += var20;
                  var2 += Rasterizer2D.graphicsPixelsWidth;
               }
            }

            var3 = var5 <<= 14;
            if(var2 < 0) {
               var3 -= var15 * var2;
               var5 -= var17 * var2;
               var8 -= var20 * var2;
               var2 = 0;
            }

            var4 <<= 14;
            if(var1 < 0) {
               var4 -= var16 * var1;
               var1 = 0;
            }

            if(var15 < var17) {
               var0 -= var1;
               var1 -= var2;
               var2 = rasterClipY[var2];

               while(true) {
                  --var1;
                  if(var1 < 0) {
                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           return;
                        }

                        method1689(Rasterizer2D.graphicsPixels, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
                        var4 += var16;
                        var5 += var17;
                        var8 += var20;
                        var2 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method1689(Rasterizer2D.graphicsPixels, var2, 0, 0, var3 >> 14, var5 >> 14, var8, var19);
                  var3 += var15;
                  var5 += var17;
                  var8 += var20;
                  var2 += Rasterizer2D.graphicsPixelsWidth;
               }
            }

            var0 -= var1;
            var1 -= var2;
            var2 = rasterClipY[var2];

            while(true) {
               --var1;
               if(var1 < 0) {
                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        return;
                     }

                     method1689(Rasterizer2D.graphicsPixels, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
                     var4 += var16;
                     var5 += var17;
                     var8 += var20;
                     var2 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }

               method1689(Rasterizer2D.graphicsPixels, var2, 0, 0, var5 >> 14, var3 >> 14, var8, var19);
               var3 += var15;
               var5 += var17;
               var8 += var20;
               var2 += Rasterizer2D.graphicsPixelsWidth;
            }
         }
      }

   }

   static {
      int var0;
      for(var0 = 1; var0 < 512; ++var0) {
         field1473[var0] = '耀' / var0;
      }

      for(var0 = 1; var0 < 2048; ++var0) {
         field1474[var0] = 65536 / var0;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         field1475[var0] = (int)(65536.0D * Math.sin((double)var0 * 0.0030679615D));
         field1469[var0] = (int)(65536.0D * Math.cos((double)var0 * 0.0030679615D));
      }

   }
}
