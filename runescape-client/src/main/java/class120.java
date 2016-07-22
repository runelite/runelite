import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public final class class120 {
   @ObfuscatedName("r")
   static class113 field2042 = new class113();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI[BII)I",
      garbageValue = "9"
   )
   public static int method2521(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      class113 var5 = field2042;
      synchronized(field2042) {
         field2042.field1993 = var2;
         field2042.field1973 = var4;
         field2042.field1969 = var0;
         field2042.field1976 = 0;
         field2042.field1977 = var1;
         field2042.field1982 = 0;
         field2042.field1981 = 0;
         field2042.field1974 = 0;
         field2042.field1978 = 0;
         method2524(field2042);
         var1 -= field2042.field1977;
         field2042.field1993 = null;
         field2042.field1969 = null;
         return var1;
      }
   }

   @ObfuscatedName("w")
   static void method2522(class113 var0) {
      byte var2 = var0.field1979;
      int var3 = var0.field1966;
      int var4 = var0.field1988;
      int var5 = var0.field1986;
      int[] var6 = class49.field1099;
      int var7 = var0.field1984;
      byte[] var8 = var0.field1969;
      int var9 = var0.field1976;
      int var10 = var0.field1977;
      int var12 = var0.field1972 + 1;

      label116:
      while(true) {
         if(var3 > 0) {
            while(true) {
               if(var10 == 0) {
                  break label116;
               }

               if(var3 == 1) {
                  if(var10 == 0) {
                     var3 = 1;
                     break label116;
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
               break label116;
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
                  break label116;
               }

               var8[var9] = var2;
               ++var9;
               --var10;
               var14 = true;
            } else if(var4 == var12) {
               if(var10 == 0) {
                  var3 = 1;
                  break label116;
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

      int var13 = var0.field1978;
      var0.field1978 += var10 - var10;
      if(var0.field1978 < var13) {
         ;
      }

      var0.field1979 = var2;
      var0.field1966 = var3;
      var0.field1988 = var4;
      var0.field1986 = var5;
      class49.field1099 = var6;
      var0.field1984 = var7;
      var0.field1969 = var8;
      var0.field1976 = var9;
      var0.field1977 = var10;
   }

   @ObfuscatedName("o")
   static byte method2523(class113 var0) {
      return (byte)method2525(8, var0);
   }

   @ObfuscatedName("e")
   static void method2524(class113 var0) {
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
      var0.field1983 = 1;
      if(class49.field1099 == null) {
         class49.field1099 = new int[var0.field1983 * 100000];
      }

      boolean var26 = true;

      while(true) {
         while(var26) {
            byte var1 = method2523(var0);
            if(var1 == 23) {
               return;
            }

            var1 = method2523(var0);
            var1 = method2523(var0);
            var1 = method2523(var0);
            var1 = method2523(var0);
            var1 = method2523(var0);
            var1 = method2523(var0);
            var1 = method2523(var0);
            var1 = method2523(var0);
            var1 = method2523(var0);
            var1 = method2533(var0);
            if(var1 != 0) {
               ;
            }

            var0.field1997 = 0;
            var1 = method2523(var0);
            var0.field1997 = var0.field1997 << 8 | var1 & 255;
            var1 = method2523(var0);
            var0.field1997 = var0.field1997 << 8 | var1 & 255;
            var1 = method2523(var0);
            var0.field1997 = var0.field1997 << 8 | var1 & 255;

            int var36;
            for(var36 = 0; var36 < 16; ++var36) {
               var1 = method2533(var0);
               if(var1 == 1) {
                  var0.field1994[var36] = true;
               } else {
                  var0.field1994[var36] = false;
               }
            }

            for(var36 = 0; var36 < 256; ++var36) {
               var0.field1991[var36] = false;
            }

            int var37;
            for(var36 = 0; var36 < 16; ++var36) {
               if(var0.field1994[var36]) {
                  for(var37 = 0; var37 < 16; ++var37) {
                     var1 = method2533(var0);
                     if(var1 == 1) {
                        var0.field1991[var36 * 16 + var37] = true;
                     }
                  }
               }
            }

            method2544(var0);
            int var39 = var0.field1990 + 2;
            int var40 = method2525(3, var0);
            int var41 = method2525(15, var0);

            for(var36 = 0; var36 < var41; ++var36) {
               var37 = 0;

               while(true) {
                  var1 = method2533(var0);
                  if(var1 == 0) {
                     var0.field1989[var36] = (byte)var37;
                     break;
                  }

                  ++var37;
               }
            }

            byte[] var35 = new byte[6];

            byte var29;
            for(var29 = 0; var29 < var40; var35[var29] = var29++) {
               ;
            }

            for(var36 = 0; var36 < var41; ++var36) {
               var29 = var0.field1989[var36];

               byte var28;
               for(var28 = var35[var29]; var29 > 0; --var29) {
                  var35[var29] = var35[var29 - 1];
               }

               var35[0] = var28;
               var0.field1996[var36] = var28;
            }

            int var38;
            for(var38 = 0; var38 < var40; ++var38) {
               int var50 = method2525(5, var0);

               for(var36 = 0; var36 < var39; ++var36) {
                  while(true) {
                     var1 = method2533(var0);
                     if(var1 == 0) {
                        var0.field1975[var38][var36] = (byte)var50;
                        break;
                     }

                     var1 = method2533(var0);
                     if(var1 == 0) {
                        ++var50;
                     } else {
                        --var50;
                     }
                  }
               }
            }

            for(var38 = 0; var38 < var40; ++var38) {
               byte var2 = 32;
               byte var3 = 0;

               for(var36 = 0; var36 < var39; ++var36) {
                  if(var0.field1975[var38][var36] > var3) {
                     var3 = var0.field1975[var38][var36];
                  }

                  if(var0.field1975[var38][var36] < var2) {
                     var2 = var0.field1975[var38][var36];
                  }
               }

               method2530(var0.field1999[var38], var0.field2000[var38], var0.field2001[var38], var0.field1975[var38], var2, var3, var39);
               var0.field2002[var38] = var2;
            }

            int var42 = var0.field1990 + 1;
            int var43 = -1;
            byte var44 = 0;

            for(var36 = 0; var36 <= 255; ++var36) {
               var0.field1987[var36] = 0;
            }

            int var56 = 4095;

            int var27;
            int var55;
            for(var27 = 15; var27 >= 0; --var27) {
               for(var55 = 15; var55 >= 0; --var55) {
                  var0.field1980[var56] = (byte)(var27 * 16 + var55);
                  --var56;
               }

               var0.field1995[var27] = var56 + 1;
            }

            int var47 = 0;
            byte var54;
            if(var44 == 0) {
               ++var43;
               var44 = 50;
               var54 = var0.field1996[var43];
               var22 = var0.field2002[var54];
               var23 = var0.field1999[var54];
               var25 = var0.field2001[var54];
               var24 = var0.field2000[var54];
            }

            int var45 = var44 - 1;
            int var51 = var22;

            int var52;
            byte var53;
            for(var52 = method2525(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
               ++var51;
               var53 = method2533(var0);
            }

            int var46 = var25[var52 - var24[var51]];

            while(true) {
               while(var46 != var42) {
                  if(var46 != 0 && var46 != 1) {
                     int var33 = var46 - 1;
                     int var30;
                     if(var33 < 16) {
                        var30 = var0.field1995[0];

                        for(var1 = var0.field1980[var30 + var33]; var33 > 3; var33 -= 4) {
                           int var34 = var30 + var33;
                           var0.field1980[var34] = var0.field1980[var34 - 1];
                           var0.field1980[var34 - 1] = var0.field1980[var34 - 2];
                           var0.field1980[var34 - 2] = var0.field1980[var34 - 3];
                           var0.field1980[var34 - 3] = var0.field1980[var34 - 4];
                        }

                        while(var33 > 0) {
                           var0.field1980[var30 + var33] = var0.field1980[var30 + var33 - 1];
                           --var33;
                        }

                        var0.field1980[var30] = var1;
                     } else {
                        int var31 = var33 / 16;
                        int var32 = var33 % 16;
                        var30 = var0.field1995[var31] + var32;

                        for(var1 = var0.field1980[var30]; var30 > var0.field1995[var31]; --var30) {
                           var0.field1980[var30] = var0.field1980[var30 - 1];
                        }

                        ++var0.field1995[var31];

                        while(var31 > 0) {
                           --var0.field1995[var31];
                           var0.field1980[var0.field1995[var31]] = var0.field1980[var0.field1995[var31 - 1] + 16 - 1];
                           --var31;
                        }

                        --var0.field1995[0];
                        var0.field1980[var0.field1995[0]] = var1;
                        if(var0.field1995[0] == 0) {
                           var56 = 4095;

                           for(var27 = 15; var27 >= 0; --var27) {
                              for(var55 = 15; var55 >= 0; --var55) {
                                 var0.field1980[var56] = var0.field1980[var0.field1995[var27] + var55];
                                 --var56;
                              }

                              var0.field1995[var27] = var56 + 1;
                           }
                        }
                     }

                     ++var0.field1987[var0.field1970[var1 & 255] & 255];
                     class49.field1099[var47] = var0.field1970[var1 & 255] & 255;
                     ++var47;
                     if(var45 == 0) {
                        ++var43;
                        var45 = 50;
                        var54 = var0.field1996[var43];
                        var22 = var0.field2002[var54];
                        var23 = var0.field1999[var54];
                        var25 = var0.field2001[var54];
                        var24 = var0.field2000[var54];
                     }

                     --var45;
                     var51 = var22;

                     for(var52 = method2525(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
                        ++var51;
                        var53 = method2533(var0);
                     }

                     var46 = var25[var52 - var24[var51]];
                  } else {
                     int var48 = -1;
                     int var49 = 1;

                     do {
                        if(var46 == 0) {
                           var48 += var49;
                        } else if(var46 == 1) {
                           var48 += 2 * var49;
                        }

                        var49 *= 2;
                        if(var45 == 0) {
                           ++var43;
                           var45 = 50;
                           var54 = var0.field1996[var43];
                           var22 = var0.field2002[var54];
                           var23 = var0.field1999[var54];
                           var25 = var0.field2001[var54];
                           var24 = var0.field2000[var54];
                        }

                        --var45;
                        var51 = var22;

                        for(var52 = method2525(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
                           ++var51;
                           var53 = method2533(var0);
                        }

                        var46 = var25[var52 - var24[var51]];
                     } while(var46 == 0 || var46 == 1);

                     ++var48;
                     var1 = var0.field1970[var0.field1980[var0.field1995[0]] & 255];

                     for(var0.field1987[var1 & 255] += var48; var48 > 0; --var48) {
                        class49.field1099[var47] = var1 & 255;
                        ++var47;
                     }
                  }
               }

               var0.field1966 = 0;
               var0.field1979 = 0;
               var0.field1992[0] = 0;

               for(var36 = 1; var36 <= 256; ++var36) {
                  var0.field1992[var36] = var0.field1987[var36 - 1];
               }

               for(var36 = 1; var36 <= 256; ++var36) {
                  var0.field1992[var36] += var0.field1992[var36 - 1];
               }

               for(var36 = 0; var36 < var47; ++var36) {
                  var1 = (byte)(class49.field1099[var36] & 255);
                  class49.field1099[var0.field1992[var1 & 255]] |= var36 << 8;
                  ++var0.field1992[var1 & 255];
               }

               var0.field1984 = class49.field1099[var0.field1997] >> 8;
               var0.field1988 = 0;
               var0.field1984 = class49.field1099[var0.field1984];
               var0.field1986 = (byte)(var0.field1984 & 255);
               var0.field1984 >>= 8;
               ++var0.field1988;
               var0.field1972 = var47;
               method2522(var0);
               if(var0.field1988 == var0.field1972 + 1 && var0.field1966 == 0) {
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

   @ObfuscatedName("l")
   static int method2525(int var0, class113 var1) {
      while(var1.field1982 < var0) {
         var1.field1981 = var1.field1981 << 8 | var1.field1993[var1.field1973] & 255;
         var1.field1982 += 8;
         ++var1.field1973;
         ++var1.field1974;
         if(var1.field1974 == 0) {
            ;
         }
      }

      int var3 = var1.field1981 >> var1.field1982 - var0 & (1 << var0) - 1;
      var1.field1982 -= var0;
      return var3;
   }

   @ObfuscatedName("r")
   static void method2530(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
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

   @ObfuscatedName("g")
   static byte method2533(class113 var0) {
      return (byte)method2525(1, var0);
   }

   @ObfuscatedName("j")
   static void method2544(class113 var0) {
      var0.field1990 = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if(var0.field1991[var1]) {
            var0.field1970[var0.field1990] = (byte)var1;
            ++var0.field1990;
         }
      }

   }
}
