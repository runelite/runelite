import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class43 extends class207 {
   @ObfuscatedName("l")
   static class196 field1008 = new class196(64);
   @ObfuscatedName("ar")
   static class149 field1009;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1650295249
   )
   int field1010 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1017828257
   )
   public int field1011;
   @ObfuscatedName("e")
   static class170 field1012;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 520789615
   )
   public int field1013;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1551362393
   )
   public int field1014;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1810296717
   )
   public int field1015;
   @ObfuscatedName("y")
   public static class122 field1017;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   void method890() {
      this.method893(this.field1010);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1874289992"
   )
   void method891(class122 var1, int var2) {
      while(true) {
         int var3 = var1.method2610();
         if(var3 == 0) {
            return;
         }

         this.method892(var1, var3, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;III)V",
      garbageValue = "621973920"
   )
   void method892(class122 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1010 = var1.method2703();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-606743713"
   )
   void method893(int var1) {
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
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1015 = (int)(var14 * 256.0D);
      this.field1013 = (int)(var16 * 256.0D);
      if(this.field1015 < 0) {
         this.field1015 = 0;
      } else if(this.field1015 > 255) {
         this.field1015 = 255;
      }

      if(this.field1013 < 0) {
         this.field1013 = 0;
      } else if(this.field1013 > 255) {
         this.field1013 = 255;
      }

      if(var16 > 0.5D) {
         this.field1014 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field1014 = (int)(512.0D * var16 * var14);
      }

      if(this.field1014 < 1) {
         this.field1014 = 1;
      }

      this.field1011 = (int)((double)this.field1014 * var12);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-13"
   )
   static int method914(int var0) {
      class37 var1 = (class37)class11.field188.method3882((long)var0);
      return var1 == null?-1:(class11.field184.field3146 == var1.field3152?-1:((class37)var1.field3152).field833);
   }
}
