import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public class class282 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   public static RSAudioPlayer field3753;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1560639067
   )
   public static int field3754;

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "59"
   )
   static final void method5026() {
      int var0 = BaseVarType.field21 * 128 + 64;
      int var1 = BoundingBox3D.field253 * 128 + 64;
      int var2 = WorldMapType2.getTileHeight(var0, var1, BoundingBox2D.plane) - Projectile.field1380;
      if(MouseInput.cameraX < var0) {
         MouseInput.cameraX = (var0 - MouseInput.cameraX) * class48.field577 / 1000 + MouseInput.cameraX + class11.field259;
         if(MouseInput.cameraX > var0) {
            MouseInput.cameraX = var0;
         }
      }

      if(MouseInput.cameraX > var0) {
         MouseInput.cameraX -= class48.field577 * (MouseInput.cameraX - var0) / 1000 + class11.field259;
         if(MouseInput.cameraX < var0) {
            MouseInput.cameraX = var0;
         }
      }

      if(GrandExchangeEvent.cameraZ < var2) {
         GrandExchangeEvent.cameraZ = (var2 - GrandExchangeEvent.cameraZ) * class48.field577 / 1000 + GrandExchangeEvent.cameraZ + class11.field259;
         if(GrandExchangeEvent.cameraZ > var2) {
            GrandExchangeEvent.cameraZ = var2;
         }
      }

      if(GrandExchangeEvent.cameraZ > var2) {
         GrandExchangeEvent.cameraZ -= class48.field577 * (GrandExchangeEvent.cameraZ - var2) / 1000 + class11.field259;
         if(GrandExchangeEvent.cameraZ < var2) {
            GrandExchangeEvent.cameraZ = var2;
         }
      }

      if(GZipDecompressor.cameraY < var1) {
         GZipDecompressor.cameraY = (var1 - GZipDecompressor.cameraY) * class48.field577 / 1000 + GZipDecompressor.cameraY + class11.field259;
         if(GZipDecompressor.cameraY > var1) {
            GZipDecompressor.cameraY = var1;
         }
      }

      if(GZipDecompressor.cameraY > var1) {
         GZipDecompressor.cameraY -= class48.field577 * (GZipDecompressor.cameraY - var1) / 1000 + class11.field259;
         if(GZipDecompressor.cameraY < var1) {
            GZipDecompressor.cameraY = var1;
         }
      }

      var0 = class1.field9 * 128 + 64;
      var1 = Buffer.field2516 * 128 + 64;
      var2 = WorldMapType2.getTileHeight(var0, var1, BoundingBox2D.plane) - GrandExchangeEvents.field273;
      int var3 = var0 - MouseInput.cameraX;
      int var4 = var2 - GrandExchangeEvent.cameraZ;
      int var5 = var1 - GZipDecompressor.cameraY;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class160.cameraPitch < var7) {
         class160.cameraPitch = (var7 - class160.cameraPitch) * FontName.field3698 / 1000 + class160.cameraPitch + class173.field2429;
         if(class160.cameraPitch > var7) {
            class160.cameraPitch = var7;
         }
      }

      if(class160.cameraPitch > var7) {
         class160.cameraPitch -= FontName.field3698 * (class160.cameraPitch - var7) / 1000 + class173.field2429;
         if(class160.cameraPitch < var7) {
            class160.cameraPitch = var7;
         }
      }

      int var9 = var8 - class240.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class240.cameraYaw = class240.cameraYaw + class173.field2429 + var9 * FontName.field3698 / 1000;
         class240.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class240.cameraYaw -= class173.field2429 + -var9 * FontName.field3698 / 1000;
         class240.cameraYaw &= 2047;
      }

      int var10 = var8 - class240.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class240.cameraYaw = var8;
      }

   }
}
