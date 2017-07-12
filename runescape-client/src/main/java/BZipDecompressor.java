import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
@Implements("BZipDecompressor")
public final class BZipDecompressor {
   @ObfuscatedName("j")
   @Export("state")
   static DState state;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI[BII)I",
      garbageValue = "9"
   )
   public static int method3078(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      DState var5 = state;
      synchronized(state) {
         state.strm = var2;
         state.next_in = var4;
         state.out = var0;
         state.next_out = 0;
         state.field2369 = var1;
         state.total_in_lo32 = 0;
         state.total_in_hi32 = 0;
         state.total_out_lo32 = 0;
         state.total_out_hi32 = 0;
         method3091(state);
         var1 -= state.field2369;
         state.strm = null;
         state.out = null;
         return var1;
      }
   }

   @ObfuscatedName("t")
   static byte method3080(DState var0) {
      return (byte)method3082(8, var0);
   }

   @ObfuscatedName("s")
   static byte method3081(DState var0) {
      return (byte)method3082(1, var0);
   }

   @ObfuscatedName("r")
   static int method3082(int var0, DState var1) {
      while(var1.total_in_lo32 < var0) {
         var1.total_in_hi32 = var1.total_in_hi32 << 8 | var1.strm[var1.next_in] & 255;
         var1.total_in_lo32 += 8;
         ++var1.next_in;
         ++var1.total_out_lo32;
         if(var1.total_out_lo32 == 0) {
            ;
         }
      }

      int var2 = var1.total_in_hi32 >> var1.total_in_lo32 - var0 & (1 << var0) - 1;
      var1.total_in_lo32 -= var0;
      return var2;
   }

   @ObfuscatedName("y")
   static void method3084(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
      int var7 = 0;

      int var8;
      int var9;
      for(var8 = var4; var8 <= var5; ++var8) {
         for(var9 = 0; var9 < var6; ++var9) {
            if(var8 == var3[var9]) {
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

   @ObfuscatedName("w")
   static void method3088(DState var0) {
      byte var1 = var0.out_ch;
      int var2 = var0.out_len;
      int var3 = var0.nblock_used;
      int var4 = var0.k0;
      int[] var5 = FrameMap.tt;
      int var6 = var0.tPos;
      byte[] var7 = var0.out;
      int var8 = var0.next_out;
      int var9 = var0.field2369;
      int var10 = var0.field2395 + 1;

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
            if(var4 != var12) {
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
            if(var4 != var12) {
               var4 = var12;
            } else {
               var2 = 3;
               var6 = var5[var6];
               var12 = (byte)(var6 & 255);
               var6 >>= 8;
               ++var3;
               if(var3 != var10) {
                  if(var4 != var12) {
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

      int var13 = var0.total_out_hi32;
      var0.total_out_hi32 += var9 - var9;
      if(var0.total_out_hi32 < var13) {
         ;
      }

      var0.out_ch = var1;
      var0.out_len = var2;
      var0.nblock_used = var3;
      var0.k0 = var4;
      FrameMap.tt = var5;
      var0.tPos = var6;
      var0.out = var7;
      var0.next_out = var8;
      var0.field2369 = var9;
   }

   @ObfuscatedName("a")
   static void method3091(DState var0) {
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
      var0.blockSize100k = 1;
      if(FrameMap.tt == null) {
         FrameMap.tt = new int[var0.blockSize100k * 100000];
      }

      boolean var23 = true;

      while(true) {
         while(var23) {
            byte var24 = method3080(var0);
            if(var24 == 23) {
               return;
            }

            var24 = method3080(var0);
            var24 = method3080(var0);
            var24 = method3080(var0);
            var24 = method3080(var0);
            var24 = method3080(var0);
            var24 = method3080(var0);
            var24 = method3080(var0);
            var24 = method3080(var0);
            var24 = method3080(var0);
            var24 = method3081(var0);
            if(var24 != 0) {
               ;
            }

            var0.field2376 = 0;
            var24 = method3080(var0);
            var0.field2376 = var0.field2376 << 8 | var24 & 255;
            var24 = method3080(var0);
            var0.field2376 = var0.field2376 << 8 | var24 & 255;
            var24 = method3080(var0);
            var0.field2376 = var0.field2376 << 8 | var24 & 255;

            int var25;
            for(var25 = 0; var25 < 16; ++var25) {
               var24 = method3081(var0);
               if(var24 == 1) {
                  var0.field2384[var25] = true;
               } else {
                  var0.field2384[var25] = false;
               }
            }

            for(var25 = 0; var25 < 256; ++var25) {
               var0.inUse[var25] = false;
            }

            int var26;
            for(var25 = 0; var25 < 16; ++var25) {
               if(var0.field2384[var25]) {
                  for(var26 = 0; var26 < 16; ++var26) {
                     var24 = method3081(var0);
                     if(var24 == 1) {
                        var0.inUse[var26 + var25 * 16] = true;
                     }
                  }
               }
            }

            method3093(var0);
            int var27 = var0.nInUse + 2;
            int var28 = method3082(3, var0);
            int var29 = method3082(15, var0);

            for(var25 = 0; var25 < var29; ++var25) {
               var26 = 0;

               while(true) {
                  var24 = method3081(var0);
                  if(var24 == 0) {
                     var0.field2389[var25] = (byte)var26;
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
               var31 = var0.field2389[var25];

               byte var32;
               for(var32 = var30[var31]; var31 > 0; --var31) {
                  var30[var31] = var30[var31 - 1];
               }

               var30[0] = var32;
               var0.field2388[var25] = var32;
            }

            int var33;
            int var50;
            for(var50 = 0; var50 < var28; ++var50) {
               var33 = method3082(5, var0);

               for(var25 = 0; var25 < var27; ++var25) {
                  while(true) {
                     var24 = method3081(var0);
                     if(var24 == 0) {
                        var0.field2390[var50][var25] = (byte)var33;
                        break;
                     }

                     var24 = method3081(var0);
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
                  if(var0.field2390[var50][var25] > var34) {
                     var34 = var0.field2390[var50][var25];
                  }

                  if(var0.field2390[var50][var25] < var51) {
                     var51 = var0.field2390[var50][var25];
                  }
               }

               method3084(var0.field2391[var50], var0.field2396[var50], var0.field2366[var50], var0.field2390[var50], var51, var34, var27);
               var0.field2394[var50] = var51;
            }

            var33 = var0.nInUse + 1;
            int var52 = -1;
            byte var35 = 0;

            for(var25 = 0; var25 <= 255; ++var25) {
               var0.field2379[var25] = 0;
            }

            int var36 = 4095;

            int var37;
            int var38;
            for(var37 = 15; var37 >= 0; --var37) {
               for(var38 = 15; var38 >= 0; --var38) {
                  var0.field2393[var36] = (byte)(var38 + var37 * 16);
                  --var36;
               }

               var0.field2387[var37] = var36 + 1;
            }

            int var39 = 0;
            byte var40;
            if(var35 == 0) {
               ++var52;
               var35 = 50;
               var40 = var0.field2388[var52];
               var19 = var0.field2394[var40];
               var20 = var0.field2391[var40];
               var22 = var0.field2366[var40];
               var21 = var0.field2396[var40];
            }

            int var41 = var35 - 1;
            int var42 = var19;

            int var43;
            byte var44;
            for(var43 = method3082(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
               ++var42;
               var44 = method3081(var0);
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
                        var47 = var0.field2387[0];

                        for(var24 = var0.field2393[var47 + var46]; var46 > 3; var46 -= 4) {
                           var48 = var47 + var46;
                           var0.field2393[var48] = var0.field2393[var48 - 1];
                           var0.field2393[var48 - 1] = var0.field2393[var48 - 2];
                           var0.field2393[var48 - 2] = var0.field2393[var48 - 3];
                           var0.field2393[var48 - 3] = var0.field2393[var48 - 4];
                        }

                        while(var46 > 0) {
                           var0.field2393[var47 + var46] = var0.field2393[var47 + var46 - 1];
                           --var46;
                        }

                        var0.field2393[var47] = var24;
                     } else {
                        var48 = var46 / 16;
                        int var49 = var46 % 16;
                        var47 = var0.field2387[var48] + var49;

                        for(var24 = var0.field2393[var47]; var47 > var0.field2387[var48]; --var47) {
                           var0.field2393[var47] = var0.field2393[var47 - 1];
                        }

                        ++var0.field2387[var48];

                        while(var48 > 0) {
                           --var0.field2387[var48];
                           var0.field2393[var0.field2387[var48]] = var0.field2393[var0.field2387[var48 - 1] + 16 - 1];
                           --var48;
                        }

                        --var0.field2387[0];
                        var0.field2393[var0.field2387[0]] = var24;
                        if(var0.field2387[0] == 0) {
                           var36 = 4095;

                           for(var37 = 15; var37 >= 0; --var37) {
                              for(var38 = 15; var38 >= 0; --var38) {
                                 var0.field2393[var36] = var0.field2393[var38 + var0.field2387[var37]];
                                 --var36;
                              }

                              var0.field2387[var37] = var36 + 1;
                           }
                        }
                     }

                     ++var0.field2379[var0.seqToUnseq[var24 & 255] & 255];
                     FrameMap.tt[var39] = var0.seqToUnseq[var24 & 255] & 255;
                     ++var39;
                     if(var41 == 0) {
                        ++var52;
                        var41 = 50;
                        var40 = var0.field2388[var52];
                        var19 = var0.field2394[var40];
                        var20 = var0.field2391[var40];
                        var22 = var0.field2366[var40];
                        var21 = var0.field2396[var40];
                     }

                     --var41;
                     var42 = var19;

                     for(var43 = method3082(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                        ++var42;
                        var44 = method3081(var0);
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
                           var40 = var0.field2388[var52];
                           var19 = var0.field2394[var40];
                           var20 = var0.field2391[var40];
                           var22 = var0.field2366[var40];
                           var21 = var0.field2396[var40];
                        }

                        --var41;
                        var42 = var19;

                        for(var43 = method3082(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                           ++var42;
                           var44 = method3081(var0);
                        }

                        var45 = var22[var43 - var21[var42]];
                     } while(var45 == 0 || var45 == 1);

                     ++var46;
                     var24 = var0.seqToUnseq[var0.field2393[var0.field2387[0]] & 255];

                     for(var0.field2379[var24 & 255] += var46; var46 > 0; --var46) {
                        FrameMap.tt[var39] = var24 & 255;
                        ++var39;
                     }
                  }
               }

               var0.out_len = 0;
               var0.out_ch = 0;
               var0.field2371[0] = 0;

               for(var25 = 1; var25 <= 256; ++var25) {
                  var0.field2371[var25] = var0.field2379[var25 - 1];
               }

               for(var25 = 1; var25 <= 256; ++var25) {
                  var0.field2371[var25] += var0.field2371[var25 - 1];
               }

               for(var25 = 0; var25 < var39; ++var25) {
                  var24 = (byte)(FrameMap.tt[var25] & 255);
                  FrameMap.tt[var0.field2371[var24 & 255]] |= var25 << 8;
                  ++var0.field2371[var24 & 255];
               }

               var0.tPos = FrameMap.tt[var0.field2376] >> 8;
               var0.nblock_used = 0;
               var0.tPos = FrameMap.tt[var0.tPos];
               var0.k0 = (byte)(var0.tPos & 255);
               var0.tPos >>= 8;
               ++var0.nblock_used;
               var0.field2395 = var39;
               method3088(var0);
               if(var0.field2395 + 1 == var0.nblock_used && var0.out_len == 0) {
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

   @ObfuscatedName("v")
   static void method3093(DState var0) {
      var0.nInUse = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if(var0.inUse[var1]) {
            var0.seqToUnseq[var0.nInUse] = (byte)var1;
            ++var0.nInUse;
         }
      }

   }

   static {
      state = new DState();
   }
}
