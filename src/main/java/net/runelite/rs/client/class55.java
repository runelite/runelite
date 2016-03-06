package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public class class55 extends class66 {
   @ObfuscatedName("a")
   int field1177 = 0;
   @ObfuscatedName("l")
   class198 field1178 = new class198();
   @ObfuscatedName("j")
   class198 field1179 = new class198();
   @ObfuscatedName("i")
   int field1180 = -1;

   @ObfuscatedName("h")
   protected int vmethod3679() {
      return 0;
   }

   @ObfuscatedName("l")
   public final synchronized void method1137(class66 var1) {
      var1.method3853();
   }

   @ObfuscatedName("a")
   void method1138() {
      if(this.field1177 > 0) {
         for(class61 var1 = (class61)this.field1178.method3773(); var1 != null; var1 = (class61)this.field1178.method3772()) {
            var1.field1237 -= this.field1177;
         }

         this.field1180 -= this.field1177;
         this.field1177 = 0;
      }

   }

   @ObfuscatedName("f")
   void method1140(class61 var1) {
      var1.method3853();
      var1.method1272();
      class207 var2 = this.field1178.field3095.field3111;
      if(var2 == this.field1178.field3095) {
         this.field1180 = -1;
      } else {
         this.field1180 = ((class61)var2).field1237;
      }

   }

   @ObfuscatedName("m")
   protected class66 vmethod3677() {
      return (class66)this.field1179.method3773();
   }

   @ObfuscatedName("b")
   void method1143(int var1) {
      for(class66 var2 = (class66)this.field1179.method3773(); var2 != null; var2 = (class66)this.field1179.method3772()) {
         var2.vmethod3676(var1);
      }

   }

   @ObfuscatedName("n")
   public final synchronized void vmethod3680(int[] var1, int var2, int var3) {
      do {
         if(this.field1180 < 0) {
            this.method1145(var1, var2, var3);
            return;
         }

         if(this.field1177 + var3 < this.field1180) {
            this.field1177 += var3;
            this.method1145(var1, var2, var3);
            return;
         }

         int var4 = this.field1180 - this.field1177;
         this.method1145(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1177 += var4;
         this.method1138();
         class61 var5 = (class61)this.field1178.method3773();
         synchronized(var5) {
            int var7 = var5.method1273();
            if(var7 < 0) {
               var5.field1237 = 0;
               this.method1140(var5);
            } else {
               var5.field1237 = var7;
               this.method1148(var5.field3111, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("k")
   void method1145(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1179.method3773(); var4 != null; var4 = (class66)this.field1179.method3772()) {
         var4.method1469(var1, var2, var3);
      }

   }

   @ObfuscatedName("r")
   public final synchronized void vmethod3676(int var1) {
      do {
         if(this.field1180 < 0) {
            this.method1143(var1);
            return;
         }

         if(this.field1177 + var1 < this.field1180) {
            this.field1177 += var1;
            this.method1143(var1);
            return;
         }

         int var2 = this.field1180 - this.field1177;
         this.method1143(var2);
         var1 -= var2;
         this.field1177 += var2;
         this.method1138();
         class61 var3 = (class61)this.field1178.method3773();
         synchronized(var3) {
            int var5 = var3.method1273();
            if(var5 < 0) {
               var3.field1237 = 0;
               this.method1140(var3);
            } else {
               var3.field1237 = var5;
               this.method1148(var3.field3111, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("i")
   void method1148(class207 var1, class61 var2) {
      while(var1 != this.field1178.field3095 && ((class61)var1).field1237 <= var2.field1237) {
         var1 = var1.field3111;
      }

      class198.method3766(var2, var1);
      this.field1180 = ((class61)this.field1178.field3095.field3111).field1237;
   }

   @ObfuscatedName("j")
   public final synchronized void method1152(class66 var1) {
      this.field1179.method3769(var1);
   }

   @ObfuscatedName("o")
   protected class66 vmethod3678() {
      return (class66)this.field1179.method3772();
   }
}
