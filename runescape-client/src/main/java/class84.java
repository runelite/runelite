import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class84 {
   @ObfuscatedName("w")
   static int[] field1329;
   @ObfuscatedName("k")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("v")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("r")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1563948697
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lbu;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("s")
   static Calendar field1337;
   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("c")
   static final String[] field1338;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1750209601
   )
   static int field1339;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 534034941
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1126683851
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("g")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("y")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;

   static {
      field1329 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1337 = Calendar.getInstance();
      field1338 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1339 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "4"
   )
   static final int method1661() {
      return class135.field1991;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lhc;I)Z",
      garbageValue = "2076365085"
   )
   public static boolean method1684(class220 var0) {
      return class220.field2772 == var0 || class220.field2763 == var0 || class220.field2764 == var0 || class220.field2765 == var0 || class220.field2766 == var0 || class220.field2762 == var0 || class220.field2767 == var0 || class220.field2768 == var0;
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-701220111"
   )
   static final String[] method1685(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
