import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1112051935
   )
   int field60;
   @ObfuscatedName("r")
   boolean field61 = false;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -60845651
   )
   static int field63;
   @ObfuscatedName("he")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("dm")
   static int[] field66;
   @ObfuscatedName("x")
   public static String field67;
   @ObfuscatedName("t")
   static class13 field68;
   @ObfuscatedName("pj")
   static class163 field69;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 424982309
   )
   @Export("id")
   int id;

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "-1404161959"
   )
   static final WidgetNode method42(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field60 = var2;
      Client.componentTable.method3940(var3, (long)var0);
      method43(var1);
      Widget var4 = class134.method2983(var0);
      class79.method1777(var4);
      if(Client.field376 != null) {
         class79.method1777(Client.field376);
         Client.field376 = null;
      }

      class124.method2891();
      class53.method1145(Widget.widgets[var0 >> 16], var4, false);
      ItemLayer.method2291(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class14.method179(var5)) {
            class9.method134(Widget.widgets[var5], 1);
         }
      }

      return var3;
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-730269376"
   )
   static final void method43(int var0) {
      if(class14.method179(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2929 = 0;
               var3.field2930 = 0;
            }
         }
      }

   }
}
