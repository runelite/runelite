import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class154 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 401879113
   )
   static int field2098 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -374401975
   )
   static int field2099 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2022093207
   )
   static int field2100 = 0;
   @ObfuscatedName("q")
   static byte[][] field2101 = new byte[1000][];
   @ObfuscatedName("d")
   static byte[][] field2102 = new byte[250][];
   @ObfuscatedName("k")
   static byte[][] field2103 = new byte[50][];

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1842791089"
   )
   static synchronized byte[] method3006(int var0) {
      byte[] var1;
      if(var0 == 100 && field2100 > 0) {
         var1 = field2101[--field2100];
         field2101[field2100] = null;
         return var1;
      } else if(var0 == 5000 && field2099 > 0) {
         var1 = field2102[--field2099];
         field2102[field2099] = null;
         return var1;
      } else if(var0 == 30000 && field2098 > 0) {
         var1 = field2103[--field2098];
         field2103[field2098] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   class154() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "551151550"
   )
   public static String method3009(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }
}
