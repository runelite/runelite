import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("Size")
public class Size {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final Size field336;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final Size field325;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final Size field326;
   @ObfuscatedName("u")
   static int[] field334;
   @ObfuscatedName("cx")
   @Export("middleMouseMovesCamera")
   static boolean middleMouseMovesCamera;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 710215009
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -1973289209
   )
   static int field340;
   @ObfuscatedName("p")
   final String field327;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 973045001
   )
   final int field337;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -830340303
   )
   final int field329;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1473976839
   )
   final int field330;

   static {
      field336 = new Size("SMALL", 2, 0, 4);
      field325 = new Size("MEDIUM", 1, 1, 2);
      field326 = new Size("LARGE", 0, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field327 = var1;
      this.field337 = var2;
      this.field329 = var3;
      this.field330 = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "1293005011"
   )
   boolean method192(float var1) {
      return var1 >= (float)this.field330;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[Ln;",
      garbageValue = "-1942349082"
   )
   static Size[] method194() {
      return new Size[]{field336, field326, field325};
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Ln;",
      garbageValue = "1291903553"
   )
   static Size method193(int var0) {
      Size[] var1 = method194();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Size var3 = var1[var2];
         if(var0 == var3.field329) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1232442184"
   )
   static final int method200(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
