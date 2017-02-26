import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public final class class152 {
   @ObfuscatedName("d")
   final int field2048 = 16;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 656170179
   )
   int field2049;
   @ObfuscatedName("p")
   final int field2050 = 6;
   @ObfuscatedName("j")
   final int field2051 = 50;
   @ObfuscatedName("ah")
   int[] field2052 = new int[6];
   @ObfuscatedName("r")
   byte[] field2053;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 857013681
   )
   int field2054 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -813418987
   )
   int field2055;
   @ObfuscatedName("o")
   byte[] field2056;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1882665813
   )
   int field2057 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1152007529
   )
   int field2058;
   @ObfuscatedName("b")
   byte field2060;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 740251415
   )
   int field2061;
   @ObfuscatedName("ao")
   int[][] field2062 = new int[6][258];
   @ObfuscatedName("q")
   final int field2063 = 4096;
   @ObfuscatedName("x")
   int[] field2064 = new int[257];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -77184737
   )
   int field2065;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1045251159
   )
   int field2066;
   @ObfuscatedName("h")
   final int field2067 = 258;
   @ObfuscatedName("k")
   int[] field2068 = new int[256];
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1789021831
   )
   int field2069;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -925082999
   )
   int field2070;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -162291463
   )
   int field2071;
   @ObfuscatedName("ae")
   boolean[] field2072 = new boolean[256];
   @ObfuscatedName("aq")
   boolean[] field2073 = new boolean[16];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1862117043
   )
   int field2074;
   @ObfuscatedName("au")
   byte[] field2075 = new byte[4096];
   @ObfuscatedName("am")
   int[] field2076 = new int[16];
   @ObfuscatedName("ad")
   byte[] field2077 = new byte[18002];
   @ObfuscatedName("ai")
   byte[] field2078 = new byte[18002];
   @ObfuscatedName("ac")
   byte[][] field2079 = new byte[6][258];
   @ObfuscatedName("at")
   byte[] field2080 = new byte[256];
   @ObfuscatedName("as")
   int[][] field2081 = new int[6][258];
   @ObfuscatedName("aa")
   int[][] field2082 = new int[6][258];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 139426095
   )
   int field2083;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -752426287
   )
   int field2084;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 819185673
   )
   static int field2086;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1522662445
   )
   int field2087;
   @ObfuscatedName("n")
   final int field2088 = 18002;

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static void method2813(int var0) {
      class9.field90 = new class38();
      class9.field90.field820 = Client.menuActionParams0[var0];
      class9.field90.field816 = Client.menuActionParams1[var0];
      class9.field90.field817 = Client.menuTypes[var0];
      class9.field90.field818 = Client.menuIdentifiers[var0];
      class9.field90.field819 = Client.menuOptions[var0];
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1788295142"
   )
   static void method2814() {
      Client.menuOptionCount = 0;
      Client.field433 = -1;
      Client.isMenuOpen = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILclass182;IIIZI)V",
      garbageValue = "1219640738"
   )
   public static void method2815(int var0, class182 var1, int var2, int var3, int var4, boolean var5) {
      class138.field1919 = 1;
      class167.field2182 = var1;
      ScriptState.field130 = var2;
      class138.field1918 = var3;
      class1.field16 = var4;
      class165.field2163 = var5;
      FileOnDisk.field1209 = var0;
   }
}
