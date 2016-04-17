import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class55 extends class66 {
   @ObfuscatedName("y")
   int field1179 = -1;
   @ObfuscatedName("d")
   class199 field1180 = new class199();
   @ObfuscatedName("c")
   int field1181 = 0;
   @ObfuscatedName("a")
   class199 field1182 = new class199();

   @ObfuscatedName("p")
   protected int vmethod3810() {
      return 0;
   }

   @ObfuscatedName("w")
   public final synchronized void method1235(class66 var1) {
      var1.method3998();
   }

   @ObfuscatedName("d")
   void method1236() {
      if(this.field1181 > 0) {
         for(class61 var1 = (class61)this.field1180.method3926(); var1 != null; var1 = (class61)this.field1180.method3902()) {
            var1.field1237 -= this.field1181;
         }

         this.field1179 -= this.field1181;
         this.field1181 = 0;
      }

   }

   @ObfuscatedName("y")
   void method1237(class61 var1) {
      var1.method3998();
      var1.method1365();
      class208 var2 = this.field1180.field3108.field3124;
      if(var2 == this.field1180.field3108) {
         this.field1179 = -1;
      } else {
         this.field1179 = ((class61)var2).field1237;
      }

   }

   @ObfuscatedName("k")
   protected class66 vmethod3806() {
      return (class66)this.field1182.method3926();
   }

   @ObfuscatedName("x")
   void method1240(int var1) {
      for(class66 var2 = (class66)this.field1182.method3926(); var2 != null; var2 = (class66)this.field1182.method3902()) {
         var2.vmethod3800(var1);
      }

   }

   @ObfuscatedName("q")
   public final synchronized void vmethod3796(int[] var1, int var2, int var3) {
      do {
         if(this.field1179 < 0) {
            this.method1270(var1, var2, var3);
            return;
         }

         if(this.field1181 + var3 < this.field1179) {
            this.field1181 += var3;
            this.method1270(var1, var2, var3);
            return;
         }

         int var4 = this.field1179 - this.field1181;
         this.method1270(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1181 += var4;
         this.method1236();
         class61 var5 = (class61)this.field1180.method3926();
         synchronized(var5) {
            int var7 = var5.method1366(this);
            if(var7 < 0) {
               var5.field1237 = 0;
               this.method1237(var5);
            } else {
               var5.field1237 = var7;
               this.method1244(var5.field3124, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("e")
   public final synchronized void vmethod3800(int var1) {
      do {
         if(this.field1179 < 0) {
            this.method1240(var1);
            return;
         }

         if(this.field1181 + var1 < this.field1179) {
            this.field1181 += var1;
            this.method1240(var1);
            return;
         }

         int var2 = this.field1179 - this.field1181;
         this.method1240(var2);
         var1 -= var2;
         this.field1181 += var2;
         this.method1236();
         class61 var3 = (class61)this.field1180.method3926();
         synchronized(var3) {
            int var5 = var3.method1366(this);
            if(var5 < 0) {
               var3.field1237 = 0;
               this.method1237(var3);
            } else {
               var3.field1237 = var5;
               this.method1244(var3.field3124, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("c")
   void method1244(class208 var1, class61 var2) {
      while(var1 != this.field1180.field3108 && ((class61)var1).field1237 <= var2.field1237) {
         var1 = var1.field3124;
      }

      class199.method3933(var2, var1);
      this.field1179 = ((class61)this.field1180.field3108.field3124).field1237;
   }

   @ObfuscatedName("a")
   public final synchronized void method1253(class66 var1) {
      this.field1182.method3901(var1);
   }

   @ObfuscatedName("r")
   protected class66 vmethod3797() {
      return (class66)this.field1182.method3902();
   }

   @ObfuscatedName("m")
   void method1270(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1182.method3926(); var4 != null; var4 = (class66)this.field1182.method3902()) {
         var4.method1568(var1, var2, var3);
      }

   }
}
