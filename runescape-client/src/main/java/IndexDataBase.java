import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -763325975
   )
   static int field3379;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -225110591
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("b")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("z")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("l")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("s")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("y")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("c")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("h")
   @Export("archiveFileNames")
   int[][] archiveFileNames;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lhk;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("o")
   @Export("archives")
   Object[] archives;
   @ObfuscatedName("d")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 705106645
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("q")
   @Export("releaseArchives")
   boolean releaseArchives;
   @ObfuscatedName("f")
   @Export("shallowRecords")
   boolean shallowRecords;

   static {
      gzip = new GZipDecompressor();
      field3379 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.releaseArchives = var1;
      this.shallowRecords = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-744189284"
   )
   @Export("setIndexReference")
   void setIndexReference(byte[] var1) {
      int var3 = var1.length;
      int var5 = -1;

      int var6;
      for(var6 = 0; var6 < var3; ++var6) {
         var5 = var5 >>> 8 ^ Buffer.crc32Table[(var5 ^ var1[var6]) & 255];
      }

      var5 = ~var5;
      this.crc = var5;
      Buffer var15 = new Buffer(CombatInfoListHolder.decodeContainer(var1));
      var5 = var15.readUnsignedByte();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var15.readInt();
         }

         var6 = var15.readUnsignedByte();
         if(var5 >= 7) {
            this.validArchivesCount = var15.getLargeSmart();
         } else {
            this.validArchivesCount = var15.readUnsignedShort();
         }

         int var7 = 0;
         int var8 = -1;
         this.archiveIds = new int[this.validArchivesCount];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveIds[var9] = var7 += var15.getLargeSmart();
               if(this.archiveIds[var9] > var8) {
                  var8 = this.archiveIds[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveIds[var9] = var7 += var15.readUnsignedShort();
               if(this.archiveIds[var9] > var8) {
                  var8 = this.archiveIds[var9];
               }
            }
         }

         this.archiveCrcs = new int[var8 + 1];
         this.archiveRevisions = new int[var8 + 1];
         this.archiveNumberOfFiles = new int[var8 + 1];
         this.archiveFileIds = new int[var8 + 1][];
         this.archives = new Object[var8 + 1];
         this.childs = new Object[var8 + 1][];
         if(var6 != 0) {
            this.archiveNames = new int[var8 + 1];

            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveNames[this.archiveIds[var9]] = var15.readInt();
            }

            this.identifiers = new Identifiers(this.archiveNames);
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveCrcs[this.archiveIds[var9]] = var15.readInt();
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveRevisions[this.archiveIds[var9]] = var15.readInt();
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveNumberOfFiles[this.archiveIds[var9]] = var15.readUnsignedShort();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               var10 = this.archiveIds[var9];
               var11 = this.archiveNumberOfFiles[var10];
               var7 = 0;
               var12 = -1;
               this.archiveFileIds[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.archiveFileIds[var10][var13] = var7 += var15.getLargeSmart();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.childs[var10] = new Object[var12 + 1];
            }
         } else {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               var10 = this.archiveIds[var9];
               var11 = this.archiveNumberOfFiles[var10];
               var7 = 0;
               var12 = -1;
               this.archiveFileIds[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.archiveFileIds[var10][var13] = var7 += var15.readUnsignedShort();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.childs[var10] = new Object[var12 + 1];
            }
         }

         if(var6 != 0) {
            this.archiveFileNames = new int[var8 + 1][];
            this.childIdentifiers = new Identifiers[var8 + 1];

            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               var10 = this.archiveIds[var9];
               var11 = this.archiveNumberOfFiles[var10];
               this.archiveFileNames[var10] = new int[this.childs[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.archiveFileNames[var10][this.archiveFileIds[var10][var12]] = var15.readInt();
               }

               this.childIdentifiers[var10] = new Identifiers(this.archiveFileNames[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-333551024"
   )
   void vmethod4755(int var1) {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "928958327"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigDataKeys(var1, var2, (int[])null);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-16711936"
   )
   @Export("getConfigDataKeys")
   public byte[] getConfigDataKeys(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.buildRecords(var1, var3);
            if(!var4) {
               this.loadArchive(var1);
               var4 = this.buildRecords(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class1.toByteArray(this.childs[var1][var2], false);
         if(this.shallowRecords) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1621879797"
   )
   @Export("tryLoadRecord")
   public boolean tryLoadRecord(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.archives[var1] != null) {
            return true;
         } else {
            this.loadArchive(var1);
            return this.archives[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1460745810"
   )
   public boolean method4646(int var1) {
      if(this.childs.length == 1) {
         return this.tryLoadRecord(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.tryLoadRecord(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1964881933"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.archives[var1] != null) {
         return true;
      } else {
         this.loadArchive(var1);
         return this.archives[var1] != null;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-658121487"
   )
   public boolean method4666() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.archives[var3] == null) {
            this.loadArchive(var3);
            if(this.archives[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "374327103"
   )
   @Export("archiveLoadPercent")
   int archiveLoadPercent(int var1) {
      return this.archives[var1] != null?100:0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "26"
   )
   @Export("takeRecordFlat")
   public byte[] takeRecordFlat(int var1) {
      if(this.childs.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "1"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.buildRecords(var1, (int[])null);
            if(!var3) {
               this.loadArchive(var1);
               var3 = this.buildRecords(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class1.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1472239510"
   )
   @Export("getRecordFlat")
   public byte[] getRecordFlat(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-27"
   )
   @Export("loadArchive")
   void loadArchive(int var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-928431992"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1742618333"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-20"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2077691934"
   )
   public void method4657() {
      for(int var1 = 0; var1 < this.archives.length; ++var1) {
         this.archives[var1] = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-500212489"
   )
   public void method4675(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-331387292"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1527505885"
   )
   @Export("buildRecords")
   boolean buildRecords(int var1, int[] var2) {
      if(this.archives[var1] == null) {
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
               var18 = class1.toByteArray(this.archives[var1], false);
            } else {
               var18 = class1.toByteArray(this.archives[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            }

            byte[] var20 = CombatInfoListHolder.decodeContainer(var18);
            if(this.releaseArchives) {
               this.archives[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var10 * var3 * 4;
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
                  if(!this.shallowRecords) {
                     var5[var4[var15]] = GraphicsObject.byteArrayToObject(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.shallowRecords) {
               var5[var4[0]] = GraphicsObject.byteArrayToObject(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)I",
      garbageValue = "-8803"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(LoginPacket.djb2Hash(var1));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-1858357269"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(LoginPacket.djb2Hash(var2));
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1178222894"
   )
   public boolean method4663(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(LoginPacket.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(LoginPacket.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-1507481076"
   )
   @Export("takeRecordByNames")
   public byte[] takeRecordByNames(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(LoginPacket.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(LoginPacket.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;S)Z",
      garbageValue = "-15681"
   )
   @Export("tryLoadRecordByNames")
   public boolean tryLoadRecordByNames(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(LoginPacket.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(LoginPacket.djb2Hash(var2));
      return this.tryLoadRecord(var3, var4);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "1"
   )
   @Export("tryLoadArchiveByName")
   public boolean tryLoadArchiveByName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(LoginPacket.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1297734400"
   )
   public void method4667(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(LoginPacket.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4755(var2);
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "60"
   )
   @Export("archiveLoadPercentByName")
   public int archiveLoadPercentByName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(LoginPacket.djb2Hash(var1));
      return this.archiveLoadPercent(var2);
   }
}
