import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("g")
   public static class170 field200;
   @ObfuscatedName("z")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("t")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 233681579
   )
   static int field203;
   @ObfuscatedName("s")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass215;I)Ljava/lang/String;",
      garbageValue = "2039633723"
   )
   public static String method178(CharSequence var0, class215 var1) {
      if(null == var0) {
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

         int var14 = var3 - var2;
         if(var14 >= 1 && var14 <= class169.method3241(var1)) {
            StringBuilder var13 = new StringBuilder(var14);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else if(class152.method3136(var7)) {
                  var8 = true;
               } else {
                  char[] var9 = class167.field2707;
                  int var10 = 0;

                  label113:
                  while(true) {
                     char var11;
                     if(var10 >= var9.length) {
                        var9 = class167.field2703;

                        for(var10 = 0; var10 < var9.length; ++var10) {
                           var11 = var9[var10];
                           if(var11 == var7) {
                              var8 = true;
                              break label113;
                           }
                        }

                        var8 = false;
                        break;
                     }

                     var11 = var9[var10];
                     if(var7 == var11) {
                        var8 = true;
                        break;
                     }

                     ++var10;
                  }
               }

               if(var8) {
                  char var12 = class139.method2875(var7);
                  if(var12 != 0) {
                     var13.append(var12);
                  }
               }
            }

            if(var13.length() == 0) {
               return null;
            } else {
               return var13.toString();
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "343350447"
   )
   static final void method182(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class33.field710.length; ++var2) {
         class33.field710[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class33.field710[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class33.field701[var5] = (class33.field710[var5 - 1] + class33.field710[1 + var5] + class33.field710[var5 - 128] + class33.field710[128 + var5]) / 4;
            }
         }

         int[] var8 = class33.field710;
         class33.field710 = class33.field701;
         class33.field701 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var6 = var3 + 16 + var0.offsetY;
                  int var7 = var5 + (var6 << 7);
                  class33.field710[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-1926077671"
   )
   public static void method184(class170 var0) {
      GameEngine.field2248 = var0;
   }
}
