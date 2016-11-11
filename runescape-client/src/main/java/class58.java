import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class58 extends class69 {
   @ObfuscatedName("e")
   int field1226 = 0;
   @ObfuscatedName("h")
   Deque field1227 = new Deque();
   @ObfuscatedName("i")
   Deque field1228 = new Deque();
   @ObfuscatedName("g")
   int field1229 = -1;

   @ObfuscatedName("i")
   public final synchronized void method1177(class69 var1) {
      this.field1228.method3841(var1);
   }

   @ObfuscatedName("h")
   public final synchronized void method1178(class69 var1) {
      var1.unlink();
   }

   @ObfuscatedName("e")
   void method1179() {
      if(this.field1226 > 0) {
         for(class64 var1 = (class64)this.field1227.method3845(); var1 != null; var1 = (class64)this.field1227.method3847()) {
            var1.field1283 -= this.field1226;
         }

         this.field1229 -= this.field1226;
         this.field1226 = 0;
      }

   }

   @ObfuscatedName("g")
   void method1180(Node var1, class64 var2) {
      while(var1 != this.field1227.head && ((class64)var1).field1283 <= var2.field1283) {
         var1 = var1.next;
      }

      Deque.method3842(var2, var1);
      this.field1229 = ((class64)this.field1227.head.next).field1283;
   }

   @ObfuscatedName("n")
   void method1181(class64 var1) {
      var1.unlink();
      var1.method1321();
      Node var2 = this.field1227.head.next;
      if(var2 == this.field1227.head) {
         this.field1229 = -1;
      } else {
         this.field1229 = ((class64)var2).field1283;
      }

   }

   @ObfuscatedName("u")
   protected class69 vmethod3756() {
      return (class69)this.field1228.method3845();
   }

   @ObfuscatedName("d")
   protected class69 vmethod3744() {
      return (class69)this.field1228.method3847();
   }

   @ObfuscatedName("l")
   protected int vmethod3745() {
      return 0;
   }

   @ObfuscatedName("m")
   public final synchronized void vmethod3746(int[] var1, int var2, int var3) {
      do {
         if(this.field1229 < 0) {
            this.method1194(var1, var2, var3);
            return;
         }

         if(this.field1226 + var3 < this.field1229) {
            this.field1226 += var3;
            this.method1194(var1, var2, var3);
            return;
         }

         int var4 = this.field1229 - this.field1226;
         this.method1194(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1226 += var4;
         this.method1179();
         class64 var5 = (class64)this.field1227.method3845();
         synchronized(var5) {
            int var7 = var5.method1317(this);
            if(var7 < 0) {
               var5.field1283 = 0;
               this.method1181(var5);
            } else {
               var5.field1283 = var7;
               this.method1180(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("s")
   void method1188(int var1) {
      for(class69 var2 = (class69)this.field1228.method3845(); var2 != null; var2 = (class69)this.field1228.method3847()) {
         var2.vmethod3743(var1);
      }

   }

   @ObfuscatedName("j")
   void method1194(int[] var1, int var2, int var3) {
      for(class69 var4 = (class69)this.field1228.method3845(); var4 != null; var4 = (class69)this.field1228.method3847()) {
         var4.method1505(var1, var2, var3);
      }

   }

   @ObfuscatedName("y")
   public final synchronized void vmethod3743(int var1) {
      do {
         if(this.field1229 < 0) {
            this.method1188(var1);
            return;
         }

         if(this.field1226 + var1 < this.field1229) {
            this.field1226 += var1;
            this.method1188(var1);
            return;
         }

         int var2 = this.field1229 - this.field1226;
         this.method1188(var2);
         var1 -= var2;
         this.field1226 += var2;
         this.method1179();
         class64 var3 = (class64)this.field1227.method3845();
         synchronized(var3) {
            int var5 = var3.method1317(this);
            if(var5 < 0) {
               var3.field1283 = 0;
               this.method1181(var3);
            } else {
               var3.field1283 = var5;
               this.method1180(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }
}
