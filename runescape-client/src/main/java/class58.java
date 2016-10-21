import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class58 extends class69 {
   @ObfuscatedName("e")
   Deque field1214 = new Deque();
   @ObfuscatedName("f")
   Deque field1215 = new Deque();
   @ObfuscatedName("n")
   int field1216 = 0;
   @ObfuscatedName("t")
   int field1217 = -1;

   @ObfuscatedName("e")
   public final synchronized void method1173(class69 var1) {
      var1.unlink();
   }

   @ObfuscatedName("n")
   void method1174() {
      if(this.field1216 > 0) {
         for(class64 var1 = (class64)this.field1214.method3890(); var1 != null; var1 = (class64)this.field1214.method3892()) {
            var1.field1276 -= this.field1216;
         }

         this.field1217 -= this.field1216;
         this.field1216 = 0;
      }

   }

   @ObfuscatedName("w")
   void method1175(int[] var1, int var2, int var3) {
      for(class69 var4 = (class69)this.field1215.method3890(); var4 != null; var4 = (class69)this.field1215.method3892()) {
         var4.method1533(var1, var2, var3);
      }

   }

   @ObfuscatedName("b")
   protected class69 vmethod3776() {
      return (class69)this.field1215.method3890();
   }

   @ObfuscatedName("m")
   protected class69 vmethod3777() {
      return (class69)this.field1215.method3892();
   }

   @ObfuscatedName("k")
   protected int vmethod3778() {
      return 0;
   }

   @ObfuscatedName("c")
   public final synchronized void vmethod3796(int[] var1, int var2, int var3) {
      do {
         if(this.field1217 < 0) {
            this.method1175(var1, var2, var3);
            return;
         }

         if(this.field1216 + var3 < this.field1217) {
            this.field1216 += var3;
            this.method1175(var1, var2, var3);
            return;
         }

         int var4 = this.field1217 - this.field1216;
         this.method1175(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1216 += var4;
         this.method1174();
         class64 var5 = (class64)this.field1214.method3890();
         synchronized(var5) {
            int var7 = var5.method1323(this);
            if(var7 < 0) {
               var5.field1276 = 0;
               this.method1189(var5);
            } else {
               var5.field1276 = var7;
               this.method1180(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("t")
   void method1180(Node var1, class64 var2) {
      while(var1 != this.field1214.head && ((class64)var1).field1276 <= var2.field1276) {
         var1 = var1.next;
      }

      Deque.method3888(var2, var1);
      this.field1217 = ((class64)this.field1214.head.next).field1276;
   }

   @ObfuscatedName("l")
   public final synchronized void vmethod3780(int var1) {
      do {
         if(this.field1217 < 0) {
            this.method1182(var1);
            return;
         }

         if(this.field1216 + var1 < this.field1217) {
            this.field1216 += var1;
            this.method1182(var1);
            return;
         }

         int var2 = this.field1217 - this.field1216;
         this.method1182(var2);
         var1 -= var2;
         this.field1216 += var2;
         this.method1174();
         class64 var3 = (class64)this.field1214.method3890();
         synchronized(var3) {
            int var5 = var3.method1323(this);
            if(var5 < 0) {
               var3.field1276 = 0;
               this.method1189(var3);
            } else {
               var3.field1276 = var5;
               this.method1180(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("h")
   void method1182(int var1) {
      for(class69 var2 = (class69)this.field1215.method3890(); var2 != null; var2 = (class69)this.field1215.method3892()) {
         var2.vmethod3780(var1);
      }

   }

   @ObfuscatedName("f")
   public final synchronized void method1184(class69 var1) {
      this.field1215.method3910(var1);
   }

   @ObfuscatedName("v")
   void method1189(class64 var1) {
      var1.unlink();
      var1.method1322();
      Node var2 = this.field1214.head.next;
      if(var2 == this.field1214.head) {
         this.field1217 = -1;
      } else {
         this.field1217 = ((class64)var2).field1276;
      }

   }
}
