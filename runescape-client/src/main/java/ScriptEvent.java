import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -254845199
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("ag")
   static int[] field847;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   class220 field845;
   @ObfuscatedName("e")
   Object[] field849;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1040973181
   )
   int field837;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2118209137
   )
   int field844;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   Widget field835;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1276526145
   )
   int field848;
   @ObfuscatedName("u")
   String field840;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1344882249
   )
   int field839;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -331933383
   )
   int field841;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1309093919
   )
   int field842;
   @ObfuscatedName("n")
   boolean field834;

   public ScriptEvent() {
      this.field845 = class220.field2771;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "25335463"
   )
   public void method1113(Object[] var1) {
      this.field849 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lhc;B)V",
      garbageValue = "1"
   )
   public void method1107(class220 var1) {
      this.field845 = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)[Lhe;",
      garbageValue = "1187028191"
   )
   public static Permission[] method1111() {
      return new Permission[]{Permission.field3159, Permission.field3154, Permission.field3161, Permission.field3155, Permission.field3157, Permission.field3153};
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1185413086"
   )
   static final void method1106() {
      int var0 = class9.field248 * 128 + 64;
      int var1 = 64 + WorldMapType2.field522 * 128;
      int var2 = Friend.getTileHeight(var0, var1, class29.plane) - class36.field505;
      if(class273.cameraX < var0) {
         class273.cameraX = (var0 - class273.cameraX) * MessageNode.field874 / 1000 + class273.cameraX + class18.field315;
         if(class273.cameraX > var0) {
            class273.cameraX = var0;
         }
      }

      if(class273.cameraX > var0) {
         class273.cameraX -= MessageNode.field874 * (class273.cameraX - var0) / 1000 + class18.field315;
         if(class273.cameraX < var0) {
            class273.cameraX = var0;
         }
      }

      if(PendingSpawn.cameraZ < var2) {
         PendingSpawn.cameraZ += (var2 - PendingSpawn.cameraZ) * MessageNode.field874 / 1000 + class18.field315;
         if(PendingSpawn.cameraZ > var2) {
            PendingSpawn.cameraZ = var2;
         }
      }

      if(PendingSpawn.cameraZ > var2) {
         PendingSpawn.cameraZ -= MessageNode.field874 * (PendingSpawn.cameraZ - var2) / 1000 + class18.field315;
         if(PendingSpawn.cameraZ < var2) {
            PendingSpawn.cameraZ = var2;
         }
      }

      if(GZipDecompressor.cameraY < var1) {
         GZipDecompressor.cameraY += (var1 - GZipDecompressor.cameraY) * MessageNode.field874 / 1000 + class18.field315;
         if(GZipDecompressor.cameraY > var1) {
            GZipDecompressor.cameraY = var1;
         }
      }

      if(GZipDecompressor.cameraY > var1) {
         GZipDecompressor.cameraY -= MessageNode.field874 * (GZipDecompressor.cameraY - var1) / 1000 + class18.field315;
         if(GZipDecompressor.cameraY < var1) {
            GZipDecompressor.cameraY = var1;
         }
      }

      var0 = class158.field2239 * 128 + 64;
      var1 = class36.field510 * 128 + 64;
      var2 = Friend.getTileHeight(var0, var1, class29.plane) - class222.field2807;
      int var3 = var0 - class273.cameraX;
      int var4 = var2 - PendingSpawn.cameraZ;
      int var5 = var1 - GZipDecompressor.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class250.cameraPitch < var7) {
         class250.cameraPitch += (var7 - class250.cameraPitch) * class150.field2180 / 1000 + ISAACCipher.field2418;
         if(class250.cameraPitch > var7) {
            class250.cameraPitch = var7;
         }
      }

      if(class250.cameraPitch > var7) {
         class250.cameraPitch -= class150.field2180 * (class250.cameraPitch - var7) / 1000 + ISAACCipher.field2418;
         if(class250.cameraPitch < var7) {
            class250.cameraPitch = var7;
         }
      }

      int var9 = var8 - Player.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         Player.cameraYaw += ISAACCipher.field2418 + var9 * class150.field2180 / 1000;
         Player.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         Player.cameraYaw -= -var9 * class150.field2180 / 1000 + ISAACCipher.field2418;
         Player.cameraYaw &= 2047;
      }

      int var10 = var8 - Player.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         Player.cameraYaw = var8;
      }

   }
}
