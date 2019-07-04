import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("UserComparator10")
public class UserComparator10 extends AbstractUserComparator {
   @ObfuscatedName("m")
   final boolean field932;

   public UserComparator10(boolean var1) {
      this.field932 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;B)I",
      garbageValue = "-15"
   )
   int method341(Buddy var1, Buddy var2) {
      return Client.worldId == var1.world0 && var2.world0 == Client.worldId ? (this.field932 ? var1.int2 - var2.int2 : var2.int2 - var1.int2) : this.method12(var1, var2);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.method341((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "653874364"
   )
   static final void method3352(boolean var0) {
      class13.playPcmPlayers();
      ++Client.packetWriter.field675;
      if (Client.packetWriter.field675 >= 50 || var0) {
         Client.packetWriter.field675 = 0;
         if (!Client.field176 && Client.packetWriter.getSocket() != null) {
            PacketBufferNode var1 = Interpreter.method1915(ClientPacket.field244, Client.packetWriter.isaacCipher);
            Client.packetWriter.method241(var1);

            try {
               Client.packetWriter.method240();
            } catch (IOException var3) {
               Client.field176 = true;
            }
         }
      }

   }
}
