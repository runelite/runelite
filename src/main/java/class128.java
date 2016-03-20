import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dm")
public final class class128 {
   @ObfuscatedName("g")
   public static int method2830(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("r")
   public static String method2832(CharSequence var0, class211 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class27.method648(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2) {
            char var5 = var0.charAt(var3 - 1);
            boolean var4 = var5 == 160 || var5 == 32 || 95 == var5 || 45 == var5;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var13 = var3 - var2;
         if(var13 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3131) {
               case 0:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var13 <= var6) {
               StringBuilder var14 = new StringBuilder(var13);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else {
                     boolean var9 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                     if(var9) {
                        var8 = true;
                     } else {
                        char[] var10 = class163.field2642;
                        int var11 = 0;

                        label121:
                        while(true) {
                           char var12;
                           if(var11 >= var10.length) {
                              var10 = class163.field2641;

                              for(var11 = 0; var11 < var10.length; ++var11) {
                                 var12 = var10[var11];
                                 if(var12 == var7) {
                                    var8 = true;
                                    break label121;
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
                     char var16 = class72.method1610(var7);
                     if(var16 != 0) {
                        var14.append(var16);
                     }
                  }
               }

               if(var14.length() == 0) {
                  return null;
               }

               return var14.toString();
            }
         }

         return null;
      }
   }
}
