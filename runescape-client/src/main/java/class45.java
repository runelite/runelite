import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class45 {
   @ObfuscatedName("s")
   static int[] field894 = new int[2048];
   @ObfuscatedName("iy")
   static Widget field896;
   @ObfuscatedName("t")
   static byte[] field897 = new byte[2048];
   @ObfuscatedName("i")
   static byte[] field898 = new byte[2048];
   @ObfuscatedName("k")
   static Buffer[] field899 = new Buffer[2048];
   @ObfuscatedName("n")
   static int[] field900 = new int[2048];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2036777491
   )
   static int field901 = 0;
   @ObfuscatedName("a")
   static int[] field902 = new int[2048];
   @ObfuscatedName("r")
   static int[] field903 = new int[2048];
   @ObfuscatedName("x")
   static int[] field904 = new int[2048];
   @ObfuscatedName("z")
   static int[] field905 = new int[2048];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -346389779
   )
   static int field906 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -845646623
   )
   static int field907 = 0;
   @ObfuscatedName("o")
   static Buffer field908 = new Buffer(new byte[5000]);

   class45() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass216;",
      garbageValue = "-196963564"
   )
   public static class216 method890(int var0) {
      class216[] var1 = class99.method2001();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class216 var3 = var1[var2];
         if(var3.field3177 == var0) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-254353703"
   )
   public static boolean method899(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[LSpritePixels;",
      garbageValue = "1131116612"
   )
   static SpritePixels[] method902() {
      SpritePixels[] var0 = new SpritePixels[class225.field3226];

      for(int var1 = 0; var1 < class225.field3226; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class225.field3228;
         var2.maxHeight = class225.field3227;
         var2.offsetX = class225.field3229[var1];
         var2.offsetY = class155.field2105[var1];
         var2.width = class172.field2351[var1];
         var2.height = class225.field3230[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class225.field3232[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class225.field3231[var4[var5] & 255];
         }
      }

      class0.method13();
      return var0;
   }
}
