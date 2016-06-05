import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.Replace;

@ObfuscatedName("ee")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class class139 extends Canvas {
   @ObfuscatedName("t")
   Component field2166;
   @ObfuscatedName("au")
   static class143 field2167;
   @ObfuscatedName("ak")
   static class146 field2168;
   @ObfuscatedName("g")
   public static String field2169;

   public final void update(Graphics var1) {
      this.field2166.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field2166.paint(var1);
   }

   class139(Component var1) {
      this.field2166 = var1;
   }
}
