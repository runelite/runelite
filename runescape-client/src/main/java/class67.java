import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class67 extends class196 {
   @ObfuscatedName("m")
   String field805;
   @ObfuscatedName("e")
   short field807;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1164117199
   )
   int field809;

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "-1589650147"
   )
   static final void method1027(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1 && var2 != -1 && class18.validInterfaces[var2]) {
         class2.field15.method4043(var2);
         if(Widget.widgets[var2] != null) {
            boolean var4 = true;

            for(int var5 = 0; var5 < Widget.widgets[var2].length; ++var5) {
               if(Widget.widgets[var2][var5] != null) {
                  if(Widget.widgets[var2][var5].type != 2) {
                     Widget.widgets[var2][var5] = null;
                  } else {
                     var4 = false;
                  }
               }
            }

            if(var4) {
               Widget.widgets[var2] = null;
            }

            class18.validInterfaces[var2] = false;
         }
      }

      WorldMapType2.method512(var2);
      Widget var6 = class223.method3959(var3);
      if(var6 != null) {
         XItemContainer.method1020(var6);
      }

      DynamicObject.method1762();
      if(Client.widgetRoot != -1) {
         class4.method13(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IIIB)LWidgetNode;",
      garbageValue = "25"
   )
   static final WidgetNode method1028(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field811 = var2;
      Client.componentTable.method3426(var3, (long)var0);
      WorldMapType3.method219(var1);
      Widget var4 = class223.method3959(var0);
      XItemContainer.method1020(var4);
      if(Client.field1070 != null) {
         XItemContainer.method1020(Client.field1070);
         Client.field1070 = null;
      }

      DynamicObject.method1762();
      class95.method1670(Widget.widgets[var0 >> 16], var4, false);
      class64.method1022(var1);
      if(Client.widgetRoot != -1) {
         class4.method13(Client.widgetRoot, 1);
      }

      return var3;
   }

   class67(String var1, int var2) {
      this.field809 = (int)(class166.method2970() / 1000L);
      this.field805 = var1;
      this.field807 = (short)var2;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "1679216987"
   )
   static final void method1029(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1029(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3425((long)var3.id);
               if(var4 != null) {
                  class4.method13(var4.id, var1);
               }
            }

            class69 var6;
            if(var1 == 0 && var3.field2761 != null) {
               var6 = new class69();
               var6.field822 = var3;
               var6.field821 = var3.field2761;
               class77.method1440(var6);
            }

            if(var1 == 1 && var3.field2762 != null) {
               if(var3.index >= 0) {
                  Widget var5 = class223.method3959(var3.id);
                  if(var5 == null || var5.children == null || var3.index >= var5.children.length || var5.children[var3.index] != var3) {
                     continue;
                  }
               }

               var6 = new class69();
               var6.field822 = var3;
               var6.field821 = var3.field2762;
               class77.method1440(var6);
            }
         }
      }

   }
}
