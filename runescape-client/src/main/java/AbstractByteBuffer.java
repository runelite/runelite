import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("o")
   static boolean field2376;
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static BuildType field2373;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   @Export("titlemuteSprite")
   static ModIcon[] titlemuteSprite;

   static {
      field2376 = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-227926536"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-834931198"
   )
   @Export("put")
   abstract void put(byte[] var1);
}
