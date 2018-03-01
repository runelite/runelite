import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class66 {
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "40"
   )
   public static final void method1082(int var0, int var1) {
      class132.Viewport_mouseX = var0;
      class132.Viewport_mouseY = var1;
      class132.Viewport_containsMouse = true;
      class132.Viewport_entityCountAtMouse = 0;
      class132.Viewport_false0 = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2065028478"
   )
   static void method1081() {
      Iterator var0 = class95.messages.iterator();

      while(var0.hasNext()) {
         MessageNode var1 = (MessageNode)var0.next();
         var1.method1103();
      }

   }
}
