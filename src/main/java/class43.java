import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class43 extends class204 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1472363773
   )
   int field1012;
   @ObfuscatedName("x")
   public static class167 field1013;
   @ObfuscatedName("t")
   public static class193 field1014 = new class193(64);
   @ObfuscatedName("p")
   public static class193 field1015 = new class193(30);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -786529649
   )
   int field1016 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2105968375
   )
   int field1017;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1049287181
   )
   public int field1018 = -1;
   @ObfuscatedName("w")
   public static class167 field1020;
   @ObfuscatedName("l")
   short[] field1021;
   @ObfuscatedName("z")
   short[] field1022;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1844877653
   )
   int field1023 = 128;
   @ObfuscatedName("v")
   short[] field1024;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 853245837
   )
   int field1025 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1406692983
   )
   int field1026 = 0;
   @ObfuscatedName("c")
   short[] field1027;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2100323455
   )
   int field1029 = 128;

   @ObfuscatedName("p")
   public final class105 method937(int var1) {
      class105 var2 = (class105)field1015.method3771((long)this.field1012);
      if(null == var2) {
         class100 var3 = class100.method2214(field1013, this.field1017, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(this.field1027 != null) {
            for(var4 = 0; var4 < this.field1027.length; ++var4) {
               var3.method2238(this.field1027[var4], this.field1024[var4]);
            }
         }

         if(this.field1021 != null) {
            for(var4 = 0; var4 < this.field1021.length; ++var4) {
               var3.method2205(this.field1021[var4], this.field1022[var4]);
            }
         }

         var2 = var3.method2212(this.field1026 + 64, this.field1016 + 850, -30, -50, -30);
         field1015.method3773(var2, (long)this.field1012);
      }

      class105 var5;
      if(-1 != this.field1018 && var1 != -1) {
         var5 = class96.method2187(this.field1018).method904(var2, var1);
      } else {
         var5 = var2.method2302(true);
      }

      if(this.field1029 != 128 || this.field1023 != 128) {
         var5.method2315(this.field1029, this.field1023, this.field1029);
      }

      if(this.field1025 != 0) {
         if(this.field1025 == 90) {
            var5.method2310();
         }

         if(this.field1025 == 180) {
            var5.method2310();
            var5.method2310();
         }

         if(270 == this.field1025) {
            var5.method2310();
            var5.method2310();
            var5.method2310();
         }
      }

      return var5;
   }

   @ObfuscatedName("an")
   static final int method938(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.field109[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class5.field96[var5][var3][var4] + var6 * class5.field96[var5][var3 + 1][var4] >> 7;
         int var9 = class5.field96[var5][var3 + 1][var4 + 1] * var6 + (128 - var6) * class5.field96[var5][var3][1 + var4] >> 7;
         return (128 - var7) * var8 + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-31"
   )
   void method939(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1017 = var1.method2508();
      } else if(2 == var2) {
         this.field1018 = var1.method2508();
      } else if(4 == var2) {
         this.field1029 = var1.method2508();
      } else if(5 == var2) {
         this.field1023 = var1.method2508();
      } else if(6 == var2) {
         this.field1025 = var1.method2508();
      } else if(var2 == 7) {
         this.field1026 = var1.method2506();
      } else if(8 == var2) {
         this.field1016 = var1.method2506();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2506();
            this.field1027 = new short[var3];
            this.field1024 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1027[var4] = (short)var1.method2508();
               this.field1024[var4] = (short)var1.method2508();
            }
         } else if(var2 == 41) {
            var3 = var1.method2506();
            this.field1021 = new short[var3];
            this.field1022 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1021[var4] = (short)var1.method2508();
               this.field1022[var4] = (short)var1.method2508();
            }
         }
      }

   }

   @ObfuscatedName("q")
   static class224 method944(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         class224 var1 = new class224(var0, class76.field1392, class76.field1388, class76.field1389, class76.field1390, class76.field1391, class10.field180);
         class21.method582();
         return var1;
      }
   }

   @ObfuscatedName("x")
   void method948(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(var2 == 0) {
            return;
         }

         this.method939(var1, var2);
      }
   }

   @ObfuscatedName("ci")
   static void method950(class173 var0) {
      class173 var1 = -1 == var0.field2786?null:class52.method1115(var0.field2786);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class15.field235;
         var3 = class15.field233;
      } else {
         var2 = var1.field2767;
         var3 = var1.field2783;
      }

      class24.method608(var0, var2, var3, false);
      class10.method127(var0, var2, var3);
   }

   @ObfuscatedName("e")
   public static class224 method951(class167 var0, class167 var1, int var2, int var3) {
      return !class121.method2747(var0, var2, var3)?null:method944(var1.method3335(var2, var3));
   }
}
