import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class47 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1339174803
   )
   public int field623;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   public Coordinates field621;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   public Coordinates field620;

   @ObfuscatedSignature(
      signature = "(ILhl;Lhl;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field623 = var1;
      this.field621 = var2;
      this.field620 = var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "16"
   )
   public static int method719(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;Ljava/lang/String;Ljava/lang/String;I)Lju;",
      garbageValue = "53741574"
   )
   public static Font method720(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      Font var6;
      if(!class249.method4517(var0, var4, var5)) {
         var6 = null;
      } else {
         byte[] var8 = var1.getConfigData(var4, var5);
         Font var7;
         if(var8 == null) {
            var7 = null;
         } else {
            Font var9 = new Font(var8, class287.field3807, World.offsetsY, class236.field3238, FileSystem.field3207, class181.field2456, class208.spritePixels);
            Actor.method1605();
            var7 = var9;
         }

         var6 = var7;
      }

      return var6;
   }

   @ObfuscatedName("k")
   static final void method717(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-239616181"
   )
   static final int method718() {
      return class132.field1984;
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1255910884"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class5.plane][var0][var1];
      if(var2 == null) {
         class8.region.method2842(class5.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class46.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class8.region.method2842(class5.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class8.region.addItemPile(class5.plane, var0, var1, CacheFile.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class5.plane), var5, var9, var11, var10);
         }
      }
   }
}
