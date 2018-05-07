import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class95 {
   @ObfuscatedName("g")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   static final IterableDualNodeQueue field1429;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -592033461
   )
   static int field1431;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1429 = new IterableDualNodeQueue();
      field1431 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "469718687"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "79544076"
   )
   static final int method2076(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-743819804"
   )
   @Export("runWidgetOnLoadListener")
   static void runWidgetOnLoadListener(int var0) {
      if(var0 != -1) {
         if(class85.loadWidget(var0)) {
            Widget[] var1 = GZipDecompressor.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.onLoadListener != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.source = var3;
                  var4.objs = var3.onLoadListener;
                  class7.runScript(var4, 5000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-511615548"
   )
   static void method2095() {
      if(class265.localPlayer.x >> 7 == Client.destinationX && class265.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

   }
}
