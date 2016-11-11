import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class130 {
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -32327265
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -1841897801
   )
   protected static int field2102;
   @ObfuscatedName("bi")
   static ModIcon field2103;

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "531630454"
   )
   static void method2850(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class14.method166(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class14.method166(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3812((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class14.method172(var6)) {
            class14.method166(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
