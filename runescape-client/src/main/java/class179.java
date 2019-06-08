import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public abstract class class179 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1237576843
   )
   @Export("Interpreter_intStackSize")
   static int Interpreter_intStackSize;
   @ObfuscatedName("e")
   @Export("__fe_e")
   static byte[][][] __fe_e;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 123677543
   )
   public int field2120;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2126454535
   )
   public int field2121;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1566880917
   )
   public int field2122;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2126101601
   )
   public int field2123;

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
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
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
   static boolean method3643(AbstractIndexCache var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      if(var2 == null) {
         return false;
      } else {
         DevicePcmPlayerProvider.decodeSprite(var2);
         return true;
      }
   }
}
