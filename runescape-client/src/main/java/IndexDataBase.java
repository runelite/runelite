import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -335196461
   )
   static int field3315;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -955590129
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("w")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("e")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("u")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("z")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("t")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("f")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("g")
   @Export("archiveFileNames")
   int[][] archiveFileNames;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lgm;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("x")
   @Export("archives")
   Object[] archives;
   @ObfuscatedName("c")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1159717755
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("y")
   @Export("releaseArchives")
   boolean releaseArchives;
   @ObfuscatedName("o")
   @Export("shallowRecords")
   boolean shallowRecords;

   static {
      gzip = new GZipDecompressor();
      field3315 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.releaseArchives = var1;
      this.shallowRecords = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "837100469"
   )
   @Export("setIndexReference")
   void setIndexReference(byte[] var1) {
      this.crc = class175.method3182(var1, var1.length);
      Buffer var2 = new Buffer(class218.decodeContainer(var1));
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
         this.archives = new Object[var6 + 1];
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1772940672"
   )
   void vmethod4373(int var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "16"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-1575622448"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
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

         byte[] var5 = TextureProvider.toByteArray(this.childs[var1][var2], false);
         if(this.shallowRecords) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1548623911"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-45"
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1376169074"
   )
   public boolean method4259() {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-325248462"
   )
   @Export("archiveLoadPercent")
   int archiveLoadPercent(int var1) {
      return this.archives[var1] != null?100:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1702901875"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "0"
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

         byte[] var4 = TextureProvider.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1503383677"
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1028855805"
   )
   @Export("loadArchive")
   void loadArchive(int var1) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1864207737"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "684786742"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "101"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-54"
   )
   public void method4327(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1644161676"
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
               var18 = TextureProvider.toByteArray(this.archives[var1], false);
            } else {
               var18 = TextureProvider.toByteArray(this.archives[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            }

            byte[] var20 = class218.decodeContainer(var18);
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
                     var5[var4[var15]] = class27.byteArrayToObject(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.shallowRecords) {
               var5[var4[0]] = class27.byteArrayToObject(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)I",
      garbageValue = "2036"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class31.djb2Hash(var1));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-1324119989"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class31.djb2Hash(var2));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-572795785"
   )
   public boolean method4273(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class31.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class31.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-945944964"
   )
   @Export("takeRecordByNames")
   public byte[] takeRecordByNames(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class31.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class31.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1860261102"
   )
   @Export("tryLoadRecordByNames")
   public boolean tryLoadRecordByNames(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class31.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class31.djb2Hash(var2));
      return this.tryLoadRecord(var3, var4);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-256581435"
   )
   @Export("tryLoadArchiveByName")
   public boolean tryLoadArchiveByName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class31.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-104"
   )
   public void method4277(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class31.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4373(var2);
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "22"
   )
   @Export("archiveLoadPercentByName")
   public int archiveLoadPercentByName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class31.djb2Hash(var1));
      return this.archiveLoadPercent(var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;Lib;ZB)V",
      garbageValue = "99"
   )
   public static void method4346(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.objects_ref = var0;
      ObjectComposition.field3551 = var1;
      ObjectComposition.ObjectDefinition_isLowDetail = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lik;",
      garbageValue = "339798863"
   )
   static class250[] method4253() {
      return new class250[]{class250.field3364, class250.field3366, class250.field3363};
   }
}
