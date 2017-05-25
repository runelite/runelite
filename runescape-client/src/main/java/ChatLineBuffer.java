import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("h")
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1719492491
   )
   @Export("length")
   int length;
   @ObfuscatedName("ac")
   static java.awt.Font field1552;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "53"
   )
   public static int method1895(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "1347121655"
   )
   MessageNode method1896(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method3687();
         var5.method1127(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "-1599932837"
   )
   MessageNode method1897(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-407545225"
   )
   int method1898() {
      return this.length;
   }

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-32"
   )
   static final void method1903(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1093; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1096[var4] = true;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CS)Z",
      garbageValue = "1404"
   )
   public static boolean method1905(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "915413661"
   )
   static final void method1907(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1907(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3615((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class14.method75(var5)) {
                     method1907(class90.widgets[var5], var1);
                  }
               }
            }

            class69 var6;
            if(var1 == 0 && var3.field2749 != null) {
               var6 = new class69();
               var6.field816 = var3;
               var6.field826 = var3.field2749;
               GroundObject.method2522(var6);
            }

            if(var1 == 1 && var3.field2735 != null) {
               if(var3.index >= 0) {
                  Widget var7 = class261.method4792(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
                     continue;
                  }
               }

               var6 = new class69();
               var6.field816 = var3;
               var6.field826 = var3.field2735;
               GroundObject.method2522(var6);
            }
         }
      }

   }
}
