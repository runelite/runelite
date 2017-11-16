import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1571517423
   )
   static int field3285;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2146669425
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("s")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("r")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("x")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("f")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("u")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("t")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("k")
   @Export("archiveFileNames")
   int[][] archiveFileNames;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lgv;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("d")
   Object[] field3279;
   @ObfuscatedName("o")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1388987323
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("j")
   boolean field3275;
   @ObfuscatedName("m")
   boolean field3282;

   static {
      gzip = new GZipDecompressor();
      field3285 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3275 = var1;
      this.field3282 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "2122060862"
   )
   void method4106(byte[] var1) {
      this.crc = class100.method1877(var1, var1.length);
      Buffer var2 = new Buffer(CacheFile.decodeContainer(var1));
      int var3 = var2.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if(var3 >= 7) {
            this.validArchivesCount = var2.getLargeSmart();
         } else {
            this.validArchivesCount = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.archiveIds = new int[this.validArchivesCount];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               this.archiveIds[var7] = var5 += var2.getLargeSmart();
               if(this.archiveIds[var7] > var6) {
                  var6 = this.archiveIds[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               this.archiveIds[var7] = var5 += var2.readUnsignedShort();
               if(this.archiveIds[var7] > var6) {
                  var6 = this.archiveIds[var7];
               }
            }
         }

         this.archiveCrcs = new int[var6 + 1];
         this.archiveRevisions = new int[var6 + 1];
         this.archiveNumberOfFiles = new int[var6 + 1];
         this.archiveFileIds = new int[var6 + 1][];
         this.field3279 = new Object[var6 + 1];
         this.childs = new Object[var6 + 1][];
         if(var4 != 0) {
            this.archiveNames = new int[var6 + 1];

            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               this.archiveNames[this.archiveIds[var7]] = var2.readInt();
            }

            this.identifiers = new Identifiers(this.archiveNames);
         }

         for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
            this.archiveCrcs[this.archiveIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
            this.archiveRevisions[this.archiveIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
            this.archiveNumberOfFiles[this.archiveIds[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.archiveNumberOfFiles[var8];
               var5 = 0;
               var10 = -1;
               this.archiveFileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.archiveFileIds[var8][var11] = var5 += var2.getLargeSmart();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.childs[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.archiveNumberOfFiles[var8];
               var5 = 0;
               var10 = -1;
               this.archiveFileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.archiveFileIds[var8][var11] = var5 += var2.readUnsignedShort();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.childs[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.archiveFileNames = new int[var6 + 1][];
            this.childIdentifiers = new Identifiers[var6 + 1];

            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.archiveNumberOfFiles[var8];
               this.archiveFileNames[var8] = new int[this.childs[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.archiveFileNames[var8][this.archiveFileIds[var8][var10]] = var2.readInt();
               }

               this.childIdentifiers[var8] = new Identifiers(this.archiveFileNames[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1224741281"
   )
   void vmethod4211(int var1) {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "119"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "1676828941"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4146(var1, var3);
            if(!var4) {
               this.vmethod4216(var1);
               var4 = this.method4146(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = Ignore.toByteArray(this.childs[var1][var2], false);
         if(this.field3282) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "24"
   )
   public boolean method4157(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3279[var1] != null) {
            return true;
         } else {
            this.vmethod4216(var1);
            return this.field3279[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-25"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3279[var1] != null) {
         return true;
      } else {
         this.vmethod4216(var1);
         return this.field3279[var1] != null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2103700526"
   )
   public boolean method4112() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3279[var3] == null) {
            this.vmethod4216(var3);
            if(this.field3279[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   int vmethod4223(int var1) {
      return this.field3279[var1] != null?100:0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1625352551"
   )
   public byte[] method4114(int var1) {
      if(this.childs.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1091771088"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4146(var1, (int[])null);
            if(!var3) {
               this.vmethod4216(var1);
               var3 = this.method4146(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = Ignore.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1507566919"
   )
   public byte[] method4116(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "71"
   )
   void vmethod4216(int var1) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1521972978"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1688352619"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-140616018"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "497600572"
   )
   public void method4113(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "788148524"
   )
   @Export("reset")
   public void reset() {
      for(int var1 = 0; var1 < this.childs.length; ++var1) {
         if(this.childs[var1] != null) {
            for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
               this.childs[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "-54"
   )
   boolean method4146(int var1, int[] var2) {
      if(this.field3279[var1] == null) {
         return false;
      } else {
         int var3 = this.archiveNumberOfFiles[var1];
         int[] var4 = this.archiveFileIds[var1];
         Object[] var5 = this.childs[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(var5[var4[var7]] == null) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var18;
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = Ignore.toByteArray(this.field3279[var1], false);
            } else {
               var18 = Ignore.toByteArray(this.field3279[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            }

            byte[] var20 = CacheFile.decodeContainer(var18);
            if(this.field3275) {
               this.field3279[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var3 * var10 * 4;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.readInt();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.offset = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.readInt();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field3282) {
                     var5[var4[var15]] = class177.method3156(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3282) {
               var5[var4[0]] = class177.method3156(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "0"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class90.djb2Hash(var1));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "1637361607"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class90.djb2Hash(var2));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1896681162"
   )
   public boolean method4125(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class90.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class90.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "-36"
   )
   public byte[] method4141(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class90.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class90.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1847874150"
   )
   public boolean method4127(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class90.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class90.djb2Hash(var2));
      return this.method4157(var3, var4);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1093624908"
   )
   public boolean method4171(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class90.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1757779887"
   )
   public void method4120(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class90.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4211(var2);
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "2041930848"
   )
   public int method4128(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class90.djb2Hash(var1));
      return this.vmethod4223(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-419185739"
   )
   public static int method4198(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }
}
