import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   @Export("soundTaskDataProvider")
   public static class101 soundTaskDataProvider;
   @ObfuscatedName("ac")
   static int[] field789;
   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;
   @ObfuscatedName("g")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("e")
   @Export("lock")
   Object lock;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1909950351
   )
   @Export("index")
   int index;
   @ObfuscatedName("z")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("n")
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
      for(; this.isRunning; BoundingBox3DDrawMode.method59(50L)) {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgm;I)V",
      garbageValue = "323660414"
   )
   public static void method1165(Huffman var0) {
      class313.huffman = var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1609857676"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(Size.listFetcher == null) {
            Size.listFetcher = class2.urlRequester.request(new URL(MapIcon.field531));
         } else if(Size.listFetcher.isDone()) {
            byte[] var0 = Size.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            class171.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = class171.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            CombatInfo1.method1724(class171.worldList, 0, class171.worldList.length - 1, World.field1213, World.field1210);
            Size.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         Size.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lbx;Lbx;IZI)I",
      garbageValue = "1230830034"
   )
   static int method1164(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1761()?(var1.method1761()?0:1):(var1.method1761()?-1:0)):(var2 == 5?(var0.method1728()?(var1.method1728()?0:1):(var1.method1728()?-1:0)):(var2 == 6?(var0.method1729()?(var1.method1729()?0:1):(var1.method1729()?-1:0)):(var2 == 7?(var0.method1727()?(var1.method1727()?0:1):(var1.method1727()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1429580903"
   )
   static int method1160(int var0) {
      MessageNode var1 = (MessageNode)class95.messages.get((long)var0);
      return var1 == null?-1:(var1.next == class95.field1429.sentinel?-1:((MessageNode)var1.next).id);
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "78"
   )
   static final String method1166(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
