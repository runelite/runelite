import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class15 {
   @ObfuscatedName("i")
   static final class15 field165 = new class15();
   @ObfuscatedName("x")
   static final class15 field167 = new class15();
   @ObfuscatedName("a")
   static final class15 field168 = new class15();
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -2082661045
   )
   static int field169;
   @ObfuscatedName("e")
   static String field170;
   @ObfuscatedName("u")
   static final class15 field172 = new class15();

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   static final void method178() {
      for(class25 var0 = (class25)Client.field545.method2391(); null != var0; var0 = (class25)Client.field545.method2393()) {
         if(var0.field577 == -1) {
            var0.field576 = 0;
            class114.method2175(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
