import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
public enum class284 implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   field3769(0, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   field3770(1, 1),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   field3772(2, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   field3771(3, 3),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   field3773(4, 4);

   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1656649679
   )
   public final int field3774;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -960487265
   )
   final int field3775;

   class284(int var3, int var4) {
      this.field3774 = var3;
      this.field3775 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field3775;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "48749379"
   )
   public static int method4980(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      byte var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = (char)var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = (char)var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         byte var11;
         if(var9 == 198) {
            var11 = 69;
         } else if(var9 == 230) {
            var11 = 101;
         } else if(var9 == 223) {
            var11 = 115;
         } else if(var9 == 338) {
            var11 = 69;
         } else if(var9 == 339) {
            var11 = 101;
         } else {
            var11 = 0;
         }

         var7 = var11;
         byte var12;
         if(var10 == 198) {
            var12 = 69;
         } else if(var10 == 230) {
            var12 = 101;
         } else if(var10 == 223) {
            var12 = 115;
         } else if(var10 == 338) {
            var12 = 69;
         } else if(var10 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = class95.method1813(var9, var2);
         var10 = class95.method1813(var10, var2);
         if(var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var9 != var10) {
               return class170.method3214(var9, var2) - class170.method3214(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      int var17;
      char var20;
      for(var17 = 0; var17 < var16; ++var17) {
         char var18 = var0.charAt(var17);
         var20 = var1.charAt(var17);
         if(var20 != var18 && Character.toUpperCase(var18) != Character.toUpperCase(var20)) {
            var18 = Character.toLowerCase(var18);
            var20 = Character.toLowerCase(var20);
            if(var18 != var20) {
               return class170.method3214(var18, var2) - class170.method3214(var20, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var19 = 0; var19 < var16; ++var19) {
            var20 = var0.charAt(var19);
            char var13 = var1.charAt(var19);
            if(var20 != var13) {
               return class170.method3214(var20, var2) - class170.method3214(var13, var2);
            }
         }

         return 0;
      }
   }
}
