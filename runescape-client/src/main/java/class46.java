import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("KitDefinition")
public class class46 extends class207 {
   @ObfuscatedName("o")
   static class196 field1047 = new class196(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1976552863
   )
   public int field1048 = -1;
   @ObfuscatedName("m")
   public static class170 field1049;
   @ObfuscatedName("l")
   int[] field1050;
   @ObfuscatedName("r")
   short[] field1051;
   @ObfuscatedName("j")
   short[] field1052;
   @ObfuscatedName("k")
   short[] field1053;
   @ObfuscatedName("v")
   int[] field1054 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("h")
   public boolean field1055 = false;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 407856965
   )
   public static int field1058;
   @ObfuscatedName("w")
   public static String field1060;
   @ObfuscatedName("x")
   short[] field1063;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "107"
   )
   @Export("ready")
   public boolean method959() {
      if(this.field1050 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1050.length; ++var2) {
            if(!class169.field2722.method3359(this.field1050[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1326608335"
   )
   void method961(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1048 = var1.method2556();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2556();
            this.field1050 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1050[var4] = var1.method2706();
            }
         } else if(var2 == 3) {
            this.field1055 = true;
         } else if(var2 == 40) {
            var3 = var1.method2556();
            this.field1052 = new short[var3];
            this.field1051 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1052[var4] = (short)var1.method2706();
               this.field1051[var4] = (short)var1.method2706();
            }
         } else if(var2 == 41) {
            var3 = var1.method2556();
            this.field1063 = new short[var3];
            this.field1053 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1063[var4] = (short)var1.method2706();
               this.field1053[var4] = (short)var1.method2706();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1054[var2 - 60] = var1.method2706();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Lclass103;",
      garbageValue = "0"
   )
   @Export("getModelData")
   public class103 method963() {
      if(null == this.field1050) {
         return null;
      } else {
         class103[] var1 = new class103[this.field1050.length];

         for(int var4 = 0; var4 < this.field1050.length; ++var4) {
            var1[var4] = class103.method2323(class169.field2722, this.field1050[var4], 0);
         }

         class103 var2;
         if(var1.length == 1) {
            var2 = var1[0];
         } else {
            var2 = new class103(var1, var1.length);
         }

         int var3;
         if(this.field1052 != null) {
            for(var3 = 0; var3 < this.field1052.length; ++var3) {
               var2.method2317(this.field1052[var3], this.field1051[var3]);
            }
         }

         if(null != this.field1063) {
            for(var3 = 0; var3 < this.field1063.length; ++var3) {
               var2.method2298(this.field1063[var3], this.field1053[var3]);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2023820793"
   )
   public boolean method965() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1054[var2] != -1 && !class169.field2722.method3359(this.field1054[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass103;",
      garbageValue = "-912404761"
   )
   public class103 method967() {
      class103[] var1 = new class103[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1054[var3] != -1) {
            var1[var2++] = class103.method2323(class169.field2722, this.field1054[var3], 0);
         }
      }

      class103 var5 = new class103(var1, var2);
      int var4;
      if(null != this.field1052) {
         for(var4 = 0; var4 < this.field1052.length; ++var4) {
            var5.method2317(this.field1052[var4], this.field1051[var4]);
         }
      }

      if(null != this.field1063) {
         for(var4 = 0; var4 < this.field1063.length; ++var4) {
            var5.method2298(this.field1063[var4], this.field1053[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1455453059"
   )
   public static void method969() {
      class186.field3007.method3750();
      class186.field3004 = 1;
      class128.field2089 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "25"
   )
   void method971(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method961(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1479571670"
   )
   static void method978(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != class27.field649[var5]) {
            var2[var4] = class27.field649[var5];
            var3[var4] = class27.field648[var5];
            ++var4;
         }
      }

      class27.field649 = var2;
      class27.field648 = var3;
      class102.method2282(class219.field3210, 0, class219.field3210.length - 1, class27.field649, class27.field648);
   }
}
