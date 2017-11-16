import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("ClanMember")
public class ClanMember extends Node {
   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "Lq;"
   )
   static class13 field855;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      longValue = -6221300841306505341L
   )
   static long field860;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1567598093
   )
   static int field854;
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   static RSSocket field857;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 1098149175
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1326284095
   )
   static int field861;
   @ObfuscatedName("b")
   @Export("username")
   String username;
   @ObfuscatedName("s")
   String field850;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 713778179
   )
   @Export("world")
   int world;
   @ObfuscatedName("g")
   @Export("rank")
   byte rank;

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "41"
   )
   static void method1102() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3592(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3593()) {
         int var1 = var0.id;
         if(class64.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class64.method1017(var4);
               if(var5 != null) {
                  ScriptEvent.method1038(var5);
               }
            }
         }
      }

   }
}
