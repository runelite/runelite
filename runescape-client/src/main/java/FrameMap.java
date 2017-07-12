import net.runelite.mapping.Export;
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
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 891823307
   )
   @Export("count")
   int count;
   @ObfuscatedName("t")
   @Export("list")
   int[][] list;
   @ObfuscatedName("a")
   @Export("types")
   int[] types;
   @ObfuscatedName("g")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("pq")
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;

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
      return ++MouseInput.mouseIdleTicks - 1;
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
         if(var0.length > 136 && !AbstractByteBuffer.field2420) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.field2420 = true;
            }
         }

         return var0;
      }
   }

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
}
