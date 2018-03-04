import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public class class95 {
   @ObfuscatedName("d")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static final IterableDualNodeQueue field1431;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1498537481
   )
   static int field1434;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1685259315
   )
   static int field1436;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1431 = new IterableDualNodeQueue();
      field1434 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILir;B)Lct;",
      garbageValue = "9"
   )
   @Export("getScriptByFile")
   static Script getScriptByFile(int var0, class245 var1) {
      Script var2 = (Script)Script.field1439.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class1.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class1.indexScripts.takeRecordFlat(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = class61.newScript(var5);
               if(var2 != null) {
                  Script.field1439.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1587792274"
   )
   public static void method2042(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            class3.widgetIndex.method4684(var0);
            if(Widget.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }
}
