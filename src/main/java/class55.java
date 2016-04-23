import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class55 extends class66 {
   @ObfuscatedName("h")
   class199 field1155 = new class199();
   @ObfuscatedName("m")
   int field1156 = 0;
   @ObfuscatedName("j")
   class199 field1157 = new class199();
   @ObfuscatedName("z")
   int field1158 = -1;

   @ObfuscatedName("h")
   public final synchronized void method1133(class66 var1) {
      var1.method3883();
   }

   @ObfuscatedName("m")
   void method1134() {
      if(this.field1156 > 0) {
         for(class61 var1 = (class61)this.field1155.method3784(); var1 != null; var1 = (class61)this.field1155.method3777()) {
            var1.field1212 -= this.field1156;
         }

         this.field1158 -= this.field1156;
         this.field1156 = 0;
      }

   }

   @ObfuscatedName("c")
   protected int vmethod3675() {
      return 0;
   }

   @ObfuscatedName("x")
   void method1136(class61 var1) {
      var1.method3883();
      var1.method1269();
      class208 var2 = this.field1155.field3107.field3123;
      if(var2 == this.field1155.field3107) {
         this.field1158 = -1;
      } else {
         this.field1158 = ((class61)var2).field1212;
      }

   }

   @ObfuscatedName("e")
   protected class66 vmethod3673() {
      return (class66)this.field1157.method3784();
   }

   @ObfuscatedName("i")
   protected class66 vmethod3674() {
      return (class66)this.field1157.method3777();
   }

   @ObfuscatedName("l")
   void method1141(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1157.method3784(); var4 != null; var4 = (class66)this.field1157.method3777()) {
         var4.method1472(var1, var2, var3);
      }

   }

   @ObfuscatedName("r")
   void method1143(int var1) {
      for(class66 var2 = (class66)this.field1157.method3784(); var2 != null; var2 = (class66)this.field1157.method3777()) {
         var2.vmethod3677(var1);
      }

   }

   @ObfuscatedName("j")
   public final synchronized void method1146(class66 var1) {
      this.field1157.method3780(var1);
   }

   @ObfuscatedName("u")
   public final synchronized void vmethod3677(int var1) {
      do {
         if(this.field1158 < 0) {
            this.method1143(var1);
            return;
         }

         if(this.field1156 + var1 < this.field1158) {
            this.field1156 += var1;
            this.method1143(var1);
            return;
         }

         int var2 = this.field1158 - this.field1156;
         this.method1143(var2);
         var1 -= var2;
         this.field1156 += var2;
         this.method1134();
         class61 var3 = (class61)this.field1155.method3784();
         synchronized(var3) {
            int var5 = var3.method1270(this);
            if(var5 < 0) {
               var3.field1212 = 0;
               this.method1136(var3);
            } else {
               var3.field1212 = var5;
               this.method1159(var3.field3123, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("z")
   void method1159(class208 var1, class61 var2) {
      while(var1 != this.field1155.field3107 && ((class61)var1).field1212 <= var2.field1212) {
         var1 = var1.field3123;
      }

      class199.method3781(var2, var1);
      this.field1158 = ((class61)this.field1155.field3107.field3123).field1212;
   }

   @ObfuscatedName("n")
   public final synchronized void vmethod3676(int[] var1, int var2, int var3) {
      do {
         if(this.field1158 < 0) {
            this.method1141(var1, var2, var3);
            return;
         }

         if(this.field1156 + var3 < this.field1158) {
            this.field1156 += var3;
            this.method1141(var1, var2, var3);
            return;
         }

         int var4 = this.field1158 - this.field1156;
         this.method1141(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1156 += var4;
         this.method1134();
         class61 var5 = (class61)this.field1155.method3784();
         synchronized(var5) {
            int var7 = var5.method1270(this);
            if(var7 < 0) {
               var5.field1212 = 0;
               this.method1136(var5);
            } else {
               var5.field1212 = var7;
               this.method1159(var5.field3123, var5);
            }
         }
      } while(var3 != 0);

   }
}
