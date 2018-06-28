import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class177 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static IndexDataBase field2314;

   static {
      new HashMap();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-6587"
   )
   public static int method3533(int var0) {
      return UnitPriceComparator.method59(class120.field1688[var0]);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1979749512"
   )
   public static void method3530() {
      try {
         if(class217.field2486 == 1) {
            int var0 = class217.field2485.method4228();
            if(var0 > 0 && class217.field2485.method4354()) {
               var0 -= class308.field3746;
               if(var0 < 0) {
                  var0 = 0;
               }

               class217.field2485.method4302(var0);
               return;
            }

            class217.field2485.method4236();
            class217.field2485.method4231();
            if(class26.field236 != null) {
               class217.field2486 = 2;
            } else {
               class217.field2486 = 0;
            }

            Ignore.field3644 = null;
            class59.field557 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class217.field2485.method4236();
         class217.field2486 = 0;
         Ignore.field3644 = null;
         class59.field557 = null;
         class26.field236 = null;
      }

   }
}
