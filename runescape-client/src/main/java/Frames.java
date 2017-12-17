import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 711911861
   )
   public static int field2028;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -1202290627
   )
   static int field2030;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Leu;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Lib;Lib;IZ)V"
   )
   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.fileCount(var3);
      this.skeletons = new Frame[var6];
      int[] var7 = var1.getChilds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.getFront(); var12 != null; var12 = (FrameMap)var5.getNext()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.getChild(0, var11);
            } else {
               var13 = var2.getChild(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-67697236"
   )
   public boolean method2884(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;B)V",
      garbageValue = "88"
   )
   static void method2887(File var0, File var1) {
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
}
