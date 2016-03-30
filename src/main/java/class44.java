import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class44 extends class204 {
   @ObfuscatedName("l")
   short[] field1032;
   @ObfuscatedName("p")
   public static class193 field1033 = new class193(64);
   @ObfuscatedName("m")
   short[] field1034;
   @ObfuscatedName("y")
   int[] field1035;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -946186431
   )
   public int field1036 = -1;
   @ObfuscatedName("x")
   static class167 field1037;
   @ObfuscatedName("v")
   short[] field1038;
   @ObfuscatedName("c")
   short[] field1039;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1657187239
   )
   public static int field1041;
   @ObfuscatedName("z")
   int[] field1042 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("s")
   public boolean field1043 = false;
   @ObfuscatedName("ez")
   static class78[] field1044;
   @ObfuscatedName("w")
   static class167 field1048;

   @ObfuscatedName("m")
   public boolean method952() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(-1 != this.field1042[var2] && !field1037.method3290(this.field1042[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "7"
   )
   void method953(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(0 == var2) {
            return;
         }

         this.method954(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "376991518"
   )
   void method954(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1036 = var1.method2506();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2506();
            this.field1035 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1035[var4] = var1.method2508();
            }
         } else if(3 == var2) {
            this.field1043 = true;
         } else if(var2 == 40) {
            var3 = var1.method2506();
            this.field1034 = new short[var3];
            this.field1039 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1034[var4] = (short)var1.method2508();
               this.field1039[var4] = (short)var1.method2508();
            }
         } else if(41 == var2) {
            var3 = var1.method2506();
            this.field1038 = new short[var3];
            this.field1032 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1038[var4] = (short)var1.method2508();
               this.field1032[var4] = (short)var1.method2508();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1042[var2 - 60] = var1.method2508();
         }
      }

   }

   @ObfuscatedName("e")
   public boolean method955() {
      if(this.field1035 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1035.length; ++var2) {
            if(!field1037.method3290(this.field1035[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("c")
   public class100 method958() {
      class100[] var1 = new class100[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(-1 != this.field1042[var3]) {
            var1[var2++] = class100.method2214(field1037, this.field1042[var3], 0);
         }
      }

      class100 var5 = new class100(var1, var2);
      int var4;
      if(null != this.field1034) {
         for(var4 = 0; var4 < this.field1034.length; ++var4) {
            var5.method2238(this.field1034[var4], this.field1039[var4]);
         }
      }

      if(this.field1038 != null) {
         for(var4 = 0; var4 < this.field1038.length; ++var4) {
            var5.method2205(this.field1038[var4], this.field1032[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("y")
   public class100 method963() {
      if(null == this.field1035) {
         return null;
      } else {
         class100[] var1 = new class100[this.field1035.length];

         for(int var2 = 0; var2 < this.field1035.length; ++var2) {
            var1[var2] = class100.method2214(field1037, this.field1035[var2], 0);
         }

         class100 var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new class100(var1, var1.length);
         }

         int var3;
         if(this.field1034 != null) {
            for(var3 = 0; var3 < this.field1034.length; ++var3) {
               var4.method2238(this.field1034[var3], this.field1039[var3]);
            }
         }

         if(null != this.field1038) {
            for(var3 = 0; var3 < this.field1038.length; ++var3) {
               var4.method2205(this.field1038[var3], this.field1032[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   static final int method978(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("ai")
   static int method979() {
      return client.field508?2:1;
   }
}
