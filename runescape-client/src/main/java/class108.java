import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class108 {
   class108() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   static final void method2037() {
      Client.field321.method3195(158);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2334(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2335()) {
         if(var0.field178 == 0 || var0.field178 == 3) {
            class39.method768(var0, true);
         }
      }

      if(null != Client.field309) {
         class2.method28(Client.field309);
         Client.field309 = null;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;B)V",
      garbageValue = "116"
   )
   public static void method2038(class182 var0, class182 var1) {
      NPCComposition.field3008 = var0;
      NPCComposition.field2982 = var1;
   }
}
