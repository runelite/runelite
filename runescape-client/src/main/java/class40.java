import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class40 extends class210 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -758901879
   )
   int field894 = (int)(class56.method1249() / 1000L);
   @ObfuscatedName("g")
   String field895;
   @ObfuscatedName("r")
   short field896;
   @ObfuscatedName("cm")
   static class146 field904;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;B)V",
      garbageValue = "71"
   )
   public static void method810(class170 var0) {
      class54.field1169 = var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "363387876"
   )
   public static int method811(CharSequence var0, CharSequence var1, int var2) {
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
            boolean var10 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var14;
         if(var8 != 0) {
            var14 = (char)var8;
            boolean var11 = false;
         } else {
            var14 = var1.charAt(var6++);
         }

         byte var16;
         if(var9 == 198) {
            var16 = 69;
         } else if(var9 == 230) {
            var16 = 101;
         } else if(var9 == 223) {
            var16 = 115;
         } else if(var9 == 338) {
            var16 = 69;
         } else if(var9 == 339) {
            var16 = 101;
         } else {
            var16 = 0;
         }

         var7 = var16;
         byte var12;
         if(var14 == 198) {
            var12 = 69;
         } else if(var14 == 230) {
            var12 = 101;
         } else if(var14 == 223) {
            var12 = 115;
         } else if(var14 == 338) {
            var12 = 69;
         } else if(var14 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = class165.method3339(var9, var2);
         var14 = class165.method3339(var14, var2);
         if(var14 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var14)) {
            var9 = Character.toLowerCase(var9);
            var14 = Character.toLowerCase(var14);
            if(var14 != var9) {
               return class8.method124(var9, var2) - class8.method124(var14, var2);
            }
         }
      }

      int var15 = Math.min(var3, var4);

      int var17;
      char var18;
      for(var17 = 0; var17 < var15; ++var17) {
         char var19 = var0.charAt(var17);
         var18 = var1.charAt(var17);
         if(var19 != var18 && Character.toUpperCase(var19) != Character.toUpperCase(var18)) {
            var19 = Character.toLowerCase(var19);
            var18 = Character.toLowerCase(var18);
            if(var19 != var18) {
               return class8.method124(var19, var2) - class8.method124(var18, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var20 = 0; var20 < var15; ++var20) {
            var18 = var0.charAt(var20);
            char var13 = var1.charAt(var20);
            if(var13 != var18) {
               return class8.method124(var18, var2) - class8.method124(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-857213040"
   )
   public static boolean method812(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1718627522"
   )
   static final int method813(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   class40(String var1, int var2) {
      this.field895 = var1;
      this.field896 = (short)var2;
   }
}
