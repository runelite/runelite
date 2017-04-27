import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
final class class0 implements Comparator {
   @ObfuscatedName("aw")
   static class102 field1;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;S)I",
      garbageValue = "13441"
   )
   int method4(class2 var1, class2 var2) {
      return var1.field22 < var2.field22?-1:(var1.field22 == var2.field22?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4((class2)var1, (class2)var2);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-833317903"
   )
   static final void method11() {
      if(Client.field489 > 0) {
         method12();
      } else {
         class9.setGameState(40);
         class132.field1979 = Friend.rssocket;
         Friend.rssocket = null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1606297872"
   )
   static final void method12() {
      if(Friend.rssocket != null) {
         Friend.rssocket.method2093();
         Friend.rssocket = null;
      }

      class101.method1962();
      class172.region.method1721();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2250();
      }

      System.gc();
      GameEngine.method2202(2);
      Client.field524 = -1;
      Client.field525 = false;

      for(class31 var1 = (class31)class31.field709.method2828(); var1 != null; var1 = (class31)class31.field709.method2830()) {
         if(var1.field705 != null) {
            class114.field1791.method945(var1.field705);
            var1.field705 = null;
         }

         if(var1.field710 != null) {
            class114.field1791.method945(var1.field710);
            var1.field710 = null;
         }
      }

      class31.field709.method2823();
      class9.setGameState(10);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "1898675338"
   )
   public static Widget method13(int var0, int var1) {
      Widget var2 = class128.method2364(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("d")
   public static final void method14(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class99.method1945(var0 - 1L);
            class99.method1945(1L);
         } else {
            class99.method1945(var0);
         }

      }
   }
}
