import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public final class class87 {
   @ObfuscatedName("m")
   static int[] field1504;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -202373353
   )
   int field1505;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1828116309
   )
   int field1506;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1462692681
   )
   int field1507;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1871617303
   )
   int field1508;
   @ObfuscatedName("h")
   public class85 field1509;
   @ObfuscatedName("g")
   public class85 field1510;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1530772031
   )
   int field1511;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -573236111
   )
   int field1512 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 532232861
   )
   public int field1515 = 0;
   @ObfuscatedName("cr")
   static class143 field1516;

   @ObfuscatedName("j")
   public static void method2090() {
      class173.field2824.method3760();
      class173.field2860.method3760();
      class173.field2751.method3760();
      class173.field2768.method3760();
   }

   @ObfuscatedName("s")
   static void method2091() {
      class31.field703 = class31.field703.trim();
      if(class31.field703.length() == 0) {
         class121.method2750("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class52.method1085();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = class12.method162(var1, class31.field703);
         }

         switch(var0) {
         case 2:
            class121.method2750("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field702 = 6;
            break;
         case 3:
            class121.method2750("", "Error connecting to server.", "");
            break;
         case 4:
            class121.method2750("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class121.method2750("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class121.method2750("", "Error connecting to server.", "");
            break;
         case 7:
            class121.method2750("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("w")
   static void method2092(int var0, String var1, String var2) {
      class46.method973(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static void method2093(int var0) {
      for(class201 var1 = (class201)client.field480.method3794(); null != var1; var1 = (class201)client.field480.method3791()) {
         if((var1.field3115 >> 48 & 65535L) == (long)var0) {
            var1.method3913();
         }
      }

   }

   @ObfuscatedName("s")
   public static String method2094(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class165.field2659[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-43"
   )
   public static void method2095() {
      while(true) {
         class199 var1 = class170.field2708;
         class169 var0;
         synchronized(class170.field2708) {
            var0 = (class169)class170.field2706.method3823();
         }

         if(var0 == null) {
            return;
         }

         var0.field2701.method3327(var0.field2700, (int)var0.field3115, var0.field2699, false);
      }
   }
}
