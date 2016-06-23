import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class151 {
   @ObfuscatedName("v")
   static int[] field2253;

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-3"
   )
   static final void method3169(String var0) {
      if(!var0.equals("")) {
         client.field333.method2773(114);
         client.field333.method2654(class23.method629(var0));
         client.field333.method2545(var0);
      }
   }
}
