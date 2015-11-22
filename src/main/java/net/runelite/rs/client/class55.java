package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class55 extends class66 {
   @ObfuscatedName("m")
   class198 field1157 = new class198();
   @ObfuscatedName("j")
   class198 field1158 = new class198();
   @ObfuscatedName("f")
   int field1159 = 0;
   @ObfuscatedName("l")
   int field1160 = -1;

   @ObfuscatedName("s")
   public final synchronized void vmethod3787(int var1) {
      do {
         if(this.field1160 < 0) {
            this.method1187(var1);
            return;
         }

         if(this.field1159 + var1 < this.field1160) {
            this.field1159 += var1;
            this.method1187(var1);
            return;
         }

         int var2 = this.field1160 - this.field1159;
         this.method1187(var2);
         var1 -= var2;
         this.field1159 += var2;
         this.method1178();
         class61 var3 = (class61)this.field1157.method3871();
         synchronized(var3) {
            int var5 = var3.method1315();
            if(var5 < 0) {
               var3.field1217 = 0;
               this.method1180(var3);
            } else {
               var3.field1217 = var5;
               this.method1179(var3.field3102, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("m")
   public final synchronized void method1177(class66 var1) {
      var1.method3965();
   }

   @ObfuscatedName("f")
   void method1178() {
      if(this.field1159 > 0) {
         for(class61 var1 = (class61)this.field1157.method3871(); var1 != null; var1 = (class61)this.field1157.method3873()) {
            var1.field1217 -= this.field1159;
         }

         this.field1160 -= this.field1159;
         this.field1159 = 0;
      }

   }

   @ObfuscatedName("l")
   void method1179(class207 var1, class61 var2) {
      while(var1 != this.field1157.field3086 && ((class61)var1).field1217 <= var2.field1217) {
         var1 = var1.field3102;
      }

      class198.method3887(var2, var1);
      this.field1160 = ((class61)this.field1157.field3086.field3102).field1217;
   }

   @ObfuscatedName("u")
   void method1180(class61 var1) {
      var1.method3965();
      var1.method1313();
      class207 var2 = this.field1157.field3086.field3102;
      if(var2 == this.field1157.field3086) {
         this.field1160 = -1;
      } else {
         this.field1160 = ((class61)var2).field1217;
      }

   }

   @ObfuscatedName("a")
   protected class66 vmethod3774() {
      return (class66)this.field1158.method3871();
   }

   @ObfuscatedName("h")
   protected class66 vmethod3770() {
      return (class66)this.field1158.method3873();
   }

   @ObfuscatedName("i")
   protected int vmethod3772() {
      return 0;
   }

   @ObfuscatedName("t")
   public final synchronized void vmethod3784(int[] var1, int var2, int var3) {
      do {
         if(this.field1160 < 0) {
            this.method1185(var1, var2, var3);
            return;
         }

         if(this.field1159 + var3 < this.field1160) {
            this.field1159 += var3;
            this.method1185(var1, var2, var3);
            return;
         }

         int var4 = this.field1160 - this.field1159;
         this.method1185(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1159 += var4;
         this.method1178();
         class61 var5 = (class61)this.field1157.method3871();
         synchronized(var5) {
            int var7 = var5.method1315();
            if(var7 < 0) {
               var5.field1217 = 0;
               this.method1180(var5);
            } else {
               var5.field1217 = var7;
               this.method1179(var5.field3102, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("k")
   void method1185(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1158.method3871(); var4 != null; var4 = (class66)this.field1158.method3873()) {
         var4.method1492(var1, var2, var3);
      }

   }

   @ObfuscatedName("w")
   void method1187(int var1) {
      for(class66 var2 = (class66)this.field1158.method3871(); var2 != null; var2 = (class66)this.field1158.method3873()) {
         var2.vmethod3787(var1);
      }

   }

   @ObfuscatedName("j")
   public final synchronized void method1200(class66 var1) {
      this.field1158.method3867(var1);
   }
}
