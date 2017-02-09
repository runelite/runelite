import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class88 {
   @ObfuscatedName("dx")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("l")
   static int[] field1541;

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(LWidget;B)I",
      garbageValue = "-35"
   )
   static int method1872(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2331(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.field1887:var0.field2169;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1101267417"
   )
   public static void method1873() {
      while(true) {
         Deque var1 = class183.field2714;
         class180 var0;
         synchronized(class183.field2714) {
            var0 = (class180)class183.field2713.method2383();
         }

         if(var0 == null) {
            return;
         }

         var0.field2681.method3387(var0.field2683, (int)var0.hash, var0.field2682, false);
      }
   }
}
