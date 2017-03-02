import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class8 {
   @ObfuscatedName("kw")
   static class112 field73;

   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "1716916243"
   )
   static int method112(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2428(((long)var0.id << 32) + (long)var0.index);
      return null != var1?var1.field1891:var0.field2268;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1165308152"
   )
   static final void method113(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field544; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field386[var4] = true;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "1811795072"
   )
   public static int method114(byte[] var0, int var1) {
      return Player.method255(var0, 0, var1);
   }

   class8() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[Lclass40;",
      garbageValue = "70482673"
   )
   static class40[] method115() {
      return new class40[]{class40.field810, class40.field808, class40.field807, class40.field805};
   }
}
