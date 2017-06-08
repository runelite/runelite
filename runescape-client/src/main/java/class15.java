import java.applet.Applet;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class15 implements Comparator {
   @ObfuscatedName("gc")
   static SpritePixels[] field297;
   @ObfuscatedName("aa")
   static java.awt.Font field298;
   @ObfuscatedName("n")
   public static Applet field304;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method107((class14)var1, (class14)var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-1268224513"
   )
   int method107(class14 var1, class14 var2) {
      return var1.field288.totalQuantity < var2.field288.totalQuantity?-1:(var2.field288.totalQuantity == var1.field288.totalQuantity?0:1);
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-1277410199"
   )
   static final void method111(String var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(141);
      Client.secretPacketBuffer1.putByte(Script.method1836(var0) + 1);
      Client.secretPacketBuffer1.method3184(var1);
      Client.secretPacketBuffer1.method3150(var0);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1310050706"
   )
   static final int method114(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-91"
   )
   static void method115(String var0, String var1, String var2) {
      class92.loginMessage1 = var0;
      class92.loginMessage2 = var1;
      class92.loginMessage3 = var2;
   }
}
