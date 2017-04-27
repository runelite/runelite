import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("Game")
public class Game implements class134 {
   @ObfuscatedName("t")
   public static final Game field2681 = new Game("game5", "Game 5", 4);
   @ObfuscatedName("c")
   public static final Game field2682 = new Game("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("n")
   public static final Game field2683 = new Game("game3", "Game 3", 2);
   @ObfuscatedName("q")
   public static final Game field2684 = new Game("game4", "Game 4", 3);
   @ObfuscatedName("u")
   @Export("name")
   public final String name;
   @ObfuscatedName("d")
   public static final Game field2688 = new Game("runescape", "RuneScape", 0);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 247768237
   )
   @Export("number")
   final int number;
   @ObfuscatedName("p")
   public static final Game field2694 = new Game("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1946751124"
   )
   public int vmethod4163() {
      return this.number;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   Game(String var1, String var2, int var3) {
      this.name = var1;
      this.number = var3;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass15;I)V",
      garbageValue = "-80951584"
   )
   static final void method3289(class15 var0) {
      if(class22.localPlayer.x >> 7 == Client.flagX && Client.flagY == class22.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class45.field891;
      int[] var2 = class45.field894;
      int var3 = var1;
      if(class15.field168 == var0 || var0 == class15.field165) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class15.field168 == var0) {
            var5 = class22.localPlayer;
            var6 = class22.localPlayer.field257 << 14;
         } else if(var0 == class15.field165) {
            var5 = Client.cachedPlayers[Client.field472];
            var6 = Client.field472 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class15.field167 == var0 && var2[var4] == Client.field472) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod737() && !var5.field263) {
            var5.field253 = false;
            if((Client.field285 && var1 > 50 || var1 > 200) && class15.field168 != var0 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field253 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field258) {
                  var5.field253 = false;
                  var5.field262 = CombatInfo1.method600(var5.x, var5.y, Client.plane);
                  class172.region.method1748(Client.plane, var5.x, var5.y, var5.field262, 60, var5, var5.angle, var6, var5.field249, var5.field252, var5.field251, var5.field254);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field497[var7][var8] == Client.field309) {
                        continue;
                     }

                     Client.field497[var7][var8] = Client.field309;
                  }

                  var5.field262 = CombatInfo1.method600(var5.x, var5.y, Client.plane);
                  class172.region.method1732(Client.plane, var5.x, var5.y, var5.field262, 60, var5, var5.angle, var6, var5.field602);
               }
            }
         }
      }

   }
}
