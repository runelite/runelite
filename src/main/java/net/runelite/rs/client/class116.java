package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ds")
public final class class116 {
   @ObfuscatedName("i")
   static class109 field1976 = new class109();

   @ObfuscatedName("j")
   public static int method2478(byte[] var0, int var1, byte[] var2, int var3) {
      class109 var4 = field1976;
      synchronized(field1976) {
         field1976.field1902 = var2;
         field1976.field1903 = var3;
         field1976.field1905 = var0;
         field1976.field1906 = 0;
         field1976.field1901 = var1;
         field1976.field1912 = 0;
         field1976.field1915 = 0;
         field1976.field1913 = 0;
         field1976.field1908 = 0;
         method2480(field1976);
         var1 -= field1976.field1901;
         field1976.field1902 = null;
         field1976.field1905 = null;
         return var1;
      }
   }

   @ObfuscatedName("f")
   static void method2480(class109 var0) {
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      boolean var10 = false;
      boolean var11 = false;
      boolean var12 = false;
      boolean var13 = false;
      boolean var14 = false;
      boolean var15 = false;
      boolean var16 = false;
      boolean var17 = false;
      boolean var18 = false;
      boolean var19 = false;
      boolean var20 = false;
      boolean var21 = false;
      int var22 = 0;
      int[] var23 = null;
      int[] var24 = null;
      int[] var25 = null;
      var0.field1899 = 1;
      if(class88.field1542 == null) {
         class88.field1542 = new int[var0.field1899 * 100000];
      }

      boolean var26 = true;

      while(true) {
         while(var26) {
            byte var1 = method2503(var0);
            if(var1 == 23) {
               return;
            }

            var1 = method2503(var0);
            var1 = method2503(var0);
            var1 = method2503(var0);
            var1 = method2503(var0);
            var1 = method2503(var0);
            var1 = method2503(var0);
            var1 = method2503(var0);
            var1 = method2503(var0);
            var1 = method2503(var0);
            var1 = method2482(var0);
            if(var1 != 0) {
               ;
            }

            var0.field1927 = 0;
            var1 = method2503(var0);
            var0.field1927 = var0.field1927 << 8 | var1 & 255;
            var1 = method2503(var0);
            var0.field1927 = var0.field1927 << 8 | var1 & 255;
            var1 = method2503(var0);
            var0.field1927 = var0.field1927 << 8 | var1 & 255;

            int var35;
            for(var35 = 0; var35 < 16; ++var35) {
               var1 = method2482(var0);
               if(var1 == 1) {
                  var0.field1922[var35] = true;
               } else {
                  var0.field1922[var35] = false;
               }
            }

            for(var35 = 0; var35 < 256; ++var35) {
               var0.field1921[var35] = false;
            }

            int var36;
            for(var35 = 0; var35 < 16; ++var35) {
               if(var0.field1922[var35]) {
                  for(var36 = 0; var36 < 16; ++var36) {
                     var1 = method2482(var0);
                     if(var1 == 1) {
                        var0.field1921[var35 * 16 + var36] = true;
                     }
                  }
               }
            }

            method2484(var0);
            int var38 = var0.field1920 + 2;
            int var39 = method2483(3, var0);
            int var40 = method2483(15, var0);

            for(var35 = 0; var35 < var40; ++var35) {
               var36 = 0;

               while(true) {
                  var1 = method2482(var0);
                  if(var1 == 0) {
                     var0.field1926[var35] = (byte)var36;
                     break;
                  }

                  ++var36;
               }
            }

            byte[] var27 = new byte[6];

            byte var29;
            for(var29 = 0; var29 < var39; var27[var29] = var29++) {
               ;
            }

            for(var35 = 0; var35 < var40; ++var35) {
               var29 = var0.field1926[var35];

               byte var28;
               for(var28 = var27[var29]; var29 > 0; --var29) {
                  var27[var29] = var27[var29 - 1];
               }

               var27[0] = var28;
               var0.field1911[var35] = var28;
            }

            int var37;
            for(var37 = 0; var37 < var39; ++var37) {
               int var49 = method2483(5, var0);

               for(var35 = 0; var35 < var38; ++var35) {
                  while(true) {
                     var1 = method2482(var0);
                     if(var1 == 0) {
                        var0.field1928[var37][var35] = (byte)var49;
                        break;
                     }

                     var1 = method2482(var0);
                     if(var1 == 0) {
                        ++var49;
                     } else {
                        --var49;
                     }
                  }
               }
            }

            for(var37 = 0; var37 < var39; ++var37) {
               byte var2 = 32;
               byte var3 = 0;

               for(var35 = 0; var35 < var38; ++var35) {
                  if(var0.field1928[var37][var35] > var3) {
                     var3 = var0.field1928[var37][var35];
                  }

                  if(var0.field1928[var37][var35] < var2) {
                     var2 = var0.field1928[var37][var35];
                  }
               }

               method2485(var0.field1929[var37], var0.field1930[var37], var0.field1931[var37], var0.field1928[var37], var2, var3, var38);
               var0.field1932[var37] = var2;
            }

            int var41 = var0.field1920 + 1;
            int var42 = -1;
            byte var43 = 0;

            for(var35 = 0; var35 <= 255; ++var35) {
               var0.field1917[var35] = 0;
            }

            int var56 = 4095;

            int var54;
            int var55;
            for(var54 = 15; var54 >= 0; --var54) {
               for(var55 = 15; var55 >= 0; --var55) {
                  var0.field1924[var56] = (byte)(var54 * 16 + var55);
                  --var56;
               }

               var0.field1925[var54] = var56 + 1;
            }

            int var46 = 0;
            byte var53;
            if(var43 == 0) {
               ++var42;
               var43 = 50;
               var53 = var0.field1911[var42];
               var22 = var0.field1932[var53];
               var23 = var0.field1929[var53];
               var25 = var0.field1931[var53];
               var24 = var0.field1930[var53];
            }

            int var44 = var43 - 1;
            int var50 = var22;

            int var51;
            byte var52;
            for(var51 = method2483(var22, var0); var51 > var23[var50]; var51 = var51 << 1 | var52) {
               ++var50;
               var52 = method2482(var0);
            }

            int var45 = var25[var51 - var24[var50]];

            while(true) {
               while(var45 != var41) {
                  if(var45 != 0 && var45 != 1) {
                     int var33 = var45 - 1;
                     int var30;
                     if(var33 < 16) {
                        var30 = var0.field1925[0];

                        for(var1 = var0.field1924[var30 + var33]; var33 > 3; var33 -= 4) {
                           int var34 = var30 + var33;
                           var0.field1924[var34] = var0.field1924[var34 - 1];
                           var0.field1924[var34 - 1] = var0.field1924[var34 - 2];
                           var0.field1924[var34 - 2] = var0.field1924[var34 - 3];
                           var0.field1924[var34 - 3] = var0.field1924[var34 - 4];
                        }

                        while(var33 > 0) {
                           var0.field1924[var30 + var33] = var0.field1924[var30 + var33 - 1];
                           --var33;
                        }

                        var0.field1924[var30] = var1;
                     } else {
                        int var31 = var33 / 16;
                        int var32 = var33 % 16;
                        var30 = var0.field1925[var31] + var32;

                        for(var1 = var0.field1924[var30]; var30 > var0.field1925[var31]; --var30) {
                           var0.field1924[var30] = var0.field1924[var30 - 1];
                        }

                        ++var0.field1925[var31];

                        while(var31 > 0) {
                           --var0.field1925[var31];
                           var0.field1924[var0.field1925[var31]] = var0.field1924[var0.field1925[var31 - 1] + 16 - 1];
                           --var31;
                        }

                        --var0.field1925[0];
                        var0.field1924[var0.field1925[0]] = var1;
                        if(var0.field1925[0] == 0) {
                           var56 = 4095;

                           for(var54 = 15; var54 >= 0; --var54) {
                              for(var55 = 15; var55 >= 0; --var55) {
                                 var0.field1924[var56] = var0.field1924[var0.field1925[var54] + var55];
                                 --var56;
                              }

                              var0.field1925[var54] = var56 + 1;
                           }
                        }
                     }

                     ++var0.field1917[var0.field1923[var1 & 255] & 255];
                     class88.field1542[var46] = var0.field1923[var1 & 255] & 255;
                     ++var46;
                     if(var44 == 0) {
                        ++var42;
                        var44 = 50;
                        var53 = var0.field1911[var42];
                        var22 = var0.field1932[var53];
                        var23 = var0.field1929[var53];
                        var25 = var0.field1931[var53];
                        var24 = var0.field1930[var53];
                     }

                     --var44;
                     var50 = var22;

                     for(var51 = method2483(var22, var0); var51 > var23[var50]; var51 = var51 << 1 | var52) {
                        ++var50;
                        var52 = method2482(var0);
                     }

                     var45 = var25[var51 - var24[var50]];
                  } else {
                     int var47 = -1;
                     int var48 = 1;

                     do {
                        if(var45 == 0) {
                           var47 += var48;
                        } else if(var45 == 1) {
                           var47 += 2 * var48;
                        }

                        var48 *= 2;
                        if(var44 == 0) {
                           ++var42;
                           var44 = 50;
                           var53 = var0.field1911[var42];
                           var22 = var0.field1932[var53];
                           var23 = var0.field1929[var53];
                           var25 = var0.field1931[var53];
                           var24 = var0.field1930[var53];
                        }

                        --var44;
                        var50 = var22;

                        for(var51 = method2483(var22, var0); var51 > var23[var50]; var51 = var51 << 1 | var52) {
                           ++var50;
                           var52 = method2482(var0);
                        }

                        var45 = var25[var51 - var24[var50]];
                     } while(var45 == 0 || var45 == 1);

                     ++var47;
                     var1 = var0.field1923[var0.field1924[var0.field1925[0]] & 255];

                     for(var0.field1917[var1 & 255] += var47; var47 > 0; --var47) {
                        class88.field1542[var46] = var1 & 255;
                        ++var46;
                     }
                  }
               }

               var0.field1896 = 0;
               var0.field1909 = 0;
               var0.field1919[0] = 0;

               for(var35 = 1; var35 <= 256; ++var35) {
                  var0.field1919[var35] = var0.field1917[var35 - 1];
               }

               for(var35 = 1; var35 <= 256; ++var35) {
                  var0.field1919[var35] += var0.field1919[var35 - 1];
               }

               for(var35 = 0; var35 < var46; ++var35) {
                  var1 = (byte)(class88.field1542[var35] & 255);
                  class88.field1542[var0.field1919[var1 & 255]] |= var35 << 8;
                  ++var0.field1919[var1 & 255];
               }

               var0.field1918 = class88.field1542[var0.field1927] >> 8;
               var0.field1904 = 0;
               var0.field1918 = class88.field1542[var0.field1918];
               var0.field1897 = (byte)(var0.field1918 & 255);
               var0.field1918 >>= 8;
               ++var0.field1904;
               var0.field1933 = var46;
               method2493(var0);
               if(var0.field1904 == var0.field1933 + 1 && var0.field1896 == 0) {
                  var26 = true;
                  break;
               }

               var26 = false;
               break;
            }
         }

         return;
      }
   }

   @ObfuscatedName("u")
   static byte method2482(class109 var0) {
      return (byte)method2483(1, var0);
   }

   @ObfuscatedName("a")
   static int method2483(int var0, class109 var1) {
      while(var1.field1912 < var0) {
         var1.field1915 = var1.field1915 << 8 | var1.field1902[var1.field1903] & 255;
         var1.field1912 += 8;
         ++var1.field1903;
         ++var1.field1913;
         if(var1.field1913 == 0) {
            ;
         }
      }

      int var3 = var1.field1915 >> var1.field1912 - var0 & (1 << var0) - 1;
      var1.field1912 -= var0;
      return var3;
   }

   @ObfuscatedName("h")
   static void method2484(class109 var0) {
      var0.field1920 = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if(var0.field1921[var1]) {
            var0.field1923[var0.field1920] = (byte)var1;
            ++var0.field1920;
         }
      }

   }

   @ObfuscatedName("i")
   static void method2485(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
      int var7 = 0;

      int var8;
      for(var8 = var4; var8 <= var5; ++var8) {
         for(int var9 = 0; var9 < var6; ++var9) {
            if(var3[var9] == var8) {
               var2[var7] = var9;
               ++var7;
            }
         }
      }

      for(var8 = 0; var8 < 23; ++var8) {
         var1[var8] = 0;
      }

      for(var8 = 0; var8 < var6; ++var8) {
         ++var1[var3[var8] + 1];
      }

      for(var8 = 1; var8 < 23; ++var8) {
         var1[var8] += var1[var8 - 1];
      }

      for(var8 = 0; var8 < 23; ++var8) {
         var0[var8] = 0;
      }

      int var10 = 0;

      for(var8 = var4; var8 <= var5; ++var8) {
         var10 += var1[var8 + 1] - var1[var8];
         var0[var8] = var10 - 1;
         var10 <<= 1;
      }

      for(var8 = var4 + 1; var8 <= var5; ++var8) {
         var1[var8] = (var0[var8 - 1] + 1 << 1) - var1[var8];
      }

   }

   @ObfuscatedName("m")
   static void method2493(class109 var0) {
      byte var2 = var0.field1909;
      int var3 = var0.field1896;
      int var4 = var0.field1904;
      int var5 = var0.field1897;
      int[] var6 = class88.field1542;
      int var7 = var0.field1918;
      byte[] var8 = var0.field1905;
      int var9 = var0.field1906;
      int var10 = var0.field1901;
      int var12 = var0.field1933 + 1;

      label112:
      while(true) {
         if(var3 > 0) {
            while(true) {
               if(var10 == 0) {
                  break label112;
               }

               if(var3 == 1) {
                  if(var10 == 0) {
                     var3 = 1;
                     break label112;
                  }

                  var8[var9] = var2;
                  ++var9;
                  --var10;
                  break;
               }

               var8[var9] = var2;
               --var3;
               ++var9;
               --var10;
            }
         }

         boolean var14 = true;

         byte var1;
         while(var14) {
            var14 = false;
            if(var4 == var12) {
               var3 = 0;
               break label112;
            }

            var2 = (byte)var5;
            var7 = var6[var7];
            var1 = (byte)(var7 & 255);
            var7 >>= 8;
            ++var4;
            if(var1 != var5) {
               var5 = var1;
               if(var10 == 0) {
                  var3 = 1;
                  break label112;
               }

               var8[var9] = var2;
               ++var9;
               --var10;
               var14 = true;
            } else if(var4 == var12) {
               if(var10 == 0) {
                  var3 = 1;
                  break label112;
               }

               var8[var9] = var2;
               ++var9;
               --var10;
               var14 = true;
            }
         }

         var3 = 2;
         var7 = var6[var7];
         var1 = (byte)(var7 & 255);
         var7 >>= 8;
         ++var4;
         if(var4 != var12) {
            if(var1 != var5) {
               var5 = var1;
            } else {
               var3 = 3;
               var7 = var6[var7];
               var1 = (byte)(var7 & 255);
               var7 >>= 8;
               ++var4;
               if(var4 != var12) {
                  if(var1 != var5) {
                     var5 = var1;
                  } else {
                     var7 = var6[var7];
                     var1 = (byte)(var7 & 255);
                     var7 >>= 8;
                     ++var4;
                     var3 = (var1 & 255) + 4;
                     var7 = var6[var7];
                     var5 = (byte)(var7 & 255);
                     var7 >>= 8;
                     ++var4;
                  }
               }
            }
         }
      }

      int var13 = var0.field1908;
      var0.field1908 += var10 - var10;
      if(var0.field1908 < var13) {
         ;
      }

      var0.field1909 = var2;
      var0.field1896 = var3;
      var0.field1904 = var4;
      var0.field1897 = var5;
      class88.field1542 = var6;
      var0.field1918 = var7;
      var0.field1905 = var8;
      var0.field1906 = var9;
      var0.field1901 = var10;
   }

   @ObfuscatedName("l")
   static byte method2503(class109 var0) {
      return (byte)method2483(8, var0);
   }
}
