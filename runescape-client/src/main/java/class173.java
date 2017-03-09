import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class173 {
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-25"
   )
   static void method3269() {
      if(Client.field468) {
         Widget var0 = class40.method826(class26.field621, Client.field469);
         if(null != var0 && var0.field2278 != null) {
            class18 var1 = new class18();
            var1.field223 = var0;
            var1.field232 = var0.field2278;
            Frames.method1963(var1);
         }

         Client.field468 = false;
         class2.method36(var0);
      }
   }

   class173() throws Throwable {
      throw new Error();
   }
}
