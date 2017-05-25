import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
public class class276 {
   @ObfuscatedName("i")
   public static final class276 field3724;
   @ObfuscatedName("h")
   public static final class276 field3725;
   @ObfuscatedName("u")
   public static final class276 field3726;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 709941923
   )
   public final int field3727;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class276(int var1) {
      this.field3727 = var1;
   }

   static {
      field3724 = new class276(0);
      field3725 = new class276(1);
      field3726 = new class276(2);
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "-37"
   )
   static final void method4969(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && Widget.validInterfaces[var2]) {
         Widget.field2682.method4186(var2);
         if(class90.widgets[var2] != null) {
            boolean var4 = true;

            for(var5 = 0; var5 < class90.widgets[var2].length; ++var5) {
               if(class90.widgets[var2][var5] != null) {
                  if(class90.widgets[var2][var5].type != 2) {
                     class90.widgets[var2][var5] = null;
                  } else {
                     var4 = false;
                  }
               }
            }

            if(var4) {
               class90.widgets[var2] = null;
            }

            Widget.validInterfaces[var2] = false;
         }
      }

      class166.method3129(var2);
      Widget var6 = class261.method4792(var3);
      if(var6 != null) {
         class219.method4130(var6);
      }

      XGrandExchangeOffer.method110();
      if(Client.widgetRoot != -1) {
         var5 = Client.widgetRoot;
         if(class14.method75(var5)) {
            ChatLineBuffer.method1907(class90.widgets[var5], 1);
         }
      }

   }
}
