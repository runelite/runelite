import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class20 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1478310797
   )
   static int field336;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lak;"
   )
   @Export("scriptMapIconReference")
   static MapIconReference scriptMapIconReference;
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -248590319
   )
   @Export("cameraY")
   static int cameraY;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-15"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class95.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class95.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class95.messages.put(var5, (long)var5.id);
      class95.field1453.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "466845483"
   )
   @Export("runWidgetOnLoadListener")
   static void runWidgetOnLoadListener(int var0) {
      if(var0 != -1) {
         if(class189.loadWidget(var0)) {
            Widget[] var1 = MouseRecorder.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.onLoadListener != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.objs = var3.onLoadListener;
                  FloorUnderlayDefinition.runScript(var4, 5000000);
               }
            }

         }
      }
   }
}
