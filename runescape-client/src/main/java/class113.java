import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public final class class113 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1274834317
   )
   int field1966;
   @ObfuscatedName("w")
   final int field1967 = 16;
   @ObfuscatedName("e")
   final int field1968 = 258;
   @ObfuscatedName("k")
   byte[] field1969;
   @ObfuscatedName("ap")
   byte[] field1970 = new byte[256];
   @ObfuscatedName("l")
   final int field1971 = 18002;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -723471621
   )
   int field1972;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1181818899
   )
   int field1973 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1469645129
   )
   int field1974;
   @ObfuscatedName("ax")
   byte[][] field1975 = new byte[6][258];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1023229
   )
   int field1976 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -133265609
   )
   int field1977;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 667476667
   )
   int field1978;
   @ObfuscatedName("y")
   byte field1979;
   @ObfuscatedName("ar")
   byte[] field1980 = new byte[4096];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 33947739
   )
   int field1981;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 571380719
   )
   int field1982;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -382862709
   )
   int field1983;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1213493893
   )
   int field1984;
   @ObfuscatedName("m")
   final int field1985 = 4096;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -986604953
   )
   int field1986;
   @ObfuscatedName("z")
   int[] field1987 = new int[256];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 320627771
   )
   int field1988;
   @ObfuscatedName("aa")
   byte[] field1989 = new byte[18002];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -97682503
   )
   int field1990;
   @ObfuscatedName("aj")
   boolean[] field1991 = new boolean[256];
   @ObfuscatedName("q")
   int[] field1992 = new int[257];
   @ObfuscatedName("j")
   byte[] field1993;
   @ObfuscatedName("an")
   boolean[] field1994 = new boolean[16];
   @ObfuscatedName("ab")
   int[] field1995 = new int[16];
   @ObfuscatedName("ai")
   byte[] field1996 = new byte[18002];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 745230851
   )
   int field1997;
   @ObfuscatedName("g")
   final int field1998 = 50;
   @ObfuscatedName("ad")
   int[][] field1999 = new int[6][258];
   @ObfuscatedName("av")
   int[][] field2000 = new int[6][258];
   @ObfuscatedName("aq")
   int[][] field2001 = new int[6][258];
   @ObfuscatedName("af")
   int[] field2002 = new int[6];
   @ObfuscatedName("o")
   final int field2003 = 6;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-662070099"
   )
   public static int method2487(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/lang/Object;I)V",
      garbageValue = "552731372"
   )
   public static void method2488(class139 var0, Object var1) {
      if(null != var0.field2148) {
         for(int var2 = 0; var2 < 50 && var0.field2148.peekEvent() != null; ++var2) {
            class141.method2993(1L);
         }

         if(null != var1) {
            var0.field2148.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }
}
