import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -942641665
   )
   int field1183 = 128;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1765129729
   )
   int field1185;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1279074947
   )
   int field1186 = 0;
   @ObfuscatedName("k")
   double field1187 = 1.0D;
   @ObfuscatedName("b")
   class79[] field1188;
   @ObfuscatedName("n")
   class182 field1189;
   @ObfuscatedName("l")
   Deque field1190 = new Deque();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-392867944"
   )
   public int vmethod1968(int var1) {
      return null != this.field1188[var1]?this.field1188[var1].field1290:0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "-104"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1188[var1];
      if(null != var2) {
         if(null != var2.field1298) {
            this.field1190.method2470(var2);
            var2.field1294 = true;
            return var2.field1298;
         }

         boolean var3 = var2.method1604(this.field1187, this.field1183, this.field1189);
         if(var3) {
            if(this.field1186 == 0) {
               class79 var4 = (class79)this.field1190.method2471();
               var4.method1603();
            } else {
               --this.field1186;
            }

            this.field1190.method2470(var2);
            var2.field1294 = true;
            return var2.field1298;
         }
      }

      return null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1052398682"
   )
   public boolean vmethod1966(int var1) {
      return this.field1188[var1].field1291;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "94000090"
   )
   public boolean vmethod1965(int var1) {
      return this.field1183 == 64;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2056196043"
   )
   public void method1495() {
      for(int var1 = 0; var1 < this.field1188.length; ++var1) {
         if(this.field1188[var1] != null) {
            this.field1188[var1].method1603();
         }
      }

      this.field1190 = new Deque();
      this.field1186 = this.field1185;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "379983782"
   )
   public void method1496(int var1) {
      for(int var2 = 0; var2 < this.field1188.length; ++var2) {
         class79 var3 = this.field1188[var2];
         if(var3 != null && var3.field1299 != 0 && var3.field1294) {
            var3.method1602(var1);
            var3.field1294 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1189 = var2;
      this.field1185 = var3;
      this.field1186 = this.field1185;
      this.field1187 = var4;
      this.field1183 = var6;
      int[] var7 = var1.method3357(0);
      int var8 = var7.length;
      this.field1188 = new class79[var1.method3398(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1188[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1511(double var1) {
      this.field1187 = var1;
      this.method1495();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "6"
   )
   public static int method1513(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[Lclass221;",
      garbageValue = "-1191581041"
   )
   public static class221[] method1514() {
      return new class221[]{class221.field3194, class221.field3195, class221.field3198, class221.field3197, class221.field3199};
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "40000"
   )
   static void method1515(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2428((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }
}
