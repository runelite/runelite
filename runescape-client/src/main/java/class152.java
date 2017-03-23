import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public final class class152 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -509411937
   )
   int field2044;
   @ObfuscatedName("j")
   final int field2045 = 16;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 664843783
   )
   int field2046;
   @ObfuscatedName("d")
   final int field2047 = 6;
   @ObfuscatedName("w")
   final int field2048 = 50;
   @ObfuscatedName("x")
   final int field2049 = 4096;
   @ObfuscatedName("u")
   byte[] field2050;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1886766889
   )
   int field2051 = 0;
   @ObfuscatedName("h")
   final int field2052 = 18002;
   @ObfuscatedName("y")
   byte[] field2053;
   @ObfuscatedName("af")
   byte[] field2054 = new byte[4096];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -21805505
   )
   int field2055;
   @ObfuscatedName("aa")
   byte[] field2056 = new byte[256];
   @ObfuscatedName("l")
   byte field2057;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1665697731
   )
   int field2058;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1134699595
   )
   int field2059;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1092464365
   )
   int field2060;
   @ObfuscatedName("ar")
   boolean[] field2061 = new boolean[16];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 920275239
   )
   int field2062;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1005920663
   )
   int field2063;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 557502837
   )
   int field2064;
   @ObfuscatedName("z")
   int[] field2065 = new int[256];
   @ObfuscatedName("ax")
   int[] field2066 = new int[16];
   @ObfuscatedName("n")
   int[] field2067 = new int[257];
   @ObfuscatedName("ae")
   int[][] field2068 = new int[6][258];
   @ObfuscatedName("an")
   boolean[] field2069 = new boolean[256];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1930073259
   )
   int field2070 = 0;
   @ObfuscatedName("c")
   final int field2071 = 258;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 933264529
   )
   int field2072;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -450445713
   )
   int field2073;
   @ObfuscatedName("ah")
   byte[] field2074 = new byte[18002];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -535701079
   )
   int field2075;
   @ObfuscatedName("az")
   byte[] field2076 = new byte[18002];
   @ObfuscatedName("at")
   byte[][] field2077 = new byte[6][258];
   @ObfuscatedName("ab")
   int[][] field2078 = new int[6][258];
   @ObfuscatedName("ao")
   int[][] field2079 = new int[6][258];
   @ObfuscatedName("am")
   int[] field2080 = new int[6];
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 42323343
   )
   int field2081;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Lclass186;",
      garbageValue = "0"
   )
   public static class186 method2812(int var0) {
      class186 var1 = (class186)class186.field2764.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class186.field2762.getConfigData(5, var0);
         var1 = new class186();
         if(null != var2) {
            var1.method3442(new Buffer(var2));
         }

         class186.field2764.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LScript;",
      garbageValue = "-2135092729"
   )
   static Script method2813(int var0) {
      Script var1 = (Script)Script.field964.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = RSSocket.field1763.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new Script();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.readInt();
            var1.localIntCount = var3.readUnsignedShort();
            var1.localStringCount = var3.readUnsignedShort();
            var1.intStackCount = var3.readUnsignedShort();
            var1.stringStackCount = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2838();
            var1.instructions = new int[var4];
            var1.intOperands = new int[var4];
            var1.stringOperands = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.instructions[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if(var6 == 3) {
                  var1.stringOperands[var5] = var3.readString();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.intOperands[var5] = var3.readInt();
               } else {
                  var1.intOperands[var5] = var3.readUnsignedByte();
               }
            }

            Script.field964.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-49"
   )
   public static int method2814(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
