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
   @Export("__bv_z")
   static final String[] __bv_z;
   @ObfuscatedName("s")
   @Export("__bv_s")
   static boolean __bv_s;
   @ObfuscatedName("t")
   @Export("__bv_t")
   static boolean __bv_t;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1019558835
   )
   @Export("__bv_y")
   static int __bv_y;
   @ObfuscatedName("r")
   @Export("__bv_r")
   static final double __bv_r;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgs;Lhn;I)Lgg;",
      garbageValue = "-370104720"
   )
   public static PacketBufferNode method1915(ClientPacket var0, IsaacCipher var1) {
      PacketBufferNode var2;
      if(PacketBufferNode.__gg_u == 0) {
         var2 = new PacketBufferNode();
      } else {
         var2 = PacketBufferNode.packetBufferNodes[--PacketBufferNode.__gg_u];
      }

      var2.__m = var0;
      var2.__f = var0.length;
      if(var2.__f == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.__f == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.__f <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.__f <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.writeByteIsaac(var2.__m.id);
      var2.__w = 0;
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
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = EnumDefinition.EnumDefinition_indexCache.takeRecord(8, var0);
         var1 = new EnumDefinition();
         if(var2 != null) {
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
   static void method1975(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.__bt_e[var5] != var0) {
            var2[var4] = World.__bt_e[var5];
            var3[var4] = World.__bt_l[var5];
            ++var4;
         }
      }

      World.__bt_e = var2;
      World.__bt_l = var3;
      MilliClock.method3400(ItemContainer.worlds, 0, ItemContainer.worlds.length - 1, World.__bt_e, World.__bt_l);
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
         if(var0.exists()) {
            class168.randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
         } else {
            label34:
            for(int var2 = 0; var2 < Canvas.__ao_s.length; ++var2) {
               for(var1 = 0; var1 < WorldMapSection2.cacheDirectoryLocations.length; ++var1) {
                  File var3 = new File(WorldMapSection2.cacheDirectoryLocations[var1] + Canvas.__ao_s[var2] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class168.randomDat = new BufferedFile(new AccessFile(var3, "rw", 25L), 24, 0);
                     break label34;
                  }
               }
            }
         }

         if(class168.randomDat == null) {
            RandomAccessFile var5 = new RandomAccessFile(var0, "rw");
            var1 = var5.read();
            var5.seek(0L);
            var5.write(var1);
            var5.seek(0L);
            var5.close();
            class168.randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var4) {
         ;
      }

   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-10"
   )
   @Export("drawWidgets")
   static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(GroundItemPile.loadWidgetGroup(var0)) {
         class279.__jx_ne = null;
         DevicePcmPlayerProvider.drawWidgetGroup(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class279.__jx_ne != null) {
            DevicePcmPlayerProvider.drawWidgetGroup(class279.__jx_ne, -1412584499, var1, var2, var3, var4, class54.__bs_nb, class157.__fw_nm, var7);
            class279.__jx_ne = null;
         }
      } else if(var7 != -1) {
         Client.__client_od[var7] = true;
      } else {
         for(int var8 = 0; var8 < 100; ++var8) {
            Client.__client_od[var8] = true;
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
      __bv_z = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      __bv_s = false;
      __bv_t = false;
      __bv_y = 0;
      __bv_r = Math.log(2.0D);
   }
}
