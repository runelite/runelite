import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class143 extends class68 {
   @ObfuscatedName("i")
   class139 field2002;
   @ObfuscatedName("f")
   class51 field2004 = new class51();
   @ObfuscatedName("e")
   Deque field2005 = new Deque();
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -987234063
   )
   static int field2006;

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "32768"
   )
   static int method2647(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2311(((long)var0.id << 32) + (long)var0.index);
      return null != var1?var1.field1891:var0.field2324;
   }

   class143(class139 var1) {
      this.field2002 = var1;
   }

   @ObfuscatedName("v")
   protected int vmethod2649() {
      return 0;
   }

   @ObfuscatedName("l")
   protected void vmethod2651(int var1) {
      this.field2004.vmethod2651(var1);

      for(class140 var3 = (class140)this.field2005.method2359(); null != var3; var3 = (class140)this.field2005.method2361()) {
         if(!this.field2002.method2494(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1971) {
                  this.method2653(var3, var2);
                  var3.field1971 -= var2;
                  break;
               }

               this.method2653(var3, var3.field1971);
               var2 -= var3.field1971;
            } while(!this.field2002.method2495(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "1065203955"
   )
   void method2652(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2002.field1935[var1.field1963] & 4) != 0 && var1.field1966 < 0) {
         int var6 = this.field2002.field1940[var1.field1963] / class57.field1053;

         while(true) {
            int var7 = (1048575 + var6 - var1.field1972) / var6;
            if(var7 > var4) {
               var1.field1972 += var4 * var6;
               break;
            }

            var1.field1962.vmethod2665(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1972 += var7 * var6 - 1048576;
            int var8 = class57.field1053 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1962;
            if(this.field2002.field1938[var1.field1963] == 0) {
               var1.field1962 = class66.method1160(var1.field1968, var10.method1194(), var10.method1166(), var10.method1167());
            } else {
               var1.field1962 = class66.method1160(var1.field1968, var10.method1194(), 0, var10.method1167());
               this.field2002.method2472(var1, var1.field1953.field1991[var1.field1957] < 0);
               var1.field1962.method1193(var8, var10.method1166());
            }

            if(var1.field1953.field1991[var1.field1957] < 0) {
               var1.field1962.method1162(-1);
            }

            var10.method1173(var8);
            var10.vmethod2665(var2, var3, var5 - var3);
            if(var10.method1276()) {
               this.field2004.method882(var10);
            }
         }
      }

      var1.field1962.vmethod2665(var2, var3, var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass140;II)V",
      garbageValue = "-977521478"
   )
   void method2653(class140 var1, int var2) {
      if((this.field2002.field1935[var1.field1963] & 4) != 0 && var1.field1966 < 0) {
         int var3 = this.field2002.field1940[var1.field1963] / class57.field1053;
         int var4 = (var3 + 1048575 - var1.field1972) / var3;
         var1.field1972 = var2 * var3 + var1.field1972 & 1048575;
         if(var4 <= var2) {
            if(this.field2002.field1938[var1.field1963] == 0) {
               var1.field1962 = class66.method1160(var1.field1968, var1.field1962.method1194(), var1.field1962.method1166(), var1.field1962.method1167());
            } else {
               var1.field1962 = class66.method1160(var1.field1968, var1.field1962.method1194(), 0, var1.field1962.method1167());
               this.field2002.method2472(var1, var1.field1953.field1991[var1.field1957] < 0);
            }

            if(var1.field1953.field1991[var1.field1957] < 0) {
               var1.field1962.method1162(-1);
            }

            var2 = var1.field1972 / var3;
         }
      }

      var1.field1962.vmethod2651(var2);
   }

   @ObfuscatedName("w")
   protected class68 vmethod2658() {
      class140 var1;
      do {
         var1 = (class140)this.field2005.method2361();
         if(null == var1) {
            return null;
         }
      } while(null == var1.field1962);

      return var1.field1962;
   }

   @ObfuscatedName("h")
   protected void vmethod2665(int[] var1, int var2, int var3) {
      this.field2004.vmethod2665(var1, var2, var3);

      for(class140 var6 = (class140)this.field2005.method2359(); null != var6; var6 = (class140)this.field2005.method2361()) {
         if(!this.field2002.method2494(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1971) {
                  this.method2652(var6, var1, var4, var5, var4 + var5);
                  var6.field1971 -= var5;
                  break;
               }

               this.method2652(var6, var1, var4, var6.field1971, var4 + var5);
               var4 += var6.field1971;
               var5 -= var6.field1971;
            } while(!this.field2002.method2495(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("q")
   protected class68 vmethod2666() {
      class140 var1 = (class140)this.field2005.method2359();
      return (class68)(var1 == null?null:(null != var1.field1962?var1.field1962:this.vmethod2658()));
   }
}
