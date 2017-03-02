import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public final class class152 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -939502313
   )
   int field2041;
   @ObfuscatedName("v")
   int[] field2042 = new int[256];
   @ObfuscatedName("i")
   final int field2043 = 258;
   @ObfuscatedName("t")
   final int field2044 = 6;
   @ObfuscatedName("ay")
   int[] field2045 = new int[6];
   @ObfuscatedName("h")
   final int field2046 = 18002;
   @ObfuscatedName("n")
   byte[] field2047;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1086575873
   )
   int field2048;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 211154541
   )
   int field2049;
   @ObfuscatedName("r")
   byte[] field2050;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1895878679
   )
   int field2051 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -17431251
   )
   int field2052;
   @ObfuscatedName("af")
   byte[] field2053 = new byte[4096];
   @ObfuscatedName("s")
   byte field2054;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 426337241
   )
   int field2055;
   @ObfuscatedName("cl")
   static class110 field2056;
   @ObfuscatedName("b")
   final int field2057 = 4096;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2072305427
   )
   int field2058;
   @ObfuscatedName("k")
   final int field2059 = 50;
   @ObfuscatedName("l")
   final int field2060 = 16;
   @ObfuscatedName("aj")
   boolean[] field2061 = new boolean[16];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1044503931
   )
   int field2062;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -85442657
   )
   int field2063 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -294704161
   )
   int field2064;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1029065625
   )
   int field2065;
   @ObfuscatedName("ap")
   boolean[] field2066 = new boolean[256];
   @ObfuscatedName("j")
   int[] field2067 = new int[257];
   @ObfuscatedName("ab")
   byte[] field2068 = new byte[256];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1388918693
   )
   int field2069;
   @ObfuscatedName("aw")
   int[] field2070 = new int[16];
   @ObfuscatedName("ac")
   byte[] field2071 = new byte[18002];
   @ObfuscatedName("an")
   byte[] field2072 = new byte[18002];
   @ObfuscatedName("ae")
   byte[][] field2073 = new byte[6][258];
   @ObfuscatedName("au")
   int[][] field2074 = new int[6][258];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 506698919
   )
   int field2075;
   @ObfuscatedName("as")
   int[][] field2076 = new int[6][258];
   @ObfuscatedName("am")
   int[][] field2077 = new int[6][258];
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1980957951
   )
   int field2078;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 777981551
   )
   int field2079;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "127"
   )
   public static int method2838(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var1 * var5;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   public static void method2839() {
      try {
         class104.field1683.method1435();

         for(int var0 = 0; var0 < class104.field1679; ++var0) {
            class116.field1821[var0].method1435();
         }

         class104.field1680.method1435();
         class104.field1681.method1435();
      } catch (Exception var2) {
         ;
      }

   }
}
