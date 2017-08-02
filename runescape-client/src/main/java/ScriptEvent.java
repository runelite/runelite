import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   class219 field830;
   @ObfuscatedName("c")
   Object[] field831;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1652123197
   )
   int field837;
   @ObfuscatedName("k")
   String field838;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -566884547
   )
   int field832;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1234268307
   )
   int field833;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   Widget field835;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1291640887
   )
   int field839;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 464674339
   )
   int field836;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1070708355
   )
   int field840;
   @ObfuscatedName("o")
   boolean field834;

   public ScriptEvent() {
      this.field830 = class219.field2768;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;B)V",
      garbageValue = "-121"
   )
   public void method1047(Object[] var1) {
      this.field831 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lhg;I)V",
      garbageValue = "-981177936"
   )
   public void method1048(class219 var1) {
      this.field830 = var1;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1654931903"
   )
   static final void method1046() {
      int var0 = class37.menuX;
      int var1 = IndexDataBase.menuY;
      int var2 = WorldMapData.menuWidth;
      int var3 = MilliTimer.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4828(var0, var1, var2, var3, var4);
      Rasterizer2D.method4828(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      Area.field3285.method4640("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = MouseInput.field730;
      int var6 = MouseInput.field731;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         var8 = var1 + (Client.menuOptionCount - 1 - var7) * 15 + 31;
         var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         Area.field3285.method4640(MessageNode.method1060(var7), var0 + 3, var8, var9, 0);
      }

      var7 = class37.menuX;
      var8 = IndexDataBase.menuY;
      var9 = WorldMapData.menuWidth;
      int var10 = MilliTimer.menuHeight;

      for(int var11 = 0; var11 < Client.field1107; ++var11) {
         if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var7 && Client.widgetPositionX[var11] < var9 + var7 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
            Client.field1064[var11] = true;
         }
      }

   }
}
