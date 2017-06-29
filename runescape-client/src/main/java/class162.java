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
      int var2 = WorldMapType3.method199(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }

   static {
      field2315 = new int[128][128];
      field2316 = new int[128][128];
      field2318 = new int[4096];
      field2319 = new int[4096];
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
   static final byte[] method3047(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3237 != 0 && var3 > IndexDataBase.field3237) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3237 == 0 || var6 <= IndexDataBase.field3237)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class167.method3078(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.field3233.method3072(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }
}
