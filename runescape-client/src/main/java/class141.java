import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class141 {
   @ObfuscatedName("e")
   public static String field2180 = null;
   @ObfuscatedName("f")
   public static Applet field2182 = null;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-1358225466"
   )
   public static int method2955(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = 1 + (var0 << 4);
      }

      return var2;
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "1760088660"
   )
   static final void method2960(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method2960(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3849((long)var3.id);
               if(null != var4) {
                  class13.method152(var4.id, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && var3.field2895 != null) {
               var5 = new class0();
               var5.field2 = var3;
               var5.field1 = var3.field2895;
               class112.method2452(var5);
            }

            if(var1 == 1 && var3.field2896 != null) {
               if(var3.index >= 0) {
                  Widget var6 = class153.method3170(var3.id);
                  if(null == var6 || null == var6.children || var3.index >= var6.children.length || var6.children[var3.index] != var3) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field2 = var3;
               var5.field1 = var3.field2896;
               class112.method2452(var5);
            }
         }
      }

   }
}
