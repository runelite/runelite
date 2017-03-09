import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class20 implements Runnable {
   @ObfuscatedName("d")
   int[] field247 = new int[500];
   @ObfuscatedName("x")
   boolean field249 = true;
   @ObfuscatedName("w")
   int[] field250 = new int[500];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1704887259
   )
   public static int field251;
   @ObfuscatedName("j")
   Object field253 = new Object();
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 183614743
   )
   int field254 = 0;

   public void run() {
      for(; this.field249; class140.method2660(50L)) {
         Object var1 = this.field253;
         synchronized(this.field253) {
            if(this.field254 < 500) {
               this.field247[this.field254] = class115.field1807;
               this.field250[this.field254] = class115.field1801;
               ++this.field254;
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1207545212"
   )
   public static void method222() {
      class115 var0 = class115.mouse;
      synchronized(class115.mouse) {
         class115.field1806 = class115.field1803;
         class115.field1807 = class115.field1804;
         class115.field1801 = class115.field1810;
         class115.field1813 = class115.field1809;
         class115.field1814 = class115.field1805;
         class115.field1815 = class115.field1811;
         class115.field1816 = class115.field1812;
         class115.field1809 = 0;
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-328537730"
   )
   static final void method223(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class1.method21(var0, var1, class31.plane) - var2;
         var0 -= class65.cameraX;
         var3 -= class8.cameraZ;
         var1 -= CombatInfoListHolder.cameraY;
         int var4 = class84.field1441[class25.cameraPitch];
         int var5 = class84.field1462[class25.cameraPitch];
         int var6 = class84.field1441[class108.cameraYaw];
         int var7 = class84.field1462[class108.cameraYaw];
         int var8 = var7 * var0 + var1 * var6 >> 16;
         var1 = var1 * var7 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var1 * var5 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.field355 = Client.camera2 / 2 + var0 * Client.scale / var1;
            Client.field339 = Client.camera3 / 2 + Client.scale * var8 / var1;
         } else {
            Client.field355 = -1;
            Client.field339 = -1;
         }

      } else {
         Client.field355 = -1;
         Client.field339 = -1;
      }
   }
}
