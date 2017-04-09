import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public final class class147 {
   @ObfuscatedName("n")
   static class152 field2052 = new class152();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BI[BII)I",
      garbageValue = "9"
   )
   public static int method2806(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      class152 var5 = field2052;
      class152 var6 = field2052;
      class152 var7 = field2052;
      synchronized(field2052) {
         field2052.field2075 = var2;
         field2052.field2076 = var4;
         field2052.field2100 = var0;
         field2052.field2096 = 0;
         field2052.field2080 = var1;
         field2052.field2094 = 0;
         field2052.field2084 = 0;
         field2052.field2077 = 0;
         field2052.field2081 = 0;
         method2826(field2052);
         var1 -= field2052.field2080;
         field2052.field2075 = null;
         field2052.field2100 = null;
         return var1;
      }
   }

   @ObfuscatedName("r")
   static byte method2809(class152 var0) {
      return (byte)method2811(8, var0);
   }

   @ObfuscatedName("n")
   static void method2810(class152 var0) {
      var0.field2105 = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if(var0.field2069[var1]) {
            var0.field2071[var0.field2105] = (byte)var1;
            ++var0.field2105;
         }
      }

   }

   @ObfuscatedName("l")
   static int method2811(int var0, class152 var1) {
      while(var1.field2094 < var0) {
         var1.field2084 = var1.field2084 << 8 | var1.field2075[var1.field2076] & 255;
         var1.field2094 += 8;
         ++var1.field2076;
         ++var1.field2077;
         if(var1.field2077 == 0) {
            ;
         }
      }

      int var2 = var1.field2084 >> var1.field2094 - var0 & (1 << var0) - 1;
      var1.field2094 -= var0;
      return var2;
   }

   @ObfuscatedName("m")
   static void method2813(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
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

   @ObfuscatedName("i")
   static void method2819(class152 var0) {
      byte var1 = var0.field2082;
      int var2 = var0.field2083;
      int var3 = var0.field2078;
      int var4 = var0.field2089;
      int[] var5 = class165.field2183;
      int var6 = var0.field2088;
      byte[] var7 = var0.field2100;
      int var8 = var0.field2096;
      int var9 = var0.field2080;
      int var10 = var0.field2106 + 1;

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

      int var13 = var0.field2081;
      var0.field2081 += var9 - var9;
      if(var0.field2081 < var13) {
         ;
      }

      var0.field2082 = var1;
      var0.field2083 = var2;
      var0.field2078 = var3;
      var0.field2089 = var4;
      class165.field2183 = var5;
      var0.field2088 = var6;
      var0.field2100 = var7;
      var0.field2096 = var8;
      var0.field2080 = var9;
   }

   @ObfuscatedName("o")
   static byte method2821(class152 var0) {
      return (byte)method2811(1, var0);
   }

   class147() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("u")
   static void method2826(class152 var0) {
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
      var0.field2086 = 1;
      if(class165.field2183 == null) {
         class165.field2183 = new int[var0.field2086 * 100000];
      }

      boolean var23 = true;

      while(true) {
         while(var23) {
            byte var24 = method2809(var0);
            if(var24 == 23) {
               return;
            }

            var24 = method2809(var0);
            var24 = method2809(var0);
            var24 = method2809(var0);
            var24 = method2809(var0);
            var24 = method2809(var0);
            var24 = method2809(var0);
            var24 = method2809(var0);
            var24 = method2809(var0);
            var24 = method2809(var0);
            var24 = method2821(var0);
            if(var24 != 0) {
               ;
            }

            var0.field2102 = 0;
            var24 = method2809(var0);
            var0.field2102 = var0.field2102 << 8 | var24 & 255;
            var24 = method2809(var0);
            var0.field2102 = var0.field2102 << 8 | var24 & 255;
            var24 = method2809(var0);
            var0.field2102 = var0.field2102 << 8 | var24 & 255;

            int var25;
            for(var25 = 0; var25 < 16; ++var25) {
               var24 = method2821(var0);
               if(var24 == 1) {
                  var0.field2095[var25] = true;
               } else {
                  var0.field2095[var25] = false;
               }
            }

            for(var25 = 0; var25 < 256; ++var25) {
               var0.field2069[var25] = false;
            }

            int var26;
            for(var25 = 0; var25 < 16; ++var25) {
               if(var0.field2095[var25]) {
                  for(var26 = 0; var26 < 16; ++var26) {
                     var24 = method2821(var0);
                     if(var24 == 1) {
                        var0.field2069[var25 * 16 + var26] = true;
                     }
                  }
               }
            }

            method2810(var0);
            int var27 = var0.field2105 + 2;
            int var28 = method2811(3, var0);
            int var29 = method2811(15, var0);

            for(var25 = 0; var25 < var29; ++var25) {
               var26 = 0;

               while(true) {
                  var24 = method2821(var0);
                  if(var24 == 0) {
                     var0.field2087[var25] = (byte)var26;
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
               var31 = var0.field2087[var25];

               byte var32;
               for(var32 = var30[var31]; var31 > 0; --var31) {
                  var30[var31] = var30[var31 - 1];
               }

               var30[0] = var32;
               var0.field2099[var25] = var32;
            }

            int var33;
            int var50;
            for(var33 = 0; var33 < var28; ++var33) {
               var50 = method2811(5, var0);

               for(var25 = 0; var25 < var27; ++var25) {
                  while(true) {
                     var24 = method2821(var0);
                     if(var24 == 0) {
                        var0.field2101[var33][var25] = (byte)var50;
                        break;
                     }

                     var24 = method2821(var0);
                     if(var24 == 0) {
                        ++var50;
                     } else {
                        --var50;
                     }
                  }
               }
            }

            for(var33 = 0; var33 < var28; ++var33) {
               byte var34 = 32;
               byte var35 = 0;

               for(var25 = 0; var25 < var27; ++var25) {
                  if(var0.field2101[var33][var25] > var35) {
                     var35 = var0.field2101[var33][var25];
                  }

                  if(var0.field2101[var33][var25] < var34) {
                     var34 = var0.field2101[var33][var25];
                  }
               }

               method2813(var0.field2072[var33], var0.field2103[var33], var0.field2104[var33], var0.field2101[var33], var34, var35, var27);
               var0.field2108[var33] = var34;
            }

            var50 = var0.field2105 + 1;
            int var51 = -1;
            byte var52 = 0;

            for(var25 = 0; var25 <= 255; ++var25) {
               var0.field2090[var25] = 0;
            }

            int var36 = 4095;

            int var37;
            int var38;
            for(var37 = 15; var37 >= 0; --var37) {
               for(var38 = 15; var38 >= 0; --var38) {
                  var0.field2097[var36] = (byte)(var37 * 16 + var38);
                  --var36;
               }

               var0.field2098[var37] = var36 + 1;
            }

            int var39 = 0;
            byte var40;
            if(var52 == 0) {
               ++var51;
               var52 = 50;
               var40 = var0.field2099[var51];
               var19 = var0.field2108[var40];
               var20 = var0.field2072[var40];
               var22 = var0.field2104[var40];
               var21 = var0.field2103[var40];
            }

            int var41 = var52 - 1;
            int var42 = var19;

            int var43;
            byte var44;
            for(var43 = method2811(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
               ++var42;
               var44 = method2821(var0);
            }

            int var45 = var22[var43 - var21[var42]];

            while(true) {
               while(var45 != var50) {
                  int var46;
                  int var47;
                  if(var45 != 0 && var45 != 1) {
                     var46 = var45 - 1;
                     int var48;
                     if(var46 < 16) {
                        var47 = var0.field2098[0];

                        for(var24 = var0.field2097[var47 + var46]; var46 > 3; var46 -= 4) {
                           var48 = var47 + var46;
                           var0.field2097[var48] = var0.field2097[var48 - 1];
                           var0.field2097[var48 - 1] = var0.field2097[var48 - 2];
                           var0.field2097[var48 - 2] = var0.field2097[var48 - 3];
                           var0.field2097[var48 - 3] = var0.field2097[var48 - 4];
                        }

                        while(var46 > 0) {
                           var0.field2097[var47 + var46] = var0.field2097[var47 + var46 - 1];
                           --var46;
                        }

                        var0.field2097[var47] = var24;
                     } else {
                        var48 = var46 / 16;
                        int var49 = var46 % 16;
                        var47 = var0.field2098[var48] + var49;

                        for(var24 = var0.field2097[var47]; var47 > var0.field2098[var48]; --var47) {
                           var0.field2097[var47] = var0.field2097[var47 - 1];
                        }

                        ++var0.field2098[var48];

                        while(var48 > 0) {
                           --var0.field2098[var48];
                           var0.field2097[var0.field2098[var48]] = var0.field2097[var0.field2098[var48 - 1] + 16 - 1];
                           --var48;
                        }

                        --var0.field2098[0];
                        var0.field2097[var0.field2098[0]] = var24;
                        if(var0.field2098[0] == 0) {
                           var36 = 4095;

                           for(var37 = 15; var37 >= 0; --var37) {
                              for(var38 = 15; var38 >= 0; --var38) {
                                 var0.field2097[var36] = var0.field2097[var0.field2098[var37] + var38];
                                 --var36;
                              }

                              var0.field2098[var37] = var36 + 1;
                           }
                        }
                     }

                     ++var0.field2090[var0.field2071[var24 & 255] & 255];
                     class165.field2183[var39] = var0.field2071[var24 & 255] & 255;
                     ++var39;
                     if(var41 == 0) {
                        ++var51;
                        var41 = 50;
                        var40 = var0.field2099[var51];
                        var19 = var0.field2108[var40];
                        var20 = var0.field2072[var40];
                        var22 = var0.field2104[var40];
                        var21 = var0.field2103[var40];
                     }

                     --var41;
                     var42 = var19;

                     for(var43 = method2811(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                        ++var42;
                        var44 = method2821(var0);
                     }

                     var45 = var22[var43 - var21[var42]];
                  } else {
                     var46 = -1;
                     var47 = 1;

                     do {
                        if(var45 == 0) {
                           var46 += var47;
                        } else if(var45 == 1) {
                           var46 += var47 * 2;
                        }

                        var47 *= 2;
                        if(var41 == 0) {
                           ++var51;
                           var41 = 50;
                           var40 = var0.field2099[var51];
                           var19 = var0.field2108[var40];
                           var20 = var0.field2072[var40];
                           var22 = var0.field2104[var40];
                           var21 = var0.field2103[var40];
                        }

                        --var41;
                        var42 = var19;

                        for(var43 = method2811(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                           ++var42;
                           var44 = method2821(var0);
                        }

                        var45 = var22[var43 - var21[var42]];
                     } while(var45 == 0 || var45 == 1);

                     ++var46;
                     var24 = var0.field2071[var0.field2097[var0.field2098[0]] & 255];

                     for(var0.field2090[var24 & 255] += var46; var46 > 0; --var46) {
                        class165.field2183[var39] = var24 & 255;
                        ++var39;
                     }
                  }
               }

               var0.field2083 = 0;
               var0.field2082 = 0;
               var0.field2092[0] = 0;

               for(var25 = 1; var25 <= 256; ++var25) {
                  var0.field2092[var25] = var0.field2090[var25 - 1];
               }

               for(var25 = 1; var25 <= 256; ++var25) {
                  var0.field2092[var25] += var0.field2092[var25 - 1];
               }

               for(var25 = 0; var25 < var39; ++var25) {
                  var24 = (byte)(class165.field2183[var25] & 255);
                  class165.field2183[var0.field2092[var24 & 255]] |= var25 << 8;
                  ++var0.field2092[var24 & 255];
               }

               var0.field2088 = class165.field2183[var0.field2102] >> 8;
               var0.field2078 = 0;
               var0.field2088 = class165.field2183[var0.field2088];
               var0.field2089 = (byte)(var0.field2088 & 255);
               var0.field2088 >>= 8;
               ++var0.field2078;
               var0.field2106 = var39;
               method2819(var0);
               if(var0.field2078 == var0.field2106 + 1 && var0.field2083 == 0) {
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
}
