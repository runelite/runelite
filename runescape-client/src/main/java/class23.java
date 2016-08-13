import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class23 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -19694681
   )
   int field606;
   @ObfuscatedName("g")
   int[] field607;
   @ObfuscatedName("r")
   int[] field608;
   @ObfuscatedName("e")
   String[] field609;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1614349601
   )
   int field610;
   @ObfuscatedName("l")
   static NodeCache field611 = new NodeCache(128);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1157917443
   )
   int field612;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1061318801
   )
   int field613;
   @ObfuscatedName("gj")
   static Widget field614;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 1318288997
   )
   static int field618;
   @ObfuscatedName("mm")
   static SpritePixels field619;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Ljava/lang/String;Ljava/lang/String;I)Lclass227;",
      garbageValue = "-1433800157"
   )
   public static class227 method596(class170 var0, class170 var1, String var2, String var3) {
      int var4 = var0.method3410(var2);
      int var5 = var0.method3459(var4, var3);
      class227 var6;
      if(!class4.method49(var0, var4, var5)) {
         var6 = null;
      } else {
         byte[] var7 = var1.method3411(var4, var5);
         class227 var8;
         if(var7 == null) {
            var8 = null;
         } else {
            class227 var9 = new class227(var7, class79.field1457, class180.field2962, class192.field3106, class79.field1458, class79.field1459, class145.field2236);
            ItemComposition.method1182();
            var8 = var9;
         }

         var6 = var8;
      }

      return var6;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1904598155"
   )
   static SpritePixels method597() {
      SpritePixels var0 = new SpritePixels();
      var0.field1484 = class79.field1454;
      var0.field1483 = class79.field1456;
      var0.field1480 = class79.field1457[0];
      var0.field1478 = class180.field2962[0];
      var0.width = class192.field3106[0];
      var0.height = class79.field1458[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class145.field2236[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class79.field1459[var2[var3] & 255];
      }

      ItemComposition.method1182();
      return var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass43;",
      garbageValue = "1641330043"
   )
   public static class43 method601(int var0) {
      class43 var1 = (class43)class43.field1000.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class43.field1007.method3411(1, var0);
         var1 = new class43();
         if(var2 != null) {
            var1.method905(new Buffer(var2), var0);
         }

         var1.method889();
         class43.field1000.put(var1, (long)var0);
         return var1;
      }
   }
}
