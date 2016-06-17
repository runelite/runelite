import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class183 {
   @ObfuscatedName("g")
   public static class167 field2950;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1258707167
   )
   public static int field2951;
   @ObfuscatedName("d")
   public static class184 field2952;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1006930145
   )
   public static int field2953 = 0;
   @ObfuscatedName("di")
   static byte[][] field2954;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 450939023
   )
   public static int field2955;
   @ObfuscatedName("p")
   public static boolean field2956;
   @ObfuscatedName("j")
   public static class167 field2957;
   @ObfuscatedName("b")
   public static class167 field2958;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-1584965238"
   )
   public static int method3597(byte[] var0, int var1, CharSequence var2) {
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

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1823751864"
   )
   static final void method3606() {
      for(int var0 = 0; var0 < client.field449; ++var0) {
         int var1 = client.field318[var0];
         class34 var2 = client.field326[var1];
         if(var2 != null) {
            class98.method2199(var2, var2.field762.field865);
         }
      }

   }
}
