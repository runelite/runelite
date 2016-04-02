import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("an")
public class class44 extends class204 {
   @ObfuscatedName("a")
   short[] field1001;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1070237351
   )
   public static int field1002;
   @ObfuscatedName("s")
   static class193 field1003 = new class193(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1691743813
   )
   public int field1004 = -1;
   @ObfuscatedName("e")
   public static class167 field1005;
   @ObfuscatedName("n")
   public boolean field1006 = false;
   @ObfuscatedName("w")
   public static class167 field1007;
   @ObfuscatedName("r")
   short[] field1008;
   @ObfuscatedName("k")
   short[] field1009;
   @ObfuscatedName("m")
   int[] field1010 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("h")
   int[] field1011;
   @ObfuscatedName("mr")
   static byte field1012;
   @ObfuscatedName("g")
   short[] field1013;

   @ObfuscatedName("w")
   void method920(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(0 == var2) {
            return;
         }

         this.method922(var1, var2);
      }
   }

   @ObfuscatedName("f")
   void method922(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1004 = var1.method2523();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2523();
            this.field1011 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1011[var4] = var1.method2700();
            }
         } else if(3 == var2) {
            this.field1006 = true;
         } else if(var2 == 40) {
            var3 = var1.method2523();
            this.field1013 = new short[var3];
            this.field1001 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1013[var4] = (short)var1.method2700();
               this.field1001[var4] = (short)var1.method2700();
            }
         } else if(41 == var2) {
            var3 = var1.method2523();
            this.field1008 = new short[var3];
            this.field1009 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1008[var4] = (short)var1.method2700();
               this.field1009[var4] = (short)var1.method2700();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1010[var2 - 60] = var1.method2700();
         }
      }

   }

   @ObfuscatedName("p")
   public class100 method923() {
      if(this.field1011 == null) {
         return null;
      } else {
         class100[] var1 = new class100[this.field1011.length];

         for(int var2 = 0; var2 < this.field1011.length; ++var2) {
            var1[var2] = class100.method2221(field1007, this.field1011[var2], 0);
         }

         class100 var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new class100(var1, var1.length);
         }

         int var3;
         if(this.field1013 != null) {
            for(var3 = 0; var3 < this.field1013.length; ++var3) {
               var4.method2234(this.field1013[var3], this.field1001[var3]);
            }
         }

         if(this.field1008 != null) {
            for(var3 = 0; var3 < this.field1008.length; ++var3) {
               var4.method2235(this.field1008[var3], this.field1009[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("h")
   public boolean method924() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(-1 != this.field1010[var2] && !field1007.method3264(this.field1010[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("g")
   public class100 method925() {
      class100[] var1 = new class100[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1010[var3] != -1) {
            var1[var2++] = class100.method2221(field1007, this.field1010[var3], 0);
         }
      }

      class100 var5 = new class100(var1, var2);
      int var4;
      if(null != this.field1013) {
         for(var4 = 0; var4 < this.field1013.length; ++var4) {
            var5.method2234(this.field1013[var4], this.field1001[var4]);
         }
      }

      if(this.field1008 != null) {
         for(var4 = 0; var4 < this.field1008.length; ++var4) {
            var5.method2235(this.field1008[var4], this.field1009[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("s")
   public boolean method936() {
      if(null == this.field1011) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1011.length; ++var2) {
            if(!field1007.method3264(this.field1011[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("y")
   public static int method944(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("bb")
   static final void method945(class30 var0, int var1, int var2) {
      class56.method1179(var0.field690, var0.field682, var0.field683, var0.field684, var0.field681, var1, var2);
   }
}
