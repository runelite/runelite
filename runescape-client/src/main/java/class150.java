import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public final class class150 {
   @ObfuscatedName("ds")
   @Export("region")
   static class86 field2230;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI)Lclass224;",
      garbageValue = "-1946798889"
   )
   public static class224 method3150(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         class224 var1 = new class224(var0, class76.field1353, class131.field2048, class76.field1354, class28.field674, class8.field135, class76.field1355);
         class7.method95();
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "314509191"
   )
   public static String method3151(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class39.method797(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "0"
   )
   public static void method3152(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method3152(var0, var1, var2, var5 - 1);
         method3152(var0, var1, 1 + var5, var3);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass80;I)V",
      garbageValue = "1503107287"
   )
   static final void method3153(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class28.field673.length; ++var2) {
         class28.field673[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class28.field673[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class82.field1406[var5] = (class28.field673[1 + var5] + class28.field673[var5 - 1] + class28.field673[var5 - 128] + class28.field673[var5 + 128]) / 4;
            }
         }

         int[] var8 = class28.field673;
         class28.field673 = class82.field1406;
         class82.field1406 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1391; ++var3) {
            for(var4 = 0; var4 < var0.field1390; ++var4) {
               if(var0.field1394[var2++] != 0) {
                  var5 = 16 + var4 + var0.field1392;
                  int var6 = var0.field1395 + var3 + 16;
                  int var7 = var5 + (var6 << 7);
                  class28.field673[var7] = 0;
               }
            }
         }
      }

   }
}
