import java.math.BigInteger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class87 {
   @ObfuscatedName("s")
   static final BigInteger field1301;
   @ObfuscatedName("g")
   static final BigInteger field1306;

   static {
      field1301 = new BigInteger("10001", 16);
      field1306 = new BigInteger("9f2df2736a57934dc9d4c77cabc70c197393b951eddb95135d2c5bade69f293a2380e019f38970da3ad83f1984cbadb17bcfbb1b3255df75b1933b65041c2c3f341e3583c9dd269ad640e71e2d80211922100b069f0fbc05c460e6f280a5c82b4c964245d1ccf1e5b0e01d1e9415e1440423696e7752d4f14ae501e4ef609589", 16);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lfy;III)Ldf;",
      garbageValue = "148524608"
   )
   public static final AbstractSoundSystem method1879(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = class27.soundTaskDataProvider.taskData();
            var3.samples = new int[256 * (CombatInfo1.audioHighMemory?2:1)];
            var3.field1549 = var2;
            var3.vmethod2282();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(class84.priority > 0 && AbstractSoundSystem.task == null) {
               AbstractSoundSystem.task = new SoundTask();
               SoundTask.field1574 = Executors.newScheduledThreadPool(1);
               SoundTask.field1574.scheduleAtFixedRate(AbstractSoundSystem.task, 0L, 10L, TimeUnit.MILLISECONDS);
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

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(ILhv;ZI)V",
      garbageValue = "1572941543"
   )
   static void method1878(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class33.method340().method5835(var0);
      int var4 = GroundObject.localPlayer.field827;
      int var5 = (GroundObject.localPlayer.x >> 7) + ClanMemberManager.baseX;
      int var6 = (GroundObject.localPlayer.y >> 7) + WorldMapData.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class33.method340().method5984(var3, var7, var1, var2);
   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1417065165"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class175.clientInstance.method835();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field874 = 0;
            Client.field875 = 0;
            Client.field888.method5530(var0);
            if(var0 != 20) {
               FaceNormal.method3113(false);
            }
         }

         if(var0 != 20 && var0 != 40 && class160.field2161 != null) {
            class160.field2161.vmethod3299();
            class160.field2161 = null;
         }

         if(Client.gameState == 25) {
            Client.field894 = 0;
            Client.field890 = 0;
            Client.field891 = 1;
            Client.field892 = 0;
            Client.field893 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class65.method1059(class65.indexCache10, class37.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class65.method1059(class65.indexCache10, class37.indexSprites, false, 4);
            } else if(class89.field1329) {
               AbstractByteBuffer.field2531 = null;
               class89.field1319 = null;
               class89.runeSprites = null;
               UnitPriceComparator.field307 = null;
               class37.field483 = null;
               class137.logoSprite = null;
               class35.titlemuteSprite = null;
               Size.field350 = null;
               class89.field1321 = null;
               class85.field1291 = null;
               class89.slFlagSprites = null;
               class89.slArrowSprites = null;
               class222.slStarSprites = null;
               VertexNormal.field1889 = null;
               KeyFocusListener.field623 = null;
               class89.field1326 = null;
               class80.field1251 = null;
               class5.field29 = null;
               class43.field547 = null;
               OwnWorldComparator.field834 = null;
               OwnWorldComparator.field838 = null;
               class31.field424 = null;
               UnitPriceComparator.method132(2);
               Timer.sendConInfo(true);
               class89.field1329 = false;
            }
         } else {
            class65.method1059(class65.indexCache10, class37.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
