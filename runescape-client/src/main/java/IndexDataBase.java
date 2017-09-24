import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1711028985
   )
   static int field3230;
   @ObfuscatedName("b")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("j")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("d")
   Object[] field3224;
   @ObfuscatedName("l")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("v")
   boolean field3228;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lgq;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("n")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("q")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 457752525
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("c")
   boolean field3225;
   @ObfuscatedName("o")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1830998187
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("a")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("k")
   @Export("archiveFileNames")
   int[][] archiveFileNames;

   static {
      gzip = new GZipDecompressor();
      field3230 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3228 = var1;
      this.field3225 = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[IS)[B",
      garbageValue = "28114"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4150(var1, var3);
            if(!var4) {
               this.vmethod4228(var1);
               var4 = this.method4150(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = CollisionData.toByteArray(this.childs[var1][var2], false);
         if(this.field3225) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-40"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIS)[B",
      garbageValue = "29330"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4150(var1, (int[])null);
            if(!var3) {
               this.vmethod4228(var1);
               var3 = this.method4150(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = CollisionData.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void vmethod4228(int var1) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "0"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "371809644"
   )
   public byte[] method4143(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "56"
   )
   int vmethod4233(int var1) {
      return this.field3224[var1] != null?100:0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-341619082"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1269827268"
   )
   void method4162(byte[] var1) {
      this.crc = PendingSpawn.method1521(var1, var1.length);
      Buffer var2 = new Buffer(AbstractByteBuffer.decodeContainer(var1));
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
         this.field3224 = new Object[var6 + 1];
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1410982767"
   )
   public boolean method4137(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3224[var1] != null) {
            return true;
         } else {
            this.vmethod4228(var1);
            return this.field3224[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-28"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3224[var1] != null) {
         return true;
      } else {
         this.vmethod4228(var1);
         return this.field3224[var1] != null;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "59"
   )
   public boolean method4155(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(Preferences.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(Preferences.djb2Hash(var2));
      return this.method4137(var3, var4);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1165910002"
   )
   void vmethod4238(int var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1183967716"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "167655749"
   )
   public byte[] method4209(int var1) {
      if(this.childs.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1800773537"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(Preferences.djb2Hash(var1));
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "584951307"
   )
   public boolean method4198(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(Preferences.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(Preferences.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "1726257576"
   )
   boolean method4150(int var1, int[] var2) {
      if(this.field3224[var1] == null) {
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
               var18 = CollisionData.toByteArray(this.field3224[var1], false);
            } else {
               var18 = CollisionData.toByteArray(this.field3224[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            }

            byte[] var20 = AbstractByteBuffer.decodeContainer(var18);
            if(this.field3228) {
               this.field3224[var1] = null;
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
                  if(!this.field3225) {
                     var5[var4[var15]] = class43.method646(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3225) {
               var5[var4[0]] = class43.method646(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)I",
      garbageValue = "256"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(Preferences.djb2Hash(var2));
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1947771482"
   )
   public int method4158(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(Preferences.djb2Hash(var1));
      return this.vmethod4233(var2);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "6"
   )
   public byte[] method4154(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(Preferences.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(Preferences.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-16834"
   )
   public boolean method4139() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3224[var3] == null) {
            this.vmethod4228(var3);
            if(this.field3224[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-303896706"
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

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1913418105"
   )
   public boolean method4172(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(Preferences.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "764687181"
   )
   public void method4148(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2144473999"
   )
   public void method4157(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(Preferences.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4238(var2);
      }
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-34"
   )
   static final void method4169(int var0) {
      if(class13.loadWidget(var0)) {
         Widget[] var1 = class268.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2780 = 0;
               var3.field2734 = 0;
            }
         }

      }
   }
}
