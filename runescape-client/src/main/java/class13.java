import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class13 implements Runnable {
   @ObfuscatedName("l")
   Object field206 = new Object();
   @ObfuscatedName("h")
   int[] field208 = new int[500];
   @ObfuscatedName("r")
   int[] field209 = new int[500];
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 1062085871
   )
   @Export("menuWidth")
   static int field213;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1676456439
   )
   int field214 = 0;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 1820640651
   )
   static int field215;
   @ObfuscatedName("e")
   boolean field216 = true;
   @ObfuscatedName("j")
   public static class175 field217;
   @ObfuscatedName("ct")
   static class146 field219;

   public void run() {
      for(; this.field216; class125.method2881(50L)) {
         Object var1 = this.field206;
         synchronized(this.field206) {
            if(this.field214 < 500) {
               this.field208[this.field214] = class143.field2198;
               this.field209[this.field214] = class143.field2201;
               ++this.field214;
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Lclass21;",
      garbageValue = "1224861940"
   )
   static class21[] method152() {
      return new class21[]{class21.field594, class21.field593, class21.field598, class21.field597};
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass44;",
      garbageValue = "1240168613"
   )
   @Export("getAnimation")
   public static class44 method153(int var0) {
      class44 var1 = (class44)class44.field1021.method3834((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class44.field1031.method3340(12, var0);
         var1 = new class44();
         if(null != var2) {
            var1.method952(new class122(var2));
         }

         var1.method918();
         class44.field1021.method3836(var1, (long)var0);
         return var1;
      }
   }
}
