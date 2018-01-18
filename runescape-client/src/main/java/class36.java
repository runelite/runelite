import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class36 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   static final class36 field484;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   static final class36 field480;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1694135557
   )
   final int field485;

   static {
      field484 = new class36(0);
      field480 = new class36(1);
   }

   class36(int var1) {
      this.field485 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-578890081"
   )
   public static final boolean method490(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Lfm;",
      garbageValue = "48"
   )
   public static Timer method491() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-47"
   )
   static void method489() {
      class91.username = class91.username.trim();
      if(class91.username.length() == 0) {
         ClanMember.method1170("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class150.method2992();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = Player.method1137(var1, class91.username);
         }

         switch(var0) {
         case 2:
            ClanMember.method1170("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class91.loginIndex = 6;
            break;
         case 3:
            ClanMember.method1170("", "Error connecting to server.", "");
            break;
         case 4:
            ClanMember.method1170("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            ClanMember.method1170("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            ClanMember.method1170("", "Error connecting to server.", "");
            break;
         case 7:
            ClanMember.method1170("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
