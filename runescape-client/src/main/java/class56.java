import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class56 {
   @ObfuscatedName("m")
   public static IndexDataBase field665;
   @ObfuscatedName("n")
   static Applet field667;
   @ObfuscatedName("p")
   static String field669;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-1059247011"
   )
   public static void method800(IndexDataBase var0) {
      class251.field3389 = var0;
   }

   static {
      field667 = null;
      field669 = null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "923026271"
   )
   static int method809(World var0, World var1, int var2, boolean var3) {
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
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1521()?(var1.method1521()?0:1):(var1.method1521()?-1:0)):(var2 == 5?(var0.method1519()?(var1.method1519()?0:1):(var1.method1519()?-1:0)):(var2 == 6?(var0.method1554()?(var1.method1554()?0:1):(var1.method1554()?-1:0)):(var2 == 7?(var0.method1518()?(var1.method1518()?0:1):(var1.method1518()?-1:0)):var0.id - var1.id)))));
      }
   }
}
