import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
public enum class249 implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3277(0, 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3273(1, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3274(2, 2);

   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2070321655
   )
   public final int field3275;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1686539261
   )
   final int field3276;

   private class249(int var3, int var4) {
      this.field3275 = var3;
      this.field3276 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   public int rsOrdinal() {
      return this.field3276;
   }
}
