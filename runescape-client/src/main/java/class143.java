import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class143 extends class68 {
   @ObfuscatedName("u")
   class139 field1990;
   @ObfuscatedName("i")
   class51 field1991 = new class51();
   @ObfuscatedName("x")
   Deque field1992 = new Deque();

   @ObfuscatedName("g")
   protected class68 vmethod2671() {
      class140 var1 = (class140)this.field1992.method2391();
      return (class68)(null == var1?null:(null != var1.field1953?var1.field1953:this.vmethod2672()));
   }

   @ObfuscatedName("z")
   protected class68 vmethod2672() {
      class140 var1;
      do {
         var1 = (class140)this.field1992.method2393();
         if(var1 == null) {
            return null;
         }
      } while(var1.field1953 == null);

      return var1.field1953;
   }

   @ObfuscatedName("t")
   protected int vmethod2673() {
      return 0;
   }

   @ObfuscatedName("m")
   protected void vmethod2674(int[] var1, int var2, int var3) {
      this.field1991.vmethod2674(var1, var2, var3);

      for(class140 var6 = (class140)this.field1992.method2391(); null != var6; var6 = (class140)this.field1992.method2393()) {
         if(!this.field1990.method2511(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1959) {
                  this.method2697(var6, var1, var4, var5, var5 + var4);
                  var6.field1959 -= var5;
                  break;
               }

               this.method2697(var6, var1, var4, var6.field1959, var4 + var5);
               var4 += var6.field1959;
               var5 -= var6.field1959;
            } while(!this.field1990.method2512(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("e")
   protected void vmethod2675(int var1) {
      this.field1991.vmethod2675(var1);

      for(class140 var3 = (class140)this.field1992.method2391(); null != var3; var3 = (class140)this.field1992.method2393()) {
         if(!this.field1990.method2511(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1959) {
                  this.method2684(var3, var2);
                  var3.field1959 -= var2;
                  break;
               }

               this.method2684(var3, var3.field1959);
               var2 -= var3.field1959;
            } while(!this.field1990.method2512(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2019780868"
   )
   static void method2679(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class181 var4 = (class181)class185.field2727.method2339(var2);
      if(null != var4) {
         class185.field2728.method2285(var4);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass140;II)V",
      garbageValue = "888208943"
   )
   void method2684(class140 var1, int var2) {
      if((this.field1990.field1919[var1.field1957] & 4) != 0 && var1.field1949 < 0) {
         int var3 = this.field1990.field1924[var1.field1957] / class7.field65;
         int var4 = (1048575 + var3 - var1.field1955) / var3;
         var1.field1955 = var1.field1955 + var2 * var3 & 1048575;
         if(var4 <= var2) {
            if(this.field1990.field1922[var1.field1957] == 0) {
               var1.field1953 = class66.method1131(var1.field1937, var1.field1953.method1223(), var1.field1953.method1137(), var1.field1953.method1183());
            } else {
               var1.field1953 = class66.method1131(var1.field1937, var1.field1953.method1223(), 0, var1.field1953.method1183());
               this.field1990.method2592(var1, var1.field1943.field1982[var1.field1940] < 0);
            }

            if(var1.field1943.field1982[var1.field1940] < 0) {
               var1.field1953.method1133(-1);
            }

            var2 = var1.field1955 / var3;
         }
      }

      var1.field1953.vmethod2675(var2);
   }

   class143(class139 var1) {
      this.field1990 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "732846375"
   )
   void method2697(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field1990.field1919[var1.field1957] & 4) != 0 && var1.field1949 < 0) {
         int var6 = this.field1990.field1924[var1.field1957] / class7.field65;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field1955) / var6;
            if(var7 > var4) {
               var1.field1955 += var6 * var4;
               break;
            }

            var1.field1953.vmethod2674(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1955 += var6 * var7 - 1048576;
            int var8 = class7.field65 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1953;
            if(this.field1990.field1922[var1.field1957] == 0) {
               var1.field1953 = class66.method1131(var1.field1937, var10.method1223(), var10.method1137(), var10.method1183());
            } else {
               var1.field1953 = class66.method1131(var1.field1937, var10.method1223(), 0, var10.method1183());
               this.field1990.method2592(var1, var1.field1943.field1982[var1.field1940] < 0);
               var1.field1953.method1259(var8, var10.method1137());
            }

            if(var1.field1943.field1982[var1.field1940] < 0) {
               var1.field1953.method1133(-1);
            }

            var10.method1144(var8);
            var10.vmethod2674(var2, var3, var5 - var3);
            if(var10.method1148()) {
               this.field1991.method889(var10);
            }
         }
      }

      var1.field1953.vmethod2674(var2, var3, var4);
   }
}
