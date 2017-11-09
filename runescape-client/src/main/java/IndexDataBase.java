import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1824732555
   )
   static int field3289;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1759791547
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("p")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("i")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("v")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("x")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("e")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("l")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("b")
   @Export("archiveFileNames")
   int[][] archiveFileNames;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lgt;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("c")
   Object[] field3276;
   @ObfuscatedName("a")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 983786297
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("k")
   boolean field3290;
   @ObfuscatedName("t")
   boolean field3291;

   static {
      gzip = new GZipDecompressor();
      field3289 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3290 = var1;
      this.field3291 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1845256395"
   )
   void method4277(byte[] var1) {
      int var3 = var1.length;
      int var5 = -1;

      int var6;
      for(var6 = 0; var6 < var3; ++var6) {
         var5 = var5 >>> 8 ^ Buffer.crc32Table[(var5 ^ var1[var6]) & 255];
      }

      var5 = ~var5;
      this.crc = var5;
      Buffer var15 = new Buffer(DynamicObject.decodeContainer(var1));
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
         this.field3276 = new Object[var8 + 1];
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1176382278"
   )
   void vmethod4400(int var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "652693081"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-1723630841"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4294(var1, var3);
            if(!var4) {
               this.vmethod4386(var1);
               var4 = this.method4294(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class149.toByteArray(this.childs[var1][var2], false);
         if(this.field3291) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "-14113"
   )
   public boolean method4281(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3276[var1] != null) {
            return true;
         } else {
            this.vmethod4386(var1);
            return this.field3276[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-167319142"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3276[var1] != null) {
         return true;
      } else {
         this.vmethod4386(var1);
         return this.field3276[var1] != null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "983390373"
   )
   public boolean method4283() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3276[var3] == null) {
            this.vmethod4386(var3);
            if(this.field3276[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1828486885"
   )
   int vmethod4391(int var1) {
      return this.field3276[var1] != null?100:0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "644731468"
   )
   public byte[] method4375(int var1) {
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
      signature = "(IIB)[B",
      garbageValue = "10"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4294(var1, (int[])null);
            if(!var3) {
               this.vmethod4386(var1);
               var3 = this.method4294(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class149.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "82"
   )
   public byte[] method4287(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void vmethod4386(int var1) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "903231320"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "72"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "17"
   )
   public void method4292(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1951192472"
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "0"
   )
   boolean method4294(int var1, int[] var2) {
      if(this.field3276[var1] == null) {
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
               var18 = class149.toByteArray(this.field3276[var1], false);
            } else {
               var18 = class149.toByteArray(this.field3276[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            }

            byte[] var20 = DynamicObject.decodeContainer(var18);
            if(this.field3290) {
               this.field3276[var1] = null;
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
                  if(!this.field3291) {
                     var5[var4[var15]] = class182.method3517(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3291) {
               var5[var4[0]] = class182.method3517(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-506294355"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class258.djb2Hash(var1));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "-71"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class258.djb2Hash(var2));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "769367063"
   )
   public boolean method4297(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class258.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class258.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "1416800120"
   )
   public byte[] method4308(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class258.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class258.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1894285024"
   )
   public boolean method4295(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class258.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class258.djb2Hash(var2));
      return this.method4281(var3, var4);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1348699687"
   )
   public boolean method4300(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class258.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1703137216"
   )
   public void method4301(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class258.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4400(var2);
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "58"
   )
   public int method4323(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class258.djb2Hash(var1));
      return this.vmethod4391(var2);
   }
}
