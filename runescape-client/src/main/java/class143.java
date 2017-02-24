import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class143 extends class68 {
   @ObfuscatedName("d")
   Deque field2004 = new Deque();
   @ObfuscatedName("h")
   class51 field2005 = new class51();
   @ObfuscatedName("q")
   class139 field2006;

   @ObfuscatedName("o")
   protected int vmethod2716() {
      return 0;
   }

   @ObfuscatedName("c")
   protected class68 vmethod2717() {
      class140 var1;
      do {
         var1 = (class140)this.field2004.method2472();
         if(var1 == null) {
            return null;
         }
      } while(null == var1.field1975);

      return var1.field1975;
   }

   class143(class139 var1) {
      this.field2006 = var1;
   }

   @ObfuscatedName("s")
   protected void vmethod2718(int[] var1, int var2, int var3) {
      this.field2005.vmethod2718(var1, var2, var3);

      for(class140 var6 = (class140)this.field2004.method2458(); var6 != null; var6 = (class140)this.field2004.method2472()) {
         if(!this.field2006.method2566(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1952) {
                  this.method2720(var6, var1, var4, var5, var5 + var4);
                  var6.field1952 -= var5;
                  break;
               }

               this.method2720(var6, var1, var4, var6.field1952, var4 + var5);
               var4 += var6.field1952;
               var5 -= var6.field1952;
            } while(!this.field2006.method2581(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("b")
   protected void vmethod2719(int var1) {
      this.field2005.vmethod2719(var1);

      for(class140 var3 = (class140)this.field2004.method2458(); var3 != null; var3 = (class140)this.field2004.method2472()) {
         if(!this.field2006.method2566(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1952) {
                  this.method2721(var3, var2);
                  var3.field1952 -= var2;
                  break;
               }

               this.method2721(var3, var3.field1952);
               var2 -= var3.field1952;
            } while(!this.field2006.method2581(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "-1970144820"
   )
   void method2720(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2006.field1941[var1.field1967] & 4) != 0 && var1.field1965 < 0) {
         int var6 = this.field2006.field1935[var1.field1967] / class57.field1061;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field1971) / var6;
            if(var7 > var4) {
               var1.field1971 += var6 * var4;
               break;
            }

            var1.field1975.vmethod2718(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1971 += var6 * var7 - 1048576;
            int var8 = class57.field1061 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1975;
            if(this.field2006.field1938[var1.field1967] == 0) {
               var1.field1975 = class66.method1236(var1.field1953, var10.method1338(), var10.method1263(), var10.method1278());
            } else {
               var1.field1975 = class66.method1236(var1.field1953, var10.method1338(), 0, var10.method1278());
               this.field2006.method2558(var1, var1.field1973.field1992[var1.field1955] < 0);
               var1.field1975.method1247(var8, var10.method1263());
            }

            if(var1.field1973.field1992[var1.field1955] < 0) {
               var1.field1975.method1243(-1);
            }

            var10.method1316(var8);
            var10.vmethod2718(var2, var3, var5 - var3);
            if(var10.method1253()) {
               this.field2005.method985(var10);
            }
         }
      }

      var1.field1975.vmethod2718(var2, var3, var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass140;II)V",
      garbageValue = "649126758"
   )
   void method2721(class140 var1, int var2) {
      if((this.field2006.field1941[var1.field1967] & 4) != 0 && var1.field1965 < 0) {
         int var3 = this.field2006.field1935[var1.field1967] / class57.field1061;
         int var4 = (var3 + 1048575 - var1.field1971) / var3;
         var1.field1971 = var1.field1971 + var3 * var2 & 1048575;
         if(var4 <= var2) {
            if(this.field2006.field1938[var1.field1967] == 0) {
               var1.field1975 = class66.method1236(var1.field1953, var1.field1975.method1338(), var1.field1975.method1263(), var1.field1975.method1278());
            } else {
               var1.field1975 = class66.method1236(var1.field1953, var1.field1975.method1338(), 0, var1.field1975.method1278());
               this.field2006.method2558(var1, var1.field1973.field1992[var1.field1955] < 0);
            }

            if(var1.field1973.field1992[var1.field1955] < 0) {
               var1.field1975.method1243(-1);
            }

            var2 = var1.field1971 / var3;
         }
      }

      var1.field1975.vmethod2719(var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZI)V",
      garbageValue = "-299784955"
   )
   public static void method2728(class182 var0, class182 var1, boolean var2) {
      ObjectComposition.field2893 = var0;
      ObjectComposition.field2894 = var1;
      ObjectComposition.field2905 = var2;
   }

   @ObfuscatedName("n")
   protected class68 vmethod2734() {
      class140 var1 = (class140)this.field2004.method2458();
      return (class68)(null == var1?null:(null != var1.field1975?var1.field1975:this.vmethod2717()));
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1020400690"
   )
   static void method2737(int var0) {
      for(class133 var1 = (class133)Client.widgetFlags.method2403(); null != var1; var1 = (class133)Client.widgetFlags.method2411()) {
         if((var1.hash >> 48 & 65535L) == (long)var0) {
            var1.unlink();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "-337126783"
   )
   public static void method2739(class182 var0, class182 var1, class182 var2) {
      Sequence.field3066 = var0;
      NPC.field785 = var1;
      class210.field3124 = var2;
   }
}
