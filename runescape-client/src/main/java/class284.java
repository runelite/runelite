import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
public enum class284 implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   field3782(0, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   field3779(1, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   field3780(2, 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   field3781(3, 3),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   field3784(4, 4);

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1448519065
   )
   final int field3778;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 345093823
   )
   public final int field3783;

   class284(int var3, int var4) {
      this.field3783 = var3;
      this.field3778 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field3778;
   }
}
