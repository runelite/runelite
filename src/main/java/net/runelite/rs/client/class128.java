package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dx")
public final class class128 {
   @ObfuscatedName("h")
   static int method2863(class25 var0, class25 var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.field629;
         int var5 = var1.field629;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(-1 == var5) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.field626 - var1.field626:(var2 == 3?(var0.field633.equals("-")?(var1.field633.equals("-")?0:(var3?-1:1)):(var1.field633.equals("-")?(var3?1:-1):var0.field633.compareTo(var1.field633))):(4 == var2?(var0.method672()?(var1.method672()?0:1):(var1.method672()?-1:0)):(var2 == 5?(var0.method644()?(var1.method644()?0:1):(var1.method644()?-1:0)):(6 == var2?(var0.method643()?(var1.method643()?0:1):(var1.method643()?-1:0)):(var2 == 7?(var0.method660()?(var1.method660()?0:1):(var1.method660()?-1:0)):var0.field621 - var1.field621)))));
      }
   }

   @ObfuscatedName("da")
   static final void method2864(class172 var0) {
      int var1 = var0.field2738;
      if(var1 == 324) {
         if(-1 == client.field548 * -1) {
            client.field548 = var0.field2866 * -1;
            client.field549 = var0.field2768 * -1;
         }

         if(client.field547.field2900) {
            var0.field2866 = client.field548 * -1;
         } else {
            var0.field2866 = client.field549 * -1;
         }

      } else if(var1 == 325) {
         if(client.field548 * -1 == -1) {
            client.field548 = var0.field2866 * -1;
            client.field549 = var0.field2768 * -1;
         }

         if(client.field547.field2900) {
            var0.field2866 = client.field549 * -1;
         } else {
            var0.field2866 = client.field548 * -1;
         }

      } else if(327 == var1) {
         var0.field2783 = 150;
         var0.field2760 = (int)(Math.sin((double)client.field286 / 40.0D) * 256.0D) & 2047;
         var0.field2777 = 5;
         var0.field2776 = 0;
      } else if(328 == var1) {
         var0.field2783 = 150;
         var0.field2760 = (int)(Math.sin((double)client.field286 / 40.0D) * 256.0D) & 2047;
         var0.field2777 = 5;
         var0.field2776 = 1;
      }
   }
}
