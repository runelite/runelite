import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class178 {
   @ObfuscatedName("w")
   public final String field2680;
   @ObfuscatedName("d")
   public static final class178 field2681 = new class178("BUILDLIVE", 3);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2080616335
   )
   public final int field2682;
   @ObfuscatedName("h")
   public static final class178 field2683 = new class178("WIP", 2);
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -1030992075
   )
   static int field2685;
   @ObfuscatedName("n")
   public static final class178 field2686 = new class178("LIVE", 0);
   @ObfuscatedName("m")
   public static final class178 field2687 = new class178("RC", 1);
   @ObfuscatedName("b")
   static String field2688;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "-45"
   )
   static int method3312(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;B)V",
      garbageValue = "-84"
   )
   static final void method3313(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class11.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class11.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2305(var3, var4);
                  }
               }
            }
         }
      }

      class11.field111 += (int)(Math.random() * 5.0D) - 2;
      if(class11.field111 < -8) {
         class11.field111 = -8;
      }

      if(class11.field111 > 8) {
         class11.field111 = 8;
      }

      class11.field115 += (int)(Math.random() * 5.0D) - 2;
      if(class11.field115 < -16) {
         class11.field115 = -16;
      }

      if(class11.field115 > 16) {
         class11.field115 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var44;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var45 = class5.field51[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class11.tileHeights[var2][1 + var12][var11] - class11.tileHeights[var2][var12 - 1][var11];
               var14 = class11.tileHeights[var2][var12][1 + var11] - class11.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(65536 + var13 * var13 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var44 = (var14 << 8) / var15;
               var19 = 96 + (-50 * var44 + var16 * -50 + -10 * var17) / var10;
               var20 = (var45[1 + var12][var11] >> 3) + (var45[var12 - 1][var11] >> 2) + (var45[var12][var11 - 1] >> 2) + (var45[var12][1 + var11] >> 3) + (var45[var12][var11] >> 1);
               class48.field933[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class162.field2307[var11] = 0;
            class107.field1728[var11] = 0;
            class205.field3075[var11] = 0;
            class72.field1179[var11] = 0;
            class202.field3064[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = 5 + var11;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class11.field105[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class191 var46 = (class191)class191.field2811.get((long)var16);
                     class191 var47;
                     if(null != var46) {
                        var47 = var46;
                     } else {
                        byte[] var18 = class191.field2812.method3329(1, var16);
                        var46 = new class191();
                        if(var18 != null) {
                           var46.method3529(new Buffer(var18), var16);
                        }

                        var46.method3536();
                        class191.field2811.put(var46, (long)var16);
                        var47 = var46;
                     }

                     class162.field2307[var12] += var47.field2814;
                     class107.field1728[var12] += var47.field2815;
                     class205.field3075[var12] += var47.field2816;
                     class72.field1179[var12] += var47.field2817;
                     ++class202.field3064[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class11.field105[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     class191 var55 = (class191)class191.field2811.get((long)var17);
                     class191 var48;
                     if(null != var55) {
                        var48 = var55;
                     } else {
                        byte[] var53 = class191.field2812.method3329(1, var17);
                        var55 = new class191();
                        if(var53 != null) {
                           var55.method3529(new Buffer(var53), var17);
                        }

                        var55.method3536();
                        class191.field2811.put(var55, (long)var17);
                        var48 = var55;
                     }

                     class162.field2307[var12] -= var48.field2814;
                     class107.field1728[var12] -= var48.field2815;
                     class205.field3075[var12] -= var48.field2816;
                     class72.field1179[var12] -= var48.field2817;
                     --class202.field3064[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var44 = 5 + var17;
                  if(var44 >= 0 && var44 < 104) {
                     var12 += class162.field2307[var44];
                     var13 += class107.field1728[var44];
                     var14 += class205.field3075[var44];
                     var15 += class72.field1179[var44];
                     var16 += class202.field3064[var44];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class162.field2307[var19];
                     var13 -= class107.field1728[var19];
                     var14 -= class205.field3075[var19];
                     var15 -= class72.field1179[var19];
                     var16 -= class202.field3064[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field288 || (class11.tileSettings[0][var11][var17] & 2) != 0 || (class11.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class11.field102) {
                        class11.field102 = var2;
                     }

                     var20 = class11.field105[var2][var11][var17] & 255;
                     int var21 = class11.field106[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class11.tileHeights[var2][var11][var17];
                        int var23 = class11.tileHeights[var2][1 + var11][var17];
                        int var24 = class11.tileHeights[var2][var11 + 1][1 + var17];
                        int var25 = class11.tileHeights[var2][var11][var17 + 1];
                        int var26 = class48.field933[var11][var17];
                        int var27 = class48.field933[var11 + 1][var17];
                        int var28 = class48.field933[1 + var11][var17 + 1];
                        int var29 = class48.field933[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var34;
                        int var50;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var50 = var13 / var16;
                           var34 = var14 / var16;
                           var30 = class156.method2956(var32, var50, var34);
                           var32 = var32 + class11.field111 & 255;
                           var34 += class11.field115;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class156.method2956(var32, var50, var34);
                        }

                        class200 var35;
                        if(var2 > 0) {
                           boolean var56 = true;
                           if(var20 == 0 && class38.field797[var2][var11][var17] != 0) {
                              var56 = false;
                           }

                           if(var21 > 0) {
                              var34 = var21 - 1;
                              var35 = (class200)class200.field3038.get((long)var34);
                              class200 var33;
                              if(var35 != null) {
                                 var33 = var35;
                              } else {
                                 byte[] var51 = class200.field3032.method3329(4, var34);
                                 var35 = new class200();
                                 if(var51 != null) {
                                    var35.method3782(new Buffer(var51), var34);
                                 }

                                 var35.method3781();
                                 class200.field3038.put(var35, (long)var34);
                                 var33 = var35;
                              }

                              if(!var33.field3033) {
                                 var56 = false;
                              }
                           }

                           if(var56 && var22 == var23 && var22 == var24 && var22 == var25) {
                              class187.field2778[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class84.colorPalette[class40.method784(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1869(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class40.method784(var30, var26), class40.method784(var30, var27), class40.method784(var30, var28), class40.method784(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var50 = 1 + class38.field797[var2][var11][var17];
                           byte var57 = class11.field107[var2][var11][var17];
                           int var36 = var21 - 1;
                           class200 var37 = (class200)class200.field3038.get((long)var36);
                           if(var37 != null) {
                              var35 = var37;
                           } else {
                              byte[] var52 = class200.field3032.method3329(4, var36);
                              var37 = new class200();
                              if(null != var52) {
                                 var37.method3782(new Buffer(var52), var36);
                              }

                              var37.method3781();
                              class200.field3038.put(var37, (long)var36);
                              var35 = var37;
                           }

                           int var38 = var35.field3039;
                           int var39;
                           int var40;
                           int var41;
                           int var42;
                           if(var38 >= 0) {
                              var40 = class84.field1441.vmethod1934(var38);
                              var39 = -1;
                           } else if(var35.field3030 == 16711935) {
                              var39 = -2;
                              var38 = -1;
                              var40 = -2;
                           } else {
                              var39 = class156.method2956(var35.field3035, var35.field3036, var35.field3037);
                              var41 = class11.field111 + var35.field3035 & 255;
                              var42 = var35.field3037 + class11.field115;
                              if(var42 < 0) {
                                 var42 = 0;
                              } else if(var42 > 255) {
                                 var42 = 255;
                              }

                              var40 = class156.method2956(var41, var35.field3036, var42);
                           }

                           var41 = 0;
                           if(var40 != -2) {
                              var41 = class84.colorPalette[class118.method2338(var40, 96)];
                           }

                           if(var35.field3034 != -1) {
                              var42 = class11.field111 + var35.field3031 & 255;
                              int var43 = class11.field115 + var35.field3040;
                              if(var43 < 0) {
                                 var43 = 0;
                              } else if(var43 > 255) {
                                 var43 = 255;
                              }

                              var40 = class156.method2956(var42, var35.field3029, var43);
                              var41 = class84.colorPalette[class118.method2338(var40, 96)];
                           }

                           var0.method1869(var2, var11, var17, var50, var57, var38, var22, var23, var24, var25, class40.method784(var30, var26), class40.method784(var30, var27), class40.method784(var30, var28), class40.method784(var30, var29), class118.method2338(var39, var26), class118.method2338(var39, var27), class118.method2338(var39, var28), class118.method2338(var39, var29), var32, var41);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class11.tileSettings[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class11.tileSettings[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.method1872(var2, var12, var11, var17);
            }
         }

         class11.field105[var2] = null;
         class11.field106[var2] = null;
         class38.field797[var2] = null;
         class11.field107[var2] = null;
         class5.field51[var2] = null;
      }

      var0.method1771(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class11.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method1817(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var54;
                  if((class187.field2778[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class187.field2778[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class187.field2778[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label599:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class187.field2778[var11 - 1][var8][var13] & var2) == 0) {
                              break label599;
                           }
                        }

                        --var11;
                     }

                     label588:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class187.field2778[1 + var12][var8][var13] & var2) == 0) {
                              break label588;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + var12 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var54 = 240;
                        var15 = class11.tileHeights[var12][var8][var9] - var54;
                        var16 = class11.tileHeights[var11][var8][var9];
                        Region.method1743(var5, 1, var8 * 128, var8 * 128, 128 * var9, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var44 = var9; var44 <= var10; ++var44) {
                              class187.field2778[var17][var8][var44] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class187.field2778[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class187.field2778[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class187.field2778[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label652:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class187.field2778[var11 - 1][var13][var7] & var3) == 0) {
                              break label652;
                           }
                        }

                        --var11;
                     }

                     label641:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class187.field2778[1 + var12][var13][var7] & var3) == 0) {
                              break label641;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var54 = 240;
                        var15 = class11.tileHeights[var12][var9][var7] - var54;
                        var16 = class11.tileHeights[var11][var9][var7];
                        Region.method1743(var5, 2, var9 * 128, 128 * var10 + 128, var7 * 128, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var44 = var9; var44 <= var10; ++var44) {
                              class187.field2778[var17][var44][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class187.field2778[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class187.field2778[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class187.field2778[var6][var8][1 + var12] & var4) != 0) {
                        ++var12;
                     }

                     label705:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class187.field2778[var6][var9 - 1][var13] & var4) == 0) {
                              break label705;
                           }
                        }

                        --var9;
                     }

                     label694:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class187.field2778[var6][var10 + 1][var13] & var4) == 0) {
                              break label694;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var10 - var9)) * (1 + (var12 - var11)) >= 4) {
                        var13 = class11.tileHeights[var6][var9][var11];
                        Region.method1743(var5, 4, 128 * var9, var10 * 128 + 128, var11 * 128, 128 * var12 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class187.field2778[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class178(String var1, int var2) {
      this.field2680 = var1;
      this.field2682 = var2;
   }
}
