import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public class class267 {
   @ObfuscatedName("x")
   static final char[] field3648;
   @ObfuscatedName("y")
   static final char[] field3649;

   static {
      field3648 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
      field3649 = new char[]{'[', ']', '#'};
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lim;Ljava/lang/String;Ljava/lang/String;I)[Lji;",
      garbageValue = "-113345682"
   )
   public static SpritePixels[] method4867(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      SpritePixels[] var5;
      if(!WallObject.method2899(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class286.field3781];

         for(int var8 = 0; var8 < class286.field3781; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.maxWidth = class286.field3779;
            var9.maxHeight = class286.field3780;
            var9.offsetX = class270.field3666[var8];
            var9.offsetY = class286.offsetsY[var8];
            var9.width = class286.field3778[var8];
            var9.height = class286.field3782[var8];
            int var10 = var9.height * var9.width;
            byte[] var11 = class177.spritePixels[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class286.field3783[var11[var12] & 255];
            }
         }

         class229.method4093();
         var5 = var7;
      }

      return var5;
   }
}
