import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public final class class167 {
   @ObfuscatedName("p")
   static class172 field2311;

   @ObfuscatedName("h")
   static void method3136(class172 var0) {
      byte var2 = var0.field2350;
      int var3 = var0.field2371;
      int var4 = var0.field2359;
      int var5 = var0.field2357;
      int[] var6 = class64.field774;
      int var7 = var0.field2363;
      byte[] var8 = var0.field2346;
      int var9 = var0.field2342;
      int var10 = var0.field2348;
      int var12 = var0.field2374 + 1;

      label113:
      while(true) {
         if(var3 > 0) {
            while(true) {
               if(var10 == 0) {
                  break label113;
               }

               if(var3 == 1) {
                  if(var10 == 0) {
                     var3 = 1;
                     break label113;
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
               break label113;
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
                  break label113;
               }

               var8[var9] = var2;
               ++var9;
               --var10;
               var14 = true;
            } else if(var4 == var12) {
               if(var10 == 0) {
                  var3 = 1;
                  break label113;
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

      int var13 = var0.field2349;
      var0.field2349 += var10 - var10;
      if(var0.field2349 < var13) {
         ;
      }

      var0.field2350 = var2;
      var0.field2371 = var3;
      var0.field2359 = var4;
      var0.field2357 = var5;
      class64.field774 = var6;
      var0.field2363 = var7;
      var0.field2346 = var8;
      var0.field2342 = var9;
      var0.field2348 = var10;
   }

   @ObfuscatedName("g")
   static byte method3139(class172 var0) {
      return (byte)method3140(1, var0);
   }

   @ObfuscatedName("v")
   static int method3140(int var0, class172 var1) {
      while(var1.field2372 < var0) {
         var1.field2352 = var1.field2352 << 8 | var1.field2343[var1.field2362] & 255;
         var1.field2372 += 8;
         ++var1.field2362;
         ++var1.field2345;
         if(var1.field2345 == 0) {
            ;
         }
      }

      int var3 = var1.field2352 >> var1.field2372 - var0 & (1 << var0) - 1;
      var1.field2372 -= var0;
      return var3;
   }

   @ObfuscatedName("p")
   static void method3142(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
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

   static {
      field2311 = new class172();
   }

   @ObfuscatedName("q")
   static byte method3143(class172 var0) {
      return (byte)method3140(8, var0);
   }

   @ObfuscatedName("t")
   static void method3147(class172 var0) {
      var0.field2361 = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if(var0.field2351[var1]) {
            var0.field2364[var0.field2361] = (byte)var1;
            ++var0.field2361;
         }
      }

   }

   @ObfuscatedName("u")
   static void method3153(class172 var0) {
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
      var0.field2354 = 1;
      if(class64.field774 == null) {
         class64.field774 = new int[var0.field2354 * 100000];
      }

      boolean var26 = true;

      while(true) {
         while(var26) {
            byte var1 = method3143(var0);
            if(var1 == 23) {
               return;
            }

            var1 = method3143(var0);
            var1 = method3143(var0);
            var1 = method3143(var0);
            var1 = method3143(var0);
            var1 = method3143(var0);
            var1 = method3143(var0);
            var1 = method3143(var0);
            var1 = method3143(var0);
            var1 = method3143(var0);
            var1 = method3139(var0);
            if(var1 != 0) {
               ;
            }

            var0.field2355 = 0;
            var1 = method3143(var0);
            var0.field2355 = var0.field2355 << 8 | var1 & 255;
            var1 = method3143(var0);
            var0.field2355 = var0.field2355 << 8 | var1 & 255;
            var1 = method3143(var0);
            var0.field2355 = var0.field2355 << 8 | var1 & 255;

            int var36;
            for(var36 = 0; var36 < 16; ++var36) {
               var1 = method3139(var0);
               if(var1 == 1) {
                  var0.field2340[var36] = true;
               } else {
                  var0.field2340[var36] = false;
               }
            }

            for(var36 = 0; var36 < 256; ++var36) {
               var0.field2351[var36] = false;
            }

            int var37;
            for(var36 = 0; var36 < 16; ++var36) {
               if(var0.field2340[var36]) {
                  for(var37 = 0; var37 < 16; ++var37) {
                     var1 = method3139(var0);
                     if(var1 == 1) {
                        var0.field2351[var36 * 16 + var37] = true;
                     }
                  }
               }
            }

            method3147(var0);
            int var39 = var0.field2361 + 2;
            int var40 = method3140(3, var0);
            int var41 = method3140(15, var0);

            for(var36 = 0; var36 < var41; ++var36) {
               var37 = 0;

               while(true) {
                  var1 = method3139(var0);
                  if(var1 == 0) {
                     var0.field2347[var36] = (byte)var37;
                     break;
                  }

                  ++var37;
               }
            }

            byte[] var27 = new byte[6];

            byte var29;
            for(var29 = 0; var29 < var40; var27[var29] = var29++) {
               ;
            }

            for(var36 = 0; var36 < var41; ++var36) {
               var29 = var0.field2347[var36];

               byte var28;
               for(var28 = var27[var29]; var29 > 0; --var29) {
                  var27[var29] = var27[var29 - 1];
               }

               var27[0] = var28;
               var0.field2370[var36] = var28;
            }

            int var38;
            for(var38 = 0; var38 < var40; ++var38) {
               int var50 = method3140(5, var0);

               for(var36 = 0; var36 < var39; ++var36) {
                  while(true) {
                     var1 = method3139(var0);
                     if(var1 == 0) {
                        var0.field2369[var38][var36] = (byte)var50;
                        break;
                     }

                     var1 = method3139(var0);
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
                  if(var0.field2369[var38][var36] > var3) {
                     var3 = var0.field2369[var38][var36];
                  }

                  if(var0.field2369[var38][var36] < var2) {
                     var2 = var0.field2369[var38][var36];
                  }
               }

               method3142(var0.field2375[var38], var0.field2367[var38], var0.field2337[var38], var0.field2369[var38], var2, var3, var39);
               var0.field2373[var38] = var2;
            }

            int var42 = var0.field2361 + 1;
            int var43 = -1;
            byte var44 = 0;

            for(var36 = 0; var36 <= 255; ++var36) {
               var0.field2358[var36] = 0;
            }

            int var56 = 4095;

            int var35;
            int var55;
            for(var35 = 15; var35 >= 0; --var35) {
               for(var55 = 15; var55 >= 0; --var55) {
                  var0.field2365[var56] = (byte)(var35 * 16 + var55);
                  --var56;
               }

               var0.field2366[var35] = var56 + 1;
            }

            int var47 = 0;
            byte var54;
            if(var44 == 0) {
               ++var43;
               var44 = 50;
               var54 = var0.field2370[var43];
               var22 = var0.field2373[var54];
               var23 = var0.field2375[var54];
               var25 = var0.field2337[var54];
               var24 = var0.field2367[var54];
            }

            int var45 = var44 - 1;
            int var51 = var22;

            int var52;
            byte var53;
            for(var52 = method3140(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
               ++var51;
               var53 = method3139(var0);
            }

            int var46 = var25[var52 - var24[var51]];

            while(true) {
               while(var46 != var42) {
                  if(var46 != 0 && var46 != 1) {
                     int var33 = var46 - 1;
                     int var30;
                     if(var33 < 16) {
                        var30 = var0.field2366[0];

                        for(var1 = var0.field2365[var30 + var33]; var33 > 3; var33 -= 4) {
                           int var34 = var30 + var33;
                           var0.field2365[var34] = var0.field2365[var34 - 1];
                           var0.field2365[var34 - 1] = var0.field2365[var34 - 2];
                           var0.field2365[var34 - 2] = var0.field2365[var34 - 3];
                           var0.field2365[var34 - 3] = var0.field2365[var34 - 4];
                        }

                        while(var33 > 0) {
                           var0.field2365[var30 + var33] = var0.field2365[var30 + var33 - 1];
                           --var33;
                        }

                        var0.field2365[var30] = var1;
                     } else {
                        int var31 = var33 / 16;
                        int var32 = var33 % 16;
                        var30 = var0.field2366[var31] + var32;

                        for(var1 = var0.field2365[var30]; var30 > var0.field2366[var31]; --var30) {
                           var0.field2365[var30] = var0.field2365[var30 - 1];
                        }

                        ++var0.field2366[var31];

                        while(var31 > 0) {
                           --var0.field2366[var31];
                           var0.field2365[var0.field2366[var31]] = var0.field2365[var0.field2366[var31 - 1] + 16 - 1];
                           --var31;
                        }

                        --var0.field2366[0];
                        var0.field2365[var0.field2366[0]] = var1;
                        if(var0.field2366[0] == 0) {
                           var56 = 4095;

                           for(var35 = 15; var35 >= 0; --var35) {
                              for(var55 = 15; var55 >= 0; --var55) {
                                 var0.field2365[var56] = var0.field2365[var0.field2366[var35] + var55];
                                 --var56;
                              }

                              var0.field2366[var35] = var56 + 1;
                           }
                        }
                     }

                     ++var0.field2358[var0.field2364[var1 & 255] & 255];
                     class64.field774[var47] = var0.field2364[var1 & 255] & 255;
                     ++var47;
                     if(var45 == 0) {
                        ++var43;
                        var45 = 50;
                        var54 = var0.field2370[var43];
                        var22 = var0.field2373[var54];
                        var23 = var0.field2375[var54];
                        var25 = var0.field2337[var54];
                        var24 = var0.field2367[var54];
                     }

                     --var45;
                     var51 = var22;

                     for(var52 = method3140(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
                        ++var51;
                        var53 = method3139(var0);
                     }

                     var46 = var25[var52 - var24[var51]];
                  } else {
                     int var48 = -1;
                     int var49 = 1;

                     do {
                        if(var46 == 0) {
                           var48 += var49;
                        } else if(var46 == 1) {
                           var48 += var49 * 2;
                        }

                        var49 *= 2;
                        if(var45 == 0) {
                           ++var43;
                           var45 = 50;
                           var54 = var0.field2370[var43];
                           var22 = var0.field2373[var54];
                           var23 = var0.field2375[var54];
                           var25 = var0.field2337[var54];
                           var24 = var0.field2367[var54];
                        }

                        --var45;
                        var51 = var22;

                        for(var52 = method3140(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
                           ++var51;
                           var53 = method3139(var0);
                        }

                        var46 = var25[var52 - var24[var51]];
                     } while(var46 == 0 || var46 == 1);

                     ++var48;
                     var1 = var0.field2364[var0.field2365[var0.field2366[0]] & 255];

                     for(var0.field2358[var1 & 255] += var48; var48 > 0; --var48) {
                        class64.field774[var47] = var1 & 255;
                        ++var47;
                     }
                  }
               }

               var0.field2371 = 0;
               var0.field2350 = 0;
               var0.field2360[0] = 0;

               for(var36 = 1; var36 <= 256; ++var36) {
                  var0.field2360[var36] = var0.field2358[var36 - 1];
               }

               for(var36 = 1; var36 <= 256; ++var36) {
                  var0.field2360[var36] += var0.field2360[var36 - 1];
               }

               for(var36 = 0; var36 < var47; ++var36) {
                  var1 = (byte)(class64.field774[var36] & 255);
                  class64.field774[var0.field2360[var1 & 255]] |= var36 << 8;
                  ++var0.field2360[var1 & 255];
               }

               var0.field2363 = class64.field774[var0.field2355] >> 8;
               var0.field2359 = 0;
               var0.field2363 = class64.field774[var0.field2363];
               var0.field2357 = (byte)(var0.field2363 & 255);
               var0.field2363 >>= 8;
               ++var0.field2359;
               var0.field2374 = var47;
               method3136(var0);
               if(var0.field2359 == var0.field2374 + 1 && var0.field2371 == 0) {
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI[BII)I",
      garbageValue = "9"
   )
   public static int method3158(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      class172 var5 = field2311;
      synchronized(field2311) {
         field2311.field2343 = var2;
         field2311.field2362 = var4;
         field2311.field2346 = var0;
         field2311.field2342 = 0;
         field2311.field2348 = var1;
         field2311.field2372 = 0;
         field2311.field2352 = 0;
         field2311.field2345 = 0;
         field2311.field2349 = 0;
         method3153(field2311);
         var1 -= field2311.field2348;
         field2311.field2343 = null;
         field2311.field2346 = null;
         return var1;
      }
   }
}
