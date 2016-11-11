import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public final class class165 {
   @ObfuscatedName("i")
   public static final char[] field2698 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "81"
   )
   static final void method3226(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = 6 + var2;
      int var5 = class136.field2123.method4064(var0, 250);
      int var6 = class136.field2123.method4084(var0, 250) * 13;
      class82.method1853(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
      class82.method1856(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
      class136.field2123.method4071(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class144.method3021(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class164.canvas.getGraphics();
            class220.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var13) {
            class164.canvas.repaint();
         }
      } else {
         int var12 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field425; ++var11) {
            if(Client.widgetBoundsWidth[var11] + Client.widgetPositionX[var11] > var12 && Client.widgetPositionX[var11] < var12 + var9 && Client.widgetBoundsHeight[var11] + Client.widgetPositionY[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
               Client.field506[var11] = true;
            }
         }
      }

   }
}
