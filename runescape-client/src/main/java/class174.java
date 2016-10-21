import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class174 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1136387433
   )
   public static int field2748 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 580816685
   )
   public static int field2749 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -7864143662254435355L
   )
   public static long field2750;
   @ObfuscatedName("t")
   public static XHashTable field2751 = new XHashTable(4096);
   @ObfuscatedName("a")
   public static class171[] field2752 = new class171[256];
   @ObfuscatedName("b")
   public static XHashTable field2753 = new XHashTable(32);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 744919237
   )
   public static int field2754 = 0;
   @ObfuscatedName("f")
   public static class146 field2755;
   @ObfuscatedName("c")
   public static XHashTable field2756 = new XHashTable(4096);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -866118789
   )
   public static int field2757 = 0;
   @ObfuscatedName("k")
   public static Node2LinkedList field2758 = new Node2LinkedList();
   @ObfuscatedName("q")
   public static CRC32 field2759 = new CRC32();
   @ObfuscatedName("l")
   public static XHashTable field2760 = new XHashTable(4096);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1570079797
   )
   public static int field2762 = 0;
   @ObfuscatedName("z")
   public static byte field2764 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 531059865
   )
   public static int field2765 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 289179317
   )
   public static int field2766 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 660252069
   )
   public static int field2769 = 0;
   @ObfuscatedName("x")
   public static Buffer field2770 = new Buffer(8);
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = 2042653227
   )
   static int field2771;

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "404061421"
   )
   static void method3428(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class28.method654(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class28.method654(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3849((long)var1.id);
      if(var5 != null) {
         class8.method109(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
