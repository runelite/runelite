import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class76 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1639165669
   )
   public static int field1396;
   @ObfuscatedName("b")
   public static int[] field1397;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -930984735
   )
   public static int field1398;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1443232745
   )
   static int field1399;
   @ObfuscatedName("g")
   public static byte[][] field1400;

   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)Lclass173;",
      garbageValue = "82"
   )
   static class173 method1704(class173 var0) {
      int var2 = class18.method205(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class153.method3177(var0.field2773);
            if(null == var0) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "896701687"
   )
   public static String method1706(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var1 * var0;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(48 + var8);
               }
            }

            return new String(var5);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "924519291"
   )
   public static boolean method1721(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
