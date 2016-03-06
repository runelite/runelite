import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
public class class189 {
   @ObfuscatedName("l")
   public static final class189 field3048 = new class189("3", "3");
   @ObfuscatedName("a")
   public static final class189 field3049 = new class189("6", "6");
   @ObfuscatedName("i")
   public static final class189 field3050 = new class189("15", "15");
   @ObfuscatedName("b")
   public static final class189 field3051 = new class189("1", "1");
   @ObfuscatedName("m")
   public static final class189 field3052 = new class189("4", "4");
   @ObfuscatedName("o")
   public static final class189 field3053 = new class189("2", "2");
   @ObfuscatedName("h")
   public static final class189 field3054 = new class189("10", "10");
   @ObfuscatedName("k")
   public static final class189 field3055 = new class189("12", "12");
   @ObfuscatedName("f")
   public static final class189 field3056 = new class189("8", "8");
   @ObfuscatedName("r")
   public static final class189 field3057 = new class189("5", "5");
   @ObfuscatedName("j")
   public static final class189 field3058 = new class189("14", "14");
   @ObfuscatedName("q")
   public static final class189 field3059 = new class189("13", "13");
   @ObfuscatedName("u")
   public static final class189 field3060 = new class189("11", "11");
   @ObfuscatedName("g")
   public static final class189 field3061 = new class189("7", "7");
   @ObfuscatedName("y")
   public final String field3062;
   @ObfuscatedName("n")
   public static final class189 field3063 = new class189("9", "9");

   class189(String var1, String var2) {
      this.field3062 = var2;
   }

   @ObfuscatedName("j")
   public static String method3702(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class161.field2655[(int)(var6 - 37L * var0)];
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
}
