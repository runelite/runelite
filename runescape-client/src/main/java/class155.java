import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class155 implements class115 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1289513433
   )
   public final int field2302;
   @ObfuscatedName("f")
   static final class155 field2304 = new class155(2, 1, true, true, false);
   @ObfuscatedName("u")
   public final boolean field2305;
   @ObfuscatedName("v")
   static final class155 field2306 = new class155(4, 3, false, false, true);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1901021319
   )
   final int field2307;
   @ObfuscatedName("c")
   static final class155 field2308 = new class155(3, 2, false, false, true);
   @ObfuscatedName("y")
   public final boolean field2309;
   @ObfuscatedName("k")
   static final class155 field2310 = new class155(0, -1, true, false, true);
   @ObfuscatedName("q")
   static final class155 field2312 = new class155(1, 0, true, true, true);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-116"
   )
   public int vmethod3197() {
      return this.field2307;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class155(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2307 = var1;
      this.field2302 = var2;
      this.field2309 = var4;
      this.field2305 = var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lclass54;",
      garbageValue = "-1244023218"
   )
   public static class54 method3176(int var0) {
      class54 var1 = (class54)class54.field1162.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class54.field1165.method3305(5, var0);
         var1 = new class54();
         if(null != var2) {
            var1.method1102(new Buffer(var2));
         }

         class54.field1162.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZLclass227;I)V",
      garbageValue = "918956299"
   )
   public static void method3177(class170 var0, class170 var1, boolean var2, class227 var3) {
      ItemComposition.field1169 = var0;
      class117.field2027 = var1;
      ItemComposition.isMembersWorld = var2;
      ItemComposition.field1167 = ItemComposition.field1169.method3290(10);
      class11.field170 = var3;
   }
}
