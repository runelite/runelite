import java.awt.Canvas;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.Replace;

@ObfuscatedName("dj")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("bf")
   protected static FontMetrics field1745;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 456955565
   )
   static int field1747;
   @ObfuscatedName("u")
   Component field1749;

   public final void paint(Graphics var1) {
      this.field1749.paint(var1);
   }

   public final void update(Graphics var1) {
      this.field1749.update(var1);
   }

   RSCanvas(Component var1) {
      this.field1749 = var1;
   }
}
