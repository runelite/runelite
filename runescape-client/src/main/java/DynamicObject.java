import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1174563175
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -780980641
   )
   @Export("type")
   int type;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -405492085
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -616080743
   )
   @Export("level")
   int level;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1475499661
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -718879387
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   Sequence field1454;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 815102389
   )
   @Export("animFrame")
   int animFrame;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1899582733
   )
   @Export("animCycleCount")
   int animCycleCount;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLek;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1454 = ISAACCipher.getAnimation(var7);
         this.animFrame = 0;
         this.animCycleCount = Client.gameCycle - 1;
         if(this.field1454.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1454 == this.field1454) {
               this.animFrame = var10.animFrame;
               this.animCycleCount = var10.animCycleCount;
               return;
            }
         }

         if(var8 && this.field1454.frameStep != -1) {
            this.animFrame = (int)(Math.random() * (double)this.field1454.frameIDs.length);
            this.animCycleCount -= (int)(Math.random() * (double)this.field1454.frameLengths[this.animFrame]);
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Led;",
      garbageValue = "-83"
   )
   protected final Model getModel() {
      if(this.field1454 != null) {
         int var1 = Client.gameCycle - this.animCycleCount;
         if(var1 > 100 && this.field1454.frameStep > 0) {
            var1 = 100;
         }

         label56: {
            do {
               do {
                  if(var1 <= this.field1454.frameLengths[this.animFrame]) {
                     break label56;
                  }

                  var1 -= this.field1454.frameLengths[this.animFrame];
                  ++this.animFrame;
               } while(this.animFrame < this.field1454.frameIDs.length);

               this.animFrame -= this.field1454.frameStep;
            } while(this.animFrame >= 0 && this.animFrame < this.field1454.frameIDs.length);

            this.field1454 = null;
         }

         this.animCycleCount = Client.gameCycle - var1;
      }

      ObjectComposition var12 = FileRequest.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.width;
            var3 = var12.length;
         } else {
            var2 = var12.length;
            var3 = var12.width;
         }

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class62.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var5][var6] + var8[var4][var6] + var8[var4][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method5006(this.type, this.orientation, var8, var10, var9, var11, this.field1454, this.animFrame);
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lfl;IIB)Ldz;",
      garbageValue = "0"
   )
   public static final AbstractSoundSystem method2022(Signlink var0, int var1, int var2) {
      if(class317.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = class21.soundTaskDataProvider.vmethod2095();
            var3.samples = new int[256 * (UnitPriceComparator.audioHighMemory?2:1)];
            var3.field1557 = var2;
            var3.vmethod2197();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(Coordinates.field2777 > 0 && class27.task == null) {
               class27.task = new SoundTask();
               class57.field654 = Executors.newScheduledThreadPool(1);
               class57.field654.scheduleAtFixedRate(class27.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class27.task != null) {
               if(class27.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class27.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-460983189"
   )
   static void method2019(int var0, int var1) {
      PacketNode var2 = FaceNormal.method3078(ClientPacket.field2382, Client.field902.field1475);
      var2.packetBuffer.method3648(var1);
      var2.packetBuffer.putInt(var0);
      Client.field902.method2036(var2);
   }
}
