import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2987(0, 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2981(1, 0),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2978(2, 0),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2976(3, 0),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2980(9, 2),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2979(4, 1),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2982(5, 1),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2993(6, 1),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2984(7, 1),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2985(8, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2996(12, 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2999(13, 2),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2988(14, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2989(15, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2990(16, 2),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2991(17, 2),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2992(18, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2983(19, 2),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2994(20, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2995(21, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2977(10, 2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2997(11, 2),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field2998(22, 3);

   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 890365011
   )
   @Export("rsOrdinal")
   public final int rsOrdinal;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   WorldMapDecorationType(int var3, int var4) {
      this.rsOrdinal = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.rsOrdinal;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1877674212"
   )
   static synchronized byte[] method4615(int var0) {
      return class195.method3810(var0, false);
   }
}
