import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class174 {
   @ObfuscatedName("ad")
   static ModIcon[] field2643;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-1899151311"
   )
   public static Widget method3178(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = class2.method25(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   static final void method3179() {
      if(class6.field46 != null) {
         class6.field46.method2027();
         class6.field46 = null;
      }

      class3.method33();
      class159.region.method1666();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2199();
      }

      System.gc();
      class119.method2238(2);
      Client.field522 = -1;
      Client.field493 = false;

      for(class31 var1 = (class31)class31.field723.method2349(); var1 != null; var1 = (class31)class31.field723.method2351()) {
         if(null != var1.field716) {
            FaceNormal.field1554.method923(var1.field716);
            var1.field716 = null;
         }

         if(var1.field714 != null) {
            FaceNormal.field1554.method923(var1.field714);
            var1.field714 = null;
         }
      }

      class31.field723.method2348();
      class20.setGameState(10);
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "966248254"
   )
   static final String method3180(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
