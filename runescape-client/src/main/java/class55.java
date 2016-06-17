import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class55 extends class66 {
   @ObfuscatedName("b")
   class199 field1141 = new class199();
   @ObfuscatedName("g")
   class199 field1142 = new class199();
   @ObfuscatedName("j")
   int field1143 = 0;
   @ObfuscatedName("d")
   int field1144 = -1;

   @ObfuscatedName("g")
   public final synchronized void method1132(class66 var1) {
      var1.method3916();
   }

   @ObfuscatedName("c")
   protected int vmethod3724() {
      return 0;
   }

   @ObfuscatedName("y")
   protected class66 vmethod3722() {
      return (class66)this.field1141.method3844();
   }

   @ObfuscatedName("r")
   protected class66 vmethod3736() {
      return (class66)this.field1141.method3834();
   }

   @ObfuscatedName("l")
   public final synchronized void vmethod3721(int[] var1, int var2, int var3) {
      do {
         if(this.field1144 < 0) {
            this.method1140(var1, var2, var3);
            return;
         }

         if(this.field1143 + var3 < this.field1144) {
            this.field1143 += var3;
            this.method1140(var1, var2, var3);
            return;
         }

         int var4 = this.field1144 - this.field1143;
         this.method1140(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1143 += var4;
         this.method1146();
         class61 var5 = (class61)this.field1142.method3844();
         synchronized(var5) {
            int var7 = var5.method1283(this);
            if(var7 < 0) {
               var5.field1197 = 0;
               this.method1147(var5);
            } else {
               var5.field1197 = var7;
               this.method1162(var5.field3114, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("u")
   void method1140(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1141.method3844(); var4 != null; var4 = (class66)this.field1141.method3834()) {
         var4.method1486(var1, var2, var3);
      }

   }

   @ObfuscatedName("p")
   public final synchronized void vmethod3725(int var1) {
      do {
         if(this.field1144 < 0) {
            this.method1142(var1);
            return;
         }

         if(this.field1143 + var1 < this.field1144) {
            this.field1143 += var1;
            this.method1142(var1);
            return;
         }

         int var2 = this.field1144 - this.field1143;
         this.method1142(var2);
         var1 -= var2;
         this.field1143 += var2;
         this.method1146();
         class61 var3 = (class61)this.field1142.method3844();
         synchronized(var3) {
            int var5 = var3.method1283(this);
            if(var5 < 0) {
               var3.field1197 = 0;
               this.method1147(var3);
            } else {
               var3.field1197 = var5;
               this.method1162(var3.field3114, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("n")
   void method1142(int var1) {
      for(class66 var2 = (class66)this.field1141.method3844(); var2 != null; var2 = (class66)this.field1141.method3834()) {
         var2.vmethod3725(var1);
      }

   }

   @ObfuscatedName("j")
   void method1146() {
      if(this.field1143 > 0) {
         for(class61 var1 = (class61)this.field1142.method3844(); var1 != null; var1 = (class61)this.field1142.method3834()) {
            var1.field1197 -= this.field1143;
         }

         this.field1144 -= this.field1143;
         this.field1143 = 0;
      }

   }

   @ObfuscatedName("x")
   void method1147(class61 var1) {
      var1.method3916();
      var1.method1282();
      class208 var2 = this.field1142.field3098.field3114;
      if(var2 == this.field1142.field3098) {
         this.field1144 = -1;
      } else {
         this.field1144 = ((class61)var2).field1197;
      }

   }

   @ObfuscatedName("d")
   void method1162(class208 var1, class61 var2) {
      while(var1 != this.field1142.field3098 && ((class61)var1).field1197 <= var2.field1197) {
         var1 = var1.field3114;
      }

      class199.method3821(var2, var1);
      this.field1144 = ((class61)this.field1142.field3098.field3114).field1197;
   }

   @ObfuscatedName("b")
   public final synchronized void method1167(class66 var1) {
      this.field1141.method3820(var1);
   }
}
