import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("el")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -189026053
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -246836467
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1315088577
   )
   @Export("z")
   int z;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -542108679
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lec;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Leh;IIIB)V",
      garbageValue = "3"
   )
   public static final void method2712(Model var0, int var1, int var2, int var3) {
      if(class214.boundingBox3DContainsMouse(var0, var1, var2, var3)) {
         class28.method238(var0, var1, var2, var3, -65281);
      } else if(class11.BoundingBox3DDrawMode_all == class7.boundingBox3DDrawMode) {
         class28.method238(var0, var1, var2, var3, -16776961);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-2086661375"
   )
   static String method2711(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class276.field3734[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class276.field3734[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class276.field3734[(var6 & 15) << 2 | var7 >>> 6]).append(class276.field3734[var7 & 63]);
            } else {
               var3.append(class276.field3734[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class276.field3734[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}
