import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class46 extends class204 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -280035581
   )
   public int field1027 = 0;
   @ObfuscatedName("g")
   public static class193 field1028 = new class193(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1303270493
   )
   public int field1029;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 472834333
   )
   public int field1030 = -1;
   @ObfuscatedName("x")
   public boolean field1031 = true;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 199909121
   )
   public int field1032;
   @ObfuscatedName("b")
   static class167 field1033;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 567990381
   )
   public int field1034;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 302576405
   )
   public int field1035;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -71015713
   )
   public int field1036;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -936715683
   )
   public int field1037;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 59796401
   )
   public int field1038 = -1;
   @ObfuscatedName("qp")
   @Export("canvas")
   public static Canvas field1040;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method957() {
      if(this.field1038 != -1) {
         this.method963(this.field1038);
         this.field1036 = this.field1037;
         this.field1029 = this.field1034;
         this.field1032 = this.field1035;
      }

      this.method963(this.field1027);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "754082076"
   )
   void method958(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2514();
         if(var3 == 0) {
            return;
         }

         this.method959(var1, var3, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;III)V",
      garbageValue = "-777754031"
   )
   void method959(class119 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1027 = var1.method2518();
      } else if(var2 == 2) {
         this.field1030 = var1.method2514();
      } else if(var2 == 5) {
         this.field1031 = false;
      } else if(var2 == 7) {
         this.field1038 = var1.method2518();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;I)[Lclass78;",
      garbageValue = "-2115924249"
   )
   public static class78[] method960(class167 var0, String var1, String var2) {
      int var3 = var0.method3281(var1);
      int var4 = var0.method3282(var3, var2);
      return class96.method2196(var0, var3, var4);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1946358132"
   )
   void method963(int var1) {
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
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1037 = (int)(256.0D * var12);
      this.field1034 = (int)(var14 * 256.0D);
      this.field1035 = (int)(256.0D * var16);
      if(this.field1034 < 0) {
         this.field1034 = 0;
      } else if(this.field1034 > 255) {
         this.field1034 = 255;
      }

      if(this.field1035 < 0) {
         this.field1035 = 0;
      } else if(this.field1035 > 255) {
         this.field1035 = 255;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   public static int method967(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
