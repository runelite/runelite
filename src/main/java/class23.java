import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public final class class23 extends class208 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1074824755
   )
   int field584;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 101543379
   )
   int field585;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1854005329
   )
   int field586;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1081958283
   )
   int field587;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 787226457
   )
   int field588;
   @ObfuscatedName("r")
   class40 field589;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1130016651
   )
   int field590;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2120433459
   )
   int field591;
   @ObfuscatedName("n")
   class64 field592;
   @ObfuscatedName("j")
   static class199 field593 = new class199();
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2113374207
   )
   int field595;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1105319023
   )
   int field596;
   @ObfuscatedName("p")
   class64 field597;
   @ObfuscatedName("a")
   int[] field599;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -233888513
   )
   int field602;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-262972943"
   )
   void method588() {
      int var1 = this.field602;
      class40 var2 = this.field589.method804();
      if(var2 != null) {
         this.field602 = var2.field951;
         this.field590 = var2.field950 * 128;
         this.field596 = var2.field914;
         this.field586 = var2.field952;
         this.field599 = var2.field953;
      } else {
         this.field602 = -1;
         this.field590 = 0;
         this.field596 = 0;
         this.field586 = 0;
         this.field599 = null;
      }

      if(this.field602 != var1 && null != this.field592) {
         class135.field2066.method1133(this.field592);
         this.field592 = null;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lclass33;B)V",
      garbageValue = "50"
   )
   static final void method593(class33 var0) {
      if(client.field507 == class47.field1053.field816 >> 7 && class47.field1053.field840 >> 7 == client.field508) {
         client.field507 = 0;
      }

      int var1 = class32.field737;
      int[] var2 = class32.field738;
      int var3 = var1;
      if(var0 == class33.field760 || var0 == class33.field752) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(var0 == class33.field760) {
            var5 = class47.field1053;
            var6 = class47.field1053.field52 << 14;
         } else if(class33.field752 == var0) {
            var5 = client.field396[client.field405];
            var6 = client.field405 << 14;
         } else {
            var5 = client.field396[var2[var4]];
            var6 = var2[var4] << 14;
            if(class33.field751 == var0 && var2[var4] == client.field405) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod742() && !var5.field56) {
            var5.field35 = false;
            if((client.field303 && var1 > 50 || var1 > 200) && var0 != class33.field760 && var5.field799 == var5.field854) {
               var5.field35 = true;
            }

            int var7 = var5.field816 >> 7;
            int var8 = var5.field840 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.field49 && client.field285 >= var5.field44 && client.field285 < var5.field45) {
                  var5.field35 = false;
                  var5.field43 = class148.method3106(var5.field816, var5.field840, class28.field655);
                  class35.field771.method2017(class28.field655, var5.field816, var5.field840, var5.field43, 60, var5, var5.field796, var6, var5.field50, var5.field47, var5.field38, var5.field53);
               } else {
                  if((var5.field816 & 127) == 64 && 64 == (var5.field840 & 127)) {
                     if(client.field473 == client.field520[var7][var8]) {
                        continue;
                     }

                     client.field520[var7][var8] = client.field473;
                  }

                  var5.field43 = class148.method3106(var5.field816, var5.field840, class28.field655);
                  class35.field771.method2009(class28.field655, var5.field816, var5.field840, var5.field43, 60, var5, var5.field796, var6, var5.field843);
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "64"
   )
   static final void method596(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class186.field3009[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.field91[0][var5][var4] = class5.field91[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class5.field91[0][var5][var4] = class5.field91[0][1 + var5][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class5.field91[0][var5][var4] = class5.field91[0][var5][var4 - 1];
               }

               if(var1 + var3 == var4 && var4 < 103) {
                  class5.field91[0][var5][var4] = class5.field91[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)J",
      garbageValue = "66"
   )
   public static long method597(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }
}
