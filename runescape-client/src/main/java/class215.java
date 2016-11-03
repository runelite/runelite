import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class215 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 896260595
   )
   public final int field3186;
   @ObfuscatedName("q")
   static final class215 field3187 = new class215(1, 1, "", "");
   @ObfuscatedName("f")
   static final class215 field3188 = new class215(7, 2, "", "");
   @ObfuscatedName("c")
   static final class215 field3189 = new class215(4, 3, "", "");
   @ObfuscatedName("j")
   static final class215 field3190 = new class215(5, 5, "", "");
   @ObfuscatedName("l")
   final String field3191;
   @ObfuscatedName("m")
   static final class215 field3192 = new class215(2, 6, "", "");
   @ObfuscatedName("k")
   public static final class215 field3193 = new class215(6, 0, "", "");
   @ObfuscatedName("u")
   public static final class215 field3194;
   @ObfuscatedName("v")
   static final class215 field3195 = new class215(3, 4, "", "");
   @ObfuscatedName("y")
   static final class215 field3196 = new class215(8, 7, "", "");

   class215(int var1, int var2, String var3, String var4) {
      this.field3186 = var1;
      this.field3191 = var4;
   }

   class215(int var1, int var2, String var3, String var4, boolean var5, class215[] var6) {
      this.field3186 = var1;
      this.field3191 = var4;
   }

   static {
      field3194 = new class215(0, -1, "", "", true, new class215[]{field3193, field3187, field3188, field3195, field3189});
   }

   public String toString() {
      return this.field3191;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "-2138900391"
   )
   public static long method3972(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(1 + var5 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }
}
