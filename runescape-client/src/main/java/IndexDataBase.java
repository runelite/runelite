import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 442496635
   )
   static int field3229;
   @ObfuscatedName("g")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("k")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("y")
   Object[] field3221;
   @ObfuscatedName("o")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("b")
   boolean field3227;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Lgr;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("s")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("r")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -199808843
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("f")
   boolean field3213;
   @ObfuscatedName("q")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -533063505
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("e")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("v")
   @Export("archiveFileNames")
   int[][] archiveFileNames;

   static {
      gzip = new GZipDecompressor();
      field3229 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3227 = var1;
      this.field3213 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "1"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4233(var1, var3);
            if(!var4) {
               this.vmethod4340(var1);
               var4 = this.method4233(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class36.toByteArray(this.childs[var1][var2], false);
         if(this.field3213) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2079179627"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "-85"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4233(var1, (int[])null);
            if(!var3) {
               this.vmethod4340(var1);
               var3 = this.method4233(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class36.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "11"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1778515348"
   )
   void vmethod4340(int var1) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "2006578172"
   )
   public byte[] method4226(int var1) {
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
      signature = "(IS)I",
      garbageValue = "-7359"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "102"
   )
   int vmethod4321(int var1) {
      return this.field3221[var1] != null?100:0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "441375557"
   )
   void method4216(byte[] var1) {
      this.crc = class56.method850(var1, var1.length);
      Buffer var2 = new Buffer(class170.decodeContainer(var1));
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
         this.field3221 = new Object[var6 + 1];
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

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1030785587"
   )
   public boolean method4238(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class35.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class35.djb2Hash(var2));
      return this.method4237(var3, var4);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   void vmethod4315(int var1) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1381502000"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3221[var1] != null) {
         return true;
      } else {
         this.vmethod4340(var1);
         return this.field3221[var1] != null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1182901814"
   )
   public boolean method4237(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3221[var1] != null) {
            return true;
         } else {
            this.vmethod4340(var1);
            return this.field3221[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "0"
   )
   public byte[] method4224(int var1) {
      if(this.childs.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "0"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1367107356"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class35.djb2Hash(var1));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1863068308"
   )
   public boolean method4276(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class35.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class35.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-70000"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class35.djb2Hash(var2));
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "37337424"
   )
   public int method4241(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class35.djb2Hash(var1));
      return this.vmethod4321(var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "504938839"
   )
   boolean method4233(int var1, int[] var2) {
      if(this.field3221[var1] == null) {
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
               var18 = class36.toByteArray(this.field3221[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            } else {
               var18 = class36.toByteArray(this.field3221[var1], false);
            }

            byte[] var20 = class170.decodeContainer(var18);
            if(this.field3227) {
               this.field3221[var1] = null;
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
                  if(!this.field3213) {
                     var5[var4[var15]] = ScriptVarType.method26(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3213) {
               var5[var4[0]] = ScriptVarType.method26(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-382300517"
   )
   public byte[] method4305(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class35.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class35.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2004580760"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1695292216"
   )
   public boolean method4292() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3221[var3] == null) {
            this.vmethod4340(var3);
            if(this.field3221[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1721142876"
   )
   public boolean method4288(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class35.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2077190352"
   )
   public void method4236(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-751151165"
   )
   public void method4268(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class35.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4315(var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1100718165"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class238.field3265 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class238.field3265.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class238.field3265.close();
            } catch (Exception var3) {
               ;
            }

            ++class238.field3271;
            class238.field3265 = null;
         }

      }
   }
}
