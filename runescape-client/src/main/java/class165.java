import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class165 {
   @ObfuscatedName("q")
   public static int[][] field2059;
   @ObfuscatedName("b")
   public static int[][] field2058;
   @ObfuscatedName("x")
   public static int[] field2061;
   @ObfuscatedName("j")
   public static int[] field2060;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      longValue = -6186679556520973423L
   )
   static long field2065;

   static {
      field2059 = new int[128][128];
      field2058 = new int[128][128];
      field2061 = new int[4096];
      field2060 = new int[4096];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "-58"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class301.cp1252AsciiExtension[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }
}
