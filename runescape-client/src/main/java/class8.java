import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class8 {
   @ObfuscatedName("x")
   boolean field143;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -906764651
   )
   int field144 = 1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1305311719
   )
   static int field145 = 4;
   @ObfuscatedName("u")
   LinkedHashMap field146 = new LinkedHashMap();
   @ObfuscatedName("bs")
   static class168 field147;
   @ObfuscatedName("p")
   boolean field148;

   class8() {
      this.method113(true);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Lclass119;",
      garbageValue = "-13"
   )
   class119 method105() {
      class119 var1 = new class119(100);
      var1.method2477(field145);
      var1.method2477(this.field148?1:0);
      var1.method2477(this.field143?1:0);
      var1.method2477(this.field144);
      var1.method2477(this.field146.size());
      Iterator var2 = this.field146.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2480(((Integer)var3.getKey()).intValue());
         var1.method2480(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-63"
   )
   static void method107(String var0, String var1, String var2) {
      class31.field734 = var0;
      class31.field725 = var1;
      class31.field738 = var2;
   }

   class8(class119 var1) {
      if(var1 != null && null != var1.field2007) {
         int var2 = var1.method2492();
         if(var2 >= 0 && var2 <= field145) {
            if(var1.method2492() == 1) {
               this.field148 = true;
            }

            if(var2 > 1) {
               this.field143 = var1.method2492() == 1;
            }

            if(var2 > 3) {
               this.field144 = var1.method2492();
            }

            if(var2 > 2) {
               int var3 = var1.method2492();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2497();
                  int var6 = var1.method2497();
                  this.field146.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method113(true);
         }
      } else {
         this.method113(true);
      }

   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-49"
   )
   static void method112() {
      for(class3 var0 = (class3)client.field308.method3780(); null != var0; var0 = (class3)client.field308.method3781()) {
         int var1 = var0.field69;
         if(class188.method3731(var1)) {
            boolean var2 = true;
            class173[] var3 = class217.field3171[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2764;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3125;
               class173 var5 = class29.method645(var4);
               if(var5 != null) {
                  class34.method701(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   void method113(boolean var1) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IS)Lclass41;",
      garbageValue = "-19081"
   )
   public static class41 method114(int var0) {
      class41 var1 = (class41)class41.field976.method3743((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class41.field981.method3239(1, var0);
         var1 = new class41();
         if(var2 != null) {
            var1.method812(new class119(var2), var0);
         }

         var1.method811();
         class41.field976.method3745(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass37;II)V",
      garbageValue = "-1879548553"
   )
   static final void method115(class37 var0, int var1) {
      class102.method2270(var0.field823, var0.field813, var1);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1956335312"
   )
   static final void method116(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field480; ++var4) {
         if(client.field477[var4] + client.field485[var4] > var0 && client.field485[var4] < var0 + var2 && client.field488[var4] + client.field486[var4] > var1 && client.field486[var4] < var1 + var3) {
            client.field483[var4] = true;
         }
      }

   }
}
