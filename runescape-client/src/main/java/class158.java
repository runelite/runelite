import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public enum class158 implements Enumerated {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   field2177(0, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   field2171(3, 1),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   field2172(2, 2),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   field2173(1, 3);

   @ObfuscatedName("i")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1427803327
   )
   public final int field2174;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -330652339
   )
   final int field2170;

   class158(int var3, int var4) {
      this.field2174 = var3;
      this.field2170 = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-369819377"
   )
   public int rsOrdinal() {
      return this.field2170;
   }
}
