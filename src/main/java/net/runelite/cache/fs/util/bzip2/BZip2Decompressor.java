package net.runelite.cache.fs.util.bzip2;

import net.runelite.cache.fs.util.bzip2.BZip2BlockEntry;

public class BZip2Decompressor {
   private static int[] anIntArray257;
   private static BZip2BlockEntry entryInstance = new BZip2BlockEntry();

   public static final void decompress(byte[] decompressedData, byte[] packedData, int containerSize, int blockSize) {
      BZip2BlockEntry var4 = entryInstance;
      synchronized(entryInstance) {
         entryInstance.aByteArray2224 = packedData;
         entryInstance.anInt2209 = blockSize;
         entryInstance.aByteArray2212 = decompressedData;
         entryInstance.anInt2203 = 0;
         entryInstance.anInt2206 = decompressedData.length;
         entryInstance.anInt2232 = 0;
         entryInstance.anInt2207 = 0;
         entryInstance.anInt2217 = 0;
         entryInstance.anInt2216 = 0;
         method1793(entryInstance);
         entryInstance.aByteArray2224 = null;
         entryInstance.aByteArray2212 = null;
      }
   }

   private static final void method1785(BZip2BlockEntry entry) {
      entry.anInt2215 = 0;

      for(int i = 0; i < 256; ++i) {
         if(entry.aBooleanArray2213[i]) {
            entry.aByteArray2211[entry.anInt2215] = (byte)i;
            ++entry.anInt2215;
         }
      }

   }

   private static final void method1786(int[] ai, int[] ai1, int[] ai2, byte[] abyte0, int i, int j, int k) {
      int l = 0;

      int i3;
      int k2;
      for(i3 = i; i3 <= j; ++i3) {
         for(k2 = 0; k2 < k; ++k2) {
            if(abyte0[k2] == i3) {
               ai2[l] = k2;
               ++l;
            }
         }
      }

      for(i3 = 0; i3 < 23; ++i3) {
         ai1[i3] = 0;
      }

      for(i3 = 0; i3 < k; ++i3) {
         ++ai1[abyte0[i3] + 1];
      }

      for(i3 = 1; i3 < 23; ++i3) {
         ai1[i3] += ai1[i3 - 1];
      }

      for(i3 = 0; i3 < 23; ++i3) {
         ai[i3] = 0;
      }

      i3 = 0;

      for(k2 = i; k2 <= j; ++k2) {
         i3 += ai1[k2 + 1] - ai1[k2];
         ai[k2] = i3 - 1;
         i3 <<= 1;
      }

      for(k2 = i + 1; k2 <= j; ++k2) {
         ai1[k2] = (ai[k2 - 1] + 1 << 1) - ai1[k2];
      }

   }

   private static final void method1787(BZip2BlockEntry entry) {
      byte byte4 = entry.aByte2201;
      int i = entry.anInt2222;
      int j = entry.anInt2227;
      int k = entry.anInt2221;
      int[] ai = anIntArray257;
      int l = entry.anInt2208;
      byte[] abyte0 = entry.aByteArray2212;
      int i1 = entry.anInt2203;
      int j1 = entry.anInt2206;
      int l1 = entry.anInt2225 + 1;

      label65:
      while(true) {
         if(i > 0) {
            while(true) {
               if(j1 == 0) {
                  break label65;
               }

               if(i == 1) {
                  if(j1 == 0) {
                     i = 1;
                     break label65;
                  }

                  abyte0[i1] = byte4;
                  ++i1;
                  --j1;
                  break;
               }

               abyte0[i1] = byte4;
               --i;
               ++i1;
               --j1;
            }
         }

         boolean flag = true;

         byte byte1;
         while(flag) {
            flag = false;
            if(j == l1) {
               i = 0;
               break label65;
            }

            byte4 = (byte)k;
            l = ai[l];
            byte1 = (byte)(l & 255);
            l >>= 8;
            ++j;
            if(byte1 != k) {
               k = byte1;
               if(j1 == 0) {
                  i = 1;
                  break label65;
               }

               abyte0[i1] = byte4;
               ++i1;
               --j1;
               flag = true;
            } else if(j == l1) {
               if(j1 == 0) {
                  i = 1;
                  break label65;
               }

               abyte0[i1] = byte4;
               ++i1;
               --j1;
               flag = true;
            }
         }

         i = 2;
         l = ai[l];
         byte1 = (byte)(l & 255);
         l >>= 8;
         ++j;
         if(j != l1) {
            if(byte1 != k) {
               k = byte1;
            } else {
               i = 3;
               l = ai[l];
               byte byte2 = (byte)(l & 255);
               l >>= 8;
               ++j;
               if(j != l1) {
                  if(byte2 != k) {
                     k = byte2;
                  } else {
                     l = ai[l];
                     byte byte3 = (byte)(l & 255);
                     l >>= 8;
                     ++j;
                     i = (byte3 & 255) + 4;
                     l = ai[l];
                     k = (byte)(l & 255);
                     l >>= 8;
                     ++j;
                  }
               }
            }
         }
      }

      entry.anInt2216 += j1 - j1;
      entry.aByte2201 = byte4;
      entry.anInt2222 = i;
      entry.anInt2227 = j;
      entry.anInt2221 = k;
      anIntArray257 = ai;
      entry.anInt2208 = l;
      entry.aByteArray2212 = abyte0;
      entry.anInt2203 = i1;
      entry.anInt2206 = j1;
   }

   private static final byte method1788(BZip2BlockEntry entry) {
      return (byte)method1790(1, entry);
   }

   private static final byte method1789(BZip2BlockEntry entry) {
      return (byte)method1790(8, entry);
   }

   private static final int method1790(int i, BZip2BlockEntry entry) {
      while(entry.anInt2232 < i) {
         entry.anInt2207 = entry.anInt2207 << 8 | entry.aByteArray2224[entry.anInt2209] & 255;
         entry.anInt2232 += 8;
         ++entry.anInt2209;
         ++entry.anInt2217;
      }

      int k = entry.anInt2207 >> entry.anInt2232 - i & (1 << i) - 1;
      entry.anInt2232 -= i;
      return k;
   }

   public static void clearBlockEntryInstance() {
      entryInstance = null;
   }

   private static final void method1793(BZip2BlockEntry entry) {
      int j8 = 0;
      int[] ai = (int[])null;
      int[] ai1 = (int[])null;
      int[] ai2 = (int[])null;
      entry.anInt2202 = 1;
      if(anIntArray257 == null) {
         anIntArray257 = new int[entry.anInt2202 * 100000];
      }

      boolean flag18 = true;

      while(true) {
         while(flag18) {
            byte byte0 = method1789(entry);
            if(byte0 == 23) {
               return;
            }

            byte0 = method1789(entry);
            byte0 = method1789(entry);
            byte0 = method1789(entry);
            byte0 = method1789(entry);
            byte0 = method1789(entry);
            byte0 = method1789(entry);
            byte0 = method1789(entry);
            byte0 = method1789(entry);
            byte0 = method1789(entry);
            byte0 = method1788(entry);
            entry.anInt2223 = 0;
            byte0 = method1789(entry);
            entry.anInt2223 = entry.anInt2223 << 8 | byte0 & 255;
            byte0 = method1789(entry);
            entry.anInt2223 = entry.anInt2223 << 8 | byte0 & 255;
            byte0 = method1789(entry);
            entry.anInt2223 = entry.anInt2223 << 8 | byte0 & 255;

            int i4;
            for(i4 = 0; i4 < 16; ++i4) {
               byte j4 = method1788(entry);
               if(j4 == 1) {
                  entry.aBooleanArray2205[i4] = true;
               } else {
                  entry.aBooleanArray2205[i4] = false;
               }
            }

            for(i4 = 0; i4 < 256; ++i4) {
               entry.aBooleanArray2213[i4] = false;
            }

            int var28;
            for(i4 = 0; i4 < 16; ++i4) {
               if(entry.aBooleanArray2205[i4]) {
                  for(var28 = 0; var28 < 16; ++var28) {
                     byte k4 = method1788(entry);
                     if(k4 == 1) {
                        entry.aBooleanArray2213[i4 * 16 + var28] = true;
                     }
                  }
               }
            }

            method1785(entry);
            i4 = entry.anInt2215 + 2;
            var28 = method1790(3, entry);
            int var29 = method1790(15, entry);

            int l4;
            byte i5;
            for(int abyte0 = 0; abyte0 < var29; ++abyte0) {
               l4 = 0;

               while(true) {
                  i5 = method1788(entry);
                  if(i5 == 0) {
                     entry.aByteArray2214[abyte0] = (byte)l4;
                     break;
                  }

                  ++l4;
               }
            }

            byte[] var30 = new byte[6];

            for(byte var31 = 0; var31 < var28; var30[var31] = var31++) {
               ;
            }

            byte j5;
            for(l4 = 0; l4 < var29; ++l4) {
               i5 = entry.aByteArray2214[l4];

               for(j5 = var30[i5]; i5 > 0; --i5) {
                  var30[i5] = var30[i5 - 1];
               }

               var30[0] = j5;
               entry.aByteArray2219[l4] = j5;
            }

            int var32;
            int var33;
            for(l4 = 0; l4 < var28; ++l4) {
               var32 = method1790(5, entry);

               for(var33 = 0; var33 < i4; ++var33) {
                  while(true) {
                     byte i9 = method1788(entry);
                     if(i9 == 0) {
                        entry.aByteArrayArray2229[l4][var33] = (byte)var32;
                        break;
                     }

                     i9 = method1788(entry);
                     if(i9 == 0) {
                        ++var32;
                     } else {
                        --var32;
                     }
                  }
               }
            }

            int var35;
            for(l4 = 0; l4 < var28; ++l4) {
               i5 = 32;
               j5 = 0;

               for(var35 = 0; var35 < i4; ++var35) {
                  if(entry.aByteArrayArray2229[l4][var35] > j5) {
                     j5 = entry.aByteArrayArray2229[l4][var35];
                  }

                  if(entry.aByteArrayArray2229[l4][var35] < i5) {
                     i5 = entry.aByteArrayArray2229[l4][var35];
                  }
               }

               method1786(entry.anIntArrayArray2230[l4], entry.anIntArrayArray2218[l4], entry.anIntArrayArray2210[l4], entry.aByteArrayArray2229[l4], i5, j5, i4);
               entry.anIntArray2200[l4] = i5;
            }

            l4 = entry.anInt2215 + 1;
            var32 = -1;
            byte var34 = 0;

            for(var35 = 0; var35 <= 255; ++var35) {
               entry.anIntArray2228[var35] = 0;
            }

            var35 = 4095;

            int l5;
            int l6;
            for(l5 = 15; l5 >= 0; --l5) {
               for(l6 = 15; l6 >= 0; --l6) {
                  entry.aByteArray2204[var35] = (byte)(l5 * 16 + l6);
                  --var35;
               }

               entry.anIntArray2226[l5] = var35 + 1;
            }

            l5 = 0;
            if(var34 == 0) {
               ++var32;
               var34 = 50;
               byte var36 = entry.aByteArray2219[var32];
               j8 = entry.anIntArray2200[var36];
               ai = entry.anIntArrayArray2230[var36];
               ai2 = entry.anIntArrayArray2210[var36];
               ai1 = entry.anIntArrayArray2218[var36];
            }

            var33 = var34 - 1;
            l6 = j8;

            int k7;
            byte byte9;
            for(k7 = method1790(j8, entry); k7 > ai[l6]; k7 = k7 << 1 | byte9) {
               ++l6;
               byte9 = method1788(entry);
            }

            int l2 = ai2[k7 - ai1[l6]];

            while(true) {
               while(l2 != l4) {
                  int byte7;
                  byte j7;
                  int i8;
                  byte byte11;
                  int var38;
                  if(l2 != 0 && l2 != 1) {
                     byte7 = l2 - 1;
                     byte var37;
                     if(byte7 < 16) {
                        var38 = entry.anIntArray2226[0];

                        for(var37 = entry.aByteArray2204[var38 + byte7]; byte7 > 3; byte7 -= 4) {
                           i8 = var38 + byte7;
                           entry.aByteArray2204[i8] = entry.aByteArray2204[i8 - 1];
                           entry.aByteArray2204[i8 - 1] = entry.aByteArray2204[i8 - 2];
                           entry.aByteArray2204[i8 - 2] = entry.aByteArray2204[i8 - 3];
                           entry.aByteArray2204[i8 - 3] = entry.aByteArray2204[i8 - 4];
                        }

                        while(byte7 > 0) {
                           entry.aByteArray2204[var38 + byte7] = entry.aByteArray2204[var38 + byte7 - 1];
                           --byte7;
                        }

                        entry.aByteArray2204[var38] = var37;
                     } else {
                        var38 = byte7 / 16;
                        i8 = byte7 % 16;
                        int var40 = entry.anIntArray2226[var38] + i8;

                        for(var37 = entry.aByteArray2204[var40]; var40 > entry.anIntArray2226[var38]; --var40) {
                           entry.aByteArray2204[var40] = entry.aByteArray2204[var40 - 1];
                        }

                        ++entry.anIntArray2226[var38];

                        while(var38 > 0) {
                           --entry.anIntArray2226[var38];
                           entry.aByteArray2204[entry.anIntArray2226[var38]] = entry.aByteArray2204[entry.anIntArray2226[var38 - 1] + 16 - 1];
                           --var38;
                        }

                        --entry.anIntArray2226[0];
                        entry.aByteArray2204[entry.anIntArray2226[0]] = var37;
                        if(entry.anIntArray2226[0] == 0) {
                           int l9 = 4095;

                           for(int j9 = 15; j9 >= 0; --j9) {
                              for(int k9 = 15; k9 >= 0; --k9) {
                                 entry.aByteArray2204[l9] = entry.aByteArray2204[entry.anIntArray2226[j9] + k9];
                                 --l9;
                              }

                              entry.anIntArray2226[j9] = l9 + 1;
                           }
                        }
                     }

                     ++entry.anIntArray2228[entry.aByteArray2211[var37 & 255] & 255];
                     anIntArray257[l5] = entry.aByteArray2211[var37 & 255] & 255;
                     ++l5;
                     if(var33 == 0) {
                        ++var32;
                        var33 = 50;
                        j7 = entry.aByteArray2219[var32];
                        j8 = entry.anIntArray2200[j7];
                        ai = entry.anIntArrayArray2230[j7];
                        ai2 = entry.anIntArrayArray2210[j7];
                        ai1 = entry.anIntArrayArray2218[j7];
                     }

                     --var33;
                     var38 = j8;

                     for(i8 = method1790(j8, entry); i8 > ai[var38]; i8 = i8 << 1 | byte11) {
                        ++var38;
                        byte11 = method1788(entry);
                     }

                     l2 = ai2[i8 - ai1[var38]];
                  } else {
                     byte7 = -1;
                     int byte6 = 1;

                     do {
                        if(l2 == 0) {
                           byte7 += byte6;
                        } else if(l2 == 1) {
                           byte7 += 2 * byte6;
                        }

                        byte6 *= 2;
                        if(var33 == 0) {
                           ++var32;
                           var33 = 50;
                           j7 = entry.aByteArray2219[var32];
                           j8 = entry.anIntArray2200[j7];
                           ai = entry.anIntArrayArray2230[j7];
                           ai2 = entry.anIntArrayArray2210[j7];
                           ai1 = entry.anIntArrayArray2218[j7];
                        }

                        --var33;
                        var38 = j8;

                        for(i8 = method1790(j8, entry); i8 > ai[var38]; i8 = i8 << 1 | byte11) {
                           ++var38;
                           byte11 = method1788(entry);
                        }

                        l2 = ai2[i8 - ai1[var38]];
                     } while(l2 == 0 || l2 == 1);

                     ++byte7;
                     j7 = entry.aByteArray2211[entry.aByteArray2204[entry.anIntArray2226[0]] & 255];

                     for(entry.anIntArray2228[j7 & 255] += byte7; byte7 > 0; --byte7) {
                        anIntArray257[l5] = j7 & 255;
                        ++l5;
                     }
                  }
               }

               entry.anInt2222 = 0;
               entry.aByte2201 = 0;
               entry.anIntArray2220[0] = 0;

               for(l2 = 1; l2 <= 256; ++l2) {
                  entry.anIntArray2220[l2] = entry.anIntArray2228[l2 - 1];
               }

               for(l2 = 1; l2 <= 256; ++l2) {
                  entry.anIntArray2220[l2] += entry.anIntArray2220[l2 - 1];
               }

               for(l2 = 0; l2 < l5; ++l2) {
                  byte var39 = (byte)(anIntArray257[l2] & 255);
                  anIntArray257[entry.anIntArray2220[var39 & 255]] |= l2 << 8;
                  ++entry.anIntArray2220[var39 & 255];
               }

               entry.anInt2208 = anIntArray257[entry.anInt2223] >> 8;
               entry.anInt2227 = 0;
               entry.anInt2208 = anIntArray257[entry.anInt2208];
               entry.anInt2221 = (byte)(entry.anInt2208 & 255);
               entry.anInt2208 >>= 8;
               ++entry.anInt2227;
               entry.anInt2225 = l5;
               method1787(entry);
               if(entry.anInt2227 == entry.anInt2225 + 1 && entry.anInt2222 == 0) {
                  flag18 = true;
                  break;
               }

               flag18 = false;
               break;
            }
         }

         return;
      }
   }
}
