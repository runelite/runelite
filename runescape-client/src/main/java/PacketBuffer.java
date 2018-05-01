import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("h")
   static final int[] field2607;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -907150051
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2607 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1064585767"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(Lgo;I)V",
      garbageValue = "-2120400909"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-67"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2049682658"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2059426963"
   )
   public boolean method3854() {
      int var1 = super.payload[super.offset] - this.cipher.method3897() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1778179822"
   )
   public int method3860() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "111"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "29"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2607[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2607[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2607[var1];
      }

      return var4;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "16724"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "12681612"
   )
   static final void method3894(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class22.method169(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1135 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Liz;IIB)V",
      garbageValue = "58"
   )
   static final void method3863(Widget var0, int var1, int var2) {
      if(Client.draggedWidget == null && !Client.isMenuOpen) {
         if(var0 != null && WorldMapType2.method580(var0) != null) {
            Client.draggedWidget = var0;
            Client.field1024 = WorldMapType2.method580(var0);
            Client.field1025 = var1;
            Client.field892 = var2;
            class23.field352 = 0;
            Client.draggingWidget = false;
            int var3 = class57.method878();
            if(var3 != -1) {
               class86.method1965(var3);
            }

         }
      }
   }
}
