import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class191 extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2073202957
   )
   public int field2784;
   @ObfuscatedName("g")
   static int[][] field2785;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2060322977
   )
   int field2786 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1099378621
   )
   public int field2787;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2067673105
   )
   public int field2788;
   @ObfuscatedName("x")
   public static NodeCache field2789 = new NodeCache(64);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -89105629
   )
   public int field2790;
   @ObfuscatedName("m")
   static int[] field2791;
   @ObfuscatedName("u")
   public static class182 field2795;
   @ObfuscatedName("n")
   static class20 field2796;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method3462() {
      this.method3468(this.field2786);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-818339584"
   )
   void method3468(int var1) {
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
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field2788 = (int)(256.0D * var14);
      this.field2784 = (int)(var16 * 256.0D);
      if(this.field2788 < 0) {
         this.field2788 = 0;
      } else if(this.field2788 > 255) {
         this.field2788 = 255;
      }

      if(this.field2784 < 0) {
         this.field2784 = 0;
      } else if(this.field2784 > 255) {
         this.field2784 = 255;
      }

      if(var16 > 0.5D) {
         this.field2790 = (int)(512.0D * (1.0D - var16) * var14);
      } else {
         this.field2790 = (int)(512.0D * var16 * var14);
      }

      if(this.field2790 < 1) {
         this.field2790 = 1;
      }

      this.field2787 = (int)(var12 * (double)this.field2790);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "-126"
   )
   void method3471(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2786 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1004008232"
   )
   public void method3476(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3471(var1, var3, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "16"
   )
   static int method3478(int var0) {
      MessageNode var1 = (MessageNode)class47.field922.method2300((long)var0);
      return null == var1?-1:(var1.previous == class47.field921.field1886?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "-1592291590"
   )
   static long method3479(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(1 + var5 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }
}
