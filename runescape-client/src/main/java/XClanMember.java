import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("rp")
   protected static boolean field632;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -820262091
   )
   @Export("world")
   int world;
   @ObfuscatedName("r")
   @Export("rank")
   byte rank;
   @ObfuscatedName("d")
   String field635;
   @ObfuscatedName("it")
   @ObfuscatedGetter(
      intValue = -1774050141
   )
   static int field638;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -335870581
   )
   static int field640;
   @ObfuscatedName("a")
   @Export("username")
   String username;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-108"
   )
   public static final boolean method602() {
      class140 var0 = class140.keyboard;
      synchronized(class140.keyboard) {
         if(class140.field2197 == class140.field2185) {
            return false;
         } else {
            class117.field2047 = class140.field2195[class140.field2185];
            class24.field615 = class140.field2194[class140.field2185];
            class140.field2185 = class140.field2185 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-88"
   )
   static void method603() {
      Client.field323.method2801(126);
      Client.field323.method2513(class23.method586());
      Client.field323.method2514(class159.field2374);
      Client.field323.method2514(class92.field1643);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lclass50;",
      garbageValue = "-67"
   )
   public static class50 method604(int var0) {
      class50 var1 = (class50)class50.field1118.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field1027.method3309(14, var0);
         var1 = new class50();
         if(null != var2) {
            var1.method1032(new Buffer(var2));
         }

         class50.field1118.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "1927973552"
   )
   public static SpritePixels[] method605(class170 var0, String var1, String var2) {
      int var3 = var0.method3324(var1);
      int var4 = var0.method3313(var3, var2);
      SpritePixels[] var5;
      if(!class126.method2817(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class79.field1464];

         for(int var8 = 0; var8 < class79.field1464; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.field1481 = class79.field1460;
            var9.field1482 = class79.field1456;
            var9.field1479 = class79.field1462[var8];
            var9.field1480 = class79.field1458[var8];
            var9.width = class59.field1268[var8];
            var9.height = class79.field1461[var8];
            int var10 = var9.width * var9.height;
            byte[] var11 = class8.field139[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class132.field2126[var11[var12] & 255];
            }
         }

         class35.method747();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "35"
   )
   static World method606() {
      return World.field658 < World.field659?World.worldList[++World.field658 - 1]:null;
   }
}
