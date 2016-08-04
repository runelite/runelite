import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public class class58 extends class69 {
   @ObfuscatedName("r")
   int field1239 = 0;
   @ObfuscatedName("g")
   class202 field1240 = new class202();
   @ObfuscatedName("l")
   class202 field1241 = new class202();
   @ObfuscatedName("e")
   int field1242 = -1;

   @ObfuscatedName("l")
   public final synchronized void method1251(class69 var1) {
      this.field1241.method3964(var1);
   }

   @ObfuscatedName("r")
   void method1253() {
      if(this.field1239 > 0) {
         for(class64 var1 = (class64)this.field1240.method3980(); var1 != null; var1 = (class64)this.field1240.method3970()) {
            var1.field1300 -= this.field1239;
         }

         this.field1242 -= this.field1239;
         this.field1239 = 0;
      }

   }

   @ObfuscatedName("e")
   void method1254(class211 var1, class64 var2) {
      while(var1 != this.field1240.field3157 && ((class64)var1).field1300 <= var2.field1300) {
         var1 = var1.field3173;
      }

      class202.method3998(var2, var1);
      this.field1242 = ((class64)this.field1240.field3157.field3173).field1300;
   }

   @ObfuscatedName("h")
   void method1255(class64 var1) {
      var1.method4067();
      var1.method1406();
      class211 var2 = this.field1240.field3157.field3173;
      if(var2 == this.field1240.field3157) {
         this.field1242 = -1;
      } else {
         this.field1242 = ((class64)var2).field1300;
      }

   }

   @ObfuscatedName("s")
   protected class69 vmethod3870() {
      return (class69)this.field1241.method3980();
   }

   @ObfuscatedName("k")
   protected class69 vmethod3871() {
      return (class69)this.field1241.method3970();
   }

   @ObfuscatedName("n")
   public final synchronized void vmethod3873(int[] var1, int var2, int var3) {
      do {
         if(this.field1242 < 0) {
            this.method1260(var1, var2, var3);
            return;
         }

         if(this.field1239 + var3 < this.field1242) {
            this.field1239 += var3;
            this.method1260(var1, var2, var3);
            return;
         }

         int var4 = this.field1242 - this.field1239;
         this.method1260(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1239 += var4;
         this.method1253();
         class64 var5 = (class64)this.field1240.method3980();
         synchronized(var5) {
            int var7 = var5.method1404(this);
            if(var7 < 0) {
               var5.field1300 = 0;
               this.method1255(var5);
            } else {
               var5.field1300 = var7;
               this.method1254(var5.field3173, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("b")
   void method1260(int[] var1, int var2, int var3) {
      for(class69 var4 = (class69)this.field1241.method3980(); var4 != null; var4 = (class69)this.field1241.method3970()) {
         var4.method1595(var1, var2, var3);
      }

   }

   @ObfuscatedName("m")
   public final synchronized void vmethod3874(int var1) {
      do {
         if(this.field1242 < 0) {
            this.method1262(var1);
            return;
         }

         if(this.field1239 + var1 < this.field1242) {
            this.field1239 += var1;
            this.method1262(var1);
            return;
         }

         int var2 = this.field1242 - this.field1239;
         this.method1262(var2);
         var1 -= var2;
         this.field1239 += var2;
         this.method1253();
         class64 var3 = (class64)this.field1240.method3980();
         synchronized(var3) {
            int var5 = var3.method1404(this);
            if(var5 < 0) {
               var3.field1300 = 0;
               this.method1255(var3);
            } else {
               var3.field1300 = var5;
               this.method1254(var3.field3173, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("q")
   void method1262(int var1) {
      for(class69 var2 = (class69)this.field1241.method3980(); var2 != null; var2 = (class69)this.field1241.method3970()) {
         var2.vmethod3874(var1);
      }

   }

   @ObfuscatedName("u")
   protected int vmethod3872() {
      return 0;
   }

   @ObfuscatedName("g")
   public final synchronized void method1285(class69 var1) {
      var1.method4067();
   }
}
