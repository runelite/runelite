import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class19 implements Comparator {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   static RSSocket field299;
   @ObfuscatedName("u")
   static byte[][][] field296;
   @ObfuscatedName("i")
   @Export("osNameLC")
   public static String osNameLC;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lj;Lj;I)I",
      garbageValue = "1804120945"
   )
   int method140(class14 var1, class14 var2) {
      return var1.field270 < var2.field270?-1:(var1.field270 == var2.field270?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method140((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)[Liw;",
      garbageValue = "339258079"
   )
   public static class235[] method142() {
      return new class235[]{class235.field3214, class235.field3215, class235.field3216, class235.field3217, class235.field3213, class235.field3212, class235.field3219, class235.field3218};
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1967717931"
   )
   static final int method143(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "([Lhx;II)V",
      garbageValue = "1186293760"
   )
   static final void method145(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method145(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class64.loadWidget(var5)) {
                     method145(Widget.widgets[var5], var1);
                  }
               }
            }

            ScriptEvent var6;
            if(var1 == 0 && var3.field2820 != null) {
               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.field785 = var3.field2820;
               BaseVarType.method11(var6);
            }

            if(var1 == 1 && var3.field2821 != null) {
               if(var3.index >= 0) {
                  Widget var7 = class64.method1017(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
                     continue;
                  }
               }

               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.field785 = var3.field2821;
               BaseVarType.method11(var6);
            }
         }
      }

   }
}
