import java.lang.management.GarbageCollectorMXBean;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
final class class19 implements Comparator {
   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("g")
   static Thread field316;
   @ObfuscatedName("aq")
   protected static GarbageCollectorMXBean field315;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lt;Lt;B)I",
      garbageValue = "-30"
   )
   int method149(class14 var1, class14 var2) {
      return var1.field275 < var2.field275?-1:(var1.field275 == var2.field275?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method149((class14)var1, (class14)var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-750141077"
   )
   public static void method140(Buffer var0, int var1) {
      if(class155.field2207 != null) {
         try {
            class155.field2207.seek(0L);
            class155.field2207.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}
