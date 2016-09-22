import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class156 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1111604509
   )
   final int field2340;
   @ObfuscatedName("d")
   static final class156 field2341 = new class156("BUILDLIVE", 3);
   @ObfuscatedName("v")
   static final class156 field2342 = new class156("RC", 1);
   @ObfuscatedName("a")
   static final class156 field2343 = new class156("LIVE", 0);
   @ObfuscatedName("z")
   public final String field2344;
   @ObfuscatedName("r")
   static final class156 field2345 = new class156("WIP", 2);

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class156(String var1, int var2) {
      this.field2344 = var1;
      this.field2340 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[BLclass137;B)V",
      garbageValue = "-125"
   )
   static void method3201(int var0, byte[] var1, class137 var2) {
      class172 var3 = new class172();
      var3.field2767 = 0;
      var3.hash = (long)var0;
      var3.field2762 = var1;
      var3.field2763 = var2;
      Deque var4 = class173.field2774;
      synchronized(class173.field2774) {
         class173.field2774.method3849(var3);
      }

      class165.method3239();
   }
}
