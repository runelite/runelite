import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
@Implements("Bzip2State")
public final class Bzip2State {
   @ObfuscatedName("m")
   final int __m;
   @ObfuscatedName("f")
   final int __f;
   @ObfuscatedName("q")
   final int __q;
   @ObfuscatedName("w")
   final int __w;
   @ObfuscatedName("o")
   final int __o;
   @ObfuscatedName("u")
   final int __u;
   @ObfuscatedName("g")
   byte[] __g;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1510817847
   )
   int __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -473971741
   )
   int __e;
   @ObfuscatedName("x")
   byte[] __x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -861462251
   )
   int __d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 594179173
   )
   int __k;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1860254567
   )
   int __n;
   @ObfuscatedName("i")
   byte __i;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1994129645
   )
   int __a;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1793367959
   )
   int __z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1987934943
   )
   int __j;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1172102327
   )
   int __s;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1502359789
   )
   int __t;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -953353963
   )
   int __y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1981923611
   )
   int __h;
   @ObfuscatedName("b")
   int[] __b;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -557334365
   )
   int __c;
   @ObfuscatedName("r")
   int[] __r;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -886333045
   )
   int __v;
   @ObfuscatedName("ag")
   boolean[] __ag;
   @ObfuscatedName("aq")
   boolean[] __aq;
   @ObfuscatedName("aj")
   byte[] __aj;
   @ObfuscatedName("av")
   byte[] __av;
   @ObfuscatedName("ar")
   int[] __ar;
   @ObfuscatedName("ac")
   byte[] __ac;
   @ObfuscatedName("ay")
   byte[] __ay;
   @ObfuscatedName("ah")
   byte[][] __ah;
   @ObfuscatedName("ak")
   int[][] __ak;
   @ObfuscatedName("aw")
   int[][] __aw;
   @ObfuscatedName("al")
   int[][] __al;
   @ObfuscatedName("ab")
   int[] __ab;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 444639767
   )
   int __ae;

   Bzip2State() {
      this.__m = 4096;
      this.__f = 16;
      this.__q = 258;
      this.__w = 6;
      this.__o = 50;
      this.__u = 18002;
      this.__l = 0;
      this.__d = 0;
      this.__b = new int[256];
      this.__r = new int[257];
      this.__ag = new boolean[256];
      this.__aq = new boolean[16];
      this.__aj = new byte[256];
      this.__av = new byte[4096];
      this.__ar = new int[16];
      this.__ac = new byte[18002];
      this.__ay = new byte[18002];
      this.__ah = new byte[6][258];
      this.__ak = new int[6][258];
      this.__aw = new int[6][258];
      this.__al = new int[6][258];
      this.__ab = new int[6];
   }
}
