import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("d")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 931459753
   )
   int field111 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -668893331
   )
   int field112;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1275965459
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1441853025
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1754273117
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("v")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1756189983
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 867450881
   )
   int field118;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1334814437
   )
   int field119;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1711376127
   )
   @Export("start")
   int start;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 451902793
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("s")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("p")
   @Export("x")
   double x;
   @ObfuscatedName("r")
   @Export("z")
   double z;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -395946405
   )
   int field126 = 0;
   @ObfuscatedName("w")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("x")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("k")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("z")
   @Export("az")
   double az;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -256319395
   )
   int field131;
   @ObfuscatedName("f")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("bc")
   static ModIcon[] field134;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1317467379
   )
   int field135;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 813245491
   )
   @Export("id")
   int id;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1030108207
   )
   static int field137;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1083943013
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("c")
   double field140;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field118 = var7;
      this.field119 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field131 = var11;
      this.isMoving = false;
      int var12 = Sequence.method929(this.id).field1033;
      if(var12 != -1) {
         this.animationSequence = class192.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1187527285"
   )
   final void method90(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field140;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += (double)var1 * (double)var1 * 0.5D * this.az + this.velocityX * (double)var1;
      this.velocityX += this.az * (double)var1;
      this.field135 = (int)(Math.atan2(this.field140, this.scalar) * 325.949D) + 1024 & 2047;
      this.field112 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field126 += var1;

         while(true) {
            do {
               do {
                  if(this.field126 <= this.animationSequence.field1019[this.field111]) {
                     return;
                  }

                  this.field126 -= this.animationSequence.field1019[this.field111];
                  ++this.field111;
               } while(this.field111 < this.animationSequence.field1011.length);

               this.field111 -= this.animationSequence.field1012;
            } while(this.field111 >= 0 && this.field111 < this.animationSequence.field1011.length);

            this.field111 = 0;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1050401255"
   )
   protected final Model getModel() {
      class45 var1 = Sequence.method929(this.id);
      Model var2 = var1.method935(this.field111);
      if(var2 == null) {
         return null;
      } else {
         var2.method2344(this.field112);
         return var2;
      }
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(LWidget;B)I",
      garbageValue = "-101"
   )
   static int method96(Widget var0) {
      class204 var1 = (class204)Client.widgetFlags.method3812(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.field3159:var0.field2908;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1388624977"
   )
   final void method97(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + var7 * (double)this.start / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field118 + 1 - var4);
      this.field140 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field140 * this.field140);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field119 * 0.02454369D);
      }

      this.az = ((double)var3 - this.z - this.velocityX * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "783372137"
   )
   static boolean method101(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class141.field2184.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var14 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var14.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class141.field2190;
            Object[] var5 = new Object[]{(new URL(class141.field2190.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return var13 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class141.field2190.getAppletContext().showDocument(new URL(class141.field2190.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class141.field2190;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class141.field2190.getAppletContext().showDocument(new URL(class141.field2190.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
