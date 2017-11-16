import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2078937009
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1747902745
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1994232587
   )
   @Export("identifier")
   int identifier;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 160287915
   )
   @Export("type")
   int type;
   @ObfuscatedName("x")
   @Export("option")
   String option;

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1490134270"
   )
   static void method1679() {
      if(Client.spellSelected) {
         Widget var0 = DecorativeObject.method2896(class47.field562, Client.field1003);
         if(var0 != null && var0.field2805 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field785 = var0.field2805;
            BaseVarType.method11(var1);
         }

         Client.spellSelected = false;
         ScriptEvent.method1038(var0);
      }
   }
}
