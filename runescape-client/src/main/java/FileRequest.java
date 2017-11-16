import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("l")
   @Export("osName")
   static String osName;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1965679587
   )
   @Export("crc")
   int crc;
   @ObfuscatedName("r")
   @Export("padding")
   byte padding;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;B)V",
      garbageValue = "103"
   )
   public static void method4104(IndexDataBase var0) {
      Varbit.varbit_ref = var0;
   }
}
