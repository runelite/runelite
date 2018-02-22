import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("index")
   public IndexData index;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 445542515
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("o")
   @Export("padding")
   public byte padding;
}
