import java.applet.Applet;
import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class108 {
   @ObfuscatedName("i")
   static Applet field1719;
   @ObfuscatedName("v")
   static class228 field1724;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 325975559
   )
   protected static int field1726;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/lang/Object;I)V",
      garbageValue = "1437865658"
   )
   public static void method2014(class103 var0, Object var1) {
      if(null != var0.field1659) {
         for(int var2 = 0; var2 < 50 && var0.field1659.peekEvent() != null; ++var2) {
            class10.method149(1L);
         }

         if(null != var1) {
            var0.field1659.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "90"
   )
   static final void method2015() {
      class200.field3045.reset();
      class191.field2809.reset();
      class105.method1994();
      class15.method172();
      class118.method2251();
      ItemComposition.field2949.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      Sequence.field3050.reset();
      Sequence.field3054.reset();
      class190.field2793.reset();
      class190.field2803.reset();
      class194.field2850.reset();
      class1.method16();
      class164.method3056();
      class156.method2954();
      PlayerComposition.field2175.reset();
      Widget.field2197.reset();
      Widget.field2281.reset();
      Widget.field2221.reset();
      Widget.field2205.reset();
      ((TextureProvider)class84.field1450).method1418();
      class48.field953.reset();
      class137.field1897.method3223();
      class44.field900.method3223();
      class47.field947.method3223();
      VertexNormal.field1425.method3223();
      Friend.field150.method3223();
      class204.field3079.method3223();
      class140.field1974.method3223();
      Client.field314.method3223();
      MessageNode.field220.method3223();
      CollisionData.field1838.method3223();
      class105.field1706.method3223();
      class65.field1111.method3223();
   }
}
