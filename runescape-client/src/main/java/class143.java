import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class143 extends class68 {
   @ObfuscatedName("m")
   Deque field2017 = new Deque();
   @ObfuscatedName("b")
   class51 field2018 = new class51();
   @ObfuscatedName("ep")
   static SpritePixels[] field2019;
   @ObfuscatedName("o")
   class139 field2020;
   @ObfuscatedName("es")
   static ModIcon[] field2021;

   @ObfuscatedName("k")
   protected int vmethod2624() {
      return 0;
   }

   @ObfuscatedName("c")
   protected class68 vmethod2625() {
      class140 var1 = (class140)this.field2017.method2349();
      return (class68)(var1 == null?null:(null != var1.field1986?var1.field1986:this.vmethod2626()));
   }

   @ObfuscatedName("u")
   protected class68 vmethod2626() {
      class140 var1;
      do {
         var1 = (class140)this.field2017.method2351();
         if(null == var1) {
            return null;
         }
      } while(var1.field1986 == null);

      return var1.field1986;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "430753931"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2892.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2926.method3203(6, var0);
         var1 = new ObjectComposition();
         var1.field2897 = var0;
         if(null != var2) {
            var1.method3514(new Buffer(var2));
         }

         var1.method3513();
         if(var1.field2929) {
            var1.field2907 = 0;
            var1.field2918 = false;
         }

         ObjectComposition.field2892.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   protected void vmethod2628(int[] var1, int var2, int var3) {
      this.field2018.vmethod2628(var1, var2, var3);

      for(class140 var6 = (class140)this.field2017.method2349(); null != var6; var6 = (class140)this.field2017.method2351()) {
         if(!this.field2020.method2481(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1987) {
                  this.method2630(var6, var1, var4, var5, var4 + var5);
                  var6.field1987 -= var5;
                  break;
               }

               this.method2630(var6, var1, var4, var6.field1987, var5 + var4);
               var4 += var6.field1987;
               var5 -= var6.field1987;
            } while(!this.field2020.method2482(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("j")
   protected void vmethod2629(int var1) {
      this.field2018.vmethod2629(var1);

      for(class140 var3 = (class140)this.field2017.method2349(); null != var3; var3 = (class140)this.field2017.method2351()) {
         if(!this.field2020.method2481(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1987) {
                  this.method2631(var3, var2);
                  var3.field1987 -= var2;
                  break;
               }

               this.method2631(var3, var3.field1987);
               var2 -= var3.field1987;
            } while(!this.field2020.method2482(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "-192799247"
   )
   void method2630(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2020.field1950[var1.field1984] & 4) != 0 && var1.field1978 < 0) {
         int var6 = this.field2020.field1955[var1.field1984] / class57.field1042;

         while(true) {
            int var7 = (1048575 + var6 - var1.field1989) / var6;
            if(var7 > var4) {
               var1.field1989 += var6 * var4;
               break;
            }

            var1.field1986.vmethod2628(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1989 += var6 * var7 - 1048576;
            int var8 = class57.field1042 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1986;
            if(this.field2020.field1953[var1.field1984] == 0) {
               var1.field1986 = class66.method1294(var1.field1970, var10.method1183(), var10.method1175(), var10.method1176());
            } else {
               var1.field1986 = class66.method1294(var1.field1970, var10.method1183(), 0, var10.method1176());
               this.field2020.method2455(var1, var1.field1969.field2013[var1.field1973] < 0);
               var1.field1986.method1303(var8, var10.method1175());
            }

            if(var1.field1969.field2013[var1.field1973] < 0) {
               var1.field1986.method1268(-1);
            }

            var10.method1182(var8);
            var10.vmethod2628(var2, var3, var5 - var3);
            if(var10.method1186()) {
               this.field2018.method898(var10);
            }
         }
      }

      var1.field1986.vmethod2628(var2, var3, var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass140;II)V",
      garbageValue = "-1027750537"
   )
   void method2631(class140 var1, int var2) {
      if((this.field2020.field1950[var1.field1984] & 4) != 0 && var1.field1978 < 0) {
         int var3 = this.field2020.field1955[var1.field1984] / class57.field1042;
         int var4 = (var3 + 1048575 - var1.field1989) / var3;
         var1.field1989 = var1.field1989 + var2 * var3 & 1048575;
         if(var4 <= var2) {
            if(this.field2020.field1953[var1.field1984] == 0) {
               var1.field1986 = class66.method1294(var1.field1970, var1.field1986.method1183(), var1.field1986.method1175(), var1.field1986.method1176());
            } else {
               var1.field1986 = class66.method1294(var1.field1970, var1.field1986.method1183(), 0, var1.field1986.method1176());
               this.field2020.method2455(var1, var1.field1969.field2013[var1.field1973] < 0);
            }

            if(var1.field1969.field2013[var1.field1973] < 0) {
               var1.field1986.method1268(-1);
            }

            var2 = var1.field1989 / var3;
         }
      }

      var1.field1986.vmethod2629(var2);
   }

   class143(class139 var1) {
      this.field2020 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZB)I",
      garbageValue = "-15"
   )
   static int method2643(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class85.method1664(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class85.method1664(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
