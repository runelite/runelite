import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("UserComparator10")
public class UserComparator10 extends AbstractUserComparator {
   @ObfuscatedName("m")
   @Export("__m")
   final boolean __m;

   public UserComparator10(boolean var1) {
      this.__m = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;B)I",
      garbageValue = "-15"
   )
   @Export("__m_268")
   int __m_268(Buddy var1, Buddy var2) {
      return Client.worldId == var1.world0 && var2.world0 == Client.worldId?(this.__m?var1.int2 - var2.int2:var2.int2 - var1.int2):this.__x_461(var1, var2);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.__m_268((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "653874364"
   )
   static final void method3352(boolean var0) {
      class13.playPcmPlayers();
      ++Client.packetWriter.__d;
      if(Client.packetWriter.__d >= 50 || var0) {
         Client.packetWriter.__d = 0;
         if(!Client.__client_fh && Client.packetWriter.getSocket() != null) {
            PacketBufferNode var1 = Interpreter.method1915(ClientPacket.__gs_c, Client.packetWriter.isaacCipher);
            Client.packetWriter.__q_167(var1);

            try {
               Client.packetWriter.__f_166();
            } catch (IOException var3) {
               Client.__client_fh = true;
            }
         }
      }

   }
}
