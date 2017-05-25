import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class73 extends class163 {
   @ObfuscatedName("y")
   static String field847;
   @ObfuscatedName("aq")
   static FontMetrics field850;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = -1419578159
   )
   static int field852;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "1503685727"
   )
   public boolean vmethod3110(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2289 && var3 == super.field2287;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1689658475"
   )
   static int method1135(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class261.method4792(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class83.field1311:Buffer.field2384;
      }

      if(var0 == 1927) {
         if(class83.field1321 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2751 == null) {
            return 0;
         } else {
            class69 var4 = new class69();
            var4.field816 = var3;
            var4.field826 = var3.field2751;
            var4.field824 = class83.field1321 + 1;
            Client.field1089.method3655(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-484885426"
   )
   public static String method1140(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var1 + var2; var5 < var6; var3[var4++] = (char)var8) {
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
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
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
}
