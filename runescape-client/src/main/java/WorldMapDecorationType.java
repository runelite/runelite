import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2791(0, 0),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2773(1, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2774(2, 0),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2775(3, 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2776(9, 2),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2777(4, 1),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2783(5, 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2795(6, 1),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2780(7, 1),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2781(8, 1),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2784(12, 2),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2792(13, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2789(14, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2785(15, 2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2786(16, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2787(17, 2),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2788(18, 2),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2794(19, 2),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2790(20, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2782(21, 2),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2772(10, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2793(11, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field2778(22, 3);

   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1352297023
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "60"
   )
   public int rsOrdinal() {
      return this.rsOrdinal;
   }
}
