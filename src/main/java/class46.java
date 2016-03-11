import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class46 extends class203 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1695428605
   )
   public int field1050;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 792436775
   )
   public int field1051 = 0;
   @ObfuscatedName("f")
   public boolean field1052 = true;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1696598773
   )
   public int field1053 = -1;
   @ObfuscatedName("l")
   public static class192 field1054 = new class192(64);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1776544273
   )
   public int field1055 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2081496579
   )
   public int field1056;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1561934015
   )
   public int field1057;
   @ObfuscatedName("j")
   public static class166 field1058;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1664521789
   )
   public int field1059;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 275606191
   )
   public int field1060;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -356508387
   )
   public int field1061;
   @ObfuscatedName("ah")
   static class167 field1062;

   @ObfuscatedName("j")
   public void method953() {
      if(this.field1055 != -1) {
         this.method955(this.field1055);
         this.field1059 = this.field1056;
         this.field1060 = this.field1057;
         this.field1061 = this.field1050;
      }

      this.method955(this.field1051);
   }

   @ObfuscatedName("l")
   public void method954(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method963(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "6"
   )
   void method955(int var1) {
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
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1056 = (int)(256.0D * var12);
      this.field1057 = (int)(var14 * 256.0D);
      this.field1050 = (int)(var16 * 256.0D);
      if(this.field1057 < 0) {
         this.field1057 = 0;
      } else if(this.field1057 > 255) {
         this.field1057 = 255;
      }

      if(this.field1050 < 0) {
         this.field1050 = 0;
      } else if(this.field1050 > 255) {
         this.field1050 = 255;
      }

   }

   @ObfuscatedName("a")
   void method963(class118 var1, int var2) {
      if(var2 == 1) {
         this.field1051 = var1.method2553();
      } else if(2 == var2) {
         this.field1053 = var1.method2453();
      } else if(5 == var2) {
         this.field1052 = false;
      } else if(7 == var2) {
         this.field1055 = var1.method2553();
      } else if(var2 == 8) {
         ;
      }

   }
}
