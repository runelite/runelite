import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class237 {
   @ObfuscatedName("cn")
   public static char field3235;

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-119045192"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class186.method3767();
      ++Client.field937.field1449;
      if(Client.field937.field1449 >= 50 || var0) {
         Client.field937.field1449 = 0;
         if(!Client.socketError && Client.field937.getSocket() != null) {
            PacketNode var1 = Script.method2025(ClientPacket.field2345, Client.field937.field1454);
            Client.field937.method2044(var1);

            try {
               Client.field937.method2043();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }
}
