import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public enum class27 implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field370(1, (byte)0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field366(0, (byte)1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field368(3, (byte)2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field375(2, (byte)3);

   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -1339000471
   )
   static int field372;
   @ObfuscatedName("ao")
   static int[] field365;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1899422909
   )
   final int field369;
   @ObfuscatedName("b")
   final byte field367;

   class27(int var3, byte var4) {
      this.field369 = var3;
      this.field367 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.field367;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method228() {
      class62.field711 = null;
      class62.field707 = null;
      class62.field708 = null;
      FrameMap.field1952 = null;
      class62.field709 = null;
      class62.field704 = null;
      class62.field714 = null;
      BoundingBox.field239 = null;
      class36.field475 = null;
      class22.field319 = null;
      class199.field2584 = null;
      class36.field476 = null;
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1807421451"
   )
   static void method232(int var0) {
      for(IntegerNode var1 = (IntegerNode)Client.widgetFlags.first(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.next()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }
}
