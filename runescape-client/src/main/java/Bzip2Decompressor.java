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

   @ObfuscatedName("m")
   @Export("Bzip2Decompressor_decompress")
   public static int Bzip2Decompressor_decompress(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      Bzip2State var5 = Bzip2Decompressor_state;
      synchronized(Bzip2Decompressor_state) {
         Bzip2Decompressor_state.field62 = var2;
         Bzip2Decompressor_state.field63 = var4;
         Bzip2Decompressor_state.field65 = var0;
         Bzip2Decompressor_state.field66 = 0;
         Bzip2Decompressor_state.field67 = var1;
         Bzip2Decompressor_state.field72 = 0;
         Bzip2Decompressor_state.field71 = 0;
         Bzip2Decompressor_state.field64 = 0;
         Bzip2Decompressor_state.field68 = 0;
         method3725(Bzip2Decompressor_state);
         var1 -= Bzip2Decompressor_state.field67;
         Bzip2Decompressor_state.field62 = null;
         Bzip2Decompressor_state.field65 = null;
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   static void method3705(Bzip2State var0) {
      byte var1 = var0.field69;
      int var2 = var0.field70;
      int var3 = var0.field78;
      int var4 = var0.field76;
      int[] var5 = WorldMapSection0.field1056;
      int var6 = var0.field75;
      byte[] var7 = var0.field65;
      int var8 = var0.field66;
      int var9 = var0.field67;
      int var10 = var0.field93 + 1;

      label65:
      while (true) {
         if (var2 > 0) {
            while (true) {
               if (var9 == 0) {
                  break label65;
               }

               if (var2 == 1) {
                  if (var9 == 0) {
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
         while (var11) {
            var11 = false;
            if (var3 == var10) {
               var2 = 0;
               break label65;
            }

            var1 = (byte)var4;
            var6 = var5[var6];
            var12 = (byte)(var6 & 255);
            var6 >>= 8;
            ++var3;
            if (var12 != var4) {
               var4 = var12;
               if (var9 == 0) {
                  var2 = 1;
                  break label65;
               }

               var7[var8] = var1;
               ++var8;
               --var9;
               var11 = true;
            } else if (var3 == var10) {
               if (var9 == 0) {
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
         if (var3 != var10) {
            if (var12 != var4) {
               var4 = var12;
            } else {
               var2 = 3;
               var6 = var5[var6];
               var12 = (byte)(var6 & 255);
               var6 >>= 8;
               ++var3;
               if (var3 != var10) {
                  if (var12 != var4) {
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

      int var13 = var0.field68;
      var0.field68 += var9 - var9;
      if (var0.field68 < var13) {
      }

      var0.field69 = var1;
      var0.field70 = var2;
      var0.field78 = var3;
      var0.field76 = var4;
      WorldMapSection0.field1056 = var5;
      var0.field75 = var6;
      var0.field65 = var7;
      var0.field66 = var8;
      var0.field67 = var9;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   static void method3725(Bzip2State var0) {
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
      var0.field73 = 1;
      if (WorldMapSection0.field1056 == null) {
         WorldMapSection0.field1056 = new int[var0.field73 * 100000];
      }

      boolean var23 = true;

      while (true) {
         while (var23) {
            byte var24 = method3707(var0);
            if (var24 == 23) {
               return;
            }

            var24 = method3707(var0);
            var24 = method3707(var0);
            var24 = method3707(var0);
            var24 = method3707(var0);
            var24 = method3707(var0);
            var24 = method3707(var0);
            var24 = method3707(var0);
            var24 = method3707(var0);
            var24 = method3707(var0);
            var24 = method3711(var0);
            if (var24 != 0) {
            }

            var0.field74 = 0;
            var24 = method3707(var0);
            var0.field74 = var0.field74 << 8 | var24 & 255;
            var24 = method3707(var0);
            var0.field74 = var0.field74 << 8 | var24 & 255;
            var24 = method3707(var0);
            var0.field74 = var0.field74 << 8 | var24 & 255;

            int var25;
            for (var25 = 0; var25 < 16; ++var25) {
               var24 = method3711(var0);
               if (var24 == 1) {
                  var0.field82[var25] = true;
               } else {
                  var0.field82[var25] = false;
               }
            }

            for (var25 = 0; var25 < 256; ++var25) {
               var0.field81[var25] = false;
            }

            int var26;
            for (var25 = 0; var25 < 16; ++var25) {
               if (var0.field82[var25]) {
                  for (var26 = 0; var26 < 16; ++var26) {
                     var24 = method3711(var0);
                     if (var24 == 1) {
                        var0.field81[var26 + var25 * 16] = true;
                     }
                  }
               }
            }

            method3710(var0);
            int var27 = var0.field80 + 2;
            int var28 = method3708(3, var0);
            int var29 = method3708(15, var0);

            for (var25 = 0; var25 < var29; ++var25) {
               var26 = 0;

               while (true) {
                  var24 = method3711(var0);
                  if (var24 == 0) {
                     var0.field87[var25] = (byte)var26;
                     break;
                  }

                  ++var26;
               }
            }

            byte[] var30 = new byte[6];

            byte var31;
            for (var31 = 0; var31 < var28; var30[var31] = var31++) {
            }

            for (var25 = 0; var25 < var29; ++var25) {
               var31 = var0.field87[var25];

               byte var32;
               for (var32 = var30[var31]; var31 > 0; --var31) {
                  var30[var31] = var30[var31 - 1];
               }

               var30[0] = var32;
               var0.field86[var25] = var32;
            }

            int var33;
            int var50;
            for (var50 = 0; var50 < var28; ++var50) {
               var33 = method3708(5, var0);

               for (var25 = 0; var25 < var27; ++var25) {
                  while (true) {
                     var24 = method3711(var0);
                     if (var24 == 0) {
                        var0.field88[var50][var25] = (byte)var33;
                        break;
                     }

                     var24 = method3711(var0);
                     if (var24 == 0) {
                        ++var33;
                     } else {
                        --var33;
                     }
                  }
               }
            }

            for (var50 = 0; var50 < var28; ++var50) {
               byte var51 = 32;
               byte var34 = 0;

               for (var25 = 0; var25 < var27; ++var25) {
                  if (var0.field88[var50][var25] > var34) {
                     var34 = var0.field88[var50][var25];
                  }

                  if (var0.field88[var50][var25] < var51) {
                     var51 = var0.field88[var50][var25];
                  }
               }

               method3706(var0.field89[var50], var0.field90[var50], var0.field91[var50], var0.field88[var50], var51, var34, var27);
               var0.field92[var50] = var51;
            }

            var33 = var0.field80 + 1;
            int var52 = -1;
            byte var35 = 0;

            for (var25 = 0; var25 <= 255; ++var25) {
               var0.field77[var25] = 0;
            }

            int var36 = 4095;

            int var37;
            int var38;
            for (var37 = 15; var37 >= 0; --var37) {
               for (var38 = 15; var38 >= 0; --var38) {
                  var0.field84[var36] = (byte)(var38 + var37 * 16);
                  --var36;
               }

               var0.field85[var37] = var36 + 1;
            }

            int var39 = 0;
            byte var40;
            if (var35 == 0) {
               ++var52;
               var35 = 50;
               var40 = var0.field86[var52];
               var19 = var0.field92[var40];
               var20 = var0.field89[var40];
               var22 = var0.field91[var40];
               var21 = var0.field90[var40];
            }

            int var41 = var35 - 1;
            int var42 = var19;

            int var43;
            byte var44;
            for (var43 = method3708(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
               ++var42;
               var44 = method3711(var0);
            }

            int var45 = var22[var43 - var21[var42]];

            while (true) {
               int[] var10000;
               int var54;
               while (var45 != var33) {
                  int var46;
                  int var47;
                  if (var45 != 0 && var45 != 1) {
                     var46 = var45 - 1;
                     int var48;
                     if (var46 < 16) {
                        var47 = var0.field85[0];

                        for (var24 = var0.field84[var47 + var46]; var46 > 3; var46 -= 4) {
                           var48 = var47 + var46;
                           var0.field84[var48] = var0.field84[var48 - 1];
                           var0.field84[var48 - 1] = var0.field84[var48 - 2];
                           var0.field84[var48 - 2] = var0.field84[var48 - 3];
                           var0.field84[var48 - 3] = var0.field84[var48 - 4];
                        }

                        while (var46 > 0) {
                           var0.field84[var47 + var46] = var0.field84[var47 + var46 - 1];
                           --var46;
                        }

                        var0.field84[var47] = var24;
                     } else {
                        var48 = var46 / 16;
                        int var49 = var46 % 16;
                        var47 = var0.field85[var48] + var49;

                        for (var24 = var0.field84[var47]; var47 > var0.field85[var48]; --var47) {
                           var0.field84[var47] = var0.field84[var47 - 1];
                        }

                        for (var54 = var0.field85[var48]++; var48 > 0; --var48) {
                           var54 = var0.field85[var48]--;
                           var0.field84[var0.field85[var48]] = var0.field84[var0.field85[var48 - 1] + 16 - 1];
                        }

                        var54 = var0.field85[0]--;
                        var0.field84[var0.field85[0]] = var24;
                        if (var0.field85[0] == 0) {
                           var36 = 4095;

                           for (var37 = 15; var37 >= 0; --var37) {
                              for (var38 = 15; var38 >= 0; --var38) {
                                 var0.field84[var36] = var0.field84[var0.field85[var37] + var38];
                                 --var36;
                              }

                              var0.field85[var37] = var36 + 1;
                           }
                        }
                     }

                     var54 = var0.field77[var0.field83[var24 & 255] & 255]++;
                     WorldMapSection0.field1056[var39] = var0.field83[var24 & 255] & 255;
                     ++var39;
                     if (var41 == 0) {
                        ++var52;
                        var41 = 50;
                        var40 = var0.field86[var52];
                        var19 = var0.field92[var40];
                        var20 = var0.field89[var40];
                        var22 = var0.field91[var40];
                        var21 = var0.field90[var40];
                     }

                     --var41;
                     var42 = var19;

                     for (var43 = method3708(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                        ++var42;
                        var44 = method3711(var0);
                     }

                     var45 = var22[var43 - var21[var42]];
                  } else {
                     var46 = -1;
                     var47 = 1;

                     do {
                        if (var45 == 0) {
                           var46 += var47;
                        } else if (var45 == 1) {
                           var46 += var47 * 2;
                        }

                        var47 *= 2;
                        if (var41 == 0) {
                           ++var52;
                           var41 = 50;
                           var40 = var0.field86[var52];
                           var19 = var0.field92[var40];
                           var20 = var0.field89[var40];
                           var22 = var0.field91[var40];
                           var21 = var0.field90[var40];
                        }

                        --var41;
                        var42 = var19;

                        for (var43 = method3708(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                           ++var42;
                           var44 = method3711(var0);
                        }

                        var45 = var22[var43 - var21[var42]];
                     } while(var45 == 0 || var45 == 1);

                     ++var46;
                     var24 = var0.field83[var0.field84[var0.field85[0]] & 255];
                     var10000 = var0.field77;

                     for (var10000[var24 & 255] += var46; var46 > 0; --var46) {
                        WorldMapSection0.field1056[var39] = var24 & 255;
                        ++var39;
                     }
                  }
               }

               var0.field70 = 0;
               var0.field69 = 0;
               var0.field79[0] = 0;

               for (var25 = 1; var25 <= 256; ++var25) {
                  var0.field79[var25] = var0.field77[var25 - 1];
               }

               for (var25 = 1; var25 <= 256; ++var25) {
                  var10000 = var0.field79;
                  var10000[var25] += var0.field79[var25 - 1];
               }

               for (var25 = 0; var25 < var39; ++var25) {
                  var24 = (byte)(WorldMapSection0.field1056[var25] & 255);
                  var10000 = WorldMapSection0.field1056;
                  int var53 = var0.field79[var24 & 255];
                  var10000[var53] |= var25 << 8;
                  var54 = var0.field79[var24 & 255]++;
               }

               var0.field75 = WorldMapSection0.field1056[var0.field74] >> 8;
               var0.field78 = 0;
               var0.field75 = WorldMapSection0.field1056[var0.field75];
               var0.field76 = (byte)(var0.field75 & 255);
               var0.field75 >>= 8;
               ++var0.field78;
               var0.field93 = var39;
               method3705(var0);
               if (var0.field93 + 1 == var0.field78 && var0.field70 == 0) {
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
      while (var1.field72 < var0) {
         var1.field71 = var1.field71 << 8 | var1.field62[var1.field63] & 255;
         var1.field72 += 8;
         ++var1.field63;
         ++var1.field64;
         if (var1.field64 == 0) {
         }
      }

      int var2 = var1.field71 >> var1.field72 - var0 & (1 << var0) - 1;
      var1.field72 -= var0;
      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   static void method3710(Bzip2State var0) {
      var0.field80 = 0;

      for (int var1 = 0; var1 < 256; ++var1) {
         if (var0.field81[var1]) {
            var0.field83[var0.field80] = (byte)var1;
            ++var0.field80;
         }
      }

   }

   @ObfuscatedName("l")
   static void method3706(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
      int var7 = 0;

      int var8;
      int var9;
      for (var8 = var4; var8 <= var5; ++var8) {
         for (var9 = 0; var9 < var6; ++var9) {
            if (var8 == var3[var9]) {
               var2[var7] = var9;
               ++var7;
            }
         }
      }

      for (var8 = 0; var8 < 23; ++var8) {
         var1[var8] = 0;
      }

      for (var8 = 0; var8 < var6; ++var8) {
         ++var1[var3[var8] + 1];
      }

      for (var8 = 1; var8 < 23; ++var8) {
         var1[var8] += var1[var8 - 1];
      }

      for (var8 = 0; var8 < 23; ++var8) {
         var0[var8] = 0;
      }

      var9 = 0;

      for (var8 = var4; var8 <= var5; ++var8) {
         var9 += var1[var8 + 1] - var1[var8];
         var0[var8] = var9 - 1;
         var9 <<= 1;
      }

      for (var8 = var4 + 1; var8 <= var5; ++var8) {
         var1[var8] = (var0[var8 - 1] + 1 << 1) - var1[var8];
      }

   }

   static {
      Bzip2Decompressor_state = new Bzip2State();
   }
}
