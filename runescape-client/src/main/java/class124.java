import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class124 {
   @ObfuscatedName("h")
   static int[] field2052;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -828267541
   )
   static int field2053 = 0;
   @ObfuscatedName("dr")
   @Export("mapRegions")
   static int[] field2054;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 816659683
   )
   static int field2055 = 0;
   @ObfuscatedName("g")
   static byte[][] field2056 = new byte[250][];
   @ObfuscatedName("l")
   static byte[][] field2057 = new byte[50][];
   @ObfuscatedName("o")
   static byte[][] field2058 = new byte[1000][];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 151603757
   )
   static int field2059 = 0;
   @ObfuscatedName("bl")
   @Export("host")
   static String field2060;
   @ObfuscatedName("md")
   static byte field2062;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-184604723"
   )
   static synchronized byte[] method2793(int var0) {
      byte[] var1;
      if(var0 == 100 && field2055 > 0) {
         var1 = field2058[--field2055];
         field2058[field2055] = null;
         return var1;
      } else if(var0 == 5000 && field2053 > 0) {
         var1 = field2056[--field2053];
         field2056[field2053] = null;
         return var1;
      } else if(var0 == 30000 && field2059 > 0) {
         var1 = field2057[--field2059];
         field2057[field2059] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
