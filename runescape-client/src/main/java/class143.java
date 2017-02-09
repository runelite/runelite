import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class143 extends class68 {
   @ObfuscatedName("o")
   class51 field1997 = new class51();
   @ObfuscatedName("k")
   class139 field1998;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 2009478609
   )
   public static int field1999;
   @ObfuscatedName("y")
   Deque field2000 = new Deque();

   @ObfuscatedName("c")
   protected class68 vmethod2687() {
      class140 var1;
      do {
         var1 = (class140)this.field2000.method2398();
         if(var1 == null) {
            return null;
         }
      } while(var1.field1970 == null);

      return var1.field1970;
   }

   @ObfuscatedName("g")
   protected int vmethod2688() {
      return 0;
   }

   @ObfuscatedName("i")
   protected void vmethod2689(int[] var1, int var2, int var3) {
      this.field1997.vmethod2689(var1, var2, var3);

      for(class140 var6 = (class140)this.field2000.method2403(); var6 != null; var6 = (class140)this.field2000.method2398()) {
         if(!this.field1998.method2502(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1967) {
                  this.method2691(var6, var1, var4, var5, var5 + var4);
                  var6.field1967 -= var5;
                  break;
               }

               this.method2691(var6, var1, var4, var6.field1967, var5 + var4);
               var4 += var6.field1967;
               var5 -= var6.field1967;
            } while(!this.field1998.method2563(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("a")
   protected void vmethod2690(int var1) {
      this.field1997.vmethod2690(var1);

      for(class140 var3 = (class140)this.field2000.method2403(); null != var3; var3 = (class140)this.field2000.method2398()) {
         if(!this.field1998.method2502(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1967) {
                  this.method2692(var3, var2);
                  var3.field1967 -= var2;
                  break;
               }

               this.method2692(var3, var3.field1967);
               var2 -= var3.field1967;
            } while(!this.field1998.method2563(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "-2096978167"
   )
   void method2691(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field1998.field1917[var1.field1959] & 4) != 0 && var1.field1962 < 0) {
         int var6 = this.field1998.field1934[var1.field1959] / class57.field1045;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field1968) / var6;
            if(var7 > var4) {
               var1.field1968 += var6 * var4;
               break;
            }

            var1.field1970.vmethod2689(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1968 += var6 * var7 - 1048576;
            int var8 = class57.field1045 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1970;
            if(this.field1998.field1932[var1.field1959] == 0) {
               var1.field1970 = class66.method1266(var1.field1961, var10.method1208(), var10.method1199(), var10.method1303());
            } else {
               var1.field1970 = class66.method1266(var1.field1961, var10.method1208(), 0, var10.method1303());
               this.field1998.method2471(var1, var1.field1949.field1987[var1.field1953] < 0);
               var1.field1970.method1204(var8, var10.method1199());
            }

            if(var1.field1949.field1987[var1.field1953] < 0) {
               var1.field1970.method1196(-1);
            }

            var10.method1206(var8);
            var10.vmethod2689(var2, var3, var5 - var3);
            if(var10.method1189()) {
               this.field1997.method918(var10);
            }
         }
      }

      var1.field1970.vmethod2689(var2, var3, var4);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass140;IB)V",
      garbageValue = "55"
   )
   void method2692(class140 var1, int var2) {
      if((this.field1998.field1917[var1.field1959] & 4) != 0 && var1.field1962 < 0) {
         int var3 = this.field1998.field1934[var1.field1959] / class57.field1045;
         int var4 = (1048575 + var3 - var1.field1968) / var3;
         var1.field1968 = var1.field1968 + var3 * var2 & 1048575;
         if(var4 <= var2) {
            if(this.field1998.field1932[var1.field1959] == 0) {
               var1.field1970 = class66.method1266(var1.field1961, var1.field1970.method1208(), var1.field1970.method1199(), var1.field1970.method1303());
            } else {
               var1.field1970 = class66.method1266(var1.field1961, var1.field1970.method1208(), 0, var1.field1970.method1303());
               this.field1998.method2471(var1, var1.field1949.field1987[var1.field1953] < 0);
            }

            if(var1.field1949.field1987[var1.field1953] < 0) {
               var1.field1970.method1196(-1);
            }

            var2 = var1.field1968 / var3;
         }
      }

      var1.field1970.vmethod2690(var2);
   }

   class143(class139 var1) {
      this.field1998 = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Lclass188;",
      garbageValue = "-310704412"
   )
   public static class188 method2696(int var0) {
      class188 var1 = (class188)class188.field2761.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class188.field2765.getConfigData(19, var0);
         var1 = new class188();
         if(var2 != null) {
            var1.method3439(new Buffer(var2));
         }

         class188.field2761.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   protected class68 vmethod2708() {
      class140 var1 = (class140)this.field2000.method2403();
      return (class68)(var1 == null?null:(null != var1.field1970?var1.field1970:this.vmethod2687()));
   }
}
