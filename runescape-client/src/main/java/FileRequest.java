import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 76133179
   )
   public static int field3304;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -803899541
   )
   @Export("crc")
   int crc;
   @ObfuscatedName("e")
   @Export("padding")
   byte padding;
}
