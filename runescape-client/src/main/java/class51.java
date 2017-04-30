import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("au")
public class class51 extends class68 {
   @ObfuscatedName("q")
   int field963;
   @ObfuscatedName("c")
   Deque field964;
   @ObfuscatedName("n")
   int field965;
   @ObfuscatedName("d")
   Deque field966;

   @ObfuscatedName("d")
   public final synchronized void method935(class68 var1) {
      this.field966.method2843(var1);
   }

   @ObfuscatedName("n")
   void method936() {
      if(this.field965 > 0) {
         for(class62 var1 = (class62)this.field964.method2828(); var1 != null; var1 = (class62)this.field964.method2830()) {
            var1.field1074 -= this.field965;
         }

         this.field963 -= this.field965;
         this.field965 = 0;
      }

   }

   @ObfuscatedName("p")
   protected class68 vmethod3102() {
      return (class68)this.field966.method2828();
   }

   @ObfuscatedName("t")
   void method939(class62 var1) {
      var1.unlink();
      var1.method1176();
      Node var2 = this.field964.head.next;
      if(var2 == this.field964.head) {
         this.field963 = -1;
      } else {
         this.field963 = ((class62)var2).field1074;
      }

   }

   @ObfuscatedName("u")
   protected class68 vmethod3091() {
      return (class68)this.field966.method2830();
   }

   @ObfuscatedName("w")
   protected int vmethod3097() {
      return 0;
   }

   @ObfuscatedName("r")
   public final synchronized void vmethod3093(int[] var1, int var2, int var3) {
      do {
         if(this.field963 < 0) {
            this.method944(var1, var2, var3);
            return;
         }

         if(this.field965 + var3 < this.field963) {
            this.field965 += var3;
            this.method944(var1, var2, var3);
            return;
         }

         int var4 = this.field963 - this.field965;
         this.method944(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field965 += var4;
         this.method936();
         class62 var5 = (class62)this.field964.method2828();
         synchronized(var5) {
            int var7 = var5.method1180(this);
            if(var7 < 0) {
               var5.field1074 = 0;
               this.method939(var5);
            } else {
               var5.field1074 = var7;
               this.method963(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("s")
   void method944(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field966.method2828(); var4 != null; var4 = (class68)this.field966.method2830()) {
         var4.method1360(var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   public final synchronized void method945(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("e")
   void method946(int var1) {
      for(class68 var2 = (class68)this.field966.method2828(); var2 != null; var2 = (class68)this.field966.method2830()) {
         var2.vmethod3094(var1);
      }

   }

   @ObfuscatedName("k")
   public final synchronized void vmethod3094(int var1) {
      do {
         if(this.field963 < 0) {
            this.method946(var1);
            return;
         }

         if(this.field965 + var1 < this.field963) {
            this.field965 += var1;
            this.method946(var1);
            return;
         }

         int var2 = this.field963 - this.field965;
         this.method946(var2);
         var1 -= var2;
         this.field965 += var2;
         this.method936();
         class62 var3 = (class62)this.field964.method2828();
         synchronized(var3) {
            int var5 = var3.method1180(this);
            if(var5 < 0) {
               var3.field1074 = 0;
               this.method939(var3);
            } else {
               var3.field1074 = var5;
               this.method963(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   public class51() {
      this.field966 = new Deque();
      this.field964 = new Deque();
      this.field965 = 0;
      this.field963 = -1;
   }

   @ObfuscatedName("q")
   void method963(Node var1, class62 var2) {
      while(var1 != this.field964.head && ((class62)var1).field1074 <= var2.field1074) {
         var1 = var1.next;
      }

      Deque.method2822(var2, var1);
      this.field963 = ((class62)this.field964.head.next).field1074;
   }
}
