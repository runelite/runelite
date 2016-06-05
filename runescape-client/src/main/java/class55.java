import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class55 extends class66 {
   @ObfuscatedName("i")
   class199 field1179 = new class199();
   @ObfuscatedName("t")
   class199 field1180 = new class199();
   @ObfuscatedName("g")
   int field1181 = 0;
   @ObfuscatedName("h")
   int field1182 = -1;

   @ObfuscatedName("r")
   protected class66 vmethod3695() {
      return (class66)this.field1180.method3797();
   }

   @ObfuscatedName("i")
   public final synchronized void method1092(class66 var1) {
      var1.method3870();
   }

   @ObfuscatedName("g")
   void method1093() {
      if(this.field1181 > 0) {
         for(class61 var1 = (class61)this.field1179.method3797(); var1 != null; var1 = (class61)this.field1179.method3779()) {
            var1.field1233 -= this.field1181;
         }

         this.field1182 -= this.field1181;
         this.field1181 = 0;
      }

   }

   @ObfuscatedName("t")
   public final synchronized void method1094(class66 var1) {
      this.field1180.method3788(var1);
   }

   @ObfuscatedName("z")
   void method1095(class61 var1) {
      var1.method3870();
      var1.method1231();
      class208 var2 = this.field1179.field3108.field3126;
      if(var2 == this.field1179.field3108) {
         this.field1182 = -1;
      } else {
         this.field1182 = ((class61)var2).field1233;
      }

   }

   @ObfuscatedName("l")
   void method1096(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1180.method3797(); var4 != null; var4 = (class66)this.field1180.method3779()) {
         var4.method1425(var1, var2, var3);
      }

   }

   @ObfuscatedName("f")
   protected class66 vmethod3677() {
      return (class66)this.field1180.method3779();
   }

   @ObfuscatedName("s")
   protected int vmethod3678() {
      return 0;
   }

   @ObfuscatedName("d")
   public final synchronized void vmethod3679(int[] var1, int var2, int var3) {
      do {
         if(this.field1182 < 0) {
            this.method1096(var1, var2, var3);
            return;
         }

         if(this.field1181 + var3 < this.field1182) {
            this.field1181 += var3;
            this.method1096(var1, var2, var3);
            return;
         }

         int var4 = this.field1182 - this.field1181;
         this.method1096(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1181 += var4;
         this.method1093();
         class61 var5 = (class61)this.field1179.method3797();
         synchronized(var5) {
            int var7 = var5.method1232(this);
            if(var7 < 0) {
               var5.field1233 = 0;
               this.method1095(var5);
            } else {
               var5.field1233 = var7;
               this.method1127(var5.field3126, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("y")
   public final synchronized void vmethod3686(int var1) {
      do {
         if(this.field1182 < 0) {
            this.method1102(var1);
            return;
         }

         if(this.field1181 + var1 < this.field1182) {
            this.field1181 += var1;
            this.method1102(var1);
            return;
         }

         int var2 = this.field1182 - this.field1181;
         this.method1102(var2);
         var1 -= var2;
         this.field1181 += var2;
         this.method1093();
         class61 var3 = (class61)this.field1179.method3797();
         synchronized(var3) {
            int var5 = var3.method1232(this);
            if(var5 < 0) {
               var3.field1233 = 0;
               this.method1095(var3);
            } else {
               var3.field1233 = var5;
               this.method1127(var3.field3126, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("p")
   void method1102(int var1) {
      for(class66 var2 = (class66)this.field1180.method3797(); var2 != null; var2 = (class66)this.field1180.method3779()) {
         var2.vmethod3686(var1);
      }

   }

   @ObfuscatedName("h")
   void method1127(class208 var1, class61 var2) {
      while(var1 != this.field1179.field3108 && ((class61)var1).field1233 <= var2.field1233) {
         var1 = var1.field3126;
      }

      class199.method3785(var2, var1);
      this.field1182 = ((class61)this.field1179.field3108.field3126).field1233;
   }
}
