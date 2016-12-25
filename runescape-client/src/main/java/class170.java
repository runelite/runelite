import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class170 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2034990174"
   )
   @Export("calculateHeight")
   static final int calculateHeight(int var0, int var1) {
      int var2 = class8.method96('넵' + var0, var1 + 91923, 4) - 128 + (class8.method96(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (class8.method96(var0, var1, 1) - 128 >> 2);
      var2 = 35 + (int)(0.3D * (double)var2);
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1978665628"
   )
   static final void method3174(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field526 != 0 || Client.field523) {
         String var2;
         if(Client.field526 == 1 && Client.menuOptionCount < 2) {
            var2 = "Use" + " " + Client.field375 + " " + "->";
         } else if(Client.field523 && Client.menuOptionCount < 2) {
            var2 = Client.field444 + " " + Client.field327 + " " + "->";
         } else {
            var2 = class172.method3179(Client.menuOptionCount - 1);
         }

         if(Client.menuOptionCount > 2) {
            var2 = var2 + class155.method2949(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class11.field119.method3787(var2, var0 + 4, 15 + var1, 16777215, 0, Client.gameCycle / 1000);
      }
   }
}
