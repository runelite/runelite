import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("AbstractIndexCache")
public abstract class AbstractIndexCache {
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
   @Export("__ir_s")
   static int __ir_s;
   @ObfuscatedName("au")
   @Export("garbageCollector")
   static GarbageCollectorMXBean garbageCollector;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 334735939
   )
   @Export("__ir_bu")
   static int __ir_bu;
   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache0")
   static IndexCache indexCache0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1694798923
   )
   @Export("archiveCount")
   int archiveCount;
   @ObfuscatedName("q")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("w")
   @Export("archiveNameHashes")
   int[] archiveNameHashes;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   @Export("archiveNameHashTable")
   IntHashTable archiveNameHashTable;
   @ObfuscatedName("u")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("g")
   @Export("archiveVersions")
   int[] archiveVersions;
   @ObfuscatedName("l")
   @Export("recordCounts")
   int[] recordCounts;
   @ObfuscatedName("e")
   @Export("recordIds")
   int[][] recordIds;
   @ObfuscatedName("x")
   @Export("recordNameHashes")
   int[][] recordNameHashes;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("recordNameHashTables")
   IntHashTable[] recordNameHashTables;
   @ObfuscatedName("k")
   @Export("archives")
   Object[] archives;
   @ObfuscatedName("n")
   @Export("records")
   Object[][] records;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -530370811
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("z")
   @Export("releaseArchives")
   boolean releaseArchives;
   @ObfuscatedName("j")
   @Export("shallowRecords")
   boolean shallowRecords;

   static {
      gzipDecompressor = new GzipDecompressor();
      __ir_s = 0;
   }

   AbstractIndexCache(boolean var1, boolean var2) {
      this.releaseArchives = var1;
      this.shallowRecords = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "0"
   )
   @Export("setIndexReference")
   void setIndexReference(byte[] var1) {
      this.hash = WallDecoration.method3257(var1, var1.length);
      Buffer var2 = new Buffer(Strings.decompressBytes(var1));
      int var3 = var2.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if(var3 >= 7) {
            this.archiveCount = var2.__ad_309();
         } else {
            this.archiveCount = var2.__ag_302();
         }

         int var5 = 0;
         int var6 = -1;
         this.archiveIds = new int[this.archiveCount];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.archiveCount; ++var7) {
               this.archiveIds[var7] = var5 += var2.__ad_309();
               if(this.archiveIds[var7] > var6) {
                  var6 = this.archiveIds[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.archiveCount; ++var7) {
               this.archiveIds[var7] = var5 += var2.__ag_302();
               if(this.archiveIds[var7] > var6) {
                  var6 = this.archiveIds[var7];
               }
            }
         }

         this.archiveCrcs = new int[var6 + 1];
         this.archiveVersions = new int[var6 + 1];
         this.recordCounts = new int[var6 + 1];
         this.recordIds = new int[var6 + 1][];
         this.archives = new Object[var6 + 1];
         this.records = new Object[var6 + 1][];
         if(var4 != 0) {
            this.archiveNameHashes = new int[var6 + 1];

            for(var7 = 0; var7 < this.archiveCount; ++var7) {
               this.archiveNameHashes[this.archiveIds[var7]] = var2.readInt();
            }

            this.archiveNameHashTable = new IntHashTable(this.archiveNameHashes);
         }

         for(var7 = 0; var7 < this.archiveCount; ++var7) {
            this.archiveCrcs[this.archiveIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.archiveCount; ++var7) {
            this.archiveVersions[this.archiveIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.archiveCount; ++var7) {
            this.recordCounts[this.archiveIds[var7]] = var2.__ag_302();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.archiveCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.recordCounts[var8];
               var5 = 0;
               var10 = -1;
               this.recordIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.recordIds[var8][var11] = var5 += var2.__ad_309();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.records[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.archiveCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.recordCounts[var8];
               var5 = 0;
               var10 = -1;
               this.recordIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.recordIds[var8][var11] = var5 += var2.__ag_302();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.records[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.recordNameHashes = new int[var6 + 1][];
            this.recordNameHashTables = new IntHashTable[var6 + 1];

            for(var7 = 0; var7 < this.archiveCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.recordCounts[var8];
               this.recordNameHashes[var8] = new int[this.records[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.recordNameHashes[var8][this.recordIds[var8][var10]] = var2.readInt();
               }

               this.recordNameHashTables[var8] = new IntHashTable(this.recordNameHashes[var8]);
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
   @Export("__f_392")
   void __f_392(int var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1945577069"
   )
   @Export("takeRecord")
   public byte[] takeRecord(int var1, int var2) {
      return this.takeRecordEncrypted(var1, var2, (int[])null);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-1363136655"
   )
   @Export("takeRecordEncrypted")
   public byte[] takeRecordEncrypted(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.records.length && this.records[var1] != null && var2 >= 0 && var2 < this.records[var1].length) {
         if(this.records[var1][var2] == null) {
            boolean var4 = this.buildRecords(var1, var3);
            if(!var4) {
               this.loadArchive(var1);
               var4 = this.buildRecords(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = TextureProvider.byteArrayFromObject(this.records[var1][var2], false);
         if(this.shallowRecords) {
            this.records[var1][var2] = null;
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
   @Export("tryLoadRecord")
   public boolean tryLoadRecord(int var1, int var2) {
      if(var1 >= 0 && var1 < this.records.length && this.records[var1] != null && var2 >= 0 && var2 < this.records[var1].length) {
         if(this.records[var1][var2] != null) {
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1923759754"
   )
   @Export("__u_393")
   public boolean __u_393(int var1) {
      if(this.records.length == 1) {
         return this.tryLoadRecord(0, var1);
      } else if(this.records[var1].length == 1) {
         return this.tryLoadRecord(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-374594123"
   )
   @Export("tryLoadArchive")
   public boolean tryLoadArchive(int var1) {
      if(this.archives[var1] != null) {
         return true;
      } else {
         this.loadArchive(var1);
         return this.archives[var1] != null;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1694975256"
   )
   @Export("__l_394")
   public boolean __l_394() {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1809769865"
   )
   @Export("archiveLoadPercent")
   int archiveLoadPercent(int var1) {
      return this.archives[var1] != null?100:0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)[B",
      garbageValue = "-10015"
   )
   @Export("takeRecordFlat")
   public byte[] takeRecordFlat(int var1) {
      if(this.records.length == 1) {
         return this.takeRecord(0, var1);
      } else if(this.records[var1].length == 1) {
         return this.takeRecord(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-755739011"
   )
   @Export("getRecord")
   public byte[] getRecord(int var1, int var2) {
      if(var1 >= 0 && var1 < this.records.length && this.records[var1] != null && var2 >= 0 && var2 < this.records[var1].length) {
         if(this.records[var1][var2] == null) {
            boolean var3 = this.buildRecords(var1, (int[])null);
            if(!var3) {
               this.loadArchive(var1);
               var3 = this.buildRecords(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = TextureProvider.byteArrayFromObject(this.records[var1][var2], false);
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
   @Export("getRecordFlat")
   public byte[] getRecordFlat(int var1) {
      if(this.records.length == 1) {
         return this.getRecord(0, var1);
      } else if(this.records[var1].length == 1) {
         return this.getRecord(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1829145107"
   )
   @Export("loadArchive")
   void loadArchive(int var1) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "28"
   )
   @Export("__j_395")
   public int[] __j_395(int var1) {
      return var1 >= 0 && var1 < this.recordIds.length?this.recordIds[var1]:null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1178362496"
   )
   @Export("__s_396")
   public int __s_396(int var1) {
      return this.records[var1].length;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1702434573"
   )
   @Export("__t_397")
   public int __t_397() {
      return this.records.length;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   @Export("__y_398")
   public void __y_398() {
      for(int var1 = 0; var1 < this.archives.length; ++var1) {
         this.archives[var1] = null;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "330258899"
   )
   @Export("__h_399")
   public void __h_399(int var1) {
      for(int var2 = 0; var2 < this.records[var1].length; ++var2) {
         this.records[var1][var2] = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-709581639"
   )
   @Export("__b_400")
   public void __b_400() {
      for(int var1 = 0; var1 < this.records.length; ++var1) {
         if(this.records[var1] != null) {
            for(int var2 = 0; var2 < this.records[var1].length; ++var2) {
               this.records[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1835696874"
   )
   @Export("buildRecords")
   boolean buildRecords(int var1, int[] var2) {
      if(this.archives[var1] == null) {
         return false;
      } else {
         int var3 = this.recordCounts[var1];
         int[] var4 = this.recordIds[var1];
         Object[] var5 = this.records[var1];
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
               var18 = TextureProvider.byteArrayFromObject(this.archives[var1], false);
            } else {
               var18 = TextureProvider.byteArrayFromObject(this.archives[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.xteaDecrypt(var2, 5, var8.array.length);
            }

            byte[] var20 = Strings.decompressBytes(var18);
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
               var11.index = var9;

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

               var11.index = var9;
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
                     var5[var4[var15]] = Projectile.byteArrayToObject(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.shallowRecords) {
               var5[var4[0]] = Projectile.byteArrayToObject(var20, false);
            } else {
               var5[var4[0]] = var20;
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
   @Export("getArchiveId")
   public int getArchiveId(String var1) {
      var1 = var1.toLowerCase();
      return this.archiveNameHashTable.get(Client.hashString(var1));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-443631072"
   )
   @Export("getRecordId")
   public int getRecordId(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.recordNameHashTables[var1].get(Client.hashString(var2));
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "68"
   )
   @Export("__ag_401")
   public boolean __ag_401(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.archiveNameHashTable.get(Client.hashString(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.recordNameHashTables[var3].get(Client.hashString(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;S)[B",
      garbageValue = "-22726"
   )
   @Export("takeRecordByNames")
   public byte[] takeRecordByNames(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.archiveNameHashTable.get(Client.hashString(var1));
      int var4 = this.recordNameHashTables[var3].get(Client.hashString(var2));
      return this.takeRecord(var3, var4);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "2140743930"
   )
   @Export("tryLoadRecordByNames")
   public boolean tryLoadRecordByNames(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.archiveNameHashTable.get(Client.hashString(var1));
      int var4 = this.recordNameHashTables[var3].get(Client.hashString(var2));
      return this.tryLoadRecord(var3, var4);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1282569336"
   )
   @Export("tryLoadArchiveByName")
   public boolean tryLoadArchiveByName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.archiveNameHashTable.get(Client.hashString(var1));
      return this.tryLoadArchive(var2);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "40"
   )
   @Export("__ar_402")
   public void __ar_402(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.archiveNameHashTable.get(Client.hashString(var1));
      if(var2 >= 0) {
         this.__f_392(var2);
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1645224643"
   )
   @Export("archiveLoadPercentByName")
   public int archiveLoadPercentByName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.archiveNameHashTable.get(Client.hashString(var1));
      return this.archiveLoadPercent(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgr;Llh;I)Llh;",
      garbageValue = "15597880"
   )
   @Export("readStringIntParameters")
   static final IterableNodeHashTable readStringIntParameters(Buffer var0, IterableNodeHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = World.method1759(var2);
         var1 = new IterableNodeHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.readMedium();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readStringCp1252NullTerminated());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lby;S)V",
      garbageValue = "-4702"
   )
   @Export("runScript")
   public static void runScript(ScriptEvent var0) {
      GrandExchangeEvent.runScript0(var0, 500000);
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "308670894"
   )
   static boolean method4585() {
      if(Client.indexCacheLoaders != null && Client.indexCacheLoaderIndex < Client.indexCacheLoaders.size()) {
         while(Client.indexCacheLoaderIndex < Client.indexCacheLoaders.size()) {
            IndexCacheLoader var0 = (IndexCacheLoader)Client.indexCacheLoaders.get(Client.indexCacheLoaderIndex);
            if(!var0.__m_122()) {
               return false;
            }

            ++Client.indexCacheLoaderIndex;
         }

         return true;
      } else {
         return true;
      }
   }
}
