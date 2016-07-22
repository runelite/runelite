import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class58 extends class69 {
   @ObfuscatedName("o")
   int field1242 = 0;
   @ObfuscatedName("e")
   class202 field1243 = new class202();
   @ObfuscatedName("m")
   class202 field1244 = new class202();
   @ObfuscatedName("g")
   int field1245 = -1;

   @ObfuscatedName("x")
   public final synchronized void vmethod3778(int[] var1, int var2, int var3) {
      do {
         if(this.field1245 < 0) {
            this.method1213(var1, var2, var3);
            return;
         }

         if(this.field1242 + var3 < this.field1245) {
            this.field1242 += var3;
            this.method1213(var1, var2, var3);
            return;
         }

         int var4 = this.field1245 - this.field1242;
         this.method1213(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1242 += var4;
         this.method1206();
         class64 var5 = (class64)this.field1243.method3882();
         synchronized(var5) {
            int var7 = var5.method1356(this);
            if(var7 < 0) {
               var5.field1303 = 0;
               this.method1240(var5);
            } else {
               var5.field1303 = var7;
               this.method1207(var5.field3168, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("m")
   public final synchronized void method1204(class69 var1) {
      this.field1244.method3878(var1);
   }

   @ObfuscatedName("e")
   void method1206() {
      if(this.field1242 > 0) {
         for(class64 var1 = (class64)this.field1243.method3882(); var1 != null; var1 = (class64)this.field1243.method3891()) {
            var1.field1303 -= this.field1242;
         }

         this.field1245 -= this.field1242;
         this.field1242 = 0;
      }

   }

   @ObfuscatedName("o")
   void method1207(class211 var1, class64 var2) {
      while(var1 != this.field1243.field3150 && ((class64)var1).field1303 <= var2.field1303) {
         var1 = var1.field3168;
      }

      class202.method3879(var2, var1);
      this.field1245 = ((class64)this.field1243.field3150.field3168).field1303;
   }

   @ObfuscatedName("l")
   protected class69 vmethod3775() {
      return (class69)this.field1244.method3882();
   }

   @ObfuscatedName("j")
   protected class69 vmethod3776() {
      return (class69)this.field1244.method3891();
   }

   @ObfuscatedName("r")
   protected int vmethod3783() {
      return 0;
   }

   @ObfuscatedName("k")
   void method1213(int[] var1, int var2, int var3) {
      for(class69 var4 = (class69)this.field1244.method3882(); var4 != null; var4 = (class69)this.field1244.method3891()) {
         var4.method1551(var1, var2, var3);
      }

   }

   @ObfuscatedName("v")
   public final synchronized void vmethod3779(int var1) {
      do {
         if(this.field1245 < 0) {
            this.method1236(var1);
            return;
         }

         if(this.field1242 + var1 < this.field1245) {
            this.field1242 += var1;
            this.method1236(var1);
            return;
         }

         int var2 = this.field1245 - this.field1242;
         this.method1236(var2);
         var1 -= var2;
         this.field1242 += var2;
         this.method1206();
         class64 var3 = (class64)this.field1243.method3882();
         synchronized(var3) {
            int var5 = var3.method1356(this);
            if(var5 < 0) {
               var3.field1303 = 0;
               this.method1240(var3);
            } else {
               var3.field1303 = var5;
               this.method1207(var3.field3168, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("w")
   public final synchronized void method1228(class69 var1) {
      var1.method3990();
   }

   @ObfuscatedName("h")
   void method1236(int var1) {
      for(class69 var2 = (class69)this.field1244.method3882(); var2 != null; var2 = (class69)this.field1244.method3891()) {
         var2.vmethod3779(var1);
      }

   }

   @ObfuscatedName("g")
   void method1240(class64 var1) {
      var1.method3990();
      var1.method1355();
      class211 var2 = this.field1243.field3150.field3168;
      if(var2 == this.field1243.field3150) {
         this.field1245 = -1;
      } else {
         this.field1245 = ((class64)var2).field1303;
      }

   }
}
