import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public final class class117 {
   @ObfuscatedName("k")
   static class110 field2003 = new class110();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI[BII)I",
      garbageValue = "9"
   )
   public static int method2450(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      class110 var5 = field2003;
      class110 var6 = field2003;
      synchronized(field2003) {
         field2003.field1958 = var2;
         field2003.field1953 = var4;
         field2003.field1926 = var0;
         field2003.field1934 = 0;
         field2003.field1931 = var1;
         field2003.field1936 = 0;
         field2003.field1935 = 0;
         field2003.field1937 = 0;
         field2003.field1929 = 0;
         method2457(field2003);
         var1 -= field2003.field1931;
         field2003.field1958 = null;
         field2003.field1926 = null;
         return var1;
      }
   }

   @ObfuscatedName("j")
   static void method2451(class110 var0) {
      byte var1 = var0.field1933;
      int var2 = var0.field1932;
      int var3 = var0.field1942;
      int var4 = var0.field1940;
      int[] var5 = class104.field1803;
      int var6 = var0.field1939;
      byte[] var7 = var0.field1926;
      int var8 = var0.field1934;
      int var9 = var0.field1931;
      int var10 = var0.field1947 + 1;

      label65:
      while(true) {
         if(var2 > 0) {
            while(true) {
               if(var9 == 0) {
                  break label65;
               }

               if(var2 == 1) {
                  if(var9 == 0) {
                     var2 = 1;
                     break label65;
                  }

                  var7[var8] = var1;
                  ++var8;
                  --var9;
                  break;
               }

               var7[var8] = var1;
               --var2;
               ++var8;
               --var9;
            }
         }

         boolean var11 = true;

         byte var12;
         while(var11) {
            var11 = false;
            if(var3 == var10) {
               var2 = 0;
               break label65;
            }

            var1 = (byte)var4;
            var6 = var5[var6];
            var12 = (byte)(var6 & 255);
            var6 >>= 8;
            ++var3;
            if(var12 != var4) {
               var4 = var12;
               if(var9 == 0) {
                  var2 = 1;
                  break label65;
               }

               var7[var8] = var1;
               ++var8;
               --var9;
               var11 = true;
            } else if(var3 == var10) {
               if(var9 == 0) {
                  var2 = 1;
                  break label65;
               }

               var7[var8] = var1;
               ++var8;
               --var9;
               var11 = true;
            }
         }

         var2 = 2;
         var6 = var5[var6];
         var12 = (byte)(var6 & 255);
         var6 >>= 8;
         ++var3;
         if(var3 != var10) {
            if(var12 != var4) {
               var4 = var12;
            } else {
               var2 = 3;
               var6 = var5[var6];
               var12 = (byte)(var6 & 255);
               var6 >>= 8;
               ++var3;
               if(var3 != var10) {
                  if(var12 != var4) {
                     var4 = var12;
                  } else {
                     var6 = var5[var6];
                     var12 = (byte)(var6 & 255);
                     var6 >>= 8;
                     ++var3;
                     var2 = (var12 & 255) + 4;
                     var6 = var5[var6];
                     var4 = (byte)(var6 & 255);
                     var6 >>= 8;
                     ++var3;
                  }
               }
            }
         }
      }

      int var13 = var0.field1929;
      var0.field1929 += var9 - var9;
      if(var0.field1929 < var13) {
         ;
      }

      var0.field1933 = var1;
      var0.field1932 = var2;
      var0.field1942 = var3;
      var0.field1940 = var4;
      class104.field1803 = var5;
      var0.field1939 = var6;
      var0.field1926 = var7;
      var0.field1934 = var8;
      var0.field1931 = var9;
   }

   @ObfuscatedName("d")
   static byte method2453(class110 var0) {
      return (byte)method2454(1, var0);
   }

   @ObfuscatedName("u")
   static int method2454(int var0, class110 var1) {
      while(var1.field1936 < var0) {
         var1.field1935 = var1.field1935 << 8 | var1.field1958[var1.field1953] & 255;
         var1.field1936 += 8;
         ++var1.field1953;
         ++var1.field1937;
         if(var1.field1937 == 0) {
            ;
         }
      }

      int var2 = var1.field1935 >> var1.field1936 - var0 & (1 << var0) - 1;
      var1.field1936 -= var0;
      return var2;
   }

   @ObfuscatedName("o")
   static void method2455(class110 var0) {
      var0.field1944 = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if(var0.field1920[var1]) {
            var0.field1927[var0.field1944] = (byte)var1;
            ++var0.field1944;
         }
      }

   }

   @ObfuscatedName("x")
   static byte method2456(class110 var0) {
      return (byte)method2454(8, var0);
   }

   @ObfuscatedName("p")
   static void method2457(class110 var0) {
      boolean var1 = false;
      boolean var2 = false;
      boolean var3 = false;
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
      int var19 = 0;
      int[] var20 = null;
      int[] var21 = null;
      int[] var22 = null;
      var0.field1925 = 1;
      if(class104.field1803 == null) {
         class104.field1803 = new int[var0.field1925 * 100000];
      }

      boolean var23 = true;

      while(true) {
         while(var23) {
            byte var24 = method2456(var0);
            if(var24 == 23) {
               return;
            }

            var24 = method2456(var0);
            var24 = method2456(var0);
            var24 = method2456(var0);
            var24 = method2456(var0);
            var24 = method2456(var0);
            var24 = method2456(var0);
            var24 = method2456(var0);
            var24 = method2456(var0);
            var24 = method2456(var0);
            var24 = method2453(var0);
            if(var24 != 0) {
               ;
            }

            var0.field1938 = 0;
            var24 = method2456(var0);
            var0.field1938 = var0.field1938 << 8 | var24 & 255;
            var24 = method2456(var0);
            var0.field1938 = var0.field1938 << 8 | var24 & 255;
            var24 = method2456(var0);
            var0.field1938 = var0.field1938 << 8 | var24 & 255;

            int var25;
            for(var25 = 0; var25 < 16; ++var25) {
               var24 = method2453(var0);
               if(var24 == 1) {
                  var0.field1946[var25] = true;
               } else {
                  var0.field1946[var25] = false;
               }
            }

            for(var25 = 0; var25 < 256; ++var25) {
               var0.field1920[var25] = false;
            }

            int var26;
            for(var25 = 0; var25 < 16; ++var25) {
               if(var0.field1946[var25]) {
                  for(var26 = 0; var26 < 16; ++var26) {
                     var24 = method2453(var0);
                     if(var24 == 1) {
                        var0.field1920[var25 * 16 + var26] = true;
                     }
                  }
               }
            }

            method2455(var0);
            int var27 = var0.field1944 + 2;
            int var28 = method2454(3, var0);
            int var29 = method2454(15, var0);

            for(var25 = 0; var25 < var29; ++var25) {
               var26 = 0;

               while(true) {
                  var24 = method2453(var0);
                  if(var24 == 0) {
                     var0.field1951[var25] = (byte)var26;
                     break;
                  }

                  ++var26;
               }
            }

            byte[] var30 = new byte[6];

            byte var31;
            for(var31 = 0; var31 < var28; var30[var31] = var31++) {
               ;
            }

            for(var25 = 0; var25 < var29; ++var25) {
               var31 = var0.field1951[var25];

               byte var32;
               for(var32 = var30[var31]; var31 > 0; --var31) {
                  var30[var31] = var30[var31 - 1];
               }

               var30[0] = var32;
               var0.field1950[var25] = var32;
            }

            int var33;
            int var50;
            for(var50 = 0; var50 < var28; ++var50) {
               var33 = method2454(5, var0);

               for(var25 = 0; var25 < var27; ++var25) {
                  while(true) {
                     var24 = method2453(var0);
                     if(var24 == 0) {
                        var0.field1957[var50][var25] = (byte)var33;
                        break;
                     }

                     var24 = method2453(var0);
                     if(var24 == 0) {
                        ++var33;
                     } else {
                        --var33;
                     }
                  }
               }
            }

            for(var50 = 0; var50 < var28; ++var50) {
               byte var51 = 32;
               byte var34 = 0;

               for(var25 = 0; var25 < var27; ++var25) {
                  if(var0.field1957[var50][var25] > var34) {
                     var34 = var0.field1957[var50][var25];
                  }

                  if(var0.field1957[var50][var25] < var51) {
                     var51 = var0.field1957[var50][var25];
                  }
               }

               method2469(var0.field1952[var50], var0.field1928[var50], var0.field1955[var50], var0.field1957[var50], var51, var34, var27);
               var0.field1956[var50] = var51;
            }

            var33 = var0.field1944 + 1;
            int var52 = -1;
            byte var35 = 0;

            for(var25 = 0; var25 <= 255; ++var25) {
               var0.field1941[var25] = 0;
            }

            int var36 = 4095;

            int var37;
            int var38;
            for(var37 = 15; var37 >= 0; --var37) {
               for(var38 = 15; var38 >= 0; --var38) {
                  var0.field1948[var36] = (byte)(var37 * 16 + var38);
                  --var36;
               }

               var0.field1949[var37] = var36 + 1;
            }

            int var39 = 0;
            byte var40;
            if(var35 == 0) {
               ++var52;
               var35 = 50;
               var40 = var0.field1950[var52];
               var19 = var0.field1956[var40];
               var20 = var0.field1952[var40];
               var22 = var0.field1955[var40];
               var21 = var0.field1928[var40];
            }

            int var41 = var35 - 1;
            int var42 = var19;

            int var43;
            byte var44;
            for(var43 = method2454(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
               ++var42;
               var44 = method2453(var0);
            }

            int var45 = var22[var43 - var21[var42]];

            while(true) {
               while(var45 != var33) {
                  int var46;
                  int var47;
                  if(var45 != 0 && var45 != 1) {
                     var46 = var45 - 1;
                     int var48;
                     if(var46 < 16) {
                        var47 = var0.field1949[0];

                        for(var24 = var0.field1948[var47 + var46]; var46 > 3; var46 -= 4) {
                           var48 = var47 + var46;
                           var0.field1948[var48] = var0.field1948[var48 - 1];
                           var0.field1948[var48 - 1] = var0.field1948[var48 - 2];
                           var0.field1948[var48 - 2] = var0.field1948[var48 - 3];
                           var0.field1948[var48 - 3] = var0.field1948[var48 - 4];
                        }

                        while(var46 > 0) {
                           var0.field1948[var47 + var46] = var0.field1948[var47 + var46 - 1];
                           --var46;
                        }

                        var0.field1948[var47] = var24;
                     } else {
                        var48 = var46 / 16;
                        int var49 = var46 % 16;
                        var47 = var0.field1949[var48] + var49;

                        for(var24 = var0.field1948[var47]; var47 > var0.field1949[var48]; --var47) {
                           var0.field1948[var47] = var0.field1948[var47 - 1];
                        }

                        ++var0.field1949[var48];

                        while(var48 > 0) {
                           --var0.field1949[var48];
                           var0.field1948[var0.field1949[var48]] = var0.field1948[var0.field1949[var48 - 1] + 16 - 1];
                           --var48;
                        }

                        --var0.field1949[0];
                        var0.field1948[var0.field1949[0]] = var24;
                        if(var0.field1949[0] == 0) {
                           var36 = 4095;

                           for(var37 = 15; var37 >= 0; --var37) {
                              for(var38 = 15; var38 >= 0; --var38) {
                                 var0.field1948[var36] = var0.field1948[var0.field1949[var37] + var38];
                                 --var36;
                              }

                              var0.field1949[var37] = var36 + 1;
                           }
                        }
                     }

                     ++var0.field1941[var0.field1927[var24 & 255] & 255];
                     class104.field1803[var39] = var0.field1927[var24 & 255] & 255;
                     ++var39;
                     if(var41 == 0) {
                        ++var52;
                        var41 = 50;
                        var40 = var0.field1950[var52];
                        var19 = var0.field1956[var40];
                        var20 = var0.field1952[var40];
                        var22 = var0.field1955[var40];
                        var21 = var0.field1928[var40];
                     }

                     --var41;
                     var42 = var19;

                     for(var43 = method2454(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                        ++var42;
                        var44 = method2453(var0);
                     }

                     var45 = var22[var43 - var21[var42]];
                  } else {
                     var46 = -1;
                     var47 = 1;

                     do {
                        if(var45 == 0) {
                           var46 += var47;
                        } else if(var45 == 1) {
                           var46 += 2 * var47;
                        }

                        var47 *= 2;
                        if(var41 == 0) {
                           ++var52;
                           var41 = 50;
                           var40 = var0.field1950[var52];
                           var19 = var0.field1956[var40];
                           var20 = var0.field1952[var40];
                           var22 = var0.field1955[var40];
                           var21 = var0.field1928[var40];
                        }

                        --var41;
                        var42 = var19;

                        for(var43 = method2454(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                           ++var42;
                           var44 = method2453(var0);
                        }

                        var45 = var22[var43 - var21[var42]];
                     } while(var45 == 0 || var45 == 1);

                     ++var46;
                     var24 = var0.field1927[var0.field1948[var0.field1949[0]] & 255];

                     for(var0.field1941[var24 & 255] += var46; var46 > 0; --var46) {
                        class104.field1803[var39] = var24 & 255;
                        ++var39;
                     }
                  }
               }

               var0.field1932 = 0;
               var0.field1933 = 0;
               var0.field1943[0] = 0;

               for(var25 = 1; var25 <= 256; ++var25) {
                  var0.field1943[var25] = var0.field1941[var25 - 1];
               }

               for(var25 = 1; var25 <= 256; ++var25) {
                  var0.field1943[var25] += var0.field1943[var25 - 1];
               }

               for(var25 = 0; var25 < var39; ++var25) {
                  var24 = (byte)(class104.field1803[var25] & 255);
                  class104.field1803[var0.field1943[var24 & 255]] |= var25 << 8;
                  ++var0.field1943[var24 & 255];
               }

               var0.field1939 = class104.field1803[var0.field1938] >> 8;
               var0.field1942 = 0;
               var0.field1939 = class104.field1803[var0.field1939];
               var0.field1940 = (byte)(var0.field1939 & 255);
               var0.field1939 >>= 8;
               ++var0.field1942;
               var0.field1947 = var39;
               method2451(var0);
               if(var0.field1942 == var0.field1947 + 1 && var0.field1932 == 0) {
                  var23 = true;
                  break;
               }

               var23 = false;
               break;
            }
         }

         return;
      }
   }

   @ObfuscatedName("b")
   static void method2469(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
      int var7 = 0;

      int var8;
      int var9;
      for(var8 = var4; var8 <= var5; ++var8) {
         for(var9 = 0; var9 < var6; ++var9) {
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

      var9 = 0;

      for(var8 = var4; var8 <= var5; ++var8) {
         var9 += var1[var8 + 1] - var1[var8];
         var0[var8] = var9 - 1;
         var9 <<= 1;
      }

      for(var8 = var4 + 1; var8 <= var5; ++var8) {
         var1[var8] = (var0[var8 - 1] + 1 << 1) - var1[var8];
      }

   }
}
