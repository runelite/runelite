import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class171 {
   @ObfuscatedName("u")
   public static class196 field2726 = new class196(32);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2057095347
   )
   public static int field2727 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 6660666332482632323L
   )
   public static long field2728;
   @ObfuscatedName("x")
   public static class196 field2729 = new class196(4096);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1919917643
   )
   public static int field2730 = 0;
   @ObfuscatedName("j")
   public static class143 field2731;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 36549951
   )
   public static int field2732 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1307239897
   )
   public static int field2733 = 0;
   @ObfuscatedName("k")
   public static class196 field2734 = new class196(4096);
   @ObfuscatedName("e")
   public static class119 field2735;
   @ObfuscatedName("l")
   public static class196 field2736 = new class196(4096);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 966697787
   )
   public static int field2737 = 0;
   @ObfuscatedName("m")
   public static class119 field2738 = new class119(8);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1481775225
   )
   public static int field2739 = 0;
   @ObfuscatedName("a")
   static CRC32 field2740 = new CRC32();
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 479208641
   )
   public static int field2741 = 0;
   @ObfuscatedName("w")
   static class119 field2742;
   @ObfuscatedName("b")
   public static class203 field2743 = new class203();
   @ObfuscatedName("y")
   public static byte field2744 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -96408423
   )
   public static int field2745 = 0;
   @ObfuscatedName("g")
   static class168[] field2746 = new class168[256];

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CIB)C",
      garbageValue = "-74"
   )
   static char method3363(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(231 == var0) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || 255 == var0) {
            return 'y';
         }
      }

      return var0 == 338?'O':(339 == var0?'o':(376 == var0?'Y':var0));
   }
}
