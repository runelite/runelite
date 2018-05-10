import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("m")
   @Export("directBufferUnavailable")
   static boolean directBufferUnavailable;

   static {
      directBufferUnavailable = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "114"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-321653700"
   )
   @Export("put")
   abstract void put(byte[] var1);
}
