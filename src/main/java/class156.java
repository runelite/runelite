import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class156 {
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1991908170"
   )
   static void method3166() {
      int var0 = class144.field2198;
      int var1 = class144.field2200;
      int var2 = class38.field854 - class35.field762 - var0;
      int var3 = class51.field1132 - class21.field575 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field374.method3026();
            int var5 = 0;
            int var6 = 0;
            if(class2.field61 == var4) {
               Insets var7 = class2.field61.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class51.field1132);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class38.field854, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class38.field854 - var2, var6, var2, class51.field1132);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class51.field1132 + var6 - var3, class38.field854, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "477955655"
   )
   static void method3167() {
      client var0 = client.field374;
      synchronized(client.field374) {
         Container var1 = client.field374.method3026();
         if(var1 != null) {
            class38.field854 = Math.max(var1.getSize().width, class38.field848);
            class51.field1132 = Math.max(var1.getSize().height, class116.field1961);
            Insets var2;
            if(var1 == class2.field61) {
               var2 = class2.field61.getInsets();
               class38.field854 -= var2.left + var2.right;
               class51.field1132 -= var2.top + var2.bottom;
            }

            if(class38.field854 <= 0) {
               class38.field854 = 1;
            }

            if(class51.field1132 <= 0) {
               class51.field1132 = 1;
            }

            if(class89.method2098() == 1) {
               class35.field762 = client.field493;
               class21.field575 = client.field308 * 503;
            } else {
               class35.field762 = Math.min(class38.field854, 7680);
               class21.field575 = Math.min(class51.field1132, 2160);
            }

            class144.field2198 = (class38.field854 - class35.field762) / 2;
            class144.field2200 = 0;
            class12.field192.setSize(class35.field762, class21.field575);
            class134.field2070 = class14.method169(class35.field762, class21.field575, class12.field192);
            if(var1 == class2.field61) {
               var2 = class2.field61.getInsets();
               class12.field192.setLocation(class144.field2198 + var2.left, class144.field2200 + var2.top);
            } else {
               class12.field192.setLocation(class144.field2198, class144.field2200);
            }

            class49.method1001();
            if(-1 != client.field438) {
               int var7 = client.field438;
               int var3 = class35.field762;
               int var4 = class21.field575;
               if(class113.method2462(var7)) {
                  class51.method1062(class173.field2837[var7], -1, var3, var4, true);
               }
            }

            method3166();
         }
      }
   }
}
