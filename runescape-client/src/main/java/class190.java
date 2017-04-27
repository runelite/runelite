import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class190 extends CacheableNode {
   @ObfuscatedName("d")
   public static IndexDataBase field2789;
   @ObfuscatedName("n")
   public boolean field2790 = false;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -66975277
   )
   public static int field2791;
   @ObfuscatedName("i")
   public static String[] field2792;
   @ObfuscatedName("c")
   static NodeCache field2793 = new NodeCache(64);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1577366715"
   )
   void method3454(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3455(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1474303550"
   )
   void method3455(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2790 = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LSpotanim;",
      garbageValue = "498613612"
   )
   public static Spotanim method3462(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field2801.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field2799.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field2816 = var0;
         if(var2 != null) {
            var1.method3475(new Buffer(var2));
         }

         Spotanim.field2801.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1434608085"
   )
   static final void method3463(int var0, int var1, int var2, int var3) {
      if(Client.field393 == 1) {
         PlayerComposition.field2181[Client.field333 / 100].method4230(Client.field550 - 8, Client.field391 - 8);
      }

      if(Client.field393 == 2) {
         PlayerComposition.field2181[Client.field333 / 100 + 4].method4230(Client.field550 - 8, Client.field391 - 8);
      }

      Client.field402 = 0;
      int var4 = (class22.localPlayer.x >> 7) + class108.baseX;
      int var5 = (class22.localPlayer.y >> 7) + GameEngine.baseY;
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.field402 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.field402 = 1;
      }

      if(Client.field402 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.field402 = 0;
      }

   }
}
