import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class174 {
   @ObfuscatedName("x")
   public static class146 field2774;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1249029511
   )
   public static int field2775 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 3227155929691682237L
   )
   public static long field2776;
   @ObfuscatedName("z")
   public static XHashTable field2777 = new XHashTable(4096);
   @ObfuscatedName("b")
   public static XHashTable field2779 = new XHashTable(32);
   @ObfuscatedName("c")
   public static class171[] field2781 = new class171[256];
   @ObfuscatedName("p")
   static XHashTable field2782 = new XHashTable(4096);
   @ObfuscatedName("m")
   public static Node2LinkedList field2783 = new Node2LinkedList();
   @ObfuscatedName("d")
   public static XHashTable field2784 = new XHashTable(4096);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1759071437
   )
   public static int field2785 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -967715749
   )
   public static int field2786 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1423556589
   )
   public static int field2787 = 0;
   @ObfuscatedName("a")
   public static CRC32 field2788 = new CRC32();
   @ObfuscatedName("g")
   public static Buffer field2789 = new Buffer(8);
   @ObfuscatedName("n")
   public static byte field2790 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -216302979
   )
   public static int field2791 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1314118507
   )
   public static int field2792 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1457139611
   )
   public static int field2793 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1424190899
   )
   public static int field2794 = 0;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "20"
   )
   static final int method3418(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }
}
