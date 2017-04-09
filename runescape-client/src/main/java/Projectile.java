import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1324862265
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 388736059
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("s")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 42675943
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("bb")
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -807588315
   )
   int field878;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1662484833
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("k")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1110820447
   )
   int field881;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -763582571
   )
   int field882;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 146812267
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("d")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("q")
   @Export("x")
   double x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2121769045
   )
   @Export("start")
   int start;
   @ObfuscatedName("p")
   @Export("z")
   double z;
   @ObfuscatedName("y")
   double field888;
   @ObfuscatedName("a")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("v")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("z")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1238668177
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("x")
   @Export("az")
   double az;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 834963099
   )
   int field894;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1936773971
   )
   int field895;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -626501195
   )
   int field896 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 311026099
   )
   int field897 = 0;
   @ObfuscatedName("hl")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("qc")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = -1645018615
   )
   static int field900;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 405503663
   )
   @Export("id")
   int id;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field894 = var7;
      this.field881 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field878 = var11;
      this.isMoving = false;
      int var12 = class145.method2800(this.id).field2808;
      if(var12 != -1) {
         this.animationSequence = Friend.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1268247584"
   )
   final void method816(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.x1 + (double)this.start * var5 / var9;
         this.velocityZ = (double)this.start * var7 / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field894 + 1 - var4);
      this.field888 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field888 * this.field888 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.field881);
      }

      this.az = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      Spotanim var1 = class145.method2800(this.id);
      Model var2 = var1.method3517(this.field896);
      if(var2 == null) {
         return null;
      } else {
         var2.method1592(this.field882);
         return var2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "32"
   )
   final void method823(int var1) {
      this.isMoving = true;
      this.x += this.field888 * (double)var1;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += (double)var1 * (double)var1 * 0.5D * this.az + (double)var1 * this.velocityX;
      this.velocityX += (double)var1 * this.az;
      this.field895 = (int)(Math.atan2(this.field888, this.scalar) * 325.949D) + 1024 & 2047;
      this.field882 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field897 += var1;

         while(true) {
            do {
               do {
                  if(this.field897 <= this.animationSequence.frameLenghts[this.field896]) {
                     return;
                  }

                  this.field897 -= this.animationSequence.frameLenghts[this.field896];
                  ++this.field896;
               } while(this.field896 < this.animationSequence.frameIDs.length);

               this.field896 -= this.animationSequence.frameStep;
            } while(this.field896 >= 0 && this.field896 < this.animationSequence.frameIDs.length);

            this.field896 = 0;
         }
      }
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "1159788851"
   )
   static final void method826(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method826(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2417((long)var3.id);
               if(var4 != null) {
                  class33.method718(var4.id, var1);
               }
            }

            class18 var6;
            if(var1 == 0 && var3.field2326 != null) {
               var6 = new class18();
               var6.field207 = var3;
               var6.field199 = var3.field2326;
               class26.method565(var6);
            }

            if(var1 == 1 && var3.field2234 != null) {
               if(var3.index >= 0) {
                  Widget var5 = FaceNormal.method1932(var3.id);
                  if(var5 == null || var5.children == null || var3.index >= var5.children.length || var5.children[var3.index] != var3) {
                     continue;
                  }
               }

               var6 = new class18();
               var6.field207 = var3;
               var6.field199 = var3.field2234;
               class26.method565(var6);
            }
         }
      }

   }
}
