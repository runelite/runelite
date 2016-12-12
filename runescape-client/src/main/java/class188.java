import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class188 extends CacheableNode {
   @ObfuscatedName("i")
   public static class182 field2781;
   @ObfuscatedName("e")
   public static NodeCache field2782 = new NodeCache(64);
   @ObfuscatedName("f")
   public boolean field2784 = false;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "90"
   )
   public void method3384(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3387(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-2"
   )
   void method3387(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2784 = true;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1227404093"
   )
   static void method3391() {
      class10.field102 = 99;
      NPC.field763 = new byte[4][104][104];
      class11.field117 = new byte[4][104][104];
      class10.field91 = new byte[4][104][104];
      class65.field1110 = new byte[4][104][104];
      class10.field97 = new int[4][105][105];
      class10.field92 = new byte[4][105][105];
      class7.field65 = new int[105][105];
      class211.field3116 = new int[104];
      WallObject.field1552 = new int[104];
      CombatInfo1.field662 = new int[104];
      class211.field3118 = new int[104];
      ItemLayer.field1222 = new int[104];
   }
}
