import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class161 {
   @ObfuscatedName("h")
   static char[] field2634;
   @ObfuscatedName("j")
   static char[] field2637 = new char[64];
   @ObfuscatedName("d")
   public static class172 field2639;
   @ObfuscatedName("m")
   static int[] field2640;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Lclass42;",
      garbageValue = "1"
   )
   public static class42 method3153(int var0) {
      class42 var1 = (class42)class42.field970.method3704((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class42.field980.method3217(12, var0);
         var1 = new class42();
         if(var2 != null) {
            var1.method850(new class119(var2));
         }

         var1.method852();
         class42.field970.method3706(var1, (long)var0);
         return var1;
      }
   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2637[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2637[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2637[var0] = (char)(48 + var0 - 52);
      }

      field2637[62] = 43;
      field2637[63] = 47;
      field2634 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2634[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2634[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2634[var0] = (char)(var0 + 48 - 52);
      }

      field2634[62] = 42;
      field2634[63] = 45;
      field2640 = new int[128];

      for(var0 = 0; var0 < field2640.length; ++var0) {
         field2640[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2640[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2640[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2640[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field2640;
      field2640[43] = 62;
      var2[42] = 62;
      int[] var1 = field2640;
      field2640[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIILclass86;Lclass108;I)V",
      garbageValue = "1649720898"
   )
   static final void method3155(int var0, int var1, int var2, int var3, int var4, int var5, int var6, class86 var7, class108 var8) {
      class40 var9 = class85.method1903(var4);
      int var10;
      int var11;
      if(var5 != 1 && 3 != var5) {
         var10 = var9.field920;
         var11 = var9.field921;
      } else {
         var10 = var9.field921;
         var11 = var9.field920;
      }

      int var12;
      int var13;
      if(var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var11 + var3 <= 104) {
         var14 = (var11 >> 1) + var3;
         var15 = (1 + var11 >> 1) + var3;
      } else {
         var14 = var3;
         var15 = 1 + var3;
      }

      int[][] var16 = class5.field91[var1];
      int var17 = var16[var13][var15] + var16[var13][var14] + var16[var12][var14] + var16[var12][var15] >> 2;
      int var18 = (var10 << 6) + (var2 << 7);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = 1073741824 + (var3 << 7) + var2 + (var4 << 14);
      if(var9.field917 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = var6 + (var5 << 6);
      if(1 == var9.field945) {
         var21 += 256;
      }

      Object var22;
      if(22 == var6) {
         if(-1 == var9.field928 && var9.field956 == null) {
            var22 = var9.method801(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new class12(var4, 22, var5, var1, var2, var3, var9.field928, true, (class85)null);
         }

         var7.method1911(var0, var2, var3, var17, (class85)var22, var20, var21);
         if(1 == var9.field922) {
            var8.method2382(var2, var3);
         }

      } else if(10 != var6 && 11 != var6) {
         if(var6 >= 12) {
            if(-1 == var9.field928 && var9.field956 == null) {
               var22 = var9.method801(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, var6, var5, var1, var2, var3, var9.field928, true, (class85)null);
            }

            var7.method2037(var0, var2, var3, var17, 1, 1, (class85)var22, 0, var20, var21);
            if(var9.field922 != 0) {
               var8.method2379(var2, var3, var10, var11, var9.field923);
            }

         } else if(0 == var6) {
            if(-1 == var9.field928 && null == var9.field956) {
               var22 = var9.method801(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, 0, var5, var1, var2, var3, var9.field928, true, (class85)null);
            }

            var7.method1913(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field92[var5], 0, var20, var21);
            if(0 != var9.field922) {
               var8.method2383(var2, var3, var6, var5, var9.field923);
            }

         } else if(var6 == 1) {
            if(-1 == var9.field928 && null == var9.field956) {
               var22 = var9.method801(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, 1, var5, var1, var2, var3, var9.field928, true, (class85)null);
            }

            var7.method1913(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field93[var5], 0, var20, var21);
            if(var9.field922 != 0) {
               var8.method2383(var2, var3, var6, var5, var9.field923);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               Object var28;
               if(-1 == var9.field928 && var9.field956 == null) {
                  var28 = var9.method801(2, 4 + var5, var16, var18, var17, var19);
                  var24 = var9.method801(2, var27, var16, var18, var17, var19);
               } else {
                  var28 = new class12(var4, 2, 4 + var5, var1, var2, var3, var9.field928, true, (class85)null);
                  var24 = new class12(var4, 2, var27, var1, var2, var3, var9.field928, true, (class85)null);
               }

               var7.method1913(var0, var2, var3, var17, (class85)var28, (class85)var24, class5.field92[var5], class5.field92[var27], var20, var21);
               if(0 != var9.field922) {
                  var8.method2383(var2, var3, var6, var5, var9.field923);
               }

            } else if(3 == var6) {
               if(-1 == var9.field928 && var9.field956 == null) {
                  var22 = var9.method801(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, 3, var5, var1, var2, var3, var9.field928, true, (class85)null);
               }

               var7.method1913(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field93[var5], 0, var20, var21);
               if(var9.field922 != 0) {
                  var8.method2383(var2, var3, var6, var5, var9.field923);
               }

            } else if(9 == var6) {
               if(var9.field928 == -1 && var9.field956 == null) {
                  var22 = var9.method801(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, var6, var5, var1, var2, var3, var9.field928, true, (class85)null);
               }

               var7.method2037(var0, var2, var3, var17, 1, 1, (class85)var22, 0, var20, var21);
               if(var9.field922 != 0) {
                  var8.method2379(var2, var3, var10, var11, var9.field923);
               }

            } else if(4 == var6) {
               if(-1 == var9.field928 && null == var9.field956) {
                  var22 = var9.method801(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, 4, var5, var1, var2, var3, var9.field928, true, (class85)null);
               }

               var7.method1914(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field92[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var27 = 16;
                  var23 = var7.method2034(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class85.method1903(var23 >> 14 & 32767).field929;
                  }

                  if(-1 == var9.field928 && var9.field956 == null) {
                     var24 = var9.method801(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5, var1, var2, var3, var9.field928, true, (class85)null);
                  }

                  var7.method1914(var0, var2, var3, var17, (class85)var24, (class85)null, class5.field92[var5], 0, class5.field94[var5] * var27, var27 * class5.field95[var5], var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var23 = var7.method2034(var0, var2, var3);
                  if(0 != var23) {
                     var27 = class85.method1903(var23 >> 14 & 32767).field929 / 2;
                  }

                  if(var9.field928 == -1 && null == var9.field956) {
                     var24 = var9.method801(4, 4 + var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, 4 + var5, var1, var2, var3, var9.field928, true, (class85)null);
                  }

                  var7.method1914(var0, var2, var3, var17, (class85)var24, (class85)null, 256, var5, var27 * class5.field96[var5], var27 * class5.field97[var5], var20, var21);
               } else if(var6 == 7) {
                  var23 = 2 + var5 & 3;
                  if(var9.field928 == -1 && var9.field956 == null) {
                     var22 = var9.method801(4, 4 + var23, var16, var18, var17, var19);
                  } else {
                     var22 = new class12(var4, 4, var23 + 4, var1, var2, var3, var9.field928, true, (class85)null);
                  }

                  var7.method1914(var0, var2, var3, var17, (class85)var22, (class85)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var23 = var7.method2034(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class85.method1903(var23 >> 14 & 32767).field929 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(-1 == var9.field928 && var9.field956 == null) {
                     var24 = var9.method801(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method801(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, 4 + var5, var1, var2, var3, var9.field928, true, (class85)null);
                     var25 = new class12(var4, 4, var26 + 4, var1, var2, var3, var9.field928, true, (class85)null);
                  }

                  var7.method1914(var0, var2, var3, var17, (class85)var24, (class85)var25, 256, var5, var27 * class5.field96[var5], class5.field97[var5] * var27, var20, var21);
               }
            }
         }
      } else {
         if(var9.field928 == -1 && null == var9.field956) {
            var22 = var9.method801(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new class12(var4, 10, var5, var1, var2, var3, var9.field928, true, (class85)null);
         }

         if(var22 != null) {
            var7.method2037(var0, var2, var3, var17, var10, var11, (class85)var22, var6 == 11?256:0, var20, var21);
         }

         if(0 != var9.field922) {
            var8.method2379(var2, var3, var10, var11, var9.field923);
         }

      }
   }
}
