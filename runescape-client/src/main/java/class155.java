import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class155 {
   @ObfuscatedName("p")
   static String field2116;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 999829337
   )
   protected static int field2118;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -3999357000017825037L
   )
   static long field2123;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1995537132"
   )
   public static void method2927() {
      while(true) {
         Deque var1 = class183.field2733;
         class180 var0;
         synchronized(class183.field2733) {
            var0 = (class180)class183.field2730.method2332();
         }

         if(var0 == null) {
            return;
         }

         var0.field2703.method3275(var0.field2702, (int)var0.hash, var0.field2701, false);
      }
   }
}
