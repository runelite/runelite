import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("a")
   @Export("padding")
   public byte padding;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("index")
   public IndexData index;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1394674797
   )
   @Export("crc")
   public int crc;
}
