import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class118 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 260818437
   )
   public static int field1842;
   @ObfuscatedName("m")
   public static int[] field1843 = new int[4096];
   @ObfuscatedName("v")
   public static int[][] field1844 = new int[128][128];
   @ObfuscatedName("a")
   public static int[] field1845 = new int[4096];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1826607149
   )
   public static int field1846;
   @ObfuscatedName("db")
   static int[] field1847;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 1752218421
   )
   static int field1849;
   @ObfuscatedName("g")
   public static int[][] field1851 = new int[128][128];

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1617221011"
   )
   static void method2380() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         class41.method864("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class57.method1178();
         int var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            var0 = XItemContainer.method180(var1, class41.username);
         }

         switch(var0) {
         case 2:
            class41.method864("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            class41.method864("", "Error connecting to server.", "");
            break;
         case 4:
            class41.method864("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class41.method864("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class41.method864("", "Error connecting to server.", "");
            break;
         case 7:
            class41.method864("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1010086035"
   )
   static int method2383(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      return null != class210.field3130 && class210.field3130.hash == var2?1 + ChatMessages.field939.offset * 99 / (ChatMessages.field939.payload.length - class210.field3130.field2707):0;
   }

   @ObfuscatedName("rd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   protected static final void method2384() {
      Frames.field1576.vmethod2132();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1770[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1783[var0] = 0L;
      }

      Friend.field148 = 0;
   }

   class118() throws Throwable {
      throw new Error();
   }
}
