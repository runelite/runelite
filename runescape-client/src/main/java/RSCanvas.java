import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.Replace;

@ObfuscatedName("dk")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("l")
   static SpritePixels field1766;
   @ObfuscatedName("o")
   Component field1771;

   public final void paint(Graphics var1) {
      this.field1771.paint(var1);
   }

   RSCanvas(Component var1) {
      this.field1771 = var1;
   }

   public final void update(Graphics var1) {
      this.field1771.update(var1);
   }
}
