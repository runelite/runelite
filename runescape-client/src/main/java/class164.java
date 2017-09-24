import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public abstract class class164 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 777660859
   )
   public int field2314;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 493223029
   )
   public int field2315;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1828749207
   )
   public int field2316;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1949920475
   )
   public int field2317;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILfh;I)Z",
      garbageValue = "-982142966"
   )
   protected abstract boolean vmethod3145(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "899838602"
   )
   static void method3149(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      FileRequest var4 = (FileRequest)class239.field3264.get(var2);
      if(var4 != null) {
         class239.field3258.setHead(var4);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1096599157"
   )
   public static void method3148(int var0) {
      if(class204.field2507 != 0) {
         class204.field2510 = var0;
      } else {
         class225.field2856.method3793(var0);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)Lcp;",
      garbageValue = "-14663"
   )
   static World method3150() {
      return World.field1301 < World.worldCount?World.worldList[++World.field1301 - 1]:null;
   }
}
