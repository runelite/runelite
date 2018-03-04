import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lb")
public enum class329 implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Llb;"
   )
   field3962(0, 0),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Llb;"
   )
   field3963(1, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Llb;"
   )
   field3964(2, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Llb;"
   )
   field3965(3, 3),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llb;"
   )
   field3966(4, 4);

   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -759553529
   )
   public final int field3967;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -622730897
   )
   final int field3968;

   class329(int var3, int var4) {
      this.field3967 = var3;
      this.field3968 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.field3968;
   }
}
