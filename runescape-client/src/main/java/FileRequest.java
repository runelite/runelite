import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("g")
   @Export("padding")
   public byte padding;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("index")
   public IndexData index;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 495640147
   )
   @Export("crc")
   public int crc;
}
