import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class46 extends class204 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1494710299
   )
   public int field1049;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 371267719
   )
   public int field1051 = -1;
   @ObfuscatedName("d")
   public boolean field1052 = true;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1724936353
   )
   public int field1053 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1696023461
   )
   public int field1054;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -544011889
   )
   public int field1055;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1518307747
   )
   public int field1056;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -782942995
   )
   public int field1058 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1353711101
   )
   public int field1059;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1371651663
   )
   public int field1061;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = -675998751
   )
   static int field1062;
   @ObfuscatedName("j")
   public static class193 field1063 = new class193(64);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "890584732"
   )
   public void method936() {
      if(-1 != this.field1053) {
         this.method939(this.field1053);
         this.field1061 = this.field1054;
         this.field1056 = this.field1055;
         this.field1059 = this.field1049;
      }

      this.method939(this.field1058);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "3"
   )
   public void method937(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2492();
         if(0 == var3) {
            return;
         }

         this.method938(var1, var3, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;III)V",
      garbageValue = "1180486512"
   )
   void method938(class119 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1058 = var1.method2513();
      } else if(var2 == 2) {
         this.field1051 = var1.method2492();
      } else if(5 == var2) {
         this.field1052 = false;
      } else if(var2 == 7) {
         this.field1053 = var1.method2513();
      } else if(8 == var2) {
         ;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "62446634"
   )
   void method939(int var1) {
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

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1054 = (int)(var12 * 256.0D);
      this.field1055 = (int)(256.0D * var14);
      this.field1049 = (int)(var16 * 256.0D);
      if(this.field1055 < 0) {
         this.field1055 = 0;
      } else if(this.field1055 > 255) {
         this.field1055 = 255;
      }

      if(this.field1049 < 0) {
         this.field1049 = 0;
      } else if(this.field1049 > 255) {
         this.field1049 = 255;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIB)Z",
      garbageValue = "-45"
   )
   static final boolean method947(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      class119 var4 = new class119(var0);
      int var5 = -1;

      label84:
      while(true) {
         int var6 = var4.method2505();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2505();
               if(var9 == 0) {
                  continue label84;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2492() >> 2;
               int var13 = var11 + var1;
               int var14 = var2 + var10;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  class40 var15 = class9.method120(var5);
                  if(22 != var12 || !client.field493 || var15.field943 != 0 || var15.field941 == 1 || var15.field944) {
                     if(!var15.method808()) {
                        ++client.field561;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2505();
            if(0 == var9) {
               break;
            }

            var4.method2492();
         }
      }
   }
}
