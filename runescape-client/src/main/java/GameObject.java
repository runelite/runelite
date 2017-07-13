import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 879084215
   )
   static int field2188;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -166007035
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -222954029
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2033407771
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -523216843
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1149718661
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 196080681
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -447952619
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -316182449
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1441468757
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1827820859
   )
   @Export("height")
   int height;
   @ObfuscatedName("v")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1890287651
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 698402003
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1962356795
   )
   @Export("drawPriority")
   int drawPriority;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(IIIB)LWidgetNode;",
      garbageValue = "4"
   )
   static final WidgetNode method2891(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      class22.method168(var1);
      Widget var4 = class61.method1038(var0);
      class48.method749(var4);
      if(Client.field1070 != null) {
         class48.method749(Client.field1070);
         Client.field1070 = null;
      }

      class36.method486();
      class36.method487(Widget.widgets[var0 >> 16], var4, false);
      class229.method4069(var1);
      if(Client.widgetRoot != -1) {
         class31.method275(Client.widgetRoot, 1);
      }

      return var3;
   }
}
