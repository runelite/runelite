import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public final class class162 {
   @ObfuscatedName("t")
   static final char[] field2674 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   @ObfuscatedName("w")
   static int[] field2678;

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIIB)V",
      garbageValue = "74"
   )
   static final void method3166(class173 var0, int var1, int var2, int var3) {
      class175 var4 = var0.method3375(false);
      if(null != var4) {
         if(client.field549 < 3) {
            class165.field2695.method1736(var1, var2, var4.field2918, var4.field2917, 25, 25, client.field302, 256, var4.field2920, var4.field2922);
         } else {
            class79.method1752(var1, var2, 0, var4.field2920, var4.field2922);
         }

      }
   }
}
