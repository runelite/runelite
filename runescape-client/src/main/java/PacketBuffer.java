import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("x")
   @Export("PacketBuffer_masks")
   static final int[] PacketBuffer_masks;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 701739159
   )
   @Export("__hx_z")
   public static int __hx_z;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   @Export("isaacCipher0")
   IsaacCipher isaacCipher0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1048718919
   )
   @Export("bitIndex")
   int bitIndex;

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-763699765"
   )
   @Export("newIsaacCipher")
   public void newIsaacCipher(int[] var1) {
      this.isaacCipher0 = new IsaacCipher(var1);
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(Lhn;B)V",
      garbageValue = "0"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(IsaacCipher var1) {
      this.isaacCipher0 = var1;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "1405"
   )
   @Export("writeByteIsaac")
   public void writeByteIsaac(int var1) {
      super.array[++super.index - 1] = (byte)(var1 + this.isaacCipher0.__m_336());
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1990206702"
   )
   @Export("readByteIsaac")
   public int readByteIsaac() {
      return super.array[++super.index - 1] - this.isaacCipher0.__m_336() & 255;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "101"
   )
   @Export("__ig_334")
   public boolean __ig_334() {
      int var1 = super.array[super.index] - this.isaacCipher0.__f_337() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2087071250"
   )
   @Export("readSmartByteShortIsaac")
   public int readSmartByteShortIsaac() {
      int var1 = super.array[++super.index - 1] - this.isaacCipher0.__m_336() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.array[++super.index - 1] - this.isaacCipher0.__m_336() & 255);
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1168019189"
   )
   @Export("__jb_335")
   public void __jb_335(byte[] var1, int var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         var1[var4 + var2] = (byte)(super.array[++super.index - 1] - this.isaacCipher0.__m_336());
      }

   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1207949100"
   )
   @Export("importIndex")
   public void importIndex() {
      this.bitIndex = super.index * 8;
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1710439720"
   )
   @Export("readBits")
   public int readBits(int var1) {
      int var2 = this.bitIndex >> 3;
      int var3 = 8 - (this.bitIndex & 7);
      int var4 = 0;

      for(this.bitIndex += var1; var1 > var3; var3 = 8) {
         var4 += (super.array[var2++] & PacketBuffer_masks[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.array[var2] & PacketBuffer_masks[var3];
      } else {
         var4 += super.array[var2] >> var3 - var1 & PacketBuffer_masks[var1];
      }

      return var4;
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1466909963"
   )
   @Export("exportIndex")
   public void exportIndex() {
      super.index = (this.bitIndex + 7) / 8;
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-141269845"
   )
   @Export("bitsRemaining")
   public int bitsRemaining(int var1) {
      return var1 * 8 - this.bitIndex;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1249956146"
   )
   static boolean method4062(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lit;IIIBZI)V",
      garbageValue = "-1562700981"
   )
   @Export("requestNetFile")
   static void requestNetFile(IndexCache var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      NetFileRequest var8 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.get(var6);
      if(var8 == null) {
         var8 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var6);
         if(var8 == null) {
            var8 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.removeDual();
                  NetCache.NetCache_pendingPriorityWrites.put(var8, var6);
                  --NetCache.NetCache_pendingWritesCount;
                  ++NetCache.NetCache_pendingPriorityWritesCount;
               }
            } else {
               if(!var5) {
                  var8 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new NetFileRequest();
               var8.indexCache = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  NetCache.NetCache_pendingPriorityWrites.put(var8, var6);
                  ++NetCache.NetCache_pendingPriorityWritesCount;
               } else {
                  NetCache.NetCache_pendingWritesQueue.addFirst(var8);
                  NetCache.NetCache_pendingWrites.put(var8, var6);
                  ++NetCache.NetCache_pendingWritesCount;
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "587268539"
   )
   public static int method4081(int var0, int var1) {
      return (var0 + 40000 << 8) + var1;
   }

   static {
      PacketBuffer_masks = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }
}
