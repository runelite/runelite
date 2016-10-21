import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 68899791
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("as")
   void vmethod2373(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(null != var10) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod2373(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "3"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "827410568"
   )
   static void method1959(int var0, int var1, int var2, int var3) {
      Widget var4 = Player.method44(var0, var1);
      if(var4 != null && var4.field2879 != null) {
         class0 var5 = new class0();
         var5.field2 = var4;
         var5.field1 = var4.field2879;
         class112.method2452(var5);
      }

      Client.field484 = var3;
      Client.field434 = true;
      class32.field711 = var0;
      Client.field344 = var1;
      class221.field3210 = var2;
      MessageNode.method750(var4);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "111"
   )
   static final int method1960(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class5.tileHeights[var5][1 + var3][var4] + class5.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = var6 * class5.tileHeights[var5][var3 + 1][1 + var4] + class5.tileHeights[var5][var3][1 + var4] * (128 - var6) >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "274263161"
   )
   static final void method1961() {
      int var0 = class133.menuX;
      int var1 = class0.menuY;
      int var2 = class107.menuWidth;
      int var3 = class85.menuHeight;
      int var4 = 6116423;
      class82.method1861(var0, var1, var2, var3, var4);
      class82.method1861(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      class82.method1852(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class79.field1434.method4096("Choose Option", 3 + var0, 14 + var1, var4, -1);
      int var5 = class143.field2192;
      int var6 = class143.field2199;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = var1 + 31 + 15 * (Client.menuOptionCount - 1 - var7);
         int var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < 3 + var8) {
            var9 = 16776960;
         }

         class227 var10 = class79.field1434;
         String var11;
         if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method4096(var11, var0 + 3, var8, var9, 0);
      }

      class48.method968(class133.menuX, class0.menuY, class107.menuWidth, class85.menuHeight);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1885383615"
   )
   static int method1963(int var0) {
      MessageNode var1 = (MessageNode)class11.field167.method3881((long)var0);
      return null == var1?-1:(var1.next == class11.field174.field3150?-1:((MessageNode)var1.next).id);
   }
}
