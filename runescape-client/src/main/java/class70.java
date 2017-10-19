import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class70 implements Runnable {
   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("w")
   boolean field869;
   @ObfuscatedName("s")
   Object field867;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1758786911
   )
   int field871;
   @ObfuscatedName("o")
   int[] field873;
   @ObfuscatedName("g")
   int[] field870;

   class70() {
      this.field869 = true;
      this.field867 = new Object();
      this.field871 = 0;
      this.field873 = new int[500];
      this.field870 = new int[500];
   }

   public void run() {
      for(; this.field869; class94.method1823(50L)) {
         Object var1 = this.field867;
         synchronized(this.field867) {
            if(this.field871 < 500) {
               this.field873[this.field871] = MouseInput.field756;
               this.field870[this.field871] = MouseInput.field741;
               ++this.field871;
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-7203"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(Ignore.listFetcher == null) {
            Ignore.listFetcher = class60.field763.method2932(new URL(class204.field2525));
         } else if(Ignore.listFetcher.method2933()) {
            byte[] var0 = Ignore.listFetcher.method2935();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            class266.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = class266.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            Script.method1897(class266.worldList, 0, class266.worldList.length - 1, World.field1286, World.field1284);
            Ignore.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         Ignore.listFetcher = null;
      }

      return false;
   }
}
