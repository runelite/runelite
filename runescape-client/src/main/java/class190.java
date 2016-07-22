import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class190 extends class211 {
   @ObfuscatedName("e")
   class184 field3056;
   @ObfuscatedName("d")
   class67 field3057;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1719795569
   )
   int field3058;
   @ObfuscatedName("o")
   class65 field3059;
   @ObfuscatedName("w")
   class188 field3060;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1877044257
   )
   int field3061;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1159589473
   )
   int field3062;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1872562141
   )
   int field3063;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1132693411
   )
   int field3064;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1948380181
   )
   int field3065;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -346360687
   )
   int field3066;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 24539723
   )
   int field3067;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -175797849
   )
   int field3068;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -358052609
   )
   int field3069;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 468023987
   )
   int field3070;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -803131109
   )
   int field3071;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1784325165
   )
   int field3073;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1708323471
   )
   int field3074;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1093335149
   )
   int field3075;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -588854069
   )
   int field3076;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1750996919
   )
   int field3078;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-7"
   )
   void method3797() {
      this.field3056 = null;
      this.field3059 = null;
      this.field3060 = null;
      this.field3057 = null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "-777195616"
   )
   static String method3799(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var1 * var0;
               if(var8 >= 10) {
                  var5[var6] = (char)(87 + var8);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
