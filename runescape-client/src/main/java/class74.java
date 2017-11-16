import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class74 implements Comparator {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field845;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1215854593
   )
   static int field846;
   @ObfuscatedName("b")
   boolean field847;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lj;Lj;I)I",
      garbageValue = "1753977646"
   )
   int method1093(class14 var1, class14 var2) {
      if(var2.field277 == var1.field277) {
         return 0;
      } else {
         if(this.field847) {
            if(Client.world == var1.field277) {
               return -1;
            }

            if(var2.field277 == Client.world) {
               return 1;
            }
         }

         return var1.field277 < var2.field277?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1093((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhx;B)Ljava/lang/String;",
      garbageValue = "37"
   )
   static String method1094(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class27.method206(class139.method2860(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(Lhx;Ljj;IIZB)V",
      garbageValue = "100"
   )
   static final void method1099(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         class33.method323(var7, class222.getColTags(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
      }

   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Lbf;ZB)V",
      garbageValue = "50"
   )
   static final void method1100(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         Enum.method4462(var2);
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetFlags.method3592(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.method3593()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var6 = class64.method1017(var3);
      if(var6 != null) {
         ScriptEvent.method1038(var6);
      }

      WidgetNode.method1028();
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class64.loadWidget(var5)) {
            class19.method145(Widget.widgets[var5], 1);
         }
      }

   }
}
