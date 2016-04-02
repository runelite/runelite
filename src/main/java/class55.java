import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
public class class55 extends class66 {
   @ObfuscatedName("e")
   class199 field1144 = new class199();
   @ObfuscatedName("f")
   class199 field1145 = new class199();
   @ObfuscatedName("s")
   int field1146 = 0;
   @ObfuscatedName("p")
   int field1147 = -1;

   @ObfuscatedName("e")
   public final synchronized void method1128(class66 var1) {
      this.field1144.method3821(var1);
   }

   @ObfuscatedName("h")
   protected class66 vmethod3713() {
      return (class66)this.field1144.method3825();
   }

   @ObfuscatedName("p")
   void method1132(class61 var1) {
      var1.method3913();
      var1.method1269();
      class208 var2 = this.field1145.field3099.field3114;
      if(var2 == this.field1145.field3099) {
         this.field1147 = -1;
      } else {
         this.field1147 = ((class61)var2).field1201;
      }

   }

   @ObfuscatedName("g")
   protected class66 vmethod3733() {
      return (class66)this.field1144.method3827();
   }

   @ObfuscatedName("a")
   protected int vmethod3715() {
      return 0;
   }

   @ObfuscatedName("k")
   void method1137(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1144.method3825(); var4 != null; var4 = (class66)this.field1144.method3827()) {
         var4.method1465(var1, var2, var3);
      }

   }

   @ObfuscatedName("m")
   public final synchronized void vmethod3717(int var1) {
      do {
         if(this.field1147 < 0) {
            this.method1139(var1);
            return;
         }

         if(this.field1146 + var1 < this.field1147) {
            this.field1146 += var1;
            this.method1139(var1);
            return;
         }

         int var2 = this.field1147 - this.field1146;
         this.method1139(var2);
         var1 -= var2;
         this.field1146 += var2;
         this.method1140();
         class61 var3 = (class61)this.field1145.method3825();
         synchronized(var3) {
            int var5 = var3.method1274();
            if(var5 < 0) {
               var3.field1201 = 0;
               this.method1132(var3);
            } else {
               var3.field1201 = var5;
               this.method1142(var3.field3114, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("n")
   void method1139(int var1) {
      for(class66 var2 = (class66)this.field1144.method3825(); var2 != null; var2 = (class66)this.field1144.method3827()) {
         var2.vmethod3717(var1);
      }

   }

   @ObfuscatedName("f")
   void method1140() {
      if(this.field1146 > 0) {
         for(class61 var1 = (class61)this.field1145.method3825(); var1 != null; var1 = (class61)this.field1145.method3827()) {
            var1.field1201 -= this.field1146;
         }

         this.field1147 -= this.field1146;
         this.field1146 = 0;
      }

   }

   @ObfuscatedName("s")
   void method1142(class208 var1, class61 var2) {
      while(var1 != this.field1145.field3099 && ((class61)var1).field1201 <= var2.field1201) {
         var1 = var1.field3114;
      }

      class199.method3822(var2, var1);
      this.field1147 = ((class61)this.field1145.field3099.field3114).field1201;
   }

   @ObfuscatedName("w")
   public final synchronized void method1146(class66 var1) {
      var1.method3913();
   }

   @ObfuscatedName("r")
   public final synchronized void vmethod3716(int[] var1, int var2, int var3) {
      do {
         if(this.field1147 < 0) {
            this.method1137(var1, var2, var3);
            return;
         }

         if(this.field1146 + var3 < this.field1147) {
            this.field1146 += var3;
            this.method1137(var1, var2, var3);
            return;
         }

         int var4 = this.field1147 - this.field1146;
         this.method1137(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1146 += var4;
         this.method1140();
         class61 var5 = (class61)this.field1145.method3825();
         synchronized(var5) {
            int var7 = var5.method1274();
            if(var7 < 0) {
               var5.field1201 = 0;
               this.method1132(var5);
            } else {
               var5.field1201 = var7;
               this.method1142(var5.field3114, var5);
            }
         }
      } while(var3 != 0);

   }
}
