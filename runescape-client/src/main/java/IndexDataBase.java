import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -287065423
   )
   static int field3221;
   @ObfuscatedName("j")
   @Export("archiveFileNames")
   int[][] archiveFileNames;
   @ObfuscatedName("k")
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("t")
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("s")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("r")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("v")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("a")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("c")
   boolean field3229;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 784420865
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1818639637
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("o")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("z")
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("y")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("e")
   Object[] field3235;
   @ObfuscatedName("m")
   boolean field3236;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1586973609
   )
   static int field3237;
   @ObfuscatedName("cm")
   public static char field3238;
   @ObfuscatedName("w")
   @Export("archiveIds")
   int[] archiveIds;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1842353899"
   )
   public boolean method4111() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3235[var3] == null) {
            this.vmethod4217(var3);
            if(this.field3235[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "97"
   )
   void method4112(byte[] var1) {
      int var2 = var1.length;
      int var3 = class27.method208(var1, 0, var2);
      this.crc = var3;
      Buffer var4 = new Buffer(class162.decodeContainer(var1));
      int var5 = var4.readUnsignedByte();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.readInt();
         }

         int var6 = var4.readUnsignedByte();
         if(var5 >= 7) {
            this.validArchivesCount = var4.getLargeSmart();
         } else {
            this.validArchivesCount = var4.readUnsignedShort();
         }

         int var7 = 0;
         int var8 = -1;
         this.archiveIds = new int[this.validArchivesCount];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveIds[var9] = var7 += var4.getLargeSmart();
               if(this.archiveIds[var9] > var8) {
                  var8 = this.archiveIds[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveIds[var9] = var7 += var4.readUnsignedShort();
               if(this.archiveIds[var9] > var8) {
                  var8 = this.archiveIds[var9];
               }
            }
         }

         this.archiveCrcs = new int[var8 + 1];
         this.archiveRevisions = new int[var8 + 1];
         this.archiveNumberOfFiles = new int[var8 + 1];
         this.archiveFileIds = new int[var8 + 1][];
         this.field3235 = new Object[var8 + 1];
         this.childs = new Object[var8 + 1][];
         if(var6 != 0) {
            this.archiveNames = new int[var8 + 1];

            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveNames[this.archiveIds[var9]] = var4.readInt();
            }

            this.identifiers = new Identifiers(this.archiveNames);
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveCrcs[this.archiveIds[var9]] = var4.readInt();
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveRevisions[this.archiveIds[var9]] = var4.readInt();
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveNumberOfFiles[this.archiveIds[var9]] = var4.readUnsignedShort();
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
                  var14 = this.archiveFileIds[var10][var13] = var7 += var4.getLargeSmart();
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
                  var14 = this.archiveFileIds[var10][var13] = var7 += var4.readUnsignedShort();
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
                  this.archiveFileNames[var10][this.archiveFileIds[var10][var12]] = var4.readInt();
               }

               this.childIdentifiers[var10] = new Identifiers(this.archiveFileNames[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1800419410"
   )
   void vmethod4243(int var1) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "98"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-1195813551"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4129(var1, var3);
            if(!var4) {
               this.vmethod4217(var1);
               var4 = this.method4129(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = ScriptEvent.toByteArray(this.childs[var1][var2], false);
         if(this.field3236) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "173080625"
   )
   public boolean method4116(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3235[var1] != null) {
            return true;
         } else {
            this.vmethod4217(var1);
            return this.field3235[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1850334098"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3235[var1] != null) {
         return true;
      } else {
         this.vmethod4217(var1);
         return this.field3235[var1] != null;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "727269048"
   )
   public int method4118(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class60.djb2Hash(var1));
      return this.vmethod4226(var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-106443138"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-551342685"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-576103713"
   )
   public byte[] method4122(int var1) {
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
      signature = "(II)V",
      garbageValue = "160969676"
   )
   public void method4127(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "-87"
   )
   boolean method4129(int var1, int[] var2) {
      if(this.field3235[var1] == null) {
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
               var18 = ScriptEvent.toByteArray(this.field3235[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            } else {
               var18 = ScriptEvent.toByteArray(this.field3235[var1], false);
            }

            byte[] var19 = class162.decodeContainer(var18);
            if(this.field3229) {
               this.field3235[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= var10 * var3 * 4;
               Buffer var11 = new Buffer(var19);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var13;
               int var14;
               for(int var15 = 0; var15 < var10; ++var15) {
                  var13 = 0;

                  for(var14 = 0; var14 < var3; ++var14) {
                     var13 += var11.readInt();
                     var12[var14] += var13;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var13 = 0; var13 < var3; ++var13) {
                  var20[var13] = new byte[var12[var13]];
                  var12[var13] = 0;
               }

               var11.offset = var9;
               var13 = 0;

               for(var14 = 0; var14 < var10; ++var14) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.readInt();
                     System.arraycopy(var19, var13, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var13 += var16;
                  }
               }

               for(var14 = 0; var14 < var3; ++var14) {
                  if(!this.field3236) {
                     var5[var4[var14]] = FrameMap.method2665(var20[var14], false);
                  } else {
                     var5[var4[var14]] = var20[var14];
                  }
               }
            } else if(!this.field3236) {
               var5[var4[0]] = FrameMap.method2665(var19, false);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "-48"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class60.djb2Hash(var2));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2141591179"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-104"
   )
   public boolean method4134(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class60.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class60.djb2Hash(var2));
      return this.method4116(var3, var4);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1924270987"
   )
   public boolean method4135(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class60.djb2Hash(var1));
      return this.containsFile(var2);
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3229 = var1;
      this.field3236 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1120779352"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "21209"
   )
   public void method4143(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class60.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4243(var2);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "-80"
   )
   public byte[] method4145(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class60.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class60.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "24496090"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class60.djb2Hash(var1));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "375185060"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "388386437"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4129(var1, (int[])null);
            if(!var3) {
               this.vmethod4217(var1);
               var3 = this.method4129(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = ScriptEvent.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1276506450"
   )
   public boolean method4190(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class60.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class60.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "2"
   )
   void vmethod4217(int var1) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-400480797"
   )
   int vmethod4226(int var1) {
      return this.field3235[var1] != null?100:0;
   }

   static {
      gzip = new GZipDecompressor();
      field3237 = 0;
   }
}
