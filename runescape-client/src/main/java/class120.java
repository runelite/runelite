import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public final class class120 {
   @ObfuscatedName("l")
   static class113 field2037 = new class113();

   @ObfuscatedName("l")
   static void method2493(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
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

   @ObfuscatedName("h")
   static void method2495(class113 var0) {
      byte var2 = var0.field1973;
      int var3 = var0.field1996;
      int var4 = var0.field1982;
      int var5 = var0.field1980;
      int[] var6 = class231.field3268;
      int var7 = var0.field1979;
      byte[] var8 = var0.field1974;
      int var9 = var0.field1992;
      int var10 = var0.field1971;
      int var12 = var0.field1967 + 1;

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

      int var13 = var0.field1972;
      var0.field1972 += var10 - var10;
      if(var0.field1972 < var13) {
         ;
      }

      var0.field1973 = var2;
      var0.field1996 = var3;
      var0.field1982 = var4;
      var0.field1980 = var5;
      class231.field3268 = var6;
      var0.field1979 = var7;
      var0.field1974 = var8;
      var0.field1992 = var9;
      var0.field1971 = var10;
   }

   @ObfuscatedName("e")
   static void method2496(class113 var0) {
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
      var0.field1977 = 1;
      if(class231.field3268 == null) {
         class231.field3268 = new int[var0.field1977 * 100000];
      }

      boolean var26 = true;

      while(true) {
         while(var26) {
            byte var1 = method2516(var0);
            if(var1 == 23) {
               return;
            }

            var1 = method2516(var0);
            var1 = method2516(var0);
            var1 = method2516(var0);
            var1 = method2516(var0);
            var1 = method2516(var0);
            var1 = method2516(var0);
            var1 = method2516(var0);
            var1 = method2516(var0);
            var1 = method2516(var0);
            var1 = method2497(var0);
            if(var1 != 0) {
               ;
            }

            var0.field1986 = 0;
            var1 = method2516(var0);
            var0.field1986 = var0.field1986 << 8 | var1 & 255;
            var1 = method2516(var0);
            var0.field1986 = var0.field1986 << 8 | var1 & 255;
            var1 = method2516(var0);
            var0.field1986 = var0.field1986 << 8 | var1 & 255;

            int var36;
            for(var36 = 0; var36 < 16; ++var36) {
               var1 = method2497(var0);
               if(var1 == 1) {
                  var0.field1998[var36] = true;
               } else {
                  var0.field1998[var36] = false;
               }
            }

            for(var36 = 0; var36 < 256; ++var36) {
               var0.field1985[var36] = false;
            }

            int var37;
            for(var36 = 0; var36 < 16; ++var36) {
               if(var0.field1998[var36]) {
                  for(var37 = 0; var37 < 16; ++var37) {
                     var1 = method2497(var0);
                     if(var1 == 1) {
                        var0.field1985[var36 * 16 + var37] = true;
                     }
                  }
               }
            }

            method2499(var0);
            int var39 = var0.field1988 + 2;
            int var40 = method2498(3, var0);
            int var41 = method2498(15, var0);

            for(var36 = 0; var36 < var41; ++var36) {
               var37 = 0;

               while(true) {
                  var1 = method2497(var0);
                  if(var1 == 0) {
                     var0.field1991[var36] = (byte)var37;
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
               var29 = var0.field1991[var36];

               byte var28;
               for(var28 = var35[var29]; var29 > 0; --var29) {
                  var35[var29] = var35[var29 - 1];
               }

               var35[0] = var28;
               var0.field1990[var36] = var28;
            }

            int var38;
            for(var38 = 0; var38 < var40; ++var38) {
               int var50 = method2498(5, var0);

               for(var36 = 0; var36 < var39; ++var36) {
                  while(true) {
                     var1 = method2497(var0);
                     if(var1 == 0) {
                        var0.field1968[var38][var36] = (byte)var50;
                        break;
                     }

                     var1 = method2497(var0);
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
                  if(var0.field1968[var38][var36] > var3) {
                     var3 = var0.field1968[var38][var36];
                  }

                  if(var0.field1968[var38][var36] < var2) {
                     var2 = var0.field1968[var38][var36];
                  }
               }

               method2493(var0.field1993[var38], var0.field1994[var38], var0.field1989[var38], var0.field1968[var38], var2, var3, var39);
               var0.field1966[var38] = var2;
            }

            int var42 = var0.field1988 + 1;
            int var43 = -1;
            byte var44 = 0;

            for(var36 = 0; var36 <= 255; ++var36) {
               var0.field1981[var36] = 0;
            }

            int var56 = 4095;

            int var27;
            int var55;
            for(var27 = 15; var27 >= 0; --var27) {
               for(var55 = 15; var55 >= 0; --var55) {
                  var0.field1969[var56] = (byte)(var27 * 16 + var55);
                  --var56;
               }

               var0.field1970[var27] = var56 + 1;
            }

            int var47 = 0;
            byte var54;
            if(var44 == 0) {
               ++var43;
               var44 = 50;
               var54 = var0.field1990[var43];
               var22 = var0.field1966[var54];
               var23 = var0.field1993[var54];
               var25 = var0.field1989[var54];
               var24 = var0.field1994[var54];
            }

            int var45 = var44 - 1;
            int var51 = var22;

            int var52;
            byte var53;
            for(var52 = method2498(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
               ++var51;
               var53 = method2497(var0);
            }

            int var46 = var25[var52 - var24[var51]];

            while(true) {
               while(var46 != var42) {
                  if(var46 != 0 && var46 != 1) {
                     int var33 = var46 - 1;
                     int var30;
                     if(var33 < 16) {
                        var30 = var0.field1970[0];

                        for(var1 = var0.field1969[var30 + var33]; var33 > 3; var33 -= 4) {
                           int var34 = var30 + var33;
                           var0.field1969[var34] = var0.field1969[var34 - 1];
                           var0.field1969[var34 - 1] = var0.field1969[var34 - 2];
                           var0.field1969[var34 - 2] = var0.field1969[var34 - 3];
                           var0.field1969[var34 - 3] = var0.field1969[var34 - 4];
                        }

                        while(var33 > 0) {
                           var0.field1969[var30 + var33] = var0.field1969[var30 + var33 - 1];
                           --var33;
                        }

                        var0.field1969[var30] = var1;
                     } else {
                        int var31 = var33 / 16;
                        int var32 = var33 % 16;
                        var30 = var0.field1970[var31] + var32;

                        for(var1 = var0.field1969[var30]; var30 > var0.field1970[var31]; --var30) {
                           var0.field1969[var30] = var0.field1969[var30 - 1];
                        }

                        ++var0.field1970[var31];

                        while(var31 > 0) {
                           --var0.field1970[var31];
                           var0.field1969[var0.field1970[var31]] = var0.field1969[var0.field1970[var31 - 1] + 16 - 1];
                           --var31;
                        }

                        --var0.field1970[0];
                        var0.field1969[var0.field1970[0]] = var1;
                        if(var0.field1970[0] == 0) {
                           var56 = 4095;

                           for(var27 = 15; var27 >= 0; --var27) {
                              for(var55 = 15; var55 >= 0; --var55) {
                                 var0.field1969[var56] = var0.field1969[var0.field1970[var27] + var55];
                                 --var56;
                              }

                              var0.field1970[var27] = var56 + 1;
                           }
                        }
                     }

                     ++var0.field1981[var0.field1987[var1 & 255] & 255];
                     class231.field3268[var47] = var0.field1987[var1 & 255] & 255;
                     ++var47;
                     if(var45 == 0) {
                        ++var43;
                        var45 = 50;
                        var54 = var0.field1990[var43];
                        var22 = var0.field1966[var54];
                        var23 = var0.field1993[var54];
                        var25 = var0.field1989[var54];
                        var24 = var0.field1994[var54];
                     }

                     --var45;
                     var51 = var22;

                     for(var52 = method2498(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
                        ++var51;
                        var53 = method2497(var0);
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
                           var54 = var0.field1990[var43];
                           var22 = var0.field1966[var54];
                           var23 = var0.field1993[var54];
                           var25 = var0.field1989[var54];
                           var24 = var0.field1994[var54];
                        }

                        --var45;
                        var51 = var22;

                        for(var52 = method2498(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
                           ++var51;
                           var53 = method2497(var0);
                        }

                        var46 = var25[var52 - var24[var51]];
                     } while(var46 == 0 || var46 == 1);

                     ++var48;
                     var1 = var0.field1987[var0.field1969[var0.field1970[0]] & 255];

                     for(var0.field1981[var1 & 255] += var48; var48 > 0; --var48) {
                        class231.field3268[var47] = var1 & 255;
                        ++var47;
                     }
                  }
               }

               var0.field1996 = 0;
               var0.field1973 = 0;
               var0.field1983[0] = 0;

               for(var36 = 1; var36 <= 256; ++var36) {
                  var0.field1983[var36] = var0.field1981[var36 - 1];
               }

               for(var36 = 1; var36 <= 256; ++var36) {
                  var0.field1983[var36] += var0.field1983[var36 - 1];
               }

               for(var36 = 0; var36 < var47; ++var36) {
                  var1 = (byte)(class231.field3268[var36] & 255);
                  class231.field3268[var0.field1983[var1 & 255]] |= var36 << 8;
                  ++var0.field1983[var1 & 255];
               }

               var0.field1979 = class231.field3268[var0.field1986] >> 8;
               var0.field1982 = 0;
               var0.field1979 = class231.field3268[var0.field1979];
               var0.field1980 = (byte)(var0.field1979 & 255);
               var0.field1979 >>= 8;
               ++var0.field1982;
               var0.field1967 = var47;
               method2495(var0);
               if(var0.field1982 == var0.field1967 + 1 && var0.field1996 == 0) {
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

   @ObfuscatedName("n")
   static byte method2497(class113 var0) {
      return (byte)method2498(1, var0);
   }

   @ObfuscatedName("u")
   static int method2498(int var0, class113 var1) {
      while(var1.field1976 < var0) {
         var1.field1975 = var1.field1975 << 8 | var1.field1997[var1.field1995] & 255;
         var1.field1976 += 8;
         ++var1.field1995;
         ++var1.field1960;
         if(var1.field1960 == 0) {
            ;
         }
      }

      int var3 = var1.field1975 >> var1.field1976 - var0 & (1 << var0) - 1;
      var1.field1976 -= var0;
      return var3;
   }

   @ObfuscatedName("d")
   static void method2499(class113 var0) {
      var0.field1988 = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if(var0.field1985[var1]) {
            var0.field1987[var0.field1988] = (byte)var1;
            ++var0.field1988;
         }
      }

   }

   @ObfuscatedName("g")
   static byte method2516(class113 var0) {
      return (byte)method2498(8, var0);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI[BII)I",
      garbageValue = "9"
   )
   public static int method2517(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      class113 var5 = field2037;
      synchronized(field2037) {
         field2037.field1997 = var2;
         field2037.field1995 = var4;
         field2037.field1974 = var0;
         field2037.field1992 = 0;
         field2037.field1971 = var1;
         field2037.field1976 = 0;
         field2037.field1975 = 0;
         field2037.field1960 = 0;
         field2037.field1972 = 0;
         method2496(field2037);
         var1 -= field2037.field1971;
         field2037.field1997 = null;
         field2037.field1974 = null;
         return var1;
      }
   }
}
