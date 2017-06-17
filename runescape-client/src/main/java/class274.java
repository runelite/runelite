import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
public class class274 {
   @ObfuscatedName("e")
   public static final class274 field3712;
   @ObfuscatedName("f")
   public static final class274 field3713;
   @ObfuscatedName("w")
   public static final class274 field3714;
   @ObfuscatedName("z")
   public static final class274 field3715;
   @ObfuscatedName("n")
   public static final class274 field3716;
   @ObfuscatedName("i")
   public static final class274 field3717;
   @ObfuscatedName("j")
   public static final class274 field3718;
   @ObfuscatedName("p")
   public static final class274 field3719;
   @ObfuscatedName("g")
   public static final class274 field3720;
   @ObfuscatedName("q")
   public static final class274 field3721;
   @ObfuscatedName("c")
   public static final class274 field3722;
   @ObfuscatedName("a")
   public static final class274 field3723;
   @ObfuscatedName("o")
   public static final class274 field3724;
   @ObfuscatedName("v")
   public final String field3725;
   @ObfuscatedName("t")
   public static final class274 field3727;
   @ObfuscatedName("m")
   public static final class274 field3728;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "208"
   )
   static void method4790() {
      class92.username = class92.username.trim();
      if(class92.username.length() == 0) {
         class47.method674("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var0 = class109.method1967();
         int var2;
         if(0L == var0) {
            var2 = 5;
         } else {
            var2 = class236.method4093(var0, class92.username);
         }

         switch(var2) {
         case 2:
            class47.method674("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class92.loginIndex = 6;
            break;
         case 3:
            class47.method674("", "Error connecting to server.", "");
            break;
         case 4:
            class47.method674("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class47.method674("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class47.method674("", "Error connecting to server.", "");
            break;
         case 7:
            class47.method674("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }
      }

   }

   class274(String var1, String var2) {
      this.field3725 = var2;
   }

   static {
      field3719 = new class274("6", "6");
      field3728 = new class274("2", "2");
      field3712 = new class274("13", "13");
      field3727 = new class274("9", "9");
      field3714 = new class274("15", "15");
      field3715 = new class274("1", "1");
      field3718 = new class274("7", "7");
      field3717 = new class274("10", "10");
      field3713 = new class274("12", "12");
      field3722 = new class274("11", "11");
      field3724 = new class274("3", "3");
      field3721 = new class274("14", "14");
      field3716 = new class274("8", "8");
      field3723 = new class274("5", "5");
      field3720 = new class274("4", "4");
   }
}
