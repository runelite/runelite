import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class166 {
   @ObfuscatedName("z")
   static int[] field2661;

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-68"
   )
   static final void method3276(String var0) {
      if(var0 != null) {
         if((client.field555 < 200 || client.field412 == 1) && client.field555 < 400) {
            String var1 = class138.method2969(var0, client.field294);
            if(null != var1) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field555; ++var2) {
                  class17 var3 = client.field557[var2];
                  var4 = class138.method2969(var3.field254, client.field294);
                  if(var4 != null && var4.equals(var1)) {
                     class52.method1147(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(null != var3.field248) {
                     var5 = class138.method2969(var3.field248, client.field294);
                     if(null != var5 && var5.equals(var1)) {
                        class52.method1147(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field559; ++var2) {
                  class7 var6 = client.field560[var2];
                  var4 = class138.method2969(var6.field134, client.field294);
                  if(null != var4 && var4.equals(var1)) {
                     class52.method1147(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.field137 != null) {
                     var5 = class138.method2969(var6.field137, client.field294);
                     if(null != var5 && var5.equals(var1)) {
                        class52.method1147(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class138.method2969(class15.field225.field60, client.field294).equals(var1)) {
                  class52.method1147(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  client.field333.method2773(251);
                  client.field333.method2654(class23.method629(var0));
                  client.field333.method2545(var0);
               }
            }
         } else {
            class52.method1147(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lclass173;I)Ljava/lang/String;",
      garbageValue = "1574125033"
   )
   static String method3281(String var0, class173 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class39.method827(class101.method2344(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var6 = "";
            if(class185.field2999 != null) {
               int var5 = class185.field2999.field2210;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var6 = var4;
               if(null != class185.field2999.field2216) {
                  var6 = (String)class185.field2999.field2216;
               }
            }

            var0 = var0.substring(0, var2) + var6 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lclass33;B)V",
      garbageValue = "25"
   )
   static final void method3282(class33 var0) {
      if(client.field482 == class15.field225.field837 >> 7 && client.field522 == class15.field225.field880 >> 7) {
         client.field482 = 0;
      }

      int var1 = class32.field753;
      int[] var2 = class32.field761;
      int var3 = var1;
      if(var0 == class33.field781 || class33.field772 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(class33.field781 == var0) {
            var5 = class15.field225;
            var6 = class15.field225.field37 << 14;
         } else if(var0 == class33.field772) {
            var5 = client.field302[client.field464];
            var6 = client.field464 << 14;
         } else {
            var5 = client.field302[var2[var4]];
            var6 = var2[var4] << 14;
            if(class33.field776 == var0 && client.field464 == var2[var4]) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod790() && !var5.field46) {
            var5.field53 = false;
            if((client.field296 && var1 > 50 || var1 > 200) && class33.field781 != var0 && var5.field826 == var5.field849) {
               var5.field53 = true;
            }

            int var7 = var5.field837 >> 7;
            int var8 = var5.field880 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.field43 != null && client.field301 >= var5.field54 && client.field301 < var5.field48) {
                  var5.field53 = false;
                  var5.field42 = class74.method1659(var5.field837, var5.field880, class14.field212);
                  class129.field2056.method2051(class14.field212, var5.field837, var5.field880, var5.field42, 60, var5, var5.field883, var6, var5.field49, var5.field50, var5.field51, var5.field52);
               } else {
                  if((var5.field837 & 127) == 64 && (var5.field880 & 127) == 64) {
                     if(client.field552 == client.field337[var7][var8]) {
                        continue;
                     }

                     client.field337[var7][var8] = client.field552;
                  }

                  var5.field42 = class74.method1659(var5.field837, var5.field880, class14.field212);
                  class129.field2056.method1986(class14.field212, var5.field837, var5.field880, var5.field42, 60, var5, var5.field883, var6, var5.field858);
               }
            }
         }
      }

   }
}
