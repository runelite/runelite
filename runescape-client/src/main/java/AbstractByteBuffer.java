import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("p")
   static boolean field2512;
   @ObfuscatedName("b")
   static byte[][][] field2513;

   static {
      field2512 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "2025274732"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1395414743"
   )
   @Export("put")
   abstract void put(byte[] var1);
}
