import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("eo")
   static ModIcon[] field1540;
   @ObfuscatedName("ds")
   @Export("region")
   static Region region;
   @ObfuscatedName("dr")
   static int[] field1542;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 253578329
   )
   @Export("modelHeight")
   public int modelHeight = 1000;
   @ObfuscatedName("mk")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   @ObfuscatedName("cs")
   void vmethod1886(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(null != var10) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1886(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2063755858"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-2128338253"
   )
   static void method1892(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class205.method3818(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class205.method3818(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2374((long)var1.id);
      if(null != var5) {
         int var6 = var5.id;
         if(class103.method1973(var6)) {
            class205.method3818(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
