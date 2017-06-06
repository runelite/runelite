import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class162 {
   @ObfuscatedName("v")
   public static int[][] field2322;
   @ObfuscatedName("x")
   public static int[] field2325;
   @ObfuscatedName("f")
   public static int[] field2326;
   @ObfuscatedName("e")
   public static int[][] field2329;

   static {
      field2329 = new int[128][128];
      field2322 = new int[128][128];
      field2325 = new int[4096];
      field2326 = new int[4096];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "1129006332"
   )
   public static SpritePixels[] method3053(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4125(var1);
      int var4 = var0.method4126(var3, var2);
      SpritePixels[] var5;
      if(!class7.method28(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class286.field3791];

         for(int var8 = 0; var8 < class286.field3791; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.maxWidth = class286.field3790;
            var9.maxHeight = class286.field3792;
            var9.offsetX = class286.field3793[var8];
            var9.offsetY = class266.field3657[var8];
            var9.width = class233.field3205[var8];
            var9.height = ScriptState.field779[var8];
            int var10 = var9.height * var9.width;
            byte[] var11 = IndexFile.field2307[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class4.field33[var11[var12] & 255];
            }
         }

         class251.method4451();
         var5 = var7;
      }

      return var5;
   }
}
