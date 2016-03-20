import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("Projectile")
public final class class6 extends class84 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1782806111
   )
   int field95;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 357849257
   )
   int field96;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -29034959
   )
   int field97;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1008031675
   )
   int field98;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1536592207
   )
   int field99;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1310636229
   )
   int field100;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1047926807
   )
   int field101 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 946552733
   )
   int field102;
   @ObfuscatedName("c")
   @Export("velocityX")
   double field103;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 65688007
   )
   int field104;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1630742193
   )
   int field105;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1720193345
   )
   int field106;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 1544759465
   )
   public static int field107;
   @ObfuscatedName("v")
   @Export("velocityZ")
   double field108;
   @ObfuscatedName("z")
   double field109;
   @ObfuscatedName("u")
   double field110;
   @ObfuscatedName("t")
   @Export("scalar")
   double field111;
   @ObfuscatedName("b")
   @Export("velocityY")
   double field112;
   @ObfuscatedName("i")
   double field113;
   @ObfuscatedName("x")
   double field114;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -565899949
   )
   int field115;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1905337771
   )
   int field116;
   @ObfuscatedName("q")
   @Export("animationSequence")
   class42 field117;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -301728503
   )
   int field118 = 0;
   @ObfuscatedName("h")
   @Export("isMoving")
   boolean field119 = false;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1698013843
   )
   int field122;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = 1596893325
   )
   static int field124;

   @ObfuscatedName("a")
   final void method103(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field119) {
         var5 = (double)(var1 - this.field97);
         double var7 = (double)(var2 - this.field106);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.field113 = (double)this.field104 * var5 / var9 + (double)this.field97;
         this.field108 = (double)this.field106 + (double)this.field104 * var7 / var9;
         this.field109 = (double)this.field99;
      }

      var5 = (double)(this.field102 + 1 - var4);
      this.field110 = ((double)var1 - this.field113) / var5;
      this.field111 = ((double)var2 - this.field108) / var5;
      this.field112 = Math.sqrt(this.field111 * this.field111 + this.field110 * this.field110);
      if(!this.field119) {
         this.field103 = -this.field112 * Math.tan(0.02454369D * (double)this.field95);
      }

      this.field114 = ((double)var3 - this.field109 - var5 * this.field103) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1713967754"
   )
   final void method104(int var1) {
      this.field119 = true;
      this.field113 += (double)var1 * this.field110;
      this.field108 += (double)var1 * this.field111;
      this.field109 += (double)var1 * (double)var1 * this.field114 * 0.5D + (double)var1 * this.field103;
      this.field103 += (double)var1 * this.field114;
      this.field115 = (int)(Math.atan2(this.field110, this.field111) * 325.949D) + 1024 & 2047;
      this.field116 = (int)(Math.atan2(this.field103, this.field112) * 325.949D) & 2047;
      if(null != this.field117) {
         this.field101 += var1;

         while(true) {
            do {
               do {
                  if(this.field101 <= this.field117.field990[this.field118]) {
                     return;
                  }

                  this.field101 -= this.field117.field990[this.field118];
                  ++this.field118;
               } while(this.field118 < this.field117.field988.length);

               this.field118 -= this.field117.field1000 * -1;
            } while(this.field118 >= 0 && this.field118 < this.field117.field988.length);

            this.field118 = 0;
         }
      }
   }

   @ObfuscatedName("f")
   protected final class104 vmethod1919() {
      class43 var1 = class24.method595(this.field98);
      class104 var2 = var1.method909(this.field118);
      if(null == var2) {
         return null;
      } else {
         var2.method2319(this.field116);
         return var2;
      }
   }

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field98 = var1;
      this.field96 = var2;
      this.field97 = var3;
      this.field106 = var4;
      this.field99 = var5;
      this.field122 = var6;
      this.field102 = var7;
      this.field95 = var8;
      this.field104 = var9;
      this.field105 = var10;
      this.field100 = var11;
      this.field119 = false;
      int var12 = class24.method595(this.field98).field1012;
      if(-1 != var12) {
         this.field117 = class134.method2875(var12);
      } else {
         this.field117 = null;
      }

   }

   @ObfuscatedName("e")
   public static boolean method108(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "36"
   )
   static final void method112(String var0) {
      if(null != var0) {
         if((client.field562 < 200 || 1 == client.field459) && client.field562 < 400) {
            String var1 = class128.method2832(var0, class132.field2062);
            if(null != var1) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field562; ++var2) {
                  class17 var3 = client.field513[var2];
                  var4 = class128.method2832(var3.field261, class132.field2062);
                  if(null != var4 && var4.equals(var1)) {
                     class137.method2943(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.field248 != null) {
                     var5 = class128.method2832(var3.field248, class132.field2062);
                     if(null != var5 && var5.equals(var1)) {
                        class137.method2943(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field509; ++var2) {
                  class7 var6 = client.field568[var2];
                  var4 = class128.method2832(var6.field129, class132.field2062);
                  if(null != var4 && var4.equals(var1)) {
                     class137.method2943(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.field125 != null) {
                     var5 = class128.method2832(var6.field125, class132.field2062);
                     if(var5 != null && var5.equals(var1)) {
                        class137.method2943(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class128.method2832(class151.field2253.field40, class132.field2062).equals(var1)) {
                  class137.method2943(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  client.field301.method2753(216);
                  client.field301.method2497(class22.method578(var0));
                  client.field301.method2503(var0);
               }
            }
         } else {
            class137.method2943(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("dw")
   static String method114(class172 var0) {
      int var2 = class101.method2294(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(null != var0.field2820 && var0.field2820.trim().length() != 0?var0.field2820:null);
   }
}
