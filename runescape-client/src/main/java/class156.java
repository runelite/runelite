import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class156 {
   @ObfuscatedName("cx")
   static class208 field2236;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -1072619655
   )
   static int field2238;
   @ObfuscatedName("bl")
   static class184 field2240;

   @ObfuscatedName("rw")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZI)V",
      garbageValue = "-853440384"
   )
   protected static final void method2955(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class107.canvas.getGraphics();
         if(WallObject.field1547 == null) {
            WallObject.field1547 = new Font("Helvetica", 1, 13);
            GameObject.field1617 = class107.canvas.getFontMetrics(WallObject.field1547);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class16.field169, class65.field1103);
         }

         if(var2 == null) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(null == class8.field71) {
               class8.field71 = class107.canvas.createImage(304, 34);
            }

            Graphics var5 = class8.field71.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, 3 * var0, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + var0 * 3, 2, 300 - var0 * 3, 30);
            var5.setFont(WallObject.field1547);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - GameObject.field1617.stringWidth(var1)) / 2, 22);
            var4.drawImage(class8.field71, class16.field169 / 2 - 152, class65.field1103 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class16.field169 / 2 - 152;
            int var7 = class65.field1103 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(2 + var6, 2 + var7, 3 * var0, 30);
            var4.setColor(Color.black);
            var4.drawRect(var6 + 1, var7 + 1, 301, 31);
            var4.fillRect(var0 * 3 + var6 + 2, var7 + 2, 300 - 3 * var0, 30);
            var4.setFont(WallObject.field1547);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - GameObject.field1617.stringWidth(var1)) / 2, var7 + 22);
         }
      } catch (Exception var9) {
         class107.canvas.repaint();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-50"
   )
   static final int method2956(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }
}
