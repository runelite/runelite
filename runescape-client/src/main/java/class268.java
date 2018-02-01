import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public enum class268 implements MouseWheel {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   field3605(0, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   field3602(1, 1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   field3603(2, 2);

   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1541299589
   )
   public final int field3601;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -304859995
   )
   final int field3604;

   class268(int var3, int var4) {
      this.field3601 = var3;
      this.field3604 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.field3604;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "825781285"
   )
   public static void method4897() {
      class304.classInfos = new CombatInfoList();
   }

   @ObfuscatedName("i")
   public static String method4895(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class291.field3768[(int)(var6 - var0 * 37L)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)[Lkh;",
      garbageValue = "34"
   )
   static IndexedSprite[] method4896() {
      IndexedSprite[] var0 = new IndexedSprite[class310.field3894];

      for(int var1 = 0; var1 < class310.field3894; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class310.field3891;
         var2.originalHeight = class310.field3898;
         var2.offsetX = class310.field3892[var1];
         var2.offsetY = class310.offsetsY[var1];
         var2.originalWidth = class310.field3895[var1];
         var2.height = class310.field3896[var1];
         var2.palette = class310.field3897;
         var2.pixels = class160.spritePixels[var1];
      }

      class47.method698();
      return var0;
   }
}
