import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class27 implements class178 {
   @ObfuscatedName("h")
   static final class27 field390;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 476277575
   )
   static int field391;
   @ObfuscatedName("q")
   static final class27 field393;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 565183445
   )
   final int field394;
   @ObfuscatedName("v")
   final byte field395;
   @ObfuscatedName("i")
   static final class27 field397;
   @ObfuscatedName("u")
   static final class27 field399;
   @ObfuscatedName("op")
   static byte field401;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "36"
   )
   static World method205() {
      World.field1274 = 0;
      return class230.method4156();
   }

   static {
      field397 = new class27(1, (byte)0);
      field390 = new class27(2, (byte)1);
      field399 = new class27(3, (byte)2);
      field393 = new class27(0, (byte)3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field395;
   }

   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   class27(int var1, byte var2) {
      this.field394 = var1;
      this.field395 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)[Lclass27;",
      garbageValue = "-56"
   )
   static class27[] method213() {
      return new class27[]{field399, field397, field390, field393};
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass289;B)Ljava/lang/String;",
      garbageValue = "48"
   )
   public static String method214(CharSequence var0, class289 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class215.method4046(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2) {
            char var5 = var0.charAt(var3 - 1);
            boolean var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1 && var14 <= ISAACCipher.method3498(var1)) {
            StringBuilder var12 = new StringBuilder(var14);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else if(class47.method713(var7)) {
                  var8 = true;
               } else {
                  char[] var13 = class267.field3663;
                  int var10 = 0;

                  label120:
                  while(true) {
                     char var11;
                     if(var10 >= var13.length) {
                        var13 = class267.field3661;

                        for(var10 = 0; var10 < var13.length; ++var10) {
                           var11 = var13[var10];
                           if(var7 == var11) {
                              var8 = true;
                              break label120;
                           }
                        }

                        var8 = false;
                        break;
                     }

                     var11 = var13[var10];
                     if(var11 == var7) {
                        var8 = true;
                        break;
                     }

                     ++var10;
                  }
               }

               if(var8) {
                  char var9;
                  switch(var7) {
                  case ' ':
                  case '-':
                  case '_':
                  case ' ':
                     var9 = 95;
                     break;
                  case '#':
                  case '[':
                  case ']':
                     var9 = var7;
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
                     var9 = 97;
                     break;
                  case 'Ç':
                  case 'ç':
                     var9 = 99;
                     break;
                  case 'È':
                  case 'É':
                  case 'Ê':
                  case 'Ë':
                  case 'è':
                  case 'é':
                  case 'ê':
                  case 'ë':
                     var9 = 101;
                     break;
                  case 'Í':
                  case 'Î':
                  case 'Ï':
                  case 'í':
                  case 'î':
                  case 'ï':
                     var9 = 105;
                     break;
                  case 'Ñ':
                  case 'ñ':
                     var9 = 110;
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
                     var9 = 111;
                     break;
                  case 'Ù':
                  case 'Ú':
                  case 'Û':
                  case 'Ü':
                  case 'ù':
                  case 'ú':
                  case 'û':
                  case 'ü':
                     var9 = 117;
                     break;
                  case 'ß':
                     var9 = 98;
                     break;
                  case 'ÿ':
                  case 'Ÿ':
                     var9 = 121;
                     break;
                  default:
                     var9 = Character.toLowerCase(var7);
                  }

                  if(var9 != 0) {
                     var12.append(var9);
                  }
               }
            }

            if(var12.length() == 0) {
               return null;
            } else {
               return var12.toString();
            }
         } else {
            return null;
         }
      }
   }
}
