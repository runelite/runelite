import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class26 {
   @ObfuscatedName("ee")
   static class78[] field665;

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass33;I)V",
      garbageValue = "-1057104897"
   )
   static final void method634(class33 var0) {
      if(class151.field2253.field870 >> 7 == client.field528 && client.field529 == class151.field2253.field813 >> 7) {
         client.field528 = 0;
      }

      int var1 = class32.field774;
      int[] var2 = class32.field759;
      int var3 = var1;
      if(class33.field776 == var0 || var0 == class33.field783) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(class33.field776 == var0) {
            var5 = class151.field2253;
            var6 = class151.field2253.field48 << 14;
         } else if(class33.field783 == var0) {
            var5 = client.field415[client.field521];
            var6 = client.field521 << 14;
         } else {
            var5 = client.field415[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class33.field778 && client.field521 == var2[var4]) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod755() && !var5.field52) {
            var5.field44 = false;
            if((client.field297 && var1 > 50 || var1 > 200) && var0 != class33.field776 && var5.field817 == var5.field840) {
               var5.field44 = true;
            }

            int var7 = var5.field870 >> 7;
            int var8 = var5.field813 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.field39 && client.field303 >= var5.field34 && client.field303 < var5.field35) {
                  var5.field44 = false;
                  var5.field33 = class4.method52(var5.field870, var5.field813, class48.field1078);
                  class77.field1396.method1934(class48.field1078, var5.field870, var5.field813, var5.field33, var5, var5.field814, var6, var5.field25, var5.field41, var5.field51, var5.field50);
               } else {
                  if(64 == (var5.field870 & 127) && 64 == (var5.field813 & 127)) {
                     if(client.field398[var7][var8] == client.field399) {
                        continue;
                     }

                     client.field398[var7][var8] = client.field399;
                  }

                  var5.field33 = class4.method52(var5.field870, var5.field813, class48.field1078);
                  class77.field1396.method1968(class48.field1078, var5.field870, var5.field813, var5.field33, 60, var5, var5.field814, var6, var5.field815);
               }
            }
         }
      }

   }

   @ObfuscatedName("dx")
   static boolean method635(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class128.method2832(var0, class132.field2062);

         for(int var2 = 0; var2 < client.field509; ++var2) {
            class7 var3 = client.field568[var2];
            if(var1.equalsIgnoreCase(class128.method2832(var3.field129, class132.field2062))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class128.method2832(var3.field125, class132.field2062))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass135;Ljava/awt/Component;III)Lclass56;",
      garbageValue = "0"
   )
   public static final class56 method636(class135 var0, int var1, int var2) {
      if(class56.field1185 == 0) {
         throw new IllegalStateException();
      } else {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class69 var6 = new class69();
            var6.field1182 = new int[(class56.field1173?2:1) * 256];
            var6.field1181 = var2;
            var6.vmethod1563();
            var6.field1180 = (var2 & -1024) + 1024;
            if(var6.field1180 > 16384) {
               var6.field1180 = 16384;
            }

            var6.vmethod1545(var6.field1180);
            if(class56.field1174 > 0 && null == class221.field3176) {
               class221.field3176 = new class72();
               class221.field3176.field1352 = var0;
               var0.method2893(class221.field3176, class56.field1174);
            }

            if(null != class221.field3176) {
               if(null != class221.field3176.field1349[var1]) {
                  throw new IllegalArgumentException();
               }

               class221.field3176.field1349[var1] = var6;
            }

            return var6;
         } catch (Throwable var5) {
            try {
               class54 var3 = new class54(var0, var1);
               var3.field1182 = new int[256 * (class56.field1173?2:1)];
               var3.field1181 = var2;
               var3.vmethod1563();
               var3.field1180 = 16384;
               var3.vmethod1545(var3.field1180);
               if(class56.field1174 > 0 && null == class221.field3176) {
                  class221.field3176 = new class72();
                  class221.field3176.field1352 = var0;
                  var0.method2893(class221.field3176, class56.field1174);
               }

               if(null != class221.field3176) {
                  if(class221.field3176.field1349[var1] != null) {
                     throw new IllegalArgumentException();
                  }

                  class221.field3176.field1349[var1] = var3;
               }

               return var3;
            } catch (Throwable var4) {
               return new class56();
            }
         }
      }
   }
}
