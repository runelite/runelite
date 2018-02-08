import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class186 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 2617333612067583305L
   )
   @Export("currentTimeMsLast")
   static long currentTimeMsLast;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 5256051902074941339L
   )
   @Export("currentTimeMsOffset")
   static long currentTimeMsOffset;
   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexCache15")
   static IndexData indexCache15;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "333908877"
   )
   public static void method3766() {
      while(true) {
         Deque var1 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         FileSystem var0;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var0 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
         }

         if(var0 == null) {
            return;
         }

         var0.data.load(var0.index, (int)var0.hash, var0.field3291, false);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIZIZS)V",
      garbageValue = "29072"
   )
   static void method3764(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class31.worldList[var6];
         class31.worldList[var6] = class31.worldList[var1];
         class31.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = class31.worldList[var9];
            int var12 = class62.method1029(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class62.method1029(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = class31.worldList[var9];
               class31.worldList[var9] = class31.worldList[var7];
               class31.worldList[var7++] = var14;
            }
         }

         class31.worldList[var1] = class31.worldList[var7];
         class31.worldList[var7] = var8;
         method3764(var0, var7 - 1, var2, var3, var4, var5);
         method3764(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-561445796"
   )
   public static void method3768() {
      try {
         if(class214.field2617 == 1) {
            int var0 = class25.field356.method4227();
            if(var0 > 0 && class25.field356.method4221()) {
               var0 -= class214.field2616;
               if(var0 < 0) {
                  var0 = 0;
               }

               class25.field356.method4133(var0);
               return;
            }

            class25.field356.method4139();
            class25.field356.method4137();
            if(class214.field2614 != null) {
               class214.field2617 = 2;
            } else {
               class214.field2617 = 0;
            }

            class56.field637 = null;
            class168.field2232 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class25.field356.method4139();
         class214.field2617 = 0;
         class56.field637 = null;
         class168.field2232 = null;
         class214.field2614 = null;
      }

   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-32"
   )
   static final void method3767() {
      if(Enum.soundSystem1 != null) {
         Enum.soundSystem1.method2262();
      }

      if(BoundingBox.soundSystem0 != null) {
         BoundingBox.soundSystem0.method2262();
      }

   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "15827"
   )
   static final boolean method3765(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
