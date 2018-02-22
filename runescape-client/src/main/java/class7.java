import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class7 {
   @ObfuscatedName("b")
   @Export("drawBoundingBoxes3D")
   public static boolean drawBoundingBoxes3D;
   @ObfuscatedName("q")
   @Export("drawBoundingBoxes2D")
   public static boolean drawBoundingBoxes2D;
   @ObfuscatedName("o")
   @Export("drawObjectGeometry2D")
   public static boolean drawObjectGeometry2D;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lr;"
   )
   @Export("boundingBox3DDrawMode")
   public static BoundingBox3DDrawMode boundingBox3DDrawMode;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("boundingBoxes")
   public static CombatInfoList boundingBoxes;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
      boundingBoxes = new CombatInfoList();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-752998375"
   )
   static final int method29(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
