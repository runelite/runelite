import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("c")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("x")
   @Export("previousName")
   String field140;
   @ObfuscatedName("ew")
   static class78[] field142;
   @ObfuscatedName("mw")
   static class78 field143;
   @ObfuscatedName("en")
   static class78[] field144;
   @ObfuscatedName("w")
   @Export("name")
   String field146;

   @ObfuscatedName("w")
   public static int method101(CharSequence var0, CharSequence var1) {
      int var2 = var0.length();
      int var3 = var1.length();
      int var4 = 0;
      int var5 = 0;
      byte var6 = 0;
      byte var7 = 0;

      while(var4 - var6 < var2 || var5 - var7 < var3) {
         if(var4 - var6 >= var2) {
            return -1;
         }

         if(var5 - var7 >= var3) {
            return 1;
         }

         char var8;
         if(0 != var6) {
            var8 = (char)var6;
            boolean var13 = false;
         } else {
            var8 = var0.charAt(var4++);
         }

         char var9;
         if(0 != var7) {
            var9 = (char)var7;
            boolean var14 = false;
         } else {
            var9 = var1.charAt(var5++);
         }

         byte var10;
         if(var8 == 198) {
            var10 = 69;
         } else if(var8 == 230) {
            var10 = 101;
         } else if(223 == var8) {
            var10 = 115;
         } else if(338 == var8) {
            var10 = 69;
         } else if(339 == var8) {
            var10 = 101;
         } else {
            var10 = 0;
         }

         var6 = var10;
         byte var11;
         if(198 == var9) {
            var11 = 69;
         } else if(var9 == 230) {
            var11 = 101;
         } else if(var9 == 223) {
            var11 = 115;
         } else if(338 == var9) {
            var11 = 69;
         } else if(339 == var9) {
            var11 = 101;
         } else {
            var11 = 0;
         }

         var7 = var11;
         var8 = class42.method914(var8);
         var9 = class42.method914(var9);
         if(var9 != var8 && Character.toUpperCase(var8) != Character.toUpperCase(var9)) {
            var8 = Character.toLowerCase(var8);
            var9 = Character.toLowerCase(var9);
            if(var8 != var9) {
               return class49.method1044(var8) - class49.method1044(var9);
            }
         }
      }

      int var15 = Math.min(var2, var3);

      int var16;
      char var19;
      for(var16 = 0; var16 < var15; ++var16) {
         char var17 = var0.charAt(var16);
         var19 = var1.charAt(var16);
         if(var19 != var17 && Character.toUpperCase(var17) != Character.toUpperCase(var19)) {
            var17 = Character.toLowerCase(var17);
            var19 = Character.toLowerCase(var19);
            if(var17 != var19) {
               return class49.method1044(var17) - class49.method1044(var19);
            }
         }
      }

      var16 = var2 - var3;
      if(0 != var16) {
         return var16;
      } else {
         for(int var18 = 0; var18 < var15; ++var18) {
            var19 = var0.charAt(var18);
            char var12 = var1.charAt(var18);
            if(var12 != var19) {
               return class49.method1044(var19) - class49.method1044(var12);
            }
         }

         return 0;
      }
   }
}
