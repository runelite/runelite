import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class172 extends class204 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 177088991
   )
   int field2748;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -1593339429
   )
   @Export("menuWidth")
   static int field2749;
   @ObfuscatedName("p")
   byte field2750;
   @ObfuscatedName("s")
   class168 field2752;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1398828511"
   )
   static void method3364() {
      class31.field737 = class31.field737.trim();
      if(class31.field737.length() == 0) {
         class8.method107("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var0 = class114.method2437();
         int var2;
         if(var0 == 0L) {
            var2 = 5;
         } else {
            var2 = class48.method965(var0, class31.field737);
         }

         switch(var2) {
         case 2:
            class8.method107("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field732 = 6;
            break;
         case 3:
            class8.method107("", "Error connecting to server.", "");
            break;
         case 4:
            class8.method107("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class8.method107("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class8.method107("", "Error connecting to server.", "");
            break;
         case 7:
            class8.method107("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-993144895"
   )
   static final void method3365() {
      if(client.field412 != -1) {
         class176.method3437(client.field412);
      }

      int var0;
      for(var0 = 0; var0 < client.field480; ++var0) {
         if(client.field482[var0]) {
            client.field483[var0] = true;
         }

         client.field368[var0] = client.field482[var0];
         client.field482[var0] = false;
      }

      client.field487 = client.field335;
      client.field426 = -1;
      client.field443 = -1;
      class25.field642 = null;
      if(-1 != client.field412) {
         client.field480 = 0;
         class59.method1241(client.field412, 0, 0, class15.field214, class15.field215, 0, 0, -1);
      }

      class79.method1766();
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      if(!client.field418) {
         if(-1 != client.field426) {
            class26.method615(client.field426, client.field443);
         }
      } else {
         var0 = class39.field882;
         var1 = class7.field136;
         var2 = field2749;
         var3 = class0.field0;
         int var7 = 6116423;
         class79.method1808(var0, var1, var2, var3, var7);
         class79.method1808(var0 + 1, 1 + var1, var2 - 2, 16, 0);
         class79.method1779(1 + var0, 18 + var1, var2 - 2, var3 - 19, 0);
         class164.field2665.method4002("Choose Option", var0 + 3, 14 + var1, var7, -1);
         var4 = class140.field2162;
         var5 = class140.field2163;

         for(var6 = 0; var6 < client.field496; ++var6) {
            int var8 = 31 + var1 + 15 * (client.field496 - 1 - var6);
            int var9 = 16777215;
            if(var4 > var0 && var4 < var0 + var2 && var5 > var8 - 13 && var5 < 3 + var8) {
               var9 = 16776960;
            }

            class224 var10 = class164.field2665;
            String var11;
            if(client.field425[var6].length() > 0) {
               var11 = client.field424[var6] + " " + client.field425[var6];
            } else {
               var11 = client.field424[var6];
            }

            var10.method4002(var11, 3 + var0, var8, var9, 0);
         }

         class8.method116(class39.field882, class7.field136, field2749, class0.field0);
      }

      if(3 == client.field506) {
         for(var0 = 0; var0 < client.field480; ++var0) {
            if(client.field368[var0]) {
               class79.method1772(client.field485[var0], client.field486[var0], client.field477[var0], client.field488[var0], 16711935, 128);
            } else if(client.field483[var0]) {
               class79.method1772(client.field485[var0], client.field486[var0], client.field477[var0], client.field488[var0], 16711680, 128);
            }
         }
      }

      var0 = class21.field581;
      var1 = class106.field1881.field823;
      var2 = class106.field1881.field813;
      var3 = client.field356;

      for(class23 var12 = (class23)class23.field615.method3812(); null != var12; var12 = (class23)class23.field615.method3817()) {
         if(-1 != var12.field604 || var12.field608 != null) {
            var4 = 0;
            if(var1 > var12.field601) {
               var4 += var1 - var12.field601;
            } else if(var1 < var12.field599) {
               var4 += var12.field599 - var1;
            }

            if(var2 > var12.field602) {
               var4 += var2 - var12.field602;
            } else if(var2 < var12.field600) {
               var4 += var12.field600 - var2;
            }

            if(var4 - 64 <= var12.field603 && 0 != client.field520 && var12.field606 == var0) {
               var4 -= 64;
               if(var4 < 0) {
                  var4 = 0;
               }

               var5 = (var12.field603 - var4) * client.field520 / var12.field603;
               class58 var13;
               class58 var14;
               class62 var15;
               class64 var16;
               if(var12.field598 == null) {
                  if(var12.field604 >= 0) {
                     var13 = (class58)null;
                     var14 = class58.method1228(class28.field682, var12.field604, 0);
                     if(null != var14) {
                        var15 = var14.method1222().method1256(class110.field1960);
                        var16 = class64.method1280(var15, 100, var5);
                        var16.method1428(-1);
                        class114.field1978.method1127(var16);
                        var12.field598 = var16;
                     }
                  }
               } else {
                  var12.field598.method1284(var5);
               }

               if(null == var12.field610) {
                  if(var12.field608 != null && (var12.field609 -= var3) <= 0) {
                     var6 = (int)(Math.random() * (double)var12.field608.length);
                     var13 = (class58)null;
                     var14 = class58.method1228(class28.field682, var12.field608[var6], 0);
                     if(var14 != null) {
                        var15 = var14.method1222().method1256(class110.field1960);
                        var16 = class64.method1280(var15, 100, var5);
                        var16.method1428(0);
                        class114.field1978.method1127(var16);
                        var12.field610 = var16;
                        var12.field609 = var12.field597 + (int)(Math.random() * (double)(var12.field607 - var12.field597));
                     }
                  }
               } else {
                  var12.field610.method1284(var5);
                  if(!var12.field610.method3897()) {
                     var12.field610 = null;
                  }
               }
            } else {
               if(null != var12.field598) {
                  class114.field1978.method1117(var12.field598);
                  var12.field598 = null;
               }

               if(null != var12.field610) {
                  class114.field1978.method1117(var12.field610);
                  var12.field610 = null;
               }
            }
         }
      }

      client.field356 = 0;
   }
}
