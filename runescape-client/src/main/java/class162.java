import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class162 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 1939569275599198833L
   )
   static long field2306;
   @ObfuscatedName("z")
   static int[] field2307;
   @ObfuscatedName("e")
   public static class181 field2308;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -8838939477370323941L
   )
   static long field2309;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2044068264"
   )
   static int method3189(int var0) {
      MessageNode var1 = (MessageNode)class47.field925.method2378((long)var0);
      return var1 == null?-1:(class47.field930.field1897 == var1.previous?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "110"
   )
   static void method3193(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || null != var0[var8] && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method3193(var0, var1, var2, var5 - 1);
         method3193(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;I)Ljava/lang/String;",
      garbageValue = "1858845869"
   )
   public static String method3194(CharSequence var0, class228 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class159.method2972(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class159.method2972(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= class13.method187(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               if(class187.method3485(var7)) {
                  char var8;
                  switch(var7) {
                  case ' ':
                  case '-':
                  case '_':
                  case ' ':
                     var8 = 95;
                     break;
                  case '#':
                  case '[':
                  case ']':
                     var8 = var7;
                     break;
                  case 'À':
                  case 'Á':
                  case 'Â':
                  case 'Ã':
                  case 'Ä':
                  case 'à':
                  case 'á':
                  case 'â':
                  case 'ã':
                  case 'ä':
                     var8 = 97;
                     break;
                  case 'Ç':
                  case 'ç':
                     var8 = 99;
                     break;
                  case 'È':
                  case 'É':
                  case 'Ê':
                  case 'Ë':
                  case 'è':
                  case 'é':
                  case 'ê':
                  case 'ë':
                     var8 = 101;
                     break;
                  case 'Í':
                  case 'Î':
                  case 'Ï':
                  case 'í':
                  case 'î':
                  case 'ï':
                     var8 = 105;
                     break;
                  case 'Ñ':
                  case 'ñ':
                     var8 = 110;
                     break;
                  case 'Ò':
                  case 'Ó':
                  case 'Ô':
                  case 'Õ':
                  case 'Ö':
                  case 'ò':
                  case 'ó':
                  case 'ô':
                  case 'õ':
                  case 'ö':
                     var8 = 111;
                     break;
                  case 'Ù':
                  case 'Ú':
                  case 'Û':
                  case 'Ü':
                  case 'ù':
                  case 'ú':
                  case 'û':
                  case 'ü':
                     var8 = 117;
                     break;
                  case 'ß':
                     var8 = 98;
                     break;
                  case 'ÿ':
                  case 'Ÿ':
                     var8 = 121;
                     break;
                  default:
                     var8 = Character.toLowerCase(var7);
                  }

                  if(var8 != 0) {
                     var5.append(var8);
                  }
               }
            }

            if(var5.length() == 0) {
               return null;
            } else {
               return var5.toString();
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1130171165"
   )
   static void method3195() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class30.method684(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[1 + var1];
                  Client.menuTargets[var1] = Client.menuTargets[1 + var1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)[Lclass40;",
      garbageValue = "2613"
   )
   static class40[] method3196() {
      return new class40[]{class40.field811, class40.field806, class40.field808, class40.field814};
   }
}
