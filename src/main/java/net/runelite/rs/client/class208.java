import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hh")
public final class class208 {
   @ObfuscatedName("ag")
   static void method3862() {
      int var0 = class143.field2208;
      int var1 = class143.field2209;
      int var2 = class34.field775 - class142.field2190 - var0;
      int var3 = class102.field1777 - class89.field1566 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field284.method2971();
            int var5 = 0;
            int var6 = 0;
            if(client.field574 == var4) {
               Insets var7 = client.field574.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class102.field1777);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class34.field775, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class34.field775 + var5 - var2, var6, var2, class102.field1777);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class102.field1777 + var6 - var3, class34.field775, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }
}
