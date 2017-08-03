import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public enum class27 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   field377(1, (byte)0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   field368(2, (byte)1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   field369(3, (byte)2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   field367(0, (byte)3);

   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1600984255
   )
   final int field371;
   @ObfuscatedName("fq")
   static int[] field373;
   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field374;
   @ObfuscatedName("f")
   final byte field378;

   class27(int var3, byte var4) {
      this.field371 = var3;
      this.field378 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field378;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-71340778"
   )
   public static void method210(int var0) {
      class203.field2475 = 1;
      class262.field3614 = null;
      class11.field253 = -1;
      class203.field2482 = -1;
      class203.field2474 = 0;
      class182.field2413 = false;
      RSCanvas.field633 = var0;
   }
}
