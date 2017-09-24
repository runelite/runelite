import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class82 {
   @ObfuscatedName("o")
   static int[] field1346;
   @ObfuscatedName("n")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("q")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("k")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1022243897
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lba;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("v")
   static Calendar field1343;
   @ObfuscatedName("c")
   static final String[] field1353;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1780758693
   )
   static int field1354;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1780761805
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("a")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;

   static {
      field1346 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1343 = Calendar.getInstance();
      field1353 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1354 = 0;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lds;I)V",
      garbageValue = "-1759063318"
   )
   static final void method1674(class118 var0) {
      var0.field1729 = false;
      if(var0.field1728 != null) {
         var0.field1728.field1760 = 0;
      }

      for(class118 var1 = var0.vmethod3943(); var1 != null; var1 = var0.vmethod3934()) {
         method1674(var1);
      }

   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IIII)Lbq;",
      garbageValue = "2052709534"
   )
   static final WidgetNode method1644(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      IndexDataBase.method4169(var1);
      Widget var4 = GZipDecompressor.method3177(var0);
      class7.method34(var4);
      if(Client.field1086 != null) {
         class7.method34(Client.field1086);
         Client.field1086 = null;
      }

      class13.method83();
      class64.method1114(class268.widgets[var0 >> 16], var4, false);
      GameEngine.method907(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class13.loadWidget(var5)) {
            ScriptEvent.method1133(class268.widgets[var5], 1);
         }
      }

      return var3;
   }
}
