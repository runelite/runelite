import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public final class class159 extends Buffer {
   @ObfuscatedName("o")
   static final int[] field2129 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("cj")
   static class110 field2130;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 129287007
   )
   int field2131;
   @ObfuscatedName("i")
   class160 field2133;
   @ObfuscatedName("qp")
   protected static class109 field2135;

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "108530541"
   )
   public int method3069() {
      return super.payload[++super.offset - 1] - this.field2133.method3101() & 255;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-419555868"
   )
   public void method3070(int[] var1) {
      this.field2133 = new class160(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "61"
   )
   static void method3071(int var0) {
      if(var0 != -1) {
         if(class30.method696(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(null != var3.field2331) {
                  class18 var4 = new class18();
                  var4.field198 = var3;
                  var4.field209 = var3.field2331;
                  class174.method3275(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-42"
   )
   public void method3072() {
      this.field2131 = super.offset * 8;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "280619585"
   )
   public void method3073(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2133.method3101());
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-4737"
   )
   public void method3074() {
      super.offset = (this.field2131 + 7) / 8;
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-7975"
   )
   public int method3075(int var1) {
      return var1 * 8 - this.field2131;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass228;I)I",
      garbageValue = "-2036698035"
   )
   static final int method3076(class228 var0) {
      if(null == var0) {
         return 12;
      } else {
         switch(var0.field3251) {
         case 7:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class159(int var1) {
      super(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;Z[I[II)I",
      garbageValue = "-1870737122"
   )
   public static int method3094(int var0, int var1, int var2, class119 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class118.field1845[var8][var9] = 0;
            class118.field1846[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var12;
      byte var13;
      int var14;
      int var15;
      byte var16;
      int var17;
      int[][] var18;
      int var19;
      int var20;
      int var21;
      int var22;
      boolean var28;
      boolean var29;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class118.field1845[var12][var13] = 99;
         class118.field1846[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1848[var16] = var0;
         var33 = var16 + 1;
         class118.field1850[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var17 == var33) {
               class118.field1847 = var10;
               class215.field3175 = var11;
               var29 = false;
               break;
            }

            var10 = class118.field1848[var17];
            var11 = class118.field1850[var17];
            var17 = 1 + var17 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2339(1, var10, var11, var4)) {
               class118.field1847 = var10;
               class215.field3175 = var11;
               var29 = true;
               break;
            }

            var21 = 1 + class118.field1846[var30][var31];
            if(var30 > 0 && class118.field1845[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1850[var33] = var11;
               var33 = var33 + 1 & 4095;
               class118.field1845[var30 - 1][var31] = 2;
               class118.field1846[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class118.field1845[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class118.field1848[var33] = 1 + var10;
               class118.field1850[var33] = var11;
               var33 = var33 + 1 & 4095;
               class118.field1845[1 + var30][var31] = 8;
               class118.field1846[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class118.field1845[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1848[var33] = var10;
               class118.field1850[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1845[var30][var31 - 1] = 1;
               class118.field1846[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class118.field1845[var30][1 + var31] == 0 && (var18[var19][1 + var20] & 19136800) == 0) {
               class118.field1848[var33] = var10;
               class118.field1850[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class118.field1845[var30][var31 + 1] = 4;
               class118.field1846[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class118.field1845[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1850[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1845[var30 - 1][var31 - 1] = 3;
               class118.field1846[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class118.field1845[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1848[var33] = var10 + 1;
               class118.field1850[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1845[1 + var30][var31 - 1] = 9;
               class118.field1846[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class118.field1845[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1850[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class118.field1845[var30 - 1][1 + var31] = 6;
               class118.field1846[var30 - 1][1 + var31] = var21;
            }

            if(var30 < 127 && var31 < 127 && class118.field1845[var30 + 1][var31 + 1] == 0 && (var18[1 + var19][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class118.field1848[var33] = var10 + 1;
               class118.field1850[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class118.field1845[var30 + 1][1 + var31] = 12;
               class118.field1846[1 + var30][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class118.field1845[var12][var13] = 99;
         class118.field1846[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1848[var16] = var0;
         var33 = var16 + 1;
         class118.field1850[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var17 == var33) {
               class118.field1847 = var10;
               class215.field3175 = var11;
               var29 = false;
               break;
            }

            var10 = class118.field1848[var17];
            var11 = class118.field1850[var17];
            var17 = 1 + var17 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2339(2, var10, var11, var4)) {
               class118.field1847 = var10;
               class215.field3175 = var11;
               var29 = true;
               break;
            }

            var21 = 1 + class118.field1846[var30][var31];
            if(var30 > 0 && class118.field1845[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1850[var33] = var11;
               var33 = var33 + 1 & 4095;
               class118.field1845[var30 - 1][var31] = 2;
               class118.field1846[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class118.field1845[var30 + 1][var31] == 0 && (var18[2 + var19][var20] & 19136899) == 0 && (var18[var19 + 2][1 + var20] & 19136992) == 0) {
               class118.field1848[var33] = var10 + 1;
               class118.field1850[var33] = var11;
               var33 = 1 + var33 & 4095;
               class118.field1845[1 + var30][var31] = 8;
               class118.field1846[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class118.field1845[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[1 + var19][var20 - 1] & 19136899) == 0) {
               class118.field1848[var33] = var10;
               class118.field1850[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1845[var30][var31 - 1] = 1;
               class118.field1846[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class118.field1845[var30][1 + var31] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[1 + var19][2 + var20] & 19136992) == 0) {
               class118.field1848[var33] = var10;
               class118.field1850[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class118.field1845[var30][var31 + 1] = 4;
               class118.field1846[var30][1 + var31] = var21;
            }

            if(var30 > 0 && var31 > 0 && class118.field1845[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1850[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1845[var30 - 1][var31 - 1] = 3;
               class118.field1846[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class118.field1845[var30 + 1][var31 - 1] == 0 && (var18[1 + var19][var20 - 1] & 19136911) == 0 && (var18[2 + var19][var20 - 1] & 19136899) == 0 && (var18[2 + var19][var20] & 19136995) == 0) {
               class118.field1848[var33] = 1 + var10;
               class118.field1850[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1845[1 + var30][var31 - 1] = 9;
               class118.field1846[1 + var30][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class118.field1845[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][1 + var20] & 19136830) == 0 && (var18[var19 - 1][2 + var20] & 19136824) == 0 && (var18[var19][2 + var20] & 19137016) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1850[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class118.field1845[var30 - 1][var31 + 1] = 6;
               class118.field1846[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 126 && var31 < 126 && class118.field1845[var30 + 1][1 + var31] == 0 && (var18[var19 + 1][2 + var20] & 19137016) == 0 && (var18[var19 + 2][2 + var20] & 19136992) == 0 && (var18[2 + var19][var20 + 1] & 19136995) == 0) {
               class118.field1848[var33] = 1 + var10;
               class118.field1850[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class118.field1845[1 + var30][var31 + 1] = 12;
               class118.field1846[1 + var30][1 + var31] = var21;
            }
         }

         var28 = var29;
      } else {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class118.field1845[var12][var13] = 99;
         class118.field1846[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1848[var16] = var0;
         var33 = var16 + 1;
         class118.field1850[var16] = var1;
         var18 = var4.flags;

         label901:
         while(true) {
            label899:
            while(true) {
               do {
                  do {
                     do {
                        label876:
                        do {
                           if(var33 == var17) {
                              class118.field1847 = var10;
                              class215.field3175 = var11;
                              var29 = false;
                              break label901;
                           }

                           var10 = class118.field1848[var17];
                           var11 = class118.field1850[var17];
                           var17 = 1 + var17 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod2339(var2, var10, var11, var4)) {
                              class118.field1847 = var10;
                              class215.field3175 = var11;
                              var29 = true;
                              break label901;
                           }

                           var21 = 1 + class118.field1846[var30][var31];
                           if(var30 > 0 && class118.field1845[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var20 + var2 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1848[var33] = var10 - 1;
                                    class118.field1850[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1845[var30 - 1][var31] = 2;
                                    class118.field1846[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class118.field1845[var30 + 1][var31] == 0 && (var18[var2 + var19][var20] & 19136899) == 0 && (var18[var19 + var2][var20 + var2 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1848[var33] = var10 + 1;
                                    class118.field1850[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1845[var30 + 1][var31] = 8;
                                    class118.field1846[var30 + 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var2 + var19][var20 + var22] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class118.field1845[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var2 + var19 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1848[var33] = var10;
                                    class118.field1850[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1845[var30][var31 - 1] = 1;
                                    class118.field1846[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class118.field1845[var30][var31 + 1] == 0 && (var18[var19][var2 + var20] & 19136824) == 0 && (var18[var2 + var19 - 1][var2 + var20] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1848[var33] = var10;
                                    class118.field1850[var33] = 1 + var11;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1845[var30][var31 + 1] = 4;
                                    class118.field1846[var30][var31 + 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var2 + var20] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class118.field1845[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class118.field1848[var33] = var10 - 1;
                                    class118.field1850[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1845[var30 - 1][var31 - 1] = 3;
                                    class118.field1846[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + (var20 - 1)] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class118.field1845[1 + var30][var31 - 1] == 0 && (var18[var19 + var2][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class118.field1848[var33] = 1 + var10;
                                    class118.field1850[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1845[1 + var30][var31 - 1] = 9;
                                    class118.field1846[var30 + 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var2 + var19][var22 + (var20 - 1)] & 19136995) != 0 || (var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class118.field1845[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var2 + var20] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var2 + var20] & 19137016) != 0) {
                                    continue label876;
                                 }
                              }

                              class118.field1848[var33] = var10 - 1;
                              class118.field1850[var33] = 1 + var11;
                              var33 = 1 + var33 & 4095;
                              class118.field1845[var30 - 1][1 + var31] = 6;
                              class118.field1846[var30 - 1][1 + var31] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class118.field1845[1 + var30][1 + var31] != 0);
               } while((var18[var2 + var19][var2 + var20] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var22 + var19][var2 + var20] & 19137016) != 0 || (var18[var19 + var2][var20 + var22] & 19136995) != 0) {
                     continue label899;
                  }
               }

               class118.field1848[var33] = 1 + var10;
               class118.field1850[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class118.field1845[var30 + 1][1 + var31] = 12;
               class118.field1846[var30 + 1][1 + var31] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class118.field1847;
      var30 = class215.field3175;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1857;
         var17 = var3.field1852;
         int var27 = var3.field1854;
         var19 = var3.field1855;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class118.field1846[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var27 + var33 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var26 == var31 && class118.field1846[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class118.field1846[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class118.field1848[var13] = var11;
         var31 = var13 + 1;
         class118.field1850[var13] = var30;

         for(var14 = var15 = class118.field1845[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class118.field1845[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class118.field1848[var31] = var11;
               class118.field1850[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class118.field1848[var31];
            var7[var33++] = class118.field1850[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2090253494"
   )
   public int method3095(int var1) {
      int var2 = this.field2131 >> 3;
      int var3 = 8 - (this.field2131 & 7);
      int var4 = 0;

      for(this.field2131 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2129[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field2129[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2129[var1];
      }

      return var4;
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(LWidget;II)I",
      garbageValue = "16711935"
   )
   static final int method3096(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class179.method3296(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class103.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == 1 + var11) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class165.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class172.field2352[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class165.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class36.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class172.field2354[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class179.method3296(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class103.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class165.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class109.method2109(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class36.localPlayer.x >> 7) + class5.baseX;
               }

               if(var6 == 19) {
                  var7 = XClanMember.baseY + (class36.localPlayer.y >> 7);
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
