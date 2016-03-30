import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public final class class122 extends class119 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -485556955
   )
   int field2022;
   @ObfuscatedName("l")
   static final int[] field2023 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("v")
   class123 field2024;
   @ObfuscatedName("k")
   static int[] field2025;

   @ObfuscatedName("hz")
   public void method2748() {
      this.field2022 = super.field2011 * 8;
   }

   @ObfuscatedName("hh")
   public void method2749(int[] var1) {
      this.field2024 = new class123(var1);
   }

   @ObfuscatedName("hp")
   public int method2751() {
      return super.field2012[++super.field2011 - 1] - this.field2024.method2781() & 255;
   }

   @ObfuscatedName("hc")
   public void method2752() {
      super.field2011 = (this.field2022 + 7) / 8;
   }

   public class122(int var1) {
      super(var1);
   }

   @ObfuscatedName("hg")
   public int method2754(int var1) {
      return var1 * 8 - this.field2022;
   }

   @ObfuscatedName("hv")
   public void method2757(int var1) {
      super.field2012[++super.field2011 - 1] = (byte)(var1 + this.field2024.method2781());
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-736325610"
   )
   static final void method2760(int var0, int var1) {
      class199 var2 = client.field425[class82.field1437][var0][var1];
      if(null == var2) {
         class3.field75.method1929(class82.field1437, var0, var1);
      } else {
         long var3 = -99999999L;
         class28 var5 = null;

         class28 var6;
         for(var6 = (class28)var2.method3836(); null != var6; var6 = (class28)var2.method3841()) {
            class51 var7 = class50.method1055(var6.field686);
            long var8 = (long)var7.field1162;
            if(var7.field1133 == 1) {
               var8 *= (long)(1 + var6.field683);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class3.field75.method1929(class82.field1437, var0, var1);
         } else {
            var2.method3835(var5);
            class28 var10 = null;
            class28 var11 = null;

            for(var6 = (class28)var2.method3836(); var6 != null; var6 = (class28)var2.method3841()) {
               if(var5.field686 != var6.field686) {
                  if(var10 == null) {
                     var10 = var6;
                  }

                  if(var10.field686 != var6.field686 && var11 == null) {
                     var11 = var6;
                  }
               }
            }

            int var9 = (var1 << 7) + var0 + 1610612736;
            class3.field75.method1915(class82.field1437, var0, var1, class43.method938(128 * var0 + 64, 64 + 128 * var1, class82.field1437), var5, var9, var10, var11);
         }
      }
   }

   @ObfuscatedName("hu")
   public int method2777(int var1) {
      int var2 = this.field2022 >> 3;
      int var3 = 8 - (this.field2022 & 7);
      int var4 = 0;

      for(this.field2022 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field2012[var2++] & field2023[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.field2012[var2] & field2023[var3];
      } else {
         var4 += super.field2012[var2] >> var3 - var1 & field2023[var1];
      }

      return var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass86;Lclass108;I)V",
      garbageValue = "1993276876"
   )
   static final void method2778(int var0, int var1, int var2, int var3, int var4, int var5, class86 var6, class108 var7) {
      if(!client.field413 || (class5.field109[0][var1][var2] & 2) != 0 || (class5.field109[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field108) {
            class5.field108 = var0;
         }

         class40 var8 = class22.method592(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field979;
            var10 = var8.field942;
         } else {
            var9 = var8.field942;
            var10 = var8.field979;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = var1 + (1 + var9 >> 1);
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class5.field96[var0];
         int var16 = var15[var11][var14] + var15[var11][var13] + var15[var12][var13] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = 1073741824 + (var3 << 14) + var1 + (var2 << 7);
         if(var8.field975 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field966 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method832()) {
            class23 var21 = new class23();
            var21.field610 = var0;
            var21.field611 = var1 * 128;
            var21.field612 = var2 * 128;
            var22 = var8.field979;
            var23 = var8.field942;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.field942;
               var23 = var8.field979;
            }

            var21.field613 = (var22 + var1) * 128;
            var21.field614 = (var2 + var23) * 128;
            var21.field616 = var8.field963;
            var21.field623 = var8.field971 * 128;
            var21.field609 = var8.field972;
            var21.field619 = var8.field960;
            var21.field621 = var8.field974;
            if(var8.field943 != null) {
               var21.field626 = var8;
               var21.method601();
            }

            class23.field618.method3834(var21);
            if(var21.field621 != null) {
               var21.field615 = var21.field609 + (int)(Math.random() * (double)(var21.field619 - var21.field609));
            }
         }

         Object var26;
         if(22 == var5) {
            if(!client.field413 || var8.field975 != 0 || var8.field931 == 1 || var8.field941) {
               if(var8.field949 == -1 && null == var8.field943) {
                  var26 = var8.method827(22, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 22, var4, var0, var1, var2, var8.field949, true, (class85)null);
               }

               var6.method1914(var0, var1, var2, var16, (class85)var26, var19, var20);
               if(1 == var8.field931 && var7 != null) {
                  var7.method2396(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.field949 == -1 && var8.field943 == null) {
                  var26 = var8.method827(var5, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field949, true, (class85)null);
               }

               var6.method1918(var0, var1, var2, var16, 1, 1, (class85)var26, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class3.field72[var0][var1][var2] |= 2340;
               }

               if(0 != var8.field931 && null != var7) {
                  var7.method2408(var1, var2, var9, var10, var8.field977);
               }

            } else if(var5 == 0) {
               if(var8.field949 == -1 && var8.field943 == null) {
                  var26 = var8.method827(0, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 0, var4, var0, var1, var2, var8.field949, true, (class85)null);
               }

               var6.method1916(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field100[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field957) {
                     class129.field2062[var0][var1][var2] = 50;
                     class129.field2062[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.field938) {
                     class3.field72[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field957) {
                     class129.field2062[var0][var1][var2 + 1] = 50;
                     class129.field2062[var0][1 + var1][1 + var2] = 50;
                  }

                  if(var8.field938) {
                     class3.field72[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(2 == var4) {
                  if(var8.field957) {
                     class129.field2062[var0][1 + var1][var2] = 50;
                     class129.field2062[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field938) {
                     class3.field72[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field957) {
                     class129.field2062[var0][var1][var2] = 50;
                     class129.field2062[var0][1 + var1][var2] = 50;
                  }

                  if(var8.field938) {
                     class3.field72[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field931 != 0 && var7 != null) {
                  var7.method2421(var1, var2, var5, var4, var8.field977);
               }

               if(16 != var8.field950) {
                  var6.method1937(var0, var1, var2, var8.field950);
               }

            } else if(1 == var5) {
               if(var8.field949 == -1 && var8.field943 == null) {
                  var26 = var8.method827(1, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 1, var4, var0, var1, var2, var8.field949, true, (class85)null);
               }

               var6.method1916(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field101[var4], 0, var19, var20);
               if(var8.field957) {
                  if(0 == var4) {
                     class129.field2062[var0][var1][1 + var2] = 50;
                  } else if(1 == var4) {
                     class129.field2062[var0][1 + var1][var2 + 1] = 50;
                  } else if(2 == var4) {
                     class129.field2062[var0][1 + var1][var2] = 50;
                  } else if(3 == var4) {
                     class129.field2062[var0][var1][var2] = 50;
                  }
               }

               if(var8.field931 != 0 && var7 != null) {
                  var7.method2421(var1, var2, var5, var4, var8.field977);
               }

            } else {
               int var27;
               Object var28;
               if(2 == var5) {
                  var27 = var4 + 1 & 3;
                  Object var30;
                  if(-1 == var8.field949 && null == var8.field943) {
                     var30 = var8.method827(2, var4 + 4, var15, var17, var16, var18);
                     var28 = var8.method827(2, var27, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field949, true, (class85)null);
                     var28 = new class12(var3, 2, var27, var0, var1, var2, var8.field949, true, (class85)null);
                  }

                  var6.method1916(var0, var1, var2, var16, (class85)var30, (class85)var28, class5.field100[var4], class5.field100[var27], var19, var20);
                  if(var8.field938) {
                     if(var4 == 0) {
                        class3.field72[var0][var1][var2] |= 585;
                        class3.field72[var0][var1][1 + var2] |= 1170;
                     } else if(1 == var4) {
                        class3.field72[var0][var1][var2 + 1] |= 1170;
                        class3.field72[var0][var1 + 1][var2] |= 585;
                     } else if(2 == var4) {
                        class3.field72[var0][1 + var1][var2] |= 585;
                        class3.field72[var0][var1][var2] |= 1170;
                     } else if(3 == var4) {
                        class3.field72[var0][var1][var2] |= 1170;
                        class3.field72[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field931 != 0 && null != var7) {
                     var7.method2421(var1, var2, var5, var4, var8.field977);
                  }

                  if(var8.field950 != 16) {
                     var6.method1937(var0, var1, var2, var8.field950);
                  }

               } else if(3 == var5) {
                  if(var8.field949 == -1 && null == var8.field943) {
                     var26 = var8.method827(3, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 3, var4, var0, var1, var2, var8.field949, true, (class85)null);
                  }

                  var6.method1916(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field101[var4], 0, var19, var20);
                  if(var8.field957) {
                     if(0 == var4) {
                        class129.field2062[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class129.field2062[var0][var1 + 1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class129.field2062[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class129.field2062[var0][var1][var2] = 50;
                     }
                  }

                  if(0 != var8.field931 && var7 != null) {
                     var7.method2421(var1, var2, var5, var4, var8.field977);
                  }

               } else if(9 == var5) {
                  if(var8.field949 == -1 && var8.field943 == null) {
                     var26 = var8.method827(var5, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field949, true, (class85)null);
                  }

                  var6.method1918(var0, var1, var2, var16, 1, 1, (class85)var26, 0, var19, var20);
                  if(var8.field931 != 0 && var7 != null) {
                     var7.method2408(var1, var2, var9, var10, var8.field977);
                  }

                  if(16 != var8.field950) {
                     var6.method1937(var0, var1, var2, var8.field950);
                  }

               } else if(var5 == 4) {
                  if(-1 == var8.field949 && var8.field943 == null) {
                     var26 = var8.method827(4, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field949, true, (class85)null);
                  }

                  var6.method1917(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field100[var4], 0, 0, 0, var19, var20);
               } else if(5 == var5) {
                  var27 = 16;
                  var22 = var6.method1927(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class22.method592(var22 >> 14 & 32767).field950;
                  }

                  if(var8.field949 == -1 && var8.field943 == null) {
                     var28 = var8.method827(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, var4, var0, var1, var2, var8.field949, true, (class85)null);
                  }

                  var6.method1917(var0, var1, var2, var16, (class85)var28, (class85)null, class5.field100[var4], 0, var27 * class5.field102[var4], class5.field103[var4] * var27, var19, var20);
               } else if(6 == var5) {
                  var27 = 8;
                  var22 = var6.method1927(var0, var1, var2);
                  if(0 != var22) {
                     var27 = class22.method592(var22 >> 14 & 32767).field950 / 2;
                  }

                  if(-1 == var8.field949 && null == var8.field943) {
                     var28 = var8.method827(4, 4 + var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field949, true, (class85)null);
                  }

                  var6.method1917(var0, var1, var2, var16, (class85)var28, (class85)null, 256, var4, var27 * class5.field98[var4], var27 * class5.field105[var4], var19, var20);
               } else if(var5 == 7) {
                  var22 = 2 + var4 & 3;
                  if(-1 == var8.field949 && var8.field943 == null) {
                     var26 = var8.method827(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field949, true, (class85)null);
                  }

                  var6.method1917(var0, var1, var2, var16, (class85)var26, (class85)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var27 = 8;
                  var22 = var6.method1927(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class22.method592(var22 >> 14 & 32767).field950 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(-1 == var8.field949 && var8.field943 == null) {
                     var28 = var8.method827(4, var4 + 4, var15, var17, var16, var18);
                     var29 = var8.method827(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field949, true, (class85)null);
                     var29 = new class12(var3, 4, var25 + 4, var0, var1, var2, var8.field949, true, (class85)null);
                  }

                  var6.method1917(var0, var1, var2, var16, (class85)var28, (class85)var29, 256, var4, var27 * class5.field98[var4], var27 * class5.field105[var4], var19, var20);
               }
            }
         } else {
            if(var8.field949 == -1 && null == var8.field943) {
               var26 = var8.method827(10, var4, var15, var17, var16, var18);
            } else {
               var26 = new class12(var3, 10, var4, var0, var1, var2, var8.field949, true, (class85)null);
            }

            if(null != var26 && var6.method1918(var0, var1, var2, var16, var9, var10, (class85)var26, var5 == 11?256:0, var19, var20) && var8.field957) {
               var22 = 15;
               if(var26 instanceof class105) {
                  var22 = ((class105)var26).method2306() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class129.field2062[var0][var23 + var1][var2 + var24]) {
                        class129.field2062[var0][var23 + var1][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(0 != var8.field931 && null != var7) {
               var7.method2408(var1, var2, var9, var10, var8.field977);
            }

         }
      }
   }

   @ObfuscatedName("w")
   public static void method2779(class167 var0, class167 var1) {
      class44.field1048 = var0;
      class44.field1037 = var1;
      class44.field1041 = class44.field1048.method3330(3);
   }
}
