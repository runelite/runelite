import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("e")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("t")
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("w")
   static File field1357;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "27"
   )
   void method1568(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3457(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3448()) {
         ++var6;
         if(var7.field1276 == var1) {
            var7.method1457(var1, var2, var3, var4);
            return;
         }

         if(var7.field1276 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3442(new CombatInfo1(var1, var2, var3, var4));
         }
      } else {
         CombatInfoList.method3443(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3457().unlink();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "-115200820"
   )
   CombatInfo1 method1569(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3457();
      if(var2 != null && var2.field1276 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3448(); var3 != null && var3.field1276 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3448()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field1271 + var2.field1276 + this.combatInfo2.field3379 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-45607179"
   )
   boolean method1570() {
      return this.combatInfo1.method3449();
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "-1820838163"
   )
   static final void method1572(class66 var0) {
      if(class20.localPlayer.x >> 7 == Client.detinationX && class20.localPlayer.y >> 7 == Client.destinationY) {
         Client.detinationX = 0;
      }

      int var1 = class96.field1487;
      int[] var2 = class96.field1491;
      int var3 = var1;
      if(var0 == class66.field802 || var0 == class66.field804) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class66.field802) {
            var5 = class20.localPlayer;
            var6 = class20.localPlayer.field890 << 14;
         } else if(var0 == class66.field804) {
            var5 = Client.cachedPlayers[Client.field1035];
            var6 = Client.field1035 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class66.field798 && Client.field1035 == var2[var4]) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod1593() && !var5.hidden) {
            var5.field886 = false;
            if((Client.field1055 && var1 > 50 || var1 > 200) && var0 != class66.field802 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field886 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.field871 && Client.gameCycle < var5.field882) {
                  var5.field886 = false;
                  var5.field879 = class77.method1438(var5.x, var5.y, Player.plane);
                  class17.region.method2587(Player.plane, var5.x, var5.y, var5.field879, 60, var5, var5.angle, var6, var5.field870, var5.field878, var5.field885, var5.field880);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field1010 == Client.field1009[var7][var8]) {
                        continue;
                     }

                     Client.field1009[var7][var8] = Client.field1010;
                  }

                  var5.field879 = class77.method1438(var5.x, var5.y, Player.plane);
                  class17.region.method2610(Player.plane, var5.x, var5.y, var5.field879, 60, var5, var5.angle, var6, var5.field1211);
               }
            }
         }
      }

   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)[LSpritePixels;",
      garbageValue = "1955041902"
   )
   static SpritePixels[] method1583() {
      SpritePixels[] var0 = new SpritePixels[class286.field3796];

      for(int var1 = 0; var1 < class286.field3796; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class220.field2818;
         var2.maxHeight = class286.field3792;
         var2.offsetX = class286.field3793[var1];
         var2.offsetY = class286.field3794[var1];
         var2.width = class286.field3791[var1];
         var2.height = class149.field2211[var1];
         int var3 = var2.width * var2.height;
         byte[] var4 = class286.field3797[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class116.field1686[var4[var5] & 255];
         }
      }

      class286.field3793 = null;
      class286.field3794 = null;
      class286.field3791 = null;
      class149.field2211 = null;
      class116.field1686 = null;
      class286.field3797 = (byte[][])null;
      return var0;
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1777596795"
   )
   static final void method1584(String var0) {
      if(!var0.equals("")) {
         Client.secretPacketBuffer1.putOpcode(105);
         Client.secretPacketBuffer1.putByte(Friend.method1023(var0));
         Client.secretPacketBuffer1.method3125(var0);
      }

   }
}
