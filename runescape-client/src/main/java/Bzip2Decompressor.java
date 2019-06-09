import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("Bzip2Decompressor")
public final class Bzip2Decompressor {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("Bzip2Decompressor_state")
   static Bzip2State Bzip2Decompressor_state;

   static {
      Bzip2Decompressor_state = new Bzip2State();
   }

   @ObfuscatedName("m")
   @Export("Bzip2Decompressor_decompress")
   public static int Bzip2Decompressor_decompress(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      Bzip2State var5 = Bzip2Decompressor_state;
      synchronized(Bzip2Decompressor_state) {
         Bzip2Decompressor_state.__g = var2;
         Bzip2Decompressor_state.__l = var4;
         Bzip2Decompressor_state.__x = var0;
         Bzip2Decompressor_state.__d = 0;
         Bzip2Decompressor_state.__k = var1;
         Bzip2Decompressor_state.__j = 0;
         Bzip2Decompressor_state.__z = 0;
         Bzip2Decompressor_state.__e = 0;
         Bzip2Decompressor_state.__n = 0;
         method3725(Bzip2Decompressor_state);
         var1 -= Bzip2Decompressor_state.__k;
         Bzip2Decompressor_state.__g = null;
         Bzip2Decompressor_state.__x = null;
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   static void method3705(Bzip2State var0) {
      byte var2 = var0.__i;
      int var3 = var0.__a;
      int var4 = var0.__c;
      int var5 = var0.__h;
      int[] var6 = WorldMapSection0.__y_p;
      int var7 = var0.__y;
      byte[] var8 = var0.__x;
      int var9 = var0.__d;
      int var10 = var0.__k;
      int var12 = var0.__ae + 1;

      label65:
      while(true) {
         if(var3 > 0) {
            while(true) {
               if(var10 == 0) {
                  break label65;
               }

               if(var3 == 1) {
                  if(var10 == 0) {
                     var3 = 1;
                     break label65;
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
               break label65;
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
                  break label65;
               }

               var8[var9] = var2;
               ++var9;
               --var10;
               var14 = true;
            } else if(var4 == var12) {
               if(var10 == 0) {
                  var3 = 1;
                  break label65;
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

      int var13 = var0.__n;
      var0.__n += var10 - var10;
      if(var0.__n < var13) {
         ;
      }

      var0.__i = var2;
      var0.__a = var3;
      var0.__c = var4;
      var0.__h = var5;
      WorldMapSection0.__y_p = var6;
      var0.__y = var7;
      var0.__x = var8;
      var0.__d = var9;
      var0.__k = var10;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   static void method3725(Bzip2State var0) {
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
      var0.__s = 1;
      if(WorldMapSection0.__y_p == null) {
         WorldMapSection0.__y_p = new int[var0.__s * 100000];
      }

      boolean var26 = true;

      while(true) {
         while(var26) {
            byte var1 = method3707(var0);
            if(var1 == 23) {
               return;
            }

            var1 = method3707(var0);
            var1 = method3707(var0);
            var1 = method3707(var0);
            var1 = method3707(var0);
            var1 = method3707(var0);
            var1 = method3707(var0);
            var1 = method3707(var0);
            var1 = method3707(var0);
            var1 = method3707(var0);
            var1 = method3711(var0);
            if(var1 != 0) {
               ;
            }

            var0.__t = 0;
            var1 = method3707(var0);
            var0.__t = var0.__t << 8 | var1 & 255;
            var1 = method3707(var0);
            var0.__t = var0.__t << 8 | var1 & 255;
            var1 = method3707(var0);
            var0.__t = var0.__t << 8 | var1 & 255;

            int var36;
            for(var36 = 0; var36 < 16; ++var36) {
               var1 = method3711(var0);
               if(var1 == 1) {
                  var0.__aq[var36] = true;
               } else {
                  var0.__aq[var36] = false;
               }
            }

            for(var36 = 0; var36 < 256; ++var36) {
               var0.__ag[var36] = false;
            }

            int var37;
            for(var36 = 0; var36 < 16; ++var36) {
               if(var0.__aq[var36]) {
                  for(var37 = 0; var37 < 16; ++var37) {
                     var1 = method3711(var0);
                     if(var1 == 1) {
                        var0.__ag[var37 + var36 * 16] = true;
                     }
                  }
               }
            }

            method3710(var0);
            int var39 = var0.__v + 2;
            int var40 = method3708(3, var0);
            int var41 = method3708(15, var0);

            for(var36 = 0; var36 < var41; ++var36) {
               var37 = 0;

               while(true) {
                  var1 = method3711(var0);
                  if(var1 == 0) {
                     var0.__ay[var36] = (byte)var37;
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
               var29 = var0.__ay[var36];

               byte var28;
               for(var28 = var27[var29]; var29 > 0; --var29) {
                  var27[var29] = var27[var29 - 1];
               }

               var27[0] = var28;
               var0.__ac[var36] = var28;
            }

            int var38;
            for(var38 = 0; var38 < var40; ++var38) {
               int var50 = method3708(5, var0);

               for(var36 = 0; var36 < var39; ++var36) {
                  while(true) {
                     var1 = method3711(var0);
                     if(var1 == 0) {
                        var0.__ah[var38][var36] = (byte)var50;
                        break;
                     }

                     var1 = method3711(var0);
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
                  if(var0.__ah[var38][var36] > var3) {
                     var3 = var0.__ah[var38][var36];
                  }

                  if(var0.__ah[var38][var36] < var2) {
                     var2 = var0.__ah[var38][var36];
                  }
               }

               method3706(var0.__ak[var38], var0.__aw[var38], var0.__al[var38], var0.__ah[var38], var2, var3, var39);
               var0.__ab[var38] = var2;
            }

            int var42 = var0.__v + 1;
            int var43 = -1;
            byte var44 = 0;

            for(var36 = 0; var36 <= 255; ++var36) {
               var0.__b[var36] = 0;
            }

            int var56 = 4095;

            int var35;
            int var55;
            for(var35 = 15; var35 >= 0; --var35) {
               for(var55 = 15; var55 >= 0; --var55) {
                  var0.__av[var56] = (byte)(var55 + var35 * 16);
                  --var56;
               }

               var0.__ar[var35] = var56 + 1;
            }

            int var47 = 0;
            byte var54;
            if(var44 == 0) {
               ++var43;
               var44 = 50;
               var54 = var0.__ac[var43];
               var22 = var0.__ab[var54];
               var23 = var0.__ak[var54];
               var25 = var0.__al[var54];
               var24 = var0.__aw[var54];
            }

            int var45 = var44 - 1;
            int var51 = var22;

            int var52;
            byte var53;
            for(var52 = method3708(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
               ++var51;
               var53 = method3711(var0);
            }

            int var46 = var25[var52 - var24[var51]];

            while(true) {
               while(var46 != var42) {
                  if(var46 != 0 && var46 != 1) {
                     int var33 = var46 - 1;
                     int var30;
                     if(var33 < 16) {
                        var30 = var0.__ar[0];

                        for(var1 = var0.__av[var30 + var33]; var33 > 3; var33 -= 4) {
                           int var34 = var30 + var33;
                           var0.__av[var34] = var0.__av[var34 - 1];
                           var0.__av[var34 - 1] = var0.__av[var34 - 2];
                           var0.__av[var34 - 2] = var0.__av[var34 - 3];
                           var0.__av[var34 - 3] = var0.__av[var34 - 4];
                        }

                        while(var33 > 0) {
                           var0.__av[var30 + var33] = var0.__av[var30 + var33 - 1];
                           --var33;
                        }

                        var0.__av[var30] = var1;
                     } else {
                        int var31 = var33 / 16;
                        int var32 = var33 % 16;
                        var30 = var0.__ar[var31] + var32;

                        for(var1 = var0.__av[var30]; var30 > var0.__ar[var31]; --var30) {
                           var0.__av[var30] = var0.__av[var30 - 1];
                        }

                        ++var0.__ar[var31];

                        while(var31 > 0) {
                           --var0.__ar[var31];
                           var0.__av[var0.__ar[var31]] = var0.__av[var0.__ar[var31 - 1] + 16 - 1];
                           --var31;
                        }

                        --var0.__ar[0];
                        var0.__av[var0.__ar[0]] = var1;
                        if(var0.__ar[0] == 0) {
                           var56 = 4095;

                           for(var35 = 15; var35 >= 0; --var35) {
                              for(var55 = 15; var55 >= 0; --var55) {
                                 var0.__av[var56] = var0.__av[var0.__ar[var35] + var55];
                                 --var56;
                              }

                              var0.__ar[var35] = var56 + 1;
                           }
                        }
                     }

                     ++var0.__b[var0.__aj[var1 & 255] & 255];
                     WorldMapSection0.__y_p[var47] = var0.__aj[var1 & 255] & 255;
                     ++var47;
                     if(var45 == 0) {
                        ++var43;
                        var45 = 50;
                        var54 = var0.__ac[var43];
                        var22 = var0.__ab[var54];
                        var23 = var0.__ak[var54];
                        var25 = var0.__al[var54];
                        var24 = var0.__aw[var54];
                     }

                     --var45;
                     var51 = var22;

                     for(var52 = method3708(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
                        ++var51;
                        var53 = method3711(var0);
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
                           var54 = var0.__ac[var43];
                           var22 = var0.__ab[var54];
                           var23 = var0.__ak[var54];
                           var25 = var0.__al[var54];
                           var24 = var0.__aw[var54];
                        }

                        --var45;
                        var51 = var22;

                        for(var52 = method3708(var22, var0); var52 > var23[var51]; var52 = var52 << 1 | var53) {
                           ++var51;
                           var53 = method3711(var0);
                        }

                        var46 = var25[var52 - var24[var51]];
                     } while(var46 == 0 || var46 == 1);

                     ++var48;
                     var1 = var0.__aj[var0.__av[var0.__ar[0]] & 255];

                     for(var0.__b[var1 & 255] += var48; var48 > 0; --var48) {
                        WorldMapSection0.__y_p[var47] = var1 & 255;
                        ++var47;
                     }
                  }
               }

               var0.__a = 0;
               var0.__i = 0;
               var0.__r[0] = 0;

               for(var36 = 1; var36 <= 256; ++var36) {
                  var0.__r[var36] = var0.__b[var36 - 1];
               }

               for(var36 = 1; var36 <= 256; ++var36) {
                  var0.__r[var36] += var0.__r[var36 - 1];
               }

               for(var36 = 0; var36 < var47; ++var36) {
                  var1 = (byte)(WorldMapSection0.__y_p[var36] & 255);
                  WorldMapSection0.__y_p[var0.__r[var1 & 255]] |= var36 << 8;
                  ++var0.__r[var1 & 255];
               }

               var0.__y = WorldMapSection0.__y_p[var0.__t] >> 8;
               var0.__c = 0;
               var0.__y = WorldMapSection0.__y_p[var0.__y];
               var0.__h = (byte)(var0.__y & 255);
               var0.__y >>= 8;
               ++var0.__c;
               var0.__ae = var47;
               method3705(var0);
               if(var0.__ae + 1 == var0.__c && var0.__a == 0) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgt;)B"
   )
   static byte method3707(Bzip2State var0) {
      return (byte)method3708(8, var0);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgt;)B"
   )
   static byte method3711(Bzip2State var0) {
      return (byte)method3708(1, var0);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILgt;)I"
   )
   static int method3708(int var0, Bzip2State var1) {
      while(var1.__j < var0) {
         var1.__z = var1.__z << 8 | var1.__g[var1.__l] & 255;
         var1.__j += 8;
         ++var1.__l;
         ++var1.__e;
         if(var1.__e == 0) {
            ;
         }
      }

      int var3 = var1.__z >> var1.__j - var0 & (1 << var0) - 1;
      var1.__j -= var0;
      return var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   static void method3710(Bzip2State var0) {
      var0.__v = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if(var0.__ag[var1]) {
            var0.__aj[var0.__v] = (byte)var1;
            ++var0.__v;
         }
      }

   }

   @ObfuscatedName("l")
   static void method3706(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
      int var7 = 0;

      int var8;
      for(var8 = var4; var8 <= var5; ++var8) {
         for(int var9 = 0; var9 < var6; ++var9) {
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
}
