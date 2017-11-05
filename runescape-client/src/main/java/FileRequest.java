import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1000645349
   )
   static int field3204;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -412311545
   )
   @Export("crc")
   int crc;
   @ObfuscatedName("q")
   @Export("padding")
   byte padding;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-2008589117"
   )
   public static boolean method4186(char var0) {
      return var0 >= ' ' && var0 <= '~'?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
