import java.awt.Font;
import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class38 {
   @ObfuscatedName("t")
   static final String[] field801 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 724359779
   )
   static int field802 = 0;
   @ObfuscatedName("i")
   static int[] field803 = new int[5];
   @ObfuscatedName("j")
   static int[] field804;
   @ObfuscatedName("l")
   static int[] field805 = new int[1000];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1823253125
   )
   static int field806 = 0;
   @ObfuscatedName("v")
   static Widget field807;
   @ObfuscatedName("f")
   static class14[] field808 = new class14[50];
   @ObfuscatedName("m")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("q")
   static Calendar field810 = Calendar.getInstance();
   @ObfuscatedName("b")
   static int[][] field812 = new int[5][5000];
   @ObfuscatedName("qv")
   protected static Font field815;

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1061972045"
   )
   static final boolean method738(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1082860827"
   )
   static char method744(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1784408795"
   )
   static final void method745(String var0) {
      if(!var0.equals("")) {
         Client.field323.method2818(160);
         Client.field323.method2715(class43.method857(var0));
         Client.field323.method2616(var0);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "594402229"
   )
   public static int method747(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }
}
