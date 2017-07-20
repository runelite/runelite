import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class223 {
   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2024907259"
   )
   static final void method3979(boolean var0) {
      Client.field1027 = 0;
      Client.pendingNpcFlagsCount = 0;
      class225.method3982();
      IndexDataBase.method4093(var0);
      class48.method690();

      int var1;
      for(var1 = 0; var1 < Client.field1027; ++var1) {
         int var2 = Client.field1028[var1];
         if(Client.cachedNPCs[var2].field1258 != Client.gameCycle) {
            Client.cachedNPCs[var2].composition = null;
            Client.cachedNPCs[var2] = null;
         }
      }

      if(Client.packetLength != Client.secretPacketBuffer2.offset) {
         throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
      } else {
         for(var1 = 0; var1 < Client.field953; ++var1) {
            if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.field953);
            }
         }

      }
   }
}
