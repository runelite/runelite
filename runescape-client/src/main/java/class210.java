import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class210 extends CacheableNode {
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = -749905481
   )
   static int field2590;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -28782361
   )
   public final int field2589;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -253317073
   )
   public final int field2592;
   @ObfuscatedName("q")
   public final int[] field2591;
   @ObfuscatedName("o")
   public final int[] field2594;

   class210(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2589 = var1;
      this.field2592 = var2;
      this.field2591 = var3;
      this.field2594 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "160971214"
   )
   public boolean method4001(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2594.length) {
         int var3 = this.field2594[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2591[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "78"
   )
   static void method4000() {
      class90.username = class90.username.trim();
      if(class90.username.length() == 0) {
         class36.method481("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class27.method221();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = Spotanim.method4414(var1, class90.username);
         }

         switch(var0) {
         case 2:
            class36.method481("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class90.loginIndex = 6;
            break;
         case 3:
            class36.method481("", "Error connecting to server.", "");
            break;
         case 4:
            class36.method481("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class36.method481("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class36.method481("", "Error connecting to server.", "");
            break;
         case 7:
            class36.method481("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
