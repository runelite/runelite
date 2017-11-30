import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("ar")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;I)I",
      garbageValue = "2077193301"
   )
   int method86(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method86((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgh;I)Ljava/lang/String;",
      garbageValue = "1391683018"
   )
   public static String method94(Buffer var0) {
      return class238.method4217(var0, 32767);
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-512192122"
   )
   static final void method85() {
      if(Client.field881 > 0) {
         class96.method1831();
      } else {
         Client.field892.method5047();
         Friend.setGameState(40);
         MouseInput.field685 = Client.field888.getSocket();
         Client.field888.method1873();
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "292506396"
   )
   static void method92() {
      int var0 = class94.playerIndexesCount;
      int[] var1 = class94.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         if(var1[var2] != Client.field957 && var1[var2] != Client.localInteractingIndex) {
            PendingSpawn.method1462(Client.cachedPlayers[var1[var2]], true);
         }
      }

   }
}
