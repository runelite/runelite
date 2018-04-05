import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("h")
   @Export("indexedSpriteOffsetYs")
   static int[] indexedSpriteOffsetYs;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1844691065
   )
   @Export("type")
   int type;
   @ObfuscatedName("k")
   public byte[] field3367;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("data")
   public IndexData data;

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(IIII)Lbt;",
      garbageValue = "-2107829732"
   )
   static final WidgetNode method4523(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      BoundingBox.method45(var1);
      Widget var4 = class44.getWidget(var0);
      FontName.method5490(var4);
      if(Client.field1033 != null) {
         FontName.method5490(Client.field1033);
         Client.field1033 = null;
      }

      ScriptState.method1109();
      class86.method1889(MouseRecorder.widgets[var0 >> 16], var4, false);
      class20.runWidgetOnLoadListener(var1);
      if(Client.widgetRoot != -1) {
         DynamicObject.method2026(Client.widgetRoot, 1);
      }

      return var3;
   }
}
