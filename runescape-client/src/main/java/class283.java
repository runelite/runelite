import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
public enum class283 implements RSEnum {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   field3755(0, 0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   field3752(1, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   field3753(2, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   field3756(3, 3),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   field3754(4, 4);

   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1610941511
   )
   public final int field3751;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2097204823
   )
   final int field3757;

   class283(int var3, int var4) {
      this.field3751 = var3;
      this.field3757 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field3757;
   }
}
