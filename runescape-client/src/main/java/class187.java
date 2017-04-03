import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class187 extends CacheableNode {
   @ObfuscatedName("f")
   public static IndexDataBase field2788;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 766932495
   )
   public static int field2789;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 324772979
   )
   public int field2790 = 0;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -1161741379
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("u")
   static NodeCache field2793 = new NodeCache(64);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;I)Ljava/lang/String;",
      garbageValue = "1815667047"
   )
   public static String method3483(CharSequence var0, class228 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && XItemContainer.method146(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && XItemContainer.method146(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= class145.method2801(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else {
                  boolean var9 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                  if(var9) {
                     var8 = true;
                  } else {
                     char[] var10 = class204.field3088;
                     int var11 = 0;

                     label101:
                     while(true) {
                        char var12;
                        if(var11 >= var10.length) {
                           var10 = class204.field3089;

                           for(var11 = 0; var11 < var10.length; ++var11) {
                              var12 = var10[var11];
                              if(var7 == var12) {
                                 var8 = true;
                                 break label101;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var12 = var10[var11];
                        if(var7 == var12) {
                           var8 = true;
                           break;
                        }

                        ++var11;
                     }
                  }
               }

               if(var8) {
                  char var13 = class173.method3309(var7);
                  if(var13 != 0) {
                     var5.append(var13);
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-104"
   )
   void method3484(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2790 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-826404897"
   )
   void method3492(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3484(var1, var2);
      }
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1156386759"
   )
   static final boolean method3495() {
      return Client.menuOptionCount <= 0?false:Client.field417 && class105.field1734[81] && Client.field449 != -1;
   }
}
