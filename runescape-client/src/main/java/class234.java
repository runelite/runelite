import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
public class class234 extends CacheableNode {
   @ObfuscatedName("i")
   public byte field3210;
   @ObfuscatedName("j")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2083591931
   )
   public int field3212;
   @ObfuscatedName("n")
   public IndexData field3213;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1960487701"
   )
   public static void method4121() {
      ObjectComposition.field3444.reset();
      ObjectComposition.field3467.reset();
      ObjectComposition.field3446.reset();
      ObjectComposition.field3452.reset();
   }
}
