import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class214 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field2618;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field2615;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field2619;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -747367745
   )
   public static int field2617;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field2614;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1418623185
   )
   static int field2616;

   static {
      field2617 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method4129() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3324 == 0) {
            class219.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            class219.IndexStoreActionHandler_thread.setDaemon(true);
            class219.IndexStoreActionHandler_thread.start();
            class219.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.field3324 = 600;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-473539797"
   )
   static int method4131(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class94.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.size();
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(Lby;ZB)V",
      garbageValue = "109"
   )
   static void method4127(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field822 << 14;
         var0.isLowDetail = false;
         if((Client.lowMemory && class92.playerIndexesCount > 50 || class92.playerIndexesCount > 200) && var1 && var0.idlePoseAnimation == var0.poseAnimation) {
            var0.isLowDetail = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field813 = MessageNode.getTileHeight(var0.x, var0.y, class60.plane);
               TotalQuantityComparator.region.method3010(class60.plane, var0.x, var0.y, var0.field813, 60, var0, var0.angle, var2, var0.field820, var0.field821, var0.field815, var0.field812);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field1027[var3][var4] == Client.field928) {
                     return;
                  }

                  Client.field1027[var3][var4] = Client.field928;
               }

               var0.field813 = MessageNode.getTileHeight(var0.x, var0.y, class60.plane);
               TotalQuantityComparator.region.method2915(class60.plane, var0.x, var0.y, var0.field813, 60, var0, var0.angle, var2, var0.field1117);
            }
         }
      }

   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "2074153896"
   )
   static final void method4128(int var0, int var1, int var2, int var3, int var4) {
      class34.scrollbarSprites[0].method5653(var0, var1);
      class34.scrollbarSprites[1].method5653(var0, var3 + var1 - 16);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field901);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field905);
      Rasterizer2D.method5575(var0, var6 + var1 + 16, var5, Client.field904);
      Rasterizer2D.method5575(var0 + 1, var6 + var1 + 16, var5, Client.field904);
      Rasterizer2D.method5573(var0, var6 + var1 + 16, 16, Client.field904);
      Rasterizer2D.method5573(var0, var6 + var1 + 17, 16, Client.field904);
      Rasterizer2D.method5575(var0 + 15, var6 + var1 + 16, var5, Client.field931);
      Rasterizer2D.method5575(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field931);
      Rasterizer2D.method5573(var0, var6 + var5 + var1 + 15, 16, Client.field931);
      Rasterizer2D.method5573(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field931);
   }

   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "2071957546"
   )
   static void method4122(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class235.field2949; ++var4) {
         ItemComposition var5 = ItemContainer.getItemDefinition(var4);
         if((!var1 || var5.isTradable) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               OwnWorldComparator.field836 = -1;
               class27.field382 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class27.field382 = var2;
      class157.field2152 = 0;
      OwnWorldComparator.field836 = var3;
      String[] var8 = new String[OwnWorldComparator.field836];

      for(int var9 = 0; var9 < OwnWorldComparator.field836; ++var9) {
         var8[var9] = ItemContainer.getItemDefinition(var2[var9]).name;
      }

      class153.method3200(var8, class27.field382);
   }
}
