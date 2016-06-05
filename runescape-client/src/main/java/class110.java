import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public final class class110 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1262816789
   )
   int field1917;
   @ObfuscatedName("i")
   final int field1918 = 16;
   @ObfuscatedName("g")
   final int field1919 = 258;
   @ObfuscatedName("h")
   final int field1920 = 6;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -149779591
   )
   int field1921;
   @ObfuscatedName("m")
   int[] field1922 = new int[257];
   @ObfuscatedName("f")
   byte[] field1923;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -72367247
   )
   int field1924 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1033209887
   )
   int field1925;
   @ObfuscatedName("l")
   byte[] field1926;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1825028347
   )
   int field1927 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 350410621
   )
   int field1928;
   @ObfuscatedName("r")
   final int field1929 = 18002;
   @ObfuscatedName("aq")
   byte[][] field1930 = new byte[6][258];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1289931779
   )
   int field1931;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -323059051
   )
   int field1932;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1700518511
   )
   int field1933;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 484658675
   )
   int field1934;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1976226739
   )
   int field1935;
   @ObfuscatedName("an")
   int[][] field1936 = new int[6][258];
   @ObfuscatedName("ai")
   int[][] field1937 = new int[6][258];
   @ObfuscatedName("x")
   int[] field1938 = new int[256];
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1507102239
   )
   static int field1939;
   @ObfuscatedName("ap")
   int[] field1940 = new int[6];
   @ObfuscatedName("aw")
   int[][] field1941 = new int[6][258];
   @ObfuscatedName("ad")
   boolean[] field1942 = new boolean[256];
   @ObfuscatedName("as")
   boolean[] field1943 = new boolean[16];
   @ObfuscatedName("ag")
   byte[] field1944 = new byte[256];
   @ObfuscatedName("o")
   byte field1945;
   @ObfuscatedName("av")
   int[] field1946 = new int[16];
   @ObfuscatedName("ar")
   byte[] field1947 = new byte[18002];
   @ObfuscatedName("ay")
   byte[] field1948 = new byte[18002];
   @ObfuscatedName("z")
   final int field1949 = 50;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1734106097
   )
   int field1950;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1089026985
   )
   int field1951;
   @ObfuscatedName("t")
   final int field1952 = 4096;
   @ObfuscatedName("al")
   byte[] field1953 = new byte[4096];
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1104973727
   )
   int field1954;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -582098847
   )
   int field1955;
   @ObfuscatedName("ax")
   static class80[] field1956;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "0"
   )
   static void method2384(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != class25.field643[var5]) {
            var2[var4] = class25.field643[var5];
            var3[var4] = class25.field635[var5];
            ++var4;
         }
      }

      class25.field643 = var2;
      class25.field635 = var3;
      class8.method103(class25.field636, 0, class25.field636.length - 1, class25.field643, class25.field635);
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-22"
   )
   static void method2385(int var0, int var1, int var2, int var3) {
      class173 var4 = class74.method1561(var0, var1);
      if(var4 != null && var4.field2870 != null) {
         class0 var5 = new class0();
         var5.field2 = var4;
         var5.field5 = var4.field2870;
         class171.method3363(var5);
      }

      client.field439 = var3;
      client.field437 = true;
      class27.field669 = var0;
      client.field342 = var1;
      class3.field69 = var2;
      class20.method547(var4);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass42;IIII)V",
      garbageValue = "-320284859"
   )
   static void method2386(class42 var0, int var1, int var2, int var3) {
      if(client.field524 < 50 && client.field374 != 0) {
         if(var0.field988 != null && var1 < var0.field988.length) {
            int var4 = var0.field988[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field525[client.field524] = var5;
               client.field319[client.field524] = var6;
               client.field527[client.field524] = 0;
               client.field529[client.field524] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field532[client.field524] = var7 + (var8 << 16) + (var9 << 8);
               ++client.field524;
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "1"
   )
   public static int method2387(CharSequence var0, int var1, boolean var2) {
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
            if(var5 != var9 / var1) {
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
}
