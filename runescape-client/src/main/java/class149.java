import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public enum class149 implements RSEnum {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   field2194(0, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   field2190(1, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   field2189(3, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   field2192(2, 3);

   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1345885343
   )
   public final int field2193;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1509897171
   )
   final int field2195;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public static Track1 field2196;

   class149(int var3, int var4) {
      this.field2193 = var3;
      this.field2195 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1952293135"
   )
   public int rsOrdinal() {
      return this.field2195;
   }
}
