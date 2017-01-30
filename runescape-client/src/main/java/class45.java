import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class45 {
   @ObfuscatedName("u")
   static Buffer field894 = new Buffer(new byte[5000]);
   @ObfuscatedName("j")
   static int[] field895 = new int[2048];
   @ObfuscatedName("d")
   static Buffer[] field897 = new Buffer[2048];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1336883639
   )
   static int field898 = 0;
   @ObfuscatedName("ph")
   public static class103 field899;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -578318361
   )
   static int field900 = 0;
   @ObfuscatedName("t")
   static class20 field901;
   @ObfuscatedName("a")
   static int[] field902 = new int[2048];
   @ObfuscatedName("c")
   static int[] field903 = new int[2048];
   @ObfuscatedName("m")
   static int[] field904 = new int[2048];
   @ObfuscatedName("o")
   static int[] field905 = new int[2048];
   @ObfuscatedName("r")
   static int[] field906 = new int[2048];
   @ObfuscatedName("x")
   static byte[] field908 = new byte[2048];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -363701857
   )
   static int field909 = 0;
   @ObfuscatedName("q")
   static byte[] field910 = new byte[2048];

   class45() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "582199197"
   )
   static void method821(int var0) {
      for(class133 var1 = (class133)Client.widgetFlags.method2361(); var1 != null; var1 = (class133)Client.widgetFlags.method2369()) {
         if((var1.hash >> 48 & 65535L) == (long)var0) {
            var1.unlink();
         }
      }

   }
}
