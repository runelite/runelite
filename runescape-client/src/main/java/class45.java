import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class45 {
   @ObfuscatedName("a")
   static int[] field903 = new int[2048];
   @ObfuscatedName("p")
   static int[] field904 = new int[2048];
   @ObfuscatedName("f")
   static byte[] field905 = new byte[2048];
   @ObfuscatedName("g")
   static Buffer[] field907 = new Buffer[2048];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1314022609
   )
   static int field908 = 0;
   @ObfuscatedName("m")
   static Buffer field909 = new Buffer(new byte[5000]);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1453288047
   )
   static int field910 = 0;
   @ObfuscatedName("w")
   static int[] field911 = new int[2048];
   @ObfuscatedName("v")
   static int[] field912 = new int[2048];
   @ObfuscatedName("k")
   static byte[] field913 = new byte[2048];
   @ObfuscatedName("h")
   static int[] field915 = new int[2048];
   @ObfuscatedName("c")
   static int[] field917 = new int[2048];
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = 840420893
   )
   static int field921;
   @ObfuscatedName("at")
   static class102 field922;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -668694697
   )
   static int field924 = 0;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "20456"
   )
   public static boolean method792(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1752682171"
   )
   public static int method801(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }
}
