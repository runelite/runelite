import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class38 {
   @ObfuscatedName("u")
   static Calendar field782 = Calendar.getInstance();
   @ObfuscatedName("y")
   static String[] field785;
   @ObfuscatedName("p")
   static int[] field786 = new int[5];
   @ObfuscatedName("g")
   static int[][] field787 = new int[5][5000];
   @ObfuscatedName("t")
   static int[] field788;
   @ObfuscatedName("f")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1963030303
   )
   static int field790 = 0;
   @ObfuscatedName("h")
   static class14[] field791 = new class14[50];
   @ObfuscatedName("w")
   static Widget field792;
   @ObfuscatedName("ie")
   static Widget field793;
   @ObfuscatedName("n")
   static final String[] field794 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -754371573
   )
   static int field795 = 0;
   @ObfuscatedName("bd")
   @Export("host")
   static String host;
   @ObfuscatedName("ae")
   static int[] field799;
   @ObfuscatedName("m")
   static int[] field800 = new int[1000];

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "112957591"
   )
   static boolean method764(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = XItemContainer.method178(var0, Client.field518);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(XItemContainer.method178(var3.name, Client.field518))) {
               return true;
            }

            if(var1.equalsIgnoreCase(XItemContainer.method178(var3.previousName, Client.field518))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-794796897"
   )
   static final int method765(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = var2 * (789221 + var2 * var2 * 15731) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I[BLclass137;B)V",
      garbageValue = "16"
   )
   static void method766(int var0, byte[] var1, class137 var2) {
      class172 var3 = new class172();
      var3.field2758 = 0;
      var3.hash = (long)var0;
      var3.field2757 = var1;
      var3.field2750 = var2;
      Deque var4 = class173.field2760;
      synchronized(class173.field2760) {
         class173.field2760.method3801(var3);
      }

      SecondaryBufferProvider.method1647();
   }
}
