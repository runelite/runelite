import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("items")
   static NodeCache items;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("itemModelCache")
   static NodeCache itemModelCache;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3466;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1087852009
   )
   public static int field3467;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 732678981
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1741443835
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 308190251
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("aa")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1984894439
   )
   @Export("team")
   int team;
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   IterableHashTable field3512;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1500513995
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1373376345
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 113401441
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("av")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("a")
   @Export("name")
   public String name;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -319091259
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -78292025
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1331903553
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -698238643
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1886980343
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("aq")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -822224031
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 267214333
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 974388673
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1668140393
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -44911063
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1188585321
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -355239233
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1866098773
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1689878239
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1599414233
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("am")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1513413159
   )
   @Export("price")
   public int price;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -182622803
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("e")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("l")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 2124270809
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1106182315
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("ag")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("y")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1798519207
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("q")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("bg")
   public boolean field3513;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1422804251
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1759401015
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -2033589971
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1728574947
   )
   @Export("note")
   public int note;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1071240717
   )
   public int field3511;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -2095771757
   )
   public int field3492;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1800548377
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1953215461
   )
   public int field3516;

   static {
      items = new NodeCache(64);
      itemModelCache = new NodeCache(50);
      itemSpriteCache = new NodeCache(200);
   }

   ItemComposition() {
      this.name = "null";
      this.zoom2d = 2000;
      this.xan2d = 0;
      this.yan2d = 0;
      this.zan2d = 0;
      this.offsetX2d = 0;
      this.offsetY2d = 0;
      this.isStackable = 0;
      this.price = 1;
      this.isMembers = false;
      this.groundActions = new String[]{null, null, "Take", null, null};
      this.inventoryActions = new String[]{null, null, null, null, "Drop"};
      this.team = -2;
      this.maleModel = -1;
      this.maleModel1 = -1;
      this.maleOffset = 0;
      this.femaleModel = -1;
      this.femaleModel1 = -1;
      this.femaleOffset = 0;
      this.maleModel2 = -1;
      this.femaleModel2 = -1;
      this.maleHeadModel = -1;
      this.maleHeadModel2 = -1;
      this.femaleHeadModel = -1;
      this.femaleHeadModel2 = -1;
      this.note = -1;
      this.notedTemplate = -1;
      this.resizeX = 128;
      this.resizeY = 128;
      this.resizeZ = 128;
      this.ambient = 0;
      this.contrast = 0;
      this.field3511 = 0;
      this.field3513 = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.field3516 = -1;
      this.field3492 = -1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "840197966"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.inventoryModel = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.zoom2d = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.xan2d = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.yan2d = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.offsetX2d = var1.readUnsignedShort();
         if(this.offsetX2d > 32767) {
            this.offsetX2d -= 65536;
         }
      } else if(var2 == 8) {
         this.offsetY2d = var1.readUnsignedShort();
         if(this.offsetY2d > 32767) {
            this.offsetY2d -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.readInt();
      } else if(var2 == 16) {
         this.isMembers = true;
      } else if(var2 == 23) {
         this.maleModel = var1.readUnsignedShort();
         this.maleOffset = var1.readUnsignedByte();
      } else if(var2 == 24) {
         this.maleModel1 = var1.readUnsignedShort();
      } else if(var2 == 25) {
         this.femaleModel = var1.readUnsignedShort();
         this.femaleOffset = var1.readUnsignedByte();
      } else if(var2 == 26) {
         this.femaleModel1 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.readString();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.readString();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.colourToReplace = new short[var3];
            this.colourToReplaceWith = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.colourToReplace[var4] = (short)var1.readUnsignedShort();
               this.colourToReplaceWith[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.textureToReplace = new short[var3];
            this.textToReplaceWith = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.textureToReplace[var4] = (short)var1.readUnsignedShort();
               this.textToReplaceWith[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 42) {
            this.team = var1.readByte();
         } else if(var2 == 65) {
            this.field3513 = true;
         } else if(var2 == 78) {
            this.maleModel2 = var1.readUnsignedShort();
         } else if(var2 == 79) {
            this.femaleModel2 = var1.readUnsignedShort();
         } else if(var2 == 90) {
            this.maleHeadModel = var1.readUnsignedShort();
         } else if(var2 == 91) {
            this.femaleHeadModel = var1.readUnsignedShort();
         } else if(var2 == 92) {
            this.maleHeadModel2 = var1.readUnsignedShort();
         } else if(var2 == 93) {
            this.femaleHeadModel2 = var1.readUnsignedShort();
         } else if(var2 == 95) {
            this.zan2d = var1.readUnsignedShort();
         } else if(var2 == 97) {
            this.note = var1.readUnsignedShort();
         } else if(var2 == 98) {
            this.notedTemplate = var1.readUnsignedShort();
         } else if(var2 >= 100 && var2 < 110) {
            if(this.countObj == null) {
               this.countObj = new int[10];
               this.countCo = new int[10];
            }

            this.countObj[var2 - 100] = var1.readUnsignedShort();
            this.countCo[var2 - 100] = var1.readUnsignedShort();
         } else if(var2 == 110) {
            this.resizeX = var1.readUnsignedShort();
         } else if(var2 == 111) {
            this.resizeY = var1.readUnsignedShort();
         } else if(var2 == 112) {
            this.resizeZ = var1.readUnsignedShort();
         } else if(var2 == 113) {
            this.ambient = var1.readByte();
         } else if(var2 == 114) {
            this.contrast = var1.readByte() * 5;
         } else if(var2 == 115) {
            this.field3511 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.unnotedId = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.notedId = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3516 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3492 = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3512 = class46.method629(var1, this.field3512);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Leo;",
      garbageValue = "-7"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class10.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2331(field3466, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2349(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2347(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1879 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Ldj;",
      garbageValue = "95"
   )
   public final ModelData method4448(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class10.getItemDefinition(var2).method4448(1);
         }
      }

      ModelData var4 = ModelData.method2331(field3466, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2349(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2347(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1888371577"
   )
   public final boolean method4496(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!field3466.method4010(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field3466.method4010(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "31247362"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZB)Ldj;",
      garbageValue = "-1"
   )
   public final ModelData method4454(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2331(field3466, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2331(field3466, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var5};
            var4 = new ModelData(var6, 2);
         }

         int var7;
         if(this.colourToReplace != null) {
            for(var7 = 0; var7 < this.colourToReplace.length; ++var7) {
               var4.recolor(this.colourToReplace[var7], this.colourToReplaceWith[var7]);
            }
         }

         if(this.textureToReplace != null) {
            for(var7 = 0; var7 < this.textureToReplace.length; ++var7) {
               var4.method2347(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "1877025475"
   )
   @Export("loadBuffer")
   void loadBuffer(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.populateFromBuffer(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "1646000795"
   )
   @Export("readyWorn")
   public final boolean readyWorn(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.maleModel1;
      int var4 = this.maleModel2;
      if(var1) {
         var2 = this.femaleModel;
         var3 = this.femaleModel1;
         var4 = this.femaleModel2;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!field3466.method4010(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field3466.method4010(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field3466.method4010(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZI)Ldj;",
      garbageValue = "74721816"
   )
   @Export("getWornModelData")
   public final ModelData getWornModelData(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.maleModel1;
      int var4 = this.maleModel2;
      if(var1) {
         var2 = this.femaleModel;
         var3 = this.femaleModel1;
         var4 = this.femaleModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method2331(field3466, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2331(field3466, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2331(field3466, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2345(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2345(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2347(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lic;Lic;I)V",
      garbageValue = "1586087386"
   )
   void method4470(ItemComposition var1, ItemComposition var2) {
      this.inventoryModel = var1.inventoryModel;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.colourToReplace = var1.colourToReplace;
      this.colourToReplaceWith = var1.colourToReplaceWith;
      this.textureToReplace = var1.textureToReplace;
      this.textToReplaceWith = var1.textToReplaceWith;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lic;Lic;I)V",
      garbageValue = "-2098290661"
   )
   void method4479(ItemComposition var1, ItemComposition var2) {
      this.inventoryModel = var1.inventoryModel;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.colourToReplace = var2.colourToReplace;
      this.colourToReplaceWith = var2.colourToReplaceWith;
      this.textureToReplace = var2.textureToReplace;
      this.textToReplaceWith = var2.textToReplaceWith;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.isStackable = var2.isStackable;
      this.maleModel = var2.maleModel;
      this.maleModel1 = var2.maleModel1;
      this.maleModel2 = var2.maleModel2;
      this.femaleModel = var2.femaleModel;
      this.femaleModel1 = var2.femaleModel1;
      this.femaleModel2 = var2.femaleModel2;
      this.maleHeadModel = var2.maleHeadModel;
      this.maleHeadModel2 = var2.maleHeadModel2;
      this.femaleHeadModel = var2.femaleHeadModel;
      this.femaleHeadModel2 = var2.femaleHeadModel2;
      this.field3511 = var2.field3511;
      this.groundActions = var2.groundActions;
      this.inventoryActions = new String[5];
      if(var2.inventoryActions != null) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.inventoryActions[var3] = var2.inventoryActions[var3];
         }
      }

      this.inventoryActions[4] = "Discard";
      this.price = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lic;Lic;I)V",
      garbageValue = "-1887451579"
   )
   void method4447(ItemComposition var1, ItemComposition var2) {
      this.inventoryModel = var1.inventoryModel;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.colourToReplace = var1.colourToReplace;
      this.colourToReplaceWith = var1.colourToReplaceWith;
      this.textureToReplace = var1.textureToReplace;
      this.textToReplaceWith = var1.textToReplaceWith;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembers = false;
      this.field3513 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Lic;",
      garbageValue = "-1"
   )
   public ItemComposition method4450(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class10.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-802089717"
   )
   public int method4455(int var1, int var2) {
      return class112.method2023(this.field3512, var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "2145465723"
   )
   public String method4478(int var1, String var2) {
      return class232.method4001(this.field3512, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1905056047"
   )
   public int method4449() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-918831772"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + FaceNormal.method2807(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "2"
   )
   static final void method4505(String var0) {
      if(var0 != null) {
         String var1 = class215.method3908(var0, class22.field331);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = class215.method3908(var4, class22.field331);
               if(ScriptState.method1025(var0, var1, var4, var5)) {
                  --Client.friendCount;

                  for(int var6 = var2; var6 < Client.friendCount; ++var6) {
                     Client.friends[var6] = Client.friends[var6 + 1];
                  }

                  Client.field1142 = Client.cycleCntr;
                  Client.secretPacketBuffer1.putOpcode(26);
                  Client.secretPacketBuffer1.putByte(class15.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
                  break;
               }
            }

         }
      }
   }
}
