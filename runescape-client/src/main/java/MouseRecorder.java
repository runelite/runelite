import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("a")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("w")
   @Export("lock")
   Object lock;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 396566785
   )
   @Export("index")
   int index;
   @ObfuscatedName("k")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("u")
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
      for(; this.isRunning; World.method1500(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.field679;
               this.ys[this.index] = MouseInput.field682 * -469125321;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class192.listFetcher == null) {
            class192.listFetcher = DState.urlRequester.request(new URL(Client.field1107));
         } else if(class192.listFetcher.isDone()) {
            byte[] var0 = class192.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            ItemContainer.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = ItemContainer.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            FontName.method4874(ItemContainer.worldList, 0, ItemContainer.worldList.length - 1, World.field1203, World.field1197);
            class192.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class192.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-3645386"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = Ignore.getSmoothNoise2D(var3, var5);
      int var8 = Ignore.getSmoothNoise2D(var3 + 1, var5);
      int var9 = Ignore.getSmoothNoise2D(var3, var5 + 1);
      int var10 = Ignore.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var16 * var13 >> 16);
      return var15;
   }
}
