import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public class class286 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1819207681
   )
   static int field3796;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -11790981
   )
   static int field3798;
   @ObfuscatedName("t")
   public static int[] field3799;
   @ObfuscatedName("s")
   public static int[] field3800;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -149631605
   )
   static int field3801;

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-355721289"
   )
   static final void method5141() {
      int var0 = ScriptState.menuX;
      int var1 = Coordinates.menuY;
      int var2 = WorldMapType1.menuWidth;
      int var3 = MessageNode.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4983(var0, var1, var2, var3, var4);
      Rasterizer2D.method4983(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.method4958(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      World.field1322.method4790("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class59.field748;
      int var6 = class59.field749;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         var8 = (Client.menuOptionCount - 1 - var7) * 15 + 31 + var1;
         var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         Font var10 = World.field1322;
         String var11;
         if(var7 < 0) {
            var11 = "";
         } else if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method4790(var11, var0 + 3, var8, var9, 0);
      }

      var7 = ScriptState.menuX;
      var8 = Coordinates.menuY;
      var9 = WorldMapType1.menuWidth;
      int var12 = MessageNode.menuHeight;

      for(int var13 = 0; var13 < Client.field1061; ++var13) {
         if(Client.widgetPositionX[var13] + Client.widgetBoundsWidth[var13] > var7 && Client.widgetPositionX[var13] < var7 + var9 && Client.widgetBoundsHeight[var13] + Client.widgetPositionY[var13] > var8 && Client.widgetPositionY[var13] < var12 + var8) {
            Client.field1133[var13] = true;
         }
      }

   }
}
