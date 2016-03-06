import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fs")
public class class179 extends class207 {
   @ObfuscatedName("j")
   class195 field2923;
   @ObfuscatedName("l")
   byte[] field2924;

   class179(class118 var1) {
      var1.field1998 = var1.field1995.length - 3;
      int var2 = var1.method2453();
      int var3 = var1.method2455();
      int var4 = 14 + var2 * 10;
      var1.field1998 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      int var12 = 0;

      int var13;
      int var14;
      int var15;
      for(var13 = 0; var13 < var2; ++var13) {
         var14 = -1;

         while(true) {
            var15 = var1.method2453();
            if(var15 != var14) {
               ++var4;
            }

            var14 = var15 & 15;
            if(var15 == 7) {
               break;
            }

            if(var15 == 23) {
               ++var5;
            } else if(var14 == 0) {
               ++var7;
            } else if(var14 == 1) {
               ++var8;
            } else if(var14 == 2) {
               ++var6;
            } else if(var14 == 3) {
               ++var9;
            } else if(var14 == 4) {
               ++var10;
            } else if(var14 == 5) {
               ++var11;
            } else {
               if(var14 != 6) {
                  throw new RuntimeException();
               }

               ++var12;
            }
         }
      }

      var4 += 5 * var5;
      var4 += 2 * (var7 + var8 + var6 + var9 + var11);
      var4 += var10 + var12;
      var13 = var1.field1998;
      var14 = var2 + var5 + var6 + var7 + var8 + var9 + var10 + var11 + var12;

      for(var15 = 0; var15 < var14; ++var15) {
         var1.method2468();
      }

      var4 += var1.field1998 - var13;
      var15 = var1.field1998;
      int var16 = 0;
      int var17 = 0;
      int var18 = 0;
      int var19 = 0;
      int var20 = 0;
      int var21 = 0;
      int var22 = 0;
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26 = 0;
      int var27 = 0;
      int var28 = 0;

      int var29;
      for(var29 = 0; var29 < var6; ++var29) {
         var28 = var28 + var1.method2453() & 127;
         if(var28 != 0 && var28 != 32) {
            if(var28 == 1) {
               ++var16;
            } else if(var28 == 33) {
               ++var17;
            } else if(var28 == 7) {
               ++var18;
            } else if(var28 == 39) {
               ++var19;
            } else if(var28 == 10) {
               ++var20;
            } else if(var28 == 42) {
               ++var21;
            } else if(var28 == 99) {
               ++var22;
            } else if(var28 == 98) {
               ++var23;
            } else if(var28 == 101) {
               ++var24;
            } else if(var28 == 100) {
               ++var25;
            } else if(var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123) {
               ++var27;
            } else {
               ++var26;
            }
         } else {
            ++var12;
         }
      }

      var29 = 0;
      int var30 = var1.field1998;
      var1.field1998 += var26;
      int var31 = var1.field1998;
      var1.field1998 += var11;
      int var32 = var1.field1998;
      var1.field1998 += var10;
      int var33 = var1.field1998;
      var1.field1998 += var9;
      int var34 = var1.field1998;
      var1.field1998 += var16;
      int var35 = var1.field1998;
      var1.field1998 += var18;
      int var36 = var1.field1998;
      var1.field1998 += var20;
      int var37 = var1.field1998;
      var1.field1998 += var7 + var8 + var11;
      int var38 = var1.field1998;
      var1.field1998 += var7;
      int var39 = var1.field1998;
      var1.field1998 += var27;
      int var40 = var1.field1998;
      var1.field1998 += var8;
      int var41 = var1.field1998;
      var1.field1998 += var17;
      int var42 = var1.field1998;
      var1.field1998 += var19;
      int var43 = var1.field1998;
      var1.field1998 += var21;
      int var44 = var1.field1998;
      var1.field1998 += var12;
      int var45 = var1.field1998;
      var1.field1998 += var9;
      int var46 = var1.field1998;
      var1.field1998 += var22;
      int var47 = var1.field1998;
      var1.field1998 += var23;
      int var48 = var1.field1998;
      var1.field1998 += var24;
      int var49 = var1.field1998;
      var1.field1998 += var25;
      int var50 = var1.field1998;
      var1.field1998 += var5 * 3;
      this.field2924 = new byte[var4];
      class118 var51 = new class118(this.field2924);
      var51.method2441(1297377380);
      var51.method2441(6);
      var51.method2541(var2 > 1?1:0);
      var51.method2541(var2);
      var51.method2541(var3);
      var1.field1998 = var13;
      int var52 = 0;
      int var53 = 0;
      int var54 = 0;
      int var55 = 0;
      int var56 = 0;
      int var57 = 0;
      int var58 = 0;
      int[] var59 = new int[128];
      var28 = 0;

      label359:
      for(int var60 = 0; var60 < var2; ++var60) {
         var51.method2441(1297379947);
         var51.field1998 += 4;
         int var61 = var51.field1998;
         int var62 = -1;

         while(true) {
            while(true) {
               int var63 = var1.method2468();
               var51.method2452(var63);
               int var64 = var1.field1995[var29++] & 255;
               boolean var65 = var64 != var62;
               var62 = var64 & 15;
               if(var64 == 7) {
                  if(var65) {
                     var51.method2438(255);
                  }

                  var51.method2438(47);
                  var51.method2438(0);
                  var51.method2448(var51.field1998 - var61);
                  continue label359;
               }

               if(var64 == 23) {
                  if(var65) {
                     var51.method2438(255);
                  }

                  var51.method2438(81);
                  var51.method2438(3);
                  var51.method2438(var1.field1995[var50++]);
                  var51.method2438(var1.field1995[var50++]);
                  var51.method2438(var1.field1995[var50++]);
               } else {
                  var52 ^= var64 >> 4;
                  if(var62 == 0) {
                     if(var65) {
                        var51.method2438(144 + var52);
                     }

                     var53 += var1.field1995[var37++];
                     var54 += var1.field1995[var38++];
                     var51.method2438(var53 & 127);
                     var51.method2438(var54 & 127);
                  } else if(var62 == 1) {
                     if(var65) {
                        var51.method2438(128 + var52);
                     }

                     var53 += var1.field1995[var37++];
                     var55 += var1.field1995[var40++];
                     var51.method2438(var53 & 127);
                     var51.method2438(var55 & 127);
                  } else if(var62 == 2) {
                     if(var65) {
                        var51.method2438(176 + var52);
                     }

                     var28 = var28 + var1.field1995[var15++] & 127;
                     var51.method2438(var28);
                     byte var66;
                     if(var28 != 0 && var28 != 32) {
                        if(var28 == 1) {
                           var66 = var1.field1995[var34++];
                        } else if(var28 == 33) {
                           var66 = var1.field1995[var41++];
                        } else if(var28 == 7) {
                           var66 = var1.field1995[var35++];
                        } else if(var28 == 39) {
                           var66 = var1.field1995[var42++];
                        } else if(var28 == 10) {
                           var66 = var1.field1995[var36++];
                        } else if(var28 == 42) {
                           var66 = var1.field1995[var43++];
                        } else if(var28 == 99) {
                           var66 = var1.field1995[var46++];
                        } else if(var28 == 98) {
                           var66 = var1.field1995[var47++];
                        } else if(var28 == 101) {
                           var66 = var1.field1995[var48++];
                        } else if(var28 == 100) {
                           var66 = var1.field1995[var49++];
                        } else if(var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123) {
                           var66 = var1.field1995[var39++];
                        } else {
                           var66 = var1.field1995[var30++];
                        }
                     } else {
                        var66 = var1.field1995[var44++];
                     }

                     int var67 = var66 + var59[var28];
                     var59[var28] = var67;
                     var51.method2438(var67 & 127);
                  } else if(var62 == 3) {
                     if(var65) {
                        var51.method2438(224 + var52);
                     }

                     var56 += var1.field1995[var45++];
                     var56 += var1.field1995[var33++] << 7;
                     var51.method2438(var56 & 127);
                     var51.method2438(var56 >> 7 & 127);
                  } else if(var62 == 4) {
                     if(var65) {
                        var51.method2438(208 + var52);
                     }

                     var57 += var1.field1995[var32++];
                     var51.method2438(var57 & 127);
                  } else if(var62 == 5) {
                     if(var65) {
                        var51.method2438(160 + var52);
                     }

                     var53 += var1.field1995[var37++];
                     var58 += var1.field1995[var31++];
                     var51.method2438(var53 & 127);
                     var51.method2438(var58 & 127);
                  } else {
                     if(var62 != 6) {
                        throw new RuntimeException();
                     }

                     if(var65) {
                        var51.method2438(192 + var52);
                     }

                     var51.method2438(var1.field1995[var44++]);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   void method3461() {
      if(this.field2923 == null) {
         this.field2923 = new class195(16);
         int[] var1 = new int[16];
         int[] var2 = new int[16];
         var2[9] = 128;
         var1[9] = 128;
         class181 var4 = new class181(this.field2924);
         int var5 = var4.method3482();

         int var6;
         for(var6 = 0; var6 < var5; ++var6) {
            var4.method3483(var6);
            var4.method3486(var6);
            var4.method3484(var6);
         }

         label76:
         do {
            while(true) {
               var6 = var4.method3491();
               int var7 = var4.field2941[var6];

               while(var4.field2941[var6] == var7) {
                  var4.method3483(var6);
                  int var8 = var4.method3526(var6);
                  if(var8 == 1) {
                     var4.method3485();
                     var4.method3484(var6);
                     continue label76;
                  }

                  int var9 = var8 & 240;
                  int var10;
                  int var11;
                  int var12;
                  if(var9 == 176) {
                     var10 = var8 & 15;
                     var11 = var8 >> 8 & 127;
                     var12 = var8 >> 16 & 127;
                     if(var11 == 0) {
                        var1[var10] = (var1[var10] & -2080769) + (var12 << 14);
                     }

                     if(var11 == 32) {
                        var1[var10] = (var1[var10] & -16257) + (var12 << 7);
                     }
                  }

                  if(var9 == 192) {
                     var10 = var8 & 15;
                     var11 = var8 >> 8 & 127;
                     var2[var10] = var1[var10] + var11;
                  }

                  if(var9 == 144) {
                     var10 = var8 & 15;
                     var11 = var8 >> 8 & 127;
                     var12 = var8 >> 16 & 127;
                     if(var12 > 0) {
                        int var13 = var2[var10];
                        class196 var14 = (class196)this.field2923.method3744((long)var13);
                        if(var14 == null) {
                           var14 = new class196(new byte[128]);
                           this.field2923.method3746(var14, (long)var13);
                        }

                        var14.field3090[var11] = 1;
                     }
                  }

                  var4.method3486(var6);
                  var4.method3484(var6);
               }
            }
         } while(!var4.method3479());

      }
   }

   @ObfuscatedName("a")
   void method3462() {
      this.field2923 = null;
   }

   @ObfuscatedName("j")
   public static class179 method3467(class166 var0, int var1, int var2) {
      byte[] var3 = var0.method3214(var1, var2);
      return var3 == null?null:new class179(new class118(var3));
   }
}
