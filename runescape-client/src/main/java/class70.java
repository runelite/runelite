import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class70 extends class177 {
   @ObfuscatedName("nn")
   @ObfuscatedSignature(
      signature = "Llc;"
   )
   static class312 field779;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILfq;I)Z",
      garbageValue = "368840615"
   )
   protected boolean vmethod3428(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2250 && var3 == super.field2249;
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   static int method1179() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-64842753"
   )
   static final void method1177(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field820[var4] = true;
         }
      }

   }
}
