import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class118 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -8227153301322544145L
   )
   static long field2032;
   @ObfuscatedName("q")
   public static String field2034;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1277364705"
   )
   public static int method2512(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1193708665"
   )
   public static int method2513(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1973059692"
   )
   public static void method2514() {
      Sequence.field1023.reset();
      Sequence.field1005.reset();
   }
}
