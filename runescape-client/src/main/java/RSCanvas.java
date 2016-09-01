import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("es")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("r")
   Component field2197;

   public final void update(Graphics var1) {
      this.field2197.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field2197.paint(var1);
   }

   RSCanvas(Component var1) {
      this.field2197 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "84"
   )
   static final boolean method2985(int var0, int var1) {
      ObjectComposition var2 = class1.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method801(var1);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-571963411"
   )
   static void method2986() {
      class92.method2125(class129.canvas);
      Canvas var0 = class129.canvas;
      var0.removeMouseListener(class143.mouse);
      var0.removeMouseMotionListener(class143.mouse);
      var0.removeFocusListener(class143.mouse);
      class143.field2200 = 0;
      if(null != class5.field91) {
         class5.field91.vmethod3161(class129.canvas);
      }

      Client.field377.method3063();
      class129.canvas.setBackground(Color.black);
      Canvas var1 = class129.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class140.keyboard);
      var1.addFocusListener(class140.keyboard);
      class16.method188(class129.canvas);
      if(class5.field91 != null) {
         class5.field91.vmethod3166(class129.canvas);
      }

      if(Client.widgetRoot != -1) {
         int var2 = Client.widgetRoot;
         int var3 = FaceNormal.field1499;
         int var4 = class212.field3175;
         if(class175.method3419(var2)) {
            Client.method353(Widget.widgets[var2], -1, var3, var4, false);
         }
      }

      GameEngine.field2259 = true;
   }
}
