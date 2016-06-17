import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("KitDefinition")
public class class44 extends class204 {
   @ObfuscatedName("l")
   short[] field1005;
   @ObfuscatedName("g")
   static class167 field1006;
   @ObfuscatedName("r")
   short[] field1007;
   @ObfuscatedName("d")
   public static class193 field1008 = new class193(64);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 530677427
   )
   public int field1009 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1720649993
   )
   public static int field1010;
   @ObfuscatedName("c")
   short[] field1011;
   @ObfuscatedName("b")
   static class167 field1012;
   @ObfuscatedName("y")
   int[] field1013;
   @ObfuscatedName("u")
   short[] field1014;
   @ObfuscatedName("p")
   int[] field1015 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("n")
   public boolean field1016 = false;
   @ObfuscatedName("me")
   static class78 field1017;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1234449123
   )
   static int field1018;
   @ObfuscatedName("ch")
   static class224 field1021;
   @ObfuscatedName("rf")
   protected static String field1022;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "799844964"
   )
   void method922(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1009 = var1.method2514();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2514();
            this.field1013 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1013[var4] = var1.method2516();
            }
         } else if(var2 == 3) {
            this.field1016 = true;
         } else if(var2 == 40) {
            var3 = var1.method2514();
            this.field1007 = new short[var3];
            this.field1011 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1007[var4] = (short)var1.method2516();
               this.field1011[var4] = (short)var1.method2516();
            }
         } else if(var2 == 41) {
            var3 = var1.method2514();
            this.field1005 = new short[var3];
            this.field1014 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1005[var4] = (short)var1.method2516();
               this.field1014[var4] = (short)var1.method2516();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1015[var2 - 60] = var1.method2516();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "469637823"
   )
   @Export("ready")
   public boolean method923() {
      if(null == this.field1013) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1013.length; ++var2) {
            if(!field1006.method3268(this.field1013[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Lclass100;",
      garbageValue = "114"
   )
   @Export("getModelData")
   public class100 method924() {
      if(this.field1013 == null) {
         return null;
      } else {
         class100[] var1 = new class100[this.field1013.length];

         for(int var4 = 0; var4 < this.field1013.length; ++var4) {
            var1[var4] = class100.method2208(field1006, this.field1013[var4], 0);
         }

         class100 var2;
         if(var1.length == 1) {
            var2 = var1[0];
         } else {
            var2 = new class100(var1, var1.length);
         }

         int var3;
         if(this.field1007 != null) {
            for(var3 = 0; var3 < this.field1007.length; ++var3) {
               var2.method2221(this.field1007[var3], this.field1011[var3]);
            }
         }

         if(this.field1005 != null) {
            for(var3 = 0; var3 < this.field1005.length; ++var3) {
               var2.method2222(this.field1005[var3], this.field1014[var3]);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "-830978133"
   )
   public class100 method926() {
      class100[] var1 = new class100[5];
      int var2 = 0;

      for(int var5 = 0; var5 < 5; ++var5) {
         if(this.field1015[var5] != -1) {
            var1[var2++] = class100.method2208(field1006, this.field1015[var5], 0);
         }
      }

      class100 var3 = new class100(var1, var2);
      int var4;
      if(this.field1007 != null) {
         for(var4 = 0; var4 < this.field1007.length; ++var4) {
            var3.method2221(this.field1007[var4], this.field1011[var4]);
         }
      }

      if(this.field1005 != null) {
         for(var4 = 0; var4 < this.field1005.length; ++var4) {
            var3.method2222(this.field1005[var4], this.field1014[var4]);
         }
      }

      return var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1980038464"
   )
   void method928(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method922(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   public boolean method935() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1015[var2] != -1 && !field1006.method3268(this.field1015[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }
}
