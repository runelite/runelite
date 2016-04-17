import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class127 {
   @ObfuscatedName("eq")
   static class78[] field2044;
   @ObfuscatedName("cz")
   static class143 field2047;

   @ObfuscatedName("tz")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZS)V",
      garbageValue = "7977"
   )
   protected static final void method2938(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class158.field2585.getGraphics();
         if(class29.field708 == null) {
            class29.field708 = new Font("Helvetica", 1, 13);
            class23.field625 = class158.field2585.getFontMetrics(class29.field708);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class37.field876, class98.field1671);
         }

         if(null == var2) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(class106.field1864 == null) {
               class106.field1864 = class158.field2585.createImage(304, 34);
            }

            Graphics var5 = class106.field1864.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, var0 * 3, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(var0 * 3 + 2, 2, 300 - 3 * var0, 30);
            var5.setFont(class29.field708);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - class23.field625.stringWidth(var1)) / 2, 22);
            var4.drawImage(class106.field1864, class37.field876 / 2 - 152, class98.field1671 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class37.field876 / 2 - 152;
            int var7 = class98.field1671 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(var6 + 2, var7 + 2, var0 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var6 + 1, var7 + 1, 301, 31);
            var4.fillRect(var0 * 3 + 2 + var6, var7 + 2, 300 - var0 * 3, 30);
            var4.setFont(class29.field708);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - class23.field625.stringWidth(var1)) / 2, 22 + var7);
         }
      } catch (Exception var9) {
         class158.field2585.repaint();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1778210427"
   )
   public static synchronized long method2941() {
      long var0 = System.currentTimeMillis();
      if(var0 < class115.field1972) {
         class115.field1970 += class115.field1972 - var0;
      }

      class115.field1972 = var0;
      return class115.field1970 + var0;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "642700870"
   )
   static final void method2942() {
      int var0 = class2.field61 * 128 + 64;
      int var1 = class12.field193 * 128 + 64;
      int var2 = class34.method816(var0, var1, class42.field1002) - class28.field692;
      if(class26.field673 < var0) {
         class26.field673 += class107.field1875 + (var0 - class26.field673) * class28.field693 / 1000;
         if(class26.field673 > var0) {
            class26.field673 = var0;
         }
      }

      if(class26.field673 > var0) {
         class26.field673 -= (class26.field673 - var0) * class28.field693 / 1000 + class107.field1875;
         if(class26.field673 < var0) {
            class26.field673 = var0;
         }
      }

      if(class46.field1070 < var2) {
         class46.field1070 += class107.field1875 + (var2 - class46.field1070) * class28.field693 / 1000;
         if(class46.field1070 > var2) {
            class46.field1070 = var2;
         }
      }

      if(class46.field1070 > var2) {
         class46.field1070 -= class107.field1875 + (class46.field1070 - var2) * class28.field693 / 1000;
         if(class46.field1070 < var2) {
            class46.field1070 = var2;
         }
      }

      if(class137.field2129 < var1) {
         class137.field2129 += class107.field1875 + class28.field693 * (var1 - class137.field2129) / 1000;
         if(class137.field2129 > var1) {
            class137.field2129 = var1;
         }
      }

      if(class137.field2129 > var1) {
         class137.field2129 -= class107.field1875 + class28.field693 * (class137.field2129 - var1) / 1000;
         if(class137.field2129 < var1) {
            class137.field2129 = var1;
         }
      }

      var0 = 64 + class16.field236 * 128;
      var1 = class175.field2903 * 128 + 64;
      var2 = class34.method816(var0, var1, class42.field1002) - class17.field266;
      int var3 = var0 - class26.field673;
      int var4 = var2 - class46.field1070;
      int var5 = var1 - class137.field2129;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class59.field1227 < var7) {
         class59.field1227 += (var7 - class59.field1227) * class167.field2665 / 1000 + class14.field227;
         if(class59.field1227 > var7) {
            class59.field1227 = var7;
         }
      }

      if(class59.field1227 > var7) {
         class59.field1227 -= class167.field2665 * (class59.field1227 - var7) / 1000 + class14.field227;
         if(class59.field1227 < var7) {
            class59.field1227 = var7;
         }
      }

      int var9 = var8 - class113.field1958;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class113.field1958 += class167.field2665 * var9 / 1000 + class14.field227;
         class113.field1958 &= 2047;
      }

      if(var9 < 0) {
         class113.field1958 -= class14.field227 + class167.field2665 * -var9 / 1000;
         class113.field1958 &= 2047;
      }

      int var10 = var8 - class113.field1958;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class113.field1958 = var8;
      }

   }
}
