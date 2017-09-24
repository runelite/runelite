import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class95 {
   @ObfuscatedName("a")
   static byte[] field1504;
   @ObfuscatedName("r")
   static byte[] field1513;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lfp;"
   )
   static Buffer[] field1506;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1872645791
   )
   static int field1507;
   @ObfuscatedName("q")
   static int[] field1511;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1215952399
   )
   static int field1509;
   @ObfuscatedName("k")
   static int[] field1515;
   @ObfuscatedName("s")
   static int[] field1502;
   @ObfuscatedName("d")
   static int[] field1512;
   @ObfuscatedName("l")
   static int[] field1508;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2109101675
   )
   static int field1514;
   @ObfuscatedName("y")
   static int[] field1510;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   static Buffer field1516;

   static {
      field1504 = new byte[2048];
      field1513 = new byte[2048];
      field1506 = new Buffer[2048];
      field1507 = 0;
      field1511 = new int[2048];
      field1509 = 0;
      field1515 = new int[2048];
      field1502 = new int[2048];
      field1512 = new int[2048];
      field1508 = new int[2048];
      field1514 = 0;
      field1510 = new int[2048];
      field1516 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-8"
   )
   static void method1814() {
      if(Client.spellSelected) {
         Widget var0 = Varcs.method1849(BaseVarType.field26, Client.field1087);
         if(var0 != null && var0.field2750 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field864 = var0.field2750;
            class153.method3002(var1);
         }

         Client.spellSelected = false;
         class7.method34(var0);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CIS)C",
      garbageValue = "-26058"
   )
   static char method1813(char var0, int var1) {
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

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }
}
