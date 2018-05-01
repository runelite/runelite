import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class81 {
   @ObfuscatedName("z")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("n")
   static int[] field1277;
   @ObfuscatedName("l")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("s")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("c")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -964697413
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 969622183
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lbk;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static Widget field1270;
   @ObfuscatedName("p")
   static Calendar field1271;
   @ObfuscatedName("q")
   static final String[] field1263;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   @Export("scriptMapIconReference")
   static MapIconReference scriptMapIconReference;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 172673385
   )
   static int field1274;

   static {
      field1277 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1271 = Calendar.getInstance();
      field1263 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1274 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "1925295473"
   )
   static int method1912(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class49.field604:field1270;
      if(var0 == 1600) {
         intStack[++class171.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         intStack[++class171.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         scriptStringStack[++scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         intStack[++class171.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         intStack[++class171.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         intStack[++class171.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         intStack[++class171.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         intStack[++class171.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         intStack[++class171.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         intStack[++class171.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         intStack[++class171.intStackSize - 1] = var3.field2853;
         return 1;
      } else if(var0 == 1611) {
         intStack[++class171.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         intStack[++class171.intStackSize - 1] = var3.field2847;
         return 1;
      } else if(var0 == 1613) {
         intStack[++class171.intStackSize - 1] = var3.field2854.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
