import java.awt.Component;
import java.util.HashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class148 {
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 299112199
   )
   static int field2038;

   static {
      new HashMap();
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "429237428"
   )
   static final void method2733(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field281; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field524[var4] = true;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "237187207"
   )
   public static void method2734(Component var0) {
      var0.removeMouseListener(class115.mouse);
      var0.removeMouseMotionListener(class115.mouse);
      var0.removeFocusListener(class115.mouse);
      class115.field1792 = 0;
   }
}
