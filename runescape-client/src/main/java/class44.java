import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("KitDefinition")
public class class44 extends class204 {
   @ObfuscatedName("h")
   static class193 field1026 = new class193(64);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 559517463
   )
   public int field1027 = -1;
   @ObfuscatedName("r")
   int[] field1028;
   @ObfuscatedName("f")
   short[] field1029;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1031587135
   )
   public static int field1030;
   @ObfuscatedName("l")
   short[] field1032;
   @ObfuscatedName("y")
   int[] field1033 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("p")
   public boolean field1034 = false;
   @ObfuscatedName("ee")
   static class78 field1035;
   @ObfuscatedName("s")
   short[] field1036;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -904111231
   )
   static int field1038;
   @ObfuscatedName("bi")
   static class80[] field1039;
   @ObfuscatedName("d")
   short[] field1041;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-516453963"
   )
   void method896(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method897(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1644929529"
   )
   void method897(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1027 = var1.method2494();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2494();
            this.field1028 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1028[var4] = var1.method2470();
            }
         } else if(var2 == 3) {
            this.field1034 = true;
         } else if(var2 == 40) {
            var3 = var1.method2494();
            this.field1029 = new short[var3];
            this.field1036 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1029[var4] = (short)var1.method2470();
               this.field1036[var4] = (short)var1.method2470();
            }
         } else if(var2 == 41) {
            var3 = var1.method2494();
            this.field1041 = new short[var3];
            this.field1032 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1041[var4] = (short)var1.method2470();
               this.field1032[var4] = (short)var1.method2470();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1033[var2 - 60] = var1.method2470();
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "1883692830"
   )
   @Export("getModelData")
   public class100 method898() {
      if(null == this.field1028) {
         return null;
      } else {
         class100[] var1 = new class100[this.field1028.length];

         for(int var2 = 0; var2 < this.field1028.length; ++var2) {
            var1[var2] = class100.method2172(class218.field3170, this.field1028[var2], 0);
         }

         class100 var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new class100(var1, var1.length);
         }

         int var3;
         if(null != this.field1029) {
            for(var3 = 0; var3 < this.field1029.length; ++var3) {
               var4.method2201(this.field1029[var3], this.field1036[var3]);
            }
         }

         if(null != this.field1041) {
            for(var3 = 0; var3 < this.field1041.length; ++var3) {
               var4.method2189(this.field1041[var3], this.field1032[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1782029878"
   )
   public boolean method899() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1033[var2] != -1 && !class218.field3170.method3259(this.field1033[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-5012"
   )
   @Export("ready")
   public boolean method900() {
      if(this.field1028 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1028.length; ++var2) {
            if(!class218.field3170.method3259(this.field1028[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "1941071871"
   )
   public class100 method901() {
      class100[] var1 = new class100[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1033[var3] != -1) {
            var1[var2++] = class100.method2172(class218.field3170, this.field1033[var3], 0);
         }
      }

      class100 var5 = new class100(var1, var2);
      int var4;
      if(this.field1029 != null) {
         for(var4 = 0; var4 < this.field1029.length; ++var4) {
            var5.method2201(this.field1029[var4], this.field1036[var4]);
         }
      }

      if(this.field1041 != null) {
         for(var4 = 0; var4 < this.field1041.length; ++var4) {
            var5.method2189(this.field1041[var4], this.field1032[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIB)Lclass78;",
      garbageValue = "-35"
   )
   public static class78 method907(class167 var0, int var1, int var2) {
      return !class21.method551(var0, var1, var2)?null:class49.method982();
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(Lclass3;ZB)V",
      garbageValue = "1"
   )
   static final void method912(class3 var0, boolean var1) {
      int var2 = var0.field65;
      int var3 = (int)var0.field3125;
      var0.method3870();
      class28.method634(var2);

      for(class201 var4 = (class201)client.field428.method3751(); var4 != null; var4 = (class201)client.field428.method3752()) {
         if((var4.field3125 >> 48 & 65535L) == (long)var2) {
            var4.method3870();
         }
      }

      class173 var9 = class170.method3344(var3);
      if(var9 != null) {
         class20.method547(var9);
      }

      int var5;
      for(var5 = 0; var5 < client.field294; ++var5) {
         int var7 = client.field392[var5];
         boolean var6 = var7 == 57 || var7 == 58 || var7 == 1007 || var7 == 25 || var7 == 30;
         if(var6) {
            if(var5 < client.field294 - 1) {
               for(int var8 = var5; var8 < client.field294 - 1; ++var8) {
                  client.field429[var8] = client.field429[var8 + 1];
                  client.field337[var8] = client.field337[var8 + 1];
                  client.field392[var8] = client.field392[1 + var8];
                  client.field502[var8] = client.field502[1 + var8];
                  client.field425[var8] = client.field425[var8 + 1];
                  client.field426[var8] = client.field426[var8 + 1];
               }
            }

            --client.field294;
         }
      }

      if(client.field442 != -1) {
         var5 = client.field442;
         if(class173.method3380(var5)) {
            class13.method140(class216.field3168[var5], 1);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1863937694"
   )
   public static void method920(class119 var0) {
      byte[] var1 = new byte[24];

      try {
         class149.field2269.method4096(0L);
         class149.field2269.method4098(var1);

         int var2;
         for(var2 = 0; var2 < 24 && var1[var2] == 0; ++var2) {
            ;
         }

         if(var2 >= 24) {
            throw new IOException();
         }
      } catch (Exception var5) {
         for(int var3 = 0; var3 < 24; ++var3) {
            var1[var3] = -1;
         }
      }

      var0.method2462(var1, 0, 24);
   }
}
