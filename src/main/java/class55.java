import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bp")
public class class55 extends class66 {
   @ObfuscatedName("f")
   int field1168 = 0;
   @ObfuscatedName("r")
   class198 field1169 = new class198();
   @ObfuscatedName("s")
   int field1170 = -1;
   @ObfuscatedName("a")
   class198 field1171 = new class198();

   @ObfuscatedName("a")
   public final synchronized void method1152(class66 var1) {
      this.field1171.method3856(var1);
   }

   @ObfuscatedName("r")
   public final synchronized void method1153(class66 var1) {
      var1.method3946();
   }

   @ObfuscatedName("f")
   void method1154() {
      if(this.field1168 > 0) {
         for(class61 var1 = (class61)this.field1169.method3860(); var1 != null; var1 = (class61)this.field1169.method3861()) {
            var1.field1229 -= this.field1168;
         }

         this.field1170 -= this.field1168;
         this.field1168 = 0;
      }

   }

   @ObfuscatedName("e")
   protected class66 vmethod3767() {
      return (class66)this.field1171.method3860();
   }

   @ObfuscatedName("m")
   protected int vmethod3770() {
      return 0;
   }

   @ObfuscatedName("j")
   public final synchronized void vmethod3779(int[] var1, int var2, int var3) {
      do {
         if(this.field1170 < 0) {
            this.method1160(var1, var2, var3);
            return;
         }

         if(this.field1168 + var3 < this.field1170) {
            this.field1168 += var3;
            this.method1160(var1, var2, var3);
            return;
         }

         int var4 = this.field1170 - this.field1168;
         this.method1160(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1168 += var4;
         this.method1154();
         class61 var5 = (class61)this.field1169.method3860();
         synchronized(var5) {
            int var7 = var5.method1297();
            if(var7 < 0) {
               var5.field1229 = 0;
               this.method1162(var5);
            } else {
               var5.field1229 = var7;
               this.method1187(var5.field3110, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("n")
   void method1160(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1171.method3860(); var4 != null; var4 = (class66)this.field1171.method3861()) {
         var4.method1491(var1, var2, var3);
      }

   }

   @ObfuscatedName("l")
   public final synchronized void vmethod3765(int var1) {
      do {
         if(this.field1170 < 0) {
            this.method1174(var1);
            return;
         }

         if(this.field1168 + var1 < this.field1170) {
            this.field1168 += var1;
            this.method1174(var1);
            return;
         }

         int var2 = this.field1170 - this.field1168;
         this.method1174(var2);
         var1 -= var2;
         this.field1168 += var2;
         this.method1154();
         class61 var3 = (class61)this.field1169.method3860();
         synchronized(var3) {
            int var5 = var3.method1297();
            if(var5 < 0) {
               var3.field1229 = 0;
               this.method1162(var3);
            } else {
               var3.field1229 = var5;
               this.method1187(var3.field3110, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("y")
   void method1162(class61 var1) {
      var1.method3946();
      var1.method1295();
      class207 var2 = this.field1169.field3094.field3110;
      if(var2 == this.field1169.field3094) {
         this.field1170 = -1;
      } else {
         this.field1170 = ((class61)var2).field1229;
      }

   }

   @ObfuscatedName("h")
   void method1174(int var1) {
      for(class66 var2 = (class66)this.field1171.method3860(); var2 != null; var2 = (class66)this.field1171.method3861()) {
         var2.vmethod3765(var1);
      }

   }

   @ObfuscatedName("s")
   void method1187(class207 var1, class61 var2) {
      while(var1 != this.field1169.field3094 && ((class61)var1).field1229 <= var2.field1229) {
         var1 = var1.field3110;
      }

      class198.method3875(var2, var1);
      this.field1170 = ((class61)this.field1169.field3094.field3110).field1229;
   }

   @ObfuscatedName("g")
   protected class66 vmethod3752() {
      return (class66)this.field1171.method3861();
   }
}
