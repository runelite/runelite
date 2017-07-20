import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -121819355
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 693854609
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -54453057
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("v")
   @Export("x")
   double x;
   @ObfuscatedName("a")
   double field1447;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1229887381
   )
   int field1455;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 373774797
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1377859165
   )
   int field1452;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1155683769
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("h")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1843918867
   )
   @Export("start")
   int start;
   @ObfuscatedName("e")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -639465253
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("t")
   @Export("z")
   double z;
   @ObfuscatedName("l")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("q")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 772732447
   )
   @Export("height")
   int height;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 917076865
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("y")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1260655837
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -195875603
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1389879051
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -798253739
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("animationSequence")
   Sequence animationSequence;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1455 = 0;
      this.field1452 = 0;
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.height = var5;
      this.startTime = var6;
      this.cycle = var7;
      this.slope = var8;
      this.start = var9;
      this.interacting = var10;
      this.endHeight = var11;
      this.isMoving = false;
      int var12 = class205.getSpotAnimType(this.id).field3299;
      if(var12 != -1) {
         this.animationSequence = class31.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Leo;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      Spotanim var1 = class205.getSpotAnimType(this.id);
      Model var2 = var1.method4231(this.field1455);
      if(var2 == null) {
         return null;
      } else {
         var2.method2465(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-2294"
   )
   final void method1701(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field1447;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += this.velocityX * (double)var1 + (double)var1 * (double)var1 * this.heightOffset * 0.5D;
      this.velocityX += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.field1447, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1452 += var1;

         while(true) {
            do {
               do {
                  if(this.field1452 <= this.animationSequence.frameLenghts[this.field1455]) {
                     return;
                  }

                  this.field1452 -= this.animationSequence.frameLenghts[this.field1455];
                  ++this.field1455;
               } while(this.field1455 < this.animationSequence.frameIDs.length);

               this.field1455 -= this.animationSequence.frameStep;
            } while(this.field1455 >= 0 && this.field1455 < this.animationSequence.frameIDs.length);

            this.field1455 = 0;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-729999430"
   )
   final void method1696(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + (double)this.start * var7 / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1447 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field1447 * this.field1447 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = ((double)var3 - this.z - this.velocityX * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lew;III)Ldi;",
      garbageValue = "-1415637809"
   )
   public static final AbstractSoundSystem method1704(Signlink var0, int var1, int var2) {
      if(CombatInfo1.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = class22.field332.vmethod1850();
            var3.samples = new int[(class8.highMemory?2:1) * 256];
            var3.field1599 = var2;
            var3.vmethod1948();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(class261.priority > 0 && class243.task == null) {
               class243.task = new SoundTask();
               AbstractSoundSystem.field1593 = Executors.newScheduledThreadPool(1);
               AbstractSoundSystem.field1593.scheduleAtFixedRate(class243.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class243.task != null) {
               if(class243.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class243.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
