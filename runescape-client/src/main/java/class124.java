import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public class class124 {
   @ObfuscatedName("v")
   static byte[][] field2062 = new byte[250][];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 92738127
   )
   static int field2063 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 814960441
   )
   static int field2064 = 0;
   @ObfuscatedName("c")
   static byte[][] field2065 = new byte[1000][];
   @ObfuscatedName("ap")
   static boolean field2066;
   @ObfuscatedName("j")
   static byte[][] field2067 = new byte[50][];
   @ObfuscatedName("bp")
   @Export("host")
   static String host;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -202893607
   )
   static int field2070 = 0;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-552667699"
   )
   static synchronized byte[] method2801(int var0) {
      byte[] var1;
      if(var0 == 100 && field2070 > 0) {
         var1 = field2065[--field2070];
         field2065[field2070] = null;
         return var1;
      } else if(var0 == 5000 && field2063 > 0) {
         var1 = field2062[--field2063];
         field2062[field2063] = null;
         return var1;
      } else if(var0 == 30000 && field2064 > 0) {
         var1 = field2067[--field2064];
         field2067[field2064] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
