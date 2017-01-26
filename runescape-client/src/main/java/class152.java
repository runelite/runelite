import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ex")
public final class class152 {
   @ObfuscatedName("av")
   int[] field2047 = new int[6];
   @ObfuscatedName("g")
   final int field2048 = 16;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1365615481
   )
   int field2049;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1530417005
   )
   int field2050 = 0;
   @ObfuscatedName("d")
   final int field2051 = 50;
   @ObfuscatedName("f")
   int[] field2052 = new int[256];
   @ObfuscatedName("j")
   byte[] field2053;
   @ObfuscatedName("q")
   final int field2054 = 6;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1150469675
   )
   int field2055;
   @ObfuscatedName("a")
   byte[] field2056;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 261951791
   )
   int field2057;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -395337073
   )
   int field2058;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -618177457
   )
   int field2059 = 0;
   @ObfuscatedName("k")
   final int field2060 = 18002;
   @ObfuscatedName("b")
   static int[] field2061;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 736238021
   )
   int field2062;
   @ObfuscatedName("p")
   final int field2063 = 4096;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -396007787
   )
   int field2064;
   @ObfuscatedName("ah")
   byte[] field2065 = new byte[4096];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1782998639
   )
   int field2066;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -489576071
   )
   int field2067;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -329831279
   )
   int field2068;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1662807251
   )
   int field2069;
   @ObfuscatedName("t")
   int[] field2070 = new int[257];
   @ObfuscatedName("x")
   final int field2071 = 258;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 859558225
   )
   int field2072;
   @ObfuscatedName("ai")
   boolean[] field2073 = new boolean[256];
   @ObfuscatedName("am")
   boolean[] field2074 = new boolean[16];
   @ObfuscatedName("ad")
   byte[] field2075 = new byte[256];
   @ObfuscatedName("r")
   byte field2076;
   @ObfuscatedName("aj")
   int[] field2077 = new int[16];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1192311645
   )
   int field2078;
   @ObfuscatedName("ak")
   byte[] field2079 = new byte[18002];
   @ObfuscatedName("ar")
   byte[][] field2080 = new byte[6][258];
   @ObfuscatedName("aw")
   int[][] field2081 = new int[6][258];
   @ObfuscatedName("ay")
   int[][] field2082 = new int[6][258];
   @ObfuscatedName("af")
   int[][] field2083 = new int[6][258];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 320745821
   )
   int field2084;
   @ObfuscatedName("ax")
   byte[] field2085 = new byte[18002];
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = -1314106797
   )
   static int field2086;
   @ObfuscatedName("et")
   static SpritePixels[] field2087;

   @ObfuscatedName("g")
   public static String method2797(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class205.field3077[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }
}
