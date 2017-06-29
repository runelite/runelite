import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 468508233
   )
   int field2057;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 891823307
   )
   int field2058;
   @ObfuscatedName("t")
   int[][] field2061;
   @ObfuscatedName("a")
   int[] field2062;
   @ObfuscatedName("g")
   static int[] field2064;
   @ObfuscatedName("pq")
   static class109 field2065;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1387470708"
   )
   public static boolean method2661(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1479443479"
   )
   public static int method2662() {
      return ++class59.mouseIdleTicks - 1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2045436958"
   )
   public static int method2663(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1870942696"
   )
   public static boolean method2664(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-336351817"
   )
   public static Object method2665(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class176.field2420) {
            try {
               class171 var2 = new class171();
               var2.vmethod3351(var0);
               return var2;
            } catch (Throwable var3) {
               class176.field2420 = true;
            }
         }

         return var0;
      }
   }

   FrameMap(int var1, byte[] var2) {
      this.field2057 = var1;
      Buffer var3 = new Buffer(var2);
      this.field2058 = var3.readUnsignedByte();
      this.field2062 = new int[this.field2058];
      this.field2061 = new int[this.field2058][];

      int var4;
      for(var4 = 0; var4 < this.field2058; ++var4) {
         this.field2062[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field2058; ++var4) {
         this.field2061[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field2058; ++var4) {
         for(int var5 = 0; var5 < this.field2061[var4].length; ++var5) {
            this.field2061[var4][var5] = var3.readUnsignedByte();
         }
      }

   }
}
