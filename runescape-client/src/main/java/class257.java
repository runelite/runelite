import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public enum class257 implements RSEnum {
   @ObfuscatedName("p")
   field3550(2, 0),
   @ObfuscatedName("m")
   field3549(0, 1),
   @ObfuscatedName("e")
   field3552(1, 2);

   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1309149023
   )
   final int field3548;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1348149273
   )
   public final int field3551;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field3548;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   private class257(int var3, int var4) {
      this.field3551 = var3;
      this.field3548 = var4;
   }
}
