import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("MapIcon")
public class MapIcon {
   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      signature = "Lcb;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 11101833
   )
   @Export("areaId")
   public final int areaId;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public final Coordinates field510;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public final Coordinates field511;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 685445531
   )
   final int field512;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -241289191
   )
   final int field513;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   final MapLabel field516;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1475020631
   )
   @Export("screenX")
   int screenX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -840678659
   )
   @Export("screenY")
   int screenY;

   @ObfuscatedSignature(
      signature = "(ILik;Lik;Lah;)V"
   )
   MapIcon(int var1, Coordinates var2, Coordinates var3, MapLabel var4) {
      this.areaId = var1;
      this.field511 = var2;
      this.field510 = var3;
      this.field516 = var4;
      Area var5 = Area.mapAreaType[this.areaId];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field512 = var6.width;
         this.field513 = var6.height;
      } else {
         this.field512 = 0;
         this.field513 = 0;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1466409005"
   )
   boolean method585(int var1, int var2) {
      return this.method580(var1, var2)?true:this.method581(var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1680059413"
   )
   boolean method580(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.areaId];
      switch(var3.horizontalAlignment.value) {
      case 0:
         if(var1 < this.screenX - this.field512 / 2 || var1 > this.field512 / 2 + this.screenX) {
            return false;
         }
         break;
      case 1:
         if(var1 < this.screenX || var1 >= this.screenX + this.field512) {
            return false;
         }
         break;
      case 2:
         if(var1 <= this.screenX - this.field512 || var1 > this.screenX) {
            return false;
         }
      }

      switch(var3.verticalAlignment.value) {
      case 0:
         if(var2 >= this.screenY - this.field513 / 2 && var2 <= this.field513 / 2 + this.screenY) {
            break;
         }

         return false;
      case 1:
         if(var2 > this.screenY - this.field513 && var2 <= this.screenY) {
            break;
         }

         return false;
      case 2:
         if(var2 < this.screenY || var2 >= this.field513 + this.screenY) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1183710462"
   )
   boolean method581(int var1, int var2) {
      return this.field516 == null?false:(var1 >= this.screenX - this.field516.field441 / 2 && var1 <= this.field516.field441 / 2 + this.screenX?var2 >= this.screenY && var2 <= this.field516.field442 + this.screenY:false);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lfd;III)Ldr;",
      garbageValue = "-347674077"
   )
   public static final AbstractSoundSystem method590(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = AbstractSoundSystem.soundTaskDataProvider.vmethod2122();
            var3.samples = new int[256 * (AbstractSoundSystem.audioHighMemory?2:1)];
            var3.field1535 = var2;
            var3.vmethod2240();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(class190.field2496 > 0 && AbstractSoundSystem.task == null) {
               AbstractSoundSystem.task = new SoundTask();
               CombatInfo1.field1203 = Executors.newScheduledThreadPool(1);
               CombatInfo1.field1203.scheduleAtFixedRate(AbstractSoundSystem.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(AbstractSoundSystem.task != null) {
               if(AbstractSoundSystem.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               AbstractSoundSystem.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "42"
   )
   static final void method588() {
      if(class195.soundSystem1 != null) {
         class195.soundSystem1.method2210();
      }

      if(WorldComparator.soundSystem0 != null) {
         WorldComparator.soundSystem0.method2210();
      }

   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "868520532"
   )
   static void method591(int var0) {
      Client.field1059 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      if(SoundTaskDataProvider.method838() == 1) {
         class249.clientInstance.method911(765, 503);
      } else {
         class249.clientInstance.method911(7680, 2160);
      }

      if(Client.gameState >= 25) {
         PacketNode var1 = class33.method382(ClientPacket.field2427, Client.field1072.field1456);
         var1.packetBuffer.putByte(SoundTaskDataProvider.method838());
         var1.packetBuffer.putShort(WallObject.canvasWidth);
         var1.packetBuffer.putShort(GameEngine.canvasHeight);
         Client.field1072.method2073(var1);
      }

   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1954515034"
   )
   static final void method589(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method5141()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1139 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1078[var4][var5] == Client.field1043) {
                     continue;
                  }

                  Client.field1078[var4][var5] = Client.field1043;
               }

               if(!var2.composition.field3738) {
                  var3 -= Integer.MIN_VALUE;
               }

               var2.field1141 = Client.gameCycle;
               class38.region.method2877(Ignore.plane, var2.x, var2.y, class149.getTileHeight(var2.field1139 * 64 - 64 + var2.x, var2.field1139 * 64 - 64 + var2.y, Ignore.plane), var2.field1139 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1165);
            }
         }
      }

   }
}
