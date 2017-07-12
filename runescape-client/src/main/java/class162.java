import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class162 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -508984053
   )
   static int field2313;
   @ObfuscatedName("a")
   static int[][] field2315;
   @ObfuscatedName("t")
   static int[][] field2316;
   @ObfuscatedName("y")
   static int[] field2318;
   @ObfuscatedName("j")
   static int[] field2319;

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Ljava/lang/String;",
      garbageValue = "1378581632"
   )
   static String method3041(Widget var0) {
      int var1 = WorldMapType3.getWidgetConfig(var0);
      int var2 = var1 >> 11 & 63;
      return var2 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }

   @ObfuscatedName("w")
   static final void method3046(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1665981140"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 >= 0 && (IndexDataBase.field3237 == 0 || var3 <= IndexDataBase.field3237)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.readBytes(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.readInt();
            if(var4 < 0 || IndexDataBase.field3237 != 0 && var4 > IndexDataBase.field3237) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  BZipDecompressor.method3078(var5, var4, var0, var3, 9);
               } else {
                  IndexDataBase.gzip.decompress(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   static {
      field2315 = new int[128][128];
      field2316 = new int[128][128];
      field2318 = new int[4096];
      field2319 = new int[4096];
   }
}
