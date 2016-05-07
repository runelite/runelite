import java.awt.Image;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class44 extends class204 {
   @ObfuscatedName("u")
   int[] field1022;
   @ObfuscatedName("j")
   static class167 field1023;
   @ObfuscatedName("k")
   short[] field1024;
   @ObfuscatedName("x")
   public static class193 field1025 = new class193(64);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 328823507
   )
   public int field1026 = -1;
   @ObfuscatedName("o")
   short[] field1028;
   @ObfuscatedName("b")
   short[] field1029;
   @ObfuscatedName("qj")
   protected static Image field1030;
   @ObfuscatedName("c")
   short[] field1031;
   @ObfuscatedName("t")
   public boolean field1033 = false;
   @ObfuscatedName("s")
   static class167 field1034;
   @ObfuscatedName("aw")
   static String field1035;
   @ObfuscatedName("q")
   static class13 field1036;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1183112573
   )
   public static int field1037;
   @ObfuscatedName("l")
   int[] field1038 = new int[]{-1, -1, -1, -1, -1};

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "10"
   )
   void method896(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(var2 == 0) {
            return;
         }

         this.method909(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Lclass100;",
      garbageValue = "99"
   )
   public class100 method899() {
      if(null == this.field1022) {
         return null;
      } else {
         class100[] var1 = new class100[this.field1022.length];

         for(int var2 = 0; var2 < this.field1022.length; ++var2) {
            var1[var2] = class100.method2181(field1023, this.field1022[var2], 0);
         }

         class100 var4;
         if(1 == var1.length) {
            var4 = var1[0];
         } else {
            var4 = new class100(var1, var1.length);
         }

         int var3;
         if(this.field1028 != null) {
            for(var3 = 0; var3 < this.field1028.length; ++var3) {
               var4.method2194(this.field1028[var3], this.field1029[var3]);
            }
         }

         if(this.field1024 != null) {
            for(var3 = 0; var3 < this.field1024.length; ++var3) {
               var4.method2195(this.field1024[var3], this.field1031[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1143423580"
   )
   public boolean method900() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1038[var2] != -1 && !field1023.method3272(this.field1038[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass122;S)V",
      garbageValue = "2191"
   )
   static final void method907(class122 var0) {
      var0.method2739();
      int var1 = client.field291;
      class2 var2 = class106.field1881 = client.field491[var1] = new class2();
      var2.field42 = var1;
      int var3 = var0.method2750(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field866[0] = var5 - class22.field594;
      var2.field823 = (var2.field866[0] << 7) + (var2.method20() << 6);
      var2.field863[0] = var6 - class114.field1981;
      var2.field813 = (var2.field863[0] << 7) + (var2.method20() << 6);
      var2.field55 = var4 * 2105743795;
      class21.field581 = var4;
      if(null != class32.field768[var1]) {
         var2.method11(class32.field768[var1]);
      }

      class32.field755 = 0;
      class32.field756[++class32.field755 - 1] = var1;
      class32.field752[var1] = 0;
      class32.field757 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2750(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class32.field759[var7] = var11 + (var10 << 14) + (var9 << 28);
            class32.field760[var7] = 0;
            class32.field761[var7] = -1;
            class32.field751[++class32.field757 - 1] = var7;
            class32.field752[var7] = 0;
         }
      }

      var0.method2740();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-913629866"
   )
   void method909(class119 var1, int var2) {
      if(1 == var2) {
         this.field1026 = var1.method2492();
      } else {
         int var3;
         int var4;
         if(2 == var2) {
            var3 = var1.method2492();
            this.field1022 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1022[var4] = var1.method2584();
            }
         } else if(3 == var2) {
            this.field1033 = true;
         } else if(var2 == 40) {
            var3 = var1.method2492();
            this.field1028 = new short[var3];
            this.field1029 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1028[var4] = (short)var1.method2584();
               this.field1029[var4] = (short)var1.method2584();
            }
         } else if(var2 == 41) {
            var3 = var1.method2492();
            this.field1024 = new short[var3];
            this.field1031 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1024[var4] = (short)var1.method2584();
               this.field1031[var4] = (short)var1.method2584();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1038[var2 - 60] = var1.method2584();
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "1666811330"
   )
   public class100 method919() {
      class100[] var1 = new class100[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(-1 != this.field1038[var3]) {
            var1[var2++] = class100.method2181(field1023, this.field1038[var3], 0);
         }
      }

      class100 var5 = new class100(var1, var2);
      int var4;
      if(this.field1028 != null) {
         for(var4 = 0; var4 < this.field1028.length; ++var4) {
            var5.method2194(this.field1028[var4], this.field1029[var4]);
         }
      }

      if(this.field1024 != null) {
         for(var4 = 0; var4 < this.field1024.length; ++var4) {
            var5.method2195(this.field1024[var4], this.field1031[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method921() {
      if(null == this.field1022) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1022.length; ++var2) {
            if(!field1023.method3272(this.field1022[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }
}
