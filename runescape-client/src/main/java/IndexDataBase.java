import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("g")
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 825542521
   )
   static int field3229;
   @ObfuscatedName("s")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("j")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("m")
   Object[] field3228;
   @ObfuscatedName("u")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("t")
   boolean field3227;
   @ObfuscatedName("p")
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("r")
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("e")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("l")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1627562057
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("c")
   boolean field3226;
   @ObfuscatedName("v")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2032511915
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("n")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("w")
   @Export("archiveFileNames")
   int[][] archiveFileNames;

   static {
      gzip = new GZipDecompressor();
      field3229 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3227 = var1;
      this.field3226 = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-2005389520"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4096(var1, var3);
            if(!var4) {
               this.vmethod4194(var1);
               var4 = this.method4096(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class152.toByteArray(this.childs[var1][var2], false);
         if(this.field3226) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2129047959"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "746175496"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4096(var1, (int[])null);
            if(!var3) {
               this.vmethod4194(var1);
               var3 = this.method4096(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class152.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-314848895"
   )
   void vmethod4194(int var1) {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "-22"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-666198645"
   )
   public byte[] method4090(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2124731025"
   )
   int vmethod4176(int var1) {
      return this.field3228[var1] != null?100:0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "23"
   )
   void method4080(byte[] var1) {
      this.crc = ItemLayer.method2394(var1, var1.length);
      Buffer var2 = new Buffer(class217.decodeContainer(var1));
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
         this.field3228 = new Object[var6 + 1];
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1733500784"
   )
   public boolean method4085(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3228[var1] != null) {
            return true;
         } else {
            this.vmethod4194(var1);
            return this.field3228[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-92027322"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3228[var1] != null) {
         return true;
      } else {
         this.vmethod4194(var1);
         return this.field3228[var1] != null;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1421383248"
   )
   public boolean method4101(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class208.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class208.djb2Hash(var2));
      return this.method4085(var3, var4);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1537468439"
   )
   void vmethod4193(int var1) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-574632782"
   )
   public byte[] method4088(int var1) {
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
      signature = "(IB)[I",
      garbageValue = "-122"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "92"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class208.djb2Hash(var1));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-119"
   )
   public boolean method4084(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class208.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class208.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "1477010122"
   )
   boolean method4096(int var1, int[] var2) {
      if(this.field3228[var1] == null) {
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
               var18 = class152.toByteArray(this.field3228[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            } else {
               var18 = class152.toByteArray(this.field3228[var1], false);
            }

            byte[] var20 = class217.decodeContainer(var18);
            if(this.field3227) {
               this.field3228[var1] = null;
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
                  if(!this.field3226) {
                     var5[var4[var15]] = class83.method1617(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3226) {
               var5[var4[0]] = class83.method1617(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "-2089866009"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class208.djb2Hash(var2));
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1665008808"
   )
   public int method4112(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class208.djb2Hash(var1));
      return this.vmethod4176(var2);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "-32"
   )
   public byte[] method4116(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class208.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class208.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-2860"
   )
   public boolean method4086() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3228[var3] == null) {
            this.vmethod4194(var3);
            if(this.field3228[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1358665273"
   )
   public boolean method4102(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class208.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1312703058"
   )
   public void method4094(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-208819982"
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

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-766102953"
   )
   public void method4103(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class208.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4193(var2);
      }
   }
}
