import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class185 {
   @ObfuscatedName("b")
   public static byte field2728 = 0;
   @ObfuscatedName("d")
   public static Node2LinkedList field2729 = new Node2LinkedList();
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 2020465102466276561L
   )
   public static long field2730;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1617578569
   )
   public static int field2731 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -111847277
   )
   public static int field2732 = 0;
   @ObfuscatedName("j")
   public static XHashTable field2733 = new XHashTable(32);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1012985129
   )
   public static int field2734 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1360002581
   )
   public static int field2735 = 0;
   @ObfuscatedName("r")
   public static XHashTable field2736 = new XHashTable(4096);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 520200919
   )
   public static int field2738 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1117110553
   )
   public static int field2739 = 0;
   @ObfuscatedName("s")
   public static XHashTable field2740 = new XHashTable(4096);
   @ObfuscatedName("n")
   public static XHashTable field2741 = new XHashTable(4096);
   @ObfuscatedName("f")
   static CRC32 field2742 = new CRC32();
   @ObfuscatedName("u")
   static class184[] field2743 = new class184[256];
   @ObfuscatedName("a")
   public static Buffer field2744 = new Buffer(8);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1671101973
   )
   public static int field2745 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 939683469
   )
   public static int field2746 = 0;
   @ObfuscatedName("k")
   public static class110 field2748;

   class185() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIZB)Ljava/lang/String;",
      garbageValue = "21"
   )
   static String method3407(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(87 + var8);
               } else {
                  var5[var6] = (char)(48 + var8);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
