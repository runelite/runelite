import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("g")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -732504795
   )
   @Export("ordinal")
   public final int ordinal;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.ordinal = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lip;IIB)Lky;",
      garbageValue = "95"
   )
   public static SpritePixels method4173(IndexDataBase var0, int var1, int var2) {
      if(!class261.method4822(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class287.field3809;
         var4.maxHeight = class287.field3807;
         var4.offsetX = class287.field3808[0];
         var4.offsetY = class21.offsetsY[0];
         var4.width = class287.field3806[0];
         var4.height = class56.field700[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class227.spritePixels[0];
         var4.pixels = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.pixels[var7] = class114.field1675[var6[var7] & 255];
         }

         class249.method4493();
         return var4;
      }
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Lhj;IIII)V",
      garbageValue = "-1014087476"
   )
   static final void method4177(Widget var0, int var1, int var2, int var3) {
      class210 var4 = var0.method4076(false);
      if(var4 != null) {
         if(Client.field1148 < 3) {
            class202.compass.method5184(var1, var2, var4.field2589, var4.field2592, 25, 25, Client.mapAngle, 256, var4.field2594, var4.field2591);
         } else {
            Rasterizer2D.method5059(var1, var2, 0, var4.field2594, var4.field2591);
         }

      }
   }
}
