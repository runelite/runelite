package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ah")
public class class41 extends class203 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1275187587
   )
   public int field956;
   @ObfuscatedName("m")
   static class192 field957 = new class192(64);
   @ObfuscatedName("bz")
   static String field959;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 719208177
   )
   public int field960;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1570244211
   )
   public int field961;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -580023419
   )
   public int field962;
   @ObfuscatedName("j")
   static class166 field963;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 1340255281
   )
   static int field964;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -521330709
   )
   int field968 = 0;

   @ObfuscatedName("a")
   void method884(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field960 = (int)(var14 * 256.0D);
      this.field961 = (int)(256.0D * var16);
      if(this.field960 < 0) {
         this.field960 = 0;
      } else if(this.field960 > 255) {
         this.field960 = 255;
      }

      if(this.field961 < 0) {
         this.field961 = 0;
      } else if(this.field961 > 255) {
         this.field961 = 255;
      }

      if(var16 > 0.5D) {
         this.field962 = (int)(512.0D * (1.0D - var16) * var14);
      } else {
         this.field962 = (int)(var14 * var16 * 512.0D);
      }

      if(this.field962 < 1) {
         this.field962 = 1;
      }

      this.field956 = (int)((double)this.field962 * var12);
   }

   @ObfuscatedName("f")
   void method885() {
      this.method884(this.field968);
   }

   @ObfuscatedName("l")
   void method886(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(var2 == 0) {
            return;
         }

         this.method887(var1, var2);
      }
   }

   @ObfuscatedName("u")
   void method887(class118 var1, int var2) {
      if(1 == var2) {
         this.field968 = var1.method2540();
      }

   }

   @ObfuscatedName("f")
   public static class80[] method896(class166 var0, String var1, String var2) {
      int var3 = var0.method3327(var1);
      int var4 = var0.method3323(var3, var2);
      class80[] var5;
      if(!class46.method1007(var0, var3, var4)) {
         var5 = null;
      } else {
         class80[] var7 = new class80[class76.field1379];

         for(int var8 = 0; var8 < class76.field1379; ++var8) {
            class80 var9 = var7[var8] = new class80();
            var9.field1413 = class76.field1367;
            var9.field1414 = class76.field1368;
            var9.field1411 = class76.field1366[var8];
            var9.field1409 = class76.field1370[var8];
            var9.field1407 = class76.field1371[var8];
            var9.field1410 = class76.field1373[var8];
            var9.field1412 = class76.field1369;
            var9.field1408 = class17.field236[var8];
         }

         class135.method2935();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("j")
   public static void method903(class166 var0, int var1, int var2, int var3, boolean var4) {
      class182.field2940 = 1;
      class188.field3038 = var0;
      class182.field2945 = var1;
      class35.field778 = var2;
      class182.field2942 = var3;
      class158.field2586 = var4;
      class173.field2874 = 10000;
   }

   @ObfuscatedName("k")
   static final void method904(class85 var0, class107[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if(1 == (class5.field86[var2][var3][var4] & 1)) {
                  var5 = var2;
                  if(2 == (class5.field86[1][var3][var4] & 2)) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2424(var3, var4);
                  }
               }
            }
         }
      }

      class5.field88 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field88 < -8) {
         class5.field88 = -8;
      }

      if(class5.field88 > 8) {
         class5.field88 = 8;
      }

      class5.field89 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field89 < -16) {
         class5.field89 = -16;
      }

      if(class5.field89 > 16) {
         class5.field89 = 16;
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
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class150.field2239[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = 768 * var9 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class5.field79[var2][var12 + 1][var11] - class5.field79[var2][var12 - 1][var11];
               var14 = class5.field79[var2][var12][var11 + 1] - class5.field79[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + 65536 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (-50 * var16 + var17 * -10 + var18 * -50) / var10 + 96;
               var20 = (var42[var12 + 1][var11] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12][1 + var11] >> 3) + (var42[var12][var11] >> 1);
               class5.field77[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class5.field75[var11] = 0;
            class34.field764[var11] = 0;
            class157.field2573[var11] = 0;
            class219.field3156[var11] = 0;
            class5.field73[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = 5 + var11;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class5.field85[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     class41 var43 = class97.method2215(var14 - 1);
                     class5.field75[var12] += var43.field956;
                     class34.field764[var12] += var43.field960;
                     class157.field2573[var12] += var43.field961;
                     class219.field3156[var12] += var43.field962;
                     ++class5.field73[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class5.field85[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     class41 var44 = class97.method2215(var15 - 1);
                     class5.field75[var12] -= var44.field956;
                     class34.field764[var12] -= var44.field960;
                     class157.field2573[var12] -= var44.field961;
                     class219.field3156[var12] -= var44.field962;
                     --class5.field73[var12];
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
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class5.field75[var18];
                     var13 += class34.field764[var18];
                     var14 += class157.field2573[var18];
                     var15 += class219.field3156[var18];
                     var16 += class5.field73[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class5.field75[var19];
                     var13 -= class34.field764[var19];
                     var14 -= class157.field2573[var19];
                     var15 -= class219.field3156[var19];
                     var16 -= class5.field73[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!client.field527 || (class5.field86[0][var11][var17] & 2) != 0 || 0 == (class5.field86[var2][var11][var17] & 16))) {
                     if(var2 < class5.field74) {
                        class5.field74 = var2;
                     }

                     var20 = class5.field85[var2][var11][var17] & 255;
                     int var21 = class164.field2645[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.field79[var2][var11][var17];
                        int var23 = class5.field79[var2][1 + var11][var17];
                        int var24 = class5.field79[var2][var11 + 1][var17 + 1];
                        int var25 = class5.field79[var2][var11][1 + var17];
                        int var26 = class5.field77[var11][var17];
                        int var27 = class5.field77[1 + var11][var17];
                        int var28 = class5.field77[1 + var11][1 + var17];
                        int var29 = class5.field77[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class132.method2889(var32, var33, var34);
                           var32 = class5.field88 + var32 & 255;
                           var34 += class5.field89;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class132.method2889(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var46 = true;
                           if(var20 == 0 && class5.field76[var2][var11][var17] != 0) {
                              var46 = false;
                           }

                           if(var21 > 0 && !class76.method1696(var21 - 1).field1032) {
                              var46 = false;
                           }

                           if(var46 && var22 == var23 && var24 == var22 && var22 == var25) {
                              class29.field677[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class90.field1568[class163.method3282(var31, 96)];
                        }

                        if(0 == var21) {
                           var0.method2004(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class163.method3282(var30, var26), class163.method3282(var30, var27), class163.method3282(var30, var28), class163.method3282(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = 1 + class5.field76[var2][var11][var17];
                           byte var47 = class133.field2058[var2][var11][var17];
                           class46 var35 = class76.method1696(var21 - 1);
                           int var36 = var35.field1038;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class90.field1569.vmethod2187(var36);
                              var37 = -1;
                           } else if(var35.field1041 == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class132.method2889(var35.field1034, var35.field1039, var35.field1040);
                              var39 = class5.field88 + var35.field1034 & 255;
                              var40 = class5.field89 + var35.field1040;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class132.method2889(var39, var35.field1039, var40);
                           }

                           var39 = 0;
                           if(-2 != var38) {
                              var39 = class90.field1568[class17.method215(var38, 96)];
                           }

                           if(var35.field1036 != -1) {
                              var40 = var35.field1037 + class5.field88 & 255;
                              int var41 = var35.field1043 + class5.field89;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class132.method2889(var40, var35.field1042, var41);
                              var39 = class90.field1568[class17.method215(var38, 96)];
                           }

                           var0.method2004(var2, var11, var17, var33, var47, var36, var22, var23, var24, var25, class163.method3282(var30, var26), class163.method3282(var30, var27), class163.method3282(var30, var28), class163.method3282(var30, var29), class17.method215(var37, var26), class17.method215(var37, var27), class17.method215(var37, var28), class17.method215(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method2033(var2, var12, var11, class163.method3281(var2, var12, var11));
            }
         }

         class5.field85[var2] = (byte[][])null;
         class164.field2645[var2] = (byte[][])null;
         class5.field76[var2] = (byte[][])null;
         class133.field2058[var2] = (byte[][])null;
         class150.field2239[var2] = (byte[][])null;
      }

      var0.method1957(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class5.field86[1][var2][var3] & 2) == 2) {
               var0.method1934(var2, var3);
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
                  short var45;
                  if((class29.field677[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && 0 != (class29.field677[var6][var8][var9 - 1] & var2); --var9) {
                        ;
                     }

                     while(var10 < 104 && (class29.field677[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label527:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class29.field677[var11 - 1][var8][var13] & var2)) {
                              break label527;
                           }
                        }

                        --var11;
                     }

                     label516:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class29.field677[1 + var12][var8][var13] & var2)) {
                              break label516;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + var12 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class5.field79[var12][var8][var9] - var45;
                        var16 = class5.field79[var11][var8][var9];
                        class85.method1935(var5, 1, 128 * var8, var8 * 128, var9 * 128, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class29.field677[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class29.field677[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class29.field677[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class29.field677[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label580:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class29.field677[var11 - 1][var13][var7] & var3)) {
                              break label580;
                           }
                        }

                        --var11;
                     }

                     label569:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class29.field677[1 + var12][var13][var7] & var3)) {
                              break label569;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + (var10 - var9)) * (1 + var12 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class5.field79[var12][var9][var7] - var45;
                        var16 = class5.field79[var11][var9][var7];
                        class85.method1935(var5, 2, var9 * 128, 128 + var10 * 128, 128 * var7, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class29.field677[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class29.field677[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class29.field677[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && 0 != (class29.field677[var6][var8][var12 + 1] & var4)) {
                        ++var12;
                     }

                     label633:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class29.field677[var6][var9 - 1][var13] & var4) == 0) {
                              break label633;
                           }
                        }

                        --var9;
                     }

                     label622:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class29.field677[var6][var10 + 1][var13] & var4) == 0) {
                              break label622;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var12 - var11)) * (1 + (var10 - var9)) >= 4) {
                        var13 = class5.field79[var6][var9][var11];
                        class85.method1935(var5, 4, 128 * var9, 128 + var10 * 128, var11 * 128, 128 + 128 * var12, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class29.field677[var6][var14][var15] &= ~var4;
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
