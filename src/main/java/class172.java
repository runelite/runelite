import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class172 extends class204 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 901671459
   )
   public int field2730;
   @ObfuscatedName("j")
   public class168 field2731;
   @ObfuscatedName("m")
   public byte field2732;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   static void method3357() {
      class31.field698 = class31.field698.trim();
      if(class31.field698.length() == 0) {
         class114.method2436("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class20.method559();
         int var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            var0 = class75.method1630(var1, class31.field698);
         }

         switch(var0) {
         case 2:
            class114.method2436("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field712 = 6;
            break;
         case 3:
            class114.method2436("", "Error connecting to server.", "");
            break;
         case 4:
            class114.method2436("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class114.method2436("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class114.method2436("", "Error connecting to server.", "");
            break;
         case 7:
            class114.method2436("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "51"
   )
   public static int method3358(int var0) {
      return var0 >> 17 & 7;
   }
}
