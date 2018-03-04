import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("index")
   public IndexData index;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 290058725
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("n")
   @Export("padding")
   public byte padding;
}
