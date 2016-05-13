import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public final class class110 {
   @ObfuscatedName("ab")
   boolean[] field1920 = new boolean[256];
   @ObfuscatedName("j")
   final int field1921 = 16;
   @ObfuscatedName("p")
   final int field1922 = 258;
   @ObfuscatedName("x")
   final int field1923 = 6;
   @ObfuscatedName("d")
   final int field1924 = 50;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 518318867
   )
   int field1925;
   @ObfuscatedName("c")
   byte[] field1926;
   @ObfuscatedName("an")
   byte[] field1927 = new byte[256];
   @ObfuscatedName("ai")
   int[][] field1928 = new int[6][258];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -639173975
   )
   int field1929;
   @ObfuscatedName("s")
   final int field1930 = 4096;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1479514413
   )
   int field1931;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -184627803
   )
   int field1932;
   @ObfuscatedName("r")
   byte field1933;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1004114245
   )
   int field1934 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2035296111
   )
   int field1935;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 201186455
   )
   int field1936;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -896029055
   )
   int field1937;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1482953873
   )
   int field1938;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1243727001
   )
   int field1939;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 330888489
   )
   int field1940;
   @ObfuscatedName("y")
   int[] field1941 = new int[256];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1990117607
   )
   int field1942;
   @ObfuscatedName("q")
   int[] field1943 = new int[257];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 559405897
   )
   int field1944;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 949087109
   )
   static int field1945;
   @ObfuscatedName("ad")
   boolean[] field1946 = new boolean[16];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1720149787
   )
   int field1947;
   @ObfuscatedName("au")
   byte[] field1948 = new byte[4096];
   @ObfuscatedName("ap")
   int[] field1949 = new int[16];
   @ObfuscatedName("am")
   byte[] field1950 = new byte[18002];
   @ObfuscatedName("ae")
   byte[] field1951 = new byte[18002];
   @ObfuscatedName("as")
   int[][] field1952 = new int[6][258];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1921737799
   )
   int field1953 = 0;
   @ObfuscatedName("u")
   final int field1954 = 18002;
   @ObfuscatedName("ah")
   int[][] field1955 = new int[6][258];
   @ObfuscatedName("ax")
   int[] field1956 = new int[6];
   @ObfuscatedName("ao")
   byte[][] field1957 = new byte[6][258];
   @ObfuscatedName("o")
   byte[] field1958;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 432424163
   )
   static int field1959;
   @ObfuscatedName("nu")
   static class74 field1960;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass80;I)V",
      garbageValue = "1997121078"
   )
   static final void method2416(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class27.field670.length; ++var2) {
         class27.field670[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class27.field670[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class178.field2932[var5] = (class27.field670[var5 - 128] + class27.field670[var5 - 1] + class27.field670[var5 + 1] + class27.field670[128 + var5]) / 4;
            }
         }

         int[] var6 = class27.field670;
         class27.field670 = class178.field2932;
         class178.field2932 = var6;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1429; ++var3) {
            for(var4 = 0; var4 < var0.field1427; ++var4) {
               if(var0.field1430[var2++] != 0) {
                  var5 = var0.field1428 + 16 + var4;
                  int var8 = 16 + var3 + var0.field1431;
                  int var7 = var5 + (var8 << 7);
                  class27.field670[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "1"
   )
   public static final void method2417(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class56.field1186 = var0;
         class56.field1180 = var1;
         class56.field1194 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-968140850"
   )
   static void method2418(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         class25 var8 = class25.field636[var6];
         class25.field636[var6] = class25.field636[var1];
         class25.field636[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            class25 var10 = class25.field636[var9];
            int var11 = class56.method1195(var10, var8, var2, var3);
            int var12;
            if(var11 != 0) {
               if(var3) {
                  var12 = -var11;
               } else {
                  var12 = var11;
               }
            } else if(-1 == var4) {
               var12 = 0;
            } else {
               int var13 = class56.method1195(var10, var8, var4, var5);
               if(var5) {
                  var12 = -var13;
               } else {
                  var12 = var13;
               }
            }

            if(var12 <= 0) {
               class25 var14 = class25.field636[var9];
               class25.field636[var9] = class25.field636[var7];
               class25.field636[var7++] = var14;
            }
         }

         class25.field636[var1] = class25.field636[var7];
         class25.field636[var7] = var8;
         method2418(var0, var7 - 1, var2, var3, var4, var5);
         method2418(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
