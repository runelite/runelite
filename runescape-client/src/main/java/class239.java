import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public enum class239 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3255(1, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3254(0, 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3262(2, 2);

   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1056692171
   )
   public final int field3256;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2004694379
   )
   final int field3257;

   class239(int var3, int var4) {
      this.field3256 = var3;
      this.field3257 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field3257;
   }
}
