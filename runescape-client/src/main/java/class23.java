import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class23 {
   @ObfuscatedName("ot")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   static class115 field343;

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1453961320"
   )
   static final void method167(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1041[var4] = true;
         }
      }

   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "([Lhq;IIIZI)V",
      garbageValue = "184946789"
   )
   static void method168(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            Client.method1513(var6, var2, var3, var4);
            class218.method4083(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class160.method3094(var0, var6, var4);
            }
         }
      }

   }
}
