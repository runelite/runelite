import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("ay")
   protected static String field888;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2100073639
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1577881435
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -15833835
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @Export("name")
   String name;
   @ObfuscatedName("o")
   @Export("sender")
   String sender;
   @ObfuscatedName("n")
   @Export(
      value = "value",
      setter = true
   )
   String value;

   @Hook("setMessage")
   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class97.field1534 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1811102058"
   )
   @Export("setMessage")
   @Hook("setMessage")
   void setMessage(int var1, String var2, String var3, String var4) {
      int var5 = ++class97.field1534 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(Lbq;ZI)V",
      garbageValue = "-732790400"
   )
   static final void method1143(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && class2.validInterfaces[var2]) {
         Coordinates.widgetIndex.method4148(var2);
         if(class268.widgets[var2] != null) {
            boolean var6 = true;

            for(var5 = 0; var5 < class268.widgets[var2].length; ++var5) {
               if(class268.widgets[var2][var5] != null) {
                  if(class268.widgets[var2][var5].type != 2) {
                     class268.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               class268.widgets[var2] = null;
            }

            class2.validInterfaces[var2] = false;
         }
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetFlags.method3628(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.method3625()) {
         if((long)var2 == (var4.hash >> 48 & 65535L)) {
            var4.unlink();
         }
      }

      Widget var7 = GZipDecompressor.method3177(var3);
      if(var7 != null) {
         class7.method34(var7);
      }

      class13.method83();
      if(Client.widgetRoot != -1) {
         var5 = Client.widgetRoot;
         if(class13.loadWidget(var5)) {
            ScriptEvent.method1133(class268.widgets[var5], 1);
         }
      }

   }
}
