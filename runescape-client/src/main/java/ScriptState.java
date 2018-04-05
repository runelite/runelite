import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = -2113898473
   )
   static int field755;
   @ObfuscatedName("p")
   static int[] field762;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 260466589
   )
   static int field761;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -1304361363
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1003403421
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("t")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("d")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lbg;Lbg;IZI)I",
      garbageValue = "570182430"
   )
   static int method1110(World var0, World var1, int var2, boolean var3) {
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
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1686()?(var1.method1686()?0:1):(var1.method1686()?-1:0)):(var2 == 5?(var0.method1684()?(var1.method1684()?0:1):(var1.method1684()?-1:0)):(var2 == 6?(var0.method1685()?(var1.method1685()?0:1):(var1.method1685()?-1:0)):(var2 == 7?(var0.method1683()?(var1.method1683()?0:1):(var1.method1683()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(Ljn;Ljava/lang/String;I)V",
      garbageValue = "-1408810217"
   )
   static void method1108(IndexData var0, String var1) {
      class64 var2 = new class64(var0, var1);
      Client.field871.add(var2);
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1397694242"
   )
   static void method1109() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.menuBooleanArray[var3] = Client.menuBooleanArray[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
