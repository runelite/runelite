import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
final class class2 implements class0 {
   @ObfuscatedName("fj")
   @Export("region")
   static Region region;
   @ObfuscatedName("mo")
   static class156 field16;

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "16711935"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class37.font_p12full.method4751(var0, 250);
      int var6 = class37.font_p12full.method4752(var0, 250) * 13;
      Rasterizer2D.method4983(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 16777215);
      class37.font_p12full.method4788(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      Coordinates.method3911(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2);
      if(var1) {
         class43.field602.vmethod5007(0, 0);
      } else {
         int var7 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field1061; ++var11) {
            if(Client.widgetBoundsWidth[var11] + Client.widgetPositionX[var11] > var7 && Client.widgetPositionX[var11] < var7 + var9 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
               Client.field1133[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-5277"
   )
   static final int method7() {
      return Client.menuOptionCount <= 0?-1:(Client.field1075 && KeyFocusListener.field659[81] && Client.field1074 != -1?Client.field1074:Client.menuOptionCount - 1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "1564820534"
   )
   public static SpritePixels[] method8(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class8.method43(var0, var3, var4);
   }
}
