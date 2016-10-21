import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class178 extends CacheableNode {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 912921359
   )
   public final int field2930;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1648710867
   )
   public final int field2931;
   @ObfuscatedName("n")
   public final int[] field2932;
   @ObfuscatedName("t")
   public final int[] field2933;

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1671205511"
   )
   static final void method3497(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = Renderable.method1960(var0, var1, XItemContainer.plane) - var2;
         var0 -= class139.cameraX;
         var3 -= class172.cameraZ;
         var1 -= class77.cameraY;
         int var4 = class94.field1635[class144.cameraPitch];
         int var5 = class94.field1646[class144.cameraPitch];
         int var6 = class94.field1635[Frames.cameraYaw];
         int var7 = class94.field1646[Frames.cameraYaw];
         int var8 = var7 * var0 + var1 * var6 >> 16;
         var1 = var1 * var7 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var3 * var4 + var1 * var5 >> 16;
         if(var1 >= 50) {
            Client.field387 = Client.scale * var0 / var1 + Client.camera2 / 2;
            Client.field388 = var8 * Client.scale / var1 + Client.camera3 / 2;
         } else {
            Client.field387 = -1;
            Client.field388 = -1;
         }

      } else {
         Client.field387 = -1;
         Client.field388 = -1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2078539505"
   )
   public boolean method3498(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2933.length) {
         int var3 = this.field2933[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2932[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2056601527"
   )
   public static int method3503(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   class178(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2930 = var1;
      this.field2931 = var2;
      this.field2932 = var3;
      this.field2933 = var4;
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "12390582"
   )
   static boolean method3504(Widget var0) {
      if(Client.field449) {
         if(class93.method2130(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
