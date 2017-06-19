import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public enum class239 implements RSEnum {
   @ObfuscatedName("p")
   field3281(2, 0),
   @ObfuscatedName("m")
   field3283(0, 1),
   @ObfuscatedName("e")
   field3280(1, 2);

   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2118642957
   )
   final int field3279;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 778762781
   )
   public final int field3282;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field3279;
   }

   @ObfuscatedName("e")
   public static String method4141(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var4;
            char var8;
            for(var4 = new StringBuilder(var2); 0L != var0; var4.append(var8)) {
               long var5 = var0;
               var0 /= 37L;
               var8 = class268.field3673[(int)(var5 - 37L * var0)];
               if(var8 == 95) {
                  int var7 = var4.length() - 1;
                  var4.setCharAt(var7, Character.toUpperCase(var4.charAt(var7)));
                  var8 = 160;
               }
            }

            var4.reverse();
            var4.setCharAt(0, Character.toUpperCase(var4.charAt(0)));
            return var4.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   private class239(int var3, int var4) {
      this.field3282 = var3;
      this.field3279 = var4;
   }
}
