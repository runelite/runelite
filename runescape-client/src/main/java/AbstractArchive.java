import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("AbstractArchive")
public abstract class AbstractArchive {
   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      signature = "Lco;"
   )
   @Export("pcmPlayer1")
   static PcmPlayer pcmPlayer1;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("gzipDecompressor")
   static GzipDecompressor gzipDecompressor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -244224193
   )
   static int field1;
   @ObfuscatedName("au")
   @Export("garbageCollector")
   static GarbageCollectorMXBean garbageCollector;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 334735939
   )
   static int field2;
   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("archive0")
   static Archive archive0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1694798923
   )
   @Export("groupCount")
   int groupCount;
   @ObfuscatedName("q")
   @Export("groupIds")
   int[] groupIds;
   @ObfuscatedName("w")
   @Export("groupNameHashes")
   int[] groupNameHashes;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   @Export("groupNameHashTable")
   IntHashTable groupNameHashTable;
   @ObfuscatedName("u")
   @Export("groupCrcs")
   int[] groupCrcs;
   @ObfuscatedName("g")
   @Export("groupVersions")
   int[] groupVersions;
   @ObfuscatedName("l")
   @Export("fileCounts")
   int[] fileCounts;
   @ObfuscatedName("e")
   @Export("fileIds")
   int[][] fileIds;
   @ObfuscatedName("x")
   @Export("fileNameHashes")
   int[][] fileNameHashes;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("fileNameHashTables")
   IntHashTable[] fileNameHashTables;
   @ObfuscatedName("k")
   @Export("groups")
   Object[] groups;
   @ObfuscatedName("n")
   @Export("files")
   Object[][] files;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -530370811
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("z")
   @Export("releaseGroups")
   boolean releaseGroups;
   @ObfuscatedName("j")
   @Export("shallowFiles")
   boolean shallowFiles;

   AbstractArchive(boolean var1, boolean var2) {
      this.releaseGroups = var1;
      this.shallowFiles = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "0"
   )
   @Export("decodeIndex")
   void decodeIndex(byte[] var1) {
      this.hash = WallDecoration.method3257(var1, var1.length);
      Buffer var2 = new Buffer(Strings.decompressBytes(var1));
      int var3 = var2.readUnsignedByte();
      if (var3 >= 5 && var3 <= 7) {
         if (var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if (var3 >= 7) {
            this.groupCount = var2.method50();
         } else {
            this.groupCount = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.groupIds = new int[this.groupCount];
         int var7;
         if (var3 >= 7) {
            for (var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupIds[var7] = var5 += var2.method50();
               if (this.groupIds[var7] > var6) {
                  var6 = this.groupIds[var7];
               }
            }
         } else {
            for (var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupIds[var7] = var5 += var2.readUnsignedShort();
               if (this.groupIds[var7] > var6) {
                  var6 = this.groupIds[var7];
               }
            }
         }

         this.groupCrcs = new int[var6 + 1];
         this.groupVersions = new int[var6 + 1];
         this.fileCounts = new int[var6 + 1];
         this.fileIds = new int[var6 + 1][];
         this.groups = new Object[var6 + 1];
         this.files = new Object[var6 + 1][];
         if (var4 != 0) {
            this.groupNameHashes = new int[var6 + 1];

            for (var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupNameHashes[this.groupIds[var7]] = var2.readInt();
            }

            this.groupNameHashTable = new IntHashTable(this.groupNameHashes);
         }

         for (var7 = 0; var7 < this.groupCount; ++var7) {
            this.groupCrcs[this.groupIds[var7]] = var2.readInt();
         }

         for (var7 = 0; var7 < this.groupCount; ++var7) {
            this.groupVersions[this.groupIds[var7]] = var2.readInt();
         }

         for (var7 = 0; var7 < this.groupCount; ++var7) {
            this.fileCounts[this.groupIds[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if (var3 >= 7) {
            for (var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               var5 = 0;
               var10 = -1;
               this.fileIds[var8] = new int[var9];

               for (var11 = 0; var11 < var9; ++var11) {
                  var12 = this.fileIds[var8][var11] = var5 += var2.method50();
                  if (var12 > var10) {
                     var10 = var12;
                  }
               }

               this.files[var8] = new Object[var10 + 1];
            }
         } else {
            for (var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               var5 = 0;
               var10 = -1;
               this.fileIds[var8] = new int[var9];

               for (var11 = 0; var11 < var9; ++var11) {
                  var12 = this.fileIds[var8][var11] = var5 += var2.readUnsignedShort();
                  if (var12 > var10) {
                     var10 = var12;
                  }
               }

               this.files[var8] = new Object[var10 + 1];
            }
         }

         if (var4 != 0) {
            this.fileNameHashes = new int[var6 + 1][];
            this.fileNameHashTables = new IntHashTable[var6 + 1];

            for (var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               this.fileNameHashes[var8] = new int[this.files[var8].length];

               for (var10 = 0; var10 < var9; ++var10) {
                  this.fileNameHashes[var8][this.fileIds[var8][var10]] = var2.readInt();
               }

               this.fileNameHashTables[var8] = new IntHashTable(this.fileNameHashes[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2102142648"
   )
   void vmethod129(int var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1945577069"
   )
   @Export("takeFile")
   public byte[] takeFile(int group, int file) {
      return this.takeFileEncrypted(group, file, (int[])null);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-1363136655"
   )
   @Export("takeFileEncrypted")
   public byte[] takeFileEncrypted(int group, int file, int[] xteaKey) {
      if (group >= 0 && group < this.files.length && this.files[group] != null && file >= 0 && file < this.files[group].length) {
         if (this.files[group][file] == null) {
            boolean var4 = this.buildFiles(group, xteaKey);
            if (!var4) {
               this.loadGroup(group);
               var4 = this.buildFiles(group, xteaKey);
               if (!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = TextureProvider.byteArrayFromObject(this.files[group][file], false);
         if (this.shallowFiles) {
            this.files[group][file] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1822260214"
   )
   @Export("tryLoadFile")
   public boolean tryLoadFile(int group, int file) {
      if (group >= 0 && group < this.files.length && this.files[group] != null && file >= 0 && file < this.files[group].length) {
         if (this.files[group][file] != null) {
            return true;
         } else if (this.groups[group] != null) {
            return true;
         } else {
            this.loadGroup(group);
            return this.groups[group] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1923759754"
   )
   public boolean method1(int var1) {
      if (this.files.length == 1) {
         return this.tryLoadFile(0, var1);
      } else if (this.files[var1].length == 1) {
         return this.tryLoadFile(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-374594123"
   )
   @Export("tryLoadGroup")
   public boolean tryLoadGroup(int group) {
      if (this.groups[group] != null) {
         return true;
      } else {
         this.loadGroup(group);
         return this.groups[group] != null;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1694975256"
   )
   public boolean method2() {
      boolean var1 = true;

      for (int var2 = 0; var2 < this.groupIds.length; ++var2) {
         int var3 = this.groupIds[var2];
         if (this.groups[var3] == null) {
            this.loadGroup(var3);
            if (this.groups[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1809769865"
   )
   @Export("groupLoadPercent")
   int groupLoadPercent(int var1) {
      return this.groups[var1] != null ? 100 : 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)[B",
      garbageValue = "-10015"
   )
   @Export("takeFileFlat")
   public byte[] takeFileFlat(int groupOrFile) {
      if (this.files.length == 1) {
         return this.takeFile(0, groupOrFile);
      } else if (this.files[groupOrFile].length == 1) {
         return this.takeFile(groupOrFile, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-755739011"
   )
   @Export("getFile")
   public byte[] getFile(int group, int file) {
      if (group >= 0 && group < this.files.length && this.files[group] != null && file >= 0 && file < this.files[group].length) {
         if (this.files[group][file] == null) {
            boolean var3 = this.buildFiles(group, (int[])null);
            if (!var3) {
               this.loadGroup(group);
               var3 = this.buildFiles(group, (int[])null);
               if (!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = TextureProvider.byteArrayFromObject(this.files[group][file], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "68"
   )
   @Export("getFileFlat")
   public byte[] getFileFlat(int groupOrFile) {
      if (this.files.length == 1) {
         return this.getFile(0, groupOrFile);
      } else if (this.files[groupOrFile].length == 1) {
         return this.getFile(groupOrFile, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1829145107"
   )
   @Export("loadGroup")
   void loadGroup(int group) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "28"
   )
   public int[] method3(int var1) {
      return var1 >= 0 && var1 < this.fileIds.length ? this.fileIds[var1] : null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1178362496"
   )
   public int method4(int var1) {
      return this.files[var1].length;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1702434573"
   )
   public int method5() {
      return this.files.length;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   public void method6() {
      for (int var1 = 0; var1 < this.groups.length; ++var1) {
         this.groups[var1] = null;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "330258899"
   )
   public void method7(int var1) {
      for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
         this.files[var1][var2] = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-709581639"
   )
   public void method8() {
      for (int var1 = 0; var1 < this.files.length; ++var1) {
         if (this.files[var1] != null) {
            for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
               this.files[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1835696874"
   )
   @Export("buildFiles")
   boolean buildFiles(int group, int[] xteaKey) {
      if (this.groups[group] == null) {
         return false;
      } else {
         int var3 = this.fileCounts[group];
         int[] var4 = this.fileIds[group];
         Object[] var5 = this.files[group];
         boolean var6 = true;

         for (int var7 = 0; var7 < var3; ++var7) {
            if (var5[var4[var7]] == null) {
               var6 = false;
               break;
            }
         }

         if (var6) {
            return true;
         } else {
            byte[] var18;
            if (xteaKey == null || xteaKey[0] == 0 && xteaKey[1] == 0 && xteaKey[2] == 0 && xteaKey[3] == 0) {
               var18 = TextureProvider.byteArrayFromObject(this.groups[group], false);
            } else {
               var18 = TextureProvider.byteArrayFromObject(this.groups[group], true);
               Buffer var8 = new Buffer(var18);
               var8.xteaDecrypt(xteaKey, 5, var8.array.length);
            }

            byte[] var19 = Strings.decompressBytes(var18);
            if (this.releaseGroups) {
               this.groups[group] = null;
            }

            if (var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= var10 * var3 * 4;
               Buffer var11 = new Buffer(var19);
               int[] var12 = new int[var3];
               var11.index = var9;

               int var13;
               int var14;
               for (int var15 = 0; var15 < var10; ++var15) {
                  var13 = 0;

                  for (var14 = 0; var14 < var3; ++var14) {
                     var13 += var11.readInt();
                     var12[var14] += var13;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for (var13 = 0; var13 < var3; ++var13) {
                  var20[var13] = new byte[var12[var13]];
                  var12[var13] = 0;
               }

               var11.index = var9;
               var13 = 0;

               for (var14 = 0; var14 < var10; ++var14) {
                  int var16 = 0;

                  for (int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.readInt();
                     System.arraycopy(var19, var13, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var13 += var16;
                  }
               }

               for (var14 = 0; var14 < var3; ++var14) {
                  if (!this.shallowFiles) {
                     var5[var4[var14]] = Projectile.byteArrayToObject(var20[var14], false);
                  } else {
                     var5[var4[var14]] = var20[var14];
                  }
               }
            } else if (!this.shallowFiles) {
               var5[var4[0]] = Projectile.byteArrayToObject(var19, false);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-224510300"
   )
   @Export("getGroupId")
   public int getGroupId(String groupName) {
      groupName = groupName.toLowerCase();
      return this.groupNameHashTable.get(Client.hashString(groupName));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-443631072"
   )
   @Export("getFileId")
   public int getFileId(int group, String fileName) {
      fileName = fileName.toLowerCase();
      return this.fileNameHashTables[group].get(Client.hashString(fileName));
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "68"
   )
   public boolean method9(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.groupNameHashTable.get(Client.hashString(var1));
      if (var3 < 0) {
         return false;
      } else {
         int var4 = this.fileNameHashTables[var3].get(Client.hashString(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;S)[B",
      garbageValue = "-22726"
   )
   @Export("takeFileByNames")
   public byte[] takeFileByNames(String groupName, String fileName) {
      groupName = groupName.toLowerCase();
      fileName = fileName.toLowerCase();
      int var3 = this.groupNameHashTable.get(Client.hashString(groupName));
      int var4 = this.fileNameHashTables[var3].get(Client.hashString(fileName));
      return this.takeFile(var3, var4);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "2140743930"
   )
   @Export("tryLoadFileByNames")
   public boolean tryLoadFileByNames(String groupName, String fileName) {
      groupName = groupName.toLowerCase();
      fileName = fileName.toLowerCase();
      int var3 = this.groupNameHashTable.get(Client.hashString(groupName));
      int var4 = this.fileNameHashTables[var3].get(Client.hashString(fileName));
      return this.tryLoadFile(var3, var4);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1282569336"
   )
   @Export("tryLoadGroupByName")
   public boolean tryLoadGroupByName(String groupName) {
      groupName = groupName.toLowerCase();
      int var2 = this.groupNameHashTable.get(Client.hashString(groupName));
      return this.tryLoadGroup(var2);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "40"
   )
   public void method10(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.groupNameHashTable.get(Client.hashString(var1));
      if (var2 >= 0) {
         this.vmethod129(var2);
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1645224643"
   )
   @Export("groupLoadPercentByName")
   public int groupLoadPercentByName(String groupName) {
      groupName = groupName.toLowerCase();
      int var2 = this.groupNameHashTable.get(Client.hashString(groupName));
      return this.groupLoadPercent(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgr;Llh;I)Llh;",
      garbageValue = "15597880"
   )
   @Export("readStringIntParameters")
   static final IterableNodeHashTable readStringIntParameters(Buffer buffer, IterableNodeHashTable hashTable) {
      int var2 = buffer.readUnsignedByte();
      int var3;
      if (hashTable == null) {
         var3 = World.method1759(var2);
         hashTable = new IterableNodeHashTable(var3);
      }

      for (var3 = 0; var3 < var2; ++var3) {
         boolean var4 = buffer.readUnsignedByte() == 1;
         int var5 = buffer.readMedium();
         Object var6;
         if (var4) {
            var6 = new ObjectNode(buffer.readStringCp1252NullTerminated());
         } else {
            var6 = new IntegerNode(buffer.readInt());
         }

         hashTable.put((Node)var6, (long)var5);
      }

      return hashTable;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lby;S)V",
      garbageValue = "-4702"
   )
   @Export("runScript")
   public static void runScript(ScriptEvent scriptEvent) {
      GrandExchangeEvent.runScript0(scriptEvent, 500000);
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "308670894"
   )
   static boolean method4585() {
      if (Client.archiveLoaders != null && Client.archiveLoaderArchive < Client.archiveLoaders.size()) {
         while (Client.archiveLoaderArchive < Client.archiveLoaders.size()) {
            ArchiveLoader var0 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoaderArchive);
            if (!var0.method134()) {
               return false;
            }

            ++Client.archiveLoaderArchive;
         }

         return true;
      } else {
         return true;
      }
   }

   static {
      gzipDecompressor = new GzipDecompressor();
      field1 = 0;
   }
}
