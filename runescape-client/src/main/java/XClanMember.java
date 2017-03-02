import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("ba")
   static class184 field266;
   @ObfuscatedName("ri")
   protected static String field267;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1938823665
   )
   @Export("world")
   int world;
   @ObfuscatedName("t")
   @Export("rank")
   byte rank;
   @ObfuscatedName("b")
   @Export("username")
   String username;
   @ObfuscatedName("l")
   String field277;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass68;B)V",
      garbageValue = "38"
   )
   static final void method257(class68 var0) {
      var0.field1124 = false;
      if(var0.field1127 != null) {
         var0.field1127.field1158 = 0;
      }

      for(class68 var1 = var0.vmethod2744(); null != var1; var1 = var0.vmethod2746()) {
         method257(var1);
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1681002476"
   )
   static void method258() {
      if(Client.field549) {
         Widget var0 = CollisionData.method2322(class170.field2331, Client.field441);
         if(var0 != null && var0.field2263 != null) {
            class18 var1 = new class18();
            var1.field185 = var0;
            var1.field197 = var0.field2263;
            class97.method1988(var1);
         }

         Client.field549 = false;
         Frames.method1960(var0);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-263854717"
   )
   public static void method259(Component var0) {
      var0.removeMouseListener(class115.mouse);
      var0.removeMouseMotionListener(class115.mouse);
      var0.removeFocusListener(class115.mouse);
      class115.field1797 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "1192990601"
   )
   public static void method260(class182 var0, class182 var1, class182 var2) {
      class108.field1728 = var0;
      Sequence.field3065 = var1;
      Sequence.field3059 = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "-301160921"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3075.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class108.field1728.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method3856(new Buffer(var2));
         }

         var1.method3859();
         Sequence.field3075.put(var1, (long)var0);
         return var1;
      }
   }
}
