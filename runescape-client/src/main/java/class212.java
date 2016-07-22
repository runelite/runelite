import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public final class class212 {
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      longValue = -6053351493880792587L
   )
   static long field3170;
   @ObfuscatedName("ks")
   static class134 field3171;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-43"
   )
   public static String method4002(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }
}
