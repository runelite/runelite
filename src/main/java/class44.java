import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class44 extends class204 {
   @ObfuscatedName("e")
   int[] field1036 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("w")
   public static class167 field1037;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2002881147
   )
   public static int field1038;
   @ObfuscatedName("a")
   public static class167 field1039;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -647395891
   )
   public int field1040 = -1;
   @ObfuscatedName("p")
   short[] field1041;
   @ObfuscatedName("c")
   static class193 field1042 = new class193(64);
   @ObfuscatedName("q")
   short[] field1044;
   @ObfuscatedName("m")
   short[] field1045;
   @ObfuscatedName("r")
   short[] field1046;
   @ObfuscatedName("x")
   public boolean field1047 = false;
   @ObfuscatedName("k")
   int[] field1049;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;S)V",
      garbageValue = "28688"
   )
   void method1013(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(var2 == 0) {
            return;
         }

         this.method1014(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "1"
   )
   void method1014(class119 var1, int var2) {
      if(1 == var2) {
         this.field1040 = var1.method2613();
      } else {
         int var3;
         int var4;
         if(2 == var2) {
            var3 = var1.method2613();
            this.field1049 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1049[var4] = var1.method2615();
            }
         } else if(3 == var2) {
            this.field1047 = true;
         } else if(var2 == 40) {
            var3 = var1.method2613();
            this.field1046 = new short[var3];
            this.field1041 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1046[var4] = (short)var1.method2615();
               this.field1041[var4] = (short)var1.method2615();
            }
         } else if(var2 == 41) {
            var3 = var1.method2613();
            this.field1044 = new short[var3];
            this.field1045 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1044[var4] = (short)var1.method2615();
               this.field1045[var4] = (short)var1.method2615();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1036[var2 - 60] = var1.method2615();
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1552986534"
   )
   public boolean method1017() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(-1 != this.field1036[var2] && !field1037.method3429(this.field1036[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)Lclass100;",
      garbageValue = "-9030"
   )
   public class100 method1028() {
      class100[] var1 = new class100[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1036[var3] != -1) {
            var1[var2++] = class100.method2307(field1037, this.field1036[var3], 0);
         }
      }

      class100 var5 = new class100(var1, var2);
      int var4;
      if(null != this.field1046) {
         for(var4 = 0; var4 < this.field1046.length; ++var4) {
            var5.method2303(this.field1046[var4], this.field1041[var4]);
         }
      }

      if(null != this.field1044) {
         for(var4 = 0; var4 < this.field1044.length; ++var4) {
            var5.method2304(this.field1044[var4], this.field1045[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "-1092265621"
   )
   public class100 method1029() {
      if(this.field1049 == null) {
         return null;
      } else {
         class100[] var1 = new class100[this.field1049.length];

         for(int var2 = 0; var2 < this.field1049.length; ++var2) {
            var1[var2] = class100.method2307(field1037, this.field1049[var2], 0);
         }

         class100 var4;
         if(1 == var1.length) {
            var4 = var1[0];
         } else {
            var4 = new class100(var1, var1.length);
         }

         int var3;
         if(this.field1046 != null) {
            for(var3 = 0; var3 < this.field1046.length; ++var3) {
               var4.method2303(this.field1046[var3], this.field1041[var3]);
            }
         }

         if(this.field1044 != null) {
            for(var3 = 0; var3 < this.field1044.length; ++var3) {
               var4.method2304(this.field1044[var3], this.field1045[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "558865416"
   )
   public boolean method1033() {
      if(null == this.field1049) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1049.length; ++var2) {
            if(!field1037.method3429(this.field1049[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }
}
