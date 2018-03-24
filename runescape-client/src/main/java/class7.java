import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class7 {
   @ObfuscatedName("t")
   @Export("drawBoundingBoxes3D")
   public static boolean drawBoundingBoxes3D;
   @ObfuscatedName("q")
   @Export("drawBoundingBoxes2D")
   public static boolean drawBoundingBoxes2D;
   @ObfuscatedName("i")
   @Export("drawObjectGeometry2D")
   public static boolean drawObjectGeometry2D;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("boundingBox3DDrawMode")
   public static BoundingBox3DDrawMode boundingBox3DDrawMode;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("boundingBoxes")
   public static CombatInfoList boundingBoxes;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -606831213
   )
   static int field221;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
      boundingBoxes = new CombatInfoList();
   }
}
