import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class185 {
   @ObfuscatedName("b")
   public static class110 field2741;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1168523567
   )
   public static int field2742 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -4456960209254592261L
   )
   public static long field2743;
   @ObfuscatedName("a")
   public static XHashTable field2744 = new XHashTable(4096);
   @ObfuscatedName("t")
   public static XHashTable field2745 = new XHashTable(4096);
   @ObfuscatedName("h")
   public static XHashTable field2746 = new XHashTable(32);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1029764687
   )
   public static int field2747 = 0;
   @ObfuscatedName("f")
   public static Node2LinkedList field2748 = new Node2LinkedList();
   @ObfuscatedName("c")
   public static class184[] field2749 = new class184[256];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1174454319
   )
   public static int field2750 = 0;
   @ObfuscatedName("u")
   public static CRC32 field2751 = new CRC32();
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -77760301
   )
   public static int field2752 = 0;
   @ObfuscatedName("o")
   public static Buffer field2753 = new Buffer(8);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1370002815
   )
   public static int field2754 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1383948897
   )
   public static int field2755 = 0;
   @ObfuscatedName("x")
   public static XHashTable field2756 = new XHashTable(4096);
   @ObfuscatedName("v")
   public static byte field2757 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1965522215
   )
   public static int field2758 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1155666401
   )
   public static int field2759 = 0;
   @ObfuscatedName("p")
   static Widget field2760;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)Z",
      garbageValue = "-1963614050"
   )
   public static boolean method3467(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class6.method95(var3);
         return true;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass228;B)I",
      garbageValue = "-62"
   )
   static final int method3487(class228 var0) {
      if(null == var0) {
         return 12;
      } else {
         switch(var0.field3258) {
         case 8:
            return 20;
         default:
            return 12;
         }
      }
   }

   class185() throws Throwable {
      throw new Error();
   }
}
