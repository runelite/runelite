import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class43 extends class204 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 279977191
   )
   int field983 = 0;
   @ObfuscatedName("f")
   public static class193 field984 = new class193(64);
   @ObfuscatedName("s")
   public static class193 field985 = new class193(30);
   @ObfuscatedName("m")
   short[] field986;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1495105737
   )
   int field987;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1653258851
   )
   public int field988 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 701569079
   )
   int field989;
   @ObfuscatedName("r")
   short[] field990;
   @ObfuscatedName("k")
   short[] field991;
   @ObfuscatedName("w")
   public static class167 field992;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -644069621
   )
   int field993 = 128;
   @ObfuscatedName("a")
   short[] field994;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1187192193
   )
   int field995 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -939034291
   )
   int field996 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1093391775
   )
   int field997 = 128;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-41"
   )
   void method899(class119 var1, int var2) {
      if(1 == var2) {
         this.field987 = var1.method2700();
      } else if(2 == var2) {
         this.field988 = var1.method2700();
      } else if(var2 == 4) {
         this.field993 = var1.method2700();
      } else if(var2 == 5) {
         this.field997 = var1.method2700();
      } else if(var2 == 6) {
         this.field995 = var1.method2700();
      } else if(var2 == 7) {
         this.field996 = var1.method2523();
      } else if(8 == var2) {
         this.field983 = var1.method2523();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2523();
            this.field994 = new short[var3];
            this.field990 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field994[var4] = (short)var1.method2700();
               this.field990[var4] = (short)var1.method2700();
            }
         } else if(41 == var2) {
            var3 = var1.method2523();
            this.field991 = new short[var3];
            this.field986 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field991[var4] = (short)var1.method2700();
               this.field986[var4] = (short)var1.method2700();
            }
         }
      }

   }

   @ObfuscatedName("w")
   void method900(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(var2 == 0) {
            return;
         }

         this.method899(var1, var2);
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1859984120"
   )
   static final void method902() {
      int var0 = class32.field731;
      int[] var1 = class32.field732;

      for(int var2 = 0; var2 < var0; ++var2) {
         class2 var3 = client.field387[var1[var2]];
         if(var3 != null) {
            class59.method1260(var3);
         }
      }

   }

   @ObfuscatedName("o")
   public static void method904() {
      class51.field1129.method3760();
   }

   @ObfuscatedName("s")
   public final class105 method914(int var1) {
      class105 var2 = (class105)field985.method3754((long)this.field989);
      if(null == var2) {
         class100 var3 = class100.method2221(field992, this.field987, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(this.field994 != null) {
            for(var4 = 0; var4 < this.field994.length; ++var4) {
               var3.method2234(this.field994[var4], this.field990[var4]);
            }
         }

         if(this.field991 != null) {
            for(var4 = 0; var4 < this.field991.length; ++var4) {
               var3.method2235(this.field991[var4], this.field986[var4]);
            }
         }

         var2 = var3.method2236(this.field996 + 64, 850 + this.field983, -30, -50, -30);
         field985.method3756(var2, (long)this.field989);
      }

      class105 var5;
      if(this.field988 != -1 && -1 != var1) {
         var5 = class46.method974(this.field988).method862(var2, var1);
      } else {
         var5 = var2.method2366(true);
      }

      if(this.field993 != 128 || this.field997 != 128) {
         var5.method2384(this.field993, this.field997, this.field993);
      }

      if(0 != this.field995) {
         if(this.field995 == 90) {
            var5.method2381();
         }

         if(180 == this.field995) {
            var5.method2381();
            var5.method2381();
         }

         if(270 == this.field995) {
            var5.method2381();
            var5.method2381();
            var5.method2381();
         }
      }

      return var5;
   }

   @ObfuscatedName("f")
   static void method915() {
      class227 var0 = null;

      try {
         var0 = class143.method3003("", class164.field2657.field2278, true);
         class119 var1 = class39.field865.method109();
         var0.method4113(var1.field1980, 0, var1.field1976);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4114();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("a")
   static byte[] method916(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass80;I)V",
      garbageValue = "505783917"
   )
   static final void method917(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class27.field656.length; ++var2) {
         class27.field656[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class27.field656[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class115.field1957[var5] = (class27.field656[var5 - 128] + class27.field656[var5 - 1] + class27.field656[var5 + 1] + class27.field656[var5 + 128]) / 4;
            }
         }

         int[] var8 = class27.field656;
         class27.field656 = class115.field1957;
         class115.field1957 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1391; ++var3) {
            for(var4 = 0; var4 < var0.field1390; ++var4) {
               if(var0.field1389[var2++] != 0) {
                  var5 = 16 + var4 + var0.field1393;
                  int var6 = var0.field1394 + 16 + var3;
                  int var7 = var5 + (var6 << 7);
                  class27.field656[var7] = 0;
               }
            }
         }
      }

   }
}
