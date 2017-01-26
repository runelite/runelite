import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class185 {
   @ObfuscatedName("o")
   public static XHashTable field2741 = new XHashTable(4096);
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -1017284957
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("q")
   public static XHashTable field2743 = new XHashTable(4096);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1191174545
   )
   public static int field2745 = 0;
   @ObfuscatedName("f")
   public static byte field2746 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1905313961
   )
   public static int field2747 = 0;
   @ObfuscatedName("s")
   public static Node2LinkedList field2748 = new Node2LinkedList();
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1262162029
   )
   public static int field2749 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2138021085
   )
   public static int field2750 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -707286677
   )
   public static int field2751 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -597946607
   )
   public static int field2752 = 0;
   @ObfuscatedName("r")
   public static class181 field2753;
   @ObfuscatedName("u")
   public static Buffer field2754 = new Buffer(8);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1657519739
   )
   public static int field2755 = 0;
   @ObfuscatedName("w")
   public static CRC32 field2756 = new CRC32();
   @ObfuscatedName("p")
   public static class110 field2757;
   @ObfuscatedName("v")
   public static class184[] field2758 = new class184[256];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -1589096370494624139L
   )
   public static long field2759;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 163393025
   )
   public static int field2760 = 0;
   @ObfuscatedName("k")
   public static XHashTable field2761 = new XHashTable(32);
   @ObfuscatedName("c")
   public static XHashTable field2762 = new XHashTable(4096);

   class185() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "-1822411187"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2815.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class231.field3282.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method3490(new Buffer(var2));
         }

         KitDefinition.field2815.put(var1, (long)var0);
         return var1;
      }
   }
}
