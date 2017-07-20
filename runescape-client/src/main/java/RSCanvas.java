import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1377439079
   )
   static int field660;
   @ObfuscatedName("c")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }
}
