import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class7 {
   @ObfuscatedName("j")
   public static boolean field227;
   @ObfuscatedName("h")
   public static boolean field228;
   @ObfuscatedName("f")
   public static boolean field229;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lm;"
   )
   public static class11 field230;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   static CombatInfoList field231;

   static {
      field227 = false;
      field228 = false;
      field229 = false;
      field230 = class11.field265;
      field231 = new CombatInfoList();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIIII[Lfc;I)V",
      garbageValue = "1014201941"
   )
   static final void method32(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class41.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Lhi;IB)Ljava/lang/String;",
      garbageValue = "58"
   )
   static String method31(Widget var0, int var1) {
      int var3 = class262.getWidgetConfig(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.field2749 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "119"
   )
   static final void method24(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class25.getTileHeight(var0, var1, class35.plane) - var2;
         var0 -= ISAACCipher.cameraX;
         var3 -= WorldMapData.cameraZ;
         var1 -= class25.cameraY;
         int var4 = Graphics3D.SINE[KeyFocusListener.cameraPitch];
         int var5 = Graphics3D.COSINE[KeyFocusListener.cameraPitch];
         int var6 = Graphics3D.SINE[class47.cameraYaw];
         int var7 = Graphics3D.COSINE[class47.cameraYaw];
         int var8 = var0 * var7 + var6 * var1 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var4 * var3 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenY = var0 * Client.scale / var1 + Client.viewportHeight / 2;
            Client.screenX = Client.viewportWidth / 2 + var8 * Client.scale / var1;
         } else {
            Client.screenY = -1;
            Client.screenX = -1;
         }

      } else {
         Client.screenY = -1;
         Client.screenX = -1;
      }
   }
}
