import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class185 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -8915871991370479475L
   )
   static long field2721;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1220085347
   )
   static int field2722 = 0;
   @ObfuscatedName("e")
   static class181 field2723;
   @ObfuscatedName("a")
   static XHashTable field2724 = new XHashTable(4096);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1659821959
   )
   static int field2725 = 0;
   @ObfuscatedName("c")
   static XHashTable field2726 = new XHashTable(32);
   @ObfuscatedName("g")
   static XHashTable field2727 = new XHashTable(4096);
   @ObfuscatedName("l")
   static Node2LinkedList field2728 = new Node2LinkedList();
   @ObfuscatedName("r")
   static CRC32 field2729 = new CRC32();
   @ObfuscatedName("bz")
   static ModIcon field2730;
   @ObfuscatedName("t")
   static XHashTable field2731 = new XHashTable(4096);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 653684397
   )
   static int field2732 = 0;
   @ObfuscatedName("q")
   static boolean field2733;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1357036175
   )
   static int field2734 = 0;
   @ObfuscatedName("v")
   static Buffer field2735 = new Buffer(8);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 71763499
   )
   public static int field2736 = 0;
   @ObfuscatedName("u")
   static class110 field2737;
   @ObfuscatedName("h")
   static class184[] field2738 = new class184[256];
   @ObfuscatedName("s")
   static byte field2739 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 547807753
   )
   public static int field2740 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1732413289
   )
   static int field2741 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 537736337
   )
   static int field2743 = 0;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass190;",
      garbageValue = "-1987357695"
   )
   public static class190 method3389(int var0) {
      class190 var1 = (class190)class190.field2768.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class190.field2778.method3272(13, var0);
         var1 = new class190();
         var1.field2770 = var0;
         if(var2 != null) {
            var1.method3447(new Buffer(var2));
         }

         class190.field2768.put(var1, (long)var0);
         return var1;
      }
   }
}
