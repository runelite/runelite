import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class174 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -322334431
   )
   public static int field2760 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2062461899
   )
   public static int field2761 = 0;
   @ObfuscatedName("g")
   public static XHashTable field2762 = new XHashTable(4096);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1209831911
   )
   public static int field2763 = 0;
   @ObfuscatedName("u")
   public static XHashTable field2764 = new XHashTable(32);
   @ObfuscatedName("l")
   public static Node2LinkedList field2765 = new Node2LinkedList();
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -344029575
   )
   public static int field2766 = 0;
   @ObfuscatedName("m")
   static XHashTable field2767 = new XHashTable(4096);
   @ObfuscatedName("i")
   public static class146 field2768;
   @ObfuscatedName("y")
   public static XHashTable field2769 = new XHashTable(4096);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1390012613
   )
   public static int field2770 = 0;
   @ObfuscatedName("p")
   public static boolean field2771;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1749434171
   )
   public static int field2772 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1869164313
   )
   public static int field2773 = 0;
   @ObfuscatedName("k")
   public static CRC32 field2774 = new CRC32();
   @ObfuscatedName("q")
   public static class171[] field2775 = new class171[256];
   @ObfuscatedName("o")
   public static byte field2776 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1171860229
   )
   public static int field2777 = 0;
   @ObfuscatedName("r")
   public static Buffer field2778 = new Buffer(8);
   @ObfuscatedName("dw")
   static byte[][] field2779;
   @ObfuscatedName("ch")
   static class149 field2781;

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "127"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class173.plane][var0][var1];
      if(var2 == null) {
         class128.region.method1973(class173.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method3845(); var6 != null; var6 = (Item)var2.method3847()) {
            ItemComposition var7 = class92.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class128.region.method1973(class173.plane, var0, var1);
         } else {
            var2.method3841(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method3845(); var6 != null; var6 = (Item)var2.method3847()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class128.region.method1959(class173.plane, var0, var1, class16.method191(64 + var0 * 128, var1 * 128 + 64, class173.plane), var5, var9, var11, var10);
         }
      }
   }
}
