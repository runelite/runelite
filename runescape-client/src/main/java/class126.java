import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class126 {
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -422901581
   )
   protected static int field2049;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2105656008"
   )
   public static int method2782(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
