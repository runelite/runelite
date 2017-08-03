import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class83 {
   @ObfuscatedName("e")
   static int[] field1304;
   @ObfuscatedName("f")
   @Export("SHAPE_VERTICIES")
   static int[][] SHAPE_VERTICIES;
   @ObfuscatedName("v")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("i")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -792973403
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lbl;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("u")
   static Calendar field1311;
   @ObfuscatedName("b")
   static final String[] field1312;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -831431735
   )
   static int field1306;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1934166363
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("x")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("y")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;

   static {
      field1304 = new int[5];
      SHAPE_VERTICIES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1311 = Calendar.getInstance();
      field1312 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1306 = 0;
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1858647605"
   )
   static void method1680() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3564(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3565()) {
         int var1 = var0.id;
         if(class7.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = class170.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = WallObject.method2901(var4);
               if(var5 != null) {
                  class48.method732(var5);
               }
            }
         }
      }

   }
}
