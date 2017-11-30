import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
public enum class296 implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   field3837(0, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   field3838(1, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   field3836(2, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   field3839(3, 3),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   field3840(4, 4);

   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1483596249
   )
   static int field3843;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 824355041
   )
   public final int field3842;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 665565463
   )
   final int field3841;

   class296(int var3, int var4) {
      this.field3842 = var3;
      this.field3841 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.field3841;
   }
}
