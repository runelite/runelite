import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
public enum class329 implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   field3963(0, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   field3964(1, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   field3962(2, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   field3965(3, 3),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   field3966(4, 4);

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1306441371
   )
   public final int field3967;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1676939879
   )
   final int field3968;

   class329(int var3, int var4) {
      this.field3967 = var3;
      this.field3968 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.field3968;
   }
}
