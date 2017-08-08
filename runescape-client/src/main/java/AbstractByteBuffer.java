import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("n")
   static boolean field2401;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static Font field2400;

   static {
      field2401 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "9"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1210030604"
   )
   @Export("put")
   abstract void put(byte[] var1);
}
