import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("i")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("k")
   @Export("userHome")
   public static String userHome;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 352790753
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -696934221
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -731724627
   )
   @Export("z")
   int z;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILff;Lic;B)V",
      garbageValue = "82"
   )
   static void method3082(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.type = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var3);
      }

      class158.method3313();
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(Lbs;I)V",
      garbageValue = "674148170"
   )
   static final void method3083(Actor var0) {
      if(var0.field929 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < 32768) {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var1 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field910) {
               var0.interacting = -1;
               var0.field910 = false;
            }
         }

         if(var0.field897 != -1 && (var0.queueSize == 0 || var0.field936 > 0)) {
            var0.orientation = var0.field897;
            var0.field897 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field910) {
            var0.interacting = -1;
            var0.field910 = false;
         }

         if(var4 != 0) {
            ++var0.field930;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field929;
               var6 = true;
               if(var4 < var0.field929 || var4 > 2048 - var0.field929) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field930 > 25 || var6)) {
                  if(var0.field892 != -1) {
                     var0.poseAnimation = var0.field892;
                  } else {
                     var0.poseAnimation = var0.field890;
                  }
               }
            } else {
               var0.angle += var0.field929;
               var6 = true;
               if(var4 < var0.field929 || var4 > 2048 - var0.field929) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field930 > 25 || var6)) {
                  if(var0.field889 != -1) {
                     var0.poseAnimation = var0.field889;
                  } else {
                     var0.poseAnimation = var0.field890;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field930 = 0;
         }

      }
   }
}
