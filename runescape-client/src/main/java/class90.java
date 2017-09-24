import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public enum class90 implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   field1431(0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   field1424(1),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   field1425(2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   field1426(3);

   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1343858031
   )
   final int field1427;

   class90(int var3) {
      this.field1427 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field1427;
   }
}
