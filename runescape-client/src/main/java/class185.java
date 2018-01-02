import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class185 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 972741227
   )
   static int field2521;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -263654099
   )
   static int field2519;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 572866317
   )
   static int field2520;
   @ObfuscatedName("k")
   static byte[][] field2524;
   @ObfuscatedName("u")
   static byte[][] field2522;
   @ObfuscatedName("z")
   static byte[][] field2523;
   @ObfuscatedName("f")
   static int[] field2518;

   static {
      field2521 = 0;
      field2519 = 0;
      field2520 = 0;
      field2524 = new byte[1000][];
      field2522 = new byte[250][];
      field2523 = new byte[50][];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILfv;Liu;B)V",
      garbageValue = "64"
   )
   static void method3513(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.type = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var3);
      }

      Object var9 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3328 == 0) {
            IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
            IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
            IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.field3328 = 600;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "-2101965736"
   )
   static synchronized byte[] method3505(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2521 > 0) {
         var2 = field2524[--field2521];
         field2524[field2521] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2519 > 0) {
         var2 = field2522[--field2519];
         field2522[field2519] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2520 > 0) {
         var2 = field2523[--field2520];
         field2523[field2520] = null;
         return var2;
      }

      if(class21.field324 != null) {
         for(int var4 = 0; var4 < CombatInfo1.field1189.length; ++var4) {
            if(CombatInfo1.field1189[var4] != var0) {
               if(var0 < CombatInfo1.field1189[var4]) {
                  ;
               }
            } else if(field2518[var4] > 0) {
               byte[] var3 = class21.field324[var4][--field2518[var4]];
               class21.field324[var4][field2518[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "119"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = BaseVarType.font_p12full.method4888(var0, 250);
      int var6 = BaseVarType.font_p12full.method4889(var0, 250) * 13;
      Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
      BaseVarType.font_p12full.method4895(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      WorldMapData.method305(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         ScriptState.rasterProvider.drawFull(0, 0);
      } else {
         SoundEffectWorker.method2084(var3, var4, var5, var6);
      }

   }
}
