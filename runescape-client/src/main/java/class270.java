import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
public final class class270 {
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1970622348"
   )
   static final void method4788() {
      Client.secretPacketBuffer1.putOpcode(128);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3435(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3429()) {
         if(var0.field811 == 0 || var0.field811 == 3) {
            class67.method1027(var0, true);
         }
      }

      if(Client.field1070 != null) {
         XItemContainer.method1020(Client.field1070);
         Client.field1070 = null;
      }

   }
}
