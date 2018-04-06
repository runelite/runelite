import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class7 {
   @ObfuscatedName("o")
   @Export("drawBoundingBoxes3D")
   public static boolean drawBoundingBoxes3D;
   @ObfuscatedName("k")
   @Export("drawBoundingBoxes2D")
   public static boolean drawBoundingBoxes2D;
   @ObfuscatedName("t")
   @Export("drawObjectGeometry2D")
   public static boolean drawObjectGeometry2D;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "La;"
   )
   @Export("boundingBox3DDrawMode")
   public static BoundingBox3DDrawMode boundingBox3DDrawMode;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   @Export("boundingBoxes")
   public static CombatInfoList boundingBoxes;
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   static Widget field234;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
      boundingBoxes = new CombatInfoList();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "186026116"
   )
   public static boolean method27(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label84: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == '-') {
                  var2 = true;
                  break label84;
               }

               if(var7 == '+') {
                  break label84;
               }
            }

            int var9;
            if(var7 >= '0' && var7 <= '9') {
               var9 = var7 - '0';
            } else if(var7 >= 'A' && var7 <= 'Z') {
               var9 = var7 - '7';
            } else {
               if(var7 < 'a' || var7 > 'z') {
                  var1 = false;
                  break;
               }

               var9 = var7 - 'W';
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var9 + var4 * 10;
            if(var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;B)V",
      garbageValue = "0"
   )
   public static void method29(IndexDataBase var0) {
      class279.field3552 = var0;
   }
}
