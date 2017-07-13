import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public enum class149 implements RSEnum {
   @ObfuscatedName("a")
   field2194(0, 0),
   @ObfuscatedName("j")
   field2190(1, 1),
   @ObfuscatedName("n")
   field2189(3, 2),
   @ObfuscatedName("r")
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
   public static Track1 field2196;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
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
