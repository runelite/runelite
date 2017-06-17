import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public final class class167 {
   @ObfuscatedName("i")
   static class172 field2345;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI[BII)I",
      garbageValue = "9"
   )
   public static int method2976(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      class172 var5 = field2345;
      class172 var6 = field2345;
      synchronized(field2345) {
         field2345.field2376 = var2;
         field2345.field2374 = var4;
         field2345.field2399 = var0;
         field2345.field2385 = 0;
         field2345.field2378 = var1;
         field2345.field2383 = 0;
         field2345.field2382 = 0;
         field2345.field2375 = 0;
         field2345.field2379 = 0;
         method2978(field2345);
         var1 -= field2345.field2378;
         field2345.field2376 = null;
         field2345.field2399 = null;
         return var1;
      }
   }

   @ObfuscatedName("m")
   static void method2977(class172 var0) {
      byte var1 = var0.field2393;
      int var2 = var0.field2381;
      int var3 = var0.field2389;
      int var4 = var0.field2373;
      int[] var5 = NPC.field1361;
      int var6 = var0.field2377;
      byte[] var7 = var0.field2399;
      int var8 = var0.field2385;
      int var9 = var0.field2378;
      int var10 = var0.field2404 + 1;

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

      int var13 = var0.field2379;
      var0.field2379 += var9 - var9;
      if(var0.field2379 < var13) {
         ;
      }

      var0.field2393 = var1;
      var0.field2381 = var2;
      var0.field2389 = var3;
      var0.field2373 = var4;
      NPC.field1361 = var5;
      var0.field2377 = var6;
      var0.field2399 = var7;
      var0.field2385 = var8;
      var0.field2378 = var9;
   }

   @ObfuscatedName("e")
   static void method2978(class172 var0) {
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
      var0.field2384 = 1;
      if(NPC.field1361 == null) {
         NPC.field1361 = new int[var0.field2384 * 100000];
      }

      boolean var23 = true;

      while(true) {
         while(var23) {
            byte var24 = method2999(var0);
            if(var24 == 23) {
               return;
            }

            var24 = method2999(var0);
            var24 = method2999(var0);
            var24 = method2999(var0);
            var24 = method2999(var0);
            var24 = method2999(var0);
            var24 = method2999(var0);
            var24 = method2999(var0);
            var24 = method2999(var0);
            var24 = method2999(var0);
            var24 = method2980(var0);
            if(var24 != 0) {
               ;
            }

            var0.field2388 = 0;
            var24 = method2999(var0);
            var0.field2388 = var0.field2388 << 8 | var24 & 255;
            var24 = method2999(var0);
            var0.field2388 = var0.field2388 << 8 | var24 & 255;
            var24 = method2999(var0);
            var0.field2388 = var0.field2388 << 8 | var24 & 255;

            int var25;
            for(var25 = 0; var25 < 16; ++var25) {
               var24 = method2980(var0);
               if(var24 == 1) {
                  var0.field2387[var25] = true;
               } else {
                  var0.field2387[var25] = false;
               }
            }

            for(var25 = 0; var25 < 256; ++var25) {
               var0.field2370[var25] = false;
            }

            int var26;
            for(var25 = 0; var25 < 16; ++var25) {
               if(var0.field2387[var25]) {
                  for(var26 = 0; var26 < 16; ++var26) {
                     var24 = method2980(var0);
                     if(var24 == 1) {
                        var0.field2370[var25 * 16 + var26] = true;
                     }
                  }
               }
            }

            method2982(var0);
            int var27 = var0.field2405 + 2;
            int var28 = method2990(3, var0);
            int var29 = method2990(15, var0);

            for(var25 = 0; var25 < var29; ++var25) {
               var26 = 0;

               while(true) {
                  var24 = method2980(var0);
                  if(var24 == 0) {
                     var0.field2398[var25] = (byte)var26;
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
               var31 = var0.field2398[var25];

               byte var32;
               for(var32 = var30[var31]; var31 > 0; --var31) {
                  var30[var31] = var30[var31 - 1];
               }

               var30[0] = var32;
               var0.field2369[var25] = var32;
            }

            int var33;
            int var50;
            for(var50 = 0; var50 < var28; ++var50) {
               var33 = method2990(5, var0);

               for(var25 = 0; var25 < var27; ++var25) {
                  while(true) {
                     var24 = method2980(var0);
                     if(var24 == 0) {
                        var0.field2394[var50][var25] = (byte)var33;
                        break;
                     }

                     var24 = method2980(var0);
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
                  if(var0.field2394[var50][var25] > var34) {
                     var34 = var0.field2394[var50][var25];
                  }

                  if(var0.field2394[var50][var25] < var51) {
                     var51 = var0.field2394[var50][var25];
                  }
               }

               method2983(var0.field2391[var50], var0.field2401[var50], var0.field2402[var50], var0.field2394[var50], var51, var34, var27);
               var0.field2403[var50] = var51;
            }

            var33 = var0.field2405 + 1;
            int var52 = -1;
            byte var35 = 0;

            for(var25 = 0; var25 <= 255; ++var25) {
               var0.field2380[var25] = 0;
            }

            int var36 = 4095;

            int var37;
            int var38;
            for(var37 = 15; var37 >= 0; --var37) {
               for(var38 = 15; var38 >= 0; --var38) {
                  var0.field2395[var36] = (byte)(var37 * 16 + var38);
                  --var36;
               }

               var0.field2396[var37] = var36 + 1;
            }

            int var39 = 0;
            byte var40;
            if(var35 == 0) {
               ++var52;
               var35 = 50;
               var40 = var0.field2369[var52];
               var19 = var0.field2403[var40];
               var20 = var0.field2391[var40];
               var22 = var0.field2402[var40];
               var21 = var0.field2401[var40];
            }

            int var41 = var35 - 1;
            int var42 = var19;

            int var43;
            byte var44;
            for(var43 = method2990(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
               ++var42;
               var44 = method2980(var0);
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
                        var47 = var0.field2396[0];

                        for(var24 = var0.field2395[var47 + var46]; var46 > 3; var46 -= 4) {
                           var48 = var47 + var46;
                           var0.field2395[var48] = var0.field2395[var48 - 1];
                           var0.field2395[var48 - 1] = var0.field2395[var48 - 2];
                           var0.field2395[var48 - 2] = var0.field2395[var48 - 3];
                           var0.field2395[var48 - 3] = var0.field2395[var48 - 4];
                        }

                        while(var46 > 0) {
                           var0.field2395[var47 + var46] = var0.field2395[var47 + var46 - 1];
                           --var46;
                        }

                        var0.field2395[var47] = var24;
                     } else {
                        var48 = var46 / 16;
                        int var49 = var46 % 16;
                        var47 = var0.field2396[var48] + var49;

                        for(var24 = var0.field2395[var47]; var47 > var0.field2396[var48]; --var47) {
                           var0.field2395[var47] = var0.field2395[var47 - 1];
                        }

                        ++var0.field2396[var48];

                        while(var48 > 0) {
                           --var0.field2396[var48];
                           var0.field2395[var0.field2396[var48]] = var0.field2395[var0.field2396[var48 - 1] + 16 - 1];
                           --var48;
                        }

                        --var0.field2396[0];
                        var0.field2395[var0.field2396[0]] = var24;
                        if(var0.field2396[0] == 0) {
                           var36 = 4095;

                           for(var37 = 15; var37 >= 0; --var37) {
                              for(var38 = 15; var38 >= 0; --var38) {
                                 var0.field2395[var36] = var0.field2395[var0.field2396[var37] + var38];
                                 --var36;
                              }

                              var0.field2396[var37] = var36 + 1;
                           }
                        }
                     }

                     ++var0.field2380[var0.field2392[var24 & 255] & 255];
                     NPC.field1361[var39] = var0.field2392[var24 & 255] & 255;
                     ++var39;
                     if(var41 == 0) {
                        ++var52;
                        var41 = 50;
                        var40 = var0.field2369[var52];
                        var19 = var0.field2403[var40];
                        var20 = var0.field2391[var40];
                        var22 = var0.field2402[var40];
                        var21 = var0.field2401[var40];
                     }

                     --var41;
                     var42 = var19;

                     for(var43 = method2990(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                        ++var42;
                        var44 = method2980(var0);
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
                           ++var52;
                           var41 = 50;
                           var40 = var0.field2369[var52];
                           var19 = var0.field2403[var40];
                           var20 = var0.field2391[var40];
                           var22 = var0.field2402[var40];
                           var21 = var0.field2401[var40];
                        }

                        --var41;
                        var42 = var19;

                        for(var43 = method2990(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                           ++var42;
                           var44 = method2980(var0);
                        }

                        var45 = var22[var43 - var21[var42]];
                     } while(var45 == 0 || var45 == 1);

                     ++var46;
                     var24 = var0.field2392[var0.field2395[var0.field2396[0]] & 255];

                     for(var0.field2380[var24 & 255] += var46; var46 > 0; --var46) {
                        NPC.field1361[var39] = var24 & 255;
                        ++var39;
                     }
                  }
               }

               var0.field2381 = 0;
               var0.field2393 = 0;
               var0.field2390[0] = 0;

               for(var25 = 1; var25 <= 256; ++var25) {
                  var0.field2390[var25] = var0.field2380[var25 - 1];
               }

               for(var25 = 1; var25 <= 256; ++var25) {
                  var0.field2390[var25] += var0.field2390[var25 - 1];
               }

               for(var25 = 0; var25 < var39; ++var25) {
                  var24 = (byte)(NPC.field1361[var25] & 255);
                  NPC.field1361[var0.field2390[var24 & 255]] |= var25 << 8;
                  ++var0.field2390[var24 & 255];
               }

               var0.field2377 = NPC.field1361[var0.field2388] >> 8;
               var0.field2389 = 0;
               var0.field2377 = NPC.field1361[var0.field2377];
               var0.field2373 = (byte)(var0.field2377 & 255);
               var0.field2377 >>= 8;
               ++var0.field2389;
               var0.field2404 = var39;
               method2977(var0);
               if(var0.field2389 == var0.field2404 + 1 && var0.field2381 == 0) {
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

   @ObfuscatedName("w")
   static byte method2980(class172 var0) {
      return (byte)method2990(1, var0);
   }

   @ObfuscatedName("j")
   static void method2982(class172 var0) {
      var0.field2405 = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if(var0.field2370[var1]) {
            var0.field2392[var0.field2405] = (byte)var1;
            ++var0.field2405;
         }
      }

   }

   @ObfuscatedName("c")
   static void method2983(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
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

   @ObfuscatedName("z")
   static int method2990(int var0, class172 var1) {
      while(var1.field2383 < var0) {
         var1.field2382 = var1.field2382 << 8 | var1.field2376[var1.field2374] & 255;
         var1.field2383 += 8;
         ++var1.field2374;
         ++var1.field2375;
         if(var1.field2375 == 0) {
            ;
         }
      }

      int var2 = var1.field2382 >> var1.field2383 - var0 & (1 << var0) - 1;
      var1.field2383 -= var0;
      return var2;
   }

   @ObfuscatedName("t")
   static byte method2999(class172 var0) {
      return (byte)method2990(8, var0);
   }

   static {
      field2345 = new class172();
   }
}
