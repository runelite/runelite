import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public enum class246 implements class185 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   field3348(0, 0),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   field3344(1, 1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   field3346(2, 2);

   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 391483151
   )
   public final int field3345;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2922873
   )
   final int field3347;

   class246(int var3, int var4) {
      this.field3345 = var3;
      this.field3347 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1940611593"
   )
   public int rsOrdinal() {
      return this.field3347;
   }
}
