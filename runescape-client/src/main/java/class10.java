import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("i")
public class class10 extends class110 {
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 2107846785
   )
   static int field179;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -237476711
   )
   static int field181;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public static boolean method112(int var0) {
      if(class176.field2785[var0]) {
         return true;
      } else if(!class176.field2834.method3345(var0)) {
         return false;
      } else {
         int var1 = class176.field2834.method3352(var0);
         if(var1 == 0) {
            class176.field2785[var0] = true;
            return true;
         } else {
            if(class176.field2811[var0] == null) {
               class176.field2811[var0] = new class176[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == class176.field2811[var0][var2]) {
                  byte[] var3 = class176.field2834.method3340(var0, var2);
                  if(var3 != null) {
                     class176.field2811[var0][var2] = new class176();
                     class176.field2811[var0][var2].field2794 = (var0 << 16) + var2;
                     if(var3[0] == -1) {
                        class176.field2811[var0][var2].method3517(new class122(var3));
                     } else {
                        class176.field2811[var0][var2].method3509(new class122(var3));
                     }
                  }
               }
            }

            class176.field2785[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIILclass111;S)Z",
      garbageValue = "-16645"
   )
   public boolean vmethod2464(int var1, int var2, int var3, class111 var4) {
      return var2 == super.field1952 && var3 == super.field1949;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-345045354"
   )
   @Export("widgetReset")
   static final void method115() {
      class12.method147();
      class105.method2371();
      class46.field1062.method3835();
      class42.field961.method3835();
      class42.field1006.method3835();
      class42.field963.method3835();
      class42.field986.method3835();
      class132.method2935();
      class49.method1071();
      class143.method3070();
      class55.method1220();
      class50.field1110.method3835();
      class158.method3258();
      class118.method2540();
      class228.method4205();
      class114.method2511();
      class78.method1734();
      ((class98)class94.field1646).method2269();
      class23.field613.method3835();
      class49.field1099.method3355();
      class126.field2076.method3355();
      class172.field2741.method3355();
      class17.field254.method3355();
      class4.field68.method3355();
      class109.field1948.method3355();
      class48.field1083.method3355();
      class230.field3263.method3355();
      class90.field1595.method3355();
      class192.field3097.method3355();
      class104.field1813.method3355();
      class0.field11.method3355();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-29"
   )
   static void method116() {
      int var0 = class142.field2191;
      int var1 = class132.field2109;
      if(class116.field2025 < var0) {
         var0 = class116.field2025;
      }

      if(class16.field246 < var1) {
         var1 = class16.field246;
      }

      if(client.field571 != null) {
         try {
            client var2 = client.field289;
            Object[] var3 = new Object[]{Integer.valueOf(class14.method155())};
            JSObject.getWindow(var2).call("resize", var3);
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "942965536"
   )
   public static String method117(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class9.method106(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
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
}
