import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public final class class113 {
   @ObfuscatedName("ag")
   int[][] field1945 = new int[6][258];
   @ObfuscatedName("at")
   static class146 field1946;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -961511583
   )
   int field1947;
   @ObfuscatedName("y")
   final int field1948 = 6;
   @ObfuscatedName("p")
   final int field1949 = 50;
   @ObfuscatedName("ar")
   byte[] field1950 = new byte[18002];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 279532637
   )
   int field1951;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1152537251
   )
   int field1952 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 129509195
   )
   int field1953;
   @ObfuscatedName("h")
   byte[] field1954;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1383569535
   )
   int field1955 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1573256647
   )
   int field1956;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1778533453
   )
   int field1957;
   @ObfuscatedName("ao")
   int[][] field1958 = new int[6][258];
   @ObfuscatedName("ae")
   boolean[] field1959 = new boolean[256];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 691277977
   )
   int field1960;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 357964341
   )
   int field1961;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 213273083
   )
   int field1962;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1754023521
   )
   int field1963;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -888848673
   )
   int field1964;
   @ObfuscatedName("ab")
   int[][] field1965 = new int[6][258];
   @ObfuscatedName("x")
   int[] field1966 = new int[256];
   @ObfuscatedName("g")
   final int field1967 = 18002;
   @ObfuscatedName("l")
   int[] field1968 = new int[257];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -509455325
   )
   int field1969;
   @ObfuscatedName("an")
   byte[][] field1970 = new byte[6][258];
   @ObfuscatedName("av")
   int[] field1971 = new int[6];
   @ObfuscatedName("am")
   byte[] field1972 = new byte[256];
   @ObfuscatedName("aa")
   byte[] field1973 = new byte[4096];
   @ObfuscatedName("ax")
   int[] field1974 = new int[16];
   @ObfuscatedName("ac")
   byte[] field1975 = new byte[18002];
   @ObfuscatedName("z")
   final int field1976 = 16;
   @ObfuscatedName("t")
   final int field1977 = 258;
   @ObfuscatedName("m")
   byte[] field1978;
   @ObfuscatedName("ah")
   boolean[] field1979 = new boolean[16];
   @ObfuscatedName("s")
   final int field1980 = 4096;
   @ObfuscatedName("n")
   byte field1981;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 743125037
   )
   int field1982;
   @ObfuscatedName("bh")
   static ModIcon[] field1983;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -187208263
   )
   int field1984;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2088659773"
   )
   public static synchronized long method2394() {
      long var0 = System.currentTimeMillis();
      if(var0 < class118.field2009) {
         class22.field574 += class118.field2009 - var0;
      }

      class118.field2009 = var0;
      return class22.field574 + var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "29"
   )
   public static int method2395(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1116098113"
   )
   static final void method2396() {
      Client.field300.method2748(248);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3780(); null != var0; var0 = (WidgetNode)Client.componentTable.method3785()) {
         if(var0.field54 == 0 || var0.field54 == 3) {
            class14.method169(var0, true);
         }
      }

      if(null != Client.field432) {
         class32.method685(Client.field432);
         Client.field432 = null;
      }

   }
}
