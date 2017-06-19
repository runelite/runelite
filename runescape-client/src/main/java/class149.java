import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public enum class149 implements RSEnum {
   @ObfuscatedName("p")
   field2204(3, 0),
   @ObfuscatedName("m")
   field2205(2, 1),
   @ObfuscatedName("e")
   field2206(1, 2),
   @ObfuscatedName("t")
   field2207(0, 3);

   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 37572115
   )
   final int field2208;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 704326889
   )
   static int field2209;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1707579303
   )
   public final int field2210;
   @ObfuscatedName("j")
   static int[] field2211;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field2208;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   private class149(int var3, int var4) {
      this.field2210 = var3;
      this.field2208 = var4;
   }
}
