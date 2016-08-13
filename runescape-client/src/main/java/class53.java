import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class53 extends CacheableNode {
   @ObfuscatedName("l")
   static class170 field1164;
   @ObfuscatedName("r")
   public boolean field1166 = false;
   @ObfuscatedName("g")
   static NodeCache field1167 = new NodeCache(64);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1522750207"
   )
   void method1134(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1135(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1273892065"
   )
   void method1135(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1166 = true;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass136;",
      garbageValue = "-1279913920"
   )
   static class136 method1137() {
      try {
         return new class150();
      } catch (Throwable var1) {
         return new class144();
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "229"
   )
   static int method1139() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-142847619"
   )
   static void method1145(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class0.method2(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class0.method2(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3936((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class14.method179(var6)) {
            class0.method2(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-76"
   )
   public static void method1147() {
      while(true) {
         Deque var0 = class173.field2765;
         Deque var2 = class173.field2765;
         class172 var1;
         synchronized(class173.field2765) {
            var1 = (class172)class173.field2761.method3966();
         }

         if(var1 == null) {
            return;
         }

         var1.field2758.method3483(var1.field2759, (int)var1.hash, var1.field2755, false);
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "22"
   )
   static final boolean method1149(Widget var0) {
      if(null == var0.field2920) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2920.length; ++var1) {
            int var2 = class31.method689(var0, var1);
            int var3 = var0.field2921[var1];
            if(var0.field2920[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2920[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2920[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2105001500"
   )
   static final boolean method1150(int var0, int var1) {
      ObjectComposition var2 = class160.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method849(var1);
   }
}
