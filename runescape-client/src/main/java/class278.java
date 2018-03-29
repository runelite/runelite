import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class278 extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field3542;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3545;
   @ObfuscatedName("o")
   char field3544;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -129043779
   )
   public int field3543;
   @ObfuscatedName("k")
   public String field3546;
   @ObfuscatedName("x")
   boolean field3547;

   static {
      field3545 = new NodeCache(64);
   }

   class278() {
      this.field3547 = true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2028292566"
   )
   void method4903() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-1354491236"
   )
   void method4905(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4909(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgp;IB)V",
      garbageValue = "9"
   )
   void method4909(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3544 = NPC.method1838(var1.readByte());
      } else if(var2 == 2) {
         this.field3543 = var1.readInt();
      } else if(var2 == 4) {
         this.field3547 = false;
      } else if(var2 == 5) {
         this.field3546 = var1.readString();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1992436166"
   )
   public boolean method4907() {
      return this.field3544 == 's';
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-398888946"
   )
   static void method4922() {
      class90.username = class90.username.trim();
      if(class90.username.length() == 0) {
         class33.method385("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = MapLabel.method387();
         int var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            var0 = class234.method4359(var1, class90.username);
         }

         switch(var0) {
         case 2:
            class33.method385("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class90.loginIndex = 6;
            break;
         case 3:
            class33.method385("", "Error connecting to server.", "");
            break;
         case 4:
            class33.method385("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class33.method385("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class33.method385("", "Error connecting to server.", "");
            break;
         case 7:
            class33.method385("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
