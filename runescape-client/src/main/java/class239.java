import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class239 implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2118642957
   )
   final int field3279;
   @ObfuscatedName("e")
   static final class239 field3280;
   @ObfuscatedName("p")
   static final class239 field3281;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 778762781
   )
   public final int field3282;
   @ObfuscatedName("m")
   static final class239 field3283;

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

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class268.field3673[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
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

   static {
      field3281 = new class239(2, 0);
      field3283 = new class239(0, 1);
      field3280 = new class239(1, 2);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class239(int var1, int var2) {
      this.field3282 = var1;
      this.field3279 = var2;
   }
}
