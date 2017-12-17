import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("BaseVarType")
public enum BaseVarType implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   @Export("INTEGER")
   INTEGER(0, 0, Integer.class, new class2()),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = -920203399
   )
   static int field21;
   @ObfuscatedName("n")
   static int[] field28;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -845345371
   )
   static int field31;
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 826185209
   )
   @Export("id2")
   final int id2;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -436300871
   )
   @Export("id")
   final int id;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;La;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.id2 = var3;
      this.id = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1407958579"
   )
   static int method12(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.size();
   }
}
