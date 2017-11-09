import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class222 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field2712;

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1682708790"
   )
   static final void method4145() {
      int var0 = class94.playerIndexesCount;
      int[] var1 = class94.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            ServerPacket.method3181(var3, 1);
         }
      }

   }
}
