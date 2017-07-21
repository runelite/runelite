import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public class class269 {
   @ObfuscatedName("c")
   public static char[] field3660;
   @ObfuscatedName("o")
   static char[] field3663;
   @ObfuscatedName("i")
   static int[] field3658;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -2098684181
   )
   static int field3659;

   static {
      field3660 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3660[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3660[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3660[var0] = (char)(var0 + 48 - 52);
      }

      field3660[62] = 43;
      field3660[63] = 47;
      field3663 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3663[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3663[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3663[var0] = (char)(var0 + 48 - 52);
      }

      field3663[62] = 42;
      field3663[63] = 45;
      field3658 = new int[128];

      for(var0 = 0; var0 < field3658.length; ++var0) {
         field3658[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3658[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3658[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3658[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3658;
      field3658[43] = 62;
      var2[42] = 62;
      int[] var1 = field3658;
      field3658[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;Ljava/lang/String;I)[Ljj;",
      garbageValue = "948255496"
   )
   public static SpritePixels[] method4759(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      SpritePixels[] var5;
      if(!ISAACCipher.method3381(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class286.field3785];

         for(int var8 = 0; var8 < class286.field3785; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.maxWidth = class286.field3780;
            var9.maxHeight = class286.field3781;
            var9.offsetX = class286.field3782[var8];
            var9.offsetY = class286.offsetsY[var8];
            var9.width = class286.field3779[var8];
            var9.height = class286.field3787[var8];
            int var10 = var9.height * var9.width;
            byte[] var11 = class286.spritePixels[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class286.field3786[var11[var12] & 255];
            }
         }

         class286.field3782 = null;
         class286.offsetsY = null;
         class286.field3779 = null;
         class286.field3787 = null;
         class286.field3786 = null;
         class286.spritePixels = null;
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;Ljava/lang/String;I)[Ljx;",
      garbageValue = "-1153173118"
   )
   public static IndexedSprite[] method4758(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return IndexFile.method2942(var0, var3, var4);
   }
}
