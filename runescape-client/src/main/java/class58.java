import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class58 extends class69 {
   @ObfuscatedName("l")
   class202 field1237 = new class202();
   @ObfuscatedName("e")
   class202 field1238 = new class202();
   @ObfuscatedName("c")
   int field1239 = 0;
   @ObfuscatedName("h")
   int field1240 = -1;

   @ObfuscatedName("c")
   void method1240() {
      if(this.field1239 > 0) {
         for(class64 var1 = (class64)this.field1237.method3899(); var1 != null; var1 = (class64)this.field1237.method3918()) {
            var1.field1299 -= this.field1239;
         }

         this.field1240 -= this.field1239;
         this.field1239 = 0;
      }

   }

   @ObfuscatedName("e")
   public final synchronized void method1241(class69 var1) {
      this.field1238.method3896(var1);
   }

   @ObfuscatedName("r")
   void method1242(class64 var1) {
      var1.method4000();
      var1.method1378();
      class211 var2 = this.field1237.field3145.field3162;
      if(var2 == this.field1237.field3145) {
         this.field1240 = -1;
      } else {
         this.field1240 = ((class64)var2).field1299;
      }

   }

   @ObfuscatedName("a")
   protected class69 vmethod3803() {
      return (class69)this.field1238.method3899();
   }

   @ObfuscatedName("u")
   protected int vmethod3805() {
      return 0;
   }

   @ObfuscatedName("o")
   public final synchronized void vmethod3806(int[] var1, int var2, int var3) {
      do {
         if(this.field1240 < 0) {
            this.method1247(var1, var2, var3);
            return;
         }

         if(this.field1239 + var3 < this.field1240) {
            this.field1239 += var3;
            this.method1247(var1, var2, var3);
            return;
         }

         int var4 = this.field1240 - this.field1239;
         this.method1247(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1239 += var4;
         this.method1240();
         class64 var5 = (class64)this.field1237.method3899();
         synchronized(var5) {
            int var7 = var5.method1375(this);
            if(var7 < 0) {
               var5.field1299 = 0;
               this.method1242(var5);
            } else {
               var5.field1299 = var7;
               this.method1258(var5.field3162, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("p")
   void method1247(int[] var1, int var2, int var3) {
      for(class69 var4 = (class69)this.field1238.method3899(); var4 != null; var4 = (class69)this.field1238.method3918()) {
         var4.method1560(var1, var2, var3);
      }

   }

   @ObfuscatedName("i")
   public final synchronized void vmethod3807(int var1) {
      do {
         if(this.field1240 < 0) {
            this.method1266(var1);
            return;
         }

         if(this.field1239 + var1 < this.field1240) {
            this.field1239 += var1;
            this.method1266(var1);
            return;
         }

         int var2 = this.field1240 - this.field1239;
         this.method1266(var2);
         var1 -= var2;
         this.field1239 += var2;
         this.method1240();
         class64 var3 = (class64)this.field1237.method3899();
         synchronized(var3) {
            int var5 = var3.method1375(this);
            if(var5 < 0) {
               var3.field1299 = 0;
               this.method1242(var3);
            } else {
               var3.field1299 = var5;
               this.method1258(var3.field3162, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("l")
   public final synchronized void method1254(class69 var1) {
      var1.method4000();
   }

   @ObfuscatedName("b")
   protected class69 vmethod3804() {
      return (class69)this.field1238.method3918();
   }

   @ObfuscatedName("h")
   void method1258(class211 var1, class64 var2) {
      while(var1 != this.field1237.field3145 && ((class64)var1).field1299 <= var2.field1299) {
         var1 = var1.field3162;
      }

      class202.method3902(var2, var1);
      this.field1240 = ((class64)this.field1237.field3145.field3162).field1299;
   }

   @ObfuscatedName("q")
   void method1266(int var1) {
      for(class69 var2 = (class69)this.field1238.method3899(); var2 != null; var2 = (class69)this.field1238.method3918()) {
         var2.vmethod3807(var1);
      }

   }
}
