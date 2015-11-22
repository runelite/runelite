package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aj")
public class class49 extends class203 {
   @ObfuscatedName("f")
   public boolean field1072 = false;
   @ObfuscatedName("m")
   public static class192 field1073 = new class192(64);
   @ObfuscatedName("j")
   public static class166 field1076;

   @ObfuscatedName("f")
   public static String method1038(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(1 + var5 < var6 && 128 == (var0[var5] & 192) && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && 128 == (var0[var5 + 1] & 192) && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("m")
   public void method1039(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(var2 == 0) {
            return;
         }

         this.method1040(var2);
      }
   }

   @ObfuscatedName("f")
   void method1040(int var1) {
      if(2 == var1) {
         this.field1072 = true;
      }

   }

   @ObfuscatedName("ch")
   static void method1044(class172 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2749;
      int var5 = var0.field2750;
      if(var0.field2741 == 0) {
         var0.field2749 = var0.field2860;
      } else if(var0.field2741 == 1) {
         var0.field2749 = var1 - var0.field2860;
      } else if(var0.field2741 == 2) {
         var0.field2749 = var0.field2860 * var1 >> 14;
      }

      if(0 == var0.field2837) {
         var0.field2750 = var0.field2746;
      } else if(1 == var0.field2837) {
         var0.field2750 = var2 - var0.field2746;
      } else if(var0.field2837 == 2) {
         var0.field2750 = var0.field2746 * var2 >> 14;
      }

      if(4 == var0.field2741) {
         var0.field2749 = var0.field2750 * var0.field2751 / var0.field2752;
      }

      if(var0.field2837 == 4) {
         var0.field2750 = var0.field2752 * var0.field2749 / var0.field2751;
      }

      if(client.field442 && 0 == var0.field2736) {
         if(var0.field2750 < 5 && var0.field2749 < 5) {
            var0.field2750 = 5;
            var0.field2749 = 5;
         } else {
            if(var0.field2750 <= 0) {
               var0.field2750 = 5;
            }

            if(var0.field2749 <= 0) {
               var0.field2749 = 5;
            }
         }
      }

      if(1337 == var0.field2738) {
         client.field535 = var0;
      }

      if(var3 && var0.field2841 != null && (var4 != var0.field2749 || var5 != var0.field2750)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field10 = var0.field2841;
         client.field473.method3868(var6);
      }

   }

   @ObfuscatedName("m")
   public static String method1046(CharSequence[] var0, int var1, int var2) {
      if(0 == var2) {
         return "";
      } else if(1 == var2) {
         CharSequence var8 = var0[var1];
         return var8 == null?"null":var8.toString();
      } else {
         int var3 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var3; ++var5) {
            CharSequence var6 = var0[var5];
            if(null == var6) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var3; ++var10) {
            CharSequence var7 = var0[var10];
            if(null == var7) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }

   @ObfuscatedName("a")
   public static boolean method1051(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
