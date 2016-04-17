import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class27 {
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 420676647
   )
   static int field680;
   @ObfuscatedName("w")
   class35[] field681 = new class35[100];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1986561709
   )
   int field682;
   @ObfuscatedName("px")
   static GarbageCollectorMXBean field685;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lclass35;",
      garbageValue = "7"
   )
   class35 method721(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field681[99];

      for(int var6 = this.field682; var6 > 0; --var6) {
         if(var6 != 100) {
            this.field681[var6] = this.field681[var6 - 1];
         }
      }

      if(null == var5) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3998();
         var5.method3979();
         var5.method822(var1, var2, var4, var3);
      }

      this.field681[0] = var5;
      if(this.field682 < 100) {
         ++this.field682;
      }

      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass35;",
      garbageValue = "-1668428887"
   )
   class35 method722(int var1) {
      return var1 >= 0 && var1 < this.field682?this.field681[var1]:null;
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lclass173;I)Ljava/lang/String;",
      garbageValue = "-647342731"
   )
   static String method725(String var0, class173 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         String var4;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var4 = var0.substring(0, var3);
               int var6 = class116.method2556(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(-1 == var2) {
               break;
            }

            String var7 = "";
            if(null != class17.field260) {
               int var8 = class17.field260.field2212;
               var4 = (var8 >> 24 & 255) + "." + (var8 >> 16 & 255) + "." + (var8 >> 8 & 255) + "." + (var8 & 255);
               var7 = var4;
               if(class17.field260.field2211 != null) {
                  var7 = (String)class17.field260.field2211;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1248429141"
   )
   int method727() {
      return this.field682;
   }
}
