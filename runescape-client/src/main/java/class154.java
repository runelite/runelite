import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class154 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -323895487
   )
   static int field2106 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2036775101
   )
   static int field2107 = 0;
   @ObfuscatedName("h")
   static byte[][] field2108 = new byte[1000][];
   @ObfuscatedName("a")
   static byte[][] field2109 = new byte[250][];
   @ObfuscatedName("g")
   static byte[][] field2110 = new byte[50][];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1137960289
   )
   static int field2111 = 0;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)Z",
      garbageValue = "1425924745"
   )
   public static boolean method2922(class182 var0, int var1) {
      byte[] var2 = var0.method3187(var1);
      if(null == var2) {
         return false;
      } else {
         class9.method98(var2);
         return true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1259774023"
   )
   static synchronized byte[] method2923(int var0) {
      byte[] var1;
      if(var0 == 100 && field2111 > 0) {
         var1 = field2108[--field2111];
         field2108[field2111] = null;
         return var1;
      } else if(var0 == 5000 && field2106 > 0) {
         var1 = field2109[--field2106];
         field2109[field2106] = null;
         return var1;
      } else if(var0 == 30000 && field2107 > 0) {
         var1 = field2110[--field2107];
         field2110[field2107] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
