import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public final class class217 {
   @ObfuscatedName("g")
   static class182 field3166;
   @ObfuscatedName("bv")
   static class184 field3168;

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "539146294"
   )
   static int method3874(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2299((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.field1908:var0.field2239;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "771751587"
   )
   static final void method3875(int var0, int var1) {
      if(Client.field306 == 2) {
         Sequence.method3699(Client.field430 + (Client.field333 - class107.baseX << 7), (Client.field364 - XClanMember.baseY << 7) + Client.field313, Client.field311 * 2);
         if(Client.field392 > -1 && Client.gameCycle % 20 < 10) {
            class143.field2019[0].method4048(var0 + Client.field392 - 12, var1 + Client.field393 - 28);
         }

      }
   }
}
