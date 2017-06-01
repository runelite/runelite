import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
final class class12 implements Comparator {
   @ObfuscatedName("c")
   public static IndexDataBase field270;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-1211669741"
   )
   int method53(class14 var1, class14 var2) {
      return var1.field288 < var2.field288?-1:(var2.field288 == var1.field288?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method53((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1535621223"
   )
   static final void method62(boolean var0) {
      WidgetNode.method1084();
      ++Client.field1109;
      if(Client.field1109 >= 50 || var0) {
         Client.field1109 = 0;
         if(!Client.field983 && ScriptState.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(235);

            try {
               ScriptState.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.field983 = true;
            }
         }

      }
   }
}
