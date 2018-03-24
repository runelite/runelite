import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2980(0, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2981(1, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2982(2, 0),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2983(3, 0),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2984(9, 2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2990(4, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2986(5, 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2987(6, 1),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3001(7, 1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2989(8, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2997(12, 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2991(13, 2),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2988(14, 2),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2993(15, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2992(16, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2995(17, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2996(18, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2994(19, 2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2998(20, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2999(21, 2),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3000(10, 2),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field2985(11, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3002(22, 3);

   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1481303947
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.rsOrdinal;
   }
}
