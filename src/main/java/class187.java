import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class187 extends class208 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2062127595
   )
   int field3022;
   @ObfuscatedName("d")
   class181 field3023;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1488578263
   )
   int field3024;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 492460435
   )
   int field3025;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 936611119
   )
   int field3026;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1170102287
   )
   int field3027;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1651218051
   )
   int field3028;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 701696275
   )
   int field3029;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1384410989
   )
   int field3030;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 533460715
   )
   int field3031;
   @ObfuscatedName("c")
   class62 field3032;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1582348991
   )
   int field3033;
   @ObfuscatedName("w")
   class185 field3034;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 16226503
   )
   int field3035;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1195930163
   )
   int field3036;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1908912411
   )
   int field3037;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -428213481
   )
   int field3038;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1384270943
   )
   int field3039;
   @ObfuscatedName("j")
   class64 field3040;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1328501387
   )
   int field3041;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -252001389
   )
   int field3042;

   @ObfuscatedName("w")
   public static String method3824(long var0) {
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
               var8 = class162.field2638[(int)(var6 - var0 * 37L)];
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1274594158"
   )
   void method3826() {
      this.field3023 = null;
      this.field3032 = null;
      this.field3034 = null;
      this.field3040 = null;
   }
}
