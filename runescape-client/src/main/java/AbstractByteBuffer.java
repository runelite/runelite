import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 261244409
   )
   static int field2528;
   @ObfuscatedName("g")
   @Export("directBufferUnavailable")
   static boolean directBufferUnavailable;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field2531;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -871981779
   )
   static int field2530;

   static {
      directBufferUnavailable = false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "819018446"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-324208490"
   )
   @Export("put")
   abstract void put(byte[] var1);
}
