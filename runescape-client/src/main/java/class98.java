import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class98 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -408530371
   )
   static int field1496;
   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static class232 field1497;
   @ObfuscatedName("c")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   static final class186 field1495;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   static final class201 field1493;

   static {
      chatLineMap = new HashMap();
      field1495 = new class186(1024);
      field1493 = new class201();
      field1496 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   public static boolean method1779(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "36"
   )
   public static void method1769(int var0) {
      if(var0 != -1) {
         if(class163.validInterfaces[var0]) {
            class35.widgetIndex.method4021(var0);
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

               class163.validInterfaces[var0] = false;
            }
         }
      }
   }
}
