import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class69 {
   @ObfuscatedName("q")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("b")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("f")
   static int[] field1019;
   @ObfuscatedName("n")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("h")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("j")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1795765091
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Lak;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("g")
   static Calendar field1024;
   @ObfuscatedName("y")
   static final String[] field1018;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1805120271
   )
   static int field1025;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -749547257
   )
   static int field1028;

   static {
      field1019 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1024 = Calendar.getInstance();
      field1018 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1025 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Liv;IIS)[Llc;",
      garbageValue = "128"
   )
   static SpritePixels[] method1804(IndexDataBase var0, int var1, int var2) {
      return !class306.method5702(var0, var1, var2)?null:Coordinates.method4483();
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "506250925"
   )
   static void method1749() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         int var1 = var0.id;
         if(GameCanvas.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = OwnWorldComparator.getWidget(var4);
               if(var5 != null) {
                  DState.method3548(var5);
               }
            }
         }
      }

   }
}
