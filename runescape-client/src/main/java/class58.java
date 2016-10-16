import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class58 extends class69 {
   @ObfuscatedName("y")
   int field1209 = -1;
   @ObfuscatedName("z")
   Deque field1210 = new Deque();
   @ObfuscatedName("s")
   Deque field1211 = new Deque();
   @ObfuscatedName("t")
   int field1212 = 0;

   @ObfuscatedName("s")
   public final synchronized void method1143(class69 var1) {
      this.field1211.method3811(var1);
   }

   @ObfuscatedName("z")
   public final synchronized void method1144(class69 var1) {
      var1.unlink();
   }

   @ObfuscatedName("t")
   void method1145() {
      if(this.field1212 > 0) {
         for(class64 var1 = (class64)this.field1210.method3808(); var1 != null; var1 = (class64)this.field1210.method3810()) {
            var1.field1271 -= this.field1212;
         }

         this.field1209 -= this.field1212;
         this.field1212 = 0;
      }

   }

   @ObfuscatedName("p")
   void method1147(class64 var1) {
      var1.unlink();
      var1.method1282();
      Node var2 = this.field1210.head.next;
      if(var2 == this.field1210.head) {
         this.field1209 = -1;
      } else {
         this.field1209 = ((class64)var2).field1271;
      }

   }

   @ObfuscatedName("g")
   protected class69 vmethod3708() {
      return (class69)this.field1211.method3808();
   }

   @ObfuscatedName("m")
   protected class69 vmethod3709() {
      return (class69)this.field1211.method3810();
   }

   @ObfuscatedName("k")
   public final synchronized void vmethod3711(int[] var1, int var2, int var3) {
      do {
         if(this.field1209 < 0) {
            this.method1154(var1, var2, var3);
            return;
         }

         if(this.field1212 + var3 < this.field1209) {
            this.field1212 += var3;
            this.method1154(var1, var2, var3);
            return;
         }

         int var4 = this.field1209 - this.field1212;
         this.method1154(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1212 += var4;
         this.method1145();
         class64 var5 = (class64)this.field1210.method3808();
         synchronized(var5) {
            int var7 = var5.method1283(this);
            if(var7 < 0) {
               var5.field1271 = 0;
               this.method1147(var5);
            } else {
               var5.field1271 = var7;
               this.method1171(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("r")
   public final synchronized void vmethod3712(int var1) {
      do {
         if(this.field1209 < 0) {
            this.method1153(var1);
            return;
         }

         if(this.field1212 + var1 < this.field1209) {
            this.field1212 += var1;
            this.method1153(var1);
            return;
         }

         int var2 = this.field1209 - this.field1212;
         this.method1153(var2);
         var1 -= var2;
         this.field1212 += var2;
         this.method1145();
         class64 var3 = (class64)this.field1210.method3808();
         synchronized(var3) {
            int var5 = var3.method1283(this);
            if(var5 < 0) {
               var3.field1271 = 0;
               this.method1147(var3);
            } else {
               var3.field1271 = var5;
               this.method1171(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("w")
   void method1153(int var1) {
      for(class69 var2 = (class69)this.field1211.method3808(); var2 != null; var2 = (class69)this.field1211.method3810()) {
         var2.vmethod3712(var1);
      }

   }

   @ObfuscatedName("h")
   void method1154(int[] var1, int var2, int var3) {
      for(class69 var4 = (class69)this.field1211.method3808(); var4 != null; var4 = (class69)this.field1211.method3810()) {
         var4.method1493(var1, var2, var3);
      }

   }

   @ObfuscatedName("f")
   protected int vmethod3707() {
      return 0;
   }

   @ObfuscatedName("y")
   void method1171(Node var1, class64 var2) {
      while(var1 != this.field1210.head && ((class64)var1).field1271 <= var2.field1271) {
         var1 = var1.next;
      }

      Deque.method3814(var2, var1);
      this.field1209 = ((class64)this.field1210.head.next).field1271;
   }
}
