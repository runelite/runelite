import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public final class class110 {
   @ObfuscatedName("ao")
   byte[][] field1896 = new byte[6][258];
   @ObfuscatedName("h")
   final int field1897 = 16;
   @ObfuscatedName("an")
   int[] field1898 = new int[16];
   @ObfuscatedName("z")
   final int field1899 = 6;
   @ObfuscatedName("x")
   final int field1900 = 50;
   @ObfuscatedName("e")
   final int field1901 = 18002;
   @ObfuscatedName("i")
   byte[] field1902;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1336813935
   )
   int field1903;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1041776239
   )
   int field1904;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2010008589
   )
   int field1905;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1217908025
   )
   int field1906 = 0;
   @ObfuscatedName("j")
   final int field1907 = 4096;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1442026221
   )
   int field1908;
   @ObfuscatedName("d")
   byte field1909;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1377181981
   )
   int field1910;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1322302887
   )
   int field1911;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1339979929
   )
   int field1912;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -346775795
   )
   int field1913;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 595820597
   )
   int field1914;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -912226357
   )
   int field1915;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2116492513
   )
   int field1916;
   @ObfuscatedName("s")
   int[] field1917 = new int[256];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1503164147
   )
   int field1918;
   @ObfuscatedName("o")
   int[] field1919 = new int[257];
   @ObfuscatedName("m")
   final int field1920 = 258;
   @ObfuscatedName("au")
   boolean[] field1921 = new boolean[256];
   @ObfuscatedName("aq")
   boolean[] field1922 = new boolean[16];
   @ObfuscatedName("ab")
   byte[] field1923 = new byte[256];
   @ObfuscatedName("am")
   byte[] field1924 = new byte[4096];
   @ObfuscatedName("l")
   byte[] field1925;
   @ObfuscatedName("aj")
   byte[] field1926 = new byte[18002];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1642640987
   )
   int field1927;
   @ObfuscatedName("ay")
   byte[] field1928 = new byte[18002];
   @ObfuscatedName("ag")
   int[][] field1929 = new int[6][258];
   @ObfuscatedName("as")
   int[][] field1930 = new int[6][258];
   @ObfuscatedName("az")
   int[][] field1931 = new int[6][258];
   @ObfuscatedName("av")
   int[] field1932 = new int[6];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 949291779
   )
   int field1933 = 0;
   @ObfuscatedName("ql")
   protected static class133 field1934;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;Ljava/lang/String;B)I",
      garbageValue = "25"
   )
   public static int method2419(class119 var0, String var1) {
      int var2 = var0.field1971;
      byte[] var3 = class102.method2273(var1);
      var0.method2666(var3.length);
      var0.field1971 += class163.field2644.method2431(var3, 0, var3.length, var0.field1973, var0.field1971);
      return var0.field1971 - var2;
   }
}
