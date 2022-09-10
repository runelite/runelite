/*
 * Copyright (c) 2020, Noodleeater <noodleeater4@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.api;

import java.math.BigInteger;

/**
 * Represents a byte buffer
 */
public interface Buffer extends Node
{
	byte[] getPayload();

	int getOffset();

	void setOffset(int offset);

	boolean checkCrc();

	void encryptRsa(BigInteger var1, BigInteger var2);

	int packBytesToInt();

	boolean readBoolean();

	byte readByte();

	byte readByteAdd();

	byte readByteNeg();

	byte readByteSub();

	void readBytes(byte[] var1, int var2, int var3);

	void readBytesLE(byte[] var1, int var2, int var3);

	String readCESU8();

	int readIncrSmallSmart();

	int readInt();

	int readLargeSmart();

	long readLong();

	int readMedium();

	int readNullableLargeSmart();

	int readShort();

	int readShortAdd();

	int readShortAddLE();

	int readShortLE();

	int readShortSmartSub();

	int readShortSmartSub64();

	String readStringCp1252NullCircumfixed();

	String readStringCp1252NullTerminated();

	String readStringCp1252NullTerminatedOrNull();

	int readUShortSmart();

	int readUnsignedByte();

	int readUnsignedByteAdd();

	int readUnsignedByteNeg();

	int readUnsignedByteSub();

	int readUnsignedIntIME();

	int readUnsignedIntLE();

	int readUnsignedIntME();

	int readUnsignedMediumLME();

	int readUnsignedMediumRME();

	int readUnsignedShort();

	int readUnsignedShortAdd();

	int readUnsignedShortAddLE();

	int readUnsignedShortLE();

	int readVarInt();

	void releaseArray();

	void writeBoolean(boolean var1);

	void writeBuffer(Buffer var1);

	void writeByte(int var1);

	void writeByteAdd(int var1);

	void writeByteNeg(int var1);

	void writeByteSub(int var1);

	void writeBytes(byte[] var1, int var2, int var3);

	void writeCESU8(CharSequence var1);

	int writeCrc(int var1);

	void writeInt(int var1);

	void writeIntIME(int var1);

	void writeIntLE(int var1);

	void writeIntME(int var1);

	void writeLengthByte(int var1);

	void writeLengthInt(int var1);

	void writeLengthShort(int var1);

	void writeLong(long var1);

	void writeLongMedium(long var1);

	void writeMedium(int var1);

	void writeShort(int var1);

	void writeShortAdd(int var1);

	void writeShortAddLE(int var1);

	void writeShortLE(int var1);

	void writeSmartByteShort(int var1);

	void writeStringCp1252NullCircumfixed(String var1);

	void writeStringCp1252NullTerminated(String var1);

	void writeVarInt(int var1);

	void xteaDecrypt(int[] var1, int var2, int var3);

	void xteaDecryptAll(int[] var1);

	void xteaEncrypt(int[] var1, int var2, int var3);
}
