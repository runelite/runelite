import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class82 {
   @ObfuscatedName("g")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("x")
   static int[] field1258;
   @ObfuscatedName("f")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("u")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1053971181
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("k")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -51860535
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lbr;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1253;
   @ObfuscatedName("j")
   static Calendar field1267;
   @ObfuscatedName("m")
   static final String[] field1263;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1341213581
   )
   static int field1266;
   @ObfuscatedName("z")
   static int[] field1265;

   static {
      field1258 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1267 = Calendar.getInstance();
      field1263 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1266 = 0;
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "62"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class226.method4078(var0, class189.field2529);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class226.method4078(Client.friends[var3].name, class189.field2529)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class226.method4078(class275.localPlayer.name, class189.field2529))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
