import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class43 extends class204 {
   @ObfuscatedName("d")
   static class193 field1014 = new class193(64);
   @ObfuscatedName("c")
   static class193 field1016 = new class193(30);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 582059199
   )
   int field1017 = 128;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1560848921
   )
   int field1018;
   @ObfuscatedName("h")
   static int[] field1019;
   @ObfuscatedName("p")
   short[] field1020;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1064168583
   )
   public int field1021 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2121506193
   )
   int field1022 = 0;
   @ObfuscatedName("e")
   short[] field1023;
   @ObfuscatedName("w")
   static class167 field1024;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 118670353
   )
   int field1025 = 128;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 508674213
   )
   int field1026 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1169009135
   )
   int field1027 = 0;
   @ObfuscatedName("q")
   short[] field1028;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1324765159
   )
   int field1030;
   @ObfuscatedName("m")
   short[] field1031;
   @ObfuscatedName("ip")
   static class173 field1032;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -546949215
   )
   static int field1033;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = -2248851
   )
   static int field1034;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1984758120"
   )
   void method993(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(var2 == 0) {
            return;
         }

         this.method999(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Lclass105;",
      garbageValue = "85125453"
   )
   public final class105 method994(int var1) {
      class105 var2 = (class105)field1016.method3840((long)this.field1030);
      if(null == var2) {
         class100 var3 = class100.method2307(field1024, this.field1018, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(this.field1020 != null) {
            for(var4 = 0; var4 < this.field1020.length; ++var4) {
               var3.method2303(this.field1020[var4], this.field1028[var4]);
            }
         }

         if(null != this.field1031) {
            for(var4 = 0; var4 < this.field1031.length; ++var4) {
               var3.method2304(this.field1031[var4], this.field1023[var4]);
            }
         }

         var2 = var3.method2368(this.field1027 + 64, this.field1022 + 850, -30, -50, -30);
         field1016.method3842(var2, (long)this.field1030);
      }

      class105 var5;
      if(this.field1021 != -1 && -1 != var1) {
         var5 = class96.method2279(this.field1021).method956(var2, var1);
      } else {
         var5 = var2.method2390(true);
      }

      if(this.field1017 != 128 || 128 != this.field1025) {
         var5.method2403(this.field1017, this.field1025, this.field1017);
      }

      if(this.field1026 != 0) {
         if(90 == this.field1026) {
            var5.method2398();
         }

         if(180 == this.field1026) {
            var5.method2398();
            var5.method2398();
         }

         if(this.field1026 == 270) {
            var5.method2398();
            var5.method2398();
            var5.method2398();
         }
      }

      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;Lclass167;Lclass167;B)V",
      garbageValue = "98"
   )
   public static void method995(class167 var0, class167 var1, class167 var2, class167 var3) {
      class173.field2802 = var0;
      class173.field2841 = var1;
      class189.field3058 = var2;
      class173.field2751 = var3;
      class173.field2886 = new class173[class173.field2802.method3411()][];
      class163.field2642 = new boolean[class173.field2802.method3411()];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1470453556"
   )
   void method999(class119 var1, int var2) {
      if(1 == var2) {
         this.field1018 = var1.method2615();
      } else if(var2 == 2) {
         this.field1021 = var1.method2615();
      } else if(4 == var2) {
         this.field1017 = var1.method2615();
      } else if(var2 == 5) {
         this.field1025 = var1.method2615();
      } else if(var2 == 6) {
         this.field1026 = var1.method2615();
      } else if(var2 == 7) {
         this.field1027 = var1.method2613();
      } else if(8 == var2) {
         this.field1022 = var1.method2613();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2613();
            this.field1020 = new short[var3];
            this.field1028 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1020[var4] = (short)var1.method2615();
               this.field1028[var4] = (short)var1.method2615();
            }
         } else if(var2 == 41) {
            var3 = var1.method2613();
            this.field1031 = new short[var3];
            this.field1023 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1031[var4] = (short)var1.method2615();
               this.field1023[var4] = (short)var1.method2615();
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lclass52;",
      garbageValue = "1835914535"
   )
   public static class52 method1009(int var0) {
      class52 var1 = (class52)class52.field1170.method3840((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class52.field1173.method3403(16, var0);
         var1 = new class52();
         if(null != var2) {
            var1.method1181(new class119(var2));
         }

         class52.field1170.method3842(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-31"
   )
   static void method1011(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field230.method3868((long)var0);
      if(null == var4) {
         var4 = new class15();
         class15.field230.method3875(var4, (long)var0);
      }

      if(var4.field229.length <= var1) {
         int[] var5 = new int[1 + var1];
         int[] var6 = new int[1 + var1];

         int var7;
         for(var7 = 0; var7 < var4.field229.length; ++var7) {
            var5[var7] = var4.field229[var7];
            var6[var7] = var4.field234[var7];
         }

         for(var7 = var4.field229.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field229 = var5;
         var4.field234 = var6;
      }

      var4.field229[var1] = var2;
      var4.field234[var1] = var3;
   }
}
