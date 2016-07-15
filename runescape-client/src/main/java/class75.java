import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class75 implements Runnable {
   @ObfuscatedName("h")
   volatile boolean field1417 = false;
   @ObfuscatedName("l")
   volatile class59[] field1418 = new class59[2];
   @ObfuscatedName("c")
   volatile boolean field1419 = false;
   @ObfuscatedName("e")
   class139 field1423;

   public void run() {
      this.field1417 = true;

      try {
         while(!this.field1419) {
            class59 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1418[var1];
               if(var2 != null) {
                  var2.method1277();
               }
            }

            class125.method2881(10L);
            class139 var5 = this.field1423;
            var2 = null;
            if(null != var5.field2144) {
               for(int var3 = 0; var3 < 50 && var5.field2144.peekEvent() != null; ++var3) {
                  class125.method2881(1L);
               }

               if(null != var2) {
                  var5.field2144.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         class46.method1008((String)null, var8);
      } finally {
         this.field1417 = false;
      }

   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-143037715"
   )
   static void method1663(int var0, int var1) {
      class32 var2 = class11.field189;
      class25.method587(var2.field749, var2.field746, var2.field748, var2.field747, var2.field750, var2.field750, var0, var1);
      class11.field189 = null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "465203058"
   )
   static final int method1668(int var0, int var1) {
      int var2 = class2.method14(var0 - 1, var1 - 1) + class2.method14(var0 + 1, var1 - 1) + class2.method14(var0 - 1, var1 + 1) + class2.method14(1 + var0, 1 + var1);
      int var3 = class2.method14(var0 - 1, var1) + class2.method14(1 + var0, var1) + class2.method14(var0, var1 - 1) + class2.method14(var0, 1 + var1);
      int var4 = class2.method14(var0, var1);
      return var4 / 4 + var3 / 8 + var2 / 16;
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-936741152"
   )
   static boolean method1669(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class17.method167(var0, client.field296);

         for(int var3 = 0; var3 < client.field511; ++var3) {
            if(var2.equalsIgnoreCase(class17.method167(client.field564[var3].field253, client.field296)) && (!var1 || client.field564[var3].field249 != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class17.method167(class118.field2035.field52, client.field296))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1452515303"
   )
   static final void method1670(String var0) {
      if(var0 != null) {
         if((client.field511 < 200 || client.field418 == 1) && client.field511 < 400) {
            String var1 = class17.method167(var0, client.field296);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field511; ++var2) {
                  class17 var3 = client.field564[var2];
                  var4 = class17.method167(var3.field253, client.field296);
                  if(var4 != null && var4.equals(var1)) {
                     class25.method586(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(null != var3.field257) {
                     var5 = class17.method167(var3.field257, client.field296);
                     if(null != var5 && var5.equals(var1)) {
                        class25.method586(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field346; ++var2) {
                  class7 var6 = client.field560[var2];
                  var4 = class17.method167(var6.field141, client.field296);
                  if(null != var4 && var4.equals(var1)) {
                     class25.method586(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.field131 != null) {
                     var5 = class17.method167(var6.field131, client.field296);
                     if(null != var5 && var5.equals(var1)) {
                        class25.method586(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class17.method167(class118.field2035.field52, client.field296).equals(var1)) {
                  class25.method586(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  client.field336.method2854(98);
                  client.field336.method2795(class29.method650(var0));
                  client.field336.method2601(var0);
               }
            }
         } else {
            class25.method586(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }
}
