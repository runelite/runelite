import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bf")
public class class55 extends class66 {
   @ObfuscatedName("e")
   int field1177 = -1;
   @ObfuscatedName("t")
   class199 field1178 = new class199();
   @ObfuscatedName("p")
   int field1179 = 0;
   @ObfuscatedName("x")
   class199 field1180 = new class199();

   @ObfuscatedName("x")
   public final synchronized void method1153(class66 var1) {
      var1.method3935();
   }

   @ObfuscatedName("t")
   void method1154() {
      if(this.field1179 > 0) {
         for(class61 var1 = (class61)this.field1178.method3836(); var1 != null; var1 = (class61)this.field1178.method3841()) {
            var1.field1235 -= this.field1179;
         }

         this.field1177 -= this.field1179;
         this.field1179 = 0;
      }

   }

   @ObfuscatedName("p")
   void method1155(class208 var1, class61 var2) {
      while(var1 != this.field1178.field3108 && ((class61)var1).field1235 <= var2.field1235) {
         var1 = var1.field3124;
      }

      class199.method3859(var2, var1);
      this.field1177 = ((class61)this.field1178.field3108.field3124).field1235;
   }

   @ObfuscatedName("m")
   protected class66 vmethod3749() {
      return (class66)this.field1180.method3841();
   }

   @ObfuscatedName("z")
   public final synchronized void vmethod3734(int var1) {
      do {
         if(this.field1177 < 0) {
            this.method1181(var1);
            return;
         }

         if(this.field1179 + var1 < this.field1177) {
            this.field1179 += var1;
            this.method1181(var1);
            return;
         }

         int var2 = this.field1177 - this.field1179;
         this.method1181(var2);
         var1 -= var2;
         this.field1179 += var2;
         this.method1154();
         class61 var3 = (class61)this.field1178.method3836();
         synchronized(var3) {
            int var5 = var3.method1287();
            if(var5 < 0) {
               var3.field1235 = 0;
               this.method1177(var3);
            } else {
               var3.field1235 = var5;
               this.method1155(var3.field3124, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("v")
   public final synchronized void vmethod3733(int[] var1, int var2, int var3) {
      do {
         if(this.field1177 < 0) {
            this.method1160(var1, var2, var3);
            return;
         }

         if(this.field1179 + var3 < this.field1177) {
            this.field1179 += var3;
            this.method1160(var1, var2, var3);
            return;
         }

         int var4 = this.field1177 - this.field1179;
         this.method1160(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1179 += var4;
         this.method1154();
         class61 var5 = (class61)this.field1178.method3836();
         synchronized(var5) {
            int var7 = var5.method1287();
            if(var7 < 0) {
               var5.field1235 = 0;
               this.method1177(var5);
            } else {
               var5.field1235 = var7;
               this.method1155(var5.field3124, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("l")
   void method1160(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1180.method3836(); var4 != null; var4 = (class66)this.field1180.method3841()) {
         var4.method1467(var1, var2, var3);
      }

   }

   @ObfuscatedName("y")
   protected class66 vmethod3729() {
      return (class66)this.field1180.method3836();
   }

   @ObfuscatedName("c")
   protected int vmethod3745() {
      return 0;
   }

   @ObfuscatedName("e")
   void method1177(class61 var1) {
      var1.method3935();
      var1.method1293();
      class208 var2 = this.field1178.field3108.field3124;
      if(var2 == this.field1178.field3108) {
         this.field1177 = -1;
      } else {
         this.field1177 = ((class61)var2).field1235;
      }

   }

   @ObfuscatedName("s")
   void method1181(int var1) {
      for(class66 var2 = (class66)this.field1180.method3836(); var2 != null; var2 = (class66)this.field1180.method3841()) {
         var2.vmethod3734(var1);
      }

   }

   @ObfuscatedName("w")
   public final synchronized void method1188(class66 var1) {
      this.field1180.method3835(var1);
   }
}
