import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 531935843
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1196967949
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -597638975
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 715535169
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1346946317
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1773400681
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -826143231
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2038769415
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2126370605
   )
   @Export("y")
   int y;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1582224591
   )
   @Export("height")
   int height;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -420756911
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1854135211
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 127427715
   )
   @Export("drawPriority")
   int drawPriority;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Liu;",
      garbageValue = "1990757343"
   )
   public static class245 method2938(int var0) {
      class245 var1 = (class245)class245.field3314.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class21.field338.getConfigData(15, var0);
         var1 = new class245();
         if(var2 != null) {
            var1.method4326(new Buffer(var2));
         }

         class245.field3314.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(IIII)Lbb;",
      garbageValue = "501607303"
   )
   static final WidgetNode method2937(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      WidgetNode.method1093(var1);
      Widget var4 = class266.method4862(var0);
      class255.method4531(var4);
      if(Client.field1066 != null) {
         class255.method4531(Client.field1066);
         Client.field1066 = null;
      }

      class5.method11();
      Player.method1171(Item.widgets[var0 >> 16], var4, false);
      IndexData.method4242(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class10.loadWidget(var5)) {
            class31.method280(Item.widgets[var5], 1);
         }
      }

      return var3;
   }
}
