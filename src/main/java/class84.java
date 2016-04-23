import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class84 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1334521815
   )
   int field1439;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -433091203
   )
   int field1440;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1013415383
   )
   int field1442;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)Z",
      garbageValue = "-939585810"
   )
   static boolean method1892(class122 var0, int var1) {
      int var2 = var0.method2737(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2737(1) != 0) {
            method1892(var0, var1);
         }

         var3 = var0.method2737(6);
         var4 = var0.method2737(6);
         boolean var11 = var0.method2737(1) == 1;
         if(var11) {
            class32.field745[++class32.field733 - 1] = var1;
         }

         if(client.field396[var1] != null) {
            throw new RuntimeException();
         } else {
            class2 var12 = client.field396[var1] = new class2();
            var12.field52 = var1;
            if(class32.field736[var1] != null) {
               var12.method8(class32.field736[var1]);
            }

            var12.field844 = class32.field742[var1];
            var12.field819 = class32.field743[var1];
            var7 = class32.field741[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var12.field850[0] = class32.field735[var1];
            var12.field57 = (byte)var8;
            var12.method13(var3 + (var9 << 6) - class187.field3014, (var10 << 6) + var4 - class0.field12);
            var12.field59 = false;
            return true;
         }
      } else if(1 == var2) {
         var3 = var0.method2737(2);
         var4 = class32.field741[var1];
         class32.field741[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2737(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class32.field741[var1];
            var7 = (var6 >> 28) + var4 & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(2 == var5) {
               ++var8;
               --var9;
            }

            if(3 == var5) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(6 == var5) {
               ++var9;
            }

            if(7 == var5) {
               ++var8;
               ++var9;
            }

            class32.field741[var1] = var9 + (var8 << 14) + (var7 << 28);
            return false;
         } else {
            var3 = var0.method2737(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class32.field741[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var6 & 255;
            class32.field741[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass103;",
      garbageValue = "1112956865"
   )
   static class103 method1893(int var0) {
      class103 var1 = (class103)class42.field971.method3704((long)var0);
      if(null != var1) {
         return var1;
      } else {
         class167 var3 = class42.field968;
         class167 var4 = class42.field969;
         boolean var5 = true;
         int[] var6 = var3.method3226(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3223(var0, var6[var7]);
            if(null == var8) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3223(var9, 0);
               if(null == var10) {
                  var5 = false;
               }
            }
         }

         class103 var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new class103(var3, var4, var0, false);
            } catch (Exception var11) {
               var2 = null;
            }
         }

         if(null != var2) {
            class42.field971.method3706(var2, (long)var0);
         }

         return var2;
      }
   }
}
