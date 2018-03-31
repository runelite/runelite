import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
public class class251 {
   @ObfuscatedName("nw")
   @ObfuscatedSignature(
      signature = "Llf;"
   )
   static class320 field3296;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1917448934"
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
      class95.field1434.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "([Lib;IB)V",
      garbageValue = "9"
   )
   static final void method4522(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method4522(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  DState.method3500(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.onDialogAbortListener != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.objs = var3.onDialogAbortListener;
               AbstractByteBuffer.method3757(var5);
            }

            if(var1 == 1 && var3.onSubChangeListener != null) {
               if(var3.index >= 0) {
                  Widget var6 = class3.getWidget(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.objs = var3.onSubChangeListener;
               AbstractByteBuffer.method3757(var5);
            }
         }
      }

   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "752870906"
   )
   static final void method4520(int var0) {
      if(Name.loadWidget(var0)) {
         Widget[] var1 = class189.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2837 = 0;
               var3.field2806 = 0;
            }
         }

      }
   }
}
