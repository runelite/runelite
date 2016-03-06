import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
public final class class109 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1672414201
   )
   int field1916 = 0;
   @ObfuscatedName("l")
   final int field1917 = 16;
   @ObfuscatedName("a")
   final int field1918 = 258;
   @ObfuscatedName("i")
   final int field1919 = 6;
   @ObfuscatedName("ag")
   int[] field1920 = new int[6];
   @ObfuscatedName("m")
   final int field1921 = 18002;
   @ObfuscatedName("o")
   byte[] field1922;
   @ObfuscatedName("ab")
   boolean[] field1923 = new boolean[256];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -273096447
   )
   int field1924;
   @ObfuscatedName("k")
   byte[] field1925;
   @ObfuscatedName("ac")
   byte[] field1926 = new byte[18002];
   @ObfuscatedName("aa")
   int[][] field1927 = new int[6][258];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1499378737
   )
   int field1928 = 0;
   @ObfuscatedName("u")
   byte field1929;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1356229097
   )
   int field1930;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -674871563
   )
   int field1931;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 827215743
   )
   int field1932;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1055555291
   )
   int field1933;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 140532417
   )
   int field1934;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 36081731
   )
   int field1935;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 647036141
   )
   int field1936;
   @ObfuscatedName("t")
   int[] field1937 = new int[256];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2053377347
   )
   int field1938;
   @ObfuscatedName("x")
   int[] field1939 = new int[257];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1166169281
   )
   int field1940;
   @ObfuscatedName("f")
   final int field1941 = 50;
   @ObfuscatedName("ax")
   byte[] field1942 = new byte[18002];
   @ObfuscatedName("ak")
   boolean[] field1943 = new boolean[16];
   @ObfuscatedName("aw")
   byte[] field1944 = new byte[4096];
   @ObfuscatedName("j")
   final int field1945 = 4096;
   @ObfuscatedName("as")
   int[][] field1946 = new int[6][258];
   @ObfuscatedName("az")
   int[] field1947 = new int[16];
   @ObfuscatedName("ai")
   byte[][] field1948 = new byte[6][258];
   @ObfuscatedName("ar")
   int[][] field1949 = new int[6][258];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1080711225
   )
   int field1952;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -903832833
   )
   int field1953;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -66426331
   )
   int field1954;
   @ObfuscatedName("am")
   byte[] field1955 = new byte[256];

   @ObfuscatedName("j")
   public static int method2380(int var0) {
      class47 var1 = class39.method796(var0);
      int var2 = var1.field1067;
      int var3 = var1.field1068;
      int var4 = var1.field1069;
      int var5 = class175.field2905[var4 - var3];
      return class175.field2906[var2] >> var3 & var5;
   }

   @ObfuscatedName("j")
   public static synchronized long method2381() {
      long var0 = System.currentTimeMillis();
      if(var0 < class89.field1562) {
         class114.field1973 += class89.field1562 - var0;
      }

      class89.field1562 = var0;
      return var0 + class114.field1973;
   }

   @ObfuscatedName("by")
   static final void method2382() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < client.field430 - 1; ++var1) {
            if(client.field433[var1] < 1000 && client.field433[var1 + 1] > 1000) {
               String var2 = client.field365[var1];
               client.field365[var1] = client.field365[var1 + 1];
               client.field365[1 + var1] = var2;
               String var3 = client.field437[var1];
               client.field437[var1] = client.field437[1 + var1];
               client.field437[1 + var1] = var3;
               int var4 = client.field433[var1];
               client.field433[var1] = client.field433[var1 + 1];
               client.field433[1 + var1] = var4;
               var4 = client.field431[var1];
               client.field431[var1] = client.field431[1 + var1];
               client.field431[var1 + 1] = var4;
               var4 = client.field432[var1];
               client.field432[var1] = client.field432[var1 + 1];
               client.field432[var1 + 1] = var4;
               var4 = client.field523[var1];
               client.field523[var1] = client.field523[var1 + 1];
               client.field523[1 + var1] = var4;
               var0 = false;
            }
         }
      }

   }
}
