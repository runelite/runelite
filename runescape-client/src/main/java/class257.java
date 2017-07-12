import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public enum class257 implements RSEnum {
   @ObfuscatedName("i")
   field3551(2, 0),
   @ObfuscatedName("w")
   field3553(1, 1),
   @ObfuscatedName("a")
   field3552(0, 2);

   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1890825181
   )
   public final int field3550;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1034249539
   )
   final int field3554;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field3554;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   private class257(int var3, int var4) {
      this.field3550 = var3;
      this.field3554 = var4;
   }
}
