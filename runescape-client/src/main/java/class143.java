import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class143 extends class68 {
   @ObfuscatedName("f")
   class51 field2010 = new class51();
   @ObfuscatedName("s")
   class139 field2011;
   @ObfuscatedName("c")
   Deque field2012 = new Deque();
   @ObfuscatedName("de")
   @Export("mapRegions")
   static int[] mapRegions;

   @ObfuscatedName("u")
   protected class68 vmethod2611() {
      class140 var1 = (class140)this.field2012.method2330();
      return (class68)(null == var1?null:(var1.field1966 != null?var1.field1966:this.vmethod2612()));
   }

   @ObfuscatedName("b")
   protected class68 vmethod2612() {
      class140 var1;
      do {
         var1 = (class140)this.field2012.method2346();
         if(null == var1) {
            return null;
         }
      } while(null == var1.field1966);

      return var1.field1966;
   }

   @ObfuscatedName("r")
   protected void vmethod2614(int[] var1, int var2, int var3) {
      this.field2010.vmethod2614(var1, var2, var3);

      for(class140 var6 = (class140)this.field2012.method2330(); var6 != null; var6 = (class140)this.field2012.method2346()) {
         if(!this.field2011.method2437(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1964) {
                  this.method2628(var6, var1, var4, var5, var4 + var5);
                  var6.field1964 -= var5;
                  break;
               }

               this.method2628(var6, var1, var4, var6.field1964, var4 + var5);
               var4 += var6.field1964;
               var5 -= var6.field1964;
            } while(!this.field2011.method2449(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("m")
   protected void vmethod2615(int var1) {
      this.field2010.vmethod2615(var1);

      for(class140 var3 = (class140)this.field2012.method2330(); var3 != null; var3 = (class140)this.field2012.method2346()) {
         if(!this.field2011.method2437(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1964) {
                  this.method2617(var3, var2);
                  var3.field1964 -= var2;
                  break;
               }

               this.method2617(var3, var3.field1964);
               var2 -= var3.field1964;
            } while(!this.field2011.method2449(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass140;II)V",
      garbageValue = "1983377675"
   )
   void method2617(class140 var1, int var2) {
      if((this.field2011.field1938[var1.field1979] & 4) != 0 && var1.field1978 < 0) {
         int var3 = this.field2011.field1946[var1.field1979] / class57.field1057;
         int var4 = (var3 + 1048575 - var1.field1984) / var3;
         var1.field1984 = var2 * var3 + var1.field1984 & 1048575;
         if(var4 <= var2) {
            if(this.field2011.field1949[var1.field1979] == 0) {
               var1.field1966 = class66.method1127(var1.field1968, var1.field1966.method1141(), var1.field1966.method1133(), var1.field1966.method1228());
            } else {
               var1.field1966 = class66.method1127(var1.field1968, var1.field1966.method1141(), 0, var1.field1966.method1228());
               this.field2011.method2458(var1, var1.field1965.field2002[var1.field1969] < 0);
            }

            if(var1.field1965.field2002[var1.field1969] < 0) {
               var1.field1966.method1165(-1);
            }

            var2 = var1.field1984 / var3;
         }
      }

      var1.field1966.vmethod2615(var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "-948672556"
   )
   void method2628(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2011.field1938[var1.field1979] & 4) != 0 && var1.field1978 < 0) {
         int var6 = this.field2011.field1946[var1.field1979] / class57.field1057;

         while(true) {
            int var7 = (1048575 + var6 - var1.field1984) / var6;
            if(var7 > var4) {
               var1.field1984 += var4 * var6;
               break;
            }

            var1.field1966.vmethod2614(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1984 += var7 * var6 - 1048576;
            int var8 = class57.field1057 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1966;
            if(this.field2011.field1949[var1.field1979] == 0) {
               var1.field1966 = class66.method1127(var1.field1968, var10.method1141(), var10.method1133(), var10.method1228());
            } else {
               var1.field1966 = class66.method1127(var1.field1968, var10.method1141(), 0, var10.method1228());
               this.field2011.method2458(var1, var1.field1965.field2002[var1.field1969] < 0);
               var1.field1966.method1186(var8, var10.method1133());
            }

            if(var1.field1965.field2002[var1.field1969] < 0) {
               var1.field1966.method1165(-1);
            }

            var10.method1139(var8);
            var10.vmethod2614(var2, var3, var5 - var3);
            if(var10.method1143()) {
               this.field2010.method868(var10);
            }
         }
      }

      var1.field1966.vmethod2614(var2, var3, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)LObjectComposition;",
      garbageValue = "125"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2931.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2918.method3182(6, var0);
         var1 = new ObjectComposition();
         var1.field2942 = var0;
         if(var2 != null) {
            var1.method3483(new Buffer(var2));
         }

         var1.method3512();
         if(var1.isSolid) {
            var1.field2916 = 0;
            var1.field2933 = false;
         }

         ObjectComposition.field2931.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   protected int vmethod2632() {
      return 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-2081971246"
   )
   static byte[] method2634(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   class143(class139 var1) {
      this.field2011 = var1;
   }
}
