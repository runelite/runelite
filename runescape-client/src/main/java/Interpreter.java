import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("Interpreter")
public class Interpreter {
   @ObfuscatedName("w")
   @Export("Interpreter_stringLocals")
   static String[] Interpreter_stringLocals;
   @ObfuscatedName("o")
   @Export("Interpreter_arrayLengths")
   static int[] Interpreter_arrayLengths;
   @ObfuscatedName("u")
   @Export("Interpreter_arrays")
   static int[][] Interpreter_arrays;
   @ObfuscatedName("g")
   @Export("Interpreter_intStack")
   static int[] Interpreter_intStack;
   @ObfuscatedName("e")
   @Export("Interpreter_stringStack")
   static String[] Interpreter_stringStack;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -114766123
   )
   @Export("Interpreter_stringStackSize")
   static int Interpreter_stringStackSize;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 545127349
   )
   @Export("Interpreter_frameDepth")
   static int Interpreter_frameDepth;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lbn;"
   )
   @Export("Interpreter_frames")
   static ScriptFrame[] Interpreter_frames;
   @ObfuscatedName("a")
   @Export("Interpreter_calendar")
   static Calendar Interpreter_calendar;
   @ObfuscatedName("z")
   static final String[] field422;
   @ObfuscatedName("s")
   static boolean field423;
   @ObfuscatedName("t")
   static boolean field424;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1019558835
   )
   static int field425;
   @ObfuscatedName("r")
   static final double field426;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgs;Lhn;I)Lgg;",
      garbageValue = "-370104720"
   )
   public static PacketBufferNode method1915(ClientPacket var0, IsaacCipher var1) {
      PacketBufferNode var2;
      if (PacketBufferNode.field668 == 0) {
         var2 = new PacketBufferNode();
      } else {
         var2 = PacketBufferNode.packetBufferNodes[--PacketBufferNode.field668];
      }

      var2.field669 = var0;
      var2.field670 = var0.length;
      if (var2.field670 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if (var2.field670 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if (var2.field670 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if (var2.field670 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.writeByteIsaac(var2.field669.id);
      var2.field671 = 0;
      return var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljw;",
      garbageValue = "-1888252818"
   )
   @Export("getEnum")
   public static EnumDefinition getEnum(int var0) {
      EnumDefinition var1 = (EnumDefinition)EnumDefinition.EnumDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = EnumDefinition.EnumDefinition_indexCache.takeRecord(8, var0);
         var1 = new EnumDefinition();
         if (var2 != null) {
            var1.read(new Buffer(var2));
         }

         EnumDefinition.EnumDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "76"
   )
   @Export("changeWorldSelectSorting")
   static void changeWorldSelectSorting(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for (int var5 = 0; var5 < 4; ++var5) {
         if (World.sortOption1[var5] != var0) {
            var2[var4] = World.sortOption1[var5];
            var3[var4] = World.sortOption2[var5];
            ++var4;
         }
      }

      World.sortOption1 = var2;
      World.sortOption2 = var3;
      MilliClock.method3400(ItemContainer.worlds, 0, ItemContainer.worlds.length - 1, World.sortOption1, World.sortOption2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "80"
   )
   public static void method1976() {
      try {
         File var0 = new File(WorldMapSection1.userHomeDirectory, "random.dat");
         int var1;
         if (var0.exists()) {
            class168.randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
         } else {
            label34:
            for (int var2 = 0; var2 < Canvas.field94.length; ++var2) {
               for (var1 = 0; var1 < WorldMapSection2.cacheDirectoryLocations.length; ++var1) {
                  File var3 = new File(WorldMapSection2.cacheDirectoryLocations[var1] + Canvas.field94[var2] + File.separatorChar + "random.dat");
                  if (var3.exists()) {
                     class168.randomDat = new BufferedFile(new AccessFile(var3, "rw", 25L), 24, 0);
                     break label34;
                  }
               }
            }
         }

         if (class168.randomDat == null) {
            RandomAccessFile var5 = new RandomAccessFile(var0, "rw");
            var1 = var5.read();
            var5.seek(0L);
            var5.write(var1);
            var5.seek(0L);
            var5.close();
            class168.randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var4) {
      }

   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-10"
   )
   @Export("drawWidgets")
   static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (GroundItemPile.loadWidgetGroup(var0)) {
         class279.field1145 = null;
         DevicePcmPlayerProvider.drawWidgetGroup(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if (class279.field1145 != null) {
            DevicePcmPlayerProvider.drawWidgetGroup(class279.field1145, -1412584499, var1, var2, var3, var4, class54.field1161, class157.field1114, var7);
            class279.field1145 = null;
         }
      } else if (var7 != -1) {
         Client.field100[var7] = true;
      } else {
         for (int var8 = 0; var8 < 100; ++var8) {
            Client.field100[var8] = true;
         }
      }

   }

   static {
      Interpreter_arrayLengths = new int[5];
      Interpreter_arrays = new int[5][5000];
      Interpreter_intStack = new int[1000];
      Interpreter_stringStack = new String[1000];
      Interpreter_frameDepth = 0;
      Interpreter_frames = new ScriptFrame[50];
      Interpreter_calendar = Calendar.getInstance();
      field422 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field423 = false;
      field424 = false;
      field425 = 0;
      field426 = Math.log(2.0D);
   }
}
