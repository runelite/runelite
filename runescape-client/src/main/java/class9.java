import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public abstract class class9 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1775908210"
   )
   abstract void vmethod55();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lke;I)Ljava/lang/String;",
      garbageValue = "-921054791"
   )
   public static String method48(CharSequence var0, class289 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var10 = var3 - var2;
         if(var10 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3840) {
               case 7:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var10 <= var6) {
               StringBuilder var9 = new StringBuilder(var10);

               for(int var11 = var2; var11 < var3; ++var11) {
                  char var7 = var0.charAt(var11);
                  if(class7.method39(var7)) {
                     char var8 = class43.method634(var7);
                     if(var8 != 0) {
                        var9.append(var8);
                     }
                  }
               }

               if(var9.length() == 0) {
                  return null;
               }

               return var9.toString();
            }
         }

         return null;
      }
   }
}
