import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[[Lho;"
   )
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field3287;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1727870803
   )
   @Export("crc")
   int crc;
   @ObfuscatedName("w")
   @Export("padding")
   byte padding;
}
