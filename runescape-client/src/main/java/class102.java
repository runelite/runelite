import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("FrameMap")
public class class102 extends class208 {
   @ObfuscatedName("pd")
   static class160 field1742;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1539107269
   )
   int field1743;
   @ObfuscatedName("j")
   int[] field1744;
   @ObfuscatedName("d")
   int[][] field1745;
   @ObfuscatedName("kw")
   static class131 field1746;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -71653979
   )
   int field1747;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      longValue = -5849355926221381007L
   )
   static long field1750;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "-1693500839"
   )
   public static int method2289(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = class18.method182(var9);
         var8 = class18.method182(var10);
         var9 = class144.method3064(var9, var2);
         var10 = class144.method3064(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return class155.method3176(var9, var2) - class155.method3176(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var12 != var11 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var12 != var11) {
               return class155.method3176(var11, var2) - class155.method3176(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var12 != var13) {
               return class155.method3176(var12, var2) - class155.method3176(var13, var2);
            }
         }

         return 0;
      }
   }

   class102(int var1, byte[] var2) {
      this.field1743 = var1;
      class119 var3 = new class119(var2);
      this.field1747 = var3.method2514();
      this.field1744 = new int[this.field1747];
      this.field1745 = new int[this.field1747][];

      int var4;
      for(var4 = 0; var4 < this.field1747; ++var4) {
         this.field1744[var4] = var3.method2514();
      }

      for(var4 = 0; var4 < this.field1747; ++var4) {
         this.field1745[var4] = new int[var3.method2514()];
      }

      for(var4 = 0; var4 < this.field1747; ++var4) {
         for(int var5 = 0; var5 < this.field1745[var4].length; ++var5) {
            this.field1745[var4][var5] = var3.method2514();
         }
      }

   }
}
