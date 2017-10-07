import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("k")
   static boolean field2429;
   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "Lbw;"
   )
   @Export("localPlayer")
   static Player localPlayer;

   static {
      field2429 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-95"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-180504190"
   )
   @Export("put")
   abstract void put(byte[] var1);
}
