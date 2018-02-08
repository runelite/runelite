import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class80 {
   @ObfuscatedName("m")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("h")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("i")
   static int[] field1241;
   @ObfuscatedName("w")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("t")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 814627225
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("z")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1498481391
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lbn;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("q")
   static Calendar field1248;
   @ObfuscatedName("r")
   static final String[] field1238;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1526911583
   )
   static int field1250;
   @ObfuscatedName("v")
   static int[] field1251;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 442858239
   )
   @Export("cameraYaw")
   static int cameraYaw;

   static {
      field1241 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1248 = Calendar.getInstance();
      field1238 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1250 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgt;B)I",
      garbageValue = "27"
   )
   static int method1817(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-770907288"
   )
   public static void method1826() {
      VarPlayerType.varplayers.reset();
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2098345133"
   )
   static void method1825() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(FloorUnderlayDefinition.method4758(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
                  Client.menuBooleanArray[var1] = Client.menuBooleanArray[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
