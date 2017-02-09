import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class161 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1473084047
   )
   static int field2268 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2001990417
   )
   static int field2269 = 0;
   @ObfuscatedName("r")
   static byte[][] field2270 = new byte[1000][];
   @ObfuscatedName("w")
   static byte[][] field2271 = new byte[250][];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 348172173
   )
   static int field2272 = 0;
   @ObfuscatedName("j")
   static byte[][] field2273 = new byte[50][];
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1705421671
   )
   @Export("menuX")
   static int menuX;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-55"
   )
   static SpritePixels method3135() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class225.field3212;
      var0.maxHeight = class225.field3213;
      var0.offsetX = class163.field2287[0];
      var0.offsetY = class225.field3214[0];
      var0.width = class47.field932[0];
      var0.height = class225.field3211[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class225.field3218[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class225.field3215[var2[var3] & 255];
      }

      class221.method4056();
      return var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1934989934"
   )
   static synchronized byte[] method3136(int var0) {
      byte[] var1;
      if(var0 == 100 && field2268 > 0) {
         var1 = field2270[--field2268];
         field2270[field2268] = null;
         return var1;
      } else if(var0 == 5000 && field2272 > 0) {
         var1 = field2271[--field2272];
         field2271[field2272] = null;
         return var1;
      } else if(var0 == 30000 && field2269 > 0) {
         var1 = field2273[--field2269];
         field2273[field2269] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   class161() throws Throwable {
      throw new Error();
   }
}
