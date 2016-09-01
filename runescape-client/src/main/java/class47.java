import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class47 extends CacheableNode {
   @ObfuscatedName("x")
   static class170 field1046;
   @ObfuscatedName("j")
   public boolean field1047 = false;
   @ObfuscatedName("r")
   static NodeCache field1048 = new NodeCache(64);
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -375621455
   )
   protected static int field1050;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "407403932"
   )
   public static class51 method952(int var0) {
      class51 var1 = (class51)class51.field1097.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class51.field1110.method3290(32, var0);
         var1 = new class51();
         if(null != var2) {
            var1.method1029(new Buffer(var2));
         }

         class51.field1097.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1715660044"
   )
   void method953(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method954(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1506264636"
   )
   void method954(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1047 = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IZZZB)Lclass171;",
      garbageValue = "51"
   )
   static class171 method969(int var0, boolean var1, boolean var2, boolean var3) {
      class137 var4 = null;
      if(class152.field2288 != null) {
         var4 = new class137(var0, class152.field2288, class35.field790[var0], 1000000);
      }

      return new class171(var4, FaceNormal.field1501, var0, var1, var2, var3);
   }

   @ObfuscatedName("py")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1301755067"
   )
   protected static final void method970() {
      class138.field2133.vmethod3173();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field2248[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field2246[var0] = 0L;
      }

      class0.field13 = 0;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
   )
   static void method971() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class132.method2881(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[1 + var1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[1 + var1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
