import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class204 {
   @ObfuscatedName("o")
   static final char[] field3065 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("r")
   static final char[] field3066 = new char[]{'[', ']', '#'};

   class204() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;IIS)Ljava/lang/String;",
      garbageValue = "20342"
   )
   public static String method3813(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return null == var3?"null":var3.toString();
      } else {
         int var9 = var2 + var1;
         int var4 = 0;

         for(int var8 = var1; var8 < var9; ++var8) {
            CharSequence var10 = var0[var8];
            if(var10 == null) {
               var4 += 4;
            } else {
               var4 += var10.length();
            }
         }

         StringBuilder var5 = new StringBuilder(var4);

         for(int var6 = var1; var6 < var9; ++var6) {
            CharSequence var7 = var0[var6];
            if(null == var7) {
               var5.append("null");
            } else {
               var5.append(var7);
            }
         }

         return var5.toString();
      }
   }
}
