import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class88 {
   @ObfuscatedName("pq")
   static Clipboard field1541;

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "738254611"
   )
   static final void method1820() {
      Client.field336.method2963(180);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2283(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2277()) {
         if(var0.field193 == 0 || var0.field193 == 3) {
            WallObject.method1832(var0, true);
         }
      }

      if(Client.field455 != null) {
         class204.method3671(Client.field455);
         Client.field455 = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)LModIcon;",
      garbageValue = "-13"
   )
   public static ModIcon method1821(class182 var0, String var1, String var2) {
      int var3 = var0.method3197(var1);
      int var4 = var0.method3198(var3, var2);
      ModIcon var5;
      if(!class37.method718(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon var7 = new ModIcon();
         var7.width = class225.field3218;
         var7.originalHeight = class225.field3219;
         var7.offsetX = class181.field2710[0];
         var7.offsetY = class225.field3220[0];
         var7.originalWidth = class119.field1865[0];
         var7.height = class109.field1742[0];
         var7.palette = class225.field3217;
         var7.pixels = class44.field888[0];
         class30.method648();
         var5 = var7;
      }

      return var5;
   }
}
