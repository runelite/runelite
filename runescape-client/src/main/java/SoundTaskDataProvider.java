import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements TaskDataProvider {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ldo;",
      garbageValue = "284237156"
   )
   public AbstractSoundSystem taskData() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1856578271"
   )
   static final void method763() {
      int var0 = class295.field3781 * 128 + 64;
      int var1 = class22.field322 * 128 + 64;
      int var2 = GameCanvas.getTileHeight(var0, var1, MessageNode.plane) - class60.field681;
      if(Actor.cameraX < var0) {
         Actor.cameraX = (var0 - Actor.cameraX) * WorldMapType2.field491 / 1000 + Actor.cameraX + Occluder.field2036;
         if(Actor.cameraX > var0) {
            Actor.cameraX = var0;
         }
      }

      if(Actor.cameraX > var0) {
         Actor.cameraX -= WorldMapType2.field491 * (Actor.cameraX - var0) / 1000 + Occluder.field2036;
         if(Actor.cameraX < var0) {
            Actor.cameraX = var0;
         }
      }

      if(class60.cameraZ < var2) {
         class60.cameraZ = (var2 - class60.cameraZ) * WorldMapType2.field491 / 1000 + class60.cameraZ + Occluder.field2036;
         if(class60.cameraZ > var2) {
            class60.cameraZ = var2;
         }
      }

      if(class60.cameraZ > var2) {
         class60.cameraZ -= WorldMapType2.field491 * (class60.cameraZ - var2) / 1000 + Occluder.field2036;
         if(class60.cameraZ < var2) {
            class60.cameraZ = var2;
         }
      }

      if(GameCanvas.cameraY < var1) {
         GameCanvas.cameraY = (var1 - GameCanvas.cameraY) * WorldMapType2.field491 / 1000 + GameCanvas.cameraY + Occluder.field2036;
         if(GameCanvas.cameraY > var1) {
            GameCanvas.cameraY = var1;
         }
      }

      if(GameCanvas.cameraY > var1) {
         GameCanvas.cameraY -= WorldMapType2.field491 * (GameCanvas.cameraY - var1) / 1000 + Occluder.field2036;
         if(GameCanvas.cameraY < var1) {
            GameCanvas.cameraY = var1;
         }
      }

      var0 = Script.field1409 * 128 + 64;
      var1 = Actor.field1158 * 128 + 64;
      var2 = GameCanvas.getTileHeight(var0, var1, MessageNode.plane) - KeyFocusListener.field598;
      int var3 = var0 - Actor.cameraX;
      int var4 = var2 - class60.cameraZ;
      int var5 = var1 - GameCanvas.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(SceneTilePaint.cameraPitch < var7) {
         SceneTilePaint.cameraPitch = (var7 - SceneTilePaint.cameraPitch) * GrandExchangeOffer.field294 / 1000 + SceneTilePaint.cameraPitch + class283.field3718;
         if(SceneTilePaint.cameraPitch > var7) {
            SceneTilePaint.cameraPitch = var7;
         }
      }

      if(SceneTilePaint.cameraPitch > var7) {
         SceneTilePaint.cameraPitch -= GrandExchangeOffer.field294 * (SceneTilePaint.cameraPitch - var7) / 1000 + class283.field3718;
         if(SceneTilePaint.cameraPitch < var7) {
            SceneTilePaint.cameraPitch = var7;
         }
      }

      int var9 = var8 - class33.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class33.cameraYaw = var9 * GrandExchangeOffer.field294 / 1000 + class33.cameraYaw + class283.field3718;
         class33.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class33.cameraYaw -= -var9 * GrandExchangeOffer.field294 / 1000 + class283.field3718;
         class33.cameraYaw &= 2047;
      }

      int var10 = var8 - class33.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class33.cameraYaw = var8;
      }

   }
}
