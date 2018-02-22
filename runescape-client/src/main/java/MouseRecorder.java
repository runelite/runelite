import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 1261568865
   )
   static int field759;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -580396479
   )
   static int field761;
   @ObfuscatedName("b")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("q")
   @Export("lock")
   Object lock;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1701316417
   )
   @Export("index")
   int index;
   @ObfuscatedName("p")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("a")
   @Export("ys")
   int[] ys;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
   }

   public void run() {
      for(; this.isRunning; class19.method152(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.mouseLastX;
               this.ys[this.index] = MouseInput.mouseLastY;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1355804425"
   )
   static synchronized byte[] method1146(int var0) {
      return class194.method3783(var0, false);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1515976135"
   )
   public static boolean method1140() {
      try {
         if(class223.field2646 == 2) {
            if(class46.field550 == null) {
               class46.field550 = Track1.getMusicFile(Huffman.field2471, class223.field2648, TextureProvider.field1658);
               if(class46.field550 == null) {
                  return false;
               }
            }

            if(Item.field1366 == null) {
               Item.field1366 = new class109(Item.field1362, GameCanvas.field601);
            }

            if(class155.field2105.method4136(class46.field550, class223.field2644, Item.field1366, 22050)) {
               class155.field2105.method4238();
               class155.field2105.method4134(class223.field2645);
               class155.field2105.method4210(class46.field550, class223.field2647);
               class223.field2646 = 0;
               class46.field550 = null;
               Item.field1366 = null;
               Huffman.field2471 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class155.field2105.method4140();
         class223.field2646 = 0;
         class46.field550 = null;
         Item.field1366 = null;
         Huffman.field2471 = null;
      }

      return false;
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(ZLgu;I)V",
      garbageValue = "1197029991"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0, PacketBuffer var1) {
      Client.isDynamicRegion = var0;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(!Client.isDynamicRegion) {
         int var2 = var1.readUnsignedShortOb1();
         var3 = var1.method3699();
         var4 = var1.readUnsignedShort();
         FriendManager.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               FriendManager.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         IndexData.mapRegions = new int[var4];
         class43.landMapFileIds = new int[var4];
         class40.landRegionFileIds = new int[var4];
         class157.field2120 = new byte[var4][];
         KeyFocusListener.field589 = new byte[var4][];
         boolean var16 = false;
         if((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
            var16 = true;
         }

         if(var3 / 8 == 48 && var2 / 8 == 148) {
            var16 = true;
         }

         var4 = 0;

         for(var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
            for(var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
               var8 = var7 + (var6 << 8);
               if(!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
                  IndexData.mapRegions[var4] = var8;
                  class43.landMapFileIds[var4] = Script.indexMaps.getFile("m" + var6 + "_" + var7);
                  class40.landRegionFileIds[var4] = Script.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         Varcs.method1967(var3, var2, true);
      } else {
         boolean var15 = var1.method3577() == 1;
         var3 = var1.method3699();
         var4 = var1.readUnsignedShortOb1();
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.instanceTemplateChunks[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.instanceTemplateChunks[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         FriendManager.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               FriendManager.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         IndexData.mapRegions = new int[var5];
         class43.landMapFileIds = new int[var5];
         class40.landRegionFileIds = new int[var5];
         class157.field2120 = new byte[var5][];
         KeyFocusListener.field589 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.instanceTemplateChunks[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(IndexData.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        IndexData.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        class43.landMapFileIds[var5] = Script.indexMaps.getFile("m" + var13 + "_" + var14);
                        class40.landRegionFileIds[var5] = Script.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         Varcs.method1967(var4, var3, !var15);
      }

   }
}
