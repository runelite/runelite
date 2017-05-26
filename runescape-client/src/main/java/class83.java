import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class83 {
   @ObfuscatedName("a")
   static class111 field1308;
   @ObfuscatedName("u")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("j")
   static final String[] field1310;
   @ObfuscatedName("x")
   static Widget field1311;
   @ObfuscatedName("v")
   static int[][] field1312;
   @ObfuscatedName("t")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -755406857
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("l")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("q")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("o")
   static Calendar field1320;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 592400825
   )
   static int field1321;
   @ObfuscatedName("g")
   static int[] field1322;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 315081167
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("r")
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("rq")
   static class288 field1325;

   static {
      field1322 = new int[5];
      field1312 = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1320 = Calendar.getInstance();
      field1310 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1321 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-1508256929"
   )
   public static char method1686(char var0, int var1) {
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
}
