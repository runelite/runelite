import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public final class class109 {
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1082982913
   )
   int field1904;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 408069347
   )
   int field1905;
   @ObfuscatedName("f")
   final int field1906 = 258;
   @ObfuscatedName("a")
   final int field1907 = 4096;
   @ObfuscatedName("y")
   final int field1908 = 50;
   @ObfuscatedName("e")
   final int field1909 = 18002;
   @ObfuscatedName("g")
   byte[] field1910;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -981029099
   )
   int field1911 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -807843307
   )
   int field1912;
   @ObfuscatedName("ax")
   byte[] field1913 = new byte[4096];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2081149639
   )
   int field1914 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1720119083
   )
   int field1915;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -465100463
   )
   int field1916;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1426838957
   )
   int field1918;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1095563465
   )
   int field1919;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1357498045
   )
   int field1920;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -709553829
   )
   int field1921;
   @ObfuscatedName("ac")
   byte[] field1922 = new byte[18002];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -993062909
   )
   int field1923;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -555339715
   )
   int field1924;
   @ObfuscatedName("am")
   int[][] field1925 = new int[6][258];
   @ObfuscatedName("s")
   final int field1926 = 6;
   @ObfuscatedName("w")
   int[] field1927 = new int[257];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1826160987
   )
   int field1928;
   @ObfuscatedName("ad")
   boolean[] field1929 = new boolean[256];
   @ObfuscatedName("at")
   boolean[] field1930 = new boolean[16];
   @ObfuscatedName("aw")
   byte[] field1931 = new byte[256];
   @ObfuscatedName("p")
   int[] field1932 = new int[256];
   @ObfuscatedName("ak")
   int[] field1933 = new int[16];
   @ObfuscatedName("ah")
   byte[] field1934 = new byte[18002];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1393350735
   )
   int field1935;
   @ObfuscatedName("as")
   byte[][] field1936 = new byte[6][258];
   @ObfuscatedName("ao")
   int[][] field1937 = new int[6][258];
   @ObfuscatedName("n")
   byte[] field1938;
   @ObfuscatedName("ai")
   int[][] field1939 = new int[6][258];
   @ObfuscatedName("v")
   byte field1940;
   @ObfuscatedName("ab")
   int[] field1941 = new int[6];
   @ObfuscatedName("r")
   final int field1942 = 16;

   @ObfuscatedName("dt")
   static final void method2431() {
      client.field301.method2753(53);
      client.field301.method2497(0);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "1"
   )
   public static int method2432(CharSequence var0, int var1) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var2 = false;
         boolean var3 = false;
         int var4 = 0;
         int var5 = var0.length();

         for(int var6 = 0; var6 < var5; ++var6) {
            char var7 = var0.charAt(var6);
            if(0 == var6) {
               if(45 == var7) {
                  var2 = true;
                  continue;
               }

               if(43 == var7) {
                  continue;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  throw new NumberFormatException();
               }

               var9 = var7 - 87;
            }

            if(var9 >= var1) {
               throw new NumberFormatException();
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var4 * var1 + var9;
            if(var8 / var1 != var4) {
               throw new NumberFormatException();
            }

            var4 = var8;
            var3 = true;
         }

         if(!var3) {
            throw new NumberFormatException();
         } else {
            return var4;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
