import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class34 {
   @ObfuscatedName("e")
   static int[] field767 = new int[2048];
   @ObfuscatedName("f")
   static byte[] field769 = new byte[2048];
   @ObfuscatedName("c")
   static byte[] field770 = new byte[2048];
   @ObfuscatedName("v")
   static Buffer[] field771 = new Buffer[2048];
   @ObfuscatedName("l")
   static int[] field772 = new int[2048];
   @ObfuscatedName("m")
   static int[] field773 = new int[2048];
   @ObfuscatedName("u")
   static int[] field775 = new int[2048];
   @ObfuscatedName("h")
   static int[] field776 = new int[2048];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1923834681
   )
   static int field777 = 0;
   @ObfuscatedName("b")
   static int[] field778 = new int[2048];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2137539151
   )
   static int field779 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -375842803
   )
   static int field780 = 0;
   @ObfuscatedName("p")
   static Buffer field781 = new Buffer(new byte[5000]);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "1727255183"
   )
   public static int method720(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method736() {
      ItemComposition.itemSpriteCache.reset();
   }
}
