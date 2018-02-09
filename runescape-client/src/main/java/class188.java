import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class188 {
   @ObfuscatedName("s")
   @Export("javaVendor")
   public static String javaVendor;

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1300675341"
   )
   static final void method3796(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1029[var4] = true;
         }
      }

   }
}
