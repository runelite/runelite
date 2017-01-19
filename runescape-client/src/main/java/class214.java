import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class214 {
   @ObfuscatedName("f")
   static final class214 field3146 = new class214("4", "4");
   @ObfuscatedName("c")
   static final class214 field3147 = new class214("15", "15");
   @ObfuscatedName("x")
   static final class214 field3148 = new class214("8", "8");
   @ObfuscatedName("h")
   static final class214 field3149 = new class214("11", "11");
   @ObfuscatedName("a")
   static final class214 field3150 = new class214("7", "7");
   @ObfuscatedName("g")
   static final class214 field3151 = new class214("13", "13");
   @ObfuscatedName("p")
   public final String field3152;
   @ObfuscatedName("k")
   static final class214 field3153 = new class214("3", "3");
   @ObfuscatedName("b")
   static final class214 field3154 = new class214("10", "10");
   @ObfuscatedName("u")
   static final class214 field3155 = new class214("1", "1");
   @ObfuscatedName("r")
   static final class214 field3156 = new class214("5", "5");
   @ObfuscatedName("n")
   static final class214 field3157 = new class214("2", "2");
   @ObfuscatedName("m")
   public static final class214 field3158 = new class214("14", "14");
   @ObfuscatedName("j")
   public static final class214 field3159 = new class214("6", "6");
   @ObfuscatedName("w")
   static final class214 field3160 = new class214("9", "9");
   @ObfuscatedName("s")
   static final class214 field3161 = new class214("12", "12");

   class214(String var1, String var2) {
      this.field3152 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "443125283"
   )
   static int method3827(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method600()?(var1.method600()?0:1):(var1.method600()?-1:0)):(var2 == 5?(var0.method598()?(var1.method598()?0:1):(var1.method598()?-1:0)):(var2 == 6?(var0.method599()?(var1.method599()?0:1):(var1.method599()?-1:0)):(var2 == 7?(var0.method621()?(var1.method621()?0:1):(var1.method621()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "1199801734"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }
}
