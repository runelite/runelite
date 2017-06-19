import java.applet.Applet;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
final class class95 implements Comparator {
   final boolean val$preferOwnWorld;
   @ObfuscatedName("p")
   static IndexDataBase field1484;
   @ObfuscatedName("j")
   public static IndexDataBase field1485;

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-260685283"
   )
   static void method1670(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      XClanMember.method1097(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         XClanMember.method1097(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3425((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class59.method961(var6)) {
            XClanMember.method1097(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;B)I",
      garbageValue = "101"
   )
   int method1671(class14 var1, class14 var2) {
      if(var2.field297 == var1.field297) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field297) {
               return -1;
            }

            if(var2.field297 == Client.world) {
               return 1;
            }
         }

         return var1.field297 < var2.field297?-1:1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "-641662840"
   )
   static long method1672(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1671((class14)var1, (class14)var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "117"
   )
   public static void method1681(Applet var0, String var1) {
      class56.field688 = var0;
      class56.field687 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-612834974"
   )
   public static void method1682(boolean var0) {
      if(var0 != class240.isMembersWorld) {
         ItemComposition.field3497.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         class240.isMembersWorld = var0;
      }

   }

   class95(boolean var1) {
      this.val$preferOwnWorld = var1;
   }
}
