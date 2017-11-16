import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -1005906405
   )
   static int field2511;
   @ObfuscatedName("s")
   static boolean field2510;

   static {
      field2510 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-125"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-539521374"
   )
   @Export("put")
   abstract void put(byte[] var1);
}
