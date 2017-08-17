import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   @Export("gzip")
   static GZipDecompressor gzip;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1790966165
   )
   static int field3210;
   @ObfuscatedName("l")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("h")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("o")
   Object[] field3211;
   @ObfuscatedName("m")
   @Export("childs")
   Object[][] childs;
   @ObfuscatedName("r")
   boolean field3215;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Lgg;"
   )
   @Export("childIdentifiers")
   Identifiers[] childIdentifiers;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("identifiers")
   Identifiers identifiers;
   @ObfuscatedName("g")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("c")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 393659193
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("e")
   boolean field3216;
   @ObfuscatedName("x")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1450899511
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("f")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("w")
   @Export("archiveFileNames")
   int[][] archiveFileNames;

   static {
      gzip = new GZipDecompressor();
      field3210 = 0;
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3215 = var1;
      this.field3216 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "39"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var4 = this.method4155(var1, var3);
            if(!var4) {
               this.vmethod4223(var1);
               var4 = this.method4155(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class90.toByteArray(this.childs[var1][var2], false);
         if(this.field3216) {
            this.childs[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1461623570"
   )
   @Export("size")
   public int size() {
      return this.childs.length;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "533459618"
   )
   @Export("getChild")
   public byte[] getChild(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] == null) {
            boolean var3 = this.method4155(var1, (int[])null);
            if(!var3) {
               this.vmethod4223(var1);
               var3 = this.method4155(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class90.toByteArray(this.childs[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1542431978"
   )
   void vmethod4223(int var1) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1907068428"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1726926761"
   )
   public byte[] method4121(int var1) {
      if(this.childs.length == 1) {
         return this.getChild(0, var1);
      } else if(this.childs[var1].length == 1) {
         return this.getChild(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "4005"
   )
   int vmethod4229(int var1) {
      return this.field3211[var1] != null?100:0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-559282164"
   )
   @Export("fileCount")
   public int fileCount(int var1) {
      return this.childs[var1].length;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1972869376"
   )
   void method4169(byte[] var1) {
      int var3 = var1.length;
      int var2 = CollisionData.method3074(var1, 0, var3);
      this.crc = var2;
      Buffer var4 = new Buffer(GZipDecompressor.decodeContainer(var1));
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
         this.field3211 = new Object[var8 + 1];
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1457080495"
   )
   public boolean method4115(int var1, int var2) {
      if(var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
         if(this.childs[var1][var2] != null) {
            return true;
         } else if(this.field3211[var1] != null) {
            return true;
         } else {
            this.vmethod4223(var1);
            return this.field3211[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "56"
   )
   @Export("containsFile")
   public boolean containsFile(int var1) {
      if(this.field3211[var1] != null) {
         return true;
      } else {
         this.vmethod4223(var1);
         return this.field3211[var1] != null;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;S)Z",
      garbageValue = "-23468"
   )
   public boolean method4133(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class12.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class12.djb2Hash(var2));
      return this.method4115(var3, var4);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2112050568"
   )
   void vmethod4225(int var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1995963574"
   )
   @Export("getChilds")
   public int[] getChilds(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1887230666"
   )
   public byte[] method4119(int var1) {
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
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1635183872"
   )
   @Export("getFile")
   public int getFile(String var1) {
      var1 = var1.toLowerCase();
      return this.identifiers.getFile(class12.djb2Hash(var1));
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1254365942"
   )
   public boolean method4191(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class12.djb2Hash(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.childIdentifiers[var3].getFile(class12.djb2Hash(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "854124577"
   )
   boolean method4155(int var1, int[] var2) {
      if(this.field3211[var1] == null) {
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
               var18 = class90.toByteArray(this.field3211[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            } else {
               var18 = class90.toByteArray(this.field3211[var1], false);
            }

            byte[] var20 = GZipDecompressor.decodeContainer(var18);
            if(this.field3215) {
               this.field3211[var1] = null;
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
                  if(!this.field3216) {
                     var5[var4[var15]] = class83.method1621(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3216) {
               var5[var4[0]] = class83.method1621(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "935520212"
   )
   @Export("getChild")
   public int getChild(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.childIdentifiers[var1].getFile(class12.djb2Hash(var2));
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-14"
   )
   public int method4136(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class12.djb2Hash(var1));
      return this.vmethod4229(var2);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "1337029366"
   )
   public byte[] method4206(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.identifiers.getFile(class12.djb2Hash(var1));
      int var4 = this.childIdentifiers[var3].getFile(class12.djb2Hash(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "240990289"
   )
   public boolean method4117() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3211[var3] == null) {
            this.vmethod4223(var3);
            if(this.field3211[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-63"
   )
   public boolean method4134(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class12.djb2Hash(var1));
      return this.containsFile(var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1498714309"
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "280"
   )
   public void method4126(int var1) {
      for(int var2 = 0; var2 < this.childs[var1].length; ++var2) {
         this.childs[var1][var2] = null;
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1393099190"
   )
   public void method4135(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.identifiers.getFile(class12.djb2Hash(var1));
      if(var2 >= 0) {
         this.vmethod4225(var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-64"
   )
   static final boolean method4213(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
