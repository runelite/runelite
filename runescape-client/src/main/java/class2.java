import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class2 implements class0 {
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 1963180727
   )
   static int field11;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   public static class111 field12;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1905488383
   )
   static int field13;

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2082343765"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class289.clientInstance.method796();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field895 = 0;
            Client.field896 = 0;
            Client.field976.method4920(var0);
            if(var0 != 20) {
               class24.method172(false);
            }
         }

         if(var0 != 20 && var0 != 40 && ClanMember.field857 != null) {
            ClanMember.field857.close();
            ClanMember.field857 = null;
         }

         if(Client.gameState == 25) {
            Client.field1023 = 0;
            Client.field912 = 0;
            Client.field913 = 1;
            Client.field914 = 0;
            Client.field1088 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               GrandExchangeOffer.method114(Player.field840, Signlink.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               GrandExchangeOffer.method114(Player.field840, Signlink.indexSprites, false, 4);
            } else {
               class66.method1023();
            }
         } else {
            GrandExchangeOffer.method114(Player.field840, Signlink.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Lhx;I)Z",
      garbageValue = "1204947107"
   )
   static boolean method2(Widget var0) {
      if(Client.field1017) {
         if(class12.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
