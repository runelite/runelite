import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ff")
public class class180 extends class208 {
   @ObfuscatedName("s")
   class196 field2943;
   @ObfuscatedName("j")
   byte[] field2944;

   class180(class119 var1) {
      var1.field2005 = var1.field2007.length - 3;
      int var2 = var1.method2492();
      int var3 = var1.method2584();
      int var4 = 14 + var2 * 10;
      var1.field2005 = 0;
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
            var15 = var1.method2492();
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
      var13 = var1.field2005;
      var14 = var2 + var5 + var6 + var7 + var8 + var9 + var10 + var11 + var12;

      for(var15 = 0; var15 < var14; ++var15) {
         var1.method2507();
      }

      var4 += var1.field2005 - var13;
      var15 = var1.field2005;
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
         var28 = var28 + var1.method2492() & 127;
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
      int var30 = var1.field2005;
      var1.field2005 += var26;
      int var31 = var1.field2005;
      var1.field2005 += var11;
      int var32 = var1.field2005;
      var1.field2005 += var10;
      int var33 = var1.field2005;
      var1.field2005 += var9;
      int var34 = var1.field2005;
      var1.field2005 += var16;
      int var35 = var1.field2005;
      var1.field2005 += var18;
      int var36 = var1.field2005;
      var1.field2005 += var20;
      int var37 = var1.field2005;
      var1.field2005 += var7 + var8 + var11;
      int var38 = var1.field2005;
      var1.field2005 += var7;
      int var39 = var1.field2005;
      var1.field2005 += var27;
      int var40 = var1.field2005;
      var1.field2005 += var8;
      int var41 = var1.field2005;
      var1.field2005 += var17;
      int var42 = var1.field2005;
      var1.field2005 += var19;
      int var43 = var1.field2005;
      var1.field2005 += var21;
      int var44 = var1.field2005;
      var1.field2005 += var12;
      int var45 = var1.field2005;
      var1.field2005 += var9;
      int var46 = var1.field2005;
      var1.field2005 += var22;
      int var47 = var1.field2005;
      var1.field2005 += var23;
      int var48 = var1.field2005;
      var1.field2005 += var24;
      int var49 = var1.field2005;
      var1.field2005 += var25;
      int var50 = var1.field2005;
      var1.field2005 += var5 * 3;
      this.field2944 = new byte[var4];
      class119 var51 = new class119(this.field2944);
      var51.method2480(1297377380);
      var51.method2480(6);
      var51.method2661(var2 > 1?1:0);
      var51.method2661(var2);
      var51.method2661(var3);
      var1.field2005 = var13;
      int var52 = 0;
      int var53 = 0;
      int var54 = 0;
      int var55 = 0;
      int var56 = 0;
      int var57 = 0;
      int var58 = 0;
      int[] var59 = new int[128];
      var28 = 0;

      label222:
      for(int var60 = 0; var60 < var2; ++var60) {
         var51.method2480(1297379947);
         var51.field2005 += 4;
         int var61 = var51.field2005;
         int var62 = -1;

         while(true) {
            while(true) {
               int var63 = var1.method2507();
               var51.method2622(var63);
               int var64 = var1.field2007[var29++] & 255;
               boolean var65 = var64 != var62;
               var62 = var64 & 15;
               if(var64 == 7) {
                  if(var65) {
                     var51.method2477(255);
                  }

                  var51.method2477(47);
                  var51.method2477(0);
                  var51.method2487(var51.field2005 - var61);
                  continue label222;
               }

               if(var64 == 23) {
                  if(var65) {
                     var51.method2477(255);
                  }

                  var51.method2477(81);
                  var51.method2477(3);
                  var51.method2477(var1.field2007[var50++]);
                  var51.method2477(var1.field2007[var50++]);
                  var51.method2477(var1.field2007[var50++]);
               } else {
                  var52 ^= var64 >> 4;
                  if(var62 == 0) {
                     if(var65) {
                        var51.method2477(144 + var52);
                     }

                     var53 += var1.field2007[var37++];
                     var54 += var1.field2007[var38++];
                     var51.method2477(var53 & 127);
                     var51.method2477(var54 & 127);
                  } else if(var62 == 1) {
                     if(var65) {
                        var51.method2477(128 + var52);
                     }

                     var53 += var1.field2007[var37++];
                     var55 += var1.field2007[var40++];
                     var51.method2477(var53 & 127);
                     var51.method2477(var55 & 127);
                  } else if(var62 == 2) {
                     if(var65) {
                        var51.method2477(176 + var52);
                     }

                     var28 = var28 + var1.field2007[var15++] & 127;
                     var51.method2477(var28);
                     byte var66;
                     if(var28 != 0 && var28 != 32) {
                        if(var28 == 1) {
                           var66 = var1.field2007[var34++];
                        } else if(var28 == 33) {
                           var66 = var1.field2007[var41++];
                        } else if(var28 == 7) {
                           var66 = var1.field2007[var35++];
                        } else if(var28 == 39) {
                           var66 = var1.field2007[var42++];
                        } else if(var28 == 10) {
                           var66 = var1.field2007[var36++];
                        } else if(var28 == 42) {
                           var66 = var1.field2007[var43++];
                        } else if(var28 == 99) {
                           var66 = var1.field2007[var46++];
                        } else if(var28 == 98) {
                           var66 = var1.field2007[var47++];
                        } else if(var28 == 101) {
                           var66 = var1.field2007[var48++];
                        } else if(var28 == 100) {
                           var66 = var1.field2007[var49++];
                        } else if(var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123) {
                           var66 = var1.field2007[var39++];
                        } else {
                           var66 = var1.field2007[var30++];
                        }
                     } else {
                        var66 = var1.field2007[var44++];
                     }

                     int var67 = var66 + var59[var28];
                     var59[var28] = var67;
                     var51.method2477(var67 & 127);
                  } else if(var62 == 3) {
                     if(var65) {
                        var51.method2477(224 + var52);
                     }

                     var56 += var1.field2007[var45++];
                     var56 += var1.field2007[var33++] << 7;
                     var51.method2477(var56 & 127);
                     var51.method2477(var56 >> 7 & 127);
                  } else if(var62 == 4) {
                     if(var65) {
                        var51.method2477(208 + var52);
                     }

                     var57 += var1.field2007[var32++];
                     var51.method2477(var57 & 127);
                  } else if(var62 == 5) {
                     if(var65) {
                        var51.method2477(160 + var52);
                     }

                     var53 += var1.field2007[var37++];
                     var58 += var1.field2007[var31++];
                     var51.method2477(var53 & 127);
                     var51.method2477(var58 & 127);
                  } else {
                     if(var62 != 6) {
                        throw new RuntimeException();
                     }

                     if(var65) {
                        var51.method2477(192 + var52);
                     }

                     var51.method2477(var1.field2007[var44++]);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   void method3495() {
      this.field2943 = null;
   }

   @ObfuscatedName("j")
   void method3502() {
      if(this.field2943 == null) {
         this.field2943 = new class196(16);
         int[] var1 = new int[16];
         int[] var2 = new int[16];
         var2[9] = 128;
         var1[9] = 128;
         class182 var3 = new class182(this.field2944);
         int var4 = var3.method3561();

         int var5;
         for(var5 = 0; var5 < var4; ++var5) {
            var3.method3517(var5);
            var3.method3520(var5);
            var3.method3557(var5);
         }

         label56:
         do {
            while(true) {
               var5 = var3.method3525();
               int var6 = var3.field2960[var5];

               while(var3.field2960[var5] == var6) {
                  var3.method3517(var5);
                  int var7 = var3.method3521(var5);
                  if(var7 == 1) {
                     var3.method3519();
                     var3.method3557(var5);
                     continue label56;
                  }

                  int var8 = var7 & 240;
                  int var9;
                  int var10;
                  int var11;
                  if(var8 == 176) {
                     var9 = var7 & 15;
                     var10 = var7 >> 8 & 127;
                     var11 = var7 >> 16 & 127;
                     if(var10 == 0) {
                        var1[var9] = (var1[var9] & -2080769) + (var11 << 14);
                     }

                     if(var10 == 32) {
                        var1[var9] = (var1[var9] & -16257) + (var11 << 7);
                     }
                  }

                  if(var8 == 192) {
                     var9 = var7 & 15;
                     var10 = var7 >> 8 & 127;
                     var2[var9] = var1[var9] + var10;
                  }

                  if(var8 == 144) {
                     var9 = var7 & 15;
                     var10 = var7 >> 8 & 127;
                     var11 = var7 >> 16 & 127;
                     if(var11 > 0) {
                        int var12 = var2[var9];
                        class197 var13 = (class197)this.field2943.method3777((long)var12);
                        if(var13 == null) {
                           var13 = new class197(new byte[128]);
                           this.field2943.method3778(var13, (long)var12);
                        }

                        var13.field3104[var10] = 1;
                     }
                  }

                  var3.method3520(var5);
                  var3.method3557(var5);
               }
            }
         } while(!var3.method3526());
      }

   }

   @ObfuscatedName("s")
   static class180 method3504(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3239(var1, var2);
      return var3 == null?null:new class180(new class119(var3));
   }
}
