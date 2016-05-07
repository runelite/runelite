import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class55 extends class66 {
   @ObfuscatedName("x")
   int field1175 = -1;
   @ObfuscatedName("j")
   class199 field1176 = new class199();
   @ObfuscatedName("p")
   int field1177 = 0;
   @ObfuscatedName("s")
   class199 field1178 = new class199();

   @ObfuscatedName("t")
   void method1115(int var1) {
      for(class66 var2 = (class66)this.field1178.method3812(); var2 != null; var2 = (class66)this.field1178.method3817()) {
         var2.vmethod3707(var1);
      }

   }

   @ObfuscatedName("x")
   void method1116(class208 var1, class61 var2) {
      while(var1 != this.field1176.field3109 && ((class61)var1).field1235 <= var2.field1235) {
         var1 = var1.field3124;
      }

      class199.method3809(var2, var1);
      this.field1175 = ((class61)this.field1176.field3109.field3124).field1235;
   }

   @ObfuscatedName("j")
   public final synchronized void method1117(class66 var1) {
      var1.method3898();
   }

   @ObfuscatedName("p")
   void method1118() {
      if(this.field1177 > 0) {
         for(class61 var1 = (class61)this.field1176.method3812(); var1 != null; var1 = (class61)this.field1176.method3817()) {
            var1.field1235 -= this.field1177;
         }

         this.field1175 -= this.field1177;
         this.field1177 = 0;
      }

   }

   @ObfuscatedName("d")
   void method1119(class61 var1) {
      var1.method3898();
      var1.method1254();
      class208 var2 = this.field1176.field3109.field3124;
      if(var2 == this.field1176.field3109) {
         this.field1175 = -1;
      } else {
         this.field1175 = ((class61)var2).field1235;
      }

   }

   @ObfuscatedName("u")
   protected class66 vmethod3709() {
      return (class66)this.field1178.method3812();
   }

   @ObfuscatedName("b")
   protected int vmethod3705() {
      return 0;
   }

   @ObfuscatedName("k")
   public final synchronized void vmethod3706(int[] var1, int var2, int var3) {
      do {
         if(this.field1175 < 0) {
            this.method1124(var1, var2, var3);
            return;
         }

         if(this.field1177 + var3 < this.field1175) {
            this.field1177 += var3;
            this.method1124(var1, var2, var3);
            return;
         }

         int var4 = this.field1175 - this.field1177;
         this.method1124(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1177 += var4;
         this.method1118();
         class61 var5 = (class61)this.field1176.method3812();
         synchronized(var5) {
            int var7 = var5.method1249(this);
            if(var7 < 0) {
               var5.field1235 = 0;
               this.method1119(var5);
            } else {
               var5.field1235 = var7;
               this.method1116(var5.field3124, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("c")
   void method1124(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1178.method3812(); var4 != null; var4 = (class66)this.field1178.method3817()) {
         var4.method1446(var1, var2, var3);
      }

   }

   @ObfuscatedName("l")
   public final synchronized void vmethod3707(int var1) {
      do {
         if(this.field1175 < 0) {
            this.method1115(var1);
            return;
         }

         if(this.field1177 + var1 < this.field1175) {
            this.field1177 += var1;
            this.method1115(var1);
            return;
         }

         int var2 = this.field1175 - this.field1177;
         this.method1115(var2);
         var1 -= var2;
         this.field1177 += var2;
         this.method1118();
         class61 var3 = (class61)this.field1176.method3812();
         synchronized(var3) {
            int var5 = var3.method1249(this);
            if(var5 < 0) {
               var3.field1235 = 0;
               this.method1119(var3);
            } else {
               var3.field1235 = var5;
               this.method1116(var3.field3124, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("s")
   public final synchronized void method1127(class66 var1) {
      this.field1178.method3808(var1);
   }

   @ObfuscatedName("o")
   protected class66 vmethod3704() {
      return (class66)this.field1178.method3817();
   }
}
