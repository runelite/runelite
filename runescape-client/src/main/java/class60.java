import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public final class class60 {
   @ObfuscatedName("gz")
   static SpritePixels[] field732;
   @ObfuscatedName("fw")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-102"
   )
   static String method996(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
