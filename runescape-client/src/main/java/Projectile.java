import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("Projectile")
public final class Projectile extends Entity {
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lbu;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2111080001
   )
   @Export("id")
   int id;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1038876505
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1652455041
   )
   @Export("sourceX")
   int sourceX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1421996173
   )
   @Export("sourceY")
   int sourceY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -4446033
   )
   @Export("sourceZ")
   int sourceZ;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -675081925
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 358196599
   )
   @Export("cycleStart")
   int cycleStart;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2121946763
   )
   @Export("cycleEnd")
   int cycleEnd;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -769539171
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2074328969
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 551413977
   )
   @Export("targetIndex")
   int targetIndex;
   @ObfuscatedName("k")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("n")
   @Export("x")
   double x;
   @ObfuscatedName("i")
   @Export("y")
   double y;
   @ObfuscatedName("a")
   @Export("z")
   double z;
   @ObfuscatedName("z")
   @Export("speedX")
   double speedX;
   @ObfuscatedName("j")
   @Export("speedY")
   double speedY;
   @ObfuscatedName("s")
   @Export("speed")
   double speed;
   @ObfuscatedName("t")
   @Export("speedZ")
   double speedZ;
   @ObfuscatedName("y")
   @Export("accelerationZ")
   double accelerationZ;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1281680175
   )
   @Export("yaw")
   int yaw;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2072120189
   )
   @Export("pitch")
   int pitch;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   @Export("sequenceDefinition")
   SequenceDefinition sequenceDefinition;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -377214997
   )
   @Export("frame")
   int frame;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -742871951
   )
   @Export("frameCycle")
   int frameCycle;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.frame = 0;
      this.frameCycle = 0;
      this.id = var1;
      this.plane = var2;
      this.sourceX = var3;
      this.sourceY = var4;
      this.sourceZ = var5;
      this.cycleStart = var6;
      this.cycleEnd = var7;
      this.slope = var8;
      this.startHeight = var9;
      this.targetIndex = var10;
      this.endHeight = var11;
      this.isMoving = false;
      int var12 = class50.getSpotAnimationDefinition(this.id).sequence;
      if (var12 != -1) {
         this.sequenceDefinition = WorldMapAreaData.getSequenceDefinition(var12);
      } else {
         this.sequenceDefinition = null;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-553495769"
   )
   @Export("setDestination")
   final void setDestination(int x, int y, int height, int cycle) {
      double var5;
      if (!this.isMoving) {
         var5 = (double)(x - this.sourceX);
         double var7 = (double)(y - this.sourceY);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.sourceX + var5 * (double)this.startHeight / var9;
         this.y = (double)this.sourceY + (double)this.startHeight * var7 / var9;
         this.z = (double)this.sourceZ;
      }

      var5 = (double)(this.cycleEnd + 1 - cycle);
      this.speedX = ((double)x - this.x) / var5;
      this.speedY = ((double)y - this.y) / var5;
      this.speed = Math.sqrt(this.speedY * this.speedY + this.speedX * this.speedX);
      if (!this.isMoving) {
         this.speedZ = -this.speed * Math.tan(0.02454369D * (double)this.slope);
      }

      this.accelerationZ = ((double)height - this.z - var5 * this.speedZ) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1351865817"
   )
   @Export("advance")
   final void advance(int cycles) {
      this.isMoving = true;
      this.x += this.speedX * (double)cycles;
      this.y += (double)cycles * this.speedY;
      this.z += (double)cycles * this.accelerationZ * 0.5D * (double)cycles + this.speedZ * (double)cycles;
      this.speedZ += this.accelerationZ * (double)cycles;
      this.yaw = (int)(Math.atan2(this.speedX, this.speedY) * 325.949D) + 1024 & 2047;
      this.pitch = (int)(Math.atan2(this.speedZ, this.speed) * 325.949D) & 2047;
      if (this.sequenceDefinition != null) {
         this.frameCycle += cycles;

         while (true) {
            do {
               do {
                  if (this.frameCycle <= this.sequenceDefinition.frameLengths[this.frame]) {
                     return;
                  }

                  this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
                  ++this.frame;
               } while(this.frame < this.sequenceDefinition.frameIds.length);

               this.frame -= this.sequenceDefinition.frameCount;
            } while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

            this.frame = 0;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ldu;",
      garbageValue = "-2134947096"
   )
   @Export("getModel")
   protected final Model getModel() {
      SpotAnimationDefinition var1 = class50.getSpotAnimationDefinition(this.id);
      Model var2 = var1.getModel(this.frame);
      if (var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.pitch);
         return var2;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "95"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] bytes, boolean copyArray) {
      if (bytes == null) {
         return null;
      } else {
         if (bytes.length > 136 && !AbstractByteArrayCopier.directBufferUnavailable) {
            try {
               DirectByteArrayCopier var2 = new DirectByteArrayCopier();
               var2.set(bytes);
               return var2;
            } catch (Throwable var3) {
               AbstractByteArrayCopier.directBufferUnavailable = true;
            }
         }

         return bytes;
      }
   }

   @ObfuscatedName("g")
   @Export("addEntityTagAtMouse")
   static final void addEntityTagAtMouse(long var0) {
      ViewportMouse.ViewportMouse_entityTags[++ViewportMouse.ViewportMouse_entityCount - 1] = var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "372821346"
   )
   public static void method2089() {
      WorldMapElement.WorldMapElement_cachedSprites.clear();
   }
}
