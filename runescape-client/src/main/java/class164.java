import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class164 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field2314;
   @ObfuscatedName("aa")
   static int[] field2312;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1801394173"
   )
   public static void method3140(int var0) {
      class203.field2500 = 1;
      ContextMenuRow.field1392 = null;
      class203.field2502 = -1;
      class203.field2505 = -1;
      class10.field268 = 0;
      DynamicObject.field1539 = false;
      class36.field523 = var0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-122"
   )
   static final int method3141(int var0, int var1) {
      int var2 = GameEngine.getSmoothNoise(var0 + 45365, 91923 + var1, 4) - 128 + (GameEngine.getSmoothNoise(10294 + var0, var1 + 37821, 2) - 128 >> 1) + (GameEngine.getSmoothNoise(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-14986289"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?ChatLineBuffer.method1912(var3):var3;
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
