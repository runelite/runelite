import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class197 {
   @ObfuscatedName("x")
   static final int[] field2596;
   @ObfuscatedName("m")
   static final int[] field2593;

   static {
      field2596 = new int[2048];
      field2593 = new int[2048];
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         field2596[var2] = (int)(65536.0D * Math.sin((double)var2 * var0));
         field2593[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)Liw;",
      garbageValue = "3"
   )
   @Export("getWidgetChild")
   public static Widget getWidgetChild(int var0, int var1) {
      Widget var2 = class5.getWidget(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   public static void method3836() {
      class229.field2690.method4259();
      class229.field2694 = 1;
      class229.field2687 = null;
   }
}
