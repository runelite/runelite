import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class124 {
   @ObfuscatedName("c")
   public static String[] field2050;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -375662359
   )
   static int field2051 = 0;
   @ObfuscatedName("n")
   static byte[][] field2052 = new byte[250][];
   @ObfuscatedName("g")
   static byte[][] field2053 = new byte[1000][];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1767357957
   )
   static int field2054 = 0;
   @ObfuscatedName("u")
   static byte[][] field2055 = new byte[50][];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1683965497
   )
   static int field2058 = 0;
   @ObfuscatedName("q")
   public static String field2059;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-70"
   )
   static synchronized byte[] method2780(int var0) {
      byte[] var1;
      if(var0 == 100 && field2058 > 0) {
         var1 = field2053[--field2058];
         field2053[field2058] = null;
         return var1;
      } else if(var0 == 5000 && field2051 > 0) {
         var1 = field2052[--field2051];
         field2052[field2051] = null;
         return var1;
      } else if(var0 == 30000 && field2054 > 0) {
         var1 = field2055[--field2054];
         field2055[field2054] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
