import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public final class class129 {
   @ObfuscatedName("ba")
   static class168 field2038;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1948458637"
   )
   public static void method2856() {
      try {
         class149.field2220.method4131();

         for(int var0 = 0; var0 < class149.field2216; ++var0) {
            class24.field621[var0].method4131();
         }

         class149.field2221.method4131();
         class149.field2219.method4131();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/lang/Object;I)V",
      garbageValue = "1167419847"
   )
   public static void method2857(class136 var0, Object var1) {
      if(null != var0.field2075) {
         for(int var2 = 0; var2 < 50 && var0.field2075.peekEvent() != null; ++var2) {
            class116.method2459(1L);
         }

         if(var1 != null) {
            var0.field2075.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }
}
