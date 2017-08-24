import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("BaseVarType")
public enum BaseVarType implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("INTEGER")
   INTEGER(0, 0, Integer.class, new class2()),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("LONG")
   LONG(2, 1, Long.class, new class3()),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("STRING")
   STRING(1, 2, String.class, new class5());

   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 616856235
   )
   static int field26;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 347206951
   )
   final int field29;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1339619825
   )
   final int field33;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = 736214255
   )
   static int field34;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Li;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.field29 = var3;
      this.field33 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field33;
   }
}
