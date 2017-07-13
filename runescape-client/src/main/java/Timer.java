import java.awt.Image;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("aq")
   static Image field2258;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      intValue = 2010803967
   )
   static int field2255;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2130584926"
   )
   public abstract int vmethod2980(int var1, int var2);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "9"
   )
   public abstract void vmethod2974();

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass186;IIS)I",
      garbageValue = "-9571"
   )
   static int method2973(class186 var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         WidgetConfig var3 = (WidgetConfig)var0.method3482((long)var1);
         return var3 == null?var2:var3.config;
      }
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "787611644"
   )
   static final void method2979() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class45.plane && Client.gameCycle <= var0.cycle) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method1735(var1.x, var1.y, Actor.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = Script.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method1735(var3.x, var3.y, Actor.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.method1736(Client.field982);
               class29.region.method2677(class45.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "-1891484616"
   )
   static void method2981(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class112.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1248 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1259 = 0;
         }

         if(var3 == 2) {
            var0.field1259 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class112.getAnimation(var1).forcedPriority >= class112.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1248 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1259 = 0;
         var0.field1273 = var0.queueSize;
      }

   }
}
