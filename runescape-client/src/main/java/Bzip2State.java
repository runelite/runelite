import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
@Implements("Bzip2State")
public final class Bzip2State {
   @ObfuscatedName("m")
   @Export("__m")
   final int __m;
   @ObfuscatedName("f")
   @Export("__f")
   final int __f;
   @ObfuscatedName("q")
   @Export("__q")
   final int __q;
   @ObfuscatedName("w")
   @Export("__w")
   final int __w;
   @ObfuscatedName("o")
   @Export("__o")
   final int __o;
   @ObfuscatedName("u")
   @Export("__u")
   final int __u;
   @ObfuscatedName("g")
   @Export("__g")
   byte[] __g;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1510817847
   )
   @Export("__l")
   int __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -473971741
   )
   @Export("__e")
   int __e;
   @ObfuscatedName("x")
   @Export("__x")
   byte[] __x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -861462251
   )
   @Export("__d")
   int __d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 594179173
   )
   @Export("__k")
   int __k;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1860254567
   )
   @Export("surfaceOffsetY")
   int __n;
   @ObfuscatedName("i")
   @Export("__i")
   byte __i;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1994129645
   )
   @Export("__a")
   int __a;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1793367959
   )
   @Export("__z")
   int __z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1987934943
   )
   @Export("__j")
   int __j;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1172102327
   )
   @Export("__s")
   int __s;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1502359789
   )
   @Export("__t")
   int __t;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -953353963
   )
   @Export("__y")
   int __y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1981923611
   )
   @Export("__h")
   int __h;
   @ObfuscatedName("b")
   @Export("__b")
   int[] __b;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -557334365
   )
   @Export("__c")
   int __c;
   @ObfuscatedName("r")
   @Export("__r")
   int[] __r;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -886333045
   )
   @Export("__v")
   int __v;
   @ObfuscatedName("ag")
   @Export("__ag")
   boolean[] __ag;
   @ObfuscatedName("aq")
   @Export("__aq")
   boolean[] __aq;
   @ObfuscatedName("aj")
   @Export("__aj")
   byte[] __aj;
   @ObfuscatedName("av")
   @Export("__av")
   byte[] __av;
   @ObfuscatedName("ar")
   @Export("__ar")
   int[] __ar;
   @ObfuscatedName("ac")
   @Export("__ac")
   byte[] __ac;
   @ObfuscatedName("ay")
   @Export("__ay")
   byte[] __ay;
   @ObfuscatedName("ah")
   @Export("__ah")
   byte[][] __ah;
   @ObfuscatedName("ak")
   @Export("__ak")
   int[][] __ak;
   @ObfuscatedName("aw")
   @Export("__aw")
   int[][] __aw;
   @ObfuscatedName("al")
   @Export("__al")
   int[][] __al;
   @ObfuscatedName("ab")
   @Export("__ab")
   int[] __ab;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 444639767
   )
   @Export("__ae")
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
