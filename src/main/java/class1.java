import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class1 {
   @ObfuscatedName("m")
   static class173 field27;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      longValue = -4858789980194950981L
   )
   static long field31;

   @ObfuscatedName("f")
   public static int method5(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var4 + var6] = (byte)var7;
         } else if(8364 == var7) {
            var3[var4 + var6] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(402 == var7) {
            var3[var4 + var6] = -125;
         } else if(8222 == var7) {
            var3[var6 + var4] = -124;
         } else if(8230 == var7) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(8225 == var7) {
            var3[var4 + var6] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var4 + var6] = -118;
         } else if(var7 == 8249) {
            var3[var4 + var6] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var4 + var6] = -114;
         } else if(8216 == var7) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var4 + var6] = -110;
         } else if(8220 == var7) {
            var3[var4 + var6] = -109;
         } else if(8221 == var7) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var4 + var6] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var4 + var6] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var4 + var6] = -103;
         } else if(353 == var7) {
            var3[var4 + var6] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(339 == var7) {
            var3[var4 + var6] = -100;
         } else if(382 == var7) {
            var3[var6 + var4] = -98;
         } else if(376 == var7) {
            var3[var6 + var4] = -97;
         } else {
            var3[var4 + var6] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass86;[Lclass108;B)V",
      garbageValue = "7"
   )
   static final void method10(class86 var0, class108[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if(1 == (class5.field80[var2][var3][var4] & 1)) {
                  var5 = var2;
                  if((class5.field80[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2423(var3, var4);
                  }
               }
            }
         }
      }

      class5.field91 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field91 < -8) {
         class5.field91 = -8;
      }

      if(class5.field91 > 8) {
         class5.field91 = 8;
      }

      class5.field92 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field92 < -16) {
         class5.field92 = -16;
      }

      if(class5.field92 > 16) {
         class5.field92 = 16;
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
         byte[][] var42 = class5.field98[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = 768 * var9 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class5.field90[var2][1 + var12][var11] - class5.field90[var2][var12 - 1][var11];
               var14 = class5.field90[var2][var12][var11 + 1] - class5.field90[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + var13 * var13 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = 96 + (var18 * -50 + var17 * -10 + -50 * var16) / var10;
               var20 = (var42[var12][var11 + 1] >> 3) + (var42[var12][var11 - 1] >> 2) + (var42[1 + var12][var11] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11] >> 1);
               class95.field1602[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class191.field3076[var11] = 0;
            class87.field1504[var11] = 0;
            class89.field1529[var11] = 0;
            class31.field723[var11] = 0;
            class5.field84[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = 5 + var11;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class84.field1431[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class41 var46 = (class41)class41.field950.method3754((long)var16);
                     class41 var43;
                     if(var46 != null) {
                        var43 = var46;
                     } else {
                        byte[] var47 = class41.field959.method3280(1, var16);
                        var46 = new class41();
                        if(null != var47) {
                           var46.method841(new class119(var47));
                        }

                        var46.method839();
                        class41.field950.method3756(var46, (long)var16);
                        var43 = var46;
                     }

                     class191.field3076[var12] += var43.field955;
                     class87.field1504[var12] += var43.field953;
                     class89.field1529[var12] += var43.field954;
                     class31.field723[var12] += var43.field951;
                     ++class5.field84[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class84.field1431[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     class41 var48 = (class41)class41.field950.method3754((long)var17);
                     class41 var44;
                     if(null != var48) {
                        var44 = var48;
                     } else {
                        byte[] var49 = class41.field959.method3280(1, var17);
                        var48 = new class41();
                        if(null != var49) {
                           var48.method841(new class119(var49));
                        }

                        var48.method839();
                        class41.field950.method3756(var48, (long)var17);
                        var44 = var48;
                     }

                     class191.field3076[var12] -= var44.field955;
                     class87.field1504[var12] -= var44.field953;
                     class89.field1529[var12] -= var44.field954;
                     class31.field723[var12] -= var44.field951;
                     --class5.field84[var12];
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
                  var18 = 5 + var17;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class191.field3076[var18];
                     var13 += class87.field1504[var18];
                     var14 += class89.field1529[var18];
                     var15 += class31.field723[var18];
                     var16 += class5.field84[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class191.field3076[var19];
                     var13 -= class87.field1504[var19];
                     var14 -= class89.field1529[var19];
                     var15 -= class31.field723[var19];
                     var16 -= class5.field84[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!client.field285 || (class5.field80[0][var11][var17] & 2) != 0 || 0 == (class5.field80[var2][var11][var17] & 16))) {
                     if(var2 < class5.field81) {
                        class5.field81 = var2;
                     }

                     var20 = class84.field1431[var2][var11][var17] & 255;
                     int var21 = class124.field2024[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.field90[var2][var11][var17];
                        int var23 = class5.field90[var2][var11 + 1][var17];
                        int var24 = class5.field90[var2][var11 + 1][var17 + 1];
                        int var25 = class5.field90[var2][var11][1 + var17];
                        int var26 = class95.field1602[var11][var17];
                        int var27 = class95.field1602[var11 + 1][var17];
                        int var28 = class95.field1602[var11 + 1][1 + var17];
                        int var29 = class95.field1602[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class11.method154(var32, var33, var34);
                           var32 = var32 + class5.field91 & 255;
                           var34 += class5.field92;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class11.method154(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var50 = true;
                           if(0 == var20 && 0 != class107.field1856[var2][var11][var17]) {
                              var50 = false;
                           }

                           if(var21 > 0 && !class89.method2099(var21 - 1).field1030) {
                              var50 = false;
                           }

                           if(var50 && var23 == var22 && var24 == var22 && var25 == var22) {
                              class4.field74[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(-1 != var31) {
                           var32 = class91.field1564[class59.method1259(var31, 96)];
                        }

                        if(0 == var21) {
                           var0.method1961(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class59.method1259(var30, var26), class59.method1259(var30, var27), class59.method1259(var30, var28), class59.method1259(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = 1 + class107.field1856[var2][var11][var17];
                           byte var51 = class5.field82[var2][var11][var17];
                           class46 var35 = class89.method2099(var21 - 1);
                           int var36 = var35.field1029;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class91.field1569.vmethod2189(var36);
                              var37 = -1;
                           } else if(16711935 == var35.field1038) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class11.method154(var35.field1027, var35.field1033, var35.field1034);
                              var39 = class5.field91 + var35.field1027 & 255;
                              var40 = class5.field92 + var35.field1034;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class11.method154(var39, var35.field1033, var40);
                           }

                           var39 = 0;
                           if(-2 != var38) {
                              var39 = class91.field1564[class122.method2752(var38, 96)];
                           }

                           if(-1 != var35.field1032) {
                              var40 = class5.field91 + var35.field1035 & 255;
                              int var41 = class5.field92 + var35.field1037;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class11.method154(var40, var35.field1036, var41);
                              var39 = class91.field1564[class122.method2752(var38, 96)];
                           }

                           var0.method1961(var2, var11, var17, var33, var51, var36, var22, var23, var24, var25, class59.method1259(var30, var26), class59.method1259(var30, var27), class59.method1259(var30, var28), class59.method1259(var30, var29), class122.method2752(var37, var26), class122.method2752(var37, var27), class122.method2752(var37, var28), class122.method2752(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class5.field80[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && 0 != (class5.field80[1][var12][var11] & 2)) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.method1930(var2, var12, var11, var17);
            }
         }

         class84.field1431[var2] = (byte[][])null;
         class124.field2024[var2] = (byte[][])null;
         class107.field1856[var2] = (byte[][])null;
         class5.field82[var2] = (byte[][])null;
         class5.field98[var2] = (byte[][])null;
      }

      var0.method1957(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class5.field80[1][var2][var3] & 2) == 2) {
               var0.method1928(var2, var3);
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
                  if((class4.field74[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && 0 != (class4.field74[var6][var8][var9 - 1] & var2); --var9) {
                        ;
                     }

                     while(var10 < 104 && 0 != (class4.field74[var6][var8][1 + var10] & var2)) {
                        ++var10;
                     }

                     label549:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class4.field74[var11 - 1][var8][var13] & var2)) {
                              break label549;
                           }
                        }

                        --var11;
                     }

                     label538:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class4.field74[1 + var12][var8][var13] & var2) == 0) {
                              break label538;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class5.field90[var12][var8][var9] - var45;
                        var16 = class5.field90[var11][var8][var9];
                        class86.method1934(var5, 1, 128 * var8, var8 * 128, var9 * 128, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class4.field74[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if(0 != (class4.field74[var6][var8][var7] & var3)) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && 0 != (class4.field74[var6][var9 - 1][var7] & var3); --var9) {
                        ;
                     }

                     while(var10 < 104 && (class4.field74[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label602:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class4.field74[var11 - 1][var13][var7] & var3) == 0) {
                              break label602;
                           }
                        }

                        --var11;
                     }

                     label591:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class4.field74[var12 + 1][var13][var7] & var3)) {
                              break label591;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + (var10 - var9)) * (1 + var12 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class5.field90[var12][var9][var7] - var45;
                        var16 = class5.field90[var11][var9][var7];
                        class86.method1934(var5, 2, var9 * 128, 128 + var10 * 128, 128 * var7, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class4.field74[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class4.field74[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && 0 != (class4.field74[var6][var8][var11 - 1] & var4); --var11) {
                        ;
                     }

                     while(var12 < 104 && 0 != (class4.field74[var6][var8][1 + var12] & var4)) {
                        ++var12;
                     }

                     label655:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if(0 == (class4.field74[var6][var9 - 1][var13] & var4)) {
                              break label655;
                           }
                        }

                        --var9;
                     }

                     label644:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class4.field74[var6][var10 + 1][var13] & var4) == 0) {
                              break label644;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var12 - var11)) * (1 + (var10 - var9)) >= 4) {
                        var13 = class5.field90[var6][var9][var11];
                        class86.method1934(var5, 4, var9 * 128, 128 + 128 * var10, var11 * 128, 128 + var12 * 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class4.field74[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("cw")
   static final String method13(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class39.method784('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class39.method784(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class39.method784(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass122;S)V",
      garbageValue = "4201"
   )
   static final void method14(class122 var0) {
      for(int var1 = 0; var1 < class32.field741; ++var1) {
         int var2 = class32.field739[var1];
         class2 var3 = client.field387[var2];
         int var4 = var0.method2523();
         if((var4 & 2) != 0) {
            var4 += var0.method2523() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 1) != 0) {
            var6 = var0.method2523();
            byte[] var7 = new byte[var6];
            class119 var8 = new class119(var7);
            var0.method2709(var7, 0, var6);
            class32.field729[var2] = var8;
            var3.method21(var8);
         }

         int var16;
         if((var4 & 8) != 0) {
            var6 = var0.method2700();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var16 = var0.method2523();
            class90.method2100(var3, var6, var16);
         }

         if((var4 & 4) != 0) {
            var3.field845 = var0.method2700();
            if('\uffff' == var3.field845) {
               var3.field845 = -1;
            }
         }

         if((var4 & 128) != 0) {
            var3.field801 = var0.method2531();
            if(var3.field801.charAt(0) == 126) {
               var3.field801 = var3.field801.substring(1);
               class87.method2092(2, var3.field45, var3.field801);
            } else if(class20.field572 == var3) {
               class87.method2092(2, var3.field45, var3.field801);
            }

            var3.field802 = false;
            var3.field805 = 0;
            var3.field806 = 0;
            var3.field837 = 150;
         }

         if(0 != (var4 & 64)) {
            var6 = var0.method2700();
            var16 = var0.method2523();
            var3.method743(var6, var16, client.field289);
            var3.field810 = client.field289 + 300;
            var3.field836 = var0.method2523();
            var3.field812 = var0.method2523();
         }

         if(0 != (var4 & 32)) {
            var3.field815 = var0.method2700();
            if(0 == var3.field834) {
               var3.field793 = var3.field815;
               var3.field815 = -1;
            }
         }

         if((var4 & 16) != 0) {
            var6 = var0.method2700();
            class152 var17 = (class152)class35.method731(class133.method2849(), var0.method2523());
            boolean var18 = var0.method2523() == 1;
            int var9 = var0.method2523();
            int var10 = var0.field1976;
            if(null != var3.field45 && null != var3.field35) {
               boolean var11 = false;
               if(var17.field2257 && class163.method3234(var3.field45)) {
                  var11 = true;
               }

               if(!var11 && client.field307 == 0 && !var3.field54) {
                  class32.field726.field1976 = 0;
                  var0.method2709(class32.field726.field1980, 0, var9);
                  class32.field726.field1976 = 0;
                  class119 var13 = class32.field726;
                  String var12 = class76.method1672(var13, 32767);
                  String var14 = class223.method4072(class22.method581(var12));
                  var3.field801 = var14.trim();
                  var3.field805 = var6 >> 8;
                  var3.field806 = var6 & 255;
                  var3.field837 = 150;
                  var3.field802 = var18;
                  var3.field803 = var3 != class20.field572 && var17.field2257 && client.field495 != "" && var14.toLowerCase().indexOf(client.field495) == -1;
                  int var15;
                  if(var17.field2254) {
                     var15 = var18?91:1;
                  } else {
                     var15 = var18?90:2;
                  }

                  if(var17.field2258 != -1) {
                     class87.method2092(var15, class94.method2184(var17.field2258) + var3.field45, var14);
                  } else {
                     class87.method2092(var15, var3.field45, var14);
                  }
               }
            }

            var0.field1976 = var10 + var9;
         }

         if((var4 & 8192) != 0) {
            var3.field824 = var0.method2700();
            var6 = var0.method2528();
            var3.field828 = var6 >> 16;
            var3.field827 = (var6 & '\uffff') + client.field289;
            var3.field817 = 0;
            var3.field826 = 0;
            if(var3.field827 > client.field289) {
               var3.field817 = -1;
            }

            if(var3.field824 == '\uffff') {
               var3.field824 = -1;
            }
         }

         if(0 != (var4 & 4096)) {
            var3.field816 = var0.method2633();
            var3.field831 = var0.method2633();
            var3.field830 = var0.method2633();
            var3.field788 = var0.method2633();
            var3.field833 = var0.method2700() + client.field289;
            var3.field820 = var0.method2700() + client.field289;
            var3.field840 = var0.method2700();
            if(var3.field44) {
               var3.field816 += var3.field58;
               var3.field831 += var3.field36;
               var3.field830 += var3.field58;
               var3.field788 += var3.field36;
               var3.field834 = 0;
            } else {
               var3.field816 += var3.field842[0];
               var3.field831 += var3.field843[0];
               var3.field830 += var3.field842[0];
               var3.field788 += var3.field843[0];
               var3.field834 = 1;
            }

            var3.field811 = 0;
         }

         if((var4 & 1024) != 0) {
            var6 = var0.method2700();
            var16 = var0.method2523();
            var3.method743(var6, var16, client.field289);
            var3.field810 = 300 + client.field289;
            var3.field836 = var0.method2523();
            var3.field812 = var0.method2523();
         }

         if((var4 & 512) != 0) {
            class32.field730[var2] = var0.method2633();
         }

         if(0 != (var4 & 2048)) {
            var5 = var0.method2633();
         }

         if((var4 & 256) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.field46[var6] = var0.method2531();
            }
         }

         if(var3.field44) {
            if(var5 == 127) {
               var3.method25(var3.field58, var3.field36);
            } else {
               byte var19;
               if(-1 != var5) {
                  var19 = var5;
               } else {
                  var19 = class32.field730[var2];
               }

               var3.method23(var3.field58, var3.field36, var19);
            }
         }
      }

   }

   @ObfuscatedName("ai")
   static final void method15() {
      for(int var0 = 0; var0 < client.field317; ++var0) {
         int var1 = client.field318[var0];
         class34 var2 = client.field316[var1];
         if(var2 != null) {
            class59.method1260(var2);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-488191697"
   )
   public static void method16(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class148) {
               class148 var6 = (class148)var1;
               var5 = var6.field2223 + " | ";
               var4 = var6.field2218;
            } else {
               var5 = "";
            }

            StringWriter var18 = new StringWriter();
            PrintWriter var7 = new PrintWriter(var18);
            var4.printStackTrace(var7);
            var7.close();
            String var8 = var18.toString();
            BufferedReader var9 = new BufferedReader(new StringReader(var8));
            String var10 = var9.readLine();

            while(true) {
               String var11 = var9.readLine();
               if(null == var11) {
                  var5 = var5 + "| " + var10;
                  var2 = var5;
                  break;
               }

               int var12 = var11.indexOf(40);
               int var13 = var11.indexOf(41, var12 + 1);
               if(var12 >= 0 && var13 >= 0) {
                  String var14 = var11.substring(var12 + 1, var13);
                  int var15 = var14.indexOf(".java:");
                  if(var15 >= 0) {
                     var14 = var14.substring(0, var15) + var14.substring(5 + var15);
                     var5 = var5 + var14 + ' ';
                     continue;
                  }

                  var11 = var11.substring(0, var12);
               }

               var11 = var11.trim();
               var11 = var11.substring(var11.lastIndexOf(32) + 1);
               var11 = var11.substring(var11.lastIndexOf(9) + 1);
               var5 = var5 + var11 + ' ';
            }
         }

         if(var0 != null) {
            if(null != var1) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(class148.field2220 == null) {
            return;
         }

         URL var3 = new URL(class148.field2220.getCodeBase(), "clienterror.ws?c=" + class90.field1541 + "&u=" + class209.field3117 + "&v1=" + class226.field3212 + "&v2=" + class136.field2092 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("p")
   public static void method17(class119 var0) {
      byte[] var1 = new byte[24];

      try {
         class149.field2232.method4135(0L);
         class149.field2232.method4141(var1);

         int var2;
         for(var2 = 0; var2 < 24 && 0 == var1[var2]; ++var2) {
            ;
         }

         if(var2 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var3 = 0; var3 < 24; ++var3) {
            var1[var3] = -1;
         }
      }

      var0.method2517(var1, 0, 24);
   }
}
