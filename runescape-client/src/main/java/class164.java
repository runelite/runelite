import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class164 {
   @ObfuscatedName("x")
   static final char[] field2662 = new char[]{'[', ']', '#'};
   @ObfuscatedName("bv")
   static class168 field2663;
   @ObfuscatedName("p")
   static final char[] field2664 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("cd")
   static class224 field2665;
   @ObfuscatedName("er")
   static class78[] field2668;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "125"
   )
   public static String method3209(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && 45 != var4 && var4 != 42 && 95 != var4) {
            if(32 == var4) {
               var2.append('+');
            } else {
               byte var5 = class94.method2145(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "1907572862"
   )
   public static int method3215(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      byte var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(0 != var7) {
            var9 = (char)var7;
            boolean var10 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var14;
         if(var8 != 0) {
            var14 = (char)var8;
            boolean var11 = false;
         } else {
            var14 = var1.charAt(var6++);
         }

         byte var16;
         if(198 == var9) {
            var16 = 69;
         } else if(var9 == 230) {
            var16 = 101;
         } else if(var9 == 223) {
            var16 = 115;
         } else if(var9 == 338) {
            var16 = 69;
         } else if(339 == var9) {
            var16 = 101;
         } else {
            var16 = 0;
         }

         var7 = var16;
         byte var12;
         if(198 == var14) {
            var12 = 69;
         } else if(230 == var14) {
            var12 = 101;
         } else if(223 == var14) {
            var12 = 115;
         } else if(var14 == 338) {
            var12 = 69;
         } else if(339 == var14) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = class171.method3363(var9, var2);
         var14 = class171.method3363(var14, var2);
         if(var9 != var14 && Character.toUpperCase(var9) != Character.toUpperCase(var14)) {
            var9 = Character.toLowerCase(var9);
            var14 = Character.toLowerCase(var14);
            if(var14 != var9) {
               return class102.method2269(var9, var2) - class102.method2269(var14, var2);
            }
         }
      }

      int var15 = Math.min(var3, var4);

      int var17;
      char var18;
      for(var17 = 0; var17 < var15; ++var17) {
         char var19 = var0.charAt(var17);
         var18 = var1.charAt(var17);
         if(var19 != var18 && Character.toUpperCase(var19) != Character.toUpperCase(var18)) {
            var19 = Character.toLowerCase(var19);
            var18 = Character.toLowerCase(var18);
            if(var18 != var19) {
               return class102.method2269(var19, var2) - class102.method2269(var18, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var20 = 0; var20 < var15; ++var20) {
            var18 = var0.charAt(var20);
            char var13 = var1.charAt(var20);
            if(var13 != var18) {
               return class102.method2269(var18, var2) - class102.method2269(var13, var2);
            }
         }

         return 0;
      }
   }
}
