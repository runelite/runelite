import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class179 implements class158 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -895923527
   )
   final int field2681;
   @ObfuscatedName("n")
   static final class179 field2682 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("g")
   static final class179 field2683 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("x")
   static final class179 field2684 = new class179("runescape", "RuneScape", 0);
   @ObfuscatedName("y")
   static final class179 field2685 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("p")
   public static final class179 field2686 = new class179("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("j")
   public final String field2687;
   @ObfuscatedName("v")
   static final class179 field2688 = new class179("game4", "Game 4", 3);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-112"
   )
   public int vmethod4107() {
      return this.field2681;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1741954768"
   )
   static void method3344(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2437((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2687 = var1;
      this.field2681 = var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1763503909"
   )
   static String method3347() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class47.field943.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-455250011"
   )
   static final void method3348(int var0, int var1) {
      if(var0 != class9.field75 || var1 != class10.field84) {
         class9.field75 = var0;
         class10.field84 = var1;
         World.setGameState(25);
         XGrandExchangeOffer.method69("Loading - please wait.", true);
         int var2 = Player.baseX;
         int var3 = SecondaryBufferProvider.baseY;
         Player.baseX = (var0 - 6) * 8;
         SecondaryBufferProvider.baseY = (var1 - 6) * 8;
         int var4 = Player.baseX - var2;
         int var5 = SecondaryBufferProvider.baseY - var3;
         var2 = Player.baseX;
         var3 = SecondaryBufferProvider.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= var4 * 128;
               var7.y -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= var4 * 128;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var17 = var19; var17 != var18; var17 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var4 + var17;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var17][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var17][var13] = null;
                  }
               }
            }
         }

         for(class25 var12 = (class25)Client.field392.method2503(); var12 != null; var12 = (class25)Client.field392.method2492()) {
            var12.field577 -= var4;
            var12.field578 -= var5;
            if(var12.field577 < 0 || var12.field578 < 0 || var12.field577 >= 104 || var12.field578 >= 104) {
               var12.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field532 = 0;
         Client.field459 = false;
         Client.field519 = -1;
         Client.field422.method2507();
         Client.projectiles.method2507();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2342();
         }

      }
   }
}
