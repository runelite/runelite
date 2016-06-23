import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class59 {
   @ObfuscatedName("go")
   static class173 field1225;
   @ObfuscatedName("u")
   class167 field1226;
   @ObfuscatedName("b")
   class196 field1227 = new class196(256);
   @ObfuscatedName("f")
   class167 field1230;
   @ObfuscatedName("x")
   class196 field1231 = new class196(256);
   @ObfuscatedName("il")
   static class173 field1234;
   @ObfuscatedName("q")
   static String field1236;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass62;",
      garbageValue = "-951187297"
   )
   class62 method1317(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1227.method3822(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1314(this.field1230, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1308();
            this.field1227.method3826(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1247.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass62;",
      garbageValue = "1557754184"
   )
   public class62 method1319(int var1, int[] var2) {
      if(this.field1230.method3292() == 1) {
         return this.method1317(0, var1, var2);
      } else if(this.field1230.method3321(var1) == 1) {
         return this.method1317(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass62;",
      garbageValue = "-1180812650"
   )
   class62 method1320(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1227.method3822(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1231.method3822(var5);
         if(var8 == null) {
            var8 = class70.method1594(this.field1226, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1231.method3826(var8, var5);
         }

         var7 = var8.method1610(var3);
         if(null == var7) {
            return null;
         } else {
            var8.method3946();
            this.field1227.method3826(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass62;",
      garbageValue = "238831029"
   )
   public class62 method1321(int var1, int[] var2) {
      if(this.field1226.method3292() == 1) {
         return this.method1320(0, var1, var2);
      } else if(this.field1226.method3321(var1) == 1) {
         return this.method1320(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class59(class167 var1, class167 var2) {
      this.field1230 = var1;
      this.field1226 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILclass107;Lclass108;Z[I[IB)I",
      garbageValue = "0"
   )
   public static int method1322(int var0, int var1, int var2, class107 var3, class108 var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class106.field1871[var8][var9] = 0;
            class106.field1872[var8][var9] = 99999999;
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
         class106.field1871[var12][var13] = 99;
         class106.field1872[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class106.field1876[var16] = var0;
         var33 = var16 + 1;
         class106.field1869[var16] = var1;
         var18 = var4.field1908;

         while(true) {
            if(var17 == var33) {
               class106.field1873 = var10;
               class106.field1875 = var11;
               var29 = false;
               break;
            }

            var10 = class106.field1876[var17];
            var11 = class106.field1869[var17];
            var17 = 1 + var17 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.field1904;
            var20 = var11 - var4.field1905;
            if(var3.vmethod2428(1, var10, var11, var4)) {
               class106.field1873 = var10;
               class106.field1875 = var11;
               var29 = true;
               break;
            }

            var21 = class106.field1872[var30][var31] + 1;
            if(var30 > 0 && class106.field1871[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class106.field1876[var33] = var10 - 1;
               class106.field1869[var33] = var11;
               var33 = var33 + 1 & 4095;
               class106.field1871[var30 - 1][var31] = 2;
               class106.field1872[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class106.field1871[1 + var30][var31] == 0 && (var18[1 + var19][var20] & 19136896) == 0) {
               class106.field1876[var33] = var10 + 1;
               class106.field1869[var33] = var11;
               var33 = 1 + var33 & 4095;
               class106.field1871[1 + var30][var31] = 8;
               class106.field1872[1 + var30][var31] = var21;
            }

            if(var31 > 0 && class106.field1871[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class106.field1876[var33] = var10;
               class106.field1869[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class106.field1871[var30][var31 - 1] = 1;
               class106.field1872[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class106.field1871[var30][var31 + 1] == 0 && (var18[var19][1 + var20] & 19136800) == 0) {
               class106.field1876[var33] = var10;
               class106.field1869[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class106.field1871[var30][1 + var31] = 4;
               class106.field1872[var30][1 + var31] = var21;
            }

            if(var30 > 0 && var31 > 0 && class106.field1871[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class106.field1876[var33] = var10 - 1;
               class106.field1869[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class106.field1871[var30 - 1][var31 - 1] = 3;
               class106.field1872[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class106.field1871[1 + var30][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[1 + var19][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class106.field1876[var33] = var10 + 1;
               class106.field1869[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class106.field1871[1 + var30][var31 - 1] = 9;
               class106.field1872[1 + var30][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class106.field1871[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class106.field1876[var33] = var10 - 1;
               class106.field1869[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class106.field1871[var30 - 1][1 + var31] = 6;
               class106.field1872[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class106.field1871[var30 + 1][1 + var31] == 0 && (var18[var19 + 1][1 + var20] & 19136992) == 0 && (var18[1 + var19][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class106.field1876[var33] = var10 + 1;
               class106.field1869[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class106.field1871[1 + var30][1 + var31] = 12;
               class106.field1872[var30 + 1][1 + var31] = var21;
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
         class106.field1871[var12][var13] = 99;
         class106.field1872[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class106.field1876[var16] = var0;
         var33 = var16 + 1;
         class106.field1869[var16] = var1;
         var18 = var4.field1908;

         while(true) {
            if(var17 == var33) {
               class106.field1873 = var10;
               class106.field1875 = var11;
               var29 = false;
               break;
            }

            var10 = class106.field1876[var17];
            var11 = class106.field1869[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.field1904;
            var20 = var11 - var4.field1905;
            if(var3.vmethod2428(2, var10, var11, var4)) {
               class106.field1873 = var10;
               class106.field1875 = var11;
               var29 = true;
               break;
            }

            var21 = class106.field1872[var30][var31] + 1;
            if(var30 > 0 && class106.field1871[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0) {
               class106.field1876[var33] = var10 - 1;
               class106.field1869[var33] = var11;
               var33 = 1 + var33 & 4095;
               class106.field1871[var30 - 1][var31] = 2;
               class106.field1872[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class106.field1871[1 + var30][var31] == 0 && (var18[var19 + 2][var20] & 19136899) == 0 && (var18[2 + var19][1 + var20] & 19136992) == 0) {
               class106.field1876[var33] = var10 + 1;
               class106.field1869[var33] = var11;
               var33 = 1 + var33 & 4095;
               class106.field1871[var30 + 1][var31] = 8;
               class106.field1872[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class106.field1871[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0) {
               class106.field1876[var33] = var10;
               class106.field1869[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class106.field1871[var30][var31 - 1] = 1;
               class106.field1872[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class106.field1871[var30][var31 + 1] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[1 + var19][2 + var20] & 19136992) == 0) {
               class106.field1876[var33] = var10;
               class106.field1869[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class106.field1871[var30][var31 + 1] = 4;
               class106.field1872[var30][1 + var31] = var21;
            }

            if(var30 > 0 && var31 > 0 && class106.field1871[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class106.field1876[var33] = var10 - 1;
               class106.field1869[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class106.field1871[var30 - 1][var31 - 1] = 3;
               class106.field1872[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class106.field1871[var30 + 1][var31 - 1] == 0 && (var18[1 + var19][var20 - 1] & 19136911) == 0 && (var18[2 + var19][var20 - 1] & 19136899) == 0 && (var18[2 + var19][var20] & 19136995) == 0) {
               class106.field1876[var33] = var10 + 1;
               class106.field1869[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class106.field1871[1 + var30][var31 - 1] = 9;
               class106.field1872[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class106.field1871[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136830) == 0 && (var18[var19 - 1][var20 + 2] & 19136824) == 0 && (var18[var19][2 + var20] & 19137016) == 0) {
               class106.field1876[var33] = var10 - 1;
               class106.field1869[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class106.field1871[var30 - 1][var31 + 1] = 6;
               class106.field1872[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 126 && var31 < 126 && class106.field1871[1 + var30][var31 + 1] == 0 && (var18[1 + var19][2 + var20] & 19137016) == 0 && (var18[var19 + 2][2 + var20] & 19136992) == 0 && (var18[2 + var19][1 + var20] & 19136995) == 0) {
               class106.field1876[var33] = var10 + 1;
               class106.field1869[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class106.field1871[var30 + 1][1 + var31] = 12;
               class106.field1872[1 + var30][1 + var31] = var21;
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
         class106.field1871[var12][var13] = 99;
         class106.field1872[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class106.field1876[var16] = var0;
         var33 = var16 + 1;
         class106.field1869[var16] = var1;
         var18 = var4.field1908;

         label887:
         while(true) {
            label885:
            while(true) {
               do {
                  do {
                     do {
                        label862:
                        do {
                           if(var17 == var33) {
                              class106.field1873 = var10;
                              class106.field1875 = var11;
                              var29 = false;
                              break label887;
                           }

                           var10 = class106.field1876[var17];
                           var11 = class106.field1869[var17];
                           var17 = 1 + var17 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.field1904;
                           var20 = var11 - var4.field1905;
                           if(var3.vmethod2428(var2, var10, var11, var4)) {
                              class106.field1873 = var10;
                              class106.field1875 = var11;
                              var29 = true;
                              break label887;
                           }

                           var21 = 1 + class106.field1872[var30][var31];
                           if(var30 > 0 && class106.field1871[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var2 + var20 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class106.field1876[var33] = var10 - 1;
                                    class106.field1869[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class106.field1871[var30 - 1][var31] = 2;
                                    class106.field1872[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + var20] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class106.field1871[var30 + 1][var31] == 0 && (var18[var2 + var19][var20] & 19136899) == 0 && (var18[var2 + var19][var2 + var20 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class106.field1876[var33] = 1 + var10;
                                    class106.field1869[var33] = var11;
                                    var33 = 1 + var33 & 4095;
                                    class106.field1871[var30 + 1][var31] = 8;
                                    class106.field1872[1 + var30][var31] = var21;
                                    break;
                                 }

                                 if((var18[var2 + var19][var22 + var20] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class106.field1871[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var2 + var19 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class106.field1876[var33] = var10;
                                    class106.field1869[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class106.field1871[var30][var31 - 1] = 1;
                                    class106.field1872[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class106.field1871[var30][1 + var31] == 0 && (var18[var19][var2 + var20] & 19136824) == 0 && (var18[var2 + var19 - 1][var20 + var2] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class106.field1876[var33] = var10;
                                    class106.field1869[var33] = 1 + var11;
                                    var33 = var33 + 1 & 4095;
                                    class106.field1871[var30][var31 + 1] = 4;
                                    class106.field1872[var30][var31 + 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 + var2] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class106.field1871[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class106.field1876[var33] = var10 - 1;
                                    class106.field1869[var33] = var11 - 1;
                                    var33 = 1 + var33 & 4095;
                                    class106.field1871[var30 - 1][var31 - 1] = 3;
                                    class106.field1872[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + (var20 - 1)] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class106.field1871[1 + var30][var31 - 1] == 0 && (var18[var19 + var2][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class106.field1876[var33] = var10 + 1;
                                    class106.field1869[var33] = var11 - 1;
                                    var33 = 1 + var33 & 4095;
                                    class106.field1871[1 + var30][var31 - 1] = 9;
                                    class106.field1872[var30 + 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var20 - 1 + var22] & 19136995) != 0 || (var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class106.field1871[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + var2] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 + var2] & 19137016) != 0) {
                                    continue label862;
                                 }
                              }

                              class106.field1876[var33] = var10 - 1;
                              class106.field1869[var33] = var11 + 1;
                              var33 = var33 + 1 & 4095;
                              class106.field1871[var30 - 1][var31 + 1] = 6;
                              class106.field1872[var30 - 1][1 + var31] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class106.field1871[var30 + 1][1 + var31] != 0);
               } while((var18[var2 + var19][var20 + var2] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var22 + var19][var20 + var2] & 19137016) != 0 || (var18[var19 + var2][var20 + var22] & 19136995) != 0) {
                     continue label885;
                  }
               }

               class106.field1876[var33] = var10 + 1;
               class106.field1869[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class106.field1871[1 + var30][1 + var31] = 12;
               class106.field1872[1 + var30][var31 + 1] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class106.field1873;
      var30 = class106.field1875;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1886;
         var17 = var3.field1881;
         int var27 = var3.field1885;
         var19 = var3.field1883;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class106.field1872[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var33 + var27 - 1) {
                     var24 = var20 - (var33 + var27 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var31 == var26 && class106.field1872[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class106.field1872[var22][var23];
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
         class106.field1876[var13] = var11;
         var31 = var13 + 1;
         class106.field1869[var13] = var30;

         for(var14 = var15 = class106.field1871[var11 - var9][var30 - var10]; var11 != var0 || var30 != var1; var14 = class106.field1871[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class106.field1876[var31] = var11;
               class106.field1869[var31++] = var30;
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
            var6[var33] = class106.field1876[var31];
            var7[var33++] = class106.field1869[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "-1628775457"
   )
   public static void method1330(class167 var0) {
      class226.field3215 = var0;
   }
}
