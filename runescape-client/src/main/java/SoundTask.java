import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("at")
   static java.awt.Font field1600;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Ldf;"
   )
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2197();
            }
         }
      } catch (Exception var4) {
         AttackOption.processClientError((String)null, var4);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lei;IIII)Z",
      garbageValue = "-1199079099"
   )
   @Export("boundingBox3DContainsMouse")
   public static final boolean boundingBox3DContainsMouse(Model var0, int var1, int var2, int var3) {
      if(!IndexStoreActionHandler.method4629()) {
         return false;
      } else {
         class33.method408();
         int var4 = var0.centerX + var1;
         int var5 = var2 + var0.centerY;
         int var6 = var3 + var0.centerZ;
         int var7 = var0.extremeX;
         int var8 = var0.extremeY;
         int var9 = var0.extremeZ;
         int var10 = class132.field1919 - var4;
         int var11 = class132.field1923 - var5;
         int var12 = class132.field1924 - var6;
         return Math.abs(var10) > var7 + class20.field336?false:(Math.abs(var11) > var8 + class132.field1926?false:(Math.abs(var12) > var9 + IndexStoreActionHandler.field3399?false:(Math.abs(var12 * class37.field502 - var11 * Resampler.field1629) > var8 * IndexStoreActionHandler.field3399 + var9 * class132.field1926?false:(Math.abs(var10 * Resampler.field1629 - var12 * class132.field1925) > var7 * IndexStoreActionHandler.field3399 + var9 * class20.field336?false:Math.abs(var11 * class132.field1925 - var10 * class37.field502) <= var7 * class132.field1926 + var8 * class20.field336))));
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgc;IB)V",
      garbageValue = "-84"
   )
   public static void method2270(Buffer var0, int var1) {
      if(class167.randomDat != null) {
         try {
            class167.randomDat.seek(0L);
            class167.randomDat.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2142013726"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class265.getTileHeight(var0, var1, BoundingBox3DDrawMode.plane) - var2;
         var0 -= Player.cameraX;
         var3 -= GameObject.cameraZ;
         var1 -= class20.cameraY;
         int var4 = Graphics3D.SINE[GrandExchangeOffer.cameraPitch];
         int var5 = Graphics3D.COSINE[GrandExchangeOffer.cameraPitch];
         int var6 = Graphics3D.SINE[class28.cameraYaw];
         int var7 = Graphics3D.COSINE[class28.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var4 * var3 >> 16;
         if(var1 >= 50) {
            Client.screenX = var0 * Client.scale / var1 + Client.viewportWidth / 2;
            Client.screenY = Client.viewportHeight / 2 + var8 * Client.scale / var1;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }
}
