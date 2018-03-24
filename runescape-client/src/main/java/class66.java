import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class66 {
   @ObfuscatedName("fp")
   @Export("landMapFileIds")
   static int[] landMapFileIds;

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(Lcv;III)V",
      garbageValue = "-1022067648"
   )
   static final void method1149(ContextMenuRow var0, int var1, int var2) {
      class3.menuAction(var0.param0, var0.param1, var0.type, var0.identifier, var0.option, var0.option, var1, var2);
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1193369743"
   )
   static final void method1150(String var0) {
      if(KeyFocusListener.clanMemberManager != null) {
         PacketNode var1 = class33.method382(ClientPacket.field2424, Client.field1072.field1456);
         var1.packetBuffer.putByte(UnitPriceComparator.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field1072.method2073(var1);
      }
   }
}
