import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
public class class276 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("huffman")
   public static Huffman huffman;
   @ObfuscatedName("t")
   public static int[] field3727;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-12"
   )
   public static int method4981(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
