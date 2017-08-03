import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public enum class91 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   field1386(0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   field1384(1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   field1385(2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   field1393(3);

   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1628848871
   )
   final int field1387;
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;

   class91(int var3) {
      this.field1387 = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field1387;
   }
}
