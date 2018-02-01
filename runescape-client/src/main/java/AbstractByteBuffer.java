import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("i")
   @Export("directBufferUnavailable")
   static boolean directBufferUnavailable;

   static {
      directBufferUnavailable = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-2111071232"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1302322725"
   )
   @Export("put")
   abstract void put(byte[] var1);
}
