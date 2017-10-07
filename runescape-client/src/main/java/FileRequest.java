import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("e")
   @Export("padding")
   byte padding;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1336245807
   )
   @Export("crc")
   int crc;
}
