package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aw")
public class class46 extends class203 {
   @ObfuscatedName("u")
   public boolean field1032 = true;
   @ObfuscatedName("m")
   public static class192 field1033 = new class192(64);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1568974847
   )
   public int field1034;
   @ObfuscatedName("j")
   static class166 field1035;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1851021547
   )
   public int field1036 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2110473959
   )
   public int field1037;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1215255767
   )
   public int field1038 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 795380717
   )
   public int field1039;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1175918511
   )
   public int field1040;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -611212229
   )
   public int field1041 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 467476531
   )
   public int field1042;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2101933949
   )
   public int field1043;
   @ObfuscatedName("dd")
   static int[] field1044;
   @ObfuscatedName("aq")
   static class145 field1045;

   @ObfuscatedName("f")
   void method995() {
      if(-1 != this.field1036) {
         this.method998(this.field1036);
         this.field1037 = this.field1034;
         this.field1042 = this.field1039;
         this.field1043 = this.field1040;
      }

      this.method998(this.field1041);
   }

   @ObfuscatedName("a")
   void method998(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1034 = (int)(256.0D * var12);
      this.field1039 = (int)(var14 * 256.0D);
      this.field1040 = (int)(256.0D * var16);
      if(this.field1039 < 0) {
         this.field1039 = 0;
      } else if(this.field1039 > 255) {
         this.field1039 = 255;
      }

      if(this.field1040 < 0) {
         this.field1040 = 0;
      } else if(this.field1040 > 255) {
         this.field1040 = 255;
      }

   }

   @ObfuscatedName("u")
   void method999(class118 var1, int var2) {
      if(var2 == 1) {
         this.field1041 = var1.method2540();
      } else if(var2 == 2) {
         this.field1038 = var1.method2536();
      } else if(5 == var2) {
         this.field1032 = false;
      } else if(var2 == 7) {
         this.field1036 = var1.method2540();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("s")
   public static boolean method1007(class166 var0, int var1, int var2) {
      byte[] var3 = var0.method3352(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class94.method2205(var3);
         return true;
      }
   }

   @ObfuscatedName("l")
   void method1008(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(0 == var2) {
            return;
         }

         this.method999(var1, var2);
      }
   }

   @ObfuscatedName("f")
   static void method1011(class167 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class171 var8 = (class171)class170.field2698.method3836(var6);
      if(null == var8) {
         var8 = (class171)class170.field2703.method3836(var6);
         if(var8 == null) {
            var8 = (class171)class170.field2716.method3836(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3945();
                  class170.field2698.method3839(var8, var6);
                  --class170.field2700;
                  ++class170.field2699;
               }

            } else {
               if(!var5) {
                  var8 = (class171)class170.field2705.method3836(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class171();
               var8.field2719 = var0;
               var8.field2718 = var3;
               var8.field2721 = var4;
               if(var5) {
                  class170.field2698.method3839(var8, var6);
                  ++class170.field2699;
               } else {
                  class170.field2707.method3934(var8);
                  class170.field2716.method3839(var8, var6);
                  ++class170.field2700;
               }

            }
         }
      }
   }
}
