import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public final class class153 {
   @ObfuscatedName("e")
   static int[] field2294;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)I",
      garbageValue = "2047"
   )
   public static int method3160(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;B)V",
      garbageValue = "78"
   )
   public static void method3161(class170 var0, class170 var1) {
      class49.field1087 = var0;
      class49.field1085 = var1;
   }
}
