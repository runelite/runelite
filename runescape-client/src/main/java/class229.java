import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public final class class229 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1117744906"
   )
   public static void method3989() {
      class280.field3739 = new CombatInfoList();
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1958650846"
   )
   static final void method3988() {
      Client.secretPacketBuffer1.putOpcode(170);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3492(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3493()) {
         if(var0.owner == 0 || var0.owner == 3) {
            ScriptState.method1021(var0, true);
         }
      }

      if(Client.field1068 != null) {
         class21.method156(Client.field1068);
         Client.field1068 = null;
      }

   }
}
