import java.awt.Canvas;
import java.awt.Color;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public final class class214 {
   @ObfuscatedName("bl")
   @Export("indexTextures")
   static IndexData indexTextures;

   class214() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2137688012"
   )
   static void method4050() {
      XItemContainer.method169(class65.canvas);
      Canvas var0 = class65.canvas;
      var0.removeMouseListener(class115.mouse);
      var0.removeMouseMotionListener(class115.mouse);
      var0.removeFocusListener(class115.mouse);
      class115.field1801 = 0;
      if(FloorUnderlayDefinition.field2828 != null) {
         FloorUnderlayDefinition.field2828.vmethod2103(class65.canvas);
      }

      Client.field279.method2117();
      class65.canvas.setBackground(Color.black);
      class20.method214(class65.canvas);
      Canvas var1 = class65.canvas;
      var1.addMouseListener(class115.mouse);
      var1.addMouseMotionListener(class115.mouse);
      var1.addFocusListener(class115.mouse);
      if(FloorUnderlayDefinition.field2828 != null) {
         FloorUnderlayDefinition.field2828.vmethod2102(class65.canvas);
      }

      if(Client.widgetRoot != -1) {
         class15.method188(false);
      }

      GameEngine.field1779 = true;
   }
}
