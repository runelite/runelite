import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class48 extends CacheableNode {
   @ObfuscatedName("r")
   public static NodeCache field1053 = new NodeCache(64);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -65225359
   )
   public int field1054 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1965032629
   )
   public int field1055 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -163146199
   )
   public int field1057 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -926487941
   )
   public int field1058;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1709455059
   )
   public int field1061;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1991802915
   )
   public int field1062;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 977723655
   )
   public int field1063;
   @ObfuscatedName("i")
   public boolean field1064 = true;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1551234455
   )
   public int field1065;
   @ObfuscatedName("ht")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -841877163
   )
   static int field1067;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 785166905
   )
   public int field1068;
   @ObfuscatedName("x")
   static class170 field1069;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1746477159"
   )
   void method973(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2556();
         if(var3 == 0) {
            return;
         }

         this.method975(var1, var3, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-2077762027"
   )
   void method975(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1054 = var1.method2560();
      } else if(var2 == 2) {
         this.field1055 = var1.method2556();
      } else if(var2 == 5) {
         this.field1064 = false;
      } else if(var2 == 7) {
         this.field1057 = var1.method2560();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-70"
   )
   void method976(int var1) {
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

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1058 = (int)(256.0D * var12);
      this.field1065 = (int)(256.0D * var14);
      this.field1068 = (int)(256.0D * var16);
      if(this.field1065 < 0) {
         this.field1065 = 0;
      } else if(this.field1065 > 255) {
         this.field1065 = 255;
      }

      if(this.field1068 < 0) {
         this.field1068 = 0;
      } else if(this.field1068 > 255) {
         this.field1068 = 255;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-138535627"
   )
   void method990() {
      if(this.field1057 != -1) {
         this.method976(this.field1057);
         this.field1061 = this.field1058;
         this.field1062 = this.field1065;
         this.field1063 = this.field1068;
      }

      this.method976(this.field1054);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZB)I",
      garbageValue = "53"
   )
   static int method991(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class85.method1925(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class85.method1925(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;I)I",
      garbageValue = "-28473451"
   )
   public static int method992(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = TextureProvider.method2250(var1);
      var0.method2554(var3.length);
      var0.offset += class225.field3232.method2490(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
