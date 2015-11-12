package net.runelite.cache.io;

import net.runelite.cache.io.Stream;
import java.math.BigInteger;

public final class OutputStream extends Stream {
   private static final int[] BIT_MASK = new int[32];
   private int opcodeStart = 0;

   static {
      for(int i = 0; i < 32; ++i) {
         BIT_MASK[i] = (1 << i) - 1;
      }

   }

   public OutputStream(int capacity) {
      this.setBuffer(new byte[capacity]);
   }

   public OutputStream() {
      this.setBuffer(new byte[16]);
   }

   public OutputStream(byte[] buffer) {
      this.setBuffer(buffer);
      this.offset = buffer.length;
      this.length = buffer.length;
   }

   public OutputStream(int[] buffer) {
      this.setBuffer(new byte[buffer.length]);
      int[] var5 = buffer;
      int var4 = buffer.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         int value = var5[var3];
         this.writeByte(value);
      }

   }

   public void checkCapacityPosition(int position) {
      if(position >= this.getBuffer().length) {
         byte[] newBuffer = new byte[position + 16];
         System.arraycopy(this.getBuffer(), 0, newBuffer, 0, this.getBuffer().length);
         this.setBuffer(newBuffer);
      }

   }

   public void skip(int length) {
      this.setOffset(this.getOffset() + length);
   }

   public void setOffset(int offset) {
      this.offset = offset;
   }

   public void writeBytes(byte[] b, int offset, int length) {
      this.checkCapacityPosition(this.getOffset() + length - offset);
      System.arraycopy(b, offset, this.getBuffer(), this.getOffset(), length);
      this.setOffset(this.getOffset() + (length - offset));
   }

   public void writeBytes(byte[] b) {
      byte offset = 0;
      int length = b.length;
      this.checkCapacityPosition(this.getOffset() + length - offset);
      System.arraycopy(b, offset, this.getBuffer(), this.getOffset(), length);
      this.setOffset(this.getOffset() + (length - offset));
   }

   public void addBytes128(byte[] data, int offset, int len) {
      for(int k = offset; k < len; ++k) {
         this.writeByte((byte)(data[k] + 128));
      }

   }

   public void addBytesS(byte[] data, int offset, int len) {
      for(int k = offset; k < len; ++k) {
         this.writeByte((byte)(-128 + data[k]));
      }

   }

   public void addBytes_Reverse(byte[] data, int offset, int len) {
      for(int i = len - 1; i >= 0; --i) {
         this.writeByte(data[i]);
      }

   }

   public void addBytes_Reverse128(byte[] data, int offset, int len) {
      for(int i = len - 1; i >= 0; --i) {
         this.writeByte((byte)(data[i] + 128));
      }

   }

   public void writeByte(int i) {
      this.writeByte(i, this.offset++);
   }

   public void writeNegativeByte(int i) {
      this.writeByte(-i, this.offset++);
   }

   public void writeByte(int i, int position) {
      this.checkCapacityPosition(position);
      this.getBuffer()[position] = (byte)i;
   }

   public void writeByte128(int i) {
      this.writeByte(i + 128);
   }

   public void writeByteC(int i) {
      this.writeByte(-i);
   }

   public void write3Byte(int i) {
      this.writeByte(i >> 16);
      this.writeByte(i >> 8);
      this.writeByte(i);
   }

   public void write128Byte(int i) {
      this.writeByte(128 - i);
   }

   public void writeShortLE128(int i) {
      this.writeByte(i + 128);
      this.writeByte(i >> 8);
   }

   public void writeShort128(int i) {
      this.writeByte(i >> 8);
      this.writeByte(i + 128);
   }

   public void writeBigSmart(int value) {
      if(value >= 65536) {
         this.writeByte(-1);
         this.writeInt(Integer.MAX_VALUE & value);
      } else {
         this.writeShort(value);
      }
   }

   public void writeSmart(int i) {
      if(i >= 128) {
         this.writeShort(i + '\u8000');
      } else {
         this.writeByte(i);
      }

   }

   public void writeShort(int i) {
      this.writeByte(i >> 8);
      this.writeByte(i);
   }

   public void writeShortLE(int i) {
      this.writeByte(i);
      this.writeByte(i >> 8);
   }

   public void write24BitInt(int i) {
      this.writeByte(i >> 16);
      this.writeByte(i >> 8);
      this.writeByte(i);
   }

   public void writeInt(int i) {
      this.writeByte(i >> 24);
      this.writeByte(i >> 16);
      this.writeByte(i >> 8);
      this.writeByte(i);
   }

   public void writeIntV1(int i) {
      this.writeByte(i >> 8);
      this.writeByte(i);
      this.writeByte(i >> 24);
      this.writeByte(i >> 16);
   }

   public void writeIntV2(int i) {
      this.writeByte(i >> 16);
      this.writeByte(i >> 24);
      this.writeByte(i);
      this.writeByte(i >> 8);
   }

   public void writeIntLE(int i) {
      this.writeByte(i);
      this.writeByte(i >> 8);
      this.writeByte(i >> 16);
      this.writeByte(i >> 24);
   }

   public void writeLong(long l) {
      this.writeByte((int)(l >> 56));
      this.writeByte((int)(l >> 48));
      this.writeByte((int)(l >> 40));
      this.writeByte((int)(l >> 32));
      this.writeByte((int)(l >> 24));
      this.writeByte((int)(l >> 16));
      this.writeByte((int)(l >> 8));
      this.writeByte((int)l);
   }

   public void writePSmarts(int i) {
      if(i < 128) {
         this.writeByte(i);
      } else if(i < '\u8000') {
         this.writeShort('\u8000' + i);
      } else {
         System.out.println("Error psmarts out of range:");
      }
   }

   public void writeString(String s) {
      this.checkCapacityPosition(this.getOffset() + s.length() + 1);
      System.arraycopy(s.getBytes(), 0, this.getBuffer(), this.getOffset(), s.length());
      this.setOffset(this.getOffset() + s.length());
      this.writeByte(0);
   }

   public void writeGJString(String s) {
      this.writeByte(0);
      this.writeString(s);
   }

   public void putGJString3(String s) {
      this.writeByte(0);
      this.writeString(s);
      this.writeByte(0);
   }

   public void writePacket(int id) {
      this.writeByte(id);
   }

   public void writePacketVarByte(int id) {
      this.writePacket(id);
      this.writeByte(0);
      this.opcodeStart = this.getOffset() - 1;
   }

   public void writePacketVarShort(int id) {
      this.writePacket(id);
      this.writeShort(0);
      this.opcodeStart = this.getOffset() - 2;
   }

   public void endPacketVarByte() {
      this.writeByte(this.getOffset() - (this.opcodeStart + 2) + 1, this.opcodeStart);
   }

   public void endPacketVarShort() {
      int size = this.getOffset() - (this.opcodeStart + 2);
      this.writeByte(size >> 8, this.opcodeStart++);
      this.writeByte(size, this.opcodeStart);
   }

   public void initBitAccess() {
      this.bitPosition = this.getOffset() * 8;
   }

   public void finishBitAccess() {
      this.setOffset((this.bitPosition + 7) / 8);
   }

   public int getBitPos(int i) {
      return 8 * i - this.bitPosition;
   }

   public void writeBits(int numBits, int value) {
      int bytePos = this.bitPosition >> 3;
      int bitOffset = 8 - (this.bitPosition & 7);

      byte[] var10000;
      for(this.bitPosition += numBits; numBits > bitOffset; bitOffset = 8) {
         this.checkCapacityPosition(bytePos);
         var10000 = this.getBuffer();
         var10000[bytePos] = (byte)(var10000[bytePos] & ~BIT_MASK[bitOffset]);
         var10000 = this.getBuffer();
         int var10001 = bytePos++;
         var10000[var10001] = (byte)(var10000[var10001] | value >> numBits - bitOffset & BIT_MASK[bitOffset]);
         numBits -= bitOffset;
      }

      this.checkCapacityPosition(bytePos);
      if(numBits == bitOffset) {
         var10000 = this.getBuffer();
         var10000[bytePos] = (byte)(var10000[bytePos] & ~BIT_MASK[bitOffset]);
         var10000 = this.getBuffer();
         var10000[bytePos] = (byte)(var10000[bytePos] | value & BIT_MASK[bitOffset]);
      } else {
         var10000 = this.getBuffer();
         var10000[bytePos] = (byte)(var10000[bytePos] & ~(BIT_MASK[numBits] << bitOffset - numBits));
         var10000 = this.getBuffer();
         var10000[bytePos] = (byte)(var10000[bytePos] | (value & BIT_MASK[numBits]) << bitOffset - numBits);
      }

   }

   public void setBuffer(byte[] buffer) {
      this.buffer = buffer;
   }

   public final void rsaEncode(BigInteger key, BigInteger modulus) {
      int length = this.offset;
      this.offset = 0;
      byte[] data = new byte[length];
      this.getBytes(data, 0, length);
      BigInteger biginteger2 = new BigInteger(data);
      BigInteger biginteger3 = biginteger2.modPow(key, modulus);
      byte[] out = biginteger3.toByteArray();
      this.offset = 0;
      this.writeBytes(out, 0, out.length);
   }
}
