import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class222 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "5"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(IIII)Lbf;",
      garbageValue = "-2009344614"
   )
   static final WidgetNode method4016(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      class51.method724(var1);
      Widget var4 = class64.method1017(var0);
      ScriptEvent.method1038(var4);
      if(Client.field878 != null) {
         ScriptEvent.method1038(Client.field878);
         Client.field878 = null;
      }

      WidgetNode.method1028();
      class90.method1686(Widget.widgets[var0 >> 16], var4, false);
      class37.method479(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class64.loadWidget(var5)) {
            class19.method145(Widget.widgets[var5], 1);
         }
      }

      return var3;
   }
}
