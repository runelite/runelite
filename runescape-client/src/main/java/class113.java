import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public final class class113 {
   @ObfuscatedName("ad")
   boolean[] field1974 = new boolean[256];
   @ObfuscatedName("g")
   final int field1975 = 16;
   @ObfuscatedName("r")
   final int field1976 = 258;
   @ObfuscatedName("e")
   final int field1977 = 6;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1874154691
   )
   int field1978 = 0;
   @ObfuscatedName("s")
   final int field1979 = 18002;
   @ObfuscatedName("k")
   byte[] field1980;
   @ObfuscatedName("x")
   int[] field1981 = new int[256];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 753990729
   )
   int field1982;
   @ObfuscatedName("b")
   byte[] field1983;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -455853769
   )
   int field1984;
   @ObfuscatedName("l")
   final int field1985 = 4096;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1288049485
   )
   int field1986;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1843150951
   )
   int field1987;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 36075983
   )
   int field1988;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2102155621
   )
   int field1989;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1701003969
   )
   int field1990;
   @ObfuscatedName("h")
   final int field1991 = 50;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -64989639
   )
   int field1992;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1188912879
   )
   int field1993;
   @ObfuscatedName("ab")
   int[][] field1994 = new int[6][258];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1227362809
   )
   int field1995;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -152773225
   )
   int field1996;
   @ObfuscatedName("y")
   int[] field1997 = new int[257];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 190143175
   )
   int field1998;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1738723469
   )
   int field1999;
   @ObfuscatedName("as")
   boolean[] field2000 = new boolean[16];
   @ObfuscatedName("ac")
   byte[] field2001 = new byte[256];
   @ObfuscatedName("am")
   int[] field2002 = new int[16];
   @ObfuscatedName("w")
   byte field2003;
   @ObfuscatedName("aq")
   byte[] field2004 = new byte[18002];
   @ObfuscatedName("az")
   byte[] field2005 = new byte[18002];
   @ObfuscatedName("ak")
   byte[][] field2006 = new byte[6][258];
   @ObfuscatedName("ag")
   int[][] field2007 = new int[6][258];
   @ObfuscatedName("af")
   int[][] field2008 = new int[6][258];
   @ObfuscatedName("ah")
   byte[] field2009 = new byte[4096];
   @ObfuscatedName("ap")
   int[] field2010 = new int[6];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 182667131
   )
   int field2011 = 0;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1884056304"
   )
   static final int method2538(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
