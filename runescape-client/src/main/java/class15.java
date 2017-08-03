import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
final class class15 implements Comparator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "824781642"
   )
   int method88(class14 var1, class14 var2) {
      return var1.field279.totalQuantity < var2.field279.totalQuantity?-1:(var2.field279.totalQuantity == var1.field279.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method88((class14)var1, (class14)var2);
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-4"
   )
   static final void method89(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1086; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1088[var4] = true;
         }
      }

   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "634175299"
   )
   static void method93(int var0) {
      Client.field955 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      if(class10.method52() == 1) {
         Projectile.clientInstance.method951(765, 503);
      } else {
         Projectile.clientInstance.method951(7680, 2160);
      }

      if(Client.gameState >= 25) {
         Client.secretPacketBuffer1.putOpcode(197);
         Client.secretPacketBuffer1.putByte(class10.method52());
         Client.secretPacketBuffer1.putShort(class31.canvasWidth);
         Client.secretPacketBuffer1.putShort(class67.canvasHeight);
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2086658202"
   )
   static void method95(int var0) {
      if(var0 != -1) {
         if(class7.loadWidget(var0)) {
            Widget[] var1 = class170.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2649 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field818 = var3.field2649;
                  class92.method1743(var4, 2000000);
               }
            }

         }
      }
   }
}
