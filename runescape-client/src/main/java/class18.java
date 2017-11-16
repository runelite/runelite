import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class18 implements Comparator {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field294;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lj;Lj;B)I",
      garbageValue = "14"
   )
   int method132(class14 var1, class14 var2) {
      return var1.method83().compareTo(var2.method83());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method132((class14)var1, (class14)var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1074875870"
   )
   public static int method131(int var0) {
      Varbit var1 = KeyFocusListener.method715(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class218.field2680[var4 - var3];
      return class218.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfi;Lgi;I)Lfc;",
      garbageValue = "-2139945108"
   )
   public static PacketNode method133(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2 = Varcs.method1804();
      var2.clientPacket = var0;
      var2.field2416 = var0.packetLength;
      if(var2.field2416 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2416 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2416 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2416 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.method3451(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2423 = 0;
      return var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "-1549166483"
   )
   static void method130(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class156.field2154, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "1613144663"
   )
   static boolean method134(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-104"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class61.tileHeights[var5][var3][var4] + var6 * class61.tileHeights[var5][var3 + 1][var4] >> 7;
         int var9 = class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) + class61.tileHeights[var5][var3 + 1][var4 + 1] * var6 >> 7;
         return var8 * (128 - var7) + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }
}
