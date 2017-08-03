import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class155 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   public static CacheFile field2223;
   @ObfuscatedName("e")
   static File field2217;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   public static CacheFile field2224;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   public static CacheFile field2228;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1206538477
   )
   static int field2227;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1861241109
   )
   public static int field2218;
   @ObfuscatedName("m")
   @Export("osName")
   static String osName;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lcv;"
   )
   public static CacheFile[] field2226;
   @ObfuscatedName("y")
   static File field2221;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 1603483269
   )
   static int field2230;

   static {
      field2223 = null;
      field2224 = null;
      field2228 = null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;II)Lgh;",
      garbageValue = "-100216511"
   )
   static class207 method2989(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4119(var1);
      return var2 == null?null:new class207(var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "7"
   )
   public static boolean method2983(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1781372447"
   )
   static final int method2990(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
