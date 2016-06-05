import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public final class class163 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1886244781
   )
   static int field2680;
   @ObfuscatedName("r")
   public static class167 field2681;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1993580791"
   )
   static void method3181(byte[] var0) {
      class119 var1 = new class119(var0);
      var1.field2000 = var0.length - 2;
      class76.field1387 = var1.method2470();
      class76.field1388 = new int[class76.field1387];
      class165.field2689 = new int[class76.field1387];
      class76.field1385 = new int[class76.field1387];
      class14.field209 = new int[class76.field1387];
      class45.field1045 = new byte[class76.field1387][];
      var1.field2000 = var0.length - 7 - class76.field1387 * 8;
      class76.field1386 = var1.method2470();
      class76.field1392 = var1.method2470();
      int var2 = (var1.method2494() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class76.field1387; ++var3) {
         class76.field1388[var3] = var1.method2470();
      }

      for(var3 = 0; var3 < class76.field1387; ++var3) {
         class165.field2689[var3] = var1.method2470();
      }

      for(var3 = 0; var3 < class76.field1387; ++var3) {
         class76.field1385[var3] = var1.method2470();
      }

      for(var3 = 0; var3 < class76.field1387; ++var3) {
         class14.field209[var3] = var1.method2470();
      }

      var1.field2000 = var0.length - 7 - class76.field1387 * 8 - 3 * (var2 - 1);
      class14.field213 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class14.field213[var3] = var1.method2472();
         if(class14.field213[var3] == 0) {
            class14.field213[var3] = 1;
         }
      }

      var1.field2000 = 0;

      for(var3 = 0; var3 < class76.field1387; ++var3) {
         int var4 = class76.field1385[var3];
         int var5 = class14.field209[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class45.field1045[var3] = var7;
         int var8 = var1.method2494();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2469();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var4 * var10 + var9] = var1.method2469();
               }
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "-1233429165"
   )
   static String method3185(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IZIZB)V",
      garbageValue = "61"
   )
   static void method3186(int var0, boolean var1, int var2, boolean var3) {
      if(class25.field636 != null) {
         class41.method847(0, class25.field636.length - 1, var0, var1, var2, var3);
      }

   }
}
