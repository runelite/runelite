import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 966645187
   )
   static int field3304;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 480327827
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 179736161
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("x")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("k")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("v")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("m")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("b")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("t")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("p")
   @Export("archiveFileNames")
   int[][] archiveFileNames;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[Lgw;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("l")
   Object[] field3298;
   @ObfuscatedName("u")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1815079407
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("y")
   boolean field3302;
   @ObfuscatedName("j")
   boolean field3303;

   static {
      gzip = new GZipDecompressor();
      field3304 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3302 = var1;
      this.field3303 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1371503191"
   )
   void method4263(byte[] var1) {
      this.crc = ScriptVarType.method30(var1, var1.length);
      Buffer var2 = new Buffer(class1.decodeContainer(var1));
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
         this.field3298 = new Object[var6 + 1];
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1802560355"
   )
   void vmethod4370(int var1) {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1574866651"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "117"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4326(var1, var3);
            if(!var4) {
               this.vmethod4373(var1);
               var4 = this.method4326(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class48.toByteArray(this.childs[var1][var2], false);
         if(this.field3303) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1672516289"
   )
   public boolean method4322(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3298[var1] != null) {
            return true;
         } else {
            this.vmethod4373(var1);
            return this.field3298[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "32"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3298[var1] != null) {
         return true;
      } else {
         this.vmethod4373(var1);
         return this.field3298[var1] != null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-53"
   )
   public boolean method4269() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3298[var3] == null) {
            this.vmethod4373(var3);
            if(this.field3298[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "102"
   )
   int vmethod4378(int var1) {
      return this.field3298[var1] != null?100:0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1297246791"
   )
   public byte[] method4271(int var1) {
      if(this.childs.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1123550401"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4326(var1, (int[])null);
            if(!var3) {
               this.vmethod4373(var1);
               var3 = this.method4326(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class48.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-587239878"
   )
   public byte[] method4273(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "559861157"
   )
   void vmethod4373(int var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1304659427"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2002193256"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "15"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1144713036"
   )
   public void method4278(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1128014674"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "100"
   )
   boolean method4326(int var1, int[] var2) {
      if(this.field3298[var1] == null) {
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
               var18 = class48.toByteArray(this.field3298[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            } else {
               var18 = class48.toByteArray(this.field3298[var1], false);
            }

            byte[] var20 = class1.decodeContainer(var18);
            if(this.field3302) {
               this.field3298[var1] = null;
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
                  if(!this.field3303) {
                     var5[var4[var15]] = class18.method157(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3303) {
               var5[var4[0]] = class18.method157(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-65927587"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class231.djb2Hash(var1));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "1578399359"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class231.djb2Hash(var2));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1124914581"
   )
   public boolean method4283(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class231.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class231.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;S)[B",
      garbageValue = "-21565"
   )
   public byte[] method4284(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class231.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class231.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "705145349"
   )
   public boolean method4285(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class231.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class231.djb2Hash(var2));
      return this.method4322(var3, var4);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-106"
   )
   public boolean method4286(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class231.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "2"
   )
   public void method4287(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class231.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4370(var2);
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1932237290"
   )
   public int method4296(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class231.djb2Hash(var1));
      return this.vmethod4378(var2);
   }
}
