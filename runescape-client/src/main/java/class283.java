import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public enum class283 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   field3755(0, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   field3749(1, 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   field3750(2, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   field3751(3, 3),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   field3754(4, 4);

   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2103577687
   )
   public final int field3753;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -818564945
   )
   final int field3756;

   class283(int var3, int var4) {
      this.field3753 = var3;
      this.field3756 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field3756;
   }
}
