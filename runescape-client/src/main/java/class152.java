import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public final class class152 {
   @ObfuscatedName("ai")
   byte[][] field2029 = new byte[6][258];
   @ObfuscatedName("x")
   final int field2030 = 16;
   @ObfuscatedName("i")
   final int field2031 = 258;
   @ObfuscatedName("a")
   final int field2032 = 6;
   @ObfuscatedName("az")
   int[] field2033 = new int[6];
   @ObfuscatedName("c")
   final int field2034 = 18002;
   @ObfuscatedName("d")
   byte[] field2035;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1545841707
   )
   int field2036 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1541808697
   )
   int field2037;
   @ObfuscatedName("z")
   byte[] field2038;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1900066193
   )
   int field2039 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1348176375
   )
   int field2040;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -728648573
   )
   int field2041;
   @ObfuscatedName("e")
   byte field2042;
   @ObfuscatedName("n")
   int[] field2043 = new int[257];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 740332701
   )
   int field2044;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -411761085
   )
   int field2045;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 150141731
   )
   int field2046;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -717015163
   )
   int field2047;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 901578873
   )
   int field2048;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1463852673
   )
   int field2049;
   @ObfuscatedName("s")
   int[] field2050 = new int[256];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1309376871
   )
   int field2051;
   @ObfuscatedName("ah")
   int[][] field2052 = new int[6][258];
   @ObfuscatedName("af")
   int[] field2053 = new int[16];
   @ObfuscatedName("aj")
   boolean[] field2054 = new boolean[256];
   @ObfuscatedName("ag")
   boolean[] field2055 = new boolean[16];
   @ObfuscatedName("al")
   byte[] field2056 = new byte[256];
   @ObfuscatedName("an")
   byte[] field2057 = new byte[4096];
   @ObfuscatedName("at")
   int[][] field2058 = new int[6][258];
   @ObfuscatedName("f")
   final int field2059 = 50;
   @ObfuscatedName("ax")
   byte[] field2060 = new byte[18002];
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -1057156839
   )
   static int field2061;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1567901601
   )
   int field2062;
   @ObfuscatedName("av")
   int[][] field2063 = new int[6][258];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1227938789
   )
   int field2064;
   @ObfuscatedName("u")
   final int field2065 = 4096;
   @ObfuscatedName("aa")
   byte[] field2066 = new byte[18002];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1668661393
   )
   int field2067;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 1985797641
   )
   static int field2068;
   @ObfuscatedName("bk")
   @Export("host")
   static String host;

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "736102614"
   )
   static final void method2757(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field533; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field486[var4] = true;
         }
      }

   }
}
