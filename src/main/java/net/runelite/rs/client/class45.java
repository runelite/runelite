package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("au")
public class class45 extends class203 {
   @ObfuscatedName("t")
   public static short[] field1023;
   @ObfuscatedName("f")
   public boolean field1025 = false;
   @ObfuscatedName("qj")
   protected static class132 field1026;
   @ObfuscatedName("j")
   public static class166 field1027;
   @ObfuscatedName("m")
   static class192 field1028 = new class192(64);

   @ObfuscatedName("m")
   void method980(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(0 == var2) {
            return;
         }

         this.method991(var2);
      }
   }

   @ObfuscatedName("m")
   public static int method981(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("j")
   public static char method985(char var0) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(223 == var0) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || 255 == var0) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("m")
   public static String method989(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class161.field2628[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("l")
   static int method990(int var0) {
      class27 var1 = (class27)class11.field171.get(Integer.valueOf(var0));
      return null == var1?0:var1.method682();
   }

   @ObfuscatedName("f")
   void method991(int var1) {
      if(var1 == 2) {
         this.field1025 = true;
      }

   }

   @ObfuscatedName("m")
   static void method992(int var0, class133 var1, class167 var2) {
      class168 var3 = new class168();
      var3.field2684 = 1;
      var3.field3104 = (long)var0;
      var3.field2683 = var1;
      var3.field2686 = var2;
      class198 var4 = class169.field2694;
      synchronized(class169.field2694) {
         class169.field2694.method3868(var3);
      }

      class103.method2328();
   }
}
