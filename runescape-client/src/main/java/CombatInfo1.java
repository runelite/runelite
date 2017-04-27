import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("ag")
   static boolean field662;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1620858907
   )
   @Export("health")
   int health;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -744825579
   )
   int field665;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 548752529
   )
   int field666;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1752400569
   )
   @Export("healthRatio")
   int healthRatio;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1351626222"
   )
   public static int method596(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-893627548"
   )
   void method597(int var1, int var2, int var3, int var4) {
      this.field666 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field665 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1582648353"
   )
   static boolean method599(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1602416127"
   )
   static final int method600(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class10.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class10.tileHeights[var5][var3][var4] + class10.tileHeights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = var6 * class10.tileHeights[var5][var3 + 1][var4 + 1] + class10.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var9 * var7 + (128 - var7) * var8 >> 7;
      } else {
         return 0;
      }
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field666 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field665 = var4;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "925587630"
   )
   static final void method601(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = method600(var0, var1, Client.plane) - var2;
         var0 -= class22.cameraX;
         var3 -= class1.cameraZ;
         var1 -= class13.cameraY;
         int var4 = class84.field1433[class108.cameraPitch];
         int var5 = class84.field1441[class108.cameraPitch];
         int var6 = class84.field1433[class13.cameraYaw];
         int var7 = class84.field1441[class13.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var4 * var3 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.field388 = Client.camera2 / 2 + var0 * Client.scale / var1;
            Client.field389 = Client.camera3 / 2 + Client.scale * var8 / var1;
         } else {
            Client.field388 = -1;
            Client.field389 = -1;
         }

      } else {
         Client.field388 = -1;
         Client.field389 = -1;
      }
   }
}
