import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.Replace;

@ObfuscatedName("et")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("a")
   Component field2210;
   @ObfuscatedName("u")
   static int[] field2211;

   public final void paint(Graphics var1) {
      this.field2210.paint(var1);
   }

   public final void update(Graphics var1) {
      this.field2210.update(var1);
   }

   RSCanvas(Component var1) {
      this.field2210 = var1;
   }
}
