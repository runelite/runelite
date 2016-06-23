import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class48 extends class204 {
   @ObfuscatedName("u")
   public static class193 field1088 = new class193(64);
   @ObfuscatedName("x")
   public char field1089;
   @ObfuscatedName("b")
   public char field1090;
   @ObfuscatedName("g")
   public int[] field1091;
   @ObfuscatedName("f")
   public static class167 field1092;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1273370675
   )
   public int field1093 = 0;
   @ObfuscatedName("m")
   public int[] field1094;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2047301295
   )
   public int field1095;
   @ObfuscatedName("s")
   public String[] field1096;
   @ObfuscatedName("l")
   public String field1097 = "null";

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "1"
   )
   public void method1038(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method1040(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1005303481"
   )
   void method1040(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1089 = (char)var1.method2554();
      } else if(var2 == 2) {
         this.field1090 = (char)var1.method2554();
      } else if(var2 == 3) {
         this.field1097 = var1.method2668();
      } else if(var2 == 4) {
         this.field1095 = var1.method2696();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1093 = var1.method2556();
            this.field1094 = new int[this.field1093];
            this.field1096 = new String[this.field1093];

            for(var3 = 0; var3 < this.field1093; ++var3) {
               this.field1094[var3] = var1.method2696();
               this.field1096[var3] = var1.method2668();
            }
         } else if(var2 == 6) {
            this.field1093 = var1.method2556();
            this.field1094 = new int[this.field1093];
            this.field1091 = new int[this.field1093];

            for(var3 = 0; var3 < this.field1093; ++var3) {
               this.field1094[var3] = var1.method2696();
               this.field1091[var3] = var1.method2696();
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "1137198510"
   )
   public static final void method1041(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class56.field1196 = var0;
         class56.field1200 = var1;
         class56.field1188 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "1943168429"
   )
   public static int method1042(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }
}
