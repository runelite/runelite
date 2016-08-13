import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public final class class120 {
   @ObfuscatedName("n")
   static class113 field2040 = new class113();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI[BII)I",
      garbageValue = "9"
   )
   public static int method2577(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      class113 var5 = field2040;
      class113 var6 = field2040;
      synchronized(field2040) {
         field2040.field1980 = var2;
         field2040.field1978 = var4;
         field2040.field1983 = var0;
         field2040.field2011 = 0;
         field2040.field1984 = var1;
         field2040.field1990 = 0;
         field2040.field1987 = 0;
         field2040.field1999 = 0;
         field2040.field1986 = 0;
         method2579(field2040);
         var1 -= field2040.field1984;
         field2040.field1980 = null;
         field2040.field1983 = null;
         return var1;
      }
   }

   @ObfuscatedName("g")
   static void method2578(class113 var0) {
      byte var1 = var0.field2003;
      int var2 = var0.field1988;
      int var3 = var0.field1996;
      int var4 = var0.field1989;
      int[] var5 = class85.field1508;
      int var6 = var0.field1993;
      byte[] var7 = var0.field1983;
      int var8 = var0.field2011;
      int var9 = var0.field1984;
      int var10 = var0.field1992 + 1;

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

      int var13 = var0.field1986;
      var0.field1986 += var9 - var9;
      if(var0.field1986 < var13) {
         ;
      }

      var0.field2003 = var1;
      var0.field1988 = var2;
      var0.field1996 = var3;
      var0.field1989 = var4;
      class85.field1508 = var5;
      var0.field1993 = var6;
      var0.field1983 = var7;
      var0.field2011 = var8;
      var0.field1984 = var9;
   }

   @ObfuscatedName("r")
   static void method2579(class113 var0) {
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
      var0.field1982 = 1;
      if(class85.field1508 == null) {
         class85.field1508 = new int[var0.field1982 * 100000];
      }

      boolean var23 = true;

      while(true) {
         while(var23) {
            byte var24 = method2580(var0);
            if(var24 == 23) {
               return;
            }

            var24 = method2580(var0);
            var24 = method2580(var0);
            var24 = method2580(var0);
            var24 = method2580(var0);
            var24 = method2580(var0);
            var24 = method2580(var0);
            var24 = method2580(var0);
            var24 = method2580(var0);
            var24 = method2580(var0);
            var24 = method2581(var0);
            if(var24 != 0) {
               ;
            }

            var0.field1995 = 0;
            var24 = method2580(var0);
            var0.field1995 = var0.field1995 << 8 | var24 & 255;
            var24 = method2580(var0);
            var0.field1995 = var0.field1995 << 8 | var24 & 255;
            var24 = method2580(var0);
            var0.field1995 = var0.field1995 << 8 | var24 & 255;

            int var25;
            for(var25 = 0; var25 < 16; ++var25) {
               var24 = method2581(var0);
               if(var24 == 1) {
                  var0.field2000[var25] = true;
               } else {
                  var0.field2000[var25] = false;
               }
            }

            for(var25 = 0; var25 < 256; ++var25) {
               var0.field1974[var25] = false;
            }

            int var26;
            for(var25 = 0; var25 < 16; ++var25) {
               if(var0.field2000[var25]) {
                  for(var26 = 0; var26 < 16; ++var26) {
                     var24 = method2581(var0);
                     if(var24 == 1) {
                        var0.field1974[var25 * 16 + var26] = true;
                     }
                  }
               }
            }

            method2601(var0);
            int var27 = var0.field1998 + 2;
            int var28 = method2606(3, var0);
            int var29 = method2606(15, var0);

            for(var25 = 0; var25 < var29; ++var25) {
               var26 = 0;

               while(true) {
                  var24 = method2581(var0);
                  if(var24 == 0) {
                     var0.field2005[var25] = (byte)var26;
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
               var31 = var0.field2005[var25];

               byte var32;
               for(var32 = var30[var31]; var31 > 0; --var31) {
                  var30[var31] = var30[var31 - 1];
               }

               var30[0] = var32;
               var0.field2004[var25] = var32;
            }

            int var33;
            int var50;
            for(var50 = 0; var50 < var28; ++var50) {
               var33 = method2606(5, var0);

               for(var25 = 0; var25 < var27; ++var25) {
                  while(true) {
                     var24 = method2581(var0);
                     if(var24 == 0) {
                        var0.field2006[var50][var25] = (byte)var33;
                        break;
                     }

                     var24 = method2581(var0);
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
                  if(var0.field2006[var50][var25] > var34) {
                     var34 = var0.field2006[var50][var25];
                  }

                  if(var0.field2006[var50][var25] < var51) {
                     var51 = var0.field2006[var50][var25];
                  }
               }

               method2583(var0.field2007[var50], var0.field2008[var50], var0.field1994[var50], var0.field2006[var50], var51, var34, var27);
               var0.field2010[var50] = var51;
            }

            var33 = var0.field1998 + 1;
            int var52 = -1;
            byte var35 = 0;

            for(var25 = 0; var25 <= 255; ++var25) {
               var0.field1981[var25] = 0;
            }

            int var36 = 4095;

            int var37;
            int var38;
            for(var37 = 15; var37 >= 0; --var37) {
               for(var38 = 15; var38 >= 0; --var38) {
                  var0.field2009[var36] = (byte)(var37 * 16 + var38);
                  --var36;
               }

               var0.field2002[var37] = var36 + 1;
            }

            int var39 = 0;
            byte var40;
            if(var35 == 0) {
               ++var52;
               var35 = 50;
               var40 = var0.field2004[var52];
               var19 = var0.field2010[var40];
               var20 = var0.field2007[var40];
               var22 = var0.field1994[var40];
               var21 = var0.field2008[var40];
            }

            int var41 = var35 - 1;
            int var42 = var19;

            int var43;
            byte var44;
            for(var43 = method2606(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
               ++var42;
               var44 = method2581(var0);
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
                        var47 = var0.field2002[0];

                        for(var24 = var0.field2009[var47 + var46]; var46 > 3; var46 -= 4) {
                           var48 = var47 + var46;
                           var0.field2009[var48] = var0.field2009[var48 - 1];
                           var0.field2009[var48 - 1] = var0.field2009[var48 - 2];
                           var0.field2009[var48 - 2] = var0.field2009[var48 - 3];
                           var0.field2009[var48 - 3] = var0.field2009[var48 - 4];
                        }

                        while(var46 > 0) {
                           var0.field2009[var47 + var46] = var0.field2009[var47 + var46 - 1];
                           --var46;
                        }

                        var0.field2009[var47] = var24;
                     } else {
                        var48 = var46 / 16;
                        int var49 = var46 % 16;
                        var47 = var0.field2002[var48] + var49;

                        for(var24 = var0.field2009[var47]; var47 > var0.field2002[var48]; --var47) {
                           var0.field2009[var47] = var0.field2009[var47 - 1];
                        }

                        ++var0.field2002[var48];

                        while(var48 > 0) {
                           --var0.field2002[var48];
                           var0.field2009[var0.field2002[var48]] = var0.field2009[var0.field2002[var48 - 1] + 16 - 1];
                           --var48;
                        }

                        --var0.field2002[0];
                        var0.field2009[var0.field2002[0]] = var24;
                        if(var0.field2002[0] == 0) {
                           var36 = 4095;

                           for(var37 = 15; var37 >= 0; --var37) {
                              for(var38 = 15; var38 >= 0; --var38) {
                                 var0.field2009[var36] = var0.field2009[var0.field2002[var37] + var38];
                                 --var36;
                              }

                              var0.field2002[var37] = var36 + 1;
                           }
                        }
                     }

                     ++var0.field1981[var0.field2001[var24 & 255] & 255];
                     class85.field1508[var39] = var0.field2001[var24 & 255] & 255;
                     ++var39;
                     if(var41 == 0) {
                        ++var52;
                        var41 = 50;
                        var40 = var0.field2004[var52];
                        var19 = var0.field2010[var40];
                        var20 = var0.field2007[var40];
                        var22 = var0.field1994[var40];
                        var21 = var0.field2008[var40];
                     }

                     --var41;
                     var42 = var19;

                     for(var43 = method2606(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                        ++var42;
                        var44 = method2581(var0);
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
                           var40 = var0.field2004[var52];
                           var19 = var0.field2010[var40];
                           var20 = var0.field2007[var40];
                           var22 = var0.field1994[var40];
                           var21 = var0.field2008[var40];
                        }

                        --var41;
                        var42 = var19;

                        for(var43 = method2606(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
                           ++var42;
                           var44 = method2581(var0);
                        }

                        var45 = var22[var43 - var21[var42]];
                     } while(var45 == 0 || var45 == 1);

                     ++var46;
                     var24 = var0.field2001[var0.field2009[var0.field2002[0]] & 255];

                     for(var0.field1981[var24 & 255] += var46; var46 > 0; --var46) {
                        class85.field1508[var39] = var24 & 255;
                        ++var39;
                     }
                  }
               }

               var0.field1988 = 0;
               var0.field2003 = 0;
               var0.field1997[0] = 0;

               for(var25 = 1; var25 <= 256; ++var25) {
                  var0.field1997[var25] = var0.field1981[var25 - 1];
               }

               for(var25 = 1; var25 <= 256; ++var25) {
                  var0.field1997[var25] += var0.field1997[var25 - 1];
               }

               for(var25 = 0; var25 < var39; ++var25) {
                  var24 = (byte)(class85.field1508[var25] & 255);
                  class85.field1508[var0.field1997[var24 & 255]] |= var25 << 8;
                  ++var0.field1997[var24 & 255];
               }

               var0.field1993 = class85.field1508[var0.field1995] >> 8;
               var0.field1996 = 0;
               var0.field1993 = class85.field1508[var0.field1993];
               var0.field1989 = (byte)(var0.field1993 & 255);
               var0.field1993 >>= 8;
               ++var0.field1996;
               var0.field1992 = var39;
               method2578(var0);
               if(var0.field1996 == var0.field1992 + 1 && var0.field1988 == 0) {
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

   @ObfuscatedName("e")
   static byte method2580(class113 var0) {
      return (byte)method2606(8, var0);
   }

   @ObfuscatedName("h")
   static byte method2581(class113 var0) {
      return (byte)method2606(1, var0);
   }

   @ObfuscatedName("u")
   static void method2583(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
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

   @ObfuscatedName("k")
   static void method2601(class113 var0) {
      var0.field1998 = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if(var0.field1974[var1]) {
            var0.field2001[var0.field1998] = (byte)var1;
            ++var0.field1998;
         }
      }

   }

   @ObfuscatedName("s")
   static int method2606(int var0, class113 var1) {
      while(var1.field1990 < var0) {
         var1.field1987 = var1.field1987 << 8 | var1.field1980[var1.field1978] & 255;
         var1.field1990 += 8;
         ++var1.field1978;
         ++var1.field1999;
         if(var1.field1999 == 0) {
            ;
         }
      }

      int var2 = var1.field1987 >> var1.field1990 - var0 & (1 << var0) - 1;
      var1.field1990 -= var0;
      return var2;
   }
}
