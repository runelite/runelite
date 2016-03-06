package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("db")
public final class class121 extends class118 {
   @ObfuscatedName("k")
   static final int[] field2009 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1820662401
   )
   int field2010;
   @ObfuscatedName("n")
   class122 field2013;

   @ObfuscatedName("hc")
   public void method2685(int[] var1) {
      this.field2013 = new class122(var1);
   }

   @ObfuscatedName("hp")
   public void method2686(int var1) {
      super.field1995[++super.field1998 - 1] = (byte)(var1 + this.field2013.method2717());
   }

   @ObfuscatedName("hr")
   public int method2687() {
      return super.field1995[++super.field1998 - 1] - this.field2013.method2717() & 255;
   }

   @ObfuscatedName("hj")
   public void method2688() {
      this.field2010 = super.field1998 * 8;
   }

   @ObfuscatedName("he")
   public int method2689(int var1) {
      int var2 = this.field2010 >> 3;
      int var3 = 8 - (this.field2010 & 7);
      int var4 = 0;

      for(this.field2010 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field1995[var2++] & field2009[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.field1995[var2] & field2009[var3];
      } else {
         var4 += super.field1995[var2] >> var3 - var1 & field2009[var1];
      }

      return var4;
   }

   @ObfuscatedName("hs")
   public void method2690() {
      super.field1998 = (this.field2010 + 7) / 8;
   }

   public class121(int var1) {
      super(var1);
   }

   @ObfuscatedName("hd")
   public int method2691(int var1) {
      return var1 * 8 - this.field2010;
   }

   @ObfuscatedName("j")
   static class132 method2700() {
      try {
         return new class146();
      } catch (Throwable var1) {
         return new class140();
      }
   }

   @ObfuscatedName("m")
   static final void method2706(int var0, int var1, int var2, int var3, int var4, int var5, class85 var6, class107 var7) {
      if(!client.field457 || 0 != (class5.field81[0][var1][var2] & 2) || (class5.field81[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field82) {
            class5.field82 = var0;
         }

         class40 var8 = class48.method996(var3);
         int var9;
         int var10;
         if(1 != var4 && 3 != var4) {
            var9 = var8.field932;
            var10 = var8.field933;
         } else {
            var9 = var8.field933;
            var10 = var8.field932;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = var1 + (1 + var9 >> 1);
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (1 + var10 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class5.field93[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var12][var13] + var15[var11][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + (var3 << 14) + (var2 << 7) + var1;
         if(0 == var8.field936) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(1 == var8.field917) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method809()) {
            class23 var21 = new class23();
            var21.field603 = var0;
            var21.field602 = var1 * 128;
            var21.field605 = var2 * 128;
            var22 = var8.field932;
            var23 = var8.field933;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.field933;
               var23 = var8.field932;
            }

            var21.field610 = (var1 + var22) * 128;
            var21.field607 = (var2 + var23) * 128;
            var21.field609 = var8.field967;
            var21.field608 = var8.field962 * 128;
            var21.field611 = var8.field963;
            var21.field614 = var8.field964;
            var21.field619 = var8.field965;
            if(var8.field920 != null) {
               var21.field616 = var8;
               var21.method583();
            }

            class23.field615.method3768(var21);
            if(null != var21.field619) {
               var21.field612 = var21.field611 + (int)(Math.random() * (double)(var21.field614 - var21.field611));
            }
         }

         Object var26;
         if(var5 == 22) {
            if(!client.field457 || 0 != var8.field936 || 1 == var8.field934 || var8.field955) {
               if(var8.field949 == -1 && var8.field920 == null) {
                  var26 = var8.method804(22, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 22, var4, var0, var1, var2, var8.field949, true, (class84)null);
               }

               var6.method1881(var0, var1, var2, var16, (class84)var26, var19, var20);
               if(var8.field934 == 1 && var7 != null) {
                  var7.method2345(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.field949 == -1 && null == var8.field920) {
                  var26 = var8.method804(var5, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field949, true, (class84)null);
               }

               var6.method1967(var0, var1, var2, var16, 1, 1, (class84)var26, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && 13 != var5 && var0 > 0) {
                  class75.field1383[var0][var1][var2] |= 2340;
               }

               if(0 != var8.field934 && null != var7) {
                  var7.method2342(var1, var2, var9, var10, var8.field918);
               }

            } else if(0 == var5) {
               if(var8.field949 == -1 && null == var8.field920) {
                  var26 = var8.method804(0, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 0, var4, var0, var1, var2, var8.field949, true, (class84)null);
               }

               var6.method1876(var0, var1, var2, var16, (class84)var26, (class84)null, class5.field88[var4], 0, var19, var20);
               if(0 == var4) {
                  if(var8.field953) {
                     class5.field97[var0][var1][var2] = 50;
                     class5.field97[var0][var1][1 + var2] = 50;
                  }

                  if(var8.field939) {
                     class75.field1383[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field953) {
                     class5.field97[var0][var1][var2 + 1] = 50;
                     class5.field97[var0][var1 + 1][1 + var2] = 50;
                  }

                  if(var8.field939) {
                     class75.field1383[var0][var1][1 + var2] |= 1170;
                  }
               } else if(2 == var4) {
                  if(var8.field953) {
                     class5.field97[var0][1 + var1][var2] = 50;
                     class5.field97[var0][1 + var1][var2 + 1] = 50;
                  }

                  if(var8.field939) {
                     class75.field1383[var0][var1 + 1][var2] |= 585;
                  }
               } else if(3 == var4) {
                  if(var8.field953) {
                     class5.field97[var0][var1][var2] = 50;
                     class5.field97[var0][1 + var1][var2] = 50;
                  }

                  if(var8.field939) {
                     class75.field1383[var0][var1][var2] |= 1170;
                  }
               }

               if(0 != var8.field934 && null != var7) {
                  var7.method2365(var1, var2, var5, var4, var8.field918);
               }

               if(16 != var8.field961) {
                  var6.method1891(var0, var1, var2, var8.field961);
               }

            } else if(var5 == 1) {
               if(var8.field949 == -1 && var8.field920 == null) {
                  var26 = var8.method804(1, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 1, var4, var0, var1, var2, var8.field949, true, (class84)null);
               }

               var6.method1876(var0, var1, var2, var16, (class84)var26, (class84)null, class5.field80[var4], 0, var19, var20);
               if(var8.field953) {
                  if(var4 == 0) {
                     class5.field97[var0][var1][var2 + 1] = 50;
                  } else if(1 == var4) {
                     class5.field97[var0][var1 + 1][var2 + 1] = 50;
                  } else if(2 == var4) {
                     class5.field97[var0][var1 + 1][var2] = 50;
                  } else if(3 == var4) {
                     class5.field97[var0][var1][var2] = 50;
                  }
               }

               if(0 != var8.field934 && var7 != null) {
                  var7.method2365(var1, var2, var5, var4, var8.field918);
               }

            } else {
               int var27;
               Object var28;
               if(var5 == 2) {
                  var27 = 1 + var4 & 3;
                  Object var30;
                  if(-1 == var8.field949 && null == var8.field920) {
                     var30 = var8.method804(2, var4 + 4, var15, var17, var16, var18);
                     var28 = var8.method804(2, var27, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field949, true, (class84)null);
                     var28 = new class12(var3, 2, var27, var0, var1, var2, var8.field949, true, (class84)null);
                  }

                  var6.method1876(var0, var1, var2, var16, (class84)var30, (class84)var28, class5.field88[var4], class5.field88[var27], var19, var20);
                  if(var8.field939) {
                     if(0 == var4) {
                        class75.field1383[var0][var1][var2] |= 585;
                        class75.field1383[var0][var1][1 + var2] |= 1170;
                     } else if(1 == var4) {
                        class75.field1383[var0][var1][1 + var2] |= 1170;
                        class75.field1383[var0][1 + var1][var2] |= 585;
                     } else if(var4 == 2) {
                        class75.field1383[var0][1 + var1][var2] |= 585;
                        class75.field1383[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class75.field1383[var0][var1][var2] |= 1170;
                        class75.field1383[var0][var1][var2] |= 585;
                     }
                  }

                  if(0 != var8.field934 && null != var7) {
                     var7.method2365(var1, var2, var5, var4, var8.field918);
                  }

                  if(16 != var8.field961) {
                     var6.method1891(var0, var1, var2, var8.field961);
                  }

               } else if(3 == var5) {
                  if(var8.field949 == -1 && null == var8.field920) {
                     var26 = var8.method804(3, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 3, var4, var0, var1, var2, var8.field949, true, (class84)null);
                  }

                  var6.method1876(var0, var1, var2, var16, (class84)var26, (class84)null, class5.field80[var4], 0, var19, var20);
                  if(var8.field953) {
                     if(var4 == 0) {
                        class5.field97[var0][var1][1 + var2] = 50;
                     } else if(1 == var4) {
                        class5.field97[var0][var1 + 1][1 + var2] = 50;
                     } else if(2 == var4) {
                        class5.field97[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class5.field97[var0][var1][var2] = 50;
                     }
                  }

                  if(0 != var8.field934 && var7 != null) {
                     var7.method2365(var1, var2, var5, var4, var8.field918);
                  }

               } else if(9 == var5) {
                  if(var8.field949 == -1 && var8.field920 == null) {
                     var26 = var8.method804(var5, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field949, true, (class84)null);
                  }

                  var6.method1967(var0, var1, var2, var16, 1, 1, (class84)var26, 0, var19, var20);
                  if(0 != var8.field934 && var7 != null) {
                     var7.method2342(var1, var2, var9, var10, var8.field918);
                  }

                  if(var8.field961 != 16) {
                     var6.method1891(var0, var1, var2, var8.field961);
                  }

               } else if(var5 == 4) {
                  if(-1 == var8.field949 && null == var8.field920) {
                     var26 = var8.method804(4, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field949, true, (class84)null);
                  }

                  var6.method1884(var0, var1, var2, var16, (class84)var26, (class84)null, class5.field88[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var27 = 16;
                  var22 = var6.method1901(var0, var1, var2);
                  if(0 != var22) {
                     var27 = class48.method996(var22 >> 14 & 32767).field961;
                  }

                  if(-1 == var8.field949 && null == var8.field920) {
                     var28 = var8.method804(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, var4, var0, var1, var2, var8.field949, true, (class84)null);
                  }

                  var6.method1884(var0, var1, var2, var16, (class84)var28, (class84)null, class5.field88[var4], 0, class5.field103[var4] * var27, class5.field89[var4] * var27, var19, var20);
               } else if(6 == var5) {
                  var27 = 8;
                  var22 = var6.method1901(var0, var1, var2);
                  if(0 != var22) {
                     var27 = class48.method996(var22 >> 14 & 32767).field961 / 2;
                  }

                  if(-1 == var8.field949 && var8.field920 == null) {
                     var28 = var8.method804(4, 4 + var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field949, true, (class84)null);
                  }

                  var6.method1884(var0, var1, var2, var16, (class84)var28, (class84)null, 256, var4, var27 * class5.field92[var4], class5.field101[var4] * var27, var19, var20);
               } else if(var5 == 7) {
                  var22 = 2 + var4 & 3;
                  if(-1 == var8.field949 && null == var8.field920) {
                     var26 = var8.method804(4, 4 + var22, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, var22 + 4, var0, var1, var2, var8.field949, true, (class84)null);
                  }

                  var6.method1884(var0, var1, var2, var16, (class84)var26, (class84)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var27 = 8;
                  var22 = var6.method1901(var0, var1, var2);
                  if(0 != var22) {
                     var27 = class48.method996(var22 >> 14 & 32767).field961 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(var8.field949 == -1 && null == var8.field920) {
                     var28 = var8.method804(4, 4 + var4, var15, var17, var16, var18);
                     var29 = var8.method804(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field949, true, (class84)null);
                     var29 = new class12(var3, 4, var25 + 4, var0, var1, var2, var8.field949, true, (class84)null);
                  }

                  var6.method1884(var0, var1, var2, var16, (class84)var28, (class84)var29, 256, var4, var27 * class5.field92[var4], class5.field101[var4] * var27, var19, var20);
               }
            }
         } else {
            if(var8.field949 == -1 && null == var8.field920) {
               var26 = var8.method804(10, var4, var15, var17, var16, var18);
            } else {
               var26 = new class12(var3, 10, var4, var0, var1, var2, var8.field949, true, (class84)null);
            }

            if(null != var26 && var6.method1967(var0, var1, var2, var16, var9, var10, (class84)var26, 11 == var5?256:0, var19, var20) && var8.field953) {
               var22 = 15;
               if(var26 instanceof class104) {
                  var22 = ((class104)var26).method2263() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class5.field97[var0][var1 + var23][var2 + var24]) {
                        class5.field97[var0][var1 + var23][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(0 != var8.field934 && var7 != null) {
               var7.method2342(var1, var2, var9, var10, var8.field918);
            }

         }
      }
   }

   @ObfuscatedName("bw")
   static final void method2707() {
      for(class16 var0 = (class16)client.field409.method3773(); var0 != null; var0 = (class16)client.field409.method3772()) {
         if(var0.field244 == -1) {
            var0.field240 = 0;
            class169.method3327(var0);
         } else {
            var0.method3853();
         }
      }

   }
}
