import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -844801099
   )
   static int field3201;
   @ObfuscatedName("z")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("n")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("d")
   Object[] field3199;
   @ObfuscatedName("o")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("s")
   boolean field3206;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lgr;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("k")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("v")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1788127655
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("c")
   boolean field3210;
   @ObfuscatedName("w")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -778126447
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("g")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("r")
   @Export("archiveFileNames")
   int[][] archiveFileNames;

   static {
      gzip = new GZipDecompressor();
      field3201 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3206 = var1;
      this.field3210 = var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "-105"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4129(var1, var3);
            if(!var4) {
               this.vmethod4211(var1);
               var4 = this.method4129(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = Tile.toByteArray(this.childs[var1][var2], false);
         if(this.field3210) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "0"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4129(var1, (int[])null);
            if(!var3) {
               this.vmethod4211(var1);
               var3 = this.method4129(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = Tile.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1333197963"
   )
   void vmethod4211(int var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-937957606"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1241889060"
   )
   public byte[] method4145(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1623590145"
   )
   int vmethod4213(int var1) {
      return this.field3199[var1] != null?100:0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-680572954"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-1"
   )
   void method4163(byte[] var1) {
      this.crc = KeyFocusListener.method754(var1, var1.length);
      Buffer var2 = new Buffer(class171.decodeContainer(var1));
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
         this.field3199 = new Object[var6 + 1];
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
      signature = "(IIB)Z",
      garbageValue = "50"
   )
   public boolean method4116(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3199[var1] != null) {
            return true;
         } else {
            this.vmethod4211(var1);
            return this.field3199[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "90"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3199[var1] != null) {
         return true;
      } else {
         this.vmethod4211(var1);
         return this.field3199[var1] != null;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-18"
   )
   public boolean method4134(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class215.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class215.djb2Hash(var2));
      return this.method4116(var3, var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1873316388"
   )
   void vmethod4208(int var1) {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1755030328"
   )
   public byte[] method4120(int var1) {
      if(this.childs.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "803117738"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "81"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class215.djb2Hash(var1));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "61"
   )
   public boolean method4132(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class215.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class215.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "119"
   )
   boolean method4129(int var1, int[] var2) {
      if(this.field3199[var1] == null) {
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
            if(var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
               var18 = Tile.toByteArray(this.field3199[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            } else {
               var18 = Tile.toByteArray(this.field3199[var1], false);
            }

            byte[] var20 = class171.decodeContainer(var18);
            if(this.field3206) {
               this.field3199[var1] = null;
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
                  if(!this.field3210) {
                     var5[var4[var15]] = class89.method1732(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3210) {
               var5[var4[0]] = class89.method1732(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "366826034"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class215.djb2Hash(var2));
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-47466035"
   )
   public int method4137(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class215.djb2Hash(var1));
      return this.vmethod4213(var2);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "89"
   )
   public byte[] method4143(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class215.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class215.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "363153023"
   )
   public boolean method4130() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3199[var3] == null) {
            this.vmethod4211(var3);
            if(this.field3199[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-226307904"
   )
   public boolean method4167(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class215.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1814896677"
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

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1656298745"
   )
   public void method4136(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class215.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4208(var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-308474637"
   )
   public void method4159(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }
}
