import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("x")
   @Export("padding")
   byte padding;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2046608179
   )
   @Export("crc")
   int crc;
}
