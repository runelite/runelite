import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("q")
   @Export("directBufferUnavailable")
   static boolean directBufferUnavailable;

   static {
      directBufferUnavailable = false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "38"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-818307234"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1208547636"
   )
   public static int method3787(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1778319270"
   )
   public static int method3789(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }
}
