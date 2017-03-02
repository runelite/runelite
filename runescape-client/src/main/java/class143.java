import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class143 extends class68 {
   @ObfuscatedName("l")
   Deque field1998 = new Deque();
   @ObfuscatedName("i")
   class51 field1999 = new class51();
   @ObfuscatedName("b")
   class139 field2001;
   @ObfuscatedName("pk")
   static class1 field2002;
   @ObfuscatedName("bv")
   static class184 field2004;

   @ObfuscatedName("x")
   protected class68 vmethod2744() {
      class140 var1 = (class140)this.field1998.method2472();
      return (class68)(var1 == null?null:(null != var1.field1955?var1.field1955:this.vmethod2746()));
   }

   @ObfuscatedName("z")
   protected class68 vmethod2746() {
      class140 var1;
      do {
         var1 = (class140)this.field1998.method2479();
         if(null == var1) {
            return null;
         }
      } while(null == var1.field1955);

      return var1.field1955;
   }

   @ObfuscatedName("s")
   protected void vmethod2747(int[] var1, int var2, int var3) {
      this.field1999.vmethod2747(var1, var2, var3);

      for(class140 var6 = (class140)this.field1998.method2472(); null != var6; var6 = (class140)this.field1998.method2479()) {
         if(!this.field2001.method2610(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1968) {
                  this.method2749(var6, var1, var4, var5, var4 + var5);
                  var6.field1968 -= var5;
                  break;
               }

               this.method2749(var6, var1, var4, var6.field1968, var4 + var5);
               var4 += var6.field1968;
               var5 -= var6.field1968;
            } while(!this.field2001.method2592(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("y")
   protected void vmethod2748(int var1) {
      this.field1999.vmethod2748(var1);

      for(class140 var3 = (class140)this.field1998.method2472(); null != var3; var3 = (class140)this.field1998.method2479()) {
         if(!this.field2001.method2610(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1968) {
                  this.method2750(var3, var2);
                  var3.field1968 -= var2;
                  break;
               }

               this.method2750(var3, var3.field1968);
               var2 -= var3.field1968;
            } while(!this.field2001.method2592(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "1734854023"
   )
   void method2749(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2001.field1933[var1.field1966] & 4) != 0 && var1.field1963 < 0) {
         int var6 = this.field2001.field1938[var1.field1966] / class202.field3079;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field1969) / var6;
            if(var7 > var4) {
               var1.field1969 += var6 * var4;
               break;
            }

            var1.field1955.vmethod2747(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1969 += var6 * var7 - 1048576;
            int var8 = class202.field3079 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1955;
            if(this.field2001.field1936[var1.field1966] == 0) {
               var1.field1955 = class66.method1237(var1.field1954, var10.method1233(), var10.method1243(), var10.method1288());
            } else {
               var1.field1955 = class66.method1237(var1.field1954, var10.method1233(), 0, var10.method1288());
               this.field2001.method2570(var1, var1.field1957.field1991[var1.field1951] < 0);
               var1.field1955.method1248(var8, var10.method1243());
            }

            if(var1.field1957.field1991[var1.field1951] < 0) {
               var1.field1955.method1239(-1);
            }

            var10.method1300(var8);
            var10.vmethod2747(var2, var3, var5 - var3);
            if(var10.method1254()) {
               this.field1999.method993(var10);
            }
         }
      }

      var1.field1955.vmethod2747(var2, var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass140;II)V",
      garbageValue = "-312917731"
   )
   void method2750(class140 var1, int var2) {
      if((this.field2001.field1933[var1.field1966] & 4) != 0 && var1.field1963 < 0) {
         int var3 = this.field2001.field1938[var1.field1966] / class202.field3079;
         int var4 = (var3 + 1048575 - var1.field1969) / var3;
         var1.field1969 = var2 * var3 + var1.field1969 & 1048575;
         if(var4 <= var2) {
            if(this.field2001.field1936[var1.field1966] == 0) {
               var1.field1955 = class66.method1237(var1.field1954, var1.field1955.method1233(), var1.field1955.method1243(), var1.field1955.method1288());
            } else {
               var1.field1955 = class66.method1237(var1.field1954, var1.field1955.method1233(), 0, var1.field1955.method1288());
               this.field2001.method2570(var1, var1.field1957.field1991[var1.field1951] < 0);
            }

            if(var1.field1957.field1991[var1.field1951] < 0) {
               var1.field1955.method1239(-1);
            }

            var2 = var1.field1969 / var3;
         }
      }

      var1.field1955.vmethod2748(var2);
   }

   class143(class139 var1) {
      this.field2001 = var1;
   }

   @ObfuscatedName("p")
   protected int vmethod2763() {
      return 0;
   }
}
