import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ii")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("a")
   @Export("padding")
   byte padding;
   @ObfuscatedName("i")
   @Export("index")
   IndexData index;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1130049009
   )
   @Export("crc")
   int crc;
}
