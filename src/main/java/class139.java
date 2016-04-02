import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ex")
public final class class139 extends Canvas {
   @ObfuscatedName("e")
   Component field2130;

   public final void update(Graphics var1) {
      this.field2130.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field2130.paint(var1);
   }

   @ObfuscatedName("k")
   static class80[] method2923() {
      class80[] var0 = new class80[class76.field1359];

      for(int var1 = 0; var1 < class76.field1359; ++var1) {
         class80 var2 = var0[var1] = new class80();
         var2.field1395 = class76.field1356;
         var2.field1392 = class76.field1354;
         var2.field1393 = class76.field1357[var1];
         var2.field1394 = class84.field1437[var1];
         var2.field1390 = class5.field86[var1];
         var2.field1391 = class76.field1355[var1];
         var2.field1396 = class215.field3152;
         var2.field1389 = class76.field1352[var1];
      }

      class30.method670();
      return var0;
   }

   class139(Component var1) {
      this.field2130 = var1;
   }
}
