import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class202 {
   @ObfuscatedName("rn")
   static MachineInfo field2496;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1769196575
   )
   int field2492;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1773962943
   )
   int field2494;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1437731913
   )
   int field2491;
   @ObfuscatedName("a")
   byte[] field2488;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -303217207
   )
   int field2493;
   @ObfuscatedName("j")
   byte[] field2486;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1266758277
   )
   int field2490;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -899345681
   )
   int field2487;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1244301695
   )
   int field2489;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1846109266"
   )
   public static void method3681() {
      class252.field3394.reset();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass289;I)Ljava/lang/String;",
      garbageValue = "-3230014"
   )
   public static String method3682(CharSequence var0, class289 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class96.method1769(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class96.method1769(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= WorldMapData.method345(var1)) {
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
                     char[] var10 = class267.field3665;
                     int var11 = 0;

                     label84:
                     while(true) {
                        char var12;
                        if(var11 >= var10.length) {
                           var10 = class267.field3668;

                           for(var11 = 0; var11 < var10.length; ++var11) {
                              var12 = var10[var11];
                              if(var12 == var7) {
                                 var8 = true;
                                 break label84;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var12 = var10[var11];
                        if(var12 == var7) {
                           var8 = true;
                           break;
                        }

                        ++var11;
                     }
                  }
               }

               if(var8) {
                  char var13 = class155.method2959(var7);
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
}
