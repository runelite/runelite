import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class46 extends class204 {
   @ObfuscatedName("y")
   public boolean field1058 = true;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1270306223
   )
   public int field1059 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1071788013
   )
   public int field1060 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 657796389
   )
   public int field1061;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -706019351
   )
   public int field1062 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1541956587
   )
   public int field1063;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1714713595
   )
   public int field1064;
   @ObfuscatedName("w")
   public static class193 field1065 = new class193(64);
   @ObfuscatedName("bb")
   static class80[] field1066;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1426505425
   )
   public int field1067;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 333635941
   )
   public int field1068;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 94614815
   )
   static int field1069;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1014741545
   )
   @Export("cameraZ")
   static int field1070;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1987233277
   )
   public int field1071;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-924500111"
   )
   public void method1053() {
      if(this.field1062 != -1) {
         this.method1056(this.field1062);
         this.field1071 = this.field1063;
         this.field1067 = this.field1068;
         this.field1064 = this.field1061;
      }

      this.method1056(this.field1059);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIB)V",
      garbageValue = "-33"
   )
   void method1055(class119 var1, int var2, int var3) {
      if(1 == var2) {
         this.field1059 = var1.method2617();
      } else if(var2 == 2) {
         this.field1060 = var1.method2613();
      } else if(5 == var2) {
         this.field1058 = false;
      } else if(7 == var2) {
         this.field1062 = var1.method2617();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-998048156"
   )
   void method1056(int var1) {
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
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field1063 = (int)(var12 * 256.0D);
      this.field1068 = (int)(var14 * 256.0D);
      this.field1061 = (int)(256.0D * var16);
      if(this.field1068 < 0) {
         this.field1068 = 0;
      } else if(this.field1068 > 255) {
         this.field1068 = 255;
      }

      if(this.field1061 < 0) {
         this.field1061 = 0;
      } else if(this.field1061 > 255) {
         this.field1061 = 255;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "2113870070"
   )
   public void method1064(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2613();
         if(var3 == 0) {
            return;
         }

         this.method1055(var1, var3, var2);
      }
   }
}
