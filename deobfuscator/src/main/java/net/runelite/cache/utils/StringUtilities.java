/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.cache.utils;

import net.runelite.cache.io.InputStream;

/**
 * Created by Allen Kinzalow on 3/15/2015.
 *
 * These are methods from the OSRS Client.
 */
public class StringUtilities {

//    public static int method769(CharSequence sequence, int var1) {
//        int length = sequence.length();
//        int position = 0;
//
//        for(int charPosition = 0; charPosition < length; ++charPosition) {
//            position = (position << 5) - position + method671(sequence.charAt(charPosition));
//        }
//
//        return position;
//    }
//
//    public static byte method671(char var0) {
//        byte var2;
//        if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
//            if(8364 == var0) {
//                var2 = -128;
//            } else if(var0 == 8218) {
//                var2 = -126;
//            } else if(402 == var0) {
//                var2 = -125;
//            } else if(8222 == var0) {
//                var2 = -124;
//            } else if(var0 == 8230) {
//                var2 = -123;
//            } else if(8224 == var0) {
//                var2 = -122;
//            } else if(8225 == var0) {
//                var2 = -121;
//            } else if(710 == var0) {
//                var2 = -120;
//            } else if(8240 == var0) {
//                var2 = -119;
//            } else if(var0 == 352) {
//                var2 = -118;
//            } else if(8249 == var0) {
//                var2 = -117;
//            } else if(var0 == 338) {
//                var2 = -116;
//            } else if(381 == var0) {
//                var2 = -114;
//            } else if(var0 == 8216) {
//                var2 = -111;
//            } else if(var0 == 8217) {
//                var2 = -110;
//            } else if(8220 == var0) {
//                var2 = -109;
//            } else if(var0 == 8221) {
//                var2 = -108;
//            } else if(8226 == var0) {
//                var2 = -107;
//            } else if(8211 == var0) {
//                var2 = -106;
//            } else if(8212 == var0) {
//                var2 = -105;
//            } else if(732 == var0) {
//                var2 = -104;
//            } else if(8482 == var0) {
//                var2 = -103;
//            } else if(var0 == 353) {
//                var2 = -102;
//            } else if(8250 == var0) {
//                var2 = -101;
//            } else if(339 == var0) {
//                var2 = -100;
//            } else if(var0 == 382) {
//                var2 = -98;
//            } else if(376 == var0) {
//                var2 = -97;
//            } else {
//                var2 = 63;
//            }
//        } else {
//            var2 = (byte)var0;
//        }
//
//        return var2;
//    }

    public static String readString_2(InputStream stream) {
        int var2 = stream.getOffset();

        while(stream.readByte() != 0) {
            ;
        }

        int var3 = stream.getOffset() - var2 - 1;
        return var3 == 0? "" : getStringMethod(stream.getBuffer(), var2, var3);
    }

    public static String getStringMethod(byte[] var0, int var1, int var2) {
        char[] aCharArray1496 = new char[]{'\u20ac', '\u0000', '\u201a', '\u0192', '\u201e', '\u2026', '\u2020', '\u2021', '\u02c6', '\u2030', '\u0160', '\u2039', '\u0152', '\u0000', '\u017d', '\u0000', '\u0000', '\u2018', '\u2019', '\u201c', '\u201d', '\u2022', '\u2013', '\u2014', '\u02dc', '\u2122', '\u0161', '\u203a', '\u0153', '\u0000', '\u017e', '\u0178'};
        char[] var4 = new char[var2];
        int var5 = 0;

        for (int var8 = 0; var8 < var2; ++var8) {
            int var6 = var0[var1 + var8] & 255;
            if (var6 != 0) {
                if (var6 >= 128 && var6 < 160) {
                    char var7 = aCharArray1496[var6 - 128];
                    if (0 == var7) {
                        var7 = 63;
                    }

                    var6 = var7;
                }

                var4[var5++] = (char) var6;
            }
        }

        return new String(var4, 0, var5);
    }

}
