import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class47 extends CacheableNode {
   @ObfuscatedName("ab")
   static ModIcon[] field1045;
   @ObfuscatedName("e")
   public static NodeCache field1046 = new NodeCache(64);
   @ObfuscatedName("f")
   public static class170 field1047;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -320508349
   )
   static int field1049;
   @ObfuscatedName("bv")
   static class171 field1050;
   @ObfuscatedName("n")
   public boolean field1051 = false;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "16777215"
   )
   public void method961(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method965(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "3"
   )
   void method965(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1051 = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass215;B)Ljava/lang/String;",
      garbageValue = "-24"
   )
   public static String method967(CharSequence var0, class215 var1) {
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
               switch(var1.field3179) {
               case 8:
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
                  if(class129.method2836(var7)) {
                     char var8 = class31.method672(var7);
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
