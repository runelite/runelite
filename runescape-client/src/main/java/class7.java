import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class7 {
   @ObfuscatedName("d")
   @Export("drawBoundingBoxes3D")
   public static boolean drawBoundingBoxes3D;
   @ObfuscatedName("z")
   @Export("drawBoundingBoxes2D")
   public static boolean drawBoundingBoxes2D;
   @ObfuscatedName("n")
   @Export("drawObjectGeometry2D")
   public static boolean drawObjectGeometry2D;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("boundingBox3DDrawMode")
   public static BoundingBox3DDrawMode boundingBox3DDrawMode;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   @Export("boundingBoxes")
   public static CombatInfoList boundingBoxes;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field235;
   @ObfuscatedName("as")
   static FontMetrics field231;
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   static Task field233;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
      boundingBoxes = new CombatInfoList();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;S)I",
      garbageValue = "-5767"
   )
   public static int method34(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1923823975"
   )
   static final boolean method35(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
