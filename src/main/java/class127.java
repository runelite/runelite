import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class127 {
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "414295850"
   )
   static final void method2812(int var0, int var1) {
      if(client.field420 >= 2 || 0 != client.field431 || client.field433) {
         String var2;
         if(client.field431 == 1 && client.field420 < 2) {
            var2 = "Use" + " " + client.field392 + " " + "->";
         } else if(client.field433 && client.field420 < 2) {
            var2 = client.field377 + " " + client.field437 + " " + "->";
         } else {
            var2 = class84.method1917(client.field420 - 1);
         }

         if(client.field420 > 2) {
            var2 = var2 + class39.method784(16777215) + " " + '/' + " " + (client.field420 - 2) + " more options";
         }

         class124.field2022.method4025(var2, 4 + var0, var1 + 15, 16777215, 0, client.field289 / 1000);
      }
   }

   @ObfuscatedName("e")
   public static String method2815(CharSequence[] var0, int var1, int var2) {
      if(0 == var2) {
         return "";
      } else if(var2 == 1) {
         CharSequence var8 = var0[var1];
         return var8 == null?"null":var8.toString();
      } else {
         int var3 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var3; ++var5) {
            CharSequence var6 = var0[var5];
            if(null == var6) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var3; ++var10) {
            CharSequence var7 = var0[var10];
            if(var7 == null) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }
}
