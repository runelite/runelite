import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1081655545
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("b")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1125129413
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -66408175
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1111108697
   )
   int field864;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 824058533
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1183093791
   )
   int field866;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -448247595
   )
   int field867;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 899863845
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("ep")
   static SpritePixels[] field869;
   @ObfuscatedName("k")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("f")
   @Export("x")
   double x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1719157777
   )
   @Export("start")
   int start;
   @ObfuscatedName("q")
   @Export("z")
   double z;
   @ObfuscatedName("c")
   double field874;
   @ObfuscatedName("w")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("r")
   @Export("az")
   double az;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1287828343
   )
   int field879;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 501786799
   )
   int field880;
   @ObfuscatedName("h")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("l")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -25522829
   )
   int field883 = 0;
   @ObfuscatedName("ej")
   static SpritePixels field884;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1101762791
   )
   int field885 = 0;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -1513061899
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -690078463
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2004113237
   )
   @Export("x1")
   int x1;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "1570696153"
   )
   static void method865(Sequence var0, int var1, int var2, int var3) {
      if(Client.field532 < 50 && Client.field397 != 0) {
         if(null != var0.field3065 && var1 < var0.field3065.length) {
            int var4 = var0.field3065[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field533[Client.field532] = var5;
               Client.field534[Client.field532] = var6;
               Client.field535[Client.field532] = 0;
               Client.field537[Client.field532] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field536[Client.field532] = (var9 << 8) + (var8 << 16) + var7;
               ++Client.field532;
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2074499664"
   )
   final void method866(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = (double)this.start * var7 / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field866 - var4);
      this.field874 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field874 * this.field874 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field867 * 0.02454369D);
      }

      this.az = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-106"
   )
   final void method867(int var1) {
      this.isMoving = true;
      this.x += this.field874 * (double)var1;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += this.velocityX * (double)var1 + (double)var1 * 0.5D * this.az * (double)var1;
      this.velocityX += this.az * (double)var1;
      this.field879 = (int)(Math.atan2(this.field874, this.scalar) * 325.949D) + 1024 & 2047;
      this.field880 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field883 += var1;

         while(true) {
            do {
               do {
                  if(this.field883 <= this.animationSequence.frameLenghts[this.field885]) {
                     return;
                  }

                  this.field883 -= this.animationSequence.frameLenghts[this.field885];
                  ++this.field885;
               } while(this.field885 < this.animationSequence.frameIDs.length);

               this.field885 -= this.animationSequence.frameStep;
            } while(this.field885 >= 0 && this.field885 < this.animationSequence.frameIDs.length);

            this.field885 = 0;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      Spotanim var1 = class157.method3129(this.id);
      Model var2 = var1.method3535(this.field885);
      if(var2 == null) {
         return null;
      } else {
         var2.method1676(this.field880);
         return var2;
      }
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field866 = var7;
      this.field867 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field864 = var11;
      this.isMoving = false;
      int var12 = class157.method3129(this.id).field2797;
      if(var12 != -1) {
         this.animationSequence = TextureProvider.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2026004288"
   )
   public static boolean method874(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2197.method3358(var0)) {
         return false;
      } else {
         int var1 = Widget.field2197.method3352(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(class231.widgets[var0] == null) {
               class231.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == class231.widgets[var0][var2]) {
                  byte[] var3 = Widget.field2197.getConfigData(var0, var2);
                  if(var3 != null) {
                     class231.widgets[var0][var2] = new Widget();
                     class231.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class231.widgets[var0][var2].method3280(new Buffer(var3));
                     } else {
                        class231.widgets[var0][var2].method3281(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-655615320"
   )
   static void method875(int var0, boolean var1, int var2, boolean var3) {
      if(null != CombatInfoListHolder.worldList) {
         XGrandExchangeOffer.method68(0, CombatInfoListHolder.worldList.length - 1, var0, var1, var2, var3);
      }

   }
}
