import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class54 {
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;I)Z",
      garbageValue = "1928821755"
   )
   public static boolean method750(IndexDataBase var0, IndexDataBase var1) {
      Area.field3376 = var1;
      if(!var0.method4508()) {
         return false;
      } else {
         Area.field3393 = var0.fileCount(35);
         Area.mapAreaType = new Area[Area.field3393];

         for(int var2 = 0; var2 < Area.field3393; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               Area.mapAreaType[var2] = new Area(var2);
               Area.mapAreaType[var2].method4680(new Buffer(var3));
               Area.mapAreaType[var2].method4682();
            }
         }

         return true;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-133828210"
   )
   public static boolean method752(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[Lki;",
      garbageValue = "2036922150"
   )
   static SpritePixels[] method753() {
      SpritePixels[] var0 = new SpritePixels[class310.field3909];

      for(int var1 = 0; var1 < class310.field3909; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class310.field3908;
         var2.maxHeight = class310.field3910;
         var2.offsetX = class219.field2698[var1];
         var2.offsetY = class263.offsetsY[var1];
         var2.width = class60.field708[var1];
         var2.height = class310.field3911[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class310.spritePixels[var1];
         var2.pixels = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.pixels[var5] = class289.field3786[var4[var5] & 255];
         }
      }

      Name.method5282();
      return var0;
   }
}
