import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("aw")
   static int[] field1958;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -396894033
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 844183929
   )
   @Export("count")
   int count;
   @ObfuscatedName("y")
   @Export("types")
   int[] types;
   @ObfuscatedName("r")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "-2009876701"
   )
   static void method2742(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class157.jagexClDat, "rw", 10000L);
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lif;II)V",
      garbageValue = "423116450"
   )
   static void method2743(IndexData var0, int var1) {
      if(CombatInfoListHolder.NetCache_reference != null) {
         CombatInfoListHolder.NetCache_reference.offset = var1 * 8 + 5;
         int var2 = CombatInfoListHolder.NetCache_reference.readInt();
         int var3 = CombatInfoListHolder.NetCache_reference.readInt();
         var0.setInformation(var2, var3);
      } else {
         class56.requestNetFile((IndexData)null, 255, 255, 0, (byte)0, true);
         class249.NetCache_indexCaches[var1] = var0;
      }
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(IIIILkg;Lhw;B)V",
      garbageValue = "-61"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class221 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5292(var10 + var5.field2721 / 2 - var4.maxWidth / 2, var5.field2718 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2721, var5.field2718, var5.field2720, var5.field2719);
            } else {
               var4.drawAt(var0 + var10 + var5.field2721 / 2 - var4.maxWidth / 2, var5.field2718 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
