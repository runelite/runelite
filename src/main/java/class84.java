import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class84 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -285598409
   )
   int field1456;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 193674243
   )
   int field1457;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1777395087
   )
   int field1459;
   @ObfuscatedName("r")
   static byte[][][] field1463;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-96"
   )
   public static boolean method1994() {
      return 0 != class183.field2967?true:class183.field2973.method3736();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;B)[Lclass80;",
      garbageValue = "114"
   )
   public static class80[] method1995(class167 var0, String var1, String var2) {
      int var3 = var0.method3377(var1);
      int var4 = var0.method3378(var3, var2);
      return class8.method155(var0, var3, var4);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-790728838"
   )
   public static String method1996(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && 46 != var4 && 45 != var4 && 42 != var4 && 95 != var4) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class51.method1136(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass143;ZB)V",
      garbageValue = "1"
   )
   public static void method1997(class143 var0, boolean var1) {
      if(null != class171.field2717) {
         try {
            class171.field2717.method3095();
         } catch (Exception var6) {
            ;
         }

         class171.field2717 = null;
      }

      class171.field2717 = var0;
      class38.method854(var1);
      class171.field2726.field1992 = 0;
      class124.field2032 = null;
      class171.field2716 = null;
      class171.field2728 = 0;

      while(true) {
         class172 var2 = (class172)class171.field2718.method3871();
         if(null == var2) {
            while(true) {
               var2 = (class172)class171.field2713.method3871();
               if(var2 == null) {
                  if(0 != class171.field2731) {
                     try {
                        class119 var7 = new class119(4);
                        var7.method2603(4);
                        var7.method2603(class171.field2731);
                        var7.method2599(0);
                        class171.field2717.method3100(var7.field1993, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class171.field2717.method3095();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class171.field2733;
                        class171.field2717 = null;
                     }
                  }

                  class171.field2715 = 0;
                  class171.field2730 = class127.method2941();
                  return;
               }

               class171.field2720.method3964(var2);
               class171.field2721.method3875(var2, var2.field3125);
               ++class171.field2739;
               --class171.field2724;
            }
         }

         class171.field2738.method3875(var2, var2.field3125);
         ++class171.field2727;
         --class171.field2719;
      }
   }
}
