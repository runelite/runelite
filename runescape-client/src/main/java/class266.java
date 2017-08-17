import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
public class class266 {
   @ObfuscatedName("g")
   static int[] field3647;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   static Huffman field3648;

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(Lbq;I)V",
      garbageValue = "-491906604"
   )
   static final void method4875(class66 var0) {
      if(XGrandExchangeOffer.localPlayer.x >> 7 == Client.destinationX && XGrandExchangeOffer.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      int var1 = class97.field1510;
      int[] var2 = class97.field1511;
      int var3 = var1;
      if(class66.field823 == var0 || class66.field824 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class66.field823 == var0) {
            var5 = XGrandExchangeOffer.localPlayer;
            var6 = XGrandExchangeOffer.localPlayer.field896 << 14;
         } else if(class66.field824 == var0) {
            var5 = Client.cachedPlayers[Client.field1054];
            var6 = Client.field1054 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class66.field826 == var0 && var2[var4] == Client.field1054) {
               continue;
            }
         }

         if(var5 != null && var5.hasConfig() && !var5.hidden) {
            var5.field913 = false;
            if((Client.lowMemory && var1 > 50 || var1 > 200) && class66.field823 != var0 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field913 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.field905 && Client.gameCycle < var5.field906) {
                  var5.field913 = false;
                  var5.field904 = class25.getTileHeight(var5.x, var5.y, class35.plane);
                  class36.region.method2874(class35.plane, var5.x, var5.y, var5.field904, 60, var5, var5.angle, var6, var5.field901, var5.field920, var5.field919, var5.field923);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field1028[var7][var8] == Client.field1071) {
                        continue;
                     }

                     Client.field1028[var7][var8] = Client.field1071;
                  }

                  var5.field904 = class25.getTileHeight(var5.x, var5.y, class35.plane);
                  class36.region.method2713(class35.plane, var5.x, var5.y, var5.field904, 60, var5, var5.angle, var6, var5.field1221);
               }
            }
         }
      }

   }
}
