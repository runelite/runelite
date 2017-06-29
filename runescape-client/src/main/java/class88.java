import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class88 {
   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-890638746"
   )
   static void method1714(Widget var0) {
      if(var0.field2786 == Client.field1131) {
         Client.field1132[var0.boundsIndex] = true;
      }

   }
}
