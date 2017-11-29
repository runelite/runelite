import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class7 {
   @ObfuscatedName("d")
   @Export("drawBoundingBoxes3D")
   public static boolean drawBoundingBoxes3D;
   @ObfuscatedName("x")
   @Export("drawBoundingBoxes2D")
   public static boolean drawBoundingBoxes2D;
   @ObfuscatedName("k")
   @Export("drawObjectGeometry2D")
   public static boolean drawObjectGeometry2D;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   @Export("boundingBox3DDrawMode")
   public static class11 boundingBox3DDrawMode;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("boundingBoxes")
   public static CombatInfoList boundingBoxes;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = class11.BoundingBox3DDrawMode_mouseOver;
      boundingBoxes = new CombatInfoList();
   }
}
