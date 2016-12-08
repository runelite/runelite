import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class178 {
   @ObfuscatedName("m")
   static final class178 field2682 = new class178("BUILDLIVE", 3);
   @ObfuscatedName("b")
   static final class178 field2683 = new class178("RC", 1);
   @ObfuscatedName("g")
   static final class178 field2684 = new class178("WIP", 2);
   @ObfuscatedName("h")
   public final String field2685;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 627245535
   )
   final int field2686;
   @ObfuscatedName("o")
   static final class178 field2687 = new class178("LIVE", 0);

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class178(String var1, int var2) {
      this.field2685 = var1;
      this.field2686 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2046795927"
   )
   public static void method3192() {
      class194.field2847.reset();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)[LModIcon;",
      garbageValue = "-1877336648"
   )
   static ModIcon[] method3194(class182 var0, int var1, int var2) {
      return !Friend.method170(var0, var1, var2)?null:class194.method3462();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1275186775"
   )
   static final void method3195() {
      int var0 = 64 + class57.field1059 * 128;
      int var1 = 64 + ChatMessages.field928 * 128;
      int var2 = ChatLineBuffer.method896(var0, var1, class63.plane) - class45.field901;
      if(class110.cameraX < var0) {
         class110.cameraX += FileOnDisk.field1197 + (var0 - class110.cameraX) * class9.field73 / 1000;
         if(class110.cameraX > var0) {
            class110.cameraX = var0;
         }
      }

      if(class110.cameraX > var0) {
         class110.cameraX -= (class110.cameraX - var0) * class9.field73 / 1000 + FileOnDisk.field1197;
         if(class110.cameraX < var0) {
            class110.cameraX = var0;
         }
      }

      if(class189.cameraZ < var2) {
         class189.cameraZ += FileOnDisk.field1197 + class9.field73 * (var2 - class189.cameraZ) / 1000;
         if(class189.cameraZ > var2) {
            class189.cameraZ = var2;
         }
      }

      if(class189.cameraZ > var2) {
         class189.cameraZ -= FileOnDisk.field1197 + (class189.cameraZ - var2) * class9.field73 / 1000;
         if(class189.cameraZ < var2) {
            class189.cameraZ = var2;
         }
      }

      if(class16.cameraY < var1) {
         class16.cameraY += class9.field73 * (var1 - class16.cameraY) / 1000 + FileOnDisk.field1197;
         if(class16.cameraY > var1) {
            class16.cameraY = var1;
         }
      }

      if(class16.cameraY > var1) {
         class16.cameraY -= (class16.cameraY - var1) * class9.field73 / 1000 + FileOnDisk.field1197;
         if(class16.cameraY < var1) {
            class16.cameraY = var1;
         }
      }

      var0 = Actor.field620 * 128 + 64;
      var1 = class139.field1941 * 128 + 64;
      var2 = ChatLineBuffer.method896(var0, var1, class63.plane) - Projectile.field887;
      int var3 = var0 - class110.cameraX;
      int var4 = var2 - class189.cameraZ;
      int var5 = var1 - class16.cameraY;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(WidgetNode.cameraPitch < var7) {
         WidgetNode.cameraPitch += class161.field2151 * (var7 - WidgetNode.cameraPitch) / 1000 + class13.field148;
         if(WidgetNode.cameraPitch > var7) {
            WidgetNode.cameraPitch = var7;
         }
      }

      if(WidgetNode.cameraPitch > var7) {
         WidgetNode.cameraPitch -= class161.field2151 * (WidgetNode.cameraPitch - var7) / 1000 + class13.field148;
         if(WidgetNode.cameraPitch < var7) {
            WidgetNode.cameraPitch = var7;
         }
      }

      int var9 = var8 - class60.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class60.cameraYaw += var9 * class161.field2151 / 1000 + class13.field148;
         class60.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class60.cameraYaw -= class161.field2151 * -var9 / 1000 + class13.field148;
         class60.cameraYaw &= 2047;
      }

      int var10 = var8 - class60.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class60.cameraYaw = var8;
      }

   }
}
