import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Tile")
public final class class100 extends class207 {
   @ObfuscatedName("b")
   boolean field1724;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2023492897
   )
   @Export("plane")
   int field1725;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 64231303
   )
   @Export("y")
   int field1726;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 156017247
   )
   int field1727;
   @ObfuscatedName("u")
   boolean field1728;
   @ObfuscatedName("e")
   class96 field1729;
   @ObfuscatedName("g")
   class86 field1731;
   @ObfuscatedName("h")
   @Export("objects")
   class97[] field1732 = new class97[5];
   @ObfuscatedName("n")
   @Export("itemLayer")
   class98 field1733;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1683356241
   )
   int field1734;
   @ObfuscatedName("q")
   class100 field1735;
   @ObfuscatedName("i")
   int[] field1736 = new int[5];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 243990003
   )
   int field1737 = 0;
   @ObfuscatedName("y")
   class88 field1738;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -670078155
   )
   @Export("x")
   int field1739;
   @ObfuscatedName("t")
   boolean field1740;
   @ObfuscatedName("m")
   class93 field1741;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -140914019
   )
   int field1742;
   @ObfuscatedName("j")
   class92 field1743;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1387121213
   )
   int field1744;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1957632471
   )
   int field1745;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -522713697
   )
   int field1746;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -934214375
   )
   int field1749;

   @ObfuscatedName("f")
   static void method2289(int var0) {
      class15 var1 = (class15)class15.field225.method3824((long)var0);
      if(null != var1) {
         var1.method3946();
      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1940586255"
   )
   static final void method2290(int var0, int var1) {
      if(var0 != class38.field873 || class9.field148 != var1) {
         class38.field873 = var0;
         class9.field148 = var1;
         class1.method9(25);
         class185.method3778("Loading - please wait.", true);
         int var2 = class147.field2214;
         int var3 = class17.field257;
         class147.field2214 = (var0 - 6) * 8;
         class17.field257 = (var1 - 6) * 8;
         int var4 = class147.field2214 - var2;
         int var5 = class17.field257 - var3;
         var2 = class147.field2214;
         var3 = class17.field257;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var7 = client.field358[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field866[var8] -= var4;
                  var7.field867[var8] -= var5;
               }

               var7.field870 -= 128 * var4;
               var7.field813 -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var18 = client.field415[var6];
            if(var18 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var18.field866[var8] -= var4;
                  var18.field867[var8] -= var5;
               }

               var18.field870 -= var4 * 128;
               var18.field813 -= var5 * 128;
            }
         }

         byte var17 = 0;
         byte var19 = 104;
         byte var20 = 1;
         if(var4 < 0) {
            var17 = 103;
            var19 = -1;
            var20 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var12 = var17; var12 != var19; var12 += var20) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var4 + var12;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field419[var16][var12][var13] = client.field419[var16][var14][var15];
                  } else {
                     client.field419[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var21 = (class16)client.field427.method3860(); null != var21; var21 = (class16)client.field427.method3861()) {
            var21.field229 -= var4;
            var21.field244 -= var5;
            if(var21.field229 < 0 || var21.field244 < 0 || var21.field229 >= 104 || var21.field244 >= 104) {
               var21.method3946();
            }
         }

         if(0 != client.field528) {
            client.field528 -= var4;
            client.field529 -= var5;
         }

         client.field536 = 0;
         client.field542 = false;
         client.field523 = 1;
         client.field429.method3854();
         client.field385.method3854();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field359[var13].method2396();
         }

      }
   }

   class100(int var1, int var2, int var3) {
      this.field1727 = this.field1725 = var1;
      this.field1739 = var2;
      this.field1726 = var3;
   }

   @ObfuscatedName("r")
   public static int method2291(CharSequence var0, int var1) {
      return class109.method2432(var0, var1);
   }

   @ObfuscatedName("f")
   public static void method2292() {
      if(class136.field2108 != null) {
         class136 var0 = class136.field2108;
         synchronized(class136.field2108) {
            class136.field2108 = null;
         }
      }

   }
}
