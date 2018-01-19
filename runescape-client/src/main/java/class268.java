import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public enum class268 implements Enumerated {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   field3628(2, 0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   field3631(0, 1),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   field3629(1, 2);

   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -255362997
   )
   public final int field3627;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -750361693
   )
   final int field3630;

   class268(int var3, int var4) {
      this.field3627 = var3;
      this.field3630 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.field3630;
   }
}
