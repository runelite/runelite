import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class185 {
   @ObfuscatedName("m")
   static XHashTable field2762 = new XHashTable(4096);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1483565649
   )
   static int field2763 = 0;
   @ObfuscatedName("z")
   static CRC32 field2764 = new CRC32();
   @ObfuscatedName("h")
   static XHashTable field2765 = new XHashTable(4096);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1915685947
   )
   static int field2766 = 0;
   @ObfuscatedName("o")
   static XHashTable field2767 = new XHashTable(32);
   @ObfuscatedName("n")
   static Node2LinkedList field2768 = new Node2LinkedList();
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -897860333
   )
   static int field2769 = 0;
   @ObfuscatedName("f")
   static RSSocket field2770;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1003377013
   )
   static int field2771 = 0;
   @ObfuscatedName("j")
   static XHashTable field2772 = new XHashTable(4096);
   @ObfuscatedName("p")
   static Buffer field2773 = new Buffer(8);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 312074237
   )
   static int field2774 = 0;
   @ObfuscatedName("y")
   static Buffer field2775;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -334935227
   )
   static int field2776 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -5683698152026548367L
   )
   static long field2778;
   @ObfuscatedName("g")
   static IndexData[] field2779 = new IndexData[256];
   @ObfuscatedName("b")
   static byte field2780 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1294097427
   )
   public static int field2781 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -274442051
   )
   public static int field2782 = 0;

   class185() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Ljava/lang/String;Ljava/lang/String;S)LFont;",
      garbageValue = "5600"
   )
   public static Font method3473(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.method3351(var2);
      int var5 = var0.method3352(var4, var3);
      return XItemContainer.method157(var0, var1, var4, var5);
   }
}
