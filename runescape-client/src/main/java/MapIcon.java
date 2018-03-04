import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("MapIcon")
public class MapIcon {
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = -1489644035
   )
   static int field530;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 693032101
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1057046031
   )
   @Export("areaId")
   public final int areaId;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   public final Coordinates field531;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   public final Coordinates field532;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2039426363
   )
   final int field533;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1320618743
   )
   final int field534;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   final MapLabel field536;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -801573435
   )
   int field538;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1845405553
   )
   int field537;

   @ObfuscatedSignature(
      signature = "(ILic;Lic;Lai;)V"
   )
   MapIcon(int var1, Coordinates var2, Coordinates var3, MapLabel var4) {
      this.areaId = var1;
      this.field532 = var2;
      this.field531 = var3;
      this.field536 = var4;
      Area var5 = Area.mapAreaType[this.areaId];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field533 = var6.width;
         this.field534 = var6.height;
      } else {
         this.field533 = 0;
         this.field534 = 0;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-24"
   )
   boolean method548(int var1, int var2) {
      return this.method553(var1, var2)?true:this.method550(var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1226972367"
   )
   boolean method553(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.areaId];
      switch(var3.field3464.field3698) {
      case 0:
         if(var1 >= this.field538 && var1 < this.field533 + this.field538) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field538 - this.field533 / 2 && var1 <= this.field533 / 2 + this.field538) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.field538 - this.field533 || var1 > this.field538) {
            return false;
         }
      }

      switch(var3.field3463.field3436) {
      case 0:
         if(var2 >= this.field537 && var2 < this.field537 + this.field534) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field537 - this.field534 / 2 || var2 > this.field534 / 2 + this.field537) {
            return false;
         }
         break;
      case 2:
         if(var2 <= this.field537 - this.field534 || var2 > this.field537) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1180742701"
   )
   boolean method550(int var1, int var2) {
      return this.field536 == null?false:(var1 >= this.field538 - this.field536.field472 / 2 && var1 <= this.field536.field472 / 2 + this.field538?var2 >= this.field537 && var2 <= this.field536.field473 + this.field537:false);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Lgr;IB)Lgr;",
      garbageValue = "38"
   )
   @Export("forOrdinal")
   public static Enumerated forOrdinal(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "1733042415"
   )
   static final void method559(String var0, int var1) {
      PacketNode var2 = class31.method285(ClientPacket.field2405, Client.field899.field1470);
      var2.packetBuffer.putByte(class29.getLength(var0) + 1);
      var2.packetBuffer.putString(var0);
      var2.packetBuffer.putShortLE(var1);
      Client.field899.method2082(var2);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lfv;IIB)Ldg;",
      garbageValue = "-29"
   )
   public static final AbstractSoundSystem method556(Signlink var0, int var1, int var2) {
      if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = AbstractSoundSystem.soundTaskDataProvider.vmethod2149();
            var3.samples = new int[256 * (AbstractSoundSystem.audioHighMemory?2:1)];
            var3.field1549 = var2;
            var3.vmethod2257();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(GrandExchangeOffer.field309 > 0 && AbstractSoundSystem.task == null) {
               AbstractSoundSystem.task = new SoundTask();
               class250.field3015 = Executors.newScheduledThreadPool(1);
               class250.field3015.scheduleAtFixedRate(AbstractSoundSystem.task, 0L, 10L, TimeUnit.MILLISECONDS);
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

   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2022597708"
   )
   static final void method552() {
      for(int var0 = 0; var0 < Client.queuedSoundEffectCount; ++var0) {
         --Client.unknownSoundValues2[var0];
         if(Client.unknownSoundValues2[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(class178.indexCache4, Client.queuedSoundEffectIDs[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.unknownSoundValues2[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.unknownSoundValues2[var0] < 0) {
               int var2;
               if(Client.soundLocations[var0] != 0) {
                  int var3 = (Client.soundLocations[var0] & 255) * 128;
                  int var4 = Client.soundLocations[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - TotalQuantityComparator.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.soundLocations[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - TotalQuantityComparator.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.unknownSoundValues2[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field911 / var3;
               } else {
                  var2 = Client.field1084;
               }

               if(var2 > 0) {
                  RawAudioNode var10 = var9.method2168().applyResampler(class57.field673);
                  class115 var11 = class115.method2363(var10, 100, var2);
                  var11.method2366(Client.unknownSoundValues1[var0] - 1);
                  class29.field431.method2103(var11);
               }

               Client.unknownSoundValues2[var0] = -100;
            }
         } else {
            --Client.queuedSoundEffectCount;

            for(int var1 = var0; var1 < Client.queuedSoundEffectCount; ++var1) {
               Client.queuedSoundEffectIDs[var1] = Client.queuedSoundEffectIDs[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.unknownSoundValues1[var1] = Client.unknownSoundValues1[var1 + 1];
               Client.unknownSoundValues2[var1] = Client.unknownSoundValues2[var1 + 1];
               Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field970) {
         boolean var12;
         if(class229.field2694 != 0) {
            var12 = true;
         } else {
            var12 = class229.field2690.method4266();
         }

         if(!var12) {
            if(Client.field981 != 0 && Client.field1115 != -1) {
               MouseRecorder.method1095(class154.indexTrack1, Client.field1115, 0, Client.field981, false);
            }

            Client.field970 = false;
         }
      }

   }
}
