import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("b")
   Frame[] field1563;
   @ObfuscatedName("s")
   static String field1567;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2134027895"
   )
   public boolean method1954(int var1) {
      return this.field1563[var1].field1308;
   }

   Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3398(var3);
      this.field1563 = new Frame[var6];
      int[] var7 = var1.method3357(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2472(); null != var12; var12 = (FrameMap)var5.method2479()) {
            if(var12.field1460 == var11) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3354(0, var11);
            } else {
               var13 = var2.method3354(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method2468(var10);
         }

         this.field1563[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1186916310"
   )
   static final void method1959(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field389 == -1) {
            Client.field389 = var0.textureId;
            Client.field299 = var0.field2232;
         }

         if(Client.field562.isFemale) {
            var0.textureId = Client.field389;
         } else {
            var0.textureId = Client.field299;
         }

      } else if(var1 == 325) {
         if(Client.field389 == -1) {
            Client.field389 = var0.textureId;
            Client.field299 = var0.field2232;
         }

         if(Client.field562.isFemale) {
            var0.textureId = Client.field299;
         } else {
            var0.textureId = Client.field389;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1424294402"
   )
   static void method1960(Widget var0) {
      if(Client.field489 == var0.field2328) {
         Client.field490[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1742192756"
   )
   static void method1961() {
      class10.field109 = 99;
      class10.underlayIds = new byte[4][104][104];
      class10.overlayIds = new byte[4][104][104];
      class10.overlayPaths = new byte[4][104][104];
      class10.overlayRotations = new byte[4][104][104];
      class149.field2027 = new int[4][105][105];
      Item.field884 = new byte[4][105][105];
      class183.field2729 = new int[105][105];
      class85.field1444 = new int[104];
      class142.field1996 = new int[104];
      class47.field928 = new int[104];
      class10.field95 = new int[104];
      class16.field175 = new int[104];
   }
}
