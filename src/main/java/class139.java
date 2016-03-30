import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eu")
public final class class139 extends Canvas {
   @ObfuscatedName("c")
   static class80 field2156;
   @ObfuscatedName("w")
   Component field2161;
   @ObfuscatedName("e")
   static class80[] field2162;

   public final void update(Graphics var1) {
      this.field2161.update(var1);
   }

   class139(Component var1) {
      this.field2161 = var1;
   }

   public final void paint(Graphics var1) {
      this.field2161.paint(var1);
   }
}
