import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class185 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 116590163
   )
   public static int field2745 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 7999389
   )
   public static int field2746 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -3374855969677076063L
   )
   public static long field2747;
   @ObfuscatedName("h")
   public static XHashTable field2748 = new XHashTable(4096);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 773202359
   )
   public static int field2749 = 0;
   @ObfuscatedName("r")
   public static XHashTable field2750 = new XHashTable(32);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1493034331
   )
   public static int field2751 = 0;
   @ObfuscatedName("p")
   public static Node2LinkedList field2752 = new Node2LinkedList();
   @ObfuscatedName("g")
   public static XHashTable field2753 = new XHashTable(4096);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1275220721
   )
   public static int field2754 = 0;
   @ObfuscatedName("q")
   public static XHashTable field2755 = new XHashTable(4096);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -93144319
   )
   public static int field2756 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 696472993
   )
   public static int field2757 = 0;
   @ObfuscatedName("x")
   public static Buffer field2758 = new Buffer(8);
   @ObfuscatedName("i")
   static CRC32 field2759 = new CRC32();
   @ObfuscatedName("b")
   static class184[] field2760 = new class184[256];
   @ObfuscatedName("n")
   public static class110 field2761;
   @ObfuscatedName("j")
   public static byte field2762 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 862456783
   )
   public static int field2763 = 0;

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(LWidget;S)I",
      garbageValue = "16256"
   )
   static int method3463(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2405(((long)var0.id << 32) + (long)var0.index);
      return null != var1?var1.field1892:var0.field2141;
   }
}
