import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public final class class153 {
   @ObfuscatedName("es")
   static class83[] field2310;

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "25519"
   )
   static final void method3189(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class5.field91.method2025(var0, var1, var2);
      int var6;
      int var8;
      int var9;
      int var11;
      int var17;
      int var20;
      if(var5 != 0) {
         var6 = class5.field91.method2028(var0, var1, var2, var5);
         var17 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var19 = class20.field561.field1486;
         var11 = 4 * var1 + 24624 + 2048 * (103 - var2);
         var20 = var5 >> 14 & 32767;
         class42 var21 = class7.method100(var20);
         if(var21.field961 != -1) {
            class83 var14 = field2310[var21.field961];
            if(var14 != null) {
               int var15 = (var21.field976 * 4 - var14.field1500) / 2;
               int var16 = (var21.field980 * 4 - var14.field1497) / 2;
               var14.method1946(48 + 4 * var1 + var15, (104 - var2 - var21.field980) * 4 + 48 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var17 == 0) {
                  var19[var11] = var9;
                  var19[var11 + 512] = var9;
                  var19[1024 + var11] = var9;
                  var19[1536 + var11] = var9;
               } else if(var17 == 1) {
                  var19[var11] = var9;
                  var19[var11 + 1] = var9;
                  var19[var11 + 2] = var9;
                  var19[3 + var11] = var9;
               } else if(var17 == 2) {
                  var19[3 + var11] = var9;
                  var19[3 + var11 + 512] = var9;
                  var19[1024 + var11 + 3] = var9;
                  var19[var11 + 3 + 1536] = var9;
               } else if(var17 == 3) {
                  var19[var11 + 1536] = var9;
                  var19[1536 + var11 + 1] = var9;
                  var19[var11 + 1536 + 2] = var9;
                  var19[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var17 == 0) {
                  var19[var11] = var9;
               } else if(var17 == 1) {
                  var19[var11 + 3] = var9;
               } else if(var17 == 2) {
                  var19[1536 + 3 + var11] = var9;
               } else if(var17 == 3) {
                  var19[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var17 == 3) {
                  var19[var11] = var9;
                  var19[var11 + 512] = var9;
                  var19[1024 + var11] = var9;
                  var19[1536 + var11] = var9;
               } else if(var17 == 0) {
                  var19[var11] = var9;
                  var19[1 + var11] = var9;
                  var19[var11 + 2] = var9;
                  var19[3 + var11] = var9;
               } else if(var17 == 1) {
                  var19[var11 + 3] = var9;
                  var19[512 + var11 + 3] = var9;
                  var19[1024 + 3 + var11] = var9;
                  var19[3 + var11 + 1536] = var9;
               } else if(var17 == 2) {
                  var19[1536 + var11] = var9;
                  var19[var11 + 1536 + 1] = var9;
                  var19[var11 + 1536 + 2] = var9;
                  var19[1536 + var11 + 3] = var9;
               }
            }
         }
      }

      var5 = class5.field91.method2137(var0, var1, var2);
      if(var5 != 0) {
         var6 = class5.field91.method2028(var0, var1, var2, var5);
         var17 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class42 var23 = class7.method100(var9);
         int var13;
         if(var23.field961 != -1) {
            class83 var22 = field2310[var23.field961];
            if(null != var22) {
               var20 = (var23.field976 * 4 - var22.field1500) / 2;
               var13 = (var23.field980 * 4 - var22.field1497) / 2;
               var22.method1946(var20 + 4 * var1 + 48, (104 - var2 - var23.field980) * 4 + 48 + var13);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var12 = class20.field561.field1486;
            var13 = 24624 + 4 * var1 + (103 - var2) * 2048;
            if(var17 != 0 && var17 != 2) {
               var12[var13] = var11;
               var12[var13 + 512 + 1] = var11;
               var12[2 + 1024 + var13] = var11;
               var12[3 + 1536 + var13] = var11;
            } else {
               var12[var13 + 1536] = var11;
               var12[1 + var13 + 1024] = var11;
               var12[2 + 512 + var13] = var11;
               var12[3 + var13] = var11;
            }
         }
      }

      var5 = class5.field91.method2027(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class42 var7 = class7.method100(var6);
         if(var7.field961 != -1) {
            class83 var18 = field2310[var7.field961];
            if(var18 != null) {
               var9 = (var7.field976 * 4 - var18.field1500) / 2;
               int var10 = (var7.field980 * 4 - var18.field1497) / 2;
               var18.method1946(48 + 4 * var1 + var9, var10 + 48 + 4 * (104 - var2 - var7.field980));
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIIZI)V",
      garbageValue = "-2069014866"
   )
   public static void method3190(class170 var0, int var1, int var2, int var3, boolean var4) {
      class186.field3004 = 1;
      class128.field2089 = var0;
      class105.field1834 = var1;
      class186.field3009 = var2;
      class40.field903 = var3;
      class133.field2111 = var4;
      class186.field3010 = 10000;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public static String method3191(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class12.method153(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
