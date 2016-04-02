import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class10 extends class107 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1820047009
   )
   static int field166;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -159265817
   )
   @Export("cameraYaw")
   static int field167;
   @ObfuscatedName("po")
   static class221 field168;

   @ObfuscatedName("e")
   static int method135() {
      return ++class11.field170 - 1;
   }

   @ObfuscatedName("e")
   protected boolean vmethod2402(int var1, int var2) {
      return super.field1864 == var1 && var2 == super.field1853;
   }

   @ObfuscatedName("e")
   static final void method137(class122 var0) {
      var0.method2755();
      int var1 = client.field401;
      class2 var2 = class20.field572 = client.field387[var1] = new class2();
      var2.field56 = var1;
      int var3 = var0.method2756(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field842[0] = var5 - class85.field1439;
      var2.field804 = (var2.field842[0] << 7) + (var2.method22() << 6);
      var2.field843[0] = var6 - class6.field128;
      var2.field814 = (var2.field843[0] << 7) + (var2.method22() << 6);
      class48.field1063 = var2.field55 = var4;
      if(null != class32.field729[var1]) {
         var2.method21(class32.field729[var1]);
      }

      class32.field731 = 0;
      class32.field732[++class32.field731 - 1] = var1;
      class32.field740[var1] = 0;
      class32.field733 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2756(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class32.field735[var7] = var11 + (var9 << 28) + (var10 << 14);
            class32.field736[var7] = 0;
            class32.field737[var7] = -1;
            class32.field734[++class32.field733 - 1] = var7;
            class32.field740[var7] = 0;
         }
      }

      var0.method2754();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIILclass107;Lclass108;Z[I[II)I",
      garbageValue = "1"
   )
   public static int method142(int var0, int var1, int var2, class107 var3, class108 var4, int[] var5, int[] var6) {
      int var8;
      for(int var7 = 0; var7 < 128; ++var7) {
         for(var8 = 0; var8 < 128; ++var8) {
            class106.field1847[var7][var8] = 0;
            class106.field1843[var7][var8] = 99999999;
         }
      }

      int var9;
      int var10;
      byte var11;
      byte var12;
      int var13;
      int var14;
      byte var15;
      int var16;
      int[][] var17;
      int var18;
      int var19;
      int var20;
      int var21;
      boolean var26;
      boolean var27;
      int var28;
      int var29;
      int var31;
      if(var2 == 1) {
         var9 = var0;
         var10 = var1;
         var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class106.field1847[var11][var12] = 99;
         class106.field1843[var11][var12] = 0;
         var15 = 0;
         var16 = 0;
         class106.field1846[var15] = var0;
         var31 = var15 + 1;
         class106.field1848[var15] = var1;
         var17 = var4.field1885;

         while(true) {
            if(var16 == var31) {
               class106.field1844 = var9;
               class106.field1845 = var10;
               var27 = false;
               break;
            }

            var9 = class106.field1846[var16];
            var10 = class106.field1848[var16];
            var16 = var16 + 1 & 4095;
            var28 = var9 - var13;
            var29 = var10 - var14;
            var18 = var9 - var4.field1875;
            var19 = var10 - var4.field1879;
            if(var3.vmethod2402(var9, var10)) {
               class106.field1844 = var9;
               class106.field1845 = var10;
               var27 = true;
               break;
            }

            var20 = class106.field1843[var28][var29] + 1;
            if(var28 > 0 && 0 == class106.field1847[var28 - 1][var29] && 0 == (var17[var18 - 1][var19] & 19136776)) {
               class106.field1846[var31] = var9 - 1;
               class106.field1848[var31] = var10;
               var31 = 1 + var31 & 4095;
               class106.field1847[var28 - 1][var29] = 2;
               class106.field1843[var28 - 1][var29] = var20;
            }

            if(var28 < 127 && class106.field1847[var28 + 1][var29] == 0 && (var17[1 + var18][var19] & 19136896) == 0) {
               class106.field1846[var31] = var9 + 1;
               class106.field1848[var31] = var10;
               var31 = var31 + 1 & 4095;
               class106.field1847[var28 + 1][var29] = 8;
               class106.field1843[var28 + 1][var29] = var20;
            }

            if(var29 > 0 && class106.field1847[var28][var29 - 1] == 0 && (var17[var18][var19 - 1] & 19136770) == 0) {
               class106.field1846[var31] = var9;
               class106.field1848[var31] = var10 - 1;
               var31 = 1 + var31 & 4095;
               class106.field1847[var28][var29 - 1] = 1;
               class106.field1843[var28][var29 - 1] = var20;
            }

            if(var29 < 127 && 0 == class106.field1847[var28][1 + var29] && (var17[var18][var19 + 1] & 19136800) == 0) {
               class106.field1846[var31] = var9;
               class106.field1848[var31] = 1 + var10;
               var31 = var31 + 1 & 4095;
               class106.field1847[var28][var29 + 1] = 4;
               class106.field1843[var28][var29 + 1] = var20;
            }

            if(var28 > 0 && var29 > 0 && class106.field1847[var28 - 1][var29 - 1] == 0 && 0 == (var17[var18 - 1][var19 - 1] & 19136782) && 0 == (var17[var18 - 1][var19] & 19136776) && (var17[var18][var19 - 1] & 19136770) == 0) {
               class106.field1846[var31] = var9 - 1;
               class106.field1848[var31] = var10 - 1;
               var31 = var31 + 1 & 4095;
               class106.field1847[var28 - 1][var29 - 1] = 3;
               class106.field1843[var28 - 1][var29 - 1] = var20;
            }

            if(var28 < 127 && var29 > 0 && class106.field1847[1 + var28][var29 - 1] == 0 && 0 == (var17[1 + var18][var19 - 1] & 19136899) && (var17[var18 + 1][var19] & 19136896) == 0 && 0 == (var17[var18][var19 - 1] & 19136770)) {
               class106.field1846[var31] = 1 + var9;
               class106.field1848[var31] = var10 - 1;
               var31 = 1 + var31 & 4095;
               class106.field1847[var28 + 1][var29 - 1] = 9;
               class106.field1843[1 + var28][var29 - 1] = var20;
            }

            if(var28 > 0 && var29 < 127 && class106.field1847[var28 - 1][1 + var29] == 0 && (var17[var18 - 1][var19 + 1] & 19136824) == 0 && (var17[var18 - 1][var19] & 19136776) == 0 && 0 == (var17[var18][1 + var19] & 19136800)) {
               class106.field1846[var31] = var9 - 1;
               class106.field1848[var31] = 1 + var10;
               var31 = 1 + var31 & 4095;
               class106.field1847[var28 - 1][var29 + 1] = 6;
               class106.field1843[var28 - 1][1 + var29] = var20;
            }

            if(var28 < 127 && var29 < 127 && class106.field1847[var28 + 1][1 + var29] == 0 && 0 == (var17[1 + var18][var19 + 1] & 19136992) && (var17[1 + var18][var19] & 19136896) == 0 && (var17[var18][1 + var19] & 19136800) == 0) {
               class106.field1846[var31] = 1 + var9;
               class106.field1848[var31] = 1 + var10;
               var31 = var31 + 1 & 4095;
               class106.field1847[var28 + 1][var29 + 1] = 12;
               class106.field1843[1 + var28][var29 + 1] = var20;
            }
         }

         var26 = var27;
      } else if(var2 == 2) {
         var9 = var0;
         var10 = var1;
         var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class106.field1847[var11][var12] = 99;
         class106.field1843[var11][var12] = 0;
         var15 = 0;
         var16 = 0;
         class106.field1846[var15] = var0;
         var31 = var15 + 1;
         class106.field1848[var15] = var1;
         var17 = var4.field1885;

         while(true) {
            if(var31 == var16) {
               class106.field1844 = var9;
               class106.field1845 = var10;
               var27 = false;
               break;
            }

            var9 = class106.field1846[var16];
            var10 = class106.field1848[var16];
            var16 = var16 + 1 & 4095;
            var28 = var9 - var13;
            var29 = var10 - var14;
            var18 = var9 - var4.field1875;
            var19 = var10 - var4.field1879;
            if(var3.vmethod2402(var9, var10)) {
               class106.field1844 = var9;
               class106.field1845 = var10;
               var27 = true;
               break;
            }

            var20 = 1 + class106.field1843[var28][var29];
            if(var28 > 0 && class106.field1847[var28 - 1][var29] == 0 && 0 == (var17[var18 - 1][var19] & 19136782) && (var17[var18 - 1][var19 + 1] & 19136824) == 0) {
               class106.field1846[var31] = var9 - 1;
               class106.field1848[var31] = var10;
               var31 = 1 + var31 & 4095;
               class106.field1847[var28 - 1][var29] = 2;
               class106.field1843[var28 - 1][var29] = var20;
            }

            if(var28 < 126 && class106.field1847[var28 + 1][var29] == 0 && (var17[var18 + 2][var19] & 19136899) == 0 && 0 == (var17[var18 + 2][var19 + 1] & 19136992)) {
               class106.field1846[var31] = var9 + 1;
               class106.field1848[var31] = var10;
               var31 = var31 + 1 & 4095;
               class106.field1847[var28 + 1][var29] = 8;
               class106.field1843[1 + var28][var29] = var20;
            }

            if(var29 > 0 && class106.field1847[var28][var29 - 1] == 0 && 0 == (var17[var18][var19 - 1] & 19136782) && (var17[var18 + 1][var19 - 1] & 19136899) == 0) {
               class106.field1846[var31] = var9;
               class106.field1848[var31] = var10 - 1;
               var31 = 1 + var31 & 4095;
               class106.field1847[var28][var29 - 1] = 1;
               class106.field1843[var28][var29 - 1] = var20;
            }

            if(var29 < 126 && class106.field1847[var28][var29 + 1] == 0 && 0 == (var17[var18][var19 + 2] & 19136824) && (var17[1 + var18][var19 + 2] & 19136992) == 0) {
               class106.field1846[var31] = var9;
               class106.field1848[var31] = 1 + var10;
               var31 = var31 + 1 & 4095;
               class106.field1847[var28][1 + var29] = 4;
               class106.field1843[var28][1 + var29] = var20;
            }

            if(var28 > 0 && var29 > 0 && 0 == class106.field1847[var28 - 1][var29 - 1] && 0 == (var17[var18 - 1][var19] & 19136830) && (var17[var18 - 1][var19 - 1] & 19136782) == 0 && 0 == (var17[var18][var19 - 1] & 19136911)) {
               class106.field1846[var31] = var9 - 1;
               class106.field1848[var31] = var10 - 1;
               var31 = 1 + var31 & 4095;
               class106.field1847[var28 - 1][var29 - 1] = 3;
               class106.field1843[var28 - 1][var29 - 1] = var20;
            }

            if(var28 < 126 && var29 > 0 && class106.field1847[var28 + 1][var29 - 1] == 0 && (var17[var18 + 1][var19 - 1] & 19136911) == 0 && 0 == (var17[var18 + 2][var19 - 1] & 19136899) && (var17[2 + var18][var19] & 19136995) == 0) {
               class106.field1846[var31] = var9 + 1;
               class106.field1848[var31] = var10 - 1;
               var31 = var31 + 1 & 4095;
               class106.field1847[1 + var28][var29 - 1] = 9;
               class106.field1843[1 + var28][var29 - 1] = var20;
            }

            if(var28 > 0 && var29 < 126 && class106.field1847[var28 - 1][var29 + 1] == 0 && (var17[var18 - 1][1 + var19] & 19136830) == 0 && (var17[var18 - 1][var19 + 2] & 19136824) == 0 && (var17[var18][var19 + 2] & 19137016) == 0) {
               class106.field1846[var31] = var9 - 1;
               class106.field1848[var31] = var10 + 1;
               var31 = var31 + 1 & 4095;
               class106.field1847[var28 - 1][1 + var29] = 6;
               class106.field1843[var28 - 1][1 + var29] = var20;
            }

            if(var28 < 126 && var29 < 126 && class106.field1847[1 + var28][1 + var29] == 0 && 0 == (var17[1 + var18][var19 + 2] & 19137016) && (var17[var18 + 2][2 + var19] & 19136992) == 0 && 0 == (var17[2 + var18][var19 + 1] & 19136995)) {
               class106.field1846[var31] = 1 + var9;
               class106.field1848[var31] = 1 + var10;
               var31 = 1 + var31 & 4095;
               class106.field1847[1 + var28][1 + var29] = 12;
               class106.field1843[var28 + 1][var29 + 1] = var20;
            }
         }

         var26 = var27;
      } else {
         var9 = var0;
         var10 = var1;
         var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class106.field1847[var11][var12] = 99;
         class106.field1843[var11][var12] = 0;
         var15 = 0;
         var16 = 0;
         class106.field1846[var15] = var0;
         var31 = var15 + 1;
         class106.field1848[var15] = var1;
         var17 = var4.field1885;

         label897:
         while(true) {
            label895:
            while(true) {
               do {
                  do {
                     do {
                        label872:
                        do {
                           if(var31 == var16) {
                              class106.field1844 = var9;
                              class106.field1845 = var10;
                              var27 = false;
                              break label897;
                           }

                           var9 = class106.field1846[var16];
                           var10 = class106.field1848[var16];
                           var16 = var16 + 1 & 4095;
                           var28 = var9 - var13;
                           var29 = var10 - var14;
                           var18 = var9 - var4.field1875;
                           var19 = var10 - var4.field1879;
                           if(var3.vmethod2402(var9, var10)) {
                              class106.field1844 = var9;
                              class106.field1845 = var10;
                              var27 = true;
                              break label897;
                           }

                           var20 = class106.field1843[var28][var29] + 1;
                           if(var28 > 0 && 0 == class106.field1847[var28 - 1][var29] && 0 == (var17[var18 - 1][var19] & 19136782) && 0 == (var17[var18 - 1][var19 + var2 - 1] & 19136824)) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2 - 1) {
                                    class106.field1846[var31] = var9 - 1;
                                    class106.field1848[var31] = var10;
                                    var31 = var31 + 1 & 4095;
                                    class106.field1847[var28 - 1][var29] = 2;
                                    class106.field1843[var28 - 1][var29] = var20;
                                    break;
                                 }

                                 if(0 != (var17[var18 - 1][var21 + var19] & 19136830)) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var28 < 128 - var2 && class106.field1847[var28 + 1][var29] == 0 && 0 == (var17[var2 + var18][var19] & 19136899) && (var17[var2 + var18][var2 + var19 - 1] & 19136992) == 0) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2 - 1) {
                                    class106.field1846[var31] = 1 + var9;
                                    class106.field1848[var31] = var10;
                                    var31 = 1 + var31 & 4095;
                                    class106.field1847[var28 + 1][var29] = 8;
                                    class106.field1843[var28 + 1][var29] = var20;
                                    break;
                                 }

                                 if(0 != (var17[var18 + var2][var21 + var19] & 19136995)) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var29 > 0 && class106.field1847[var28][var29 - 1] == 0 && 0 == (var17[var18][var19 - 1] & 19136782) && (var17[var2 + var18 - 1][var19 - 1] & 19136899) == 0) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2 - 1) {
                                    class106.field1846[var31] = var9;
                                    class106.field1848[var31] = var10 - 1;
                                    var31 = 1 + var31 & 4095;
                                    class106.field1847[var28][var29 - 1] = 1;
                                    class106.field1843[var28][var29 - 1] = var20;
                                    break;
                                 }

                                 if(0 != (var17[var21 + var18][var19 - 1] & 19136911)) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var29 < 128 - var2 && class106.field1847[var28][1 + var29] == 0 && 0 == (var17[var18][var2 + var19] & 19136824) && (var17[var18 + var2 - 1][var2 + var19] & 19136992) == 0) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2 - 1) {
                                    class106.field1846[var31] = var9;
                                    class106.field1848[var31] = 1 + var10;
                                    var31 = 1 + var31 & 4095;
                                    class106.field1847[var28][1 + var29] = 4;
                                    class106.field1843[var28][1 + var29] = var20;
                                    break;
                                 }

                                 if(0 != (var17[var21 + var18][var19 + var2] & 19137016)) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var28 > 0 && var29 > 0 && 0 == class106.field1847[var28 - 1][var29 - 1] && (var17[var18 - 1][var19 - 1] & 19136782) == 0) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2) {
                                    class106.field1846[var31] = var9 - 1;
                                    class106.field1848[var31] = var10 - 1;
                                    var31 = 1 + var31 & 4095;
                                    class106.field1847[var28 - 1][var29 - 1] = 3;
                                    class106.field1843[var28 - 1][var29 - 1] = var20;
                                    break;
                                 }

                                 if((var17[var18 - 1][var21 + (var19 - 1)] & 19136830) != 0 || 0 != (var17[var21 + (var18 - 1)][var19 - 1] & 19136911)) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var28 < 128 - var2 && var29 > 0 && 0 == class106.field1847[1 + var28][var29 - 1] && (var17[var18 + var2][var19 - 1] & 19136899) == 0) {
                              var21 = 1;

                              while(true) {
                                 if(var21 >= var2) {
                                    class106.field1846[var31] = var9 + 1;
                                    class106.field1848[var31] = var10 - 1;
                                    var31 = var31 + 1 & 4095;
                                    class106.field1847[var28 + 1][var29 - 1] = 9;
                                    class106.field1843[1 + var28][var29 - 1] = var20;
                                    break;
                                 }

                                 if((var17[var2 + var18][var21 + (var19 - 1)] & 19136995) != 0 || (var17[var21 + var18][var19 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var21;
                              }
                           }

                           if(var28 > 0 && var29 < 128 - var2 && 0 == class106.field1847[var28 - 1][var29 + 1] && 0 == (var17[var18 - 1][var2 + var19] & 19136824)) {
                              for(var21 = 1; var21 < var2; ++var21) {
                                 if((var17[var18 - 1][var19 + var21] & 19136830) != 0 || 0 != (var17[var21 + (var18 - 1)][var2 + var19] & 19137016)) {
                                    continue label872;
                                 }
                              }

                              class106.field1846[var31] = var9 - 1;
                              class106.field1848[var31] = 1 + var10;
                              var31 = 1 + var31 & 4095;
                              class106.field1847[var28 - 1][var29 + 1] = 6;
                              class106.field1843[var28 - 1][var29 + 1] = var20;
                           }
                        } while(var28 >= 128 - var2);
                     } while(var29 >= 128 - var2);
                  } while(class106.field1847[1 + var28][1 + var29] != 0);
               } while(0 != (var17[var2 + var18][var19 + var2] & 19136992));

               for(var21 = 1; var21 < var2; ++var21) {
                  if((var17[var21 + var18][var19 + var2] & 19137016) != 0 || (var17[var18 + var2][var19 + var21] & 19136995) != 0) {
                     continue label895;
                  }
               }

               class106.field1846[var31] = var9 + 1;
               class106.field1848[var31] = var10 + 1;
               var31 = var31 + 1 & 4095;
               class106.field1847[1 + var28][1 + var29] = 12;
               class106.field1843[var28 + 1][var29 + 1] = var20;
            }
         }

         var26 = var27;
      }

      var8 = var0 - 64;
      var9 = var1 - 64;
      var10 = class106.field1844;
      var28 = class106.field1845;
      if(!var26) {
         var29 = Integer.MAX_VALUE;
         var13 = Integer.MAX_VALUE;
         byte var30 = 10;
         var31 = var3.field1864;
         var16 = var3.field1853;
         int var32 = var3.field1855;
         var18 = var3.field1862;

         for(var19 = var31 - var30; var19 <= var30 + var31; ++var19) {
            for(var20 = var16 - var30; var20 <= var16 + var30; ++var20) {
               var21 = var19 - var8;
               int var22 = var20 - var9;
               if(var21 >= 0 && var22 >= 0 && var21 < 128 && var22 < 128 && class106.field1843[var21][var22] < 100) {
                  int var23 = 0;
                  if(var19 < var31) {
                     var23 = var31 - var19;
                  } else if(var19 > var32 + var31 - 1) {
                     var23 = var19 - (var32 + var31 - 1);
                  }

                  int var24 = 0;
                  if(var20 < var16) {
                     var24 = var16 - var20;
                  } else if(var20 > var18 + var16 - 1) {
                     var24 = var20 - (var18 + var16 - 1);
                  }

                  int var25 = var23 * var23 + var24 * var24;
                  if(var25 < var29 || var25 == var29 && class106.field1843[var21][var22] < var13) {
                     var29 = var25;
                     var13 = class106.field1843[var21][var22];
                     var10 = var19;
                     var28 = var20;
                  }
               }
            }
         }

         if(var29 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var10 && var1 == var28) {
         return 0;
      } else {
         var12 = 0;
         class106.field1846[var12] = var10;
         var29 = var12 + 1;
         class106.field1848[var12] = var28;

         for(var13 = var14 = class106.field1847[var10 - var8][var28 - var9]; var0 != var10 || var1 != var28; var13 = class106.field1847[var10 - var8][var28 - var9]) {
            if(var13 != var14) {
               var14 = var13;
               class106.field1846[var29] = var10;
               class106.field1848[var29++] = var28;
            }

            if((var13 & 2) != 0) {
               ++var10;
            } else if(0 != (var13 & 8)) {
               --var10;
            }

            if(0 != (var13 & 1)) {
               ++var28;
            } else if(0 != (var13 & 4)) {
               --var28;
            }
         }

         var31 = 0;

         while(var29-- > 0) {
            var5[var31] = class106.field1846[var29];
            var6[var31++] = class106.field1848[var29];
            if(var31 >= var5.length) {
               break;
            }
         }

         return var31;
      }
   }
}
