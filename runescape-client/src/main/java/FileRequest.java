import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1450681237
   )
   static int field3207;
   @ObfuscatedName("w")
   static int[][] field3211;
   @ObfuscatedName("n")
   @Export("padding")
   byte padding;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1630955271
   )
   @Export("crc")
   int crc;
}
