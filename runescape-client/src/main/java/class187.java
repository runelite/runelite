import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class187 extends class208 {
   @ObfuscatedName("v")
   class64 field3007;
   @ObfuscatedName("g")
   class181 field3008;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 507942367
   )
   int field3009;
   @ObfuscatedName("d")
   class185 field3010;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 875779861
   )
   int field3011;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 455316003
   )
   int field3012;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 239638599
   )
   int field3013;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -579681083
   )
   int field3014;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1960522087
   )
   int field3015;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2100238651
   )
   int field3016;
   @ObfuscatedName("j")
   class62 field3017;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1215452281
   )
   int field3018;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1098460831
   )
   int field3019;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1896624179
   )
   int field3020;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -334543907
   )
   int field3021;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 980590773
   )
   int field3022;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1508154495
   )
   int field3023;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1168866403
   )
   int field3024;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -469159829
   )
   int field3025;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2122211589
   )
   int field3026;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 577654517
   )
   int field3027;

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-22514"
   )
   static final void method3748() {
      int var0 = class16.field234;
      int var1 = class12.field194;
      int var2 = class156.field2288;
      int var3 = class20.field573;
      int var4 = 6116423;
      class79.method1865(var0, var1, var2, var3, var4);
      class79.method1865(var0 + 1, 1 + var1, var2 - 2, 16, 0);
      class79.method1852(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class162.field2636.method4033("Choose Option", 3 + var0, var1 + 14, var4, -1);
      int var5 = class140.field2134;
      int var6 = class140.field2135;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < client.field429; ++var7) {
         var8 = 15 * (client.field429 - 1 - var7) + var1 + 31;
         var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class224 var10 = class162.field2636;
         String var11;
         if(client.field396[var7].length() > 0) {
            var11 = client.field434[var7] + " " + client.field396[var7];
         } else {
            var11 = client.field434[var7];
         }

         var10.method4033(var11, var0 + 3, var8, var9, 0);
      }

      var7 = class16.field234;
      var8 = class12.field194;
      var9 = class156.field2288;
      int var13 = class20.field573;

      for(int var12 = 0; var12 < client.field490; ++var12) {
         if(client.field497[var12] + client.field495[var12] > var7 && client.field495[var12] < var9 + var7 && client.field498[var12] + client.field496[var12] > var8 && client.field496[var12] < var13 + var8) {
            client.field283[var12] = true;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "349646095"
   )
   void method3751() {
      this.field3008 = null;
      this.field3017 = null;
      this.field3010 = null;
      this.field3007 = null;
   }
}
