import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class58 extends class69 {
   @ObfuscatedName("j")
   int field1218 = 0;
   @ObfuscatedName("x")
   Deque field1219 = new Deque();
   @ObfuscatedName("r")
   Deque field1220 = new Deque();
   @ObfuscatedName("z")
   int field1221 = -1;

   @ObfuscatedName("m")
   protected int vmethod3747() {
      return 0;
   }

   @ObfuscatedName("x")
   public final synchronized void method1179(class69 var1) {
      this.field1219.method3846(var1);
   }

   @ObfuscatedName("r")
   public final synchronized void method1180(class69 var1) {
      var1.unlink();
   }

   @ObfuscatedName("j")
   void method1181() {
      if(this.field1218 > 0) {
         for(class64 var1 = (class64)this.field1220.method3850(); var1 != null; var1 = (class64)this.field1220.method3852()) {
            var1.field1273 -= this.field1218;
         }

         this.field1221 -= this.field1218;
         this.field1218 = 0;
      }

   }

   @ObfuscatedName("b")
   protected class69 vmethod3753() {
      return (class69)this.field1219.method3850();
   }

   @ObfuscatedName("l")
   protected class69 vmethod3746() {
      return (class69)this.field1219.method3852();
   }

   @ObfuscatedName("z")
   void method1187(Node var1, class64 var2) {
      while(var1 != this.field1220.head && ((class64)var1).field1273 <= var2.field1273) {
         var1 = var1.next;
      }

      Deque.method3847(var2, var1);
      this.field1221 = ((class64)this.field1220.head.next).field1273;
   }

   @ObfuscatedName("f")
   void method1188(int[] var1, int var2, int var3) {
      for(class69 var4 = (class69)this.field1219.method3850(); var4 != null; var4 = (class69)this.field1219.method3852()) {
         var4.method1500(var1, var2, var3);
      }

   }

   @ObfuscatedName("d")
   public final synchronized void vmethod3749(int var1) {
      do {
         if(this.field1221 < 0) {
            this.method1190(var1);
            return;
         }

         if(this.field1218 + var1 < this.field1221) {
            this.field1218 += var1;
            this.method1190(var1);
            return;
         }

         int var2 = this.field1221 - this.field1218;
         this.method1190(var2);
         var1 -= var2;
         this.field1218 += var2;
         this.method1181();
         class64 var3 = (class64)this.field1220.method3850();
         synchronized(var3) {
            int var5 = var3.method1317(this);
            if(var5 < 0) {
               var3.field1273 = 0;
               this.method1204(var3);
            } else {
               var3.field1273 = var5;
               this.method1187(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("v")
   void method1190(int var1) {
      for(class69 var2 = (class69)this.field1219.method3850(); var2 != null; var2 = (class69)this.field1219.method3852()) {
         var2.vmethod3749(var1);
      }

   }

   @ObfuscatedName("i")
   void method1204(class64 var1) {
      var1.unlink();
      var1.method1318();
      Node var2 = this.field1220.head.next;
      if(var2 == this.field1220.head) {
         this.field1221 = -1;
      } else {
         this.field1221 = ((class64)var2).field1273;
      }

   }

   @ObfuscatedName("p")
   public final synchronized void vmethod3748(int[] var1, int var2, int var3) {
      do {
         if(this.field1221 < 0) {
            this.method1188(var1, var2, var3);
            return;
         }

         if(this.field1218 + var3 < this.field1221) {
            this.field1218 += var3;
            this.method1188(var1, var2, var3);
            return;
         }

         int var4 = this.field1221 - this.field1218;
         this.method1188(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1218 += var4;
         this.method1181();
         class64 var5 = (class64)this.field1220.method3850();
         synchronized(var5) {
            int var7 = var5.method1317(this);
            if(var7 < 0) {
               var5.field1273 = 0;
               this.method1204(var5);
            } else {
               var5.field1273 = var7;
               this.method1187(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }
}
