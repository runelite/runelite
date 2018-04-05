import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
public enum class329 implements Enumerated {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   field3965(0, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   field3966(1, 1),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   field3967(2, 2),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   field3968(3, 3),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   field3969(4, 4);

   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1688724763
   )
   public final int field3970;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1728854711
   )
   final int field3972;

   class329(int var3, int var4) {
      this.field3970 = var3;
      this.field3972 = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-369819377"
   )
   public int rsOrdinal() {
      return this.field3972;
   }
}
