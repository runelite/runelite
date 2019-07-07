import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public abstract class RouteStrategy {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1237576843
   )
   @Export("Interpreter_intStackSize")
   static int Interpreter_intStackSize;
   @ObfuscatedName("e")
   static byte[][][] field760;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 123677543
   )
   @Export("approxDestinationX")
   public int approxDestinationX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2126454535
   )
   @Export("approxDestinationY")
   public int approxDestinationY;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1566880917
   )
   @Export("approxDestinationSizeX")
   public int approxDestinationSizeX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2126101601
   )
   @Export("approxDestinationSizeY")
   public int approxDestinationSizeY;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILfy;I)Z",
      garbageValue = "-519225044"
   )
   protected abstract boolean vmethod3644(int var1, int var2, int var3, CollisionMap var4);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1634956279"
   )
   public static int method3642(int var0, int var1) {
      int var2;
      for (var2 = 1; var1 > 1; var1 >>= 1) {
         if ((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if (var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lir;II)Z",
      garbageValue = "-602741260"
   )
   @Export("loadSpriteFlat")
   static boolean loadSpriteFlat(AbstractArchive var0, int var1) {
      byte[] var2 = var0.takeFileFlat(var1);
      if (var2 == null) {
         return false;
      } else {
         DevicePcmPlayerProvider.decodeSprite(var2);
         return true;
      }
   }
}
