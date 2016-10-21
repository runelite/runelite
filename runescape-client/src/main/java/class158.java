import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class158 {
   @ObfuscatedName("e")
   public static final boolean[] field2336 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("n")
   public static int[] field2340 = new int[99];

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "339661880"
   )
   static int method3187() {
      return Client.isResized?2:1;
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2340[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(IIIB)LWidgetNode;",
      garbageValue = "-10"
   )
   static final WidgetNode method3188(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field58 = var2;
      Client.componentTable.method3850(var3, (long)var0);
      class114.method2458(var1);
      Widget var4 = class153.method3170(var0);
      MessageNode.method750(var4);
      if(null != Client.field443) {
         MessageNode.method750(Client.field443);
         Client.field443 = null;
      }

      Friend.method188();
      class174.method3428(Widget.widgets[var0 >> 16], var4, false);
      class38.method765(var1);
      if(Client.widgetRoot != -1) {
         class13.method152(Client.widgetRoot, 1);
      }

      return var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "722327657"
   )
   public static SpritePixels[] method3189(class170 var0, String var1, String var2) {
      int var3 = var0.method3299(var1);
      int var4 = var0.method3361(var3, var2);
      byte[] var7 = var0.method3304(var3, var4);
      boolean var6;
      if(var7 == null) {
         var6 = false;
      } else {
         class13.method154(var7);
         var6 = true;
      }

      SpritePixels[] var5;
      if(!var6) {
         var5 = null;
      } else {
         SpritePixels[] var8 = new SpritePixels[class79.field1429];

         for(int var9 = 0; var9 < class79.field1429; ++var9) {
            SpritePixels var10 = var8[var9] = new SpritePixels();
            var10.field1462 = class79.field1430;
            var10.field1457 = class79.field1437;
            var10.field1460 = class189.field3050[var9];
            var10.field1455 = class79.field1431[var9];
            var10.width = class79.field1432[var9];
            var10.height = XItemContainer.field221[var9];
            int var11 = var10.height * var10.width;
            byte[] var12 = BufferProvider.field1450[var9];
            var10.image = new int[var11];

            for(int var13 = 0; var13 < var11; ++var13) {
               var10.image[var13] = class137.field2130[var12[var13] & 255];
            }
         }

         class14.method161();
         var5 = var8;
      }

      return var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)[Lclass155;",
      garbageValue = "120"
   )
   public static class155[] method3190() {
      return new class155[]{class155.field2314, class155.field2315, class155.field2310, class155.field2309, class155.field2308};
   }
}
