import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("XItemContainer")
public class class15 extends class207 {
   @ObfuscatedName("ds")
   static byte[][] field214;
   @ObfuscatedName("r")
   @Export("itemIds")
   int[] field215 = new int[]{-1};
   @ObfuscatedName("el")
   static class78[] field216;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 1070271175
   )
   static int field217;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1463402645
   )
   static int field218;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 838886437
   )
   @Export("cameraPitch")
   static int field219;
   @ObfuscatedName("pm")
   static class133 field220;
   @ObfuscatedName("f")
   @Export("stackSizes")
   int[] field221 = new int[]{0};
   @ObfuscatedName("a")
   @Export("itemContainers")
   static class195 field225 = new class195(32);

   @ObfuscatedName("r")
   static void method190(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != class25.field637[var5]) {
            var2[var4] = class25.field637[var5];
            var3[var4] = class25.field636[var5];
            ++var4;
         }
      }

      class25.field637 = var2;
      class25.field636 = var3;
      class4.method53(class25.field633, 0, class25.field633.length - 1, class25.field637, class25.field636);
   }

   @ObfuscatedName("j")
   static int method192(int var0, int var1, int var2) {
      return (class5.field90[var0][var1][var2] & 8) != 0?0:(var0 > 0 && 0 != (class5.field90[1][var1][var2] & 2)?var0 - 1:var0);
   }

   @ObfuscatedName("a")
   public static void method194(class166 var0, class166 var1, class166 var2) {
      class42.field991 = var0;
      class42.field984 = var1;
      class42.field985 = var2;
   }

   @ObfuscatedName("a")
   public static class129 method195(int var0) {
      class129[] var1 = new class129[]{class129.field2046, class129.field2055, class129.field2049};
      class129[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class129 var4 = var2[var3];
         if(var4.field2050 == var0) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIIILclass85;Lclass107;S)V",
      garbageValue = "-14693"
   )
   static final void method196(int var0, int var1, int var2, int var3, int var4, int var5, int var6, class85 var7, class107 var8) {
      class40 var9 = class156.method3176(var4);
      int var10;
      int var11;
      if(1 != var5 && var5 != 3) {
         var10 = var9.field938;
         var11 = var9.field939;
      } else {
         var10 = var9.field939;
         var11 = var9.field938;
      }

      int var12;
      int var13;
      if(var2 + var10 <= 104) {
         var12 = var2 + (var10 >> 1);
         var13 = (var10 + 1 >> 1) + var2;
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var11 + var3 <= 104) {
         var14 = (var11 >> 1) + var3;
         var15 = (var11 + 1 >> 1) + var3;
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class5.field86[var1];
      int var17 = var16[var12][var15] + var16[var13][var14] + var16[var12][var14] + var16[var13][var15] >> 2;
      int var18 = (var10 << 6) + (var2 << 7);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = 1073741824 + (var4 << 14) + (var3 << 7) + var2;
      if(0 == var9.field942) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = var6 + (var5 << 6);
      if(var9.field963 == 1) {
         var21 += 256;
      }

      Object var22;
      if(22 == var6) {
         if(var9.field946 == -1 && null == var9.field955) {
            var22 = var9.method812(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new class12(var4, 22, var5, var1, var2, var3, var9.field946, true, (class84)null);
         }

         var7.method1928(var0, var2, var3, var17, (class84)var22, var20, var21);
         if(1 == var9.field925) {
            var8.method2400(var2, var3);
         }

      } else if(10 != var6 && var6 != 11) {
         if(var6 >= 12) {
            if(-1 == var9.field946 && null == var9.field955) {
               var22 = var9.method812(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, var6, var5, var1, var2, var3, var9.field946, true, (class84)null);
            }

            var7.method1932(var0, var2, var3, var17, 1, 1, (class84)var22, 0, var20, var21);
            if(var9.field925 != 0) {
               var8.method2398(var2, var3, var10, var11, var9.field941);
            }

         } else if(0 == var6) {
            if(var9.field946 == -1 && null == var9.field955) {
               var22 = var9.method812(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, 0, var5, var1, var2, var3, var9.field946, true, (class84)null);
            }

            var7.method1972(var0, var2, var3, var17, (class84)var22, (class84)null, class5.field81[var5], 0, var20, var21);
            if(0 != var9.field925) {
               var8.method2416(var2, var3, var6, var5, var9.field941);
            }

         } else if(1 == var6) {
            if(-1 == var9.field946 && var9.field955 == null) {
               var22 = var9.method812(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, 1, var5, var1, var2, var3, var9.field946, true, (class84)null);
            }

            var7.method1972(var0, var2, var3, var17, (class84)var22, (class84)null, class5.field82[var5], 0, var20, var21);
            if(0 != var9.field925) {
               var8.method2416(var2, var3, var6, var5, var9.field941);
            }

         } else {
            Object var24;
            int var27;
            if(2 == var6) {
               var27 = 1 + var5 & 3;
               Object var28;
               if(var9.field946 == -1 && null == var9.field955) {
                  var28 = var9.method812(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method812(2, var27, var16, var18, var17, var19);
               } else {
                  var28 = new class12(var4, 2, 4 + var5, var1, var2, var3, var9.field946, true, (class84)null);
                  var24 = new class12(var4, 2, var27, var1, var2, var3, var9.field946, true, (class84)null);
               }

               var7.method1972(var0, var2, var3, var17, (class84)var28, (class84)var24, class5.field81[var5], class5.field81[var27], var20, var21);
               if(var9.field925 != 0) {
                  var8.method2416(var2, var3, var6, var5, var9.field941);
               }

            } else if(var6 == 3) {
               if(var9.field946 == -1 && null == var9.field955) {
                  var22 = var9.method812(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, 3, var5, var1, var2, var3, var9.field946, true, (class84)null);
               }

               var7.method1972(var0, var2, var3, var17, (class84)var22, (class84)null, class5.field82[var5], 0, var20, var21);
               if(var9.field925 != 0) {
                  var8.method2416(var2, var3, var6, var5, var9.field941);
               }

            } else if(9 == var6) {
               if(var9.field946 == -1 && null == var9.field955) {
                  var22 = var9.method812(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, var6, var5, var1, var2, var3, var9.field946, true, (class84)null);
               }

               var7.method1932(var0, var2, var3, var17, 1, 1, (class84)var22, 0, var20, var21);
               if(0 != var9.field925) {
                  var8.method2398(var2, var3, var10, var11, var9.field941);
               }

            } else if(var6 == 4) {
               if(var9.field946 == -1 && var9.field955 == null) {
                  var22 = var9.method812(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, 4, var5, var1, var2, var3, var9.field946, true, (class84)null);
               }

               var7.method1931(var0, var2, var3, var17, (class84)var22, (class84)null, class5.field81[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var27 = 16;
                  var23 = var7.method1948(var0, var2, var3);
                  if(0 != var23) {
                     var27 = class156.method3176(var23 >> 14 & 32767).field951;
                  }

                  if(-1 == var9.field946 && var9.field955 == null) {
                     var24 = var9.method812(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5, var1, var2, var3, var9.field946, true, (class84)null);
                  }

                  var7.method1931(var0, var2, var3, var17, (class84)var24, (class84)null, class5.field81[var5], 0, class5.field83[var5] * var27, class5.field84[var5] * var27, var20, var21);
               } else if(6 == var6) {
                  var27 = 8;
                  var23 = var7.method1948(var0, var2, var3);
                  if(0 != var23) {
                     var27 = class156.method3176(var23 >> 14 & 32767).field951 / 2;
                  }

                  if(-1 == var9.field946 && var9.field955 == null) {
                     var24 = var9.method812(4, 4 + var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5 + 4, var1, var2, var3, var9.field946, true, (class84)null);
                  }

                  var7.method1931(var0, var2, var3, var17, (class84)var24, (class84)null, 256, var5, var27 * class5.field79[var5], class5.field77[var5] * var27, var20, var21);
               } else if(var6 == 7) {
                  var23 = var5 + 2 & 3;
                  if(var9.field946 == -1 && var9.field955 == null) {
                     var22 = var9.method812(4, 4 + var23, var16, var18, var17, var19);
                  } else {
                     var22 = new class12(var4, 4, 4 + var23, var1, var2, var3, var9.field946, true, (class84)null);
                  }

                  var7.method1931(var0, var2, var3, var17, (class84)var22, (class84)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var23 = var7.method1948(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class156.method3176(var23 >> 14 & 32767).field951 / 2;
                  }

                  int var26 = 2 + var5 & 3;
                  Object var25;
                  if(-1 == var9.field946 && var9.field955 == null) {
                     var24 = var9.method812(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method812(4, 4 + var26, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, 4 + var5, var1, var2, var3, var9.field946, true, (class84)null);
                     var25 = new class12(var4, 4, var26 + 4, var1, var2, var3, var9.field946, true, (class84)null);
                  }

                  var7.method1931(var0, var2, var3, var17, (class84)var24, (class84)var25, 256, var5, class5.field79[var5] * var27, var27 * class5.field77[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.field946 == -1 && null == var9.field955) {
            var22 = var9.method812(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new class12(var4, 10, var5, var1, var2, var3, var9.field946, true, (class84)null);
         }

         if(var22 != null) {
            var7.method1932(var0, var2, var3, var17, var10, var11, (class84)var22, var6 == 11?256:0, var20, var21);
         }

         if(0 != var9.field925) {
            var8.method2398(var2, var3, var10, var11, var9.field941);
         }

      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "673767053"
   )
   static final void method197(boolean var0) {
      class10.method146();
      ++client.field341;
      if(client.field341 >= 50 || var0) {
         client.field341 = 0;
         if(!client.field346 && null != class178.field2912) {
            client.field301.method2753(163);

            try {
               class178.field2912.method3003(client.field301.field1980, 0, client.field301.field1979);
               client.field301.field1979 = 0;
            } catch (IOException var2) {
               client.field346 = true;
            }
         }

      }
   }
}
