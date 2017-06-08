import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 44212577
   )
   int field3364;
   @ObfuscatedName("i")
   public static NodeCache field3365;
   @ObfuscatedName("j")
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -883000509
   )
   public int field3367;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 133754693
   )
   public int field3368;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1442381863
   )
   public int field3369;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1078140419
   )
   public int field3370;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1727769847
   )
   public int field3371;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1990109727
   )
   public int field3372;
   @ObfuscatedName("n")
   public static IndexDataBase field3373;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1610620871
   )
   int field3374;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 83565071
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 251308715
   )
   public int field3376;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "130460096"
   )
   public void method4414(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4415(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "428180556"
   )
   void method4415(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3368 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3369 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3371 = 0;
      } else if(var2 == 5) {
         this.field3370 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3364 = var1.method3338();
      } else if(var2 == 8) {
         this.field3374 = var1.method3338();
      } else if(var2 == 11) {
         this.field3371 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3376 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-38"
   )
   public SpritePixels method4416() {
      if(this.field3374 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3374);
         if(var1 != null) {
            return var1;
         } else {
            var1 = WallObject.method2876(class5.field40, this.field3374, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3374);
            }

            return var1;
         }
      }
   }

   public CombatInfo2() {
      this.field3368 = 255;
      this.field3369 = 255;
      this.field3371 = -1;
      this.field3372 = 1;
      this.field3370 = 70;
      this.field3364 = -1;
      this.field3374 = -1;
      this.healthScale = 30;
      this.field3376 = 0;
   }

   static {
      field3365 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1117458151"
   )
   public SpritePixels method4422() {
      if(this.field3364 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3364);
         if(var1 != null) {
            return var1;
         } else {
            var1 = WallObject.method2876(class5.field40, this.field3364, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3364);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1280051711"
   )
   static final void method4423() {
      for(Projectile var0 = (Projectile)Client.projectiles.method3622(); var0 != null; var0 = (Projectile)Client.projectiles.method3608()) {
         if(class92.plane == var0.floor && Client.gameCycle <= var0.field1460) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method1726(var1.x, var1.y, class181.method3424(var1.x, var1.y, var0.floor) - var0.field1473, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class168.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method1726(var3.x, var3.y, class181.method3424(var3.x, var3.y, var0.floor) - var0.field1473, Client.gameCycle);
                  }
               }

               var0.method1727(Client.field990);
               class61.region.method2686(class92.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field1456, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
