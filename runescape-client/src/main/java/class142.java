import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class142 {
   @ObfuscatedName("q")
   public static class172 field2173;

   @ObfuscatedName("ss")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZI)V",
      garbageValue = "-535089395"
   )
   protected static final void method3011(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class89.field1567.getGraphics();
         if(class25.field647 == null) {
            class25.field647 = new Font("Helvetica", 1, 13);
            class25.field652 = class89.field1567.getFontMetrics(class25.field647);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class30.field708, class153.field2274);
         }

         if(var2 == null) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(class111.field1965 == null) {
               class111.field1965 = class89.field1567.createImage(304, 34);
            }

            Graphics var5 = class111.field1965.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, 3 * var0, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + 3 * var0, 2, 300 - var0 * 3, 30);
            var5.setFont(class25.field647);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - class25.field652.stringWidth(var1)) / 2, 22);
            var4.drawImage(class111.field1965, class30.field708 / 2 - 152, class153.field2274 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class30.field708 / 2 - 152;
            int var7 = class153.field2274 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(var6 + 2, 2 + var7, 3 * var0, 30);
            var4.setColor(Color.black);
            var4.drawRect(1 + var6, 1 + var7, 301, 31);
            var4.fillRect(3 * var0 + var6 + 2, var7 + 2, 300 - var0 * 3, 30);
            var4.setFont(class25.field647);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - class25.field652.stringWidth(var1)) / 2, var7 + 22);
         }
      } catch (Exception var9) {
         class89.field1567.repaint();
      }

   }
}
